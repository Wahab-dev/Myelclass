<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/jquery.dialogextend.1_0_1.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/overcast/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" href="css/ui.multiselect.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/jquerywidgetstyle.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<script type="text/javascript" src="js/ui.multiselect.js"></script>	
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>	
<script src="js/elpro/sampleinvtrack.js"></script> 
<script type="text/javascript">
$(function() {
	 var icons = {
			 header: "ui-icon-circle-arrow-e",
			 activeHeader: "ui-icon-circle-arrow-s"
	};
	$(".accordionmenu").accordion({
		 icons: icons,
		 active: false,
		 collapsible: true ,
		 heightStyle: "content"
	});
	
});
</script>
</head>
<body>
<div id="accordionwidth" style="width: 1100px;">
<table style="border: thin; ">
   		<tr>  
   			<td>		
			<div id="accordionmenu1" class="accordionmenu">
			  <h3>Samples </h3>
			        <ul>
			            	<li> <h:link action='/loadSrf' scope="request">SrfScreen</h:link></li>
							<li> <h:link action='/gotoSampleTracking'>Sample Tacking</h:link></li>
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
 		<table>	
  		<h:form action="/login" method="post">
  		
  		<tr>   			
	   		<td>Welcome <h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text>   				
	   	<%-- 	<h:text property="formaction" styleId="formaction" value="${actionform}"></h:text> --%>
	   		<h:submit property="prfaction" value="Logout"></h:submit></td>
	   	</tr>
	   
	   	</h:form>
	   		</table>	

	 Group By: <select id="chngroup"> 
			<option value="invno">Inv No</option> 
			<option value="invtype">Inv Type</option>
			<option value="exporter">Exporter</option>
			<option value="customer">Customer</option> 
			<option value="invctno">Ct No</option> 
			<option value="invartname">Article</option>
			<option value="invcolor">Color</option>
			<option value="clear">Remove Grouping</option>
		</select> <br/><br/>
 
		<div>
			<table id="sampleinvtracktbl"></table> 
			<div id="sampleinvtrackpager"></div> 
		</div>

</body>
</html>