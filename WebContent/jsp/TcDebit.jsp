<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.7.3.custom.css" rel="Stylesheet" />
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 	
</style>	
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/redmond/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="js/elpro/tcdebit.js"></script> 		
<script type="text/javascript">
</script>
</head>
<body>
<!--  Login Form  -->
<h:form action="/login" method="post" >
	<table style="border: thin;">
   		<tr>
			<td>Welcome ${user.name}</td> 
   			<td><h:submit property="action" value="Logout"></h:submit></td>
		</tr>
   </table>
</h:form>


<h:form action="/savetcdebit" focus="tcdebitno"> 	
	<table width="800" border="2" cellspacing="0" cellpadding="0">
    	<tr>
		    <td>
		    	<fieldset>         
        				<legend>Tcdebit Details</legend> 
        					Tcdebit No: <h:text property="tcdeb_tcdebitno" styleId="tcdeb_tcdebitno"></h:text><br />
        					<br />Tanner  : <h:text property="tcdeb_exporter" styleId="tcdeb_exporter" value="${invdetails[0].inv_exporter}"></h:text><br />        	 					
         					<br />Address: <h:textarea property="tcdeb_tanaddr" cols="30" rows="2" styleId="tcdeb_tanaddr"></h:textarea><br />
        					<br />Telephone : <h:text property="tcdeb_tantelephone" styleId="tcdeb_tantelephone"> </h:text><br />
							
      		  </fieldset>
		    </td>
		    <td>
        					<br />TcDebit Date: <h:text property="tcdeb_tcdebitdate" styleId="tcdeb_tcdebitdate" ></h:text><br />
        					<br />Tanner Invoice No: <h:text property="tcdeb_taninvno" styleId="tcdeb_taninvno" value="${invdetails[0].inv_invoiceno}"></h:text><br />              	 					
         					<br />elclass ref no : <h:text property="tcdeb_elclassrefno" styleId="tcdeb_elclassrefno" value="${invdetails[0].inv_otherref}"></h:text><br />
        					
      			
			</td>
  		</tr>
  		<tr>
	  		<td>&nbsp;</td>
	  		<td>&nbsp;</td>
	  	</tr>
  		<tr>
		   <td colspan="3">
            		 <table id="tbl_tcdebselInvDetails"></table>
             		<div id="deb_tcdebpager"></div>
              	</td>
              	<td>
              	</td>
	  	</tr>
	  	<tr>
		    <td>
		    	<br />Exchange Rate: <h:text property="tcdeb_exchangerate" styleId="tcdeb_exchangerate" > </h:text><br />
				<br />TC :  <h:text property="tcdeb_commission1" styleId="tcdeb_commission1"> </h:text>  <br />  
				<br />Rate: <h:text property="tcdeb_rate" styleId="tcdeb_rate"> </h:text><br />
				<br />Quantity :  <h:text property="tcdeb_totalquantity" styleId="tcdeb_totalquantity"> </h:text>  <br />  
				
				
      		</td>
		    <td>
		    	<br />Invoice Amount: <h:text property="tcdeb_invoiceamt" styleId="tcdeb_invoiceamt"> </h:text><br />
				<br />el class Amount :  <h:text property="tcdeb_elclassamt" styleId="tcdeb_elclassamt"> </h:text>  <br />  
		    	<br />TC Amount in Rs: <h:text property="tcdeb_elclassamtinrs" styleId="tcdeb_elclassamtinrs"> </h:text><br />
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