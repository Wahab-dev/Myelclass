<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Menu page</title>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/overcast/jquery-ui-1.10.3.custom.css" />
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>	
<script type="text/javascript">

$(function() {
	$("#accordionmenu").accordion({
		heightStyle: "content"
	});
});
	

</script>
</head>
<body onload="">
	<!--  Login Form  -->
<h:form action="/login" method="post" >
	<table style="border: thin;">
   		<tr>  			
   			<td>Welcome ${user.name}...</td> 	
   			<td><h:submit property="action" value="Logout"></h:submit></td> 
   		</tr>
   </table>
</h:form>
	<h1>Menu Page</h1>
	<ul id="accordionmenu">
    <li> <h3>Samples </h3>
        <ul>
            <li> <h:link action='/loadSrf' scope="request">SrfScreen</h:link></li>
            <li> <h:link action='/gotoSampleTracking'>Sample Tacking</h:link></li>
            <li> <h:link action='/gotoSampleInvoice'>Sample Invoice Screen</h:link></li>
            <li> <h:link action='/sit'>Sample Invoice Tracking</h:link></li>
            <li> <h:link action='/gotoSampleDebit'>Sample Debit</h:link></li>
            <li> <h:link action='/sm'>Sample Master Tracking</h:link></li>
        </ul>
    </li>
    <li><h3>Contracts</h3>
        <ul>
            <li><h:link action='/LoadPrf' scope="request">Prf Screen</h:link></li>
            <li><h:link action='/gotoBulkTracking'>Bulk Tacking</h:link></li>
            <li><h:link action='/loadInspection'>Inspection Screen</h:link></li>
            <li><h:link action='/gotoInspectionTracking'>Inspection Tacking</h:link></li>
            <li><h:link action='/gotoinvoice'>Invoice Screen</h:link></li>
            <li><h:link action='/InvoiceTracking'>Invoice Tracking</h:link></li>
            <li><h:link action='/gotodebit'>Debit Screen</h:link></li>
            <li><h:link action='/gotodebittracking'>Debit Tacking</h:link></li>
            <li><h:link action='/gotopayment'>Payment Screen</h:link></li>
            <li><h:link action='/pt'>Payment Tracking</h:link></li>
            <li><h:link action='/gotoMasterTracking'>Master Tacking</h:link></li>
        </ul>
    </li>
    <li><h3>UserInput Screen</h3>
        <ul>
            <li><h:link action='/gotoUserInput'>User Input Settingss</h:link></li>
        </ul>
    </li>
</ul>
</body>
</html>