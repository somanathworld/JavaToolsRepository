<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Page</title>
</head>
<body>
	<frm:form action="register" method="post" modelAttribute="empFrm">
		<div align="center">
			<div>
				<label for="fname">First Name : </label>
				<div>
					<!-- 					<input name="fname" id="fname" type="text" />
 -->
					<frm:input path="fname" id="fname" type="text" />
				</div>
			</div>
			<div>
				<label for="lname">Last Name : </label>
				<div>
					<!-- 					<input name="lname" id="lname" type="text" />
 -->
					<frm:input path="lname" id="lname" type="text" />
				</div>
			</div>
			<div>
				<label for="job">Job : </label>
				<div>
					<!-- 					<input name="job" id="job" type="text" />
 -->
					<frm:input path="job" id="job" type="text" />
				</div>
			</div>
			<div>
				<label for="salary">Salary : </label>
				<div>
					<!-- 					<input name="salary" id="salary" type="text" />
 -->
					<frm:input path="salary" id="salary" type="text" />

				</div>
			</div>
			<div>
				<button type="submit">Register</button>
				<button type="reset">Reset</button>
			</div>
		</div>
	</frm:form>
</body>
</html>