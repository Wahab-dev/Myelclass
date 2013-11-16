 $(document).ready(function() {

$("#tcdeb_tcdebitdate").datepicker({
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
		 var tcgrid = $("#tbl_tcdebselInvDetails");
		 tcgrid.jqGrid({
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
			 pager: '#deb_tcdebpager',
			 rowNum:3, 
			 toppager:true,
			 rowList:[3,5,7],	       
			 sortorder: 'desc',  
			 height : 'automatic',
			 emptyrecords: 'No records to display',
			 caption: 'Debit Load',
		});
tcgrid.jqGrid('navGrid','#deb_tcdebpager',{ edit: false, add: false, del: false });
 });