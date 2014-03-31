<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Payment Page</title>
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
<script src="js/elpro/payment.js"></script> 		
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
   <h:form action="/Payment" focus="debitno" method="post" onreset=""> 	
			<td >Welcome <h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text></td >
   			<td><h:text property="payactionform" styleId="payactionform" value="${payactionform}" readonly="true" ></h:text></td>
   			<td><h:submit property="paymntaction" value="Logout"></h:submit></td> 
	<table style="border-width: medium; border-style: solid;"> 
    	<tr>
		    <td>
		    	<fieldset>         
        				<legend>Tannery Details</legend> 
        					<br/>Tanner  : <h:text property="deb_exporter" styleId="deb_exporter" value="${editpayform[0].deb_exporter}"></h:text><br/>        	 					
         					<br/>Address: <h:textarea property="deb_tanaddr" cols="30" rows="2" styleId="deb_tanaddr"></h:textarea><br/>
        					<br/>Telephone : <h:text property="deb_tantelephone" styleId="deb_tantelephone"> </h:text><br/>
							
      		 </fieldset>
		    </td>
		    <td>
		    	<fieldset>         
        				<legend>Payment Reciept Details</legend> 
		    				<br/>Paymnet No: <h:text property="paymentno" styleId="paymentno" value="${editpayform[0].deb_debitno}"></h:text><br/>
        					<br/>Payment Date: <h:text property="deb_debitdate" styleClass="paydt" styleId="deb_debitdate"  value="${editpayform[0].deb_debitdate }"></h:text><br/>
        					 <br/>Cheque Details: <h:textarea property="chequedetails" styleId="chequedetails" rows="2" cols="30" value="${editpayform[0].chequedetails }"> </h:textarea><br/>
      			 </fieldset>
			</td>
  		</tr>
  		<tr>
	  		<td>&nbsp;</td>
	  		<td>&nbsp;</td>
	  	</tr>
  		<tr>
		   <td colspan="2">
            		 <table id="tbl_paymentDetails"></table>
             		<div id="paymentpager"></div>
              	</td>
              	<td>
              	</td>
	  	</tr>
	  	<tr>
		    <td>
		    	<br/>Quantity :  <h:text property="deb_totalquantity" styleId="deb_totalquantity"  value="${editpayform[0].deb_qshipped }"> </h:text>  <br/>  
				<br/>Invoice Amount: <h:text property="deb_invoiceamt" styleId="deb_invoiceamt"  value="${editpayform[0].deb_invoiceamt }"> </h:text><br/>
				<br/>Amount(Rs): <h:text property="deb_elclassamtinrs"  value="${editpayform[0].deb_elclassamtinrs }" styleId="deb_elclassamtinrs"> </h:text><br/>
				
      		</td>
		    <td>
		    	
				<br/>Tax @ 12.36% :  <h:text property="deb_tax" styleId="deb_tax"  value="${editpayform[0].deb_tax }"> </h:text>  <br/>  
				<br/>Total: <h:text property="deb_total" styleId="deb_total"  value="${editpayform[0].deb_total }"> </h:text><br/>
				<br/>TDS :  <h:text property="deb_tds" styleId="deb_tds"  value="${editpayform[0].deb_tds }"> </h:text>  <br/>  
				<br/>Total Due: <h:text property="deb_due" styleId="deb_due"  value="${editpayform[0].deb_due }"> </h:text><br/>
			</td>
		   
	  	</tr>
	  	<tr>
	  		<td>&nbsp;</td>
	  		<td>&nbsp;</td>
	  	</tr>
	  	<tr>
	  		 <td >
		    	<br/>Credit Amount: <h:text property="creditamt"  value="${editpayform[0].creditamt }" styleId="creditamt"> </h:text><br/>
				<br/>Balance Amount :  <h:text property="balanceamt" styleId="balanceamt"  value="${editpayform[0].balanceamt }"> </h:text>  <br/>  
				<br/>Reciept Date :  <h:text property="recieptdate" styleId="recieptdate" styleClass="paydt"  value="${editpayform[0].recieptdate }"> </h:text>  <br/>
				
			</td>
	  		<td>
	  			 
				<br/>Comments: <h:textarea property="otherdetails" styleId="otherdetails"  value="${editpayform[0].otherdetails }"  rows="2" cols="30"> </h:textarea><br/>
			</td>	
	  	</tr>
	  	<tr>
	  		<td>&nbsp;</td>
	  		<td>&nbsp;</td>
	  	</tr>
	  	<tr>
		    <td><h:submit property="paymntaction" value="Save" styleId="Btndebitsave"></h:submit>
		   <h:submit property="paymntaction" value="Print" styleId="Btndebitsave"></h:submit>
   			<td><h:reset property="paymntaction" value="Clear"></h:reset></td> 
  		</tr>
	</table>
</h:form>
</body>
</html>