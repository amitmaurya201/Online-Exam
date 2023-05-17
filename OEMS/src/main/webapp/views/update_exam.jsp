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
<title>Update Exam</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="body-color">
		<div class="container-fluid">
			<section class="get-in-touch" style="width: 70%">
				<h1 class="title">Create Exam</h1>
				<form:form action="update_exam" modelAttribute="ExamUpdate"
					method="post" class="contact-form row">
					<div class="form-field col-lg-12">
						<a class="submit-btn" href="exam_add_question">Add
							Question</a>
						<!-- <a class="submit-btn" data-toggle="modal" data-target="#exampleModalLong" >Add Question</a> -->
					</div>
					<input id="questionId" name="eid" value="${ ExamUpdate.eid}" type="hidden" >
					<div class="form-field col-lg-12">
						<input id="message" name="examName" value="${ExamUpdate.examName}"
							class="input-text js-input" type="text" required> <label
							class="label" for="message">Exam Name</label>
					</div>
					<div class="form-field col-lg-12">
						<input id="message" name="description"
							value="${ExamUpdate.description}" class="input-text js-input"
							type="text" required> <label class="label" for="message">Exam
							Description</label>
					</div>
					<div class="form-field col-lg-12">
						<input id="message" name="maxMarks" value="${ExamUpdate.maxMarks}"
							class="input-text js-input" type="text" required> <label
							class="label" for="message"> Max Marks</label>
					</div>




					<div class="form-field col-lg-12">
						<button type="submit" class="submit-btn">Submit</button>
					</div>


					<%--     <sec:csrfInput/> --%>
				</form:form>
</body>
</html>