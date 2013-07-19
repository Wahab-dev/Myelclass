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
		 var gridbtn = $("#thelink");
		 var grid = $("#tbl_invListCustomerContract"); 
		// var billbtn = $("#loadBill");
		 
		 //Load Cust Ct No
		gridbtn.click(function (){
			var custid = $("#custid").val();
			 alert("Customer Name is "+custid);
			 grid.jqGrid({ // MAster Grid
				 url:"/Myelclass/InvSelectCtfromCust.do?custid="+custid+"&action="+"load",
				 datatype: "json",
				 loadonce: false,
				 mtype: 'GET', 
				 colNames:['Ct No','Article','Color','Size','Substance','Quantity','Rate','TC'],
				 colModel:[
				           {name: 'contractno', index:'contractno',editable: true, formoptions:{
				        	   	elmprefix:"(<span class='mystar' style='color:red'>*</span>)&nbsp;",
				        	    elmsuffix:"&nbsp;yyyy-mm-dd",
				        	    label: "<span>Date<span><span style='float:right'>XXX</span>"}, 
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
	 		 	   caption:"Status", 
	 		 	   buttonicon:"ui-icon-add", 
	 		 	   onClickButton: function(){ 
	 		 	     alert("Adding Row");
	 		 	    alert(grid.jqGrid('getGridParam','selarrrow'));
	 		 	   }, 
	 		 	   position:"last"
	 		 	});
		
		
		});
		 
		 
		 
		//$('#tbl_invListCustomerContract' ).trigger( 'reloadGrid', [{ page: 1}] );
		
		//Invoice Type
		$('#invoicetype').change(function(){
			var value = $('#invoicetype').val();
			alert("select box value changed"+value);
		});
		
		$('#customer').autocomplete({
			minLength: 1,
			source: function(request, response,term) {
				var param = request.term;
				 $.ajax({
		                url: "/Myelclass/InvAutocomplete.do?term="+param+"&action="+"customer",
		                dataType: "json",
		                type:"POST",
		                success: function (data) {
		                	 response($.map(data, function(item) {
		                		  return { 
		                			 id: item.customerId,
		                			 label : item.value,
		                			 value: item.value,
		                             addr: item.customerAddress,
		                             fone: item.customerTelephone,	
		                             attn : item.customerAttention,
		                             fax: item.customerFax,
		                             };
		                         }));//END Response
		                    }//END Success
		            });//END AJAX
				},
				select: function( event, ui ) { 
		          	  $('#custaddr').val(ui.item.addr);
		          	  $('#custtele').val(ui.item.fone);
		          	  $('#custattn').val(ui.item.attn);
		          	  $('#custfax').val(ui.item.fax);
		          	 $('#custid').val(ui.item.id);
				    }
		  	});
		
		 $(".dateclass").datepicker({
			    autoSize: true,
			    changeMonth:false,
			    dateFormat: "dd/mm/yy",
			    firstDay: 1,
			    gotoCurrent:true, 
			});
		
			
			//Load Billing Details
			/*  billbtn.click(function (){
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
							       root: function (jsonOrderArray) { return jsonOrderArray; },
							       page: function (jsonOrderArray) { return 1; },
							       total: function (jsonOrderArray) { return 1; },
							       records: function (jsonOrderArray) { return jsonOrderArray.length; }
							       }, 
					pager: '#tbl_invpager',
					rowNum:3, 
					multiselect : true,
					rowList:[3,5,7],	       
					sortorder: 'desc',  
					emptyrecords: 'No records to display',
					caption  : "Select Contract"
							       
				 });
			 }); */
			
			 
	});
	
</script>
<script type="text/javascript">
	//Tannery DDL	
	function loadexportervalue(){		
				var expname = document.getElementById("exporter").value;
		 		  <c:forEach items="${InvExporterarray}" var="ExpoList">
						var expvalue  = "<c:out value="${ExpoList.expname}"></c:out>";					 
				  			 if(expname == expvalue){
				  			     var myexpaddr = "<c:out value="${ExpoList.expaddr}"></c:out>" ; 			  			  	
				  			     var mayexpphone = "<c:out value="${ExpoList.expphone}"></c:out>" ;
				  			     var myexpattn = "<c:out value="${ExpoList.expattn}"></c:out>" ; 
				  			     var myexpfax = "<c:out value="${ExpoList.expfax}"></c:out>" ; 	 
				  			     var myexpref = "<c:out value="${ExpoList.expref}"></c:out>" ; 
				   				
				   				document.getElementById("exportertele").value = mayexpphone;
				   				document.getElementById("exporterattn").value = myexpattn;
				   				document.getElementById("exporterfax").value = myexpfax;   
				  			    document.getElementById("exporteraddress").value = myexpaddr; 
				  			    document.getElementById("expref").value = myexpref;
						} 
					</c:forEach>   
			}
	
	//Notify  DDL	
	function loadnotifyvalue(){		
				var notifyname = document.getElementById("notify").value;
		 		  <c:forEach items="${InvNotifyarray}" var="NotifyList">
						var notifyvalue  = "<c:out value="${NotifyList.notifyConsigneeName}"></c:out>";					 
				  			 if(notifyname == notifyvalue){
				  			     var mynotifyaddr = "<c:out value="${NotifyList.notifyConsigneeAddress}"></c:out>" ; 			  			  	
				  			     var maynotifyphone = "<c:out value="${NotifyList.notifyConsigneeContactNo}"></c:out>" ;
				  			     var mynotifyattn = "<c:out value="${NotifyList.notifyConsigneeAttention}"></c:out>" ; 
				  			     var mynotifyfax = "<c:out value="${NotifyList.notifyConsigneefax}"></c:out>" ; 	 
				  			     
				   				document.getElementById("notifytele").value = maynotifyphone;
				   				document.getElementById("notifyattn").value = mynotifyattn;
				   				document.getElementById("notifyfax").value = mynotifyfax;   
				  			    document.getElementById("notifyaddress").value = mynotifyaddr; 
				  			} 
					</c:forEach>   
			}
	
		

	//Bank DDL	
	function loadbankvalue(){		
				var bankname = document.getElementById("bank").value;			
		 		  <c:forEach items="${invBankarray}" var="BankList">
						var bankvalue  = "<c:out value="${BankList.bankName}"></c:out>";						
				  			if(bankname == bankvalue){
				  				
				  			    var mybankaddr = "<c:out value="${BankList.bankAddress}"></c:out>" ; 			  			  	
				  			    var maybankphone = "<c:out value="${BankList.bankContactNo}"></c:out>" ;
				  			    var mybankbranch = "<c:out value="${BankList.bankBranch}"></c:out>" ; 
				  			    var mybankswiftcode = "<c:out value="${BankList.bankSwiftCode}"></c:out>" ; 
				  			 	var mybankacno = "<c:out value="${BankList.bankAcctNo}"></c:out>" ; 
				   				
				   				document.getElementById("bankaddress").value = mybankaddr;
				   				document.getElementById("banktele").value = maybankphone;
				   				document.getElementById("bankbranch").value = mybankbranch;   
				  			    document.getElementById("bankswiftcode").value = mybankswiftcode;   
				  			    document.getElementById("bankacno").value = mybankacno;   
						} 
					</c:forEach>   
			} 		

	//Customer DDL	
	function loadcustvalue(){		
				 var custname = document.getElementById("customer").value;
				 <c:forEach items="${invCustomerarray}" var="invCustList">
				 var custvalue  = "<c:out value="${invCustList.customerName}"></c:out>";
				 if(custname == custvalue){
					 //Address is not Working pls check
					 	 var mycustaddr = "<c:out value="${invCustList.customerAddress}"></c:out>" ;
						 var mycustphone = "<c:out value="${invCustList.customerTelephone}"></c:out>" ;
			  			var mycustattn = "<c:out value="${invCustList.customerAttention}"></c:out>" ; 
			  			var mycustfax = "<c:out value="${invCustList.customerFax}"></c:out>" ; 		
			  			var mytable = document.getElementById("ListCustomerContract");
			   			document.getElementById("custtele").value = mycustphone;
			   			document.getElementById("custattn").value = mycustattn;
			   			document.getElementById("custfax").value = mycustfax;  
			   			document.getElementById("custaddr").value = mycustaddr;  
			   			loadcustInvValue(custvalue,mytable);
				 }
				 
				 </c:forEach> 
				 
			} 	
	
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
       					  Type: <h:select property="invoicetype" styleId="invoicetype">
       					  		  <h:option value="0">Select Type</h:option>
   		 						  <h:option value="1">IC-Local</h:option>
   		 						  <h:option value="2">IC-Exports</h:option>
   		 						  <h:option value="3">IC-Courier</h:option>
   		 						  <h:option value="4">Other-Tanner Courier</h:option> 
   		 						  <h:option value="5">Other-Tanner Exports</h:option> 
   		 						  <h:option value="6">Other-Tanner Local</h:option>
   		 						   <h:option value="6">IC-PO</h:option>  
   		 						   <h:option value="6">IC-JW</h:option>  
       							 </h:select><br />        
   	 					 <br /> Invoice No: <h:text property="invoiceno" styleId="invoiceno"></h:text><br />
       					 <br /> Invoice Date:<h:text property="invdate" styleId="invdate" styleClass="dateclass"></h:text><br />
       					 <br /> Exporters Ref. : <h:text property="expref" styleId="expref"> </h:text><br />
						 <br /> Other ref :  <h:text property="otherref" styleId="otherref"> </h:text>  <br />  
   				  </fieldset>
			  </td>
   			  <td width="300">
   				  <fieldset>         
       				  <legend>Exporter Details</legend><br/> 
       					  Exporter: <h:select property="exporter" styleId="exporter" onchange="loadexportervalue();">
   		 						  <h:option value="0">select Tanner</h:option>
   		 							  <c:forEach items="${InvExporterarray}" var="InvExporterlist">
          		 							<h:option value="${InvExporterlist.expname}">
         		 								<c:out value="${InvExporterlist.expname}"></c:out>
          		 							</h:option>
          	 							</c:forEach>
       							  </h:select><br />        
   	 					 <br /> Attn: <h:text property="exporterattn" styleId="exporterattn"></h:text><br />
       					 <br /> Address: <h:textarea property="exporteraddress" cols="30" rows="2" styleId="exporteraddress"></h:textarea><br />
       					 <br /> Telephone : <h:text property="exportertele" styleId="exportertele"> </h:text><br />
						<br /> Fax :  <h:text property="exporterfax" styleId="exporterfax"> </h:text>  <br />  
       			  </fieldset>
       		  </td>
   			  <td width="300">
   				  <fieldset>         
       				  <legend>Notify Details</legend><br/> 
       					  Notify: <h:select property="notify" styleId="notify" onchange="loadnotifyvalue();">
   		 						  <h:option value="0">select Notify</h:option>
   		 							  <c:forEach items="${InvNotifyarray}" var="InvNotifylist">
          		 							<h:option value="${InvNotifylist.notifyConsigneeName}">
         		 								<c:out value="${InvNotifylist.notifyConsigneeName}"></c:out>
          		 							</h:option>
          	 							</c:forEach>
       							  </h:select><br />        
   	 					 <br /> Attn: <h:text property="notifyattn" styleId="notifyattn"></h:text><br />
       					 <br /> Address:<h:textarea property="notifyaddress" cols="15" rows="1" styleId="notifyaddress"></h:textarea><br />
       					<br />  Phone : <h:text property="notifytele" styleId="notifytele"> </h:text><br />
						 <br /> Fax :  <h:text property="notifyfax" styleId="notifyfax"> </h:text>  <br />  
       			  </fieldset>
   			  </td>
		  </tr>
		  <tr>
   			  <td height="19">

   				  <fieldset>         
       				  <legend>Bank Details</legend><br/> 
       					  Bank: <h:select property="bank" styleId="bank" onchange="loadbankvalue();">
   		 						  <h:option value="0">select Bank</h:option>
   		 							  <c:forEach items="${invBankarray}" var="invBanklist">
       		 							  <h:option value="${invBanklist.bankName}">
       		 								  <c:out value="${invBanklist.bankName}"></c:out>
       		 							  </h:option>
       	 							  </c:forEach>
       							  </h:select><br />        
   	 					  <br />Branch: <h:text property="bankbranch" styleId="bankbranch"></h:text><br />
       					  <br />addr:<h:textarea property="bankaddress" cols="15" rows="1" styleId="bankaddress" style="align:center"></h:textarea><br />
       					  <br />Swift Code: <h:text property="bankswiftcode" styleId="bankswiftcode"> </h:text><br />
       					  <br />Acct No : <h:text property="bankacno" styleId="bankacno"> </h:text><br />
       					  <br />Phone : <h:text property="banktele" styleId="banktele"> </h:text><br />
						  <br />fax :  <h:text property="bankfax" styleId="bankfax"> </h:text>  <br />  
       			  </fieldset>
       		  </td>
   			  <td>
   			      <fieldset>         
       				  <legend>Dispatch Details</legend><br/> 
       					  COG: <h:select property="ctryoforigngoods" styleId="ctryoforigngoods" onchange="">
       					  		<h:option value="0">select Loading Country</h:option>
       					  		<h:option value="1">India</h:option>
       					  		<h:option value="2">China</h:option>
          		 			   </h:select><br />
       					  <br />Port Of Loading: <h:select property="loadingport" styleId="loadingport" onchange="loadtanvalue();">
   		 						  <h:option value="0">select Loading Port</h:option>
   		 							  <c:forEach items="${invLoadingPortarray}" var="invLoadingPortlist">
          		 							<h:option value="${invLoadingPortlist.destination}">
         		 								<c:out value="${invLoadingPortlist.destination}"></c:out>
          		 							</h:option>
          	 							</c:forEach>
       							  </h:select><br /> 
						 <br /> COF: <h:select property="ctryoffinaldesti" styleId="ctryoffinaldesti" onchange="loadtanvalue();">
   		 						  <h:option value="0">select Loading Port</h:option>
   		 							  <c:forEach items="${invCountryFinalDestiarray}" var="invCountryFinalDestilist">
          		 							<h:option value="${invCountryFinalDestilist.destinationCountry}">
         		 								<c:out value="${invCountryFinalDestilist.destinationCountry}"></c:out>
          		 							</h:option>
          	 							</c:forEach>
       							  </h:select><br /> 
   	 					  <br />Final Destination: <h:select property="finaldesti" styleId="finaldesti" onchange="loadtanvalue();">
   		 						  <h:option value="0">select Destination</h:option>
   		 							  <c:forEach items="${invFinalDestinationarray}" var="invDestinationlist">
          		 							<h:option value="${invDestinationlist.destination}">
         		 								<c:out value="${invDestinationlist.destination}"></c:out>
          		 							</h:option>
          	 							</c:forEach>
       							  </h:select><br /> 
       					  <br />Discharge port:<h:select property="dischargeport" styleId="dischargeport" onchange="loadtanvalue();">
   		 						  <h:option value="0">select Discharge Port</h:option>
   		 							  <c:forEach items="${invDischargeportarray}" var="invFinalDestinationlist">
          		 							<h:option value="${invFinalDestinationlist.destination}">
         		 								<c:out value="${invFinalDestinationlist.destination}"></c:out>
          		 							</h:option>
          	 							</c:forEach>
       							  </h:select><br /> 
       					  <br />Vessel No  : <h:text property="vesselno" styleId="vesselno"></h:text><br />      
       					 <br /> AW/Bill Date: <h:text property="awbilldate" styleId="awbilldate" styleClass="dateclass"> </h:text><br />
						  <br />AW/Bill No :  <h:text property="awbillno" styleId="awbillno"> </h:text>  <br />  
       			  </fieldset>    				  			
   			  </td>
   			  <td>
   				  <fieldset>         
       				  <legend>Other Details</legend><br/> 
   						  Gross Wt: <h:text property="grosswt" styleId="grosswt"></h:text><br />
       					  <br />Dimension: <h:text property="dimension" styleId="dimension" onchange="loadtanvalue();"></h:text><br /> 
						 <br /> Marks: <h:text property="marksno" styleId="marksno"></h:text><br />
   	 					 <br /> No Of packages: <h:text property="noofpackages" styleId="noofpackages"></h:text><br />
       					  <br />Pack No:<h:text property="packno" styleId="packno"></h:text><br />
       					 <br />Net Wt: <h:text property="netwt" styleId="netwt"></h:text><br />      
       					 
				  </fieldset>  
				 
			</td>
		  </tr>
		  <tr>
   			  <td>
   				  <fieldset>         
       				  <legend>Customer Details</legend>
   						  Customer Name: <h:text property="customer" styleId="customer"></h:text> 
   						  				<%-- <h:select property="customer" styleId="customer" onchange="loadcustvalue();">
   		 						  <h:option value="0">select Customer</h:option>
   		 							  <c:forEach items="${invCustomerarray}" var="invCustomerlist">
       		 							  <h:option value="${invCustomerlist.customerName}">
       		 								  <c:out value="${invCustomerlist.customerName}"></c:out>
       		 							  </h:option>
       	 							  </c:forEach>
       							  </h:select> --%><br />
       					  <br />Attn: 	   <h:text property="customer" styleId="custattn"></h:text><br /> 
						 <br /> Address:   <h:textarea property="custaddr" cols="15" rows="1" styleId="custaddr"></h:textarea><br />
   	 					  <br />Telephone: <h:text property="custtele" styleId="custtele"></h:text><br />
       					  <br />Fax:	   <h:text property="custfax" styleId="custfax"></h:text><br />
       					    <br />ID:	   <h:text property="custid" styleId="custid"></h:text><br />
       					  <h:button property="selctforcust" value="load" styleId="thelink"></h:button>
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
		     <h:button property="Addinv" value="LoadBill" styleId="loadBill"></h:button>
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
				  		 Courier Charges: <h:text property="courierchrgs" styleId="courierchrgs"> </h:text>
				  		 <h:radio property="vatcst" value="cst" styleId="vatcst">Discount: </h:radio><h:radio property="discount" value="vat" styleId="vatcst">Deduction:</h:radio>
				  		  <br /> <h:radio property="vatcst" value="cst" styleId="vatcst">CST: </h:radio><h:radio property="vatcst" value="vat" styleId="vatcst">Vat: </h:radio>
						  <br />Other Charges :  <h:text property="courierchrgs" styleId="courierchrgs"> </h:text>  <br />
						   <br />Total Amount :  <h:text property="total" styleId="total"> </h:text>  <br />
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