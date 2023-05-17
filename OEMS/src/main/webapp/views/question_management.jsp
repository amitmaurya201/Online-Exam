<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Management</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

</head>
<body>



	<table class="table border-sty">
		<thead>
			<tr>
				<th scope="col">S.No</th>
				<th scope="col">Question</th>


				<th scope="col">Add Option</th>
				<th scope="col">Created On</th>
				<th scope="col">Delete Question</th>



			</tr>
		</thead>
		<tbody>
			<c:forEach items="${questionList}" var="question">
				<tr>
					<td>${question.quesid}</td>
					<td scope="row"><a
						href="edit_question?questionId=${question.quesid}">${question.question}</a>
					</td>
					<%-- <td>${question.category.title}</td> --%>

					<td><a href="add_option?questionId=${question.quesid}">Add
							Option </a></td>
					<td>${question.createOn}</td>
					<%-- 	<td>${question.createdby}</td> --%>
					<td><a href="delete_question?questionId=${question.quesid}"
						class="btn btn-dander">Delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>