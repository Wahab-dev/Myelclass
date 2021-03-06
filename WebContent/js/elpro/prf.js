/**
 * PRF js
 * 19.08.13
 * 
 */
$(document).ready(function() {
	/*
	 * Function to check the select tag is not selected 
	 */
	function fnc_chkselecttagempty(value, colName) {
		if (value.toUpperCase() === "NULL")
			return [false, colName + ": Shouldnot be Empty "];
		else
			return [true, ""];
		} 
	
	
	$("#pojw_pojwno").focusin(function() {
		 $.get("/Myelclass/PrfAutocomplete.do?action="+"pojwno", 
		 	function(data){
			 if($("#prfactionform").val().toLowerCase() == "add" ){
				 $("#pojw_pojwno").val(data); 
			 }else{
				 $("#pojw_pojwno").val($("#prf_pojwno").val()); 
			 }
		 	},"text"); 
	 });
		 
	 $('#pojw_tanname').autocomplete({
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
			                       id: item.tanneryId
			                       };
			              }));//END response
			           }
				);
			 	$('.ui-autocomplete').css('zIndex',1234);
		 	},
			select: function( event, ui) {
			     $('#pojw_tanaddr').val(ui.item.addr);
			     $('#pojw_tanphone').val(ui.item.phone);
			     $('#pojw_tanattn').val(ui.item.attn);
			     $('#pojw_tanfax').val(ui.item.fax);
			     $('#pojw_tanid').val(ui.item.id);
			     $('#pojw_payterms').val('By local Cheque on or before 30 days from invoice date in Indian Rupee at prevailing exchange rates.');
	        } ,	
	        change: function(event,ui){
		    	 $(this).val((ui.item ? ui.item.value : ""));
		   }
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
			                       id: item.tanneryId
			                       };
			                     }));//END response
			                    }
					 );
					},
					select: function( event, ui) { 
						var value = ui.item.value;
						if(value == ("International Corporation")){// As per Mary on 11 July Only IC 
						//if(value == ("International Corporation") || value == ("Conceria International Pvt Ltd")){
			          		$('#pojw').removeAttr('disabled');
			          		$('#Btnprfsave').attr('disabled','disabled');
			          	}else{
			          		$('#pojw').attr('disabled','disabled');
			          		$('#Btnprfsave').removeAttr('disabled');
			          	}
			          	$('#prf_tanaddr').val(ui.item.addr);
			          	$('#prf_tanphone').val(ui.item.phone);
			          	$('#prf_tanattn').val(ui.item.attn);
			          	$('#prf_tanfax').val(ui.item.fax);
			        	$('#prf_tannid').val(ui.item.id);
			       },
			       change: function(event,ui){
				    	 $(this).val((ui.item ? ui.item.value : ""));
				   }
			}); 
	 
/*	$.extend($.jgrid.edit, {
	    bSubmit: "Save",
	    bCancel: "Cancel",
	    width: 370,
	    recreateForm: true,
	    beforeShowForm: function () {
	     
	    }
	});*/
	
	function selecpcheck(value,colName){
		/*
		 * Fuction to check the selection percent always 100 
		 * Will Work with split type % also
		 */
		var sum = 0;
		$.map(($("#prf_selectionp").val()).split('-'), function(value){
			sum += parseInt(value, 10);
			return sum;
		});
		if(!(sum == 100))return [false,"Sum of Selection Percent Should be 100"];
		else return [true,""]; 
	}
	
	var grid = $("#list"); //table id artinsert
	 grid.jqGrid({ 
		url:"/Myelclass/PrfinsertArticle.do", ///   
		datatype:"json",
		mtype: "GET",
		postData: {
		        ctno: function (){return $("#prf_contractno").val();},
	    },
		colNames:['Article Type','Article ','Article Shform', 'Article ID','Color','Size','Size Avg','Size Rem','Substance','Selection','Selection Percent','Quantity','Unit','Pcs','Price','Currency','Price','Shipment','T c','TC Price','TC Currency','TC Cust','Contract','User','Prfarticleid'],  
	    colModel:[   
			 {name:'prf_articletype', index:'articletype', width:80, align:'center', sortable:true, editable:true, hidden: false, edittype:'select',
				 editoptions: { 
				   dataUrl:'/Myelclass/PrfAutocomplete.do?action=arttype',
          		   buildSelect: function(data) {
          		  	var response = jQuery.parseJSON(data);
                    	var s = '<select style="width: 520px">';
                    	if (response && response.length) {
                        	s += '<option value="NULL">--- Select Article Type ---</option>';
                    		for (var i = 0, l=response.length; i<l ; i++) {
                          	var ri = response[i].value;
                           	s += '<option value="'+ri+'">'+ri+'</option>';
                        	}
                      	}
                     	return s + "</select>";
                   },
                 } ,
                 editrules: {required: true, custom:true, custom_func: fnc_chkselecttagempty},
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
					        },	
						    change: function(event,ui){
						    	$(this).val((ui.item ? ui.item.value : ""));
						    }
						 });
					$('.ui-autocomplete').css('zIndex',1000); // z index for jqgfrid and autocomplete has been misalignment so we are manually setting it 
					}
		    	}, 
		    	editrules :{required : true},
		    	formoptions:{rowpos: 1, colpos: 2} 
			}, 
			{name:'artshform', index:'articleshfrom', width:55, align:'center', sortable:true, editable:true, hidden: true,	
				//formoptions:{rowpos: 1, colpos: 3},
				//editrules :{required : true},
			}, 
			{name:'articleid', index:'articleid', align: 'center', width:40, sortable:true,  editable:true, hidden: true,					     				 
				editrules :{required : true},
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
						           type:"GET",
						           success: function (data) {
						           	 response($.map(data, function(item) {
						            	 return { 
						                    label: item.value,
						                    value: item.value // I am displaying both labe and value
						                 };
						             }));//END Response
						           },//END Success
						        });//END AJAX
							},	
					        change: function(event,ui){
						    	 $(this).val((ui.item ? ui.item.value : ""));
						   }
						});
					$('.ui-autocomplete').css('zIndex',1000); // z index for jqgfrid and autocomplete has been misalignment so we are manually setting it 
					}
				 },
			     editrules :{required : true},
			     formoptions:{rowpos: 1, colpos: 3},
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
				editoptions: { 
					dataUrl:'/Myelclass/PrfAutocomplete.do?action=sizerem',
        			type:"GET",
        			buildSelect: function(data) {
        				var response = jQuery.parseJSON(data);
        			    var s = '<select style="width: 520px">';
        			    if (response && response.length) {
        			    	s += '<option value="NULL">-- Select Size Remarks --</option>';
        			  	    for (var i = 0, l=response.length; i<l ; i++) {
        			  	    	var ri = response[i].value;
        			            s += '<option value="'+ri+'">'+ri+'</option>';
        			       	}
        			    }
        			return s + "</select>";
        			},
        		} ,
				// editoptions:{value:{0: 'Select Size Remarks', F:'F', S:'S', FS:'FS', DB:'Double Butt', sqinchSingleButt:'sq inch / SingleButt',  NA:'NA', }},
				editrules: {required: true, custom:true, custom_func: fnc_chkselecttagempty},
				formoptions:{rowpos: 6, colpos: 2} ,	
			}, 
			{name:'prf_substance', index:'substance', align:'center', sortable:true, hidden: false, width:80,
				editable:true, formoptions:{rowpos: 7, colpos: 1},editrules :{required : true}, 	
			},  
			{name:'prf_selection', index:'selection', align:'center', width:90, sortable:true, hidden: false, editable:true,
				edittype:'select',
				editoptions: { 
        			  dataUrl:'/Myelclass/PrfAutocomplete.do?action=selec',
        			  type:"GET",
        			  buildSelect: function(data) {
        			   	var response = jQuery.parseJSON(data);
        			        	var s = '<select style="width: 520px">';
        			        	if (response && response.length) {
        			            	s += '<option value="NULL">--Select Article Selection--</option>';
        			  	            for (var i = 0, l=response.length; i<l ; i++) {
        			                  var ri = response[i].value;
        			               	  s += '<option value="'+ri+'">'+ri+'</option>';
        			            	}
        			          	}
        			       return s + "</select>";
        			   },
        			 } ,
        		editrules: {required: true, custom:true, custom_func: fnc_chkselecttagempty},
				formoptions:{rowpos: 7, colpos: 2} 
			}, 
			{name:'prf_selectionp', index:'selectionpercent', align:'center', width:90, sortable:true, editable:true, hidden: false,
				editrules :{required : true},
				editrules:{custom:true, custom_func:selecpcheck}, 
				formoptions:{rowpos: 7, colpos: 3} ,
			}, 	
		
			{name:'prf_quantity', index:'quantity', width:90, align:'center', sortable:true, hidden: false, 
				editable:true, editrules:{required : true, number:true}, formatter: 'integer',  // -- Allow only whole number - change to number to allow decimal  
				  //formatoptions: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.0000' },
				  formoptions:{rowpos: 8, colpos: 1} 
			}, 	
			{name:'prf_unit', index:'unit', width:90, align:'center', sortable:true, hidden: false, editable:true,
				edittype:'select',
				  editoptions:{
					  dataUrl:'/Myelclass/PrfAutocomplete.do?action=qtyunit',
						type:"GET",
						buildSelect: function(data) {
							var response = jQuery.parseJSON(data);
							var s = '<select style="width: 520px">';
							if (response && response.length) {
								s += '<option value="NULL">--- Select Quantity Unit ---</option>';
								for (var i = 0, l=response.length; i<l ; i++) {
									var ri = response[i].value;
								    s += '<option value="'+ri+'">'+ri+'</option>';
								}
							}
							return s + "</select>";
						},
					 // value:{0:'Select Quantity Unit',sqft:'sq ft',skin:'skin',skins:'skins',Garment:'Garment',NA:'NA'},
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
						
					  },
				 editrules: {required: true, custom:true, custom_func: fnc_chkselecttagempty},
				 formoptions: {rowpos: 8, colpos: 2},
			 }, 	
			{name:'prf_pieces', index:'pcs', width:90, align:'center', sortable:true, hidden: false, editable:true,
				editrules :{required : true},
				formoptions: {rowpos: 8, colpos: 3},
			}, 	
			{name:'prf_rate', index:'rate', width:90, align:'center', sortable:true, hidden: false, editable:true,
				editrules:{edithidden:true}, 
				formoptions: {rowpos: 9, colpos: 1},
				
			}, 
			{name:'prf_ratesign', index:'ratesign', width:90, align:'center', sortable:true, hidden: true, editable:true,
				 edittype:'select',
				 editoptions: { 
					dataUrl:'/Myelclass/PrfAutocomplete.do?action=currency',
					type:"GET",
					buildSelect: function(data) {
						var response = jQuery.parseJSON(data);
						var s = '<select style="width: 520px">';
						if (response && response.length) {
							s += '<option value="NULL">--- Select Currency Type---</option>';
							for (var i = 0, l=response.length; i<l ; i++) {
								var ri = response[i].value;
							    s += '<option value="'+ri+'">'+ri+'</option>';
							}
						}
					return s + "</select>";
					},
				 } ,
				 // editoptions:{value:{0:'--- Select Currency --- ',$:'$',Rs:'Rs',Euro:'Euro',NA:' Not Available'}},
				 // editrules:{edithidden:true,required : true}, 
				 editrules: {edithidden:true,required: true, custom:true, custom_func: fnc_chkselecttagempty},
				 formoptions: {rowpos: 10, colpos: 1},
			},  
			{name:'prf_rateamt', index:'rateamt', width:90, align:'center', sortable:true, hidden: true, editable:true,
				 editrules:{edithidden:true,required : true}, 
				 formoptions: {rowpos: 10, colpos: 2},	
			}, 
			{name:'prf_shipment', index:'shipment', width:90, align:'center', sortable:true, editable:true, hidden: true,
			      edittype:'select',
			      editoptions: { 
			      	dataUrl:'/Myelclass/PrfAutocomplete.do?action=shipment',
			      	type:"GET",
			      	buildSelect: function(data) {
			      		var response = jQuery.parseJSON(data);
			      		var s = '<select style="width: 520px">';
			      		if (response && response.length) {
			      			s += '<option value="NULL">--- Select Shipment Type---</option>';
			      			for (var i = 0, l=response.length; i<l ; i++) {
			      				var ri = response[i].value;
			      			    s += '<option value="'+ri+'">'+ri+'</option>';
			      			}
			      		}
			      	return s + "</select>";
			      	},
			      } ,
			    //  editoptions:{value:{0:'--- Select Shipment --- ',Air:'Air',Sea:'Sea',Courier:'Courier',Truck:'Truck',Train:'Train',Fob:'Fob',ExChennai:'Ex Chennai',ExRanipet:'Ex Ranipet',ExFactory:'Ex-Factory',NA:'NA',TBA:'TBA'}},
			    //editrules:{edithidden:true, required : true},	
			    editrules: {edithidden:true,required: true, custom:true, custom_func: fnc_chkselecttagempty},
   			    formoptions:{rowpos: 10, colpos: 3},
			}, 
			{name:'prf_tc', index:'tc', width:90, align:'center', sortable:true, editable:true, hidden: false,
				
			},  	
			{name:'prf_tcamt', index:'tcamt', width:90, align:'center', sortable:true, editable:true, hidden: true,
				editrules:{edithidden:true}, 
				formoptions: {rowpos: 12, colpos: 2},
			}, 	
			{name:'prf_tccurrency', index:'tcsign', width:90, align:'center', sortable:true, editable:true, hidden: true,
				edittype:'select',
				editoptions: { 
					dataUrl:'/Myelclass/PrfAutocomplete.do?action=subcurrency',
					type:"GET",
					buildSelect: function(data) {
						var response = jQuery.parseJSON(data);
						var s = '<select style="width: 520px">';
						if (response && response.length) {
							s += '<option value="NULL">--- Select TC Currency---</option>';
							for (var i = 0, l=response.length; i<l ; i++) {
								var ri = response[i].value;
							    s += '<option value="'+ri+'">'+ri+'</option>';
							}
						}
					return s + "</select>";
					},
				 } ,			
				//editoptions:{value:{0:'Select TC currency ',cents:'cents',paise:'paise',shillings:'shillings',NA:'NA'}},
			  	//editrules:{edithidden:true}, 
			  	editrules: {edithidden:true,required: true, custom:true, custom_func: fnc_chkselecttagempty},
			  	formoptions: {rowpos: 12, colpos: 1},
			},
			{name:'prf_tcagent', index:'tccust', width:90, align:'center', sortable:true, editable:true, hidden: true,
				edittype:'select',
				editoptions: { 
					dataUrl:'/Myelclass/PrfAutocomplete.do?action=tccust',
					type:"GET",
					buildSelect: function(data) {
						var response = jQuery.parseJSON(data);
						var s = '<select style="width: 520px">';
						if (response && response.length) {
							s += '<option value="NULL">---Select TC Customer---</option>';
							for (var i = 0, l=response.length; i<l ; i++) {
								var ri = response[i].value;
							    s += '<option value="'+ri+'">'+ri+'</option>';
							}
						}
					return s + "</select>";
					},
				} ,
			      //editoptions:{value:{0:'Select TC Customer',IC:'IC',Cust:'Cust',ICMD:'IC/MD',MD:'MD',NA:'NA'}},
			    //editrules:{edithidden:true, required : true}, 
			    editrules: {edithidden:true,required: true, custom:true, custom_func: fnc_chkselecttagempty},
			    formoptions: {rowpos: 12, colpos: 3},
			}, 	
			{name:'prf_contractnum', index:'contractno', width:90, align:'center', sortable:true, editable:true,hidden: false,
				editrules:{required : true},
				editoptions:{required : true, readonly: 'readonly'},
				formoptions: {rowpos: 13, colpos: 1},
			}, 	
			 	
			{name:'user', index:'user', width:90, align:'center', sortable:true, editable:true, hidden: true,
				editrules:{required : true},
				editoptions:{required : true, readonly: 'readonly'},
				formoptions: {rowpos: 13, colpos: 2},
			}, 	
			{name:'prf_articleid', index:'prfarticleid', width:90, align:'center', sortable:true, editable:true, hidden: true
			
			},
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
		}).jqGrid('navGrid','#pager',{
			add:true, edit:true, del:true, search: false,
			addtext: 'Add', edittext: 'Edit', deltext: 'Delete', searchtext: 'Search', refreshtext: 'Reload',
			}, 
			/*
	         *  // edit option
			 */
		   { 		  	
			 top: 150,
			 left: 200,
		 	 width : 750,
			 beforeShowForm: function(form) { 
				 /*
				  * Code to Implement Save as New in Edit form
				  */
				  /* $('<a href="#">Save New<span class="ui-icon ui-icon-disk"></span></a>')
		            .click(function() {
		                alert("click!");
		            }).addClass("fm-button ui-state-default ui-corner-all fm-button-icon-left")
		              .prependTo("#Act_Buttons>td.EditButton");*/
				  //Size Calculation
				 var sizec = $("#prf_size").val();
				 var temp = sizec.indexOf(' ');
				 $("#prf_size").val(sizec.substring(0, temp));
				 $("#prf_sizeremarks").val(sizec.substring(temp+1));
				 
				 //Size Avg Calculation
				 var sizeval = $("#prf_size").val();
				 var size_minindex = sizeval.indexOf('/');
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
		   
		      {/*
				*  // add option
				*/	    				     	 
		    	top: 150,
			 	left: 200,
			 	width : 750,
		        beforeShowForm: function(form) { 
		           	 $("#prf_contractnum").val($("#prf_contractno").val());
		           	 $("#user").val($("#userinsession").val());		   
		             $("#tr_prf_tc").hide(); // hide the tr prf_rate
		             $("#tr_prf_rate").hide();
		             $("#tr_user").show();
		        },
		        closeAfterAdd: true,
				reloadAfterSubmit: true
			 },
			 {
				//Del Article
				delData: {
					//Function to Add parameters to the delete 
					//Here i am passing artid with val 
					prf_articleid: function() {
                           var sel_id = grid.jqGrid('getGridParam', 'selrow');
                           var value = grid.jqGrid('getCell', sel_id, 'prf_articleid');
                           return value;
                     },
			 		reloadAfterSubmit: true,
                },	 
			 }    
	 	);
	 
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
	        change: function(event,ui){
		    	 $(this).val((ui.item ? ui.item.value : ""));
		   }
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
			                             id:item.consigneeId
			                             };
			                         }));//END Success
			                    }
			            });//END AJAX
					},
					select: function( event, ui ) { 
			          	  $('#prf_consigneeaddr').val(ui.item.addr);
			          	 $('#prf_consigneephone').val(ui.item.fone);
			          	 $('#prf_consigneeattn').val(ui.item.attn);
			          	 $('#prf_consigneefax').val(ui.item.fax);
			          	 $('#prf_consigneeid').val(ui.item.id);
			       },
			        change: function(event,ui){
				    	 $(this).val((ui.item ? ui.item.value : ""));
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
			                             id:item.bankId
			                             };
			                         }));//END Succ ess
			                    }
			            });//END AJAX
					},
				select: function( event, ui ) { 
			       $('#prf_bankaddr').val(ui.item.addr);
			       $('#prf_bankphone').val(ui.item.fone);
			       $('#prf_bankbranch').val(ui.item.brnch);
			       $('#prf_bankfax').val(ui.item.fax);
			       $('#prf_bankid').val(ui.item.id);
			    }, 
			    change: function(event,ui){
				 	 $(this).val((ui.item ? ui.item.value : ""));
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
			                     id: item.notifyConsigneeId
			                  };
			             }));//END Success
			           }
			        });//END AJAX
					},
					select: function( event, ui ) {
			          	  $('#prf_notifyaddr').val( ui.item.addr);
			          	 $('#prf_notifyphone').val(ui.item.fone);
			          	 $('#prf_notifyattn').val(ui.item.attn);
			          	 $('#prf_notifyfax').val(ui.item.fax);
			          	 $('#prf_notifyid').val(ui.item.id);
			        },
			        change: function(event,ui){
				    	 $(this).val((ui.item ? ui.item.value : ""));
				   } 
		 	});
		
		        //DATEPICKER
		        $(".prf_orderdate").datepicker({
				   // changeYear: true,
		        	//beforeShowDay: noWeekendsOrHolidays,
				    autoSize: true,
				    changeMonth:false,
				    dateFormat: "dd-mm-yy",
				    showWeek: true,
				    firstDay: 1,
				    numberOfMonths: 1,
				    showButtonPanel: false,
				    gotoCurrent:true, 
				    beforeShowDay: function(date) {
				        var day = date.getDay();              // Disable only SUndays
				        return [(day != 0), ''];
				    } 
				});
		                 
		        $(".prf_delivrydate").datepicker({
				   // changeYear: true,
				    autoSize: true,
				    changeMonth:false,
				    dateFormat: "dd-mm-yy",
				    showWeek: true,
				    firstDay: 1,
				    numberOfMonths: 2,
				    showButtonPanel: false,
				    gotoCurrent:true, 
				    beforeShowDay: function(date) {
				        var day = date.getDay();              // Disable only SUndays
				        return [(day != 0), ''];
				    } 
				    });
		        
					 
			 
		
			 //Customer Autocomplete
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
						             id: item.customerId
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
						$('#prf_custid').val(ui.item.id);
					 } ,
				     change: function(event,ui){
					 	$(this).val((ui.item ? ui.item.value : ""));
		    	     }
				}); 
				
				 //Terms Autocomplete
				$('#prf_terms').autocomplete({
					source: function(request, response) {
						var param = request.term;  
						$.getJSON("/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"terms",
						   function(result) { 	
							 response($.map(result, function(item) {
								 return { 
									 value: item.value,
								 };
						      }));//END response
						  }
						);
					 },
					 select: function( event, ui) { 
						$('#prf_terms').val(ui.item.value);
					 } ,
				     change: function(event,ui){
					 	$(this).val((ui.item ? ui.item.value : ""));
		    	     }
				}); 
				
				 //Payment Autocomplete
				$('#prf_payment').autocomplete({
					source: function(request, response) {
						var param = request.term;  
						$.getJSON("/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"payment",
						   function(result) { 	
							 response($.map(result, function(item) {
								 return { 
									 value: item.value,
								 };
						      }));//END response
						  }
						);
					 },
					 select: function( event, ui) { 
						$('#prf_payment').val(ui.item.value);
					 } ,
				     change: function(event,ui){
					 	$(this).val((ui.item ? ui.item.value : ""));
		    	     }
				}); 

					/*
					 * Jquery  Agent Autocomplete
					 */
					 $('#prf_agentname').autocomplete({
						 minLength: 0,
						 source: function(request, response) {
								var param = request.term;  
							 	$.getJSON("/Myelclass/PrfAutocomplete.do?term="+param+"&action="+"agent",
									function(result) { 	
							           response($.map(result, function(item) {
							              return { 
							                value: item.agentname,
							                 ctno: item.contractNo,
							               };
							            }));//END response
							          }
							    );
							},
							select: function( event, ui) { 
							     $('#prf_agentname').val(ui.item.value);
							     $('#prf_contractno').val(ui.item.ctno);
					         },
					         change: function(event,ui){
							   	 $(this).val((ui.item ? ui.item.value : ""));
							 }
						}).focus(function() {
							    $(this).autocomplete("search", "");
						});
					 
					 
					
					/*
					 * Autocomple for Local Data Types
					 */
						function split( val ) {
					      return val.split( /,\s*/ );
					    }
					    function extractLast (term) {
					      return split(term).pop();
					    }
				
					    
					    $("#prf_destination").autocomplete({
					        minLength: 1,
					        source: function( request, response ) {
					        	$.getJSON("/Myelclass/PrfAutocomplete.do?&action="+"desti", 
					        			{term : extractLast(request.term
					        	)}).done(function(data) {
					                    response($.map(data, function(item) {
					                        return {
					                        	label : item.label,
					                			 value: item.label +", " +item.value
					                            //value: el.label, 
					                        };
					                    }));
					        		});	//done
					        	//});//End Ajax
					        },
					        change: function(event,ui){
					        	$(this).val((ui.item ? ui.item.value : ""));
					        }
					    });
					        
					    
					    /*
					     * 
					     * Commisssion
					     */
					
					    $('#prf_commission')
					     // don't navigate away from the field on tab when selecting an item
					      .bind( "keydown", function( event ) {
					        if ( event.keyCode === $.ui.keyCode.TAB &&
					            $( this ).data( "ui-autocomplete" ).menu.active ) {
					          event.preventDefault();
					        }
					      }).autocomplete({
							minLength: 1,
							source: function(request, response, term) {
								$.getJSON("/Myelclass/PrfAutocomplete.do?&action="+"othercommision", 
					        			{term : extractLast(request.term
					        	)}).done(function(data) {
					                    response($.map(data, function(el) {
					                        return {
					                        	label : el.value,
					                        	 value: el.value+", "+el.commplace,
					                       
					                        };
					                    }));
					        		});	//done
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
							   this.value = terms.join( "." );
							   return false;
							},
							/*
							 * Here while navigating away value gets cleared off 
							 * so commented. 
							 */
					        /*change: function(event,ui){
						    	 $(this).val((ui.item ? ui.item.value : ""));
						   }*/
					}).autosize({append: "\n"});
					  			 
				 
	/*
	 * Form Save
	 * 
	 */
/*$("#Save").click(function(){	
	var savePrfForm = $("#savePrfForm").serialize();
	 $.ajax({
		 url : "/Myelclass/Prf",
		 type: "POST",
		 data : savePrfForm,
		 dataType: "json",
		 success: function(data, textStatus, jqXHR)
		 {
		 	alert("In Success "+textStatus);
		 },
		 error: function(jqXHR, textStatus, errorThrown)
		 {
			 alert("In Error "+textStatus);
		 }
	 });
	$("form[name=savePrfForm]").submit(function(){
		alert("In Prf Fform "+savePrfForm);
	    $.post("/Myelclass/Prf.do", savePrfForm, function(data) {
	    	alert("Y Suskcs"+data.result);
	    	if(data.success){
	    		 alert("SUCKS here"+data.success);
	    		// $("#savePrfForm")[0].reset();
	    		 $("#savePrfForm").each(function(){
	    			 alert("reset form");
	    			    this.reset();
	    			    $("#savePrfForm").clear();
	    			});
	    	}
	    	else{
	    		 alert("Failed -->"+data.error);
	    		 $("#savePrfForm")[0].reset();
	    	}
	    }, 'json');
	    return false;
	  });*/
//});				 
/*	$("#Save").click(function(){
		var savePrfForm = $("#savePrfForm").serialize();
		alert(savePrfForm);
		 $.post("/Myelclass/Prf", savePrfForm).done( function(data, textStatus) {
             alert(data)});
	});*/
 
  //UI MODAL FORM FOR POJW
    $("#pojwdiv").tabs().dialog({
    	autoOpen: false,
		resizable: true,
		width: 980,
		height: 600,
		autoResize: true, 
		modal:false,  
		jqModal:true,
		title : "Raise PO Form",
		open: function(event, ui){
			$("#Btnprfsave").attr('disabled' , true);
		   	var pojwctno = $("#prf_contractno").val();
			$("#pojw_contractno").val(pojwctno);
			$("#pojw_orderdate").val($("#prf_orderdate").val());
			$('#pojw_splcdn').val($("#prf_special").val());
			$("#pojw_cddate").val($("#prf_cdd").val());
			pojwgrid.jqGrid('setGridParam',{url:"/Myelclass/PrfinsertArticle.do?ctno="+pojwctno}).trigger("reloadGrid");	
	   }, 
	   beforeClose: function( event, ui ) {
			$("#Btnprfsave").attr('disabled' , false);
			$("#prf_pojwno").val($("#pojw_pojwno").val());
	   },
	 }).css("font-size", "12px");
					    
    
    $('#pojw').click(function(){
    	  //Dialog Box 	
    	  $("#pojwdiv").dialog('open');
     });		

   /*
    * POJW ARTICLE TABLE
    * 
    */
	var pojwgrid = $("#pojwtbl");
	var pojwno = $("#pojw_pojwno").val();
	pojwgrid.jqGrid({ 
		url:"/Myelclass/PrfinsertArticle.do?ctno="+pojwno,
    	datatype:"json",
    	colNames:['Article Type','Name', 'Article ID','Color','Size','Size avg','Size Rem','Substance','Selection','Selp',
    	          'Quantity','Unit','Pcs','Pric','Currency','Price','Shipment','T c','Price','Currency','tccust','Contract','User','Prfarticleid'],  
    	colModel:[   
    	 	 {name:'prf_articletype', index:'articletype', width:80, align:'center', sortable:true, editable:true, hidden: false, edittype:'select', 
    	 		editoptions: { 
    	          	dataUrl:'/Myelclass/PrfAutocomplete.do?action=arttype',
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
    	 		} , editrules :{required : true}, formoptions:{rowpos: 1, colpos: 1}, 
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
    	 					},
    	 					change: function(event,ui){
    							$(this).val((ui.item ? ui.item.value : ""));
    						}
    					});
    	 			$('.ui-autocomplete').css('zIndex',1234); // z index for jqgfrid and autocomplete has been misalignment so we are manually setting it 
    	 			}
    	 		}, editrules :{required : true}, formoptions:{rowpos: 1, colpos: 2} 
    	 	 }, 
    	 	
    	 	 {name:'articleid', index:'articleid', align: 'center', width:40, sortable:true,  editable:true,  hidden: true,					     				 
    	 		 editrules :{required : true},
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
    	 				                    value: item.value // I am displaying both labe and value
    	 				                 };
    	 				             }));//END Response
    	 				           },//END Success
    	 				        });//END AJAX
    	 					},
    	 					change: function(event,ui){
    	 						$(this).val((ui.item ? ui.item.value : ""));
    	 				    }
    	 				});
    	 				$('.ui-autocomplete').css('zIndex',1234); // z index for jqgfrid and autocomplete has been misalignment so we are manually setting it 
    	 			}
    	 		},
    	 		editrules :{required : true},
    	 		formoptions:{rowpos: 1, colpos: 3},
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
    	 		formoptions:{rowpos: 2, colpos: 1} 
    	 	},  
    	 	{name:'prf_sizeavg', index:'sizeavg', width:20, align:'center', editable:true, hidden: true,
    	 		editrules: {required: true},
    	 		formoptions:{rowpos: 2, colpos: 2} 	
    	 	}, 
    	 	{name:'prf_sizeremarks', index:'sizerem', width:40, align:'center',  editable:true, hidden: true, 
    	 		edittype:'select',
    	 		editoptions:{value:{0: 'Select Size Remarks', F:'F', S:'S', FS:'FS', DB:'Double Butt'}},
    	 		editrules: {required: true},
    	 		formoptions:{rowpos: 2, colpos: 3} ,	
    		 }, 
    	 	 {name:'prf_substance', index:'substance', align:'center', sortable:true, hidden: false, width:80,
    			 editable:true, formoptions:{rowpos: 4, colpos: 1},editrules :{required : true}, 	
    	 	 },  
    	 	 {name:'prf_selection', index:'selection', align:'center', width:90, sortable:true, hidden: false, editable:true,
    	 		edittype:'select',
    	 		editoptions:{value:{0:'Select Selection %',A:'A',AB:'AB',ABC:'ABC',TR:'TR',Available:'Available'}},
    	 		editrules :{required : true},formoptions:{rowpos: 4, colpos: 2} 
    	 	 }, 
    	 	 {name:'prf_selectionp', index:'selectionpercent', align:'center', width:90, sortable:true, editable:true, hidden: false,
    	 		editrules :{required : true},
				editrules:{custom:true, custom_func:selecpcheck}, 
				formoptions:{rowpos: 4, colpos: 3} 
    	 	 }, 	
    	 	 {name:'prf_quantity', index:'quantity', width:90, align:'center', sortable:true, hidden: false, 
    	 		editable:true, editrules:{required : true, number:true}, formatter: 'integer', 
    	 		formoptions:{rowpos: 5, colpos: 1} 
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
    			},editrules :{required : true},formoptions: {rowpos: 5, colpos: 2},
    	 	 }, 	
    	 	 {name:'prf_pieces', index:'pcs', width:90, align:'center', sortable:true, hidden: false, editable:true,
    	 		formoptions: {rowpos: 5, colpos: 3},
    	 	 }, 	
    	 	 {name:'prf_rate', index:'rate', width:90, align:'center', sortable:true, hidden: false, editable:true,
    	 		editrules:{edithidden:true}, 
    	 		formoptions: {rowpos: 6, colpos: 1},
    	 	 }, 
    	 	 {name:'prf_ratesign', index:'ratesign', width:90, align:'center', sortable:true, hidden: true, editable:true,
    	 	      edittype:'select',
    	 		  editoptions:{value:{0:'--- Select Currency --- ',$:'$',Rs:'Rs',Euro:'Euro',NA:' Not Available'}},
    	 		  editrules:{edithidden:true,required : true}, 
    	 		  formoptions: {rowpos: 7, colpos: 1},
    	 	 },  
    	 	 {name:'prf_rateamt', index:'rateamt', width:90, align:'center', sortable:true, hidden: true, editable:true,
    	 		  editrules:{edithidden:true,required : true}, 
    	 		  formoptions: {rowpos: 7, colpos: 2},	
    	 	 }, 
    	 	 {name:'prf_shipment', index:'shipment', width:90, align:'center', sortable:true, editable:true, hidden: true,
    	 	      edittype:'select',
    	 	      editoptions:{value:{0:'--- Select Shipment ---',Air:'Air',Sea:'Sea',Courier:'Courier',Truck:'Truck'}},
    	 	      editrules:{edithidden:true,required : true},  formoptions: {rowpos: 7, colpos: 3},	
    	 	 }, 
    	 	 {name:'prf_tc', index:'tc', width:90, align:'center', sortable:true, editable:true, hidden: false
    	 	 }, 
    	 	 {name:'prf_tcamt', index:'tcamt', width:90, align:'center', sortable:true, editable:true, hidden: true,
    	 		 editrules:{edithidden:true}, formoptions: {rowpos: 9, colpos: 1},
    	 	 }, 	
    	 	 {name:'prf_tccurrency', index:'tcsign', width:90, align:'center', sortable:true, editable:true, hidden: true,
    	 		edittype:'select',
    	 		editoptions:{value:{0:'--- Select TC Currency ---',cents:'cents',paise:'paise',shillings:'shillings',NA:'NA'}},
    	 		editrules:{edithidden:true}, formoptions: {rowpos: 9, colpos: 2},
    	 	 },
    	 	 {name:'prf_tcagent', index:'tccust', width:90, align:'center', sortable:true, editable:true, hidden: true,
    	 	    edittype:'select',
    	 		editoptions:{value:{0:'--- Select TC Customer ---',IC:'IC',Cust:'Cust',ICMD:'IC/MD',MD:'MD',NA:'NA'}},
    	 		editrules:{edithidden:true, required : true}, formoptions: {rowpos: 9, colpos: 3},
    	 	 }, 	
    	 	 {name:'prf_contractnum', index:'contractno', width:90, align:'center', sortable:true, editable:true,editoptions:{required : true}, hidden: false,
    	 		formoptions: {rowpos: 10, colpos: 1},	
    	 	 }, 
    	 	 {name:'user', index:'user', width:90, align:'center', sortable:true, editable:true, hidden: true,
    	 		formoptions: {rowpos: 10, colpos: 2},	
    	 	 },
    	 	 {name:'prf_articleid', index:'prfarticleid', width:90, align:'center', sortable:true, editable:true, hidden: true}, 							  
    	],  
    	jsonReader : {  
    	  	repeatitems:false,
    	   	root: "rows",
    	   	page: "page", //calls first
    	   	total: "total" ,//calls Second
    	   	records: "records" //calls Third
    	},
    	caption: "Add POJW Article",
    	loadtext: "POJW Article is Loading",
    	//multiselect : true,
		//multiboxonly: true, 
    	pager: '#pojwpager',
    	rowNum:6, 
    	rowList:[6,8,10,12],
    	rownumbers: true,
    	height: "100%", 
    	width: "auto",
    	sortname: 'articlename',  
    	sortorder: 'desc', 
    	hidegrid: false,
    	viewrecords: true,
    	sortable: true,
    	toppager:true,
    	gridview: true, 
    	altRows: true, 
    	emptyrecords: 'No records to display',
    	loadComplete: function (data){
    	/*
    	 * Load Complete Events 
    	 * Diable Edit and Add Functions 
    	 */	
    		/* $("#edit_" + this.id).addClass('ui-state-disabled');
             $("#del_" + this.id).addClass('ui-state-disabled'); 
             $("#add_" + this.id).addClass('ui-state-disabled'); */
    		
    	}
    }).jqGrid('navGrid','#pojwpager',{
	 	add:true, edit:true, del:true, search: false, refresh : true,  view: true, cloneToTop:true,
	 	addtext: ' Add ', edittext: ' Edit ', deltext: ' Delete ' , searchtext: ' Search ', refreshtext: ' Reload ', viewtext: ' View ',
		beforeRefresh: function(){
			alert("in B4 refresh ");
			var pojwno = $("#pojw_pojwno").val();
				pojwgrid.jqGrid('setGridParam',{url:"/Myelclass/PrfinsertArticle.do?oper=pojw&action=load&ctno="+pojwno}).trigger("reloadGrid");
	 		}, 
	 	},
	 	/*
	 	 *  // edit option
	 	*/
	 	{ 
	 	 zIndex:1234,
	 	 width : 650,
	 	 top: 550,
	 	 left:120,
	 	 // edit option
	 	 beforeShowForm: function(form) { 
	 		var sizec = $("#prf_size").val();
	 		var temp = sizec.indexOf(' ');
	 		$("#prf_size").val(sizec.substring(0, temp));
	 		$("#prf_sizeremarks").val(sizec.substring(temp+1));

	 		 //Size Avg Calculation
	 		var sizeval = $("#prf_size").val();
	 		var size_minindex = sizeval.indexOf('/');
	 		var sizemin = sizeval.substring(0, size_minindex);
	 		var sizemax=  sizeval.substring(size_minindex+1);
	 		var sizeavg = ( (parseFloat (sizemin) + parseFloat(sizemax)) /2) ;
	 		$("#prf_sizeavg").val(sizeavg);
	 		
	 			//Rate Calculation
	 			var ratec = $("#prf_rate").val();
	 			var ratemp = ratec.indexOf(' ');
	 			var ratemplast = ratec.lastIndexOf(' ');
	 			$("#prf_ratesign").val(ratec.substring(0, ratemp));
	 			$("#prf_shipment").val(ratec.substring(ratemplast+1));

	 			//TC Calculation
	 			var tctec = $("#prf_tc").val(); 
	 			var tcindex = tctec.indexOf(" ");
	 			var tcindex1 = tctec.lastIndexOf(" ");
	 			var tcamt = tctec.substring(0, tcindex);
	 			var tcsign = tctec.substring(tcindex+1, tcindex1);
	 			var agent = tctec.substring(tcindex1+1);
	 			var rateamt = ratec.substring(ratemp+1, ratemplast);
	 			var tcamtdecimal = "0."+tcamt;
	 			var actualrate = (parseFloat(rateamt)- parseFloat(tcamtdecimal));
	 			$("#prf_rateamt").val(actualrate.toFixed(2));
	 			$("#prf_tcamt").val(tcamt);
	 			$("#prf_tcagent").val(agent);
	 			$("#prf_tccurrency").val(tcsign);
	 			$("#prf_contractnum").val($("#pojw_pojwno").val());

	 			$("#tr_prf_tc").hide();
	 			$("#tr_prf_rate").hide();
	 		 },
	 	 closeAfterEdit: true,
	 	 reloadAfterSubmit: true,
	 	// recreateForm: true,
	 	 url: "/Myelclass/PrfinsertArticle.do?oper=pojw&action=edit",
	 	},
		{
	 	 /*
	 	  * add option
	 	  */	    
	 	  zIndex:1234,		     	 
	 	  top: 450,
	 	  left: 200,
	 	  width : 850,
	 	  beforeShowForm: function(form) { 
	 	   	 $("#prf_contractnum").val($("#pojw_pojwno").val());
	 	   	 $("#user").val($("#userinsession").val());		   
	 	     $("#tr_prf_tc").hide(); // hide the tr prf_rate
	 	     $("#tr_artshform").hide();
	 	     $("#tr_prf_rate").hide();
	 	     $("#tr_user").show();
	 	  },
	 	  closeAfterAdd: true,
	 	  reloadAfterSubmit: true,
	 	 // recreateForm: true,
	 	  url: "/Myelclass/PrfinsertArticle.do?oper=pojw&action=add",
	 	},
	 	{
	 	 //Del Article
	 	 zIndex:1234,
	 	 delData: {
	 		 //Function to Add parameters to the delete 
	 		 //Here i am passing artid with val 
	 		 prf_articleid: function() {
	 			 var sel_id = pojwgrid.jqGrid('getGridParam', 'selrow');
	 		     var value = pojwgrid.jqGrid('getCell', sel_id, 'prf_articleid');
	 		     return value;
	 		 },
	 	},
	 	reloadAfterSubmit: true,
	 	recreateForm: true,
	 	url: "/Myelclass/PrfinsertArticle.do?oper=pojw&action=del",
}).jqGrid('navButtonAdd','#' + pojwgrid[0].id + '_toppager_left', {
	caption: "Copy",
	buttonicon: 'ui-icon-scissors',
	onClickButton: function() {
	var $self = $(this);
	$self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
	{
		zIndex:1234,
		width : 650,
		top: 550,
		left:120,
		recreateForm: true,
		// Copy option
		beforeInitData: function (formID) {
			alert("In B4 init Data "+formID);
			$("#tr_prf_tc").hide();
	 			$("#tr_prf_rate").hide();
	 			var posizec = $("#prf_size").val();
	 			alert(posizec);
		},
		beforeShowForm: function(form) {			
		
			var posizec = $("#prf_size").val();
	 		var potemp = posizec.indexOf(' ');
	 		$("#prf_size").val(posizec.substring(0, potemp));
	 		$("#prf_sizeremarks").val(posizec.substring(potemp+1));
	 		alert(posizec);
	 		alert(posizec.substring(potemp+1));
	 		
	 		//Size Avg Calculation
	 		var posizeval = $("#prf_size").val();
	 		var posize_minindex = posizeval.indexOf('/');
	 		var posizemin = posizeval.substring(0, posize_minindex);
	 		var posizemax=  posizeval.substring(posize_minindex+1);
	 		var posizeavg = ( (parseFloat (posizemin) + parseFloat(posizemax)) /2) ;
	 		$("#prf_sizeavg").val(posizeavg);
	 		
	 		//Rate Calculation
	 		var ratec = $("#prf_rate").val();
	 		var ratemp = ratec.indexOf(' ');
	 		var ratemplast = ratec.lastIndexOf(' ');
	 		$("#prf_ratesign").val(ratec.substring(0, ratemp));
	 		$("#prf_shipment").val(ratec.substring(ratemplast+1));

	 		//TC Calculation
	 		var tctec = $("#prf_tc").val(); 
	 		var tcindex = tctec.indexOf(" ");
	 		var tcindex1 = tctec.lastIndexOf(" ");
	 		var tcamt = tctec.substring(0, tcindex);
	 		var tcsign = tctec.substring(tcindex+1, tcindex1);
	 		var agent = tctec.substring(tcindex1+1);
	 		var rateamt = ratec.substring(ratemp+1, ratemplast);
	 		var tcamtdecimal = "0."+tcamt;
	 		var actualrate = (parseFloat(rateamt)- parseFloat(tcamtdecimal));
	 		
	 		$("#prf_rateamt").val(actualrate.toFixed(2));
	 		$("#prf_tcamt").val(tcamt);
	 		$("#prf_tcagent").val(agent);
	 		$("#prf_tccurrency").val(tcsign);
	 		$("#prf_contractnum").val($("#pojw_pojwno").val());
	 		$("#tr_prf_tc").hide();
	 		$("#tr_prf_rate").hide();
	 		
			$("#prf_tcamt").val('0');
			$("#prf_tcagent").val(agent);
			$("#prf_tccurrency").val(tcsign);
			$("#prf_contractnum").val($("#pojw_pojwno").val());
			// var ctno = $("#prf_contractnum").val();
		},
		closeAfterEdit: true,
		reloadAfterSubmit: true,
		url:"/Myelclass/PrfinsertArticle.do?oper=pojw&action=copy",
		   			
		afterSubmit: function(response, postdata) {
			if(response.responseText != ""){ // Actually iam passing success / Error as responseText 
            	  alert("Inserte Successfully "+response.responseText);
                  //return [false, response.responseText];	
              }else{alert("Inserte Failutre "+response.responseText);
                  return [true,"Ok"];
       		  }
		}
	});
}
});
    pojwgrid.jqGrid('setGridWidth', 930);

    //Bootom Pager Customization
    var bottomPagerDiv = $("div#pojwpager")[0];
    $("#view_" + pojwgrid[0].id, bottomPagerDiv).remove();
    $("#refresh_" + pojwgrid[0].id, bottomPagerDiv).remove(); 
  	//Top Pager Customization
    var topPagerDiv =  $('#' + pojwgrid[0].id + '_toppager')[0];
    $("#add_" + pojwgrid[0].id + "_top", topPagerDiv).remove();	
    $("#edit_" + pojwgrid[0].id + "_top", topPagerDiv).remove();      // "#search_list_top"
    $("#del_" + pojwgrid[0].id + "_top", topPagerDiv).remove();  
    $("#view_" + pojwgrid[0].id + "_top", topPagerDiv).remove(); // "#refresh_list_top" 	 
 });