<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script src="js/elpro/debit.js"></script> 		
<script type="text/javascript">
</script>
</head>
<body>

<h:form action="/savedebit" focus="debitno"> 	
	<table width="800" border="2" cellspacing="0" cellpadding="0">
		<tr>
			<td>Welcome ${user.name}</td> 
   			<td><h:submit property="action" value="Logout"></h:submit> 
   			</td> 
		</tr>
    	<tr>
		    <td>
		    	<fieldset>         
        				<legend>Debit Details</legend> 
        					Debit No: <h:text property="deb_debitno" styleId="deb_debitno"></h:text><br />
        					<br />Tanner  : <h:text property="deb_exporter" styleId="deb_exporter"></h:text><br />        	 					
         					<br />Address: <h:textarea property="deb_tanaddr" cols="30" rows="2" styleId="deb_tanaddr"></h:textarea><br />
        					<br />Telephone : <h:text property="deb_tantelephone" styleId="deb_tantelephone"> </h:text><br />
							
      		  </fieldset>
		    </td>
		    <td>
        					<br />Debit Date: <h:text property="deb_debitdate" styleId="deb_debitdate"></h:text><br />
        					<br />Tanner Invoice No: <h:text property="deb_taninvno" styleId="deb_taninvno"></h:text><br />              	 					
         					<br />elclass ref no : <h:text property="deb_elclassrefno" styleId="deb_elclassrefno"></h:text><br />
        					
      			
			</td>
  		</tr>
  		<tr>
	  		<td>&nbsp;</td>
	  		<td>&nbsp;</td>
	  	</tr>
  		<tr>
		   <td colspan="3">
            		 <table id="tbl_debselInvDetails"></table>
             		<div id="deb_debpager"></div>
              	</td>
              	<td>
              	</td>
	  	</tr>
	  	<tr>
		    <td>
		    	<br />Exchange Rate: <h:text property="deb_exchangerate" styleId="deb_exchangerate" > </h:text><br />
				<br />Commission :  <h:text property="deb_commission1" styleId="deb_commission1"> </h:text>  <br />  
				<br />Rate: <h:text property="deb_rate" styleId="deb_rate"> </h:text><br />
				<br />Quantity :  <h:text property="deb_totalquantity" styleId="deb_totalquantity"> </h:text>  <br />  
				<br />Invoice Amount: <h:text property="deb_invoiceamt" styleId="deb_invoiceamt"> </h:text><br />
				<br />el class Commission :  <h:text property="deb_elclassamt" styleId="deb_elclassamt"> </h:text>  <br />  
				
      		</td>
		    <td>
		    	<br />Commission in INR: <h:text property="deb_elclassamtinrs" styleId="deb_elclassamtinrs"> </h:text><br />
				<br />Tax @ 12.36% :  <h:text property="deb_tax" styleId="deb_tax"> </h:text>  <br />  
				<br />Total: <h:text property="deb_total" styleId="deb_total"> </h:text><br />
				<br />TDS :  <h:text property="deb_tds" styleId="deb_tds"> </h:text>  <br />  
				<br />Total Due: <h:text property="deb_due" styleId="deb_due"> </h:text><br />
			</td>
		   
	  	</tr>
	  	<tr>
	  		<td>&nbsp;</td>
	  		<td>&nbsp;</td>
	  	</tr>
	  	<tr>
		    <td><h:submit property="action" value="Save"></h:submit></td> 
   			<td><h:reset property="action" value="Clear"></h:reset></td> 
  		</tr>
	</table>
</h:form>
</body>
</html>