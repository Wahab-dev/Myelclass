<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.7.3.custom.css" rel="Stylesheet" />
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 	
</style>	
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/pepper-grinder/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />

<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>		
<script src="js/elpro/inspection.js"></script> 	

</head>
<body>
<!--  Login Form  -->
<h:form action="/login" method="post" >
	<table style="border: thin;">
   		<tr>  			
   			<td>Welcome ${user.name}...</td> 	
   			<td><h:submit property="btraction" value="Logout"></h:submit></td> 
   		</tr>
   </table>
</h:form>


<h:form action="/saveinspection" styleId="saveInspection">
	<table style="border: 2 px">
	  	<tr>
		   <td>
		     <fieldset> 	
		     <legend>Basic Details</legend>  
		       <table>
		     	 <tr>
		     	    <td>
		     		 Contract Number :
		     		 <h:text property="inspContractNo" styleId="inspContractNo"></h:text><br />	         												
		     		</td>
		     		<td>
		     		 Inspection Date :
		     		 <h:text property="inspdate" styleId="inspdate"></h:text><br />
		     		</td>
		     		<td>
		     		 Quality Controller:
		     		 <h:text property="inspqualityctrlr" styleId="inspqualityctrlr"></h:text><br />		
		     		</td>
		     		<td>
		     		 Total Inspected:
		     		 <h:text property="totinspected" styleId="totinspected"></h:text><br />		
		     		</td>
		     	 </tr>
		       </table>          																
		     </fieldset>
		      <table>
		       <tr>
		   <td>
		    <fieldset> 	 	
		     	<legend>Contract Details</legend>
		    	<table id="insp_Ctdetails"></table>
		    		<div id="insp_CtDetalspager"></div>
		      </fieldset> 
		   	</td>
		     </tr>
		    </table>
	          <div>Please make sure you check the following before Inspection of Goods</div>
	            <h:textarea  property="insp_cdn" styleId="insp_cdn" rows="4" cols="100"></h:textarea>	
	         <%--    <h:text property="articleid" styleId="articleid" ></h:text>          
	            <input type="hidden" name="arttid"  value="">  --%>
	             <fieldset> 	 	
		     	  <legend>Test Details</legend>
	            	<table id="insptesttbl"></table>
	            	<div id="insptestpager"></div>
	            </fieldset>	         
	            
	          <fieldset> 	 	
		     	<legend>Grading</legend>
	          	<table id="inspgradtbl"></table>
		     		<div id="inspgradpager"></div>
	         </fieldset> 
	         	
	          <fieldset> 	 	
		     	<legend>Rejects</legend>
		     	<table id="insprejtbl"></table>
		     	<div id="insprejpager"></div>
              </fieldset> 
	        
	          <table style="border: 2 px">
	           	 <tr>
	              <td height="15"> 
	               <h:textarea property="inspcomments" styleId="inspcomments" rows="2" cols="50" ></h:textarea> 	
	              </td>	
	                                 
                </tr>
	           	<tr>          	
	              <td height="55"></td>
                </tr>              
                  
                 <tr>
  					<td><h:submit property="Save" value="Save" styleId="Save"></h:submit>
  						<h:reset property="Clear" value="Clear" styleId="Clear"></h:reset>
  						
  					</td>	
  				</tr>
              </table>
	          </td>
  		</tr>
	</table>
</h:form>
</body>
</html>