<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sample Tracking Page</title>
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
 var strgrid = $('#sampletracktbl');
	strgrid.jqGrid({     
		datatype: "json",
   		url:"/Myelclass/SampleInsertAction.do", 
    	colNames:['Status','Sampleno','Order Date','Refno','priority','handledby','customerid','tanneryid','deliverid','agentid','destination','terms','add_date','cdd_date','splcdn','inspcdn','forwaderid','isinvraised','articleid','articletype','articleshform','articlename','color','size','substance','selection','selectionp','quantity','unit','colormatching','rate','pcs','tapetest','crockingwet','crockingdry','fourfolds','keytest','srfarticleid','rdd_date','courierdetails','reps','feedbackdetails','User'],  
    	colModel :[  
                {name: 'status', index: 'status', align:'center', width:35, editable:true, sortable: true, hidden:false,  
		  			edittype: 'select', 
		 			editoptions:{value:{0:'Select Status',P:'Pending',C:'Closed',CA:'Cancel',IC:'IC',S:'Shipped',D:'Delivered'},defaultValue: 'Pending'},
		  			editrules :{require : true},
	  			}, 
	  			{name: 'sampleno', index: 'sampleno', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'orderdt', index: 'orderdt', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'refno', index: 'refno', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'priority', index: 'priority', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'handledby', index: 'handledby', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'customerid', index: 'customerid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'tanneryid', index: 'tanneryid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'deliverid', index: 'deliverid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'agentid', index: 'agentid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'destination', index: 'destination', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'terms', index: 'terms', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'add_date', index: 'add_date', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'cdd_date', index: 'cdd_date', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'splcdn', index: 'splcdn', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'inspcdn', index: 'inspcdn', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'forwaderid', index: 'forwaderid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'isinvraised', index: 'isinvraised', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'articleid', index: 'articleid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'articletype', index: 'articletype', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'articleshform', index: 'articleshform', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'articlename', index: 'articlename', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'color', index: 'color', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'size', index: 'size', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'substance', index: 'substance', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'selection', index: 'selection', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'selectionp', index: 'selectionp', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'quantity', index: 'quantity', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'unit', index: 'unit', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'colormatching', colormatching: 'ctno', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'rate', index: 'rate', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'pcs', index: 'pcs', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'tapetest', index: 'tapetest', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'crockingwet', index: 'crockingwet', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'crockingdry', index: 'crockingdry', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'fourfolds', index: 'fourfolds', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'keytest', index: 'keytest', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'srfarticleid', index: 'srfarticleid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'rdd_date', index: 'rdd_date', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'courierdetails', index: 'courierdetails', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'reps', index: 'reps', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'feedbackdetails', index: 'feedbackdetails', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'user', index: 'user', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
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
	pager: '#sampletrackpager',
	rowNum:10, 
	rowList:[20,30,40],
	loadtext: "Bow Bow",
	height : "auto",
	width:"auto",  
	sortname: 'sampleno',  
	sortorder: 'desc',
	scroll: 1, //Check here
	editurl: "/Myelclass/SampleInsertAction.do",
	emptyrecords: 'No records to display',
	});
	strgrid.jqGrid('navGrid','#sampletrackpager',{
		 	edit: true,
		 	add: false,
		 	del: true, 
		 	search: true, 
		 	view: true, 
		 	//cloneToTop: true,
		 	
		 	}).navButtonAdd('#sampletrackpager',{
		 	   caption:"Status", 
		 	   buttonicon:"ui-icon-lightbulb", 
		 	   position:"last",
		 	   onClickButton: function(){ 
		 	    var $self = $(this);
		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
		 	    {
		 		 beforeShowForm: function(form) { 
		 			 
		 		 },
                  recreateForm: true,
                  editData: {//Function to Add parameters to the status 
				 		oper: 'status',
               },
               closeAfterEdit: true,
				reloadAfterSubmit: true,
		 	    });
		 	   
		 	   }
		 	}).navButtonAdd('#sampletrackpager',{
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
 	   		}).navButtonAdd('#sampletrackpager',{
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
		 	}).navButtonAdd('#sampletrackpager',{
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
   				<td><h:submit property="straction" value="Logout"></h:submit></td> 
   			</tr>
   		</table>
		<div id="blk">Sample Tracking</div> 
			<table id="sampletracktbl">
             </table> 
				<div id="sampletrackpager"></div> 
	</form>  
</body>
</html>