/**
* This class draws .
* @author Wahab
* @version 1.2
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

import sb.elpro.bo.MasterBo;
import sb.elpro.bo.MasterBoImpl;
import sb.elpro.model.BulkQtyDetails;
import sb.elpro.model.Masterbean;

/**
 * @author Wahab
 *
 */
public class MasterInsertAction extends Action{
	HttpSession usersession;
	MasterBo masterbo = new MasterBoImpl();
	public ActionForward execute (ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		usersession = request.getSession(false);
		System.out.println("usersession ID" +usersession.getId());
		PrintWriter out = response.getWriter();
		JSONObject jsonobj = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println("In Master Tracking Form");
		/*
		 * Check for Valid USer - If S Load the Grid 
		 * 
		 */
		if(usersession != null){
			 /*
			  * Load Parameters for the Grid Load 
			  * 
			  */
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
           
            
            //Query to Load tot 
             String totqty ="";
    		 String totshpd = "";
    		 String totbal ="";
    		 
    		 /*
				 * Method to call the Total QTy , Shipped And Balance 
				 */
				List<BulkQtyDetails> masterqty = masterbo.getMasterTotqty(sidx,sord);
				 Iterator<BulkQtyDetails> iter = masterqty.iterator();  
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
    		 
            //Query to load the Grid 	            
            List<Masterbean> mastrart = masterbo.getMasterDetails(sidx, sord, rows, pag );
			int records = mastrart.size();
			
			
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
			jsonobj.put("total", totalPages);
			jsonobj.put("page", page);
			jsonobj.put("records", records);
			jsonobj.put("rows", mastrart);
			jsonobj.accumulate("userdata", totobj);
			System.out.println(jsonobj);		
			out.println(jsonobj);
		}else{
			System.out.println("Error in Loading MAster Grid");
		}
		
		return null;
	}
}
