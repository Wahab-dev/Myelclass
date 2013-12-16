<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
  
<!DOCTYPE html>
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
/*  $(function() {
	$("#radio").buttonset();
});  */
</script>
</head>
<body>
<!--  Login Form  -->
<h:form action="/login" method="post" >
	<table style="border: thin;">
   		<tr>  			
   			<td>Welcome ${user.name}...</td> 	
   			<td><h:submit property="action" value="Logout"></h:submit></td> 
   		</tr>
   </table>
</h:form>
<h:form action="/saveinvoice" styleId="saveinvoice">
   
	<table border="1" style="border: solid; padding: 0px; border-spacing: 0px;">
	   <tr bordercolor="black"  >
   		  <td>
		    <fieldset>         
       		  <legend>Invoice Details</legend><br/> 
       			  Type: <h:select property ="inv_invoicetype"  styleId="inv_invoicetype" >
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
   	 					 <br/> Invoice No: <h:text property="inv_invoiceno" styleId="inv_invoiceno"></h:text><br/>
       					 <br/> Invoice Date:<h:text property="inv_invdate" styleId="inv_invdate" styleClass="dateclass"></h:text><br/>
       					 <br/> Exporters Ref. : <h:text property="inv_expref" styleId="inv_expref"> </h:text><br/>
						 <br/> Other ref :  <h:text property="inv_otherref" styleId="inv_otherref"> </h:text>  <br/>  
   			</fieldset>
		  </td>
   			  <td width="250">
   				  <fieldset>         
       				  <legend>Exporter Details</legend><br/> 
       					  Exporter: <h:text property="inv_exporter" styleId="inv_exporter"></h:text><br/>        
   	 					 <br/> Attn: <h:text property="inv_exporterattn" styleId="inv_exporterattn"></h:text><br/>
       					 <br/> Address: <h:textarea property="inv_exporteraddress" cols="15" rows="1" styleId="inv_exporteraddress"></h:textarea><br/>
       					 <br/> Telephone : <h:text property="inv_exportertele" styleId="inv_exportertele"> </h:text><br/>
						<br/> Fax :  <h:text property="inv_exporterfax" styleId="inv_exporterfax"> </h:text>  <br/>  
       			  </fieldset>
       		  </td>
   			  <td width="250">
   			  <div id="invnotify">
   				  <fieldset>         
       				  <legend>Notify Details</legend><br/> 
       					  Notify: <h:text property="inv_notify" styleId="inv_notify" ></h:text><br/>        
   	 					 <br/> Attn: <h:text property="inv_notifyattn" styleId="inv_notifyattn"></h:text><br/>
       					 <br/> Address:<h:textarea property="inv_notifyaddress" cols="15" rows="1" styleId="inv_notifyaddress"></h:textarea><br/>
       					<br/>  Phone : <h:text property="inv_notifytele" styleId="inv_notifytele"> </h:text><br/>
						 <br/> Fax :  <h:text property="inv_notifyfax" styleId="inv_notifyfax"> </h:text>  <br/>  
       			  </fieldset>
       			  </div>
   			  </td>
   			  <td width="250" >
   			    <div id="invbuyer">
   				  <fieldset>         
       				  <legend>Buyer Details</legend>
   						  Buyer Name: <h:text property="inv_buyer" styleId="inv_buyer"></h:text><br/>
       					  <br/>Attn: 	   <h:text property="inv_buyerattn" styleId="inv_buyerattn"></h:text><br/> 
						  <br/> Address:   <h:textarea property="inv_buyeraddr" cols="15" rows="1" styleId="inv_buyeraddr"></h:textarea><br/>
   	 					  <br/>Telephone: <h:text property="inv_buyertele" styleId="inv_buyertele"></h:text><br/>
       					  <br/>Fax:	   <h:text property="inv_buyerfax" styleId="inv_buyerfax"></h:text><br/>
       					  <br/>ID:	   <h:text property="inv_buyerid" styleId="inv_buyerid"></h:text><br/>      					
				  </fieldset>  
				</div>
			  </td> 
		  </tr>
		  <tr style="border: solid;">
   			  <td>
				<div id="invbank">
   				  <fieldset>         
       				  <legend>Bank Details</legend><br/> 
       					  Bank: <h:text property="inv_bank" styleId="inv_bank"></h:text><br/>        
   	 					  <br/>Branch: <h:text property="inv_bankbranch" styleId="inv_bankbranch"></h:text><br/>
       					  <br/>Addr:<h:textarea property="inv_bankaddress" cols="15" rows="1" styleId="inv_bankaddress" style="align:center"></h:textarea><br/>
       					  <br/>Swift Code: <h:text property="inv_bankswiftcode" styleId="inv_bankswiftcode"> </h:text><br/>
       					  <br/>Acct No : <h:text property="inv_bankacno" styleId="inv_bankacno"> </h:text><br/>
       					  <br/>Phone : <h:text property="inv_banktele" styleId="inv_banktele"> </h:text><br/>
						  <br/>fax :  <h:text property="inv_bankfax" styleId="inv_bankfax"> </h:text>  <br/>  
       			  </fieldset>
       			</div>
       		  </td>
   			  <td>
   			      <fieldset>         
       				  <legend>Dispatch Details</legend><br/> 
       					  COG: <h:text value="India" property="inv_ctryoforigngoods" styleId="inv_ctryoforigngoods" ></h:text><br/>
       					  <br/>LoadingPort: <h:text value="Chennai" property="inv_loadingport" styleId="inv_loadingport" ></h:text><br/> 
						  <br/>COF: <h:text property="inv_ctryoffinaldesti" styleId="inv_ctryoffinaldesti" ></h:text><br/> 
   	 					  <br/>Destination: <h:text property="inv_finaldesti" styleId="inv_finaldesti" styleClass="autocmplet"></h:text><br/>
       					  <br/>Dischargeport: <h:text property="inv_dischargeport" styleId="inv_dischargeport" styleClass="autocmplet"></h:text><br/> 
       					  <br/>Vessel No  : <h:text property="inv_vesselno" styleId="inv_vesselno" ></h:text><br/>      
       					  <br/>AW/Bill Date: <h:text property="inv_awbilldate" styleId="inv_awbilldate" styleClass="dateclass"> </h:text><br/>
						  <br/>AW/Bill No :  <h:text property="inv_awbillno" styleId="inv_awbillno"> </h:text>  <br/>  
       			  </fieldset>    				  			
   			  </td>
   			  <td width="250">
   				  <fieldset>         
       				  <legend>Other Details</legend><br/> 
       				  	  Pre Carriage By: <h:text property="inv_precarriageby" styleId="inv_precarriageby"></h:text><br/>
       					  Place of Reciept: <br/>Dimension: <h:text property="inv_precarriageby" styleId="inv_precarriageby" onchange="loadtanvalue();"></h:text><br/> 						
   						  Gross Wt: <h:text property="inv_grosswt" styleId="inv_grosswt"></h:text><br/>
       					  <br/>Dimension: <h:text property="inv_dimension" styleId="inv_dimension" onchange="loadtanvalue();"></h:text><br/> 
						  <br/> Marks: <h:text property="inv_marksno" styleId="inv_marksno"></h:text><br/>
   	 					  <br/> No Of packages: <h:text property="inv_noofpackages" styleId="inv_noofpackages"></h:text><br/>
       					  <br/>Pack No:<h:text property="inv_packno" styleId="inv_packno"></h:text><br/>
       					  <br/>Net Wt: <h:text property="inv_netwt" styleId="inv_netwt"></h:text><br/> 
				  </fieldset>  
			</td>
			<td width="250"> 
			 	<fieldset>         
       				<legend>Other Charges</legend>
				  	Courier Discount: <h:text property="inv_courierchrgs" styleId="inv_courierchrgs"> </h:text>
				  	<div id="radio">	
				  		<br/><h:radio property="inv_vatcst" value="2" styleId="inv_vatcst">CST</h:radio>
				  		<h:radio property="inv_vatcst" value="5" styleId="inv_vatcst">VAT</h:radio>
				  	</div>
				  	<%-- <br/>Discount: <h:radio property="inv_discount" value="discount" styleId="inv_discount">
				  	Deduction:</h:radio><h:radio property="inv_deduction" value="deduct" styleId="inv_deduction"></h:radio> --%>
				 
					<br/>Other Charges :  <h:text property="inv_courierchrgs" styleId="inv_courierchrgs"> </h:text>  <br/>
					<br/>Total Amount :  <h:text property="inv_total" styleId="inv_total"> </h:text>  <br/>
				</fieldset>
			</td>
		</tr>
		<tr style="border: solid;">		  
		    <td width="250">
			   <fieldset>         
       			  <legend>Customer Details</legend>
   					 Customer Name: <h:text property="inv_customer" styleId="inv_customer"></h:text><br/>
       				 <br/>Attn: 	<h:text property="inv_custattn" styleId="inv_custattn"></h:text><br/> 
					 <br/> Address: <h:textarea property="inv_custaddr" cols="15" rows="1" styleId="inv_custaddr"></h:textarea><br/>
   	 				 <br/>Telephone:<h:text property="inv_custtele" styleId="inv_custtele"></h:text><br/>
       				 <br/>Fax:	    <h:text property="inv_custfax" styleId="inv_custfax"></h:text><br/>
       				 <br/>ID:	    <h:text property="inv_custid" styleId="inv_custid"></h:text><br/>	
			   </fieldset>
			</td>
   			<td colspan="3">
           	    <table id="tbl_invListCustomerContract" > </table>   
           		<div id="tbl_invpager"></div>            	 
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
	    <tr style="border: solid;"> 
 			<td colspan="4">
		    	  <h:submit property="action" value="Save"></h:submit>
		    	  <h:reset property="action" value="Clear"></h:reset>
			</td>  		
   		</tr>
	  </table>
	</h:form>
</body>
</h:html>