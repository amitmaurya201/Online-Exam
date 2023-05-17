<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
<jsp:include page="user_navbar.jsp"></jsp:include>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<body background="/static/img/studentsexam.jpg">
<script type="text/javascript">
function preventBack() {
    window.history.forward(); 
}
  
setTimeout("preventBack()", 0);
  
window.onunload = function () { null };
</script>

	<div class="container">
		<div class="card text-center">
			<c:forEach var="entry" items="${examList}">
				<div class="card-header">Welcome To Adjecti Solutions</div>
				<div class="card-body">
					<h5 class="card-title">Exam Name : ${entry.examName}</h5>
					<p class="card-text">Exam Description : ${entry.description}</p>
					<p class="card-text">MaxMarks : ${entry.maxMarks}</p>
					<%-- 	<p class="card-text">No Of Questions : ${entry.noOfQuestion}</p> --%>
					<a href="startexam?examId=${entry.eid}" class="btn btn-primary">Start
						Exam</a>

				</div>
			</c:forEach>
			<div class="card-footer text-muted"></div>
		</div>
	</div>

</body>
</html>