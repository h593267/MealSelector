<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="main.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>MealSelector: Input confirmed</title>
</head>
<body>
	<div class="topnav">
		<a href="index">Home</a> <a href="viewmeal">Random meal</a> <a href="database">Database</a> <a class="active" href="inputmeal">Input Meal</a>
	</div>
	<div class="bg-image"></div>
	
	<div class="bg-text">
		<p>${confirmedmeal} has been successfully added to the database!</p>
		
		<form action="viewmeal" method="post">
			<input name="viewpage" class="p1" type="submit" value="View page" />
			<input type="hidden" name="ID" value="${ID}">
		</form>
	</div>
	
	<br>
	
</body>
</html>