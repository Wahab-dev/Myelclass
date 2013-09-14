/**
 * PRF js
 * 19.08.13
 * 
 */
$(document).ready(function() {
	
	
	var grid = $("#list"); //table id artinsert

	 grid.jqGrid({ 
		url:"/Myelclass/PrfinsertArticle.do",   
		datatype:"json",
		colNames:['Article ID','Article Type', 'Article Shform','Name','Color','Size','Size avg','Size Rem','Substance','Selection','Selp','Quantity','Unit','Pcs','Rate','RateSign','Rate','Shipment','Tc','tcsign','tcamt','tccust','Contract','Prfarticleid','User'],  
	    colModel:[   
			{name:'articleid', index:'articleid', width:90, sortable:true,  editable:true,  hidden: false,					     				 
			 },
			 {name:'articletype', index:'articletype', width:80, sortable:true, align:'right', editable:true, hidden: false, edittype:'select', 
				 editoptions: { 
          		 dataUrl:'/Myelclass/PrfAutocomplete.do?action=arttype',
          		 type:"GET",
          		 buildSelect: function(data) {
          		  	var response = jQuery.parseJSON(data);
                    	var s = '<select>';
                    	if (response && response.length) {
                        	for (var i = 0, l=response.length; i<l ; i++) {
                          	var ri = response[i].value;
                           	s += '<option value="'+ri+'">'+ri+'</option>';
                        		}
                      	}
                     	return s + "</select>";
                   	},
                 } 
			 },  	
			{name:'articleshfrom', index:'articleshfrom', width:55, editable:true, hidden: false
		    }, 
			{name:'articlename', index:'articlename', width:90,  editable:true, hidden: false, edittype:'text',
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
						                             size: item.size,
						                             subs: item.substance,
						                             selec:item.selection ,
						                             selp:item.selp ,
						                             rate: item.rate,
						                             tc: item.tc
						                             };
						                         }));//END Response
	
						                },//END Success
						            });//END AJAX
								},
								select: function( event, ui ) { 
									 $('#articleid').val(ui.item.id);
						          	 $('#articleshfrom').val(ui.item.shform);
						          	 $('#size').val(ui.item.size);
						          	 $('#substance').val(ui.item.subs);
						          	 $('#selection').val(ui.item.selec);
						          	 $('#selectionpercent').val(ui.item.selp);
						          	 $('#rate').val(ui.item.rate);
						          	 $('#tc').val(ui.item.tc);
						            } 
							 });
							$('.ui-autocomplete').css('zIndex',1000); // z index for jqgfrid and autocomplete has been misalignment so we are manually setting it 
							}
						   }
			}, 
			{name:'color', index:'color', width:90, sortable:true, hidden: false, editable:true, edittype:'text',
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
			{name:'size', index:'size', width:80, align:'right', hidden: false, editable:true,sortable:true,
				 editoptions: { 
						dataEvents:[{
							type: 'focusout',
							fn: function(e){
								var sizeval = $("#size").val();
								var size_minindex = sizeval.indexOf('/');
								var size_maxindex = sizeval.indexOf(' '); // in order to avoid Size remarks. Make Size remrk seperate row in Table
								var sizemin = sizeval.substring(0, size_minindex);
								var sizemax=  sizeval.substring(size_minindex+1,size_maxindex);
								var sizeavg = ( (parseFloat (sizemin) + parseFloat(sizemax)) /2) ;
								$("#sizeavg").val(sizeavg);
							}
						}]  
					  },
			},  
			{name:'sizeavg', index:'sizeavg', width:80, align:'right', editable:true, hidden: false}, 
			{name:'sizerem', index:'sizerem', width:80, align:'right', editable:true, hidden: false, 
				edittype:'select',align:'left',
				  editoptions:{value:{F:'F',S:'S',FS:'F/S',NA:'Double Butt'}},
			}, 
			{name:'substance', index:'substance', sortable:true, hidden: false, width:80, align:'right',
					  editable:true, 
			},  
			{name:'selection', index:'selection', width:90, sortable:true, hidden: false, editable:true,
				edittype:'select',
				  editoptions:{value:{A:'A',AB:'AB',ABC:'ABC',TR:'TR',Available:'Available'}}	
			}, 
			{name:'selectionpercent', index:'selectionpercent', width:90, sortable:true, editable:true, hidden: false
				
			}, 	
		
			{name:'quantity', index:'quantity', width:90, sortable:true, hidden: false, editable:true,
				editable:true, editrules:{number:true}, formatter: 'number',  
				  formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.0000' },
			}, 	
			{name:'unit', index:'unit', width:90, sortable:true, hidden: false, editable:true,
				edittype:'select',
				  editoptions:{
					  value:{sqft:'sq ft',skins:'skins',Garment:'Garment',NA:'NA'},
					  dataEvents:[{
							type: 'focusout',
							fn: function(e){
								var qty = $("#quantity").val();
								alert("qty"+qty);
								var unit = $("#unit option:selected").val();
								alert("unit"+unit);
								var sizeav = $("#sizeavg").val();
								alert("sizeav"+sizeav);
								var piecs = ((unit == "sqft") ? (parseInt (qty) / parseInt(sizeav)) : parseInt(qty)) ;
								alert(piecs);
								$("#pcs").val(parseInt(piecs));
							}
						}],
						
					  }, 
			 }, 	
			{name:'pcs', index:'pcs', width:90, sortable:true, hidden: false, editable:true}, 	
			{name:'rate', index:'rate', width:90, sortable:true, hidden: false, editable:true}, 
			{name:'ratesign', index:'ratesign', width:90, sortable:true, hidden: false, editable:true,
				  edittype:'select',
				  editoptions:{value:{$:'$',INR:'INR',Euro:'Euro',NA:'NA'}},
			},  
			{name:'rateamt', index:'rateamt', width:90, sortable:true, hidden: false, editable:true}, 
			{name:'shipment', index:'shipment', width:90, sortable:true, editable:true, hidden: false,
			      edittype:'select',
			      editoptions:{value:{Air:'Air',Sea:'Sea',Courier:'Courier',Truck:'Truck'}}
			}, 
			{name:'tc', index:'tc', width:90, sortable:true, editable:true, hidden: false}, 
			{name:'tcsign', index:'tcsign', width:90, sortable:true, editable:true, hidden: false,
				edittype:'select',
			  	  editoptions:{value:{cents:'cents',paise:'paise',shillings:'shillings',NA:'NA'}}
			}, 	
			{name:'tcamt', index:'tcamt', width:90, sortable:true, editable:true, hidden: false}, 	
			{name:'tccust', index:'tccust', width:90, sortable:true, editable:true, hidden: false,
				 edittype:'select',
			      editoptions:{value:{IC:'IC',Cust:'Cust',ICMD:'IC/MD',NA:'NA'}}
			}, 	
			{name:'contractno', index:'contractno', width:90, sortable:true, editable:true,editoptions:{readonly: true}, hidden: false}, 	
			{name:'prfarticleid', index:'prfarticleid', width:90, sortable:true, editable:true, hidden: false}, 	
			
			{name:'user', index:'user', width:90, sortable:true, editable:true, hidden: false}, 	
									  
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
      height : "auto",
      width:"auto",  
      sortname: 'articlename',  
      sortorder: 'desc',  
      emptyrecords: 'No records to display',
      editurl: "/Myelclass/PrfinsertArticle.do",
		}).jqGrid('navGrid','#pager',{add:true, edit:true, del:true, search: false}, 
			{ // edit option
			  beforeShowForm: function(form) { 
				  alert("Hola ");
		      },
		   	  closeAfterEdit: true,
		    },
		    { // add option
		    	 top: 150,
			 	  left: 200,
			 	  width : 350,
			 	 onCellSelect : function(rowid, iCol, cellcontent) {
			 		alert("2345");
			 		var myval =grid.jqGrid('getCell', rowid,'substance');
			 		alert("myval  "+myval);
			 	 },
		          beforeShowForm: function(form) { 
		           	 var ctnoval = $("#prf_contractno").val();
		           	 $("#contractno").val(ctnoval);
		          },
				  closeAfterAdd: true,
			 },
			 {
					// del option
					 
			 }    
	 	);
		 	
		
			
			
			//Formatter 
			/*function sizeFmatter(cellvalue, options, rowObject){
				return rowObject.prf_color + " / " + rowObject.prf_selection;
			}*/
		//Commssion AutoComplete 		
			 $('#prf_elclasscommission').autocomplete({
					minLength: 1,
					source: function(request, response,term) {
						var param = request.term;
						 $.ajax({
				                url: "/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"commision",
				                dataType: "json",
				                type:"POST",
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
		 $('#prf_commission').autocomplete({
				minLength: 1,
				source: function(request, response,term) {
					var param = request.term;
					 $.ajax({
			                url: "/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"othercommision",
			                dataType: "json",
			                type:"POST",
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
			                type:"POST",
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
			                type:"POST",
			                success: function (data) {
			                	 response($.map(data, function(item) {
			                		 return { 
			                			 label : item.label,
			                			 value: item.value,
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
			          	  var fone = ui.item.fone; 
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
			                type:"POST",
			                success: function (data) {
			                	 response($.map(data, function(item) {
			                		 return { 
			                			 label : item.label,
			                			 value: item.value,
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
		                    url: "/Myelclass/AutoCompleteServlet.do?term="+param+"&action="+"desti",  
		                    dataType: "json",  
		                    type:"POST",  
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
		            select: function( event, ui ) { //   
		              var shortform = ui.item.shform; //On Select Pass Event   
		              alert(shortform);  
		            }   
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
		        
				
				/* $('#addcommission').click(function (){
					//Y dont u use Multiselect Autocomplete
					alert("Assalamu alaikum");
				}); */
				 
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
			
			 
			
			
			//Commision Add 
				 var counter = 2;
		  		  $("#addButton").click(function () {
					if(counter>7){
		           		alert("Only 8 commission are allowed");
		            	return false;
					}   
					var newTextBoxDiv = $(document.createElement('div')) // Please check here  
				     .attr("id", 'prfcommissiondiv' + counter);
			 
					newTextBoxDiv.after().html('Commssion #'+ counter + ' : ' +
				      '<h:text property="prf_commission' + counter + 
				      '" value="" ></h:text><br /><br/>');
			 
					newTextBoxDiv.appendTo("#prfcommissiongroup");
				counter++;
				alert(counter);
			     });
		  		 $("#removeButton").click(function () {
		  			if(counter==2){
		  		          alert("No more textbox to remove");
		  		          return false;
		  		       }
		  			counter--;
		  			alert(counter);
		  		        $("#prfcommissiondiv" + counter).remove();
		  		 
		  		     });
 });

	
	
 
