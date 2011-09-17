<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<title>http://wbotelhos.com.br</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/autenticar" method="post">
			E-mail: <input type="text" name="usuario.email"/><br/>
			Senha: <input type="password" name="usuario.senha"/><br/><br/>
			<input type="submit" value="Acessar"/>
		</form>
	</body>
</html>