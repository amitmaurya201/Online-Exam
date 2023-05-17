<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<jsp:include page="user_navbar.jsp"></jsp:include>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class=row>

<div class="py-5 col">
    <div class="container">
      <div class="row hidden-md-up" >
        <div class="col-md-12 mb-3">
          <div class="card">
            <div class="card-block">
              <h4 class="card-title">Instruction</h4>
              <p>1.No talking during all exams.</p>
               <p>2.Remove all other electronic devices from the testing area/room during all exams.</p>
                <p>3.Do not use any copy, cut, or paste function with your mouse, keyboard, voice command, or device.</p>
                 <p>4.Reconnect to the Internet and log back into Bright space.</p>
                  <p>5.Follow your original instructions to access the exam login page.</p>
                   <p>6.Students must not stop the session and then return to it.</p>
          
          	 <a href="startexam"  class="btn btn-primary">Start Exam</a>
          	
            </div>
          </div>
        </div>
        </div>
        </div>
        </div>
        <!-- ********* are you sure popup********** -->
<div class="modal fade" id="areYouSureModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Confirm</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      are you sure you want to start...
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
       <a href="view_exam_page" class="btn btn-primary">Yes</a>
      </div>
      </div>
     
      
    </div>
  </div>
</div>
        


</body>
</html>