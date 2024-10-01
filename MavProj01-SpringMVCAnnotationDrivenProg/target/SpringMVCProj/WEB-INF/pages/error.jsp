<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	type="text/javascript"></script>
<meta charset="ISO-8859-1">
<title>Error Page - "${errCode}"</title>
</head>
<body>
	<div class="container p-3 my-3 bg-danger text-white">
		<h1 style="text-align: center">Error Page - ${errCode}</h1>
	</div>
	<div class="container p-3 my-3 border">
		<p class = "fw-bolder">Internal Problem: <span class = "text-danger">Try after some time</span></p>
		<p class = "fw-bolder">Error MSg: <span class = "text-danger">${errorMsg}</span></p>
		<p class = "fw-bolder">Time: <span class = "text-danger">${ldt}</span></p>		
		<a href="./" class = "text-decoration-none text-primary">home</a>
	</div>
</body>
</html>