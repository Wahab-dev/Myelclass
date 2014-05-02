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
<link rel="stylesheet" type="text/css" media="screen" href="css/jquerywidgetstyle.css" />

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
<div>
<h:form action="/Debit" focus="debitno" method="post" onreset=""> 	
			<td >Welcome <h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text></td >
   			<td><h:text property="debactionform" styleId="debactionform" value="${debactionform}" readonly="true" ></h:text></td>
   			<td><h:submit property="debitaction" value="Logout"></h:submit></td> 
	<table style="border-width: medium; border-style: solid;"> 
    	<tr>
		    <td>
		    	<fieldset>         
        		<legend>Tannery Details</legend> 
        		  <table>
        			<tr>
        				<td>Tanner  :</td>
        				<td><h:text property="deb_exporter" size="41" styleId="deb_exporter" value="${editdebform[0].deb_exporter}"></h:text></td>
        			</tr>
        			<tr>
        				<td>Address: </td>
        				<td><h:textarea property="deb_tanaddr" cols="35" rows="4"  styleId="deb_tanaddr"></h:textarea></td>
        			</tr>
        			<tr>
        				<td>Telephone : </td>
        				<td><h:text property="deb_tantelephone" size="41" styleId="deb_tantelephone"> </h:text></td>
        			</tr>
        		</table>
      		 </fieldset>
		    </td>
		    <td>
		      <fieldset>  
		      <legend>Debit Details</legend> 
		    	<table>
		    		<tr>
        				<td>Debit No: </td>
        				<td><h:text property="deb_debitno" size="41" styleId="deb_debitno" value="${editdebform[0].deb_debitno}"></h:text></td>
        			</tr>
		    		<tr>
		    			<td>Debit Date:</td>
		    			<td><h:text property="deb_debitdate" size="41" styleId="deb_debitdate"  value="${editdebform[0].deb_debitdate }" styleClass="dtdebit"></h:text></td>
		    		</tr>
		    		<tr>
		    			<td>Tanner Invoice No:</td>
		    			<td><h:text property="deb_taninvno" size="41" styleId="deb_taninvno"  value="${editdebform[0].deb_taninvno}"></h:text></td>
		    		</tr>
		    		<tr>
		    			<td>elclass ref no : </td>
		    			<td><h:text property="deb_elclassrefno" size="41" styleId="deb_elclassrefno"  value="${editdebform[0].deb_elclassrefno}"></h:text></td>
		    		</tr>
		    	</table> 
      		  </fieldset>
			</td>
  		</tr>
  		<tr>
		   <td colspan="2">
            	<table id="tbl_debselInvDetails"></table>
             	<div id="deb_debpager"></div>
            </td>
	  	</tr>
	  	<tr>
		    <td>
		    <table>
		    	<tr>
	    			<td>Exchange Rate:</td>
	    			<td><h:text property="deb_exchangerate" size="41" styleId="deb_exchangerate" styleClass="evntxchngerate"  value="${editdebform[0].deb_exchangerate }"> </h:text></td>
		    	</tr>
		    	<tr>
	    			<td>Commission : </td>
	    			<td><h:text property="deb_commission" size="41" styleId="deb_commission"  value="${editdebform[0].deb_commission }"> </h:text></td>
		    	</tr>
		    	<tr>
	    			<td>Rate:</td>
	    			<td><h:text property="deb_rate" size="41" styleId="deb_rate"  value="${editdebform[0].deb_rate }"> </h:text></td>
		    	</tr>
		    	<tr>
	    			<td>Quantity : </td>
	    			<td><h:text property="deb_totalquantity" size="41" styleId="deb_totalquantity"  value="${editdebform[0].deb_qshipped }"> </h:text></td>
		    	</tr>
		    	<tr>
	    			<td>Invoice Amount:</td>
	    			<td><h:text property="deb_invoiceamt" size="41" styleId="deb_invoiceamt"  value="${editdebform[0].deb_invoiceamt }"> </h:text></td>
		    	</tr>
		    	<tr>
	    			<td>el class Amount : </td>
	    			<td> <h:text property="deb_elclassamt" size="41" styleId="deb_elclassamt"  value="${editdebform[0].deb_elclassamt }"> </h:text> </td>
		    	</tr>
		    	<tr>
	    			<td></td>
	    			<td><input type="hidden" id="deb_tc" size="41" placeholder="tc values" ></input></td>
		    	</tr>
		    </table>
      		</td>
		    <td>
		    <table>
		    	<tr>
		    		<td></td>
		    		<td> <input type="hidden" id="deb_ctno" size="41" placeholder="ct no" ></input></td>
		    	</tr>
		    	<tr>
		    		<td>Commission in INR:</td>
		    		<td><h:text property="deb_elclassamtinrs"  size="41" value="${editdebform[0].deb_elclassamtinrs }" styleId="deb_elclassamtinrs"> </h:text></td>
		    	</tr>
		    	<tr>
		    		<td>Tax @ 12.36% : </td>
		    		<td><h:text property="deb_tax" styleId="deb_tax" size="41" value="${editdebform[0].deb_tax }"> </h:text></td>
		    	</tr>
		    	<tr>
		    		<td>Total:</td>
		    		<td><h:text property="deb_total" styleId="deb_total" size="41" value="${editdebform[0].deb_total }"> </h:text></td>
		    	</tr>
		    	<tr>
		    		<td>TDS : </td>
		    		<td> <h:text property="deb_tds" styleId="deb_tds" size="41" value="${editdebform[0].deb_tds }"> </h:text>  </td>
		    	</tr>
		    	<tr>
		    		<td>Total Due: </td>
		    		<td><h:text property="deb_due" styleId="deb_due" size="41" value="${editdebform[0].deb_due }"> </h:text></td>
		    	</tr>
		    </table>
			</td>
	  	</tr>
	  	<tr>
		    <td>
		    	<h:submit property="debitaction" value="Save" styleId="Btndebitsave" styleClass="myPrintButton" ></h:submit>
		    	<input type="button" disabled="disabled" id="tcbutton" value="TC Button" ></input> </td>
   			<td>
   				<h:reset property="debitaction" value="Clear" styleClass="myPrintButton" ></h:reset>
   			    <h:submit property="debitaction" value="Print" styleId="Btndebitsave" styleClass="myPrintButton" ></h:submit></td>
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
        					Tcdebit No: <h:text property="tcdeb_tcdebitno" styleId="tcdeb_tcdebitno" ></h:text><br/>
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
</div>
</body>
</html>