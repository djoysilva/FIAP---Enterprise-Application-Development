<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<tag:template title="Lista de Pratos">
	<h1>Lista de Pratos</h1>
	<table border="1px">
		<tr>
		 	<th>Nome</th>
		 	<th>Pre�o</th>
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
</tag:template>