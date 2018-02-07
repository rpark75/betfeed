<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="odds" method="get">
    <input type="text" name="url" placeholder="Url cible" />
    <input type="submit" value="Envoi"/>
</form>

<form action="test" method="get">
	<input type="submit" value="Test">
</form>
</body>
</html>
