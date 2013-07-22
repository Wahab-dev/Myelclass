<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.7.3.custom.css" rel="Stylesheet" />	
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.3.custom.min.js"></script>
<script>
	$(function() {
		$("#inspdate").datepicker();
	});
	</script>
</head>
<body>
<h:form action="/saveinspection" styleId="saveInspection">
	<table width="800" height="586" border="2" cellpadding="0" cellspacing="0">
	  	<tr>
		   <td height="533">Welcome ${user.name}.. <h:submit property="action" value="Logout"></h:submit>
		     <fieldset> 	
		     	<legend>Basic Details</legend>  
		     		<table>
		     			<tr>
		     				<td>
		     					Contract Number :
		     						<h:select property="inpsContractNumber">
          								<%-- <c:forEach items="${inspcontractarray}" var ="inspCtno">
          													<h:option value="${inspCtno.inspContractNo}">
          			    										<c:out value="${inspCtno.inspContractNo}"></c:out>
          													</h:option>       		
          												</c:forEach> --%>
          											</h:select><br />	
          												
		     				</td>
		     				<td>
		     					Inspection Date :
		     						<h:text property="inspdate" styleId="inspdate"></h:text><br />
		     				</td>
		     				<td>
		     					Quality Controller:
		     						<h:select property="inspqualityctrlr">
          								<%-- <c:forEach items="${inspqctrlrarray}" var ="inspqtyCtrl">
          													<h:option value="${inspqtyCtrl.inspqualityctrlr}">
          			    										<c:out value="${inspqtyCtrl.inspqualityctrlr}"></c:out>
          													</h:option>       		
          												</c:forEach> --%>
          											</h:select><br />		
		     				</td>
		     			</tr>
		     		</table>          																
		     </fieldset>
		    
		     <table width="800" border="2" cellspacing="0" cellpadding="0">
		      <tr>
		      	<td width="93">Ct No</td>
		        <td width="93">Order Date</td>
		        <td width="93">Article</td>
		        <td width="74">Colour</td>
		        <td width="56">Size</td>
		        <td width="62">Substance</td>
		        <td width="55">Selection</td>
		        <td width="113">Customer</td>
		        <td width="113">Supplier</td>
		        <td width="62">Quantity</td>
		        <td width="55">Rate</td>
	          </tr>
		      <tr>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
	          </tr>
	          
	        </table>
	          <div>Please make sure you check the following before Inspection of Goods</div>
	            <textarea rows="4" cols="100"></textarea>
	            
	            
	            <fieldset> 	
		     		<legend>Manual Test</legend>
	         	  <table width="800" border="2" cellspacing="0" cellpadding="0">
	          		
		     		<tr>
	            		<td width="198">Test Type</td>
	            		<td width="193">Tested Peces</td>
	            		<td width="399">Comments</td>
	            	</tr>
	          		<tr>
	            		<td>Color</td>
	            		<td>&nbsp;</td>
	            		<td>&nbsp;</td>
	            	</tr>
	          		<tr>
	            		<td>Substance</td>
	            		<td>&nbsp;</td>
	            		<td>&nbsp;</td>
	            	</tr>
	          		<tr>
	            		<td>Tear Strength</td>
	            		<td>&nbsp;</td>
	            		<td>&nbsp;</td>
	            	</tr>
	          		<tr>
			            <td>Grain Break</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	           	 	</tr>
	          		<tr>
			            <td>Crocking Dry</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	            	</tr>
	          		<tr>
			            <td>Crocking Wet</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	            	</tr>
	          		<tr>
			            <td>Finish Adhension</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	            	</tr>
	          		<tr>
			            <td>Four Fold</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	            	</tr>
	          		<tr>
			            <td>Cross Section</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	            	</tr>
	          		<tr>
			            <td>Organoleptic</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	            	</tr>	            
	         	 </table>
	          </fieldset> 
	          <div>Content for New Div Tag Goes Here</div>
	          <fieldset> 	
		     		<legend>Grading</legend>
	          	<table width="800" border="2" cellspacing="0" cellpadding="0">
	            	<tr>
	              		<td width="88">Grading</td>
	              		<td width="118">Skin Count</td>
	              		<td width="223">Percentage</td>
	              		<td width="359">Comments</td>
                	</tr>
	            	<tr>
	              		<td>Grading 1</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
                	</tr>
	            	<tr>
	              		<td>Grading 2</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
                	</tr>
	            	<tr>
	              		<td>Grading 3</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
                	</tr>
	            	<tr>
	              		<td>Grading 4</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
                	</tr>
	            	<tr>
	              		<td>Grading 5</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
                	</tr>
              	</table>
              </fieldset>
	          <div>Content for New Div Tag Goes Here</div>
	          <fieldset> 	 	
		     	<legend>Rejects</legend>
	          		<table width="799" border="2" cellspacing="0" cellpadding="0">
	            		<tr>
	              			<td height="28" colspan="2" rowspan="2">Total Skins Passed</td>
	              			<td colspan="7"><div align="center">Rejects</div></td>
	              			<td rowspan="2">Total Skins Inspected</td>
                		</tr>
	            		<tr>
	              			<td width="92">Substance</td>
	              			<td width="68">Size</td>
	              			<td width="77">Selection</td>
	              			<td width="42">Color</td>
	              			<td width="84">Organoleptic</td>
	              			<td width="53">Other</td>
	              			<td width="106">Total Rejects</td>
                		</tr>
	            		<tr>
	              			<td width="44" height="22">Sides</td>
	              			<td width="72">&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td width="137">&nbsp;</td>
                		</tr>
	            		<tr>
	              			<td>Hides</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
                		</tr>
	            		<tr>
	              			<td>Total</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
                		</tr>
              		</table>
              	</fieldset>
	        
	          <table width="800" border="2" cellspacing="0" cellpadding="0">
	           	 <tr>
	              <td height="15">Comments</td>	  	                           
                </tr>
	           	<tr>          	
	              <td height="55"></td>
                </tr>              
                <tr>
	              <td height="15">Stamping Details</td>	  	                           
                </tr>
                <tr>          	
	              <td height="55"></td>
                </tr>   
                 <tr>
  					<td><h:submit property="action" value="Save" styleId="Save"></h:submit>
  						<h:reset property="action" value="Clear" styleId="Clear"></h:reset>
  						<h:reset property="action" value="Print" styleId="Print"></h:reset>
  					</td>	
  				</tr>
              </table>
	          </td>
  		</tr>
	</table>
</h:form>
</body>
</html>