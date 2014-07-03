/**				
 * 
 */
$(document).ready(function() {
	 //Global Variables
   var clr = null ;
   var arid = null ;
  // var totinspectd = ""; 
   
// Grid Details 
	var artgrid = $('#insp_Ctdetails'); 
	var testgrid = $('#insptesttbl'); 
	var gradgrid = $('#inspgradtbl'); 
	var rejgrid = $('#insprejtbl');
	 
	/*
	 * AUTOCOMPLETE	
	 */
	$('#inspContractNo').autocomplete({		
		 source: function(request, response) {
			var type = $('#insptype').val();
			var param = request.term;  
			$.getJSON("/Myelclass/InspAutocomplete.do?term="+param+"&action="+"inspCt"+"&type="+type,
				function(result) { 	
			       response($.map(result, function(item) {
			           return { 
			              value: item.prf_contractno,
			              splcdn: item.prf_inspcdn,
			              };
			        }));//END response
			 });
		 },
		 select: function( event, ui ) { 
         	$('#insp_cdn').val(ui.item.splcdn);
         	var type = $('#insptype').val();
         	var ctno =ui.item.value;
         	alert(ctno);
         	artgrid.jqGrid('setGridParam',{url:"/Myelclass/InspectionAction.do?event=loadarticle&ctno="+ctno+"&type="+type}).trigger("reloadGrid");
         },
         change: function(event,ui){
	    	 $(this).val((ui.item ? ui.item.value : ""));
	   }
	}); 
	$('#inspqualityctrlr').autocomplete({
		 source: function(request, response) {
			var param = request.term;  
			$.getJSON("/Myelclass/InspAutocomplete.do?term="+param+"&action=inspQtCtr",
				function(result) { 	
			       response($.map(result, function(item) {
			           return { 
			              value: item.label,
			              addr: item.tanneryAddress,
			              phone: item.tanneryContactNo,	
			              attn : item.tanneryAttention,
			              fax: item.tanneryFax,
			              };
			        }));//END response
			 	});
		 	},
		 	 change: function(event,ui){
		    	 $(this).val((ui.item ? ui.item.value : ""));
		   }
	}); 
	 //DATEPICKER
     $("#inspdate").datepicker({
    	 	changeMonth:false,
		    dateFormat: "dd-mm-yy",
		    showWeek: true,
		    firstDay: 1,
		    numberOfMonths: 1,
		    showButtonPanel: false,
		    gotoCurrent:true, 
	  });
	
	 //Methods
	 /*  allowOnlyNumbers = function(element) { 
         $(element).keyup(function(){
             var val1 = element.value;
             var num = new Number(val1);
             if(isNaN(num))
             {alert("Only Numbers are Allowed");}
         });
     	}; */	
     	
	// Contract Grid 
	artgrid.jqGrid({  
		url:"",   
		datatype:"json",
		loadonce: false,
		colNames:['Article Id','Article Name', 'Color', 'Tannery', 'Customer','Order Date', 'PONo', 'Size','Subs','Selec','Selec P', 'Quantity'],  
	    colModel:[   
				{name:'prf_articleid', index:'prf_articleid', hidden: true, sortable: true, },
				{name:'prf_articlename', index:'articlename', hidden: false, sortable: true,  },
				{name:'prf_color', index:'color', hidden: false, sortable: true, },
				{name:'prf_tannid', index:'prf_tannid',   hidden: false,sortable: true, },
				{name:'prf_custid', index:'prf_custid',  hidden: false,sortable: true, },
				{name:'prf_orderdate', index:'prf_orderdate',  hidden: false,sortable: true, },
				{name:'prf_poref', index:'prf_poref', hidden: false, sortable: true, },
				{name:'prf_size', index:'size', hidden: false, sortable: true, },
				{name:'prf_substance', index:'subatance', hidden: false, sortable: true, },
				{name:'prf_selection', index:'selection', hidden: false, sortable: true, },
				{name:'prf_selectionp', index:'selectionp', hidden: false, sortable: true, },
				{name:'prf_quantity', index:'prf_quantity', hidden: false, sortable: true, },
			],  
		jsonReader : {  
		  	repeatitems:false,
	      	root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third
		},
		caption: "Load Article Details On Selected CT",
		pager: '#insp_CtDetalspager',
	   	rowNum:5, 
	   	rowList:[5,10,15,20],
	    loadtext: "Bow Bow........... ",
	    height : "auto",
	    width:"auto",
	    multiselect: true,
	    loadonce: true,
	    sortname: 'articlename',  
	    sortorder: 'desc',  
	    viewrecords: true,
	    emptyrecords: 'No records to display',
	    /*
	     * Method to select only one row @ a time in multiselect
	     */
	    beforeSelectRow: function(rowid, e)
	    {
	    	artgrid.jqGrid('resetSelection');
	        return(true);
	    },
	    onSelectRow: function(rowid){
	    	clr = artgrid.jqGrid('getCell', rowid, 'prf_color');
	       	arid = artgrid.jqGrid('getCell', rowid, 'prf_articleid'); 
	       	$("#artidhidden").val(arid); 
	    	$("#articlehidden").val(artgrid.jqGrid('getCell', rowid, 'prf_articlename'));  
	    	$("#colorhidden").val(clr); 
	    	$("#tanhidden").val(artgrid.jqGrid('getCell', rowid, 'prf_tannid')); 
	    	$("#custhidden").val(artgrid.jqGrid('getCell', rowid, 'prf_custid')); 
	    	$("#sizehidden").val(artgrid.jqGrid('getCell', rowid, 'prf_size')); 
	    	$("#substancehidden").val(artgrid.jqGrid('getCell', rowid, 'prf_substance')); 
	    	$("#selhidden").val(artgrid.jqGrid('getCell', rowid, 'prf_selection')); 
	    	$("#quantityhidden").val(artgrid.jqGrid('getCell', rowid, 'prf_quantity')); 
	    	
	       	testgrid.jqGrid('setGridParam',{url:"/Myelclass/InspectionAction.do?event=manualtest&artid="+arid}).trigger("reloadGrid");
	       	gradgrid.jqGrid('setGridParam',{url:"/Myelclass/InspectionAction.do?event=grade&artid="+arid}).trigger("reloadGrid");
	       	rejgrid.jqGrid('setGridParam',{url:"/Myelclass/InspectionAction.do?event=reject&artid="+arid}).trigger("reloadGrid");	       	
		 }
	}).jqGrid('navGrid', '#insp_CtDetalspager',  { edit: false, add: false, del: false, 
	search: false, refresh: true, view:true,
	 refreshtext: 'Reload', viewtext:'View',
	});
	artgrid.jqGrid('setGridWidth', 930);
	
	
//tEST GRID LOAD 
	testgrid.jqGrid({  
				url:"",   
				datatype:"json",
				colNames:['Id','Test Id', 'ArticleID','Color',
				          'Colortest','Colortested', 'Colorresult', 'Colorcomments',
				          'Subtest','Subtested', 'Subresult', 'Subcomments',
				          'Teartest','Teartested', 'Tearresult', 'Tearcomments',
				          'GrainBreak Test','GrainBreaktested', 'GrainBreakresult', 'GrainBreakcomments',
				          'CrockingWet Test','CrockingWettested', 'CrockingWetresult', 'CrockingWetcomments',
				          'CrockingDry Test','CrockingDrytested', 'CrockingDryresult', 'CrockingDrycomments',
				          'FinishAdhension Test','FinishAdhensiontested', 'FinishAdhensionresult', 'FinishAdhensioncomments',
				          'FourFolds Test','FourFoldstested', 'FourFoldsresult', 'FourFoldscomments',
				          'Cross Section','DyeThrutested', 'DyeThruresult', 'DyeThrucomments',
				          'Organoleptic Test','Organoleptictested', 'Organolepticresult', 'Organolepticcomments',
				         ],  
			    colModel:[  
					{name:'id', index:'id', align:'center', width:60, editable:true, hidden: true, 
						
						formoptions: {rowpos: 1, colpos: 1},
					},	
					{name: 'testid', index:'testid', align:'center', width:60, editable:true, hidden: false, 
						editoptions: {size:12},
						formoptions: {rowpos: 2, colpos: 1},
					},
					{name: 'articleid', index: 'articleid', align:'center', width:60, editable:true, hidden: true, 
						editoptions: {size:12},
						editoptions: {size:12, readonly: true},
						formoptions: {rowpos: 2, colpos: 2},
					},
					{name:'testcolor', index:'testcolor', align:'center', width:120, editable:true, hidden: false, 
						editoptions: {size:12}, 
						editoptions: {size:12, readonly: true},
						formoptions: {rowpos: 2, colpos: 3},
						
					},
					{name:'colortest', index:'colortest', align:'center', width:180, editable:true, hidden: true, 
						editoptions: {size:25}, 
						formoptions: {rowpos: 3, colpos: 1},
						
					},
					{name:'colortested', index:'colortest', align:'center', width:70, editable:true, hidden: false, 
						edittype:'text',
						editoptions:{ size: 15, maxlength:2, defaultValue:"0"},
						editrules:{integer: true, required: true},
						formoptions: {rowpos: 3, colpos: 2},
					},
					{name:'colorresult', index:'colorresult', align:'center', width:130, editable:true, hidden:true, 
						 edittype: 'select', 
						 editoptions: {value: {P:'Pass',F:'Fail',N:'Not Applicable'}},		
						 formoptions: {rowpos: 3, colpos: 3},
					},
					{name:'colorcomments', index:'colorcomments', align:'center', width:120, editable:true, hidden:true, 
						edittype: 'text',
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 3, colpos: 4},
					},	
					{name:'subtest', index:'subtest', align:'center', width:150, editable:true, hidden: true, 
						editoptions: {size:25}, 
						formoptions: {rowpos: 4, colpos: 1},
						
					},
					{name:'subtested', index:'subtest', align:'center', width:60, editable:true, hidden:false, 
						edittype:'text',
						editoptions:{ size: 15, maxlength:2, defaultValue:"0"},
						editrules:{integer: true, required: true},
						formoptions: {rowpos: 4, colpos: 2},
					},
					{name:'subresult', index:'subresult', align:'center', width:130, editable:true, hidden:true, 
						 edittype: 'select', 
						 editoptions: {value: {P:'Pass',F:'Fail',N:'Not Applicable'}},		
						 formoptions: {rowpos: 4, colpos: 3},
					},
					{name:'subcomments', index:'subcomments', align:'center', width:120, editable:true, hidden:true, 
						edittype: 'text',
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 4, colpos: 4},
					},
					{name:'teartest', index:'teartest', align:'center', width:120, editable:true, hidden: true, 
						editoptions: {size:25}, 
						formoptions: {rowpos: 5, colpos: 1},						
					},
					{name:'teartested', index:'teartest', align:'center', width:60, editable:true, hidden:false, 
						edittype:'text',
						editoptions:{ size: 15, maxlength:2, defaultValue:"0"},
						editrules:{integer: true, required: true},
						formoptions: {rowpos: 5, colpos: 2},
					},
					{name:'tearresult', index:'tearresult', align:'center', width:130, editable:true, hidden:true, 
						 edittype: 'select', 
						 editoptions: {value: {P:'Pass',F:'Fail',N:'Not Applicable'}},	
						 formoptions: {rowpos: 5, colpos: 3},
					},
					{name:'tearcomments', index:'tearcomments', align:'center', width:120, editable:true, hidden:true, 
						edittype: 'text',
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 5, colpos: 4},
					},
					{name:'grainbreaktest', index:'grainbreaktest', align:'center', width:220, editable:true, hidden: true, 
						editoptions: {size:25}, 
						formoptions: {rowpos: 6, colpos: 1},
						
					},
					{name:'grainbreaktested', index:'grainbreaktest', align:'center', width:70, editable:true, hidden: false, 
						edittype:'text',
						editoptions:{ size: 15, maxlength:2, defaultValue:"0"},
						editrules:{integer: true, required: true},
						formoptions: {rowpos: 6, colpos: 2},
					},
					{name:'grainbreakresult', index:'grainbreakresult', align:'center', width:130, editable:true, hidden:true, 
						 edittype: 'select', 
						 editoptions: {value: {P:'Pass',F:'Fail',N:'Not Applicable'}},		
						 formoptions: {rowpos: 6, colpos: 3},
					},
					{name:'grainbreakcomments', index:'grainbreakcomments', align:'center', width:120, editable:true, hidden:true, 
						edittype: 'text',
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 6, colpos: 4},
					},	
					{name:'crockingwettest', index:'crockingwettest', align:'center', width:120, editable:true, hidden: true, 
						editoptions: {size:25}, 
						formoptions: {rowpos: 7, colpos: 1},
						
					},
					{name:'crockingwettested', index:'crockingwettest', align:'center', width:80, editable:true, hidden:false, 
						edittype:'text',
						editoptions:{ size: 15, maxlength:2, defaultValue:"0"},
						editrules:{integer: true, required: true},
						formoptions: {rowpos: 7, colpos: 2},
					},
					{name:'crockingwetresult', index:'crockingwetresult', align:'center', width:130, editable:true, hidden:true, 
						 edittype: 'select', 
						 editoptions: {value: {P:'Pass',F:'Fail',N:'Not Applicable'}},		
						 formoptions: {rowpos: 7, colpos: 3},
					},
					{name:'crockingwetcomments', index:'crockingwetcomments', align:'center', width:120, editable:true, hidden:true, 
						edittype: 'text',
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 7, colpos: 4},
					},	
					{name:'crockingdrytest', index:'crockingdrytest', align:'center', width:120, editable:true, hidden: true, 
						editoptions: {size:25}, 
						formoptions: {rowpos: 8, colpos: 1},
						
					},
					{name:'crockingdrytested', index:'crockingdrytest', align:'center', width:70, editable:true, hidden:false, 
						edittype:'text',
						editoptions:{ size: 15, maxlength:2, defaultValue:"0"},
						editrules:{integer: true, required: true},
						formoptions: {rowpos: 8, colpos: 2},
					},
					{name:'crockingdryresult', index:'crockingdryresult', align:'center', width:130, editable:true, hidden:true, 
						 edittype: 'select', 
						 editoptions: {value: {P:'Pass',F:'Fail',N:'Not Applicable'}},		
						 formoptions: {rowpos: 8, colpos: 3},
					},
					{name:'crockingdrycomments', index:'crockingdrycomments', align:'center', width:120, editable:true, hidden:true, 
						edittype: 'text',
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 8, colpos: 4},
					},	
					{name:'finishadhensiontest', index:'finishadhensiontest', align:'center', width:120, editable:true, hidden: true, 
						editoptions: {size:25}, 
						formoptions: {rowpos: 9, colpos: 1},
						
					},
					{name:'finishadhensiontested', index:'finishadhensiontest', align:'center', width:80, editable:true, hidden:false, 
						edittype:'text',
						editoptions:{ size: 15, maxlength:2, defaultValue:"0"},
						editrules:{integer: true, required: true},
						formoptions: {rowpos: 9, colpos: 2},
					},
					{name:'finishadhensionresult', index:'finishadhensionresult', align:'center', width:130, editable:true, hidden:true, 
						 edittype: 'select', 
						 editoptions: {value: {P:'Pass',F:'Fail',N:'Not Applicable'}},		
						 formoptions: {rowpos: 9, colpos: 3},
					},
					{name:'finishadhensioncomments', index:'finishadhensioncomments', align:'center', width:120, editable:true, hidden:true, 
						edittype: 'text',
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 9, colpos: 4},
					},	
					{name:'fourfoldstest', index:'fourfoldstest', align:'center', width:120, editable:true, hidden: true, 
						editoptions: {size:25}, 
						formoptions: {rowpos: 10, colpos: 1},
						
					},
					{name:'fourfoldstested', index:'fourfoldstest', align:'center', width:80, editable:true, hidden:false, 
						edittype:'text',
						editoptions:{ size: 15, maxlength:2, defaultValue:"0"},
						editrules:{integer: true, required: true},
						formoptions: {rowpos: 10, colpos: 2},
					},
					{name:'fourfoldsresult', index:'fourfoldsresult', align:'center', width:130, editable:true, hidden:true, 
						 edittype: 'select', 
						 editoptions: {value: {P:'Pass',F:'Fail',N:'Not Applicable'}},		
						 formoptions: {rowpos: 10, colpos: 3},
					},
					{name:'fourfoldscomments', index:'fourfoldscomments', align:'center', width:120, editable:true, hidden:true, 
						edittype: 'text',
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 10, colpos: 4},
					},	
					{name:'dyethrutest', index:'dyethrutest', align:'center', width:120, editable:true, hidden: true, 
						editoptions: {size:25}, 
						formoptions: {rowpos: 11, colpos: 1},
						
					},
					{name:'dyethrutested', index:'dyethrutest', align:'center', width:60, editable:true, hidden: false, 
						edittype:'text',
						editoptions:{ size: 15, maxlength:2, defaultValue:"0"},
						editrules:{integer: true, required: true},
						formoptions: {rowpos: 11, colpos: 2},
					},
					{name:'dyethruresult', index:'dyethruresult', align:'center', width:130, editable:true, hidden:true, 
						 edittype: 'select', 
						 editoptions: {value: {P:'Pass',F:'Fail',N:'Not Applicable'}},		
						 formoptions: {rowpos: 11, colpos: 3},
					},
					{name:'dyethrucomments', index:'dyethrucomments', align:'center', width:120, editable:true, hidden:true, 
						edittype: 'text',
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 11, colpos: 4},
					},	
					{name:'organoleptictest', index:'organoleptictest', align:'center', width:120, editable:true, hidden: true, 
						editoptions: {size:25}, 
						formoptions: {rowpos: 12, colpos: 1},
						
					},
					{name:'organoleptictested', index:'organoleptictest', align:'center', width:60, editable:true, hidden:false, 
						edittype:'text',
						editoptions:{ size: 15, maxlength:2, defaultValue:"0"},
						editrules:{integer: true, required: true},
						formoptions: {rowpos: 12, colpos: 2},
					},
					{name:'organolepticresult', index:'organolepticresult', align:'center', width:130, editable:true, hidden:true, 
						 edittype: 'select', 
						 editoptions: {value: {P:'Pass',F:'Fail',N:'Not Applicable'}},		
						 formoptions: {rowpos: 12, colpos: 3},
					},
					{name:'organolepticcomments', index:'organolepticcomments', align:'center', width:120, editable:true, hidden:true, 
						edittype: 'text',
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 12, colpos: 4},
					},	
				],  
				jsonReader : {  
				  	repeatitems:false,
			      	root: "rows",
			      	page: "page", 
			      	total: "total" ,
			      	records: "records" 
				},
				editurl: "/Myelclass/InspectionAction.do?event=manualtest&artid="+arid,
				caption: "Test Details",
		    	pager: '#insptestpager',
		    	viewrecords: true,
		    	rowNum: 20, 
		    	rowList: [20,40,60],
		        loadtext: "Bow Bow........... ",
		        height : "auto",
		        width: "auto",  
		        sortname: 'testid',  
		        sortorder: 'desc', 
		        emptyrecords: 'No records to display',
		      /*  loadComplete: function() {
		        	alert(testgrid.jqGrid('getGridParam', 'records')); //get number of rows count 
		        },*/
			}).jqGrid('navGrid', '#insptestpager',  { 
				edit: true, add: true, del: true, search: false, refresh: true, view: true,
				addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View'
				},
				{ 
					width : 700,
					top:120,
					left:120,
					recreateForm: true,
					//Edit
				 	beforeShowForm: function(formID){	
						/*
						 * Show Hidden to True
						 */
				 		 $("#tr_id").hide();
				 		 $("#tr_colortest").show();	
					     $("#tr_colortested").show();
					     $("#tr_colortestresult").show();
					     $("#tr_colorcomments").show();
				 		
					     $("#tr_subtest").show();	
					     $("#tr_subtested").show();
					     $("#tr_subresult").show();
					     $("#tr_subcomments").show();
					     $("#tr_teartest").show();
					     $("#tr_teartested").show();
					     $("#tr_tearresult").show();
					     $("#tr_tearcomments").show();
					     $("#tr_grainbreaktest").show(); 
					     $("#tr_grainbreaktested").show();
					     $("#tr_grainbreakresult").show();
					     $("#tr_grainbreakcomments").show();
					     $("#tr_crockingwettest").show();
					     $("#tr_crockingwettested").show();
					     $("#tr_crockingwetresult").show();
					     $("#tr_crockingwetcomments").show();
					     $("#tr_crockingdrytest").show();
					     $("#tr_crockingdrytested").show();
					     $("#tr_crockingdryresult").show();
					     $("#tr_crockingdrycomments").show();
					     $("#tr_finishadhensiontest").show();
					     $("#tr_finishadhensiontested").show();
					     $("#tr_finishadhensionresult").show();
					     $("#tr_finishadhensioncomments").show();
					     $("#tr_fourfoldstest").show();
					     $("#tr_fourfoldstested").show();	
					     $("#tr_fourfoldsresult").show();
					     $("#tr_fourfoldscomments").show();
					     $("#tr_dyethrutest").show();
					     $("#tr_dyethrutested").show();	
					     $("#tr_dyethruresult").show();
					     $("#tr_dyethrucomments").show();
					     $("#tr_organoleptictest").show();	
					     $("#tr_organoleptictested").show();
					     $("#tr_organolepticresult").show();
					     $("#tr_organolepticcomments").show();
					     $("#tr_articleid").show();
						 /*
						  * Set values of test type inside textfield 
						  */
						  $("#id").attr("readonly","readonly"); 
						  $("#colortest").val('Color').attr("readonly","readonly"); 
						  $("#subtest").val('Substance').attr("readonly","readonly"); 
						  $("#teartest").val('Tear Strength').attr("readonly","readonly");  
						  $("#grainbreaktest").val('Grain Break').attr("readonly","readonly");  
						  $("#crockingwettest").val('Crocking Wet').attr("readonly","readonly");  
						  $("#crockingdrytest").val('Crocking Dry').attr("readonly","readonly");  
						  $("#finishadhensiontest").val('Finish Adhension').attr("readonly","readonly");  
						  $("#fourfoldstest").val('FourFolds').attr("readonly","readonly");  
						  $("#dyethrutest").val('Cross Section').attr("readonly","readonly");  
						  $("#organoleptictest").val('Organoleptic').attr("readonly","readonly");  
						  
						 /*
						  * Hide the TextField Label  	
						  * http://stackoverflow.com/questions/4484220/jqgrid-dynamic-form-change-label-in-formedit-add
						  */
						  jQuery('tr#tr_colortest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_subtest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_teartest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_grainbreaktest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_crockingwettest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_crockingdrytest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_finishadhensiontest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_fourfoldstest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_dyethrutest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_organoleptictest > td.CaptionTD', formID[0]).html('');
						 
						  
						  $("#testcolor").val(clr);
						  $("#articleid").val(arid);
						  /*$("#tr_testid").hide();
						  $("#tr_articleid").hide();*/
						  
						  /*
						   * Grouping fields with Header
						   * group vertically
						   * When I wrote this, only God and I understood what I was doing
						   * Now, God only knows
						   */
						  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
							      '<div style="padding:3px; text-align: center;" class="ui-widget-header ui-corner-all">' +
							      '<b>Test Type</b></div></td></tr>')
							      .insertBefore('#tr_colortest');
						  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
								  '<div style="padding:3px; text-align: center" class="ui-widget-header ui-corner-all">' +
								  '<b>Pieces Tested</b></div></td></tr>')
								  .insertBefore('#tr_colortest');
						  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
								  '<div style="padding:3px; text-align: center" class="ui-widget-header ui-corner-all">' +
								  '<b>Results</b></div></td></tr>')
								  .insertBefore('#tr_colortest');
						  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
								  '<div style="padding:3px; text-align: center" class="ui-widget-header ui-corner-all">' +
								  '<b>Comments</b></div></td></tr>')
							      .insertBefore('#tr_colortest');
						 },
						 reloadAfterSubmit: true,
						 closeAfterEdit: true,
						
					},
					{
						 width : 700,
						 top:120,
						 left:120,
						 recreateForm: true,
					   //  Add 
			 		    beforeShowForm: function(formID){
			 		    /*
						 * Show Hidden to True
						 */
			 		     $("#tr_colortest").show();	
						 $("#tr_colortested").show();
						 $("#tr_colortestresult").show();
						 $("#tr_colorcomments").show();
			 		     $("#tr_subtest").show();	
			 		     $("#tr_subtested").show();
			 		     $("#tr_subresult").show();
			 		     $("#tr_subcomments").show();
			 		     $("#tr_teartest").show();
			 		     $("#tr_teartested").show();
			 		     $("#tr_tearresult").show();
			 		     $("#tr_tearcomments").show();
			 		     $("#tr_grainbreaktest").show(); 
			 		     $("#tr_grainbreaktested").show();
			 		     $("#tr_grainbreakresult").show();
			 		     $("#tr_grainbreakcomments").show();
			 		     $("#tr_crockingwettest").show();
			 		     $("#tr_crockingwettested").show();
			 		     $("#tr_crockingwetresult").show();
			 		     $("#tr_crockingwetcomments").show();
			 		     $("#tr_crockingdrytest").show();
			 		     $("#tr_crockingdrytested").show();
			 		     $("#tr_crockingdryresult").show();
			 		     $("#tr_crockingdrycomments").show();
			 		     $("#tr_finishadhensiontest").show();
			 		     $("#tr_finishadhensiontested").show();
			 		     $("#tr_finishadhensionresult").show();
			 		     $("#tr_finishadhensioncomments").show();
			 		     $("#tr_fourfoldstest").show();
			 		     $("#tr_fourfoldstested").show();	
			 		     $("#tr_fourfoldsresult").show();
			 		     $("#tr_fourfoldscomments").show();
			 		     $("#tr_dyethrutest").show();
			 		     $("#tr_dyethrutested").show();	
			 		     $("#tr_dyethruresult").show();
			 		     $("#tr_dyethrucomments").show();
			 		     $("#tr_organoleptictest").show();	
			 		     $("#tr_organoleptictested").show();
			 		     $("#tr_organolepticresult").show();
			 		     $("#tr_organolepticcomments").show();	
			 		     $("#tr_articleid").show();
						 /*
						  * Set values of test type inside textfield 
						  * 
						  */
						  $("#colortest").val('Color').attr("readonly","readonly"); 
						  $("#subtest").val('Substance').attr("readonly","readonly"); 
						  $("#teartest").val('Tear Strength').attr("readonly","readonly");  
						  $("#grainbreaktest").val('Grain Break').attr("readonly","readonly");  
						  $("#crockingwettest").val('Crocking Wet').attr("readonly","readonly");  
						  $("#crockingdrytest").val('Crocking Dry').attr("readonly","readonly");  
						  $("#finishadhensiontest").val('Finish Adhension').attr("readonly","readonly");  
						  $("#fourfoldstest").val('FourFolds').attr("readonly","readonly");  
						  $("#dyethrutest").val('Cross Section').attr("readonly","readonly");  
						  $("#organoleptictest").val('Organoleptic').attr("readonly","readonly");  						  
						 /*
						  * Hide the TextField Label  	
						  * http://stackoverflow.com/questions/4484220/jqgrid-dynamic-form-change-label-in-formedit-add
						  */
						  jQuery('tr#tr_id > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_colortest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_subtest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_teartest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_grainbreaktest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_crockingwettest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_crockingdrytest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_finishadhensiontest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_fourfoldstest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_dyethrutest > td.CaptionTD', formID[0]).html('');
						  jQuery('tr#tr_organoleptictest > td.CaptionTD', formID[0]).html('');
						 
						  
						  $("#testcolor").val(clr);
						  $("#articleid").val(arid);
						  $("#id").hide();
						  /*$("#tr_articleid").hide();*/
						  
						  /*
						   * Grouping fields with Header
						   * group vertically
						   * When I wrote this, only God and I understood what I was doing
						   * Now, God only knows
						   */
						  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
							      '<div style="padding:3px; text-align: center;" class="ui-widget-header ui-corner-all">' +
							      '<b>Test Type</b></div></td></tr>')
							      .insertBefore('#tr_colortest');
						  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
								  '<div style="padding:3px; text-align: center" class="ui-widget-header ui-corner-all">' +
								  '<b>Pieces Tested</b></div></td></tr>')
								  .insertBefore('#tr_colortest');
						  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
								  '<div style="padding:3px; text-align: center" class="ui-widget-header ui-corner-all">' +
								  '<b>Results</b></div></td></tr>')
								  .insertBefore('#tr_colortest');
						  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
								  '<div style="padding:3px; text-align: center" class="ui-widget-header ui-corner-all">' +
								  '<b>Comments</b></div></td></tr>')
							      .insertBefore('#tr_colortest');
					 },
					 reloadAfterSubmit: true,
					 closeAfterAdd: true,
					});//testgrid.jqGrid('setGridWidth', 930);
		
//Grade GRID
		gradgrid.jqGrid({  
				url: "",   
				datatype:"json",
				colNames:['Id','Grade ID','Article Id','Color',  'Tot Passed',
				          'Grade1', 'Skin Count1', 'Percentage1','Comments1',
				          'Grade2', 'Skin Count2', 'Percentage2','Comments2',
				          'Grade3', 'Skin Count3', 'Percentage3','Comments3',
				          'Grade4', 'Skin Count4', 'Percentage4','Comments4',
				          'Grade5', 'Skin Count5', 'Percentage5','Comments5',
				          'Improvement ', 'Skin Count6', 'Percentage6','Comments6',
				          ],  
			    colModel:[   
					{name:'id', index:'id',align:'center', width:80, editable:true, sortable: true, hidden: true, 
						formoptions: {rowpos: 1, colpos: 1},
					},
					{name:'gradeid', index:'gradeid', align:'center', width:80, editable:true, sortable: true, hidden: false,
						formoptions: {rowpos: 2, colpos: 1},
					},
					{name:'artid', index:'artid', align:'center', width:80, editable:true, sortable: true, hidden: false,
						formoptions: {rowpos: 2, colpos: 2},
						editoptions: {size:12, readonly: true},
					},
					{name: 'gradecolor', index: 'gradecolor', align: 'center', width: 80, editable: true, sortable: true, hidden: false,
						formoptions: {rowpos: 2, colpos: 3},
						editoptions: {size:12, readonly: true},
					},
					{name:'grtotinspected', index:'grtotinspected', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						formoptions: {rowpos: 2, colpos: 4},
						editoptions: {size:12, readonly: true},
					},
					{name:'grade1', index:'grade1', align:'center', width:120, editable:true, sortable: true, hidden: false,
						formoptions: {rowpos: 3, colpos: 1},
					},
					{name:'skincount1', index:'skincount1', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						//Focus Out 
						editoptions: { defaultValue:"0", 
							dataEvents:[{
								type: 'focusout',
								fn: function(e){
									var percent = 0.00;
									var prcntval = 0.00;
									var skincount = $("#skincount1").val();
									var totinspect = $("#grtotinspected").val();
									percent = (skincount / totinspect) * 100;
									prcntval = percent.toFixed(2);
									$("#percent1").val(prcntval);				
								}
							}]  
						}, 
						editrules:{integer: true},
						formoptions: {rowpos: 3, colpos: 2},
					},	
					
					{name:'percent1', index:'percent1', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						formoptions: {rowpos: 3, colpos: 3},
						editoptions:{ defaultValue:"0.00" },
					},
					{name:'comment1', index:'comment1', align:'center', width:120, editable:true, sortable: true, hidden:true, 
						edittype: 'text', 
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 3, colpos: 4},
					},	
					{name:'grade2', index:'grade2', align:'center', width:120, editable:true, sortable: true, hidden: false,
						edittype: 'text',  
						formoptions: {rowpos: 4, colpos: 1},
					},
					{name:'skincount2', index:'skincount2', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						//Focus Out 
						editoptions: { 
							dataEvents:[{defaultValue:"0", 
								type: 'focusout',
								fn: function(e){
									var percent = 0.00;
									var prcntval = 0.00;
									var skincount = $("#skincount2").val();
									var totinspect = $("#grtotinspected").val();
									percent = (skincount / totinspect) * 100;
									prcntval = percent.toFixed(2);
									$("#percent2").val(prcntval);
								}
							}]  
						},
						editrules:{integer: true},
						formoptions: {rowpos: 4, colpos: 2},
					},	
					{name:'percent2', index:'percent2', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						formoptions: {rowpos: 4, colpos: 3},	
						editoptions:{ defaultValue:"0.00" },
					},
					{name:'comment2', index:'comment2', align:'center', width:120, editable:true, sortable: true, hidden:true, 
						edittype: 'text', 
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 4, colpos: 4},
					},	
					{name:'grade3', index:'grade3', align:'center', width:120, editable:true, sortable: true, hidden: false,
						edittype: 'text', 
						formoptions: {rowpos: 5, colpos: 1},
					},
					{name:'skincount3', index:'skincount3', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						//Focus Out 
						editoptions: { 
							dataEvents:[{defaultValue:"0", 
								type: 'focusout',
								fn: function(e){
									var percent = 0.00;
									var prcntval = 0.00;
									var skincount = $("#skincount3").val();
									var totinspect = $("#grtotinspected").val();
									percent = (skincount / totinspect) * 100;
									prcntval = percent.toFixed(2);
									$("#percent3").val(prcntval);
									
								}
							}]  
						},
						editrules:{integer: true},
						formoptions: {rowpos: 5, colpos: 2},
					},	
					{name:'percent3', index:'percent3', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						formoptions: {rowpos: 5, colpos: 3},	
						editoptions:{ defaultValue:"0.00" },
					},
					{name:'comment3', index:'comment3', align:'center', width:120, editable:true, sortable: true, hidden:true, 
						edittype: 'text', 
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 5, colpos: 4},
					},	
					{name:'grade4', index:'grade4', align:'center', width:120, editable:true, sortable: true, hidden: true,
						edittype: 'text', 
						formoptions: {rowpos: 6, colpos: 1},
					},
					{name:'skincount4', index:'skincount4', align:'center', width:120, editable:true, sortable: true, hidden: true, 
						//Focus Out 
						editoptions: { 
							dataEvents:[{defaultValue:"0", 
								type: 'focusout',
								fn: function(e){
									var percent = 0.00;
									var prcntval = 0.00;
									var skincount = $("#skincount4").val();
									var totinspect = $("#grtotinspected").val();
									percent = (skincount / totinspect) * 100;
									prcntval = percent.toFixed(2);
									$("#percent4").val(prcntval);
									
								}
							}]  
						},
						editrules:{integer: true},
						formoptions: {rowpos: 6, colpos: 2},
					},	
					{name:'percent4', index:'percent4', align:'center', width:120, editable:true, sortable: true, hidden: true, 
						formoptions: {rowpos: 6, colpos: 3},	
						editoptions:{ defaultValue:"0.00" },
					},
					{name:'comment4', index:'comment4', align:'center', width:120, editable:true, sortable: true, hidden:true, 
						edittype: 'text', 
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 6, colpos: 4},
					},	
					{name:'grade5', index:'grade5', align:'center', width:120, editable:true, sortable: true, hidden: true,
						edittype: 'text', 
						formoptions: {rowpos: 7, colpos: 1},
					},
					{name:'skincount5', index:'skincount5', align:'center', width:120, editable:true, sortable: true, hidden: true, 
						//Focus Out 
						editoptions: { 
							dataEvents:[{defaultValue:"0", 
								type: 'focusout',
								fn: function(e){
									var percent = 0.00;
									var prcntval = 0.00;
									var skincount = $("#skincount5").val();
									var totinspect = $("#grtotinspected").val();
									percent = (skincount / totinspect) * 100;
									prcntval = percent.toFixed(2);
									$("#percent5").val(prcntval);
									
								}
							}]  
						},
						
						formoptions: {rowpos: 7, colpos: 2},
					},	
					{name:'percent5', index:'percent5', align:'center', width:120, editable:true, sortable: true, hidden: true, 
						formoptions: {rowpos: 7, colpos: 3},
						editoptions:{ defaultValue:"0.00" },
					},
					{name:'comment5', index:'comment5', align:'center', width:120, editable:true, sortable: true, hidden:true, 
						edittype: 'text', 
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 7, colpos: 4},
					},
					{name:'improvement', index:'improvement', align:'center', width:120, editable:true, sortable: true, hidden: false,
						edittype: 'text', 
						formoptions: {rowpos: 8, colpos: 1},
					},
					{name:'skincount6', index:'skincount6', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						//Focus Out 
						editoptions: { 
							dataEvents:[{defaultValue:"0", 
								type: 'focusout',
								fn: function(e){
									var percent = 0.00;
									var prcntval = 0.00;
									var skincount = $("#skincount6").val();
									var totinspect = $("#grtotinspected").val();
									percent = (skincount / totinspect) * 100;
									prcntval = percent.toFixed(2);
									$("#percent6").val(prcntval);
									
								}
							}]  
						},
						formoptions: {rowpos: 8, colpos: 2},
					},	
					{name:'percent6', index:'percent6', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						formoptions: {rowpos: 8, colpos: 3},
						editoptions:{ defaultValue:"0.00" },
					},
					{name:'comment6', index:'comment6', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						edittype: 'text', 
						editoptions:{ defaultValue:"NA" },
						formoptions: {rowpos: 8, colpos: 4},
					},
				],  
				jsonReader : {  
				  	repeatitems:false,
			      	root: "rows",
			      	page: "page", //calls first
			      	total: "total" ,//calls Second
			      	records: "records" //calls Third
				},
				caption: "Grading Details ",
				editurl: "/Myelclass/InspectionAction.do?event=grade&artid="+arid,
		    	pager: '#inspgradpager',
		    	rowNum:2, 
		    	rowList:[2,4,6],
		        loadtext: "Bow Bow.......",
		        height : "auto",
		        width:"auto",  
		        viewrecords: true,
		        sortname: 'gradeid',  
		        sortorder: 'desc',  
		        emptyrecords: 'No records to display',
		   	 	loadComplete:function(data){
		   	 	
		   	 	},
		}).jqGrid('navGrid', '#inspgradpager',  { 
			edit: true, add: true, del: true, search: false, refresh: true, view: true,
			addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View'	
		},
			{			
				// Edit
				
				 width : 700,
				 top:120,
				 left:120,
				 recreateForm : true,
				
				beforeShowForm: function(formID){
					 $("#tr_comment1").show();	
		 		     $("#tr_comment2").show();
		 		     $("#tr_comment3").show();
		 		     $("#tr_comment4").show();
		 		     $("#tr_comment5").show();
		 		     $("#tr_comment6").show();
		 		     $("#tr_grade4").show();
		 		     $("#tr_skincount4").show();
		 		     $("#tr_percent4").show();
		 		     $("#tr_grade5").show(); 
		 		     $("#tr_skincount5").show();
		 		     $("#tr_percent5").show();
		 		     $("#tr_grade6").show(); 
		 		     $("#tr_skincount6").show();
		 		     $("#tr_percent6").show();
					 /*
					  * Set values of test type inside textfield 
					  * 
					  */
					  $("#grade1").val('Grade 1').attr("readonly","readonly"); 
					  $("#grade2").val('Grade 2').attr("readonly","readonly");  
					  $("#grade3").val('Grade 3').attr("readonly","readonly");  
					  $("#grade4").val('Grade 4').attr("readonly","readonly"); 
					  $("#grade5").val('Grade 5').attr("readonly","readonly");
					  $("#improvement").val('Improvement').attr("readonly","readonly");
					  /*
					   * Hide the TextField Label  	
					   * http://stackoverflow.com/questions/4484220/jqgrid-dynamic-form-change-label-in-formedit-add
					   */
					  jQuery('tr#tr_grtotinspected > td.CaptionTD', formID[0]).html('');
					  jQuery('tr#tr_grade1 > td.CaptionTD', formID[0]).html('');
					  jQuery('tr#tr_grade2 > td.CaptionTD', formID[0]).html('');
					  jQuery('tr#tr_grade3 > td.CaptionTD', formID[0]).html('');
					  jQuery('tr#tr_grade4 > td.CaptionTD', formID[0]).html('');
					  jQuery('tr#tr_grade5 > td.CaptionTD', formID[0]).html('');
					  jQuery('tr#tr_improvement > td.CaptionTD', formID[0]).html('');
					  
					  
					  $("#grtotinspected").val($("#totinspected").val());
					  $("#gradecolor").val(clr);
					  $("#artid").val(arid);
					
					  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
						      '<div style="padding:3px; text-align: center;" class="ui-widget-header ui-corner-all">' +
						      '<b>Grade Type</b></div></td></tr>')
						      .insertBefore('#tr_grade1');
					  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
							  '<div style="padding:3px; text-align: center" class="ui-widget-header ui-corner-all">' +
							  '<b>Skin Count</b></div></td></tr>')
							  .insertBefore('#tr_grade1');
					  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
							  '<div style="padding:3px; text-align: center" class="ui-widget-header ui-corner-all">' +
							  '<b>Skin Percentage</b></div></td></tr>')
							  .insertBefore('#tr_grade1');
					  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
							  '<div style="padding:3px; text-align: center" class="ui-widget-header ui-corner-all">' +
							  '<b>Comments</b></div></td></tr>')
						      .insertBefore('#tr_grade1');
				},
				editData:{
					articleid: function (){
						var ival =arid ;
						return ival;
					}
				},	
				reloadAfterSubmit: true,
				closeAfterEdit: true,
			},
			{
					
				 width : 800,
				 top:180,
				 left:120,
				 recreateForm : true,
				//Add
				 beforeShowForm: function(formID){
					 $("#tr_comment1").show();	
		 		     $("#tr_comment2").show();
		 		     $("#tr_comment3").show();
		 		     $("#tr_comment4").show();
		 		     $("#tr_comment5").show();
		 		     $("#tr_comment6").show();
		 		     $("#tr_grade4").show();
		 		     $("#tr_skincount4").show();
		 		     $("#tr_percent4").show();
		 		     $("#tr_grade5").show(); 
		 		     $("#tr_skincount5").show();
		 		     $("#tr_percent5").show();
		 		     $("#tr_grade6").show(); 
		 		     $("#tr_skincount6").show();
		 		     $("#tr_percent6").show();
					 
					 /*
					  * Set values of test type inside textfield 
					  * 
					  */
					  $("#grade1").val('Grade 1').attr("readonly","readonly"); 
					  $("#grade2").val('Grade 2').attr("readonly","readonly");  
					  $("#grade3").val('Grade 3').attr("readonly","readonly");  
					  $("#grade4").val('Grade 4').attr("readonly","readonly"); 
					  $("#grade5").val('Grade 5').attr("readonly","readonly"); 
					  $("#improvement").val('Improvement').attr("readonly","readonly"); 
					  /*
					   * Hide the TextField Label  	
					   * http://stackoverflow.com/questions/4484220/jqgrid-dynamic-form-change-label-in-formedit-add
					   */
					  jQuery('tr#tr_grtotinspected > td.CaptionTD', formID[0]).html('');
					  jQuery('tr#tr_grade1 > td.CaptionTD', formID[0]).html('');
					  jQuery('tr#tr_grade2 > td.CaptionTD', formID[0]).html('');
					  jQuery('tr#tr_grade3 > td.CaptionTD', formID[0]).html('');
					  jQuery('tr#tr_grade4 > td.CaptionTD', formID[0]).html('');
					  jQuery('tr#tr_grade5 > td.CaptionTD', formID[0]).html('');
					  jQuery('tr#tr_improvement > td.CaptionTD', formID[0]).html('');
					  
					  $("#grtotinspected").val($("#totinspected").val());
					  $("#gradecolor").val(clr);
					  $("#artid").val(arid);
					
					 
					 
					 $('<td class="CaptionTD ui-widget-content" colspan="2">' +
						      '<div style="padding:3px; text-align: center;" class="ui-widget-header ui-corner-all">' +
						      '<b>Grade Type</b></div></td></tr>')
						      .insertBefore('#tr_grade1');
					  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
							  '<div style="padding:3px; text-align: center" class="ui-widget-header ui-corner-all">' +
							  '<b>Skin Count</b></div></td></tr>')
							  .insertBefore('#tr_grade1');
					  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
							  '<div style="padding:3px; text-align: center" class="ui-widget-header ui-corner-all">' +
							  '<b>Skin Percentage</b></div></td></tr>')
							  .insertBefore('#tr_grade1');
					  $('<td class="CaptionTD ui-widget-content" colspan="2">' +
							  '<div style="padding:3px; text-align: center" class="ui-widget-header ui-corner-all">' +
							  '<b>Comments</b></div></td></tr>')
						      .insertBefore('#tr_grade1');
					 
				 }, 
				reloadAfterSubmit: true,
				closeAfterAdd: true,
				editData:{
					articleid: function (){
						var ival =arid ;
						return ival;
					}
				}
	});gradgrid.jqGrid('setGridWidth', 930);

//Rejects Grid
rejgrid.jqGrid({  
	url:"",   
	datatype:"json",
	colNames:[ 'Hides/Sides', 'id', 'RejectID ', 'Color ', 'Substance','Size','Selec','Color','Org','Others','Tot Rej','Tot Insp', 'Tot Pass'],  
    colModel:[ 
		{name:'arttype', index:'arttype', align:'center', width:120, editable:true, sortable: true, hidden: false, 
			edittype: 'select', editoptions: {value: {H:'Hides',S:'Sides',HS:'H&S'}},
		},
		{name:'id', index:'id', align:'center', width:120, editable:true, sortable: true,  hidden: true, 
	
		},
		{name:'rejectid', index:'rejectid',align:'center', width:120, editable:true, sortable: true,  hidden: false, 
				
		}, 
		{name:'rejcolor', index:'rejcolor', align:'center', width:80, editable:true, sortable: true, hidden:false, 
			editoptions: {size:12, readonly: true},
		},
		{name:'subsrejects', index:'subsrejects', align:'center', width:60, editable:true, sortable: true, hidden:false, 
			
		},	
		{name:'sizerejects', index:'sizerejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			
		},
		{name:'selecrejects', index:'selecrejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			
		},			
		{name:'colorrejects', index:'colorrejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			
		},	
		{name:'orgrejects', index:'orgrejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			
		},	
		{name:'otherrejects', index:'otherrejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			//Focus out 
			editoptions: { 
				dataEvents:[{
					type: 'focusout',
					fn: function(e){
						var totrej = 0;
						var totinsp = 0;
						
						var totpasd = parseInt ($("#totpassed").val());
						var subrej = parseInt ($("#subsrejects").val());
						var sizerej = parseInt ($("#sizerejects").val());
						var selecrej = parseInt ($("#selecrejects").val());
						var colorrej = parseInt ($("#colorrejects").val());
						var orgrej =  parseInt ($("#orgrejects").val());
						var otherrej = parseInt ($("#otherrejects").val());
						
						totrej =  parseInt(subrej + sizerej + selecrej + colorrej + orgrej + otherrej);
						totinsp = parseInt (totpasd + totrej);
						
						$("#totrejects").val(totrej);
						$("#rjtotinspected").val(totinsp);
						
					}
				}]  
			  },
		},
		{name:'totrejects', index:'totrejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			
		},	
		{name:'rjtotinspected', index:'rjtotinspected', align:'center', width:80, editable:true, sortable: true, hidden:false, 
			
		},
		{name:'totpassed', index:'totpassed', align:'center', width:120, editable:true, sortable: true, hidden:false, 
			
		},
	],  
	jsonReader : {  
	  	repeatitems:false,
      	root: "rows",
      	page: "page", //calls first
      	total: "total" ,//calls Second
      	records: "records" //calls Third
	},
	caption: "Rejects Details ",
	editurl: "/Myelclass/InspectionAction.do?event=reject&artid="+arid,
	pager: '#insprejpager',
	rowNum:6, 
	rowList:[2,4,6],
    loadtext: "Bow Bow........... ",
    height : "auto",
    width:"auto",  
   // hiddengrid : true,
    viewrecords: true,
    gridview: true,
    sortname: 'rejectid',  
    sortorder: 'desc',  
    emptyrecords: 'No records to display',
    footerrow : true,
    altRows: true,
    loadComplete:  function (){
    	var $self = $(this);
    	 sumtotinsp = $self.jqGrid("getCol", "rjtotinspected", false, "sum");
    	 sumtotpass = $self.jqGrid("getCol", "totpassed", false, "sum");    	
    	 sumtotrej = $self.jqGrid("getCol", "totrejects", false, "sum");

    		$self.jqGrid("footerData", "set", {arttype:"Total:", rjtotinspected: sumtotinsp});
    		$self.jqGrid("footerData", "set", {totpassed: sumtotpass});
    		$self.jqGrid("footerData", "set", {totrejects: sumtotrej});

    }
	}).jqGrid('navGrid', '#insprejpager',  { 
		edit: true, add: true, del: true, search: false, refresh: true	, view: true,
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View'
		},
		{ //Edit 
		  reloadAfterSubmit: true,
		  closeAfterEdit: true,
		  editData:{
				articleid: function (){
					var ival =arid ;
					return ival;
				}
			},
		},
		{
			//Add 
			 beforeShowForm: function(form){
				 $("#rejcolor").val(clr);
				 $("#totpassed").val($("#totinspected").val());		
			 },
			 editData:{
					articleid: function (){
						var ival =arid ;
						return ival;
					}
				},
		  reloadAfterSubmit: true,
		  closeAfterAdd: true,
	 }).jqGrid('setGroupHeaders', {
	  useColSpanStyle: false, 
	  groupHeaders:[
		{ startColumnName: 'subsrejects', numberOfColumns: 7, titleText: '<em>Rejects</em>'},
	  ]
});rejgrid.jqGrid('setGridWidth', 930);
	

	

	  
	
});