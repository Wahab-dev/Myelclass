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
		            groupOrder : ['desc'],
		            groupColumnShow: [false],
		            groupCollapse: [true],
		        });
			}	
		}else{
			alert("Please Select field to Group");
		}
	});
	
	
	sampledebgrid.jqGrid({
		url:"/Myelclass/sid.do?action=load",
		datatype: "json",
		colNames:['invtype','invno','expname','taninvno','invdate','customer','invbillid','ctno','articleid','artname','color','size','subs','selc','unit','pcs','rate','qty','qshpd','qbal','amt','othercharges','discounts','totalamount','AWBillNo','AWBillDate','consignee','notify','exporterref','buyer','bank','bank charge','Realized Amt','Ex rate','Amt in Inr','Deb Date','Remarks'],
	    colModel:[
					{name: 'invtype', index: 'invtype', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invno', index: 'invno', align:'center', width:90, editable:true, sortable: true, hidden: true,  
				
					 },
					
					 {name: 'exporter', index: 'exporter', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'taninvno', index: 'taninvno', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invdt', index: 'invdt', align:'center', width:90, editable:true, sortable: true, hidden: true,  
							
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
					 {name: 'invsubs', index: 'invsubs', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
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
					 {name: 'invqbal', index: 'invqbal', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },
					 
					 {name: 'invamt', index: 'invamt', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invothercrg', index: 'invothercrg', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'invclaim', index: 'invclaim', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						
					 },
					 {name: 'invtotamount', index: 'invtotamount', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
					 },
					 {name: 'awbillno', index: 'awbillno', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						
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
					 {name: 'bankcharge', index: 'bankcharge', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						 editrules: { number:true},
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
					 {name: 'realizedamt', index: 'realizedamt', align:'center', width:90, editable:true, sortable: true, hidden: false,  
						 editrules: {required: true, number:true},
					 },
					 {name: 'exchngrate', index: 'exchngrate', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						 editrules:{number:true},
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
					 {name: 'amtininr', index: 'amtininr', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						 formatter: 'number',  
						  formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },	
					 },
					 {name: 'debdt', index: 'debdt', align:'center', width:90, editable:true, sortable: true, hidden: true,  
						 editoptions: { dataInit: DateGrpEdit },
						  editrules :{require : true},
					 },
					 {name: 'remarks', index: 'remarks', align:'center', width:90, editable:true, sortable: true, hidden: false,  
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
    	pager: '#sampledebpager',
    	rowNum: 15, 
    	rowList: [15,25,50],
        loadtext: "Bow Bow",
        height : "auto",
        width: "auto",  
        sortname: 'Ctno',  
        sortorder: 'desc',
        loadonce: true,
        sortable: true,
        grouping: true,
        gridview : true,
        viewrecords: true,
        footerrow: true,
        userDataOnFooter : true, //Gets Footer Total Recod from Server Side 
        emptyrecords: 'No records to display',
        editurl: "/Myelclass/sid.do",
        loadComplete: function() {
        	 var $self = $(this),
        	
        	 qshpd = $self.jqGrid("getCol", "invqshpd", false, "sum");
        	 
        	// $self.jqGrid("footerData", "set", {selection: "Total:", invqty: qty});
        	 $self.jqGrid("footerData", "set", {selection: "Total:", invqshpd: qshpd});
        	// $self.jqGrid("footerData", "set", {selection: "Total:", invqbal: qbal});
        }
	 });
	sampledebgrid.jqGrid('navGrid','#sampledebpager',{
	 	edit: false,
	 	add: false,
	 	del: false, 
	 	search: false, 
	 	view: false, 
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
		 			   var isic = exporter.toUpperCase() == "INTERNATIONAL CORPORATION";
			 		   if(isic){
			 			 $("#tr_bankcharge").show();
			 			 $("#tr_exchngrate").show();
			 			 $("#tr_amtininr").show();
			 			 $("#tr_debdt").show();
		 				}else{
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
	sampledebgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, stringResult: true});  //To Enable AutoSearch please comment Search on Enter to False
	
		 	    
});