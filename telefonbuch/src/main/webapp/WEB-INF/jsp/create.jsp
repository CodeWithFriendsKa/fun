<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	<!-- 		
	<script>
		let validateForm = event => {
			let form = event.target;
            let error = document.getElementById("error");
            let name = form.name.value;
            let vorname = form.vorname.value;
            let telefonnummer = form.telefonnummer.value;  
            if(name == "" || vorname==""|| telefonnummer==""){
                error.textContent = "Bitte füllen Sie alle Felder aus!";	
    		    event.preventDefault();
            }

		}	
	</script> 
	-->
	</head>
	<body>
		<h1>TELEFONBUCH</h1>
		<p>
        <nav>
            <a href="<c:url value = "./telefonbuch"/>">Zurück zum Telefonbuch</a>
        </nav>
		<p>
		<p>
		<h2>Einen neuen Kontakt anlegen</h2>	
        <form method="POST" onsubmit = "validateForm(event)">
            <table>
                <tr>
                    <td>
                        Name:
                    </td>
                    <td>
                        <input name="name" type="text" value="${name}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Vorname:
                    </td>
                    <td>
                        <input name="vorname" type="text" value="${vorname}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Telefonnummer:
                    </td>
                    <td>
                        <input name="telefonnummer" type="text" value="${telefonnummer}" />
                    </td>
                </tr>                
            </table>
            <input id="btn" type="submit" value="Kontakt speichern"/>
        </form>
            <div id="error">${error} </div>
	</body>
</html>
