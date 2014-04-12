/**
 * PRF js
 * 19.08.13
 * 
 */
$(document).ready(function() {
	 $("#prf_pojw").focusin(function() {
		 $.get("/Myelclass/PrfAutocomplete.do?action="+"pojwno", 
		 	function(data){
	  		 $("#prf_pojw").val(data); 	
		 	},"text"); 
		 
	 });
		 
	  $('#prf_exporter').autocomplete({
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
			 	$('.ui-autocomplete').css('zIndex',1234);
					},
					select: function( event, ui) {
			          	 $('#prf_exporteraddr').val(ui.item.addr);
			          	 $('#prf_exportertele').val(ui.item.phone);
			          	 $('#prf_exporterattn').val(ui.item.attn);
			          	 $('#prf_exporterfax').val(ui.item.fax);
			          	 $('#pojw_payterms').val('By local Cheque on or before 30 days from invoice date in Indian Rupee at prevailing exchange rates.');
			          	
			           } ,	
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
						var value = ui.item.value;
						if(value == ("International Corporation") || value == ("Conceria International Pvt Ltd")){
			          		$('#pojw').removeAttr('disabled');
			          	}else{
			          		$('#pojw').attr('disabled','disabled');
			          	}
			          	 $('#prf_tanaddr').val(ui.item.addr);
			          	 $('#prf_tanphone').val(ui.item.phone);
			          	 $('#prf_tanattn').val(ui.item.attn);
			          	 $('#prf_tanfax').val(ui.item.fax);
			           } 
			}); 
	 
	 
	/*
     * Function To disabe Specific Dates
     */ 
     natDays = [
                [1, 26, 'au'], [2, 6, 'nz'], [3, 17, 'ie'],
                [4, 27, 'za'], [5, 25, 'ar'], [6, 6, 'se'],
                [7, 4, 'us'], [8, 17, 'id'], [9, 7, 'br'],
                [10, 1, 'cn'], [11, 22, 'lb'], [12, 12, 'ke']
              ];

     function noWeekendsOrHolidays(date) {
           for (var i = 0; i < natDays.length; i++) {
              if (date.getMonth() == natDays[i][0] - 1 && date.getDate() == natDays[i][1]) {
                   return [false, natDays[i][2] + '_day'];
               }
            }
            return [true, ''];
     }
	$.extend($.jgrid.edit, {
	    bSubmit: "Save",
	    bCancel: "Cancel",
	    width: 370,
	    recreateForm: true,
	    beforeShowForm: function () {
	     
	    }
	});
	
	 
	/* $("#prfform").dialog({
			autoOpen: false,
	        resizable: true,
	        position: ['left','top'],
			width: 'auto',
			height: 'auto',
	        autoResize: true, 
	        modal: true,
		});
			* Min Max Button for Jquery UI Dialog from jquery.dialogextend plugin 
			*/
	 /*.dialogExtend({
	        "close" : true,
	        "maximize" : true,
	        "minimize" : true,
	        "dblclick" : "collapse",
	        "titlebar" : "transparent",
	        "icons" : {
	          "close" : "ui-icon-circle-close",
	          "maximize" : "ui-icon-circle-plus",
	          "minimize" : "ui-icon-circle-minus",
	          "restore" : "ui-icon-bullet"
	         },
		});*/
	
	 //$("#prfform").dialog( "open" );
	var grid = $("#list"); //table id artinsert
	 grid.jqGrid({ 
		url:"/Myelclass/PrfinsertArticle.do", ///   
		datatype:"json",
		mtype: "GET",
		postData: {
		        ctno: function (){return $("#prf_contractno").val();},
	    },
		colNames:['Article Type','Name','Article Shform', 'Article ID','Color','Size','Size avg','Size Rem','Substance','Selection','Selp','Quantity','Unit','Pcs','Pric','Currency','Price','Shipment','T c','Price','Currency','tccust','Contract','Prfarticleid','User'],  
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
                 } ,
                 editrules :{required : true},
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
		    	  	}, editrules :{required : true},
		    	  	formoptions:{rowpos: 1, colpos: 2} 
			}, 
			{name:'artshform', index:'articleshfrom', width:55, align:'center', editable:true, hidden: true,
				formoptions:{rowpos: 1, colpos: 3},
				 editrules :{required : true},
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
						});
					$('.ui-autocomplete').css('zIndex',1000); // z index for jqgfrid and autocomplete has been misalignment so we are manually setting it 
					}
				 },
			     editrules :{required : true},
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
				  formoptions:{rowpos: 6, colpos: 2} ,	
			}, 
			{name:'prf_substance', index:'substance', align:'center', sortable:true, hidden: false, width:80,
					  editable:true, formoptions:{rowpos: 7, colpos: 1},editrules :{required : true}, 	
			},  
			{name:'prf_selection', index:'selection', align:'center', width:90, sortable:true, hidden: false, editable:true,
				edittype:'select',
				  editoptions:{value:{0:'Select Selection %',A:'A',AB:'AB',ABC:'ABC',TR:'TR',Available:'Available'}},
				  editrules :{required : true},formoptions:{rowpos: 7, colpos: 2} 
			}, 
			{name:'prf_selectionp', index:'selectionpercent', align:'center', width:90, sortable:true, editable:true, hidden: false,
				editrules :{required : true},
			//	editrules:{custom:true, custom_func:mypricecheck}, 
				editoptions: { 
					dataEvents:[{
					type: 'focusout',
					fn: function(e){
						var sum = 0;
						$.map(($("#prf_selectionp").val()).split('-'), function(value){
							sum += parseInt(value, 10);
							return sum;
						});
						if(!(sum == 100))alert("selection percent should be 100. Please Enter valid percentage");
					}
				}],
				},
				formoptions:{rowpos: 7, colpos: 3} ,
			}, 	
		
			{name:'prf_quantity', index:'quantity', width:90, align:'center', sortable:true, hidden: false, 
				editable:true, editrules:{required : true, number:true}, formatter: 'number',  
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
						
					  },editrules :{required : true},formoptions: {rowpos: 8, colpos: 2},
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
				  editrules:{edithidden:true,required : true}, 
				  formoptions: {rowpos: 10, colpos: 1},
			},  
			{name:'prf_rateamt', index:'rateamt', width:90, align:'center', sortable:true, hidden: true, editable:true,
				 editrules:{edithidden:true,required : true}, 
				 formoptions: {rowpos: 10, colpos: 2},	
			}, 
			{name:'prf_shipment', index:'shipment', width:90, align:'center', sortable:true, editable:true, hidden: true,
			      edittype:'select',
			      editoptions:{value:{0:'--- Select Shipment --- ',Air:'Air',Sea:'Sea',Courier:'Courier',Truck:'Truck'}},
			      editrules:{edithidden:true,required : true},  formoptions: {rowpos: 10, colpos: 3},	
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
			      editrules:{edithidden:true, required : true}, formoptions: {rowpos: 12, colpos: 3},
			}, 	
			{name:'prf_contractnum', index:'contractno', width:90, align:'center', sortable:true, editable:true,editoptions:{required : true}, hidden: false}, 	
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
			  //hidden : adminHide,
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
		  	
			 width : 650,
			 top:120,
			 left:120,
			 // edit option
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
			 	width : 850,
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
		             $("#tr_user").show();
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
                     },
			 		reloadAfterSubmit: true,
                },
						
					 
			 }    
	 	);
	 //grid.setGridParam({url:"Myelclass/PrfinsertArticle.do"	}, postData: {ctno: $("#prf_contractno").val()},).trigger("reloadGrid"); /
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
			          	  var fone = ui.item.fone; 
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
			          	  var fone = ui.item.fone; 
			          	  var fax = ui.item.fax; 
			          	  $('#prf_notifyaddr').val(addr);
			          	 $('#prf_notifyphone').val(fone);
			          	 $('#prf_notifyattn').val(attn);
			          	 $('#prf_notifyfax').val(fax);
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
				    /*onSelect: function(dateText, inst) { 
						addOrRemoveDate(dateText);
					},
					beforeShowDay: function (date){
				         var year = date.getFullYear();
				         // months and days are inserted into the array in the form, e.g "01/01/2009", but here the format is "1/1/2009"
				         var month = padNumber(date.getMonth() + 1);
				         var day = padNumber(date.getDate());
				         // This depends on the datepicker's date format
				         var dateString = month + "/" + day + "/" + year;

				         var gotDate = jQuery.inArray(dateString, dates);
				         if (gotDate >= 0) {
				           // Enable date so it can be deselected. Set style to be highlighted
				           return [true,"ui-state-highlight"]; 
				         }
				         // Dates not in the array are left enabled, but with no extra style
				         return [true, ""];
				       }
				    */
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
				
					    
					    $("#prf_destination")
					      // don't navigate away from the field on tab when selecting an item
					    /*  .bind( "keydown", function( event ) {
					        if ( event.keyCode === $.ui.keyCode.TAB &&
					            $( this ).data( "ui-autocomplete" ).menu.active ) {
					          event.preventDefault();
					        }
					      })*/.autocomplete({
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
					        }});
					        /*focus: function() {
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
					      .autosize({append: "\n"});*/
					    
					    
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
							   this.value = terms.join( ", " );
							   return false;
							} 
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
 $("#pojwdiv").dialog({
	autoOpen: false,
    resizable: true,
    width: 980,
    height: 600,
    autoResize: true, 
    modal:false,  
    jqModal:true,
    title : "Raise PO Form",
    open: function(event, ui){
       	var pojwctno = $("#prf_contractno").val();
       	$("#pojw_contractno").val(pojwctno);
      	$("#pojw_orderdate").val($("#prf_orderdate").val());
       	pojwgrid.jqGrid('setGridParam',{url:"/Myelclass/PrfinsertArticle.do?ctno="+pojwctno}).trigger("reloadGrid");
    },
    buttons:{
    	"Save": function () {
    		var formdata = $('#pojwform').serialize();
    		alert("Form Data"+formdata);
    		$.ajax({
				url: "/Myelclass/pojw.do",
				type: "POST",
				async: true,
				dataType: "text",
				data: formdata,
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success: function (data) {
					alert("S"+data);
	                console.log("success"+data);
	                $(this).dialog("close");
	            }, 
	            error: function (data) {
	            	alert("F "+data);
	                console.log("error");
	            } 
			});
    	},
    	"Cancel": function () {
    		alert("In Cancel");
    	},
    	"Print" : function (){
    		alert("In Print");
    	}
    }
 	}).css("font-size", "12px");
	$('#pojw').click(function(){
	 //Dialog Box 	
	 $("#pojwdiv").dialog('open');
	});		
	
/*
 *  POJW ARTICLE TABLE
 * 
 */
	var pojwgrid = $("#pojwtbl");
	var pojwno = $("#prf_pojw").val();
	//pojwgrid.jqGrid('setGridParam',{url:"/Myelclass/PrfinsertArticle.do?oper=pojw&action=load&ctno="+pojwno}).trigger("reloadGrid");
	 pojwgrid.jqGrid({ 
			url:"/Myelclass/PrfinsertArticle.do?oper=pojw&action=load&ctno="+pojwno,  
			datatype:"json",
			mtype: "GET",
							/*postData: {
							        ctno: function (){return $("#pojw_contractno").val();
							  
							        },
						    },*/
							colNames:['Article Type','Name','Article Shform', 'Article ID','Color','Size','Size avg','Size Rem','Substance','Selection','Selp','Quantity','Unit','Pcs','Pric','Currency','Price','Shipment','T c','Price','Currency','tccust','Contract','Prfarticleid','User'],  
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
					                 } ,
					                 editrules :{required : true},
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
												$('.ui-autocomplete').css('zIndex',1234); // z index for jqgfrid and autocomplete has been misalignment so we are manually setting it 
												}
							    	  	}, editrules :{required : true},
							    	  	formoptions:{rowpos: 1, colpos: 2} 
								}, 
								{name:'artshform', index:'articleshfrom', width:55, align:'center', editable:true, hidden: true,
									formoptions:{rowpos: 1, colpos: 3},
									 editrules :{required : true},
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
											});
										$('.ui-autocomplete').css('zIndex',1234); // z index for jqgfrid and autocomplete has been misalignment so we are manually setting it 
										}
									 },
								     editrules :{required : true},
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
									  formoptions:{rowpos: 6, colpos: 2} ,	
								}, 
								{name:'prf_substance', index:'substance', align:'center', sortable:true, hidden: false, width:80,
										  editable:true, formoptions:{rowpos: 7, colpos: 1},editrules :{required : true}, 	
								},  
								{name:'prf_selection', index:'selection', align:'center', width:90, sortable:true, hidden: false, editable:true,
									edittype:'select',
									  editoptions:{value:{0:'Select Selection %',A:'A',AB:'AB',ABC:'ABC',TR:'TR',Available:'Available'}},
									  editrules :{required : true},formoptions:{rowpos: 7, colpos: 2} 
								}, 
								{name:'prf_selectionp', index:'selectionpercent', align:'center', width:90, sortable:true, editable:true, hidden: false,
									editrules :{required : true},
								//	editrules:{custom:true, custom_func:mypricecheck}, 
									editoptions: { 
										dataEvents:[{
										type: 'focusout',
										fn: function(e){
											var sum = 0;
											$.map(($("#prf_selectionp").val()).split('-'), function(value){
												sum += parseInt(value, 10);
												return sum;
											});
											if(!(sum == 100))alert("selection percent should be 100. Please Enter valid percentage");
										}
									}],
									},
									formoptions:{rowpos: 7, colpos: 3} ,
								}, 	
							
								{name:'prf_quantity', index:'quantity', width:90, align:'center', sortable:true, hidden: false, 
									editable:true, editrules:{required : true, number:true}, formatter: 'number',  
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
											
										  },editrules :{required : true},formoptions: {rowpos: 8, colpos: 2},
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
									  editrules:{edithidden:true,required : true}, 
									  formoptions: {rowpos: 10, colpos: 1},
								},  
								{name:'prf_rateamt', index:'rateamt', width:90, align:'center', sortable:true, hidden: true, editable:true,
									 editrules:{edithidden:true,required : true}, 
									 formoptions: {rowpos: 10, colpos: 2},	
								}, 
								{name:'prf_shipment', index:'shipment', width:90, align:'center', sortable:true, editable:true, hidden: true,
								      edittype:'select',
								      editoptions:{value:{0:'--- Select Shipment --- ',Air:'Air',Sea:'Sea',Courier:'Courier',Truck:'Truck'}},
								      editrules:{edithidden:true,required : true},  formoptions: {rowpos: 10, colpos: 3},	
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
								      editrules:{edithidden:true, required : true}, formoptions: {rowpos: 12, colpos: 3},
								}, 	
								{name:'prf_contractnum', index:'contractno', width:90, align:'center', sortable:true, editable:true,editoptions:{required : true}, hidden: false}, 	
								{name:'prf_articleid', index:'prfarticleid', width:90, align:'center', sortable:true, editable:true, hidden: true}, 	
								
								{name:'user', index:'user', width:90, align:'center', sortable:true, editable:true, hidden: true,
									//${user.name}.	
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
							pager: '#pojwpager',
							//toppager:true,
				            //cloneToTop:true,
							rowNum:6, 
							rowList:[6,8,10],
					        loadtext: "Bow Bow........... ",
					        sortname: 'articlename',  
					        sortorder: 'desc', 
					        viewrecords: true,
					        gridview: true, // if used cant use subgrid, treegrid and aftertInsertRow 
					        height: "100%", 
					        emptyrecords: 'No records to display',
					        loadComplete: function (data){
					        	//var pojwno = $("#prf_pojw").val();
					        	//pojwgrid.jqGrid('setGridParam',{url:"/Myelclass/PrfinsertArticle.do?oper=pojw&action=load&ctno="+pojwno}).trigger("reloadGrid");
					        }
							}).jqGrid('navGrid','#pojwpager',{add:true, edit:true, del:true, search: true, refresh : true,  view: true, 
								beforeRefresh: function(){
									var pojwno = $("#prf_pojw").val();
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
									 $("#prf_contractnum").val($("#prf_pojw").val());
									 
									 $("#tr_prf_tc").hide();
									 $("#tr_prf_rate").hide();
							      },
							        closeAfterEdit: true,
									reloadAfterSubmit: true,
									recreateForm: true,
									url: "/Myelclass/PrfinsertArticle.do?oper=pojw&action=edit",
							      },
							   
							      {/*
									*  // add option
									*/	    
							    	zIndex:1234,		     	 
							    	top: 450,
								 	left: 200,
								 	width : 850,
							        beforeShowForm: function(form) { 
							           	 $("#prf_contractnum").val($("#prf_pojw").val());
							           	 $("#user").val($("#userinsession").val());		   
							             $("#tr_prf_tc").hide(); // hide the tr prf_rate
							             $("#tr_prf_rate").hide();
							             $("#tr_user").show();
							        },
							        closeAfterAdd: true,
									reloadAfterSubmit: true,
									recreateForm: true,
									url: "/Myelclass/PrfinsertArticle.do?oper=pojw&action=add",
								 },
								 {
									// del option
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
								 });
						 pojwgrid.jqGrid('navButtonAdd','#pojwpager',  { // "#list_toppager_left"
				                caption: "Copy",
				                buttonicon: 'ui-icon-wrench',
				                onClickButton: function() {
				                	 var $self = $(this);
						 		 	 $self.jqGrid("editGridRow", $self.jqGrid("getGridParam", "selrow"),
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
											 
											 $("#prf_tcamt").val('0');
											 $("#prf_tcagent").val(agent);
											 $("#prf_tccurrency").val(tcsign);
											 $("#prf_contractnum").val($("#prf_pojw").val());
											// var ctno = $("#prf_contractnum").val();		
											 $("#tr_prf_tc").hide();
											 $("#tr_prf_rate").hide();
											
									      },
									       recreateForm: true,
									        closeAfterEdit: true,
											reloadAfterSubmit: true,
											url:"/Myelclass/PrfinsertArticle.do?oper=pojw&action=copy",
											/*afterSubmit : function () {
												var ctno = $("#prf_contractnum").val();		
												url:"/Myelclass/PrfinsertArticle.do?oper=pojw&action=copy",
											},*/
											
						 		 	 });
				                }
				            });
						 pojwgrid.jqGrid('setGridWidth', 930);
		 });