<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Exam Questions</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="header.jsp"%>

	<table class="table border-sty">
		<thead>
			<tr>
				<th scope="col">Question</th>
				<th scope="col">Category</th>
				
				<!--   <th scope="col">Created By</th> -->



			</tr>
		</thead>
		<tbody>
			<c:forEach items="${questionList}" var="question">
				<tr>
					<td scope="row"><a
						href="edit_question?questionId=${question.quesid}">${question.question}</a>
					</td>
					<td>${question.category.title}</td>

			
				



				</tr>
			</c:forEach>

		</tbody>
	</table>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>