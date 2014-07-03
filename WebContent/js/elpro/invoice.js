/**
 * Inv js
 * 11.10.13
 */

$(document).ready(function() {
	$("#inv_total").focusout(function() {
		var totamt = (parseFloat ($("#inv_total").val()) - parseFloat ($("#inv_discount").val())) + parseFloat ($("#othercharges").val());		
		$("#inv_total").val(totamt);
	});
	
	
	var billInvisInEdit = false; //boolean value need to Check High Priority 
	var type =null;//get whether the inv for only ct or sample included
	 //Radiio Box Chercked b
	$("#inv_vatcst").click(function() { 
		var val = "";
		val= $('input[type="radio"]:checked').val();
		});
	
	// Invoice Type
	$("#inv_invoicetype").change(function() {
		var str = "" ;
		 $("#inv_invoicetype option:selected" ).each(function() {
			str = "" ;
			str = $(this).text();
			//str += $( this ).text() + " ";
			/*
			 * Ajax Call for Invoice no Based on Invoice Type 
			 */
			$.ajax({
				url: "/Myelclass/InvAutocomplete.do",
				type: "GET",
				async: true,
				dataType: "text",
				data: { term: str, action: "invtype" },
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success: function (data) {
					if($("#invactionform").val().toLowerCase() == "add" ){		
						console.log("success"+data);
		                $("#inv_invoiceno").val(data);
					}
	            }, 
	            error: function (data) {
	                console.log("error");
	            } 
		});
			
		});
		 $("#dv_invtype").text(str);
			/*if(str == "IC-Local"){
				alert(str+"1");
				$("#invnotify").hide();
				$("#invbuyer").hide();
				$("#invbank").hide();
				$("#inv_ctryoforigngoods").hide();
				$("#inv_ctryoffinaldesti").hide();
				$("#inv_dischargeport").hide();
				$("#inv_vesselno").hide();
				$("#inv_precarriageby").hide();
				$("#inv_precarriageby").hide();
				$("#inv_marksno").hide();
				$("#invbank").hide();
				$("#inv_courierchrgs").hide();
				$("#inv_discount").hide();
				$("#inv_deduction").hide();
			}else if (str == "IC-Exports"){
				alert(str+"2");
				$("#invnotify").show();
				$("#invbuyer").show();
				$("#invbank").show();
				$("#inv_ctryoforigngoods").show();
				$("#inv_ctryoffinaldesti").show();
				$("#inv_dischargeport").show();
				$("#inv_vesselno").show();
				$("#inv_precarriageby").show();
				$("#inv_precarriageby").show();
				$("#inv_marksno").show();
				$("#invbank").show();
				$("#inv_courierchrgs").show();
				$("#inv_discount").show();
				$("#inv_deduction").show();
			}else{
				$("#invnotify").show();
				$("#invbuyer").show();
				$("#invbank").show();
				$("#inv_ctryoforigngoods").show();
				$("#inv_ctryoffinaldesti").show();
				$("#inv_dischargeport").show();
				$("#inv_vesselno").show();
				$("#inv_precarriageby").show();
				$("#inv_precarriageby").show();
				$("#inv_marksno").show();
				$("#invbank").show();
				$("#inv_courierchrgs").show();
				$("#inv_discount").show();
				$("#inv_deduction").show();
			}*/
		 }).trigger("change");
	
	
	var invgrid = $("#invBill");
	var billgrid = $("#tbl_invaddinvBill");
	var invctgrid = $("#tbl_invListCustomerContract"); 
	
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
		          	// var custname = ui.item.label;
		          	 var custid = ui.item.id;
		          	 //Load First Grid Based On Selected Value
		          	type = $('#inv_includeSample').val();
		          	invctgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?custid="+custid+"&type="+type+"&action="+"load"}).trigger("reloadGrid");				 
				 },
				 change: function(event,ui){
			    	 $(this).val((ui.item ? ui.item.value : ""));
			   }
		  	 });
		 function clickheremethod(){
			 var selctnos="";
		 		 var ids = invctgrid.jqGrid('getGridParam','selarrrow');
		 		 for (var i=0; i<ids.length;i++){
		 		     var rowData = invctgrid.jqGrid('getRowData',ids[i]);
		 			 var ctno = " '"+rowData.ctno+"',";
		 			 selctnos = selctnos+ctno;
		 		   }
		 		 var itemp =selctnos.lastIndexOf(",");
			 var ctnoselc = selctnos.substring(0, itemp);
			 type = $('#inv_includeSample').val();
				 billgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?ctno="+ctnoselc+"&type="+type+"&action="+"loadsubgrid",page:1});
				 billgrid.jqGrid('setCaption',"Raise Invoice").trigger('reloadGrid');
				 invgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?action="+"loadBill&ctno="+ctnoselc+"&type="+type ,page:1}).trigger('reloadGrid');
		 }

		 	/*
		 	 * Grid 1 - Loads Data Based on the Customer Selected Value
		 	 *  fields -ctno, orderdt, pono, cdd_date, add_date, destination, customerid
		 	 *  MultiSelect to Selec the Ct Number
		 	 *  Just Two Methods .  Select CT Number, Reload - Client Side
		 	 *  
		 	 */
			 invctgrid.jqGrid({ 
				 url: "",
				 datatype: "json",
				 loadonce: false,
				 mtype: 'GET', 
				 colNames:['Ct No','Date','Po NO','Customer','Tannery','Consignee','Desti','CDD','ADD','Commission','Other Commi'],
				 colModel:[
				           {
				        	   name: 'ctno', index:'ctno', width :42, hidden:false, sortable: true,
				           }, 
				           {
				        	   name: 'orderdt', index:'orderdt', width :65, hidden:false, sortable: true,
				           },
				           {
				        	   name: 'pono', index:'pono', width :150, hidden:false, sortable: true,
				           },
				           {
				        	   name: 'customer', index:'customer', hidden:true, sortable:false,
				           },
				           {
				        	   name: 'tannery', index:'tannery', hidden:true, sortable:false,
				           },
				           {
				        	   name: 'consignee', index:'consignee', hidden: true, sortable:false,
				           },
				           {
				        	   name: 'destination', index:'destination', width :80, hidden:false, sortable: true,
				           },
				           {
				        	   name: 'cdd_date', index:'cdd_date', width :80, hidden:false, sortable: true,
				           },
				           {
				        	   name: 'add_date', index:'add_date',width :65, hidden:false, sortable: true,
				           },
				           {
				        	   name: 'commission', index:'commission',width :65, hidden:false, sortable: true,
				           },
				           {
				        	   name: 'othercommission', index:'othercommission',width :140, hidden:false, sortable: true,
				           },
				          ],
				  jsonReader : {  
					       repeatitems:false,
					       root: "rows",
					       page: "page", //calls first
					       total: "total" ,//calls Second
					       records: "records", //calls Third
					       },
				   caption  : "Contract / Sample List To Raise Invoice",
				   loadtext: "List is Loading",
				   pager : '#tbl_invpager',
				   rowNum: 20,
				   rowList: [10,20,50,100,200,500],
				   rownumbers: true, 
				   height : "200",
				   width: "auto",
				   sortname: 'Ctno',
				   sortorder: 'desc',
				   ignoreCase:true,
				   hidegrid: false,
				   multiselect : true,
				   multiboxonly: true, // Works with multiselec true. enables checkbox by simply clicking the row
				   sortable: true,
				   gridview : true,
				   viewrecords: true,
				   altRows: true,
			       emptyrecords: 'No records to display',		       
			       });
			invctgrid.jqGrid('navGrid','#tbl_invpager',{
				add : false,
				edit: false, 
				del : false,
				view: true,
				search : false,
				reload: true,
				addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View',
			}).jqGrid('navButtonAdd', '#tbl_invpager', {
	 		 	   caption:"Click Here",    
	 		 	   buttonicon: "ui-icon-circle-arrow-s",
	 		       title: "Click here to load",	 		 	   
	 		       onClickButton: function(){
	 		    	  clickheremethod();
	 		 	 },
	 		 	
			});
			billgrid.jqGrid({
				url:"",
				datatype: "json",
				colNames:['Status','Ct No','Art Id','Type','Article','Color','Size','Substance','Selection','Pcs','Quantity','Unit','Shipped','Balance','Rate','RDD','Comments','Reps','Feedback','Amount','Total','TC', 'Comm','Other Comm', 'User'],
			    colModel:[
			              {name:'status', index:'status',align:'center', width :40, editable:false, sortable: true, hidden:false, search: true, 
			            	 
			              },
			              {name:'contractno', index:'contractno',align:'center', width :40, editable:true, sortable: true, hidden:false, search: true,
			            	  editoptions: { readonly: 'readonly' },
						  },
						  {name:'prfarticleid', index:'prfarticleid',align:'center', width :40, editable:true, sortable: true, hidden:true, search: true,
							  

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
						  {name:'feedback', index:'feedback',align:'center', width :100, editable:false, sortable: true, hidden:false, search: true,
							  
						  },
						  {name:'amount', index:'amount',align:'center', width :50, editable:true, sortable: true, hidden: false, search: true,
							  
							  formatter : 'number', formatoptions: {decimalSeparator:".", decimalPlaces: 2, defaultValue: '0.00'},
						  },
						  {name:'total', index:'total',align:'center', width :50, editable:true, sortable: true, hidden:true, search: true,
							  
						  },
						  {name:'tc', index:'tc',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							 
						  },
						  {name:'commission', index:'commission',align:'center', width :80, editable:true, sortable: true, hidden:true, search: true,
								 
						  },
						  {name:'othercommission', index:'othercommission',align:'center', width :80, editable:true, sortable: true, hidden:true, search: true,
								 
						  },
						  {name:'user', index:'user',align:'center', width :80, editable:true, sortable: true, hidden: true, search: true,
							  editoptions: { readonly: 'readonly' },
						  },
						  
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
				height: 'automatic',
				rowList:[10,20,30,40],	       
				sortorder: 'desc',  
				editurl: "/Myelclass/InvSelectCtfromCust.do?action="+"addBill",
				emptyrecords: 'No records to display',
				grouping:true, 
		        groupingView : { 
		            groupField : ['contractno'],
		            groupOrder : ['desc'] 
		        },
			});
			billgrid.jqGrid('navGrid','#tbl_invbillpager',{
				add : true, addCaption :"Raise Bill", edit: false, del : false, view: false, search : false, reload: false,
				addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View'
			}, 
			{},
			{
				/*
				 * Add Method 
				 */
				closeAfterAdd: true,
				reloadAfterSubmit: true,
				beforeInitData : function(formid) {
					var rowid = billgrid.jqGrid('getGridParam', 'selrow');
		         	if (rowid === null) {
		           		alert('Please select row ');
		           		return false;
					}else{	
						return true;
					}
				},
				//Add 
				beforeShowForm : function(formID){
					$("#user").val( $("#userinsession").val());
					$('#tr_tc').hide();
					$('#tr_user').show();
					var selRowData;
					var rowids = billgrid.jqGrid('getGridParam', 'selrow');
			           	selRowData = billgrid.jqGrid('getRowData', rowids);
			            $('#' + 'contractno' + '.FormElement', formID).val(selRowData.contractno);
			            $('#' + 'articletype' + '.FormElement', formID).val(selRowData.articletype);
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
			            $('#' + 'commission' + '.FormElement', formID).val(selRowData.commission);
			            $('#' + 'othercommission' + '.FormElement', formID).val(selRowData.othercommission);
			            $('#' + 'articleid' + '.FormElement', formID).val(selRowData.articleid);
			            $('#' + 'prfarticleid' + '.FormElement', formID).val(selRowData.prfarticleid);	            
				}, 
				/*
				 * Add Parameter 
				 */
			  editData : {
				invoiceno: function() {
	                var invno = $('#inv_invoiceno').val();
	                return invno;
	             },
				invoicetype: function() {
	                var invtyp = $('#inv_invoicetype').val();
	                return invtyp;
	             },
				invoicedt: function() {
	                var invdt = $('#inv_invdate').val();
	                 return invdt;
	             },
			  },
			  afterSubmit: function (response, postdata) {
				/*var invno = $('#inv_invoiceno').val();
				var ctno = $("#contractno").val();
				ctno = "'"+ctno+"'";
				invgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?action="+"loadBill&invno="+invno+"&ctno="+ctno ,page:1}).trigger('reloadGrid');
				*/
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
			
				 invgrid.jqGrid({
					 url:"",
					 datatype: "json",
					 colNames:['Inv Id','Inv No','InvDt','articleid','Ct No','Article','Color','Size','Sub','Sel','Quantity','Unit','Pcs','Rate','TC','Shipped','Balance','amount','Comm','Other Comm','User' ],
					 colModel:[
					           	{name: 'invid', index:'invid',align:'center', width :80, editable:true, sortable: true, hidden:true, search: true,
					           		editoptions: { readonly: 'readonly' },
					           	},
								{name: 'invno', index:'invno',align:'center', width :80, editable:true, sortable: true, hidden:true, search: true,
					           		editoptions: { readonly: 'readonly' },
								},
								{name: 'invdt', index:'invdt',align:'center', width :60, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invartid', index:'invartid',align:'center', width :60, editable:true, sortable: true, hidden:true, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invctno', index:'invctno',align:'center', width :50, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invartname', index:'invartname',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invcolor', index:'invcolor',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invsize', index:'invsize',align:'center', width :50, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invsubs', index:'invsubs',align:'center', width :60, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invselc', index:'invselc',align:'center', width :40, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invqty', index:'invqty',align:'right', width :70, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
									formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, },
								},
								{name: 'invunit', index:'invunit',align:'center', width :40, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								
								{name: 'invpcs', index:'invpcs',align:'center', width :40, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invrate', index:'invrate',align:'right', width :80, editable:true, sortable: true, hidden:false, search: true,
									
								},
								{name: 'invtc', index:'invtc',align:'center', width :80, editable:true, sortable: true, hidden:true, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invqshpd', index:'invqshpd',align:'right', sortable:true, editable: true, width:70,
									formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, },
									edittype:'text',   editrules: { required: true}, 
								},
								{name: 'invqbal', index:'qbal', align:'right', width :80, editable:true, sortable: true, hidden:false, search: true,
									formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, },
									edittype: 'text', 
									editoptions:{
									 	dataEvents:  [{
											type: 'focusout',
											fn: function(e){
												if(billInvisInEdit){
													//Code for Edit Form Qty Calculation 
													 var invqbal = parseFloat($("#invqbal").val() - $("#invqshpd").val());
													 var qbals = invqbal.toFixed(2);
													
													 $("#invqbal").val(qbals);
													 //Rate Calculation
													 var rate = $("#invrate").val();
													 
													 var ratemp = rate.indexOf(' ');
													 var ratemplast = rate.lastIndexOf(' ');
													 var rates = rate.substring(ratemp+1, ratemplast);
													// alert(rates);
													 var amt = parseFloat (rates * $("#invqshpd").val()).toFixed(2);
													 $("#invamt").val(amt);
												 }else{
													 var invqbal = parseFloat($("#invqbal").val() - $("#invqshpd").val()).toFixed(2);													 
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
								{name: 'invamt', index:'amt',align:'right', width :80, editable:true, sortable: true, hidden:false, search: true,
									formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, },	
								},
								{name:'invcomm', index:'invcomm',align:'center', width :80, editable:true, sortable: true, hidden: false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name:'invothercomm', index:'invothercomm',align:'center', width :80, editable:true, sortable: true, hidden: false, search: true,
									editoptions: { readonly: 'readonly' },	 
								},
								{name:'user', index:'invuser',align:'center', width :80, editable:true, sortable: true, hidden: true, search: true,
								  editoptions: { readonly: 'readonly' },
								},
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
					sortname: 'invno',
					sortorder: 'desc',  
					height: 'automatic',
					emptyrecords: 'No records to display',
					editurl: "/Myelclass/InvSelectCtfromCust.do?action="+"loadBill",
					grouping:true, 
					footerrow: true, //footer row Enabled
					userDataOnFooter : true,
					groupingView : { 
			            groupField : ['invno'],
			            groupOrder : ['desc'] 
			        },
			        loadComplete: function () {	 
			        	//Need to Provice a Clear Solution here 
			        	
			        	/*alert ("hi "+$('#inv_invoiceno').val());
				        var $self = $(this);
			            var qshpdsum = $self.jqGrid("getCol", "invqshpd", false, "sum");
			            var amtsum 	 = $self.jqGrid("getCol", "invamt", false, "sum");
			            $self.jqGrid("footerData", "set", { invqshpd: qshpdsum});
			            $self.jqGrid("footerData", "set", { invamt: amtsum});
			           $("#inv_total").val(amtsum);*/
			        }
				 });			
				 invgrid.jqGrid('navGrid','#invbillpager',{
						add : true,
						edit: true, 
						del : true,
						view: true,
						search : true,
						reload: true,
						addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload', viewtext: 'View'		
				 },
						{	
							/*
							 * Edit Method 
							 */
							recreateForm: true,
							closeAfterEdit: true,
							reloadAfterSubmit: true,
							beforeInitData: function ()
							{
								
								billInvisInEdit = true;
							},
							beforeShowForm : function(formID){
								$('#tr_invid').hide();
								$('#tr_invno').hide();
								$('#tr_invdt').hide();
								$('#tr_invartid').hide();
								$('#tr_invtc').hide();
								$("#invuser").val( $("#userinsession").val());
								$('#tr_invuser').show();
								
								var invqbal = parseFloat( $("#invqshpd").val()) + parseFloat ($("#invqbal").val() );
								var qbals = invqbal.toFixed(2);
								
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
								
								billInvisInEdit = false;
							},
							beforeShowForm : function(formID){
								 $("#invno").val($("#inv_invoiceno").val());
								 $("#invdt").val($("#inv_invdate").val());
								 $('#tr_invid').hide();
								 $("#user").val( $("#userinsession").val());
								 $('#tr_user').show();
								 $('#tr_invtc').hide();
								
								var selRowData;
								var rowid = invgrid.jqGrid('getGridParam', 'selrow');
					           	if (rowid === null) {
					             alert('Please select row');
					             return;
								}
					           	selRowData = invgrid.jqGrid('getRowData', rowid);
					           	
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
					            $('#' + 'invtc' + '.FormElement', formID).val(selRowData.invtc);
					            $('#' + 'invqshpd' + '.FormElement', formID).val("0.00");
					            $('#' + 'invqbal' + '.FormElement', formID).val(selRowData.invqbal);
					            $('#' + 'invamt' + '.FormElement', formID).val(selRowData.invamt);
					            $('#' + 'invcomm' + '.FormElement', formID).val(selRowData.invcomm);
					            $('#' + 'invothercomm' + '.FormElement', formID).val(selRowData.invothercomm);
					            $('#' + 'user' + '.FormElement', formID).val(selRowData.user);
					            
					           // $('#' + 'prfarticleid' + '.FormElement', formID).val(selRowData.prfarticleid);
						    }, 							
						},
						{
							delData: {
								//Function to Add parameters to the delete 
								//Here i am passing artid with val 
								invid: function() {
		                             var sel_id = invgrid.jqGrid('getGridParam', 'selrow');
		                             var value = invgrid.jqGrid('getCell', sel_id, 'invid');
		                             return value;
		                        },
		                        invqty: function() {
				                    var sel_id = invgrid.jqGrid('getGridParam', 'selrow');
				                    var value = invgrid.jqGrid('getCell', sel_id, 'invqty');
				                    return value;
				                },
				                invqbal: function() {
					                    var sel_id = invgrid.jqGrid('getGridParam', 'selrow');
					                    var value = invgrid.jqGrid('getCell', sel_id, 'invqbal');
					                    return value;
					            },
					            invqshpd: function() {
				                    var sel_id = invgrid.jqGrid('getGridParam', 'selrow');
				                    var value = invgrid.jqGrid('getCell', sel_id, 'invqshpd');
				                    return value;
					            },
					            invctno: function() {
				                    var sel_id = invgrid.jqGrid('getGridParam', 'selrow');
				                    var value = invgrid.jqGrid('getCell', sel_id, 'invctno');
				                    return value;
					            },
					            invartid: function() {
				                    var sel_id = invgrid.jqGrid('getGridParam', 'selrow');
				                    var value = invgrid.jqGrid('getCell', sel_id, 'invartid');
				                    return value;
					            },
							},
							reloadAfterSubmit: true,
							
						},{},
						 {
							// In View Grid
							
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
		                    id: item.bankId,
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
		          	  $('#inv_bankid').val(ui.item.id);
				},
				 change: function(event,ui){
			    	 $(this).val((ui.item ? ui.item.value : ""));
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
		                	id:  item.notifyConsigneeId,
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
		          	  $('#inv_notifyid').val(ui.item.id);        	
				},
				 change: function(event,ui){
			    	 $(this).val((ui.item ? ui.item.value : ""));
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
		                	ref: item.expref,
		                	label : item.expname,
		                	value: item.expname,
		                    addr: item.expaddr,
		                    fone: item.expphone,	
		                    attn : item.expattn,
		                    fax: item.expfax,
		                    id: item.expid,
		                    };
		                 }));//END Response	
					});//End getJSon
				},
				select: function( event, ui ) { 
		          	  $('#inv_exporteraddress').val(ui.item.addr);
		          	  $('#inv_exportertele').val(ui.item.fone);
		          	  $('#inv_exporterattn').val(ui.item.attn);
		          	  $('#inv_exporterfax').val(ui.item.fax);
		              $('#inv_expref').val(ui.item.ref);
		              $('#inv_exporterid').val(ui.item.id);
				 },
				 change: function(event,ui){
			    	 $(this).val((ui.item ? ui.item.value : ""));
				 }
		  	    });
		
		$('#inv_ctryoforigngoods').autocomplete({
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
			 change: function(event,ui){
		    	 $(this).val((ui.item ? ui.item.value : ""));
			 },
			});
		
		$('#inv_loadingport').autocomplete({
			 source: function(request, response) {
				var param = request.term;  
				var ctryval = $('#inv_ctryoforigngoods').val();
				$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"loadport&ctryval="+ctryval,
					function(result) { 	
				       response($.map(result, function(item) {
				           return { 
				              value: item.destiname,
				              };
				        }));//END response
				 });
			 },
			 change: function(event,ui){
		    	 $(this).val((ui.item ? ui.item.value : ""));
		   }
		});
		$('#inv_ctryoffinaldesti').autocomplete({
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
			 },
			 change: function(event,ui){
		    	 $(this).val((ui.item ? ui.item.value : ""));
		   }
		});
		$('.autocmplet').autocomplete({
			 source: function(request, response) {
				var param = request.term;  
				var destictryval = $('#inv_ctryoffinaldesti').val();
				$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"destiport&destictryval="+destictryval,
					function(result) { 	
				       response($.map(result, function(item) {
				           return { 
				              value: item.destiname,
				              };
				        }));//END response
				 });
			 },
			 change: function(event,ui){
		    	 $(this).val((ui.item ? ui.item.value : ""));
		   }
		});
		$('#inv_terms').autocomplete({
			 source: function(request, response) {
				var param = request.term;  
				$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"terms",
					function(result) { 	
				       response($.map(result, function(item) {
				           return { 
				              value: item.termname,
				              };
				        }));//END response
				 });
			 },
			 change: function(event,ui){
		    	 $(this).val((ui.item ? ui.item.value : ""));
		   }
		});
		$('#inv_payment').autocomplete({
			 source: function(request, response) {
				var param = request.term;  
				$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"payment",
					function(result) { 	
				       response($.map(result, function(item) {
				           return { 
				              value: item.paymentname,
				              };
				        }));//END response
				 });
			 },
			 change: function(event,ui){
		    	 $(this).val((ui.item ? ui.item.value : ""));
		   }
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
		
			
	});