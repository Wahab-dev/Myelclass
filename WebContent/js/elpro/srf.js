/**
 * SRF js
 * 21.09.13
 * 
 */
$(document).ready(function() {
	//UI MODAL FORM FOR POJW
	/* $("#srfdialogform").dialog({
		autoOpen: true,
	    resizable: true,
	    width: 980,
	    height: 600,
	    autoResize: true, 
	    modal:false,  
	    jqModal:true,
	    title : "Raise SRF Form",
	 }).css("font-size", "12px");
	*/
	
	$.get("/Myelclass/SrfAutoComplete.do?action="+"sampleno", 
		 function(data){
		 	if($("#srfactionform").val().toLowerCase() == "edit" ){	
		 	}else{
		 		$("#srf_sampleno").val(data); 
		 		$.trim($("#srf_sampleno").val());
		 	}
		 },"text");
	
	
	 var grid = $("#srfArticletbl"); 
		grid.jqGrid({ 
			         datatype: "json",
				     url:"/Myelclass/SrfinsertArticle.do", 
			         mtype: "GET", 
			     	autoencode: true,
			         postData: {
			        	 sampleno: function (){return $("#srf_sampleno").val();},
				    },
				     colNames:['ArticleID', 'ArticleShForm', 'ArticleType','Article name','Color', 'Size','Sizeavg','Size Rem','Substance', 'Selection','Selectionp', 'Quantity','Unit','Pieces','Price','Currency','Price','Shipment','Colormatching','Tapetest','Crockingwet','CrockingDry','Fourfolds','Keytest','SampleNo','User','Srfarticleid'],  
			         colModel :[   
			                    {name:'articleid',index:'articleid',align:'center', editable:true, sortable:true, hidden:true,
			                    	formoptions:{rowpos: 1, colpos: 1}, 
			                    },  
			                    {name:'srf_articleshform', index:'articleshform', align:'center', width:80, editable:true, sortable:true, hidden:true,
			                    	formoptions:{rowpos: 1, colpos: 2}, 
			                    },
			                    {name:'srf_articletype',index:'articletype', align:'center', width:80, editable:true, sortable:true, hidden:false, edittype:'select',
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
			                             formoptions:{rowpos: 2, colpos: 1}, 
			                    },  
			                    {name:'srf_articlename', index:'articlename',  align:'center', width:80, editable:true, sortable:true, hidden:false,
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
			      						                             
			      						                             };
			      						                         }));//END Response
			      	
			      						                },//END Success
			      						            });//END AJAX
			      								},
			      								select: function( event, ui ) { 
			      									 $('#articleid').val(ui.item.id);
			      						          	 $('#srf_articleshform').val(ui.item.shform);
			      						        	 $('#srf_color').val(ui.item.clr);
			      						          	 $('#srf_size').val(ui.item.size);
			      						          	 $('#srf_sizeremarks').val(ui.item.sizeremar);
			      						          	 $('#srf_substance').val(ui.item.subs);
			      						          	 $('#srf_selection').val(ui.item.selec);
			      						          	 $('#srf_selectionp').val(ui.item.selp);
			      						          	 $('#srf_ratesign').val(ui.item.ratesign);
			      						          	 $('#srf_rateamt').val(ui.item.rateamt);
			      						          	 $('#srf_shipment').val(ui.item.shipment);
			      						            } 
			      							 });
			      							$('.ui-autocomplete').css('zIndex',1000); // z index for jqgfrid and autocomplete has been misalignment so we are manually setting it 
			      							}
			      		    	  	},	
			      		    	  formoptions:{rowpos: 2, colpos: 2}, 
			                    },  
			                    {name:'srf_color', index:'color',  align:'center', width:80, editable:true, sortable:true, hidden:false, edittype:'text', 
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
			       						   },
			                    formoptions:{rowpos: 3, colpos: 1}, 
			                    },  
			                    {name:'srf_size', index:'size', align:'center', width:80, editable:true, sortable:true, hidden:false, 
			                    	editoptions: { 
			    						dataEvents:[{
			    							type: 'focusout',
			    							fn: function(e){
			    								var sizeval = $("#srf_size").val();
			    								var size_minindex = sizeval.indexOf('/');
			    								//var size_maxindex = sizeval.indexOf(' '); // in order to avoid Size remarks. Make Size remrk seperate row in Table
			    								var sizemin = sizeval.substring(0, size_minindex);
			    								var sizemax=  sizeval.substring(size_minindex+1);
			    								var sizeavg = ( (parseFloat (sizemin) + parseFloat(sizemax)) /2) ;
			    								$("#srf_sizeavg").val(sizeavg);
			    							}
			    						}]  
			    					  },
			    					  editrules: {required: true},
			    					  formoptions:{rowpos: 4, colpos: 1}, 
			    				},  
			                    {name:'srf_sizeavg', index:'sizeavg',  align:'center', editable:true, sortable:true, hidden:true,
			    					editrules:{edithidden:true},	
			    					formoptions:{rowpos: 4, colpos: 2}, 
			                    },
			                    {name:'srf_sizeremarks', index:'sizerem', width:40, align:'center',  editable:true, hidden: true, 
			        				edittype:'select',
			        				editoptions:{value:{0: 'Select Size Remarks', F:'F', S:'S', FS:'FS', DB:'Double Butt',NA:'NA'}},
			        				editrules:{edithidden:true},
			        				formoptions:{rowpos: 4, colpos: 3}, 
			        			}, 
			                    {name:'srf_substance', index:'substance', align:'center', width:80, editable:true, sortable:true, hidden:false,  
			        				formoptions:{rowpos: 5, colpos: 1}, 	
			                    }, 
			                    {name:'srf_selection', index:'selection', align:'center', width:80, editable:true, sortable:true, hidden:false, edittype:'select',			                    	
			                    	editoptions: { 
			              			  dataUrl:'/Myelclass/PrfAutocomplete.do?action=selec',
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
			                    	
			                       //editoptions:{value:{0:'Select Selection %',A:'A',AB:'AB',ABC:'ABC',TR:'TR',Available:'Available',TBA:'TBA'}},
			      				  formoptions:{rowpos: 5, colpos: 2},
			    				},  
			                    {name:'srf_selectionp', index:'selectionp',  align:'center', width:80, editable:true, sortable:true, hidden:true, 
			    					editrules:{edithidden:true},
			    					formoptions:{rowpos: 5, colpos: 3},
			    				},   
			                    {name:'srf_qty', index:'quantity', align:'center', width:80, editable:true, sortable:true, hidden:false, 
			                      editrules:{number:true}, formatter: 'integer',  
			      				  //formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.0000' },
			      				  formoptions:{rowpos: 6, colpos: 1},
			                    },  
			                    {name:'srf_unit', index:'unit' , align:'center', width:80, editable:true, sortable:true, hidden:false, 
			                    	edittype:'select',
			      				  editoptions:{
			      					  value:{0:'Select Quantity Unit',skins:'skins',skin:'skin',sqft:'sq ft',Garment:'Garment',NA:'NA'},
			      					  dataEvents:[{
			      							type: 'focusout',
			      							fn: function(e){
			      								var qty = $("#srf_qty").val();
			      								var unit = $("#srf_unit option:selected").val();
			      								var sizeav = $("#srf_sizeavg").val();
			      								var piecs = ((unit == "sqft") ? (parseInt (qty) / parseInt(sizeav)) : parseInt(qty)) ;
			      								$("#srf_pieces").val(parseInt(piecs));
			      							}
			      						}],
			      						
			      					  },
			      					formoptions:{rowpos: 6, colpos: 2},
			                    }, 
			                    {name:'srf_pieces', index:'pcs', align:'center', width:80, sortable:true, hidden: false, editable:true,
			                    	formoptions:{rowpos: 6, colpos: 3},
			                    }, 
			                    {name:'srf_price', index:'price',  align:'center', width:80, editable:true, sortable:true, hidden:false,
			                    	formoptions:{rowpos: 7, colpos: 1},
			                    },   
			                    {name:'srf_ratesign', index:'currency',  align:'center', editable:true, sortable:true, hidden:true, 
			                    	 edittype:'select',
			       				     editoptions:{value:{0:'--- Select Currency --- ',$:'$',Rs:'Rs',Euro:'Euro',NA:' Not Available'}},
			                    	//   editoptions:{value:  "TBA:TBA;$:$; �:�; NA:NA;"},
			       				     editrules:{edithidden:true},	
			       				  formoptions:{rowpos: 8, colpos: 1},
			                    },  
			                    {name:'srf_rateamt', index:'rateamt',  align:'center', editable:true, sortable:true, hidden:true, 
			                    	editrules:{edithidden:true}, 
			                    	 formoptions:{rowpos: 8, colpos: 2},
			                    },   
			                    {name:'srf_shipment', index:'shipment',  align:'center', editable:true, sortable:true, hidden:true, 
			                      edittype:'select',
			                      editoptions:{value:{0:'--- Select Shipment --- ',Air:'Air',Sea:'Sea',Courier:'Courier',Truck:'Truck',Train:'Train',Fob:'Fob',ExChennai:'Ex Chennai',ExRanipet:'Ex Ranipet',ExFactory:'Ex-Factory',NA:'NA',TBA:'TBA'}},
			       			      editrules:{edithidden:true},	
			       			      formoptions:{rowpos: 8, colpos: 3},
			                    },  
			                    {name:'srf_colormatch', index:'colormatching', align:'center', editable:true, sortable:true, hidden:true, 
			                    	 edittype:'select',
			                    	 editoptions: { 
			               			  dataUrl:'/Myelclass/PrfAutocomplete.do?action=colormatch',
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
				       			      editrules:{edithidden:true},	
				       			   formoptions:{rowpos: 9, colpos: 1},
			                    },   
			                    {name:'srf_tapetest', index:'tapetest', align:'center', editable:true, sortable:true, hidden:true, 
			                    	 edittype:'select',
				       			      editoptions:{value:{0:'--- Select tapetest --- ',APC:'As per Cutting',APS:'As per swatch',Good:'Good',Medium:'Medium',NA :'NA'}},
				       			      editrules:{edithidden:true},	
				       			   formoptions:{rowpos: 9, colpos: 2},
			                    },  
			                    {name:'srf_crockwet', index:'crockingwet', align:'center', editable:true, sortable:true, hidden:true, 
			                    	 edittype:'select',
				       			      editoptions:{value:{0:'--- Select crockingwet --- ',APC:'As per Cutting',APS:'As per swatch',Good:'Good',NA :'NA'}},
				       			      editrules:{edithidden:true},	
				       			   formoptions:{rowpos: 9, colpos: 3},
			                    },  
			                    {name:'srf_crockdry', index:'crockingdry', align:'center', editable:true, sortable:true, hidden:true, 
			                    	 edittype:'select',
				       			      editoptions:{value:{0:'--- Select crockingdry --- ',APC:'As per Cutting',APS:'As per swatch',Good:'Good',NA :'NA'}},
				       			      editrules:{edithidden:true},	
				       			   formoptions:{rowpos: 10, colpos: 1},
			                    }, 
			                    {name:'srf_fourfold', index:'fourfolds',  align:'center', editable:true, sortable:true, hidden:true, 
			                    	 edittype:'select',
				       			      editoptions:{value:{0:'--- Select fourfolds --- ',Required:'Required',NA:'NA'}},
				       			      editrules:{edithidden:true},	
				       			   formoptions:{rowpos: 10, colpos: 2},
			                    },  
			                    {name:'srf_keytest', index:'keytest',  align:'center', editable:true, sortable:true, hidden:true, 
			                    	 edittype:'select',
				       			      editoptions:{value:{0:'--- Select keytest --- ',Required:'Required',NA:'NA'}},
				       			      editrules:{edithidden:true},
				       			   formoptions:{rowpos: 10, colpos: 3},
			                    }, 
			                    {name:'srf_samplenum', index:'samplenum', align:'center', width:80, editable:true, sortable:true, hidden:false, 
			                    	formoptions:{rowpos: 11, colpos: 1},
			                    },
			                    {name:'user', index:'user', width:90, align:'center', sortable:true, editable:true, hidden: false,
			                    	formoptions:{rowpos: 11, colpos: 2},
			                    },
			                    {name:'srf_articleid', index:'srfarticleid', align:'center', editable:true, sortable:true, hidden:true, 
			                    },
			                    ],  
			        jsonReader : {  
			            repeatitems:false,
			       	    root: "rows",
			            page: "page", //calls first
			            total: "total" ,//calls Second
			            records: "records" //calls Third
			            }, 
			        pager: '#srfArticlepager',
			    	rowNum:7, 
			    	viewrecords: true ,
			    	rowList:[7,10,15],
			        loadtext: "Bow Bow",
			        height: 'automatic',
			        width: 'automatic',
			        sortname: 'articleid',  
			        sortorder: 'desc',  
			        emptyrecords: 'No records to display',
			        editurl: "/Myelclass/SrfinsertArticle.do", 
			        }); 
		grid.jqGrid('navGrid','#srfArticlepager',{edit:true,add:true,del:true, search:true, view:false},
		{
		  //Edit 
		  top: 150,
		  left: 200,
		  width : 850,
		  recreateForm: true,
		  beforeShowForm: function(form) { 
			  //Size Calculation
			  var sizec = $("#srf_size").val();
			  var temp = sizec.indexOf(' ');
			  $("#srf_size").val(sizec.substring(0, temp));
			  $("#srf_sizeremarks").val(sizec.substring(temp+1));
				 
			  //Size Avg Calculation
			  var sizeval = $("#srf_size").val();
			  var size_minindex = sizeval.indexOf('/');
			  var sizemin = sizeval.substring(0, size_minindex);
			  var sizemax=  sizeval.substring(size_minindex+1);
			  var sizeavg = ( (parseFloat (sizemin) + parseFloat(sizemax)) /2) ;
			  $("#srf_sizeavg").val(sizeavg);
					
			//Rate Calculation
			  var ratec = $("#srf_price").val();
			  var ratemp = ratec.indexOf(' ');
		      var ratemplast = ratec.lastIndexOf(' ');
			  $("#srf_ratesign").val(ratec.substring(0, ratemp));
			  $("#srf_rateamt").val(ratec.substring(ratemp+1, ratemplast));
			  $("#srf_shipment").val(ratec.substring(ratemplast+1));
				 
			  $("#tr_srf_price").hide();
		      },
		      closeAfterEdit: true,
			reloadAfterSubmit: true,
			
		},		
		{
			//Add
			beforeShowForm: function(form) { 
			
	           	 $("#srf_samplenum").val($("#srf_sampleno").val());
	           	 $("#user").val($("#userinsession").val());
	             $("#tr_srf_price").hide(); // hide the tr prf_rat
	          },
	          closeAfterAdd: true,
			  reloadAfterSubmit: true,
			  top: 150,
			  left: 200,
			  width : 850,
			
		},
		{
			//Del
			beforeShowForm: function ($form) {
				 var sel_id = grid.jqGrid('getGridParam', 'selrow');
                 var value = grid.jqGrid('getCell', sel_id, 'srf_color');
			    $("td.delmsg", $form[0]).html("Delete Row for <b>Color=" +value+"</b>?");
			},
			delData: {
				//Function to Add parameters to the delete 
				//Here i am passing artid with val 
				srf_articleid: function() {
                        var sel_id = grid.jqGrid('getGridParam', 'selrow');
                        var value = grid.jqGrid('getCell', sel_id, 'srf_articleid');
                        return value;
                     }
                 },
				reloadAfterSubmit: true, 
		});
		/*grid.jqGrid('navGrid', '#srfArticlepager', {
	         addtext: 'Add',
	         edittext: 'Edit',
	         deltext: 'Delete',
	         searchtext: 'Search',
	         refreshtext: 'Reload',
	         viewtext: 'View'
	     });*/
			
	//Autocomplete
	 $('#srf_tanname').autocomplete({
		 	/*autoFill: true,
			mustMatch: true,
			matchContains: false,*/
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
			                       id: item.tanneryId,
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
			        $('#srf_tannameid').val(ui.item.id);
			  } ,
			}).focus(function(){            
	            $(this).trigger('keydown.autocomplete');
	        }).addClass("ui-corner-all"); 
		  $('#srf_deliver').autocomplete({
			 source: function(request, response) {
				var param = request.term;  
			 	$.getJSON("/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"deliver",
					function(result) { 	
			             response($.map(result, function(item) {
			                return { 
			                       value: item.label,
			                       addr: item.customerAddress,
			                       phone: item.customerTelephone,	
			                       attn : item.customerAttention,
			                       fax: item.customerFax,
			                       id: item.customerId,
			                       };
			                     }));//END response
			                    }
					 );
					},
					select: function( event, ui) { 
			          	 $('#srf_deliveraddr').val(ui.item.addr);
			          	 $('#srf_deliverphone').val(ui.item.phone);
			          	 $('#srf_deliverattn').val(ui.item.attn);
			          	 $('#srf_deliverfax').val(ui.item.fax);
			          	$('#srf_deliverid').val(ui.item.id);
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
			                        value: item.label,
			                        id: item.customerId// I am displaying both labe and value  
			                	};
			            }));
			        });
			    },
			    select: function( event, ui) { 
		          	$('#srf_customerid').val(ui.item.id);
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
	/*
	 * Implement Multi Select 
	 */
	function split( val ) {
	      return val.split( /,\s*/ );
	    }
	    function extractLast (term) {
	      return split(term).pop();
	    }

	$('#srf_endusage') 
	// don't navigate away from the field on tab when selecting an item
    .bind( "keydown", function( event ) {
        if ( event.keyCode === $.ui.keyCode.TAB &&
            $( this ).data( "ui-autocomplete" ).menu.active ) {
          event.preventDefault();
        }
      })
	.autocomplete({
		 minLength: 1,
	    source: function(request, response) {
	        $.getJSON("/Myelclass/SrfAutoComplete.do?&action="+"endusage",
	        		{term : extractLast(request.term
		        	)}).done(function(data) {
	            		response($.map(data, function(item) {
	                	return {
	                		label: item.label,  
	                         //can add number of attributes here   
	                        value: item.label // I am displaying both labe and value  
	                		};
	            }));
	        });
	    },
	    focus: function() {
	          // prevent value inserted on focus
	          return false;
	        },
	        select: function( event, ui ) {
	          var terms = split( this.value );
	          // remove the current input
	          terms.pop();
	          // add the selected item
	          terms.push( ui.item.value );
	          // add placeholder to get the comma-and-space at the end
	          terms.push( "" );
	          this.value = terms.join( ", " );
	          return false;
	        }
	      }).autosize({append: "\n"});
	
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
	 var unavailableDates = ["14-04-2014", "01-01-2014", "14-01-2014", "01-05-2014", "01-01-2014", "15-08-2014"];
	 function unavailable(date) {
	        dmy = date.getDate() + "-" + (date.getMonth() + 1) + "-" + date.getFullYear();
	        if ($.inArray(dmy, unavailableDates) == -1) {
	            return [true, ""];
	        } else {
	            return [false, "", "Unavailable"];
	        }
	    }
	 
	//Date Picker
		 $('.srf_deliverydate').datepicker({
			 autoSize: true,
			    changeMonth:false,
			    dateFormat: "dd-mm-yy",
			    showWeek: true,
			    firstDay: 1,
			    numberOfMonths: 2,
			    showButtonPanel: false,
			    gotoCurrent:true, 
		 		beforeShowDay:unavailable
			   
			});
		$("#srf_orderdate").datepicker({
				 autoSize: true,
			    changeMonth:false,
			    dateFormat: "dd-mm-yy",
			    showWeek: true,
			    firstDay: 1,
			    numberOfMonths: 1,
			    showButtonPanel: false,
			    gotoCurrent:true, 
			    beforeShowDay: function(date) {
			        var day = date.getDay();              // Disable only Sundays
			        return [(day != 0), ''];
			    } 
			    
		});
		/*$("#Save").click(function(){	
			var savePrfForm = $("#savePrfForm").serialize();
			alert(savePrfForm);
		});*/
});