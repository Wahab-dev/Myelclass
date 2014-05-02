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
	
	
	
	var sampleinvtrackgrid = $("#sampleinvtracktbl");
	$('#chngroup').change(function(){
		var vl = $(this).val();
		if(vl){
			if(vl == "clear"){
				sampleinvtrackgrid.jqGrid('groupingRemove',true);	
			}else{
				sampleinvtrackgrid.jqGrid('groupingGroupBy', vl, {
		            groupOrder : ['desc'],
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
	sampleinvtrackgrid.jqGrid({
		url:"/Myelclass/sita.do?action=load",
		datatype: "json",
		colNames:['invtype','invno','invdate','expname','taninvno','customer','invbillid','ctno','articleid','artname','color','size','subs','selc','unit','pcs','rate','qty','qshpd','qbal','amt','othercharges','discounts','totalamount','AWBillNo','AWBillDate','consignee','notify','exporterref','buyer','bank'],
	    colModel:[
					{name: 'invtype', index: 'invtype', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invno', index: 'invno', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						 formatter: "dynamicLink",
						 formatoptions: {
						        url: function (cellValue, rowId, rowData) {
						            return '/Myelclass/gotoSampleInvoice.do'+ '?' +'action=editsaminvform&'+
						                $.param({
						                	invno: rowData.invno
						                });
						        }
						    }
					 },
					 {name: 'invdt', index: 'invdt', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'exporter', index: 'exporter', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'taninvno', index: 'taninvno', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'customer', index: 'customer', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invid', index: 'invid', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invctno', index: 'invctno', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invartid', index: 'invartid', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invartname', index: 'invartname', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invcolor', index: 'invcolor', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invsize', index: 'invsize', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invsubs', index: 'invsubs', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invselc', index: 'invselc', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invunit', index: 'invunit', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },
	              
					 {name: 'invpcs', index: 'invpcs', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invrate', index: 'invrate', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					
					 {name: 'invqty', index: 'invqty', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 
					 {name: 'invqshpd', index: 'invqshpd', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invqbal', index: 'invqbal', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 
					 {name: 'invamt', index: 'invamt', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invothercrg', index: 'invothercrg', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invclaim', index: 'invclaim', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invtotamount', index: 'invtotamount', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'awbillno', index: 'awbillno', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },   
					 {name: 'awbilldate', index: 'awbilldate', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },   
					
					 {name: 'consignee', index: 'consignee', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },   
					 
					 {name: 'notify', index: 'notify', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },  
					 {name: 'exporterref', index: 'exporterref', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 }, 
					 {name: 'buyer', index: 'buyer', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },  
					 {name: 'bank', index: 'bank', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },
	              ],
	    jsonReader : {  
			repeatitems:false,
			root: "rows",
			page: "page", 
		  	total: "total" ,
	     	records: "records" 
		},  
		caption: "Invoice Tracking Report",
    	pager: '#sampleinvtrackpager',
    	rowNum: 15, 
    	rowList: [15,25,50],
        loadtext: "Bow Bow",
        height : "auto",
        width: "auto",  
        sortname: 'invno',  
        sortorder: 'desc',
        loadonce: true,
        sortable: true,
        grouping: true,
        gridview : true,
        viewrecords: true,
        footerrow: true,
        grouping:true, 
        groupingView : { groupField : ['invno'] },
        userDataOnFooter : true, //Gets Footer Total Recod from Server Side 
        emptyrecords: 'No records to display',
        loadComplete: function() {
        	 var $self = $(this),
        	 qty = $self.jqGrid("getCol", "invqty", false, "sum"),
        	 qshpd = $self.jqGrid("getCol", "invqshpd", false, "sum"),
        	 qbal  = $self.jqGrid("getCol", "invqbal", false, "sum");
        	 
        	// $self.jqGrid("footerData", "set", {selection: "Total:", invqty: qty});
        	 $self.jqGrid("footerData", "set", {selection: "Total:", invqshpd: qshpd});
        	// $self.jqGrid("footerData", "set", {selection: "Total:", invqbal: qbal});
        }
	 });
	sampleinvtrackgrid.jqGrid('navGrid','#sampleinvtrackpager',{
	 	edit: true,
	 	add: true,
	 	del: true, 
	 	search: true, 
	 	view: true, 
	}).jqGrid('navButtonAdd', '#sampleinvtrackpager', {
        caption: "Pdf",
        buttonicon: "ui-icon-print",
        title: "Print in PDF Format",
        onClickButton: downloadPdf,
    });
	/*
	*  Function to print the Page 
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
		printurl = "/Myelclass/sita/PrintReports.do?&type="+type;
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