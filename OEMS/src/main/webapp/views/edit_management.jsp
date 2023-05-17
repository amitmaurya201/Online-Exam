
<%-- <%@page import="com.adjecti.oexam.model.Question"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Form</title>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<section class="get-in-touch" style="width: 60%; box-shadow: 0px 1px 1px #ccc">
			<h1 class="title">Edit Question</h1>
			<form:form action="update_question" method="post"
				modelAttribute="choice" class="contact-form row">
				
				<div class="form-field col-lg-12">
					<input  id="questionId" name="questionId"  value="${ question.quesid}" hidden>
						<input id="message" name="question"
						value="${question.question}" class="input-text js-input"
						type="text" required>
				</div>
				<c:forEach items="${optionList}" var="ch" varStatus="status">
					<%-- <div class="row">

						<div class="col-lg-12">
							<div id="inputFormRow">
								<div class="input-group mb-3">
									<div class="input-group mb-3">
										 <input type="hidden" name="choiceId"  value="${ch.aid}" class="form-check-input" id="exampleCheck1" ><br> 
										<input type="text" id="choice1" name="choice"
											value="${ch.option}" class="form-control m-input"
											placeholder="Enter option" autocomplete="off"></input>
										 <form:input type="text" id="count" path="counter" value="1" class="form-control m-input" placeholder="Enter option" autocomplete="off" hidden> </form:input>
                    
									</div>
								</div>
							</div>
						</div>
					</div> --%>
							
							
<div class="form-check">
<c:choose>
<c:when test="${ch.iscorrect}">

 	<input type="checkbox" name="ischeck" value="true"
									class="form-check-input" id="exampleCheck1" checked> 
   <input type="hidden" name="aid"  value="${ch.aid}" class="form-check-input" id="exampleCheck1" ><br> 
										<input type="text" id="choice1" name="option"
											value="${ch.option}" class="form-control m-input"
											placeholder="Enter option" autocomplete="off"></input>
											</c:when>
											<c:otherwise>
											<input type="checkbox" name="ischeck" value="true"
									class="form-check-input" id="exampleCheck1" > 
   <input type="hidden" name="aid"  value="${ch.aid}" class="form-check-input" id="exampleCheck1" ><br> 
										<input type="text" id="choice1" name="option"
											value="${ch.option}" class="form-control m-input"
											placeholder="Enter option" autocomplete="off"></input>
											</c:otherwise>
											
											</c:choose>
    
 </div>
				
																	
								
				</c:forEach>

				<div class="form-field col-lg-12">
					<button data-toggle="modal" data-target="#exampleModal"
						class="submit-btn" type="submit">Edit Question</button>
				</div>

			</form:form>
		</section>
	</div>
	<!--  <script type="text/javascript">	
     var counter=1;
      $("#addRow").click(function () {
      	counter++;
      	/* alert(counter); */
          var html = '';
          html += '<div id="inputFormRow">';
          html += '<div class="input-group mb-3">';
          html +='<input type="checkbox" name="ischeck'+counter+'" class="form-check-input" id="exampleCheck1">'
          html += '<input type="text" name="choice'+counter+'" class="form-control m-input" placeholder="Enter title" autocomplete="off">';
          html += '<div class="input-group-append">';
          html += '<button id="removeRow" type="button" class="btn btn-danger">Remove</button>';
          html += '</div>';
          html += '</div>';

          $('#newRow').append(html);
          $('#count').val(counter);
        
      });

     
      $(document).on('click', '#removeRow', function () {
          $(this).closest('#inputFormRow').remove();
      });
   </script> -->
</body>
</html>



