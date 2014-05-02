/*
 * 
 */

$(function() {
	$.get("/Myelclass/DebAutoComplete.do?action="+"payno", 
		 	function(data){
			 	if($("#payactionform").val().toLowerCase() == "edit" ){
			 		
			 	}else{
			 		$("#paymentno").val(data); 
			 		$.trim($("#paymentno").val());
			 	}
			 	
		 	},"text"); 
	//DATEPICKER
    $(".paydt").datepicker({
	   // changeYear: true,
	    autoSize: true,
	    changeMonth:false,
	    dateFormat: "dd-mm-yy",
	    showWeek: true,
	    firstDay: 1,
	    numberOfMonths: 1,
	    showButtonPanel: true,
	    gotoCurrent:true, 
	});
	
  //Autocomplete 
	$('#deb_exporter').autocomplete({
		 source: function(request, response) {
			var param = request.term;  
			$.getJSON("/Myelclass/DebAutoComplete.do?term="+param+"&action="+"debExp",
				function(result) { 	
			       response($.map(result, function(item) {
			           return { 
			              label: item.tanneryName,
			              addr: item.tanneryAddress,
			              ctno: item.tanneryContactNo,
			              };
			        }));//END response
			 });
		 },
		 select: function(event, ui){
			 $('#deb_tanaddr').val(ui.item.addr);
			 $('#deb_tantelephone').val(ui.item.ctno);
			 var payexpo = ui.item.label;
			 paymentgrid.jqGrid('setGridParam',{url:"/Myelclass/PaymentGridAction.do?exporter="+payexpo+"&action="+"loadGrid",}).trigger("reloadGrid");
		 }
	}); 
    
	 var paymentgrid = $("#tbl_paymentDetails");
	 
	 paymentgrid.jqGrid({
		 url:"",
		 datatype: "json",
		 colNames:['Deb No','Deb date','Inv No','QShipd','Rate','Inv Amount','Ex Rate','Commission','Commisison Amt','Tax','Toal Amount','TDS','Total Due'],
		 colModel:[
             	{name: 'deb_debitno', index: 'deb_debitno' ,width:90, hidden: false, },
				{name: 'deb_debitdate', index: 'deb_debitdate' ,width:70, hidden: false,},
				{name: 'deb_taninvno', index: 'deb_taninvno' ,width:50, hidden: false, },
				{name: 'deb_qshipped', index: 'deb_qshipped' ,width:70, hidden: false, },
				{name: 'deb_rate', index: 'deb_rate' ,width:70, hidden: false,},
				{name: 'deb_invoiceamt', index: 'deb_invoiceamt' ,width:70, hidden: false,},
				{name: 'deb_exchangerate', index: 'deb_exchangerate' ,width:70,  hidden: false,},
				{name: 'deb_commission', index: 'deb_commission' ,width:70,  hidden: false,},
				{name: 'deb_elclassamtinrs', index: 'deb_elclassamtinrs' ,width:70,  hidden: false,},
				{name: 'deb_tax', index: 'deb_tax' ,width:70, hidden: false,},
				{name: 'deb_total', index: 'deb_total' ,width:70,  hidden: false,},
				{name: 'deb_tds', index: 'deb_tds' ,width:70,  hidden: false,},
				{name: 'deb_due', index: 'deb_due' ,width:50, hidden: false,}
			],
		 jsonReader : {  
			 repeatitems:false,
			 root: "rows",
			 page: "page", //calls first
			 total: "total" ,//calls Second
			 records: "records" //calls Third
		 }, 
		 pager: '#paymentpager',
		 rowNum:3, 
		 rowList:[3,5,7],	       
		 sortorder: 'desc',  
		 height : 'automatic',
		 emptyrecords: 'No records to display',
		 caption: 'Payment Details',
		 multiselect : true,
		 loadComplete: function (data){ //load complete fires immeddiately aftr server response
			
		 },
		 onSelectRow:  function(rowid, status, e) {
			 
		 }
	 });
	 paymentgrid.jqGrid('navGrid','#paymentpager',{
			add : false,
			edit: false, 
			del : false,
			view: false,
			search : false,
			reload: true		
		}).jqGrid('navButtonAdd', '#paymentpager', {
	 	   caption:"Click Here",    
		 	   buttonicon: "ui-icon-print",
		       title: "Click here to load",	 		 	   
		       onClickButton: function(){
		    	  clickheremethod();
		 	   },
		 	
	});
	 function clickheremethod(){
		 var qshipped = 0.00;
		 var invamt = 0.00;
		 var amtinrs = 0.00;
		 var tax = 0.00;
		 var total = 0.00;
		 var tds = 0.00;
		 var due = 0.00;
	 		 var ids = paymentgrid.jqGrid('getGridParam','selarrrow');
	 		 for (var i=0; i<ids.length;i++){
	 		     var rowData = paymentgrid.jqGrid('getRowData',ids[i]);
	 			 var deb_qshipped = parseFloat(rowData.deb_qshipped).toFixed(2);
	 			 var deb_invamt = parseFloat(rowData.deb_invoiceamt).toFixed(2);
	 			 var deb_amtinrs = parseFloat(rowData.deb_elclassamtinrs).toFixed(2);
	 			 var deb_tax = parseFloat(rowData.deb_tax).toFixed(2);
	 			 var deb_total = parseFloat(rowData.deb_total).toFixed(2);
	 			 var deb_tds = parseFloat(rowData.deb_tds).toFixed(2);
	 			 var deb_due = parseFloat(rowData.deb_due).toFixed(0);
	 			 
	 			qshipped =  parseFloat(qshipped) + parseFloat(deb_qshipped);
	 			invamt =  parseFloat(invamt) + parseFloat(deb_invamt);
	 			amtinrs =  parseFloat(amtinrs) + parseFloat(deb_amtinrs);
	 			tax =  parseFloat(tax) + parseFloat(deb_tax);
	 			total =  parseFloat(total) + parseFloat(deb_total);
	 			tds =  parseFloat(tds) + parseFloat(deb_tds);
	 			due =  parseFloat(due) + parseFloat(deb_due);
	 		   }
	 		
	 		$("#deb_totalquantity").val(qshipped);
	 		$("#deb_invoiceamt").val(invamt);
	 		$("#deb_elclassamtinrs").val(amtinrs);
	 		$("#deb_tax").val(tax);
	 		$("#deb_total").val(total);
	 		$("#deb_tds").val(tds);
	 		$("#deb_due").val(due);
	 }
	 
	 $("#creditamt").focusout(function() {
		 var amtcrdeited =0.00;
		 var balamt =0.00;
		 var due=0.00;
		 amtcrdeited = $("#creditamt").val();
		 due = $("#deb_due").val();
		 balamt = (parseFloat(due) - parseFloat(amtcrdeited)).toFixed(2);
		 $("#balanceamt").val(balamt);
	 });
	$("#deb_tds").focusout(function() {
		var tot = parseFloat( $("#deb_total").val()).toFixed(2);
		var tds = parseFloat( $("#deb_tds").val()).toFixed(2);
		 $("#deb_due").val( parseFloat(tot) - parseFloat(tds).toFixed(2));
	});
	$("#deb_tax").focusout(function() {
		var amt = parseFloat( $("#deb_elclassamtinrs").val()).toFixed(2);
		var tax = parseFloat( $("#deb_tax").val()).toFixed(2);
		var sum =  (parseFloat(amt) + parseFloat(tax));
		$("#deb_due").val(sum);
	});
	
});