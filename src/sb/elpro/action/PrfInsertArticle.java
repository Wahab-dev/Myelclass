/**
 * 
 */
package sb.elpro.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.model.ArticleDetails;
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
			//Map<String,Object> listmap = new LinkedHashMap<String,Object>();
			 response.setContentType("application/json");
			 if(usersession != null){	
				String ctno = request.getParameter("ctno");
				String action = request.getParameter("action");
				String rows = request.getParameter("rows");
                String pag = request.getParameter("page");
                String sidx = request.getParameter("sidx");
                String sord = request.getParameter("sord");
                
                System.out.println("rows "+rows); //4
                System.out.println("page "+pag); //1
                System.out.println("sidx "+sidx);
                System.out.println("sord "+sord);
                System.out.println("ctno "+ctno);
				System.out.println("action "+action);
				
				if(action.equalsIgnoreCase("load")){
					List<PrfArticle> article = prfbo.getPrfArticleDetails(ctno,sidx,sord);
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
					/*JSONArray jsonOrderArray = JSONArray.fromObject(article);
					System.out.println(jsonOrderArray);					
			 		out.println(jsonOrderArray);*/
				}else{
					String artaxn = request.getParameter("oper");
					String artname = request.getParameter("prf_articlename");
					System.out.println("Artname "+artname);
					System.out.println("artaxn "+artaxn);
					if(artaxn.equalsIgnoreCase("edit")){
						List<PrfArticle> article = prfbo.getPrfArticleDetails(ctno,sidx,sord);
						int records = article.size();
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
						
						System.out.println("Reords  "+records);
						jsonobj.put("total", totalPages);
						jsonobj.put("page", page);
						jsonobj.put("records", records);
						jsonobj.put("rows", article);
						
						System.out.println(jsonobj);		
						out.println(jsonobj);
						
						 //List<PrfArticle> updateartbean = prfbo.updateprfArticle(articleid,prf_articlename,prf_color,prf_price,prf_quantity,prf_selection,prf_selectionp,prf_size,prf_substance);
						
					}else if(artaxn.equalsIgnoreCase("add")){
						System.out.println(" In Article Add");
						PrfArticle artindertdetail = new PrfArticle();
						
						 artindertdetail.setArticleid(request.getParameter("articleid")) ;
						 artindertdetail.setPrf_articlename(request.getParameter("prf_articlename"));
						 artindertdetail.setPrf_color(request.getParameter("prf_color"));
						 artindertdetail.setPrf_rate(request.getParameter("prf_rateamt"));
						 artindertdetail.setPrf_ratesign(request.getParameter("prf_ratesign"));
						 artindertdetail.setPrf_shipment(request.getParameter("prf_shipment"));
						 artindertdetail.setPrf_sizeavg(request.getParameter("prf_sizeavg")); 
						 artindertdetail.setPrf_sizeremarks(request.getParameter("prf_sizerem"));
						 artindertdetail.setPrf_tcamt(request.getParameter("prf_tcamt"));
						 artindertdetail.setPrf_tccurrency(request.getParameter("prf_tcsign"));
						 artindertdetail.setPrf_tcagent(request.getParameter("prf_tcto"));
						 artindertdetail.setPrf_unit(request.getParameter("prf_unit"));
						 artindertdetail.setPrf_pieces(request.getParameter("prf_pcs"));
						 artindertdetail.setPrf_quantity(request.getParameter("prf_quantity"));
						 artindertdetail.setPrf_selection(request.getParameter("prf_selection"));
						 artindertdetail.setPrf_selectionp(request.getParameter("prf_selectionp"));
						 artindertdetail.setPrf_size(request.getParameter("prf_size"));
						 artindertdetail.setPrf_substance(request.getParameter("prf_substance"));
						 
						 boolean isPrfArticleAdded = prfbo.addPrfArticleDetails(artindertdetail,ctno,sidx,sord);
						
					}else{
						System.out.println(" In Article Dele");
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
