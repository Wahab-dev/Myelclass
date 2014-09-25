/*
 *
 **/

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
	
	
	
	
	
	
	var invtrackgrid = $("#invtracktbl");
	
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
				invtrackgrid.jqGrid('groupingRemove',true,{
					groupColumnShow: [true]
				});	
			}else{
				invtrackgrid.jqGrid('groupingGroupBy', vl, {
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

	
	invtrackgrid.jqGrid({
		url:"/Myelclass/InvTrackAction.do?action=load",
		datatype: "json",
		colNames:['Type','Inv No','Date','Exporter','Tan InvNo','Customer','Invbillid','Ct No','articleid','Article',
		          'Color','Size','Subs','Selc','Unit','Pcs','Rate', 'Qty','Shipd','Bal','Amt','Courier','Discounts',
		          'Total','AWBill No','AWBill Date','Comm','Other Ccomm','Tc','Consignee','Notify','Exporterref','Buyer',
		          'Bank','Deduction','BankCharge','Amount Recieved','Balance Amt','Ex rate','Amt in Rs','Reciept Date','Remarks'],
	    colModel:[
					{name: 'invtype', index: 'invtype', align:'center', width:40, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invno', index: 'invno', align:'center', width:60, editable:true, sortable: true, hidden: false,  
						 formatter: "dynamicLink",
						 formatoptions: {
						        url: function (cellValue, rowId, rowData) {
						            return '/Myelclass/gotoinvoice.do'+ '?' +'action=editinvform&'+
						                $.param({
						                	invno: rowData.invno
						                });
						        }
						    }
					 },
					 {name: 'invdt', index: 'invdt', align:'center', width:60, editable:true, sortable: true, hidden: false, search: true, 
						 sorttype: 'date',
						 formatter: 'date', formatoptions: { newformat: 'd-m-Y' }, editable: true, datefmt: 'd-M-Y',
		                searchoptions: { sopt: ['eq', 'ne', 'lt', 'le', 'gt', 'ge'], dataInit: initDateSearch } 	
							
					 },
					 {name: 'exporter', index: 'exporter', align:'center', width:60, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'taninvno', index: 'taninvno', align:'center', width:100, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'customer', index: 'customer', align:'center', width:60, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invid', index: 'invid', align:'center', width:50, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invctno', index: 'invctno', align:'center', width:50, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invartid', index: 'invartid', align:'center', width:50, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invartname', index: 'invartname', align:'center', width:100, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invcolor', index: 'invcolor', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invsize', index: 'invsize', align:'center', width:60, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invsubs', index: 'invsubs', align:'center', width:60, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invselc', index: 'invselc', align:'center', width:40, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invunit', index: 'invunit', align:'center', width:40, editable:true, sortable: true, hidden: true,  
						
					 },
	              
					 {name: 'invpcs', index: 'invpcs', align:'center', width:40, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invrate', index: 'invrate', align:'right', width:80, editable:true, sortable: true, hidden: false,  
						
					 },
					
					 {name: 'invqty', index: 'invqty', align:'right', width:70, editable:true, sortable: true, hidden: false,  
						 summaryType:'sum', summaryTpl:'<b> {0}</b>',
					 },
					 
					 {name: 'invqshpd', index: 'invqshpd', align:'right', width:50, editable:true, sortable: true, hidden: false,  
						 summaryType:'sum', summaryTpl:'<b> {0}</b>',
					 },
					 {name: 'invqbal', index: 'invqbal', align:'right', width:50, editable:true, sortable: true, hidden: false,  
						
					 },
					 
					 {name: 'invamt', index: 'invamt', align:'right', width:60, editable:true, sortable: true, hidden: false,  
						 summaryType:'sum', summaryTpl:'<b> {0}</b>',
					 },
					 {name: 'invothercrg', index: 'invothercrg', align:'right', width:60, editable:true, sortable: true, hidden: false,  
						 summaryType:'sum', summaryTpl:'<b> {0}</b>',
					 },
					 {name: 'invclaim', index: 'invclaim', align:'right', width:60, editable:true, sortable: true, hidden: false,  
						 summaryType:'sum', summaryTpl:'<b> {0}</b>',
					 },
					 {name: 'invtotamount', index: 'invtotamount', align:'right', width:60, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'awbillno', index: 'awbillno', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },   
					 {name: 'awbilldate', index: 'awbilldate', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },   
					 {name: 'invcomm', index: 'invcomm', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },   
					 {name: 'invothercomm', index: 'invothercomm', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 }, 
					 {name: 'invtc', index: 'invtc', align:'center', width:90, editable:true, sortable: true, hidden: false,  
							
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
					 {name: 'deduction', index: 'deduction', align:'right', width:90, editable:true, sortable: true, hidden: false,  
						 formatter: 'number',  formatoptions: { defaultValue: '0.00' },
					 },
					 {name: 'bankcharge', index: 'bankcharge', align:'right', width:80, editable:true, sortable: true, hidden: false,  
							editrules: { number:true},
							formatter: 'number',  formatoptions: { defaultValue: '0.00' },
							/*editoptions:{
								dataEvents:[{
									type: 'focusout',
									fn: function(e){
										var amt = $("#invtotamount").val();
										var bankchrg = $("#bankcharge").val();	
										var deduct = $("#deduction").val();
										var realamt = (parseFloat(amt) - (parseFloat(bankchrg) + parseFloat(deduct)).toFixed(2));
										$("#amtrecieved").val(realamt);
									}
								}],
							},*/
						},
						{name: 'amtrecieved', index: 'amtrecieved', align:'right', width:80, editable:true, sortable: true, hidden: false,  
							 editrules: {required: true, number:true},
							 editoptions:{
								 dataEvents:[{
									type: 'focusout',
									fn: function(e){
										var amt = $("#amtrecieved").val();
										var tot = $("#invtotamount").val();
										var bankchrg = $("#bankcharge").val();	
										var deduct = $("#deduction").val();
										var balance = (parseFloat(tot) - (parseFloat(amt) +parseFloat(bankchrg)+parseFloat(deduct))).toFixed(2);
										$("#balanceamt").val(balance);
									}
								}],
							 },
							 formatter: 'number',  formatoptions: { defaultValue: '0.00' },
						},
						{name: 'balanceamt', index: 'balanceamt', align:'right', width:80, editable:true, sortable: true, hidden: true,  
							 editrules: {required: true, number:true},
							 formatter: 'number',  formatoptions: { defaultValue: '0.00' },
						},
						
						{name: 'exchngrate', index: 'exchngrate', align:'right', width:45, editable:true, sortable: true, hidden: true,  
							 editrules:{number:true},
							 formatter: 'number',  formatoptions: { defaultValue: '0.00' },
							 editoptions:{
								 dataEvents:[{
									type: 'focusout',
									fn: function(e){
										var amt = $("#amtrecieved").val();
										var exrt = $("#exchngrate").val();									
										var amtinrs = (parseFloat(amt) * parseFloat(exrt)).toFixed(2);
										$("#amtininr").val(amtinrs);
									}
								}],
							 },
						},
						{name: 'amtininr', index: 'amtininr', align:'right', width:70, editable:true, sortable: true, hidden: true,  
							 formatter: 'number',  
							 formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },
							 editrules: {required: true},
						},
						{name: 'recieptdate', index: 'recieptdate', align:'center', width:60, editable:true, sortable: true, hidden: false,  
							 sorttype: 'date',
							 formatter: 'date', formatoptions: { newformat: 'd-m-Y' },  datefmt: 'd-M-Y', defaultValue:null,
			                 searchoptions: { sopt: ['eq', 'ne', 'le', 'ge'], dataInit: initDateSearch }, 	
							 editoptions: { dataInit: DateGrpEdit },
							 editrules :{required : true},
						},
						{name: 'remarks', index: 'remarks', align:'center', width:100, editable:true, sortable: true, hidden: false,  
							 edittype: 'textarea',
							 editrules: {required: true},
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
		loadtext: "Invoice Tracking is Loading",
    	pager: '#invtrackpager',
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
        editurl: "/Myelclass/InvTrackAction.do?action=paymnt",
        sortable: true,
        toppager:true,
        gridview : true,
        viewrecords: true,
        footerrow: true,
        altRows: true,
        emptyrecords: 'No records to display',
        loadComplete: function() {
        	 var $self = $(this),
        	 qty = $self.jqGrid("getCol", "invqty", false, "sum"),
        	 qshpd = $self.jqGrid("getCol", "invqshpd", false, "sum"),
        	 amt = $self.jqGrid("getCol", "invamt", false, "sum");
        	 courier = $self.jqGrid("getCol", "invothercrg", false, "sum"),
        	 discount = $self.jqGrid("getCol", "invclaim", false, "sum");
        	 var qbal = (qty- qshpd).toFixed(2);
        	 
        	 $self.jqGrid("footerData", "set", {invtype: "Total",invqty: qty.toFixed(2)});
        	 $self.jqGrid("footerData", "set", { invqshpd: qshpd.toFixed(2)});
        	 $self.jqGrid("footerData", "set", { invqbal: qbal});
        	 $self.jqGrid("footerData", "set", { invamt: amt.toFixed(2)});
        	 //$self.jqGrid("footerData", "set", { invothercrg: courier.toFixed(2)});
        	 //$self.jqGrid("footerData", "set", { invclaim: discount.toFixed(2)});
        },
        onSelectRow: function(rowid, status, e) {
      
        	var selrowid = sampledebgrid.jqGrid('getGridParam', 'selrow');
        	var realzdamt = sampledebgrid.jqGrid('getCell',selrowid,'amtrecieved');
        	if(realzdamt != 0.00){
        		//disable add button -> 
        		$("#payadd").addClass('ui-state-disabled');
        	}else{
        		$("#payadd").removeClass('ui-state-disabled');
        	}
        }
	 });
	invtrackgrid.jqGrid('navGrid','#invtrackpager',{
		edit: true, add: false, del: false, search: true, view: true, cloneToTop:true,
		addtext: 'Add', edittext: 'Edit Payment', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View',
		beforeRefresh: function(){
			invtrackgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		},},
		{
			beforeShowForm:  function(form) { 
		 		$("#tr_debdt").show();
		 		$("#tr_balanceamt").show();
		 		$("#tr_invtype").hide();
		 		$("#tr_invdt").hide();
		 		$("#tr_exporter").hide();
		 		$("#tr_customer").hide();
		 		$("#tr_invctno").hide();
		 		$("#tr_invartname").hide();
		 		$("#tr_invcolor").hide();
		 		$("#tr_invsize").hide();
		 		$("#tr_invsubs").hide();
		 		$("#tr_invselc").hide();
		 		$("#tr_invrate").hide();
		 		$("#tr_invqty").hide();
		 		$("#tr_invqshpd").hide();
		 		$("#tr_invqbal").hide();
		 		$("#tr_invamt").hide();
		 		var exporter = $("#exporter").val();
			 	if(exporter.toUpperCase() == "IC"){
			 		$("#tr_deduction").show();
			 		$("#tr_bankcharge").show();
			 		$("#tr_exchngrate").show();
			 		$("#tr_amtininr").show();
			 	}else{
		 			$("#tr_deduction").hide();
		 			$("#tr_bankcharge").hide();
					$("#tr_exchngrate").hide();
					$("#tr_amtininr").hide();
		 		}
		 	},
		 	recreateForm: true,
		 		editData: {//Function to Add parameters to the status 
		 			oper: 'editpay',
                },
            closeAfterEdit : true,
    		reloadAfterSubmit : true,
		},
		{},{},
		{
	 		multipleSearch:true,
	 		stringResult  :true,
	 		multipleGroup:true,
	 	}	
	).navButtonAdd('#invtrackpager',{
		id:'payadd',
	 	caption:"Payment Reciept", 
		buttonicon:"ui-icon-circle-minus", 
		position:"first",
		onClickButton: function(){ 
			var $self = $(this);
		 	$self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
		 	{
		 		beforeShowForm:  function(form) { 
		 		$("#tr_debdt").show();
		 		$("#tr_balanceamt").show();
		 		$("#tr_invtype").hide();
		 		$("#tr_invdt").hide();
		 		$("#tr_exporter").hide();
		 		$("#tr_customer").hide();
		 		$("#tr_invctno").hide();
		 		$("#tr_invartname").hide();
		 		$("#tr_invcolor").hide();
		 		$("#tr_invsize").hide();
		 		$("#tr_invsubs").hide();
		 		$("#tr_invselc").hide();
		 		$("#tr_invrate").hide();
		 		$("#tr_invqty").hide();
		 		$("#tr_invqshpd").hide();
		 		$("#tr_invqbal").hide();
		 		$("#tr_invamt").hide();
		 		var exporter = $("#exporter").val();
			 	if(exporter.toUpperCase() == "IC"){
			 		$("#tr_deduction").show();
			 		$("#tr_bankcharge").show();
			 		$("#tr_exchngrate").show();
			 		$("#tr_amtininr").show();
			 	}else{
		 			$("#tr_deduction").hide();
		 			$("#tr_bankcharge").hide();
					$("#tr_exchngrate").hide();
					$("#tr_amtininr").hide();
		 		}
		 	},
		 	recreateForm: true,
		 		editData: {//Function to Add parameters to the status 
		 			oper: 'addpay',
                },
            closeAfterEdit : true,
    		reloadAfterSubmit : true,
		 	});
		}
	});
	invtrackgrid.jqGrid('navButtonAdd',"#invtrackpager",{caption:"Toggle",title:"Toggle Search Toolbar", buttonicon :'ui-icon-pin-s',
		onClickButton:function(){
			invtrackgrid[0].toggleToolbar();
		} 
	});
	invtrackgrid.jqGrid('navButtonAdd',"#invtrackpager",{caption:"Clear",title:"Clear Search",buttonicon :'ui-icon-refresh',
		onClickButton:function(){
			invtrackgrid[0].clearToolbar();
		} 
	});
	invtrackgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"});
	invtrackgrid.jqGrid('navButtonAdd', '#invtrackpager', {
        caption: "Pdf",
        buttonicon: "ui-icon-print",
        title: "Print in PDF Format",
        onClickButton: downloadPdf,
    }).jqGrid('navButtonAdd', '#invtrackpager', {
        caption: "Excel",
        buttonicon: "ui-icon-print",
        title: "Print in Excel Format",
        onClickButton: downloadExcel,
    });
	
	//Bootom Pager Customization
	  var bottomPagerDiv = $("div#invtrackpager")[0];
	  $("#edit_" + invtrackgrid[0].id, bottomPagerDiv).remove();
	  $("#view_" + invtrackgrid[0].id, bottomPagerDiv).remove();
	  $("#search_" + invtrackgrid[0].id, bottomPagerDiv).remove(); 
	  $("#refresh_" + invtrackgrid[0].id, bottomPagerDiv).remove(); 
		
	
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
		printurl = "/Myelclass/InvTrackAction/PrintReports.do?&type="+type;
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
	invtrackgrid.jqGrid('navButtonAdd',"#invtrackpager",{caption:"columnChooser",title:"Column Chooser",buttonicon :'ui-icon-extlink',
		onClickButton:function(){
			invtrackgrid.jqGrid('columnChooser', {
		           done: function(perm) {
		                    if (!perm) { return false; }
		                     this.jqGrid('remapColumns', perm, true);
		           }
		      });
		}
		});
	
});
			


