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
<jsp:include page="user_navbar.jsp"></jsp:include>
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>


<body class="row" onLoad="getCookie();">

<script type="text/javascript">
	function getCookie() {
		var count = 60;
		var interval = setInterval(function() {
			/* setTime(); */
			document.getElementById('hms').innerHTML = count;
			count--;
			if (count === -1) {
				clearInterval(interval);
				  document.getElementById('logout').click();
			}
		}, 1000);

	}
</script>
<a id="logout" href="logout"></a>
<div style="display: inline-flex; font-size: 2vw; margin-left: 40%;">Time :
<div id="hms" class="vertical-center"></div>
</div>
<!--  	<button type="button" onclick='getCookie()' style="float: right;">Start Exam</button> -->

<form:form action="submit" method="post">	
	<div class="container-fluid">
		<section class="get-in-touch"
			style="width: 80%; box-shadow: 0px 1px 1px #ccc">
			<h1 class="title">Exam Portal</h1>
			
				<c:forEach items="${questionList}" var="examQuestion">
				<input type="hidden" name="examId" value="${examid.examName}">
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
											<input type="hidden" name="questionId" value="${examQuestion.quesid}">
											<input type="hidden" name="question" value="${examQuestion.question}">
											<c:forEach items="${examQuestion.answer}" var="choice">
												<%--  <c:forEach items="${choice1}"  var="choice"> --%>
													<%-- <c:if
														test="${choice.question.quesid==examQuestion.quesid}"> --%>
														<div class="form-field col-lg-12">
															<%-- <input id="message" name="examName"
																value="${choice.option}" class="input-text js-input"
																type="text" required> --%>
                                                       <input type="radio" name="answer_${examQuestion.quesid}" value="${choice.aid }">${choice.option}<br> 
                                                        <%--   <input type="radio" name="isCheck" value="true">${choice.option}<br> --%>
                                                     
														</div>
												<%-- 	</c:if> --%>
													
											<%-- 	</c:forEach> --%>
												

 	
											</c:forEach>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
		</section>
	</div><br>
<div class="container"align="center">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div><br><br>
<div class="container"align="center">
					<button type="reset" class="btn btn-primary">Reset</button>
				</div>

</form:form>

</body>
</html>