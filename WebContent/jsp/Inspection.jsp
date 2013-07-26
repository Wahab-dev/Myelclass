<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.7.3.custom.css" rel="Stylesheet" />
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 	
</style>	
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/pepper-grinder/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />

<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>

<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>		
<script type="text/javascript">
$(document).ready(function() {
	//:Load Grid
	var gridbtn = $('#loadCtDetails'); 
	var grid = $('#insp_Ctdetails'); 
	gridbtn.click( function()
		    {
			var ctno = $('#inps_ContractNumber').val();
    		grid.jqGrid({  
				url:"/Myelclass/InspAutocomplete.do?ctno="+ctno+"&action="+"loadArticle",   
				datatype:"json",
				colNames:['Article Name', 'Color', 'Size','Subs','Selec','Selec P', 'Quantity'],  
			    colModel:[   
					{name:'prf_articlename', index:'articlename'},
					{name:'prf_color', index:'color'},
					{name:'prf_size', index:'size'},
					{name:'prf_substance', index:'subatance'},
					{name:'prf_selection', index:'selection'},
					{name:'prf_selectionp', index:'selectionp'},
					{name:'prf_quantity', index:'qty'},
				],  
				jsonReader : {  
				  	repeatitems:false,
			      	root: "rows",
			      	page: "page", //calls first
			      	total: "total" ,//calls Second
			      	records: "records" //calls Third
				},
				caption: "Load Article Details On Selected CT",
		    	pager: '#insp_CtDetalspager',
		    	rowNum:6, 
		    	rowList:[2,4,6],
		    	//loadonce:false,
		        loadtext: "Bow Bow........... ",
		        height : "auto",
		        width:"auto",  
		        sortname: 'articlename',  
		        sortorder: 'desc',  
		        emptyrecords: 'No records to display',
			});
			 		
			grid.jqGrid('navGrid', '#insp_CtDetalspager',  { edit: true, add: true, del: false, 
					search: false, refresh: false },
					{ // edit option
	 					 top: 150,
	 					 left: 200,
	 					 beforeShowForm: function(form) { 
	 						alert("In Edit Form"); 
	 					 },
	 					 url: "/Myelclass/PrfinsertArticle.do?ctno="+ctno+"&action="+"edit",
	 					 mtype: "POST",
	 					 closeAfterEdit: true,
	 					 //editData
	 		          },
	 		          
	 				{ // add option
	 		              beforeShowForm: function(form) { 
	 		            	  alert("In Add Form");  
	 		              },
	 		        	  top: 150,
					 	  left: 200,
					 	  width : 350,
					 	  url: "/Myelclass/PrfinsertArticle.do?ctno="+ctno+"&action="+"add",
	 		          }
	 		          );
	});
	$('#inps_ContractNumber').autocomplete({
		 source: function(request, response) {
			var param = request.term;  
			$.getJSON("/Myelclass/InspAutocomplete.do?term="+param+"&action="+"inspCt",
				function(result) { 	
			       response($.map(result, function(item) {
			           return { 
			              value: item.label,
			              splcdn: item.prf_inspcdn,
			              };
			        }));//END response
			 });
		 },
		 select: function( event, ui ) { 
         	 $('#insp_cdn').val(ui.item.splcdn);
           } 
	}); 
	$('#inps_qualityctrlr').autocomplete({
		 source: function(request, response) {
			var param = request.term;  
			$.getJSON("/Myelclass/InspAutocomplete.do?term="+param+"&action="+"inspQtCtr",
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
			 });
		 }
	}); 
	 //DATEPICKER
     $("#inps_date").datepicker({
	   // changeYear: true,
	    autoSize: true,
	    changeMonth:false,
	    dateFormat: "dd/mm/y",
	    showWeek: true,
	    firstDay: 1,
	    numberOfMonths: 1,
	    showButtonPanel: true,
	    gotoCurrent:true, 
	});
	

	  
	
});
</script>
</head>
<body>
<h:form action="/saveinspection" styleId="saveInspection">
	<table width="800" height="586" border="2" cellpadding="0" cellspacing="0">
	  	<tr>
		   <td height="533">Welcome ${user.name}..
		     <fieldset> 	
		     	<legend>Basic Details</legend>  
		     		<table>
		     			<tr>
		     				<td>
		     					Contract Number :
		     						<h:text property="inps_ContractNumber" styleId="inps_ContractNumber"></h:text><br />	
          												
		     				</td>
		     				<td>
		     					Inspection Date :
		     						<h:text property="inps_date" styleId="inps_date"></h:text><br />
		     				</td>
		     				<td>
		     					Quality Controller:
		     						<h:text property="inps_qualityctrlr" styleId="inps_qualityctrlr"></h:text><br />		
		     				</td>
		     			</tr>
		     		</table>          																
		     </fieldset>
		   
		    <table>
		    <tr>
		   <td>
		    <div>
		      <h:button property="inspinsert" value="insert" styleId="loadCtDetails"></h:button>    
		    	<table id="insp_Ctdetails"></table>
		    		<div id="insp_CtDetalspager"></div>
		    		</div>
		   	</td>
		     </tr>
		    </table>
	          <div>Please make sure you check the following before Inspection of Goods</div>
	            <h:textarea  property="insp_cdn" styleId="insp_cdn" rows="4" cols="100"></h:textarea>
	            
	            
	            <fieldset> 	
		     		<legend>Manual Test</legend>
	         	  <table width="800" border="2" cellspacing="0" cellpadding="0">
	          		
		     		<tr>
	            		<td width="198">Test Type</td>
	            		<td width="193">Tested Peces</td>
	            		<td width="399">Comments</td>
	            	</tr>
	          		<tr>
	            		<td>Color</td>
	            		<td>&nbsp;</td>
	            		<td>&nbsp;</td>
	            	</tr>
	          		<tr>
	            		<td>Substance</td>
	            		<td>&nbsp;</td>
	            		<td>&nbsp;</td>
	            	</tr>
	          		<tr>
	            		<td>Tear Strength</td>
	            		<td>&nbsp;</td>
	            		<td>&nbsp;</td>
	            	</tr>
	          		<tr>
			            <td>Grain Break</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	           	 	</tr>
	          		<tr>
			            <td>Crocking Dry</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	            	</tr>
	          		<tr>
			            <td>Crocking Wet</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	            	</tr>
	          		<tr>
			            <td>Finish Adhension</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	            	</tr>
	          		<tr>
			            <td>Four Fold</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	            	</tr>
	          		<tr>
			            <td>Cross Section</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	            	</tr>
	          		<tr>
			            <td>Organoleptic</td>
			            <td>&nbsp;</td>
			            <td>&nbsp;</td>
	            	</tr>	            
	         	 </table>
	          </fieldset> 
	          <div>Content for New Div Tag Goes Here</div>
	          <fieldset> 	
		     		<legend>Grading</legend>
	          	<table width="800" border="2" cellspacing="0" cellpadding="0">
	            	<tr>
	              		<td width="88">Grading</td>
	              		<td width="118">Skin Count</td>
	              		<td width="223">Percentage</td>
	              		<td width="359">Comments</td>
                	</tr>
	            	<tr>
	              		<td>Grading 1</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
                	</tr>
	            	<tr>
	              		<td>Grading 2</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
                	</tr>
	            	<tr>
	              		<td>Grading 3</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
                	</tr>
	            	<tr>
	              		<td>Grading 4</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
                	</tr>
	            	<tr>
	              		<td>Grading 5</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
	              		<td>&nbsp;</td>
                	</tr>
              	</table>
              </fieldset>
	          <div>Content for New Div Tag Goes Here</div>
	          <fieldset> 	 	
		     	<legend>Rejects</legend>
	          		<table width="799" border="2" cellspacing="0" cellpadding="0">
	            		<tr>
	              			<td height="28" colspan="2" rowspan="2">Total Skins Passed</td>
	              			<td colspan="7"><div align="center">Rejects</div></td>
	              			<td rowspan="2">Total Skins Inspected</td>
                		</tr>
	            		<tr>
	              			<td width="92">Substance</td>
	              			<td width="68">Size</td>
	              			<td width="77">Selection</td>
	              			<td width="42">Color</td>
	              			<td width="84">Organoleptic</td>
	              			<td width="53">Other</td>
	              			<td width="106">Total Rejects</td>
                		</tr>
	            		<tr>
	              			<td width="44" height="22">Sides</td>
	              			<td width="72">&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td width="137">&nbsp;</td>
                		</tr>
	            		<tr>
	              			<td>Hides</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
                		</tr>
	            		<tr>
	              			<td>Total</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
	              			<td>&nbsp;</td>
                		</tr>
              		</table>
              	</fieldset>
	        
	          <table width="800" border="2" cellspacing="0" cellpadding="0">
	           	 <tr>
	              <td height="15">Comments</td>	  	                           
                </tr>
	           	<tr>          	
	              <td height="55"></td>
                </tr>              
                <tr>
	              <td height="15">Stamping Details</td>	  	                           
                </tr>
                <tr>          	
	              <td height="55"></td>
                </tr>   
                 <tr>
  					<td><h:submit property="Save" value="Save" styleId="Save"></h:submit>
  						<h:reset property="Clear" value="Clear" styleId="Clear"></h:reset>
  						
  					</td>	
  				</tr>
              </table>
	          </td>
  		</tr>
	</table>
</h:form>
</body>
</html>