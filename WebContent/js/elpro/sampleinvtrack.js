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
	
	
	sampleinvtrackgrid.jqGrid({
		url:"/Myelclass/sita.do?action=load",
		datatype: "json",
		colNames:['Type','Inv No','Date','Exporter','Tan Invno','Cust','Invbillid','Sample','Articleid','Article ','Color','Size','Subs','Selc','Unit','Pcs','Rate','Qty','Shpd','Bal','Amt','Courier ','Discounts','Total','AWBillNo','AWBillDate','Consignee','Notify','Exporterref','Buyer','Bank', 'User'],
		colModel:[
		          {name: 'invtype', index: 'invtype', align:'center', width:30, editable:true, sortable: true, hidden: false,  

		          },
		          {name: 'invno', index: 'invno', align:'center', width:65, editable:true, sortable: true, hidden: false,  
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
		          {name: 'invdt', index: 'invdt', align:'center', width:65, editable:true, sortable: true, hidden: false,  search: true,
		        	  sorttype: 'date',
		        	  formatter: 'date', formatoptions: { newformat: 'd-m-Y' }, editable: true, datefmt: 'd-M-Y',
	                  searchoptions: { sopt: ['eq', 'ne', 'lt', 'le', 'gt', 'ge'], dataInit: initDateSearch } 	
						
		          },
		          {name: 'exporter', index: 'exporter', align:'center', width:50, editable:true, sortable: true, hidden: false,  

		          },
		          {name: 'taninvno', index: 'taninvno', align:'center', width:70, editable:true, sortable: true, hidden: false,  

		          },
		          {name: 'customer', index: 'customer', align:'center', width:50, editable:true, sortable: true, hidden: false,  

		          },
		          {name: 'invid', index: 'invid', align:'center', width:60, editable:true, sortable: true, hidden: true,  

		          },
		          {name: 'invctno', index: 'invctno', align:'center', width:50, editable:true, sortable: true, hidden: false,  

		          },
		          {name: 'invartid', index: 'invartid', align:'center', width:90, editable:true, sortable: true, hidden: true,  

		          },
		          {name: 'invartname', index: 'invartname', align:'center', width:110, editable:true, sortable: true, hidden: false,  

		          },
		          {name: 'invcolor', index: 'invcolor', align:'center', width:90, editable:true, sortable: true, hidden: false,  

		          },
		          {name: 'invsize', index: 'invsize', align:'center', width:50, editable:true, sortable: true, hidden: false,  

		          },
		          {name: 'invsubs', index: 'invsubs', align:'center', width:60, editable:true, sortable: true, hidden: false,  

		          },
		          {name: 'invselc', index: 'invselc', align:'center', width:50, editable:true, sortable: true, hidden: false,  

		          },
		          {name: 'invunit', index: 'invunit', align:'center', width:40, editable:true, sortable: true, hidden: true,  

		          },

		          {name: 'invpcs', index: 'invpcs', align:'center', width:40, editable:true, sortable: true, hidden: true,  

		          },
		          {name: 'invrate', index: 'invrate', align:'right', width:70, editable:true, sortable: true, hidden: false,  

		          },

		          {name: 'invqty', index: 'invqty', align:'right', width:70, editable:true, sortable: true, hidden: false,  
		        	  summaryType:'sum', summaryTpl:'<b> {0}</b>',
		          },

		          {name: 'invqshpd', index: 'invqshpd', align:'right', width:70, editable:true, sortable: true, hidden: false,  
		        	  summaryType:'sum', summaryTpl:'<b> {0}</b>',
		          },
		          {name: 'invqbal', index: 'invqbal', align:'right', width:40, editable:true, sortable: true, hidden: true,  
		        	
		          },

		          {name: 'invamt', index: 'invamt', align:'right', width:50, editable:true, sortable: true, hidden: false,  
		        	  summaryType:'sum', summaryTpl:'<b> {0}</b>',
		          },
		          {name: 'invothercrg', index: 'invothercrg', align:'right', width:50, editable:true, sortable: true, hidden: false,  
		        	  summaryType:'sum', summaryTpl:'<b> {0}</b>',
		          },
		          {name: 'invclaim', index: 'invclaim', align:'right', width:50, editable:true, sortable: true, hidden: false,  
		        	  summaryType:'sum', summaryTpl:'<b> {0}</b>',
		          },
		          {name: 'invtotamount', index: 'invtotamount', align:'right', width:50, editable:true, sortable: true, hidden: false,  
		        	  summaryType:'sum', summaryTpl:'<b> {0}</b>',
		          },
		          {name: 'awbillno', index: 'awbillno', align:'center', width:100, editable:true, sortable: true, hidden: false,  

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
		          {name: 'user', index: 'user', align:'center', width:90, editable:true, sortable: true, hidden: true,  

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
		          loadtext: "Sample Invoice Tracking is Loading",
		          pager: '#sampleinvtrackpager',
		          rowNum: 500,
		  		  rowList: [20,50,100,200,500,1000],
		  		  rownumbers: true,
		  		  height : "360",
		  		  width: "auto",
		          sortname: 'invno',  
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
		  		  altRows: true, // altrows and altclass for alternate color on grid rows
		  		  emptyrecords: 'No records to display',
		  		  loadComplete: function() {
		        	  var $self = $(this),
		        	  qty = $self.jqGrid("getCol", "invqty", false, "sum"),
		        	  qshpd = $self.jqGrid("getCol", "invqshpd", false, "sum"),
		        	  courier  = $self.jqGrid("getCol", "invothercrg", false, "sum");
		        	  discount  = $self.jqGrid("getCol", "invclaim", false, "sum");
		        	  amt  = $self.jqGrid("getCol", "invamt", false, "sum");
		        	  totamt  = $self.jqGrid("getCol", "invtotamount", false, "sum");

		        	  $self.jqGrid("footerData", "set", {invrate: "Total:", invqty: qty.toFixed(2)});
		        	  $self.jqGrid("footerData", "set", { invqshpd: qshpd.toFixed(2)});
		        	  $self.jqGrid("footerData", "set", { invamt: amt.toFixed(2)});
		        	  $self.jqGrid("footerData", "set", { invtotamount: totamt.toFixed(2)});
		        	  $self.jqGrid("footerData", "set", { invothercrg: courier.toFixed(2)});
		        	  $self.jqGrid("footerData", "set", { invclaim: discount.toFixed(2)});
		          }
	});
	sampleinvtrackgrid.jqGrid('navGrid','#sampleinvtrackpager',{
		edit: false, add: false, del: false, search: true, view: true, cloneToTop:true,
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext:'View',
		beforeRefresh: function(){
			sampleinvtrackgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		},	
	},{},{},{},
	{
	 		multipleSearch:true,
	 		stringResult  :true,
	 		multipleGroup:true,
	 	}	
	).jqGrid('navButtonAdd',"#sampleinvtrackpager",{caption:"Toggle",title:"Toggle Search Toolbar", buttonicon :'ui-icon-pin-s',
		onClickButton:function(){
			sampleinvtrackgrid[0].toggleToolbar();
		} 
	}).jqGrid('navButtonAdd',"#sampleinvtrackpager",{caption:"Clear",title:"Clear Search",buttonicon :'ui-icon-refresh',
		onClickButton:function(){
			sampleinvtrackgrid[0].clearToolbar();
		} 
	}).jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"


	}).jqGrid('navButtonAdd', '#sampleinvtrackpager', {
		caption: "Pdf",
		buttonicon: "ui-icon-print",
		title: "Print in PDF Format",
		onClickButton: downloadPdf,
	}).jqGrid('navButtonAdd', '#sampleinvtrackpager', {
		caption:"columnChooser",title:"Column Chooser",buttonicon :'ui-icon-extlink',
		onClickButton:function(){
			sampleinvtrackgrid.jqGrid('columnChooser', {
				done: function(perm) {
					if (!perm) { return false; }
					this.jqGrid('remapColumns', perm, true);
				}
			});
		}
	});
	//Bootom Pager Customization
	  var bottomPagerDiv = $("div#sampleinvtrackpager")[0];
	  $("#view_" + sampleinvtrackgrid[0].id, bottomPagerDiv).remove();
	  $("#search_" + sampleinvtrackgrid[0].id, bottomPagerDiv).remove(); 
	  $("#refresh_" + sampleinvtrackgrid[0].id, bottomPagerDiv).remove(); 

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