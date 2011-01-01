<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>http://wbotelhos.com.br</title>
	</head>
	<body>
		<form action="<c:url value='/login'/>" method="post">
			E-mail: <input type="text" name="usuario.email"/><br/>
			Senha: <input type="password" name="usuario.senha"/><br/><br/>
			<input type="submit" value="Acessar"/>
		</form>
	</body>
</html>