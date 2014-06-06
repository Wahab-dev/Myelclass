/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.model.PoJwBean;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class PojwAction extends Action {
	PrfBo prfbo = new PrfBoImpl();
	PoJwBean pojw = new PoJwBean();
	JSONObject pojwjsonobj = new JSONObject();
		/* (non-Javadoc)
		 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
		 */
		@Override
		
		public ActionForward execute(ActionMapping map, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {			
			PrintWriter out = response.getWriter();
			
			System.out.println(" in POJW SAVE FORM ACTION");
			pojw.setPojwno(request.getParameter("prf_pojw"));
			pojw.setPojw_cddate(DateConversion.ConverttoMysqlDate(request.getParameter("pojw_cddate")));
			pojw.setPojw_comm(request.getParameter("pojw_comm"));
			pojw.setPojw_contractno(request.getParameter("pojw_contractno"));
			pojw.setPojw_orderdate(DateConversion.ConverttoMysqlDate(request.getParameter("pojw_orderdate")));
			pojw.setPojw_payterms(request.getParameter("pojw_payterms"));
			pojw.setPojw_splcdn(request.getParameter("pojw_splcdn"));
			pojw.setPrf_exporter( request.getParameter("prf_exporter"));
			pojw.setPrf_exporterid(request.getParameter("prf_exporterid"));
			pojw.setPrf_exporteraddr(request.getParameter("prf_exporteraddr"));
			pojw.setPrf_exporterattn(request.getParameter("prf_exporterattn"));
			pojw.setPrf_exporterfax(request.getParameter("prf_exporterfax"));
			pojw.setPrf_exportertele(request.getParameter("prf_exportertele"));
			
			boolean issavedpojwform =  prfbo.savePoJwForm(pojw);
			if(issavedpojwform){
				pojwjsonobj.put("result", issavedpojwform);
				pojwjsonobj.put("success", "Successfully Saved The Form");
				//prfsaveform.reset(map, request);
				out.println(pojwjsonobj);
				return null;
				//return map.findForward("pojwissaved");
			}else{
				pojwjsonobj.put("result", issavedpojwform);
				pojwjsonobj.put("error", "Error in Saving The Form");
				out.println(pojwjsonobj);
				return null;
			}
		}
}
