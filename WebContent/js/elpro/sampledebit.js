$(document).ready(function() {
	
	var sampledebgrid = $("#sampledebtbl");
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
			    numberOfMonths: 2,
			    showButtonPanel: true,
			    gotoCurrent:true, 
	        });
	    },
	
	$('#chngroup').change(function(){
		var vl = $(this).val();
		if(vl){
			if(vl == "clear"){
				sampledebgrid.jqGrid('groupingRemove',true);	
			}else{
				sampledebgrid.jqGrid('groupingGroupBy', vl, {
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
	
	
	sampledebgrid.jqGrid({
		url:"/Myelclass/sid.do?action=load",
		datatype: "json",
		colNames:['Type','Inv No','Exporter','Tan Invno','Inv Date','Customer',
		          'Courier','Discount','Total','AWBillNo',
		          'AWBillDate','Notify','Exporterref','Bank','Bank Charge','Realized Amt','Ex rate',
		          'Amt in Rs','Credit Date','Remarks'
		          ],
	    colModel:[
					{name: 'invtype', index: 'invtype', align:'center', width:40, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invno', index: 'invno', align:'center', width:80, editable:true, sortable: true, hidden: false,  
				
					 },
					
					 {name: 'exporter', index: 'exporter', align:'center', width:50, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'taninvno', index: 'taninvno', align:'center', width:160, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invdt', index: 'invdt', align:'center', width:65, editable:true, sortable: true, hidden: false,  
							
					 },
					 {name: 'customer', index: 'customer', align:'center', width:70, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invothercrg', index: 'invothercrg', align:'right', width:50, editable:true, sortable: true, hidden: false,  
						 summaryType:'sum', summaryTpl:'<b> {0}</b>',
					 },
					 {name: 'invclaim', index: 'invclaim', align:'right', width:50, editable:true, sortable: true, hidden: false,  
						 summaryType:'sum', summaryTpl:'<b> {0}</b>',
					 },
					 {name: 'invtotamount', index: 'invtotamount', align:'right', width:60, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'awbillno', index: 'awbillno', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },   
					 {name: 'awbilldate', index: 'awbilldate', align:'center', width:65, editable:true, sortable: true, hidden: false,  
						
					 },    
					 {name: 'notify', index: 'notify', align:'center', width:60, editable:true, sortable: true, hidden: true,  
						
					 },  
					 {name: 'exporterref', index: 'exporterref', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 }, 
					 {name: 'bank', index: 'bank', align:'center', width:45, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'bankcharge', index: 'bankcharge', align:'right', width:80, editable:true, sortable: true, hidden: false,  
						 editrules: { number:true},
						 summaryType:'sum', summaryTpl:'<b> {0}</b>',
						 formatter: 'number',  formatoptions: { defaultValue: '0.00' },
						 editoptions:{
							 dataEvents:[{
								type: 'focusout',
								fn: function(e){
									var amt = $("#invtotamount").val();
									var bankchrg = $("#bankcharge").val();									
									var realamt = (parseFloat(amt) - parseFloat(bankchrg)).toFixed(2);
									$("#realizedamt").val(realamt);
								}
							}],
						 },
					 },
					 {name: 'realizedamt', index: 'realizedamt', align:'right', width:80, editable:true, sortable: true, hidden: false,  
						 editrules: {required: true, number:true},
						 summaryType:'sum', summaryTpl:'<b> {0}</b>',
						 formatter: 'number',  formatoptions: { defaultValue: '0.00' },
					 },
					 {name: 'exchngrate', index: 'exchngrate', align:'right', width:45, editable:true, sortable: true, hidden: false,  
						 editrules:{number:true},
						 summaryType:'sum', summaryTpl:'<b> {0}</b>',
						 formatter: 'number',  formatoptions: { defaultValue: '0.00' },
						 editoptions:{
							 dataEvents:[{
								type: 'focusout',
								fn: function(e){
									var amt = $("#realizedamt").val();
									var exrt = $("#exchngrate").val();									
									var amtinrs = (parseFloat(amt) * parseFloat(exrt)).toFixed(2);
									$("#amtininr").val(amtinrs);
								}
							}],
						 },
					 },
					 {name: 'amtininr', index: 'amtininr', align:'right', width:70, editable:true, sortable: true, hidden: false,  
						 formatter: 'number',  
						 summaryType:'sum', summaryTpl:'<b> {0}</b>',
						  formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },	
					 },
					 {name: 'debdt', index: 'debdt', align:'center', width:60, editable:true, sortable: true, hidden: false,  
						 sorttype: 'date',
						 editoptions: { dataInit: DateGrpEdit },
						  editrules :{require : true},
					 },
					 {name: 'remarks', index: 'remarks', align:'center', width:100, editable:true, sortable: true, hidden: false,  
						 edittype: 'textarea',
						 editrules: {required: true},
					 },
					 
	              ],
	    jsonReader :{  
			repeatitems:false,
			root: "rows",
			page: "page", 
		  	total: "total" ,
	     	records: "records" 
		},  
		caption: "Sample Credit Report",
		loadtext: "Sample Credit is Loading",
    	pager: '#sampledebpager',
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
		editurl: "/Myelclass/sid.do",
		sortable: true,
		toppager:true,
		gridview : true,
		viewrecords: true,
		footerrow: true,
		altRows: true, 
		emptyrecords: 'No records to display',
        loadComplete: function() {
        	 var $self = $(this),
        	 courier = $self.jqGrid("getCol", "invothercrg", false, "sum");
        	 discount = $self.jqGrid("getCol", "invclaim", false, "sum");
        	 total = $self.jqGrid("getCol", "invtotamount", false, "sum");
        	 bankchrg = $self.jqGrid("getCol", "bankcharge", false, "sum");
        	 realamt = $self.jqGrid("getCol", "realizedamt", false, "sum");
        	 amtininr = $self.jqGrid("getCol", "amtininr", false, "sum");
        	
        	 $self.jqGrid("footerData", "set", { invno: "Total"});
        	 $self.jqGrid("footerData", "set", { invothercrg: courier.toFixed(2)});
        	 $self.jqGrid("footerData", "set", { invclaim: discount.toFixed(2)});
        	 $self.jqGrid("footerData", "set", { invtotamount: total.toFixed(2)});
        	 $self.jqGrid("footerData", "set", { bankcharge: bankchrg.toFixed(2)});
        	 $self.jqGrid("footerData", "set", { realizedamt: realamt.toFixed(2)});
        	 $self.jqGrid("footerData", "set", { amtininr: amtininr.toFixed(2)});
        }
	 });
	sampledebgrid.jqGrid('navGrid','#sampledebpager',{
	 	edit: false, add: false, del: false, search: true, view: true, cloneToTop:true, searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View',
	 	beforeRefresh: function(){
	 		sampledebgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		},
	}).navButtonAdd('#sampledebpager',{
	 	   caption:"UpDate Debit Details", 
		   buttonicon:"ui-icon-lightbulb", 
		   position:"first",
		   onClickButton: function(){ 
		 	   var $self = $(this);
		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
		 	    {
		 		  beforeShowForm:  function(form) { 
		 			   var exporter = $("#exporter").val();
		 			   var isic = exporter.toUpperCase() == "IC";
			 		   if(isic){
			 			 $("#tr_bankcharge").show();
			 			 $("#tr_exchngrate").show();
			 			 $("#tr_amtininr").show();
			 			 $("#tr_debdt").show();
		 				}else{
		 				 $("#tr_bankcharge").hide();
				 		 $("#tr_exchngrate").hide();
				 		 $("#tr_amtininr").hide();
		 				 $("#tr_debdt").show();
		 				}
		 		  },
		 		 recreateForm: true,
	                   editData: {//Function to Add parameters to the status 
	                	   action: 'raisedebit',
                 },
                 closeAfterEdit : true,
    				reloadAfterSubmit : true,
		 	    });
		 	}
	});
	sampledebgrid.jqGrid('navButtonAdd',"#sampledebpager",{caption:"Toggle",title:"Toggle Search Toolbar", buttonicon :'ui-icon-pin-s',
		onClickButton:function(){
			sampledebgrid[0].toggleToolbar();
		} 
	});
	sampledebgrid.jqGrid('navButtonAdd',"#sampledebpager",{caption:"Clear",title:"Clear Search",buttonicon :'ui-icon-refresh',
		onClickButton:function(){
			sampledebgrid[0].clearToolbar();
		} 
	});
	sampledebgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"});  //To Enable AutoSearch please comment Search on Enter to False
	sampledebgrid.jqGrid('navButtonAdd',"#sampledebpager",{caption:"Column Chooser",title:"Column Chooser",buttonicon :'ui-icon-extlink',
		onClickButton:function(){
			sampledebgrid.jqGrid('columnChooser', {
				done: function(perm) {
					if (!perm) { return false; }
					this.jqGrid('remapColumns', perm, true);
				}
			});
		}
	});
	//Bootom Pager Customization
	  var bottomPagerDiv = $("div#sampledebpager")[0];
	  $("#view_" + sampledebgrid[0].id, bottomPagerDiv).remove();
	  $("#search_" + sampledebgrid[0].id, bottomPagerDiv).remove(); 
	  $("#refresh_" + sampledebgrid[0].id, bottomPagerDiv).remove(); 
		
	
		 	    
});