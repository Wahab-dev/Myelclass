/**
 *  
 */

/*global jQuery */
/*
 * Method to Add Dynamic url in Jqgrid Cell 
 * Contributed By Oleg from GITHub
 */
(function ($) {
    'use strict';
    /*jslint unparam: true */
    $.extend($.fn.fmatter, {
        dynamicLink: function (cellValue, options, rowData) {
            // href, target, rel, title, onclick
            // other attributes like media, hreflang, type are not supported currently
            var op = {url: '#'};

            if (typeof options.colModel.formatoptions !== 'undefined') {
                op = $.extend({}, op, options.colModel.formatoptions);
            }
            if ($.isFunction(op.target)) {
                op.target = op.target.call(this, cellValue, options.rowId, rowData, options);
            }
            if ($.isFunction(op.url)) {
                op.url = op.url.call(this, cellValue, options.rowId, rowData, options);
            }
            if ($.isFunction(op.cellValue)) {
                cellValue = op.cellValue.call(this, cellValue, options.rowId, rowData, options);
            }
            if ($.fmatter.isString(cellValue) || $.fmatter.isNumber(cellValue)) {
                return '<a' +
                    (op.target ? ' target=' + op.target : '') +
                    (op.onClick ? ' onclick="return $.fn.fmatter.dynamicLink.onClick.call(this, arguments[0]);"' : '') +
                    ' href="' + op.url + '">' +
                    (cellValue || '&nbsp;') + '</a>';
            } else {
                return '&nbsp;';
            }
        }
    });
    $.extend($.fn.fmatter.dynamicLink, {
        unformat: function (cellValue, options, elem) {
            var text = $(elem).text();
            return text === '&nbsp;' ? '' : text;
        },
        onClick: function (e) {
            var $cell = $(this).closest('td'),	
                $row = $cell.closest('tr.jqgrow'),
                $grid = $row.closest('table.ui-jqgrid-btable'),
                p,
                colModel,
                iCol;

            if ($grid.length === 1) {
                p = $grid[0].p;
                if (p) {
                    iCol = $.jgrid.getCellIndex($cell[0]);
                    colModel = p.colModel;
                    colModel[iCol].formatoptions.onClick.call($grid[0],
                        $row.attr('id'), $row[0].rowIndex, iCol, $cell.text(), e);
                }
            }
            return false;
        }
    });
}(jQuery));

////////////////////////////////////////////////////////////////////////////////////////////////
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
        	beforeShowDay: function(date) {
        		/*
        		*Function 2 disable Sundays
        		*/
                var day = date.getDay();
                return [(day != 0), ''];
            },
        	autoSize: true,
		    changeMonth:false,
		    dateFormat: "dd-mm-yy",
		    showWeek: true,
		    firstDay: 1,
		    numberOfMonths: 2,
		    showButtonPanel: true,
		    gotoCurrent:true, 
        });
    },
	
     $('#chngroup').change(function(){
		var vl = $(this).val();
		if(vl){
			if(vl == "clear"){
				bulkgrid.jqGrid('groupingRemove',true);	
			}else{
				bulkgrid.jqGrid('groupingGroupBy', vl, {
		            groupOrder : ['asc'],
		            groupColumnShow: [false],
				  groupingView: {
		            groupCollapse: [true],
				  }
		        });
			}	
		}else{
			alert("Please Select field to Group");
		}
	});  //shows total qty error
    
    
	bulkgrid.jqGrid({     
		 		datatype: 'json',
		        url:"/Myelclass/BulkInsertAction.do", 
		        colNames:['Status', 'Ct No', 'Agent', 'Order Date', 'PO No', 'Tannery', 'Customer', 'Exporter', 'Article', 'Color', 'Size', 
		                  	'Substance', 'Selection', 'Selp', 'Price', 'Quantity', 'Unit', 'Shipped', 'Balance', 'Comment', 'InvDetails', 
		                  	'Customer Feedback',  'Tc', 'ADD', 'CDD', 'RDD', 'Commission', 'PO/JW', 'Consignee', 'Notify', 
		                  	'Bank', 'Destination', 'Splcdn', 'Representative', 'Prfarticleid', 'User','ApplytoAll'
		                  	],     
		        colModel :[   
				  
				  {name: 'status', index: 'status', align:'center', width:45, editable:true, sortable: true, hidden:false, 
					  search: true, stype:'select', searchrules:{required:true},   	
					  edittype: 'select', 
					  editoptions:{value:{I:'Inspection', P:'Pending' ,PS:'Partial Ship',S:'Shipped',D:'Delivered',AA:'Await Approval',AP:'Await Payment',C:'Closed',CA:'Cancel'},defaultValue: 'Pending'},
					  //editrules :{require : true},
					  //searchoptions:{value:{P:'Pending',RW:'Rework', I:'Inspection', PS:'Partial Ship',S:'Shipped',D:'Delivered',AA:'Await Approval',AP:'Await Payment',C:'Closed',CA:'Cancel'}},
					  searchoptions:{value:":All;P:Pending;I:Inspection;PS:Partial Ship;D:Delivered;RW:Rework;S:Shipped;AA:Await Approval;AP:Await Payment;C:Closed;CA:Cancel"},
					   
				  },
				  {name: 'ctno', index: 'ctno', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					  editrules :{require : true},
					  formatter: "dynamicLink",
					    formatoptions: {
					        url: function (cellValue, rowId, rowData) {
					            return '/Myelclass/LoadPrf.do'+ '?' +'action=editform&'+
					                $.param({
					                    ctno: rowData.ctno
					                });
					        }
					    }
				  },
				  {name: 'agent', index: 'agent', align:'center', width:30, editable:true, sortable: true, hidden:true, search: true, stype:'text', 
					  editrules :{require : true},
					  
				  },
				  {name: 'orderdt', index: 'orderdt', align:'center', width:65, editable:true, sortable: true, hidden: false, search: true, stype:'date', 
					  /*searchoptions:{dataInit:datePick = function(elem)
						{
					   jQuery(elem).datepicker();
					}, attr:{title:'Select Date'}},*/
					  sorttype: 'date',
					//formatter: 'date', //datefmt: 'dd-mm-yy', formatoptions: {newformat: 'dd-mm-yy'}, 
					 editoptions: { size: 12,
			              maxlengh: 12, dataInit: initDateEdit, },
					 editrules :{require : true,},
				  },
				  {name: 'pono', index: 'pono', align:'center', width:90, editable:true, sortable: true, hidden:true,  
					  editrules :{require : true},
				  },
				  {name: 'tanneryid', index: 'tanneryid', align:'center', width:60, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'customerid', index: 'customerid', align:'center', width:60, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'exporterid', index: 'exprtr', align:'center', width:90, editable:true, sortable: true, hidden:true,  
					  //editrules :{require : true},
				  },
				  {name: 'articlename', index: 'articlename', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
				  },
				  {name: 'color', index: 'color', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					 // editrules :{require : true},
				  },
				  {name: 'size', index: 'size', align:'center', width:50, editable:true, sortable: true, hidden:false,  
					//  editrules :{require : true},
				  },
				  {name: 'substance', index: 'substance', align:'center', width:60, editable:true, sortable: true, hidden: false,  
					 // editrules :{require : true},
				  },
				  {name: 'selection', index: 'selection', align:'center', width:40, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
				  },
				  {name: 'selectionpercent', index: 'selectionpercent', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					  //editrules :{require : true},
				  },
				  {name: 'rate', index: 'rate', align:'center', width:90, editable:true, sortable: true, hidden: false,  
					  //editrules :{require : true},
				  },
				  {name: 'quantity', index: 'quantity', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
					  //formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },
				  },
				  {name: 'unit', index: 'unit', align:'center', width:70, editable:true, sortable: true, hidden:true,  
					  //editrules :{require : true},
				  },
				  {name: 'qshipped', index: 'qshipped', align:'center', width:50, editable:true, sortable: true, hidden: false,  
					  //editrules :{require : true},
				  },
				  {name: 'qbal', index: 'qbal', align:'center', width:50, editable:true, sortable: true, hidden:false,  
					//  editrules :{require : true},
				  },
				  {name: 'comments', index: 'Pro Stat', align:'center', width:90, editable:true, sortable: true, hidden:true,  
					  edittype: 'textarea', 
					  editrules :{require : true},
				  },
				  {name: 'invdetails', index: 'invdetails', align:'center', width:90, editable:true, sortable: true, hidden: false,  
					  edittype: 'textarea',
					  editrules :{require : true},
				  },
				  {name: 'feddback', index: 'feddback', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					  
					  edittype: 'textarea', 
					  editrules :{require : true},
				  },
				 
				 
				  {name: 'tc', index: 'tc', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					 // editrules :{require : true},
				  },
				  {name: 'add_date', index: 'add_date', align:'center', width:60, editable:true, sortable: true, hidden: false,  
					  sorttype: 'date',
					 /* formatter: 'date', datefmt: 'd/m/Y',formatoptions: {newformat: 'd/m/Y'},
					  editoptions: { dataInit: DateGrpEdit },*/
					  editrules :{require : true},
				  },
				  {name: 'cdd_date', index: 'cdd_date', align:'center', width:60, editable:true, sortable: true, hidden: false,  
					  sorttype: 'date',
					 /* formatter: 'date', datefmt: 'd/m/Y',formatoptions: {newformat: 'd/m/Y'}, 
					  editoptions: { dataInit: DateGrpEdit },*/
					  editrules :{require : true},
				  },
				  {name: 'rdd_date', index: 'rdd_date', align:'center', width:60, editable: true, sortable: true, hidden:false,  
					  sorttype: 'date',
					//  formatter: 'date', //datefmt: 'yy/MM/d',//formatoptions: {newformat: 'd-m-y'}, 
					  editoptions: { dataInit: DateGrpEdit },
					  editrules :{require : true},
				  },
				  {name: 'commission', index: 'commission', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					 // editrules :{require : true},
				  },
				  {name: 'pojw', index: 'pojw', align:'center', width:60, editable:true, sortable: true, hidden:false,  
					    editrules :{require : true},
					    formatter: "dynamicLink",
					    formatoptions: {
					        url: function (cellValue, rowId, rowData) {
					            return '/Myelclass/LoadPrf.do'+ '?' +'action=editform&'+
					                $.param({
					                    ctno: rowData.ctno
					                });
					        }
					    }
				  },
				  {name: 'consigneeid', index: 'consigneeid', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					 // editrules :{require : true},
				  },
				  {name: 'notifyid', index: 'notifyid', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					 // editrules :{require : true},
				  },
				  {name: 'bankid', index: 'bankid', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					  //editrules :{require : true},
				  },
				  {name: 'destination', index: 'destination', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					 //editrules :{require : true},formoptions : {
				  },
				  
				  {name: 'splcdn', index: 'splcdn', align:'center', width:90, editable:true, sortable: true, hidden: true,  					  
					  edittype: 'textarea', 
					  editrules :{require : true},
				  },
				  {name: 'reps', index: 'reps', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					  editrules :{require : true},
				  },
				 
				  {name: 'prfarticleid', index: 'prfarticleid', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					 // editrules :{require : true},
				  },
				  {name: 'user', index: 'user', align:'center', width:50, editable:true, sortable: true, hidden: false,  
					 // editrules :{require : true},
				  },
				  {name: 'isupdtar', index: 'isupdtart', align:'center', width:60, editable:true, sortable: true, hidden: true, 
						edittype: 'checkbox',  editoptions: { value:"True:False" },
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
		    	rowNum: 20, 
		    	rowList: [5,10,20,40,50,60,80,100,200,250,300],
		    	rownumbers: true,  
		    	loadtext: "Bulk Tracking is Loading",
		        height : "360",
		        width: "auto",  
		        sortname: 'Ctno',  
		        sortorder: 'desc',
		        loadonce: true,
		        //scroll: 1, //Check here
		        editurl: "/Myelclass/BulkInsertAction.do",
		        sortable: true,
		        toppager:true,
		        gridview : true,
		        viewrecords: true,
		        footerrow: true,
		        altRows: true,  // altrows and altclass for alternate color on grid rows
		        //userDataOnFooter : true, //Gets Footer Total Recod from Server Side 
		        loadComplete: function() {
		        	 var $self = $(this),
		        	 qty = $self.jqGrid("getCol", "quantity", false, "sum"),
		        	 qshpd = $self.jqGrid("getCol", "qshipped", false, "sum"),
		        	 bal = (parseFloat(qty) - parseFloat(qshpd));
		        	 $self.jqGrid("footerData", "set", {quantity: qty});
		        	 $self.jqGrid("footerData", "set", { qshipped: qshpd});
		        	 $self.jqGrid("footerData", "set", { qbal: bal});
		        },
		        emptyrecords: 'No records to display',
		        });
			
			bulkgrid.jqGrid('navGrid','#bulkktrackpager',{
		 		 	edit: false,
		 		 	add: false,
		 		 	del: false, 
		 		 	search: true, 
		 		 	view: true, 
		 		 	addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View',
		 		 		beforeRefresh: function(){
		 		 			bulkgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		 				}
		 		 	//cloneToTop: true,
		 		 	},
		 		 	{
		 		 		/*
		 		 		* Edit 
		 		 		*/
		 		 		 top: 50,
           				 left: 100,
           				 width : 'auto',	
           			},
		 		 	{
		 		 		/*
		 		 		* Add 
		 		 		*/
		 		 		 top: 50,
           				 left: 100,
           				 width : 'auto',	
		 		 	},
		 		 	{},
		 		 	{
		 		 		multipleSearch:true,
		 		 		stringResult  :true,
		 		 		multipleGroup:true,
		 		 	}		 		 	
				).navButtonAdd('#bulkktrackpager',{
		 		 	   caption:"Status", 
		 		 	   buttonicon:"ui-icon-lightbulb", 
		 		 	   position:"first",
		 		 	   onClickButton: function(){ 
		 		 	    var $self = $(this);
		 		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
		 		 	    {
		 		 		 beforeShowForm:  function(form) { 
		 		 			 $("#tr_agent").hide();
		 		 			 $("#tr_pono").hide(); 
		 		 			 $("#tr_orderdt").hide();
		 		 			 $("#tr_tanneryid").hide(); 
		 		 			 $("#tr_customerid").hide(); 
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
		 		 			 $("#tr_qshipped").hide(); 
		 		 			 $("#tr_qbal").hide(); 
		 		 			 $("#tr_pojw").hide();
		 		 			 $("#tr_feddback").show();
		 		 			 $("#tr_isupdtar").show();
		 		 			
		 		 			 
		 		 			 
		 		 			 $("#ctno").attr("readonly","readonly"); 
		 		 			 $("#articlename").attr("readonly","readonly"); 
		 		 			 $("#color").attr("readonly","readonly"); 
		 		 			 $("#size").attr("readonly","readonly"); 
		 		 			 $("#quantity").attr("readonly","readonly");
		 		 		 },
       	                   recreateForm: true,
       	                   editData: {//Function to Add parameters to the status 
 						 		oper: 'status',
                           },
                        closeAfterEdit : true,
           				reloadAfterSubmit : true,
           				top : 50,
           				left : 100,
           				width : 'auto',
		 		 	  });
		 		 	   
		 		 	   }
		 		 	});
			bulkgrid.jqGrid('navButtonAdd',"#bulkktrackpager",{caption:"Toggle",title:"Toggle Search Toolbar", buttonicon :'ui-icon-pin-s',
				onClickButton:function(){
					bulkgrid[0].toggleToolbar();
				} 
			});
			bulkgrid.jqGrid('navButtonAdd',"#bulkktrackpager",{caption:"Clear",title:"Clear Search",buttonicon :'ui-icon-refresh',
				onClickButton:function(){
					bulkgrid[0].clearToolbar();
				} 
			});
			bulkgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, stringResult: true});  //To Enable AutoSearch please comment Search on Enter to False
			
			
			bulkgrid.jqGrid('navButtonAdd', '#bulkktrackpager', {
		        caption: "Pdf",
		        buttonicon: "ui-icon-print",
		        title: "Print in PDF Format",
		        onClickButton: downloadPdf,
		    }).jqGrid('navButtonAdd', '#bulkktrackpager', {
		        caption: "EXCELOLD",
		        buttonicon: "ui-icon-print",
		        title: "Print in Excel Format",
		        onClickButton: downloadExcelold,
		    }).jqGrid('navButtonAdd', '#bulkktrackpager', {
		        caption: "Excel",
		        buttonicon: "ui-icon-print",
		        title: "Print in Excel Format",
		        onClickButton: downloadExcel,
		    });
			bulkgrid.jqGrid('navButtonAdd',"#bulkktrackpager",{caption:"columnChooser",title:"Column Chooser",buttonicon :'ui-icon-extlink',
				onClickButton:function(){

                	bulkgrid.jqGrid('columnChooser', {
                        done: function(perm) {
                            if (!perm) { return false; }
                            this.jqGrid('remapColumns', perm, true);                        	
                        }
                    });
				} 
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
			function downloadExcelold() 
			{
			download('xlsold');
			}
			function download(type){
				//var data = mastergrid.jqGrid('getGridParam', 'postData');
				//alert(data);
				printurl = "/Myelclass/BulkAction/PrintReports.do?&type="+type;
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
