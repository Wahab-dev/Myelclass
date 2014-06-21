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
	
	 debtrackgrid.jqGrid({
		 url:'/Myelclass/DebitTrackInsertAction.do',
		 datatype: "json",
		 colNames:['Debit No','Debit date','Tannery','ref no','Inv Date','Inv no','Ct No','Inv Amt','Exchange Rate','Commission','Price','Quantity','Commision Amt','INR','Service Tax','Total','TDS','Total Due'],
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
					{name: 'deb_debitdate', index: 'deb_debitdate' ,align:'center', width:70, hidden: false, editable:true,
						
					},
					{name: 'deb_exporter', index: 'deb_exporter', align:'center', width:50, hidden: false, editable:true,
						
					},
					{name: 'deb_elclassrefno', index: 'deb_elclassrefno' ,align:'center', width:50,  hidden: false, editable:true,
						
					},
					{name: 'deb_invdate', index: 'deb_invdate' ,align:'center', width:70, hidden: true, editable:true,
						
					},
					{name: 'deb_taninvno', index: 'deb_taninvno' ,align:'center', width:110, hidden: false, editable:true,
						
					},
					{name: 'deb_contractno', index: 'deb_contractno' ,align:'center', width:70, hidden: true, editable:true,
						
					},
					{name: 'deb_invoiceamt', index: 'deb_invoiceamt' ,width:70,  hidden: false, align:'right', editable:true,
						
					},
					{name: 'deb_exchangerate', index: 'deb_exchangerate' ,width:70,  hidden: false, align:'right', editable:true,
						
					},
					{name: 'deb_commission', index: 'deb_commission' ,width:70, hidden: false, editable:true,
						
					},
					{name: 'deb_rate', index: 'deb_rate' ,width:70, hidden: false, align:'right', editable:true,
						
					},
					{name: 'deb_qshipped', index: 'deb_qshipped' ,width:70, hidden: false, align:'right', editable:true,
						
					},
					{name: 'deb_elclassamt', index: 'deb_elclassamt' ,width:70,  align:'right', hidden: false, editable:true,
						
					},
					{name: 'deb_elclassamtinrs', index: 'deb_elclassamtinrs' ,width:70,  align:'right',  hidden: false, editable:true,
						
					},
					{name: 'deb_tax', index: 'deb_tax' ,width:70,  hidden: false, align:'right', editable:true,
						
					},
					{name: 'deb_total', index: 'deb_total' ,width:50, hidden: false, align:'right', editable:true,
						
					},
					{name: 'deb_tds', index: 'deb_tds' ,width:90, hidden: false, align:'right', editable:true,
						
					},
					{name: 'deb_due', index: 'deb_due' ,width:70, hidden: false, align:'right',editable:true,
						
					},
		           ],
		 jsonReader : {  
			 repeatitems:false,
			 root: "rows",
			 page: "page", //calls first
			 total: "total" ,//calls Second
			 records: "records" //calls Third
		 }, 
		 pager: '#debittrackpager',
		 loadtext: "Debit Tracking is Loading",
		 caption: 'Debit Tracking Page', 
		 emptyrecords: 'No records to display',
		 rowNum:30, 
		 rownumbers:true,
		 loadonce: true,
		 rowList:[30,50,70],	       
		 sortorder: 'asc',  
		 height : '360',
		 sortname : 'deb_debitno',  
		 gridview : true,
		 viewrecords: true,
		 footerrow: true,
		 loadComplete: function() { //deb_total
			 var $self = $(this),
			 amt = parseFloat($self.jqGrid("getCol", "deb_elclassamtinrs", false, "sum")).toFixed(2);
        	 tax = parseFloat($self.jqGrid("getCol", "deb_tax", false, "sum")).toFixed(2);
        	 due = parseFloat($self.jqGrid("getCol", "deb_due", false, "sum")).toFixed(2);
        	 tot = parseFloat($self.jqGrid("getCol", "deb_total", false, "sum")).toFixed(2);
        	 $self.jqGrid("footerData", "set", {deb_elclassamtinrs: parseFloat(amt)});
        	 $self.jqGrid("footerData", "set", {deb_tax: parseFloat(tax)});
        	 $self.jqGrid("footerData", "set", {deb_due: parseFloat(due)});
        	 $self.jqGrid("footerData", "set", {deb_total: parseFloat(tot)});
        	 //$(this).jqGrid('showCol', 'rn');
        }
	 }).jqGrid('navGrid','#debittrackpager',{
		 edit: true, add: false, del: false,  search: true, view: true, 
		 	addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View',
		 	 beforeRefresh: function(){
		 		debtrackgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
			 }
		});
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
	 debtrackgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, stringResult: true});  //To Enable AutoSearch please comment Search on Enter to False
		
});