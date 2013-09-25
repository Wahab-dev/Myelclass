/**
 * 
 */
package sb.elpro.action;

import java.io.PrintWriter;
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

/**
 * @author Wahab
 * 
 */
public class BulkAction extends Action  {
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
	                
	             System.out.println("rows "+rows); //4
	             System.out.println("page "+pag); //1
	             System.out.println("sidx "+sidx);
	             System.out.println("sord "+sord);
	             System.out.println("action "+action);
	         	 if(oper == null){
					 System.out.println(" In Bulk  LAOD");
					List<BulkArticle> article = bulkbo.getBulkDetails(sidx,sord);
					int records = article.size();
					System.out.println("Reords  "+records);
					
						int page = Integer.parseInt(pag);
		                int totalPages = 0;
		                int totalCount = records;
		                if (totalCount > 0) {
		                	 if (totalCount % Integer.parseInt(rows) == 0) {
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
					System.out.println(jsonobj);		
					out.println(jsonobj);
				}else {
					BulkArticle bulkmodel = new BulkArticle();
					bulkmodel.setAdd_date(request.getParameter("add_date"));
					bulkmodel.setAgent(request.getParameter("agent"));
					bulkmodel.setArticlename(request.getParameter("articlename"));
					bulkmodel.setBankid(request.getParameter("bankid"));
					bulkmodel.setCdd_date(request.getParameter("cdd_date"));
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
					bulkmodel.setQtyshpd(request.getParameter("qtyshpd"));
					bulkmodel.setQuantity(request.getParameter("quantity"));
					bulkmodel.setRate(request.getParameter("rate"));
					bulkmodel.setRdd_date(request.getParameter("rdd_date"));
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
