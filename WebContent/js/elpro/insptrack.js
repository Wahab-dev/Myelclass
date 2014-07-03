$(function() { 	
	insptrackgrid = $("#insptracktbl") ;
	 $('#chngroup').change(function(){
			var vl = $(this).val();
			if(vl){
				if(vl == "clear"){
					insptrackgrid.jqGrid('groupingRemove',true);	
				}else{
					insptrackgrid.jqGrid('groupingGroupBy', vl, {
						groupOrder : ['asc'],
						groupText : ['<b>{0} - {1} Records</b>'],
						groupSummary : [true],
						groupColumnShow: [false],
						groupingView: {
							groupCollapse: [true],
						}
				    });
				}	
			}else{
				alert("Please Select field to Group");
			}
		}); 
	insptrackgrid.jqGrid({ 
		datatype: 'json',
        url:"/Myelclass/InspectionTracGridAction.do?action=load", 
        colNames:['ID','CtNo','Inspn Dt','QC','Article','Color','TestID','GradeID','RejID','Inspctd',
                  'Grade1','Grade2','Grade3','Grade4','Grade5','Imprvmnt','Rejects','Passed',
                  'Comments','Inspn Condition'	
                  ],  
    	colModel :[ 
			{name:'inspid', index:'inspid', align:'center', width:35, editable:true, sortable: true, hidden:false, search: true,
				
			},
			{name:'inspContractNo', index:'inspContractNo',  width:60, align:'center', editable:true, sortable: true, hidden:false, search: true,
				
			},
			{name:'inspdate', index:'inspdate', align:'center',  width:60, editable:true, sortable: true, hidden:false, search: true, 
				
			},
			{name:'inspqualityctrlr', index:'inspqualityctrlr', width:70,  align:'center', editable:true, sortable: true, hidden:false, search: true, 
				
			},
			{name:'article', index:'article',  align:'center', width:100, editable:true, sortable: true, hidden:false, search: true, 
				
			},
			{name:'color', index:'color', align:'center', width:100, editable:true, sortable: true, hidden:false, search: true, 
				
			},
			{name:'testid', index:'testid', align:'center', width:35, editable:true, sortable: true, hidden:false, search: true, 
				
			},
			{name:'gradeid', index:'gradeid', align:'center', width:30, editable:true, sortable: true, hidden:true, search: true, 
				
			},
			{name:'rejectid', index:'rejectid', align:'center',width:30,  editable:true, sortable: true, hidden:true, search: true, 
				
			},
			{name:'rjtotinspected', index:'rjtotinspected', align:'center', width:45, editable:true, sortable: true, hidden:false, search: true, 
				
			},
			{name:'skincount1', index:'skincount1', align:'center', width:45, editable:true, sortable: true, hidden:false, search: true,
				
			},
			{name:'skincount2', index:'skincount2', align:'center', width:45, editable:true, sortable: true, hidden:false, search: true,
				
			},
			{name:'skincount3', index:'skincount3', align:'center', width:45, editable:true, sortable: true, hidden:false, search: true,
				
			},
			{name:'skincount4', index:'skincount4', align:'center', width:45, editable:true, sortable: true, hidden:false, search: true, 
				
			},
			{name:'skincount5', index:'skincount5', align:'center', width:45, editable:true, sortable: true, hidden:false, search: true,
				
			},
			{name:'skincount6', index:'skincount6', align:'center', width:45, editable:true, sortable: true, hidden:false, search: true,
				
			},
			{name:'totrejects', index:'totrejects', align:'center', width:45, editable:true, sortable: true, hidden:false, search: true, 
				
			},
			{name:'totpassed', index:'totpassed', align:'center', width:45, editable:true, sortable: true, hidden:false, search: true, 
				
			},
			{name:'inspcomments', index:'inspcomments', align:'center', width:250, editable:true, sortable: true, hidden:false, search: true,
				
			},
			{name:'insp_cdn', index:'insp_cdn', align:'center', width:250, editable:true, sortable: true, hidden:false, search: true,
				
			},
    	],
		jsonReader : {  
		  	repeatitems:false,
		    root: "rows",
		    page: "page", //calls first
		    total: "total" ,//calls Second
		    records: "records" //calls Third
		},
		caption: "Inspection Tracking Details ",
		loadtext: "Inspection Tracking is Loading", 
		pager: '#insptrackpager',
		rowNum:500, 
		rowList:[20,50,100,200,500,1000],
		rownumbers: true,
		height : "360",
		width: "auto",
		sortname: 'inspid',
		sortorder: 'desc',
		loadonce: true,
		ignoreCase:true,
		hidegrid: false,
		//editurl: "/Myelclass/BulkInsertAction.do",
		sortable: true,
		toppager:true,
		gridview : true,
		viewrecords: true,
		footerrow: true,
		altRows: true, 
	    emptyrecords: 'No records to display',
	    loadComplete: function () {
          /*var $self = $(this),
          totinspsum = $self.jqGrid("getCol", "rjtotinspected", false, "sum");
          totpasssum = $self.jqGrid("getCol", "totpassed", false, "sum");
          totrejsum = $self.jqGrid("getCol", "totrejects", false, "sum");
          $self.jqGrid("footerData", "set", {rjtotinspected: totinspsum});
          $self.jqGrid("footerData", "set", {totpassed: totpasssum}); 
          $self.jqGrid("footerData", "set", {totrejects: totrejsum});*/
        }
	 });
	insptrackgrid.jqGrid('navGrid','#insptrackpager',{
	 	edit: true, add: false, del: false, search: true, view: true, cloneToTop:true,
	 	addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View',
		beforeRefresh: function(){
			bulkgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		},	
	},{},{},{},
	{
	 		multipleSearch:true,
	 		stringResult  :true,
	 		multipleGroup:true,
	 	}	
	);

	insptrackgrid.jqGrid('navButtonAdd',"#insptrackpager",{caption:"Toggle",title:"Toggle Search Toolbar", buttonicon :'ui-icon-pin-s',
		onClickButton:function(){
			insptrackgrid[0].toggleToolbar();
		} 
	});
	insptrackgrid.jqGrid('navButtonAdd',"#insptrackpager",{caption:"Clear",title:"Clear Search",buttonicon :'ui-icon-refresh',
		onClickButton:function(){
			insptrackgrid[0].clearToolbar();
		} 
	});
	insptrackgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, stringResult: true}); 
	insptrackgrid.jqGrid('navButtonAdd', '#insptrackpager', {
        caption: "Pdf",
        buttonicon: "ui-icon-print",
        title: "Print in PDF Format",
        onClickButton: downloadPdf,
    }).jqGrid('navButtonAdd', '#insptrackpager', {
        caption: "Excel",
        buttonicon: "ui-icon-print",
        title: "Print in Excel Format",
        onClickButton: downloadExcel,
    });
	 //Bootom Pager Customization
	  var bottomPagerDiv = $("div#insptrackpager")[0];
	  $("#view_" + insptrackgrid[0].id, bottomPagerDiv).remove();
	  $("#search_" + insptrackgrid[0].id, bottomPagerDiv).remove(); 
	  $("#refresh_" + insptrackgrid[0].id, bottomPagerDiv).remove(); 
	  $("#edit_" + insptrackgrid[0].id, bottomPagerDiv).remove(); 
		
	
	/*
	*  Function to print the Master Page 
	*/
	
	function downloadPdf() 
	{
	download('pdf');
	}
	function downloadExcel() 
	{
	download('xls');
	}
	function download(type){
		//var data = mastergrid.jqGrid('getGridParam', 'postData');
		//alert(data);
		printurl = "/Myelclass/InspectionTracGridAction/PrintReports.do?&type="+type;
		alert(printurl);
		//start the Download
		window.location = printurl;
		
		
		// Show progress dialog
		$('#msgbox').text('Processing download...');
		$('#msgbox').dialog({	
			title: 'Download',
			modal: true,
			buttons: {"Close": function()  {
						$(this).dialog("close");
					} 
				}
		});
	}
});