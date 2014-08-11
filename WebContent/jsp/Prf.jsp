<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PRF PAGE</title> 
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<!-- <script src="js/jquery.dialogextend.1_0_1.js"></script> -->
<link rel="stylesheet" type="text/css" media="screen" href="css/redmond/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/jquerywidgetstyle.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>	
<script src="js/elpro/prf.js"></script> 
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
<div>
	<h:form action="/Prf.do" method="post" styleId="savePrfForm" onreset="" styleClass="form">
	   		<td >Welcome<h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text></td >
	   				<td ><h:text property="formaction" styleId="formaction" value="${prfactionform}"></h:text></td> 
	   				<td><h:submit property="prfaction" value="Logout"></h:submit></td> 
    <table border="1" cellspacing="0" cellpadding="0">
        <tr>
           <td>
           	<fieldset>
        	<legend>Contract Details</legend>    
        	<table>
        		<tr>
        			<td>Agent: </td>
        			<td><h:text property="prf_agentname" size="41" styleId="prf_agentname" value="${editprfform[0].prf_agentname}" ></h:text> </td>
        		</tr>
        		<tr>
        			<td>Ct No:  </td>
        			<td><h:text property="prf_contractno" size="41" styleId="prf_contractno" value="${editprfctno}" /></td>
        		</tr>
        		<tr>
        			<td>Date: </td>
        			<td>  <h:text property="prf_orderdate" size="41" styleId="prf_orderdate" styleClass="prf_orderdate" value="${editprfform[0].prf_orderdate}"></h:text> </td>
        		</tr>
        		<tr>
        			<td>PO Type: </td>
        			<td><h:select property="prf_poreftype"  styleId="prf_poreftype"  value="${editprfform[0].prf_poreftype}">             
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
        		<tr>
        			<td>
        				<div id="bcTarget" ></div> 
        			</td>
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
        			<td><h:text property="prf_tanname" size="41" styleId="prf_tanname"  value="${editprfform[0].prf_tanname}"></h:text></td>
        		</tr>
        		<tr>
        			<td><h:hidden property="prf_tannid"  styleId="prf_tannid"  value="${editprfform[0].prf_tannid}"></h:hidden></td>
        		</tr>
        		<tr>
        			<td>Attn:</td>
        			<td><h:text property="prf_tanattn" size="41" styleId="prf_tanattn"   value="${editprfform[0].prf_tanattn}"></h:text></td>
        		</tr>
        		<tr>
        			<td>Addr:</td>
        			<td><h:textarea property="prf_tanaddr" cols="30" rows="4" styleId="prf_tanaddr"  value="${editprfform[0].prf_tanaddr}"></h:textarea></td>
        		</tr>
        		<tr>
        			<td>Tele: </td>
        			<td><h:text property="prf_tanphone" size="41" styleId="prf_tanphone"  value="${editprfform[0].prf_tanphone}"> </h:text></td>
        		</tr>
        		<tr>
        			<td>Fax :</td>
        			<td> <h:text property="prf_tanfax" size="41" styleId="prf_tanfax"  value="${editprfform[0].prf_tanfax}"> </h:text></td>
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
       				<td><h:text property="prf_custname" size="41" styleId="prf_custname"  value="${editprfform[0].prf_custname}"></h:text></td>
       			</tr>
       			<tr>	
        			<td><h:hidden property="prf_custid"  styleId="prf_custid"  value="${editprfform[0].prf_custid}"></h:hidden></td>
        		</tr>
       			<tr>
       				<td>Attn: </td>
       				<td><h:text property="prf_custattn" size="41" styleId="prf_custattn"  value="${editprfform[0].prf_custattn}"></h:text></td>
       			</tr>
       			<tr>
       				<td>Addr:</td>
       				<td><h:textarea property="prf_custaddr" cols="30" rows="4" styleId="prf_custaddr"  value="${editprfform[0].prf_custaddr}"> </h:textarea></td>
       			</tr>
       			<tr>
       				<td>Tele: </td>
       				<td><h:text property="prf_custphone" size="41" styleId="prf_custphone"  value="${editprfform[0].prf_custphone}"> </h:text></td>
       			</tr>
       			<tr>
       				<td>Fax :  </td>
       				<td><h:text property="prf_custfax" size="41" styleId="prf_custfax"  value="${editprfform[0].prf_custfax}"> </h:text>  </td>
       			</tr>
       		</table>
      		</fieldset>
           </td>
        <tr>
          	<td colspan="3">
            	<table id="list" class="list"></table> 
			 	<div id="pager" class="pager"></div> 
          	</td>
        </tr>
        <tr>
            <td>
            <fieldset>
            <legend>Delivery Details</legend>
            <table>
            	<tr>
            		<td>CDD : </td>
            		<td><h:text property="prf_cdd" size="41" styleId="prf_cdd" styleClass="prf_delivrydate" value="${editprfform[0].prf_cdd}"></h:text></td>
            	</tr>
            	<tr>
            		<td>ADD :</td>
            		<td><h:text property="prf_add" size="41" styleId="prf_add" styleClass="prf_delivrydate" value="${editprfform[0].prf_add}"></h:text></td>
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
       		 		  	  </h:select></td>
            	</tr>
            	<tr>
            		<td>Payment:</td>
            		<td><h:select property="prf_payment" styleId="prf_payment"  value="${editprfform[0].prf_payment}">
       		 				<h:option value="0">select Payment</h:option>
          					 <c:forEach items="${paymentarray}" var ="paymList">
          				 		 <h:option value="${paymList.paymentname}">
          			      		 <c:out value="${paymList.paymentname}"></c:out>
          				  	</h:option>        		
          				 	</c:forEach>
       	  	  		  	  </h:select></td>
            	</tr>
            	<tr>
            		<td>Insurance: </td>
            		<td><h:select property="prf_insurance" styleId="prf_insurance"  value="${editprfform[0].prf_insurance}">  
          	  			 	<h:option value="Consignee">By Consignee</h:option>     
          				 	<h:option value="Shipper">By Shipper</h:option>      			    													         															
       		 		  	 </h:select></td>
            	</tr>	
            	<tr>
            		<td>elclass Comm:</td>
            		<td><h:text property="prf_elclasscommission" styleId="prf_elclasscommission" value="${editprfform[0].prf_elclasscommission}"></h:text></td>
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
            <legend>Special Condition</legend>
           		<h:textarea property="prf_special" cols="41" rows="17" styleId="prf_special" value="${editprfform[0].prf_special}"></h:textarea>        									
         	</fieldset>
      		</td>
            <td>
            <fieldset>
             <legend>Inspection Condition</legend>     
       	 		<h:textarea property="prf_inspcdn" cols="41" rows="17" styleId="prf_inspcdn" value="${editprfform[0].prf_inspcdn}"></h:textarea>									
         	</fieldset>
           </td>
        </tr>
        <tr>
           	<td>
           	<fieldset>
       		<legend>Consignee Details</legend>
       		<table>
       			<tr>
       				<td>Name:</td>
       				<td><h:text property="prf_consigneename" size="41" styleId="prf_consigneename"  value="${editprfform[0].prf_consigneename}"></h:text></td>
       			</tr>
       			<tr>
        			<td><h:hidden property="prf_consigneeid" styleId="prf_consigneeid"  value="${editprfform[0].prf_consigneeid}"></h:hidden></td>
        		</tr>
       			<tr>
       				<td>Attn: </td>
       				<td><h:text property="prf_consigneeattn" size="41" styleId="prf_consigneeattn"  value="${editprfform[0].prf_consigneeattn}"></h:text></td>
       			</tr>
       			<tr>
       				<td>Addr: </td>
       				<td><h:textarea property="prf_consigneeaddr" cols="30" rows="4" styleId="prf_consigneeaddr"  value="${editprfform[0].prf_consigneeaddr}"></h:textarea></td>
       			</tr>
       			<tr>
       				<td>Tele:</td>
       				<td> <h:text property="prf_consigneephone" size="41" styleId="prf_consigneephone"  value="${editprfform[0].prf_consigneephone}"> </h:text></td>
       			</tr>
       			<tr>
       				<td>Fax :</td>
       				<td> <h:text property="prf_consigneefax" size="41" styleId="prf_consigneefax"  value="${editprfform[0].prf_consigneefax}"> </h:text></td>
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
	       				<td> <h:text property="prf_notifyname" size="41" styleId="prf_notifyname"  value="${editprfform[0].prf_notifyname}"></h:text></td>
	       			</tr>
	       			<tr>
	       				<td><h:hidden property="prf_notifyid"  styleId="prf_notifyid"  value="${editprfform[0].prf_notifyid}"></h:hidden></td>
        			</tr>
	       			<tr>
	       				<td>Attn: </td>
	       				<td><h:text property="prf_notifyattn" size="41" styleId="prf_notifyattn"  value="${editprfform[0].prf_notifyattn}"></h:text></td>
	       			</tr>
	       			<tr>
	       				<td>Addr:</td>
	       				<td><h:textarea property="prf_notifyaddr" cols="30" rows="4" styleId="prf_notifyaddr"  value="${editprfform[0].prf_notifyaddr}"> </h:textarea></td>
	       			</tr>
	       			<tr>
	       				<td>Tele: </td>
	       				<td><h:text property="prf_notifyphone" size="41" styleId="prf_notifyphone"  value="${editprfform[0].prf_notifyphone}"> </h:text></td>
	       			</tr>
	       			<tr>
	       				<td>Fax :</td>
	       				<td> <h:text property="prf_notifyfax" size="41" styleId="prf_notifyfax"  value="${editprfform[0].prf_notifyfax}"> </h:text> </td>
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
	       				<td><h:text property="prf_bankname" size="41" styleId="prf_bankname"  value="${editprfform[0].prf_bankname}"></h:text></td>
	       			</tr>
	       			<tr>
        				<td><h:hidden property="prf_bankid"  styleId="prf_bankid"  value="${editprfform[0].prf_bankid}"></h:hidden></td>
        			</tr>
	       			<tr>
	       				<td>Branch : </td>
	       				<td><h:text property="prf_bankbranch" size="41" styleId="prf_bankbranch"  value="${editprfform[0].prf_bankbranch}"></h:text></td>
	       			</tr>
	       			<tr>
	       				<td>Addr :</td>
	       				<td><h:textarea property="prf_bankaddr" cols="30" rows="4" styleId="prf_bankaddr"  value="${editprfform[0].prf_bankaddr}"></h:textarea></td>
	       			</tr>
	       			<tr>
	       				<td>Tele :</td>
	       				<td><h:text property="prf_bankphone" size="41" styleId="prf_bankphone"  value="${editprfform[0].prf_bankphone}"> </h:text></td>
	       			</tr>
	       			<tr>
	       				<td>Fax  :</td>
	       				<td><h:text property="prf_bankfax" size="41" styleId="prf_bankfax"  value="${editprfform[0].prf_bankfax}"> </h:text></td>
	       			</tr>
	       		 </table>  
      		</fieldset>
            </td>
        <tr>
            <td> <h:text property="prf_pojwno" styleId="prf_pojwno" value="${editprfform[0].prf_pojwno}"></h:text> </td>
        </tr>
        <tr>
  			<td>
  				<h:submit  property="prfaction" styleId="Btnprfsave" value="Save" ></h:submit>
  				<h:button property="prfaction" styleId="pojw" value="PO/JW" disabled="true" ></h:button>
  			</td>
  			<td><h:reset property="prfaction" styleId="Clear" value="Clear" ></h:reset></td>
  			<td>
  				<h:submit property="prfaction" styleId="Print" value="Print"></h:submit> 				
  			</td>
  		 </tr>
    </table>
</h:form>		
</div>
<div id="pojwdiv" title="Po/Jw Form" class="pojwform">
  	<h:form action="/PoJw" styleId="pojwform" method="post" target="pojwhiddenframe" > 
  		<table>
  		  <tr>	
  			<td>
  			<fieldset>         
		    <legend>PO Details</legend>
			 	<table>
				  <tr>
				    <td>PO No: </td>
				     <td><h:text  property="pojw_pojwno" size="41" styleId="pojw_pojwno" value="${editprfform[0].pojw_pojwno}"></h:text><br/></td>
				  </tr>
				  <tr>
				  	<td>Order Date:</td>
				    <td><h:text property="pojw_orderdate" size="41" styleId="pojw_orderdate" value="${editprfform[0].pojw_orderdate}" styleClass="prf_orderdate" ></h:text><br /></td>
				  </tr>
				  <tr>
				  	<td>CDD:</td>
				  	<td><h:text property="pojw_cddate" size="41" styleId="pojw_cddate" value="${editprfform[0].pojw_cddate}" styleClass="prf_delivrydate" ></h:text><br /></td>
				  </tr>
				  <tr>
				    <td>Ct No: </td>
				    <td><h:text property="pojw_contractno" size="41" styleId="pojw_contractno" value="${editprfform[0].pojw_contractno}"></h:text><br /></td>
				  </tr>
				  <tr>
				  	<td>Commission :</td>
				  	<td> <h:text property="pojw_comm" size="41" styleId="pojw_comm" value="${editprfform[0].pojw_comm}"  ></h:text></td>
				  </tr>  
				  <tr>
				  	<td>Payment Terms :</td>
				  	<td> <h:textarea property="pojw_payterms"  cols="38" rows="3"  styleId="pojw_payterms" value="${editprfform[0].pojw_payterms}"  ></h:textarea></td>
				  </tr>
				</table>
			</fieldset>
			</td>
			<td>  
			<fieldset>         
			<legend>Tannery Details</legend>
				<table>
				  <tr>
				  	<td>Tanner: </td>
				    <td><h:text property="pojw_tanname" size="41" styleId="pojw_tanname" value="${editprfform[0].pojw_tanname}"></h:text><br /></td>
				  </tr>
				   <tr>
				    <td><h:hidden property="pojw_tanid" styleId="pojw_tanid" value="${editprfform[0].pojw_tanid}"></h:hidden></td>
				  </tr>
				  <tr>
				    <td>Attn:</td>
				  	<td><h:text property="pojw_tanattn" size="41" styleId="pojw_tanattn" value="${editprfform[0].pojw_tanattn}" ></h:text><br /></td>
				  </tr>
				  <tr>
				  	<td>Addr:</td>
				  	<td><h:textarea property="pojw_tanaddr" styleId="pojw_tanaddr"  cols="38" rows="3" value="${editprfform[0].pojw_tanaddr}"></h:textarea><br /></td>
				  </tr>
				  <tr>
				  	<td>Tele: </td>
				  	<td><h:text property="pojw_tanphone" size="41" styleId="pojw_tanphone" value="${editprfform[0].pojw_tanphone}" ></h:text><br/></td>
				  </tr>
				  <tr>
				  	<td>Fax :</td>
				  	<td><h:text property="pojw_tanfax" size="41" styleId="pojw_tanfax" value="${editprfform[0].pojw_tanfax}"></h:text></td>
				  </tr>
				</table>
			</fieldset>
			</td>
		  </tr>     
		  <tr>
          	<td colspan="2">
            	<table id="pojwtbl" class="pojwtbl"></table> 
			 	<div id="pojwpager" class="pojwpager"></div> 
          	</td>
          </tr>
          <tr>  			  	
         	<td colspan="2"> 
        	<fieldset>
        	<legend>Special Condition</legend>
			    <h:textarea property="pojw_splcdn" styleId="pojw_splcdn"  cols="170" rows="10" value="${editprfform[0].pojw_splcdn}"></h:textarea><br />
			</fieldset>
			</td>
          </tr>
         <%--  <tr>
        	<td colspan="2"> 
        	<fieldset>
        	<legend>Payment Terms</legend>
        		<h:textarea property="pojw_payterms"  styleId="pojw_payterms"  cols="140" rows="1" value="${editprfform[0].pojw_payterms}"></h:textarea><br />
        	</fieldset>
        	</td>
          </tr>	 --%>
          <tr>	
        	<td>
		    	<h:submit property="prfaction" value="POSave" title="Save" styleId="posave"></h:submit>
		   </td>
   		   <td>
   						
   			    <h:submit property="prfaction" value="POPrint" title="Print" styleId="poprint"></h:submit>
   		   </td>
          </tr>
     	</table>
	</h:form>
 </div>
 <iframe name="pojwhiddenframe" style="display: none;"></iframe >
</body>
</h:html>		