<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>http://wbotelhos.wordpress.com</title>
	</head>
	<body>
		Olá, ${sessionUser.usuario.nome} <a href="<c:url value='/logout'/>">Logout</a>
	</body>
</html>