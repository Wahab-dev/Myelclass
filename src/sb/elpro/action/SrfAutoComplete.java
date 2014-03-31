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

import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.bo.SrfBo;
import sb.elpro.bo.SrfBoImpl;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.EndUsageDetails;
import sb.elpro.model.HandledByDetails;
import sb.elpro.model.PaymentDetails;

/**
 * @author Wahab
 * Created on 20.07.13
 *  All Autocomplete in srf Screen ll be handled by this servlet
 */
public class SrfAutoComplete extends Action  {
	SrfBo srfbo = new SrfBoImpl();
	PrfBo prfbo = new PrfBoImpl();
	HttpSession usersession;
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request,  HttpServletResponse response) throws Exception{
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			usersession = request.getSession(false);
			if(usersession != null){
				String action = request.getParameter("action");
				if(action.equalsIgnoreCase("handlby")){
					String handlbyterm = request.getParameter("term");
					List<HandledByDetails> consigneelist =  srfbo.getsrfhandledby(handlbyterm);
					System.out.println("List Value " +consigneelist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(consigneelist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
					
				}else if(action.equalsIgnoreCase("endusage")){
					String endusageterm = request.getParameter("term");
					List<AutoComplete> endusagelist =  srfbo.getsrfEndusage(endusageterm);
					System.out.println("List Value " +endusagelist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(endusagelist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}else if(action.equalsIgnoreCase("pymttrms")){
					String pymntterm = request.getParameter("term");
					List<PaymentDetails> consigneelist =  srfbo.getPaymentDetails(pymntterm);
					System.out.println("List Value " +consigneelist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(consigneelist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}else if(action.equalsIgnoreCase("sampleno")){
					String sampleno =  srfbo.getSampleno();
					System.out.println("sampleno Value " +sampleno);
					//JSONArray jsonOrdertanArray = JSONArray.fromObject(consigneelist);
					 System.out.println(sampleno);
					 out.println(sampleno);
				}
		
		
			}
		
		return null;
	}
	
	
}
