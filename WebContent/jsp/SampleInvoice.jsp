<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sample Invoice Page </title>
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 
</style>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/ui-darkness/jquery-ui-1.10.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/jquerywidgetstyle.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>		
<script src="js/elpro/sampleinvoice.js"></script> 
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
<h:form action="/savesampleinvoice" method="post" styleId="savesampleinvoice">
   <table style=" border: thin;">
   		<tr>  			
   			<td>Welcome <h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text></td> 	
   			<td><h:text property="sampleinvactionform" styleId="sampleinvactionform" value="${sampleinvactionform}" readonly="true" ></h:text></td>
   			<td><h:submit property="sampleinvoiceaction" value="Logout"></h:submit></td> 
   		</tr>
   </table>
   
	<table border="1" style="border: solid; padding: 0px; border-spacing: 0px;">
	   <tr>
   		  <td>
		    <fieldset>         
       		  <legend>Invoice Details</legend> 
       		  <table>
       			 <tr>
       			 	<td>Type: </td>
       			 	<td><h:select property ="saminv_invoicetype"  styleId="saminv_invoicetype" value="${editsaminvform[0].saminv_invoicetype}">
       			  		  <h:option value="0">Select Type</h:option>
   		 				  <h:option value="IC-L">IC-Local</h:option>
   		 				  <h:option value="IC-E">IC-Exports</h:option>
   		 				  <h:option value="IC-C">IC-Courier</h:option>
   		 				  <h:option value="O-C">Other-Tanner Courier</h:option> 
   		 				  <h:option value="O-E">Other-Tanner Exports</h:option> 
   		 				  <h:option value="O-L">Other-Tanner Local</h:option>
       		    		</h:select><br/>
       		    	</td>
       			 </tr>
       			  <tr>
       			  	<td>Invoice No:</td>
       			  	<td><h:text property="saminv_invoiceno" size="19" styleId="saminv_invoiceno"  value="${editsaminvform[0].saminv_invoiceno}"></h:text><br/></td>
       			 </tr>
       			  <tr>
       			 	<td>Invoice Date:</td>
       			 	<td><h:text property="saminv_invdate" size="25" styleId="saminv_invdate" styleClass="dateclass"  value="${editsaminvform[0].saminv_invdate}"></h:text><br/></td>
       			 </tr>
       			  <tr>
       			 	 <td> Exporters Ref. :</td>
       			 	 <td> <h:textarea property="saminv_expref" cols="17"  rows="2" styleId="saminv_expref"  value="${editsaminvform[0].saminv_expref}"> </h:textarea><br/></td>
       			 </tr>
       			 <tr>
       			 	 <td> Other ref : </td>
       			 	 <td><h:textarea property="saminv_otherref" cols="17"  rows="2" styleId="saminv_otherref"  value="${editsaminvform[0].saminv_otherref}"> </h:textarea>  <br/>
       			 </tr>  
       			 <tr>
       	    		<td>terms :</td>
       	    		<td><h:text property="saminv_terms" size="41" styleId="saminv_terms" value="${editinvform[0].saminv_terms }"> </h:text>  <br/></td>
       	    	 </tr>
       	    	 <tr>
       	    		<td>Payment :</td>
       	    	    <td><h:text property="saminv_payment" size="41" styleId="saminv_payment" value="${editinvform[0].saminv_payment }"> </h:text>  <br/></td>
       	         </tr> 
   			</table>
   			</fieldset>
		  </td>
   			  <td>
   				  <fieldset>         
       				  <legend>Exporter Details</legend>
       				  <table>
       				  <tr>
       				  	<td>Name :</td>
       				  	<td><h:text property="saminv_exporter" styleId="saminv_exporter" size="41" value="${editsaminvform[0].saminv_exporter}"></h:text><br/></td>
       				  </tr>
       				  <tr>
       				  	<td>Attn :</td>
       				  	<td><h:text property="saminv_exporterattn" styleId="saminv_exporterattn" size="41"  value="${editsaminvform[0].saminv_exporterattn}"></h:text><br/></td>
       				  </tr>
       				  <tr>
       				  	<td>Addr :</td>
       				  	<td><h:textarea property="saminv_exporteraddress" cols="30" rows="4" styleId="saminv_exporteraddress"  value="${editsaminvform[0].saminv_exporteraddress}"></h:textarea><br/></td>
       				  </tr>
       				  <tr>
       				  	<td>Tele :</td>
       				  	<td><h:text property="saminv_exportertele" styleId="saminv_exportertele" size="41" value="${editsaminvform[0].saminv_exportertele}"> </h:text><br/></td>
       				  </tr>
       				  <tr>
       				  	<td>Fax :</td>
       				  	<td><h:text property="saminv_exporterfax" styleId="saminv_exporterfax" size="41" value="${editsaminvform[0].saminv_exporterfax}" > </h:text>  <br/></td>
       				  </tr>
					</table>  
       			  </fieldset>
       		  </td>
   			  <td>
   			  <div>
   				  <fieldset>         
       			  <legend>Notify Details</legend>
       				<table>
       				  <tr>
       				  	<td>Name :</td>
       				  	<td><h:text property="saminv_notify" styleId="saminv_notify" size="41" value="${editsaminvform[0].saminv_notify}"></h:text><br/></td>
       				  </tr>
       				  <tr>
       				  	<td>Attn :</td>
       				  	<td><h:text property="saminv_notifyattn" styleId="saminv_notifyattn" size="41"  value="${editsaminvform[0].saminv_notifyattn}"></h:text><br/></td>
       				  </tr>
       				  <tr>
       				  	<td>Addr :</td>
       				  	<td><h:textarea property="saminv_notifyaddress" cols="30" rows="4" styleId="saminv_notifyaddress"  value="${editsaminvform[0].saminv_notifyaddress}"></h:textarea><br/></td>
       				  </tr>
       				  <tr>
       				  	<td>Tele :</td>
       				  	<td><h:text property="saminv_notifytele" styleId="saminv_notifytele" size="41" value="${editsaminvform[0].saminv_notifytele}"> </h:text><br/></td>
       				  </tr>
       				  <tr>
       				  	<td>Fax :</td>
       				  	<td><h:text property="saminv_notifyfax" styleId="saminv_notifyfax" size="41" value="${editsaminvform[0].saminv_notifyfax}" > </h:text>  <br/></td>
       				  </tr>
					</table>  
       			  </fieldset>
       			  </div>
   			  </td> 
		  </tr>
		  <tr>
   			  <td>
				<div>
   				  <fieldset>         
       				  <legend>Bank Details</legend>
       				  <table>
       				  	<tr>
       				  		<td>Bank: </td>
       				  		<td><h:text property="saminv_bank" styleId="saminv_bank"  size="41"  value="${editsaminvform[0].saminv_bank}"></h:text><br/></td>
       				  	</tr>
       				  	<tr>
       				  		<td>Branch: </td>
       				  		<td><h:text property="saminv_bankbranch" styleId="saminv_bankbranch"  size="41"  value="${editsaminvform[0].saminv_bankbranch}"></h:text><br/></td>
       				  	</tr>
       				  	<tr>
       				  		<td>Addr: </td>
       				  		<td><h:textarea property="saminv_bankaddress" cols="30" rows="4" styleId="saminv_bankaddress" style="align:center"  value="${editsaminvform[0].saminv_bankaddress}"></h:textarea><br/></td>
       				  	</tr>
       				  	<tr>
       				  		<td>Swift Code: </td>
       				  		<td><h:text property="saminv_bankswiftcode" styleId="saminv_bankswiftcode" size="41" value="${editsaminvform[0].saminv_bankswiftcode}"> </h:text><br/></td>
       				  	</tr>
       				  	<tr>
       				  		<td>Phone : </td>
       				  		<td><h:text property="saminv_banktele" styleId="saminv_banktele" size="41" value="${editsaminvform[0].saminv_banktele}"> </h:text><br/></td>
       				  	</tr>
       				  	<tr>
       				  		<td>fax  : </td>
       				  		<td><h:text property="saminv_bankfax" styleId="saminv_bankfax" size="41" value="${editsaminvform[0].saminv_bankfax}"> </h:text>  <br/></td>
       				  	</tr>
					</table>  
       			  </fieldset>
       			</div>
       		  </td>
   			  <td>
   			      <fieldset>         
       			   <legend>Dispatch Details</legend>
					<table>
       				  	<tr>
       				  		<td>Origin: </td>
       				  		<td><h:text property="saminv_ctryoforigngoods" styleId="saminv_ctryoforigngoods"  value="${editsaminvform[0].saminv_ctryoforigngoods}"></h:text><br/></td>
       				  	</tr> 
       				  	<tr>
       				  		<td>LoadingPort: </td>
       				  		<td><h:text property="saminv_loadingport" styleId="saminv_loadingport"  value="${editsaminvform[0].saminv_loadingport}"></h:text><br/></td>
       				  	</tr> 
       				  	<tr>
       				  		<td>Country-Destn:</td>
       				  		<td><h:text property="saminv_ctryoffinaldesti" styleId="saminv_ctryoffinaldesti"  value="${editsaminvform[0].saminv_ctryoffinaldesti}"></h:text><br/></td>
       				  	</tr> 
       				  	<tr>
       				  		<td>Destn: </td>
       				  		<td><h:text property="saminv_finaldesti" styleId="saminv_finaldesti" styleClass="autocmplet" value="${editsaminvform[0].saminv_finaldesti}"></h:text><br/></td>
       				  	</tr> 
       				  	<tr>
       				  		<td>Port: </td>
       				  		<td><h:text property="saminv_dischargeport" styleId="saminv_dischargeport" styleClass="autocmplet" value="${editsaminvform[0].saminv_dischargeport}"></h:text><br/></td>
       				  	</tr> 
       				  	<tr>
       				  		<td>Vessel No  : </td>
       				  		<td><h:text property="saminv_vesselno" styleId="saminv_vesselno"  value="${editsaminvform[0].saminv_vesselno}"></h:text><br/></td>
       				  	</tr> 	
       				  	<tr>
       				  		<td>AW/Bill No :  </td>
       				  		<td><h:text property="saminv_awbillno" styleId="saminv_awbillno" value="${editsaminvform[0].saminv_awbillno}"> </h:text>  <br/></td>
       				  	</tr> 
       				  	<tr>
       				  		<td>AW/Bill Date: </td>
       				  		<td><h:text property="saminv_awbilldate" styleId="saminv_awbilldate" styleClass="dateclass" value="${editsaminvform[0].saminv_awbilldate}"> </h:text><br/></td>
       				  	</tr>  
       				  	  
       				  </table>	 
       			  </fieldset>    				  			
   			  </td>
   			  <td>
   				  <fieldset>         
       			  <legend>Other Details</legend>
			 	  <table>
			 	  	<tr>
			 	  		<td>Pre Carriage By: </td>
			 	  		<td> <h:text property="saminv_precarriageby" styleId="saminv_precarriageby"  value="${editsaminvform[0].saminv_precarriageby}"></h:text><br/></td>
			 	  	</tr>
			 	  	<tr>
			 	  		<td>Place of Reciept: </td>
			 	  		<td><h:text property="saminv_precarriageby" styleId="saminv_precarriageby"  value="NA"></h:text><br/></td>
			 	  	</tr>
			 	  	<tr>
			 	  		<td>Gross Wt: </td>
			 	  		<td><h:text property="saminv_grosswt" styleId="saminv_grosswt"  value="${editsaminvform[0].saminv_grosswt}"></h:text><br/></td>
			 	  	</tr>
			 	  	<tr>
			 	  		<td>Dimension: </td>
			 	  		<td><h:text property="saminv_dimension" styleId="saminv_dimension" value="${editsaminvform[0].saminv_dimension}"></h:text><br/></td>
			 	  	</tr>
			 	  	<tr>
			 	  		<td>Marks: </td>
			 	  		<td><h:text property="saminv_marksno" styleId="saminv_marksno" value="${editsaminvform[0].saminv_marksno}"></h:text><br/></td>
			 	  	</tr>
			 	  	<tr>
			 	  		<td>No Of packages:</td>
			 	  		<td><h:text property="saminv_noofpackages" styleId="saminv_noofpackages" value="${editsaminvform[0].saminv_noofpackages}"></h:text><br/></td>
			 	  	</tr>
			 	  	<tr>
			 	  		<td>Pack No:</td>
			 	  		<td><h:text property="saminv_packno" styleId="saminv_packno" value="${editsaminvform[0].saminv_packno}"></h:text><br/></td>
			 	  	</tr>
			 	  	<tr>
			 	  		<td>Net Wt: </td>
			 	  		<td><h:text property="saminv_netwt" styleId="saminv_netwt" value="${editsaminvform[0].saminv_netwt}"></h:text><br/></td>
			 	  	</tr>
			 	  </table>	
				  </fieldset>  
			</td>
			
		</tr>
		<tr>		  
		    <td>
			   <fieldset>         
       		   <legend>Customer Details</legend>
       		   <table>
       		   	<tr>
       		   		<td>Include CT:</td>
       		   		<td><h:select property ="saminv_includeSample"  styleId="saminv_includeSample" > 
       				 		<h:option value="sample" >No</h:option>
       				 		<h:option value="ct" >yes</h:option>
       				 	</h:select><br/>
       				</td>
       		   	</tr>
       		   	<tr>
       		   		<td>Name :</td>
       		   		<td><h:text property="saminv_customer" size="41"  styleId="saminv_customer" value="${editsaminvform[0].saminv_customer}"></h:text><br/></td>
       		   	</tr>
       		   	<tr>
       		   		<td>Attn :</td>
       		   		<td><h:text property="saminv_custattn" size="41"  styleId="saminv_custattn" value="${editsaminvform[0].saminv_custattn}"></h:text><br/></td>
       		   	</tr>
       		   	<tr>
       		   		<td>Addr :</td>
       		   		<td><h:textarea property="saminv_custaddr" cols="30" rows="4" styleId="saminv_custaddr" value="${editsaminvform[0].saminv_custaddr}"></h:textarea><br/></td>
       		   	</tr>
       		   	<tr>
       		   		<td>Tele :</td>
       		   		<td><h:text property="saminv_custtele" size="41"  styleId="saminv_custtele" value="${editsaminvform[0].saminv_custtele}"></h:text><br/></td>
       		   	</tr>
       		   	<tr>
       		   		<td> Fax  :</td>
       		   		<td> <h:text property="saminv_custfax" size="41"  styleId="saminv_custfax" value="${editsaminvform[0].saminv_custfax}"></h:text><br/></td>
       		   	</tr>
       		   	<tr>
       		   		<td> ID  :</td>
       		   		<td><h:text property="saminv_custid" size="41"  styleId="saminv_custid" value="${editsaminvform[0].saminv_custid}"></h:text><br/></td>
       		   	</tr>
       		   </table>
       		  </fieldset>
			</td>
   			<td colspan="2">
           	    <table id="tbl_saminvListCustomerContract" > </table>   
           		<div id="tbl_saminvpager"></div> 
           		          	 
           	</td>	      	  
		<tr>
  			<td colspan="3">&nbsp;</td>
	    </tr>
		<tr>
		  <td colspan="3">
		     	<table id="tbl_saminvaddinvBill"></table>
		        <div id="tbl_saminvbillpager"></div>
		  </td>  
		</tr>
		<tr>
  			<td colspan="3">&nbsp;</td>
	    </tr>
		<tr>
   			<td colspan="3"> 
				<table id="saminvBill"></table>
		      	<div id="saminvbillpager"></div>
			</td>    
        <tr>
        <td colspan="3"> 
			 	<fieldset>         
       				<legend>Other Charges</legend>
       				<table>
       					<tr>
       						<td>Courier Discount: </td>
       						<td><h:text property="saminv_courierchrgs" styleId="saminv_courierchrgs"  value="${editsaminvform[0].saminv_courierchrgs}"> </h:text></td>
       					</tr>
       					<tr>
       						<td>Discount :  </td>
       						<td><h:text property="saminv_deduction" styleId="saminv_deduction"  value="${editsaminvform[0].saminv_deduction}"> </h:text>  <br/></td>
       					</tr>
       					<tr>
       						<td>Total Amount :  </td>
       						<td><h:text property="saminv_total" styleId="saminv_total"  value="${editsaminvform[0].saminv_total}"> </h:text>  <br/></td>
       					</tr>
       				</table>
				</fieldset>
			</td>
	    <tr> 	
		    <td><h:submit property="sampleinvoiceaction" value="Save" styleClass="myPrintButton" ></h:submit></td>
		    <td><h:reset property="sampleinvoiceaction" value="Clear" styleClass="myPrintButton" ></h:reset></td>
		    <td><h:submit property="sampleinvoiceaction" value="Print" styleClass="myPrintButton" ></h:submit></td>	
   		</tr>
	  </table>
	</h:form>

</body>
</html>