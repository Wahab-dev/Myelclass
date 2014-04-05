/*
 *
 *
 */
/*global jQuery */
(function ($) {	 
	/*
	 * Function to add New Button in jqgrid edit
	 * 
	 */
	/*$.extend($.jgrid.edit, {
	    bSubmit: "Save and Close",
	    bCancel: "Cancel",
	    width: 370,
	    recreateForm: true,
	    beforeShowForm: function () {
	        $('<a href="#">Save and New<span class="ui-icon ui-icon-disk"></span></a>')
	            .click(function() {
	                alert("click!");
	            }).addClass("fm-button ui-state-default ui-corner-all fm-button-icon-left")
	              .prependTo("#Act_Buttons>td.EditButton");
	    }
	});*/
	
	// ------------------------------------------------------------
	
	
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
	
	 $('#chngroup').change(function(){
			var vl = $(this).val();
			if(vl){
				if(vl == "clear"){
					sampletrackgrid.jqGrid('groupingRemove',true);	
				}else{
					sampletrackgrid.jqGrid('groupingGroupBy', vl, {
			            groupOrder : ['desc'],
			            groupColumnShow: [false],
			            groupCollapse: [true],
			        });
				}	
			}else{
				alert("Please Select field to Group");
			}
		}); 
	/*var mydata=[
	            
	            {status:'P',sampleno:'S2345'},
	            {status:'P',sampleno:'S2346'},
	            ];*/
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
 var sampletrackgrid = $('#sampletrack');
 sampletrackgrid.jqGrid({  
	 	datatype: 'json',
	 	url: '/Myelclass/SamptrackInsertAction.do', 	
		colNames:['Status','Sampleno','Order Date','Refno','priority','handledby','customerid','tanneryid','deliverid','destination',
		          'endusage','terms','add','cdd','splcdn','inspcdn','forwaderid','isinvraised','articleid','articletype',
		          'articleshform','articlename','color','size','substance','selection','selectionp','quantity','pcs','colormatching','rate',
		          'tapetest','crockingwet','crockingdry','fourfolds','keytest','srfarticleid','rdd','reps','courierdetails', 
		          'Customer Feedback','User','ApplytoAll'],
    	colModel :[  
                {name: 'status', index: 'status', align:'center', width:35, search: true, stype:'text', editable:true, sortable: true, hidden: false,  
		  			edittype: 'select', 
		 			editoptions:{value:{0:'Select Status',P:'Pending',C:'Closed',CA:'Cancel',IC:'IC',S:'Shipped',D:'Delivered'},defaultValue: 'Pending'},
		  			editrules :{require : true},
	  			}, 
	  			{name: 'sampleno', index: 'sampleno', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: false, 			
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
				{name: 'orderdt', index: 'orderdt', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: false, 
					
				},
				{name: 'refno', index: 'refno', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: true, 
					
				},
				{name: 'priority', index: 'priority', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: true, 
					
				},
				{name: 'handledby', index: 'handledby', align:'center', width:60, editable:true, search: true, stype:'text', search: true, stype:'text', sortable: true, hidden: true, 
					
				},
				{name: 'customerid', index: 'customerid', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: false, 
					
				},
				{name: 'tanneryid', index: 'tanneryid', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: false, 
					
				},
				{name: 'deliverid', index: 'deliverid', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: false, 
					
				},
				
				{name: 'destination', index: 'destination', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: true, 
					
				},
				{name: 'endusage', index: 'endusage', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: true, 
					
				},
				{name: 'terms', index: 'terms', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: true, 
					
				},
				{name: 'add_date', index: 'add_date', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: false, 
					
				},
				{name: 'cdd_date', index: 'cdd_date', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: false, 
					
				},
				{name: 'splcdn', index: 'splcdn', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden : true, 
					
				},
				{name: 'inspcdn', index: 'inspcdn', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden : true, 
					
				},
				{name: 'forwaderid', index: 'forwaderid', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: true, 
					
				},
				{name: 'isinvraised', index: 'isinvraised', align:'center', width:60, editable:true, search: true, stype:'text', sortable: true, hidden: true, 
					
				},
				{name: 'articleid', index: 'articleid', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true, 
					
				},
				{name: 'articletype', index: 'articletype', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: false, 
					
				},
				{name: 'articleshform', index: 'articleshform', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true, 
					
				},
				{name: 'articlename', index: 'articlename', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: false, 
					
				},
				{name: 'color', index: 'color', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: false, 
					
				},
				{name: 'size', index: 'size', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: false, 
					
				},
				{name: 'substance', index: 'substance', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: false, 
					
				},
				{name: 'selection', index: 'selection', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true, 
					
				},
				{name: 'selectionp', index: 'selectionp', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true, 
					
				},
				{name: 'quantity', index: 'quantity', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: false, 
					
				},
				{name: 'pcs', index: 'pcs', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: false, 
					
				},
				{name: 'colormatching', index: 'colormatching',  align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true	, 
					
				},
				{name: 'rate', index: 'rate', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: false, 
					
				},
				
				{name: 'tapetest', index: 'tapetest', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true, 
					
				},
				{name: 'crockingwet', index: 'crockingwet', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true, 
					
				},
				{name: 'crockingdry', index: 'crockingdry', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true, 
					
				},
				{name: 'fourfolds', index: 'fourfolds', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true, 
					
				},
				{name: 'keytest', index: 'keytest', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true, 
					
				},
				{name: 'srfarticleid', index: 'srfarticleid', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true, 
					
				},
				{name: 'rdd_date', index: 'rdd_date', align:'center', width:120, editable:true, sortable: true, hidden: false, 
					 sorttype: 'date',
						//formatter: 'date', //datefmt: 'yy/MM/d',//formatoptions: {newformat: 'd-m-y'}, 
						  editoptions: { dataInit: DateGrpEdit, size:8 },
						  editrules :{require : true},
				},
				{name: 'reps', index: 'reps', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true, 
					edittype: 'select', 
					editoptions:{value:{0:'Select Representative ', elclass:'elclass', MD:'MD', Masa:'Masa', ALR:'ALR' }, defaultValue: 'elclass'},
		  			editrules :{require : true},
					/*editoptions:{
							dataInit:function (elem) { 
								$(elem).autocomplete({
									minLength: 2,
									source: function(request, response,term) {
										var param = request.term;
								        $.ajax({
								           url: "/Myelclass/SamptrackInsertAction.do?term="+param+"&action="+"reps",
								           dataType: "json",
								           type:"GET",
								           success: function (data) {
								           	 response($.map(data, function(item) {
								            	 return { 
								                    label: item.value,
								                    value: item.value // I am displaying both labe and value
								                 };
								             }));//END Response
								           },//END Success
								        });//END AJAX
									},
								});
							$('.ui-autocomplete').css('zIndex',1000); // z index for jqgfrid and autocomplete has been misalignment so we are manually setting it 
							}
					 },*/					 
					editrules :{required : true},
				},
				{name: 'courierdetails', index: 'courierdetails', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: false, 
					edittype: 'textarea', 
				},
				
				{name: 'feedbackdetails', index: 'feedbackdetails', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: false, 
					edittype: 'textarea', 
				},
				
				{name: 'user', index: 'user', align:'center', width:60,  search: true, stype:'text',editable:true, sortable: true, hidden: true, 
					
				},
				{name: 'isupdtar', index: 'isupdtart', align:'center', width:60,  editable:true, sortable: true, hidden: true, 
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
	caption : 'Sample Tracking Report',
	pager : '#sampletrackpgr',
	rowNum : 50, 
	rowList : [50,100,200],
    height : "auto",
    width : "auto",  
    sortname : 'sampleno',  
    sortorder : 'desc',
    loadonce: true,
    editurl : '/Myelclass/SamptrackInsertAction.do',
    sortable : true,
    gridview : true,
    viewrecords: true,
    footerrow: true,
    loadonce: true,
    emptyrecords: 'No records to display',
    loadComplete: function () {
        var $self = $(this),
            sum = $self.jqGrid("getCol", "pcs", false, "sum");

        $self.jqGrid("footerData", "set", {quantity: "Total:", pcs: sum});
    }
    }).jqGrid('navGrid','#sampletrackpgr',{
    	edit: true,
	 	add: true,
	 	del: true, 
	 	search: true, 
	 	view: true, beforeRefresh: function(){
	 		sampletrackgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
	    }
	}).navButtonAdd('#sampletrackpgr',{
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
			 $("#tr_pcs").hide();
			 $("#tr_reps").show();
			 $("#tr_isupdtar").show();
			 
			 $("#sampleno").attr("readonly","readonly"); 
			 $("#articlename").attr("readonly","readonly"); 
			 $("#color").attr("readonly","readonly"); 
			 $("#size").attr("readonly","readonly"); 
			 $("#substance").attr("readonly","readonly"); 
			 $("#quantity").attr("readonly","readonly"); 
		 },
        recreateForm: true,
        editData: {//Function to Add parameters to the status 
		 		oper: 'status',
        },
     	closeAfterEdit: true,
		reloadAfterSubmit: true,
	    });
	   
	   }
	}).jqGrid('navButtonAdd',"#sampletrackpgr",{caption:"Toggle",title:"Toggle Search Toolbar", buttonicon :'ui-icon-pin-s',
		onClickButton:function(){
			sampletrackgrid[0].toggleToolbar();
		} 
	}).jqGrid('navButtonAdd',"#sampletrackpgr",{caption:"Clear",title:"Clear Search",buttonicon :'ui-icon-refresh',
		onClickButton:function(){
			sampletrackgrid[0].clearToolbar();
		} 
	}).jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, stringResult: true  //To Enable AutoSearch please comment Search on Enter to False
		
	}).jqGrid('navButtonAdd', '#sampletrackpgr', {
        caption: "Pdf",
        buttonicon: "ui-icon-print",
        title: "Print in PDF Format",
        onClickButton: downloadPdf,
    }).jqGrid('navButtonAdd', '#sampletrackpgr', {
        caption: "Excel",
        buttonicon: "ui-icon-print",
        title: "Print in Excel Format",
        onClickButton: downloadExcel,
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
	function download(type){
		//var data = mastergrid.jqGrid('getGridParam', 'postData');
		//alert(data);
		printurl = "/Myelclass/SamptrackInsertAction/PrintReports.do?&type="+type;
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
  
 /*.navButtonAdd('#sampletrackpgr',{
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
		}).navButtonAdd('#sampletrackpgr',{
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
	}).navButtonAdd('#sampletrackpgr',{
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
});*/
});