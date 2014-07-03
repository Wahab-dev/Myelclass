/**
 * 
 */
$(document).ready(function() {
	var nameRegExpression = /^[a-zA-Z_0-9-()\/.\s]*$/; // Name  validation /s white space
	var shformRegExpression = /^[a-zA-Z_0-9-()]*$/;   /*short form  validation*/
	var telephoneRegExpression = /[0]|[+]\d{3}-\d{3}-\d{6}$/ ; /*Telephone validation Not Working pls check*/
	var addrRegExpression = /^[a-zA-Z_0-9-\/:()#,.\s]*$/; 
	var attnRegExpression = /^[a-zA-Z-\/.,\s]*$/;
	var priceRegExpression =/^[0-9]*(?:\.\d{1,2})?$/; // source: http://stackoverflow.com/questions/21203729/regular-expression-in-javascript-allow-only-numbers-optional-2-decimals
	
	
	 //Name Check 
	function namecheck(value, colName) {
		if (value == "" || value == " " || value.toUpperCase() === "NULL")
			return [false,"Name Shouldnot be Empty"];
		else if(!nameRegExpression.test(value) )
			return [false, "NAME: Only Alphabets, Numbers, Underscore _, hyphen -, Parentheses (), dots .  slash / are allowed"];
		else
			return [true, ""];
		} 
	function shformcheck(value, colName) {
		if (value == "" || value == " " || value.toUpperCase() === "NULL")
			return [false,"ShForm Shouldnot be  Empty"];
		else if(!shformRegExpression.test(value) )
			return [false, "Short Form : Only alphabets , Numbers, Underscore _, hyphen -, Parentheses () are allowed"];
		else
			return [true, ""];
		} 
	
	function telecheck(value, colName) {
		 if(!value.match(telephoneRegExpression) )
			return [false, "Contact NO:  Should be 0 or of the form +123-456-789012"];
		else 
			return [true, ""];
		} 
	
	function addrcheck(value, colName) {
		 if(!value.match(addrRegExpression) )
			return [false, "Address : only alphabets, Numbers, Underscore _, hyphen -, Parentheses (), Forward Slash /, Colon : , Hash Tag #, Comma ,  Dot .  are Allowed"];
		else 
			return [true, ""];
		} 
	function attncheck(value, colName) {
		 if(!value.match(attnRegExpression) )
			return [false, "Attn : Only Alphabets, dots, Forward Slash /, comma are allowed"];
		else 
			return [true, ""];
		} 

	function pricecheck(value, colName) {
		if (value == "" || value == " " || value.toUpperCase() === "NULL")
			return [false,"Price Should be 0 or Some Value"];
		else if(!value.match(priceRegExpression) )
			return [false, "Price : Only Numbers and Dots are allowed"];
		else 
			return [true, ""];
		}
	/* 	/*
		 * function to capitalise each word in a textbox / text area
		 * Need to check how it is working 
		 * http://stackoverflow.com/questions/9576486/javascript-code-to-capitalize-text-inputs
		 *
		
		//add a function to jQuery so we can call it on our jQuery collections
		$.fn.capitalize = function () {
	
		    //iterate through each of the elements passed in, `$.each()` is faster than `.each()
		    $.each(this, function () {
	
		        //split the value of this input by the spaces
		        var split = this.value.split(' ');
	
		        //iterate through each of the "words" and capitalize them
		        for (var i = 0, len = split.length; i < len; i++) {
		        	split[i] = split[i].charAt(0).toUpperCase() + split[i].slice(1).toLowerCase();
		        }
	
		        //re-join the string and set the value of the element
		        this.value = split.join(' ');
		    });
		    return this;
		}; */
	
//-------------------------------------------------------------------------------------------------	
	
	//tanner Grid 
	var tangrid = $("#tannerdetails");
	 tangrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=tan',
		datatype:'json',
		colNames:['ID','Name','Attn','Address','Phone','fax','Short Form'],  
	    colModel:[
				   {name: 'tanneryId',index :'tanneryId', editable:true, hidden:true,
					   editoptions: { readonly: 'readonly'},
				   },
	               {name: 'tanneryName',index :'tanneryName', editable:true, 
					   editrules :{custom:true, custom_func : namecheck},   
	               },
	               {name: 'tanneryAttention',index :'tanneryAttention', editable:true,
	            	   editrules :{custom:true, custom_func : attncheck},   
	               },
	               {name: 'tanneryAddress',index :'tanneryAddress', editable:true,
	            	   edittype: 'textarea', editoptions: {rows:"3",cols:"30"},
	            	   editrules :{custom:true, custom_func : addrcheck},  
	               },
	               {name: 'tanneryContactNo',index :'tanneryContactNo', editable:true,
	            	   editrules :{custom:true, custom_func : telecheck},  
	               },
	               {name: 'tanneryFax',index :'tanneryFax', editable:true,
	            	   editrules :{custom:true, custom_func : telecheck}, 
	               },	 
	               {name: 'tanneryShortForm',index :'tanneryShortForm', editable:true,
	            	   editrules :{custom:true, custom_func : shformcheck},
	               },
	              ],
	    jsonReader : {  
		  	repeatitems:false,
	        root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third 
		},
		caption: "Tannery Details",
		loadtext: "Tannery Details is Loading",
		pager: '#tannerpager',
		rowNum:200, 
		rowList:[20,50,100,200,500],
		rownumbers: true,
		height : "360",
		width: "auto",
		sortname: 'tanneryName',
		sortorder: 'asc',
		loadonce: true,
		ignoreCase:true,
		editurl: "/Myelclass/userinput/loadvalues.do?actn=tan",
		sortable: true,
		gridview : true,
		viewrecords: true,
		altRows: true, // altrows and altclass for alternate color on grid rows
		emptyrecords: 'No records to display',
	}).jqGrid('navGrid','#tannerpager',{
			 add:true, edit:true, del: false, search: false,
			 addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload',
			 beforeRefresh: function(){
				 	tangrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
			 }
	},			
	{//edit 
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
            // $("#tr_tanneryId").hide(); // not necessary since u hav given hidden true in col model
         },	
        closeAfterAdd: true,
	 	reloadAfterSubmit: true,
	},
	{	//delete
		delData: {	tanneryId: function() {
            	var sel_id = tangrid.jqGrid('getGridParam', 'selrow');
            	var value = tangrid.jqGrid('getCell', sel_id, 'tanneryId');
            	 return value;
     	 		},		
		}
	});
	tangrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"}); 
	$(".ui-jqgrid-titlebar").hide();
	
	
	//Customer Grid 
	 var custgrid = $("#customerdetails");
	 custgrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=cust',
		datatype:'json',
		colNames:['ID','Name','Attn','Address','Phone','fax','Short Form'],  
	    colModel:[
				   {name: 'customerId',index :'customerId', editable:true, hidden:true,
					   editoptions: { readonly: 'readonly'},
				   },
	               {name: 'customerName',index :'customerName', editable:true, 
					   editrules :{custom:true, custom_func : namecheck},
	               },
	               {name: 'customerAttention',index :'customerAttention', editable:true,
	            	   editrules :{custom:true, custom_func : attncheck},  
	               },
	               {name: 'customerAddress',index :'customerAddress', editable:true,
	            	   edittype: 'textarea', editoptions: {rows:"3",cols:"30"},
	            	   editrules :{custom:true, custom_func : addrcheck}, 
	               },
	               {name: 'customerTelephone',index :'customerTelephone', editable:true,
	            	   editrules :{custom:true, custom_func : telecheck},
	               },
	               {name: 'customerFax',index :'customerFax', editable:true,
	            	   editrules :{custom:true, custom_func : telecheck}, 
	               },	 
	               {name: 'customerShortForm',index :'customerShortForm', editable:true,
	            	   editrules :{custom:true, custom_func : shformcheck}, 
	               },
	              ],
	    jsonReader : {  
		  	repeatitems:false,
	        root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third 
		},
		caption: "Customer Details",
		loadtext: "Customer Details is Loading",
		pager: '#customerpager',
		rowNum: 500, 
		rowList: [20,50,100,200,500,1000],
		rownumbers: true,
		height : "360",
		width: "auto",
		sortname: 'customerName',
		sortorder: 'asc',
		loadonce: true,
		ignoreCase:true,
		editurl: "/Myelclass/userinput/loadvalues.do?actn=cust",
		sortable: true,
		gridview : true,
		viewrecords: true,
		altRows: true,
        emptyrecords: 'No records to display',  
	}).jqGrid('navGrid','#customerpager',{add: true, edit: true, del: false, search: false,   
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload',
		beforeRefresh: function(){
			custgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		}
	},			
	{//edit 
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
            // $("#tr_customerId").hide(); // hide the tr prf_rate
         },	
        closeAfterAdd: true,
	 	reloadAfterSubmit: true,
	},
	{	//delete
		delData: {	customerId: function() {
            	var sel_id = custgrid.jqGrid('getGridParam', 'selrow');
            	var value = custgrid.jqGrid('getCell', sel_id, 'customerId');
            	 return value;
     	 		},		
		}
	});

	 custgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"}); 
	 $(".ui-jqgrid-titlebar").hide();
	
	 
	 //Consignee Grid 
	 var consiggrid = $("#consigdetails");
	 consiggrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=consig',
		datatype:'json',
		colNames:['ID','Name','Attn','Address','Phone','fax','Short Form'],  
	    colModel:[
				   {name: 'consigneeId',index :'consigneeId', editable:true, hidden:true,
					   editoptions: { readonly: 'readonly'},
				   },
	               {name: 'consigneeName',index :'consigneeName', editable:true, 
					   editrules :{custom:true, custom_func : namecheck},  
	               },
	               {name: 'consigneeAttention',index :'consigneeAttention', editable:true,
	            	   editrules :{custom:true, custom_func : attncheck}, 
	               },
	               {name: 'consigneeAddress',index :'consigneeAddress', editable:true,
	            	   edittype: 'textarea', editoptions: {rows:"3",cols:"30"},
	            	   editrules :{custom:true, custom_func : addrcheck},  
	               },
	               {name: 'consigneeContactNo',index :'consigneeContactNo', editable:true,
	            	   editrules :{custom:true, custom_func : telecheck},  
	               },
	               {name: 'consigneefax',index :'consigneefax', editable:true,
	            	   editrules :{custom:true, custom_func : telecheck},
	               },	 
	               {name: 'consigneeShortForm',index :'consigneeShortForm', editable:true,
	            	   editrules :{custom:true, custom_func : shformcheck},
	               },
	              ],
	    jsonReader : {  
		  	repeatitems:false,
	        root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third 
		},
	  caption: "Consignee Details",
	  loadtext: "Consignee Details is Loading",
	  pager: '#consigpager',
	  rowNum: 500,
	  rowList: [20,50,100,200,500,1000],
	  rownumbers: true,
	  height : "360",
	  width: "auto",
	  sortname: 'consigneeName',
	  sortorder: 'asc',
	  loadonce: true,
	  ignoreCase:true,
	  hidegrid: false,
	  editurl: "/Myelclass/userinput/loadvalues.do?actn=consig",
	  sortable: true,
	  gridview : true,
	  viewrecords: true,
	  altRows: true, // altrows and altclass for alternate color on grid rows
	  emptyrecords: 'No records to display',     
	}).jqGrid('navGrid','#consigpager',{add:true, edit:true, del: false, search: false,
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload',
		beforeRefresh: function(){
		 consiggrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		}
	},			
	{//edit 
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
            // $("#tr_customerId").hide(); 
         },	
        closeAfterAdd: true,
	 	reloadAfterSubmit: true,
	},
	{	//delete
		delData: {	consigneeId: function() {
            	var sel_id = consiggrid.jqGrid('getGridParam', 'selrow');
            	var value = consiggrid.jqGrid('getCell', sel_id, 'consigneeId');
            	 return value;
     	 		},		
		}
	});
	consiggrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"}); 
	$(".ui-jqgrid-titlebar").hide();
	 
	 //Notify details
	 var notifygrid = $("#notifydetails");
	 notifygrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=notify',
		datatype:'json',
		colNames:['ID','Name','Attn','Address','Phone','fax','Short Form'],  
	    colModel:[
				   {name: 'notifyConsigneeId',index :'notifyConsigneeId', editable:true, hidden:true,
					   editoptions: { readonly: 'readonly'},
				   },
	               {name: 'notifyConsigneeName',index :'notifyConsigneeName', editable:true, 
					   editrules :{custom:true, custom_func : namecheck},  
	               },
	               {name: 'notifyConsigneeAttention',index :'notifyConsigneeAttention', editable:true,
	            	   editrules :{custom:true, custom_func : attncheck},
	               },
	               {name: 'notifyConsigneeAddress',index :'notifyConsigneeAddress', editable:true,
	            	   edittype: 'textarea', editoptions: {rows:"3",cols:"30"},
	            	   editrules :{custom:true, custom_func : addrcheck},  
	               },
	               {name: 'notifyConsigneeContactNo',index :'notifyConsigneeContactNo', editable:true,
	            	   editrules :{custom:true, custom_func : telecheck}, 
	               },
	               {name: 'notifyConsigneefax',index :'notifyConsigneefax', editable:true,
	            	   editrules :{custom:true, custom_func : telecheck},
	               },	 
	               {name: 'notifyConsigneeShortForm',index :'notifyConsigneeShortForm', editable:true,
	            	   editrules :{custom:true, custom_func : shformcheck},
	               },
	              ],
	    jsonReader : {  
		  	repeatitems:false,
	        root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third 
		},
		caption: "Notify Details",
		loadtext: "Notify Details is Loading",
		pager: '#notifypager',
		rowNum: 500,
		rowList: [20,50,100,200,500,1000],
		rownumbers: true,
		height : "360",
		width: "auto",
		sortname: 'notifyConsigneeName',
		sortorder: 'asc',
		loadonce: true,
		ignoreCase:true,
		hidegrid: false,
	    editurl: "/Myelclass/userinput/loadvalues.do?actn=notify",
		sortable: true,
		gridview : true,
		viewrecords: true,
		altRows: true,
	}).jqGrid('navGrid','#notifypager',{add:true, edit:true, del: false, search: false, 
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload',
		beforeRefresh: function(){
			notifygrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		}
	},			
	{//edit 
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
            // $("#tr_customerId").hide(); 
         },	
        closeAfterAdd: true,
	 	reloadAfterSubmit: true,
	},
	{	//delete
		delData: {	notifyConsigneeId: function() {
            	var sel_id = notifygrid.jqGrid('getGridParam', 'selrow');
            	var value = notifygrid.jqGrid('getCell', sel_id, 'notifyConsigneeId');
            	 return value;
     	 		},		
		}
	});
	 notifygrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"}); 
	 $(".ui-jqgrid-titlebar").hide();

	 //Bank details
	 var bankgrid = $("#bankdetails");
	 bankgrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=bank',
		datatype:'json',
		colNames:['ID','Bank','Address','Branch','Swift Code','Acct No','Contact No','Fax','Acct Name','IFSC'],  
	    colModel:[
				   {name: 'bankId',index :'bankId', editable:true,  hidden:true,
					   editoptions: { readonly: 'readonly'},
				   },
	               {name: 'bankName',index :'bankName', editable:true, 
					   editrules :{custom:true, custom_func : namecheck}, 
	               },
	               {name: 'bankAddress',index :'bankAddress', editable:true,
	            	   edittype: 'textarea', editoptions: {rows:"3",cols:"30"},
	            	   editrules :{custom:true, custom_func : addrcheck},
	               },	 
	               {name: 'bankBranch',index :'bankBranch', editable:true,
	            	   
	               },
	               {name: 'bankSwiftCode',index :'bankSwiftCode', editable:true,hidden:true
	            	   
	               },
	               {name: 'bankAcctNo',index :'bankAcctNo', editable:true,hidden:true, 
	            	   
	               },
	               {name: 'bankContactNo',index :'bankContactNo', editable:true,
	            	   editrules :{custom:true, custom_func : telecheck},  
	               }, 
	               {name: 'bankFax',index :'bankFax', editable:true,
	            	   
	               },
	               {name: 'accountholderName',index :'accountholderName', editable:true,hidden:true,
	            	   
	               },
	               {name: 'bankIfsc',index :'bankIfsc', editable:true,hidden:true,
	            	   
	               },
	              ],
	    jsonReader : {  
		  	repeatitems:false,
	        root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third 
		},
		caption: "Bank Details",
		loadtext: "Bank Details is Loading",
		pager: '#bankpager',
		rowNum: 500,
		rowList: [20,50,100,200,500,1000],
		rownumbers: true,
		height : "360",
		width: "auto",
		sortname: 'bankName',
		sortorder: 'asc',
		loadonce: true,
		ignoreCase:true,
		hidegrid: false,
		editurl: "/Myelclass/userinput/loadvalues.do?actn=bank",
		sortable: true,
		gridview : true,
		viewrecords: true,
		altRows: true,
	}).jqGrid('navGrid','#bankpager',{add:true, edit:true, del: false, search: false, 
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload',
		beforeRefresh: function(){
			bankgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		}
	},			
	{//edit 
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
            // $("#tr_customerId").hide(); 
         },	
        closeAfterAdd: true,
	 	reloadAfterSubmit: true,
	},
	{	//delete
		delData: {	bankId: function() {
            	var sel_id = bankgrid.jqGrid('getGridParam', 'selrow');
            	var value = bankgrid.jqGrid('getCell', sel_id, 'bankId');
            	 return value;
     	 		},		
		}
	});
	 bankgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"}); 
	 $(".ui-jqgrid-titlebar").hide();
	 
	//Article  details
	 var articlegrid = $("#articledetails");
	 articlegrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=article',
		datatype:'json',
		autoencode: true,
		colNames:['ID','Type','Name','Size','Size Remarks','Substance','Sel','Rate','Currency','Amount','Shipment','TC','TC Amount','TC Sign','TC Agent','Short Form'],  
	    colModel:[
				   {name: 'articleid',index :'articleid', editable:true,  hidden:true,
					   editoptions: { readonly: 'readonly'},
				   },
	               {name: 'articletype',index :'articletype', editable:true, edittype:'select',
					   editoptions: { 
			          		 dataUrl:'/Myelclass/PrfAutocomplete.do?action=arttype',
			          		 buildSelect: function(data) {
			          		  	var response = jQuery.parseJSON(data);
			                    	var s = '<select style="width: 520px">';
			                    	if (response && response.length) {
			                        	s += '<option value="0">--- Select Article Type ---</option>';
			                    		for (var i = 0, l=response.length; i<l ; i++) {
			                          	var ri = response[i].value;
			                           	s += '<option value="'+ri+'">'+ri+'</option>';
			                        	}
			                      	}
			                     	return s + "</select>";
			                   	},
			                 } ,
			                 editrules :{required : true}, 
	               },
	               {name: 'articlename',index :'articlename', editable:true,
	            	   editrules :{custom:true, custom_func : namecheck}, 
	               },
	               {name: 'size',index :'size', editable: true, sortable: true, hidden: false, 
	            	   
	               },
	               {name: 'size_remarks',index :'size_remarks', sortable: true, editable:true, hidden: true, 
       					edittype:'select',
       					editoptions:{value:{0: 'Select Size Remarks', F:'F', S:'S', FS:'FS', DB:'Double Butt'}}, 
	               },
	               {name: 'substance',index :'substance', editable:true, sortable:true, hidden:false,
	            	   
	               },
				   {name: 'selection',index :'selection',width:80, editable:true, sortable:true, hidden:false, 
	            	   edittype:'text',			                    	
	      				  //editoptions:{value:{0:'--- Select Selection ---',A:'A',AB:'AB',ABC:'ABC',TR:'TR',Available:'Available'}},
	            	   
	               },
				   {name: 'price',index :'price', editable:true, sortable:true, hidden: false,
	            	  // editrules :{custom:true, custom_func : pricecheck}, 
	               },
	               {name: 'ratesign',index :'ratesign', editable:true, sortable:true, hidden: true,
	            	   edittype:'select',
     				   editoptions:{value:{0:'--- Select Currency --- ',$:'$',Rs:'Rs',Euro:'€',NA:' Not Available'}},
	               },
 				   {name: 'rateamt',index :'rateamt', editable:true, sortable:true, hidden: true,
	            	  // editrules :{custom:true, custom_func : pricecheck},  
	               },
 				   {name: 'shipment',index :'shipment', editable:true, sortable:true, hidden: true,
	            	   edittype:'select',
	       			  // editoptions:{value:{0:'--- Select Shipment --- ',Air:'Air',Sea:'Sea',Courier:'Courier',Truck:'Truck',Train:'Train'}},
	       			 editoptions: { 
		          		 dataUrl:'/Myelclass/PrfAutocomplete.do?action=shipment',
		          		 buildSelect: function(data) {
		          		  	var response = jQuery.parseJSON(data);
		                    	var s = '<select style="width: 520px">';
		                    	if (response && response.length) {
		                        	s += '<option value="0">--- Select Article Type ---</option>';
		                    		for (var i = 0, l=response.length; i<l ; i++) {
		                          	var ri = response[i].value;
		                           	s += '<option value="'+ri+'">'+ri+'</option>';
		                        	}
		                      	}
		                     	return s + "</select>";
		                   	},
		                 } ,
		                 editrules :{required : true},   
	               },
	               {name: 'tc',index :'tc', editable:true, sortable:true, hidden:false,
	            	   
	               },
	               {name: 'tc_amount',index :'tc_amount', editable:true, sortable:true, hidden:true,
	            	   editrules :{custom:true, custom_func : pricecheck},  
	               },
	               {name: 'tc_currency',index :'tc_currency', editable:true, sortable:true, hidden:true,
	            	   edittype:'select',
	 			  	   editoptions:{value:{0:'Select TC currency ',cents:'cents',paise:'paise',shillings:'shillings',NA:'NA'}},
	 			  	
	               },
	              
	               {name: 'tc_agent',index :'tc_agent', editable:true, sortable:true, hidden:true,
	            	   edittype:'select',
	 			       editoptions:{value:{0:'Select TC Customer',IC:'IC',Cust:'Cust',ICMD:'IC/MD',MD:'MD',NA:'NA'}},
	 			      
	               },
	               {name: 'articleshortform',index :'articleshortform', editable:true, hidden:false,
	            	   editrules :{required : true}, 
	               },
	              ],
	    jsonReader : {  
		  	repeatitems:false,
	        root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third 
		},
		caption: "Article Details",
		loadtext: "Article Details is Loading",
		pager: '#articlepager',
		rowNum: 500,
		rowList: [20,50,100,200,500,1000],
		rownumbers: true,
		height : "360",
		width: "auto",
		sortname: 'articlename',
		sortorder: 'asc',
		loadonce: true,
		ignoreCase:true,
		hidegrid: false,
		editurl: "/Myelclass/userinput/loadvalues.do?actn=article",
		sortable: true,
		gridview : true,
		viewrecords: true,
		altRows: true,
	}).jqGrid('navGrid','#articlepager',{add:true, edit:true, del: false, search: false, 
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload',
		beforeRefresh: function(){
			articlegrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		}
	},			
	{//edit 
		beforeShowForm: function(form) {   		   
            $("#tr_articleshortform").show();
            $("#tr_tc_amount").show();
			 $("#tr_tc_agent").show();
			 $("#tr_tc_currency").show();
			 $("#tr_ratesign").show();
			 $("#tr_rateamt").show();
			 $("#tr_shipment").show();
			 $("#tr_size_remarks").show();
          //Size Calculation
			  var sizec = $("#size").val();
			  var temp = sizec.indexOf(' ');
			  $("#size").val(sizec.substring(0, temp));
			  $("#size_remarks").val(sizec.substring(temp+1));
				 
            
           //Rate Calculation
			 var ratec = $("#price").val();
			 var ratemp = ratec.indexOf(' ');
			 var ratemplast = ratec.lastIndexOf(' ');
			 $("#ratesign").val(ratec.substring(0, ratemp));
			 $("#rateamt").val(ratec.substring(ratemp+1, ratemplast));
			 $("#shipment").val(ratec.substring(ratemplast+1));
			 				 
			//TC Calculation
			 var tctec = $("#tc").val(); 
			 var tcindex = tctec.indexOf(" ");
			 var tcindex1 = tctec.lastIndexOf(" ");
			 var tcamt = tctec.substring(0, tcindex);
			 var tcsign = tctec.substring(tcindex+1, tcindex1);
			 var agent = tctec.substring(tcindex1+1);
			 
			 $("#tc_amount").val(tcamt);
			 $("#tc_agent").val(agent);
			 $("#tc_currency").val(tcsign);
			 
			 $("#tr_tc").hide();
			 $("#tr_price").hide();
			 
        },	
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
             $("#tr_articleshortform").show();
             $("#tr_ratesign").show();
             $("#tr_rateamt").show();
             $("#tr_shipment").show();
             $("#tr_tc_currency").show();
             $("#tr_tc_amount").show();
             $("#tr_tc_agent").show();
             $("#tr_size_remarks").show();
             $("#tr_tc").hide();
             $("#tr_price").hide();
         },	
        closeAfterAdd: true,
	 	reloadAfterSubmit: true,
	},
	{	//delete
		delData: {	articleid: function() {
            	var sel_id = articlegrid.jqGrid('getGridParam', 'selrow');
            	var value = articlegrid.jqGrid('getCell', sel_id, 'articleid');
            	 return value;
     	 		},		
		}
	});  
	 articlegrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"}); 
	 $(".ui-jqgrid-titlebar").hide();
	 
	 
	 
	 //Commission Details 
	 var commgrid = $("#commissiondetails");
	 commgrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=comm',
		datatype:'json',
		colNames:['ID','Name','Agent','Place','Type','Agent Type'],  
	    colModel:[
				   {name: 'commid',index :'commid', editable: true, hidden: false,
					   editoptions: { readonly: 'readonly'}, 
				   },
	               {name: 'commname',index :'commname', editable:true, sortable:true, 
					   editrules :{required : true}, 
	               },
	               {name: 'commagent',index :'commagent', editable:true,
	            	   editrules :{custom:true, custom_func : namecheck}, 
	               },	 
	               {name: 'commplace',commplace :'commplace', editable:true,
	            	   editrules :{custom:true, custom_func : namecheck},  
	               },
	               {name: 'commtype',index :'commtype', editable:true,
	            	   editrules :{required : true}, 
	               },
	               {name: 'agenttype',index :'agenttype', editable:true,
	            	   editrules :{required : true}, 
	               },
	              ],
	    jsonReader : {  
		  	repeatitems:false,
	        root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third 
		},
		caption: "Commision Details",
		loadtext: "Commision Details is Loading",
		pager: '#commissionpager',
		rowNum: 500,
		rowList: [20,50,100,200,500,1000],
		rownumbers: true,
		height : "360",
		width: "auto",
		sortname: 'commname',
		sortorder: 'asc',
		loadonce: true,
		ignoreCase:true,
		hidegrid: false,
		editurl: "/Myelclass/userinput/loadvalues.do?actn=comm",
		sortable: true,
		gridview : true,
		viewrecords: true,
		altRows: true,
	}).jqGrid('navGrid','#commissionpager',{add:true, edit:true, del: false, search: false, 
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload',
		beforeRefresh: function(){
			commgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		}
	},			
	{//edit 
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,
	 beforeShowForm: function(form) {   		   
       //  $("#tr_commid").hide(); 
     },	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
            $("#tr_commid").hide(); 
         },	
        closeAfterAdd: true,
	 	reloadAfterSubmit: true,
	},
	{	//delete
		delData: {	commid: function() {
            	var sel_id = commgrid.jqGrid('getGridParam', 'selrow');
            	var value = commgrid.jqGrid('getCell', sel_id, 'commid');
            	 return value;
     	 		},		
		}
	});
	 commgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"}); 
	 $(".ui-jqgrid-titlebar").hide();
	 
	 
	//Destination Details 
	 var destigrid = $("#destidetails");
	 destigrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=desti',
		datatype:'json',
		colNames:['ID','Name','Country','Short form','Destination Port','Destination Final Place'],  
	    colModel:[
				   {name: 'destiid',index :'destiid', editable: true, hidden: false, 
					   editoptions: { readonly: 'readonly'},
				   },
	               {name: 'destiname',index :'destiname', editable:true, sortable:true, 
					   editrules :{required : true}, 
	               },
	               {name: 'destictry',index :'destictry', editable:true,
	            	   editrules :{custom:true, custom_func : namecheck}, 
	               },	 
	               {name: 'destishform',commplace :'destishform', editable:true,
	            	   editrules :{custom:true, custom_func : namecheck},  
	               },
	               {name: 'destiport',index :'destiport', editable:true,
	            	  // editrules :{required : true}, 
	               },
	               {name: 'destiplace',index :'destiplace', editable:true,
	            	   //editrules :{required : true}, 
	               },
	              ],
	    jsonReader : {  
		  	repeatitems:false,
	        root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third 
		},
		caption: "Destination Details",
		loadtext: "Destination Details is Loading",
		pager: '#destipager',
		rowNum: 500,
		rowList: [20,50,100,200,500,1000],
		rownumbers: true,
		height : "360",
		width: "auto",
		sortname: 'destiname',
		sortorder: 'asc',
		loadonce: true,
		ignoreCase:true,
		hidegrid: false,
		editurl: "/Myelclass/userinput/loadvalues.do?actn=desti",
		sortable: true,
		gridview : true,
		viewrecords: true,
		altRows: true,
	}).jqGrid('navGrid','#destipager',{add:true, edit:true, del: false, search: false, 
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload',
		beforeRefresh: function(){
			destigrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		}
	},			
	{//edit 
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,	
	 beforeShowForm: function(form) {    		   
	         //   $("#tr_destiid").show(); 
     },	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
            $("#tr_destiid").hide(); 
         },	
        closeAfterAdd: true,
	 	reloadAfterSubmit: true,
	},
	{	//delete
		delData: {	destiid: function() {
            	var sel_id = destigrid.jqGrid('getGridParam', 'selrow');
            	var value = destigrid.jqGrid('getCell', sel_id, 'destiid');
            	 return value;
     	 		},		
		}
	});	
	 destigrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"}); 
	 $(".ui-jqgrid-titlebar").hide();
	 
	// Color  Details 
	 var colorgrid = $("#colordetails");
	 colorgrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=color',
		datatype:'json',
		colNames:['ID','Name','Pantone Sshades','Other Name','Ref ID'],  
	    colModel:[
				   {name: 'colorid' ,index :'colorid', editable: true, hidden: false, 
					   editoptions: { readonly: 'readonly'},
				   },
	               {name: 'color',index :'color', editable:true, sortable:true, 
					   editrules :{required : true}, 
	               },
	               {name: 'pantoneshade',index :'pantoneshade', editable:true,
	            	   //editrules :{custom:true, custom_func : namecheck}, 
	               },	 
	               {name: 'colorothername',commplace :'colorothername', editable:true,
	            	   //editrules :{custom:true, custom_func : namecheck},  
	               },
	               {name: 'colorrefno',index :'colorrefno', editable:true,
	            	  // editrules :{required : true}, 
	               },
	              
	              ],
	    jsonReader : {  
		  	repeatitems:false,
	        root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third 
		},
		caption: "Color  Details",
		loadtext: "Color Details is Loading",
		pager: '#colorpager',
		rowNum: 500,
		rowList: [20,50,100,200,500,1000],
		rownumbers: true,
		height : "360",
		width: "auto",
		sortname: 'color',
		sortorder: 'asc',
		loadonce: true,
		ignoreCase:true,
		hidegrid: false,
		editurl: "/Myelclass/userinput/loadvalues.do?actn=color",
		sortable: true,
		gridview : true,
		viewrecords: true,
		altRows: true,
	}).jqGrid('navGrid','#colorpager',{add:true, edit:true, del: false, search: false, 
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload',
		beforeRefresh: function(){
			colorgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		}
	},			
	{//edit 
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,	
	 beforeShowForm: function(form) {    		   
	         //   $("#tr_destiid").show(); 
     },	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
            $("#tr_colorid").hide(); 
         },	
        closeAfterAdd: true,
	 	reloadAfterSubmit: true,
	},
	{	//delete
		delData: {	colorid: function() {
            	var sel_id = colorgrid.jqGrid('getGridParam', 'selrow');
            	var value = colorgrid.jqGrid('getCell', sel_id, 'colorid');
            	 return value;
     	 		},		
		}
	});	
	 colorgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"}); 
	 $(".ui-jqgrid-titlebar").hide();
	
	 
	 
	// terms  Details 
	 var termsgrid = $("#termsdetails");
	 termsgrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=terms',
		datatype:'json',
		colNames:['ID','Name','Comments'],  
	    colModel:[
				   {name: 'termid' ,index :'termid', editable: true, hidden: false, 
					   editoptions: { readonly: 'readonly'},
				   },
	               {name: 'termname',index :'termname', editable:true, sortable:true, 
					   editrules :{required : true}, 
	               },
	               {name: 'otherdetails',index :'otherdetails', editable:true,
	            	   //editrules :{custom:true, custom_func : namecheck}, 
	               },	
	              ],
	    jsonReader : {  
		  	repeatitems:false,
	        root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third 
		},
		caption: "Terms  Details",
		loadtext: "Terms Details is Loading",
		pager: '#termspager',
		rowNum: 500,
		rowList: [20,50,100,200,500,1000],
		rownumbers: true,
		height : "360",
		width: "auto",
		sortname: 'termname',
		sortorder: 'asc',
		loadonce: true,
		ignoreCase:true,
		hidegrid: false,
		editurl: "/Myelclass/userinput/loadvalues.do?actn=terms",
		sortable: true,
		gridview : true,
		viewrecords: true,
		altRows: true,
	}).jqGrid('navGrid','#termspager',{add:true, edit:true, del: false, search: false, 
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload',
		beforeRefresh: function(){
			termsgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		}
	},			
	{//edit 
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,	
	 beforeShowForm: function(form) {    		   
	         //   $("#tr_destiid").show(); 
     },	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
            $("#tr_termid").hide(); 
         },	
        closeAfterAdd: true,
	 	reloadAfterSubmit: true,
	},
	{	//delete
		delData: {	termid: function() {
            	var sel_id = termsgrid.jqGrid('getGridParam', 'selrow');
            	var value = termsgrid.jqGrid('getCell', sel_id, 'termid');
            	 return value;
     	 		},		
		}
	});	
	 termsgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"}); 
	 $(".ui-jqgrid-titlebar").hide();
	
	
	// Payment  Details 
	 var paymntgrid = $("#paymntdetails");
	 paymntgrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=paymnt',
		datatype:'json',
		colNames:['ID','Name','Comments'],  
	    colModel:[
				   {name: 'paymentid' ,index :'paymentid', editable: true, hidden: false, 
					   editoptions: { readonly: 'readonly'},
				   },
	               {name: 'paymentname',index :'paymentname', editable:true, sortable:true, 
					   editrules :{required : true}, 
	               },
	               {name: 'otherdetails',index :'otherdetails', editable:true,
	            	   //editrules :{custom:true, custom_func : namecheck}, 
	               },	
	              ],
	    jsonReader : {  
		  	repeatitems:false,
	        root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third 
		},
		caption: "Payment  Details",
		loadtext: "Payment Details is Loading",
		pager: '#paymntpager',
		rowNum: 500,
		rowList: [20,50,100,200,500,1000],
		rownumbers: true,
		height : "360",
		width: "auto",
		sortname: 'paymentname',
		sortorder: 'asc',
		loadonce: true,
		ignoreCase:true,
		hidegrid: false,
		editurl: "/Myelclass/userinput/loadvalues.do?actn=paymnt",
		sortable: true,
		gridview : true,
		viewrecords: true,
		altRows: true,
	}).jqGrid('navGrid','#paymntpager',{add:true, edit:true, del: false, search: false, 
		addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload',
		beforeRefresh: function(){
			paymntgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
		}
	},			
	{//edit 
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,	
	 beforeShowForm: function(form) {    		   
	         //   $("#tr_destiid").show(); 
    },	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
           $("#tr_paymentid").hide(); 
        },	
        closeAfterAdd: true,
	 	reloadAfterSubmit: true,
	},
	{	//delete
		delData: {	paymentid: function() {
           	var sel_id = paymntgrid.jqGrid('getGridParam', 'selrow');
           	var value = paymntgrid.jqGrid('getCell', sel_id, 'paymentid');
           	 return value;
    	 		},		
		}
	});	
	 paymntgrid.jqGrid('filterToolbar', {autosearch : true, searchOnEnter:false, defaultSearch : "cn"});
	 $(".ui-jqgrid-titlebar").hide();
	 
});