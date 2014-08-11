/**
 * 
 */


$(function() {
	
	 //DATEPICKER
    $("#dOB").datepicker({
	    changeYear: true,
	    autoSize: true,
	    changeMonth: true,
	    yearRange: "-70:-18",
	    dateFormat: "yy/mm/dd",
	    showWeek: true,
	    firstDay: 1,
	    numberOfMonths: 1,
	    showButtonPanel: true,
	    gotoCurrent:true, 
	    beforeShowDay: function(date) {
	        var day = date.getDay();              // Disable only SUndays
	        return [(day != 0), ''];
	    } 
	});
	 
    $("#password2").change(function (){
    	if($('#password1').val() != $('#password2').val()){
    		  $('#pwderror').text("values do not match"); 
		}
    });
	 
	$("#registerForm").click(function (){	 
		$("#registernewUserDialogForm").dialog('open');
	});
	
	
	
	 //Forgot Password 
	 $("#forgotpassworddialogform").dialog({
			autoOpen: false,
	        resizable: true,
	        width: 420,
	        height: 200,
	        autoResize: true, 
	        modal: true,
	        /* buttons:{
	        	Send:function(){  
	        	},
	        	Cancel:function(){  
	        		$(this).dialog('close');
	        	}
	        } */
		});
	
		//Register User Dialog 
		$("#forgotpassword").click(function (){	 
			$("#forgotpassworddialogform").dialog('open');
		});
			 $("#registernewUserDialogForm").tabs().dialog({
				autoOpen: false,
		        resizable: true,
		        width: 380,
		        height: 370,
		        autoResize: true, 
		        modal: true,
		       /*  buttons:{
	        		Submit:function(){  
	        		//alert("Data to be Sent to Server "+data);
		        		 $.ajax({
		                     type: 'POST',
		                     url: '/Myelclass/Registernewuser.do',
		                     data: $('#registernewUserDialogForm :input').serialize(),
		                     error: function(xml, status, error) {
		                         $('#registernewUserDialogForm').html('<p><strong>Error Code:</strong> '+status+'</p><p><strong>Explanation:</strong> '+error+'</p>');
		                     }
		                 });
	        		 alert("Data to be Sent to Server "+data);
	        		},
	        		Cancel:function(){  
	        			$(this).dialog('close');
	        		}
	        	} */ 
		});
});