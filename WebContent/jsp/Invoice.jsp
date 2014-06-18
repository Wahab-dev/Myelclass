<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
  
<!DOCTYPE html>
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Invoice Page </title>
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 
</style>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/redmond/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/jquerywidgetstyle.css" />
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

<h:form action="/saveinvoice" styleId="saveinvoice">
	<table>
   		<tr>  
  			 <td>Welcome <h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text></td> 	
   			<td><h:text property="invactionform" styleId="invactionform" value="${invactionform}" readonly="true" ></h:text></td>
   			<td><h:submit property="invaction" value="Logout"></h:submit></td>
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
       		  		<td><h:select property ="inv_invoicetype"  styleId="inv_invoicetype" value="${editinvform[0].inv_invoicetype }">
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
       		    	</td>
       		  	</tr>
       		  	<tr>
       		  		<td>Invoice No: </td>
       		  		<td><h:text property="inv_invoiceno" size="19" styleId="inv_invoiceno" value="${editinvform[0].inv_invoiceno }"></h:text><br/></td>
       		  	</tr>
       		  	<tr>
       		  		<td>Invoice Date:</td>
       		  		<td><h:text property="inv_invdate" styleId="inv_invdate" styleClass="dateclass" value="${editinvform[0].inv_invdate }"></h:text><br/></td>
       		  	</tr>
       		  	<tr>
       		  		<td>Exporters Ref. : </td>
       		  		<td><h:text property="inv_expref" styleId="inv_expref" size="19" value="${editinvform[0].inv_expref }"> </h:text><br/></td>
       		  	</tr>
       		  	<tr>
       		  		<td>Other ref :  </td>
       		  		<td><h:textarea property="inv_otherref" styleId="inv_otherref" cols="14"  rows="2" value="${editinvform[0].inv_otherref }"> </h:textarea>  <br/></td>
       		  	</tr>
       		  	<tr>
       	    		<td>Terms :</td>
       	    		<td><h:text property="inv_terms" size="19" styleId="inv_terms" value="${editinvform[0].inv_terms }"> </h:text>  <br/></td>
       	    	</tr>
       	    	<tr>
       	    		<td>Payment :</td>
       	    		<td><h:text property="inv_payment" size="19" styleId="inv_payment" value="${editinvform[0].inv_payment }"> </h:text>  <br/></td>
       	    	</tr>
       		  </table>
   			</fieldset>
		  </td>
   	 	  <td>
   			<fieldset>         
       	    <legend>Exporter Details</legend>
				<table>
					<tr>
						<td> Name: </td>
						<td><h:text property="inv_exporter" styleId="inv_exporter" size="41" value="${editinvform[0].inv_exporter }"></h:text><br/></td>
					</tr>
					<tr>	
						<td><h:hidden property="inv_exporterid" styleId="inv_exporterid" value="${editinvform[0].inv_exporterid }"></h:hidden><br/></td>
					</tr>
					
					<tr>
						<td>Attn: </td>
						<td><h:text property="inv_exporterattn" size="41" styleId="inv_exporterattn" value="${editinvform[0].inv_exporterattn }"></h:text><br/></td>
					</tr>
					<tr>
						<td>Addr: </td>
						<td><h:textarea property="inv_exporteraddress" cols="30" rows="4" styleId="inv_exporteraddress" value="${editinvform[0].inv_exporteraddress }"></h:textarea><br/></td>
					</tr>
					<tr>
						<td>Tele : </td>
						<td><h:text property="inv_exportertele" size="41" styleId="inv_exportertele" value="${editinvform[0].inv_exportertele }"> </h:text><br/></td>
					</tr>
					<tr>
						<td> Fax : </td>
						<td> <h:text property="inv_exporterfax" size="41" styleId="inv_exporterfax" value="${editinvform[0].inv_exporterfax }"> </h:text>  <br/></td>
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
       	    			<td> Name: </td>
       	    			<td><h:text property="inv_notify" size="41" styleId="inv_notify" value="${editinvform[0].inv_notify }"></h:text><br/></td>
       	    		</tr>
       	    		<tr>
       	    			<td><h:hidden property="inv_notifyid" styleId="inv_notifyid" value="${editinvform[0].inv_notifyid }"></h:hidden><br/></td>
       	    		</tr>
       	    		<tr>
       	    			<td>Attn: </td>
       	    			<td><h:text property="inv_notifyattn" size="41" styleId="inv_notifyattn" value="${editinvform[0].inv_notifyattn }"></h:text><br/></td>
       	    		</tr>
       	    		<tr>
       	    			<td>Addr:</td>
       	    			<td><h:textarea property="inv_notifyaddress" cols="30" rows="4" styleId="inv_notifyaddress" value="${editinvform[0].inv_notifyaddress }"></h:textarea><br/></td>
       	    		</tr>
       	    		<tr>
       	    			<td>Tele :</td>
       	    			<td><h:text property="inv_notifytele" size="41" styleId="inv_notifytele" value="${editinvform[0].inv_notifytele }"></h:text></tr>
       	    		<tr>
       	    			<td>Fax :</td>
       	    			<td><h:text property="inv_notifyfax" size="41" styleId="inv_notifyfax" value="${editinvform[0].inv_notifyfax }"> </h:text>  <br/></td>
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
						<td> Bank: </td>
						<td><h:text property="inv_bank" size="41" styleId="inv_bank" value="${editinvform[0].inv_bank }"></h:text><br/></td>
					</tr>
					<tr>
						<td><h:hidden property="inv_bankid" styleId="inv_bankid" value="${editinvform[0].inv_bankid }"></h:hidden><br/></td>
					</tr>
					<tr>
						<td>Branch: </td>
						<td><h:text property="inv_bankbranch" size="41"  styleId="inv_bankbranch" value="${editinvform[0].inv_bankbranch }"></h:text><br/></td>
					</tr>
					<tr>
						<td>Addr:</td>
						<td><h:textarea property="inv_bankaddress" cols="30" rows="4" styleId="inv_bankaddress" style="align:center" value="${editinvform[0].inv_bankaddress }"></h:textarea><br/></td>
					</tr>
					<tr>
						<td>Swift Code: </td>
						<td><h:text property="inv_bankswiftcode" size="41" styleId="inv_bankswiftcode" value="${editinvform[0].inv_bankswiftcode }"> </h:text><br/></td>
					</tr>
					<tr>
						<td>Phone : </td>
						<td><h:text property="inv_banktele" size="41" styleId="inv_banktele" > </h:text><br/></td>
					</tr>
					<tr>
						<td>fax :  </td>
						<td><h:text property="inv_bankfax" size="41" styleId="inv_bankfax" > </h:text>  <br/></td>
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
       				  		<td> <h:text property="inv_ctryoforigngoods" size="25" styleId="inv_ctryoforigngoods" value="${editinvform[0].inv_ctryoforigngoods }"></h:text><br/></td>
       				  	</tr>
       				  	<tr>
       				  		<td>LoadingPort: </td>
       				  		<td><h:text property="inv_loadingport" size="25" styleId="inv_loadingport" value="${editinvform[0].inv_loadingport }"></h:text><br/></td>
       				  	</tr>
       				  	<tr>
       				  		<td>Country-Destn: </td>
       				  		<td><h:text property="inv_ctryoffinaldesti" size="25" styleId="inv_ctryoffinaldesti" value="${editinvform[0].inv_ctryoffinaldesti }"></h:text><br/></td>
       				  	</tr>
       				  	<tr>
       				  		<td>Destn: </td>
       				  		<td><h:text property="inv_finaldesti" size="25" styleId="inv_finaldesti" styleClass="autocmplet" value="${editinvform[0].inv_finaldesti }"></h:text><br/></td>
       				  	</tr>
       				  	<tr>
       				  		<td>Port: </td>
       				  		<td><h:text property="inv_dischargeport" size="25" styleId="inv_dischargeport" styleClass="autocmplet" value="${editinvform[0].inv_dischargeport }"></h:text><br/></td>
       				  	</tr>
       				  	<tr>
       				  		<td>Vessel No  : </td>
       				  		<td><h:text property="inv_vesselno" size="25" styleId="inv_vesselno" value="${editinvform[0].inv_vesselno }"></h:text><br/></td>
       				  	</tr>
       				  	<tr>
       				  		<td>AW/Bill No :  </td>
       				  		<td><h:text property="inv_awbillno" size="25" styleId="inv_awbillno" value="${editinvform[0].inv_awbillno }"> </h:text>  <br/></td>
       				  	</tr>
       				  	<tr>
       				  		<td>AW/Bill Date:</td>
       				  		<td><h:text property="inv_awbilldate" styleId="inv_awbilldate" styleClass="dateclass" value="${editinvform[0].inv_awbilldate }"> </h:text><br/></td>
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
							<td><h:text property="inv_precarriageby" size="25" styleId="inv_precarriageby" value="${editinvform[0].inv_precarriageby }"></h:text><br/></td>
						</tr>
						<tr>
							<td>Place of Reciept: </td>
							<td> <h:text property="inv_placeofreciept" size="25" styleId="inv_placeofreciept" value="${editinvform[0].inv_placeofreciept }"></h:text><br/></td>
						</tr>
						<tr>
							<td>Dimension: </td>
							<td><h:text property="inv_dimension" size="25" styleId="inv_dimension" value="${editinvform[0].inv_dimension }"></h:text><br/></td>
						</tr>
						<tr>
							<td>Marks: </td>
							<td> <h:text property="inv_marksno" size="25" styleId="inv_marksno" value="${editinvform[0].inv_marksno }"></h:text><br/></td>
						</tr>
						<tr>
							<td>No Of packages: </td>
							<td><h:text property="inv_noofpackages" size="25" styleId="inv_noofpackages" value="${editinvform[0].inv_noofpackages }"></h:text><br/></td>
						</tr>
						<tr>
							<td>Pack No:</td>
							<td><h:text property="inv_packno" size="25" styleId="inv_packno" value="${editinvform[0].inv_packno }"></h:text><br/></td>
						</tr>
						<tr>
							<td> Gross Wt: </td>
							<td><h:text property="inv_grosswt" size="25" styleId="inv_grosswt" value="${editinvform[0].inv_grosswt }"></h:text><br/></td>
						</tr>
						<tr>
							<td>Net Wt: </td>
							<td><h:text property="inv_netwt" size="25" styleId="inv_netwt" value="${editinvform[0].inv_netwt }"></h:text><br/></td>
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
       			  		<td>Include Sample:</td>
       			  		<td><h:select property ="inv_includeSample"  styleId="inv_includeSample" > 
       				 			<h:option value="ct" >No</h:option>
       				 			<h:option value="sample" >yes</h:option>
       				 		</h:select><br/>
       				 	</td>
       			  	</tr>
       			  	<tr>
       			  		<td>Customer Name: </td>
       			  		<td><h:text property="inv_customer" size="41" styleId="inv_customer" value="${editinvform[0].inv_customer }"></h:text><br/></td>
       			  	</tr>
       			  	<tr>
       			  		<td>Attn: </td>
       			  		<td><h:text property="inv_custattn" size="41" styleId="inv_custattn" value="${editinvform[0].inv_custattn }"></h:text><br/></td>
       			  	</tr>
       			  	<tr>
       			  		<td>Address: </td>
       			  		<td><h:textarea property="inv_custaddr" cols="30" rows="4" styleId="inv_custaddr" value="${editinvform[0].inv_custaddr }"></h:textarea><br/></td>
       			  	</tr>
       			  	<tr>
       			  		<td>Telephone:</td>
       			  		<td><h:text property="inv_custtele" size="41" styleId="inv_custtele" value="${editinvform[0].inv_custtele }"></h:text><br/></td>
       			  	</tr>
       			  	<tr>
       			  		<td>Fax: </td>
       			  		<td><h:text property="inv_custfax" size="41" styleId="inv_custfax" value="${editinvform[0].inv_custfax }"></h:text><br/></td>
       			  	</tr>
       			  	<tr>
       			  		<td><h:hidden property="inv_custid" styleId="inv_custid" value="${editinvform[0].inv_custid }"></h:hidden><br/></td>
       			  	</tr>
       			  </table>
       			 </fieldset>
			</td>
   			<td colspan="2">
           	    <table id="tbl_invListCustomerContract" > </table>   
           		<div id="tbl_invpager"></div>     	 
           	</td>	      	  
		
		<tr>
		  <td colspan="3">
		     	<table id="tbl_invaddinvBill"></table>
		        <div id="tbl_invbillpager"></div>
		  </td>  
		</tr>
		
		<tr>
   			<td colspan="3"> 
				<table id="invBill"></table>
		      	<div id="invbillpager"></div>
			</td> 
		<tr>	   
			<td colspan="3"> 
				<fieldset>         
       				<legend>Other Charges</legend>
       				<table>
       					<tr>
       						<td>Deduction: </td>
       						<td><h:text property="inv_discount" size="15" styleId="inv_discount" value="${editinvform[0].inv_discount }"> </h:text></td>
       					</tr>
       					<tr>
       						<td>Courier Charges : </td>
       						<td> <h:text property="othercharges" size="15" styleId="othercharges" value="${editinvform[0].othercharges }"> </h:text>  <br/></td>
       					</tr>
       					<tr>
       						<td>Total Amount :  </td>
       						<td><h:text property="inv_total" size="15" styleId="inv_total" value="${editinvform[0].inv_total }"> </h:text>  <br/></td>
       					</tr>
       				</table>
				</fieldset>	
			</td>
		</tr> 
	    <tr> 
		   <td><h:submit property="invaction" value="Save" styleClass="myPrintButton"></h:submit></td>
		   <td><h:reset property="invaction" value="Clear" styleClass="myPrintButton"></h:reset></td>
		   <td><h:submit property="invaction" value="Print" styleClass="myPrintButton"></h:submit></td>  		
   		</tr>
	  </table>
	</h:form>
</body>
</h:html>