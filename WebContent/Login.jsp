<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="l"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Screen</title>
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 
#tabs-1, #tabs-2{
	font-size: 12.5px;
}
#registernewUserDialogForm{
font-size: 12.5px; 
}
#buttons{
size: 12.5px; 
}

#pwderror{
 color:red;
}
</style>	
<link rel="stylesheet" type="text/css" media="screen" href="css/ui-darkness/jquery-ui-1.10.1.custom.css" />
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script>
$(document).ready(function(){
	
	 //DATEPICKER
    $("#dOB").datepicker({
	    changeYear: true,
	    autoSize: true,
	    changeMonth: true,
	    yearRange: "-70:-18",
	    dateFormat: "yy/mm/dd",
	    showWeek: true,
	    firstDay: 1,
	    numberOfMonths: 1,
	    showButtonPanel: true,
	    gotoCurrent:true, 
	    /* beforeShowDay: function(date) {
	        var day = date.getDay();              // Disable only SUndays
	        return [(day != 0), ''];
	    } */
	});
	 
    $("#password2").change(function (){
    	if($('#password1').val() != $('#password2').val()){
    		  $('#pwderror').text("values do not match"); 
		}
    });
	 
	$("#registerForm").click(function (){	 
		$("#registernewUserDialogForm").dialog('open');
	});
	
	
	
	 //Forgot Password 
	 $("#forgotpassworddialogform").dialog({
			autoOpen: false,
	        resizable: true,
	        width: 420,
	        height: 200,
	        autoResize: true, 
	        modal: true,
	        /* buttons:{
	        	Send:function(){  
	        	},
	        	Cancel:function(){  
	        		$(this).dialog('close');
	        	}
	        } */
		});
	
		//Register User Dialog 
		$("#forgotpassword").click(function (){	 
			$("#forgotpassworddialogform").dialog('open');
		});
			 $("#registernewUserDialogForm").tabs().dialog({
				autoOpen: false,
		        resizable: true,
		        width: 380,
		        height: 370,
		        autoResize: true, 
		        modal: true,
		       /*  buttons:{
	        		Submit:function(){  
	        		//alert("Data to be Sent to Server "+data);
		        		 $.ajax({
		                     type: 'POST',
		                     url: '/Myelclass/Registernewuser.do',
		                     data: $('#registernewUserDialogForm :input').serialize(),
		                     error: function(xml, status, error) {
		                         $('#registernewUserDialogForm').html('<p><strong>Error Code:</strong> '+status+'</p><p><strong>Explanation:</strong> '+error+'</p>');
		                     }
		                 });
	        		 alert("Data to be Sent to Server "+data);
	        		},
	        		Cancel:function(){  
	        			$(this).dialog('close');
	        		}
	        	} */ 
		});
}); 
</script>
</head>
<body>
<div id="loginform" title="Login form">
<h1><h:errors/></h1>
<table height="250" >
	<tr>
	</tr>
</table>
<h:form action="/login" method="post">

	<table align="center">
	<tr>	
		<td> User Name :</td>
		<td> <h:text property="username" styleId="username"></h:text></td>
	</tr>
	<tr height="15"></tr>
	<tr>	
		<td>Password  : </td>
		<td><h:password property="password" styleId="password"></h:password></td>
	</tr>	
	<tr height="15"></tr>
	<tr>
		<td>Role :</td>
		<td>
			<h:select property="role" styleId="role"> 
				<h:option value="0"><i>Select Role</i></h:option>
				<h:option value="Admin">Administrator</h:option>
				<h:option value="User">User</h:option>
				<h:option value="QC">QC</h:option>
				<h:option value="Manager">Manager</h:option>
			</h:select>
		</td>
	</tr>
	<tr height="15"></tr>
	 <tr>
	 	<td></td>
	 	<td><h:submit property="loginaction" value="Login" styleId="loginaction"></h:submit></td>
	 	<td><h:submit property="loginaction" value="Clear" styleId="loginaction"></h:submit></td>
	 </tr>
	 <tr height="35"></tr>
	 <tr>
	 	<td><h:button property="registerForm" styleId="registerForm" value="New User"></h:button></td>
	 	<td><h:button property="forgotpassword" styleId="forgotpassword" value="Forgot Password"></h:button></td>
	 	<td></td>
	 </tr>  
	</table>
 	</h:form>	
</div>
 	
 	
 	
 	
 	<!-- Register New User -->
 		<div id="registernewUserDialogForm" title="Register New User" style="registernewUserDialogForm">
 		 <h:form action="/Registernewuser" method="post">
 		  	<ul>
				<li><a href="#tabs-1">Personal Details</a></li>
				<li><a href="#tabs-2">Other Details</a></li>
			</ul>
			
		 	<div id="tabs-1">
				<table>
					<tr>	
						<td>First Name:</td>
						<td> <h:text property="fName" styleId="fName"></h:text></td>
					</tr>
					<tr height="12"></tr>
					<tr>	
						<td>Last Name:</td>
						<td><h:text property="lName" styleId="lName"></h:text></td>
					</tr>	
					<tr height="12"></tr>
					<tr>	
						<td>Age:</td>
						<td> <h:text property="age" styleId="age"></h:text></td>
					</tr>
					<tr height="12"></tr>
					<tr>	
						<td>Gender:</td>
						<td> 
							<h:select property="gender" styleId="gender">
								<h:option value="0">Select Gender</h:option>
								<h:option value="M">Male</h:option>
								<h:option value="F">FeMale</h:option>
							</h:select>
						</td>
					</tr>
					<tr height="12"></tr>
					<tr>	
						<td>DOB:</td>
						<td><h:text property="dOB" styleId="dOB"></h:text></td>
					</tr>	
					<tr height="12"></tr>
					<tr>	
						<td>Contact No: </td>
						<td><h:text property="contactNo" styleId="contactNo"></h:text></td>
					</tr>	
				</table>			
			</div>
		
			<div id="tabs-2">
				<table>
					<tr>	
						<td> Email Id:</td>
						<td> <h:text property="emailId" styleId="emailId"></h:text></td>
					</tr>
					<tr height="12"></tr>			
					<tr>	
						<td> User Name:</td>
						<td> <h:text property="userName" styleId="userName"></h:text></td>
					</tr>
					<tr height="12"></tr>
					<tr>	
						<td>Password: </td>
						<td><h:password property="password" styleId="password1" styleClass="password"></h:password></td>
					</tr>	
					<tr height="12"></tr>
					<tr>	
						<td>Retype Password: </td>
						<td><h:password property="repassword" styleId="password2" styleClass="password"></h:password><span id="pwderror" style="pwderror"></span></td>
					</tr>	
					<tr height="12"></tr>
					<tr>
						<td>Role :</td>
						<td>
							<h:select property="userType" styleId="userType">
								<h:option value="0"><i>Select Role</i></h:option>
								<h:option value="Admin">Administrator</h:option>
								<h:option value="User">User</h:option>
								<h:option value="QC">QC</h:option>
								<h:option value="Manager">Manager</h:option>
							</h:select>
						</td>		
					</tr>
					<tr>
						<td>
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>	
							<h:submit property="loginaction" value="Registernewuser" styleId="submitNewUser" ></h:submit>
							<h:submit property="loginaction" value="ClearRegForm" styleId="clearNewUser"></h:submit>
						</td>
					</tr>
				</table>
			</div>
		  
          </h:form> 
 	    </div>
 		
 		<!-- Forgot password -->	
 		<div id="forgotpassworddialogform" title="Forgot Password">
 			 <h:form action="/Forgotpassword" method="post">
 			 		<table>
							
					<tr>	
						<td> User Name:</td>
						<td> <h:text property="userName" styleId="userName"></h:text></td>
					</tr>
					<tr height="12"></tr>
					<tr>
						<tr>	
						<td> Email Id:</td>
						<td> <h:text property="emailId" styleId="emailId"></h:text></td>
					</tr>	
					<tr>
						<td>
						</td>
						<td>	
							<h:submit property="loginaction" value="Sendpassword" styleId="submitforNewPwd" ></h:submit>
							<h:submit property="loginaction" value="Clearpwdform" styleId="clearNewPwd"></h:submit>
						</td>
					</tr>
				</table>
 			 </h:form>
 		</div>
 		
</body>
</h:html>