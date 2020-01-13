<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>Evaluacion Tecnica</h3>
		<div>
			<form action="/start">
				<input type="text" name="name" placeholder="Ingrese Nombre" /> <input
					type="submit" value="Enviar" />
			</form>
			<label>Fecha:${fecha}</label>
		</div>
	</div>

</body>
</html>