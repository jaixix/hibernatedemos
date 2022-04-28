<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import="java.util.*, entity.SubjectEntity" language="java" contentType="text/html; charset=ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects Display</title>
<style>
	body{
		text-align:center;
		align-items:middle;
	}
	.center {
  		margin-left: auto;
  		margin-right: auto;
	}	
</style>
</head>
<body>
	<h2>Subjects List</h2>
	<table border="1" class="center">
		<tr>
			<th>Subject Name</th>
			<th>Grade Points</th>
		</tr>
		<c:forEach var="subject" items="${subjects}">
			<tr>
				<td>${subject.name}</td>
				<td>${subject.gradePoints}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href='index.html'>Home Page</a>
</body>
</html>