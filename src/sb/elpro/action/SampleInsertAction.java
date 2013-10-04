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
import sb.elpro.bo.SampTrackBo;
import sb.elpro.bo.SampTrackBoImpl;
import sb.elpro.model.BulkArticle;
import sb.elpro.model.SampleTrack;

/**
 * @author Wahab
 *
 */
public class SampleInsertAction extends Action{
	HttpSession usersession;
	SampTrackBo samptrackbo  =  new SampTrackBoImpl();
	public ActionForward execute (ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		usersession = request.getSession(false);
		PrintWriter out = response.getWriter();
		JSONObject jsonobj = new JSONObject();
		response.setContentType("application/json");
		System.out.println("In Sample Track  Action ");
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
             
             
             System.out.println("rows "+rows); //4
             System.out.println("page "+pag); //1
             System.out.println("sidx "+sidx);
             System.out.println("sord "+sord);
             System.out.println("action "+action);
             
             if(oper == null){
				 System.out.println(" In Sample  LAOD");
				List<SampleTrack> sampletrack = samptrackbo.getSampleTrackDetails(sidx,sord);
				int records = sampletrack.size();
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
				jsonobj.put("rows", sampletrack);
				System.out.println(jsonobj);		
				out.println(jsonobj);
             }
		 }else{
			 System.out.println("Error Invalid Session");
			 return map.findForward("login");
		 }
		
		return null;
	}
	
	
}
