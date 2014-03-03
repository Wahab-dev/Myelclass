<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Input Screen</title>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/pepper-grinder/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<style type="text/css">
    body { font-size: 62.5%; }
    label, input { display:block; }
    input.text { margin-bottom:12px; width:75%; padding: .4em;}
    fieldset { padding:0; border:0; margin-top:0px; }
 /*apitalise each word in a text field*/
 .myclass 
{
    text-transform:capitalize;
}
 /*Button css designed using button x generator tool in chrome */
.myButton {
	background-color:#eae0c2;
	-moz-border-radius:7px;
	-webkit-border-radius:7px;
	border-radius:7px;
	border:1px solid #f2eee4;
	display:inline-block;
	cursor:pointer;
	color:#0c0f01;
	font-family:Times New Roman;
	font-size:14px;
	font-weight:bold;
	padding:6px 12px;
	text-decoration:none;
}
.myButton:hover {
	background-color:#aba38e;
}
.myButton:active {
	position:relative;
	top:1px;
}
/*Put Border around the Dialog Box */
 .ui-widget-content.ui-dialog
	    {
	       border: 2px solid #0c0f01;
	    }
	    
/* validation tips */
.validationtips {
	font-family: sans-serif;
	font-style: normal;
	color: red;
	font-size: xx-small;
}	    
</style>
<script type="text/javascript">
$(function() {
	
	$("#tanndetails").tabs().dialog({
		 
	});
	
	
	
	$("#mybtn").click(function (){	 
		$("#dialoglink").dialog('open');
	});    
	

	$("#dialoglink").tabs().dialog({
		autoOpen: false,
	    resizable: true,
	    width:280,
	    height: 465,
	    autoResize: true, 
	    modal: true,
	    buttons: {
	        "Create": function() {
	        	var formdata = $('#tandet').serialize();
	        	alert("In Tan Save"+formdata);
	        	 var bValid = true;
	        	 bValid = bValid && checkLength(formdata);
	        	 
	        },
	        "Reset": function() {
	        	alert("In Tan Cancel");
	        },
	    }
	});
	//Valiation Part 
	function checkLength(name){
		alert("Astala  "+name);
	}
	
	
	//Submit Function
	
	
	/* $('input#tansubmit').click( function() {
		alert("In Form Submit ");
	    $.ajax({
	        url: '',
	        type: 'post',
	        dataType: 'String',
	        data: $('form#tandet').serialize(),
	        success: function(data) {
	                   alert("uu"+data);
	       }
	    });
	}); */
});
</script>
</head>
<body>
<div id="tannerydiv">
	<div id="dialoglink" title="Add Tannery">
	<p class="validationtips">Tanner and ShForm are required.</p>  
		<form class="tandet" id="tandet" method="post" action=""> 
			<fieldset>
				<label for="name">Tanner</label>
					<input type="text" required="required" 
						class="text ui-widget-content ui-corner-all" name="name"		
						placeholder="Enter Tannery Name" /> 
				<label for="name">Attn</label>
					<input type="text"  name="attn" 	
						class="text ui-widget-content ui-corner-all" title="Name" 
						placeholder="Enter Tannery Attn Name"/>
				<label for="name">Address</label> 
					<textarea rows="3" cols="30"  name="addr" 	
						class="text ui-widget-content ui-corner-all" title="Name"   	 
						placeholder="Enter Tannery Address"> </textarea>
				<label for="name">phone</label> 
					<input type="number" name="phone" 
						class="text ui-widget-content ui-corner-all"   
						placeholder="Enter Tannery Ct No"/>
				<label for="name">fax</label> 
					<input type="number" name="fax" 
						class="text ui-widget-content ui-corner-all" 
						 placeholder="Enter Tannery Fax No"/>
				<label for="name">shform</label> 
					<input type="text" required="required" name="shform"   
						class="text ui-widget-content ui-corner-all" 
						pattern="[A-Za-z0-9-]{3,7}" title="maximum 3 No Allowed" 
						placeholder="Enter Tannery ShForm"/>		
				<input type="submit" class="myButton" id="tansubmit" value="Save"></input>
				<input type="reset" class="myButton" value="Reset"></input>	
			</fieldset>
		</form>
	</div>
	<div id="tanndetails" title="Tannery Details">
	<fieldset>
		<input type="button" value=Add id="mybtn" class="myButton"></input>
		<input type="button" value=edit id="mybtn" class="myButton"></input>
		<input type="button" value=del id="mybtn" class="myButton"></input>
	</fieldset>
</div>
</div>	




<!-- <div id="dialoglink">
<form class="tandet" method="post" id="tandet">
			<fieldset>
				<label for="name">Tanner</label>
					<input type="text" required="required" 
						class="text ui-widget-content ui-corner-all" id="name" 		
						placeholder="Enter Tannery Name" /> 
				<label for="name">Attn</label>
					<input type="text" id="name" 
						class="text ui-widget-content ui-corner-all" title="Name" 
						placeholder="Enter Tannery Attn Name"/>
				<label for="name">Address</label> 
					<textarea rows="3" cols="40"  id="name" 
						class="text ui-widget-content ui-corner-all" title="Name" 	
						placeholder="Enter Tannery Address"> </textarea>
				<label for="name">phone</label> 
					<input type="number" id="name" 
						class="text ui-widget-content ui-corner-all" title="Numbers in fromat XXX-XXX-XXXX are Allowed" 
						pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" placeholder="Enter Tannery Ct No"/>
				<label for="name">fax</label> 
					<input type="number" id="name" 
						class="text ui-widget-content ui-corner-all" title="Numbers in fromat XXX-XXX-XXXX are Allowed" 
						pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" placeholder="Enter Tannery Fax No"/>
				<label for="name">shform</label> 
					<input type="text" required="required"  
						class="text ui-widget-content ui-corner-all" id="name" 
						pattern="[A-Za-z0-9-]{3,7}" title="maximum 3 No Allowed"  
						placeholder="Enter Tannery ShForm"/>		
				<input type="submit" class="myButton" id="tansubmit" value="Save"></input>
				<input type="reset" class="myButton" value="Reset"></input>	
			</fieldset>
		</form>
</div>  -->
</body>
</html>