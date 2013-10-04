<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inspection Tracking Page</title>
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
	var insptrgrid = $('#insptracktbl');
	insptrgrid.jqGrid({    //17 cols
		datatype: "json",
   		//url:"/Myelclass/SampleInsertAction.do", 
    	colNames:['ID','Status','Ct No','Order Date','Q Ctlr','comments','cdn','gradingId','grade1percent','grade2percent','grade3percent','grade4percent','grade5percent','rejectsId','totalpassed','totalrejects','testId'],  
    	colModel :[ 
					{name: 'id', index: 'ID', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'status', index: 'Status', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'contractnumber', index: 'contractNumber', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'date', index: 'date', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'qualityctrlr', index: 'qualityctrlr', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'comments', index: 'comments', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'cdn', index: 'cdn', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'gradingid', index: 'gradingId', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'grade1percent', index: 'grade1percent', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'grade2percent', index: 'grade2percent', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'grade3percent', index: 'grade3percent', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'grade4percent', index: 'grade4percent', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'grade5percent', index: 'grade5percent', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'rejectsid', index: 'rejectsId', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'totalpassed', index: 'totalpassed', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'totalrejects', index: 'totalrejects', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
					{name: 'testid', index: 'testId', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					},
    	],
    	jsonReader : {  
    		repeatitems:false,
    		root: "rows",
    		page: "page", //calls first
    		total: "total" ,//calls Second
    		records: "records" //calls Third
    	},  
    	caption: "Inspection Tracking Report",
    	pager: '#insptrackpager',
    	rowNum:10, 
    	rowList:[20,30,40],
    	loadtext: "Bow Bow",
    	height : "auto",
    	width:"auto",  
    	sortname: 'contractNumber',  
    	sortorder: 'desc',
    	scroll: 1, //Check here
    	editurl: "/Myelclass/SampleInsertAction.do",
    	emptyrecords: 'No records to display',
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
		<div id="blk">Inspection Tracking</div> 
			<table id="insptracktbl">
             </table> 
				<div id="insptrackpager"></div> 
	</form> 

</body>
</html>