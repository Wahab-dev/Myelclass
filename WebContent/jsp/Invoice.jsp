<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 
</style>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/ui-darkness/jquery-ui-1.10.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />

<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>		
<script type="text/javascript">
$(function() { 	
		// var gridbtn = $("#thelink");
		var invgrid = $("#invBill");
		var billgrid = $("#tbl_invaddinvBill");
		 var grid = $("#tbl_invListCustomerContract"); 
		// var billbtn = $("#loadBill");
		 $('#inv_customer').autocomplete({
			minLength: 1,
			source: function(request, response,term) {
				var param = request.term;
				$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"customer",
					function(result) { 	
		               response($.map(result, function(item) {
		            	  
		               	return { 
		                	id: item.customerId,
		                	label : item.value,
		                	value: item.value,
		                    addr: item.customerAddress,
		                    fone: item.customerTelephone,	
		                    attn : item.customerAttention,
		                    fax: item.customerFax,
		                    
		                 // url:"/Myelclass/InvSelectCtfromCuswet.do?custid="+custid+"&action="+"load",
		                    };
		                 }));//END Response	
					});//End getJSon
				},
				select: function( event, ui ) { 
					 $('#inv_custaddr').val(ui.item.addr);
		          	  $('#inv_custtele').val(ui.item.fone);
		          	  $('#inv_custattn').val(ui.item.attn);
		          	  $('#inv_custfax').val(ui.item.fax);
		          	 $('#inv_custid').val(ui.item.id);
		          	 var custid = $("#inv_custid").val();
		          	grid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?custid="+custid+"&action="+"load"}).trigger("reloadGrid");
		          	//billgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?ctno="+columndatamodified+"&action="+"loadsubgrid",page:1});
	 				 
				    }
		  	 });
			 grid.jqGrid({ // MAster Grid
				 url: "",
				 datatype: "json",
				 loadonce: false,
				 mtype: 'GET', 
				 colNames:['Ct No','Date','Po NO','CDD','ADD','Desti','Cust Id'],
				 colModel:[
				           {name: 'ctno', index:'ctno',editable: true, 
				        	   /* formoptions:{
				        	   	elmprefix:"(<span class='mystar' style='color:red'>*</span>)&nbsp;",
				        	    elmsuffix:"&nbsp;yyyy-mm-dd",
				        	    label: "<span>Date<span><span style='float:right'>XXX</span>"}, */ 
				        	  width:50},
				           {name: 'orderdt', index:'orderdt',width:90},
				           {name: 'pono', index:'color',width:70},
				           {name: 'cdd_date', index:'size',width:70},
				           {name: 'add_date', index:'substance',width:70},
				           {name: 'destination', index:'quantity',width:70},
				           {name: 'customerid', index:'tc',width:70}
				          ],
				  jsonReader : {  
					       repeatitems:false,
					       root: "rows",
					       page: "page", //calls first
					       total: "total" ,//calls Second
					       records: "records", //calls Third
					       },
				   pager : '#tbl_invpager',
				   autoheight: true,
				   rowNum: 5, 
				   multiselect : true,
				   rowList:[5,10,15],	 
				   //pagerpos: 'right',
				  // toppager: true,
				//   toolbar:[true,"top"],
				   sortname: 'Ctno',
				   sortorder: 'desc',  
				   //hide: false,
			       emptyrecords: 'No records to display',
			       caption  : "Select Contract From List",
			       });
			grid.jqGrid('navGrid','#tbl_invpager',{
				add : false,
				edit: false, editCaption:'Check For the Values',
				del : false,
				view: false,
				search : false,
				reload: true		
			}).navButtonAdd('#tbl_invpager',{
	 		 	   caption:"Select", 
	 		 	   buttonicon:"ui-icon-add", 
	 		 	   onClickButton: function(){
	 		 		 var columndata="";
	 		 		 var ids = grid.jqGrid('getGridParam','selarrrow');
	 		 		 alert(ids.length);
	 		 		 for (var i=0; i<ids.length;i++){
	 		 		     var rowData = grid.jqGrid('getRowData',ids[i]);
	 		 			 var colData = " '"+rowData.ctno+"',";
	 		 			 columndata = columndata+colData;
	 		 		   }
	 		 		 var itemp =columndata.lastIndexOf(",");
					 var columndatamodified = columndata.substring(0, itemp);
	 		 		 alert(columndatamodified);
	 				 billgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?ctno="+columndatamodified+"&action="+"loadsubgrid",page:1});
	 				 billgrid.jqGrid('setCaption',"Raise Invoice").trigger('reloadGrid');
	 		 	   },
	 		 	   position:"last",
			});
	
			//Load Billing Details
				 billgrid.jqGrid({
					 url:"",
					 datatype: "json",
					 colNames:['Ct No','Article','Color','Size','Substance','Selection','Quantity','unit','Rate','Q Shipped','Q Balance','Amount', 'Total','TC','articleid','Article Id'],
					 colModel:[
								{name:'contractno', index:'contractno',sortable:true, editable: true, width:50},
								{name:'articlename', index:'articlename',sortable:true, editable: true, width:70},
								{name:'color', index:'color',sortable:true, editable: true, width:70},
								{name:'size', index:'size',sortable:true, editable: true, width:70},
								{name:'substance', index:'substance',sortable:true, editable: true, width:90},
								{name:'selection', index:'selection',sortable:true, editable: true, width:90},
								{name:'quantity', index:'quantity',sortable:true, editable: true, width:70},
								{name:'unit', index:'unit',sortable:true, editable: true, hidden : true, width:70},
								{name:'rate', index:'rate',sortable:true, editable: true, width:70},
								{name:'qshipped', index:'qshipped',sortable:true, editable: true, width:70, edittype:'text', editoptions:{defaultValue:'0'} },
								{name:'qbal', index:'qbal',sortable:true, editable: true, width:70},
								{name:'amount', index:'amount',sortable:true, editable: true, width:70},
								{name:'total', index:'total',hidden: true, sortable:true, editable: true, width:70},
								{name:'tc', index:'tc',hidden: true,sortable:true, editable: true, width:70},
								{name:'articleid', index:'articleid',hidden: true,sortable:true, editable: true, width:70},
								{name:'prfarticleid', index:'prfarticleid',hidden: true,ssortable:true, editable: true, width:90},
					           ],
					jsonReader : {  
						 repeatitems:false,
					       root: "rows",
					       page: "page", //calls first
					       total: "total" ,//calls Second
					       records: "records", //calls Third
							       }, 
					pager: '#tbl_invbillpager',
					rowNum:10, 
				//	multiselect : true,
					rowList:[10,20,30,40],	       
					sortorder: 'desc',  
					editurl: "/Myelclass/InvSelectCtfromCust.do?action="+"addBill",
					emptyrecords: 'No records to display',
					/* ondblClickRow: function(rowid, form) {
						alert(form);
					    jQuery(this).jqGrid('editGridRow', rowid);
					   
					} */
				 });	
			
				  billgrid.jqGrid('navGrid','#tbl_invbillpager',{
						add : true, edit: true, del : true, view: true, search : true, reload: true},
						{
							
							/**
							 *  Billing Form Edit - 
							 *
							 */
							
							beforeShowForm: function(form) { // Shows the Hidden Date field @ Form LOads
					         alert("in Edit Grid "); 
					         $('#quantity').val($('#quantity').val()+$('#unit').val());
							},
							/* beforeSubmit : function(postdata, formid) { 
								alert("In b$ submit ");
						      //0   var prfarticleid = $('#prfarticleid').val();
						         //alert("In b$ submit "+prfarticleid); 
							}, */
							 
							afterSubmit: function(response, postdata){
								 if(response.responseText != 1){
					                    return [false,"error. user exists"];
					                    
					                }else{
					                	
					                	invgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?invno="+1+"&action="+"loadBill",page:1}).trigger("reloadGrid");
					                	return [true,"Successfully Saved"];
					                }
							},
	 					   closeAfterEdit: true,
						},
						
						{}, 
						{
							 //$("tr#trv_orderdate",form[0]).show();
							 },{},{}	
					);
				 
				//INV Billing Details
				 invgrid.jqGrid({
					 url:"",
					 datatype: "json",
					 colNames:['Inv No','articleid','Ct No','Article','Color','Size','Substance','Selection','Quantity','Rate','TC','Q Shipped','Q Balance','amount'],
					 colModel:[
								{name: 'invno', index:'invno',sortable:true, editable: true, width:50},
								{name: 'invartid', index:'articleid',sortable:true, editable: true, width:70},
								{name: 'invctno', index:'ctno',sortable:true, editable: true, width:50},
								{name: 'invartname', index:'articlename',sortable:true, editable: true, width:70},
								{name: 'invcolor', index:'color',sortable:true, editable: true, width:70},
								{name: 'invsize', index:'size',sortable:true, editable: true, width:70},
								{name: 'invsubs', index:'substance',sortable:true, editable: true, width:90},
								{name: 'invselc', index:'selection',sortable:true, editable: true, width:90},
								{name: 'invqty', index:'quantity',sortable:true, editable: true, width:70},
								{name: 'invrate', index:'rate',sortable:true, editable: true, width:70},
								{name: 'invtc', index:'tc',sortable:true, width:70, editable: true},
								{name: 'invqshpd', index:'qshpd',sortable:true, editable: true, width:70},
								{name: 'invqbal', index:'qbal',hidden: false, sortable:true, editable: true, width:70},
								{name: 'invamt', index:'amt',hidden: false, sortable:true, editable: true, width:70},
								 ],
					jsonReader : {  
						 repeatitems:false,
					       root: "rows",
					       page: "page", //calls first
					       total: "total" ,//calls Second
					       records: "records", //calls Third
							       }, 
					pager: '#invbillpager',
					rowNum:20, 
					multiselect : false,
					rowList:[10,20,30],	  
					sortname: 'invartname',
					sortorder: 'desc',  
					emptyrecords: 'No records to display',
				 });	
			
				 invgrid.jqGrid('navGrid','#invbillpager',{
						add : true,
						edit: true, 
						del : true,
						view: true,
						search : true,
						reload: true},
						{
							beforeShowForm: function(form) { // Shows the Hidden Date field @ Form LOads
						         alert("inEdit  Grid "); 
						         $('#quantity').val($('#quantity').val()+$('#unit').val());
								},
								url: "/Myelclass/InvSelectCtfromCust.do?invno="+1+"&action="+"editBill",
								mtype: "GET",
							    closeAfterEdit: true,
							
						},
						{
							beforeShowForm: function(formId) { // Shows the Hidden Date field @ Form LOads
						         alert("in Add Grid "); 
						         $(formId).attr('align', 'right');
							
							
						        // $('#quantity').val($('#quantity').val()+$('#unit').val());
								},
							
						},
						{
							beforeShowForm: function(form) { // Shows the Hidden Date field @ Form LOads
						         alert("in Delete Grid "); 
						        // $('#quantity').val($('#quantity').val()+$('#unit').val());
								},
							
						},{},
						
						 {
							beforeShowForm: function(form) { //  Shows the Hidden Date field @ Form LOads
						         alert("in View Grid "); 
						        // $('#quantity').val($('#quantity').val()+$('#unit').val());
								},
							
						}
						
					);		 
		//Invoice Type
		$('#inv_invoicetype').change(function(){
			var value = $('#inv_invoicetype').val();
			alert("select box value changed"+value);
		});
		
		
		
		$('#inv_bank').autocomplete({
			minLength: 1,
			source: function(request, response,term) {
				var param = request.term;
				$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"bank",
					function(result) { 	
		               response($.map(result, function(item) {
		               	return { 
		                	label : item.bankName,
		                	value: item.bankName,
		                    addr: item.bankAddress,
		                    branch: item.bankBranch,
		                    swiftcode: item.bankSwiftCode,	
		                    acctno : item.bankAcctNo,
		                    ctno: item.bankContactNo,
		                    fax: item.bankFax,
		                    };
		                 }));//END Response	
					});//End getJSon
				},
				select: function( event, ui ) { 
		          	  $('#inv_bankbranch').val(ui.item.branch);
		          	  $('#inv_bankaddress').val(ui.item.addr);
		          	  $('#inv_banktele').val(ui.item.ctno);
		          	  $('#inv_bankfax').val(ui.item.fax);
		          	  $('#inv_bankswiftcode').val(ui.item.swiftcode);
		          	  $('#inv_bankacno').val(ui.item.acctno);
				    }
		  	});
		
		$('#inv_notify').autocomplete({
			minLength: 1,
			source: function(request, response,term) {
				var param = request.term;
				$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"notify",
					function(result) { 	
		               response($.map(result, function(item) {
		               	return { 
		                	label : item.notifyConsigneeName,
		                	value: item.notifyConsigneeName,
		                    addr: item.notifyConsigneeAddress,
		                    fone: item.notifyConsigneeContactNo,	
		                    attn : item.notifyConsigneeAttention,
		                    fax: item.notifyConsigneefax,
		                    };
		                 }));//END Response	
					});//End getJSon
				},
				select: function( event, ui ) { 
		          	  $('#inv_notifyaddress').val(ui.item.addr);
		          	  $('#inv_notifytele').val(ui.item.fone);
		          	  $('#inv_notifyattn').val(ui.item.attn);
		          	  $('#inv_notifyfax').val(ui.item.fax);
				    }
		  	});
		
		$('#inv_exporter').autocomplete({
			minLength: 1,
			source: function(request, response,term) {
				var param = request.term;
				$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"exporter",
					function(result) { 	
		               response($.map(result, function(item) {
		               	return { 
		                	id: item.customerId,
		                	label : item.expname,
		                	value: item.expname,
		                    addr: item.expaddr,
		                    fone: item.expphone,	
		                    attn : item.expattn,
		                    fax: item.expfax,
		                    };
		                 }));//END Response	
					});//End getJSon
				},
				select: function( event, ui ) { 
		          	  $('#inv_exporteraddress').val(ui.item.addr);
		          	  $('#inv_exportertele').val(ui.item.fone);
		          	  $('#inv_exporterattn').val(ui.item.attn);
		          	  $('#inv_exporterfax').val(ui.item.fax);
				    }
		  	});
		
		$('#inv_ctryoforigngoods').autocomplete({
			 source: function(request, response) {
				var param = request.term;  
				$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"loadctry",
					function(result) { 	
				       response($.map(result, function(item) {
				           return { 
				              value: item.destination,
				              };
				        }));//END response
				 });
			 }
		}); 
		
		$('#inv_loadingport').autocomplete({
			 source: function(request, response) {
				var param = request.term;  
				var ctryval = $('#inv_ctryoforigngoods').val();
				$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"loadport&ctryval="+ctryval,
					function(result) { 	
				       response($.map(result, function(item) {
				           return { 
				              value: item.destination,
				              };
				        }));//END response
				 });
			 }
		});
		
		 $(".dateclass").datepicker({
			    autoSize: true,
			    changeMonth:false,
			    dateFormat: "dd/mm/yy",
			    firstDay: 1,
			    gotoCurrent:true, 
			});
		
			
	});	
</script>
</head>
<body>
<h:form action="/saveinvoice" styleId="saveinvoice">
    <table width="895" border="1" cellspacing="0" cellpadding="0" >
   		<tr>  			
   			<td>Welcome ${user.name}</td> 
   			<td><h:submit property="action" value="Logout"></h:submit></td> 
   		</tr>
    </table>
	  <table border="1" cellpadding="0" cellspacing="0">
		  <tr>
   			  <td width="300">
				  <fieldset>         
       				  <legend>Invoice Details</legend><br/> 
       					  Type: <h:select property="inv_invoicetype" styleId="inv_invoicetype">
       					  		  <h:option value="0">Select Type</h:option>
   		 						  <h:option value="1">IC-Local</h:option>
   		 						  <h:option value="2">IC-Exports</h:option>
   		 						  <h:option value="3">IC-Courier</h:option>
   		 						  <h:option value="4">Other-Tanner Courier</h:option> 
   		 						  <h:option value="5">Other-Tanner Exports</h:option> 
   		 						  <h:option value="6">Other-Tanner Local</h:option>
   		 						  <h:option value="7">IC-PO</h:option>  
   		 						  <h:option value="8">IC-JW</h:option>  
       							 </h:select><br />        
   	 					 <br /> Invoice No: <h:text property="inv_invoiceno" styleId="inv_invoiceno"></h:text><br />
       					 <br /> Invoice Date:<h:text property="inv_invdate" styleId="inv_invdate" styleClass="dateclass"></h:text><br />
       					 <br /> Exporters Ref. : <h:text property="inv_expref" styleId="inv_expref"> </h:text><br />
						 <br /> Other ref :  <h:text property="inv_otherref" styleId="inv_otherref"> </h:text>  <br />  
   				  </fieldset>
			  </td>
   			  <td width="300">
   				  <fieldset>         
       				  <legend>Exporter Details</legend><br/> 
       					  Exporter: <h:text property="inv_exporter" styleId="inv_exporter" styleClass="invautocompleteclass"></h:text><br />        
   	 					 <br /> Attn: <h:text property="inv_exporterattn" styleId="inv_exporterattn"></h:text><br />
       					 <br /> Address: <h:textarea property="inv_exporteraddress" cols="30" rows="2" styleId="inv_exporteraddress"></h:textarea><br />
       					 <br /> Telephone : <h:text property="inv_exportertele" styleId="inv_exportertele"> </h:text><br />
						<br /> Fax :  <h:text property="inv_exporterfax" styleId="inv_exporterfax"> </h:text>  <br />  
       			  </fieldset>
       		  </td>
   			  <td width="300">
   				  <fieldset>         
       				  <legend>Notify Details</legend><br/> 
       					  Notify: <h:text property="inv_notify" styleId="inv_notify" styleClass="invautocompleteclass"></h:text><br />        
   	 					 <br /> Attn: <h:text property="inv_notifyattn" styleId="inv_notifyattn"></h:text><br />
       					 <br /> Address:<h:textarea property="inv_notifyaddress" cols="15" rows="1" styleId="inv_notifyaddress"></h:textarea><br />
       					<br />  Phone : <h:text property="inv_notifytele" styleId="inv_notifytele"> </h:text><br />
						 <br /> Fax :  <h:text property="inv_notifyfax" styleId="inv_notifyfax"> </h:text>  <br />  
       			  </fieldset>
   			  </td>
		  </tr>
		  <tr>
   			  <td height="19">

   				  <fieldset>         
       				  <legend>Bank Details</legend><br/> 
       					  Bank: <h:text property="inv_bank" styleId="inv_bank"></h:text><br />        
   	 					  <br />Branch: <h:text property="inv_bankbranch" styleId="inv_bankbranch"></h:text><br />
       					  <br />addr:<h:textarea property="inv_bankaddress" cols="15" rows="1" styleId="inv_bankaddress" style="align:center"></h:textarea><br />
       					  <br />Swift Code: <h:text property="inv_bankswiftcode" styleId="inv_bankswiftcode"> </h:text><br />
       					  <br />Acct No : <h:text property="inv_bankacno" styleId="inv_bankacno"> </h:text><br />
       					  <br />Phone : <h:text property="inv_banktele" styleId="inv_banktele"> </h:text><br />
						  <br />fax :  <h:text property="inv_bankfax" styleId="inv_bankfax"> </h:text>  <br />  
       			  </fieldset>
       		  </td>
   			  <td>
   			      <fieldset>         
       				  <legend>Dispatch Details</legend><br/> 
       					  COG: <h:text property="inv_ctryoforigngoods" styleId="inv_ctryoforigngoods"></h:text><br />
       					  <br />Port Of Loading: <h:text property="inv_loadingport" styleId="inv_loadingport"></h:text><br /> 
						 <br /> COF: <h:select property="inv_ctryoffinaldesti" styleId="inv_ctryoffinaldesti" onchange="loadtanvalue();">
   		 						  <h:option value="0">select Loading Port</h:option>
   		 							  <c:forEach items="${invCountryFinalDestiarray}" var="invCountryFinalDestilist">
          		 							<h:option value="${invCountryFinalDestilist.destinationCountry}">
         		 								<c:out value="${invCountryFinalDestilist.destinationCountry}"></c:out>
          		 							</h:option>
          	 							</c:forEach>
       							  </h:select><br /> 
   	 					  <br />Final Destination: <h:select property="inv_finaldesti" styleId="inv_finaldesti" onchange="loadtanvalue();">
   		 						  <h:option value="0">select Destination</h:option>
   		 							  <c:forEach items="${invFinalDestinationarray}" var="invDestinationlist">
          		 							<h:option value="${invDestinationlist.destination}">
         		 								<c:out value="${invDestinationlist.destination}"></c:out>
          		 							</h:option>
          	 							</c:forEach>
       							  </h:select><br /> 
       					  <br />Discharge port:<h:select property="inv_dischargeport" styleId="inv_dischargeport" onchange="loadtanvalue();">
   		 						  <h:option value="0">select Discharge Port</h:option>
   		 							  <c:forEach items="${invDischargeportarray}" var="invFinalDestinationlist">
          		 							<h:option value="${invFinalDestinationlist.destination}">
         		 								<c:out value="${invFinalDestinationlist.destination}"></c:out>
          		 							</h:option>
          	 							</c:forEach>
       							  </h:select><br /> 
       					  <br />Vessel No  : <h:text property="inv_vesselno" styleId="inv_vesselno"></h:text><br />      
       					 <br /> AW/Bill Date: <h:text property="inv_awbilldate" styleId="inv_awbilldate" styleClass="dateclass"> </h:text><br />
						  <br />AW/Bill No :  <h:text property="inv_awbillno" styleId="inv_awbillno"> </h:text>  <br />  
       			  </fieldset>    				  			
   			  </td>
   			  <td>
   				  <fieldset>         
       				  <legend>Other Details</legend><br/> 
       				  	  Pre Carriage By: <h:text property="inv_precarriageby" styleId="inv_precarriageby"></h:text><br />
       					  Place of Reciept: <br />Dimension: <h:text property="inv_precarriageby" styleId="inv_precarriageby" onchange="loadtanvalue();"></h:text><br /> 						
   						  Gross Wt: <h:text property="inv_grosswt" styleId="inv_grosswt"></h:text><br />
       					  <br />Dimension: <h:text property="inv_dimension" styleId="inv_dimension" onchange="loadtanvalue();"></h:text><br /> 
						 <br /> Marks: <h:text property="inv_marksno" styleId="inv_marksno"></h:text><br />
   	 					 <br /> No Of packages: <h:text property="inv_noofpackages" styleId="inv_noofpackages"></h:text><br />
       					  <br />Pack No:<h:text property="inv_packno" styleId="inv_packno"></h:text><br />
       					 <br />Net Wt: <h:text property="inv_netwt" styleId="inv_netwt"></h:text><br />      
       					 
				  </fieldset>  
				 
			</td>
		  </tr>
		  <tr>
   			  <td>
   				  <fieldset>         
       				  <legend>Customer Details</legend>
   						  Customer Name: <h:text property="inv_customer" styleId="inv_customer"></h:text><br />
       					  <br />Attn: 	   <h:text property="inv_custattn" styleId="inv_custattn"></h:text><br /> 
						  <br /> Address:   <h:textarea property="inv_custaddr" cols="15" rows="1" styleId="inv_custaddr"></h:textarea><br />
   	 					  <br />Telephone: <h:text property="inv_custtele" styleId="inv_custtele"></h:text><br />
       					  <br />Fax:	   <h:text property="inv_custfax" styleId="inv_custfax"></h:text><br />
       					  <br />ID:	   <h:text property="inv_custid" styleId="inv_custid"></h:text><br />
       					
				  </fieldset>  
			  </td>
   			  <td colspan="2">
           		  <table id="tbl_invListCustomerContract" > </table>   
           		  <div id="tbl_invpager"></div>            	 
           	</td>	      	  
		  <tr>
  			  <td colspan="3">&nbsp;</td>
	    </tr>
		  <tr>
		     <td colspan="3">
		     	<table id="tbl_invaddinvBill"></table>
		       <div id="tbl_invbillpager"></div>
		       </td>
		      
		  </tr>
		   <tr>
  			  <td colspan="3">&nbsp;</td>
	    </tr>
		  <tr>
   			   <td colspan="3">
           		 
							<table id="invBill"></table>
		      				 <div id="invbillpager"></div>
						</td>    
          <tr>
                  <td> <fieldset>         
       				  <legend>Other Charges</legend>
				  		 Courier Charges: <h:text property="inv_courierchrgs" styleId="inv_courierchrgs"> </h:text>
				  		 <h:radio property="inv_vatcst" value="cst" styleId="inv_vatcst">Discount: </h:radio><h:radio property="inv_reduction" value="vat" styleId="vatcst">Deduction:</h:radio>
				  		  <br /> <h:radio property="inv_packingcharges" value="cst" styleId="inv_packingcharges">CST: </h:radio><h:radio property="inv_vatcst" value="vat" styleId="inv_vatcst">Vat: </h:radio>
						  <br />Other Charges :  <h:text property="inv_courierchrgs" styleId="inv_courierchrgs"> </h:text>  <br />
						   <br />Total Amount :  <h:text property="inv_total" styleId="inv_total"> </h:text>  <br />
						 </fieldset></td>
		  </tr>
	    <tr>
 			
		      <td colspan="4">
		    	  <h:submit property="action" value="Save"></h:submit>
		    	  <h:reset property="action" value="Clear"></h:reset>
			  </td>  		
   		</tr>
   		<tr>
			    <td>&nbsp;</td>
			    <td>&nbsp;</td>
	    </tr>
		  
	  </table>
		
		
		</h:form>
</body>
</h:html>