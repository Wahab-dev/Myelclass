/**
 * 
 */
$(document).ready(function() {
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
	
///////////////////////////////////////////////////////////////////
	
	var debtrackgrid = $('#debittracktbl');
	
    $('#chngroup').change(function(){
		var vl = $(this).val();
		if(vl){
			if(vl == "clear"){
				debtrackgrid.jqGrid('groupingRemove',true);	
			}else{
				debtrackgrid.jqGrid('groupingGroupBy', vl, {
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
	
	 debtrackgrid.jqGrid({
		 url:'/Myelclass/DebitTrackInsertAction.do',
		 datatype: "json",
		 colNames:['Debit No','Debit date','Tannery','Ref no','Inv Date',
		           'Inv no','Ct No','Inv Amt','ExRate','Com','Price',
		           'Quantity','Comm in $','Comm in Rs','Service Tax','Total',
		           'TDS','Total Due'],
		 colModel:[
					{name: 'deb_debitno', index: 'deb_debitno' , align:'center', width:90, hidden: false, 
						 formatter: "dynamicLink",
						 formatoptions: {
						        url: function (cellValue, rowId, rowData) {
						            return '/Myelclass/gotodebit.do'+ '?' +'action=editdebform&'+
						                $.param({
						                	deb_debitno: rowData.deb_debitno
						                });
						        }
						    }	
					},
					{name: 'deb_debitdate', index: 'deb_debitdate' ,align:'center', width:70,  editable:true, sortable: true, hidden: false, search: true,
						sorttype: 'date',
						formatter: 'date', formatoptions: { newformat: 'd-m-Y' }, editable: true, datefmt: 'd-M-Y',
	                    searchoptions: { sopt: ['eq', 'ne', 'lt', 'le', 'gt', 'ge'], dataInit: initDateSearch } 							
					},
					{name: 'deb_exporter', index: 'deb_exporter', align:'center', width:50, hidden: false, editable:true,
						
					},
					{name: 'deb_elclassrefno', index: 'deb_elclassrefno' ,align:'center', width:50,  hidden: false, editable:true,
						
					},
					{name: 'deb_elclassrefdt', index: 'deb_elclassrefdt' ,align:'center', width:70, hidden: false, editable:true,
						
					},
					{name: 'deb_taninvno', index: 'deb_taninvno' ,align:'center', width:110, hidden: false, editable:true,
						
					},
					{name: 'deb_contractno', index: 'deb_contractno' ,align:'center', width:70, hidden: false, editable:true,
						
					},
					{name: 'deb_invoiceamt', index: 'deb_invoiceamt' ,width:60,  hidden: false, align:'right', editable:true,
						
					},
					{name: 'deb_exchangerate', index: 'deb_exchangerate' ,width:40,  hidden: false, align:'right', editable:true,
						
					},
					{name: 'deb_commission', index: 'deb_commission' , align:'center', width:40, hidden: false, editable:true,
						
					},
					{name: 'deb_rate', index: 'deb_rate' ,width:70, hidden: false, align:'right', editable:true,
						
					},
					{name: 'deb_qshipped', index: 'deb_qshipped' ,width:60, hidden: false, align:'right', editable:true,
						summaryType:'sum', summaryTpl:'<b> {0}</b>',
						formatter:'number',formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },
					},
					{name: 'deb_elclassamt', index: 'deb_elclassamt' ,width:80,  align:'right', hidden: false, editable:true,
						summaryType:'sum', summaryTpl:'<b> {0}</b>',
						formatter:'number',formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },
					},
					{name: 'deb_elclassamtinrs', index: 'deb_elclassamtinrs' ,width:80,  align:'right',  hidden: false, editable:true,
						summaryType:'sum', summaryTpl:'<b> {0}</b>',
						formatter:'number',formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },
					},
					{name: 'deb_tax', index: 'deb_tax' ,width:80,  hidden: false, align:'right', editable:true,
						summaryType:'sum', summaryTpl:'<b> {0}</b>',
						formatter:'number',formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },
					},
					{name: 'deb_total', index: 'deb_total' ,width:80, hidden: false, align:'right', editable:true,
						summaryType:'sum', summaryTpl:'<b> {0}</b>',
						formatter:'number',formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },
					},
					{name: 'deb_tds', index: 'deb_tds' ,width:80, hidden: false, align:'right', editable:true,
						summaryType:'sum', summaryTpl:'<b> {0}</b>',
						formatter:'number',formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },
					},
					{name: 'deb_due', index: 'deb_due' ,width:80, hidden: false, align:'right',editable:true,
						summaryType:'sum', summaryTpl:'<b> {0}</b>',
						formatter:'number',formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },
					},
		           ],
		 jsonReader : {  
			 repeatitems:false,
			 root: "rows",
			 page: "page", //calls first
			 total: "total" ,//calls Second
			 records: "records" //calls Third
		 }, 
		 caption: "Debit Tracking Report",
		 loadtext: "Debit Tracking is Loading",
		 pager: '#debittrackpager',
		 rowNum:500, 
		 rowList:[20,50,100,200,500,1000],
		 rownumbers:true,
		 height : "360",
		 width: "auto",
		 sortname: 'deb_debitno',
		 sortorder: 'desc', 
		 loadonce: true,
		 ignoreCase:true,
		 hidegrid: false,
		// editurl: "/Myelclass/BulkInsertAction.do",
		 sortable: true,
		 toppager:true,
		 gridview : true,
		 viewrecords: true,
		 footerrow: true,
		 altRows: true,
		 emptyrecords: 'No records to display',
		 loadComplete: function() { //deb_total
			 var $self = $(this),
			 qty = parseFloat($self.jqGrid("getCol", "deb_qshipped", false, "sum")).toFixed(2);
			 amt = parseFloat($self.jqGrid("getCol", "deb_elclassamtinrs", false, "sum")).toFixed(2);
        	 tax = parseFloat($self.jqGrid("getCol", "deb_tax", false, "sum")).toFixed(2);
        	 due = parseFloat($self.jqGrid("getCol", "deb_due", false, "sum")).toFixed(2);
        	 tot = parseFloat($self.jqGrid("getCol", "deb_total", false, "sum")).toFixed(2);
        	 tds = parseFloat($self.jqGrid("getCol", "deb_tds", false, "sum")).toFixed(2);
        	 commamt = parseFloat($self.jqGrid("getCol", "deb_elclassamt", false, "sum")).toFixed(2);
        	 
        	 $self.jqGrid("footerData", "set", {deb_rate: "Total",deb_elclassamtinrs: parseFloat(amt)});
        	 $self.jqGrid("footerData", "set", {deb_qshipped: qty});
        	 $self.jqGrid("footerData", "set", {deb_tax: tax});
        	 $self.jqGrid("footerData", "set", {deb_due: due});
        	 $self.jqGrid("footerData", "set", {deb_total: tot});
        	 $self.jqGrid("footerData", "set", {deb_tds: tds});
        	 $self.jqGrid("footerData", "set", {deb_elclassamt: commamt});
        	 //$(this).jqGrid('showCol', 'rn');
        }
	 }).jqGrid('navGrid','#debittrackpager',{
		 edit: true, add: false, del: false,  search: true, view: true, cloneToTop:true,
		 	addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View',
		 	 beforeRefresh: function(){
		 		debtrackgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		 	},	
		},{},{},{},
		{
		 		multipleSearch:true,
		 		stringResult  :true,
		 		multipleGroup:true,
		 	}	
		);
	 debtrackgrid.jqGrid('navButtonAdd',"#debittrackpager",{caption:"Toggle",title:"Toggle Search Toolbar", buttonicon :'ui-icon-pin-s',
			onClickButton:function(){
				debtrackgrid[0].toggleToolbar();
			} 
		});
	 debtrackgrid.jqGrid('navButtonAdd',"#debittrackpager",{caption:"Clear",title:"Clear Search",buttonicon :'ui-icon-refresh',
			onClickButton:function(){
				debtrackgrid[0].clearToolbar();
			} 
		});
	 debtrackgrid.jqGrid('navButtonAdd',"#debittrackpager",{caption:"columnChooser",title:"Column Chooser",buttonicon :'ui-icon-extlink',
		 onClickButton:function(){
			 debtrackgrid.jqGrid('columnChooser', {
		            done: function(perm) {
		                     if (!perm) { return false; }
		                      this.jqGrid('remapColumns', perm, true);
		            }
		       });
		 }
		 });
	// debtrackgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, stringResult: true});  //To Enable AutoSearch please comment Search on Enter to False
	 debtrackgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"});
	 
	//Bootom Pager Customization
	 var bottomPagerDiv = $("div#debittrackpager")[0];
	 $("#edit_" + debtrackgrid[0].id, bottomPagerDiv).remove();
	 $("#view_" + debtrackgrid[0].id, bottomPagerDiv).remove(); 
	 $("#search_" + debtrackgrid[0].id, bottomPagerDiv).remove();
	 $("#refresh_" + debtrackgrid[0].id, bottomPagerDiv).remove();
	 	
});

