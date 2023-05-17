
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
<title>Add Form</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid">
		<section class="get-in-touch">
			<h1 class="title">Select Questions</h1>
			<form:form id="selctC" action="add_question_create_exam"
				method="post" class="contact-form row">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<label class="input-group-text" for="inputGroupSelect01">Category</label>
					</div>
					<select name="category" class="custom-select"
						onchange="myFunction()" id="mySelect">
						<option value="category" selected></option>
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.cid}">${category.title}</option>
						</c:forEach>
					</select>
				</div>
			</form:form>
			<form:form action="exam_add_question" method="post"
				class="contact-form row">
				<c:forEach items="${questionList}" var="question">
					<div class="form-check">
						<input type="checkbox" name="isCheck" value="true"
							class="form-check-input" id="exampleCheck1">
					</div>

					<div class="form-field col-lg-12">
						<input name="questionId" value="${question.quesid}"
							class="input-text js-input" type="hidden"> <input
							id="message" name="question" class="input-text js-input"
							value="${question.question}" type="text" required> <input
							name="category" value="${question.category.title}"
							style="border-width: 0px">
					</div>

				</c:forEach>
				<div class="form-field col-lg-12">
					<button type="submit" class="submit-btn">Submit</button>
				</div>
			</form:form>
			<sec:csrfInput />

		</section>
	</div>



	<!-- Modal -->
	<div class="modal fade" id="exampleModalLong" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<section>
							<h1 class="title">Add Question</h1>
							<form:form action="saveQuestion" method="post"
								class="contact-form row">

								<div class="form-field col-lg-12">
									<input id="message" name="examName" class="input-text js-input"
										type="text" required> <label class="label"
										for="message">Exam Name</label>
								</div>
								<div class="form-field col-lg-12">
									<input id="message" name="examName" class="input-text js-input"
										type="text" required> <label class="label"
										for="message">Exam Description</label>
								</div>
								<div class="form-field col-lg-12">
									<input id="message" name="examName" class="input-text js-input"
										type="text" required> <label class="label"
										for="message"> Max Marks</label>
								</div>
								<div class="form-field col-lg-12">
									<a href="exam_add_question" class="submit-btn">Add Question</a>
								</div>
								<sec:csrfInput />
							</form:form>
						</section>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script>
		function myFunction() {
			var x = document.getElementById("mySelect").value;
			alert(x);
			document.getElementById("selctC").submit();
		}
	</script>
	<script>
		function examquestion() {

		}
	</script>

</body>
</html>