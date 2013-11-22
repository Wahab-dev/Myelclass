/*
 *
 */
$(document).ready(function() {
	 
	//DATEPICKER
    $(".dtdebit").datepicker({
	   // changeYear: true,
	    autoSize: true,
	    changeMonth:false,
	    dateFormat: "dd/mm/y",
	    showWeek: true,
	    firstDay: 1,
	    numberOfMonths: 1,
	    showButtonPanel: true,
	    gotoCurrent:true, 
	});
    
		 var grid = $("#tbl_debselInvDetails");
		 grid.jqGrid({
			 url:"",
			 datatype: "json",
			 colNames:['Inv No','Inv date','Ct No','Article','Color','Size','Substance','Quantity','QShipd','QBal','Rate','Inv AMount','Other Charges','Discount','Total','TC','Commission','Agent Commission'],
			 colModel:[
                 	{name: 'deb_invno', index: 'deb_invno' ,width:90, },
					{name: 'deb_invdate', index: 'deb_invdate' ,width:70, hidden: true},
					{name: 'deb_contractno', index: 'deb_contractno' ,width:50, },
					{name: 'deb_article', index: 'deb_article' ,width:90, },
					{name: 'deb_color', index: 'deb_color' ,width:70, },
					{name: 'deb_size', index: 'deb_size' ,width:70, hidden: true},
					{name: 'deb_substance', index: 'deb_substance' ,width:70, hidden: true},
					{name: 'deb_totalquantity', index: 'deb_totalquantity' ,width:70, },
					{name: 'deb_qshipped', index: 'deb_qshipped' ,width:70, },
					{name: 'deb_qremain', index: 'deb_qremain' ,width:70, hidden: true},
					{name: 'deb_rate', index: 'deb_rate' ,width:70, },
					{name: 'deb_invoiceamt', index: 'deb_invoiceamt' ,width:70, },
					{name: 'deb_othercharge', index: 'deb_othercharge' ,width:50, hidden: true},
					{name: 'deb_discount', index: 'deb_discount' ,width:90, hidden: true},
					{name: 'deb_totalamt', index: 'deb_totalamt' ,width:70, hidden: true},
					{name: 'deb_tc', index: 'deb_tc' ,width:70, },
					{name: 'deb_commission1', index: 'deb_commission1' ,width:50, },
					{name: 'deb_commission2', index: 'deb_commission2' ,width:90, hidden: true},
				],
			 jsonReader : {  
				 repeatitems:false,
				 root: "rows",
				 page: "page", //calls first
				 total: "total" ,//calls Second
				 records: "records" //calls Third
			 }, 
			 pager: '#deb_debpager',
			 rowNum:3, 
			 rowList:[3,5,7],	       
			 sortorder: 'desc',  
			 height : 'automatic',
			 emptyrecords: 'No records to display',
			 caption: 'Debit Load',
			 loadComplete: function (data){ //load complete fires immeddiately aftr server response
				 $("#tcbtn").addClass('ui-state-disabled'); // Diable TC btn
				 $("#tcbutton").attr('disabled' , true);
				 var rowdata = data.rows;
				 $.each(rowdata, function(index, val) {
					    var tc = val.deb_tc;
					   var tcmt =  tc.substring(0,1);
					if(tcmt != 0){
						$("#tcbtn").removeClass('ui-state-disabled');
						//enable tc button
						$("#tcbutton").attr('disabled' , false);
						$("#deb_tc").val(tc);
					}
				 });
			 },
			 onSelectRow:  function(rowid, status, e) {
				 var selrowid = grid.jqGrid('getGridParam', 'selrow');
		         var invdetails = grid.jqGrid('getRowData', selrowid);
		         $("#deb_rate").val(invdetails.deb_rate);
		         $("#deb_totalquantity").val(invdetails.deb_qshipped);
		         $("#deb_commission1").val(invdetails.deb_commission1);
		         $("#deb_invoiceamt").val(invdetails.deb_invoiceamt);
			 }
		}).navGrid('#deb_debpager',{ edit: false, add: false, del: false, refresh: true, view: false, search: true
		}).navButtonAdd( '#deb_debpager', { 
			        caption: "TC",
			        buttonicon: 'ui-icon-extlink', 
			        title:"Raise Tc",
			        position: "last",
			        id : "tcbtn",
			    	onClickButton: function(){ 
				        /*var list = grid.jqGrid('getGridParam', 'selrow');
			    		var rowdata = grid.jqGrid('getRowData',list);
				        var exp = $("#deb_exporter").val();
				        var debno = $("#deb_debitno").val();
				        var debdt = $("#deb_debitdate").val();*/
			    		
						
			         }
		 }).navButtonAdd( '#deb_debpager',{ 
			        caption: "Waived",
			        title:"Debit to Waived",
			        buttonicon: 'ui-icon-lightbulb',
			        position: "last",
			        id : "wvdbtn",
			        onClickButton: function(){ 
			        	var selrow = grid.jqGrid('getGridParam', 'selrow');
			        	var invid = grid.jqGrid('getCell', selrow, 'deb_invno');
			        	
			        	if(invid){
			        		 // Ajax call to Controller for Debit to be Waived 
							 $.getJSON("/Myelclass/DebSelInvfromCust.do?invid="+invid+"&action="+"waived",
								function (data) { 
								 //hanle the Response ...
					         });//END getJSON
			        	}else{
			        		alert("Please Select Debitnote to be Waived ..");
			        	}
			        }
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
		 }
	}); 
	
	
	//Autocomplete 
	$('#deb_elclassrefno').autocomplete({
		 source: function(request, response) {
			var param = request.term;  
			var expname = $("#deb_exporter").val();
			$.getJSON("/Myelclass/DebAutoComplete.do?term="+param+"&action="+"Taninv"+"&expname="+expname,
				function(result) { 	
			       response($.map(result, function(item) {
			           return { 
			              value: item.label,
			              taninvno: item.shform,
			              };
			        }));//END response
			 });
		 },
		 select: function(event, ui){
			 $('#deb_taninvno').val(ui.item.taninvno);
			 $('#deb_elclassrefno').val(ui.item.value); 
			 var elclassrefno = $("#deb_elclassrefno").val();
			 grid.jqGrid('setGridParam',{url:"/Myelclass/DebSelInvfromCust.do?invno="+elclassrefno+"&action="+"loadGrid",}).trigger("reloadGrid");
		 }
	}); 
	
	
	/*
	 * Open Dialog
	 * 
	 */
	 $("#tcdebit").tabs().dialog({
			autoOpen: false,
	        resizable: true,
	        width: 830,
	        height: 640,
	        autoResize: true, 
	        modal: true,
	        open: function(event, ui){
	        	$("#tcdeb_tcdebitno").val($("#deb_debitno").val());
	        	$("#tcdeb_exporter").val($("#deb_exporter").val());
	        	$("#tcdeb_tanaddr").val($("#deb_tanaddr").val());
	        	$("#tcdeb_tantelephone").val($("#deb_tantelephone").val());
	        	$("#tcdeb_tcdebitdate").val($("#deb_debitdate").val());
	        	$("#tcdeb_taninvno").val($("#deb_taninvno").val());
	        	$("#tcdeb_elclassrefno").val($("#deb_elclassrefno").val());
	        	//$("#tcdeb_exchangerate").val($("#").val());
	        	$("#tcdeb_tcamt").val($("#deb_tc").val());
	        	$("#tcdeb_rate").val($("#deb_rate").val());
	        	$("#tcdeb_totalquantity").val($("#deb_totalquantity").val());
	        } 
		});
	 
	$("#tcbutton").click(function(){
		//Dialog Box 	 
		$("#tcdebit").dialog('open');
	});
	
	/*
	 * Events for Exchange Rate 
	 */
	 $("#deb_exchangerate").focusout(function() {
		var comm = $("#deb_commission1").val();
		var invamt = $("#deb_invoiceamt").val();
		var commindex = comm.indexOf('%');
		var commpercent = comm.substring(0,commindex);
		commpercent.trim();
	    var elclassamt = ((commpercent * invamt)/100);
	    $("#deb_elclassamt").val(elclassamt.toFixed(2));
	    var amtinrs = (elclassamt * $("#deb_exchangerate").val()); 
	    $("#deb_elclassamtinrs").val(amtinrs.toFixed(2));
	    var tax = (amtinrs *12.36)/100;                   // Add Dynamic Tax Percentage here          
	    $("#deb_tax").val(tax.toFixed(2));
	    var total = amtinrs + tax; 
	    $("#deb_total").val(total.toFixed(2));
	    var tds = (total * 10)/100;
	    $("#deb_tds").val(tds.toFixed(2));
	    var due = total - tds;
	    $("#deb_due").val(due.toFixed(2));
	 });
	 
	 $("#tcdeb_exchangerate").focusout(function() {
			var tc = $("#tcdeb_tcamt").val();
			var exchngrate = $("#tcdeb_exchangerate").val();
			var totqty = $("#tcdeb_totalquantity").val();
			
			
			var tcindex = tc.indexOf(' ');
			alert(tcindex);
			var tcpercent = tc.substring(0,tcindex);
			tcpercent.trim();
			alert(tcpercent);
			 var amt = (tcpercent * totqty) / 100;
			 alert(amt);
			 var amtinrs = (amt * exchngrate);
			 alert(amtinrs);
			 $("#tcdeb_elclassamtinrs").val(amtinrs);
		   
		 });
	 
});