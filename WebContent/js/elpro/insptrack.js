$(function() {
	 initDateSearch = function (elem) {
         setTimeout(function () {
             $(elem).datepicker({
                 dateFormat: 'd-m-yy',
                 autoSize: true,
                 changeYear: true,
                 changeMonth: true,
                 showWeek: true,
                 showButtonPanel: true
             });
         }, 100);
     },	
	insptrackgrid = $("#insptracktbl") ;
	 $('#chngroup').change(function(){
			var vl = $(this).val();
			if(vl){
				if(vl == "clear"){
					insptrackgrid.jqGrid('groupingRemove',true,{
						groupColumnShow: [true]
					});	
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
	 var mydata = [
		    {inspid:"1",inspContractNo:"L6464",inspdate:"2014-05-05",inspqualityctrlr:"Mujahid",article:"Cow Soft Nappa",color:"Balck",
		    	testid:"1",gradeid:"1",rejectid:"1",rjtotinspected:"1500",skincount1:"500",skincount2:"500",skincount3:"500",skincount4:"0",
		    	skincount5:"0",skincount6:"0",totrejects:"0",totpassed:"1500",inspcomments:"NANNANA",insp_cdn:"REGBYVUHNJ"
		     },
		     {inspid:"21",inspContractNo:"L6464",inspdate:"2014-05-05",inspqualityctrlr:"Mujahid",article:"Cow Soft Nappa",color:"Balck",
			    	testid:"1",gradeid:"1",rejectid:"1",rjtotinspected:"1500",skincount1:"500",skincount2:"500",skincount3:"500",skincount4:"0",
			    	skincount5:"0",skincount6:"0",totrejects:"0",totpassed:"1500",inspcomments:"NANNANA",insp_cdn:"REGBYVUHNJ"
			 },
			 {inspid:"20",inspContractNo:"L6464",inspdate:"2014-05-05",inspqualityctrlr:"Mujahid",article:"Cow Soft Nappa",color:"Balck",
			    	testid:"1",gradeid:"1",rejectid:"1",rjtotinspected:"1500",skincount1:"500",skincount2:"500",skincount3:"500",skincount4:"0",
			    	skincount5:"0",skincount6:"0",totrejects:"0",totpassed:"1500",inspcomments:"NANNANA",insp_cdn:"REGBYVUHNJ"
			},
			 {inspid:"31",inspContractNo:"L6464",inspdate:"2014-05-05",inspqualityctrlr:"Mujahid",article:"Cow Soft Nappa",color:"Balck",
		    	testid:"1",gradeid:"1",rejectid:"1",rjtotinspected:"1500",skincount1:"500",skincount2:"500",skincount3:"500",skincount4:"0",
		    	skincount5:"0",skincount6:"0",totrejects:"0",totpassed:"1500",inspcomments:"NANNANA",insp_cdn:"REGBYVUHNJ"
		     },
		     {inspid:"12",inspContractNo:"L6464",inspdate:"2014-05-05",inspqualityctrlr:"Mujahid",article:"Cow Soft Nappa",color:"Balck",
			    	testid:"1",gradeid:"1",rejectid:"1",rjtotinspected:"1500",skincount1:"500",skincount2:"500",skincount3:"500",skincount4:"0",
			    	skincount5:"0",skincount6:"0",totrejects:"0",totpassed:"1500",inspcomments:"NANNANA",insp_cdn:"REGBYVUHNJ"
			 },
			 {inspid:"44",inspContractNo:"L6464",inspdate:"2014-05-05",inspqualityctrlr:"Mujahid",article:"Cow Soft Nappa",color:"Balck",
			    	testid:"1",gradeid:"1",rejectid:"1",rjtotinspected:"1500",skincount1:"500",skincount2:"500",skincount3:"500",skincount4:"0",
			    	skincount5:"0",skincount6:"0",totrejects:"0",totpassed:"1500",inspcomments:"NANNANA",insp_cdn:"REGBYVUHNJ"
			 },
		    
		  ]; 
	insptrackgrid.jqGrid({ 
		//datatype: 'local',
        //data: mydata,
		datatype: 'json',
        url:"/Myelclass/InspectionTracGridAction.do?action=load", 
        colNames:['ID','CtNo','Inspn Dt','QC','Article','Color','TestID','GradeID','RejID','Inspctd',
                  'Grade1','Grade2','Grade3','Grade4','Grade5','Imprvmnt','Rejects','Passed',
                  'Comments','Inspn Condition'	
                  ],  
    	colModel :[ 
			{name: 'inspid', index: 'inspid', align: 'center', width: 65, editable:true, //sortable: true, hidden:false, //search: true,
				//formatter: 'integer',
			},
			{name:'inspContractNo', index:'inspContractNo',  width:60, align:'center', editable:true, sortable: true, hidden:false, search: true,
				
			},
			{name:'inspdate', index:'inspdate', align:'center',  width:60, editable:true, sortable: true, hidden:false, search: true, 
				sorttype: 'date',
				formatter: 'date', formatoptions: { newformat: 'd-m-Y' }, editable: true, datefmt: 'd-M-Y',
                searchoptions: { sopt: ['eq', 'ne', 'lt', 'le', 'gt', 'ge'], dataInit: initDateSearch } 	
				
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
				fixed: true,
			},
			{name:'insp_cdn', index:'insp_cdn', align:'center', width:250, editable:true, sortable: true, hidden:false, search: true,
				fixed: true,
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
		//width: "360",
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
	   	  var $self = $(this),
          totinspsum = $self.jqGrid("getCol", "rjtotinspected", false, "sum");
          totpasssum = $self.jqGrid("getCol", "totpassed", false, "sum");
          totrejsum = $self.jqGrid("getCol", "totrejects", false, "sum");
          $self.jqGrid("footerData", "set", {rjtotinspected: totinspsum});
          $self.jqGrid("footerData", "set", {totpassed: totpasssum}); 
          $self.jqGrid("footerData", "set", {totrejects: totrejsum});
       }
	 });
	insptrackgrid.jqGrid('navGrid','#insptrackpager',{
	 	edit: true, add: false, del: false, search: false, view: false, cloneToTop:false,
	 	addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View',
		beforeRefresh: function(){
			insptrackgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
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
	insptrackgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, stringResult: true, defaultSearch : "cn"}); 
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
		
	
	
	  //Function to print the Master Page 
	
	
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
