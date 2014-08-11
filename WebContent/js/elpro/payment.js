/*
 * 
 */

$(function() {
	
	 var paymentgrid = $("#tbl_paymentDetails");
	 
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
			              id: item.tanneryId,
			              };
			        }));//END response
			 });
		 },
		 select: function(event, ui){
			 $('#deb_tanaddr').val(ui.item.addr);
			 $('#deb_exporterid').val(ui.item.id);
			 $('#deb_tantelephone').val(ui.item.ctno);
			 var payexpoid = ui.item.id;
			 paymentgrid.jqGrid('setGridParam',{url:"/Myelclass/PaymentGridAction.do?exporter="+payexpoid+"&action="+"loadGrid",}).trigger("reloadGrid");
		 },
		 change: function(event,ui){
	    	 $(this).val((ui.item ? ui.item.value : ""));
	   }
	}); 
	
	 paymentgrid.jqGrid({
		 url:"",
		 datatype: "json",
		 colNames:['Deb No','Deb date','Inv No','QShipd','Rate','Inv Amt','Ex Rate','Comm%','Comm Amt','Tax','Toal Amount','TDS','Total Due'],
		 colModel:[
             	{name: 'deb_debitno', index: 'deb_debitno' ,width:70, hidden: false, },
				{name: 'deb_debitdate', index: 'deb_debitdate' ,width:70, hidden: false,},
				{name: 'deb_taninvno', index: 'deb_taninvno' ,width:80, hidden: false, },
				{name: 'deb_qshipped', index: 'deb_qshipped' ,width:50, hidden: false, },
				{name: 'deb_rate', index: 'deb_rate' ,width:70, hidden: false,},
				{name: 'deb_invoiceamt', index: 'deb_invoiceamt' ,width:60, hidden: false,},
				{name: 'deb_exchangerate', index: 'deb_exchangerate' ,width:40,  hidden: false,},
				{name: 'deb_commission', index: 'deb_commission' ,width:40,  hidden: false,},
				{name: 'deb_elclassamtinrs', index: 'deb_elclassamtinrs' ,width:70, align:'right', hidden: false,},
				{name: 'deb_tax', index: 'deb_tax' ,width:70, align:'right', hidden: false,},
				{name: 'deb_total', index: 'deb_total' ,width:70, align:'right', hidden: false,},
				{name: 'deb_tds', index: 'deb_tds' ,width:70,  align:'right', hidden: false,},
				{name: 'deb_due', index: 'deb_due' ,width:50, align:'right', hidden: false,}
			],
		 jsonReader : {  
			 repeatitems:false,
			 root: "rows",
			 page: "page", //calls first
			 total: "total" ,//calls Second
			 records: "records" //calls Third
		 }, 
		 caption: "Commission List",
		 loadtext: "Commission List is Loading",
		 pager: '#paymentpager',
		 rownumbers:true,
		 rowNum:100, 
		 rowList:[10,20,50,100,200,500,1000],	
		 height : '150',
		 width: "auto",
		 sortname: 'deb_debitdate',
		 sortorder: 'desc', 
		 ignoreCase:true,
		 hidegrid: false,
		 sortable: true,
		 gridview : true,
		 viewrecords: true,
		 footerrow: true,
		 altRows: true,
		 emptyrecords: 'No records to display',
		 caption: 'Commssion List',
		 multiselect : true,
		 loadComplete: function (data){ //load complete fires immeddiately aftr server response
			 var $self = $(this),
			
			 amt = parseFloat($self.jqGrid("getCol", "deb_elclassamtinrs", false, "sum")).toFixed(2);
        	 tax = parseFloat($self.jqGrid("getCol", "deb_tax", false, "sum")).toFixed(2);
        	 due = parseFloat($self.jqGrid("getCol", "deb_due", false, "sum")).toFixed(2);
        	 tot = parseFloat($self.jqGrid("getCol", "deb_total", false, "sum")).toFixed(2);
        	 tds = parseFloat($self.jqGrid("getCol", "deb_tds", false, "sum")).toFixed(2);
        	 commamt = parseFloat($self.jqGrid("getCol", "deb_elclassamt", false, "sum")).toFixed(2);
        	 
        	 $self.jqGrid("footerData", "set", {deb_debitno: "Total",deb_elclassamtinrs: parseFloat(amt)});
        	 $self.jqGrid("footerData", "set", {deb_tax: tax});
        	 $self.jqGrid("footerData", "set", {deb_due: due});
        	 $self.jqGrid("footerData", "set", {deb_total: tot});
        	 $self.jqGrid("footerData", "set", {deb_tds: tds});
        	 $self.jqGrid("footerData", "set", {deb_elclassamt: commamt});
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
	 			 
	 			qshipped =  (parseFloat(qshipped) + parseFloat(deb_qshipped)).toFixed(2);
	 			invamt =  (parseFloat(invamt) + parseFloat(deb_invamt)).toFixed(2);
	 			amtinrs =  (parseFloat(amtinrs) + parseFloat(deb_amtinrs)).toFixed(2);
	 			tax =  (parseFloat(tax) + parseFloat(deb_tax)).toFixed(2);
	 			total =  (parseFloat(total) + parseFloat(deb_total)).toFixed(2);
	 			tds =  (parseFloat(tds) + parseFloat(deb_tds)).toFixed(2);
	 			due =  (parseFloat(due) + parseFloat(deb_due)).toFixed(2);
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