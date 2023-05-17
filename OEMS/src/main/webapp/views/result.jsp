<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="user_navbar.jsp"></jsp:include>

<title>Result Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<style type="text/css">
h1 {
	width: 500px;
	margin: 0 auto;
	text-align: center;
}
</style>
</head>
<body>
<body background="/static/img/studentsexam.jpg">

	<div class="container">
		<div class="card text-center">
			<div class="card-header">Your Score</div>
			<div class="card-body">
				<h5 class="card-title">Score : ${score} Marks</h5>
				<h5 class="card-title">Result Id : ${idlist}</h5>

				<p class="card-text">Learning never exhausts the mind.</p>


				<a href="download-result/${idlist}" class="btn btn-primary">Download
					Result</a> <br> <br> <a href="logout" class="btn btn-primary">Logout</a>
			</div>
			<div class="card-footer text-muted">Adjecti Solutions Pvt. Ltd.
			</div>
		</div>
	</div>
</body>
</html>