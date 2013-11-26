/*
 *
 *
 */
$(function() {
	
	var insptrackgrid = $("#insptracktbl");
	
	insptrackgrid.jqGrid({    
		url:"/Myelclass/InspectionTrackAction.do?event=load", //17 cols
		datatype: "json",
    	colNames:['ID','Status','CtNo','InspDate','QCtlr','ArticleID','Article','Color','InspCdn','testID','GradeId','RejID','TotInspctd','comments'],  
    	colModel :[ 
			{name: 'inspid', index: 'inspid', align:'center', width:60, editable: true, sortable: true, hidden: false,edittype:'text',},
			{name: 'status', index: 'status', align:'center', width:60, editable: true, sortable: true, hidden: false,edittype:'text',},
			{name: 'inspContractNo', index: 'contractno', align:'center', width:60, editable: true, sortable: true, hidden: false, edittype:'text',},
			{name: 'inspdate', index: 'inspdate', align:'center', width:60, editable: true, sortable: true, hidden: false, edittype:'text',},
			{name: 'inspqualityctrlr', index: 'qualitycontroller', align:'center', width:60, editable: true, sortable: true, hidden: false, edittype:'text',},
			{name: 'articleid', index: 'articleid', align:'center', width:60, editable: true, sortable: true, hidden: false, edittype:'text',},
			{name: 'article', index: 'article', align:'center', width:60, editable: true, sortable: true, hidden: false, edittype:'text',},
			{name: 'color', index: 'color', align:'center', width:60, editable: true, sortable: true, hidden: false, edittype:'text',},
			{name: 'inspcdn', index: 'inspcdn', align:'center', width:60, editable: true, sortable: true, hidden: false, edittype:'text',},
			{name: 'testid', index: 'testid', align:'center', width:60, editable: true, sortable: true, hidden: false, edittype:'text',},
			{name: 'gradeid', index: 'gradeid', align:'center', width:60, editable: true, sortable: true, hidden: false, edittype:'text',},
			{name: 'rejectsid', index: 'rejectsid', align:'center', width:60, editable: true, sortable: true, hidden: false, edittype:'text',},
			{name: 'totinspected', index: 'totinspected', align:'center', width:60, editable: true, sortable: true, hidden: false, edittype:'text',},
			{name: 'inspcomments', index: 'inspcomments', align:'center', width:60, editable: true, sortable: true, hidden: false, edittype:'text',},
    	],
    	jsonReader : {  
    		repeatitems: false,
    		root: "rows",
    		page: "page", 
    		total: "total" ,
    		records: "records" 
    	},  
    	editurl: "/Myelclass/InspectionTrackAction.do?event=edit",
    	caption: "Inspection Tracking Report",
    	pager: "#insptrackpager",
    	rowNum: 10, 
    	rowList:[20,30,40],
    	loadtext: "Bow Bow........... ",
    	 height : "auto",
 	    width:"auto",
    	sortname: "contractno", 
    	sortorder: "desc",
    	viewrecords: true,
        gridview: true,
    	
    	emptyrecords: "No records to display",
    	ondblClickRow: function(rowid) {
    		alert("Double Click ");
    		insptrackgrid.jqGrid('editGridRow', rowid); 
    	    /*$(this).jqGrid('editGridRow', rowid);*/
    	},
    	
    	onSelectRow: function (id) {
    	    $(this).jqGrid('viewGridRow', id);
    	}
    	});
	insptrackgrid.jqGrid('navGrid','#insptrackpager',{
		 	edit: true,
 		 	add: true,
 		 	del: true, 
 		 	search: true, 
 		 	refresh: true,
 		 	view: true, 
 		 	},
 		 {
 		 		/*
 		 		* Edit 
 		 		*/
 		 		 reloadAfterSubmit: true,
				 closeAfterEdit: true,
 		 		 
 		 }	
	);
});