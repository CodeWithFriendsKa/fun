package com.example.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TelefonbuchController {
	
	@Autowired
	private TelefonbuchService service;
	
	//GET the create Page
	@RequestMapping("/create")
	public void getCreatePagee(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException   {
		if(service.userAuthentification(request.getSession())) {
			request.setAttribute("personen", service.getAllPersons());
			request.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(request, response);
		}
		else response.sendRedirect("/");
	}
	//POST a Person on the create Page
	@RequestMapping(method=RequestMethod.POST, value="/create")
	public void postCreate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		if(service.userAuthentification(request.getSession())) {
			Person p = new Person(request.getParameter("name"), request.getParameter("vorname"), request.getParameter("telefonnummer"));
			if(p.getName().equals("") || p.getVorname().equals("") || p.getTelefonnummer().equals("")) {
				request.setAttribute("error", "Bitte Alle Felder eintragen!");
			}
			else {
				service.createPerson(p);
			}
			request.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(request, response);
		}
		else response.sendRedirect("/");

	}
	//GET the "Telefonbuch"
	@RequestMapping("/telefonbuch")
	public void getTelefonbuchPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(service.userAuthentification(request.getSession())) {
			request.setAttribute("personen", service.getAllPersons());
			request.getRequestDispatcher("/WEB-INF/jsp/telefonbuch.jsp").forward(request, response);
		}
		else response.sendRedirect("/");
	}
	//Get the Login Page
	@RequestMapping("/")
	public void getLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
	}
	//POST your logincredentials to the Login Page
	@RequestMapping(method=RequestMethod.POST, value="/")
	public void postLoginPage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		User user = new User(request.getParameter("username"), request.getParameter("password"), System.currentTimeMillis());
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		if(service.userAuthentification(session)) {
			response.sendRedirect("/telefonbuch");
		}
		else {
			request.setAttribute("error", "Falscher Username oder falsches Passwort");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}
	
	//DEV
	@RequestMapping("/dev1")
	public void dev1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service.createUser(new User("Tamino", "123"));
		service.createPerson(new Person("Baumeister", "Bob", "123"));
		service.createPerson(new Person("Duck", "Dagobert", "456"));
		service.createPerson(new Person("Mustermann", "Max", "789"));
	}
	@RequestMapping("/dev2")
	public void dev2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service.deleteAll();
	}
}
