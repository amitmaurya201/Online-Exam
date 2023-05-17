<%@page import="java.util.List"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    

<!DOCTYPE html>
<html> 
<head>
<meta charset="ISO-8859-1">
<title>ViewExam</title>
</head>
<body>

<%@ include file="header.jsp"%></div>
<div class="main-div">
	<a class="btn btn-primary float-right mb-4 mt-5" href="add_question">Add
			Question</a><br><br>
				<a class="btn btn-primary float-Left mb-4 mt-1" href="upload-questions">Download
			Question File</a>
				
<form:form method="post" action="upload-excel"
		enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" class="btn btn-primary value="Submit" />
	</form:form>
			</a></div>
<table class="table border-sty">
  <thead>
    <tr>
    <th scope="col">Question</th>
      <th scope="col">Category</th>
       <th scope="col">Add Option</th>
      <th scope="col">Created On</th>
    <!--   <th scope="col">Created By</th> -->
   
      <th scope="col">Delete/Edit</th>
     <!--   <th scope="col">Upload File</th> -->
         
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${questionList}" var="question">
    <tr>
      <td scope="row">
      <a href="edit_question?questionId=${question.quesid}" >${question.question}</a> </td>
  <td>${question.getCategory().getTitle()}</td>
      <td> <a href="add_option?questionId=${question.quesid}" > Add Option</a></td>  
          <td>${question.createon}</td>
           <%--  <td>${question.createdby}</td> --%>   
      <td><a href="delete_question?questionId=${question.quesid}"  class="btn btn-danger"   > Delete</a>
      <a href="edit_question?questionId=${question.quesid}"  class="btn btn-info"> Edit</a>
     <%--  <a href="getFileById32?photoId=${photoId}"  class="btn btn-info"> Download</a> --%>      
      </td>       
    </tr>
    </c:forEach>   
  </tbody> 
</table>	

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Delete Exam</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      </div>
    <!--   <form action="delete_question" method="post" id="deleteId"> -->
        <form action="delete_question" model="${questionList}" method="post" id="deleteId">
              Id:  <input name="id" value="${question.quesid }" >
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary ">Delete </button>
         <button type="submit" class="btn btn-primary ">Add Option </button>
      </div>
     <%--   <sec:csrfInput/> --%>
      </form>
      
    </div>
  </div>
</div>

</div>
<%@ include file="footer.jsp"%>


  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>      

<script>
function examId(examId){
	document.getElementById("deleteId").id.value=;
	$("#exampleModal").model("show");
}

</script>



</body>
</html>







