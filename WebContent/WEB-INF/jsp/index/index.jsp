<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<title>http://wbotelhos.com.br</title>
	</head>
	<body>
		Ol&aacute;, ${userSession.user.nome} <a href="${pageContext.request.contextPath}/logout">Logout</a>
	</body>
</html>