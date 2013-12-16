/**
 * 
 */
package sb.elpro.action;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.BulkBo;
import sb.elpro.bo.BulkBoImpl;
import sb.elpro.model.BulkArticle;
import sb.elpro.model.BulkQtyDetails;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class BulkInsertAction extends Action {

	HttpSession usersession;
	BulkBo bulkbo  =  new BulkBoImpl();
		public ActionForward execute (ActionMapping map, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response) throws Exception{
			usersession = request.getSession(false);
			PrintWriter out = response.getWriter();
			JSONObject jsonobj = new JSONObject();
			response.setContentType("application/json");
			System.out.println("In Bulk Action ");
			 if(usersession != null){	
				 String oper =   request.getParameter("oper");
				 System.out.println("oper "+oper);
				 String action = request.getParameter("action");
				 String rows = request.getParameter("rows");
	             String pag = request.getParameter("page");
	             String sidx = request.getParameter("sidx");
	             String sord = request.getParameter("sord");
	             Boolean  search = Boolean.valueOf( request.getParameter("_search"));
	             String filters = request.getParameter("filters");
	                
	             System.out.println("rows "+rows); //4
	             System.out.println("page "+pag); //1
	             System.out.println("sidx "+sidx);
	             System.out.println("sord "+sord);
	             System.out.println("action "+action);
	             System.out.println("search  "+search);
	             System.out.println("filters  "+filters);
	             //System.out.println("filters  "+filters);
	             
	             //this parses the json
	             JSONObject jObj = new JSONObject(); 
	             jObj.getJSONObject(request.getParameter("filters")) ;
	             
				//Iterator<String> it = jObj.keys(); //gets all the keys
	             
	             Iterator<?> ite = jObj.keys();
	             System.out.println("jObj.keys()"+jObj);
	             while(ite.hasNext())
	             {
	                 String key = (String) ite.next(); // get key
	                 Object o = jObj.get(key); // get value
	                 System.out.println(key + " : " +  o); // print the key and value
	             }
	             
	             
	         	 if(oper == null){
	         		 String totqty ="";
	         		 String totshpd = "";
	         		 String totbal ="";
	         		 
					 System.out.println(" In Bulk  LAOD");
					/* if (search && filters.isEmpty()){ //Condition For Search 
						 //It Is a Toolbar Search
						 List<BulkArticle> article = bulkbo.getBulkDetails(sidx,sord);
					 }*/
					List<BulkArticle> article = bulkbo.getBulkDetails(sidx, sord, rows, pag );
					int records = article.size();
					System.out.println("Reords  "+records);
					
					List<BulkQtyDetails> bulkqty = bulkbo.getBulkTotqty(sidx,sord);
					 Iterator<BulkQtyDetails> iter = bulkqty.iterator();  
				        while(iter.hasNext()){                
				        	BulkQtyDetails bulkqtyBean = iter.next();
				        	totqty  = bulkqtyBean.getQuantity();
				        	totbal  = bulkqtyBean.getQbal();
				        	totshpd = bulkqtyBean.getQtyshpd(); 
				        	System.out.println("Tot QTY LIS "+totqty);
				        	System.out.println("BAL QTY LIS "+totbal);
				        	System.out.println("SHp QTY LIS "+totshpd);
				        }
					
					
					   JSONObject totobj = new JSONObject();
					   totobj.put("quantity", totqty);
					   totobj.put("qshipped", totshpd);
					   totobj.put("qbal", totbal);
						
						int page = Integer.parseInt(pag);  //1
		                int totalPages = 0; //0
		                int totalCount = records; //100
		                if (totalCount > 0) {
		                	 if (totalCount % Integer.parseInt(rows) == 0) { //10
		                		 System.out.println("STEP 1 "+totalCount % Integer.parseInt(rows) );
		                         totalPages = totalCount / Integer.parseInt(rows);
		                         System.out.println("STEP 2 "+totalPages);
		                     } else {
		                         totalPages = (totalCount / Integer.parseInt(rows)) + 1;
		                         System.out.println("STEP 3 "+totalPages);
		                     }
		                }else {
		                    totalPages = 0;
		                }
					jsonobj.put("total", totalPages);
					jsonobj.put("page", page);
					jsonobj.put("records", records);
					jsonobj.put("rows", article);
					jsonobj.accumulate("userdata", totobj);
					//jsonobj.
					System.out.println(jsonobj);		
					out.println(jsonobj);
				}else {
					BulkArticle bulkmodel = new BulkArticle();
					bulkmodel.setAdd_date(DateConversion.ConverttoMysqlDate(request.getParameter("add_date")));
					bulkmodel.setAgent(request.getParameter("agent"));
					bulkmodel.setArticlename(request.getParameter("articlename"));
					bulkmodel.setBankid(request.getParameter("bankid"));
					bulkmodel.setCdd_date(DateConversion.ConverttoMysqlDate(request.getParameter("cdd_date")));
					bulkmodel.setColor(request.getParameter("color"));
					bulkmodel.setComments(request.getParameter("comments"));
					bulkmodel.setCommission(request.getParameter("commission"));
					bulkmodel.setConsigneeid(request.getParameter("consigneeid"));
					bulkmodel.setCtno(request.getParameter("ctno"));
					bulkmodel.setCustomerid(request.getParameter("customerid"));
					bulkmodel.setDestination(request.getParameter("destination"));
					bulkmodel.setExporterid(request.getParameter("exporterid"));
					bulkmodel.setFeddback(request.getParameter("feddback"));
					bulkmodel.setInvdetails(request.getParameter("invdetails"));
					bulkmodel.setNotifyid(request.getParameter("notifyid"));
					bulkmodel.setOrderdt(request.getParameter("orderdt"));
					bulkmodel.setPojw(request.getParameter("pojw"));
					bulkmodel.setPono(request.getParameter("pono"));
					bulkmodel.setPrfarticleid(request.getParameter("prfarticleid"));
					bulkmodel.setQbal(request.getParameter("qbal"));
					bulkmodel.setQshipped(request.getParameter("qshipped"));
					bulkmodel.setQuantity(request.getParameter("quantity"));
					bulkmodel.setRate(request.getParameter("rate"));
					bulkmodel.setRdd_date(DateConversion.ConverttoMysqlDate(request.getParameter("rdd_date")));
					bulkmodel.setReps(request.getParameter("reps"));
					bulkmodel.setSelection(request.getParameter("selection"));
					bulkmodel.setSelectionpercent(request.getParameter("selectionpercent"));
					bulkmodel.setSize(request.getParameter("size"));
					bulkmodel.setSplcdn(request.getParameter("splcdn"));
					bulkmodel.setStatus(request.getParameter("status"));
					bulkmodel.setSubstance(request.getParameter("substance"));
					bulkmodel.setTanneryid(request.getParameter("tanneryid"));
					bulkmodel.setTc(request.getParameter("tc"));
					bulkmodel.setUnit(request.getParameter("unit"));
					bulkmodel.setUser(request.getParameter("user"));
					if(oper.equalsIgnoreCase("status")){
						System.out.println(" In BTR STATUS");
						boolean isBulkStatusUpdated = bulkbo.addBtrStatus(bulkmodel,sidx,sord);
						if(isBulkStatusUpdated){
							jsonobj.put("success", "Successfully Inserted The Record");
						}else{
							jsonobj.put("Error", "Error in Inserrting");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}/*else if(oper.equalsIgnoreCase("edit")){
						boolean isPrfArticleUpdated = prfbo.editPrfArticleDetails(artindertdetail,sidx,sord);
						if(isPrfArticleUpdated){
							jsonobj.put("message", "Successfully Inserted The Record");
						}else{
							jsonobj.put("Error", "Error in Updating");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else{
						boolean isPrfArticleDel = prfbo.delPrfArticleDetails(artindertdetail,sidx,sord);
						if(isPrfArticleDel){
						jsonobj.put("message", "Successfully Inserted The Record");
						}else{
							jsonobj.put("Error", "Error in Deleting");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}*/
					
				}
			 }else{
				 System.out.println("Error Invalid Session");
				 return map.findForward("login");
			 }
			return null;
		}
			
			
}
