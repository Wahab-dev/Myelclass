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
		alert(vl);
		if(vl){
			if(vl == "clear"){
				$("#bulkktracktbl").jqGrid('groupingRemove',true);	
			}else{
				$("#bulkktracktbl").jqGrid('groupingGroupBy',vl);
			}	
		}else{
			alert("Please Select field to Group");
		}
	});  //shows total qty error
    
    
	bulkgrid.jqGrid({     
		 		datatype: "json",
		        url:"/Myelclass/BulkInsertAction.do", 
		        colNames:['Status','Ct No','Agent','Order Date','PO No','Tan','Cust','Exp','Name','Color','Size','Substance','Selection','Selp','Quantity','Unit','Shipped','Balance','Comment','InvDetails','Feedback','rdd date','Price','Tc','Add','Cdd','Commission','PO/JW','Consignee','Notify','Bank','Destination','Splcdn','Represnt','Prfarticleid','User'],  
		        colModel :[   
				  
				  {name: 'status', index: 'status', align:'center', width:35, editable:true, sortable: true, hidden:false, 
					  search: true, stype:'text', searchoptions :{defaultValue : 'P'}, searchrules:{required:true},   	
					  edittype: 'select', 
					  editoptions:{value:{0:'Select Status',I:'Inspection', P:'Pending',C:'Closed',CA:'Cancel',PS:'Partial Ship',S:'Shipped',D:'Delivered'},defaultValue: 'Pending'},
					  editrules :{require : true},
					 
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
				  {name: 'agent', index: 'agent', align:'center', width:60, editable:true, sortable: true, hidden:false, search: true, stype:'text', 
					  editrules :{require : true},
					  
				  },
				  {name: 'orderdt', index: 'orderdt', align:'center', width:65, editable:true, sortable: true, hidden: false, search: true, stype:'date', 
					 /* searchoptions:{dataInit:datePick = function(elem)
						{
					   jQuery(elem).datepicker();
					}, attr:{title:'Select Date'}},
					  sorttype: 'date',
					 formatter: 'date', datefmt: 'd/m/Y',formatoptions: {newformat: 'd/m/Y'}, 
					 editoptions: { size: 12,
			              maxlengh: 12, dataInit: initDateEdit, },
					 editrules :{require : true,},*/
				  },
				  {name: 'pono', index: 'pono', align:'center', width:90, editable:true, sortable: true, hidden:true,  
					  editrules :{require : true},
				  },
				  {name: 'tanneryid', index: 'tanneryid', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'customerid', index: 'customerid', align:'center', width:90, editable:true, sortable: true, hidden:false,  
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
				  {name: 'size', index: 'size', align:'center', width:90, editable:true, sortable: true, hidden:true,  
					//  editrules :{require : true},
				  },
				  {name: 'substance', index: 'substance', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					 // editrules :{require : true},
				  },
				  {name: 'selection', index: 'selection', align:'center', width:90, editable:true, sortable: true, hidden:true,  
					  //editrules :{require : true},
				  },
				  {name: 'selectionpercent', index: 'selectionpercent', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					  //editrules :{require : true},
				  },
				  {name: 'quantity', index: 'quantity', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  //editrules :{require : true},
				  },
				  {name: 'unit', index: 'unit', align:'center', width:90, editable:true, sortable: true, hidden:true,  
					  //editrules :{require : true},
				  },
				  {name: 'qshipped', index: 'qshipped', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					  //editrules :{require : true},
				  },
				  {name: 'qbal', index: 'qbal', align:'center', width:90, editable:true, sortable: true, hidden:true,  
					//  editrules :{require : true},
				  },
				  {name: 'comments', index: 'comments', align:'center', width:90, editable:true, sortable: true, hidden:true,  
					  edittype: 'textarea', 
					  editrules :{require : true},
				  },
				  {name: 'invdetails', index: 'invdetails', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					  edittype: 'textarea',
					  editrules :{require : true},
				  },
				  {name: 'feddback', index: 'feddback', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					  
					  edittype: 'textarea', 
					  editrules :{require : true},
				  },
				  {name: 'rdd_date', index: 'rdd_date', align:'center', width:90, editable: true, sortable: true, hidden:true,  
					  sorttype: 'date',
					//  formatter: 'date', //datefmt: 'yy/MM/d',//formatoptions: {newformat: 'd-m-y'}, 
					  editoptions: { dataInit: DateGrpEdit },
					  editrules :{require : true},
				  },
				  {name: 'rate', index: 'rate', align:'center', width:90, editable:true, sortable: true, hidden: false,  
					  //editrules :{require : true},
				  },
				  {name: 'tc', index: 'tc', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					 // editrules :{require : true},
				  },
				  {name: 'add_date', index: 'add_date', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					  sorttype: 'date',
					 /* formatter: 'date', datefmt: 'd/m/Y',formatoptions: {newformat: 'd/m/Y'},
					  editoptions: { dataInit: DateGrpEdit },*/
					  editrules :{require : true},
				  },
				  {name: 'cdd_date', index: 'cdd_date', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					  sorttype: 'date',
					 /* formatter: 'date', datefmt: 'd/m/Y',formatoptions: {newformat: 'd/m/Y'}, 
					  editoptions: { dataInit: DateGrpEdit },*/
					  editrules :{require : true},
				  },
				  {name: 'commission', index: 'commission', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					 // editrules :{require : true},
				  },
				  {name: 'pojw', index: 'pojw', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					    editrules :{require : true},
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
				  {name: 'user', index: 'user', align:'center', width:90, editable:true, sortable: true, hidden: true,  
					 // editrules :{require : true},
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
		    	rowNum: 5, 
		    	rowList: [5,10,15],
		        loadtext: "Bow Bow",
		        height : "auto",
		        width: "auto",  
		        sortname: 'Ctno',  
		        sortorder: 'desc',
		        scroll: 1, //Check here
		        editurl: "/Myelclass/BulkInsertAction.do",
		        sortable: true,
		        grouping: true,
		        gridview : true,
		        rownumbers: true, // not working Check 
		        rownumWidth: 55,
		        viewrecords: true,
		        footerrow: true,
		        altRows: true,  // altrows and altclass for alternate color on grid rows
		        altclass:  'myAltRowClass',
		        userDataOnFooter : true, //Gets Footer Total Recod from Server Side 
		      /*loadComplete: function() {
		            $("tr.jqgrow:odd").addClass('myAltRowClass');
		        },*/
		      /*groupingView : { 
		        	groupField : ['ctno'], 
		       	 	groupColumnShow : [true],
		   		 	groupText : ['<b>{0} - {1} Item(s)</b>'],//{0} which mean the grouped text and {1} which mean how many items we have on this group.
		        },  */
		        emptyrecords: 'No records to display',
		        });
			
			bulkgrid.jqGrid('navGrid','#bulkktrackpager',{
		 		 	edit: true,
		 		 	add: true,
		 		 	del: true, 
		 		 	search: true, 
		 		 	view: true, 
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
		 		 	{},{
		 		 		multipleSearch:true,
		 		 		stringResult  :true,
		 		 		 multipleGroup:true,
		 		 	}
		 		 	
				) .navButtonAdd('#bulkktrackpager',{
		 		 	   caption:"Status", 
		 		 	   buttonicon:"ui-icon-lightbulb", 
		 		 	   position:"last",
		 		 	   onClickButton: function(){ 
		 		 	    var $self = $(this);
		 		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
		 		 	    {
		 		 		 /* beforeInitData: function(formid) {
		 		 			bulkgrid.setColProp('status', {
		 		 				formoptions : {
									rowpos : 1,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('ctno', {
		 		 				formoptions : {
									rowpos : 1,
									colpos: 2,
								},
								
							});
		 		 			bulkgrid.setColProp('tanneryid', {
		 		 				formoptions : {
									rowpos : 2,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('customerid', {
		 		 				formoptions : {
									rowpos : 2,
									colpos: 2,
								},
								
							});
		 		 			bulkgrid.setColProp('articlename', {
		 		 				formoptions : {
									rowpos : 6,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('color', {
		 		 				formoptions : {
									rowpos : 6,
									colpos: 2,
								},
								
							});
		 		 			bulkgrid.setColProp('size', {
		 		 				formoptions : {
									rowpos : 7,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('quantity', {
		 		 				formoptions : {
									rowpos : 7,
									colpos: 2,
								},
								
							});
		 		 			bulkgrid.setColProp('cdd_date', {
		 		 				formoptions : {
									rowpos : 9,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('add_date', {
		 		 				formoptions : {
									rowpos : 9,
									colpos: 2,
								},
								
							});
		 		 			 bulkgrid.setColProp('rdd_date', {
		 		 				formoptions : {
									rowpos : 10,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('reps', {
		 		 				formoptions : {
									rowpos : 10,
									colpos: 2,
								},
								
							});
		 		 			bulkgrid.setColProp('comments', {
		 		 				formoptions : {
									rowpos : 11,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('splcdn', {
		 		 				formoptions : {
									rowpos : 11,
									colpos: 2,
								},
								
							});
		 		 			bulkgrid.setColProp('invdetails', {
		 		 				formoptions : {
									rowpos : 20,
									colpos: 1,
								},
							});
		 		 			bulkgrid.setColProp('feddback', {
		 		 				formoptions : {
									rowpos : 20,
									colpos: 2,
								},
								
							});
		 		 			 			
						},  */
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
                        closeAfterEdit: true,
           				reloadAfterSubmit: true,
           				top: 50,
           				left: 100,
           				width : 'auto',
		 		 	  });
		 		 	   
		 		 	   }
		 		 	});
			bulkgrid.jqGrid('navButtonAdd',"#bulkktrackpager",{caption:"Toggle",title:"Toggle Search Toolbar", buttonicon :'ui-icon-pin-s',
				onClickButton:function(){
					bulkgrid[0].toggleToolbar();
				} 
			});
			/*bulkgrid.jqGrid('navButtonAdd',"#bulkktrackpager",{caption:"Clear",title:"Clear Search",buttonicon :'ui-icon-refresh',
				onClickButton:function(){
					bulkgrid[0].clearToolbar();
				} 
			});*/
		//	bulkgrid.jqGrid('filterToolbar', {/*autosearch : true,*/ searchOnEnter:false, stringResult: true});  //To Enable AutoSearch please comment Search on Enter to False
			/*navButtonAdd('#bulkktrackpager',{ 
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
			 	   }).navButtonAdd('#bulkktrackpager',{
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
		 		 	}).navButtonAdd('#bulkktrackpager',{
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
			 		});  */
			
});
