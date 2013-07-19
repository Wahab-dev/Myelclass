<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prf Article Page</title>
<script type="text/javascript">
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

	<h1>Welcome to the Article Page </h1>
	
	<h:form>
			<table border="2" cellpadding="0" cellspacing="0" align="center">
				<tr>
				<td>
					<table align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td>Article Name: </td>
						<td>
							<br />	<h:select property="prf_articlename" value="${editArticle[0].articlename}" styleId="prf_articlename" onchange="loadarticleidvalue()">
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
					<td><br />	<h:select property="prf_color" styleId="prf_color" value="${editArticle[0].color}">
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
					<td><br />	<h:text property="prf_sizemin" value="${editArticle[0].size_min}" styleId="prf_sizemin" size="5"></h:text> 
						<h:text property="prf_sizemax" value="${editArticle[0].size_max}" styleId="prf_sizemax" size="5"></h:text>
						<h:text property="prf_sizeavg" value="${editArticle[0].size_avg}" styleId="prf_sizeavg" size="5" onfocus="calsizeAvg();"></h:text>	
						<h:select property="prf_sizeremarks" value="${editArticle[0].size_remarks}" styleId="prf_sizeremarks">
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
					<td><br /><h:text property="prf_substancemin" value="${editArticle[0].subs_min}" styleId="prf_substancemin" size="5"></h:text>
							<h:text property="prf_substancemax" value="${editArticle[0].subs_max}" styleId="prf_substancemax" size="5"></h:text><br />
					</td>				
				</tr>
				<tr>
					<td>Selection : </td>
					<td><br />	<h:select property="prf_selection" style="width:80px" value="${editArticle[0].selection}" styleId="prf_selection" onchange="loadselectionp();">
          					<h:option value="0">Select Selection</h:option>         	
          	 					<c:forEach items="${selectionarray}" var="selectionlist">
          							<h:option value="${selectionlist.selectionname}">
          								<c:out value="${selectionlist.selectionname}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select>	
					    <h:text property="prf_selectionp1" value="${editArticle[0].selp1}" size="5"></h:text>
						<h:text property="prf_selectionp2" value="${editArticle[0].selp2}" size="5"></h:text>
						<h:text property="prf_selectionp3" value="${editArticle[0].selp3}" size="5"></h:text>
						<h:text property="prf_selectionp4" value="${editArticle[0].selp4}" size="5"></h:text><br /></td>				
				</tr>
				
				
				<tr>
					<td>Quantity: </td>
					<td><br />	<h:text property="prf_quantity" value="${editArticle[0].quantity}" styleId="prf_quantity" size="5"></h:text> 
						 Unit : 	<h:select property="prf_unit" value="${editArticle[0].unit}" styleId="prf_unit" >
          					<h:option value="0">Select Unit</h:option>         	
          	 				<h:option value="sq.ft">sq.ft</h:option>
          	 				<h:option value="skins">skins</h:option>
          	 				<h:option value="pcs">pcs</h:option>	
          					</h:select>
          					pcs: <h:text property="prf_pieces" styleId="prf_pieces" value="${editArticle[0].pieces}"  size="5" onselect="calArticlepcs();"><br /></h:text>
          			</td>	 				
				</tr>
				<tr>
					<td>Rate: </td>
					<td><br />	<h:select property="prf_ratesign" value="${editArticle[0].rate_sign}" styleId="prf_ratesign" >
          					<h:option value="0">Select Currency</h:option>         	
          	 					<c:forEach items="${ratearray}" var="ratelist">
          							<h:option value="${ratelist.rate}">
          								<c:out value="${ratelist.rate}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select>	
          							
					   <h:text property="prf_rate" value="${editArticle[0].rate}" size="5"></h:text>
					   <h:select property="prf_shipment" value="${editArticle[0].shipment}" styleId="prf_shipment" >
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
					<h:text property="prf_tcamt" value="${editArticle[0].tc_currency}"  size="5"></h:text>
					 <h:select property="prf_tccurrency" value="${editArticle[0].tc_amount}" styleId="prf_tccurrency" >
					   <h:option value="0">Select TC Currency</h:option>         	
          	 					<c:forEach items="${ratearray}" var="tclist">
          							<h:option value="${tclist.denomination}">
          								<c:out value="${tclist.denomination}"></c:out>
          							</h:option>
          						</c:forEach>
          					</h:select>
						
						 <h:select property="prf_tcagent" value="${editArticle[0].tc_agent}" style="width:100px" styleId="prf_tcagent">
					   <h:option value="0">Select Tc Agent</h:option>         	
          	 					<c:forEach items="${tcagentarray}" var="tcagentlist">
          							<h:option value="${tcagentlist.tcagent}">
          								<c:out value="${tcagentlist.tcagent}"></c:out>
          							</h:option>
          						</c:forEach> 
          					</h:select><br /></td>					
				</tr>
				<tr>
					<td ></td>
					<td>
						<h:text property="prfhidd_contractno" styleId="prfhidd_contractno" value="${ctno}"/>
						<h:text property="prf_articleid" styleId="prf_articleid" value="${editArticle[0].articleid}" />
						<h:submit property="prfaction" value="saveArticle" />
						<h:submit property="prfaction" value="clearArticle" />		
					</td>					
				</tr>
			
			</table>
			</td>
			</tr>
			</table>
		</h:form>
</body>	
</h:html>