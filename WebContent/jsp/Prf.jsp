<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="l"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PRF PAGE</title> 
<%-- <link rel="stylesheet" href="js/jquery-ui.css" />
<script src="js/jquery-1.9.0.js"></script>
<script src="js/jquery-1.9.0.min.js"></script> --%>
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 
table.EditTable > tbody > tr.FormData > td.DataTD > input[type="select"] {
    width: 115px !important;
}
</style>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/vader/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>		
<script src="js/elpro/prf.js"></script> 
<!-- <script>!window.jQuery && document.write('<script src="js/elpro/prf.js"><\/script>');</script>  -->
<script type="text/javascript">


//Agent DDL
function loadAgent(){
	 var agentname = $("#prf_agentname").val();
	<c:forEach items="${agentarray}" var="agentlist"> 	
	 	var selectedagent = "<c:out value='${agentlist.agentname}' />" ;
	 	if(agentname == selectedagent){		 		
	 		var agentctno = "<c:out value='${agentlist.contractNo}' />" ;
	 		if(agentctno.length == 0 )
			{
						agentctno = "L4501";
			}
	 		$("#prf_contractno").val(agentctno);
		}
	 </c:forEach>
	}
function loadvalues(){
	var actionform = "<c:out value='${actionform}' />";
	if(actionform == "edit"){
		var prfeditterms = "<c:out value='${editprfform[0].prf_terms}' />";
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
		
		
		$("#Save").val("UpdatePrf");
	}

}  
</script>
</head>
<body onload="loadvalues();">
	<h:form action="/Prf" method="post">
		<table width="812" border="1" cellspacing="0" cellpadding="0" >
   		<tr>  			
   			<td>Welcome ${user.name}...</td> 
   			<h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text>
   			<td >
   				<h:text property="formaction" styleId="formaction" value="${actionform}" readonly="true" ></h:text>
   			</td> 
   			<td><h:submit property="prfaction" value="Logout"></h:submit></td> 
   		</tr>
   </table>
   <font color="red">
	<h:errors/>
</font>
    <table width="800" border="1" cellspacing="0" cellpadding="0">
         	 <tr>
           		 <td width="97">
           		 	<table width="263" border="0" cellspacing="0" cellpadding="0">
              			<tr>
                			<td height="40">
                			<fieldset>
        							<legend>Contract Details</legend>
        							<br/>
                     			    Agent:<h:select property="prf_agentname" styleId="prf_agentname" onchange="loadAgent()" value="${editprfform[0].prf_agentname}">
          									  	<h:option value="0">select Agent</h:option>         	
          	 										<c:forEach var="agentList" items="${agentarray}">
          	 											<h:option value="${agentList.agentname}">
          	 												<c:out value="${agentList.agentname}"></c:out>
          	 											</h:option>
          	 										</c:forEach>
          										</h:select><br /><br />
        								Contract  No.<h:text property="prf_contractno" styleId="prf_contractno" value="${editprfctno}" /><br />
        								<br />
        								Date : <h:text property="prf_orderdate" styleId="prf_orderdate" value="${editprfform[0].prf_orderdate}"></h:text> <br /><br />						    
        								P.O. reference:<h:select property="prf_poreftype" styleId="prf_poreftype">
        								 					<h:option value="Email">Email</h:option>
        								 					<h:option value="Phone">Telephonic </h:option>
        								 					<h:option value="Others">Others</h:option>	
        								 				</h:select><br />
        								 	<h:text property="prf_poref" styleId="prf_poref" value="${editprfform[0].prf_poref}"></h:text><br /><br />
      							</fieldset>
                  			</td>
            	  		</tr>
        	 	 	</table>
        	 	 </td>
            	<td width="97">
            		<table width="263" border="0" cellspacing="0" cellpadding="0">
              			<tr>
                			<td height="21"><fieldset>         
        							<legend>Tannery Details</legend><br/> 
        												Name: <h:text property="prf_tanname" styleId="prf_tanname" ></h:text><br />  <br />    								      
       	 												Attn: <h:text property="prf_tanattn" styleId="prf_tanattn"></h:text><br /><br />
         												Address:<h:textarea property="prf_tanaddr" cols="30" rows="2" styleId="prf_tanaddr"></h:textarea><br /><br />
        												Telephone : <h:text property="prf_tanphone" styleId="prf_tanphone"> </h:text><br /><br />
														Fax:  <h:text property="prf_tanfax" styleId="prf_tanfax"> </h:text>  <br />  
      										</fieldset>
                  			</td>
             		 	</tr>
            	  	</table>
             	</td>
            	<td width="97">
            		<table width="263" border="0" cellspacing="0" cellpadding="0">
              			<tr>
                			<td height="21"><fieldset>
       								<legend>Customer Details</legend><br/> 
       									Name:<h:text property="prf_custname" styleId="prf_custname"></h:text><br /><br />        
        								Attn: <h:text property="prf_custattn" styleId="prf_custattn"></h:text><br />
         								Address:<h:textarea property="prf_custaddr" cols="30" rows="2" styleId="prf_custaddr"></h:textarea><br />
        								Telephone : <h:text property="prf_custphone" styleId="prf_custphone"> </h:text><br />
										Fax:  <h:text property="prf_custfax" styleId="prf_custfax"> </h:text>  <br />  
      							</fieldset>
                  			</td>
              			</tr>
            		</table>
            	</td>
          	</tr>
          	 <tr>
          	</tr>
          	<tr>
          	<td height="53" colspan="3">
          			<b>Response:</b> <span id="rsperror" style="color:red"></span> <br/>
             <table id="list">
             </table> 
				<div id="pager"></div> 
          	</td>
          	</tr>
          	<tr>
            	<td>
            		<fieldset>
            			<legend>Delivery Details</legend><br/> 
        						CDD: <h:text property="prf_cdd" styleId="prf_cdd" styleClass="prf_delivrydate" value="${editprfform[0].prf_cdd}"></h:text><br /> <br /> 
       	 						ADD: <h:text property="prf_add" styleId="prf_add" styleClass="prf_delivrydate" value="${editprfform[0].prf_add}"></h:text><br /><br /> 
       	 									
         						Destination: <h:text property="prf_destination" styleId="prf_destination"  value="${editprfform[0].prf_destination}"></h:text><br /><br /> 
        						Terms : <h:select  property="prf_terms" styleId="prf_terms" value="${editprfform[0].prf_terms}">
       		 								<h:option value="0">select Terms</h:option>
          										<c:forEach items="${termsarray}" var ="termsList">
          											<h:option value="${termsList.termName}">
          			    								<c:out value="${termsList.termName}"></c:out>
          											</h:option>  
          										</c:forEach> 
       		 					  		</h:select><br />
      				</fieldset>
      			</td>
            	<td>
            	<fieldset>
            		<legend>Commission Details</legend>
            			  Insurance:  <h:select property="prf_insurance" styleId="prf_insurance" value=""> <br /> 
          														<h:option value="1">Will Be Covered By Consignee</h:option>     
          														<h:option value="2">Will Be Covered By Shipper</h:option>      			    													         															
       		 											</h:select><br /><br />
            			 Payment:  <h:select property="prf_payment" styleId="prf_payment">
       		 													<h:option value="0">select Payment</h:option>
          															<c:forEach items="${paymentarray}" var ="paymList">
          																<h:option value="${paymList.payment}">
          			    													<c:out value="${paymList.payment}"></c:out>
          																</h:option>        		
          															</c:forEach>
       		 											  		</h:select><br /><br />
       		 											  			
        				elclass Commission : 
        					<h:text property="prf_elclasscommission" styleId="prf_elclasscommission" value="${editprfform[0].prf_elclasscommission}"></h:text>
        					<br /><br />
        					<div id='TextBoxesGroup'>
								<div id="TextBoxDiv1">
   									 <label>Commission #1 : </label><h:text property="prf_commission" styleId="prf_commission" value="${editprfform[0].prf_commission1}" ></h:text> </div> 	   
								</div>	
							<!-- <input type="button" value="Add Comm" id="addButton"> -->
        					<!-- <input type="button" value="Rem Comm" id="removeButton">  -->      		 														  					  		
      			</fieldset>
      			</td>
            	<td><fieldset><legend>Special Condition</legend><br/> 
        									Condtion 1: <h:textarea property="prf_special" cols="30" rows="2" styleId="prf_special" value="${editprfform[0].prf_special}"></h:textarea><br />        
       	 									Inspection Cdn: <h:textarea property="prf_special" cols="30" rows="2" styleId="prf_special" value="${editprfform[0].prf_inspcdn}"></h:textarea><br />
       	 										
         			</fieldset></td>
          	</tr>
          	<tr>
            	<td>&nbsp;</td>
            	<td>&nbsp;</td>
            	<td>&nbsp;</td>
          	</tr>
          	<tr>
            	<td>
            		<table width="263" border="0" cellspacing="0" cellpadding="0">
                		<tr>
                  			<td height="21"><fieldset>
       											<legend>Consignee Details</legend><br/> 
       													Name: <h:text property="prf_consigneename" styleId="prf_consigneename"></h:text><br />        
        												Attn: <h:text property="prf_consigneeattn" styleId="prf_consigneeattn"></h:text><br />
         												Address:<h:textarea property="prf_consigneeaddr" cols="30" rows="2" styleId="prf_consigneeaddr"></h:textarea><br />
        												Telephone : <h:text property="prf_consigneephone" styleId="prf_consigneephone"> </h:text><br />
														Fax:  <h:text property="prf_consigneefax" styleId="prf_consigneefax"> </h:text>  <br />  
      										</fieldset>
                    		</td>
                	   </tr>
              		</table>
              	</td>
            	<td>
            		<table width="263" border="0" cellspacing="0" cellpadding="0">
              			<tr>
                			<td height="21"><fieldset>
       											<legend>Notify Details</legend><br/> 
       													Name: <h:text property="prf_notifyname" styleId="prf_notifyname"></h:text><br />        
        												Attn: <h:text property="prf_notifyattn" styleId="prf_notifyattn"></h:text><br />
         												Address:<h:textarea property="prf_notifyaddr" cols="30" rows="2" styleId="prf_notifyaddr"></h:textarea><br />
        												Telephone : <h:text property="prf_notifyphone" styleId="prf_notifyphone"> </h:text><br />
														Fax:  <h:text property="prf_notifyfax" styleId="prf_notifyfax"> </h:text>  <br />  
      										</fieldset>
                  			</td>
              			</tr>
            		</table>
            	</td>
            	<td>
            		<table width="263" border="0" cellspacing="0" cellpadding="0">
              			<tr>
               				<td height="21"><fieldset>
       											<legend>Bank Details</legend><br/> 
       													Name: <h:text property="prf_bankname" styleId="prf_bankname"></h:text><br />        
        												Branch: <h:text property="prf_bankbranch" styleId="prf_bankbranch"></h:text><br />
         												Address:<h:textarea property="prf_bankaddr" cols="30" rows="2" styleId="prf_bankaddr"></h:textarea><br />
        												Telephone : <h:text property="prf_bankphone" styleId="prf_bankphone"> </h:text><br />
														Fax:  <h:text property="prf_bankfax" styleId="prf_bankfax"> </h:text>  <br />  
      										</fieldset>
                  			</td>
             			</tr>
            		</table>
            	</td> 
          </tr>
          <tr>
            <!-- td>Running Since : <b:write name="datestarted" scope="application" format="MM/dd/yy"/> </td> -->
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td></td>
  				<td><h:submit property="prfaction" value="SavePrf" styleId="Save"></h:submit></td>
  				<!-- <a href="#" id="thelink">Clickme</a> -->
  				<%-- <h:link href="#" property="insert">Click me</h:link> --%>
  				<td><h:reset property="prfaction" value="Clear" styleId="Clear"></h:reset></td>
  				<%-- <h:button property="insert" >Insert</h:button> --%>
  			<td></td>
          </tr>
        </table>
    </h:form>								
</body>
</h:html>