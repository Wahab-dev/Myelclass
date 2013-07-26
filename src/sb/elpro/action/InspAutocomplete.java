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

import sb.elpro.bo.Inspectionbo;
import sb.elpro.bo.InspectionboImpl;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.QualityCtrlrDetails;


/**
 * @author Wahab
 * Created on 22.07.13
 *  All Autocomplete in Insp Screen ll be handled by this servlet
 */
public class InspAutocomplete extends Action {
	Inspectionbo inspbo = new InspectionboImpl();
	//PrfBo prfbo = new PrfBoImpl();
	HttpSession usersession;
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request,  HttpServletResponse response) throws Exception{
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		JSONObject jsonobj = new JSONObject();
		usersession = request.getSession(false);
		if(usersession != null){
			String action = request.getParameter("action");
			String ctno = request.getParameter("ctno");
			//String action = request.getParameter("action");
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
			if(action.equalsIgnoreCase("inspCt")){ 
				String inspctterm = request.getParameter("term");
				List<ProductDetails> inspCtlist =  inspbo.getInspCtDetails(inspctterm);
				System.out.println("List Value " +inspCtlist.size());
				JSONArray jsonOrdertanArray = JSONArray.fromObject(inspCtlist);
				System.out.println(jsonOrdertanArray);
				out.println(jsonOrdertanArray);
			}else if(action.equalsIgnoreCase("inspQtCtr")) {
				String qcterm = request.getParameter("term");
				List<QualityCtrlrDetails> inspqtrllist =  inspbo.getInspQltyCtlr(qcterm);
				System.out.println("List Value " +inspqtrllist.size());
				JSONArray jsonOrdertanArray = JSONArray.fromObject(inspqtrllist);
				System.out.println(jsonOrdertanArray);
				out.println(jsonOrdertanArray);
			}else if(action.equalsIgnoreCase("loadArticle")) {
				List<ProductDetails> inspartllist =  inspbo.getInspArtDetails(ctno);
				int records = inspartllist.size();
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
				jsonobj.put("rows", inspartllist);
				System.out.println(jsonobj);		
				out.println(jsonobj);
		}else{
			System.out.println("No Action !!");
		}
		
		
		return null;
		
	}
		System.out.println("Wrong User !!");
		return null;
	}
	
	
}
