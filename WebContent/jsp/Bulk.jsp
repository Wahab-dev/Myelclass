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

<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() { 
	var grid = $('#thelink'); 
	grid.click( function()
        {
		 	 $("#list").jqGrid({     
		 		datatype: "local",
		        //Used for client side Sorting 
		        loadonce: true,
		        height:'auto',  
		         mtype: 'GET',  
		        colNames:['Name','Color', 'Size','Substance', 'Selec','Selec P', 'Quantity','Unit', 'Price','Tc'],  
		        colModel :[   
				  {name:'article', index:'article', width:90, editable:true, edittype:'text'},
		          {name:'color', index:'color', width:80, align:'right', editable:true,edittype:'text'},  
		          {name:'size', index:'size', width:55, editable:true},   
		          {name:'substance', index:'substance', width:90, editable:true},   
		          {name:'selection', index:'selection', width:80, align:'right', editable:true},  
		          {name:'pcs', index:'pcs', width:90, editable:true},   
		          {name:'quantity', index:'	quantity', width:80, align:'right', editable:true},  
		          {name:'rate', index:'rate', width:55, editable:true},   
		          {name:'tc', index:'tc', width:90, editable:true},  
		          {name:'commision', index:'commision', width:90, editable:true}  
		        ],  
		        jsonReader : {  
		        	repeatitems:false,
		            root: function (jsonOrderArray) { return jsonOrderArray; },
		            page: function (jsonOrderArray) { return 1; },
		            total: function (jsonOrderArray) { return 1; },
		            records: function (jsonOrderArray) { return jsonOrderArray.length; }
		        },  
		       	caption: "Add Article",
		    	pager: '#pager',
		    	rowNum:10, 
		    	rowList:[10,12,15],
		        loadtext: "Bow Bow",
		        height : "auto",
		        width:"auto",  
		        sortname: 'article',  
		        sortorder: 'desc',  
		        toppager: false,
		        emptyrecords: 'No records to display',
		        });
		 	  jQuery("#list").jqGrid('navGrid','#pager',{
		 		 	edit:true,
		 		 	add:true,
		 		 	del:true, 
		 		 	search:true, 
		 		 	view:true, 
		 		 	}).navButtonAdd('#pager',{
		 		 	   caption:"Status", 
		 		 	   buttonicon:"ui-icon-add", 
		 		 	   onClickButton: function(){ 
		 		 	     alert("Adding Row");
		 		 	   }, 
		 		 	   position:"last"
		 		 	}).navButtonAdd('#pager',{
			 		 	   caption:"Modify", 
			 		 	   buttonicon:"ui-icon-add", 
			 		 	   onClickButton: function(){ 
			 		 	     alert("Adding Row");
			 		 	   }, 
			 		 	   position:"centre"
			 		 	});
		 	 });  
});

</script>
</head>
<body>
<form >
			<table id="list">
             </table> 
				<div id="pager"></div> 
	 <h:button property="artinsert" value="load" styleId="thelink"></h:button>   
	 </form>  
</body>
</html>