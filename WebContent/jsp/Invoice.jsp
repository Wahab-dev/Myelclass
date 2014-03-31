<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
  
<!DOCTYPE html>
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Invoice Page </title>
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 
</style>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/ui-darkness/jquery-ui-1.10.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />

<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>		
<script src="js/elpro/invoice.js"></script> 
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
<div id="accordionwidth" style="width: 120%;">
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

<h:form action="/saveinvoice" styleId="saveinvoice">
	<table style=" border: thin;">
   		<tr>  
  			 <td>Welcome <h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text></td> 	
   			<td><h:text property="invactionform" styleId="invactionform" value="${invactionform}" readonly="true" ></h:text></td>
   			<td><h:submit property="invaction" value="Logout"></h:submit></td>
   		</tr>
   	</table> 
	<table border="1" style="border: solid; padding: 0px; border-spacing: 0px;">
	   <tr bordercolor="black"  >
   		  <td>
		    <fieldset>         
       		  <legend>Invoice Details</legend><br/> 
       			  Type: <h:select property ="inv_invoicetype"  styleId="inv_invoicetype" value="${editinvform[0].inv_invoicetype }">
       			  		  <h:option value="0">Select Type</h:option>
   		 				  <h:option value="IC-L">IC-Local</h:option>
   		 				  <h:option value="IC-E">IC-Exports</h:option>
   		 				  <h:option value="IC-C">IC-Courier</h:option>
   		 				  <h:option value="O-C">Other-Tanner Courier</h:option> 
   		 				  <h:option value="O-E">Other-Tanner Exports</h:option> 
   		 				  <h:option value="O-L">Other-Tanner Local</h:option>
   		 				  <h:option value="IC-P">IC-PO</h:option>  
   		 				  <h:option value="IC-J">IC-JW</h:option>  
       		    		</h:select><br/>     
       		    		<div id="dv_invtype">
       		    		</div>   
   	 					 <br/> Invoice No: <h:text property="inv_invoiceno" styleId="inv_invoiceno" value="${editinvform[0].inv_invoiceno }"></h:text><br/>
       					 <br/> Invoice Date:<h:text property="inv_invdate" styleId="inv_invdate" styleClass="dateclass" value="${editinvform[0].inv_invdate }"></h:text><br/>
       					 <br/> Exporters Ref. : <h:text property="inv_expref" styleId="inv_expref" value="${editinvform[0].inv_expref }"> </h:text><br/>
						 <br/> Other ref :  <h:text property="inv_otherref" styleId="inv_otherref" value="${editinvform[0].inv_otherref }"> </h:text>  <br/>  
   			</fieldset>
		  </td>
   			  <td width="250">
   				  <fieldset>         
       				  <legend>Exporter Details</legend><br/> 
       					  Exporter: <h:text property="inv_exporter" styleId="inv_exporter" value="${editinvform[0].inv_exporter }"></h:text><br/>        
   	 					 <br/> Attn: <h:text property="inv_exporterattn" styleId="inv_exporterattn" value="${editinvform[0].inv_exporterattn }"></h:text><br/>
       					 <br/> Address: <h:textarea property="inv_exporteraddress" cols="15" rows="1" styleId="inv_exporteraddress" value="${editinvform[0].inv_exporteraddress }"></h:textarea><br/>
       					 <br/> Telephone : <h:text property="inv_exportertele" styleId="inv_exportertele" value="${editinvform[0].inv_exportertele }"> </h:text><br/>
						<br/> Fax :  <h:text property="inv_exporterfax" styleId="inv_exporterfax" value="${editinvform[0].inv_exporterfax }"> </h:text>  <br/>  
       			  </fieldset>
       		  </td>
   			  <td width="250">
   			  <div id="invnotify">
   				  <fieldset>         
       				  <legend>Notify Details</legend><br/> 
       					  Notify: <h:text property="inv_notify" styleId="inv_notify" value="${editinvform[0].inv_notify }"></h:text><br/>        
   	 					 <br/> Attn: <h:text property="inv_notifyattn" styleId="inv_notifyattn" value="${editinvform[0].inv_notifyattn }"></h:text><br/>
       					 <br/> Address:<h:textarea property="inv_notifyaddress" cols="15" rows="1" styleId="inv_notifyaddress" value="${editinvform[0].inv_notifyaddress }"></h:textarea><br/>
       					<br/>  Phone : <h:text property="inv_notifytele" styleId="inv_notifytele" value="${editinvform[0].inv_notifyfax }"> </h:text><br/>
						 <br/> Fax :  <h:text property="inv_notifyfax" styleId="inv_notifyfax" value="${editinvform[0].inv_notifytele }"> </h:text>  <br/>  
       			  </fieldset>
       			  </div>
   			  </td>
   			  </tr>
		  <tr style="border: solid;">
   			  <td>
				<div id="invbank">
   				  <fieldset>         
       				  <legend>Bank Details</legend><br/> 
       					  Bank: <h:text property="inv_bank" styleId="inv_bank" value="${editinvform[0].inv_bank }"></h:text><br/>        
   	 					  <br/>Branch: <h:text property="inv_bankbranch" styleId="inv_bankbranch" value="${editinvform[0].inv_bankbranch }"></h:text><br/>
       					  <br/>Addr:<h:textarea property="inv_bankaddress" cols="15" rows="1" styleId="inv_bankaddress" style="align:center" value="${editinvform[0].inv_bankaddress }"></h:textarea><br/>
       					  <br/>Swift Code: <h:text property="inv_bankswiftcode" styleId="inv_bankswiftcode" value="${editinvform[0].inv_bankswiftcode }"> </h:text><br/>
       					  <br/>Acct No : <h:text property="inv_bankacno" styleId="inv_bankacno" value="${editinvform[0].inv_bankacno }"> </h:text><br/>
       					  <br/>Phone : <h:text property="inv_banktele" styleId="inv_banktele" > </h:text><br/>
						  <br/>fax :  <h:text property="inv_bankfax" styleId="inv_bankfax" > </h:text>  <br/>  
       			  </fieldset>
       			</div>
       		  </td>
   			  <td>
   			      <fieldset>         
       				  <legend>Dispatch Details</legend><br/> 
       					  COG: <h:text property="inv_ctryoforigngoods" styleId="inv_ctryoforigngoods" value="${editinvform[0].inv_ctryoforigngoods }"></h:text><br/>
       					  <br/>LoadingPort: <h:text property="inv_loadingport" styleId="inv_loadingport" value="${editinvform[0].inv_loadingport }"></h:text><br/> 
						  <br/>COF: <h:text property="inv_ctryoffinaldesti" styleId="inv_ctryoffinaldesti" value="${editinvform[0].inv_ctryoffinaldesti }"></h:text><br/> 
   	 					  <br/>Destination: <h:text property="inv_finaldesti" styleId="inv_finaldesti" styleClass="autocmplet" value="${editinvform[0].inv_finaldesti }"></h:text><br/>
       					  <br/>Dischargeport: <h:text property="inv_dischargeport" styleId="inv_dischargeport" styleClass="autocmplet" value="${editinvform[0].inv_dischargeport }"></h:text><br/> 
       					  <br/>Vessel No  : <h:text property="inv_vesselno" styleId="inv_vesselno" value="${editinvform[0].inv_vesselno }"></h:text><br/>      
       					  <br/>AW/Bill Date: <h:text property="inv_awbilldate" styleId="inv_awbilldate" styleClass="dateclass" value="${editinvform[0].inv_awbilldate }"> </h:text><br/>
						  <br/>AW/Bill No :  <h:text property="inv_awbillno" styleId="inv_awbillno" value="${editinvform[0].inv_awbillno }"> </h:text>  <br/>  
       			  </fieldset>    				  			
   			  </td>
   			  <td width="250">
   				  <fieldset>         
       				  <legend>Other Details</legend><br/> 
       				  	  Pre Carriage By: <h:text property="inv_precarriageby" styleId="inv_precarriageby" value="${editinvform[0].inv_precarriageby }"></h:text><br/>
       					  Place of Reciept: <h:text property="inv_precarriageby" styleId="inv_precarriageby" value="${editinvform[0].inv_placeofreciept }"></h:text><br/> 						
   						  Gross Wt: <h:text property="inv_grosswt" styleId="inv_grosswt" value="${editinvform[0].inv_grosswt }"></h:text><br/>
       					  <br/>Dimension: <h:text property="inv_dimension" styleId="inv_dimension" value="${editinvform[0].inv_dimension }"></h:text><br/> 
						  <br/> Marks: <h:text property="inv_marksno" styleId="inv_marksno" value="${editinvform[0].inv_marksno }"></h:text><br/>
   	 					  <br/> No Of packages: <h:text property="inv_noofpackages" styleId="inv_noofpackages" value="${editinvform[0].inv_noofpackages }"></h:text><br/>
       					  <br/>Pack No:<h:text property="inv_packno" styleId="inv_packno" value="${editinvform[0].inv_packno }"></h:text><br/>
       					  <br/>Net Wt: <h:text property="inv_netwt" styleId="inv_netwt" value="${editinvform[0].inv_netwt }"></h:text><br/> 
				  </fieldset>  
			</td>
			
		</tr>
		<tr style="border: solid;">		  
		    <td width="250">
			   <fieldset>         
       			  <legend>Customer Details</legend>
       			   <br/>Include Sample:<h:select property ="inv_includeSample"  styleId="inv_includeSample" > 
       				 						<h:option value="ct" >No</h:option>
       				 						<h:option value="sample" >yes</h:option>
       				 					</h:select><br/>
   					 <br/>Customer Name: <h:text property="inv_customer" styleId="inv_customer" value="${editinvform[0].inv_customer }"></h:text><br/>
       				 <br/>Attn: 	<h:text property="inv_custattn" styleId="inv_custattn" value="${editinvform[0].inv_custattn }"></h:text><br/> 
					 <br/> Address: <h:textarea property="inv_custaddr" cols="15" rows="1" styleId="inv_custaddr" value="${editinvform[0].inv_custaddr }"></h:textarea><br/>
   	 				 <br/>Telephone:<h:text property="inv_custtele" styleId="inv_custtele" value="${editinvform[0].inv_custtele }"></h:text><br/>
       				 <br/>Fax:	    <h:text property="inv_custfax" styleId="inv_custfax" value="${editinvform[0].inv_custfax }"></h:text><br/>
       				 <br/>ID:	    <h:text property="inv_custid" styleId="inv_custid" value="${editinvform[0].inv_custid }"></h:text><br/>	
       					
			   </fieldset>
			</td>
   			<td colspan="3">
           	    <table id="tbl_invListCustomerContract" > </table>   
           		<div id="tbl_invpager"></div> 
           		<!-- <table id="tbl_invListCustomerSample" > </table>   
           		<div id="tbl_invsamplepager"></div>  -->             	 
           	</td>	      	  
		<tr>
  			<td colspan="4">&nbsp;</td>
	    </tr>
		<tr>
		  <td colspan="4">
		     	<table id="tbl_invaddinvBill"></table>
		        <div id="tbl_invbillpager"></div>
		  </td>  
		</tr>
		<tr>
  			<td colspan="4">&nbsp;</td>
	    </tr>
		<tr>
   			<td colspan="4"> 
				<table id="invBill"></table>
		      	<div id="invbillpager"></div>
			</td> 
		<tr>	   
			<td colspan="4"> 
				<fieldset>         
       				<legend>Other Charges</legend>
				  	Deduction: <h:text property="inv_discount" styleId="inv_discount" value="${editinvform[0].inv_deduction }"> </h:text>
				  	<%-- <div id="localsalesradio">	
				  		<br/><h:radio property="inv_vatcst" value="2" styleId="inv_cst" onclick="alert(document.getElementById('inv_cst').value)">CST</h:radio>
				  		<h:radio property="inv_vatcst" value="5" styleId="inv_vat" onclick="alert(document.getElementById('inv_vat').value)">VAT</h:radio>
				  		<h:radio property="inv_vatcst" value="0" styleId="inv_vat"  onclick="alert(document.getElementById('inv_vat').value)">VAT</h:radio>
				  	</div>
				  	<br/>Discount: <h:radio property="inv_discount" value="discount" styleId="inv_discount">
				  	Deduction:</h:radio><h:radio property="inv_deduction" value="deduct" styleId="inv_deduction"></h:radio>
				  --%>
					<br/>Other Charges :  <h:text property="othercharges" styleId="othercharges" value="${editinvform[0].inv_courierchrgs }"> </h:text>  <br/>
					<br/>Total Amount :  <h:text property="inv_total" styleId="inv_total" value="${editinvform[0].inv_amount }"> </h:text>  <br/>
				</fieldset>	
			</td>
		</tr> 
        <tr>
	    <tr style="border: solid;"> 
 			<td colspan="4">
		    	  <h:submit property="invaction" value="Save"></h:submit>
		    	  <h:reset property="invaction" value="Clear"></h:reset>
			</td>  		
   		</tr>
	  </table>
	</h:form>
</body>
</h:html>