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
<link rel="stylesheet" type="text/css" media="screen" href="css/vader/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 	
</style>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/vader/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />

<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>

<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>		
<script src="js/elpro/srf.js"></script> 
<script src="js/jquery.autosize.js"></script> 
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
<!--  Login Form  -->
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
	
<h:form action="/Srf" method="post" styleId="saveSrfForm"> 
<table style="border: thin;">
   		<tr>  			
   			<td>Welcome<h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text>
   			<td><h:text property="srfactionform" styleId="srfactionform" value="${srfactionform}" readonly="true" ></h:text></td> 
   			<td><h:submit property="srfaction" value="logout" > </h:submit></td> 
   		</tr>
   </table>

	<table width="826" height="369" border="2" cellpadding="0" cellspacing="0">
  		<tr>
   			<td width="272">
   				Sample No : <h:text property="srf_sampleno" styleId="srf_sampleno" value="${editsrfform[0].srf_sampleno}"></h:text> <br /><br />
   				Order date: <h:text property="srf_orderdate" styleId="srf_orderdate" value="${editsrfform[0].srf_orderdate}"></h:text><br /><br />
   				Reference No: :<h:select property="srf_poreftype" styleId="srf_poreftype">
        							<h:option value="Email">Email</h:option>
        							<h:option value="Phone">Call </h:option>
        							<h:option value="Others">Others</h:option>	
        						</h:select><br />
   					<h:textarea property="srf_referenceno" styleId="srf_referenceno" cols="20" rows="2" value="${editsrfform[0].srf_referenceno}"></h:textarea>  <br /><br />
   				Priority   : <h:select property="srf_priority" styleId="srf_priority">
   								<h:option value="low">low</h:option>
          						<h:option value="medium">medium</h:option>
          						<h:option value="High">High</h:option>
          						<h:option value="Top Urgent">Top Urgent</h:option>
       		 					</h:select><br /><br /> 
   				Handled By : <h:text property="srf_handledby" styleId="srf_handledby" value="${editsrfform[0].srf_handledby}"></h:text><br /><br />	
   				Customer : <h:text property="srf_customer" styleId="srf_customer" style="width:180px" value="${editsrfform[0].srf_custname}"></h:text><br /> 			 	         
   				
   			</td>
    		<td width="272">
    			<fieldset>         
        			<legend>Tanner Details</legend><br/> 
        				Name: <h:text property="srf_tanname" styleId="srf_tanname" value="${editsrfform[0].srf_tanname}"></h:text><br /><br />
       		 			Attn: <h:text property="srf_tanattn" styleId="srf_tanattn" value=""></h:text> <br /><br />
         				Address:<h:textarea property="srf_tanaddr" cols="30" value="" rows="2" styleId="srf_tanaddr"></h:textarea> <br /><br />
        				Telephone : <h:text property="srf_tanphone" value="" styleId="srf_tanphone"> </h:text> <br /><br />
						Fax:  <h:text property="srf_tanfax" styleId="srf_tanfax" value=""> </h:text> <br /><br />
						Type  :<h:select property="srf_isSample" styleId="srf_isSample" value="">
   								<h:option value="N">Free</h:option>
   								<h:option value="Y">Chargeable</h:option>  	
   								<h:option value="NA">To Clarify</h:option>  								
   							 </h:select> <br /><br />	 
      			</fieldset>
      		</td>
    		<td width="272">
    			<fieldset>
       				<legend>Deliver Details</legend><br/> 
       					Deliver: <h:text property="srf_deliver" styleId="srf_deliver" value="${editsrfform[0].srf_deliver}"></h:text><br /><br />        
        				Attn: <h:text property="srf_custattn" styleId="srf_custattn" value="" ></h:text><br /><br />
         				Address:<h:textarea property="srf_custaddr" cols="30" rows="2"  value="" styleId="srf_custaddr"></h:textarea><br /><br />
        				Telephone : <h:text property="srf_custphone" styleId="srf_custphone" value=""> </h:text><br /><br />
						Fax:  <h:text property="srf_custfax" styleId="srf_custfax" value=""> </h:text> <br /><br />
						To Pay A/C No:<h:text property="srf_custacctno" styleId="srf_custacctno" value=""> </h:text>  <br />  
      			</fieldset>
      		</td>
  		</tr>
  		<tr>
    		<td height="21"></td>
   			<td>&nbsp;</td>
    		<td>&nbsp;</td>
  		</tr>
  		<tr>
    		<td colspan="3">
    		<%-- <h:button property="artinsert" value="insert" styleId="thelink"></h:button>   --%>
    			<table id="srfArticletbl">
    			</table>
    		
    			<div id="srfArticlepager">    			
    			</div>
  			</td>
  		</tr> 		
  		
  		<tr>
		    <td>
		    	End Usage : <h:textarea property="srf_endusage" styleId="srf_endusage" value="${editsrfform[0].srf_endusage}"></h:textarea><br /><br />
       		 	Destination :  <h:text property="srf_destination" styleId="srf_destination" value="${editsrfform[0].srf_destination}"></h:text><br /><br />
       		 			
       		 	Payment Terms : <h:text property="srf_paymentterms" styleId="srf_paymentterms" value="${editsrfform[0].srf_paymentterms}"></h:text><br /><br />						
		    </td>
		    <td>
		        ADD : <h:text property="srf_add" styleId="srf_add" styleClass="srf_deliverydate" value="${editsrfform[0].srf_add}"></h:text><br /><br /><br />	
		        CDD : <h:text property="srf_cdd" styleId="srf_cdd" styleClass="srf_deliverydate" value="${editsrfform[0].srf_cdd}"></h:text><br /><br /><br />
		        insp Cdn: <h:textarea property="srf_inspcdn" cols="30" rows="2" styleId="srf_inspcdn" value="${editsrfform[0].srf_inspcdn}"></h:textarea><br />     
			</td>
		    <td><fieldset>
		    		<legend>Special Condition</legend><br/> 
        				Condtion 1: <h:textarea property="srf_splcdn" cols="30" rows="2" styleId="srf_splcdn" value="${editsrfform[0].srf_splcdn}"></h:textarea><br />        
       	 				    									
      			</fieldset>
      		</td>
  		</tr>
  		<tr>			
  			<td> 
  				<h:submit property="srfaction" value="Save" styleId="Save"></h:submit>
  			</td>
  			<td> 
  				<h:submit property="srfaction" value="Clear" styleId="Clear"></h:submit>
  			</td>
  			<td> 
  				<h:submit property="srfaction" value="Print" styleId="Print"></h:submit>
  			</td>
  		</tr>
	</table>
	</h:form>
</body>
</h:html>