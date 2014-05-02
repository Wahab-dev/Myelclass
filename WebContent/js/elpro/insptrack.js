$(function() { 	
	insptrackgrid = $("#insptracktbl") ;
	 $('#chngroup').change(function(){
			var vl = $(this).val();
			if(vl){
				if(vl == "clear"){
					insptrackgrid.jqGrid('groupingRemove',true);	
				}else{
					insptrackgrid.jqGrid('groupingGroupBy', vl, {
				            groupOrder : ['desc'],
				            groupColumnShow: [false],
				            groupingView: {
				                groupCollapse: true
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
        colNames:['ID','CtNo','Inspn Dt','QC','ArticleID','Article','Color','Inspn Condition','Grade','Tot Inspected','Skin Count','Percentage','Passed','Rejects'],  
    	colModel :[ 
			{name:'inspid', index:'inspid', align:'center', width:60,  editable:true,  },
			{name:'inspContractNo', index:'inspContractNo',  width:60, align:'center', editable:true, },
			{name:'inspdate', index:'inspdate', align:'center',  width:60, editable:true,   },
			{name:'inspqualityctrlr', index:'inspqualityctrlr', width:80,  align:'center', editable:true, },
			{name:'articleid', index:'articleid',  align:'center', width:60,  editable:true, },
			{name:'article', index:'article', align:'center', editable:true,  },
			{name:'color', index:'color', align:'center', editable:true, },
			{name:'insp_cdn', index:'insp_cdn', align:'center', editable:true, },
			{name:'grade', index:'grade', align:'center', editable:true, },
			{name:'totinspected', index:'totinspected', align:'center', width:60, editable:true, },
			{name:'skincount', index:'skincount', align:'center', width:60, editable:true, },
			{name:'percent', index:'percent', align:'center', width:60, editable:true, },
			{name:'totpassed', index:'totpassed', align:'center', width:60, editable:true, },
			{name:'totrejects', index:'totrejects', align:'center', width:60, editable:true, }
    	],
		jsonReader : {  
		  	repeatitems:false,
		    root: "rows",
		    page: "page", //calls first
		    total: "total" ,//calls Second
		    records: "records" //calls Third
		},
		caption: "Contract Inspection Tracking Details ",
		pager: '#insptrackpager',
		rowNum:20, 
		rowList:[20,50,60],
	    loadtext: "Bow Bow........... ",
	    height : "auto",
        width: "auto",  
	    sortname: 'inspContractNo',  
	    sortorder: 'desc',
	    viewrecords: true,
	    sortable: true,
        gridview: true , // if used cant use subgrid, treegrid and aftertInsertRow 
	    footerrow: true,
        loadonce: true,
        grouping:true, 
        groupingView : { groupField : ['inspContractNo'] },
	    emptyrecords: 'No records to display',
	    loadComplete: function () {
          var $self = $(this),
          totinspsum = $self.jqGrid("getCol", "totinspected", false, "sum");
          totpasssum = $self.jqGrid("getCol", "totpassed", false, "sum");
          totrejsum = $self.jqGrid("getCol", "totrejects", false, "sum");
          $self.jqGrid("footerData", "set", {totinspected: totinspsum});
          $self.jqGrid("footerData", "set", {totpassed: totpasssum}); 
          $self.jqGrid("footerData", "set", {totrejects: totrejsum});
          
          
	    }
	 });
	insptrackgrid.jqGrid('navGrid','#insptrackpager',{
	 	edit: true,
	 	add: false,
	 	del: false, 
	 	search: true, 
		view: true, 
	});

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