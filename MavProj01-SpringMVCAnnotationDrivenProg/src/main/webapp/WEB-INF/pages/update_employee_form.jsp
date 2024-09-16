<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	type="text/javascript"></script>
<title>Update Employee Form</title>
</head>
<body>
	<div class="container-fluid">
		<div class = "mb-3">
			<h1 class="display-6 bg-danger text-white p-2 mt-2 text-center border rounded">Employee Update Form</h1>
		</div>
		<frm:form modelAttribute="emp">
			<div class="mb-3">
				<label for="empno" class="form-label">Employee No. :</label> 
				<div class = "mb-2">
					<frm:input type="number" class="form-control" id="empno"   path="empNo" readonly="true"/>
				</div>
			</div>
			<div class="mb-3">
				<label for="ename" class="form-label">Employee Name :</label> 
				<div class = "mb-2">
					<frm:input type="text" class="form-control" id="ename"   path="eName"/>
				</div>
			</div>
			<div class="mb-3">
				<label for="job" class="form-label">Employee Job :</label> 
				<div class = "mb-2">
					<frm:input type="text" class="form-control" id="job"   path="job"/>
				</div>
			</div>
			<div class="mb-3">
				<label for="sal" class="form-label">Employee Salary :</label> 
				<div class = "mb-2">
					<frm:input type="number" class="form-control" id="sal"   path="salary"/>
				</div>
			</div>
			<div class="mb-3">
				<label for="deptno" class="form-label">Employee Dept No. :</label> 
				<div class = "mb-2">
					<frm:input type="number" class="form-control" id="deptno"   path="deptNo"/>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</frm:form>
	</div>
</body>
</html>