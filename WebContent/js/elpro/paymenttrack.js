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
	var paytrackgrid = $('#paytracktbl');
	
	paytrackgrid.jqGrid({
		 url:'/Myelclass/PaymentTrackGridAction.do',
		 datatype: "json",
		 colNames:['Pay Id','Pay No','Pay Date','Exporter','Cheq Details','Deb no','Deb dt','Quantity','Inv Amt','el class Amt','Total','Tax','Tds','Due','Amt Credit','Balance','Reciept Dt','Comments'],
		 colModel:[
					{name: 'paymentid', index: 'paymentid' ,width:90, hidden: false, 
						
					},
					{name: 'paymentno', index: 'paymentno' ,width:70, hidden: false,
						 formatter: "dynamicLink",
						 formatoptions: {
						        url: function (cellValue, rowId, rowData) {
						            return '/Myelclass/gotopayment.do'+ '?' +'action=editpayform&'+
						                $.param({
						                	paymentno: rowData.paymentno
						                });
						        }
						    }	
					},
					{name: 'paymentdate', index: 'paymentdate' ,width:50, hidden: false, 
						
					},
					{name: 'deb_exporter', index: 'deb_exporter' ,width:90,  hidden: false,
						
					},
					{name: 'chequedetails', index: 'chequedetails' ,width:70, hidden: false, 
						
					},
					{name: 'deb_debitno', index: 'deb_debitno' ,width:70, hidden: false,
						
					},
					{name: 'deb_debitdate', index: 'deb_debitdate' ,width:70, hidden: false,
						
					},
					{name: 'deb_qshipped', index: 'deb_qshipped' ,width:70,  hidden: false,
						
					},
					{name: 'deb_invoiceamt', index: 'deb_invoiceamt' ,width:70,  hidden: false,
						
					},
					{name: 'deb_elclassamt', index: 'deb_elclassamt' ,width:70, hidden: false,
						
					},
					{name: 'deb_total', index: 'deb_total' ,width:70, hidden: false,
						
					},
					{name: 'deb_tax', index: 'deb_tax' ,width:70, hidden: false,
						
					},
					{name: 'deb_tds', index: 'deb_tds' ,width:70, hidden: false,
						
					},
					{name: 'deb_due', index: 'deb_due' ,width:70,  hidden: false,
						
					},
					{name: 'creditamt', index: 'creditamt' ,width:70,  hidden: false,
						
					},
					{name: 'balanceamt', index: 'balanceamt' ,width:50, hidden: false,
						
					},
					{name: 'recieptdate', index: 'recieptdate' ,width:90, hidden: false,
						
					},
					{name: 'otherdetails', index: 'otherdetails' ,width:70, hidden: false,
						
					},
		           ],
		 jsonReader : {  
			 repeatitems:false,
			 root: "rows",
			 page: "page", //calls first
			 total: "total" ,//calls Second
			 records: "records" //calls Third
		 }, 
		 pager: '#paytrackpager',
		 rowNum:30, 
		 loadonce: true,
		 rowList:[30,50,70],	       
		 sortorder: 'desc',  
		 height : 'automatic',
		 sortname : 'deb_debitno',  
		 sortorder : 'desc',
		 emptyrecords: 'No records to display',
		 caption: 'Debit Tracking Page', 
		 gridview : true,
		 viewrecords: true,
		 footerrow: true,
		 loadComplete: function() {
       	 var $self = $(this),
       	 amt = parseFloat($self.jqGrid("getCol", "deb_elclassamtinrs", false, "sum")).toFixed(2);
       	 tax = parseFloat($self.jqGrid("getCol", "deb_tax", false, "sum")).toFixed(2);
       	 due = parseFloat($self.jqGrid("getCol", "deb_due", false, "sum")).toFixed(2);
       	 $self.jqGrid("footerData", "set", {deb_elclassamtinrs: parseFloat(amt)});
       	 $self.jqGrid("footerData", "set", {deb_tax: parseFloat(tax)});
       	 $self.jqGrid("footerData", "set", {deb_due: parseFloat(due)});
       }
	 }).jqGrid('navGrid','#paytrackpager',{
		 edit: true,
		 	add: false,
		 	del: false, 
		 	search: true, 
		 	view: true, 
		});
	paytrackgrid.jqGrid('navButtonAdd',"#paytrackpager",{caption:"Toggle",title:"Toggle Search Toolbar", buttonicon :'ui-icon-pin-s',
			onClickButton:function(){
				paytrackgrid[0].toggleToolbar();
			} 
		});
	 paytrackgrid.jqGrid('navButtonAdd',"#paytrackpager",{caption:"Clear",title:"Clear Search",buttonicon :'ui-icon-refresh',
			onClickButton:function(){
				paytrackgrid[0].clearToolbar();
			} 
		});
	 paytrackgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, stringResult: true});  //To Enable AutoSearch please comment Search on Enter to False
		
	
	
	
});