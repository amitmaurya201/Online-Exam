
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="<c:url value="/static/css/common.css" />" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="<c:url value="/static/js/logout.js" />"></script>

<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;1,400&display=swap"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

<header>
	<div class="main-div ">
		<div class="logo-col">
			<span>O</span>nline <span>E</span>xam
		</div>
		<nav class="header-style">

			<ul>
				<li><a href="home">Home</a></li>

				<li><a href="view_add_question">Question</a></li>


				<li><a href="view_category">Category</a></li>
				<li><a href="view-exam-result">View Result</a></li>
				<li><a href="view_exam">Exam</a></li>
			


				<sec:authorize access="authenticated" var="authenticated" />

				<c:choose>
					<c:when test="${authenticated}">
						<li>
							<p class="navbar-text">
								welcome
								<sec:authentication property="name" />
								<a id="logout" href="logout">Logout</a>
							</p>
							<form id="logout-form" action="<c:url value="/logout"/>"
								method="post">
								<sec:csrfInput />

							</form>
						</li>
					</c:when>
					<c:otherwise>
						<li><a href="<spring:url value="/login"/>">Login</a></li>
					</c:otherwise>

				</c:choose>
				<!-- <li><a href="logout">Logout</a></li> -->
			</ul>
		</nav>
	</div>
</header>
