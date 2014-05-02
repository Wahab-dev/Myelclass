<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
<h1>Invalid  User Page</h1>
<%-- <h:form action="/login" method="post" >
	<table style="border: thin;">
   		<tr>  			
   			 	
   			<td>Click Here<h:link action="login"></h:link>to login Again</td> 
   		</tr>
   </table>
</h:form> --%>
 <ul>
            <li><h:link action="/login"> Click here </h:link>to go to Login Page</li>
</ul>
</body>
</html>