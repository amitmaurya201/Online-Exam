<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Category Details</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body>

	<%@ include file="header.jsp"%>
	<div class="main-div">
		<a class="btn btn-primary float-right mb-4 mt-4" href="category">Add
			Category</a>
		<div class="row">
			<div class=col>
				<table class="table border-sty">
					<thead>
						<tr>
							<th scope="col">S.No</th>
							<th scope="col">Category Name</th>
							<th scope="col">Created On</th>
								<th scope="col">Created By</th>
							<th scope="col">Delete Category</th>
						</tr>
					</thead>
					<c:set var="exam" value='${requestScope["list"]}'></c:set>
					<c:if test="${exam!=null }">
						<c:forEach items="${exam}" var="exam1">
							<tbody>
								<tr>
									<td class="col-3">${exam1.cid}</td>
									<td class="col-3">${exam1.title}</td>
									<td class="col-3">${exam1.createOn}</td>
									<td class="col-3">${exam1.createdby}</td>
									<td class="col-3"><a href="deletecategory?categoryId=${exam1.cid}"
											class="btn btn-danger"
											>Delete</a> 
											<br><br>
											<a
										href="edit_category?categoryId=${exam1.cid}"
										class="btn btn-info"> Edit</a></td>

								</tr>

							</tbody>
						</c:forEach>
					</c:if>
				</table>
			</div>
		</div>
		<%-- 	<jsp:include page="footer.jsp"></jsp:include> --%>
<!-- <script type="text/javascript">
var delete = "${param.Not-Deleted}"
if(delete =="deleted"){
	
swal("Good job!", "This Id ", "success");
}
</script> -->
</div>
<%@ include file="footer.jsp"%>
</body>
</html>





