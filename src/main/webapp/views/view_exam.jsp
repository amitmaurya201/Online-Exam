<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Exam</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="main-div">
	
		<a class="btn btn-primary float-right mb-4 mt-4" href="create-exam">Add
			Exam</a>
		
		<table class="table border-sty">
			<thead>
				<tr>
					<th>Exam Id</th>
					<th>Exam Name</th>
					<th>Exam Description</th>
					<th>Max Marks</th>
					<th>View Question</th>
					<th>Delete Question</th>
			</thead>
			</tr>
			<c:set var="exam" value='${requestScope["examList"]}'></c:set>
			<c:if test="${exam!=null }">
				<c:forEach items="${exam}" var="exam1">

					<tr>

						<td>${exam1.eid}</td>
						<td><a href='edit_exam?examId=${exam1.eid}'
							class="stretched-link">${exam1.examName}</a></td>
						<td>${exam1.description}</td>
						<td>${exam1.maxMarks}</td>
						<td><a href='view-exam-questions?empId=${exam1.eid}'
							class="stretched-link">View Questions</a></td>
						<td><button type="button" class="btn btn-primary"
								data-toggle="modal" data-target="#data"
								onclick="modal(${exam1.eid});">Delete Exam</button></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="data">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Are You Sure</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Are You Sure</div>
				<form:form action="delete-exam" method="post" id="delete-data">
      PinCode:<input name="id">
					<div class="modal-footer">
						<button type="submit" class="btn btn-secondary">Yes</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	</div>



	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js">
		   
	</script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js">
		
	</script>
	<script>

function modal(empId) {
	
document.getElementById("delete-data").id.value=empId;
$("#data").modal("show");		
}
</script>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>