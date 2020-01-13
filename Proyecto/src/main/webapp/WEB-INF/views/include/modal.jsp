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
		<form action="/save"  method="POST">
			<div>
				<label>Name</label><br> <input type="text" name="name"  id="name"/>
			</div>
			<div>
				<label>Age</label><br> <input type="text" name="age">
			</div>
			<div>
				<label>Email</label><br> <input type="email" name="email">
			</div>
			<div>
				<label>Phone</label><br> <input type="text" name="phone">
			</div>	
			<br>		
			<input style="margin-left: 100px" type="submit" onclick="agregar()" value="Save"/>
		</form>
	</div>
	<script type="text/javascript" src="/js/util.js"></script>
</body>
</html>