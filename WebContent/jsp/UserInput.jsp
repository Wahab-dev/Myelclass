<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Input Screen</title>
<style type="text/css">
.myclass 
{
    text-transform:capitalize;
}
</style>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/pepper-grinder/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript">
var nameRegExpression = /^[a-zA-Z\s]*$/; // Name  validation
var shformRegExpression = /^[a-zA-Z0-9-()]*$/;   /*short form  validation*/
var telephoneRegExpression = /[0]|[+]\d{3}-\d{3}-\d{6}$/ ; /*Telephone validation*/
var addrRegExpression = /^[a-zA-Z0-9-()#,.\s]*$/;
var attnRegExpression = /^[a-zA-Z.-\s]*$/;

 //Name Check 
function namecheck(value, colName) {
	if (value == "" || value == " " || value.toUpperCase() === "NULL")
		return [false,"Name Shouldnot be Empty"];
	else if(!nameRegExpression.test(value) )
		return [false, "Name only alphabets are allowed"];
	else
		return [true, ""];
	} 
function shformcheck(value, colName) {
	if (value == "" || value == " " || value.toUpperCase() === "NULL")
		return [false,"ShForm is  Empty"];
	else if(!shformRegExpression.test(value) )
		return [false, "ShForm : Only alphabets , Number and -,(,)# are allowed in Shortform"];
	else
		return [true, ""];
	} 

function telecheck(value, colName) {
	 if(!value.match(telephoneRegExpression) )
		return [false, "Number Should be of the Form +xxx-xxx-xxxxxx or 0"];
	else 
		return [true, ""];
	} 

function addrcheck(value, colName) {
	 if(!value.match(addrRegExpression) )
		return [false, "Address can contain alphabets , Number -,(),. and space"];
	else 
		return [true, ""];
	} 
function attncheck(value, colName) {
	 if(!value.match(attnRegExpression) )
		return [false, "Attn can contain Alphabets, dots, comma and space"];
	else 
		return [true, ""];
	} 

$(function() {
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
		colNames:['tanid','tanname','tanattn','tanaddr','tanphone','tanfax','shfrom'],  
	    colModel:[
				   {name: 'tanneryId',index :'tanneryId', editable:true, hidden:true,
					     
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
		pager: '#tannerpager',
		rowNum:10, 
		rowList:[10,20,30],
      loadtext: "Bow Bow........... ",
      sortname: 'tanneryName',  
      sortorder: 'desc', 
      hiddengrid : true,
      loadonce: true,
      viewrecords: true,
      gridview: true, // if used cant use subgrid, treegrid and aftertInsertRow 
      emptyrecords: 'No records to display',
      editurl: "/Myelclass/userinput/loadvalues.do?actn=tan",
	}).jqGrid('navGrid','#tannerpager',{add:true, edit:true, del:true, search: true,  beforeRefresh: function(){
        tangrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
    }},			
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
	}
	);
	
	
	//Customer Grid 
	 var custgrid = $("#customerdetails");
	 custgrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=cust',
		datatype:'json',
		colNames:['custid','custname','custattn','custaddr','custphone','custfax','shfrom'],  
	    colModel:[
				   {name: 'customerId',index :'customerId', editable:true, hidden:true,
					   
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
		pager: '#customerpager',
		rowNum:10, 
		rowList:[10,20,30],
      loadtext: "Bow Bow........... ",
      sortname: 'customerName',  
      sortorder: 'desc', 
      hiddengrid : true,
      viewrecords: true,
      gridview: true, // if used cant use subgrid, treegrid and aftertInsertRow 
      emptyrecords: 'No records to display',
      editurl: "/Myelclass/userinput/loadvalues.do?actn=cust",
	}).jqGrid('navGrid','#customerpager',{add:true, edit:true, del:true, search: true,   beforeRefresh: function(){
		custgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
    }},			
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
	 
	//Consignee Grid 
	 var consiggrid = $("#consigdetails");
	 consiggrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=consig',
		datatype:'json',
		colNames:['consigid','consigname','consigattn','consigaddr','consigphone','consigfax','shfrom'],  
	    colModel:[
				   {name: 'consigneeId',index :'consigneeId', editable:true, hidden:true,
					   
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
		pager: '#consigpager',
		rowNum:10, 
		rowList:[10,20,30],
      loadtext: "Bow Bow........... ",
      sortname: 'consigneeName',  
      sortorder: 'desc', 
      hiddengrid : true,
      viewrecords: true,
      gridview: true, // if used cant use subgrid, treegrid and aftertInsertRow 
      emptyrecords: 'No records to display',
      editurl: "/Myelclass/userinput/loadvalues.do?actn=consig",
	}).jqGrid('navGrid','#consigpager',{add:true, edit:true, del:true, search: true, beforeRefresh: function(){
		consiggrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
    }},			
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
	 
	 
	 //Notify details
	 var notifygrid = $("#notifydetails");
	 notifygrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=notify',
		datatype:'json',
		colNames:['consigid','consigname','consigattn','consigaddr','consigphone','consigfax','shfrom'],  
	    colModel:[
				   {name: 'notifyConsigneeId',index :'notifyConsigneeId', editable:true, hidden:true,
					   
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
		pager: '#notifypager',
		rowNum:10, 
		rowList:[10,20,30],
      loadtext: "Bow Bow........... ",
      sortname: 'notifyConsigneeName',  
      sortorder: 'desc', 
      hiddengrid : true,
      viewrecords: true,
      gridview: true, // if used cant use subgrid, treegrid and aftertInsertRow 
      emptyrecords: 'No records to display',
      editurl: "/Myelclass/userinput/loadvalues.do?actn=notify",
	}).jqGrid('navGrid','#notifypager',{add:true, edit:true, del:true, search: true, beforeRefresh: function(){
		notifygrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
    }},			
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
	 

	 //Bank details
	 var bankgrid = $("#bankdetails");
	 bankgrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=bank',
		datatype:'json',
		colNames:['bankId','bankName','bankAddress','bankBranch','bankSwiftCode','bankAcctNo','bankContactNo','bankFax','accountholderName','bankIfsc'],  
	    colModel:[
				   {name: 'bankId',index :'bankId', editable:true, hidden:true,
					   
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
	               {name: 'bankAcctNo',index :'bankAcctNo', editable:true,
	            	   
	               },
	               {name: 'bankContactNo',index :'bankContactNo', editable:true,
	            	   editrules :{custom:true, custom_func : telecheck},  
	               }, 
	               {name: 'bankFax',index :'bankFax', editable:true,
	            	   editrules :{custom:true, custom_func : telecheck},  
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
		pager: '#bankpager',
		rowNum:10, 
		rowList:[10,20,30],
      loadtext: "Bow Bow........... ",
      sortname: 'bankName',  
      sortorder: 'desc', 
      hiddengrid : true,
      viewrecords: true,
      gridview: true, // if used cant use subgrid, treegrid and aftertInsertRow 
      emptyrecords: 'No records to display',
      editurl: "/Myelclass/userinput/loadvalues.do?actn=bank",
	}).jqGrid('navGrid','#bankpager',{add:true, edit:true, del:true, search: true, beforeRefresh: function(){
		bankgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
    }},			
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
	 
	//Article  details
	 var articlegrid = $("#articledetails");
	 articlegrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=article',
		datatype:'json',
		colNames:['articleid','type','name','size','substance','rate','tc','shform'],  
	    colModel:[
				   {name: 'articleid',index :'articleid', editable:true, hidden:true,
					   
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
	               {name: 'size',index :'size', editable:true,
	            	   
	               },
	               {name: 'substance',index :'substance', editable:true,
	            	   
	               },
	               {name: 'rate',index :'rate', editable:true,
	            	   
	               },
	               {name: 'tc',index :'tc', editable:true,
	            	   
	               },
	               {name: 'articleshortform',index :'articleshortform', editable:true, hidden:true,
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
		pager: '#articlepager',
		rowNum:10, 
		rowList:[10,20,30],
      loadtext: "Bow Bow........... ",
      sortname: 'articlename',  
      sortorder: 'desc', 
      hiddengrid : true,
      viewrecords: true,
      gridview: true, // if used cant use subgrid, treegrid and aftertInsertRow 
      emptyrecords: 'No records to display',
      editurl: "/Myelclass/userinput/loadvalues.do?actn=article",
	}).jqGrid('navGrid','#articlepager',{add:true, edit:true, del:true, search: true, beforeRefresh: function(){
		bankgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
    }},			
	{//edit 
		beforeShowForm: function(form) {   		   
            $("#tr_articleshortform").show(); 
        },	
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
             $("#tr_articleshortform").show(); 
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
	 
	 //Commission Details 
	 var commgrid = $("#commissiondetails");
	 commgrid.jqGrid({ 
		url :'/Myelclass/userinput/loadvalues.do?actn=comm',
		datatype:'json',
		colNames:['Commid','Commname','commagent','commplace','commtype','agenttype'],  
	    colModel:[
				   {name: 'commid',index :'commid', editable:true, 
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
		pager: '#commissionpager',
		rowNum:10, 
		rowList:[10,20,30],
      loadtext: "Bow Bow........... ",
      sortname: 'commname',  
      sortorder: 'desc', 
      hiddengrid : true,
      viewrecords: true,
      gridview: true, // if used cant use subgrid, treegrid and aftertInsertRow 
      emptyrecords: 'No records to display',
      editurl: "/Myelclass/userinput/loadvalues.do?actn=comm",
	}).jqGrid('navGrid','#commissionpager',{add:true, edit:true, del:true, search: true, beforeRefresh: function(){
		commgrid.jqGrid('setGridParam',{datatype:'json'}).trigger('reloadGrid');
    }},			
	{//edit 
	 closeAfterEdit: true,
	 reloadAfterSubmit: true,
	 beforeShowForm: function(form) {   		   
       //  $("#tr_commid").hide(); 
     },	
	},
	{//Add Option
		 beforeShowForm: function(form) {   		   
         //    $("#tr_commid").hide(); 
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
});
</script>
</head>
<body>

<div id="tannery Details">
	<table id="tannerdetails"></table>
	<div id="tannerpager"></div>
</div>

<div id="Customer Details">
	<table id="customerdetails"></table>
	<div id="customerpager"></div>
</div>

<div id="Consignee Details">
	<table id="consigdetails"></table>
	<div id="consigpager"></div>
</div>

<div id="Notify Details">
	<table id="notifydetails"></table>
	<div id="notifypager"></div>
</div>

<div id="Bank Details">
	<table id="bankdetails"></table>
	<div id="bankpager"></div>
</div>

<div id="Article Details">
	<table id="articledetails"></table>
	<div id="articlepager"></div>
</div>

<div id="Destination Details">
	<table id="articledetails"></table>
	<div id="articlepager"></div>
</div>
<div id="Commssion Details">
	<table id="commissiondetails"></table>
	<div id="commissionpager"></div>
</div>

</body>
</html>