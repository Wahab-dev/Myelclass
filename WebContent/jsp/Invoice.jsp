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
					var custid = $("#inv_custid").val();
					 $('#tbl_invListCustomerContract').jqGrid().setGridParam({url:"/Myelclass/InvSelectCtfromCust.do?custid="+custid+"&action="+"load"}).trigger("reloadGrid");
		          	  $('#inv_custaddr').val(ui.item.addr);
		          	  $('#inv_custtele').val(ui.item.fone);
		          	  $('#inv_custattn').val(ui.item.attn);
		          	  $('#inv_custfax').val(ui.item.fax);
		          	 $('#inv_custid').val(ui.item.id);
				    }
		  	});
		
			 grid.jqGrid({ // MAster Grid
				 url: "",
				 datatype: "json",
				 loadonce: false,
				 mtype: 'GET', 
				 colNames:['Ct No','Article','Color','Size','Substance','Quantity','Rate','TC'],
				 colModel:[
				           {name: 'id', index:'id',editable: true, 
				        	   /* formoptions:{
				        	   	elmprefix:"(<span class='mystar' style='color:red'>*</span>)&nbsp;",
				        	    elmsuffix:"&nbsp;yyyy-mm-dd",
				        	    label: "<span>Date<span><span style='float:right'>XXX</span>"}, */ 
				        	  width:50},
				           {name: 'articlename', index:'articlename',width:90},
				           {name: 'color', index:'color',width:70},
				           {name: 'size', index:'size',width:70},
				           {name: 'substance', index:'substance',width:70},
				           {name: 'quantity', index:'quantity',width:70},
				           {name: 'rate', index:'rate',width:70},
				           {name: 'tc', index:'tc',width:70}
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
				   sortname: 'contractno',
				   sortorder: 'desc',  
				   height : "auto",
				   //hide: false,
			       emptyrecords: 'No records to display',
			       caption  : "Select Contract From List",
			       });
			grid.jqGrid('navGrid','#tbl_invpager',{
				add : false,
				edit: true, editCaption:'Check For the Values',
				del : false,
				view: false,
				search : false,
				reload: true		
			}).navButtonAdd('#tbl_invpager',{
	 		 	   caption:"Select", 
	 		 	   buttonicon:"ui-icon-add", 
	 		 	   onClickButton: function(ids){ 
	 		 		// if(ids != null) {
	 				//	ids=0;
	 				//	if(billgrid.jqGrid('getGridParam','records') ==0 )
	 					//{
	 						// contractno alert(ids);
	 						var ctno = grid.jqGrid('getGridParam','selarrrow');
	 						//var myCellData = grid.jqGrid('getCell', ctno, 'articlename');
	 						alert(ctno );
	 						billgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?ctno="+ctno+"&action="+"loadsubgrid",page:1});
	 						billgrid.jqGrid('setCaption',"Raise Invoice  ")
	 						.trigger('reloadGrid');
	 						
	 					//}
	 		 		// }
	 		 	   },
	 		 	   position:"last",
		});

			//Load Billing Details
				 $("#tbl_invaddinvBill").jqGrid({
					 datatype: "json",
					 colNames:['Ct No','Article','Color','Size','Substance','Selection','Pieces','Quantity','Rate','Commission','TC'],
					 colModel:[
								{name: 'prf_contractno', index:'prf_contractno',width:50},
								{name: 'prf_articlename', index:'prf_articlename',width:90},
								{name: 'prf_color', index:'prf_color',width:70},
								{name: 'prf_size', index:'prf_size',width:70},
								{name: 'prf_substance', index:'prf_substance',width:70},
								{name: 'prf_selection', index:'prf_selection',width:90},
								{name: 'prf_pieces', index:'prf_pieces',width:90},
								{name: 'prf_quantity', index:'prf_quantity',width:70},
								{name: 'prf_price', index:'prf_price',width:70},
								{name: 'prf_comm', index:'prf_comm',width:70},
								{name: 'prf_tc', index:'prf_tc',width:70}
					           ],
					jsonReader : {  
						 repeatitems:false,
					       root: "rows",
					       page: "page", //calls first
					       total: "total" ,//calls Second
					       records: "records", //calls Third
							       }, 
					pager: '#tbl_invbillpager',
					rowNum:3, 
					multiselect : true,
					rowList:[3,5,7],	       
					sortorder: 'desc',  
					emptyrecords: 'No records to display',
					caption  : "Select Contract"
							       
				 });	 
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
	  <table width="840" height="426" border="1" cellpadding="0" cellspacing="0">
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
           		  <table id="tbl_invListCustomerContract" >
           		  </table>   
           		  <div id="tbl_invpager">
           		  </div>            	 
           	</td>	      	  
		  <tr>
  			  <td colspan="3">&nbsp;</td>
	    </tr>
		  <tr>
		     <td colspan="3">
		    <%--  <h:button property="Addinv" value="LoadBill" styleId="loadBill"></h:button> --%>
		     	<table id="tbl_invaddinvBill">
		       </table>
		       <div id="tbl_invbillpager">
		       
		       </div>
		      <!--  <tr>
		         <td width="72">Contract No</td>
		         <td width="51">Article</td>
		         <td width="68">Color</td>
		         <td width="56">Size</td>
		         <td width="70">Substance</td>
		         <td width="58">Selection</td>
		         <td width="55">Quantity</td>
		         <td width="39">Pieces</td>
		         <td width="33">Rate</td>
		         <td width="62">Shipment</td>
		         <td width="80">Commission</td>
		         <td width="186">TC</td>
	           </tr> -->
	           
		      
	         </td>
		  </tr>
		  <tr>
   			   <td colspan="3">
           		  <table width="899" border="2" cellspacing="0" cellpadding="0">
           		    <tr>
               		   <td colspan="14">&nbsp;</td>
           		    </tr>
               	    <tr>
               	      <td width="86">Contract No</td>
               	      <td width="40">Article</td>
               	      <td width="35">Color</td>
               	      <td width="25">Size</td>
               	      <td width="62">Substance</td>
               	      <td width="55">Selection</td>
               	      <td width="53">Quantity</td>
               	      <td width="39">Pieces</td>
               	      <td width="28">Rate</td>
               	      <td width="61">Shipment</td>
               	      <td width="75">Commission</td>
               	      <td width="62">QShipped</td>
               	      <td width="75">QRemaining</td>
               	      <td width="448">Amount</td>
              	   </tr>
                	             	
           		  </table>
           	  </td>
		  </tr>
          <tr>
		  <td>&nbsp;</td>
			    <td>&nbsp;</td>
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