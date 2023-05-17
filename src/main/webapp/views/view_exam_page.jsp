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
<title>Insert title here</title>
</head>
<body class="row">
	<%@include file="header.jsp"%>
	<div class="container-fluid">
		<section class="get-in-touch"
			style="width: 80%; box-shadow: 0px 1px 1px #ccc">
			<h1 class="title">Exam Portal</h1>
			<form class="contact-form row">

				<div class="form-field col-lg-12">
					<input id="message" name="examName" value="${exam.examName}"
						class="input-text js-input" type="text" required>

				</div>
				<div class="form-field col-lg-12">
					<input id="message" name="examDesc" value="${exam.description}"
						class="input-text js-input" type="text" required>
				</div>
				<div class="form-field col-lg-12">
					<input id="message" name="maxMarks" value="${exam.maxMarks }"
						class="input-text js-input" type="text" required>
				</div>
				<c:forEach items="${questionList}" var="examQuestion">
					<div class="py-5 col">
						<div class="container">
							<div class="row hidden-md-up">
								<div class="col-md-12 mb-3">
									<div class="card"
										style="background-color: #e490e51f; border-color: #5543ca; border-style: solid; border-width: 2px; box-shadow: 3px 6px 5px #ccc;">
										<div class="card-block">
											<h5 class="card-title">${examQuestion.question}</h5>
											<c:forEach items="${optionList}" var="choice1">
												<c:forEach items="${choice1}" var="choice">
													<c:if test="${choice.question.quesid==examQuestion.quesid}">
														<div class="form-field col-lg-12">
															<input id="message" name="examName"
																value="${choice.optionString}"
																class="input-text js-input" type="text" required>

														</div>
													</c:if>
												</c:forEach>

											</c:forEach>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
		</section>
	</div>

	</form>

</body>
</html>