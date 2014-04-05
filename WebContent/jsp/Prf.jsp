<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="l"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PRF PAGE</title> 
<style type="text/css">
	
</style>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/jquery.dialogextend.1_0_1.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/pepper-grinder/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/jquerywidgetstyle.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>		
<script src="js/elpro/prf.js"></script> 
<script src="js/jquery.autosize.js"></script> 

<!-- <script>!window.jQuery && document.write('<script src="js/elpro/prf.js"><\/script>');</script>  -->
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
/*
//Maintain array of dates
var dates = new Array();
function addDate(date) {if (jQuery.inArray(date, dates) < 0) dates.push(date);}
function removeDate(index) {dates.splice(index, 1);}

// Adds a date if we don't have it yet, else remove it
function addOrRemoveDate(date)
{
  var index = jQuery.inArray(date, dates); 
  if (index >= 0)
    removeDate(index);
  else 
    addDate(date);
}

// Takes a 1-digit number and inserts a zero before it
function padNumber(number)
{
  var ret = new String(number);
  if (ret.length == 1)
    ret = "0" + ret;
  return ret;
} */


function loadvalues(){
	var actionform = "<c:out value='${actionform}' />";
	if(actionform == "edit"){
		var prfeditterms = "<c:out value='${editprfform[0].prf_terms}' />";
		alert(prfeditterms);
		var prfeditpayment = "<c:out value='${editprfform[0].prf_payment}' />";  
		var prfeditagentname = "<c:out value='${editprfform[0].prf_agentname}' />";
		var prfedittanname =  "<c:out value='${editprfform[0].prf_tanname}' />";
		var prfeditcustname =  "<c:out value='${editprfform[0].prf_custname}' />";
		var prfeditconsigname =  "<c:out value='${editprfform[0].prf_consigneename}' />";
		var prfeditnotifyname =  "<c:out value='${editprfform[0].prf_notifyname}' />";
		var prfeditbankname =  "<c:out value='${editprfform[0].prf_bankname}' />";
		
		$("#prf_tanname").val(prfedittanname); 
		$("#prf_custname").val(prfeditcustname); 
		$("#prf_consigneename").val(prfeditconsigname); 
		$("#prf_notifyname").val(prfeditnotifyname); 
		$("#prf_bankname").val(prfeditbankname); 
		if(prfedittanname != null){
			//Ajax Call for Address and Other Values 
			var url = "/Myelclass/PrfAutocomplete.do";
			$.getJSON(url, {term: prfedittanname, action:"tan"},  
				function(data) { 	
					//Data Gets Returned In JSON Format but Unable to SET in HTML
						/* var items = [];
						 $.each( data, function( key, val ) {
							alert("VA l"+items[val]);
						 }); */
					});			
			}
		$("#prf_terms option").filter(function() {//Set Terms Value
		    return $(this).text() == prfeditterms; 
		}).prop('selected', true);
		
		$("#prf_payment option").filter(function() {//Set Payment Value
		    return $(this).text() == prfeditpayment; 
		}).prop('selected', true);
		
		$("#prf_agentname option").filter(function() {//Set Agent Value
		    return $(this).text() == prfeditagentname; 
		}).prop('selected', true);
		
		//$("#Save").val("UpdatePrf");
	}

}  
</script>
</head>

<body onload="loadvalues();">
<!--  Login Form  -->
<div id="accordionwidth" style="width: 1100px">
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

<!-- <div id="prfform" title="PR Form"> -->
<h:form action="/Prf.do" method="post" styleId="savePrfForm" onreset="">
	   				<td >Welcome<h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text></td >
	   				<td ><h:text property="formaction" styleId="formaction" value="${actionform}"></h:text></td> 
	   				<td><h:submit property="prfaction" value="Logout"></h:submit></td> 
    <table border="1" cellspacing="0" cellpadding="0">
        <tr>
           <td>
           	<fieldset>
        	<legend>Contract Details</legend>    
        	<table>
        		<tr>
        			<td>Agent: </td>
        			<td><h:text property="prf_agentname" size="41" styleId="prf_agentname" value="${editprfform[0].prf_agentname}" ></h:text> <br /></td>
        		</tr>
        		<tr>
        			<td>Ct No:  </td>
        			<td><h:text property="prf_contractno" size="41" styleId="prf_contractno" value="${editprfctno}" /><br /></td>
        		</tr>
        		<tr>
        			<td>Date: </td>
        			<td>  <h:text property="prf_orderdate" size="41" styleId="prf_orderdate" value="${editprfform[0].prf_orderdate}"></h:text> <br /></td>
        		</tr>
        		<tr>
        			<td>PO Type: </td>
        			<td><h:select property="prf_poreftype"  styleId="prf_poreftype">             
        	    			 <h:option value="Email">Via Email</h:option>
        					 <h:option value="Phone">Via Call </h:option>
        					 <h:option value="Others">Others</h:option>	
        				   </h:select>
        		    </td>
        		</tr>
        		<tr>
        			<td>PO Ref: </td>
        			<td> <h:textarea property="prf_poref" cols="30" rows="2"  styleId="prf_poref" value="${editprfform[0].prf_poref}"></h:textarea></td>
        		</tr>
        	</table>   			 		  
   		    </fieldset>
           </td>
           <td >
            <fieldset>         
        	<legend>Tannery Details</legend>
        	<table>
        		<tr>
        			<td>Name: </td>
        			<td><h:text property="prf_tanname" size="41" styleId="prf_tanname" ></h:text><br /></td>
        		</tr>
        		<tr>
        			<td>Attn:</td>
        			<td><h:text property="prf_tanattn" size="41" styleId="prf_tanattn" ></h:text><br /></td>
        		</tr>
        		<tr>
        			<td>Addr:</td>
        			<td><h:textarea property="prf_tanaddr" cols="35" rows="4" styleId="prf_tanaddr" ></h:textarea><br /></td>
        		</tr>
        		<tr>
        			<td>Tele: </td>
        			<td><h:text property="prf_tanphone" size="41" styleId="prf_tanphone" > </h:text><br /></td>
        		</tr>
        		<tr>
        			<td>Fax :</td>
        			<td> <h:text property="prf_tanfax" size="41" styleId="prf_tanfax" > </h:text></td>
        		</tr>
        	</table>
            </fieldset>
           </td>
           <td>
            <fieldset>
       		<legend>Customer Details</legend>
       		<table>
       			<tr>
       				<td>Name:</td>
       				<td><h:text property="prf_custname" size="41" styleId="prf_custname" ></h:text><br /></td>
       			</tr>
       			<tr>
       				<td>Attn: </td>
       				<td><h:text property="prf_custattn" size="41" styleId="prf_custattn" ></h:text><br /></td>
       			</tr>
       			<tr>
       				<td>Addr:</td>
       				<td><h:textarea property="prf_custaddr" cols="35" rows="4" styleId="prf_custaddr" > </h:textarea><br /></td>
       			</tr>
       			<tr>
       				<td>Tele: </td>
       				<td><h:text property="prf_custphone" size="41" styleId="prf_custphone" > </h:text><br /></td>
       			</tr>
       			<tr>
       				<td>Fax :  </td>
       				<td><h:text property="prf_custfax" size="41" styleId="prf_custfax" > </h:text>  </td>
       			</tr>
       		</table>
      		</fieldset>
           </td>
        <tr>
          	<td colspan="3">
          			<b>Response:</b> <span id="rsperror" style="color:red"></span> <br/>
             <table id="list"></table> 
			 <div id="pager"></div> 
          	</td>
        </tr>
        <tr>
            <td>
            <fieldset>
            <legend>Delivery Details</legend>
            <table>
            	<tr>
            		<td>CDD : </td>
            		<td><h:text property="prf_cdd" size="41" styleId="prf_cdd" styleClass="prf_delivrydate" value="${editprfform[0].prf_cdd}"></h:text><br /></td>
            	</tr>
            	<tr>
            		<td>ADD :</td>
            		<td><h:text property="prf_add" size="41" styleId="prf_add" styleClass="prf_delivrydate" value="${editprfform[0].prf_add}"></h:text><br /></td>
            	</tr>
            	<tr>
            		<td>Desti:</td>
            		<td><h:text property="prf_destination" styleId="prf_destination"  value="${editprfform[0].prf_destination}"></h:text><br/></td>
            	</tr>
            	<tr>
            		<td>Terms: </td>
            		<td><h:select  property="prf_terms" styleId="prf_terms" value="${editprfform[0].prf_terms}">
       		 		   		<h:option value="0">select Terms</h:option>
          			    	 <c:forEach items="${termsarray}" var ="termsList">
          			      		<h:option value="${termsList.termname}">
          			      		<c:out value="${termsList.termname}"></c:out>
          			      		</h:option>  
          			    	 </c:forEach> 
       		 		  	  </h:select><br /></td>
            	</tr>
            	<tr>
            		<td>Payment:</td>
            		<td><h:select property="prf_payment" styleId="prf_payment" >
       		 				<h:option value="0">select Payment</h:option>
          					 <c:forEach items="${paymentarray}" var ="paymList">
          				 		 <h:option value="${paymList.paymentname}">
          			      		 <c:out value="${paymList.paymentname}"></c:out>
          				  	</h:option>        		
          				 	</c:forEach>
       	  	  		  	  </h:select><br /></td>
            	</tr>
            	<tr>
            		<td>Insurance: </td>
            		<td><h:select property="prf_insurance" styleId="prf_insurance" value=""> <br /> 
          	  			 	<h:option value="Consignee">By Consignee</h:option>     
          				 	<h:option value="Shipper">By Shipper</h:option>      			    													         															
       		 		  	 </h:select><br /></td>
            	</tr>	
            	<tr>
            		<td>elclass Comm:</td>
            		<td><h:text property="prf_elclasscommission" styleId="prf_elclasscommission" value="${editprfform[0].prf_elclasscommission}"></h:text><br /></td>
            	</tr>
            	<tr>
            		<td>Other Comm: </td>
            		<td>
            			<div id='TextBoxesGroup'>
						<div id="TextBoxDiv1">
            				<h:textarea property="prf_commission" cols="30" rows="2"  styleId="prf_commission" value="${editprfform[0].prf_commission}" ></h:textarea>
            		 	 </div> 	   
						</div>	
					</td>
            	</tr>
            </table>
      		</fieldset>
      		</td>
            <td>
      		<fieldset>
            <legend>Inspection Condition</legend>     
       	 		<h:textarea property="prf_inspcdn" cols="41" rows="17" styleId="prf_inspcdn" value="${editprfform[0].prf_inspcdn}"></h:textarea><br />									
         	</fieldset>
      		</td>
            <td>
            <fieldset>
            <legend>Special Condition</legend>
           		<h:textarea property="prf_special" cols="41" rows="17" styleId="prf_special" value="${editprfform[0].prf_special}"></h:textarea><br />        									
         	</fieldset></td>
        </tr>
        <tr>
           	<td>
           	<fieldset>
       		<legend>Consignee Details</legend>
       		<table>
       			<tr>
       				<td>Name:</td>
       				<td><h:text property="prf_consigneename" size="41" styleId="prf_consigneename" ></h:text></td>
       			</tr>
       			<tr>
       				<td>Attn: </td>
       				<td><h:text property="prf_consigneeattn" size="41" styleId="prf_consigneeattn" ></h:text></td>
       			</tr>
       			<tr>
       				<td>Addr: </td>
       				<td><h:textarea property="prf_consigneeaddr" cols="35" rows="4" styleId="prf_consigneeaddr" ></h:textarea></td>
       			</tr>
       			<tr>
       				<td>Tele:</td>
       				<td> <h:text property="prf_consigneephone" size="41" styleId="prf_consigneephone" > </h:text></td>
       			</tr>
       			<tr>
       				<td>Fax :</td>
       				<td> <h:text property="prf_consigneefax" size="41" styleId="prf_consigneefax" > </h:text></td>
       			</tr>
       		</table>
      		</fieldset>
            </td>
        	<td>
        	<fieldset>
	       		<legend>Notify Details</legend>
				<table>
	       			<tr>
	       				<td>Name:</td>
	       				<td> <h:text property="prf_notifyname" size="41" styleId="prf_notifyname" ></h:text></td>
	       			</tr>
	       			<tr>
	       				<td>Attn: </td>
	       				<td><h:text property="prf_notifyattn" size="41" styleId="prf_notifyattn" ></h:text></td>
	       			</tr>
	       			<tr>
	       				<td>Addr:</td>
	       				<td><h:textarea property="prf_notifyaddr" cols="35" rows="4" styleId="prf_notifyaddr" > </h:textarea></td>
	       			</tr>
	       			<tr>
	       				<td>Tele: </td>
	       				<td><h:text property="prf_notifyphone" size="41" styleId="prf_notifyphone" > </h:text></td>
	       			</tr>
	       			<tr>
	       				<td>Fax :</td>
	       				<td> <h:text property="prf_notifyfax" size="41" styleId="prf_notifyfax" > </h:text> </td>
	       			</tr>
	       		</table> 
      		</fieldset>
            </td>
            <td>
            <fieldset>
       		<legend>Bank Details</legend>
			 <table>
	       			<tr>
	       				<td>Name :</td>
	       				<td><h:text property="prf_bankname" size="41" styleId="prf_bankname" ></h:text></td>
	       			</tr>
	       			<tr>
	       				<td>Branch : </td>
	       				<td><h:text property="prf_bankbranch" size="41" styleId="prf_bankbranch" ></h:text></td>
	       			</tr>
	       			<tr>
	       				<td>Addr :</td>
	       				<td><h:textarea property="prf_bankaddr" cols="35" rows="4" styleId="prf_bankaddr" ></h:textarea></td>
	       			</tr>
	       			<tr>
	       				<td>Tele :</td>
	       				<td><h:text property="prf_bankphone" size="41" styleId="prf_bankphone" > </h:text></td>
	       			</tr>
	       			<tr>
	       				<td>Fax  :</td>
	       				<td><h:text property="prf_bankfax" size="41" styleId="prf_bankfax" > </h:text></td>
	       			</tr>
	       		 </table>  
      		</fieldset>
            </td>
       <!--  <tr>
            td>Running Since : <b:write name="datestarted" scope="application" format="MM/dd/yy"/> </td>
        </tr> -->
        <tr>
  			<td><h:submit  property="prfaction" styleId="Save" value="Save" styleClass="myPrintButton" ></h:submit></td>
  			<td><h:reset property="prfaction" styleId="Clear" value="Clear" styleClass="myPrintButton" ></h:reset></td>
  			<td><h:submit property="prfaction" styleId="Print" value="Print" styleClass="myPrintButton" ></h:submit></td>
        </tr>
    </table>
</h:form>			
<!-- </div> -->					
</body>
</h:html>