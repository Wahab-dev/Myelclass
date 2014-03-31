/**
 * 
 */

$(document).ready(function() {
	$("#saminv_total").focusout(function() {
		var discnt = $("#saminv_deduction").val();
		var courchrg = $("#saminv_courierchrgs").val();
		var tot = $("#saminv_total").val();
		totamt = (parseFloat (tot) - parseFloat (discnt)) + parseFloat (courchrg);
		alert("totamt"+totamt);
		$("#saminv_total").val(totamt);
	});
	var billInvisInEdit = false; //boolean value need to Check High Priority 
	var type =null;//get whether the inv for only ct or sample included
	var saminvgrid = $("#saminvBill");
	var sambillgrid = $("#tbl_saminvaddinvBill");
	var saminvctgrid = $("#tbl_saminvListCustomerContract"); 
	
	// Invoice Type
	$("#saminv_invoicetype").change(function() {
		var str = "" ;
		 $("#saminv_invoicetype option:selected" ).each(function() {
			str = "" ;
			str = $(this).text();
			/*
			 * Ajax Call for Invoice no Based on Invoice Type 
			 */
			$.ajax({
				url: "/Myelclass/InvAutocomplete.do",
				type: "GET",
				async: true,
				dataType: "text",
				data: { term: str, action: "saminvtype" },
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success: function (data) {
	                console.log("success"+data);
	                $("#saminv_invoiceno").val(data);
	            }, 
	            error: function (data) {
	                console.log("error");
	            } 
			});
		 });
	});
	 $(".dateclass").datepicker({
		 	autoSize: true,
		    changeMonth:false,
		    dateFormat: "dd-mm-yy",
		    showWeek: true,
		    firstDay: 1,
		    numberOfMonths: 1,
		    showButtonPanel: false,
		    gotoCurrent:true, 
		});
	 
	 $('.autocmplet').autocomplete({
		 source: function(request, response) {
			var param = request.term;  
			var destictryval = $('#saminv_ctryoffinaldesti').val();
			$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"destiport&destictryval="+destictryval,
				function(result) { 	
			       response($.map(result, function(item) {
			           return { 
			              value: item.destiname,
			              };
			        }));//END response
			 });
		 }
	});
	 
	 
	$('#saminv_ctryoffinaldesti').autocomplete({
		 source: function(request, response) {
			var param = request.term;  
			$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"destictry",
				function(result) { 	
			       response($.map(result, function(item) {
			           return { 
			              value: item.destictry,
			              };
			        }));//END response
			 });
		 }
	});
	 
	 $('#saminv_loadingport').autocomplete({
		 source: function(request, response) {
			var param = request.term;  
			var ctryval = $('#saminv_ctryoforigngoods').val();
			$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"loadport&ctryval="+ctryval,
				function(result) { 	
			       response($.map(result, function(item) {
			           return { 
			              value: item.destiname,
			              };
			        }));//END response
			 });
		 }
	});
	 
	 $('#saminv_ctryoforigngoods').autocomplete({
		 source: function(request, response) {
			var param = request.term;  
			$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"loadctry",
				function(result) { 	
			       response($.map(result, function(item) {
			           return { 
			              value: item.destiname,
			              };
			        }));//END response
			 });
		 },
		 close: function () {
			    $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
		 }
	});
	 
	 
	 $('#saminv_exporter').autocomplete({
			minLength: 1,
			source: function(request, response,term) {
				var param = request.term;
				$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"exporter",
					function(result) { 	
		               response($.map(result, function(item) {
		               	return { 
		                	ref: item.expref,
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
		          	  $('#saminv_exporteraddress').val(ui.item.addr);
		          	  $('#saminv_exportertele').val(ui.item.fone);
		          	  $('#saminv_exporterattn').val(ui.item.attn);
		          	  $('#inv_exporterfax').val(ui.item.fax);
		              $('#saminv_exporterfax').val(ui.item.ref);
				    }
		  	    });
	 
	 
	 $('#saminv_notify').autocomplete({
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
		          	  $('#saminv_notifyaddress').val(ui.item.addr);
		          	  $('#saminv_notifytele').val(ui.item.fone);
		          	  $('#saminv_notifyattn').val(ui.item.attn);
		          	  $('#saminv_notifyfax').val(ui.item.fax);
				    }
		  	});
	 
	 $('#saminv_bank').autocomplete({
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
		          	  $('#saminv_bankbranch').val(ui.item.branch);
		          	  $('#saminv_bankaddress').val(ui.item.addr);
		          	  $('#saminv_banktele').val(ui.item.ctno);
		          	  $('#saminv_bankfax').val(ui.item.fax);
		          	  $('#saminv_bankswiftcode').val(ui.item.swiftcode);
		          	  $('#saminv_bankacno').val(ui.item.acctno);
				    }
		  	});
	 
	 $('#saminv_customer').autocomplete({
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
		                    };
		                 }));//END Response	
					});//End getJSon
				},
				select: function( event, ui ) { 
					 $('#saminv_custaddr').val(ui.item.addr);
		          	 $('#saminv_custtele').val(ui.item.fone);
		          	 $('#saminv_custattn').val(ui.item.attn);
		          	 $('#saminv_custfax').val(ui.item.fax);
		          	 $('#saminv_custid').val(ui.item.id);
		          	 var custname = ui.item.label;
		          	 //Load First Grid Based On Selected Value
		          	type = $('#saminv_includeSample').val();
					alert("asd"+type);
					saminvctgrid.jqGrid('setGridParam',{url:"/Myelclass/sampleInvSelectCtfromCust.do?custname="+custname+"&type="+type+"&action="+"load"}).trigger("reloadGrid");				 
				    }
		  	 });
function clickheremethod(){
	 var selsamnos="";
	 var ids = saminvctgrid.jqGrid('getGridParam','selarrrow');
	 for (var i=0; i<ids.length;i++){
	     var rowData = saminvctgrid.jqGrid('getRowData',ids[i]);
		 var sam = " '"+rowData.sampleno+"',";
		selsamnos = selsamnos+sam;
	   }
	 var itemp = selsamnos.lastIndexOf(",");
	 var samnoselc = selsamnos.substring(0, itemp);
	 alert("samnoselc"+samnoselc);
	 type = $('#saminv_includeSample').val();
	 alert("asd"+type);
	 sambillgrid.jqGrid('setGridParam',{url:"/Myelclass/sampleInvSelectCtfromCust.do?samno="+samnoselc+"&type="+type+"&action="+"loadsubgrid",page:1});
	 sambillgrid.jqGrid('setCaption',"Raise Invoice").trigger('reloadGrid');
	 saminvgrid.jqGrid('setGridParam',{url:"/Myelclass/sampleInvSelectCtfromCust.do?action="+"loadBill&samno="+samnoselc+"&type="+type ,page:1}).trigger('reloadGrid');
 
}

		/*
	 	 * Grid 1 - Loads Data Based on the Customer Selected Value
	 	 *  fields -ctno, orderdt, pono, cdd_date, add_date, destination, customerid
	 	 *  MultiSelect to Selec the Ct Number
	 	 *  Just Two Methods .  Select CT Number, Reload - Client Side
	 	 *  
	 	 */
	 	saminvctgrid.jqGrid({ 
			 url: "",
			 datatype: "json",
			 mtype: 'GET', 
			 colNames:['Sample No','Date','Po NO','Customer','Tannery','Deliver to','Desti','CDD','ADD','Handled By','For Inv'],
			 colModel:[
			           {name: 'sampleno', index:'sampleno', width:60, hidden: false, sortable: true,}, 
			           {name: 'orderdt', index:'orderdt',  width:60, hidden: false, sortable: true,},
			           {name: 'refno', index:'refno', width:110, hidden: false, sortable: true,},
			           {name: 'customer', index:'customer', width:60, hidden:true, sortable: true,},
			           {name: 'tannery', index:'tannery', width:80, hidden:false, sortable: true,},
			           {name: 'deliverid', index:'deliverid', width:80, hidden: false, sortable: true,},
			           {name: 'destination', index:'destination', width:80, hidden: false, sortable: true,},
			           {name: 'add_date', index:'add_date', width:60, hidden: false, sortable: true,},
			           {name: 'cdd_date', index:'cdd_date', width:60, hidden: false, sortable: true,},
			           {name: 'handledby', index:'handledby', width:80, hidden: false, sortable: true,},
			           {name: 'isinvraised', index:'isinvraised', width:60, hidden: true, sortable: true,},		           
			           
			          ],
			  jsonReader : {  
				       repeatitems:false,
				       root: "rows",
				       page: "page", //calls first
				       total: "total" ,//calls Second
				       records: "records", //calls Third
				       },
			   pager : '#tbl_saminvpager',
			   autoheight: true,
			   rowNum: 10, 
			   multiselect : true,
			   multiboxonly: true, // what is this ??
			   rowList:[10,20,30],	
			   sortname: 'sampleno',
			   sortorder: 'desc',  
			   height: 'automatic',	
			   //hide: false,
		       emptyrecords: 'No records to display',
		       caption  : "Select Contract From List",
		       });
	 	saminvctgrid.jqGrid('navGrid','#tbl_saminvpager',{
			add : false,
			edit: false, 
			del : false,
			view: false,
			search : false,
			reload: true		
		}).jqGrid('navButtonAdd', '#tbl_saminvpager', {
		 	   caption:"Click Here",    
		 	   buttonicon: "ui-icon-print",
		       title: "Click here to load",	 		 	   
		       onClickButton: function(){
		    	   clickheremethod();
		 		 /*var selsamnos="";
		 		 var ids = saminvctgrid.jqGrid('getGridParam','selarrrow');
		 		 for (var i=0; i<ids.length;i++){
		 		     var rowData = saminvctgrid.jqGrid('getRowData',ids[i]);
		 			 var sam = " '"+rowData.sampleno+"',";
		 			selsamnos = selsamnos+sam;
		 		   }
		 		 var itemp = selsamnos.lastIndexOf(",");
				 var samnoselc = selsamnos.substring(0, itemp);
				 alert("samnoselc"+samnoselc);
				 type = $('#saminv_includeSample').val();
				 alert("asd"+type);
				 sambillgrid.jqGrid('setGridParam',{url:"/Myelclass/sampleInvSelectCtfromCust.do?samno="+samnoselc+"&type="+type+"&action="+"loadsubgrid",page:1});
				 sambillgrid.jqGrid('setCaption',"Raise Invoice").trigger('reloadGrid');
				 saminvgrid.jqGrid('setGridParam',{url:"/Myelclass/sampleInvSelectCtfromCust.do?action="+"loadBill&samno="+samnoselc+"&type="+type ,page:1}).trigger('reloadGrid');*/
		 	   },
		 	
		});
		/* 
		 * SubGrid 1 - Load Billing Details
	 	 *  Grid 2 - Loads Data Based on the Grid 1 Selected Ct 
	 	 *  fields -samplen, articlename, color, size, substance, selection, quantity,, unit 
	 	 *  Raise Invoice for Sample 
	 	 *  Methods .  Add Bill Methods + Search ... 
	 	 * 
	 	 */
	 	sambillgrid.jqGrid({
			url:"",
			datatype: "json",
			colNames:['Status','Sample No','Art Id','Type','Article','Color','Size','Substance','Selection','Pcs','Quantity','Unit','Shipped','Balance','Rate','RDD','Comments','Reps','Feedback','Amount','Total'],
		    colModel:[
		              {name:'status', index:'status',align:'center', width :40, editable:false, sortable: true, hidden:false, search: true, 
		            	 
		              },
		              {name:'sampleno', index:'sampleno',align:'center', width :40, editable:true, sortable: true, hidden:false, search: true,
		            	  editoptions: { readonly: 'readonly' },
					  },
					  {name:'srfarticleid', index:'srfarticleid',align:'center', width :40, editable:true, sortable: true, hidden:false, search: true,
						  

					  },
					  {name:'articletype', index:'articletype',align:'center', width :60, editable:true, sortable: true, hidden:false, search: true,
						  editoptions: { readonly: 'readonly' },
					   
					  },
					  {name:'articlename', index:'articlename',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
						  editoptions: { readonly: 'readonly' }, 
					  
					  },
					  {name:'color', index:'color',align:'center', width :70, editable:true, sortable: true, hidden:false, search: true,
						  editoptions: { readonly: 'readonly' },
						
					  },
					  {name:'size', index:'size',align:'center', width :60, editable:true, sortable: true, hidden:false, search: true,
						  editoptions: { readonly: 'readonly' },
						  
					  },
					  {name:'substance', index:'substance',align:'center', width :60, editable:true, sortable: true, hidden:false, search: true,
						  editoptions: { readonly: 'readonly' },
						  
					  },
					  {name:'selection', index:'selection',align:'center', width :40, editable:true, sortable: true, hidden:false, search: true,
						  editoptions: { readonly: 'readonly' }, 
						  
					  },
					  {name:'pieces', index:'pieces',align:'center', width :40, editable:true, sortable: true, hidden:false, search: true,
						  
					  },
					  {name:'quantity', index:'quantity',align:'center', width :60, editable:true, sortable: true, hidden:false, search: true,
						  editoptions: { readonly: 'readonly' }, 
						  
						  formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, }
					  },
					  {name:'unit', index:'unit',align:'center', width :40, editable:true, sortable: true, hidden:false, search: true,
						  
					  },
					 
					  {name:'qshipped', index:'qshipped',align:'center', width :60, editable:true, sortable: true, hidden:false, search: true,
						  editrules: { required: true}, 
						  formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, },
						  edittype:'text', 
						  editoptions:{
							  dataEvents:  [{
								  type: 'focusout',
								  fn: function(e){
									  var qbals = parseFloat($("#quantity").val() - $("#qshipped").val()).toFixed(2);
									  $("#qbal").val(qbals);
									  //Rate Calculation
									  var rate = $("#rate").val();
									  var ratemp = rate.indexOf(' ');
									  var ratemplast = rate.lastIndexOf(' ');
									  var rates = rate.substring(ratemp+1, ratemplast);
									  var floatamt = parseFloat (rates * $("#qshipped").val()).toFixed(2);
									  $("#amount").val(floatamt);
								  }
							  }]
						  },
					  },
					  {name:'qbal', index:'qbal',align:'center', width :60, editable:true, sortable: true, hidden:false, search: true,

						  //editoptions: datainit 
						  formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, defaultValue: '0.00'},
						
					  },
					  {name:'rate', index:'rate',align:'center', width :70, editable:true, sortable: true, hidden:false, search: true,
						  
					  },
					  {name:'rdd', index:'rdd',align:'center', width :70, editable:false, sortable: true, hidden:false, search: true,
						  
					  },
					  {name:'comments', index:'comments',align:'center', width :70, editable:false, sortable: true, hidden:false, search: true,
						  
					  },
					  {name:'reps', index:'reps',align:'center', width :50, editable:false, sortable: true, hidden:true, search: true,
						  
					  },
					  {name:'feedback', index:'feedback',align:'center', width :50, editable:false, sortable: true, hidden:false, search: true,
						  
					  },
					  {name:'amount', index:'amount',align:'center', width :50, editable:true, sortable: true, hidden:false, search: true,
						  
						  formatter : 'number', formatoptions: {decimalSeparator:".", decimalPlaces: 2, defaultValue: '0.00'},
					  },
					  {name:'total', index:'total',align:'center', width :50, editable:true, sortable: true, hidden:true, search: true,
						  
					  },
					 
					  
		          ],
			jsonReader : {  
					repeatitems:false,
				    root: "rows",
				    page: "page", //calls first
				    total: "total" ,//calls Second
				    records: "records", //calls Third
				  }, 
			pager: '#tbl_saminvbillpager',
			rowNum:10, 
			height: 'automatic',
			rowList:[10,20,30,40],
			sortname: 'sampleno',
			sortorder: 'desc',  
			editurl: "/Myelclass/sampleInvSelectCtfromCust.do?action="+"addBill",
			emptyrecords: 'No records to display',
			grouping:true, 
	        groupingView : { 
	            groupField : ['sampleno'],
	            groupOrder : ['desc'] 
	        },
	        loadComplete: function () {
	        
	        }
		});		
	 	sambillgrid.jqGrid('navGrid','#tbl_saminvbillpager',{
			add : true, addCaption :"Raise Bill",
			edit: false,
			del : false, 
			view: false, 
			search : false, 
			reload: false}, 
			{},
			{
				/*
				 * Add Method 
				 */
				closeAfterAdd: true,
				reloadAfterSubmit: true,
				beforeInitData : function(formid) {
					var rowid = sambillgrid.jqGrid('getGridParam', 'selrow');
		         	if (rowid === null) {
		           		alert('Please select row ');
		           		return false;
					}else{	
						return true;
					}
				},
				//Add 
				beforeShowForm : function(formID){
				
					var selRowData;
					var rowids = sambillgrid.jqGrid('getGridParam', 'selrow');
			           	selRowData = sambillgrid.jqGrid('getRowData', rowids);
			            $('#' + 'sampleno' + '.FormElement', formID).val(selRowData.sampleno);
			            $('#' + 'articletype' + '.FormElement', formID).val(selRowData.articletype);
			            $('#' + 'srfarticleid' + '.FormElement', formID).val(selRowData.srfarticleid);
			            $('#' + 'articlename' + '.FormElement', formID).val(selRowData.articlename);
			            $('#' + 'color' + '.FormElement', formID).val(selRowData.color);
			            $('#' + 'size' + '.FormElement', formID).val(selRowData.size);
			            $('#' + 'substance' + '.FormElement', formID).val(selRowData.substance);
			            $('#' + 'selection' + '.FormElement', formID).val(selRowData.selection);
			            $('#' + 'quantity' + '.FormElement', formID).val(selRowData.quantity);
			            $('#' + 'unit' + '.FormElement', formID).val(selRowData.unit);
			            $('#' + 'pieces' + '.FormElement', formID).val(selRowData.pieces);
			            $('#' + 'rate' + '.FormElement', formID).val(selRowData.rate);
			            $('#' + 'qshipped' + '.FormElement', formID).val(" "); 
			            $('#' + 'qbal' + '.FormElement', formID).val(selRowData.qbal);
			            $('#' + 'amount' + '.FormElement', formID).val(selRowData.amount);
			            $('#' + 'total' + '.FormElement', formID).val(selRowData.total);
			            $('#' + 'tc' + '.FormElement', formID).val(selRowData.tc);
			            $('#' + 'articleid' + '.FormElement', formID).val(selRowData.articleid);
			            $('#' + 'prfarticleid' + '.FormElement', formID).val(selRowData.prfarticleid);
			            
				}, 
				/*
				 * Add Parameter 
				 */
			editData : {
				saminvoiceno: function() {
                    var saminvno = $('#saminv_invoiceno').val();
                    return saminvno;
                 },
				saminvoicetype: function() {
                    var saminvtyp = $('#saminv_invoicetype').val();
                    return saminvtyp;
                 },
				saminvoicedt: function() {
                    var saminvdt = $('#saminv_invdate').val();
                     return saminvdt;
                 },
			},
			afterSubmit: function (response, postdata) {
				/*var saminvno = $('#saminv_invoiceno').val();
				var samno = $("#sampleno").val();
				samno = "'"+samno+"'";
				sambillgrid.jqGrid('setGridParam',{url:"/Myelclass/sampleInvSelectCtfromCust.do?action="+"loadBill&saminvno="+saminvno+"&samno="+samno ,page:1}).trigger('reloadGrid');*/
				 clickheremethod();
				if(response.responseText != ""){
					return [true,"Success"];
                }else{
                    return [false,"Error"];
                }
			},
		});
	 
	 	/* 
		 * SubGrid 2 - Show Billed Contracts 
	 	 *  Grid 3 - Loads Raised Invoice based on the Grid 2 Raised Bills
	 	 *  fields -contractno, articlename, color, size, substance, selection, quantity,, unit 
	 	 *  Raise Invoice for Ct + Old Cts 
	 	 *  Methods .  Crud Methods + Search ... 
	 	 */
	 	saminvgrid.jqGrid({
			 url:"",
			 datatype: "json",
			 colNames:['Inv Id','Inv No','InvDt','articleid','Ct No','Article','Color','Size','Substance','Selection','Unit','Quantity','Pcs','Rate','Q Shipped','Q Balance','amount'],
			 colModel:[
			           	{name: 'invid', index:'invid',align:'center', width :80, editable:true, sortable: true, hidden:true, search: true,
			           		editoptions: { readonly: 'readonly' },
			           	},
						{name: 'invno', index:'invno',align:'center', width :80, editable:true, sortable: true, hidden:true, search: true,
			           		editoptions: { readonly: 'readonly' },
						},
						{name: 'invdt', index:'invdt',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							editoptions: { readonly: 'readonly' },
						},
						{name: 'invartid', index:'invartid',align:'center', width :80, editable:true, sortable: true, hidden:true, search: true,
							editoptions: { readonly: 'readonly' },
						},
						{name: 'invctno', index:'invctno',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							editoptions: { readonly: 'readonly' },
						},
						{name: 'invartname', index:'invartname',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							editoptions: { readonly: 'readonly' },
						},
						{name: 'invcolor', index:'invcolor',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							editoptions: { readonly: 'readonly' },
						},
						{name: 'invsize', index:'invsize',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							editoptions: { readonly: 'readonly' },
						},
						{name: 'invsubs', index:'invsubs',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							editoptions: { readonly: 'readonly' },
						},
						{name: 'invselc', index:'invselc',align:'center', width :80, editable:true, sortable: true, hidden:true, search: true,
							editoptions: { readonly: 'readonly' },
						},
						{name: 'invunit', index:'invunit',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							editoptions: { readonly: 'readonly' },
						},
						{name: 'invqty', index:'invqty',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							editoptions: { readonly: 'readonly' },
							formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, },
						},
						{name: 'invpcs', index:'invpcs',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							editoptions: { readonly: 'readonly' },
						},
						{name: 'invrate', index:'invrate',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							
						},
						{name: 'invqshpd',  index:'invqshpd',sortable:true, editable: true, width:70,
							formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, },
							edittype:'text',   editrules: { required: true}, 
						},
						{name: 'invqbal', index:'qbal',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, },
							edittype: 'text', 
							editoptions:{
							 	dataEvents:  [{
									type: 'focusout',
									fn: function(e){
										alert("IS this Edit BILL Calculation"+billInvisInEdit);
										if(billInvisInEdit){
											alert( "WTH"+$("#invqbal").val());
											//Code for Edit Form Qty Calculation 
											 var invqbal = parseFloat($("#invqbal").val() - $("#invqshpd").val());
											 var qbals = invqbal.toFixed(2);
											 alert(qbals+"Qbalance.. ");
											 $("#invqbal").val(qbals);
											 //Rate Calculation
											 var rate = $("#invrate").val();
											 alert(rate);
											 var ratemp = rate.indexOf(' ');
											 var ratemplast = rate.lastIndexOf(' ');
											 var rates = rate.substring(ratemp+1, ratemplast);
											// alert(rates);
											 var amt = parseFloat (rates * $("#invqshpd").val()).toFixed(2);
											 $("#invamt").val(amt);
										 }else{
											 var invqbal = parseFloat($("#invqbal").val() - $("#invqshpd").val()).toFixed(2);
											 alert(invqbal);
											 $("#invqbal").val(invqbal);
											 var rate = $("#invrate").val();
											 var ratemp = rate.indexOf(' ');
											 var ratemplast = rate.lastIndexOf(' ');
											 var rates = rate.substring(ratemp+1, ratemplast);
											 var amt = parseFloat (rates * $("#invqshpd").val()).toFixed(2);
											 $("#invamt").val(amt);
											 
										 }
									}
								}]
							},		
						},
						{name: 'invamt', index:'amt',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, },	
						},
					  ],
			 jsonReader : {  
				   repeatitems:false,
			       root: "rows",
			       page: "page", //calls first
			       total: "total" ,//calls Second
			       records: "records", //calls Third
					}, 
			pager: '#saminvbillpager',
			rowNum: 20, 
			multiselect : false,
			rowList:[10,20,30],	  
			sortname: 'invno',
			sortorder: 'desc',  
			height: 'automatic',
			emptyrecords: 'No records to display',
			editurl: "/Myelclass/sampleInvSelectCtfromCust.do?action="+"loadBill",
			grouping:true, 
			footerrow: true, 
			userDataOnFooter : true,
			groupingView : { 
	            groupField : ['invno'],
	            groupOrder : ['desc'] 
	        },
	        loadComplete: function () {
	        	
	            var $self = $(this);
	            var qshpdsum = $self.jqGrid("getCol", "invqshpd", false, "sum");
	            var amtsum 	 = $self.jqGrid("getCol", "invamt", false, "sum");
	            $self.jqGrid("footerData", "set", { invqshpd: qshpdsum});
	            $self.jqGrid("footerData", "set", { invamt: amtsum});
	           $("#saminv_total").val(amtsum);
	           
	        }
		 });
	 	
	 	saminvgrid.jqGrid('navGrid','#saminvbillpager',{
				add : true,
				edit: true, 
				del : true,
				view: true,
				search : true,
				reload: true},
				{	
					/*
					 * Edit Method 
					 */
					recreateForm: true,
					closeAfterEdit: true,
					reloadAfterSubmit: true,
					beforeInitData: function ()
					{
						alert(" In B4 Init EDITTTT"+billInvisInEdit);
						billInvisInEdit = true;
					},
					beforeShowForm : function(formID){
						$('#tr_invid').hide();
						$('#tr_invno').hide();
						$('#tr_invdt').hide();
						$('#tr_invartid').hide();
						$('#tr_invtc').hide();
						
						var invqbal = parseFloat( $("#invqshpd").val()) + parseFloat ($("#invqbal").val() );
						var qbals = invqbal.toFixed(2);
						alert(qbals+"Qbalance.. ");
						$("#invqbal").val(qbals);
						$('#invqshpd').val("");
					}
				},
			   /*
				* Remove Add Button - Bcos Qty Bal Calculates wrong
				*/
				{
					
					// * Add BIll 
					recreateForm: true,
					closeAfterAdd: true,
					reloadAfterSubmit: true,
					//Add 
					beforeInitData: function ()
					{
						alert(" In B4 Init ADDD"+billInvisInEdit);
						billInvisInEdit = false;
					},
					beforeShowForm : function(formID){
						 $("#invno").val($("#saminv_invoiceno").val());
						 $("#invdt").val($("#saminv_invdate").val());
						 $('#tr_invid').hide();
						 $('#tr_invtc').hide();
						
						var selRowData;
						var rowid = saminvgrid.jqGrid('getGridParam', 'selrow');
			           	if (rowid === null) {
			             alert('Please select row');
			             return;
						}
			           	selRowData = saminvgrid.jqGrid('getRowData', rowid);
			           	alert(selRowData.invno);
			           	$('#' + 'invctno' + '.FormElement', formID).val(selRowData.invctno);
			         	$('#' + 'invartid' + '.FormElement', formID).val(selRowData.invartid);
			            $('#' + 'invartname' + '.FormElement', formID).val(selRowData.invartname);
			            $('#' + 'invcolor' + '.FormElement', formID).val(selRowData.invcolor);
			            $('#' + 'invsize' + '.FormElement', formID).val(selRowData.invsize);
			            $('#' + 'invsubs' + '.FormElement', formID).val(selRowData.invsubs);
			            $('#' + 'invselc' + '.FormElement', formID).val(selRowData.invselc);
			            $('#' + 'invunit' + '.FormElement', formID).val(selRowData.invunit);
			            $('#' + 'invqty' + '.FormElement', formID).val(selRowData.invqty); 
			            $('#' + 'invpcs' + '.FormElement', formID).val(selRowData.invpcs);
			            $('#' + 'invrate' + '.FormElement', formID).val(selRowData.invrate);
			            $('#' + 'invqshpd' + '.FormElement', formID).val("0.00");
			            $('#' + 'invqbal' + '.FormElement', formID).val(selRowData.invqbal);
			            $('#' + 'invamt' + '.FormElement', formID).val(selRowData.invamt);
			           // $('#' + 'prfarticleid' + '.FormElement', formID).val(selRowData.prfarticleid);
				    }, 							
				},
				{
					delData: {
						//Function to Add parameters to the delete 
						//Here i am passing invid with val 
						invid: function() {
                             var sel_id = saminvgrid.jqGrid('getGridParam', 'selrow');
                             var value = saminvgrid.jqGrid('getCell', sel_id, 'invid');
                             return value;
                        },
                        invqty: function() {
		                    var sel_id = saminvgrid.jqGrid('getGridParam', 'selrow');
		                    var value = saminvgrid.jqGrid('getCell', sel_id, 'invqty');
		                    return value;
		                },
		                invqbal: function() {
			                    var sel_id = saminvgrid.jqGrid('getGridParam', 'selrow');
			                    var value = saminvgrid.jqGrid('getCell', sel_id, 'invqbal');
			                    return value;
			            },
			            invqshpd: function() {
		                    var sel_id = saminvgrid.jqGrid('getGridParam', 'selrow');
		                    var value = saminvgrid.jqGrid('getCell', sel_id, 'invqshpd');
		                    return value;
			            },
			            invctno: function() {
		                    var sel_id = saminvgrid.jqGrid('getGridParam', 'selrow');
		                    var value = saminvgrid.jqGrid('getCell', sel_id, 'invctno');
		                    return value;
			            },
			            invartid: function() {
		                    var sel_id = saminvgrid.jqGrid('getGridParam', 'selrow');
		                    var value = saminvgrid.jqGrid('getCell', sel_id, 'invartid');
		                    return value;
			            },
                    },
					reloadAfterSubmit: true,				
				},
				{},
				{}
			);
});