<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="main-div">
     <table class="table border-sty">
	<thead>
		<tr>
			<th>UserId</th>
			
			</thead>
		
		<c:set var="userList" value='${requestScope["userIdList"]}'></c:set>
		<c:if test="${userList!=null }">
			<c:forEach items="${userList}" var="user">
				<tr>
					<td><a href="getUserExamDetail?userId=${user}">${user}</a></td>
				
				</tr>
			</c:forEach>
		</c:if>
	</table>
</div>
</body>
</html>