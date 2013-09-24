<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bulk Page</title>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/ui-darkness/jquery-ui-1.10.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />

<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() { 
	var bulkgrid = $('#bulkktracktbl'); 
	bulkgrid.jqGrid({     
		 		datatype: "json",
		        url:"", 
		        colNames:['Status','Ct No','PO No','Tan','Cust','Exp','Name','Color','Size','Substance','Selection','Selp','Quantity','Unit','Shipped','Balance','Comment','Price','Tc','Add','Cdd','Commission','PO/JW','Consignee','Notify','Bank','Destination','Splcdn','Represnt','Agent','Prfarticleid','User'],  
		        colModel :[   
				  {name: 'btrstatus', index: 'status', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrctno', index: 'ctno', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrpono', index: 'pono', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrtanner', index: 'tanner', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrcust', index: 'cust', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrexprtr', index: 'exprtr', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrarticle', index: 'article', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrcolor', index: 'color', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrsize', index: 'size', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrsubs', index: 'subs', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrselec', index: 'selec', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrselep', index: 'selp', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrqty', index: 'qty', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrunit', index: 'unit', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrshpd', index: 'shpd', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrbal', index: 'bal', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrcomments', index: 'comments', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrprice', index: 'price', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrtc', index: 'tc', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btradd', index: 'add', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrcdd', index: 'cdd', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrcomm', index: 'comm', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrpojw', index: 'pojw', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrconsig', index: 'consig', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrnotify', index: 'notify', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrbank', index: 'bank', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrdesti', index: 'desti', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  
				  {name: 'btrsplcdn', index: 'splcdn', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrreps', index: 'rep', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btragent', index: 'agent', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btrprfartid', index: 'prfartid', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
				  {name: 'btruser', index: 'user', align:'center', width:90, editable:true, sortable: true, hidden:false,  
					  editrules :{require : true},
				  },
		         
		        ],  
		        jsonReader : {  
		        	repeatitems:false,
		            root: function (jsonOrderArray) { return jsonOrderArray; },
		            page: function (jsonOrderArray) { return 1; },
		            total: function (jsonOrderArray) { return 1; },
		            records: function (jsonOrderArray) { return jsonOrderArray.length; }
		        },  
		       	caption: "Bulk Tracking Report",
		    	pager: '#bulkktrackpager',
		    	rowNum:10, 
		    	rowList:[20,30,40],
		        loadtext: "Bow Bow",
		        height : "auto",
		        width:"auto",  
		        sortname: 'article',  
		        sortorder: 'desc',  
		        toppager: false,
		        emptyrecords: 'No records to display',
		        });
	bulkgrid.jqGrid('navGrid','#bulkktrackpager',{
		 		 	edit:true,
		 		 	add:true,
		 		 	del:true, 
		 		 	search:true, 
		 		 	view:true, 
		 		 	}).navButtonAdd('#bulkktrackpager',{
		 		 	   caption:"Status", 
		 		 	   buttonicon:"ui-icon-add", 
		 		 	   onClickButton: function(){ 
		 		 	     alert("Adding Row");
		 		 	   }, 
		 		 	   position:"last"
		 		 	}).navButtonAdd('#bulkktrackpager',{
			 		 	   caption:"Modify", 
			 		 	   buttonicon:"ui-icon-add", 
			 		 	   onClickButton: function(){ 
			 		 	     alert("Adding Row");
			 		 	   }, 
			 		 	   position:"centre"
			 		 	});
});

</script>
</head>
<body>
<form >
	<div id="blk">Bulk Tracking</div> 
			<table id="bulkktracktbl">
             </table> 
				<div id="bulkktrackpager"></div> 
	 <%-- <h:button property="artinsert" value="load" styleId="thelink"></h:button>    --%>
	 </form>  
</body>
</html>