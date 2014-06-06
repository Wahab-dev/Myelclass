<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Master Page</title>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/redmond/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 
.myAltRowClass { background-color: Light; background-image: none; }
</style>
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="js/elpro/master.js"></script>
<script type="text/javascript">
$(function() {
	 var icons = {
			 header: "ui-icon-circle-arrow-e",
			 activeHeader: "ui-icon-circle-arrow-s"
	};
	$(".accordionmenu").accordion({
		heightStyle: "content",
		 icons: icons,
		 active: false,
		 collapsible: true ,
		 heightStyle: "content"
	});
});
</script>


</head>
<body>
<h:form action="/login" method="post" >
	<table style="border: thin;">
   		<tr>  			
   			<td>Welcome<h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text>
   			<td><h:submit property="action" value="Logout"></h:submit></td>
   			 
   		</tr>
   </table>
</h:form>
<div id="accordionwidth">
<table  style="border: thin;">
   		<tr>  
   			<td>		
			<div id="accordionmenu1" class="accordionmenu">
			  <h3>Samples </h3>
			        <ul>
			             <li> <h:link action='/loadSrf' scope="request">SrfScreen</h:link></li>
							<li> <h:link action='/gotoSampleTracking'>Sample Tracking</h:link></li>
							<li> <h:link action='/gotoSampleInvoice'>Sample Invoice Screen</h:link></li>
							  <li> <h:link action='/sit'>Sample Invoice Tracking</h:link></li>
							 <li> <h:link action='/gotoSampleDebit'>Sample Debit</h:link></li>
			        </ul>
			        </div>
			    </td>
				<td>
				<div id="accordionmenu2" class="accordionmenu">
					<h3>Contracts</h3>
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
							<li><h:link action='/gotoMasterTracking'>Master Tacking</h:link></li>
			        </ul>
			        </div>
			   </td>
			 <td>
			 <div id="accordionmenu3" class="accordionmenu">
			  <h3>UserInput Screen</h3>
			        <ul>
			            <li><h:link action='/gotoUserInput'>User Input Settingss</h:link></li>
			        </ul>
			</div>
   			</td>
   		</tr>
   </table>
   </div>
<h:form>
<h3>Master Tracking Grid </h3>
	<div>
	 Group By: <select id="chngroup"> 
			<option value="clear" selected="selected">Remove Grouping</option>
			<option value="ctno">Ct No</option> 
			<option value="agent">Agent</option> 
			<option value="exporterid">Exporter</option>
			<option value="tanneryid">Tannery</option> 
			<option value="customerid">Customer</option> 
			<option value="articlename">Article</option> 
			<option value="color">Color</option>
			<option value="status">Status</option> 
			<option value="invno">Invno</option> 
			<option value="debitno">Debitno</option> 
		</select> <br/><br/> 
	</div>	
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