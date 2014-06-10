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
        colNames:['ID','CtNo','Inspn Dt','QC','Article','Color','TestID','GraddeID','Reject ID','Tot inspctd',
                  'Skin Ct1','Skin Ct2','Skin Ct3','Skin Ct4','Skin Ct5','Skin Ct6','Tot Rejects','Tot passd',
                  'Insp Comments','Inspn Condition'	],  
    	colModel :[ 
			{name:'inspid', index:'inspid', align:'center', width:60,  editable:true,  },
			{name:'inspContractNo', index:'inspContractNo',  width:60, align:'center', editable:true, },
			{name:'inspdate', index:'inspdate', align:'center',  width:60, editable:true,   },
			{name:'inspqualityctrlr', index:'inspqualityctrlr', width:60,  align:'center', editable:true, },
			{name:'article', index:'article',  align:'center', width:60,  editable:true, },
			{name:'color', index:'color', align:'center', width:60, editable:true,  },
			{name:'testid', index:'testid', align:'center', width:60, editable:true, },
			{name:'gradeid', index:'gradeid', align:'center', width:50, editable:true, },
			{name:'rejectid', index:'rejectid', align:'center',width:70,  editable:true, },
			{name:'rjtotinspected', index:'rjtotinspected', align:'center', width:60, editable:true, },
			{name:'skincount1', index:'skincount1', align:'center', width:60, editable:true, },
			{name:'skincount2', index:'skincount2', align:'center', width:60, editable:true, },
			{name:'skincount3', index:'skincount3', align:'center', width:60, editable:true, },
			{name:'skincount4', index:'skincount4', align:'center', width:60, editable:true, },
			{name:'skincount5', index:'skincount5', align:'center', width:60, editable:true, },
			{name:'skincount6', index:'skincount6', align:'center', width:60, editable:true, },
			{name:'totrejects', index:'totrejects', align:'center', width:60, editable:true, },
			{name:'totpassed', index:'totpassed', align:'center', width:60, editable:true, },
			{name:'inspcomments', index:'inspcomments', align:'center', width:60, editable:true, },
			{name:'insp_cdn', index:'insp_cdn', align:'center', width:60, editable:true, },
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
		loadtext: "Inspection Tracking is Loading", 
        width: "auto",  
		height : "360",
		rownumbers: true, 
	    sortname: 'inspContractNo',  
	    sortorder: 'desc',
	    viewrecords: true,
	    sortable: true,
        gridview: true , // if used cant use subgrid, treegrid and aftertInsertRow 
	    footerrow: true,
        loadonce: true,
        //grouping:true, 
        //groupingView : { groupField : ['inspContractNo'] },
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