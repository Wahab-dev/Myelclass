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
	 var clr = null ;
	 var arid = null ; 
	 
	// Load Grid
	var artgrid = $('#insp_Ctdetails'); 
	var testgrid = $('#insptesttbl'); 
	var gradgrid = $('#inspgradtbl'); 
	var rejgrid = $('#insprejtbl'); 
			artgrid.jqGrid({  
				url:"",   
				datatype:"json",
				colNames:['Article Id','Article Name', 'Color', 'Tannery', 'Customer','Order Date', 'PONo', 'Size','Subs','Selec','Selec P', 'Quantity'],  
			    colModel:[   
					{name:'prf_articleid', index:'prf_articleid', width:60, hidden: true, },
					{name:'prf_articlename', index:'articlename', width:60, },
					{name:'prf_color', index:'color', width:60, },
					{name:'prf_tannid', index:'prf_tannid', width:60,  hidden: true,},
					{name:'prf_custid', index:'prf_custid', width:60, hidden: true,},
					{name:'prf_orderdate', index:'prf_orderdate', width:60, hidden: true,},
					{name:'prf_poref', index:'prf_poref', width:60, },
					{name:'prf_size', index:'size', width:60, },
					{name:'prf_substance', index:'subatance', width:60, },
					{name:'prf_selection', index:'selection', width:60, },
					{name:'prf_selectionp', index:'selectionp', width:60, },
					{name:'prf_quantity', index:'prf_quantity', width:60, },
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
		        loadtext: "Bow Bow........... ",
		        height : "auto",
		        width:"auto",
		       // multiselect: true,
		        sortname: 'articlename',  
		        sortorder: 'desc',  
		        emptyrecords: 'No records to display',
		        onSelectRow: function(rowid){
		        	clr = artgrid.jqGrid('getCell', rowid, 'prf_color');
		        	arid = artgrid.jqGrid('getCell', rowid, 'prf_articleid');
		        	alert(arid);
		        }
			});	
			artgrid.jqGrid('navGrid', '#insp_CtDetalspager',  { edit: false, add: false, del: false, 
					search: false, refresh: false, view:true });
//tEST GRID LOAD 
	testgrid.jqGrid({  
				url:'/Myelclass/InspectionAction.do?event=manualtest',   
				datatype:"json",
				colNames:['Id','Test Id','Inspection ID','ArticleID','Color','TestType', 'pieces tested', 'Results','Comments'],  
			    colModel:[  
					{name:'id', index:'id', align:'center', width:60, editable:true, sortable: true, hidden: true, 
						editoptions: {size:8},
	
					},	
					{name: 'testid', index:'testid', align:'center', width:60, editable:true, sortable: true, hidden: false, 
						editoptions: {size:8},
						
					},
					{name: 'inspid', index:'inspid', align:'center', width:60, editable:true, sortable: true, hidden: false, 
						editoptions: {size:5},
					
					},
					{name: 'articleid', index: 'articleid', align:'center', width:60, editable:true, sortable: true, hidden: false, 
						editoptions: {size:8},
						
					},
					{name:'colortest', index:'colortest', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						editoptions: {size:8}, 
						
					},
					{name:'testtype', index:'testtype', align:'center', width:120, editable:true, sortable: true, hidden:false, 
						edittype: 'select', 
						editoptions: {value: {Color:'Color',Substance:'Substance',TearStrength:'Tear Strength',GrainBreak:'Grain Break',CrockingWet:'Crocking Wet',CrockingDry:'Crocking Dry',
							FinishAdhension:'Finish Adhension',FourFolds:'Four Folds',CrossSection:'Cross Section',Organoleptic:'Organoleptic'}},						
					
					},
					{name:'testedpcs', index:'testedpcs', align:'center', width:130, editable:true, sortable: true, hidden:false, 
						edittype:'text',
						editoptions:{ 
							size: 15, 
							maxlength:2, 
                         	dataInit: function(element) { 
                             $(element).keyup(function(){
                                 var val1 = element.value;
                                 var num = new Number(val1);
                                 if(isNaN(num))
                                 {alert("Only Numbers are Allowed");}
                             });
                         	}
						}
					},
					{name:'result', index:'result', align:'center', width:120, editable:true, sortable: true, hidden:false, 
						  edittype: 'select', 
						  editoptions: {value: {P:'Pass',F:'Fail',N:'NA'}},						
					},
					{name:'comments', index:'comments', align:'center', width:120, editable:true, sortable: true, hidden:false, 
						edittype: 'textarea',
					},					
				],  
				jsonReader : {  
				  	repeatitems:false,
			      	root: "rows",
			      	page: "page", 
			      	total: "total" ,
			      	records: "records" 
				},
				editurl: '/Myelclass/InspectionAction.do?event=manualtest',
				caption: "Test Details",
		    	pager: '#insptestpager',
		    	rowNum: 6, 
		    	rowList: [2,4,6],
		        loadtext: "Bow Bow........... ",
		        height : "auto",
		        width: "auto",  
		        sortname: 'testid',  
		        sortorder: 'desc',  
		        emptyrecords: 'No records to display',
			});
			 		
		testgrid.jqGrid('navGrid', '#insptestpager',  { edit: true, add: true, del: true, 
					search: false, refresh: true, view: true },
					{
						// Edit
						 reloadAfterSubmit: true,
						 closeAfterEdit: true,
					},
					{
					   // Before Add 
			 		  beforeInitData: function(formid) {
					 	/* testgrid.setColProp('Color', {
	 		 				formoptions : {
								label : "",
							},
						}); */
			 		  },
					  beforeShowForm: function(form){
						  $("#colortest").val(clr);
						  $("#articleid").val(arid);
						  /*$('<tr class="FormData"><td class="CaptionTD ui-widget-content" colspan="2">' +
						           '<hr/><div style="padding:3px" class="ui-widget-header ui-corner-all">' +
						           '<b>Test Details :</b></div></td></tr>')
						           .insertBefore('#articleid');	  */
						/*  $("#tr_testid").hide();
						 $("#tr_testtype").hide();
						 $("#tr_Inspdate").hide(); */
						 
					 },
					 reloadAfterSubmit: true,
					 closeAfterAdd: true,
					});
		
//Grade GRID
		gradgrid.jqGrid({  
				url: '/Myelclass/InspectionAction.do?event=grade',   
				datatype:"json",
				colNames:['Id','Insp ID','Grade ID ','articleid', 'Grade ','Color','Skin Count', 'Percentage','Comments'],  
			    colModel:[   
					{name:'id', index:'id',align:'center', width:80, editable:true, sortable: true, hidden: false, },
					{name:'inspid', index:'inspid',align:'center', width:80, editable:true, sortable: true, hidden: false, },
					{name:'gradeid', index:'gradeid', align:'center', width:80, editable:true, sortable: true, hidden: false, },
					{name:'articleid', index:'articleid', align:'center', width:80, editable:true, sortable: true, hidden: false, },
					{name:'grade', index:'grade', align:'center', width:120, editable:true, sortable: true, hidden: false,
						edittype: 'select', 
						editoptions: {value: {Grade1:'Grade 1',Grade2:'Grade 2', Grade3:'Grade 3', Grade4:'Grade 4', Grade5:'Grade 5'}},
					},
					{name:'gradecolor', index:'gradecolor', align:'center', width:80, editable:true, sortable: true, hidden: false, },
					{name:'skincount', index:'skincount', align:'center', width:120, editable:true, sortable: true, hidden: false, },	
					{name:'percent', index:'percent', align:'center', width:120, editable:true, sortable: true, hidden: false, },
					{name:'comment', index:'comment', align:'center', width:120, editable:true, sortable: true, hidden:false, 
						edittype: 'textarea',
					},				
				],  
				jsonReader : {  
				  	repeatitems:false,
			      	root: "rows",
			      	page: "page", //calls first
			      	total: "total" ,//calls Second
			      	records: "records" //calls Third
				},
				caption: "Grading Details ",
				editurl: '/Myelclass/InspectionAction.do?event=grade',
		    	pager: '#inspgradpager',
		    	rowNum:6, 
		    	rowList:[2,4,6],
		        loadtext: "Bow Bow........... ",
		        height : "auto",
		        width:"auto",  
		        sortname: 'gradeid',  
		        sortorder: 'desc',  
		        emptyrecords: 'No records to display',
			});
		gradgrid.jqGrid('navGrid', '#inspgradpager',  { edit: true, add: true, del: true, 
			search: false, refresh: true, view: true },
			{			
				// Edit
				reloadAfterSubmit: true,
				closeAfterEdit: true,
			},
			{
				 beforeShowForm: function(form){
					  alert("Color "+clr);
					  $("#gradecolor").val(clr);
				 }, 
				reloadAfterSubmit: true,
				closeAfterAdd: true,
			}
			);

//Rejects Grid
rejgrid.jqGrid({  
	url:'/Myelclass/InspectionAction.do?event=reject',   
	datatype:"json",
	colNames:[ 'Arttype', 'id', 'RejectID ', 'InspID', 'ArticleID', 'Color ','Tot Passed','Substance','Size','Selec','Color','Org','Other','Tot Rejects','Tot Inspected'],  
    colModel:[ 
		{name:'arttype', index:'arttype', align:'center', width:120, editable:true, sortable: true, hidden: false, 
			edittype: 'select', editoptions: {value: {H:'Hides',S:'Sides',N:'NA'}},
		},
		{name:'id', index:'id', align:'center', width:120, editable:true, sortable: true,  hidden: false, 
	
		},
		{name:'rejectid', index:'rejectid',align:'center', width:120, editable:true, sortable: true,  hidden: false, 
				
		}, 
		{name:'inspid', index:'inspid', align:'center', width:120, editable:true, sortable: true,  hidden: false, 
			
		},
		{name:'articleid', index:'articleid', align:'center', width:120, editable:true, sortable: true,  hidden: false, 
			
		},
		
		{name:'rejcolor', index:'rejcolor', align:'center', width:80, editable:true, sortable: true, hidden:false, 
			
		},
		{name:'totpassed', index:'totpassed', align:'center', width:80, editable:true, sortable: true, hidden:false, 
			
		},
		{name:'subsrejects', index:'subsrejects', align:'center', width:60, editable:true, sortable: true, hidden:false, 
			
		},	
		{name:'sizerejects', index:'sizerejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			
		},
		{name:'selecrejects', index:'selecrejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			
		},			
		{name:'colorrejects', index:'colorrejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			
		},	
		{name:'orgrejects', index:'orgrejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			
		},	
		{name:'otherrejects', index:'otherrejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			
		},
		{name:'totrejects', index:'totrejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			
		},	
		{name:'totinspected', index:'totinspected', align:'center', width:120, editable:true, sortable: true, hidden:false, 
			
		},
	],  
	jsonReader : {  
	  	repeatitems:false,
      	root: "rows",
      	page: "page", //calls first
      	total: "total" ,//calls Second
      	records: "records" //calls Third
	},
	caption: "Rejects Details ",
	editurl: '/Myelclass/InspectionAction.do?event=reject',
	pager: '#insprejpager',
	rowNum:6, 
	rowList:[2,4,6],
    loadtext: "Bow Bow........... ",
    height : "auto",
    width:"auto",  
    sortname: 'rejectid',  
    sortorder: 'desc',  
    emptyrecords: 'No records to display',
});
	rejgrid.jqGrid('navGrid', '#insprejpager',  { edit: true, add: true, del: true, 
		   search: false, refresh: false, view: false },
		{ 
		  reloadAfterSubmit: true,
		  closeAfterEdit: true,					
		},
		{
			 beforeShowForm: function(form){
				  alert("Color "+clr);
				  $("#rejcolor").val(clr);		 
			 },
		  reloadAfterSubmit: true,
		  closeAfterAdd: true,
		});
rejgrid.jqGrid('setGroupHeaders', {
	  useColSpanStyle: false, 
	  groupHeaders:[
		{startColumnName: 'subsrejects', numberOfColumns: 7, titleText: '<em>Rejects</em>'},
	  ]
	});
	
//AUTOCOMPLETE			
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
         	var ctno = $('#inps_ContractNumber').val();
         	artgrid.jqGrid('setGridParam',{url:"/Myelclass/InspectionAction.do?event=loadarticle&ctno="+ctno}).trigger("reloadGrid");
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
		     						<h:text property="inps_contractnumber" styleId="inps_ContractNumber"></h:text><br />	
          												
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
		    <fieldset> 	 	
		     	<legend>Contract Details</legend>
		    	<table id="insp_Ctdetails"></table>
		    		<div id="insp_CtDetalspager"></div>
		      </fieldset> 
		   	</td>
		     </tr>
		    </table>
	          <div>Please make sure you check the following before Inspection of Goods</div>
	            <h:textarea  property="insp_cdn" styleId="insp_cdn" rows="4" cols="100"></h:textarea>	           
	             <fieldset> 	 	
		     	  <legend>Test Details</legend>
	            	<table id="insptesttbl"></table>
	            	<div id="insptestpager"></div>
	            </fieldset>	         
	            
	          <fieldset> 	 	
		     	<legend>Grading</legend>
	          	<table id="inspgradtbl"></table>
		     		<div id="inspgradpager"></div>
	         </fieldset> 
	         	
	          <fieldset> 	 	
		     	<legend>Rejects</legend>
		     	<table id="insprejtbl"></table>
		     	<div id="insprejpager"></div>
              </fieldset> 
	        
	          <table width="1200" border="2" cellspacing="0" cellpadding="0">
	           	 <tr>
	              <td height="15">Comments</td>	  	                           
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