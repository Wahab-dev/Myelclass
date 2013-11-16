/**
 * PRF js
 * 19.08.13
 * 
 */
$(document).ready(function() {
	var grid = $("#list"); //table id artinsert
	var ctno = $("#prf_contractno").val();
	 grid.jqGrid({ 
		url:"/Myelclass/PrfinsertArticle.do?ctno="+ctno,   
		datatype:"json",
		colNames:['Article Type','Name','Article Shform', 'Article ID','Color','Size','Size avg','Size Rem','Substance','Selection','Selp','Quantity','Unit','Pcs','Price','RateSign','Rateamt','Shipment','T c','tcamt','tcsign','tccust','Contract','Prfarticleid','User'],  
	    colModel:[   
			 
			 {name:'prf_articletype', index:'articletype', width:80, align:'center', sortable:true, editable:true, hidden: false, edittype:'select', 
				 editoptions: { 
          		 dataUrl:'/Myelclass/PrfAutocomplete.do?action=arttype',
          		 type:"GET",
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
                 editrules :{require : true},
                 formoptions:{rowpos: 1, colpos: 1}, 
			 },  
			 {name:'prf_articlename', index:'articlename', width:90,  align:'center', editable:true, hidden: false, edittype:'text',
		    	  editoptions:{
						dataInit:function (elem) { 
							$(elem).autocomplete({
								minLength: 2,
								source: function(request, response,term) {
									var param = request.term;
						            $.ajax({
						                url: "/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"artname",
						                dataType: "json",
						                type:"GET",
						                success: function (data) {
						                	 response($.map(data, function(item) {
						                		 return { 
						                             id: item.articleid,
						                             shform: item.articleshortform, //can add number of attributes here 
						                             value: item.articlename, // I am displaying both labe and value
						                             clr : item.color, 
						                             size: item.size,
						                             sizeremar:item.size_remarks,
						                             subs: item.substance,
						                             selec:item.selection ,
						                             selp:item.selp ,
						                             ratesign: item.rate_sign,
						                             rateamt: item.rateamt,
						                             shipment: item.shipment,
						                             tcsign: item.tc_currency,
						                             tcamt: item.tc_amount,
						                             tcagt: item.tc_agent
						                             };
						                         }));//END Response
	
						                },//END Success
						            });//END AJAX
								},
								select: function( event, ui ) { 
									 $('#articleid').val(ui.item.id);
						          	 $('#artshform').val(ui.item.shform);
						        	 $('#prf_color').val(ui.item.clr);
						          	 $('#prf_size').val(ui.item.size);
						          	 $('#prf_sizeremarks').val(ui.item.sizeremar);
						          	 $('#prf_substance').val(ui.item.subs);
						          	 $('#prf_selection').val(ui.item.selec);
						          	 $('#prf_selectionp').val(ui.item.selp);
						          	 $('#prf_ratesign').val(ui.item.ratesign);
						          	 $('#prf_rateamt').val(ui.item.rateamt);
						          	 $('#prf_shipment').val(ui.item.shipment);
						          	 $('#prf_tcamt').val(ui.item.tcamt);
						          	 $('#prf_tcagent').val(ui.item.tcagt);
						          	 $('#prf_tccurrency').val(ui.item.tcsign);
						            } 
							 });
							$('.ui-autocomplete').css('zIndex',1000); // z index for jqgfrid and autocomplete has been misalignment so we are manually setting it 
							}
		    	  	},
		    	  	formoptions:{rowpos: 1, colpos: 2} 
			}, 
			{name:'artshform', index:'articleshfrom', width:55, align:'center', editable:true, hidden: true,
				formoptions:{rowpos: 1, colpos: 3} 
			}, 
			{name:'articleid', index:'articleid', align: 'center', width:40, sortable:true,  editable:true,  hidden: true,					     				 
				 
		    },
			{name:'prf_color', index:'color', width:90, align:'center', sortable:true, hidden: false, editable:true, edittype:'text',
				 editoptions:{
						dataInit:function (elem) { 
							$(elem).autocomplete({
								minLength: 2,
								source: function(request, response,term) {
									var param = request.term;
						            $.ajax({
						                url: "/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"color",
						                dataType: "json",
						                type:"POST",
						                success: function (data) {
						                	 response($.map(data, function(item) {
						                		 return { 
						                             label: item.value,
						                             //shform: item.shform, //can add number of attributes here 
						                             value: item.value // I am displaying both labe and value
						                             };
						                         }));//END Response
	
						                },//END Success
						            });//END AJAX
								},
								
							});
							$('.ui-autocomplete').css('zIndex',1000); // z index for jqgfrid and autocomplete has been misalignment so we are manually setting it 
							}
						   }
			
			}, 	
			{name:'prf_size', index:'size', width:80, align:'center', hidden: false, editable:true,sortable:true,
				editoptions: { 
						dataEvents:[{
							type: 'focusout',
							fn: function(e){
								var sizeval = $("#prf_size").val();
								var size_minindex = sizeval.indexOf('/');
								//var size_maxindex = sizeval.indexOf(' '); // in order to avoid Size remarks. Make Size remrk seperate row in Table
								var sizemin = sizeval.substring(0, size_minindex);
								var sizemax=  sizeval.substring(size_minindex+1);
								var sizeavg = ( (parseFloat (sizemin) + parseFloat(sizemax)) /2) ;
								$("#prf_sizeavg").val(sizeavg);
							}
						}]  
					  },
				editrules: {required: true},
			    formoptions:{rowpos: 6, colpos: 1} 
			},  
			{name:'prf_sizeavg', index:'sizeavg', width:20, align:'center', editable:true, hidden: true,
				editrules: {required: true},
				formoptions:{rowpos: 6, colpos: 3} 	
			}, 
			{name:'prf_sizeremarks', index:'sizerem', width:40, align:'center',  editable:true, hidden: true, 
				edittype:'select',
				editoptions:{value:{0: 'Select Size Remarks', F:'F', S:'S', FS:'FS', DB:'Double Butt'}},
				  editrules: {required: true},
				  formoptions:{rowpos: 6, colpos: 2} 	
			}, 
			{name:'prf_substance', index:'substance', align:'center', sortable:true, hidden: false, width:80,
					  editable:true, formoptions:{rowpos: 7, colpos: 1} 	
			},  
			{name:'prf_selection', index:'selection', align:'center', width:90, sortable:true, hidden: false, editable:true,
				edittype:'select',
				  editoptions:{value:{0:'Select Selection %',A:'A',AB:'AB',ABC:'ABC',TR:'TR',Available:'Available'}},
				  formoptions:{rowpos: 7, colpos: 2} 
			}, 
			{name:'prf_selectionp', index:'selectionpercent', align:'center', width:90, sortable:true, editable:true, hidden: false,
				 formoptions:{rowpos: 7, colpos: 3} 
			}, 	
		
			{name:'prf_quantity', index:'quantity', width:90, align:'center', sortable:true, hidden: false, 
				editable:true, editrules:{number:true}, formatter: 'number',  
				  formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.0000' },
				  formoptions:{rowpos: 8, colpos: 1} 
			}, 	
			{name:'prf_unit', index:'unit', width:90, align:'center', sortable:true, hidden: false, editable:true,
				edittype:'select',
				  editoptions:{
					  value:{0:'Select Quantity Unit',sqft:'sq ft',skins:'skins',Garment:'Garment',NA:'NA'},
					  dataEvents:[{
							type: 'focusout',
							fn: function(e){
								var qty = $("#prf_quantity").val();
								var unit = $("#prf_unit option:selected").val();
								var sizeav = $("#prf_sizeavg").val();
								var piecs = ((unit == "sqft") ? (parseInt (qty) / parseInt(sizeav)) : parseInt(qty)) ;
								$("#prf_pieces").val(parseInt(piecs));
							}
						}],
						
					  }, formoptions: {rowpos: 8, colpos: 2},
			 }, 	
			{name:'prf_pieces', index:'pcs', width:90, align:'center', sortable:true, hidden: false, editable:true,
				 formoptions: {rowpos: 8, colpos: 3},
			}, 	
			{name:'prf_rate', index:'rate', width:90, align:'center', sortable:true, hidden: false, editable:true,
				 editrules:{edithidden:true}, 
				formoptions: {rowpos: 9, colpos: 1},
				
			}, 
			{name:'prf_ratesign', index:'ratesign', width:90, align:'center', sortable:true, hidden: true, editable:true,
				  edittype:'select',
				  editoptions:{value:{0:'--- Select Currency --- ',$:'$',Rs:'Rs',Euro:'Euro',NA:' Not Available'}},
				  //editoptions:{value:"0:--- Select Currency --- ; $:Dollar; Rs:Rupees; €:Euro; NA:Not Available"},
				  editrules:{edithidden:true}, 
				  formoptions: {rowpos: 10, colpos: 1},
			},  
			{name:'prf_rateamt', index:'rateamt', width:90, align:'center', sortable:true, hidden: true, editable:true,
				 editrules:{edithidden:true}, 
				 formoptions: {rowpos: 10, colpos: 2},	
			}, 
			{name:'prf_shipment', index:'shipment', width:90, align:'center', sortable:true, editable:true, hidden: true,
			      edittype:'select',
			      editoptions:{value:{0:'--- Select Shipment --- ',Air:'Air',Sea:'Sea',Courier:'Courier',Truck:'Truck'}},
			      editrules:{edithidden:true},  formoptions: {rowpos: 10, colpos: 3},	
			}, 
			{name:'prf_tc', index:'tc', width:90, align:'center', sortable:true, editable:true, hidden: false}, 
			 	
			{name:'prf_tcamt', index:'tcamt', width:90, align:'center', sortable:true, editable:true, hidden: true,
				 editrules:{edithidden:true}, formoptions: {rowpos: 12, colpos: 2},
			}, 	
			{name:'prf_tccurrency', index:'tcsign', width:90, align:'center', sortable:true, editable:true, hidden: true,
				edittype:'select',
			  	  editoptions:{value:{0:'Select TC currency ',cents:'cents',paise:'paise',shillings:'shillings',NA:'NA'}},
			  	 editrules:{edithidden:true}, formoptions: {rowpos: 12, colpos: 1},
			},
			{name:'prf_tcagent', index:'tccust', width:90, align:'center', sortable:true, editable:true, hidden: true,
				 edittype:'select',
			      editoptions:{value:{0:'Select TC Customer',IC:'IC',Cust:'Cust',ICMD:'IC/MD',MD:'MD',NA:'NA'}},
			      editrules:{edithidden:true}, formoptions: {rowpos: 12, colpos: 3},
			}, 	
			{name:'prf_contractnum', index:'contractno', width:90, align:'center', sortable:true, editable:true,editoptions:{readonly: true}, hidden: false}, 	
			{name:'prf_articleid', index:'prfarticleid', width:90, align:'center', sortable:true, editable:true, hidden: true}, 	
			
			{name:'user', index:'user', width:90, align:'center', sortable:true, editable:true, hidden: true,
				//${user.name}.	
			
			}, 	
			/*{
			    name: 'checkbox',
			    index: 'checkbox',
			    editable:true,
			    checked:false,
			    edittype:'checkbox',
			    align:"center",
			  //  hidden : adminHide,
			    editoptions: { value:"True:False"},
			    formatter: "checkbox",
			    formatoptions: {disabled : false,checked:false}
			}*/
									  
		],  
		jsonReader : {  
		  	repeatitems:false,
	      	root: "rows",
	      	page: "page", //calls first
	      	total: "total" ,//calls Second
	      	records: "records" //calls Third
		},
		caption: "Add Article",
  	pager: '#pager',
  	rowNum:6, 
  	rowList:[6,8,10],
      loadtext: "Bow Bow........... ",
      sortname: 'articlename',  
      sortorder: 'desc', 
      viewrecords: true,
      gridview: true, // if used cant use subgrid, treegrid and aftertInsertRow 
      height: "100%", 
      emptyrecords: 'No records to display',
      editurl: "/Myelclass/PrfinsertArticle.do",
		}).jqGrid('navGrid','#pager',{add:true, edit:true, del:true, search: false}, 
			/*
	         *  // edit option
			 */
		     { 
		  	jqModal:true, 
			  width : 650,
			  top:120,
			  left:120,
				
			// edit option
			  beforeShowForm: function(form) { 
				  
				  //Size Calculation
				 var sizec = $("#prf_size").val();
				 var temp = sizec.indexOf(' ');
				 $("#prf_size").val(sizec.substring(0, temp));
				 $("#prf_sizeremarks").val(sizec.substring(temp+1));
				 
				 //Size Avg Calculation
				   var sizeval = $("#prf_size").val();
					var size_minindex = sizeval.indexOf('/');
					//var size_maxindex = sizeval.indexOf(' '); // in order to avoid Size remarks. Make Size remrk seperate row in Table
					var sizemin = sizeval.substring(0, size_minindex);
					var sizemax=  sizeval.substring(size_minindex+1);
					var sizeavg = ( (parseFloat (sizemin) + parseFloat(sizemax)) /2) ;
					$("#prf_sizeavg").val(sizeavg);
					
				//Rate Calculation
				 var ratec = $("#prf_rate").val();
				 var ratemp = ratec.indexOf(' ');
				 var ratemplast = ratec.lastIndexOf(' ');
				 $("#prf_ratesign").val(ratec.substring(0, ratemp));
				 $("#prf_rateamt").val(ratec.substring(ratemp+1, ratemplast));
				 $("#prf_shipment").val(ratec.substring(ratemplast+1));
				 
				 
				//TC Calculation
				 var tctec = $("#prf_tc").val(); 
				 var tcindex = tctec.indexOf(" ");
				 var tcindex1 = tctec.lastIndexOf(" ");
				 var tcamt = tctec.substring(0, tcindex);
				 var tcsign = tctec.substring(tcindex+1, tcindex1);
				 var agent = tctec.substring(tcindex1+1);
				 $("#prf_tcamt").val(tcamt);
				 $("#prf_tcagent").val(agent);
				 $("#prf_tccurrency").val(tcsign);
				 $("#tr_prf_tc").hide();
				 $("#tr_prf_rate").hide();
		      },
		        closeAfterEdit: true,
				reloadAfterSubmit: true,
		      },
		   
		    /*
		     *  // add option
		     */
		    
		    {	    	 
		    	//top: 150,
			 	  //left: 200,
			 	  width : 650,
			 	/* onCellSelect : function(rowid, iCol, cellcontent) {
			 		alert("2345");
			 		var myval =grid.jqGrid('getCell', rowid,'substance');
			 		alert("myval  "+myval);
			 	 },*/
		          beforeShowForm: function(form) { 
		           	 $("#prf_contractnum").val($("#prf_contractno").val());
		           	 $("#user").val($("#userinsession").val());
		            	$("#tr_prf_tc").hide(); // hide the tr prf_rate
		            	$("#tr_prf_rate").hide();
		          },
		          closeAfterAdd: true,
					reloadAfterSubmit: true
			 },
			 {
					// del option
				//Del Article
					delData: {
						//Function to Add parameters to the delete 
						//Here i am passing artid with val 
						prf_articleid: function() {
                                var sel_id = grid.jqGrid('getGridParam', 'selrow');
                                var value = grid.jqGrid('getCell', sel_id, 'prf_articleid');
                                return value;
                             }
                         },
						reloadAfterSubmit: true,
					 
			 }    
	 	);
		 	
	//Commision Add 
	 /*var counter = 2;
	    $("#addButton").click(function () {
	 	if(counter>8){
	         alert("Only 8 Commissions Allowed allow");
	         return false;
	 	}   
	 	var newTextBoxDiv = $(document.createElement('div'))
	 	     .attr("id", 'TextBoxDiv' + counter);
	 	newTextBoxDiv.after().html('<label>Commission #'+ counter + ' : </label>' +
	 	      '<input type="text" name="prf_commission' + counter + 
	 	      '" styleId="prf_commission' + counter + '" value="" >');
	 	newTextBoxDiv.appendTo("#TextBoxesGroup");
	 	counter++;
	     });
	    $("#removeButton").click(function () {
	 			if(counter==2){
	 		          alert("No more textbox to remove");
	 		          return false;
	 		       }
	 			counter--;
	 		        $("#TextBoxDiv" + counter).remove();
	 	});	*/	

	    
	//Commssion AutoComplete 		
	 $('#prf_elclasscommission').autocomplete({
			minLength: 1,
			source: function(request, response,term) {
				var param = request.term;
				$.ajax({
				        url: "/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"commision",
				        dataType: "json",
				        type:"GET",
				        success: function (data) {
				              response($.map(data, function(item) {
				            	  return { 
				                	label : item.value,
				                    value: item.value+", "+item.commplace+".",
				                   };
				               }));//END Success
				        }
				 });//END AJAX
		    },
		});
	 
	 	 function split( val ) {
		  return val.split( /,\s*/ );
		 }
		 function extractLast( term ) {
		  return split( term ).pop();
		 }
	 
		 $('#prf_commission').autocomplete({
				minLength: 1,
				source: function(request, response, term) {
					 // delegate back to autocomplete, but extract the last term
					var param = request.term;
					 $.ajax({
			                url: "/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"othercommision",
			                dataType: "json",
			                type:"GET",
			                success: function (data) {
			                	 response($.map(data, function(item) {
			                		 return { 
			                			 label : item.value,
			                             value: item.value+", "+item.commplace+".",
			                             };
			                         }));//END Success
			                    }
			            });//END AJAX
					},
		});
		 $('#prf_consigneename').autocomplete({
				minLength: 1,
				source: function(request, response,term) {
					var param = request.term;
					 $.ajax({
			                url: "/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"consignee",
			                dataType: "json",
			                type:"GET",
			                success: function (data) {
			                	 response($.map(data, function(item) {
			                		 return { 
			                			 label : item.label,
			                			 value: item.value,
			                             addr: item.consigneeAddress,
			                             fone: item.consigneeContactNo,	
			                             attn : item.consigneeAttention,
			                             fax: item.consigneefax,
			                             };
			                         }));//END Success
			                    }
			            });//END AJAX
					},
					select: function( event, ui ) { 
			          	  var addr = ui.item.addr; 
			          	  var attn = ui.item.attn; 
			          	  var fone = ui.item.phone; 
			          	  var fax = ui.item.fax; 
			          	  $('#prf_consigneeaddr').val(addr);
			          	 $('#prf_consigneephone').val(fone);
			          	 $('#prf_consigneeattn').val(attn);
			          	 $('#prf_consigneefax').val(fax);
			            } 
		});
		 $('#prf_bankname').autocomplete({
				minLength: 1,
				source: function(request, response,term) {
					var param = request.term;
					 $.ajax({
			                url: "/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"bank",
			                dataType: "json",
			                type:"GET",
			                success: function (data) {
			                	 response($.map(data, function(item) {
			                		 return { 
			                			 label : item.bankName,
			                			 value: item.bankName,
			                             addr: item.bankAddress,
			                             fone: item.bankContactNo,	
			                             brnch : item.bankBranch,
			                             fax: item.bankFax,
			                             };
			                         }));//END Succ ess
			                    }
			            });//END AJAX
					},
					select: function( event, ui ) { 
			          	  var addr = ui.item.addr; 
			          	  var brnch = ui.item.brnch; 
			          	  var	 fone = ui.item.fone; 
			          	  var fax = ui.item.fax; 
			          	  $('#prf_bankaddr').val(addr);
			          	 $('#prf_bankphone').val(fone);
			          	 $('#prf_bankbranch').val(brnch);
			          	 $('#prf_bankfax').val(fax);
			            } 
		});
		 $('#prf_notifyname').autocomplete({
				minLength: 1,
				source: function(request, response,term) {
					var param = request.term;
					 $.ajax({
			                url: "/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"notify",
			                dataType: "json",
			                type:"GET",
			                success: function (data) {
			                	 response($.map(data, function(item) {
			                		 return { 
			                			 label : item.notifyConsigneeName,
			                			 value: item.notifyConsigneeName,
			                             addr: item.notifyConsigneeAddress,
			                             fone: item.notifyConsigneeContactNo,	
			                             attn : item.notifyConsigneeAttention,
			                             fax: item.notifyConsigneefax,
			                             };
			                         }));//END Success
			                    }
			            });//END AJAX
					},
					select: function( event, ui ) { 
			          	  var addr = ui.item.addr; 
			          	  var attn = ui.item.attn; 
			          	  var fone = ui.item.phone; 
			          	  var fax = ui.item.fax; 
			          	  $('#prf_notifyaddr').val(addr);
			          	 $('#prf_notifyphone').val(fone);
			          	 $('#prf_notifyattn').val(attn);
			          	 $('#prf_notifyfax').val(fax);
			            } 
		});
			    $('#prf_destination').autocomplete({  
		            minLength: 2,  
		            source: function(request, response,term) {  
		                var param = request.term;  
		                $.ajax({  
		                    url: "/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"desti",  
		                    dataType: "json",  
		                    type:"GET",  
		                    success: function (data) { 
		                         response($.map(data, function(item) {  
		                             return {   
		                                 label: item.label,  
		                                 shform: item.shform, //can add number of attributes here   
		                                 value: item.label +" , "+ item.value // I am displaying both labe and value  
		                                 };  
		                             }));//END Success  
		                        },  
		                });//END AJAX  
		            }, 
		        });// End Autocomplete  
				
		        //DATEPICKER
		        $("#prf_orderdate").datepicker({
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
		        
		        $(".prf_delivrydate").datepicker({
				   // changeYear: true,
				    autoSize: true,
				    changeMonth:false,
				    dateFormat: "dd/mm/y",
				    showWeek: true,
				    firstDay: 1,
				    numberOfMonths: 2,
				    showButtonPanel: true,
				    gotoCurrent:true, 
				});
		        
					 
			 $('#prf_tanname').autocomplete({
				 source: function(request, response) {
						var param = request.term;  
					 	$.getJSON("/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"tan",
							function(result) { 	
					             response($.map(result, function(item) {
					                return { 
					                       value: item.label,
					                       addr: item.tanneryAddress,
					                       phone: item.tanneryContactNo,	
					                       attn : item.tanneryAttention,
					                       fax: item.tanneryFax,
					                       };
					                     }));//END response
					                    }
							 );
							},
							select: function( event, ui) { 
					          	 $('#prf_tanaddr').val(ui.item.addr);
					          	 $('#prf_tanphone').val(ui.item.phone);
					          	 $('#prf_tanattn').val(ui.item.attn);
					          	 $('#prf_tanfax').val(ui.item.fax);
					           } 
					}); 
				 $('#prf_custname').autocomplete({
					 source: function(request, response) {
							var param = request.term;  
						 	$.getJSON("/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"custname",
								function(result) { 	
						             response($.map(result, function(item) {
						                return { 
						                       value: item.label,
						                       addr: item.customerAddress,
						                       phone: item.customerTelephone,	
						                       attn : item.customerAttention,
						                       fax: item.customerFax,
						                       };
						                     }));//END response
						                    }
								 );
								},
								select: function( event, ui) { 
									 $('#prf_custaddr').val(ui.item.addr);
						          	 $('#prf_custphone').val(ui.item.phone);
						          	 $('#prf_custattn').val(ui.item.attn);
						          	 $('#prf_custfax').val(ui.item.fax);
						           } 
						});  		
 });