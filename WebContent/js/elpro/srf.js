/**
 * SRF js
 * 21.09.13
 * 
 */
$(document).ready(function() {
	
	var sno = $('#srf_sampleno').val();
	 var grid = $("#srfArticletbl");
	
		grid.jqGrid({ 
			         datatype: "json",
				    // url:"/Myelclass/SrfinsertArticle.do",
				     url:"",
			         mtype: 'GET',  
			         colNames:['ArticleID', 'ArticleType','ArticleShForm', 'Article name','Color', 'Size','Sizeavg','Substance', 'Selection','Selectionp', 'Quantity','Unit','Price','Ratesign','Rateamt','Shipment','Colormatching','Tapetest','Crockingwet','CrockingDry','Fourfolds','Keytest','SampleNo','Srfarticleid'],  
			         colModel :[   
			                    {name:'articleid',index:'articleid',align:'center', editable:true, sortable:true, hidden:true,
			                    	
			                    },  
			                    {name:'srf_articletype',index:'articletype', align:'center', editable:true, sortable:true, hidden:false, edittype:'select',
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
			                    },  
			                    {name:'srf_articleshform', index:'articleshform', align:'center', editable:true, sortable:true, hidden:true},   
			                    {name:'srf_articlename', index:'articlename',  align:'center', editable:true, sortable:true, hidden:false,
			                    	edittype:'text',
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
			                    },  
			                    {name:'srf_color', index:'color' ,  align:'center', editable:true, sortable:true, hidden:false, },  
			                    {name:'srf_size', index:'size', align:'center', editable:true, sortable:true, hidden:false, },  
			                    {name:'srf_sizeavg', index:'sizeavg',  align:'center', editable:true, sortable:true, hidden:true, },
			                    {name:'srf_substance', index:'substance', align:'center', editable:true, sortable:true, hidden:false,  }, 
			                    {name:'srf_selection', index:'selection', align:'center', editable:true, sortable:true, hidden:false, },  
			                    {name:'srf_selectionp', index:'selectionp',  align:'center', editable:true, sortable:true, hidden:false, },   
			                    {name:'srf_qty', index:'quantity', align:'center', editable:true, sortable:true, hidden:false, },  
			                    {name:'srf_unit', index:'unit' , align:'center', editable:true, sortable:true, hidden:false, },   
			                    {name:'srf_price', index:'price',  align:'center', editable:true, sortable:true, hidden:false, },   
			                    {name:'srf_ratesign', index:'ratesign',  align:'center', editable:true, sortable:true, hidden:true, },  
			                    {name:'srf_rateamt', index:'rateamt',  align:'center', editable:true, sortable:true, hidden:true, },   
			                    {name:'srf_shipment', index:'shipment',  align:'center', editable:true, sortable:true, hidden:true, },  
			                    {name:'srf_colormatch', index:'colormatching', align:'center', editable:true, sortable:true, hidden:true, },   
			                    {name:'srf_tapetest', index:'tapetest', align:'center', editable:true, sortable:true, hidden:true, },  
			                    {name:'srf_crockwet', index:'crockingwet', align:'center', editable:true, sortable:true, hidden:true, },  
			                    {name:'srf_crockdry', index:'crockingdry', align:'center', editable:true, sortable:true, hidden:true, }, 
			                    {name:'srf_fourfold', index:'fourfolds',  align:'center', editable:true, sortable:true, hidden:true, },  
			                    {name:'srf_keytest', index:'keytest',  align:'center', editable:true, sortable:true, hidden:true, }, 
			                    {name:'srf_samplenum', index:'samplenum', align:'center', editable:true, sortable:true, hidden:false, },
			                    {name:'srf_articleid', index:'srfarticleid', align:'center', editable:true, sortable:true, hidden:true, },
			                    ],  
			        jsonReader : {  
			        	repeatitems:false,
			            root: function (jsonOrderArray) { return jsonOrderArray; },
			            page: function (jsonOrderArray) { return 1; },
			            total: function (jsonOrderArray) { return 1; },
			            records: function (jsonOrderArray) { return jsonOrderArray.length; }
			        },  
			        pager: '#srfArticlepager',
			    	rowNum:7, 
			    	viewrecords: true ,
			    	rowList:[7,10,15],
			        loadtext: "Bow Bow",
			        height : "auto",
			        width:"auto",  
			        sortname: 'articleid',  
			        sortorder: 'desc',  
			        emptyrecords: 'No records to display',
			         
			        });  
		grid.jqGrid('navGrid','#srfArticlepager',{edit:true,add:true,del:true, search:true, view:true});
	
			
	//Autocomplete
	
	 $('#srf_tanname').autocomplete({
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
			          	 $('#srf_tanaddr').val(ui.item.addr);
			          	 $('#srf_tanphone').val(ui.item.phone);
			          	 $('#srf_tanattn').val(ui.item.attn);
			          	 $('#srf_tanfax').val(ui.item.fax);
			           } 
			}); 
		  $('#srf_deliver').autocomplete({
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
			          	 $('#srf_custaddr').val(ui.item.addr);
			          	 $('#srf_custphone').val(ui.item.phone);
			          	 $('#srf_custattn').val(ui.item.attn);
			          	 $('#srf_custfax').val(ui.item.fax);
			           } 
			}); 
		  
		  $('#srf_customer').autocomplete({
			    source: function(request, response) {
			    	var param = request.term;  
			        $.getJSON("/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"custname", 
			        		 function(result) {
			            		response($.map(result, function(item) {
			                	return {
			                		label: item.label,  //can add number of attributes here   
			                        value: item.label  // I am displaying both labe and value  
			                		};
			            }));
			        });
			    }

			});
	$('#srf_destination').autocomplete({
	    source: function(request, response) {
	    	var param = request.term;  
	        $.getJSON("/Myelclass/AutoCompleteServlet.do?term="+param+"&action="+"desti", 
	        		 function(result) {
	            		response($.map(result, function(item) {
	                	return {
	                		label: item.label,  
	                        shform: item.shform, //can add number of attributes here   
	                        value: item.label +" , "+ item.value // I am displaying both labe and value  
	                		};
	            }));
	        });
	    }

	});
	
	$('#srf_handledby').autocomplete({
	    source: function(request, response) {
	    	var param = request.term;  
	        $.getJSON("/Myelclass/SrfAutoComplete.do?term="+param+"&action="+"handlby", 
	        		 function(result) {
	            		response($.map(result, function(item) {
	                	return {
	                		label: item.label,  
	                         //can add number of attributes here   
	                        value: item.label  // I am displaying both labe and value  
	                		};
	            }));
	        });
	    }

	});
	
	$('#srf_endusage').autocomplete({
	    source: function(request, response) {
	    	var param = request.term;  
	        $.getJSON("/Myelclass/SrfAutoComplete.do?term="+param+"&action="+"endusage", 
	        		 function(result) {
	            		response($.map(result, function(item) {
	                	return {
	                		label: item.label,  
	                         //can add number of attributes here   
	                        value: item.label  // I am displaying both labe and value  
	                		};
	            }));
	        });
	    }

	});
	
	$('#srf_paymentterms').autocomplete({
	    source: function(request, response) {
	    	var param = request.term;  
	        $.getJSON("/Myelclass/SrfAutoComplete.do?term="+param+"&action="+"pymttrms", 
	        		 function(result) {
	            		response($.map(result, function(item) {
	                	return {
	                		label: item.label,  
	                         //can add number of attributes here   
	                        value: item.label  // I am displaying both labe and value  
	                		};
	            }));
	        });
	    }

	});
	//Date Picker
		 $('.srf_deliverydate').datepicker({
			 	numberOfMonths: 2,
				formatDate:'dd/mm/y',
			    firstDay: 1, 
			});
		$("#srf_orderdate").datepicker({
			changeMonth:true,
			formatDate:'dd/mm/y',
		    firstDay: 1, 
		});
	
});