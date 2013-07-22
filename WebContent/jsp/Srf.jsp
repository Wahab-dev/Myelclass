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
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 	
</style>
<!-- For Auto Complete -->
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />

 <script type="text/javascript">
$(function(){
	//AutoComplete
	
	 $('#srf_tanname').autocomplete({
		 source: function(request, response) {
				var param = request.term;  
			 	$.getJSON("/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"tan",
					function(result) { 	
			             response($.map(result, function(item) {
			                return { 
			                       value: item.label,
			                       addr: item.tanneryAddress,
			                       phone: item.tanneryContactNo,	
			                       attn : item.tanneryAttention,
			                       fax: item.tanneryFax,
			                       };
			                     }));//END response
			                    }
					 );
					},
					select: function( event, ui) { 
			          	 $('#srf_tanaddr').val(ui.item.addr);
			          	 $('#srf_tanphone').val(ui.item.phone);
			          	 $('#srf_tanattn').val(ui.item.attn);
			          	 $('#srf_tanfax').val(ui.item.fax);
			           } 
			}); 
		  $('#srf_deliver').autocomplete({
			 source: function(request, response) {
				var param = request.term;  
			 	$.getJSON("/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"custname",
					function(result) { 	
			             response($.map(result, function(item) {
			                return { 
			                       value: item.label,
			                       addr: item.customerAddress,
			                       phone: item.customerTelephone,	
			                       attn : item.customerAttention,
			                       fax: item.customerFax,
			                       };
			                     }));//END response
			                    }
					 );
					},
					select: function( event, ui) { 
			          	 $('#srf_custaddr').val(ui.item.addr);
			          	 $('#srf_custphone').val(ui.item.phone);
			          	 $('#srf_custattn').val(ui.item.attn);
			          	 $('#srf_custfax').val(ui.item.fax);
			           } 
			}); 
		  
		  $('#srf_customer').autocomplete({
			    source: function(request, response) {
			    	var param = request.term;  
			        $.getJSON("/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"custname", 
			        		 function(result) {
			            		response($.map(result, function(item) {
			                	return {
			                		label: item.label,  //can add number of attributes here   
			                        value: item.label  // I am displaying both labe and value  
			                		};
			            }));
			        });
			    }

			});
	$('#srf_destination').autocomplete({
	    source: function(request, response) {
	    	var param = request.term;  
	        $.getJSON("/Myelclass/AutoCompleteServlet.do?term="+param+"&action="+"desti", 
	        		 function(result) {
	            		response($.map(result, function(item) {
	                	return {
	                		label: item.label,  
	                        shform: item.shform, //can add number of attributes here   
	                        value: item.label +" , "+ item.value // I am displaying both labe and value  
	                		};
	            }));
	        });
	    }

	});
	
	$('#srf_handledby').autocomplete({
	    source: function(request, response) {
	    	var param = request.term;  
	        $.getJSON("/Myelclass/SrfAutoComplete.do?term="+param+"&action="+"handlby", 
	        		 function(result) {
	            		response($.map(result, function(item) {
	                	return {
	                		label: item.label,  
	                         //can add number of attributes here   
	                        value: item.label  // I am displaying both labe and value  
	                		};
	            }));
	        });
	    }

	});
	
	$('#srf_endusage').autocomplete({
	    source: function(request, response) {
	    	var param = request.term;  
	        $.getJSON("/Myelclass/SrfAutoComplete.do?term="+param+"&action="+"endusage", 
	        		 function(result) {
	            		response($.map(result, function(item) {
	                	return {
	                		label: item.label,  
	                         //can add number of attributes here   
	                        value: item.label  // I am displaying both labe and value  
	                		};
	            }));
	        });
	    }

	});
	
	$('#srf_paymentterms').autocomplete({
	    source: function(request, response) {
	    	var param = request.term;  
	        $.getJSON("/Myelclass/SrfAutoComplete.do?term="+param+"&action="+"pymttrms", 
	        		 function(result) {
	            		response($.map(result, function(item) {
	                	return {
	                		label: item.label,  
	                         //can add number of attributes here   
	                        value: item.label  // I am displaying both labe and value  
	                		};
	            }));
	        });
	    }

	});
	//Date Picker
		 $('.srf_deliverydate').datepicker({
			 	numberOfMonths: 2,
				formatDate:'dd/mm/y',
			    firstDay: 1, 
			});
		$("#srf_orderdate").datepicker({
			changeMonth:true,
			formatDate:'dd/mm/y',
		    firstDay: 1, 
		});
		
			
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

</script> 

</head>
<body>
	<h:form action="/Srf">
	<table width="826" height="369" border="2" cellpadding="0" cellspacing="0">
		<tr>  			
   			<td>Welcome ${user.name}...</td> 
   			<td><h:submit property="srfaction" value="logout"></h:submit></td> 
   		</tr>
  		<tr>
   			<td width="272">
   				Sample No : <h:text property="srf_sampleno" styleId="srf_sampleno"></h:text> <br /><br />
   				Order date: <h:text property="srf_orderdate" styleId="srf_orderdate"></h:text><br /><br />
   				Reference No: <h:textarea property="srf_referenceno" styleId="srf_referenceno" cols="20" rows="2"></h:textarea>  <br /><br />
   				Priority   : <h:select property="srf_priority" styleId="srf_priority">
   								<h:option value="0">low</h:option>
          						<h:option value="1">medium</h:option>
          						<h:option value="2">High</h:option>
          						<h:option value="3">Top Urgent</h:option>
       		 					</h:select><br /> 
   				Handled By : <h:text property="srf_handledby" styleId="srf_handledby"></h:text><br /> 		
   				Customer : <h:text property="srf_customer" styleId="srf_customer" style="width:180px"></h:text><br /> 			 	         
   				
   			</td>
    		<td width="272">
    			<fieldset>         
        			<legend>Tanner Details</legend><br/> 
        				Name: <h:text property="srf_tanname" styleId="srf_tanname"></h:text><br/>
       		 			Attn: <h:text property="srf_tanattn" styleId="srf_tanattn"></h:text><br />
         				Address:<h:textarea property="srf_tanaddr" cols="30" rows="2" styleId="srf_tanaddr"></h:textarea><br />
        				Telephone : <h:text property="srf_tanphone" styleId="srf_tanphone"> </h:text><br />
						Fax:  <h:text property="srf_tanfax" styleId="srf_tanfax"> </h:text>  <br /> 
						Type  :<h:select property="srf_isSample" styleId="srf_isSample">
   								<h:option value="1">Free</h:option>
   								<h:option value="2">Raise Invoice</h:option>  								
   							 </h:select> <br /><br />	 
      			</fieldset>
      		</td>
    		<td width="272">
    			<fieldset>
       				<legend>Deliver Details</legend><br/> 
       					Deliver: <h:text property="srf_deliver" styleId="srf_deliver"></h:text><br />        
        				Attn: <h:text property="srf_custattn" styleId="srf_custattn"></h:text><br />
         				Address:<h:textarea property="srf_custaddr" cols="30" rows="2" styleId="srf_custaddr"></h:textarea><br />
        				Telephone : <h:text property="srf_custphone" styleId="srf_custphone"> </h:text><br />
						Fax:  <h:text property="srf_custfax" styleId="srf_custfax"> </h:text>  <br />  
						To Pay A/C No:<h:text property="srf_custacctno" styleId="srf_custacctno"> </h:text>  <br />  
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
		    	End Usage : <h:text property="srf_endusage" styleId="srf_endusage"></h:text><br /> 
       		 	Destination :  <h:text property="srf_destination" styleId="srf_destination"></h:text><br />
       		 			
       		 	Payment Terms : <h:text property="srf_paymentterms" styleId="srf_paymentterms"></h:text><br />								
		    </td>
		    <td>
		        ADD : <h:text property="srf_add" styleId="srf_add" styleClass="srf_deliverydate"></h:text><br /><br />	
		        CDD : <h:text property="srf_cdd" styleId="srf_cdd" styleClass="srf_deliverydate"></h:text><br /><br />	
			</td>
		    <td><fieldset>
		    		<legend>Special Condition</legend><br/> 
        				Condtion 1: <h:textarea property="srf_splcdn" cols="30" rows="2" styleId="srf_splcdn"></h:textarea><br />        
       	 				Condtion 2: <h:textarea property="srf_splcdn1" cols="30" rows="2" styleId="srf_splcdn"></h:textarea><br />         									
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