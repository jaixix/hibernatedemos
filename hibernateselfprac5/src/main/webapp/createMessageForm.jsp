<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Message</title>
</head>
<body>
	<h2>Create A Message!</h2>
	<form action="createMessageServlet" method="post">
		Enter Message Text : <br>
		<input type="text" name="text">
		<br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>