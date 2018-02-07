<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultats</title>
</head>
<body>

	<h1>Page de r�sultats.</h1>

	<div>R�sultats : <br/>
		<c:forEach items="${successList}" var="success">
		${success}<br/>
		</c:forEach>
	</div>
	
	<div>Pr�visions : <br/>
		<c:forEach items="${oddsList}" var="odds">
		${odds}<br/>
		</c:forEach>
	</div>
	
	<div>Ratios : <br/>
		<c:forEach items="${ratiosList}" var="ratio">
		${ratio}<br/>
		</c:forEach>
	</div>
	
	<form action="commitOdd" method="get">
		<div>Envoyer les r�sultats en base.</div>
		<input type="text" name="url" placeholder="Url cible" />
		<input type="text" name="date" placeholder="Date des resultats" />
    	<input type="submit" value="Envoi"/>
	</form>

</body>
</html>