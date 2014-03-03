<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Master Page</title>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/ui-darkness/jquery-ui-1.10.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 
.myAltRowClass { background-color: Light; background-image: none; }
</style>
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="js/elpro/master.js"></script>
<script type="text/javascript">

</script>


</head>
<body>
<h:form action="/login" method="post" >
	<table style="border: thin;">
   		<tr>  			
   			<td>Welcome ${user.name}...</td> 
   			<h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text>
   			<td><h:submit property="action" value="Logout"></h:submit></td>
   			 
   		</tr>
   </table>
</h:form>
<h:form>
	<h5> Welcome Buddy ! 1 am in Master Form .. . </h5>
	<div id="Master Grid Details ">
		<table id="mastertarckgrid"></table>
		<div id="masterpager"></div>
	</div>
	
	<div id="msgbox" title="" style="display: none;"> <!--  Alert Box  -->
	</div>
	<%-- <h6>Its a Slave Grid .......</h6>	
	<!--  Slave Grid  -->
	<div id="Slave Grid Details ">
		<table id="slavegrid"></table>
		<div id="slavepager"></div>
	</div> --%>
</h:form>
</body>


</html>