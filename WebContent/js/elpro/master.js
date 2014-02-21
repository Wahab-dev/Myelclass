/**
 *  Ct Master File 
 */
$(function() { 
initDateFilter = function (elem) {
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
	    dateFormat: "d-mm-yy",
	    showWeek: true,
	    firstDay: 1,
	    numberOfMonths: 1,
	    showButtonPanel: true,
	    gotoCurrent:true, 
    });
},
/*	
	var mydata = [
	                {ctno:"L4112",article:"Larista",color:"black",tan:"Aone",cust:"Maxim",quantity:"1540",total:"210.00"},
		      		{ctno:"L4212",article:"Ebony",color:"grey",tan:"Aone",cust:"Ull",quantity:"23540",total:"320.00"},
		    		{ctno:"L4322",article:"Heel Grip",color:"grey",tan:"Aqsa",cust:"Ull",quantity:"3500",total:"430.00"},
		    		{ctno:"L4522",article:"Japan Nappa",color:"black",tan:"Ci",cust:"MD",quantity:"3850",total:"210.00"},
		    		{ctno:"L4352",article:"Larista",color:"brown",tan:"JLE",cust:"Maxim",quantity:"5000",total:"320.00"},
		    		{ctno:"L4152",article:"Ebony",color:"tan",tan:"JLE",cust:"MD",quantity:"6750",total:"430.00"},
		    	],	*/
	mastergrid = $("#mastergrid") ; 
	mastergrid.jqGrid({ 
		datatype: 'json',
        url:"/Myelclass/MasterInsertAction.do", 
        colNames:[
		           'Ct NO','Agent','Date','PONo','Exporter','Tanner','Customer','ADD','RDD','Desti','Commission','Commission1','Consignee',
		           'Notify','POJW','ArticleID','Article','Color','Size','Subs','Selec','Qty','Shipped','Bal','Rate','TC','USer','Status',
		           'InvDetails','Reps','Comments','Feedbacks','inspid','inspdate','qualitycontroller','contractno','articleid','article','color',
		            'inspcdn','testid','gradeid','rejectsid','totinspected','inspcomments','invtype','invno','invdate','exportersref','expname',
		            'taninvno','customer','consignee','notify','totalamount','otherref','buyer', 'bank','AWBillNo','AWBillDate',
		            'othercharges','discounts','invbillid','articleid','artname','color','size','subs','selc','qty','pcs','rate',
		            'qshpd','qbal','amt','comm','othercomm','debitno','debitdate',
		            'exchgrate','commission', 'amount','elclassamount','amountinrs','tax','totaltax','tds',
		            'totaldue'
		  ],  
		 colModel:[
			{name:'ctno', index:'ctno',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'agent', index:'agent',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'orderdt', index:'orderdt',align:'center', editable:true, sortable: true, hidden:false, search: true, sorttype: 'date', 
				formatter: 'date', formatoptions: { newformat: 'd-m-Y' },
			
				searchoptions: {
	                searchOperators: true,
	                dataInit: initDateFilter,
	               },
	            	
			},
			{name:'pono', index:'pono',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'exporterid', index:'exporterid',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'tanneryid', index:'tanneryid',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'customerid', index:'customerid',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'add_date', index:'add_date',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',
				
			},
			{name:'rdd_date', index:'rdd_date',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text', sorttype: 'date',
			
			},
			{name:'destination', index:'destination',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'commission', index:'commission',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'othercommission', index:'othercommission',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'consigneeid', index:'consigneeid',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'notifyid', index:'notifyid',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'pojw', index:'pojw',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'articleid', index:'articleid',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'articlename', index:'articlename',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'color', index:'color',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'size', index:'size',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'substance', index:'substance',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'selection', index:'selection',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'quantity', index:'quantity',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'qshipped', index:'qshipped',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'qbal', index:'qbal',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'rate', index:'rate',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'tc', index:'tc',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'user', index:'user',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'status', index:'status',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'invdetails', index:'invdetails',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			{name:'reps', index:'reps',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'comments', index:'comments',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'feddback', index:'feddback',align:'center', editable:false, sortable: true, hidden:false, search: true, stype:'text',},
			
			//Inspection Details
			{name:'inspid', index:'inspid',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'inspdate', index:'inspdate',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'qualitycontroller', index:'qualitycontroller',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'contractno', index:'contractno',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'articleid', index:'articleid',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'article', index:'article',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'color', index:'color',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'inspcdn', index:'inspcdn',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'testid', index:'testid',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'gradeid', index:'gradeid',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'rejectsid', index:'rejectsid',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'totinspected', index:'totinspected',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'inspcomments', index:'inspcomments',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			
			//Invoice Deatils 
			{name:'invtype', index:'invtype',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'invno', index:'invno',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'invdate', index:'invdate',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'exportersref', index:'exporters ref',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'expname', index:'expname',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'taninvno', index:'taninvno',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			
			{name:'customer', index:'customer',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'consignee', index:'consignee',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'notify', index:'notify',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'totalamount', index:'totalamount',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'otherref', index:'otherref',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'buyer', index:'buyer',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'bank', index:'bank',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'AWBillNo', index:'AWBillNo',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'AWBillDate', index:'AWBillDate',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'othercharges', index:'othercharges',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'discounts', index:'discounts',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'invbillid', index:'invbillid',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'articleid', index:'articleid',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'artname', index:'artname',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'color', index:'color',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'size', index:'size',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'subs', index:'subs',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'selc', index:'selc',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'qty', index:'qty',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'pcs', index:'pcs',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'rate', index:'rate',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
					           
			{name:'qshpd', index:'qshpd',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'qbal', index:'qbal',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'amt', index:'amt',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'comm', index:'comm',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'othercomm', index:'othercomm',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			
			//Debit
			{name:'debitno', index:'debitno',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'debitdate', index:'debitdate',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			
			{name:'exchgrate', index:'exchgrate',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'commission', index:'commission',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			
			{name:'amount', index:'amount',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'elclassamount', index:'elclassamount',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'amountinrs', index:'amountinrs',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'tax', index:'tax',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'totaltax', index:'totaltax',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'tds', index:'tds',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
			{name:'totaldue', index:'totaldue',align:'center', editable:false, sortable: true, hidden:true, search: true, stype:'text',},
					           
		],
		jsonReader : {  
		  	repeatitems:false,
		     	/*root: "rows",
		      	page: "page", //calls first
		      	total: "total" ,//calls Second
		      	records: "records" //calls Third
*/				},
		caption: "Contract Master Tracking Details ",
		pager: '#masterpager',
		rowNum:20, 
		rowList:[20,50,60],
	    loadtext: "Bow Bow........... ",
	    height : "auto",
        width: "auto",  
	    sortname: 'invno',  
	    sortorder: 'desc', 
	    loadonce: true,
	    viewrecords: true,
	    sortable: true,
        gridview: true , // if used cant use subgrid, treegrid and aftertInsertRow 
	    height: "100%",
	    footerrow: true,
	    userDataOnFooter : true, 
	    emptyrecords: 'No records to display',
	    /*onSelectRow: function(id) {
	    	
	    	 * Works best if jqGrid has local data (you use datatype: 'local' or remote datatype like 
	    	 *	datatype: 'json' in combination with loadonce: true).
	    	 
	    	var localRowData = $(this).jqGrid('getLocalRow',id);
	        alert(localRowData.ctno);
	    }*/
	 });
	mastergrid.jqGrid('navGrid','#masterpager',{
		 	edit: false,
		 	add: false,
		 	del: false, 
		 	search: true, 
 		 	view: true, 
	 },
	 {},{},{},{
		 multipleSearch:true,
	 		stringResult  :true,
	 		multipleGroup:true,
	 });
	mastergrid.jqGrid('filterToolbar', {
		autosearch : true, searchOnEnter:true, stringResult: false
	});
	
	mastergrid.jqGrid('navButtonAdd', '#masterpager', {
        caption: "Pdf",
        buttonicon: "ui-icon-print",
        title: "Print in PDF Format",
        onClickButton: downloadPdf,
    });
	mastergrid.jqGrid('navButtonAdd', '#masterpager', {
        caption: "Excel",
        buttonicon: "ui-icon-print",
        title: "Print in Excel Format",
        onClickButton: downloadExcel,
    });
	function downloadPdf() 
	{
	download('pdf');
	}
	function downloadExcel() 
	{
	download('xls');
	}
	function download(type){
		printurl = "/Myelclass/MasterInsertAction/PrintReports.do?&type="+type;
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