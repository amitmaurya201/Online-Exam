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
		<section class="get-in-touch">
			<h1 class="title">Add Category</h1>
			<form:form action="addcategory" modelAttribute="category"
				method="post" class="contact-form row">
				<div class="form-field col-lg-12">
					<input id="title" name="title" class="input-text js-input"
						type="text">
					<form:errors path="title" cssClass="error"></form:errors>
					<label class="label" for="title">Category</label>
				</div>

				<div class="form-field col-lg-12">
					<input class="submit-btn" type="submit" value="submit" />
				</div>
			</form:form>
		</section>
	</div>
	
</body>
</html>