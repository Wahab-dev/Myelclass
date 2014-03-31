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
	   <tr bordercolor="black"  >
   		  <td>
		    <fieldset>         
       		  <legend>Invoice Details</legend><br/> 
       			  Type: <h:select property ="saminv_invoicetype"  styleId="saminv_invoicetype" value="${editsaminvform[0].saminv_invoicetype}">
       			  		  <h:option value="0">Select Type</h:option>
   		 				  <h:option value="IC-L">IC-Local</h:option>
   		 				  <h:option value="IC-E">IC-Exports</h:option>
   		 				  <h:option value="IC-C">IC-Courier</h:option>
   		 				  <h:option value="O-C">Other-Tanner Courier</h:option> 
   		 				  <h:option value="O-E">Other-Tanner Exports</h:option> 
   		 				  <h:option value="O-L">Other-Tanner Local</h:option>
       		    		</h:select><br/>     
       		    		<div id="dv_invtype">
       		    		</div>   
   	 					 <br/> Invoice No: <h:text property="saminv_invoiceno" styleId="saminv_invoiceno"  value="${editsaminvform[0].saminv_invoiceno}"></h:text><br/>
       					 <br/> Invoice Date:<h:text property="saminv_invdate" styleId="saminv_invdate" styleClass="dateclass"  value="${editsaminvform[0].saminv_invdate}"></h:text><br/>
       					 <br/> Exporters Ref. : <h:text property="saminv_expref" styleId="saminv_expref"  value="${editsaminvform[0].saminv_expref}"> </h:text><br/>
						 <br/> Other ref :  <h:text property="saminv_otherref" styleId="saminv_otherref"  value="${editsaminvform[0].saminv_otherref}"> </h:text>  <br/>  
   			</fieldset>
		  </td>
   			  <td width="250">
   				  <fieldset>         
       				  <legend>Exporter Details</legend><br/> 
       					  Exporter: <h:text property="saminv_exporter" styleId="saminv_exporter"  value="${editsaminvform[0].saminv_exporter}"></h:text><br/>        
   	 					 <br/> Attn: <h:text property="saminv_exporterattn" styleId="saminv_exporterattn"  value="${editsaminvform[0].saminv_exporterattn}"></h:text><br/>
       					 <br/> Address: <h:textarea property="saminv_exporteraddress" cols="15" rows="1" styleId="saminv_exporteraddress"  value="${editsaminvform[0].saminv_exporteraddress}"></h:textarea><br/>
       					 <br/> Telephone : <h:text property="saminv_exportertele" styleId="saminv_exportertele" value="${editsaminvform[0].saminv_exportertele}"> </h:text><br/>
						<br/> Fax :  <h:text property="saminv_exporterfax" styleId="saminv_exporterfax" value="${editsaminvform[0].saminv_exporterfax}"> </h:text>  <br/>  
       			  </fieldset>
       		  </td>
   			  <td width="250">
   			  <div id="saminvnotify">
   				  <fieldset>         
       				  <legend>Notify Details</legend><br/> 
       					  Notify: <h:text property="saminv_notify" styleId="saminv_notify"  value="${editsaminvform[0].saminv_notify}"></h:text><br/>        
   	 					 <br/> Attn: <h:text property="saminv_notifyattn" styleId="saminv_notifyattn"  value="${editsaminvform[0].saminv_notifyattn}"></h:text><br/>
       					 <br/> Address:<h:textarea property="saminv_notifyaddress" cols="15" rows="1" styleId="saminv_notifyaddress"  value="${editsaminvform[0].saminv_notifyaddress}"></h:textarea><br/>
       					<br/>  Phone : <h:text property="saminv_notifytele" styleId="saminv_notifytele"  value="${editsaminvform[0].saminv_notifytele}"> </h:text><br/>
						 <br/> Fax :  <h:text property="saminv_notifyfax" styleId="saminv_notifyfax"  value="${editsaminvform[0].saminv_notifyfax}"> </h:text>  <br/>  
       			  </fieldset>
       			  </div>
   			  </td>
   			 
		  </tr>
		  <tr style="border: solid;">
   			  <td>
				<div id="saminvbank">
   				  <fieldset>         
       				  <legend>Bank Details</legend><br/> 
       					  Bank: <h:text property="saminv_bank" styleId="saminv_bank" value="${editsaminvform[0].saminv_bank}"></h:text><br/>        
   	 					  <br/>Branch: <h:text property="saminv_bankbranch" styleId="saminv_bankbranch" value="${editsaminvform[0].saminv_bankbranch}"></h:text><br/>
       					  <br/>Addr:<h:textarea property="saminv_bankaddress" cols="15" rows="1" styleId="saminv_bankaddress" style="align:center"  value="${editsaminvform[0].saminv_bankaddress}"></h:textarea><br/>
       					  <br/>Swift Code: <h:text property="saminv_bankswiftcode" styleId="saminv_bankswiftcode" value="${editsaminvform[0].saminv_bankswiftcode}"> </h:text><br/>
       					  <br/>Acct No : <h:text property="saminv_bankacno" styleId="saminv_bankacno" value="${editsaminvform[0].saminv_bankacno}"> </h:text><br/>
       					  <br/>Phone : <h:text property="saminv_banktele" styleId="saminv_banktele" value="${editsaminvform[0].saminv_banktele}"> </h:text><br/>
						  <br/>fax :  <h:text property="saminv_bankfax" styleId="saminv_bankfax" value="${editsaminvform[0].saminv_bankfax}"> </h:text>  <br/>  
       			  </fieldset>
       			</div>
       		  </td>
   			  <td>
   			      <fieldset>         
       				  <legend>Dispatch Details</legend><br/> 
       					  COG: <h:text property="saminv_ctryoforigngoods" styleId="saminv_ctryoforigngoods"  value="${editsaminvform[0].saminv_ctryoforigngoods}"></h:text><br/>
       					  <br/>LoadingPort: <h:text property="saminv_loadingport" styleId="saminv_loadingport"  value="${editsaminvform[0].saminv_loadingport}"></h:text><br/> 
						  <br/>COF: <h:text property="saminv_ctryoffinaldesti" styleId="saminv_ctryoffinaldesti"  value="${editsaminvform[0].saminv_ctryoffinaldesti}"></h:text><br/> 
   	 					  <br/>Destination: <h:text property="saminv_finaldesti" styleId="saminv_finaldesti" styleClass="autocmplet" value="${editsaminvform[0].saminv_finaldesti}"></h:text><br/>
       					  <br/>Dischargeport: <h:text property="saminv_dischargeport" styleId="saminv_dischargeport" styleClass="autocmplet" value="${editsaminvform[0].saminv_dischargeport}"></h:text><br/> 
       					  <br/>Vessel No  : <h:text property="saminv_vesselno" styleId="saminv_vesselno"  value="${editsaminvform[0].saminv_vesselno}"></h:text><br/>      
       					  <br/>AW/Bill Date: <h:text property="saminv_awbilldate" styleId="saminv_awbilldate" styleClass="dateclass" value="${editsaminvform[0].saminv_awbilldate}"> </h:text><br/>
						  <br/>AW/Bill No :  <h:text property="saminv_awbillno" styleId="saminv_awbillno" value="${editsaminvform[0].saminv_awbillno}"> </h:text>  <br/>  
       			  </fieldset>    				  			
   			  </td>
   			  <td width="250">
   				  <fieldset>         
       				  <legend>Other Details</legend><br/> 
       				  	  Pre Carriage By: <h:text property="saminv_precarriageby" styleId="saminv_precarriageby"  value="${editsaminvform[0].saminv_precarriageby}"></h:text><br/>
       					  Place of Reciept: <br/>Dimension: <h:text property="saminv_precarriageby" styleId="saminv_precarriageby"  value="NA"></h:text><br/> 						
   						  Gross Wt: <h:text property="saminv_grosswt" styleId="saminv_grosswt"  value="${editsaminvform[0].saminv_grosswt}"></h:text><br/>
       					  <br/>Dimension: <h:text property="saminv_dimension" styleId="saminv_dimension" value="${editsaminvform[0].saminv_dimension}"></h:text><br/> 
						  <br/> Marks: <h:text property="saminv_marksno" styleId="saminv_marksno" value="${editsaminvform[0].saminv_marksno}"></h:text><br/>
   	 					  <br/> No Of packages: <h:text property="saminv_noofpackages" styleId="saminv_noofpackages" value="${editsaminvform[0].saminv_noofpackages}"></h:text><br/>
       					  <br/>Pack No:<h:text property="saminv_packno" styleId="saminv_packno" value="${editsaminvform[0].saminv_packno}"></h:text><br/>
       					  <br/>Net Wt: <h:text property="saminv_netwt" styleId="saminv_netwt" value="${editsaminvform[0].saminv_netwt}"></h:text><br/> 
				  </fieldset>  
			</td>
			
		</tr>
		<tr style="border: solid;">		  
		    <td width="250">
			   <fieldset>         
       			  <legend>Customer Details</legend>
       			   <br/>Include Sample:<h:select property ="saminv_includeSample"  styleId="saminv_includeSample" > 
       				 						<h:option value="sample" >sample only</h:option>
       				 						<h:option value="ct" >include Contract</h:option>
       				 					</h:select><br/>
   					 <br/>Customer Name: <h:text property="saminv_customer" styleId="saminv_customer" value="${editsaminvform[0].saminv_customer}"></h:text><br/>
       				 <br/>Attn: 	<h:text property="saminv_custattn" styleId="saminv_custattn" value="${editsaminvform[0].saminv_custattn}"></h:text><br/> 
					 <br/> Address: <h:textarea property="saminv_custaddr" cols="15" rows="1" styleId="saminv_custaddr" value="${editsaminvform[0].saminv_custaddr}"></h:textarea><br/>
   	 				 <br/>Telephone:<h:text property="saminv_custtele" styleId="saminv_custtele" value="${editsaminvform[0].saminv_custtele}"></h:text><br/>
       				 <br/>Fax:	    <h:text property="saminv_custfax" styleId="saminv_custfax" value="${editsaminvform[0].saminv_custfax}"></h:text><br/>
       				 <br/>ID:	    <h:text property="saminv_custid" styleId="saminv_custid" value="${editsaminvform[0].saminv_custid}"></h:text><br/>	
       					
			   </fieldset>
			</td>
   			<td colspan="3">
           	    <table id="tbl_saminvListCustomerContract" > </table>   
           		<div id="tbl_saminvpager"></div> 
           		          	 
           	</td>	      	  
		<tr>
  			<td colspan="4">&nbsp;</td>
	    </tr>
		<tr>
		  <td colspan="4">
		     	<table id="tbl_saminvaddinvBill"></table>
		        <div id="tbl_saminvbillpager"></div>
		  </td>  
		</tr>
		<tr>
  			<td colspan="4">&nbsp;</td>
	    </tr>
		<tr>
   			<td colspan="4"> 
				<table id="saminvBill"></table>
		      	<div id="saminvbillpager"></div>
			</td>    
        <tr>
        <td width="250"> 
			 	<fieldset>         
       				<legend>Other Charges</legend>
				  	Courier Discount: <h:text property="saminv_courierchrgs" styleId="saminv_courierchrgs"  value="${editsaminvform[0].saminv_courierchrgs}"> </h:text>
				 	<br/>Discount :  <h:text property="saminv_deduction" styleId="saminv_deduction"  value="${editsaminvform[0].saminv_deduction}"> </h:text>  <br/>
					<br/>Total Amount :  <h:text property="saminv_total" styleId="saminv_total"  value="${editsaminvform[0].saminv_total}"> </h:text>  <br/>
				</fieldset>
			</td>
	    <tr style="border: solid;"> 
 			<td colspan="4">
		    	  <h:submit property="sampleinvoiceaction" value="Save"></h:submit>
		    	  <h:submit property="sampleinvoiceaction" value="Clear"></h:submit>
			</td>  		
   		</tr>
	  </table>
	</h:form>

</body>
</html>