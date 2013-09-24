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

import sb.elpro.bo.SrfBo;
import sb.elpro.bo.SrfBoImpl;
import sb.elpro.model.PrfArticle;
import sb.elpro.model.SrfArticle;

/**
 * @author Wahab
 *
 */
public class SrfInsertArticle extends Action{

		SrfBo srfbo = new SrfBoImpl();
		HttpSession usersession;
		
		public ActionForward execute(ActionMapping map, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response) throws Exception{			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			usersession = request.getSession(false);
			JSONObject jsonobj = new JSONObject();
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
            	   System.out.println(" In Article LAOD");
					List<SrfArticle> article = srfbo.getSrfArticleDetails(sidx,sord);
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
				}else{
					String sizerem = request.getParameter("srf_sizeremarks");
					String siz = request.getParameter("srf_size");
					String size = siz+" "+sizerem;
					System.out.println("size "+size);
					
					String rat = request.getParameter("srf_rateamt");
					String ratsig = request.getParameter("srf_ratesign");
					String ship = request.getParameter("srf_shipment");
					String rate = ratsig+" "+rat+" "+ship;
					System.out.println("rate"+rate);
					
					SrfArticle artindertdetail = new SrfArticle();
					 artindertdetail.setSrf_samplenum(request.getParameter("srf_samplenum"));
					 artindertdetail.setArticleid(request.getParameter("articleid")) ;
					 artindertdetail.setSrf_articleid(request.getParameter("srf_articleid")) ;
					 artindertdetail.setSrf_articlename(request.getParameter("srf_articlename"));
					 artindertdetail.setSrf_articleshform(request.getParameter("srf_articleshform"));
					 artindertdetail.setSrf_articletype(request.getParameter("srf_articletype"));
					 artindertdetail.setSrf_color(request.getParameter("srf_color"));
					 artindertdetail.setSrf_price(rate);
					 artindertdetail.setSrf_unit(request.getParameter("srf_unit"));
					 artindertdetail.setSrf_pieces(request.getParameter("srf_pieces"));
					 artindertdetail.setSrf_qty(request.getParameter("srf_qty"));
					 artindertdetail.setSrf_selection(request.getParameter("srf_selection"));
					 artindertdetail.setSrf_selectionp(request.getParameter("srf_selectionp"));
					 artindertdetail.setSrf_size(size);
					 artindertdetail.setSrf_substance(request.getParameter("srf_substance"));
					 artindertdetail.setSrf_colormatch(request.getParameter("srf_colormatch")); 
					 artindertdetail.setSrf_crockdry(request.getParameter("srf_crockdry"));
					 artindertdetail.setSrf_crockwet(request.getParameter("srf_crockwet"));
					 artindertdetail.setSrf_fourfold(request.getParameter("srf_fourfold"));
					 artindertdetail.setSrf_keytest(request.getParameter("srf_keytest"));
					 artindertdetail.setSrf_tapetest(request.getParameter("srf_tapetest"));
					 artindertdetail.setUser(request.getParameter("user"));
					 if(oper.equalsIgnoreCase("add")){
							System.out.println(" In Article Add");
							boolean isSrfArticleAdded = srfbo.addSrfArticleDetails(artindertdetail,sidx,sord);
							if(isSrfArticleAdded){
								jsonobj.put("success", "Successfully Inserted The Record");
							}else{
								jsonobj.put("Error", "Error in Inserrting");
							}
							System.out.println(jsonobj);		
							out.println(jsonobj);
					}else if(oper.equalsIgnoreCase("edit")){
							boolean isSrfArticleUpdated = srfbo.editSrfArticleDetails(artindertdetail,sidx,sord);
							if(isSrfArticleUpdated){
								jsonobj.put("message", "Successfully Inserted The Record");
							}else{
								jsonobj.put("Error", "Error in Updating");
							}
							System.out.println(jsonobj);		
							out.println(jsonobj);
					}else{
						boolean isSrfArticleDel = srfbo.delPrfArticleDetails(artindertdetail,sidx,sord);
						if(isSrfArticleDel){
						jsonobj.put("message", "Successfully Inserted The Record");
						}else{
							jsonobj.put("Error", "Error in Deleting");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
						
					}
					 	
			}
			
			System.out.println("In Article Selected List Servlet");
			
		}
			return null;
	}
}
    