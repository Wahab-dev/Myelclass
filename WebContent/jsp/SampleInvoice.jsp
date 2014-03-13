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
</head>
<body>

<h:form action="/login" method="post" >
	<table style="border: thin;">
   		<tr>  			
   			<td>Welcome ${user.name}...</td> 	
   			<td><h:submit property="action" value="Logout"></h:submit></td> 
   		</tr>
   </table>
</h:form>

<h:form action="/savesampleinvoice" styleId="savesampleinvoice">
   
	<table border="1" style="border: solid; padding: 0px; border-spacing: 0px;">
	   <tr bordercolor="black"  >
   		  <td>
		    <fieldset>         
       		  <legend>Invoice Details</legend><br/> 
       			  Type: <h:select property ="saminv_invoicetype"  styleId="saminv_invoicetype" >
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
   	 					 <br/> Invoice No: <h:text property="saminv_invoiceno" styleId="saminv_invoiceno"></h:text><br/>
       					 <br/> Invoice Date:<h:text property="saminv_invdate" styleId="saminv_invdate" styleClass="dateclass"></h:text><br/>
       					 <br/> Exporters Ref. : <h:text property="saminv_expref" styleId="saminv_expref"> </h:text><br/>
						 <br/> Other ref :  <h:text property="saminv_otherref" styleId="saminv_otherref"> </h:text>  <br/>  
   			</fieldset>
		  </td>
   			  <td width="250">
   				  <fieldset>         
       				  <legend>Exporter Details</legend><br/> 
       					  Exporter: <h:text property="saminv_exporter" styleId="saminv_exporter"></h:text><br/>        
   	 					 <br/> Attn: <h:text property="saminv_exporterattn" styleId="saminv_exporterattn"></h:text><br/>
       					 <br/> Address: <h:textarea property="saminv_exporteraddress" cols="15" rows="1" styleId="saminv_exporteraddress"></h:textarea><br/>
       					 <br/> Telephone : <h:text property="saminv_exportertele" styleId="saminv_exportertele"> </h:text><br/>
						<br/> Fax :  <h:text property="saminv_exporterfax" styleId="saminv_exporterfax"> </h:text>  <br/>  
       			  </fieldset>
       		  </td>
   			  <td width="250">
   			  <div id="saminvnotify">
   				  <fieldset>         
       				  <legend>Notify Details</legend><br/> 
       					  Notify: <h:text property="saminv_notify" styleId="saminv_notify" ></h:text><br/>        
   	 					 <br/> Attn: <h:text property="saminv_notifyattn" styleId="saminv_notifyattn"></h:text><br/>
       					 <br/> Address:<h:textarea property="saminv_notifyaddress" cols="15" rows="1" styleId="saminv_notifyaddress"></h:textarea><br/>
       					<br/>  Phone : <h:text property="saminv_notifytele" styleId="saminv_notifytele"> </h:text><br/>
						 <br/> Fax :  <h:text property="saminv_notifyfax" styleId="saminv_notifyfax"> </h:text>  <br/>  
       			  </fieldset>
       			  </div>
   			  </td>
   			  <td width="250" >
   			    <div id="saminvbuyer">
   				  <fieldset>         
       				  <legend>Buyer Details</legend>
   						  Buyer Name: <h:text property="saminv_buyer" styleId="saminv_buyer"></h:text><br/>
       					  <br/>Attn: 	   <h:text property="saminv_buyerattn" styleId="saminv_buyerattn"></h:text><br/> 
						  <br/> Address:   <h:textarea property="saminv_buyeraddr" cols="15" rows="1" styleId="saminv_buyeraddr"></h:textarea><br/>
   	 					  <br/>Telephone: <h:text property="saminv_buyertele" styleId="saminv_buyertele"></h:text><br/>
       					  <br/>Fax:	   <h:text property="saminv_buyerfax" styleId="saminv_buyerfax"></h:text><br/>
       					  <br/>ID:	   <h:text property="saminv_buyerid" styleId="saminv_buyerid"></h:text><br/>      					
				  </fieldset>  
				</div>
			  </td> 
		  </tr>
		  <tr style="border: solid;">
   			  <td>
				<div id="saminvbank">
   				  <fieldset>         
       				  <legend>Bank Details</legend><br/> 
       					  Bank: <h:text property="saminv_bank" styleId="saminv_bank"></h:text><br/>        
   	 					  <br/>Branch: <h:text property="saminv_bankbranch" styleId="saminv_bankbranch"></h:text><br/>
       					  <br/>Addr:<h:textarea property="saminv_bankaddress" cols="15" rows="1" styleId="saminv_bankaddress" style="align:center"></h:textarea><br/>
       					  <br/>Swift Code: <h:text property="saminv_bankswiftcode" styleId="saminv_bankswiftcode"> </h:text><br/>
       					  <br/>Acct No : <h:text property="saminv_bankacno" styleId="saminv_bankacno"> </h:text><br/>
       					  <br/>Phone : <h:text property="saminv_banktele" styleId="saminv_banktele"> </h:text><br/>
						  <br/>fax :  <h:text property="saminv_bankfax" styleId="saminv_bankfax"> </h:text>  <br/>  
       			  </fieldset>
       			</div>
       		  </td>
   			  <td>
   			      <fieldset>         
       				  <legend>Dispatch Details</legend><br/> 
       					  COG: <h:text value="India" property="saminv_ctryoforigngoods" styleId="saminv_ctryoforigngoods" ></h:text><br/>
       					  <br/>LoadingPort: <h:text value="Chennai" property="saminv_loadingport" styleId="saminv_loadingport" ></h:text><br/> 
						  <br/>COF: <h:text property="saminv_ctryoffinaldesti" styleId="saminv_ctryoffinaldesti" ></h:text><br/> 
   	 					  <br/>Destination: <h:text property="saminv_finaldesti" styleId="saminv_finaldesti" styleClass="autocmplet"></h:text><br/>
       					  <br/>Dischargeport: <h:text property="saminv_dischargeport" styleId="saminv_dischargeport" styleClass="autocmplet"></h:text><br/> 
       					  <br/>Vessel No  : <h:text property="saminv_vesselno" styleId="saminv_vesselno" ></h:text><br/>      
       					  <br/>AW/Bill Date: <h:text property="saminv_awbilldate" styleId="saminv_awbilldate" styleClass="dateclass"> </h:text><br/>
						  <br/>AW/Bill No :  <h:text property="saminv_awbillno" styleId="saminv_awbillno"> </h:text>  <br/>  
       			  </fieldset>    				  			
   			  </td>
   			  <td width="250">
   				  <fieldset>         
       				  <legend>Other Details</legend><br/> 
       				  	  Pre Carriage By: <h:text property="saminv_precarriageby" styleId="saminv_precarriageby"></h:text><br/>
       					  Place of Reciept: <br/>Dimension: <h:text property="saminv_precarriageby" styleId="saminv_precarriageby" onchange="loadtanvalue();"></h:text><br/> 						
   						  Gross Wt: <h:text property="saminv_grosswt" styleId="saminv_grosswt"></h:text><br/>
       					  <br/>Dimension: <h:text property="saminv_dimension" styleId="saminv_dimension" onchange="loadtanvalue();"></h:text><br/> 
						  <br/> Marks: <h:text property="saminv_marksno" styleId="saminv_marksno"></h:text><br/>
   	 					  <br/> No Of packages: <h:text property="saminv_noofpackages" styleId="saminv_noofpackages"></h:text><br/>
       					  <br/>Pack No:<h:text property="saminv_packno" styleId="saminv_packno"></h:text><br/>
       					  <br/>Net Wt: <h:text property="saminv_netwt" styleId="saminv_netwt"></h:text><br/> 
				  </fieldset>  
			</td>
			<td width="250"> 
			 	<fieldset>         
       				<legend>Other Charges</legend>
				  	Courier Discount: <h:text property="saminv_courierchrgs" styleId="saminv_courierchrgs"> </h:text>
				  	<div id="localsalesradio">	
				  		<br/><h:radio property="saminv_vatcst" value="2" styleId="saminv_cst" onclick="alert(document.getElementById('saminv_cst').value)">CST</h:radio>
				  		<h:radio property="saminv_vatcst" value="5" styleId="saminv_vat" onclick="alert(document.getElementById('saminv_vat').value)">VAT</h:radio>
				  		<%-- <h:radio property="saminv_vatcst" value="0" styleId="inv_vat"  onclick="alert(document.getElementById('inv_vat').value)">VAT</h:radio> --%>
				  	</div>
				  	<%-- <br/>Discount: <h:radio property="inv_discount" value="discount" styleId="inv_discount">
				  	Deduction:</h:radio><h:radio property="inv_deduction" value="deduct" styleId="inv_deduction"></h:radio> --%>
				 
					<br/>Other Charges :  <h:text property="saminv_courierchrgs" styleId="saminv_courierchrgs"> </h:text>  <br/>
					<br/>Total Amount :  <h:text property="saminv_total" styleId="saminv_total"> </h:text>  <br/>
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
   					 <br/>Customer Name: <h:text property="saminv_customer" styleId="saminv_customer"></h:text><br/>
       				 <br/>Attn: 	<h:text property="saminv_custattn" styleId="saminv_custattn"></h:text><br/> 
					 <br/> Address: <h:textarea property="saminv_custaddr" cols="15" rows="1" styleId="saminv_custaddr"></h:textarea><br/>
   	 				 <br/>Telephone:<h:text property="saminv_custtele" styleId="saminv_custtele"></h:text><br/>
       				 <br/>Fax:	    <h:text property="saminv_custfax" styleId="saminv_custfax"></h:text><br/>
       				 <br/>ID:	    <h:text property="saminv_custid" styleId="saminv_custid"></h:text><br/>	
       					
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