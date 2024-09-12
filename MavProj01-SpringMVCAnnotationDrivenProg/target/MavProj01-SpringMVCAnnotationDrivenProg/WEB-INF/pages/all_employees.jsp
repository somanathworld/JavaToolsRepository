<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>All employees</title>
<script type="text/javascript">
	function updateClicked() {
		fetch("/",{
			method: "GET"
		}).then(response => response.json())
		.then(data=>console.log(data))
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<c:choose>
			<c:when test="${listDTO ne null && !empty listDTO}">
				<table
					class="table table-dark table-hover table-responsive caption-top">
					<caption>List of Employees</caption>
					<thead>
						<tr>
							<th>Serial No.</th>
							<th>Employee ID</th>
							<th>Employee Name</th>
							<th>Designation</th>
							<th>Salary</th>
							<th>Gross Salary</th>
							<th>Net Salary</th>
							<th>Department No.</th>
							<th colspan="2" class = "text-center">Operations</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dto" items="${listDTO}">
							<tr class = "text-center">
								<td>${dto.serialNo}</td>
								<td>${dto.empNo}</td>
								<td>${dto.eName}</td>
								<td>${dto.job}</td>
								<td>${dto.salary}</td>
								<td>${dto.grossSalary}</td>
								<td>${dto.netSalary}</td>
								<td>${dto.deptNo}</td>
								<td>
									<button class="btn btn-warning" onclick="updateClicked()">
										<i class="bi bi-pencil-square"></i> Update
									</button>
								</td>
								<td><button class="btn btn-danger" onclick="deleteClicked()">
										<i class="bi bi-trash3-fill"></i> Delete
									</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h1 style="color: red">No Records found</h1>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>