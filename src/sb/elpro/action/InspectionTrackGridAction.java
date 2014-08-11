/**
* This class draws .
* @author Wahab
* @version 1.2
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

import sb.elpro.bo.InspectionTrackBo;
import sb.elpro.bo.InspectionTrackBoImpl;
import sb.elpro.model.InspectionBean;

/**
 * @author Wahab
 *
 */
public class InspectionTrackGridAction extends Action {
HttpSession usersession;
InspectionTrackBo insptrackbo = new InspectionTrackBoImpl();

		public ActionForward execute (ActionMapping map, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response ) throws Exception {
			System.out.println("Insp In Track Load ");
			PrintWriter out = response.getWriter();
			JSONObject jsonobj = new JSONObject();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			usersession = request.getSession(false);
			if(!(usersession == null)){
				// String oper =   request.getParameter("oper");
				 String rows = request.getParameter("rows");
	             String pag = request.getParameter("page");
	             String sidx = request.getParameter("sidx");
	             String sord = request.getParameter("sord");
	             String action = request.getParameter("action");
	             String artid = request.getParameter("artid");
				
	             System.out.println("rows "+rows); 
	             System.out.println("page "+pag); 
	             System.out.println("sidx "+sidx);
	             System.out.println("sord "+sord);
	             System.out.println("action "+action);
	             System.out.println("artid "+artid);
	             
	            if(action.equalsIgnoreCase("load")){
	            	 System.out.println("In INsp Track Load ");
	            	 List<InspectionBean> trackingload = insptrackbo.getInspectionTrackDetails();
	            	 int records = trackingload.size();
	            	 System.out.println("Records  "+records);
	            	 int page = Integer.parseInt(pag);
	            	 int totalPages = 0;
			         int totalCount = records;
			         if (totalCount > 0) {
			           	 if (totalCount % Integer.parseInt(rows) == 0) {
			           		 System.
			           		 out.println("STEP 1 "+totalCount % Integer.parseInt(rows) );
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
					 jsonobj.put("rows", trackingload);
					 System.out.println(jsonobj);		
					 out.println(jsonobj);             
	          }
				
		} else{
			System.out.println("Wrong USer ////");
			return map.findForward("logout");
		}
			return null;
	}
}
