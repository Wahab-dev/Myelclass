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

import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.model.PrfArticle;

/**
 * @author Wahab
 *
 */
public class PrfInsertArticle extends Action  {
	HttpSession usersession;
	PrfBo prfbo  =  new PrfBoImpl();
		public ActionForward execute (ActionMapping map, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response) throws Exception{
			usersession = request.getSession(false);
			PrintWriter out = response.getWriter();
			JSONObject jsonobj = new JSONObject();
			response.setContentType("application/json");
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
					List<PrfArticle> article = prfbo.getPrfArticleDetails(sidx,sord);
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
					String sizerem = request.getParameter("prf_sizeremarks");
					String siz = request.getParameter("prf_size");
					String size = siz+" "+sizerem;
					System.out.println("size "+size);
					
					String tc = request.getParameter("prf_tcamt");
					String tcsig = request.getParameter("prf_tccurrency");
					String tcto = request.getParameter("prf_tcagent");
					String Tc = tc+" "+tcsig+" "+tcto;
					System.out.println("Tc "+Tc);
					
					String rat = request.getParameter("prf_rateamt");
					String ratsig = request.getParameter("prf_ratesign");
					String ship = request.getParameter("prf_shipment");
					String rate = ratsig+" "+rat+" "+ship;
					System.out.println("rate"+rate);
					
					PrfArticle artindertdetail = new PrfArticle();
					 artindertdetail.setPrf_contractnum(request.getParameter("prf_contractnum"));
					 artindertdetail.setArticleid(request.getParameter("articleid")) ;
					 artindertdetail.setPrf_articleid(request.getParameter("prf_articleid")) ;
					 artindertdetail.setPrf_articlename(request.getParameter("prf_articlename"));
					 artindertdetail.setArtshform(request.getParameter("artshform"));
					 artindertdetail.setPrf_articletype(request.getParameter("prf_articletype"));
					 artindertdetail.setPrf_color(request.getParameter("prf_color"));
					 artindertdetail.setPrf_rate(rate);
					 artindertdetail.setPrf_tc(Tc);
					 artindertdetail.setPrf_unit(request.getParameter("prf_unit"));
					 artindertdetail.setPrf_pieces(request.getParameter("prf_pieces"));
					 artindertdetail.setPrf_quantity(request.getParameter("prf_quantity"));
					 artindertdetail.setPrf_selection(request.getParameter("prf_selection"));
					 artindertdetail.setPrf_selectionp(request.getParameter("prf_selectionp"));
					 artindertdetail.setPrf_size(size);
					 artindertdetail.setPrf_substance(request.getParameter("prf_substance"));
					 artindertdetail.setUser(request.getParameter("user"));
					if(oper.equalsIgnoreCase("add")){
						System.out.println(" In Inspection test Add");
						boolean isPrfArticleAdded = prfbo.addPrfArticleDetails(artindertdetail,sidx,sord);
						if(isPrfArticleAdded){
							jsonobj.put("success", "Successfully Inserted The Record");
						}else{
							jsonobj.put("Error", "Error in Inserrting");
						}
						System.out.println(jsonobj);		
						out.println(jsonobj);
					}else if(oper.equalsIgnoreCase("edit")){
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
					}
					
				}						
				return null;
			}else{
				System.out.println("Error Invalid Session");
				return map.findForward("login");
			}	
		}
		 
}


/*	//Display Name Value Pair 
 * //Map<String,Object> listmap = new LinkedHashMap<String,Object>();
			 
Enumeration enumarticle = request.getParameterNames();
while (enumarticle.hasMoreElements()) {
    String keys = (String) enumarticle.nextElement();
    String value = request.getParameter(keys);
    System.out.println(keys+"=  "+value);
}*/
/* PrfArticle prfartbean = new PrfArticle();
Map<String, String[]>  propertyMap = request.getParameterMap();
System.out.println("IT IS AN INSERT COMMAND");

//fetch the Records
if(propertyMap.isEmpty()){
	List<PrfArticle> article = prfbo.getPrfArticleDetails(ctno);
		//JSONArray jsArray = new JSONArray(article);
		JSONArray jsonOrderArray = JSONArray.fromObject(article);
		// json.accumulate("article", article);
		System.out.println(jsonOrderArray);					
		out.println(jsonOrderArray);
}else{
 
//Insert the Records 
prfartbean.setPrf_contractno(ctno);
BeanUtils.populate(prfartbean, propertyMap);			        
int isarticlesaved = prfbo.saveprfArticle(prfartbean);
System.out.println("INT "+isarticlesaved);

	//Check for Successfull Insertion if Yes get all records
	if(isarticlesaved == 1){
		List<PrfArticle> article = prfbo.getPrfArticleDetails(ctno);
		//JSONArray jsArray = new JSONArray(article);
		JSONArray jsonOrderArray = JSONArray.fromObject(article);
		// json.accumulate("article", article);
		System.out.println(jsonOrderArray);

		out.println(jsonOrderArray);
	}    
}*/
