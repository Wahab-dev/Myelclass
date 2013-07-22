<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu page</title>
</head>
<body onload="">
	
	<h1>Menu Page</h1>
	
	Welcome ${user.name}....
	
	Go to Prf Screen <h:link action="/LoadPrf" scope="request">PrfScreen</h:link><br /><br />
	Go to Srf Screen <h:link action='/loadSrf' scope="request">SrfScreen</h:link><br /><br />
	Go to Invoice Screen <h:link action='/gotoinvoice'>invoice Screen</h:link><br /><br />
	Go to Inspection Screen <h:link action='/loadInspection'>Inspection Screen</h:link><br /><br />
	Go to Debit Screen <h:link action='/gotodebit'>Debit Screen</h:link><br /><br />
	Go to Payment Screen <h:link action='/gotopayment'>Payment Screen</h:link><br /><br />
	Go to Master Screen <h:link action='/gotomaster'>Master Screen</h:link><br /><br />
	Go to Bulk Trackig <h:link action='/gotoBulkTracking'>Bulk Tacking</h:link><br /><br />
	

</body>
</html>