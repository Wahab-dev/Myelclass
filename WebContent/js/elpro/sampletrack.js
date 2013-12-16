/*
 *
 *
 */


/*global jQuery */
(function ($) {
	DateGrpEdit = function (elem) {
        $(elem).datepicker({
        	autoSize: true,
		    changeMonth:false,
		    dateFormat: "dd-mm-yy",
		    showWeek: true,
		    firstDay: 1,
		    numberOfMonths: 2,
		    showButtonPanel: true,
		    gotoCurrent:true, 
        });
	};  
	
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



///////////////////////////////////////////////////////////
$(function() { 
 var strgrid = $('#sampletracktbl');
	strgrid.jqGrid({     
		datatype: "json",
   		url:"/Myelclass/SamptrackInsertAction.do", 
    	colNames:['Status','Sampleno','Order Date','Refno','priority','handledby','customerid','tanneryid','deliverid','agentid','destination','terms','add_date','cdd_date','splcdn','inspcdn','forwaderid','isinvraised','articleid','articletype','articleshform','articlename','color','size','substance','selection','selectionp','quantity','unit','colormatching','rate','pcs','tapetest','crockingwet','crockingdry','fourfolds','keytest','srfarticleid','rdd_date','courierdetails','reps','feedbackdetails','User'],  
    	colModel :[  
                {name: 'status', index: 'status', align:'center', width:35, editable:true, sortable: true, hidden:false,  
		  			edittype: 'select', 
		 			editoptions:{value:{0:'Select Status',P:'Pending',C:'Closed',CA:'Cancel',IC:'IC',S:'Shipped',D:'Delivered'},defaultValue: 'Pending'},
		  			editrules :{require : true},
	  			}, 
	  			{name: 'sampleno', index: 'sampleno', align:'center', width:60, editable:true, sortable: true, hidden:false, 			
	  				 formatter: "dynamicLink",
					    formatoptions: {
					        url: function (cellValue, rowId, rowData) {
					            return '/Myelclass/loadSrf.do'+ '?' +'action=editform&'+
					                $.param({
					                	sampleno: rowData.sampleno
					                });
					        }
					    } 
				},
				{name: 'orderdt', index: 'orderdt', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'refno', index: 'refno', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'priority', index: 'priority', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'handledby', index: 'handledby', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'customerid', index: 'customerid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'tanneryid', index: 'tanneryid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'deliverid', index: 'deliverid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'agentid', index: 'agentid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'destination', index: 'destination', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'terms', index: 'terms', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'add_date', index: 'add_date', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'cdd_date', index: 'cdd_date', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'splcdn', index: 'splcdn', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'inspcdn', index: 'inspcdn', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'forwaderid', index: 'forwaderid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'isinvraised', index: 'isinvraised', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'articleid', index: 'articleid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'articletype', index: 'articletype', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'articleshform', index: 'articleshform', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'articlename', index: 'articlename', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'color', index: 'color', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'size', index: 'size', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'substance', index: 'substance', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'selection', index: 'selection', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'selectionp', index: 'selectionp', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'quantity', index: 'quantity', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'unit', index: 'unit', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'colormatching', colormatching: 'ctno', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'rate', index: 'rate', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'pcs', index: 'pcs', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'tapetest', index: 'tapetest', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'crockingwet', index: 'crockingwet', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'crockingdry', index: 'crockingdry', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'fourfolds', index: 'fourfolds', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'keytest', index: 'keytest', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'srfarticleid', index: 'srfarticleid', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'rdd_date', index: 'rdd_date', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					 sorttype: 'date',
						//  formatter: 'date', //datefmt: 'yy/MM/d',//formatoptions: {newformat: 'd-m-y'}, 
						  editoptions: { dataInit: DateGrpEdit },
						  editrules :{require : true},
				},
				{name: 'courierdetails', index: 'courierdetails', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					edittype: 'textarea', 
				},
				{name: 'reps', index: 'reps', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					edittype: 'textarea', 
				},
				{name: 'feedbackdetails', index: 'feedbackdetails', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
				},
				{name: 'user', index: 'user', align:'center', width:60, editable:true, sortable: true, hidden:false, 
					
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
	pager: '#sampletrackpager',
	rowNum:10, 
	rowList:[20,30,40],
	loadtext: "Bow Bow",
	height : "auto",
	width:"auto",  
	sortname: 'sampleno',  
	sortorder: 'desc',
	scroll: 1, //Check here
	editurl: "/Myelclass/SamptrackInsertAction.do",
	emptyrecords: 'No records to display',
	});
	strgrid.jqGrid('navGrid','#sampletrackpager',{
		 	edit: true,
		 	add: false,
		 	del: true, 
		 	search: true, 
		 	view: true, 
		 	//cloneToTop: true,
		 	
		 	}).navButtonAdd('#sampletrackpager',{
		 	   caption:"Status", 
		 	   buttonicon:"ui-icon-lightbulb", 
		 	   position:"last",
		 	   onClickButton: function(){ 
		 	    var $self = $(this);
		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
		 	    {
		 		 beforeShowForm: function(form) { 
		 			 $("#tr_orderdt").hide();
 		 			 $("#tr_refno").hide(); 
 		 			 $("#tr_priority").hide();
 		 			 $("#tr_handledby").hide(); 
 		 			 $("#tr_customerid").hide(); 
 		 			 $("#tr_tanneryid").hide(); 
 		 			 $("#tr_deliverid").hide();
 		 			 $("#tr_agentid").hide(); 
 		 			 $("#tr_destination").hide();
 		 			 $("#tr_terms").hide(); 
 		 			 $("#tr_add_date").hide(); 
 		 			 $("#tr_cdd_date").hide(); 
 		 			 $("#tr_splcdn").hide();
 		 			 $("#tr_inspcdn").hide();
 		 			 $("#tr_forwaderid").hide();
 		 			 $("#tr_isinvraised").hide(); 
 		 			 $("#tr_articleid").hide();
 		 			 $("#tr_articletype").hide(); 
 		 			 $("#tr_articleshform").hide();
 		 			 $("#tr_selection").hide(); 
 		 			 $("#tr_selectionp").hide(); 
 		 			 $("#tr_colormatching").hide();
 		 			 $("#tr_tapetest").hide();
		 			 $("#tr_crockingwet").hide();
		 			 $("#tr_crockingdry").hide();
		 			 $("#tr_fourfolds").hide(); 
		 			 $("#tr_keytest").hide();
		 			 $("#tr_srfarticleid").hide(); 
		 			 $("#tr_user").hide();
		 			 $("#tr_feedbackdetails").hide(); 
		 			
		 		 },
                  recreateForm: true,
                  editData: {//Function to Add parameters to the status 
				 		oper: 'status',
               },
               closeAfterEdit: true,
				reloadAfterSubmit: true,
		 	    });
		 	   
		 	   }
		 	}).navButtonAdd('#sampletrackpager',{
 		 	   caption:"Modify", 
 		 	   buttonicon:"ui-icon-tag", 
 		 	   onClickButton: function(){ 
 		 		 var $self = $(this);
	 		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
	 		 		{ // some options
       	                   recreateForm: true,
       	                   editData: {//Function to Add parameters to the edit 
 						 		oper: 'modify',
                           },
		 		 	 });	   
	 		 			   
 		 	   }, 
 		 	   position:"centre"
 	   		}).navButtonAdd('#sampletrackpager',{
		 	   caption:"Destination", 
		 	   buttonicon:"ui-icon-battery-2", 
		 	   onClickButton: function(){ 
		 		 var $self = $(this);
 		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
 		 		{ // some options
   	                   recreateForm: true,
   	                   editData: {//Function to Add parameters to the edit 
						 		oper: 'modify',
                       },
	 		 	 });	   
 		 			   
		 	   }, 
		 	   position:"centre"
		 	}).navButtonAdd('#sampletrackpager',{
 		 	   caption:"Print", 
 		 	   buttonicon:"ui-icon-print", 
 		 	   onClickButton: function(){ 
 		 		 var $self = $(this);
	 		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
	 		 		{ // some options
       	                   recreateForm: true,
       	                   editData: {//Function to Add parameters to the edit 
 						 		oper: 'modify',
                           },
		 		 	 });	  	   
 		 	   }, 
 		 	   position:"centre"
 		}); 
	
	  
});