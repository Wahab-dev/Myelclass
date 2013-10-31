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
			 //url:"/Myelclass/DebSelInvfromCust.do?invno="+elclassrefno+"&action="+"loadGrid",
			 datatype: "local",
			 colNames:['Ct No','Article','Color','Size','Substance','Quantity','Rate','TC'],
			 colModel:[
					           {name: 'prf_contractno', index:'prf_contractno',width:50},
					           {name: 'prf_articlename', index:'prf_articlename',width:90},
					           {name: 'prf_color', index:'prf_color',width:70},
					           {name: 'prf_size', index:'prf_size',width:70},
					           {name: 'prf_substance', index:'prf_substance',width:70},
					           {name: 'prf_quantity', index:'prf_quantity',width:70},
					           {name: 'prf_price', index:'prf_price',width:70},
					           {name: 'prf_tc', index:'prf_tc',width:70}
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
			              value: item.label,
			              addr: item.tanneryAddress,
			              ctno: item.tanneryContactNo,
			              };
			        }));//END response
			 });
		 },
		 select: function(event, ui){
			 $('#deb_tanaddr').val(ui.item.addr);
			 $('#deb_tantelephone').val(ui.item.ctno);
			// $('#deb_taninvno').val(ui.item.splcdn);
			 //$('#deb_elclassrefno').val(ui.item.splcdn);	 
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
			              addr: item.tanneryAddress,
			              ctno: item.tanneryContactNo,
			              };
			        }));//END response
			 });
		 },
		 select: function(event, ui){
			 $('#deb_tanaddr').val(ui.item.addr);
			 $('#deb_tantelephone').val(ui.item.ctno);
			// $('#deb_taninvno').val(ui.item.splcdn);
			 //$('#deb_elclassrefno').val(ui.item.splcdn);	 
		 }
	}); 
});