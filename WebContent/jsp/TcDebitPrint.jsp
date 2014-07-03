<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporter" %>    
<% JRHtmlExporter export = (JRHtmlExporter) request.getAttribute("exportIndentObject"); 
	session.setAttribute("exportIndentObject", export); 
	JRHtmlExporter export1 = (JRHtmlExporter) session.getAttribute("exportIndentObject"); 
	export.exportReport(); 
%>
