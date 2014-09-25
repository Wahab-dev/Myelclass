<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean-el" prefix="b"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sample Request Form</title>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/redmond/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/jquerywidgetstyle.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" href="css/elpro/Srf.css" />
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>		
<script src="js/elpro/srf.js"></script> 
<script src="js/jquery.autosize.js"></script> 
<script type="text/javascript">
$(function() {
	 var icons = {
			 header: "ui-icon-circle-arrow-e",
			 activeHeader: "ui-icon-circle-arrow-s",
	};
	$(".accordionmenu").accordion({
		heightStyle: "content",
		 icons: icons,
		 active: false,
		 collapsible: true ,
		 heightStyle: "content",
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
<div id="srfdialogform">
<h:form action="/Srf" method="post" styleId="saveSrfForm" styleClass="form"> 
<table style="border: thin;">
   		<tr>  			
   			<td>Welcome<h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text>
   			<td><h:text property="srfactionform" styleId="srfactionform" value="${srfactionform}" readonly="true" ></h:text></td> 
   			<td><h:submit property="srfaction" value="logout" > </h:submit></td> 
   		</tr>
   </table>

	<table width="926" height="369" border="2" cellpadding="0" cellspacing="0">
  		<tr>
   			<td>
   			<fieldset>         
        			<legend>Sample Details </legend> 
        			<table width="300">
        				<tr>
        					<td>Sample No:</td>
        					<td><h:text property="srf_sampleno" styleId="srf_sampleno" value="${editsrfform[0].srf_sampleno}"></h:text> </td>
        				</tr>
        				<tr>
        					<td>Order date:</td>
        					<td><h:text property="srf_orderdate" styleId="srf_orderdate" value="${editsrfform[0].srf_orderdate}"></h:text></td>
        				</tr>
        				<tr>
        					<td>Ref Type: </td>
        					<td><h:select property="srf_poreftype" styleId="srf_poreftype" value="${editsrfform[0].srf_poreftype}">
        							<h:option value="Email">Email</h:option>
        							<h:option value="Phone">Phone </h:option>
        							<h:option value="Others">Others</h:option>	
        						</h:select></td>
        				</tr>
        				<tr>
        					<td>Ref No: </td>
        					<td><h:textarea property="srf_referenceno" styleId="srf_referenceno" cols="20" rows="2" value="${editsrfform[0].srf_referenceno}"></h:textarea> </td>
        				</tr>
        				<tr>
        					<td>Priority :</td>
        					<td><h:select property="srf_priority" styleId="srf_priority" value="${editsrfform[0].srf_priority}">
   								<h:option value="low">low</h:option>
          						<h:option value="medium">medium</h:option>
          						<h:option value="High">High</h:option>
          						<h:option value="Top Urgent">Top Urgent</h:option>
       		 					</h:select><br />
       		 				</td>
        				</tr>
        				<tr>
        					<td>Handled By :</td>
        					<td><h:text property="srf_handledby" styleId="srf_handledby" value="${editsrfform[0].srf_handledby}"></h:text></td>
        				</tr>
        				<tr>
        					<td>Customer :</td>
        					<td><h:text property="srf_customer" styleId="srf_customer" style="width:180px" value="${editsrfform[0].srf_customer}"></h:text></td>
        				</tr>
        				<tr>
        					<td><h:hidden property="srf_customerid" styleId="srf_customerid" style="width:180px" value="${editsrfform[0].srf_customerid}"></h:hidden></td>
        				</tr>
        			</table> 			 	         
   			</fieldset>	
   			</td>
    		<td >
    			<fieldset>         
        			<legend>Tanner Details</legend> 
        			<table width="300">
        				<tr>
        					<td>Name: </td>
        					<td><h:text property="srf_tanname" size="38" styleId="srf_tanname" value="${editsrfform[0].srf_tanname}"></h:text></td>
        				</tr>
        				<tr>
        					<td><h:hidden property="srf_tannameid" styleId="srf_tannameid" value="${editsrfform[0].srf_tannameid}"></h:hidden></td>
        				</tr>
        				<tr>
        					<td>Attn: </td>
        					<td><h:text property="srf_tanattn" size="38" styleId="srf_tanattn" value="${editsrfform[0].srf_tanattn}"></h:text> </td>
        				</tr>
        				<tr>
        					<td>Addr:</td>
        					<td><h:textarea property="srf_tanaddr" cols="29" rows="4" value="${editsrfform[0].srf_tanaddr}" styleId="srf_tanaddr"></h:textarea> </td>
        				</tr>
        				<tr>
        					<td>Tele: </td>
        					<td><h:text property="srf_tanphone" size="38" value="${editsrfform[0].srf_tanphone}" styleId="srf_tanphone"> </h:text></td>
        				</tr>
        				<tr>
        					<td>Fax :</td>
        					<td><h:text property="srf_tanfax" size="38" styleId="srf_tanfax" value="${editsrfform[0].srf_tanfax}"> </h:text></td>
        				</tr>
        				<tr>
        					<td>Type:</td>
        					<td><h:select property="srf_isSample" styleId="srf_isSample" value="${editsrfform[0].srf_isSample}">
   								<h:option value="N">Free</h:option>
   								<h:option value="Y">Chargeable</h:option>  	
   								<h:option value="NA">To Clarify</h:option>  								
   							 </h:select> 
   						   </td>
        				</tr>
        			</table>	 
      			</fieldset>
      		</td>
    		<td >
    			<fieldset>
       				<legend>Deliver Details</legend>
       				<table width="300">
       					<tr>
       						<td>Name:</td>
       						<td><h:text property="srf_deliver" size="38" styleId="srf_deliver" value="${editsrfform[0].srf_deliver}"></h:text></td>
       					</tr>
       					<tr>
       						<td><h:hidden property="srf_deliverid" styleId="srf_deliverid" value="${editsrfform[0].srf_deliverid}"></h:hidden></td>
       					</tr>
       					<tr>
       						<td>Attn:</td>
       						<td><h:text property="srf_deliverattn" size="38" styleId="srf_deliverattn" value="${editsrfform[0].srf_deliverattn}" ></h:text></td>
       					</tr>
       					<tr>
       						<td>Addr:</td>
       						<td><h:textarea property="srf_deliveraddr" cols="29" rows="4" value="${editsrfform[0].srf_deliveraddr}" styleId="srf_deliveraddr"></h:textarea></td>
       					</tr>
       					<tr>
       						<td>Tele: </td>
       						<td><h:text property="srf_deliverphone" size="38" styleId="srf_deliverphone" value="${editsrfform[0].srf_deliverphone}"> </h:text></td>
       					</tr>
       					<tr>
       						<td>Fax :</td>
       						<td><h:text property="srf_deliverfax" size="38" styleId="srf_deliverfax" value="${editsrfform[0].srf_deliverfax}"> </h:text></td>
       					</tr>
       					<tr>
       						<td>Commission Details:</td>
       						<td><h:text property="srf_deliveracctno" size="38" styleId="srf_deliveracctno" value=""> </h:text> </td>
       					</tr>
       				</table>
      			</fieldset>
      		</td>
  		</tr>
  		<tr>
    		<td colspan="3">
    			<table id="srfArticletbl">
    			</table>
    		
    			<div id="srfArticlepager">    			
    			</div>
  			</td>
  		</tr> 		
  		
  		<tr>
		    <td>
		    <fieldset>
       			<legend>Delivery Details</legend>
       			<table>
       				<tr>
       					<td>Desti :</td>   
       					<td><h:text property="srf_destination" styleId="srf_destination" value="${editsrfform[0].srf_destination}"></h:text></td>      					
       				</tr>
       				<tr>
       					<td>CDD : </td>   
       					<td><h:text property="srf_cdd" styleId="srf_cdd" styleClass="srf_deliverydate" value="${editsrfform[0].srf_cdd}"></h:text></td>      					
       				</tr>
       				<tr>
       					<td>ADD : </td>   
       					<td><h:text property="srf_add" styleId="srf_add" styleClass="srf_deliverydate" value="${editsrfform[0].srf_add}"></h:text></td>      					
       				</tr>
       				
       				<tr>
       					<td>Terms : </td>   
       					<td><h:text property="srf_paymentterms" styleId="srf_paymentterms" value="${editsrfform[0].srf_paymentterms}"></h:text></td>      					
       				</tr>
       				<tr>
       					<td>End Usage :</td>   
       					<td><h:textarea property="srf_endusage" styleId="srf_endusage" value="${editsrfform[0].srf_endusage}"></h:textarea></td>      					
       				</tr>
       			</table>			
       		 	</fieldset>				
		    </td>
		    <td><fieldset>
		    		<legend>Special Condition</legend> 
        				 <h:textarea property="srf_splcdn" cols="40" rows="15" styleId="srf_splcdn" value="${editsrfform[0].srf_splcdn}"></h:textarea>     
       	 				    									
      			</fieldset>
      		</td>
      		 <td>
		        <fieldset>
		    		<legend>Inspection Condition</legend> 
		       		 <h:textarea property="srf_inspcdn" cols="40" rows="15" styleId="srf_inspcdn" value="${editsrfform[0].srf_inspcdn}"></h:textarea>
		        </fieldset>     
			</td>
  		</tr>
  		<tr>			
  			<td> 
  				<h:submit property="srfaction" value="Save" styleId="Save" styleClass="myPrintButton"></h:submit>
  			</td>
  			<td> 
  				<h:reset property="srfaction" value="Clear" styleId="Clear" styleClass="myPrintButton"></h:reset>
  			</td>
  			<td> 
  				<h:submit property="srfaction" value="Print" styleId="Print" styleClass="myPrintButton"></h:submit>
  			</td>
  		</tr>
	</table>
	</h:form>
</div>	
</body>
</h:html>