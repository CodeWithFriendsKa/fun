<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	
	</head>
	<body>
		<h1>Login</h1>
		<p>
		<p>
        <form method="POST" onsubmit = "validateForm(event)">
            <table>
                <tr>
                    <td>
                        Username:
                    </td>
                    <td>
                        <input name="username" type="text" value="${username}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Passwort:
                    </td>
                    <td>
                        <input name="password" type="text" value="${password}" />
                    </td>
                </tr>                
            </table>
            <input id="btn" type="submit" value="Login"/>
        </form>
            <div id="error">${error} </div>
	</body>
</html>
