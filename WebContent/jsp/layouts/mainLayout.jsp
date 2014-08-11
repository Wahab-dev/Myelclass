<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<html:html lang="true">
<head>
	<title> <tiles:getAsString name="title" /></title> <!-- TITLE -->
	<html:base/>
</head>
<body bgcolor="white">
	<table style="width: 100%;height: 650px;">
		<tr>
			<td style="background-color:#EBEBFF; height: 25px;" colspan="3" align="center">
				<tiles:insert attribute="header">
					<tiles:put name="title" beanName="title" beanScope="tile"></tiles:put> <!-- HEADER -->
				</tiles:insert>		
			</td>
		</tr>	
		<tr height="300">
			<td width="22%" valign="top" bgcolor="#F0FFFF">
				<tiles:insert attribute="navbar"></tiles:insert> <!-- NAVIGATION BAR -->
			</td>
			<td width="73%" bgcolor="#FFFFE6"> 
				<tiles:insert attribute="body"></tiles:insert> <!-- BODY -->
			</td>
			<td width="5%" bgcolor="#FFF5E6" valign="top">
				<tiles:insert attribute="news"></tiles:insert> <!-- NEWS  -->
			</td>	
		</tr>	
		<tr>
			<td colspan="3" height="25" bgcolor="#FFEBFF">
				<tiles:insert attribute="footer"></tiles:insert>  <!-- FOOTER -->
			</td> 	 
		</tr>
	</table>
</body>
</html:html>