<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bulk Page</title>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/ui-darkness/jquery-ui-1.10.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 
</style>
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() { 
	//Date Format 
	 $.extend(jQuery.jgrid.edit, {recreateForm: true,});
	 $.jgrid.edit.editCaption = "Edit Article"; 
	var bulkgrid = $('#bulkktracktbl');
	initDateEdit = function (elem) {
		//$(elem).css("font-size", "95%"); decrease the font siz e dynamically
		$(elem).datepicker({
        	beforeShowDay: function(date) {
        		/*
        		*Function 2 disable Sundays
        		*/
                var day = date.getDay();
                return [(day != 0), ''];
            },
        	autoSize: true,
		    changeMonth:false,
		    dateFormat: "d/mm/yy",
		    showWeek: true,
		    firstDay: 1,
		    numberOfMonths: 1,
		    showButtonPanel: true,
		    gotoCurrent:true, 
        });
      /*   $(elem).next('button.ui-datepicker-trigger').button({
            text: false,
            icons: {primary: 'ui-icon-calculator'}
        }).css({fontSize: '0.9em', width: '1.7em'})
        .find('span.ui-button-text')
        .css({padding: '0.1em'}); */
 
    },
    DateGrpEdit = function (elem) {
        $(elem).datepicker({
        	
        	autoSize: true,
		    changeMonth:false,
		    dateFormat: "yy/mm/d",
		    showWeek: true,
		    firstDay: 1,
		    numberOfMonths: 2,
		    showButtonPanel: true,
		    gotoCurrent:true, 
        });
    },
	
	bulkgrid.jqGrid({     
		 		datatype: "json",
		        url:"/Myelclass/BulkInsertAction.do", 
		        colNames:['Status','Ct No','Agent','Order Date','PO No','Tan','Cust','Exp','Name','Color','Size','Substance','Selection','Selp','Quantity','Unit','Shipped','Balance','Comment','InvDetails','Feedback','rdd date','Price','Tc','Add','Cdd','Commission','PO/JW','Consignee','Notify','Bank','Destination','Splcdn','Represnt','Prfarticleid','User'],  
		        colModel :[   
				  {name: 'status', index: 'status', align:'center', width:35, editable:true, sortable: true, hidden:false,  
					  edittype: 'select', 
					  editoptions:{value:{0:'Select Status',P:'Pending',C:'Closed',CA:'Cancel',PS:'Partial Ship',S:'Shipped',D:'Delivered'},defaultValue: 'Pending'},
					  editrules :{require : true},
					  formoptions : {
							rowpos : 1,
							colpos: 1,
						},
				  },
				  {name: 'ctno', index: 'ctno', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					  editrules :{require : true},
					  formoptions : {
							rowpos : 1,
							colpos: 2,
						},
				  },
				  {name: 'agent', index: 'agent', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					  editrules :{require : true},
					  formoptions : {
							rowpos : 2,
							colpos: 1,
						},
				  },
				  {name: 'orderdt', index: 'orderdt', align:'center', width:65, editable:true, sortable: true, hidden:false, 
					  sorttype: 'date',
					 formatter: 'date', datefmt: 'd/m/Y',formatoptions: {newformat: 'd/m/Y'}, 
					 editoptions: { size: 12,
			              maxlengh: 12, dataInit: initDateEdit, },
					 editrules :{require : true,},
					 formoptions : {
							rowpos : 2,
							colpos: 2,
						},
				  },
				  {name: 'pono', index: 'pono', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
					  formoptions : {
							rowpos : 3,
							colpos: 1,
						},
				  },
				  {name: 'tanneryid', index: 'tanneryid', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
					  formoptions : {
							rowpos : 3,
							colpos: 2,
						},
				  },
				  {name: 'customerid', index: 'customerid', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
					  formoptions : {
							rowpos : 4,
							colpos: 1,
						},
				  },
				  {name: 'exporterid', index: 'exprtr', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
					  formoptions : {
							rowpos : 4,
							colpos: 2,
						},
				  },
				  {name: 'articlename', index: 'articlename', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
					  formoptions : {
							rowpos : 5,
							colpos: 1,
						},
				  },
				  {name: 'color', index: 'color', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					 // editrules :{require : true},
					  formoptions : {
							rowpos : 5,
							colpos: 2,
						},
				  },
				  {name: 'size', index: 'size', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					//  editrules :{require : true},
					  formoptions : {
							rowpos : 6,
							colpos: 1,
						},
				  },
				  {name: 'substance', index: 'substance', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					 // editrules :{require : true},
					  formoptions : {
							rowpos : 6,
							colpos: 2,
						},
				  },
				  {name: 'selection', index: 'selection', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
					  formoptions : {
							rowpos : 7,
							colpos: 1,
						},
				  },
				  {name: 'selectionpercent', index: 'selectionpercent', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
					  formoptions : {
							rowpos : 7,
							colpos: 2,
						},
				  },
				  {name: 'quantity', index: 'quantity', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
					  formoptions : {
							rowpos : 8,
							colpos: 1,
						},
				  },
				  {name: 'unit', index: 'unit', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
					  formoptions : {
							rowpos : 8,
							colpos: 2,
						},
				  },
				  {name: 'qtyshpd', index: 'shpd', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
					  formoptions : {
							rowpos : 9,
							colpos: 1,
						},
				  },
				  {name: 'qbal', index: 'bal', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					//  editrules :{require : true},
					  formoptions : {
							rowpos : 9,
							colpos: 2,
						},
				  },
				  {name: 'comments', index: 'comments', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  edittype: 'textarea', 
					  editrules :{require : true},
					  formoptions : {
							rowpos : 10,
							colpos: 1,
						},
				  },
				  {name: 'invdetails', index: 'invdetails', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  edittype: 'textarea',
					  editrules :{require : true},
					  formoptions : {
							rowpos : 10,
							colpos: 2,
						},
				  },
				  {name: 'feddback', index: 'feddback', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  
					  edittype: 'textarea', 
					  editrules :{require : true},
					  formoptions : {
							rowpos : 11,
							colpos: 1,
						},
				  },
				  {name: 'rdd_date', index: 'rdd_date', classes:'dategrp', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  sorttype: 'date',
					  formatter: 'date', datefmt: 'Y/m/d',formatoptions: {newformat: 'Y/m/d'}, 
					  editoptions: { dataInit: DateGrpEdit },
					  editrules :{require : true},
					  formoptions : {
							rowpos : 11,
							colpos: 2,
						},
				  },
				  {name: 'rate', index: 'rate', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
					  formoptions : {
							rowpos : 12,
							colpos: 1,
						},
				  },
				  {name: 'tc', index: 'tc', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					 // editrules :{require : true},
					  formoptions : {
							rowpos : 12,
							colpos: 2,
						},
				  },
				  {name: 'add_date', index: 'add', classes:'dategrp',align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  sorttype: 'date',
					  formatter: 'date', datefmt: 'd/m/Y',formatoptions: {newformat: 'd/m/Y'},
					  editoptions: { dataInit: DateGrpEdit },
					  editrules :{require : true},
					  formoptions : {
							rowpos : 13,
							colpos: 1,
						},
				  },
				  {name: 'cdd_date', index: 'cdd', classes:'dategrp', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  sorttype: 'date',
					  formatter: 'date', datefmt: 'd/m/Y',formatoptions: {newformat: 'd/m/Y'}, 
					  editoptions: { dataInit: DateGrpEdit },
					  editrules :{require : true},
					  formoptions : {
							rowpos : 13,
							colpos: 2,
						},
				  },
				  {name: 'commission', index: 'comm', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					 // editrules :{require : true},
					  formoptions : {
							rowpos : 14,
							colpos: 1,
						},
				  },
				  {name: 'pojw', index: 'pojw', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					    editrules :{require : true},
					    formoptions : {
							rowpos : 14,
							colpos: 2,
						},
				  },
				  {name: 'consigneeid', index: 'consig', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					 // editrules :{require : true},
					  formoptions : {
							rowpos : 15,
							colpos: 1,
						},
				  },
				  {name: 'notifyid', index: 'notify', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					 // editrules :{require : true},
					  formoptions : {
							rowpos : 15,
							colpos: 2,
						},
				  },
				  {name: 'bankid', index: 'bank', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
					  formoptions : {
							rowpos : 16,
							colpos: 1,
						},
				  },
				  {name: 'destination', index: 'desti', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					 //editrules :{require : true},formoptions : {
					formoptions : {
						rowpos : 16, 
						colpos: 2,
					},
				  },
				  
				  {name: 'splcdn', index: 'splcdn', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  
					  edittype: 'textarea', 
					  editrules :{require : true},
					  formoptions : {
							rowpos : 17, 
							colpos: 1,
						},
				  },
				  {name: 'reps', index: 'rep', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
					  formoptions : {
							rowpos : 17, 
							colpos: 2,
						},
				  },
				 
				  {name: 'prfarticleid', index: 'prfartid', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					 // editrules :{require : true},
					  formoptions : {
							rowpos : 18, 
							colpos: 1,
						},
				  },
				  {name: 'user', index: 'user', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					 // editrules :{require : true},
					  formoptions : {
							rowpos : 18, 
							colpos: 2,
						},
				  },
		         
		        ],  
		        jsonReader : {  
				  	repeatitems:false,
			      	root: "rows",
			      	page: "page", //calls first
			      	total: "total" ,//calls Second
			      	records: "records" //calls Third
				},  
		       	caption: "Bulk Tracking Report",
		    	pager: '#bulkktrackpager',
		    	rowNum:10, 
		    	rowList:[20,30,40],
		        loadtext: "Bow Bow",
		        height : "auto",
		        width:"auto",  
		        sortname: 'Ctno',  
		        sortorder: 'desc',
		        scroll: 1, //Check here
		        editurl: "/Myelclass/BulkInsertAction.do",
		        //grouping:true, 
		        // groupingView : { groupField : ['ctno','articlename'] }, //sub grouping
		       // groupingView : { groupField : ['ctno'] },
		       // toppager: true,
		        emptyrecords: 'No records to display',
		        });
			bulkgrid.jqGrid('navGrid','#bulkktrackpager',{
		 		 	edit: true,
		 		 	add: false,
		 		 	del: true, 
		 		 	search: true, 
		 		 	view: true, 
		 		 	//cloneToTop: true,
		 		 	
		 		 	}).navButtonAdd('#bulkktrackpager',{
		 		 	   caption:"Status", 
		 		 	   buttonicon:"ui-icon-lightbulb", 
		 		 	   position:"last",
		 		 	   onClickButton: function(){ 
		 		 	    var $self = $(this);
		 		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
		 		 	    {
		 		 		 /* beforeInitData: function(formid) {
		 		 			bulkgrid.setColProp('status', {
		 		 				formoptions : {
									rowpos : 1,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('ctno', {
		 		 				formoptions : {
									rowpos : 1,
									colpos: 2,
								},
								
							});
		 		 			bulkgrid.setColProp('tanneryid', {
		 		 				formoptions : {
									rowpos : 2,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('customerid', {
		 		 				formoptions : {
									rowpos : 2,
									colpos: 2,
								},
								
							});
		 		 			bulkgrid.setColProp('articlename', {
		 		 				formoptions : {
									rowpos : 6,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('color', {
		 		 				formoptions : {
									rowpos : 6,
									colpos: 2,
								},
								
							});
		 		 			bulkgrid.setColProp('size', {
		 		 				formoptions : {
									rowpos : 7,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('quantity', {
		 		 				formoptions : {
									rowpos : 7,
									colpos: 2,
								},
								
							});
		 		 			bulkgrid.setColProp('cdd_date', {
		 		 				formoptions : {
									rowpos : 9,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('add_date', {
		 		 				formoptions : {
									rowpos : 9,
									colpos: 2,
								},
								
							});
		 		 			 bulkgrid.setColProp('rdd_date', {
		 		 				formoptions : {
									rowpos : 10,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('reps', {
		 		 				formoptions : {
									rowpos : 10,
									colpos: 2,
								},
								
							});
		 		 			bulkgrid.setColProp('comments', {
		 		 				formoptions : {
									rowpos : 11,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('splcdn', {
		 		 				formoptions : {
									rowpos : 11,
									colpos: 2,
								},
								
							});
		 		 			bulkgrid.setColProp('invdetails', {
		 		 				formoptions : {
									rowpos : 20,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('feddback', {
		 		 				formoptions : {
									rowpos : 20,
									colpos: 2,
								},
								
							});
		 		 			 			
						},   */
		 		 		 beforeShowForm: function(form) { 
		 		 			 $("#tr_agent").hide();
		 		 			 $("#tr_pono").hide(); 
		 		 			 $("#tr_orderdt").hide();
		 		 			 $("#tr_exporterid").hide(); 
		 		 			 $("#tr_substance").hide();
		 		 			 $("#tr_selection").hide(); 
		 		 			 $("#tr_selectionpercent").hide();
		 		 			 $("#tr_unit").hide(); 
		 		 			 $("#tr_rate").hide(); 
		 		 			 $("#tr_tc").hide(); 
		 		 			 $("#tr_commission").hide();
		 		 			 $("#tr_consigneeid").hide();
		 		 			 $("#tr_notifyid").hide();
		 		 			 $("#tr_bankid").hide(); 
		 		 			 $("#tr_destination").hide();
		 		 			 $("#tr_prfarticleid").hide(); 
		 		 			 $("#tr_user").hide();
		 		 			 $("#tr_qtyshpd").hide(); 
		 		 			 $("#tr_qbal").hide(); 
		 		 			 $("#tr_pojw").hide();
		 		 			 
		 		 			 $("#ctno").attr("readonly","readonly"); 
		 		 			 $("#agent").attr("readonly","readonly"); 
		 		 			 $("#articlename").attr("readonly","readonly"); 
		 		 			 $("#color").attr("readonly","readonly"); 
		 		 			 $("#tanneryid").attr("readonly","readonly"); 
		 		 			 $("#customerid").attr("readonly","readonly"); 
		 		 			 $("#size").attr("readonly","readonly"); 
		 		 			 $("#quantity").attr("readonly","readonly");  
		 		 			//$("#quantity").attr("readonly","readonly"); 
		 		 		 },
       	                   recreateForm: true,
       	                   editData: {//Function to Add parameters to the status 
 						 		oper: 'status',
                           },
                           closeAfterEdit: true,
           				reloadAfterSubmit: true,
		 		 	    });
		 		 	   
		 		 	   }
		 		 	}).navButtonAdd('#bulkktrackpager',{
			 		 	   caption:"Modify", 
			 		 	   buttonicon:"ui-icon-tag", 
			 		 	   onClickButton: function(){ 
			 		 		 var $self = $(this);
				 		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
				 		 		{ // some options
			       	                   recreateForm: true,
			       	                   editData: {//Function to Add parameters to the edit 
			 						 		oper: 'modify',
			                           },
					 		 	 });	   
				 		 			   
			 		 	   }, 
			 		 	   position:"centre"
			 	   }).navButtonAdd('#bulkktrackpager',{
		 		 	   caption:"Destination", 
		 		 	   buttonicon:"ui-icon-battery-2", 
		 		 	   onClickButton: function(){ 
		 		 		 var $self = $(this);
			 		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
			 		 		{ // some options
		       	                   recreateForm: true,
		       	                   editData: {//Function to Add parameters to the edit 
		 						 		oper: 'modify',
		                           },
				 		 	 });	   
			 		 			   
		 		 	   }, 
		 		 	   position:"centre"
		 		 	}).navButtonAdd('#bulkktrackpager',{
			 		 	   caption:"Print", 
			 		 	   buttonicon:"ui-icon-print", 
			 		 	   onClickButton: function(){ 
			 		 		 var $self = $(this);
				 		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
				 		 		{ // some options
			       	                   recreateForm: true,
			       	                   editData: {//Function to Add parameters to the edit 
			 						 		oper: 'modify',
			                           },
					 		 	 });	  	   
			 		 	   }, 
			 		 	   position:"centre"
			 		}); 
});

</script>
</head>
<body>
<form action="/Myelclass/login.do" method="post">
	<table width="812" border="1" cellspacing="0" cellpadding="0" >
   		<tr>  			
   			<td>Welcome ${user.name}...</td> 
   			<h:text property="userinsession" styleId="userinsession" value="${user.name}" readonly="true" ></h:text>
   			<td><h:submit property="btraction" value="Logout"></h:submit></td> 
   		</tr>
   </table>
	<div id="blk">Bulk Tracking</div> 
			<table id="bulkktracktbl">
             </table> 
				<div id="bulkktrackpager"></div> 
	 <%-- <h:button property="artinsert" value="load" styleId="thelink"></h:button>    --%>
	 </form>  
</body>
</html>