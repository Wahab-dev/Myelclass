/**
 * PRF js
 * 19.08.13
 * 
 */
$(document).ready(function() {
	var grid = $("#list"); //table id
	    
	    
	  /*   gridbtn.click( function()
		    {
			  */
	    var ctno =$('#prf_contractno').val();
		 alert(ctno);
			 grid.jqGrid({  
				url:"/Myelclass/PrfinsertArticle.do?ctno="+ctno+"&action="+"load",   
				datatype:"json",
				colNames:['Article Type','Name','ArticleId', 'Color', 'Size','Size rem','Size avg','Subs','Selec','Selec P', 'Quantity','Unit', 'Pcs','Rate sign','Rate amt','Shipment','Tc sign','Tc amt','Tc to','Article Type','Ct','PrfArtId'],  
			    colModel:[   
					{name: 'prf_articletype',index:'articletype', width:80, sortable:true, editable: true, edittype:'select',						 
							 editoptions: { 
			            		 dataUrl:'/Myelclass/PrfAutocomplete.do?action=arttype',
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
			            			/*dataEvents :[{ 
			            		        type: 'change',
			          	  		        fn: function(e) {
			            		            var thisval = $(e.target).val();
			            		          //  $.post('/Myelclass/PrfAutocomplete.do?action=artname&arttype='+thisval,
			            		           $.ajax({
											     url: '/Myelclass/PrfAutocomplete.do?action=artname&arttype='+thisval,
											     dataType: "json",
											     type:"GET",
											     success: function (data) {
											    		//var response = jQuery.parseJSON(data);
											    		alert('response'+data);
											    		response($.map(data, function(item) {
									                		 return { 
									                             label: item.label,
									                             shform: item.shform, //can add number of attributes here 
									                             value: item.label // I am displaying both labe and value
									                             };
									                         }));
											    		
											    		
								                      	var s = '<text>';
								                      	if (response && response.length) {
								                          	for (var i = 0, l=response.length; i<l ; i++) {
								                            	var ri = response[i].value;
								                             	s += '<option value="'+ri+'">'+ri+'</option>';
								                          	}
								                        	}
								                       	return s + "</text>";
											     }
											   });//END AJAX */
			            		            		
			            		            /* function(data){
			            		            	
			            		                var res = $(data).html();
			            		                alert("RES"+res);
			            		                $("#prf_articlename").html(res);
			            		            }); 
			            		        }
			            		    }]*/
			            	},
					},         
					{name:'prf_articlename', index:'articlename', width:90, sortable:true,  editable:true, edittype:'select',					     
						  editoptions:{///
						  	maxlength: 50 , value: 'Select:Select',
							   dataUrl:'/Myelclass/PrfAutocomplete.do?action=artname',
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
							},
					 },
					{name:'articleid', index:'articleid', sortable:true, width:90, editable:true, edittype:'text',hidden: false},
					{name:'prf_color', index:'color', width:80, sortable:true, align:'right', editable:true,edittype:'text',
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
								                             label: item.label,
								                             shform: item.shform, //can add number of attributes here 
								                             value: item.label // I am displaying both labe and value
								                             };
								                         }));//END Response
								                    },//END Success
								            });//END AJAX
										},
									});
									$('.ui-autocomplete').css('zIndex',1000); // z index for jqgfrid and autocomplete has been disaligned so we are manually setting it 
									}
								   }
					 			},  
					{name:'prf_size', index:'prf_size', width:55, editable:true, 
						       formatter: sizeFmatter, editoptions: {size:10}
					 },   
					{name:'prf_sizerem', index:'sizerem', width:55, editable:true,edittype:'select',align:'left',
							  editoptions:{value:{F:'F',S:'S',FS:'F/S',NA:'Double Butt'}},
					},
					{name:'prf_sizeavg', index:'sizeavg', width:55, editable:true,editoptions: {size:10}}, 
					{name:'prf_substance', index:'substance', width:90, editable:true}, 
					{name:'prf_selection', index:'selection', width:80, align:'right', editable:true, 
							  edittype:'select',
							  editoptions:{value:{A:'A',AB:'AB',ABC:'ABC',TR:'TR',Available:'Available'}}
					},  
					{name:'prf_selectionp', index:'selectionpercent', sortable:true, width:90,editable:true},   
					{name:'prf_quantity', index:'quantity', sortable:true, width:80, align:'right',
							  editable:true, editrules:{number:true}, formatter: 'number',  
							  formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.0000' },				        		  
					},  
					{name:'prf_unit', index:'unit', width:55, editable:true, edittype:'select',
							  editoptions:{value:{sqft:'sq ft',skins:'skins',Garment:'Garment',NA:'NA'}}
					},
					{name:'prf_pcs', index:'pcs', sortable:true, width:90, editable:true, 
					}, 
					{name:'prf_ratesign', index:'ratesign', width:90, sortable:true, editable:true,
							  edittype:'select',
							  editoptions:{value:{$:'$',INR:'INR',Euro:'Euro',NA:'NA'}},
					},  
					{name:'prf_rateamt', index:'rateamt', width:90, sortable:true, editable:true}, 
					{name:'prf_shipment', index:'shipment', width:90, sortable:true, editable:true, 
						      edittype:'select',
						      editoptions:{value:{Air:'Air',Sea:'Sea',Courier:'Courier',Truck:'Truck'}}
					}, 
					{name:'prf_tcsign', index:'tcsign', sortable:true, width:90, editable:true, 
					  	  edittype:'select',
					  	  editoptions:{value:{cents:'cents',paise:'paise',shillings:'shillings',NA:'NA'}}
					}, 
					{name:'prf_tcamt', index:'tcamt', sortable:true, width:90, editable:true, 
					}, 
					{name:'prf_tcto', index:'tcto', sortable:true, width:90, editable:true,
						      edittype:'select',
						      editoptions:{value:{IC:'IC',Cust:'Cust',ICMD:'IC/MD',NA:'NA'}}
					}, 
						      //editable:true,editrules:{required:true}, editoptions:{dataInit: function(element) {$(element).attr("readonly", "readonly"); }}} ---Field visible in grid, Form and read-only
					{name:'prf_articletype', index:'type', sortable:true, width:90, editable:true, 
							 	  edittype:'select', editoptions:{value:{FinishedLeather:'Finished Leather',LeatherGoods:'Leather Goods'}}
					},	
					{name:'prf_ctno', index:'prf_ctno', width:90, editable:true, hidden:true,
						 editrules:{edithidden :true},editoptions:{ 
			                           // FOR READ ONLY   
			                             dataInit: function(element) { 
			                            	 var ctnoval = $("#prf_contractno").val();
			                            	 $(element).val(ctnoval);
			                                  $(element).attr("readonly", "readonly"); 
			                             }  
			                           }
					},
					{name:'prf_articleid', index:'prf_articleid', width:90, editable:true, edittype:'text'}						  
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
		    	rowList:[2,4,6],
		        loadtext: "Bow Bow........... ",
		        height : "auto",
		        width:"auto",  
		        sortname: 'articlename',  
		        sortorder: 'desc',  
		        emptyrecords: 'No records to display',
					/* sortname: 'Name',
					ignoreCase: true,
					height: '100%',
					viewrecords: true,
					rownumbers: true,
					sortorder: "desc",
					pager: '#pager',
					caption: "Demonstrate dependend select/dropdown lists (edit on double-click)" */
			});
				 		
			grid.jqGrid('navGrid', '#pager',  { edit: true, add: true, del: true, 
						search: false, refresh: false },
						{ // edit option
		 					 top: 150,
		 					 left: 200,
		 					 beforeShowForm: function(form) { 
		 						alert("In Edit Form"); 
		 					 },
		 					
		 					 url: "/Myelclass/PrfinsertArticle.do?ctno="+ctno+"&action="+"edit",
		 					 mtype: "POST",
		 					 closeAfterEdit: true,
		 					 //editData
		 		          },
		 		          
		 				{ // add option
		 		              beforeShowForm: function(form) { 
		 		            	  alert("In Add Form");  
		 		              },
		 		        	  top: 150,
	 					 	  left: 200,
	 					 	  width : 350,
	 					 	  url: "/Myelclass/PrfinsertArticle.do?action=add",
	 					 	  mtype: "POST",
	 					 	  datatype: "json",
	 					 	  closeAfterEdit: true,	
	 					 	  afterSubmit:function(response, postdata) {
	 					 		  alert("Response frm server"+response);
	 					 	  }
		 		          },
		 		          {
		 		        	  // delete option
		 		        	 beforeShowForm: function(form) { 
		 		            	  alert("what happening in");  
		 		        	 } ,
		 		        	  top: 150,
	 					 	  left: 200,
	 					 	  width : 350,
	 					      url: "/Myelclass/PrfinsertArticle.do?prf_articleid="+ctno+"&action="+"delete",
	 					 	  mtype: "POST",
	 					 	  datatype: "json",
	 					 	  closeAfterEdit: true,	
		 		            }
		 		           
		 	);
			
			
			//Formatter 
			function sizeFmatter(cellvalue, options, rowObject){
				return rowObject.prf_color + " / " + rowObject.prf_selection;
			}
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
	
	
 
