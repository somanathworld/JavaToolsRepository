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
<script src = "js/validation.js" type="text/javascript"></script>
<title>Employee Registration Page</title>
</head>
<body>
	<div class="container-fluid">
		<div class="mb-3">
			<h1
				class="display-6 bg-danger text-white p-2 mt-2 text-center border rounded">Employee
				Registration Form</h1>
		</div>
		<frm:form modelAttribute="emp" enctype="multipart/form-data" onsubmit="return validate(this)">

			<div class="mb-3">
				<label for="empno" class="form-label">Employee No. :</label>
				<div class="mb-2">
					<frm:input type="number" class="form-control" id="empno"
						path="empNo" readonly="true" />
				</div>
			</div>

			<div class="mb-3">
				<label for="ename" class="form-label">Employee Name :</label>
				<div class="mb-2">
					<frm:input type="text" class="form-control" id="ename" path="eName" />
					<frm:errors path="eName"
						cssClass="text-danger d-block fst-italic fw-bolder" />
					<span id = "enameId"class = "text-danger d-block fst-italic fw-bolder"></span>
				</div>
			</div>

			<div class="mb-3">
				<label for="job" class="form-label">Employee Job :</label>
				<div class="mb-2">
					<frm:input type="text" class="form-control" id="job" path="job" />
					<frm:errors path="job"
						cssClass="text-danger d-block fst-italic fw-bolder" />
					<span id = "jobId"class = "text-danger d-block fst-italic fw-bolder"></span>
				</div>
			</div>

			<div class="mb-3">
				<label for="sal" class="form-label">Employee Salary :</label>
				<div class="mb-2">
					<frm:input type="number" class="form-control" id="sal"
						path="salary" />

					<frm:errors path="salary"
						cssClass="text-danger d-block fst-italic fw-bolder" />
						
					<span id = "salId"class = "text-danger d-block fst-italic fw-bolder"></span>

				</div>
			</div>

			<div class="mb-3">
				<label for="deptno" class="form-label">Employee Dept No. :</label>
				<div class="mb-2">
					<frm:input type="number" class="form-control" id="deptno"
						path="deptNo" />
					<frm:errors path="deptNo"
						cssClass="text-danger d-block fst-italic fw-bolder" />
				</div>
			</div>

			<div class="mb-3">
				<label for="addrs" class="form-label">Employee Address :</label>
				<div class="mb-2">
					<frm:input type="text" class="form-control" id="addrs" path="addrs" />
					<frm:errors path="addrs"
						cssClass="text-danger d-block fst-italic fw-bolder" />
				</div>
			</div>

			<div class="mb-3">
				<label for="mobNo" class="form-label">Employee Mobile No. :</label>
				<div class="mb-2">
					<frm:input type="tel" class="form-control" id="mobNo" path="mobNo" />
					<frm:errors path="mobNo"
						cssClass="text-danger d-block fst-italic fw-bolder" />
				</div>
			</div>

			<div class="mb-3">
				<label for="gender" class="form-label">Employee Gender :</label>
				<div class="mb-2">
					<c:forEach var="gender" items="${genderList}">
						<div class="form-check">
							<frm:radiobutton class="form-check-input"
								id="flexSwitchCheckDefault" path="gender" value="${gender}" />
							<label class="form-check-label" for="flexSwitchCheckDefault">${gender}</label>
						</div>
					</c:forEach>
					<frm:errors path="gender"
						cssClass="text-danger d-block fst-italic fw-bolder" />
				</div>
			</div>


			<div class="mb-3">
				<label for="hobbies" class="form-label">Employee Hobbies :</label>
				<div class="mb-2">
					<c:forEach var="hobby" items="${hobbiesList}">
						<div class="form-check form-switch">
							<frm:checkbox class="form-check-input"
								id="flexSwitchCheckDefault" path="hobbies" value="${hobby}" />
							<label class="form-check-label" for="flexSwitchCheckDefault">${hobby}</label>
						</div>
					</c:forEach>
					<frm:errors path="hobbies"
						cssClass="text-danger d-block fst-italic fw-bolder" />
				</div>
			</div>

			<div class="mb-3">
				<label for="qualification" class="form-label">Employee
					Qualification :</label>
				<div class="mb-2">
					<frm:select class="form-select" id="qualification"
						path="qualification" multiple="1">
						<frm:options items="${qualificationList}" />
					</frm:select>
					<frm:errors path="qualification"
						cssClass="text-danger d-block fst-italic fw-bolder" />
				</div>
			</div>

			<div class="mb-3">
				<label for="dob" class="form-label">Employee DOB(dd-mm-yyyy)
					:</label>
				<div class="mb-2">
					<frm:input type="date" class="form-control" id="dob" path="dob" />
					<frm:errors path="dob"
						cssClass="text-danger d-block fst-italic fw-bolder" />
				</div>
			</div>

			<div class="mb-3">
				<label for="doj" class="form-label">Employee DOJ(dd-mm-yyyy)
					:</label>
				<div class="mb-2">
					<frm:input type="date" class="form-control" id="doj" path="doj" />
					<frm:errors path="doj"
						cssClass="text-danger d-block fst-italic fw-bolder" />
				</div>
			</div>

			<div class="mb-3">
				<label for="resumeFile" class="form-label"> Resume :</label>
				<frm:input class="form-control" type="file" id="resumeFile"
					path="resume" />
				<frm:errors path="resume"
					cssClass="text-danger d-block fst-italic fw-bolder" />
			</div>

			<div class="mb-3">
				<label for="photoFile" class="form-label">Photo : </label>
				<frm:input class="form-control" type="file" id="photoFile"
					path="photo" />
				<frm:errors path="photo"
					cssClass="text-danger d-block fst-italic fw-bolder" />

			</div>

			<button type="submit" class="btn btn-primary">Submit</button>

		</frm:form>
	</div>
</body>
</html>