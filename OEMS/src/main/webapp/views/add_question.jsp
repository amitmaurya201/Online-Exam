
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
<title>Add Question</title>

</head>
<body>
<%@include file="header.jsp" %>
<div class="container-fluid">
<section class="get-in-touch">
   <h1 class="title">Add Question</h1>
  <form:form action="save-question" modelAttribute="questionModel" method="post"  enctype="multipart/form-data" class="contact-form row">
 
  <form:select path="category.cid" class="custom-select" id="inputGroupSelect01">
    <c:forEach items="${categoryDTOList}" var="category">
    <form:option value="${category.cid }">${category.title}</form:option>
   </c:forEach>
  </form:select>

      <div class="form-field col-lg-12">
        	<input id="question" name="question" class="input-text js-input"
						type="text">
         					<form:errors path="question" cssClass="error"></form:errors>
         
       
         <label class="label" for="message">Question</label>  
      </div>
      
       <div class="form-field col-lg-12">
         <input class="submit-btn" type="submit" value="submit"/>
        </div>   
   </form:form>
</section>
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