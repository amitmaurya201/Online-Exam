<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<%-- <jsp:include page="admin_navbar.jsp"></jsp:include> --%>
<title>View Results</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="main-div">
		<a class="btn btn-primary float-right mb-4 mt-4"
			href="download-result">Download Results</a>
			
		<table class="table border-sty">

			<thead>
				<tr>
					<th>Result Id</th>

					<th>Submitted By</th>
					<th>Total Marks</th>

					<th>Submitted On</th>
					<th>Exam Name</th>


				</tr>
			</thead>
			<c:set var="exam" value='${requestScope["resultList"]}'></c:set>
			<c:if test="${exam!=null }">
				<c:forEach items="${exam}" var="exam1">

					<tr>

						<td>${exam1.rid}</td>
						<%-- <td>${exam1.userName}</td> --%>
						<td><a href="view_users_exam?examId=${exam1.examid}">${exam1.userName}</a></td>
						<td>${exam1.score}/${exam1.maxMarks}</td>
						<td>${exam1.createon}</td>
						<td>${exam1.examname}</td>
						<%--                     <td><a href="download-result?aid=${exam1.rid}">Download Result</a></td>
 --%>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>