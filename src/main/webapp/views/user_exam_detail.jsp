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
<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid">
		<section class="get-in-touch"
			style="width: 80%; box-shadow: 0px 1px 1px #ccc">
			<h1 class="title">User Exam Form</h1>

			<c:forEach items="${questionList}" var="examQuestion" varStatus="i">
				<%--  <c:forEach items="${userExamDetail}" var="userExamDetail" >  --%>
				<div class="py-5 col">
					<div class="container">
						<div class="row hidden-md-up">
							<div class="col-md-12 mb-3">
								<div class="card"
									style="background-color: #e490e51f; border-color: #5543ca; border-style: solid; border-width: 2px; box-shadow: 3px 6px 5px #ccc;">
									<div class="card-block">
										<h5 class="card-title">${examQuestion.question}</h5>

										<c:forEach items="${examQuestion.answer}" var="choice">
											<c:choose>
											<c:when test="${choice.optcheck}">
											<div class="form-field col-lg-12">
														<input type="radio" name="answer${i.index+1}"
															checked="checked">${choice.option}<br>
													</div>
											</c:when>
											<c:otherwise>
											<div class="form-field col-lg-12">
														<input type="radio" name="answer${i.index+1}"
															>${choice.option}<br>
													</div>
											</c:otherwise>
										</c:choose>
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