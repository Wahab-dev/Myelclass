<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean-el" prefix="b"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
</head>
<body>
<!--  Login Form  -->
<h:form action="/login" method="post" >
	<table style="border: thin;">
   		<tr>  			
   			<td>Welcome ${user.name}...</td> 
   			<h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text>
   			<td><h:text property="formaction" styleId="formaction" value="${actionform}" readonly="true" ></h:text></td> 
   			<td><h:submit property="srfaction" value="logout" > </h:submit></td> 
   		</tr>
   </table>
</h:form>

<h:form action="/Srf" method="post" styleId="saveSrfForm"> 
	<table width="826" height="369" border="2" cellpadding="0" cellspacing="0">
  		<tr>
   			<td width="272">
   				Sample No : <h:text property="srf_sampleno" styleId="srf_sampleno" value="${sampleno}"></h:text> <br /><br />
   				Order date: <h:text property="srf_orderdate" styleId="srf_orderdate" value="${editprfform[0].srf_orderdate}"></h:text><br /><br />
   				Reference No: :<h:select property="srf_poreftype" styleId="srf_poreftype">
        							<h:option value="Email">Email</h:option>
        							<h:option value="Phone">Call </h:option>
        							<h:option value="Others">Others</h:option>	
        						</h:select><br />
   					<h:textarea property="srf_referenceno" styleId="srf_referenceno" cols="20" rows="2" value="${editprfform[0].srf_referenceno}"></h:textarea>  <br /><br />
   				Priority   : <h:select property="srf_priority" styleId="srf_priority">
   								<h:option value="0">low</h:option>
          						<h:option value="1">medium</h:option>
          						<h:option value="2">High</h:option>
          						<h:option value="3">Top Urgent</h:option>
       		 					</h:select><br /><br /> 
   				Handled By : <h:text property="srf_handledby" styleId="srf_handledby" value="${editprfform[0].srf_handledby}"></h:text><br /><br />	
   				Customer : <h:text property="srf_customer" styleId="srf_customer" style="width:180px" value="${editprfform[0].srf_customer}"></h:text><br /> 			 	         
   				
   			</td>
    		<td width="272">
    			<fieldset>         
        			<legend>Tanner Details</legend><br/> 
        				Name: <h:text property="srf_tanname" styleId="srf_tanname" value="${editprfform[0].srf_tanname}"></h:text><br /><br />
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
       					Deliver: <h:text property="srf_deliver" styleId="srf_deliver" value="${editprfform[0].srf_deliver}"></h:text><br /><br />        
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
		    	End Usage : <h:textarea property="srf_endusage" styleId="srf_endusage" value="${editprfform[0].srf_endusage}"></h:textarea><br /><br />
       		 	Destination :  <h:text property="srf_destination" styleId="srf_destination" value="${editprfform[0].srf_destination}"></h:text><br /><br />
       		 			
       		 	Payment Terms : <h:text property="srf_paymentterms" styleId="srf_paymentterms" value="${editprfform[0].srf_paymentterms}"></h:text><br /><br />						
		    </td>
		    <td>
		        ADD : <h:text property="srf_add" styleId="srf_add" styleClass="srf_deliverydate" value="${editprfform[0].srf_add}"></h:text><br /><br /><br />	
		        CDD : <h:text property="srf_cdd" styleId="srf_cdd" styleClass="srf_deliverydate" value="${editprfform[0].srf_cdd}"></h:text><br /><br /><br />
		        insp Cdn: <h:textarea property="srf_inspcdn" cols="30" rows="2" styleId="srf_inspcdn" value="${editprfform[0].srf_inspcdn}"></h:textarea><br />     
			</td>
		    <td><fieldset>
		    		<legend>Special Condition</legend><br/> 
        				Condtion 1: <h:textarea property="srf_splcdn" cols="30" rows="2" styleId="srf_splcdn" value="${editprfform[0].srf_splcdn}"></h:textarea><br />        
       	 				    									
      			</fieldset>
      		</td>
  		</tr>
  		<tr>
  			<td></td>
  			<td> 
  				<h:submit property="srfaction" value="Save" styleId="Save"></h:submit>
  			</td>
  			<td> 
  				<h:reset property="srfaction" value="Clear" styleId="Clear"></h:reset>
  			</td>
  			<td></td>
  		</tr>
	</table>
	</h:form>
</body>
</h:html>