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
			//Map<String,Object> listmap = new LinkedHashMap<String,Object>();
			 response.setContentType("application/json");
			 if(usersession != null){	
				String oper =   request.getParameter("oper");
				System.out.println("oper "+oper);
				String artaxn = request.getParameter("oper");
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
					/*JSONArray jsonOrderArray = JSONArray.fromObject(article);
					System.out.println(jsonOrderArray);					
			 		out.println(jsonOrderArray);*/
				}else if (oper.equalsIgnoreCase("add")){
					System.out.println(" In Article Add");
					String sizerem = request.getParameter("sizerem");
					String siz = request.getParameter("size");
					String size = sizerem+" "+siz;
					System.out.println("size "+size);
					
					String tc = request.getParameter("tcamt");
					String tcsig = request.getParameter("tcsign");
					String tcto = request.getParameter("tccust");
					String Tc = tc+" "+tcsig+" "+tcto;
					System.out.println("Tc "+Tc);
					
					String rat = request.getParameter("rateamt");
					String ratsig = request.getParameter("ratesign");
					String ship = request.getParameter("shipment");
					String rate = ratsig+" "+rat+" "+ship;
					System.out.println("rate"+rate);
					
					PrfArticle artindertdetail = new PrfArticle();
					 artindertdetail.setPrf_contractno(request.getParameter("contractno"));
					 artindertdetail.setArticleid(request.getParameter("articleid")) ;
					 artindertdetail.setPrf_articlename(request.getParameter("articlename"));
					 artindertdetail.setArtshform(request.getParameter("articleshfrom"));
					 artindertdetail.setPrf_articletype(request.getParameter("articletype"));
					 artindertdetail.setPrf_color(request.getParameter("color"));
					 artindertdetail.setPrf_rate(rate);
					 artindertdetail.setPrf_tc(Tc);
					 artindertdetail.setPrf_unit(request.getParameter("unit"));
					 artindertdetail.setPrf_pieces(request.getParameter("pcs"));
					 artindertdetail.setPrf_quantity(request.getParameter("quantity"));
					 artindertdetail.setPrf_selection(request.getParameter("selection"));
					 artindertdetail.setPrf_selectionp(request.getParameter("selectionpercent"));
					 artindertdetail.setPrf_size(size);
					 artindertdetail.setPrf_substance(request.getParameter("substance"));
					 artindertdetail.setUser(request.getParameter("user"));
					 
					 boolean isPrfArticleAdded = prfbo.addPrfArticleDetails(artindertdetail,sidx,sord);
					System.out.println("isPrfArticleAdded"+isPrfArticleAdded);
					jsonobj.put("message", "Successfully Inserted The Record");
					
					System.out.println(jsonobj);		
					out.println(jsonobj);
				}else{
					 //artindertdetail.setArtshform("NA");
					/*if(artaxn.equalsIgnoreCase("edit")){
						String artid = request.getParameter("prf_articleid");
						 System.out.println(" In Article EDIZT");
						 boolean isPrfArticleUpdated = prfbo.editPrfArticleDetails(artindertdetail,artid,sidx,sord);
						 System.out.println("isPrfArticleUpdated"+isPrfArticleUpdated);
					}else if(artaxn.equalsIgnoreCase("add")){
						 System.out.println(" In Article Add");
						 boolean isPrfArticleAdded = prfbo.addPrfArticleDetails(artindertdetail,ctno,sidx,sord);
						System.out.println("isPrfArticleAdded"+isPrfArticleAdded);
					}else{
						System.out.println(" In Article Dele");
						String artid = request.getParameter("prf_articleid");
						System.out.println("artid"+artid);
						boolean isPrfArticleDel = prfbo.delPrfArticleDetails(artindertdetail,artid,sidx,sord);
						System.out.println("isPrfArticleDel"+isPrfArticleDel);
					}*/
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
