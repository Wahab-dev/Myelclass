<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="l"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PRF PAGE</title> 
<%-- <link rel="stylesheet" href="js/jquery-ui.css" />
<script src="js/jquery-1.9.0.js"></script>
<script src="js/jquery-1.9.0.min.js"></script> --%>
<style type="text/css">
#ui-datepicker-div { font-size: 11px; } 	
</style>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/pepper-grinder/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />

<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>

<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>		
<script type="text/javascript">

$(document).ready(function() {
	
	var gridbtn = $('#thelink');  //Button Id
	var grid = $("#list"); //table id
	/*  
	var countries = { '0':'All','1': 'US', '2': 'UK', '3':'India', '4':'Japan','5':'Korea','6':'China','7':'Vietnam','8':'Australia','9':'Italy','10':'Thailand'},
	    states = {'1': 'Alabama', '2': 'California', '3': 'Florida', '4': 'Hawaii', '5': 'London', '6': 'Oxford','7':'Chennai','8':'Mumbai','9':'Kolkatta','10':'Tokyo','11':'Hiroshima','12':'Nagasaki','13':'Seoul','14':'Pyongyang','15':'Guanzhou','14':'Shanghai','15':'Hong Kong','16':'Hanoi','17':'Pnom Phen','18':'Canberra','19':'Sydney','20':'Rome','21':'Venice','22':'Bangkok','23':'Pattaya'},
	    statesOfUS = {'1': 'Alabama', '2': 'California', '3': 'Florida', '4': 'Hawaii'},
	    statesOfUK = {'5': 'London', '6': 'Oxford'},
	    statesOfIndia = {'7':'Chennai','8':'Mumbai','9':'Kolkatta'},
	    statesOfJpn = {'10':'Tokyo','11':'Hiroshima','12':'Nagasaki'},
	    statesOfKo = {'13':'Seoul','14':'Pyongyang'},
	    statesOfCH = {'15':'Guanzhou','14':'Shanghai','15':'Hong Kong'},
	    statesOfVI = {'16':'Hanoi','17':'Pnom Phen'},
	    statesOfAU = {'18':'Canberra','19':'Sydney'},
	    statesOfIT = {'20':'Rome','21':'Venice'},
	    statesOfTH = {'22':'Bangkok','23':'Pattaya'},
	    // the next maps contries by ids to states
	    statesOfCountry = { '0': states,'1': statesOfUS, '2': statesOfUK,'3':statesOfIndia,'4':statesOfJpn,'5': statesOfKo,'6':statesOfCH,'7':statesOfVI,'8':statesOfAU,'9':statesOfIT,'10':statesOfTH},
	    mydata = [
	        { id: '0', Country: '1', State: '1', Name: "Louise Fletcher" },
	        { id: '1', Country: '1', State: '3', Name: "Jim Morrison" },
	        { id: '2', Country: '2', State: '5', Name: "Sherlock Holmes" },
	        { id: '3', Country: '2', State: '6', Name: "Oscar Wilde" }
	    ]; */
	    
	    resetStatesValues = function () {
	        // set 'value' property of the editoptions to initial state
	        grid.jqGrid('setColProp', 'State', { editoptions: { value: states} });
	    }; 
	    
	    gridbtn.click( function()
		    {
			 var ctno =$('#prf_contractno').val();
			 alert(ctno);
			 grid.jqGrid({  
				url:"/Myelclass/PrfinsertArticle.do?ctno="+ctno+"&action="+"load",   
				datatype:"json",
				colNames:['Article Type','Name','ArticleId', 'Color', 'Size','Size rem','Size avg','Subs','Selec','Selec P', 'Quantity','Unit', 'Pcs','Rate sign','Rate amt','Shipment','Tc sign','Tc amt','Tc to','Article Type'],  
			    colModel:[   
					{name: 'prf_articletype',index:'articletype', width:80, sortable:true, editable: true, edittype:'select',
						 
							 editoptions: { 
			            		 dataUrl:'/Myelclass/PrfAutocomplete.do?action=arttype',
			            		 buildSelect: function(data) {
			            		  	var response = jQuery.parseJSON(data);
			                      	var s = '<text>';
			                      	if (response && response.length) {
			                      		
			                          	for (var i = 0, l=response.length; i<l ; i++) {
			                            	var ri = response[i].value;
			                             	s += '<option value="'+ri+'">'+ri+'</option>';
			                          	}
			                        	}
			                       	return s + "</text>";
			                     	},
			            			dataEvents :[{ 
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
											   });//END AJAX
			            		            		
			            		            /* function(data){
			            		            	
			            		                var res = $(data).html();
			            		                alert("RES"+res);
			            		                $("#prf_articlename").html(res);
			            		            }); */
			            		        }
			            		    }]
			            	},
					},         
					{name:'prf_articlename', index:'articlename', width:90, sortable:true,  editable:true, edittype:'select',					     
						  editoptions:{
							  maxlength: 50 , value: 'Select:Select'}
							 /*  dataUrl:'/Myelclass/PrfAutocomplete.do?action=artname',
			            		 buildSelect: function(data) {
			            		  var response = jQuery.parseJSON(data);
			                      var s = '<text>';
			                      if (response && response.length) {
			                          for (var i = 0, l=response.length; i<l ; i++) {
			                             var ri = response[i].value;
			                             s += '<option value="'+ri+'">'+ri+'</option>';
			                          }
			                        }
			                       return s + "</text>";
			                     }		 */
					},
					{name:'articleid', index:'articleid', sortable:true, width:90, editable:true, hidden: true},
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
							 	  edittype:'select', editoptions:{value:{FinishedLeather:'Finished Leather',LeatherGoods:'Leather Goods'}
							  },	  
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
				 		
			grid.jqGrid('navGrid', '#pager',  { edit: true, add: true, del: false, 
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
	 					 	  url: "/Myelclass/PrfinsertArticle.do?ctno="+ctno+"&action="+"add",
		 		          }
		 		          );
		   });
	
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
 
//Agent DDL
 function loadAgent(){
	 var agentname = document.getElementById("prf_agentname").value;
	<c:forEach items="${agentarray}" var="agentlist"> 	
	 	var selectedagent = "<c:out value='${agentlist.agentname}' />" ;
	 	if(agentname == selectedagent){		 		
	 		var agentctno = "<c:out value='${agentlist.contractNo}' />" ;
	 		if(agentctno.length == 0 )
			{
					agentctno = "L0001";
			}
	 		document.getElementById("prf_contractno").value = agentctno;
		 	}
	 </c:forEach>
	}

//Load Consignee Details
	function loadConsignee(){
		var consigname = document.getElementById("prf_consigneename").value;
		<c:forEach items="${consigneearray}" var="consigneelist">
		var selectedconsig  = "<c:out value='${consigneelist.consigneeName}' />" ;
		if(consigname == selectedconsig){				
			var selectedconsigaddr = "<c:out value='${consigneelist.consigneeAddress}' />" ;
			var selectedconsigphone = "<c:out value='${consigneelist.consigneeContactNo}' />" ; 
  		    var selectedconsigaattn = "<c:out value='${consigneelist.consigneeAttention}' />" ; 
  		    var selectedconsigfax = "<c:out value='${consigneelist.consigneefax}' />" ;
     		document.getElementById("prf_consigneeaddr").value = selectedconsigaddr; 
			document.getElementById("prf_consigneephone").value = selectedconsigphone;
 			document.getElementById("prf_consigneeattn").value = selectedconsigaattn;
 			document.getElementById("prf_consigneefax").value = selectedconsigfax;	 
			}
			</c:forEach>
}

//Load Notify Consignee Details /////Check there are Some Errors in Laoding Values////
 
	function loadNotify(){
		var notifyname = document.getElementById("prf_notifyname").value;
		<c:forEach items="${notifyarray}" var="notify">
		var selectednotify  = "<c:out value='${notifylist.notifyConsigneeName}' />" ;
		if(notifyname == selectednotify){	
			var selectednotifyaddr = "<c:out value='${notifylist.notifyConsigneeAddress}' />" ;
			var selectednotifyphone = "<c:out value='${notifylist.notifyConsigneeContactNo}' />" ; 
  		    var selectednotifyaattn = "<c:out value='${notifylist.notifyConsigneeAttention}' />" ; 
  		    var selectednotifyfax = "<c:out value='${notifylist.notifyConsigneefax}' />" ;
     		document.getElementById("prf_notifyaddr").value = selectednotifyaddr; 
			document.getElementById("prf_notifyphone").value = selectednotifyphone;
 			document.getElementById("prf_notifyattn").value = selectednotifyaattn;
 			document.getElementById("prf_notifyfax").value = selectednotifyfax;
		}
		</c:forEach>
}


//Load Bank Details
		function loadBank(){
			var bankname = document.getElementById("prf_bankname").value;
			<c:forEach items="${bankarray}" var="banklist">
			var selectedbank  = "<c:out value='${banklist.bankName}' />" ;
			if(bankname == selectedbank){	
				var selectedbankaddr = "<c:out value='${banklist.bankAddress}' />" ;
				var selectedbankphone = "<c:out value='${banklist.bankContactNo}' />" ; 
	  		    var selectedbankbranch = "<c:out value='${banklist.bankBranch}' />" ; 
	     		document.getElementById("prf_bankaddr").value = selectedbankaddr; 
				document.getElementById("prf_bankphone").value = selectedbankphone;
	 			document.getElementById("prf_bankbranch").value = selectedbankbranch;
			}
			</c:forEach>
}
 
 function calsizeAvg(){
	var sizemin = document.getElementById("prf_sizemin").value;
	var sizemax = document.getElementById("prf_sizemax").value;
	var sizeavg = (parseInt(sizemin) + parseInt(sizemax))/2;
	 document.getElementById("prf_sizeavg").value = sizeavg;
}

function calArticlepcs(){
	var sizeavg = document.getElementById("prf_sizeavg").value;
	var quantity = document.getElementById("prf_quantity").value;
	var pieces = parseInt(quantity) / parseInt(sizeavg);
	var piecesprecision = pieces.toFixed(2); 
	document.getElementById("prf_pieces").value = piecesprecision;
}

function loadarticleidvalue(){
	var articlename = document.getElementById("prf_articlename").value; 
		<c:forEach items="${articlearray}" var="articleList">
			var articlevalue  = "<c:out value="${articleList.articlename}"></c:out>" ;
			  	if(articlename == articlevalue){
			  		var selectedarticleid =  "<c:out value="${articleList.articleid}"></c:out>" ;
			  		document.getElementById("articleid").value = selectedarticleid;
			  	}
		</c:forEach>
 }
 
</script>
</head>
<body>
	<h:form action="/Prf" method="post">
		<table width="812" border="1" cellspacing="0" cellpadding="0" >
   		<tr>  			
   			<td>Welcome ${user.name}...</td> 
   			<td><h:submit property="prfaction" value="Logout"></h:submit></td> 
   		</tr>
   </table>
   <font color="red">
	<h:errors/>
</font>
    <table width="800" border="1" cellspacing="0" cellpadding="0">
         	 <tr>
           		 <td width="97">
           		 	<table width="263" border="0" cellspacing="0" cellpadding="0">
              			<tr>
                			<td height="40">
                			<fieldset>
        							<legend>Contract Details</legend>
        							<br/>
                     			    Agent:<h:select property="prf_agentname" styleId="prf_agentname" onchange="loadAgent()">
          									  	<h:option value="0">select Agent</h:option>         	
          	 										<c:forEach var="agentList" items="${agentarray}">
          	 											<h:option value="${agentList.agentname}">
          	 												<c:out value="${agentList.agentname}"></c:out>
          	 											</h:option>
          	 										</c:forEach>
          										</h:select><br /><br />
        								Contract  No.<h:text property="prf_contractno" styleId="prf_contractno" /><br />
        								<br />
        								Date : <h:text property="prf_orderdate" styleId="prf_orderdate" value=""></h:text> <br /><br />						    
        								P.O reference : <h:text property="prf_poref" styleId="prf_poref"></h:text><br /><br />
      							</fieldset>
                  			</td>
            	  		</tr>
        	 	 	</table>
        	 	 </td>
            	<td width="97">
            		<table width="263" border="0" cellspacing="0" cellpadding="0">
              			<tr>
                			<td height="21"><fieldset>         
        							<legend>Tannery Details</legend><br/> 
        												Name: <h:text property="prf_tanname" styleId="prf_tanname"></h:text><br />      								      
       	 												Attn: <h:text property="prf_tanattn" styleId="prf_tanattn"></h:text><br />
         												Address:<h:textarea property="prf_tanaddr" cols="30" rows="2" styleId="prf_tanaddr"></h:textarea><br />
        												Telephone : <h:text property="prf_tanphone" styleId="prf_tanphone"> </h:text><br />
														Fax:  <h:text property="prf_tanfax" styleId="prf_tanfax"> </h:text>  <br />  
      										</fieldset>
                  			</td>
             		 	</tr>
            	  	</table>
             	</td>
            	<td width="97">
            		<table width="263" border="0" cellspacing="0" cellpadding="0">
              			<tr>
                			<td height="21"><fieldset>
       								<legend>Customer Details</legend><br/> 
       									Name:<h:text property="prf_custname" styleId="prf_custname"></h:text><br /><br />        
        								Attn: <h:text property="prf_custattn" styleId="prf_custattn"></h:text><br />
         								Address:<h:textarea property="prf_custaddr" cols="30" rows="2" styleId="prf_custaddr"></h:textarea><br />
        								Telephone : <h:text property="prf_custphone" styleId="prf_custphone"> </h:text><br />
										Fax:  <h:text property="prf_custfax" styleId="prf_custfax"> </h:text>  <br />  
      							</fieldset>
                  			</td>
              			</tr>
            		</table>
            	</td>
          	</tr>
          	 <tr>
            	  <td> 	
            	   <h:button property="artinsert" value="insert" styleId="thelink"></h:button>       	
             	</td>
          	</tr>
          	<tr>
          	<td height="53" colspan="3">
          			<b>Response:</b> <span id="rsperror" style="color:red"></span> <br/>
             <table id="list">
             </table> 
				<div id="pager"></div> 
          	</td>
          	</tr>
          	<tr>
            	<td><fieldset><legend>Delivery Details</legend><br/> 
        									CDD: <h:text property="prf_cdd" styleId="prf_cdd" styleClass="prf_delivrydate"></h:text><br /> <br /> 
       	 									ADD: <h:text property="prf_add" styleId="prf_add" styleClass="prf_delivrydate"></h:text><br /><br /> 
       	 									
         									Destination: <h:text property="prf_destination" styleId="prf_destination"></h:text><br /><br /> 
        									Terms : <h:select property="prf_terms" styleId="prf_terms">
       		 													<h:option value="0">select Terms</h:option>
          															<c:forEach items="${termsarray}" var ="termsList">
          																<h:option value="${termsList.termName}">
          			    													<c:out value="${termsList.termName}"></c:out>
          																</h:option>  
          															</c:forEach> 
       		 											  		</h:select><br />
      				</fieldset>
      			</td>
            	<td><fieldset><legend>Commission Details</legend>
            							    Insurance:  <h:select property="prf_insurance" styleId="prf_insurance"> <br /> 
          														<h:option value="1">Will Be Covered By Consignee</h:option>     
          														<h:option value="2">Will Be Covered By Shipper</h:option>      			    													         															
       		 											</h:select><br /><br />
            								Payment:  <h:select property="prf_payment" styleId="prf_payment">
       		 													<h:option value="0">select Payment</h:option>
          															<c:forEach items="${paymentarray}" var ="paymList">
          																<h:option value="${paymList.payment}">
          			    													<c:out value="${paymList.payment}"></c:out>
          																</h:option>        		
          															</c:forEach>
       		 											  		</h:select><br /><br />
       		 											  			
        									elclass Commission : 
        									
        									<h:text property="prf_elclasscommission" styleId="prf_elclasscommission"></h:text>
        									<br /><br />
       		 											  		
       		 								<!--  TRY with Dynamically Add Textbox -->
       		 											  		
       		 									<div id="prfcommissiongroup">
       		 											<div id="prfcommissiondiv">
									       		 		Commission :<h:text property="prf_commission" styleId="prf_commission" ></h:text><br /><br/>
									       		 		</div> 							
       		 									</div>	
       		 									<h:button value='Add' property='addButton' styleId="addButton"></h:button>
												<h:button value='Remove' property='removeButton' styleId="removeButton"></h:button> 					  					  		
      							</fieldset>
      			</td>
            	<td><fieldset><legend>Special Condition</legend><br/> 
        									Condtion 1: <h:textarea property="prf_special" cols="30" rows="2" styleId="prf_special"></h:textarea><br />        
       	 									Inspection Cdn: <h:textarea property="prf_special" cols="30" rows="2" styleId="prf_special"></h:textarea><br />
         			</fieldset></td>
          	</tr>
          	<tr>
            	<td>&nbsp;</td>
            	<td>&nbsp;</td>
            	<td>&nbsp;</td>
          	</tr>
          	<tr>
            	<td>
            		<table width="263" border="0" cellspacing="0" cellpadding="0">
                		<tr>
                  			<td height="21"><fieldset>
       											<legend>Consignee Details</legend><br/> 
       													Name: <h:text property="prf_consigneename" styleId="prf_consigneename"></h:text><br />        
        												Attn: <h:text property="prf_consigneeattn" styleId="prf_consigneeattn"></h:text><br />
         												Address:<h:textarea property="prf_consigneeaddr" cols="30" rows="2" styleId="prf_consigneeaddr"></h:textarea><br />
        												Telephone : <h:text property="prf_consigneephone" styleId="prf_consigneephone"> </h:text><br />
														Fax:  <h:text property="prf_consigneefax" styleId="prf_consigneefax"> </h:text>  <br />  
      										</fieldset>
                    		</td>
                	   </tr>
              		</table>
              	</td>
            	<td>
            		<table width="263" border="0" cellspacing="0" cellpadding="0">
              			<tr>
                			<td height="21"><fieldset>
       											<legend>Notify Details</legend><br/> 
       													Name: <h:text property="prf_notifyname" styleId="prf_notifyname"></h:text><br />        
        												Attn: <h:text property="prf_notifyattn" styleId="prf_notifyattn"></h:text><br />
         												Address:<h:textarea property="prf_notifyaddr" cols="30" rows="2" styleId="prf_notifyaddr"></h:textarea><br />
        												Telephone : <h:text property="prf_notifyphone" styleId="prf_notifyphone"> </h:text><br />
														Fax:  <h:text property="prf_notifyfax" styleId="prf_notifyfax"> </h:text>  <br />  
      										</fieldset>
                  			</td>
              			</tr>
            		</table>
            	</td>
            	<td>
            		<table width="263" border="0" cellspacing="0" cellpadding="0">
              			<tr>
               				<td height="21"><fieldset>
       											<legend>Bank Details</legend><br/> 
       													Name: <h:text property="prf_bankname" styleId="prf_bankname"></h:text><br />        
        												Branch: <h:text property="prf_bankbranch" styleId="prf_bankbranch"></h:text><br />
         												Address:<h:textarea property="prf_bankaddr" cols="30" rows="2" styleId="prf_bankaddr"></h:textarea><br />
        												Telephone : <h:text property="prf_bankphone" styleId="prf_bankphone"> </h:text><br />
														Fax:  <h:text property="prf_bankfax" styleId="prf_bankfax"> </h:text>  <br />  
      										</fieldset>
                  			</td>
             			</tr>
            		</table>
            	</td> 
          </tr>
          <tr>
            <!-- td>Running Since : <b:write name="datestarted" scope="application" format="MM/dd/yy"/> </td> -->
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td></td>
  				<td><h:submit property="prfaction" value="SavePrf" styleId="Save"></h:submit></td>
  				<!-- <a href="#" id="thelink">Clickme</a> -->
  				<%-- <h:link href="#" property="insert">Click me</h:link> --%>
  				<td><h:reset property="prfaction" value="Clear" styleId="Clear"></h:reset></td>
  				<%-- <h:button property="insert" >Insert</h:button> --%>
  			<td></td>
          </tr>
        </table>
    </h:form>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
			    
        
			<!-- ARTICLE DETAILS -->
            			 <div id="articledialog" title="Insert Article">
            			<h:form method="post" styleId="PrfArticle">
            	 	<table align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td>Article Name: </td>
						<td>
							<br />	<h:select property="prf_articlename" styleId="prf_articlename">
          					<h:option value="0">Select Article</h:option>  
          	 					<c:forEach items="${articlearray}" var="articlelist">
          							<h:option value="${articlelist.articlename}">
          								<c:out value="${articlelist.articlename}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select><br />
          					<br />	
          					<h:text property="articleid" styleId="articleid"/>	</td>
				</tr>
				<tr>
					<td>Colour: </td>
					<td><br />	<h:select property="prf_color" styleId="prf_color">
          					<h:option value="0">Select Color</h:option>         	
          	 					<c:forEach items="${colorarray}" var="colorlist">
          							<h:option value="${colorlist.colourname}">
          								<c:out value="${colorlist.colourname}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select><br />
          			</td>				
				</tr>
				<tr>
					<td>Size : </td>
					<td><br />	<h:text property="prf_sizemin" styleId="prf_sizemin" size="5"></h:text> 
						<h:text property="prf_sizemax" styleId="prf_sizemax" size="5"></h:text>
						<h:text property="prf_sizeavg" styleId="prf_sizeavg" size="5"></h:text>	
						<h:select property="prf_sizeremarks" styleId="prf_sizeremarks">
          					<h:option value="0">Select Type</h:option>         	
          	 					 <c:forEach items="${sizeremarkarray}" var="sizeremarklist">
          							<h:option value="${sizeremarklist.sizeremarks}">
          								<c:out value="${sizeremarklist.sizeremarks}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select><br /></td>						
				</tr>
				<tr>
					<td>Substance: </td>
					<td><br /><h:text property="prf_substancemin" styleId="prf_substancemin" size="5"></h:text>
							<h:text property="prf_substancemax" styleId="prf_substancemax" size="5"></h:text><br />
					</td>				
				</tr>
				<tr>
					<td>Selection : </td>
					<td><br />	<h:select property="prf_selection" style="width:80px" styleId="prf_selection">
          					<h:option value="0">Select Selection</h:option>         	
          	 					<c:forEach items="${selectionarray}" var="selectionlist">
          							<h:option value="${selectionlist.selectionname}">
          								<c:out value="${selectionlist.selectionname}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select>	
					    <h:text property="prf_selectionp1" styleId="prf_selectionp1" size="5"></h:text>
						<h:text property="prf_selectionp2" styleId="prf_selectionp2" size="5"></h:text>
						<h:text property="prf_selectionp3" styleId="prf_selectionp3" size="5"></h:text>
						<h:text property="prf_selectionp4" styleId="prf_selectionp4" size="5"></h:text><br /></td>				
				</tr>
				
				
				<tr>
					<td>Quantity: </td>
					<td><br />	<h:text property="prf_quantity" styleId="prf_quantity" size="5"></h:text> 
						 Unit : 	<h:select property="prf_unit" styleId="prf_unit" >
          					<h:option value="0">Select Unit</h:option>         	
          	 				<h:option value="sq.ft">sq.ft</h:option>
          	 				<h:option value="skins">skins</h:option>
          	 				<h:option value="pcs">pcs</h:option>	
          					</h:select>
          					pcs: <h:text property="prf_pieces" styleId="prf_pieces" size="5" ><br /></h:text>
          			</td>	 				
				</tr>
				<tr>
					<td>Rate: </td>
					<td><br />	<h:select property="prf_ratesign" styleId="prf_ratesign" >
          					<h:option value="0">Select Currency</h:option>         	
          	 					<c:forEach items="${ratearray}" var="ratelist">
          							<h:option value="${ratelist.rate}">
          								<c:out value="${ratelist.rate}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select>	
          							
					   <h:text property="prf_rate" size="5"></h:text>
					   <h:select property="prf_shipment" styleId="prf_shipment" >
					   		 <h:option value="0">Select Shipment</h:option>       	
          	 					<c:forEach items="${shipmentarray}" var="shipmentlist">
          							<h:option value="${shipmentlist.shipmentname}">
          								<c:out value="${shipmentlist.shipmentname}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select><br /></td>				
				</tr>
				<tr>
					<td>TC : </td>
					<td><br />
					<h:text property="prf_tcamt" size="5"></h:text>
					 <h:select property="prf_tccurrency" styleId="prf_tccurrency" >
					   <h:option value="0">Select TC Currency</h:option>         	
          	 					<c:forEach items="${ratearray}" var="tclist">
          							<h:option value="${tclist.denomination}">
          								<c:out value="${tclist.denomination}"></c:out>
          							</h:option>
          						</c:forEach>
          					</h:select>
						
						 <h:select property="prf_tcagent" style="width:100px" styleId="prf_tcagent">
					   <h:option value="0">Select Tc Agent</h:option>         	
          	 					<c:forEach items="${tcagentarray}" var="tcagentlist">
          							<h:option value="${tcagentlist.tcagent}">
          								<c:out value="${tcagentlist.tcagent}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select><br />
          					</td>        										
				</tr>
				</table>	
				</h:form>
                </div>  
								
</body>
</h:html>