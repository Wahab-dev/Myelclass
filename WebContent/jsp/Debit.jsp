<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<link rel="stylesheet" type="text/css" media="screen" href="css/ui-darkness/jquery-ui-1.10.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />

<script src="js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() { 
		var gridbtn = $("#thelink");
		 gridbtn.click( function(){
				var custname = $("#customer").val();
				 alert(custname);
				 $("#tbl_debselInvDetails").jqGrid({
					 url:"/Myelclass/DebSelInvfromCust.do?invno="+elclassrefno+"&action="+"loadGrid",
					 datatype: "json",
					 colNames:['Ct No','Article','Color','Size','Substance','Quantity','Rate','TC'],
					 colModel:[
					           {name: 'prf_contractno', index:'prf_contractno',width:50},
					           {name: 'prf_articlename', index:'prf_articlename',width:90},
					           {name: 'prf_color', index:'prf_color',width:70},
					           {name: 'prf_size', index:'prf_size',width:70},
					           {name: 'prf_substance', index:'prf_substance',width:70},
					           {name: 'prf_quantity', index:'prf_quantity',width:70},
					           {name: 'prf_price', index:'prf_price',width:70},
					           {name: 'prf_tc', index:'prf_tc',width:70}
					           ],
					  jsonReader : {  
						       repeatitems:false,
						       root: function (jsonOrderArray) { return jsonOrderArray; },
						       page: function (jsonOrderArray) { return 1; },
						       total: function (jsonOrderArray) { return 1; },
						       records: function (jsonOrderArray) { return jsonOrderArray.length; }
						       }, 
					   pager: '#tbl_debpager',
					   rowNum:3, 
					   multiselect : true,
					   rowList:[3,5,7],	       
					   sortorder: 'desc',  
				       emptyrecords: 'No records to display',
				        
				 });
				 jQuery("#tbl_debselInvDetails").jqGrid('#tbl_debpager',{
			 		 
			 		 	});
			});
});
</script>


<script type="text/javascript">
//Tannery DDL	
function loadexportervalue(){		
			var expname = document.getElementById("tannery").value;
	 		  <c:forEach items="${DebExporter}" var="DebExpoList">
					var expvalue  = "<c:out value="${DebExpoList.tannery}"></c:out>";					 
			  			 if(expname == expvalue){
			  			     var myexpaddr = "<c:out value="${DebExpoList.tanaddr}"></c:out>" ; 			  			  	
			  			     var mayexpphone = "<c:out value="${DebExpoList.tantelephone}"></c:out>" ;
			   				document.getElementById("tanaddr").value = myexpaddr;
			   				document.getElementById("tantelephone").value = mayexpphone;
					} 
				</c:forEach>   
		} 
</script>
<body>

<h:form action="/savedebit" focus="debitno"> 	
	<table width="800" border="2" cellspacing="0" cellpadding="0">
		<tr>
			<td>Welcome ${user.name}</td> 
   			<td><h:submit property="action" value="Logout"></h:submit> 
   			</td> 
		</tr>
    	<tr>
		    <td>
		    	<fieldset>         
        				<legend>Debit Details</legend> 
        					Debit No: <h:text property="debitno" styleId="debitno"></h:text><br />
        					<br />Tanner  : <h:select property="tannery" styleId="tannery" onchange="loadexportervalue();">
       		 						<h:option value="0">select Tanner</h:option>
       		 							<c:forEach items="${DebExporter}" var="DebExporterlist">
          		 							<h:option value="${DebExporterlist.tannery}">
         		 								<c:out value=  "${DebExporterlist.tannery}"></c:out>
          		 							</h:option>
          	 							</c:forEach>
        							</h:select><br />        
       	 					
         					<br />Address: <h:textarea property="tanaddr" cols="30" rows="2" styleId="tanaddr"></h:textarea><br />
        					<br />Telephone : <h:text property="tantelephone" styleId="tantelephone"> </h:text><br />
							
      				</fieldset>
		    </td>
		    <td>
		
        					<br />Debit Date: <h:text property="debitdate" styleId="debitdate"></h:text><br />
        					<br />elclass ref no: <h:select property="taninvno" styleId="taninvno">
       		 						<h:option value="0">select Tanner</h:option>
       		 							<c:forEach items="${DebTanInvno}" var="DebTanInvnolist">
          		 							<h:option value="${DebTanInvnolist.taninvno}">
         		 								<c:out value="${DebTanInvnolist.taninvno}"></c:out>
          		 							</h:option>
          	 							</c:forEach>
        							</h:select><br />        
       	 					
         					<br />Tanner Invoice No : <h:text property="elclassrefno" styleId="elclassrefno"></h:text><br />
        					
      			
			</td>
  		</tr>
  		<tr>
	  		<td>&nbsp;</td>
	  		<td>&nbsp;</td>
	  	</tr>
	  	<tr>
	  		 <td><h:submit property="action" value="Clickhere"></h:submit></td> 
	  		 <td><h:submit property="action" value="Calculate"></h:submit></td> 
	  	</tr>
  		<tr>
		   <td colspan="3">
		   			<h:button property="action" styleId="thelink" value="loadgrid"></h:button>
            		 <table id="tbl_debselInvDetails">
               		 <!--<tr>
                  		<td>Contract No</td>
                  		<td>Date</td>
                  		<td>Article</td>
                  		<td>Color</td>
                  		<td>Size %</td>
                  		<td>Substance</td>
                  		<td>Selection</td>
                  		<td>Quantity</td>
                  		<td>Rate</td>
                  		<td>Commission</td>
                  		<td>TC</td>
                	</tr>--> 	
             		</table>
             		<div id="tbl_debpager"></div>
              	</td>
              	<td>
              	</td>
	  	</tr>	  	
  		<tr>
	  		<td><h:submit property="action" value="RaiseTc"></h:submit></td> 
	  		<td><h:submit property="action" value="Waived"></h:submit></td> 
	  	</tr>
	  	<tr>
		    <td>
		    	<br />Exchange Rate: <h:text property="exchangerate" styleId="exchangerate" > </h:text><br />
				<br />Commission :  <h:text property="commission1" styleId="commission1"> </h:text>  <br />  
				<br />Rate: <h:text property="rate" styleId="rate"> </h:text><br />
				<br />Quantity :  <h:text property="totalquantity" styleId="totalquantity"> </h:text>  <br />  
				<br />Invoice Amount: <h:text property="invoiceamt" styleId="invoiceamt"> </h:text><br />
				<br />el class Commission :  <h:text property="elclassamt" styleId="elclassamt"> </h:text>  <br />  
				
      		</td>
		    <td>
		    	<br />Commission in INR: <h:text property="elclassamtinrs" styleId="elclassamtinrs"> </h:text><br />
				<br />Tax @ 12.36% :  <h:text property="tax" styleId="tax"> </h:text>  <br />  
				<br />Total: <h:text property="total" styleId="total"> </h:text><br />
				<br />TDS :  <h:text property="tds" styleId="tds"> </h:text>  <br />  
				<br />Total Due: <h:text property="due" styleId="due"> </h:text><br />
			</td>
		   
	  	</tr>
	  	<tr>
	  		<td>&nbsp;</td>
	  		<td>&nbsp;</td>
	  	</tr>
	  	<tr>
		    <td><h:submit property="action" value="Save"></h:submit></td> 
   			<td><h:reset property="action" value="Clear"></h:reset></td> 
  		</tr>
	</table>
</h:form>
</body>
</html>