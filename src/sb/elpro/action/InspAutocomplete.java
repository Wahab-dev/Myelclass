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

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.InspectionBo;
import sb.elpro.bo.InspectionBoImpl;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.QualityCtrlrDetails;


/**
 * @author Wahab
 * Created on 22.07.13
 *  All Autocomplete in Insp Screen ll be handled by this servlet
 */
public class InspAutocomplete extends Action {
	InspectionBo inspbo = new InspectionBoImpl();
	HttpSession usersession;
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request,  HttpServletResponse response) throws Exception{
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		usersession = request.getSession(false);
		if(usersession != null){
			String action = request.getParameter("action");
			if(action.equalsIgnoreCase("inspCt")){ 
				String inspctterm = request.getParameter("term");
				List<ProductDetails> inspCtlist =  inspbo.getInspCtDetails(inspctterm);
				System.out.println("List Value " +inspCtlist.size());
				JSONArray jsonOrdertanArray = JSONArray.fromObject(inspCtlist);
				out.println(jsonOrdertanArray);
			}else if(action.equalsIgnoreCase("inspQtCtr")) {
				String qcterm = request.getParameter("term");
				List<QualityCtrlrDetails> inspqtrllist =  inspbo.getInspQltyCtlr(qcterm);
				System.out.println("List Value " +inspqtrllist.size());
				JSONArray jsonOrdertanArray = JSONArray.fromObject(inspqtrllist);
				out.println(jsonOrdertanArray);
			}else{
			System.out.println("No Action !!");
			}	
	    }else{
	    	System.out.println("Error Invalid Session");
			 return mapping.findForward("login");
	    }
	 return null;
	}
}
