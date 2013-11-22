<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bulk Page</title>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/ui-darkness/jquery-ui-1.10.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 
</style>
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="js/elpro/bulk.js"></script> 
<script type="text/javascript">

</script>
</head>
<body>
<!--  Login Form  -->
<h:form action="/login" method="post" >
	<table style="border: thin;">
   		<tr>  			
   			<td>Welcome ${user.name}...</td> 
   			<h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text>
   			<td><h:submit property="btraction" value="Logout"></h:submit></td> 
   		</tr>
   </table>
</h:form>

<!-- Bulk Tracking Form  -->
<h:form >   
	<div id="blk">Bulk Tracking</div> 
	 Group By: <select id="chngroup"> 
			<option value="ctno">Ct No</option> 
			<option value="articlename">Article</option> 
			<option value="status">Status</option>
			<option value="color">color</option> 
			<option value="clear">Remove Grouping</option> 
		</select> <br/><br/> 
			<table id="bulkktracktbl"></table> 
			<div id="bulkktrackpager"></div> 
	 </h:form>  
</body>
</html>