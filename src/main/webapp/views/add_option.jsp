
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Options</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container-fluid">
<section class="get-in-touch">
   <h1 class="title">Add Options</h1>
  <form:form action="save_choices" method="post" modelAttribute="question" class="contact-form row">
  
      <div class="form-field col-lg-12">
         <input id="question"  name="question" class="input-text js-input" value= "${question.quesid}" hidden>
     
           <input id="question"  name="question1" class="input-text js-input" value= "${question.question}" >
       
      </div> 
<!--************************option input box***************** -->
		
    <div class="row">
        <div class="col-lg-12">
            <div id="inputFormRow">
                <div class="input-group mb-3">
                 <input type="checkbox" name="ischeck1" value="true" class="form-check-input" id="exampleCheck1">
                    <input type="text" id="choice" name="choice1"  class="form-control m-input" placeholder="Enter option" autocomplete="off"> 
                     <input type="text" id="count" name="counter" value="1" class="form-control m-input" placeholder="Enter option" autocomplete="off" hidden>
                    <div class="input-group-append">
                        <button id="removeRow" type="button" class="btn btn-danger">Remove</button>
                    </div>
                </div>
            </div>

            <div id="newRow"></div>
            <button id="addRow" type="button" style="background-image: linear-gradient(125deg, #a72879, #064497)" class="btn btn-info">Add Option</button>
        </div>
    </div>
    
    <div class="form-field col-lg-12">
         <button data-toggle="modal" data-target="#exampleModal" class="submit-btn" type="submit" >Add Options</button>
      </div> 
 <!--**********************end option***********************-->
      

  
     <%--     <sec:csrfInput/> --%>
   </form:form>
</section>
</div> 

<script type="text/javascript">
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

        // remove row
        $(document).on('click', '#removeRow', function () {
            $(this).closest('#inputFormRow').remove();
        });
    </script>
</body>
</html>

