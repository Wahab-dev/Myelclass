<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
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
<script src="js/elpro/debit.js"></script> 		
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

<h:form action="/Debit" focus="debitno" method="post" onreset=""> 	
			<td >Welcome <h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text></td >
   			<td><h:text property="debactionform" styleId="debactionform" value="${debactionform}" readonly="true" ></h:text></td>
   			<td><h:submit property="debitaction" value="Logout"></h:submit></td> 
	<table style="border-width: medium; border-style: solid;"> 
    	<tr>
		    <td>
		    	<fieldset>         
        				<legend>Debit Details</legend> 
        					Debit No: <h:text property="deb_debitno" styleId="deb_debitno" value="${editdebform[0].deb_debitno}"></h:text><br/>
        					<br/>Tanner  : <h:text property="deb_exporter" styleId="deb_exporter" value="${editdebform[0].deb_exporter}"></h:text><br/>        	 					
         					<br/>Address: <h:textarea property="deb_tanaddr" cols="30" rows="2" styleId="deb_tanaddr"></h:textarea><br/>
        					<br/>Telephone : <h:text property="deb_tantelephone" styleId="deb_tantelephone"> </h:text><br/>
							
      		 </fieldset>
		    </td>
		    <td>
		    	<fieldset>   
        					<br/>Debit Date: <h:text property="deb_debitdate" styleId="deb_debitdate"  value="${editdebform[0].deb_debitdate }" styleClass="dtdebit"></h:text><br/>
        					<br/>Tanner Invoice No: <h:text property="deb_taninvno" styleId="deb_taninvno"  value="${editdebform[0].deb_taninvno}"></h:text><br/>              	 					
         					<br/>elclass ref no : <h:text property="deb_elclassrefno" styleId="deb_elclassrefno"  value="${editdebform[0].deb_elclassrefno}"></h:text><br/>
        					
      			 </fieldset>
			</td>
  		</tr>
  		<tr>
	  		<td>&nbsp;</td>
	  		<td>&nbsp;</td>
	  	</tr>
  		<tr>
		   <td colspan="2">
            		 <table id="tbl_debselInvDetails"></table>
             		<div id="deb_debpager"></div>
              	</td>
              	<td>
              	</td>
	  	</tr>
	  	<tr>
		    <td>
		    	<br/>Exchange Rate: <h:text property="deb_exchangerate" styleId="deb_exchangerate" styleClass="evntxchngerate"  value="${editdebform[0].deb_exchangerate }"> </h:text><br/>
				<br/>Commission :  <h:text property="deb_commission" styleId="deb_commission"  value="${editdebform[0].deb_commission }"> </h:text>  <br/>  
				<br/>Rate: <h:text property="deb_rate" styleId="deb_rate"  value="${editdebform[0].deb_rate }"> </h:text><br/>
				<br/>Quantity :  <h:text property="deb_totalquantity" styleId="deb_totalquantity"  value="${editdebform[0].deb_qshipped }"> </h:text>  <br/>  
				<br/>Invoice Amount: <h:text property="deb_invoiceamt" styleId="deb_invoiceamt"  value="${editdebform[0].deb_invoiceamt }"> </h:text><br/>
				<br/>el class Amount :  <h:text property="deb_elclassamt" styleId="deb_elclassamt"  value="${editdebform[0].deb_elclassamt }"> </h:text>  <br/>  
				<br/> <input type="hidden" id="deb_tc" placeholder="tc values" ></input>
				
      		</td>
		    <td>
		    	<br/> <input type="hidden" id="deb_ctno" placeholder="ct no" ></input>
		    	<br/>Commission in INR: <h:text property="deb_elclassamtinrs"  value="${editdebform[0].deb_elclassamtinrs }" styleId="deb_elclassamtinrs"> </h:text><br/>
				<br/>Tax @ 12.36% :  <h:text property="deb_tax" styleId="deb_tax"  value="${editdebform[0].deb_tax }"> </h:text>  <br/>  
				<br/>Total: <h:text property="deb_total" styleId="deb_total"  value="${editdebform[0].deb_total }"> </h:text><br/>
				<br/>TDS :  <h:text property="deb_tds" styleId="deb_tds"  value="${editdebform[0].deb_tds }"> </h:text>  <br/>  
				<br/>Total Due: <h:text property="deb_due" styleId="deb_due"  value="${editdebform[0].deb_due }"> </h:text><br/>
			</td>
		   
	  	</tr>
	  	<tr>
	  		<td>&nbsp;</td>
	  		<td>&nbsp;</td>	
	  	</tr>
	  	
	  	<tr>
		    <td><h:submit property="debitaction" value="Save" styleId="Btndebitsave"></h:submit>
		    <input type="button" disabled="disabled" id="tcbutton" value="TC Button"></input> </td>
   			<td><h:reset property="debitaction" value="Clear"></h:reset></td> 
  		</tr>
	</table>
	
	
<!-- TC DEBIT NOTE  Dialog  -->	
	<div id="tcdebit" title="TC Debit Note" class="tcform">
 		<h:form styleId="tcdebitform" action="/Debit.do" method="POST" onreset=""> 
 			<table style="border-width: medium;">
    			<tr>
		   	 		<td>
		    			<fieldset>         
        				<legend></legend> 
        					Tcdebit No: <h:text property="tcdeb_tcdebitno" styleId="tcdeb_tcdebitno"></h:text><br/>
        					<br/>Tanner  : <h:text property="tcdeb_exporter" styleId="tcdeb_exporter" ></h:text><br/>        	 					
         					<br/>Address: <h:textarea property="tcdeb_tanaddr" cols="30" rows="2" styleId="tcdeb_tanaddr"></h:textarea><br/>
        					<br/>Telephone : <h:text property="tcdeb_tantelephone" styleId="tcdeb_tantelephone"> </h:text><br/>
							
      		  			</fieldset>
		    		</td>
		    		<td>
		    		<fieldset>  
		    			<legend></legend> 
        					<br/>TcDebit Date: <h:text property="tcdeb_tcdebitdate" styleId="tcdeb_tcdebitdate" styleClass="dtdebit"></h:text><br/>
        					<br/>Tanner Invoice No: <h:text property="tcdeb_taninvno" styleId="tcdeb_taninvno" ></h:text><br/>              	 					
         					<br/>elclass ref no : <h:text property="tcdeb_elclassrefno" styleId="tcdeb_elclassrefno" ></h:text><br/>
         					<br/>Exchange Rate: <h:text property="tcdeb_exchangerate" styleId="tcdeb_exchangerate" > </h:text><br/>
        			</fieldset>		
					</td>
  			    </tr>
	  			<tr>
		    		<td>
				    	
						<br/>TC :  <h:text property="tcdeb_tcamt" styleId="tcdeb_tcamt"> </h:text>  <br/>  
						<br/>Rate: <h:text property="tcdeb_rate" styleId="tcdeb_rate"> </h:text><br/>
					</td>
		    		<td>
		    			<br/>Quantity :  <h:text property="tcdeb_totalquantity" styleId="tcdeb_totalquantity"> </h:text>  <br/>
				    	<br/>TC Amount in Rs: <h:text property="tcdeb_elclassamtinrs" styleId="tcdeb_elclassamtinrs"> </h:text><br/>
					</td>
				</tr>
				<%-- <tr>
					<td><h:submit property="debitaction" value="TcSave" styleId="Btndebitsave"></h:submit>
					    <input type="button" disabled="disabled" id="tcbutton" value="TC Button"></input> </td>
			   		<td><h:reset property="debitaction" value="Clear"></h:reset></td> 
  				</tr> --%>
	  		
		</table>
 	</h:form>
 	
 </div>
 
 
</h:form>
</body>
</html>