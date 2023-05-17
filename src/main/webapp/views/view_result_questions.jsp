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
<title>View Result Questions</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<section class="get-in-touch"
			style="width: 80%; box-shadow: 0px 1px 1px #ccc">
			<h1 class="title">Exam Portal</h1>

			<c:forEach items="${questionList}" var="examQuestion">
				<input type="hidden" name="examId" value="${examid.getExamName()}">
				<input type="hidden" name="Id" value="${examid. getEid()}">
				<input type="hidden" name="marks" value="${examid.maxMarks}">
				<div class="py-5 col">
					<div class="container">
						<div class="row hidden-md-up">
							<div class="col-md-12 mb-3">
								<div class=""
									style="border-color: #5543ca; border-style: solid; border-width: 2px; box-shadow: 3px 6px 5px #ccc;">
									<div class="card-block">

										<h5 class="card-title">${examQuestion.question}</h5>
										<input type="hidden" name="questionId"
											value="${examQuestion.quesid}">
										<c:forEach items="${answerList}" var="choice1">
											<c:forEach items="${choice1}" var="choice">
												<c:if test="${choice.question.quesid==examQuestion.quesid}">
													<div class="form-field col-lg-12">
														<c:forEach items="${userAnsId}" var="id">
															<c:if test="${choice.aId==id.answerId}">
																<div style="display: inline-flex; font-weight: bold;">
																	<input type="radio"
																		name="answer_${examQuestion.quesid}" checked="checked"
																		value="${id.answerId}"><b>${choice.option}</b>
																	<p style="margin-left: 10px;">(selectedByUser)</p>
																	<br>
																</div>
																<br>
															</c:if>
														</c:forEach>
														<input type="radio" id="answer" name="answer">${choice.option}<br>
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
	<br>

</body>
</html>