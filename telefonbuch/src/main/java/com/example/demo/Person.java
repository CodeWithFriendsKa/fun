package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	private String name;
	private String vorname;
	private String telefonnummer;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((telefonnummer == null) ? 0 : telefonnummer.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (telefonnummer == null) {
			if (other.telefonnummer != null)
				return false;
		} else if (!telefonnummer.equals(other.telefonnummer))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", vorname=" + vorname + ", telefonnummer=" + telefonnummer + "]";
	}
	public Person(String name, String vorname, String telefonnummer) {
		this.name = name;
		this.vorname = vorname;
		this.telefonnummer = telefonnummer;
	}
	public Person() {

	}
	
	
	
	
	
}
