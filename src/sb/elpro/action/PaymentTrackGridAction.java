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

import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;
import sb.elpro.bo.PaymentBo;
import sb.elpro.bo.PaymentBoImpl;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.PaymentBean;

/**
 * @author Wahab
 *
 */
public class PaymentTrackGridAction extends Action {
	
	HttpSession usersession;
	PaymentBo paymenttrackbo =new PaymentBoImpl();
	public ActionForward execute (ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
	usersession = request.getSession(false);
	PrintWriter out = response.getWriter();
	JSONObject payjsonobj = new JSONObject();
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	System.out.println("In Payment Track Action ");
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
         if(oper == null){
        	 List<PaymentBean> debittrack = paymenttrackbo.getPayTrackDetails( );
				int records = debittrack.size();
				System.out.println("Reords  "+records);
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
            payjsonobj.put("total", totalPages);
            payjsonobj.put("page", page);
            payjsonobj.put("records", records);
            payjsonobj.put("rows", debittrack);
			//jsonobj.accumulate("userdata", totobj);
			System.out.println(payjsonobj);		
			out.println(payjsonobj);
         }
	 }else{
		 System.out.println("Error Invalid Session");
		 return map.findForward("login");
	 }
	
	
	
	return null;
	}
	
}

