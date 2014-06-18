<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.7.3.custom.css" rel="Stylesheet" />
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 

</style>	
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/redmond/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>	
<script src="js/elpro/inspection.js"></script> 	
<script type="text/javascript">
function onlyNumbers(evt)
{
    var e = (window.event)?event:evt; // for cross browser compatibility
    var charCode = e.which || e.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)){
        return false;
    }
    return true;
}
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

<h:form action="/saveinspection" styleId="saveInspection">

<table border="1" cellspacing="0" cellpadding="0" >
   		<tr>  			
   			<td>Welcome <h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text></td> 	
   			<td><h:text property="inspactionform" styleId="inspactionform" value="${inspactionform}" readonly="true" ></h:text></td>
   			<td>
   				
   			</td>	
   			<td><h:submit property="inspaction" value="Logout"></h:submit></td> 
   		</tr>
   </table>
	<table width="800" border="1" cellspacing="0" cellpadding="0">
	  	<tr>
		   <td>
		   	<table>
		   		 <tr>
		   		 	 <td>
		     		Type : 
		     		 <h:select property="insptype"  styleId="insptype">             
        	    			 <h:option value="Ct">Contract </h:option>
        					 <h:option value="sample">Sample</h:option>
        				   </h:select>         												
		     		</td>
		   		 </tr>
		     	 <tr>
		     	    <td>
		     		 <label for="Contract" id="ctno">Contract Number :</label>
		     		 <h:text property="inspContractNo" styleId="inspContractNo"></h:text><br />	         												
		     		</td>
		   			<td>
		         	
		     		 Inspection Date :
		     		 <h:text property="inspdate" styleId="inspdate"></h:text>
		    		</td>
		    		<td>
		     		 Quality Controller:
		     		 <h:text property="inspqualityctrlr" styleId="inspqualityctrlr"></h:text>	
		     		</td>
		    		<td>
		     		 Total Passed:
		     		 <h:text property="totinspected" styleId="totinspected" maxlength="5" onkeypress="return onlyNumbers(event);"></h:text>	
		     		 </td>
		    	</tr>
		      </table>
		     </td>
		    </tr>
		    <tr>
		   	  <td>
		    	<table id="insp_Ctdetails"></table>
		    	<div id="insp_CtDetalspager"></div>
		   	  </td>
		    </tr>
		    <tr>
		       <td>
	          	<div>Please make sure you check the following before Inspection of Goods</div>
	            <h:textarea  property="insp_cdn" styleId="insp_cdn" rows="4" cols="113"></h:textarea>
	         
	            <h:hidden property="artidhidden" styleId="artidhidden" ></h:hidden>
	            <h:hidden property="colorhidden" styleId="colorhidden"></h:hidden>
	            <h:hidden property="articlehidden" styleId="articlehidden"></h:hidden>
	            <h:hidden property="sizehidden" styleId="sizehidden"></h:hidden>
	            <h:hidden property="substancehidden" styleId="substancehidden"></h:hidden>
	            <h:hidden property="selhidden" styleId="selhidden"></h:hidden>
	            <h:hidden property="quantityhidden" styleId="quantityhidden"></h:hidden>
	            <h:hidden property="custhidden" styleId="custhidden"></h:hidden> 
	            <h:hidden property="tanhidden" styleId="tanhidden"></h:hidden>
	             <h:hidden property="ctdthidden" styleId="ctdthidden"></h:hidden>
 				</td>
 			 <tr>
 			 	<td>
 			 		<table id="insptesttbl"></table>
	        		<div id="insptestpager"></div>
	         	</td>
	         </tr>	
	         <tr>
	        	<td>
	        		<table id="inspgradtbl"></table>
		   		 <div id="inspgradpager"></div>
	     		</td>
	     	</tr>	
	     	<tr>
		  		<td>  
		  			<table id="insprejtbl"></table>
		    		<div id="insprejpager"></div>
             	</td>
             </tr>	
	         <tr>
	              <td height="15"> 
	               Comments:<h:textarea property="inspcomments" styleId="inspcomments" rows="4" cols="112"  ></h:textarea> 	
	              </td>	                
                </tr>
	           
                 <tr>
  					<td>
  						<h:submit property="inspaction" value="Save" styleId="Save"></h:submit>
  						<h:reset property="inspaction" value="Clear" styleId="Clear" ></h:reset>
  						<h:submit property="inspaction" value="Print" styleId="Print" ></h:submit>
  					</td>
  				</tr>
              </table>
</h:form>
</body>
</h:html>