/*
 *
 */
$(document).ready(function() {
	var finalWord ="";
	$.get("/Myelclass/DebAutoComplete.do?action="+"debno", 
		 	function(data){
			 	if($("#debactionform").val().toLowerCase() == "edit" ){		
			 		alert("In Edit From");
			 		var elclassrefnoforedit = $("#invnoforedit").val();
					grid.jqGrid('setGridParam',{url:"/Myelclass/DebSelInvfromCust.do?invno="+elclassrefnoforedit+"&action="+"loadGrid",}).trigger("reloadGrid");			
			 	}else{
			 		/*var elclassrefno = $("#invnoforedit").val();*/
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
	    beforeShowDay: function(date) {
	        var day = date.getDay();              // Disable only SUndays
	        return [(day != 0), ''];
	    }
	});
    
		 var grid = $("#tbl_debselInvDetails");
		 grid.jqGrid({
			 url:"",
			 datatype: "json",
			 colNames:['Inv No','Inv date','Ct No','Article','Color','Size','Substance','Quantity','QShipd','QBal','Rate','Inv AMount','Deb AMt ','Other Chrg','Claim','Total','TC','Comm','Other'],
			 colModel:[
			     {name: 'invno', index: 'invno' ,align:'center',width:50, hidden: false, },
				 {name: 'invdt', index: 'invdt' ,align:'center',width:70, hidden: false,},
				 {name: 'invctno', index: 'invctno' ,align:'center',width:50, hidden: false, },
				 {name: 'invartname', index: 'invartname' ,align:'center',width:90,  hidden: false,},
				 {name: 'invcolor', index: 'invcolor' ,align:'center',width:70, hidden: false, },
				 {name: 'invsize', index: 'invsize' ,align:'center',width:70, hidden: true,},
				 {name: 'invsubs', index: 'invsubs' ,align:'center',width:70, hidden: true,},
				 {name: 'invqty', index: 'invqty' ,align:'right',width:60,  hidden: false,},
				 {name: 'invqshpd', index: 'invqshpd' ,align:'right',width:60,  hidden: false,},
				 {name: 'invqbal', index: 'invqbal' ,align:'right',width:60, hidden: false,},
				 {name: 'invrate', index: 'invrate' ,align:'center',width:50,  hidden: false,},
				 {name: 'invamt', index: 'invamt' ,align:'right',width:70,  hidden: false,},
				 {name: 'debamt', index: 'debamt' ,align:'right',width:70,  hidden: false,
				  formatter:'number',
                  formatoptions: { decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00' },
                 },
				 {name: 'invothercrg', index: 'invothercrg' ,align:'right',width:70, hidden: false,},
				 {name: 'invclaim', index: 'invclaim' ,align:'right',width:50, hidden: false,},
				 {name: 'invtotamount', index: 'invtotamount' ,align:'right',width:70, hidden: false,},
				 {name: 'invtc', index: 'invtc' ,align:'center',width:70,  hidden: false,},
				 {name: 'invcomm', index: 'invcomm' ,align:'center',width:50,  hidden: false,},
				 {name: 'invothercomm', index: 'invothercomm' ,align:'center',width:90, hidden: false,},
				],
			 jsonReader : {  
				 repeatitems:false,
				 root: "rows",
				 page: "page", //calls first
				 total: "total" ,//calls Second
				 records: "records" //calls Third
			 }, 
			 pager: '#deb_debpager',
			 rowNum:9, 
			 rowList:[5,7,9,11,15,20],	       
			 sortorder: 'desc',  
			 hidegrid: false,
			 gridview :true,
			 viewrecords: true,
			 height : 'automatic',
			 emptyrecords: 'No records to display',
			 caption: 'Debit Load',
			 footerrow: true,
			 loadComplete: function (data){ //load complete fires immeddiately aftr server response
				 var $self = $(this),
				 
				 //Sum Total Shipped, Inv Value, Debit Amt
				 totshpd = $self.jqGrid("getCol", "invqshpd", false, "sum");
				 totamt = $self.jqGrid("getCol", "invamt", false, "sum");
				 totdebamt = $self.jqGrid("getCol", "debamt", false, "sum");
				 //set Total Value 
				 $self.jqGrid("footerData", "set", {invqshpd: totshpd.toFixed(2)});
	        	 $self.jqGrid("footerData", "set", {invamt: totamt.toFixed(2)});
	        	 $self.jqGrid("footerData", "set", {debamt: totdebamt.toFixed(2)});
				 
	        	 //Set Value for Text Box 
	        	 $("#deb_totalquantity").val(totshpd.toFixed(2));
	        	 $("#deb_invoiceamt").val(totamt.toFixed(2));
	        	 $("#deb_elclassamt").val(totdebamt.toFixed(2));
	        	  
	        	 // Diable TC btn
				 $("#tcbutton").attr('disabled' , true);
			 },
			 onSelectRow: function(rowid, status, e) {
				 var ctnos = grid.jqGrid('getCol', 'invctno', false);
				// alert(ctnos[0]); Need to work here --> find a way to display distinct CT NO 
				 var selrowid = grid.jqGrid('getGridParam', 'selrow');
		         var invdetails = grid.jqGrid('getRowData', selrowid);

		         $("#deb_rate").val(invdetails.invrate);
		        
		         $("#deb_commission").val(invdetails.invcomm.substring(0,4));
		       
		         $("#deb_invdate").val(invdetails.invdt);
		         $("#deb_othercommission").val(invdetails.invothercomm);
		         $("#deb_contractno").val(ctnos);
		         var tc = invdetails.invtc;
		         $("#deb_tc").val(tc);
		         var tcmt =  tc.substring(0,1);
		      
				   
				   if (tc.toLowerCase().indexOf("ic") >= 0 && tcmt != 0){
						//enable tc button
						$("#tcbutton").attr('disabled' , false);
						$("#invtc").val(tc);
						//disable save button
						$("#Btndebitsave").attr('disabled' ,true);
					}else{
						$("#Btndebitsave").attr('disabled' , false);
						$("#tcbutton").attr('disabled' , true);
					}
		         
			 }
		}).navGrid('#deb_debpager',{ 
				edit: false, add: false, del: false, refresh: true, view: false, search: true,
				addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View'
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
			              id: item.tanneryId,
			              };
			        }));//END response
			 });
		 },
		 select: function(event, ui){
			 $('#deb_tanaddr').val(ui.item.addr);
			 $('#deb_exporterid').val(ui.item.id);
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
			              invdt: item.other,
			              };
			        }));
			 });
		 },
		 select: function(event, ui){
			 $('#deb_taninvno').val(ui.item.taninvno);
			 $('#deb_elclassrefno').val(ui.item.value);
			 $('#deb_elclassrefdt').val(ui.item.invdt);
			 if($("#debactionform").val().toLowerCase() == "edit" ){

			 }else{
				 
				 var elclassrefno = $("#deb_elclassrefno").val();
				 grid.jqGrid('setGridParam',{url:"/Myelclass/DebSelInvfromCust.do?invno="+elclassrefno+"&action="+"loadGrid",}).trigger("reloadGrid");
			 }
		}
	}); 
	
	
	/*
	 * Open Dialog
	 * 
	 */
	 $("#tcdebit").tabs().dialog({
			autoOpen: false,
	        resizable: true,
	        width: 950,
	        height: 550,
	        autoResize: true, 
	        modal: true,
	        open: function(event, ui){
	        	var debitno = $("#deb_debitno").val()+"-A";
	        	$("#tcdeb_tcdebitno").val(debitno);
	        	$("#tcdeb_tcdebitdate").val($("#deb_debitdate").val());
	        	$("#tcdeb_exporter").val($("#deb_exporter").val());
	        	$("#tcdeb_exporterid").val($("#deb_exporterid").val());
	        	$("#tcdeb_tanaddr").val($("#deb_tanaddr").val());
	        	$("#tcdeb_tantelephone").val($("#deb_tantelephone").val());
	        	$("#tcdeb_invoiceamt").val($("#deb_invoiceamt").val());
	         	$("#tcdeb_ctno").val($("#deb_contractno").val());
	         	$("#tcdeb_commission").val($("#deb_commission").val());
	         	$("#tcdeb_exchangerate").val($("#deb_exchangerate").val());
	        	$("#tcdeb_taninvno").val($("#deb_taninvno").val());
	        	$("#tcdeb_elclassrefno").val($("#deb_elclassrefno").val());
	        	$("#tcdeb_elclassrefdt").val($("#deb_elclassrefdt").val());
	        	$("#tcdeb_tcamt").val($("#deb_tc").val());
	        	$("#tcdeb_rate").val($("#deb_rate").val());
	        	$("#tcdeb_totalquantity").val($("#deb_totalquantity").val());
	        },
	        beforeClose: function( event, ui ) {
	        		
	        		$("#Btndebitsave").attr('disabled' , false);
	        		$("#tcbutton").attr('disabled', true);
	        },
	        /*buttons:{
	        	"Print" : function () {
	        		alert("In Print");
	        		var formdata = $('#tcdebitform').serialize();
	        		alert("Form Data"+formdata);
	        		$.ajax({
	        			url: "/Myelclass/tcdebit/print.do",
	        			type: "POST",
	        			async: true,
	        			dataType: "text",
	        			data: formdata,
	        			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	        			success: function (data) {
	        				alert(data);	
	        			}, 
	        			error: function (data) {
	        				alert("F "+data);
	        				console.log("error");
	        			} 
	        		});	
				},
				"Close" : function () {
					 $(this).dialog("close");
				},
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
	    				success: function (textStatus) {
	    	                alert("success"+textStatus);
	    	                $("#Btndebitsave").removeAttr('disabled');
	    	            }, 
	    	            error: function (data) {
	    	            	alert("F "+data);
	    	                console.log("error");
	    	            } 
	    			});
				},
				
	        },*/
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
	    $("#deb_total").val(total.toFixed(0));
	    var tds = (total * 10)/100;
	    $("#deb_tds").val(tds.toFixed(2));
	    var due = total - tds;
	    $("#deb_due").val(due.toFixed(0));
	    test_skill( $("#deb_total").val());
	    $('#debamtinwords').val(finalWord);
	 });
	 
	 $("#tcdeb_elclassamt").focusout(function() {
		 	var tc = $("#tcdeb_tcamt").val();
			var exchngrate = $("#tcdeb_exchangerate").val();
			var totqty = $("#tcdeb_totalquantity").val();
			var tcpercent = tc.substr(0,tc.indexOf('c'));
			tcpercent.trim();
			
			 var amt = (tcpercent * totqty) / 100;
			 var amtinrs = (amt * exchngrate);
			 $("#tcdeb_elclassamtinrs").val(Math.round(amtinrs));
			 $("#tcdeb_elclassamt").val(amt.toFixed(2));
			 finalWord ="";
			 test_skill( $("#tcdeb_elclassamtinrs").val());
			 $('#tcdebamtinwords').val(finalWord);
	 });
	 
	 
	 /*
	  * Function to Convert the Number To Words Print
	  * Reused from the Old elpro Software 
	  * Nee dto Fine tune for the Jquery Version 
	  */
	 function format_number(pnumber,decimals){
			if (isNaN(pnumber)) 
					return 0;
			if (pnumber=='') 
				return 0;
			
			var snum = new String(pnumber);
			var sec = snum.split('.');
			var whole = parseFloat(sec[0]);
			var result = '';
			
			if(sec.length > 1){
				var dec = new String(sec[1]);
				dec = String(parseFloat(sec[1])/Math.pow(10,(dec.length - decimals)));
				dec = String(whole + Math.round(parseFloat(dec))/Math.pow(10,decimals));
				var dot = dec.indexOf('.');
				if(dot == -1){
					dec += '.'; 
					dot = dec.indexOf('.');
				}
				while(dec.length <= dot + decimals) { dec += '0'; }
				result = dec;
			} else{
				var dot;
				var dec = new String(whole);
				dec += '.';
				dot = dec.indexOf('.');		
				while(dec.length <= dot + decimals) { dec += '0'; }
				result = dec;
			}	
			return result;
		}

		function test_skill(total) 
		{
			    var junkVal=total;
				junkVal=Math.round(junkVal);
				var obStr=new String(junkVal);
				numReversed=obStr.split("");
				actnumber=numReversed.reverse();
				
			    if(Number(junkVal) >=0){
			        //do nothing
			    }
			    else{
			        alert('wrong Number cannot be converted');
			        return false;
			    }
			    if(Number(junkVal)==0){
			    	$('#debamtinwords').val("Zero Only");
			    	$('#tcdebamtinwords').val("Zero Only");
			        return false;
			    }
			    if(actnumber.length>9){
			        alert('The Number is too big to coverte');
			        return false;
			    }
			 
			    var iWords=["Zero", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"];
			    var ePlace=['Ten', ' Eleven', ' Twelve', ' Thirteen', ' Fourteen', ' Fifteen', ' Sixteen', ' Seventeen', ' Eighteen', ' Nineteen'];
			    var tensPlace=['dummy', ' Ten', ' Twenty', ' Thirty', ' Forty', ' Fifty', ' Sixty', ' Seventy', ' Eighty', ' Ninety' ];
			 
			    var iWordsLength=numReversed.length;
			    var inWords=new Array();
			    j=0;
			    for(var i=0; i<iWordsLength; i++){
			        switch(i)
			        {
			        case 0:
			            if(actnumber[i]==0 || actnumber[i+1]==1 ) {
			                inWords[j]='';
			            }
			            else {
			                inWords[j]=iWords[actnumber[i]];
			            }
			            inWords[j]=inWords[j]+' Only';
			            break;
			        case 1:
			            tens_complication();
			            break;
			        case 2:
			            if(actnumber[i]==0) {
			                inWords[j]='';
			            }
			            else if(actnumber[i-1]!=0 && actnumber[i-2]!=0) {
			                inWords[j]=iWords[actnumber[i]]+' Hundred and';
			            }
			            else {
			                inWords[j]=iWords[actnumber[i]]+' Hundred';
			            }
			            break;
			        case 3:
			            if(actnumber[i]==0 || actnumber[i+1]==1) {
			                inWords[j]='';
			            }
			            else {
			                inWords[j]=iWords[actnumber[i]];
			            }
			            if(actnumber[i+1] != 0 || actnumber[i] > 0){
			                inWords[j]=inWords[j]+" Thousand";
			            }
			            break;
			        case 4:
			            tens_complication();
			            break;
			        case 5:
			            if(actnumber[i]==0 || actnumber[i+1]==1 ) {
			                inWords[j]='';
			            }
			            else {
			                inWords[j]=iWords[actnumber[i]];
			            }
			            inWords[j]=inWords[j]+" Lakh";
			            break;
			        case 6:
			            tens_complication();
			            break;
			        case 7:
			            if(actnumber[i]==0 || actnumber[i+1]==1 ){
			                inWords[j]='';
			            }
			            else {
			                inWords[j]=iWords[actnumber[i]];
			            }
			            inWords[j]=inWords[j]+" Crore";
			            break;
			        case 8:
			            tens_complication();
			            break;
			        default:
			            break;
			        }
			        j++;
			    }
			 
			    function tens_complication() 
				{
			        if(actnumber[i]==0) {
			            inWords[j]='';
			        }
			        else if(actnumber[i]==1) {
			            inWords[j]=ePlace[actnumber[i-1]];
			        }
			        else {
			            inWords[j]=tensPlace[actnumber[i]];
			        }
			    }
			    inWords.reverse();
			    for(i=0; i<inWords.length; i++) {
			        finalWord+=inWords[i];
			    }
			    //$('#debamtinwords').val(finalWord);
			    return finalWord;
			}
});