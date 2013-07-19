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
<link rel="stylesheet" type="text/css" media="screen" href="css/ui-darkness/jquery-ui-1.10.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />

<!-- For Auto Complete -->
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />


<script>
$(function(){
  /*   $("#destination").autocomplete({
        source: "/Myelclass/AutoCompleteServlet.do", 
        formatItem: function(item, position, length) {
            return item.destination;		
        	}
		}); */
 
$('#destination').autocomplete({
    source: function(request, response) {
        $.getJSON('/Myelclass/AutoCompleteServlet.do', { q: request.term }, function(result) {
            response($.map(result, function(item) {
                return item.destination;
            }));
        });
    }
});
});
</script>
<!-- For Date picker -->
 	<!-- <script src="js/jquery-1.9.1.js" type="text/javascript"></script>
 	<script src="js/jquery-ui.js" type="text/javascript"></script> 
 <script type="text/javascript">
	 $(function() {
		 $('#add').datepicker({
			 	numberOfMonths: 2,
				formatDate:'dd/mm/y',
			    firstDay: 1, 
			});
		 $('#cdd').datepicker({
			 	numberOfMonths: 2,
				formatDate:'dd/mm/y',
			    firstDay: 1, 
			});
		$("#orderdate").datepicker({
			changeMonth:true,
			formatDate:'dd/mm/y',
		    firstDay: 1, 
		});
		
		 
	});
</script> -->

 <!-- For JQGrid  -->
  <!-- <script src="js/jquery-1.9.0.min.js" type="text/javascript"></script> 
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script >
//load grid
 $(function (){
    var grid = $("#thelink");
	grid.click( function(){ 
		 var sno =$('#sampleno').val();
			$("#list").jqGrid({    
				 datatype: "json",
				    url:"/Myelclass/SrfinsertArticle.do?sno="+sno+"&action="+"load",
			        loadonce: true,
			        height:'auto',  
			         mtype: 'GET',  
			        colNames:['id', 'Name','Color', 'Size','Substance', 'Selec','Selec P', 'Quantity','Unit', 'Price','Tc'],  
			        colModel :[   
					  {name:'srf_articleid',index:'srf_articleid', width:60, sorttype:"int",editable:true },  
			          {name:'srf_articlename', index:'srf_articlename', width:90, editable:true },   
			          {name:'srf_color', index:'srf_color', width:80, align:'right', editable:true },  
			          {name:'srf_size', index:'srf_size' , width:55, editable:true},   
			          {name:'srf_substance', index:'srf_substance', width:90, editable:true},   
			          {name:'srf_selection', index:'srf_selection', width:80, align:'right', editable:true, jqModal:true},  
			          {name:'srf_selectionp', index:'srf_selectionp', width:90, editable:true},   
			          {name:'srf_quantity', index:'srf_quantity', width:80, align:'right', editable:true},  
			          {name:'srf_unit', index:'srf_unit', width:55, editable:true},   
			          {name:'srf_price', index:'srf_price', width:90, editable:true},  
			          {name:'srf_tc', index:'srf_tc', width:90, editable:true}  
			        ],  
			        jsonReader : {  
			        	repeatitems:false,
			            root: function (jsonOrderArray) { return jsonOrderArray; },
			            page: function (jsonOrderArray) { return 1; },
			            total: function (jsonOrderArray) { return 1; },
			            records: function (jsonOrderArray) { return jsonOrderArray.length; }
			        },  
			        multiselect:true,
			    	pager: '#pager',
			    	rowNum:7, 
			    	viewrecords: true ,
			    	rowList:[7,10,15],
			        loadtext: "Bow Bow",
			        height : "auto",
			        width:"auto",  
			        sortname: 'articleid',  
			        sortorder: 'desc',  
			        emptyrecords: 'No records to display',
			         
			        });  
			 	 jQuery("#list").jqGrid('navGrid','#pager',{edit:true,add:true,del:true, search:true, view:true});
	
			});
}); 
</script>-->
 
<script type="text/javascript">
//Tannery DDL	
function loadtanvalue(){		
			var tanname = document.getElementById("tanname").value;
	 		  <c:forEach items="${tanneryarray}" var="tanList">
					var tanvalue  = "<c:out value="${tanList.tanneryName}"></c:out>";
			  			 if(tanname == tanvalue){		
			  				 
			  			    var mytanvalue = "<c:out value="${tanList.tanneryAddress}"></c:out>" ; 
			  			    var maytanphone = "<c:out value="${tanList.tanneryContactNo}"></c:out>" ;
			  			    var mytanattn = "<c:out value="${tanList.tanneryAttention}"></c:out>" ; 
			  			    var mytanfax = "<c:out value="${tanList.tanneryFax}"></c:out>" ;
			  			  alert(maytanphone);
			  			    documnet.getElementById("tanaddr").value = mytanvalue;
			   				document.getElementById("tanphone").value = maytanphone;
			   				document.getElementById("tanattn").value = mytanattn;
			   				document.getElementById("tanfax").value = mytanfax;
					} 
				</c:forEach>   
		} 

//Customer DDL
function loadcustvalue(){
					var custname = document.getElementById("deliver").value; 
						<c:forEach items="${customerarray}" var="custList">
							var custvalue  = "<c:out value="${custList.customerName}"></c:out>" ;
			  			 	if(custname == custvalue){				  				 
			  					var mycustvalue = "<c:out value="${custList.customerAddress}"></c:out>" ;	 
					  			    var maycustphone = "<c:out value="${custList.customerTelephone}"></c:out>" ; 
					  			    var mycustattn = "<c:out value="${custList.customerAttention}"></c:out>" ; 
					  			    var mycustfax = "<c:out value="${custList.customerFax}"></c:out>" ; 			   				
					   				document.getElementById("custaddr").value = mycustvalue; 
					   				document.getElementById("custphone").value = maycustphone;
					   				document.getElementById("custattn").value = mycustattn;
					   				document.getElementById("custfax").value = mycustfax;
			  				 }
				  		</c:forEach>
				}	
				
	function loadfn(){
		$('#sampleno').val("S0001");
	}			
	
</script>
</head>
<body onload="loadfn();">
	<h:form action="/Srf">
	<table width="826" height="369" border="2" cellpadding="0" cellspacing="0">
		<tr>  			
   			<td>Welcome ${user.name}...</td> 
   			<td><h:submit property="srfaction" value="logout"></h:submit></td> 
   		</tr>
  		<tr>
   			<td width="272">
   				Sample No : <h:text property="sampleno" styleId="sampleno"></h:text> <br /><br />
   				Order date: <h:text property="orderdate" styleId="orderdate"></h:text><br /><br />
   				Reference No: <h:textarea property="referenceno" styleId="referenceno" cols="20" rows="2"></h:textarea>  <br /><br />
   				Priority   : <h:select property="priority" styleId="priority">
   								<h:option value="0">low</h:option>
          						<h:option value="1">medium</h:option>
          						<h:option value="2">High</h:option>
          						<h:option value="3">Top Urgent</h:option>
       		 					</h:select><br /> 
   				Handled By : <h:select property="handledby" styleId="handledby">
   								<h:option value="0">Select Handledby </h:option>
   								<c:forEach items="${handledbyarray}" var ="handledbyList">
          								<h:option value="${handledbyList.handledbyname}">
          			    					<c:out value="${handledbyList.handledbyname}"></c:out>
          								</h:option>        		
          						</c:forEach>
          					</h:select><br /> 		
   				Customer : <h:select property="customer" styleId="customer" style="width:180px">
   								<h:option value="0">select Customer</h:option>
          							<c:forEach items="${customerarray}" var ="custList">
          								<h:option value="${custList.customerName}">
          			    					<c:out value="${custList.customerName}"></c:out>
          								</h:option>   
          								</c:forEach>
       		 					</h:select><br /> 			 	         
   				
   			</td>
    		<td width="272">
    			<fieldset>         
        			<legend>Tanner Details</legend><br/> 
        				Name: <h:select property="tanname" styleId="tanname" onchange="loadtanvalue()">
       		 				  	<h:option value="0">select Tanner</h:option>
       		 						<c:forEach items="${tanneryarray}" var="tanlist">
          		 						<h:option value="${tanlist.tanneryName}">
         		 							<c:out value="${tanlist.tanneryName}"></c:out>
          		 						</h:option>
          	 						</c:forEach>
        					</h:select><br />        
       	 				Attn: <h:text property="tanattn" styleId="tanattn"></h:text><br />
         				Address:<h:textarea property="tanaddr" cols="30" rows="2" styleId="tanaddr"></h:textarea><br />
        				Telephone : <h:text property="tanphone" styleId="tanphone"> </h:text><br />
						Fax:  <h:text property="tanfax" styleId="tanfax"> </h:text>  <br /> 
						Type  :<h:select property="isSample" styleId="isSample">
   								<h:option value="1">Free</h:option>
   								<h:option value="2">Raise Invoice</h:option>  								
   							 </h:select> <br /><br />	 
      			</fieldset>
      		</td>
    		<td width="272">
    			<fieldset>
       				<legend>Deliver Details</legend><br/> 
       					Deliver: <h:select property="deliver" styleId="deliver" onchange="loadcustvalue()">
       		 					<h:option value="0">select Customer</h:option>
          							<c:forEach items="${customerarray}" var ="deliverList">
          								<h:option value="${deliverList.customerName}">
          			    					<c:out value="${deliverList.customerName}"></c:out>
          								</h:option>        		
          							</c:forEach>
       		 					</h:select><br />        
        				Attn: <h:text property="custattn" styleId="custattn"></h:text><br />
         				Address:<h:textarea property="custaddr" cols="30" rows="2" styleId="custaddr"></h:textarea><br />
        				Telephone : <h:text property="custphone" styleId="custphone"> </h:text><br />
						Fax:  <h:text property="custfax" styleId="custfax"> </h:text>  <br />  
						To Pay A/C No:<h:text property="custacctno" styleId="custacctno"> </h:text>  <br />  
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
    		<h:button property="artinsert" value="insert" styleId="thelink"></h:button>  
    			<table id="list">
    				<tr>
    					<td />
    				</tr>
    			</table>
    		
    			<div id="pager">    			
    			</div>
    			
  			</td>
  		</tr> 		
  		
  		<tr>
		    <td>
		    	End Usage : <h:select property="endusage" styleId="endusage">
       		 					<h:option value="0">select Endusage</h:option>
          							<c:forEach items="${endusagearray}" var ="endusageList">
          								<h:option value="${endusageList.endusagename}">
          			    					<c:out value="${endusageList.endusagename}"></c:out>
          								</h:option>        		
          							</c:forEach>
       		 					</h:select><br /> 
       		 	Destination :  <h:text property="destination" styleId="destination"></h:text><br />
       		 			
       		 					<%-- <h:select property="destination" styleId="destination"> 
       		 					<h:option value="0">select Destination</h:option>
          							<c:forEach items="${destiarray}" var ="destList">
          								<h:option value="${destList.destination}">
          			    					<c:out value="${destList.destination}"></c:out>
          								</h:option>        		
          							</c:forEach>
       		 					</h:select><br />	 --%>
       		 	Payment Terms : <h:select property="paymentterms" styleId="paymentterms">
       		 					<h:option value="0">select Payment</h:option>
          							<c:forEach items="${paymentarray}" var ="paymList">
          								<h:option value="${paymList.payment}">
          			    					<c:out value="${paymList.payment}"></c:out>
          								</h:option>        		
          							</c:forEach>
       		 					</h:select><br />								
		    </td>
		    <td>
		        ADD : <h:text property="add" styleId="add"></h:text><br /><br />	
		        CDD : <h:text property="cdd" styleId="cdd"></h:text><br /><br />	
			</td>
		    <td><fieldset>
		    		<legend>Special Condition</legend><br/> 
        				Condtion 1: <h:textarea property="splcdn" cols="30" rows="2" styleId="splcdn"></h:textarea><br />        
       	 				Condtion 2: <h:textarea property="splcdn1" cols="30" rows="2" styleId="splcdn"></h:textarea><br />         									
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