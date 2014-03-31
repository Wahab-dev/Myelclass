/*
 *
 */
$(document).ready(function() {
	$.get("/Myelclass/DebAutoComplete.do?action="+"debno", 
		 	function(data){
			 	if($("#debactionform").val().toLowerCase() == "edit" ){
			 		
			 	}else{
			 		$("#deb_debitno").val(data); 
			 		$.trim($("#deb_debitno").val());
			 	}
			 	
		 	},"text"); 
	
	
	//DATEPICKER
    $(".dtdebit").datepicker({
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
    
		 var grid = $("#tbl_debselInvDetails");
		 grid.jqGrid({
			 url:"",
			 datatype: "json",
			 colNames:['Inv No','Inv date','Ct No','Article','Color','Size','Substance','Quantity','QShipd','QBal','Rate','Inv AMount','Other Charges','Discount','Total','TC','Comm','Other'],
			 colModel:[
                 	{name: 'invno', index: 'invno' ,width:90, hidden: false, },
					{name: 'invdt', index: 'invdt' ,width:70, hidden: true,},
					{name: 'invctno', index: 'invctno' ,width:50, hidden: false, },
					{name: 'invartname', index: 'invartname' ,width:90,  hidden: false,},
					{name: 'invcolor', index: 'invcolor' ,width:70, hidden: false, },
					{name: 'invsize', index: 'invsize' ,width:70, hidden: true,},
					{name: 'invsubs', index: 'invsubs' ,width:70, hidden: true,},
					{name: 'invqty', index: 'invqty' ,width:70,  hidden: false,},
					{name: 'invqshpd', index: 'invqshpd' ,width:70,  hidden: false,},
					{name: 'invqbal', index: 'invqbal' ,width:70, hidden: false,},
					{name: 'invrate', index: 'invrate' ,width:70,  hidden: false,},
					{name: 'invamt', index: 'invamt' ,width:70,  hidden: false,},
					{name: 'invothercrg', index: 'invothercrg' ,width:50, hidden: true,},
					{name: 'invclaim', index: 'invclaim' ,width:90, hidden: true,},
					{name: 'invtotamount', index: 'invtotamount' ,width:70, hidden: false,},
					{name: 'invtc', index: 'invtc' ,width:70,  hidden: false,},
					{name: 'invcomm', index: 'invcomm' ,width:50,  hidden: false,},
					{name: 'invothercomm', index: 'invothercomm' ,width:90, hidden: false,},
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
			 //multiselect : true,
			 loadComplete: function (data){ //load complete fires immeddiately aftr server response
				 $("#tcbtn").addClass('ui-state-disabled'); // Diable TC btn
				 $("#tcbutton").attr('disabled' , true);
			 },
			 onSelectRow:  function(rowid, status, e) {
				 
				 var qshippedsum = grid.jqGrid('getCol', 'invqshpd', false, 'sum');
				 var selrowid = grid.jqGrid('getGridParam', 'selrow');
		         var invdetails = grid.jqGrid('getRowData', selrowid);
		         
		         alert(" Alpha  "+qshippedsum);
		         $("#deb_rate").val(invdetails.invrate);
		         $("#deb_totalquantity").val(qshippedsum);
		         $("#deb_commission1").val(invdetails.invcomm);
		         $("#deb_invoiceamt").val(invdetails.invtotamount);
		         var tc = invdetails.invtc;
		         $("#deb_tc").val(tc);
		         var tcmt =  tc.substring(0,1);
				   alert("tcmt"+tcmt);
				   if(tcmt != 0){
						//enable tc button
						$("#tcbutton").attr('disabled' , false);
						$("#invtc").val(tc);
						//disable save button
						$("#Btndebitsave").attr('disabled' , true);
					}else{
						$("#Btndebitsave").attr('disabled' , false);
						$("#tcbutton").attr('disabled' , true);
					}
		         
			 }
		}).navGrid('#deb_debpager',{ edit: false, add: false, del: false, refresh: true, view: false, search: true,
		}).navButtonAdd( '#deb_debpager',{ 
			        caption: "Waived",
			        title:"Debit to Waived",
			        buttonicon: 'ui-icon-lightbulb',
			        position: "last",
			        id : "wvdbtn",
			        onClickButton: function(){ 
			        	var selrow = grid.jqGrid('getGridParam', 'selrow');
			        	var invid = grid.jqGrid('getCell', selrow, 'invno');
			        	
			        	if(invid){
			        		 // Ajax call to Controller for Debit to be Waived 
							 $.getJSON("/Myelclass/DebSelInvfromCust.do?invid="+invid+"&action="+"waived",
								function (data) { 
								 //hanle the Response ...
					         });//END getJSON
							 grid.jqGrid('setGridParam',{url:"/Myelclass/DebSelInvfromCust.do?invno="+null+"&action="+"loadGrid",}).trigger("reloadGrid");
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
	        height: 500,
	        autoResize: true, 
	        modal: true,
	        open: function(event, ui){
	        	var debitno = $("#deb_debitno").val()+"-A";
	        	$("#tcdeb_tcdebitno").val(debitno);
	        	$("#tcdeb_tcdebitdate").val($("#deb_debitdate").val());
	        	$("#tcdeb_exporter").val($("#deb_exporter").val());
	        	$("#tcdeb_tanaddr").val($("#deb_tanaddr").val());
	        	$("#tcdeb_tantelephone").val($("#deb_tantelephone").val());
	        	$("#tcdeb_tcdebitdate").val($("#deb_debitdate").val());
	        	$("#tcdeb_taninvno").val($("#deb_taninvno").val());
	        	$("#tcdeb_elclassrefno").val($("#deb_elclassrefno").val());
	        	$("#tcdeb_tcamt").val($("#deb_tc").val());
	        	$("#tcdeb_rate").val($("#deb_rate").val());
	        	$("#tcdeb_totalquantity").val($("#deb_totalquantity").val());
	        },
	        buttons:{
	        	"Save": function () {
	        		var formdata = $('#tcdebitform').serialize();
	        		alert("Form Data"+formdata);
	        		//$.post( "/Myelclass/TcDebit.do", $(".tcdebitform" ).serialize() );
	        		$.ajax({
	    				url: "/Myelclass/TcDebit.do",
	    				type: "POST",
	    				async: true,
	    				dataType: "text",
	    				data: formdata,
	    				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	    				success: function (data) {
	    					alert("S"+data);
	    	                console.log("success"+data);
	    	                $(this).dialog("close");
	    	            }, 
	    	            error: function (data) {
	    	            	alert("F "+data);
	    	                console.log("error");
	    	            } 
	    			});
				},
				"Clear" : function () {
					alert("T");
				},
				"Close" : function () {
					 $(this).dialog("close");
				},
	        },
		});
	 
	$("#tcbutton").click(function(){
		//Dialog Box 	 
		$("#tcdebit").dialog('open');
	});
	
	/*
	 * Events for Exchange Rate 
	 */
	 $("#deb_exchangerate").focusout(function() {
		var comm = $("#deb_commission").val();
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