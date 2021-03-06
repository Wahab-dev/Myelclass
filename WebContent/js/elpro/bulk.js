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


$(function() {
	$.extend(jQuery.jgrid.edit, {recreateForm: true,});
	$.jgrid.edit.editCaption = "Edit Article";
	var bulkgrid = $('#bulkktracktbl');
	
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
	
	/*initDateEdit = function (elem) {
		$(elem).datepicker({
			beforeShowDay: function(date) {
				
				 *Function 2 disable Sundays
				 
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
	},*/
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
			changeYear: true,
            changeMonth: true,
			numberOfMonths: 2,
			showButtonPanel: true,
			gotoCurrent:true,
		});
	},

	$('#chngroup').change(function(){
		var vl = $(this).val();
		if(vl){
			if(vl == "clear"){
				bulkgrid.jqGrid('groupingRemove',true,{
					groupColumnShow: [true]
				});				
			}else{
				bulkgrid.jqGrid('groupingGroupBy', vl, {
					groupOrder : ['asc'],
					groupText : ['<b>{0} - {1} Records</b>'],
					groupSummary : [true],
					groupColumnShow: [false],
					groupingView: {
						groupCollapse: [false],
					}
				});
			}	
		}else{
			alert("Please Select field to Group");
		}
	});


	bulkgrid.jqGrid({
		datatype: 'json',
		url:"/Myelclass/BulkInsertAction.do",
		colNames:['Status', 'Ct No', 'Agent', 'Order Date', 'PO No', 'Tannery', 'Exporter', 'Customer','Article Type', 'Article', 'Color', 'Size',
		          'Substance', 'Selection', 'Selp', 'Price', 'Quantity', 'Unit', 'Shipped', 'Balance', 'Comment', 'InvDetails',
		          'Customer Feedback', 'Tc', 'ADD', 'CDD', 'RDD', 'Commission', 'PO/JW', 'Consignee', 'Notify',
		          'Bank', 'Destination', 'Splcdn', 'Representative', 'Prfarticleid', 'User','ApplytoAll'
		          ],
		colModel :[
				          	{name: 'status', index: 'status', align: 'center', width:45, editable:true, sortable: true, hidden:false, classes: 'statusbgcolor', 
								search: true, stype:'select', searchrules:{required:true}, edittype: 'select',
								editoptions:{value:{P:'Pending',I:'Inspection',D:'Delivered',PS:'Partial Ship',S:'Shipped',RW:'Rework',AA:'Await Approval',AP:'Await Payment',C:'Closed',CA:'Cancel'},defaultValue: 'Pending'},
								searchoptions:{value:":All;P:Pending;I:Inspection;D:Delivered;PS:Partial Ship;S:Shipped;RW:Rework;AA:Await Approval;AP:Await Payment;C:Closed;CA:Cancel",sopt:['eq','ne'] },
								
						  	},
						  	{name: 'ctno', index: 'ctno', align:'center', width:60, editable:true, sortable: true, hidden:false, //frozen:true,
								editrules :{require : true}, formatter: "dynamicLink",
								formatoptions: {
										url: function (cellValue, rowId, rowData) {
											return '/Myelclass/LoadPrf.do'+ '?' +'action=editform&'+
											$.param({
												ctno: rowData.ctno
											});
											}
										 },
								/*cellattr: function (rowId, tv, rawObject, cm, rdata) {
										alert(rawObject[11]);
							                 //conditional formatting
							                     if (rawObject[11] > 0) {
							                         return 'style="background-color:#FFCCCC"';
							                     }
								},*/
								/*cellattr: function(cellValue) {
									var value = cellValue;
									alert(value);
									return (value.substring(0,2) == "L4") ? ' class="ui-state-error-text"' : '';
								},*/
								 /*formatter: function (cellvalue) {
					                            var color;
					                            var val = cellvalue;
					        
					                            if (val.substring(0,2) == "L4") {
					                                color = 'red';
					                            } else {
					                                color = 'green';
					                            }
					                            return '<span class="cellWithoutBackground" style="background-color:' + color + ';">' + cellvalue + '</span>';
					                        }*/
								
						  	},
						  	{name: 'agent', index: 'agent', align:'center', width:30, editable:true, sortable: true, hidden:true, search: true, stype:'text',
							      editrules :{require : true},	
							      /*
							       * Background color Change Based on value
							       */
							      /*formatter: function (cellvalue) {
			                            var color;
			                            var val = cellvalue;
			                            if (val == ("IC")) {
			                                color = '#E0E0FF';
			                            } else {
			                                color = '#FFF5FF';
			                            }
			                            return '<span class="cellWithoutBackground" style="background-color:' + color + ';">' + cellvalue + '</span>';
			                        }*/
						  	},
						  	{name: 'orderdt', index: 'orderdt', align:'center', width:65, editable:true, sortable: true, hidden: false, search: true, 								
								sorttype: 'date',
								//stype:'date',
								formatter: 'date', formatoptions: { newformat: 'd-m-Y' }, editable: true, datefmt: 'd-M-Y',
			                       // editoptions: { dataInit: initDateEdit },
			                        searchoptions: { sopt: ['eq', 'ne', 'lt', 'le', 'gt', 'ge'], dataInit: initDateSearch } 	
								
						  	},
							{name: 'pono', index: 'pono', align:'center', width:90, editable:true, sortable: true, hidden:true,
								editrules :{require : true},
							},
							{name: 'tanneryid', index: 'tanneryid', align:'center', width:60, editable:true, sortable: true, hidden:true, 
								editrules :{require : true},
							},
							{name: 'exporterid', index: 'exporterid', align:'center', width:90, editable:true, sortable: true, hidden:false, 
								//	editrules :{require : true},
							},
							{name: 'customerid', index: 'customerid', align:'center', width:60, editable:true, sortable: true, hidden:false,
								editrules :{require : true},
							},
							{name: 'articletype', index: 'articletype', align:'center', width:90, editable:true, sortable: true, hidden:false, // as per mary  req on 11-08-2014
								//	editrules :{require : true},
							},							
							{name: 'articlename', index: 'articlename', align:'center', width:90, editable:true, sortable: true, hidden:false,
							//	editrules :{require : true},
							},
							{name: 'color', index: 'color', align:'center', width:90, editable:true, sortable: true, hidden:false,
							//	editrules :{require : true},
							},
							{name: 'size', index: 'size', align:'center', width:50, editable:true, sortable: true, hidden:false,
							//	editrules :{require : true},
							},
							{name: 'substance', index: 'substance', align:'center', width:60, editable:true, sortable: true, hidden: false,
							//	editrules :{require : true},
							},
							{name: 'selection', index: 'selection', align:'center', width:40, editable:true, sortable: true, hidden:false,
							//	editrules :{require : true},
							},
							{name: 'selectionpercent', index: 'selectionpercent', align:'center', width:90, editable:true, sortable: true, hidden: true,
							//	editrules :{require : true},
							},
							{name: 'rate', index: 'rate', align:'right', width:90, editable:true, sortable: true, hidden: false,
							//	editrules :{require : true},
							},
							{name: 'quantity', index: 'quantity', align:'right', width:90, editable:true, sortable: true, hidden:false,
								summaryType:'sum', summaryTpl:'<b> {0}</b>',
							//	formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },
							},
							{name: 'unit', index: 'unit', align:'center', width:70, editable:true, sortable: true, hidden:true,
							//	editrules :{require : true},
							},
							{name: 'qshipped', index: 'qshipped', align:'right', width:50, editable:true, sortable: true, hidden: false,classes: 'qshpdbgcolor',
								summaryType:'sum', summaryTpl:'<b> {0}</b>',
							},
							{name: 'qbal', index: 'qbal', align:'right', width:50, editable:true, sortable: true, hidden:false, classes: 'qbalbgcolor',
							//	editrules :{require : true},
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
							//	editrules :{require : true},
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
							//	formatter: 'date', //datefmt: 'yy/MM/d',//formatoptions: {newformat: 'd-m-y'},
								editoptions: { dataInit: DateGrpEdit },
								editrules :{require : true},
							},
							{name: 'commission', index: 'commission', align:'center', width:90, editable:true, sortable: true, hidden: true,
							//	editrules :{require : true},
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
							//	editrules :{require : true},
							},
							{name: 'notifyid', index: 'notifyid', align:'center', width:90, editable:true, sortable: true, hidden: true,
							//	editrules :{require : true},
							},
							{name: 'bankid', index: 'bankid', align:'center', width:90, editable:true, sortable: true, hidden: true,
							//	editrules :{require : true},
							},
							{name: 'destination', index: 'destination', align:'center', width:90, editable:true, sortable: true, hidden: true,
							//	editrules :{require : true},formoptions : {
							},
							
							{name: 'splcdn', index: 'splcdn', align:'center', width:90, editable:true, sortable: true, hidden: true, viewable: true,
								edittype: 'textarea',
								editrules :{require : true},
							},
							{name: 'reps', index: 'reps', align:'center', width:90, editable:true, sortable: true, hidden: true,
								editrules :{require : true},
							},
							
							{name: 'prfarticleid', index: 'prfarticleid', align:'center', width:90, editable:true, sortable: true, hidden: true,
							//	editrules :{require : true},
							},
							{name: 'user', index: 'user', align:'center', width:50, editable:true, sortable: true, hidden: false,
							//	editrules :{require : true},
							},
							{name: 'isupdtar', index: 'isupdtart', align:'center', width:60, editable:true, sortable: true, hidden: true,
								edittype: 'checkbox', editoptions: { value:"True:False" },
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
		loadtext: "Bulk Tracking is Loading",
		pager: '#bulkktrackpager',
		rowNum: 1000,
		rowList: [20,50,100,200,500,1000],
		rownumbers: true,
		height : "360",
		width: "auto",
		sortname: 'Ctno',
		sortorder: 'desc',
		loadonce: true,
		ignoreCase:true,
		hidegrid: false,
		editurl: "/Myelclass/BulkInsertAction.do",
		sortable: true,
		toppager:true,
		gridview : true,
		viewrecords: true,
		footerrow: true,
		// scroll: 1, when Enabled it implements infinite Scrolling for the Biulk Tracking Report -- 
		altRows: true, // altrows and altclass for alternate color on grid rows
		emptyrecords: 'No records to display',
		loadComplete: function() {
			var $self = $(this),
			qty = $self.jqGrid("getCol", "quantity", false, "sum"),
			qshpd = $self.jqGrid("getCol", "qshipped", false, "sum"),
			
			bal = (parseFloat(qty) - parseFloat(qshpd));
			$self.jqGrid("footerData", "set", { status: "Total :",quantity: qty.toFixed(2)});
			$self.jqGrid("footerData", "set", { qshipped: qshpd.toFixed(2)});
			$self.jqGrid("footerData", "set", { qbal: bal.toFixed(2)});
		},
	});
	bulkgrid.jqGrid('navGrid','#bulkktrackpager',{
		edit: false, add: false, del: false, search: true, view: true, cloneToTop:true,
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View',
		beforeRefresh: function(){
			bulkgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		},	
	},{},{},{},
	{
		//Serach
	 	multipleSearch:true,
	 	stringResult  :true,
	 	multipleGroup:true,
	 },{
		 top : 50,
		 left : 100,
		 width : 350,
		 beforeShowForm: function(form) {
			$("#trv_splcdn").show();
			$("#trv_commission").show();	
		},
		 afterclickPgButtons: function(whichbutton, form, rowid) {
             $("#trv_splcdn").show();
             $("#trv_commission").show();
         }
	 }	
	);
	bulkgrid.jqGrid('navButtonAdd','#'+bulkgrid[0].id+'_toppager_left',{
		caption:"Status",
		buttonicon:"ui-icon-lightbulb",
		position:"first",
		onClickButton: function(){
			var $self = $(this);
			$self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
			{
				beforeShowForm: function(form) {
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
					$("#tr_add_date").hide();
					$("#tr_cdd_date").hide();
					
					$("#tr_pojw").hide();
					$("#tr_feddback").show();
					$("#tr_isupdtar").show();

					
					$("#tr_qshipped").show();
					$("#tr_qbal").show();
					$("#ctno").attr("readonly","readonly");
					$("#articlename").attr("readonly","readonly");
					$("#color").attr("readonly","readonly");
					$("#size").attr("readonly","readonly");
					$("#quantity").attr("readonly","readonly");
					$("#qshipped").attr("readonly","readonly");
					$("#qbal").attr("readonly","readonly");
				},
				recreateForm: true,
				editData: {//Function to Add parameters to the status
					oper: 'status',
				},
				//closeAfterEdit : true,
				//reloadAfterSubmit : true,
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
	});										//multipleSearch:true, multipleGroup:true, showQuery: true 
	bulkgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn",}); //Default Search as Contains //To Disable AutoSearch please change SearchonEnter to true


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
	bulkgrid.jqGrid('navButtonAdd',"#bulkktrackpager",{caption:"Column Chooser",buttonicon :'ui-icon-extlink',
		onClickButton:function(){
			bulkgrid.jqGrid('columnChooser', {
				done: function(perm) {
					if (!perm) { return false; }
					this.jqGrid('remapColumns', perm, true);
				}
			});
		}
	});
	
  //Bootom Pager Customization
  var bottomPagerDiv = $("div#bulkktrackpager")[0];
  $("#view_" + bulkgrid[0].id, bottomPagerDiv).remove();
  $("#search_" + bulkgrid[0].id, bottomPagerDiv).remove(); 
  $("#refresh_" + bulkgrid[0].id, bottomPagerDiv).remove(); 
	
   /*
	* Function to print the Master Page
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
		printurl = "/Myelclass/BulkAction/PrintReports.do?&type="+type;
		window.location = printurl;

		$('#msgbox').text('Processing download...');
		$('#msgbox').dialog({	
			title: 'Download',
			modal: true,
			buttons: {"Close": function() {
				$(this).dialog("close");
			}}
		});
	}	
});

