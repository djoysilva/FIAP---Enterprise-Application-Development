<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Pratos</title>
</head>
<body>
	<h1>Lista de Pratos</h1>
	<table border="1px">
		<tr>
		 	<th>Nome</th>
		 	<th>Preço</th>
		 	<th>Peso</th>
		</tr>
		<c:forEach items="${lista}" var="p">
			<tr>
				<td>${p.nome}</td>
				<td>${p.preco}</td>
				<td>${p.peso}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>