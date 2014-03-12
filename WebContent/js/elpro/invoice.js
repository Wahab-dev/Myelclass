/**
 * Inv js
 * 11.10.13
 */

$(document).ready(function() {
	var billInvisInEdit = null ; //boolean value need to Check High Priority 
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
	                console.log("success"+data);
	                $("#inv_invoiceno").val(data);
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
	//var invsamplegrid = $("#tbl_invListCustomerSample"); 
		 
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
		          	 var custname = ui.item.label;
		          	 //Load First Grid Based On Selected Value
		          	type = $('#inv_includeSample').val();
					alert("asd"+type);
		          	invctgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?custname="+custname+"&type="+type+"&action="+"load"}).trigger("reloadGrid");				 
				    }
		  	 });
		 
		 
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
				           {name: 'ctno', index:'ctno',hidden: false, sortable: true,}, 
				           {name: 'orderdt', index:'orderdt', hidden: false, sortable: true,},
				           {name: 'pono', index:'pono',hidden: false, sortable: true,},
				           {name: 'customer', index:'customer',hidden:true, sortable: true,},
				           {name: 'tannery', index:'tannery',hidden:true, sortable: true,},
				           {name: 'consignee', index:'consignee',hidden: false, sortable: true,},
				           {name: 'destination', index:'destination',hidden: false, sortable: true,},
				           {name: 'cdd_date', index:'cdd_date',hidden: true, sortable: true,},
				           {name: 'add_date', index:'add_date',hidden: true, sortable: true,},
				           {name: 'commission', index:'commission',hidden: true, sortable: true,},
				           {name: 'othercommission', index:'othercommission',hidden: true, sortable: true,},		           
				           
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
				   multiboxonly: true, // what is this ??
				   rowList:[5,10,15],	 
				   //pagerpos: 'right',
				   // toppager: true,
				   //toolbar:[true,"top"],
				   sortname: 'Ctno',
				   sortorder: 'desc',  
				   height: 'automatic',	
				   //hide: false,
			       emptyrecords: 'No records to display',
			       caption  : "Select Contract From List",
			       });
			invctgrid.jqGrid('navGrid','#tbl_invpager',{
				add : false,
				edit: false, 
				del : false,
				view: false,
				search : false,
				reload: true		
			}).jqGrid('navButtonAdd', '#tbl_invpager', {
	 		 	   caption:"Click Here",    
	 		 	   buttonicon: "ui-icon-print",
	 		       title: "Click here to load",	 		 	   
	 		       onClickButton: function(){
	 		 		 var selctnos="";
	 		 		 var ids = invctgrid.jqGrid('getGridParam','selarrrow');
	 		 		 for (var i=0; i<ids.length;i++){
	 		 		     var rowData = invctgrid.jqGrid('getRowData',ids[i]);
	 		 			 var ctno = " '"+rowData.ctno+"',";
	 		 			 selctnos = selctnos+ctno;
	 		 		   }
	 		 		 var itemp =selctnos.lastIndexOf(",");
					 var ctnoselc = selctnos.substring(0, itemp);
					 alert("ctnoselc"+ctnoselc);
					 type = $('#inv_includeSample').val();
					 alert("asd"+type);
					 //var ctnowoquote = ctnoselc.replace(/'/g, "");
	 				 billgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?ctno="+ctnoselc+"&type="+type+"&action="+"loadsubgrid",page:1});
	 				 billgrid.jqGrid('setCaption',"Raise Invoice").trigger('reloadGrid');
	 				 invgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?action="+"loadBill&ctno="+ctnoselc+"&type="+type ,page:1}).trigger('reloadGrid');
	 		 	   },
	 		 	
			});
			/*
		 	 * Grid 1 -a  - Loads Sample Data Based on the Customer Selected Value
		 	 *  fields -samno, orderdt, pono, cdd_date, add_date, destination, customerid
		 	 *  MultiSelect to Selec the Ct Number
		 	 *  Just Two Methods .  Select Sample Number, Reload - Client Side
		 	 *  
		 	 
			invsamplegrid.jqGrid({ 
				 url: "",
				 datatype: "json",
				 loadonce: false,
				 colNames:['Sample No','Date','Ref no','Priority','Handled By','Customer','Tannery','Deliver','ADD','CDD','Desti','IsInv Raised'],
				 colModel:[
				           {name: 'ctno', index:'ctno',hidden: false, sortable: true,}, 
				           {name: 'orderdt', index:'orderdt',hidden: false, sortable: true,},
				           {name: 'pono', index:'color',hidden: false, sortable: true,},
				           {name: 'cdd_date', index:'size',hidden: false, sortable: true,},
				           {name: 'add_date', index:'substance',hidden: true, sortable: true,},
				           {name: 'destination', index:'quantity',hidden: true, sortable: true,},
				           {name: 'customerid', index:'tc',hidden: false, sortable: true,},
				           {name: 'ctno', index:'ctno', hidden: false, sortable: true,}, 
				           {name: 'orderdt', index:'orderdt',hidden: false, sortable: true,},
				           {name: 'pono', index:'color',hidden: false, sortable: true,},
				           {name: 'cdd_date', index:'size',hidden: false, sortable: true,},
				           {name: 'add_date', index:'substance',hidden: false, sortable: true,},
				          ],
				  jsonReader : {  
					       repeatitems:false,
					       root: "rows",
					       page: "page", //calls first
					       total: "total" ,//calls Second
					       records: "records", //calls Third
					       },
				   pager : '#tbl_invsamplepager',
				   autoheight: true,
				   rowNum: 5, 
				   multiselect : true,
				   multiboxonly: true, // what is this ??
				   rowList:[5,10,15],	 
				   //pagerpos: 'right',
				   // toppager: true,
				   //toolbar:[true,"top"],
				   sortname: 'Ctno',
				   sortorder: 'desc',  
				   height: 'auto',	
				   hiddengrid : true,
			       emptyrecords: 'No records to display',
			       caption  : "Select Sample From List",
			       });
			invctgrid.jqGrid('navGrid','#tbl_invsamplepager',{
				add : false,
				edit: false, 
				del : false,
				view: false,
				search : false,
				reload: true		
			}).jqGrid('navButtonAdd', '#tbl_invsamplepager', {
	 		 	   caption:"Click Here",    
	 		 	   buttonicon: "ui-icon-print",
	 		       title: "Click here to load",	 		 	   
	 		       onClickButton: function(){
	 		 		 var selctnos="";
	 		 		 var ids = invctgrid.jqGrid('getGridParam','selarrrow');
	 		 		 for (var i=0; i<ids.length;i++){
	 		 		     var rowData = invctgrid.jqGrid('getRowData',ids[i]);
	 		 			 var ctno = " '"+rowData.ctno+"',";
	 		 			 selctnos = selctnos+ctno;
	 		 		   }
	 		 		 var itemp =selctnos.lastIndexOf(",");
					 var ctnoselc = selctnos.substring(0, itemp);
					 //var ctnowoquote = ctnoselc.replace(/'/g, "");
	 				 billgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?ctno="+ctnoselc+"&action="+"loadsubgrid",page:1});
	 				 billgrid.jqGrid('setCaption',"Raise Invoice").trigger('reloadGrid');
	 				 invgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?action="+"loadBill&ctno="+ctnoselc ,page:1}).trigger('reloadGrid');
	 		 	   },
	 		 	
			});
	*/
			/* 
			 * SubGrid 1 - Load Billing Details
		 	 *  Grid 2 - Loads Data Based on the Grid 1 Selected Ct 
		 	 *  fields -contractno, articlename, color, size, substance, selection, quantity,, unit 
		 	 *  Raise Invoice for Ct 
		 	 *  Methods .  Add Bill Methods + Search ... 
		 	 * 
		 	 */
			
			billgrid.jqGrid({
				url:"",
				datatype: "json",
				colNames:['Status','Ct No','Art Id','Type','Article','Color','Size','Substance','Selection','Pcs','Quantity','Unit','Shipped','Balance','Rate','RDD','Comments','Reps','Feedback','Amount','Total','TC'],
			    colModel:[
			              {name:'status', index:'status',align:'center', width :40, editable:false, sortable: true, hidden:false, search: true, 
			            	 
			              },
			              {name:'contractno', index:'contractno',align:'center', width :40, editable:true, sortable: true, hidden:false, search: true,
			            	  editoptions: { readonly: 'readonly' },
			  				/*formoptions:{
				        	   	elmprefix:"(<span class='mystar' style='color:red'>*</span>)&nbsp;",
				        	    	elmsuffix:"&nbsp;yyyy-mm-dd",
				        	    label: "<span>Date<span><span style='float:right'>XXX</span>"
				        	    }, */
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
						  {name:'tc', index:'tc',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
							 
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
						add : true, addCaption :"Raise Bill",
						edit: false,
						del : false, 
						view: false, 
						search : false, 
						reload: false}, 
						/*{addfunc: function() {
						    var sel_id = grid.getGridParam('selrow');
						    if (sel_id) {
						        grid.editGridRow("new", pAddOption);
						    } 
						}
						},*/
						{},
						{
							/*
							 * Add Method 
							 */
							closeAfterAdd: true,
							reloadAfterSubmit: true,
							/*afterShowForm: function () {
								//if($("#inv_invoiceno").val().length == '' &&  $("#inv_invdate").val().length == ''){
									var idSelector = $.jgrid.jqID(billgrid);
									alert(idSelector);
									$.jgrid.hideModal("#editmod" + idSelector, {gbox: "#gbox_" + idSelector});
									alert("Error!!!");
								//}
								alert($("#inv_invoiceno").val());
								alert($("#inv_invdate").val());
			                },*/
							/*beforeInitData: function ()
							{
								if($("#inv_invoiceno").val().length != '' &&  $("#inv_invdate").val().length != ''){
									alert("Calls A$ Form ");
									alert($("#inv_invoiceno").val());
								}else{
									alert("Calls B$ Form ");
								}
							},*/
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
							
								$('#tr_tc').hide();
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
						            $('#' + 'qshipped' + '.FormElement', formID).val(selRowData.qshipped); 
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
							var invno = $('#inv_invoiceno').val();
							var ctno = $("#contractno").val();
							ctno = "'"+ctno+"'";
							invgrid.jqGrid('setGridParam',{url:"/Myelclass/InvSelectCtfromCust.do?action="+"loadBill&invno="+invno+"&ctno="+ctno ,page:1}).trigger('reloadGrid');
							
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
					 colNames:['Inv Id','Inv No','InvDt','articleid','Ct No','Article','Color','Size','Substance','Selection','Quantity','Rate','TC','Q Shipped','Q Balance','amount'],
					 colModel:[
					           	{name: 'invid', index:'invid',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
					           		editoptions: { readonly: 'readonly' },
					           	},
								{name: 'invno', index:'invno',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
					           		editoptions: { readonly: 'readonly' },
								},
								{name: 'invdt', index:'invdt',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invartid', index:'invartid',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
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
								{name: 'invselc', index:'invselc',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invqty', index:'invqty',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
									formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, },
								},
								{name: 'invrate', index:'invrate',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
									
								},
								{name: 'invtc', index:'invtc',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
									editoptions: { readonly: 'readonly' },
								},
								{name: 'invqshpd', index:'invqshpd',sortable:true, editable: true, width:70,
									formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, },
									edittype:'text', 
								},
								{name: 'invqbal', index:'qbal',align:'center', width :80, editable:true, sortable: true, hidden:false, search: true,
									formatter : 'number', formatoptions:{decimalSeparator:".", decimalPlaces: 2, },
									edittype:'text', 
									editoptions:{
									 	dataEvents:  [{
											type: 'focusout',
											fn: function(e){
												alert("IS this Edit BILL Calculation"+billInvisInEdit);
												if(billInvisInEdit){ //Code for Edit Form Qty Calculation 
													 var invqbal = parseFloat($("#invqty").val() - $("#invqshpd").val());
													 var qbals = invqbal.toFixed(2);
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
				 });	
			
				 invgrid.jqGrid('navGrid','#invbillpager',{
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
							beforeInintData: function ()
							{
								alert("in B4 init data");
								billInvisInEdit = true;
							},
							/*beforeShowForm : function(formID){
								
								$('#tr_invtc').hide();
							}*/
						},
						/*
						 * 
						 * Remove Add Button - Bcos Qty Bal Calculates wrong
						 */{
							
							// * Add Second BIll 
							recreateForm: true,
							closeAfterAdd: true,
							reloadAfterSubmit: true,
							//Add 
							beforeInintData: function ()
							{
								billInvisInEdit = false;
							},
							beforeShowForm : function(formID){
								var selRowData;
								var rowid = invgrid.jqGrid('getGridParam', 'selrow');
					           	if (rowid === null) {
					             alert('Please select row');
					             return;
								}
					           	selRowData = invgrid.jqGrid('getRowData', rowid);
					           	alert(selRowData.invno);
					           	$('#' + 'invid' + '.FormElement', formID).val(selRowData.invid);
					            $('#' + 'invno' + '.FormElement', formID).val(selRowData.invno);
					            $('#' + 'invdt' + '.FormElement', formID).val(selRowData.invdt);
					            $('#' + 'invartid' + '.FormElement', formID).val(selRowData.invartid);
					            $('#' + 'invctno' + '.FormElement', formID).val(selRowData.invctno);
					            $('#' + 'invartname' + '.FormElement', formID).val(selRowData.invartname);
					            $('#' + 'invcolor' + '.FormElement', formID).val(selRowData.invcolor);
					            $('#' + 'invsize' + '.FormElement', formID).val(selRowData.invsize);
					            $('#' + 'invsubs' + '.FormElement', formID).val(selRowData.invsubs);
					            $('#' + 'invselc' + '.FormElement', formID).val(selRowData.invselc);
					            $('#' + 'invqty' + '.FormElement', formID).val(selRowData.invqty); 
					            $('#' + 'invrate' + '.FormElement', formID).val(selRowData.invrate);
					            $('#' + 'invtc' + '.FormElement', formID).val(selRowData.invtc);
					            $('#' + 'invqshpd' + '.FormElement', formID).val("0.00");
					            $('#' + 'invqbal' + '.FormElement', formID).val(selRowData.invqbal);
					            $('#' + 'invamt' + '.FormElement', formID).val(selRowData.invamt);
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
		                             }
		                         },
								reloadAfterSubmit: true,
							
						},{},
						 {
							// In View Grid
							/*beforeShowForm: function(form) { //  Shows the Hidden Date field @ Form LOads
						         alert("in View Grid "); 
						        // $('#quantity').val($('#quantity').val()+$('#unit').val());
								},*/
							
						
					/*}).navButtonAdd('#invbillpager',{
			 		 	   caption:"Add Bill", 
			 		 	   buttonicon:"ui-icon-lightbulb", 
			 		 	   position:"first",
			 		 	   onClickButton: function(){ 
			 		 		 var $self = $(this);
				 		 	   $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
				 		 	    {
				 		 		 
				 		 		   beforeShowForm: function(formId){
				 		 			   alert("In BFORM");
				 		 			   $("#invqshpd").val("0.00"); 
				 		 			   
				 		 		   }
				 		 	    });
			 		 	   }*/
					});
		//Invoice Type
		/*$('#inv_invoicetype').change(function(){
			var value = $('#inv_invoicetype').val();
			alert("select box value changed"+value);
		});*/
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
		          	  $('#inv_exporteraddress').val(ui.item.addr);
		          	  $('#inv_exportertele').val(ui.item.fone);
		          	  $('#inv_exporterattn').val(ui.item.attn);
		          	  $('#inv_exporterfax').val(ui.item.fax);
		              $('#inv_expref').val(ui.item.ref);
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
			 },
			 close: function () {
				    $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
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
		$('#inv_ctryoffinaldesti').autocomplete({
			 source: function(request, response) {
				var param = request.term;  
				$.getJSON("/Myelclass/InvAutocomplete.do?term="+param+"&action="+"destictry",
					function(result) { 	
				       response($.map(result, function(item) {
				           return { 
				              value: item.destinationCountry,
				              };
				        }));//END response
				 });
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
				              value: item.destination,
				              };
				        }));//END response
				 });
			 }
		});
		/*$('#inv_dischargeport').autocomplete({
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
		});*/
		
		
		 $(".dateclass").datepicker({
			    autoSize: true,
			    changeMonth:false,
			    dateFormat: "dd/mm/yy",
			    firstDay: 1,
			    gotoCurrent:true, 
			});
		
			
	});