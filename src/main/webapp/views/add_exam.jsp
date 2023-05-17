
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
	<%-- <%@include file="side_bar.jsp" %> --%>
	<%@include file="header.jsp"%>
	<div class="body-color">
		<div class="container-fluid">
			<section class="get-in-touch" style="width: 70%">
				<h1 class="title">Create Exam</h1>
				<form:form action="save_exam" method="post" class="contact-form row" modelAttribute="examModel">
					<div class="form-field col-lg-12">
						<a class="submit-btn" href="exam_add_question">Add Question</a>
						<!-- <a class="submit-btn" data-toggle="modal" data-target="#exampleModalLong" >Add Question</a> -->
					</div>

					<div class="form-field col-lg-12">
						<input id="examName" name="examName" class="input-text js-input"
							type="text" >
							 <label class="label" for="message">Exam
							Name</label>
					</div>
					<div class="form-field col-lg-12">
						<input id="description" name="description" class="input-text js-input"
							type="text" > 
							
							<label class="label" for="message">Exam
							Description</label>
					</div>
					<div class="form-field col-lg-12">
						<input id="maxMarks" name="maxMarks" class="input-text js-input"
							type="text" >
							
							 <label class="label" for="message">
							Max Marks</label>
					</div>


					<!-- *******table********** -->

					<div class="main-div">
						<table class="table border-sty"
							style="border-color: #5543ca; border-style: solid; border-width: 2px; box-shadow: 1px 1px 1px #ccc;">
							<thead>
								<tr>
									<th scope="col">S.NO</th>
									<th scope="col">Question</th>
									<!-- <th scope="col">Category</th> -->
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${questionList}" var="question">
									<tr>
										<td></td>
										<td scope="row" class="col-lg-12"><input type="hidden"
											name="questionId" value="${question.quesid}"> <input
											id="message" name="question" class="input-text js-input"
											value="${question.question}" type="text"
											style="font-size: 14px" required></td>

									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>


					<div class="form-field col-lg-12">
						<button type="submit" class="submit-btn">Submit</button>
					</div>


					<%--     <sec:csrfInput/> --%>
				</form:form>
			</section>
		</div>


		<!-- Modal -->
		<div class="modal fade" id="exampleModalLong" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalLongTitle"
			aria-hidden="true">
			<div class="modal-dialog" role="document" style="max-width: 800px">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Select
							Question</h5>

					</div>
					<div class="modal-body">
						<div class="container-fluid">
							<section>
								<h1 class="title"></h1>
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
									<c:forEach items="${questionList}" var="question">
										<div class="form-check">
											<input type="checkbox" value="true" class="form-check-input"
												id="exampleCheck1">
										</div>
										<div class="form-field col-lg-12">
											<input name="questionId" class="input-text js-input"
												type="text" hidden> <input id="message"
												name="question" class="input-text js-input" type="text"
												required> <label class="label" for="message">${question.question}</label>
										</div>
									</c:forEach>
									<!-- <div class="form-field col-lg-12">
									 <input class="submit-btn" type="submit" value="submit"/>
								</div> -->
									<%--     <sec:csrfInput/> --%>
								</form:form>
							</section>
						</div>
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
</body>
</html>






