<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CUSTOMER COMPLAINT REQUEST HOME PAGE</title>
	<style> 
	
	.error
    {
        color: #ff0000;
        font-weight: bold;
    }
    
	* {
	  box-sizing: border-box;
	}
	
	input[type=text], select, textarea {
	  width: 100%;
	  padding: 12px;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  resize: vertical;
	}
	
	label {
	  padding: 12px 12px 12px 0;
	  display: inline-block;
	}
	
	input[type=submit] {
	  background-color: #4CAF50;
	  color: white;
	  padding: 12px 20px;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	  float: right;
	}
	
	input[type=submit]:hover {
	  background-color: #45a049;
	}
	
	.container {
	  border-radius: 5px;
	  background-color: #f2f2f2;
	  padding: 20px;
	}
	
	.col-25 {
	  float: left;
	  width: 25%;
	  margin-top: 6px;
	}
	
	.col-75 {
	  float: left;
	  width: 75%;
	  margin-top: 6px;
	}
	
	/* Clear floats after the columns */
	.row:after {
	  content: "";
	  display: table;
	  clear: both;
	}
	
	/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
	@media screen and (max-width: 600px) {
	  .col-25, .col-75, input[type=submit] {
	    width: 100%;
	    margin-top: 0;
	  }
	}
	</style>
	</head>
<body>
<H1><u>CUSTOMER COMPLAINT REQUEST FORM</u></H1>
  
<!-- <div class="container">
  <form action="/submit.do">
  <div class="row">
    <div class="col-25">
      <label for="accountid">Account Id: </label>
    </div>
    <div class="col-75">
      <input type="text" id="aId" name="accountid" placeholder="Please enter valid account ID">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="bcode">Branch Code: </label>
    </div>
    <div class="col-75">
      <input type="text" id="bcode" name="branchcode" placeholder="Please enter valid Branch Code">
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="eid">Email Id: </label>
    </div>
    <div class="col-75">
      <input type="text" id="eid" name="branchcode" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" placeholder="Please enter valid Branch Code">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="ccat">Complaint Category: </label>
    </div>
    <div class="col-75">
      <select id="ccat" name="complaintcategory">
        <option value="internet">Internet Banking</option>
        <option value="general">General Banking</option>
        <option value="others">Others</option>
      </select>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="description">Description</label>
    </div>
    <div class="col-75">
      <textarea id="description" name="description" placeholder="Write description.." style="height:200px"></textarea>
    </div>
  </div>
 
  <input id=cancelButton type="button" value="Cancel" />
  <input id=submitButton type="submit" value="Submit" />

  <div class="row">
  <a href="checkStatus.hr">Check Status</a><br/>
  </div> -->
  
  
  <springForm:form method="POST" commandName="compCommand"
        action="submitComplaint.do">
		<table>
			<tr>
				<td>Account ID:</td>
				<td><springForm:input path="accountId" pattern = "[0-9]{10}" required="required"/></td>
			
			</tr>
			<tr>
				<td>Branch Code:</td>
				<td><springForm:input path="branchCode" required="required"/></td>
			
			</tr>
			<tr>
				<td>Email ID:</td>
				<td><springForm:input path="emialId" type = "email" required="required"/></td>
			</tr>
			<tr>
				<td>Category:</td>
				<td><springForm:select path="category" required="required">
				<springForm:option value="1">Internet Banking</springForm:option>
				<springForm:option value="2">General Banking</springForm:option>
				<springForm:option value="3">Others</springForm:option>
				</springForm:select>
				</td>
			</tr>
			
			<tr>
				<td>Description:</td>
				<td><springForm:input path="description" required="required"/></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Submit"></td>
			</tr>
		</table>

	</springForm:form>
</body>
</html>