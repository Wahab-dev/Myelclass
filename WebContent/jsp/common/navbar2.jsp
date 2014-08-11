<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/redmond/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
 <script>
  $(function() {
    $( "#accordion").accordion({
      collapsible: true,
    });
  });
  </script>
<div id="accordion">
  <h3>Contracts</h3>
  <div>
  	<ul>
		<li><h:link action='/LoadPrf' scope="request">Prf Screen</h:link></li>
		<li><h:link action='/gotoBulkTracking'>Bulk Tacking</h:link></li>
		<li><h:link action='/loadInspection'>Inspection Screen</h:link></li>
		<li><h:link action='/gotoInspectionTracking'>Inspection Tacking</h:link></li>
		<li><h:link action='/gotoinvoice'>Invoice Screen</h:link></li>
		<li><h:link action='/InvoiceTracking'>Invoice Tracking</h:link></li>
		<li><h:link action='/gotodebit'>Debit Screen</h:link></li>
		<li><h:link action='/gotodebittracking'>Debit Tacking</h:link></li>
		<li><h:link action='/gotopayment'>Payment Screen</h:link></li>
		<li><h:link action='/gotoMasterTracking'>Master Tacking</h:link></li>
	</ul>
  </div>
  <h3>Samples</h3>
  <div>
    <ul>
		<li> <h:link action='/loadSrf' scope="request">SrfScreen</h:link></li>
		<li> <h:link action='/gotoSampleTracking'>Sample Tracking</h:link></li>
		<li> <h:link action='/gotoSampleInvoice'>Sample Invoice Screen</h:link></li>
		<li> <h:link action='/sit'>Sample Invoice Tracking</h:link></li>
		<li> <h:link action='/gotoSampleDebit'>Sample Debit</h:link></li>
	</ul>
  </div>
  <h3>Add Data</h3>
  <div>
    <ul>
		 <li><h:link action='/gotoUserInput'>User Input Settingss</h:link></li>
	</ul>
  </div>
</div>