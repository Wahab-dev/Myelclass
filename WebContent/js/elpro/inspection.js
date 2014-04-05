/**				
 * 
 */
$(document).ready(function() {
	 //Global Variables
   var clr = null ;
   var arid = null ;
   var totinspectd = ""; 
// Grid Details 
	var artgrid = $('#insp_Ctdetails'); 
	var testgrid = $('#insptesttbl'); 
	var gradgrid = $('#inspgradtbl'); 
	var rejgrid = $('#insprejtbl');
   
	/* $("#format").buttonset();
	 $("#format input[type=radio]").change(function() {
		 alert(this.value);  
		 if(this.value === 'Sample'){
			 //set action to Insp sample
			// var actn = "";
		 }else{
			 alert(value);
			 //set action to Insp Ct 
			// var actn = "";
		 }
		});*/
	 
	/*
	 * AUTOCOMPLETE	
	 */
	$('#inspContractNo').autocomplete({		
		 source: function(request, response) {
			var param = request.term;  
			$.getJSON("/Myelclass/InspAutocomplete.do?term="+param+"&action="+"inspCt",
				function(result) { 	
			       response($.map(result, function(item) {
			           return { 
			              value: item.label,
			              splcdn: item.prf_inspcdn,
			              };
			        }));//END response
			 });
		 },
		 select: function( event, ui ) { 
         	$('#insp_cdn').val(ui.item.splcdn);
         	var ctno = $('#inspContractNo').val();
         	artgrid.jqGrid('setGridParam',{url:"/Myelclass/InspectionAction.do?event=loadarticle&ctno="+ctno}).trigger("reloadGrid");
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
		colNames:['Article Id','Article Name', 'Color', 'Tannery', 'Customer','Order Date', 'PONo', 'Size','Subs','Selec','Selec P', 'Quantity'],  
	    colModel:[   
				{name:'prf_articleid', index:'prf_articleid',  hidden: false, },
				{name:'prf_articlename', index:'articlename',  },
				{name:'prf_color', index:'color',  },
				{name:'prf_tannid', index:'prf_tannid',   hidden: false,},
				{name:'prf_custid', index:'prf_custid',  hidden: false,},
				{name:'prf_orderdate', index:'prf_orderdate',  hidden: false,},
				{name:'prf_poref', index:'prf_poref',  },
				{name:'prf_size', index:'size',  },
				{name:'prf_substance', index:'subatance',  },
				{name:'prf_selection', index:'selection',  },
				{name:'prf_selectionp', index:'selectionp',  },
				{name:'prf_quantity', index:'prf_quantity',  },
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
	   	rowNum:2, 
	   	rowList:[2,4,6],
	    loadtext: "Bow Bow........... ",
	    height : "auto",
	    width:"auto",
	    multiselect: true,
	    sortname: 'articlename',  
	    sortorder: 'desc',  
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
	    	$("#article").val(artgrid.jqGrid('getCell', rowid, 'prf_articlename'));  
	    	$("#color").val(clr); 
	    	$("#tan").val(artgrid.jqGrid('getCell', rowid, 'prf_tannid')); 
	    	$("#cust").val(artgrid.jqGrid('getCell', rowid, 'prf_custid')); 
	    	//$("#color").val(artgrid.jqGrid('getCell', rowid, 'prf_orderdate')); 
	    	$("#size").val(artgrid.jqGrid('getCell', rowid, 'prf_size')); 
	    	$("#substance").val(artgrid.jqGrid('getCell', rowid, 'prf_substance')); 
	    	$("#sel").val(artgrid.jqGrid('getCell', rowid, 'prf_selection')); 
	    	$("#quantity").val(artgrid.jqGrid('getCell', rowid, 'prf_quantity')); 
	    	
	       	testgrid.jqGrid('setGridParam',{url:"/Myelclass/InspectionAction.do?event=manualtest&artid="+arid}).trigger("reloadGrid");
	       	gradgrid.jqGrid('setGridParam',{url:"/Myelclass/InspectionAction.do?event=grade&artid="+arid}).trigger("reloadGrid");
	       	rejgrid.jqGrid('setGridParam',{url:"/Myelclass/InspectionAction.do?event=reject&artid="+arid}).trigger("reloadGrid");
	       	
	       	
		 }
	}).jqGrid('navGrid', '#insp_CtDetalspager',  { edit: false, add: false, del: false, 
	search: false, refresh: false, view:true });
	artgrid.jqGrid('setGridWidth', 930);
	
	
//tEST GRID LOAD 
	testgrid.jqGrid({  
				url:"",   
				datatype:"json",
				colNames:['Id','Test Id', 'ArticleID','Color','TestType', 'pieces tested', 'Results','Comments'],  
			    colModel:[  
					{name:'id', index:'id', align:'center', width:60, editable:true, sortable: true, hidden: true, 
						editoptions: {size:8},
	
					},	
					{name: 'testid', index:'testid', align:'center', width:60, editable:true, sortable: true, hidden: false, 
						editoptions: {size:8},
						
					},
					{name: 'articleid', index: 'articleid', align:'center', width:60, editable:true, sortable: true, hidden: false, 
						editoptions: {size:8},
						
					},
					{name:'colortest', index:'colortest', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						editoptions: {size:8}, 
						
					},
					{name:'testtype', index:'testtype', align:'center', width:120, editable:true, sortable: true, hidden:false, 
						edittype: 'select', 
						editoptions: {value: {Color:'Color',Substance:'Substance',TearStrength:'Tear Strength',GrainBreak:'Grain Break',CrockingWet:'Crocking Wet',CrockingDry:'Crocking Dry',
							FinishAdhension:'Finish Adhension',FourFolds:'Four Folds',DyeThru:'Dye Thru',Organoleptic:'Organoleptic'}},						
					
					},
					{name:'testedpcs', index:'testedpcs', align:'center', width:130, editable:true, sortable: true, hidden:false, 
						edittype:'text',
						editoptions:{ size: 15, maxlength:2, },
						editrules:{integer: true},
						formatter : 'integer', formatoptions:{thousandsSeparator: ","},	
					},
					{name:'result', index:'result', align:'center', width:120, editable:true, sortable: true, hidden:false, 
						 edittype: 'select', 
						 editoptions: {value: {P:'Pass',F:'Fail',N:'NA'}},						
					},
					{name:'comments', index:'comments', align:'center', width:120, editable:true, sortable: true, hidden:false, 
						edittype: 'textarea',
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
		    	rowNum: 20, 
		    	rowList: [20,40,60],
		        loadtext: "Bow Bow........... ",
		        height : "auto",
		        width: "auto",  
		        sortname: 'testid',  
		        sortorder: 'desc', 
		        grouping:true, 
		        groupingView : { 
		            groupField : ['testid'],
		            groupOrder : ['desc'] 
		         },
		        emptyrecords: 'No records to display',
			}).jqGrid('navGrid', '#insptestpager',  { edit: true, add: true, del: true, 
					search: false, refresh: true, view: true },
					{
						// Edit
						 reloadAfterSubmit: true,
						 closeAfterEdit: true,
					},
					{
					   // Before Add 
			 		  beforeInitData: function(formid) {
					 	/* testgrid.setColProp('Color', {
	 		 				formoptions : {
								label : "",
							},
						}); */
			 		  },
					  beforeShowForm: function(form){
						  $("#colortest").val(clr);
						  $("#articleid").val(arid);
						  /*$('<tr class="FormData"><td class="CaptionTD ui-widget-content" colspan="2">' +
						           '<hr/><div style="padding:3px" class="ui-widget-header ui-corner-all">' +
						           '<b>Test Details :</b></div></td></tr>')
						           .insertBefore('#articleid');	  */
						/*  $("#tr_testid").hide();
						 $("#tr_testtype").hide();
						 $("#tr_Inspdate").hide(); */
						 
					 },
					 reloadAfterSubmit: true,
					 closeAfterAdd: true,
					});testgrid.jqGrid('setGridWidth', 930);
		
//Grade GRID
		gradgrid.jqGrid({  
				url: "",   
				datatype:"json",
				colNames:['Id','Grade ID ', 'Grade ','Color','Skin Count', 'Tot Inspected','Percentage','Comments'],  
			    colModel:[   
					{name:'id', index:'id',align:'center', width:80, editable:true, sortable: true, hidden: true, },
					{name:'gradeid', index:'gradeid', align:'center', width:80, editable:true, sortable: true, hidden: false, },
					{name:'grade', index:'grade', align:'center', width:120, editable:true, sortable: true, hidden: false,
						edittype: 'select', 
						editoptions: {value: {Grade1:'Grade 1',Grade2:'Grade 2', Grade3:'Grade 3', Grade4:'Grade 4', Grade5:'Grade 5', imprvmnt:'Improvement'}},
					},
					{name: 'gradecolor', index: 'gradecolor', align: 'center', width: 80, editable: true, sortable: true, hidden: false, 						
					},
					{name:'skincount', index:'skincount', align:'center', width:120, editable:true, sortable: true, hidden: false, 
						//Focus Out 
						editoptions: { 
							dataEvents:[{
								type: 'focusout',
								fn: function(e){
									var percent = 0.00;
									var prcntval = 0.00;
									var skincount = $("#skincount").val();
									var totinspect = $("#grtotinspected").val();
									percent = (skincount / totinspect) * 100;
									prcntval = percent.toFixed(2);
									$("#percent").val(prcntval);
									
								}
							}]  
						  },
					},	
					{name:'grtotinspected', index:'grtotinspected', align:'center', width:120, editable:true, sortable: true, hidden: true, },
					{name:'percent', index:'percent', align:'center', width:120, editable:true, sortable: true, hidden: false, },
					{name:'comment', index:'comment', align:'center', width:120, editable:true, sortable: true, hidden:false, 
						edittype: 'textarea',
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
		    	rowNum:6, 
		    	rowList:[2,4,6],
		        loadtext: "Bow Bow........... ",
		        height : "auto",
		        width:"auto",  
		        sortname: 'gradeid',  
		        sortorder: 'desc',  
		        emptyrecords: 'No records to display',
		   	 	loadComplete:function(data){
		   	 	
		   	 	},
		}).jqGrid('navGrid', '#inspgradpager',  { edit: true, add: true, del: true, 
			search: false, refresh: true, view: true },
			{			
				// Edit
				reloadAfterSubmit: true,
				closeAfterEdit: true,
				editData:{
					articleid: function (){
						var ival =arid ;
						return ival;
					}
				}
			},
			{
					//Add
				 beforeShowForm: function(form){
					totinspectd = $("#totinspected").val();
					 $("#grtotinspected").val(totinspectd);
					 $("#gradecolor").val(clr);
					 
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
	colNames:[ 'Leather Type', 'id', 'RejectID ', 'Color ', 'Substance','Size','Selec','Color','Org','Other','Tot Rejects','Tot Passed', 'Tot Inspected'],  
    colModel:[ 
		{name:'arttype', index:'arttype', align:'center', width:120, editable:true, sortable: true, hidden: false, 
			edittype: 'select', editoptions: {value: {H:'Hides',S:'Sides',HS:'H/S',A4:'A4 swatches'}},
		},
		{name:'id', index:'id', align:'center', width:120, editable:true, sortable: true,  hidden: true, 
	
		},
		{name:'rejectid', index:'rejectid',align:'center', width:120, editable:true, sortable: true,  hidden: false, 
				
		}, 
		{name:'rejcolor', index:'rejcolor', align:'center', width:80, editable:true, sortable: true, hidden:false, 
			
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
						var totpasses = 0;
						
						var totinsp = parseInt ($("#rjtotinspected").val());
						alert(totinsp);
						var subrej = parseInt ($("#subsrejects").val());
						var sizerej = parseInt ($("#sizerejects").val());
						var selecrej = parseInt ($("#selecrejects").val());
						var colorrej = parseInt ($("#colorrejects").val());
						var orgrej =  parseInt ($("#orgrejects").val());
						var otherrej = parseInt ($("#otherrejects").val());
						
						totrej =  parseInt(subrej + sizerej + selecrej + colorrej + orgrej + otherrej);
						alert(totrej);
						totpasses = parseInt (totinsp - totrej);
						alert(totpasses);
						
						$("#totrejects").val(totrej);
						$("#totpassed").val(totpasses);
						
					}
				}]  
			  },
		},
		{name:'totrejects', index:'totrejects', align:'center', width:50, editable:true, sortable: true, hidden:false, 
			
		},	
		{name:'totpassed', index:'totpassed', align:'center', width:80, editable:true, sortable: true, hidden:false, 
			
		},
		{name:'rjtotinspected', index:'rjtotinspected', align:'center', width:120, editable:true, sortable: true, hidden:false, 
			
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
	}).jqGrid('navGrid', '#insprejpager',  { edit: true, add: true, del: true, 
		   search: false, refresh: true	, view: false },
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
				 $("#rjtotinspected").val(totinspectd);		
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