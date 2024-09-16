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
</head>
<body>
	<div class="container-fluid">
		<div class="mb-3">
			<h1
				class="display-6 bg-danger text-white p-2 mt-2 text-center border rounded">All Employee
				Details</h1>
		</div>
		<div id = "rsltDiv">
			<c:if test="${result ne null}">
				<marquee id="rslt">${result}</marquee>
			</c:if>
		</div>
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
							<th colspan="2" class="text-center">Operations</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dto" items="${listDTO}">
							<tr class="text-center">
								<td>${dto.serialNo}</td>
								<td>${dto.empNo}</td>
								<td>${dto.eName}</td>
								<td>${dto.job}</td>
								<td>${dto.salary}</td>
								<td>${dto.grossSalary}</td>
								<td>${dto.netSalary}</td>
								<td>${dto.deptNo}</td>
								<td><a href='udpate_emp?no=${dto.empNo}'
									class="btn btn-outline-warning text-decoration-none"> <i
										class="bi bi-pencil-square"></i> Update
								</a></td>
								<td><a href='delete_emp?no=${dto.empNo}'
									class="btn btn-outline-danger text-decoration-none" onclick="confirm('are you want to delete?')"> <i
										class="bi bi-trash3-fill"></i> Delete
								</a></td>
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
<script>
	let rslt = document.getElementById("rslt");
	if(rslt !== null){
	let blinking = setInterval(()=>rslt.style.opacity= (rslt.style.opacity==0 ? 1 : 0), 1000);
	setTimeout(() => {
		clearInterval(blinking);
		rsltDiv.style.display="none";
	}, 10000);
	}
</script>
</html>