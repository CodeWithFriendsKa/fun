<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
	<head>
	</head>
	
	<body>
		<h1>TELEFONBUCH</h1>
		<p>
        <nav>
            <a href="<c:url value = "./create"/>">Neuen Kontakt anlegen</a>
        </nav>
		<p>
		<p>
		<h2>Einträge</h2>
        <ul>
            <c:forEach items="${personen}" var="person">
                <li>
                    <b>Name: </b> ${person.name} <br> 
                    <b>Vorname: </b> ${person.vorname} <br> 
                    <b>Telefonnummer: </b> ${person.telefonnummer} <br><p>
                </li>
            </c:forEach>
        </ul>
        <div id="error">${error} </div>
	</body>
</html>