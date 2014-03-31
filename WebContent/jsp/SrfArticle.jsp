<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="l"%>
<%-- <%@ taglib uri="http://displaytag.sf.net" prefix="d" %>     --%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<script type="text/javascript">

 //Article DDL
function loadarticlevalue(){
	var articlename = document.getElementById("articlename").value; 
		<c:forEach items="${articledetails}" var="articleList">
			var articlevalue  = "<c:out value="${articleList.articlename}"></c:out>" ;
			  	if(articlename == articlevalue){
			  		var selectedsizemin = "<c:out value="${articleList.size}"></c:out>" ;
				    var selectedsizemax = "<c:out value="${articleList.substance}"></c:out>" ; 
					var selectedsizeavg = "<c:out value="${articleList.sizeavg}"></c:out>" ; 
					var selectedsubstancemin = "<c:out value="${articleList.substancemin}"></c:out>" ;
					var selectedsubstancemax = "<c:out value="${articleList.substancemax}"></c:out>";
					 document.getElementById("sizemin").value = selectedsizemin; 
					 document.getElementById("sizemax").value = selectedsizemax;
					 document.getElementById("sizeavg").value = selectedsizeavg;
					 document.getElementById("substancemin").value = selectedsubstancemin;
					 document.getElementById("substancemax").value = selectedsubstancemax;
			  	}
		</c:forEach>
 }	

</script>
</head>
<body>
	<table>
		<tr>	
			<td height="150"></td>
		</tr>
		</table>
		<h:form action="/insertsrfArticle">
			<table border="2" cellpadding="0" cellspacing="0" align="center">
				<tr>
				<td>
					<table align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td>Article Name: </td>
						<td>
							<br />	<h:select property="articlename" value="${editsrfarticle[0].articlename}" styleId="articlename" onchange="loadarticlevalue();">
          					<h:option value="0">Select Article</h:option>         	
          	 					<c:forEach items="${articledetails}" var="articlelist">
          							<h:option value="${articlelist.articlename}">
          								<c:out value="${articlelist.articlename}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select><br /></td>			
				</tr>
				<tr>
					<td>Colour: </td>
					<td><br />	<h:select property="color" styleId="color" value="${editsrfarticle[0].color}" onchange="loadagentvalue();">
          					<h:option value="0">Select Article</h:option>         	
          	 					<c:forEach items="${colordetails}" var="colorlist">
          							<h:option value="${colorlist.color}">
          								<c:out value="${colorlist.color}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select><br />
          			</td>				
				</tr>
				<tr>
					<td>Size : </td>
					<td><br />	<h:text property="sizemin" styleId="sizemin" size="5"></h:text> 
						<h:text property="sizemax" styleId="sizemax" size="5"></h:text>
						<h:text property="sizeavg" styleId="sizeavg" size="5"></h:text>	
						<h:select property="articletype" styleId="articletype" onchange="loadagentvalue();">
          					<h:option value="0">Select Type</h:option>         	
          	 					<c:forEach items="${articletypedetails}" var="articletypelist">
          							<h:option value="${articletypelist.articletype}">
          								<c:out value="${articletypelist.articletype}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select><br /></td>						
				</tr>
				<tr>
					<td>Substance: </td>
					<td><br /><h:text property="substancemin" styleId="substancemin" size="5"></h:text>
							<h:text property="substancemax" styleId="substancemax" size="5"></h:text><br />
					</td>				
				</tr>
				<tr>
					<td>Selection : </td>
					<td><br />	<h:select property="selection" value="${editsrfarticle[0].selection}"  style="width:80px" styleId="selection" onchange="loadselectionp();">
          					<h:option value="0">Select Selection</h:option>         	
          	 					<c:forEach items="${selectiondetails}" var="selectionlist">
          							<h:option value="${selectionlist.selection}">
          								<c:out value="${selectionlist.selection}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select>	
					    <h:text property="selectionp1" size="5"></h:text>
						<h:text property="selectionp2" size="5"></h:text>
						<h:text property="selectionp3" size="5"></h:text>
						<h:text property="selectionp4" size="5"></h:text><br /></td>				
				</tr>
				
				
				<tr>
					<td>Quantity: </td>
					<td><br />	<h:text property="quantity" size="5"></h:text> 
						 Unit : 	<h:select property="unit" styleId="unit" onchange="loadagentvalue();">
          					<h:option value="0">Select Unit</h:option>         	
          	 					<c:forEach items="${rate}" var="ratelist">
          							<h:option value="${ratelist.ratesign}">
          								<c:out value="${ratelist.ratesign}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select>
          					<h:text property="pieces" size="5"><br /></h:text>
          			</td>	 				
				</tr>
				<tr>
					<td>Rate: </td>
					<td><br />	<h:select property="ratesign" styleId="ratesign" onchange="loadagentvalue();">
          					<h:option value="0">Select Currency</h:option>         	
          	 					<c:forEach items="${rate}" var="ratelist">
          							<h:option value="${ratelist.ratesign}">
          								<c:out value="${ratelist.ratesign}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select>	
          							
					   <h:text property="rate" size="5"></h:text>
					   <h:select property="shipment" styleId="shipment" onchange="loadagentvalue();">
					   		 <h:option value="0">Select Shipment</h:option>       	
          	 					<c:forEach items="${shipmentdetails}" var="shipmentlist">
          							<h:option value="${shipmentlist.shipment}">
          								<c:out value="${shipmentlist.shipment}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select><br /></td>				
				</tr>
				<tr>
					<td>TC : </td>
					<td><br />
					<h:text property="tcamt" size="5"></h:text>
					 <h:select property="tccurrency" styleId="tccurrency" onchange="loadagentvalue();">
					   <h:option value="0">Select TC Currency</h:option>         	
          	 					<c:forEach items="${rate}" var="tclist">
          							<h:option value="${tclist.ratesign}">
          								<c:out value="${tclist.ratesign}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select>
						
						 <h:select property="tcagent" style="width:100px" styleId="tcagent" onchange="loadagentvalue();">
					   <h:option value="0">Select Rate Sign</h:option>         	
          	 					<c:forEach items="${tcagentdetails}" var="tcagentlist">
          							<h:option value="${tcagentlist.tcagent}">
          								<c:out value="${tcagentlist.tcagent}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select><br />
          			</td>					
				</tr>
				
				<tr>
					<td>Color Matching:</td>
					<td><br />	<h:select property="colormatching" style="width:100px" styleId="colormatching">
					   		<h:option value="0">Select Color Matching</h:option>         	
          	 					<c:forEach items="${colormatch}" var="colormatchlist">
          							<h:option value="${colormatchlist.colormatching}">
          								<c:out value="${colormatchlist.colormatching}"></c:out>
          							</h:option>
          						</c:forEach> <br />
          				</h:select>
          			Tape Test: 
          			<h:select property="tapetest" style="width:100px" styleId="tapetest">
					   		<h:option value="0">Select Tape Test</h:option>         	
          	 					<c:forEach items="${tapetest}" var="tapetestlist">
          							<h:option value="${tapetestlist.tapetest}">
          								<c:out value="${tapetestlist.tapetest}"></c:out>
          							</h:option>
          						</c:forEach> <br />
          				</h:select><br />         				
          			</td>					
				</tr>
				<tr>
					<td>Crocking Wet</td>
					<td><br />	<h:select property="wetnoofrubs" style="width:100px" styleId="wetnoofrubs">
					   		<h:option value="0">Select Wet Rubs</h:option>         	
          	 					<c:forEach items="${wetrubs}" var="wetrubslist">
          							<h:option value="${wetrubslist.wetnoofrubs}">
          								<c:out value="${wetrubslist.wetnoofrubs}"></c:out>
          							</h:option> 
          						</c:forEach> 
          				</h:select>
          			Crocking Dry: 
          			<h:select property="drynoofrubs" style="width:100px" styleId="drynoofrubs">
					   		<h:option value="0">Select Dry Rubs</h:option>         	
          	 					<c:forEach items="${dryrubs}" var="dryrubslist">
          							<h:option value="${dryrubslist.drynoofrubs}">
          								<c:out value="${dryrubslist.drynoofrubs}"></c:out>
          							</h:option>
          						</c:forEach> 
          				</h:select><br />         				
          			</td>
					
				</tr>
				<tr>
					<td>Four Fold</td>
					<td><br />	<h:select property="fourfolds" style="width:100px" styleId="fourfolds">
					   		<h:option value="0">Four Fold</h:option>         	
          	 				<h:option value="1">Pass</h:option>
          	 				<h:option value="2">Fail</h:option>
          				</h:select>
          			Key Test: 
          			<h:select property="keytest" style="width:100px" styleId="keytest">
					   		<h:option value="0">Key Test</h:option>         	
          	 				<h:option value="1">Pass</h:option>
          	 				<h:option value="2">Fail</h:option>	
          				</h:select><br />         				
          			</td>
					
				</tr>
				<tr>
					<td ></td>
					<td><br />
						<h:submit property="action" value="saveArticle" />
						<h:reset property="action" value="clearArticle" />
						</td>					
				</tr>
			
			</table>
			</td>
			</tr>
			</table>
		</h:form>
		
</body>
</html>