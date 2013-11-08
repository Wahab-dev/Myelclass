/*
 *
 */
$(document).ready(function() {

	 //DATEPICKER
    $("#deb_debitdate").datepicker({
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
			// url:"/Myelclass/DebSelInvfromCust.do?invno="+elclassrefno+"&action="+"loadGrid",
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
					           {name: 'deb_elclasscommission', index: 'deb_elclasscommission' ,width:50, },
					           {name: 'deb_othercommission', index: 'deb_othercommission' ,width:90, hidden: true},
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
					   multiselect : true,
					   toppager:true,
					   rowList:[3,5,7],	       
					   sortorder: 'desc',  
					   height : 'automatic',
				       emptyrecords: 'No records to display',
				       caption: 'Debit Load' 
				 });
				 grid.jqGrid('navGrid','#deb_debpager',{ edit: false, add: false, del: false,cloneToTop:true  	 
				});
				
				 
				// Pager @ Top Customization
			 	  var topPagerDiv = $('#' + grid[0].id + '_toppager')[0]; // "#list_toppager"
			  		//  $("#edit_" + grid[0].id + "_top", topPagerDiv).remove();        // "#edit_list_top"
			  //  $("#del_" + grid[0].id + "_top", topPagerDiv).remove();  // "#del_list_top"
			 ///   $("#add_" + grid[0].id + "_top", topPagerDiv).remove();	
			    $("#search_" + grid[0].id + "_top", topPagerDiv).remove();      // "#search_list_top"
			    $("#refresh_" + grid[0].id + "_top", topPagerDiv).remove() ;     // "#refresh_list_top"
			    $("#" + grid[0].id + "_toppager_center", topPagerDiv).remove(); // "#list_toppager_center"
			    $(".ui-paging-info", topPagerDiv).remove();

			    //Bootom Pager Customization
			      var bottomPagerDiv = $("div#deb_debpager")[0];
			      
			    $("#add_" + grid[0].id, bottomPagerDiv).remove();
			    $("#edit_" + grid[0].id, bottomPagerDiv).remove(); 
			    $("#del_" + grid[0].id, bottomPagerDiv).remove(); 
			    //$("#del_" + grid[0].id, bottomPagerDiv).remove(); 
			    
			    grid.jqGrid('navButtonAdd', '#tbl_debselInvDetails'+ '_toppager_left', { // Here bulkgrid[0].id -> shows bulktable 
			        caption: "Load",
			        buttonicon: 'ui-icon-lightbulb',
			    
			    }); 
			    grid.jqGrid('navButtonAdd', '#tbl_debselInvDetails'+ '_toppager_left', { // Here bulkgrid[0].id -> shows bulktable 
			        caption: "Calculate",
			        buttonicon: 'ui-icon-plusthick',
			    
			    }); 
			    grid.jqGrid('navButtonAdd', '#tbl_debselInvDetails'+ '_toppager_left', { // Here bulkgrid[0].id -> shows bulktable 
			        caption: "Waived",
			        buttonicon: 'ui-icon-lightbulb',
			    
			    }); 
			    grid.jqGrid('navButtonAdd', '#tbl_debselInvDetails'+ '_toppager_left', { // Here bulkgrid[0].id -> shows bulktable 
			        caption: "Raise TC",
			        buttonicon: 'ui-icon-extlink',
			    
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
			$.getJSON("/Myelclass/DebAutoComplete.do?term="+param+"&action="+"Taninv",
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
});