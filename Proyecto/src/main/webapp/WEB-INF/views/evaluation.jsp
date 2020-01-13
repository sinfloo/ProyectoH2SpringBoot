<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-left: 60px; margin-top: 30px;">
		<h3>Evaluacion Tecnica</h3>
		<p>
			Usuario : <strong><span>${name}</span></strong>
		</p>
		<div>
			<form action="/buscar" method="POST">
				<input type="text" name="name"> <input type="email"
					name="email"> <input type="submit" value="Buscar">
			</form>
			<div>
				<a onclick="nuevo()" href="#">Agreagar Nuevo</a> <br>
				<table border="1">
					<thead>
						<tr>
							<th>#</th>
							<th>Nombres</th>
							<th>Año</th>
							<th>Edad</th>
							<th>Email</th>
							<th>Phone</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="data" items="${users}">
							<tr>
								<td>${data.id}</td>
								<td>${data.name}</td>
								<td>${data.yaerNac()}</td>
								<td>${data.age}</td>
								<td>${data.email}</td>
								<td>${data.phone}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/util.js"></script>
</body>
</html>