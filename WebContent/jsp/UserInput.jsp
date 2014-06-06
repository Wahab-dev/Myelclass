<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User Input Screen</title>
<style type="text/css">
.myclass 
{
    text-transform:capitalize;
}
</style>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/redmond/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="js/elpro/userinput.js"></script> 
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
	$("#jqgriduserinput").accordion({
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
<table style="border: 15px; ">
   		<tr>  			
   			<td>Welcome <h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text></td> 	
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

<ul id="jqgriduserinput">
 <li> <h3>Tanner </h3>	
 	<div id="tannery Details">
		<table id="tannerdetails"></table>
		<div id="tannerpager"></div>
	</div>
 </li>
 <li><h3>Customer </h3>	
 	<div id="Customer Details">
		<table id="customerdetails"></table>
		<div id="customerpager"></div>
	</div>
 </li>
<li><h3>Consignee </h3>
	<div id="Consignee Details">
		<table id="consigdetails"></table>
		<div id="consigpager"></div>
	</div>
</li> 
 <li><h3>Notify </h3>
 	<div id="Notify Details">
		<table id="notifydetails"></table>
		<div id="notifypager"></div>
	</div>
</li> 
<li><h3>Bank </h3>
	<div id="Bank Details">
		<table id="bankdetails"></table>
		<div id="bankpager"></div>
	</div>
</li> 
<li><h3>Article  </h3>
	<div id="Article Details">
		<table id="articledetails"></table>
		<div id="articlepager"></div>
	</div>
</li> 
<li><h3>Color </h3>
	<div id="Color Details">
		<table id="colordetails"></table>
		<div id="colorpager"></div>
	</div>	
</li> 
<li><h3>Destination </h3>
	<div id="Destination Details">
		<table id="destidetails"></table>
		<div id="destipager"></div>
	</div>
</li> 
<li><h3>Commission </h3>
	<div id="Commission Details">
		<table id="commissiondetails"></table>
		<div id="commissionpager"></div>
	</div>
</li> 
<li><h3>Terms </h3>
	<div id="Terms Details">
		<table id="termsdetails"></table>
		<div id="termspager"></div>
	</div>
</li> 
<li><h3>Payment </h3>
	<div id="Payment Details">
		<table id="paymntdetails"></table>
		<div id="paymntpager"></div>
	</div>
</li> 
 
</ul>
</body>
</html>