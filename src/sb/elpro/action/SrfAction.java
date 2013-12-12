/**
 * 
 */
package sb.elpro.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sb.elpro.actionform.PrfForm;
import sb.elpro.actionform.SrfForm;
import sb.elpro.bo.SrfBo;
import sb.elpro.bo.SrfBoImpl;
import sb.elpro.model.SampleRequest;
import sb.elpro.utility.DateConversion;



/**
 * @author Wahab
 *
 */
public class SrfAction extends DispatchAction {
	HttpSession usersession;
	SrfBo srfbo = new SrfBoImpl();
	SampleRequest srfbean = new SampleRequest();
	
	public ActionForward Save(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("In Save Srf Form  >>>");
		 PrintWriter out = response.getWriter();
		 SrfForm srfsaveform =(SrfForm) form;
		 BeanUtils.copyProperties(srfbean, srfsaveform);
		 System.out.println("Cust in Bean "+srfbean.getSrf_customer());
		 System.out.println("Deliver in Bean "+srfbean.getSrf_deliver());
		 srfbean.setSrf_orderdate(DateConversion.ConverttoMysqlDate(request.getParameter("srf_orderdate")));
		 srfbean.setSrf_cdd(DateConversion.ConverttoMysqlDate(request.getParameter("srf_cdd")));
		 srfbean.setSrf_add(DateConversion.ConverttoMysqlDate(request.getParameter("srf_add")));
		 usersession = request.getSession(false);
		 if(!(usersession == null)){
			 JSONObject srfjsonobj = new JSONObject();
			 System.out.println("usersession "+usersession.getId());
				 boolean issavedSrf = srfbo.saveSrfform(srfbean);
			if(issavedSrf){	 
				srfjsonobj.put("result", issavedSrf);
				srfjsonobj.put("success", "Successfully Saved The Form");
				srfsaveform.reset(map, request);
				out.println(srfjsonobj);
				 return map.findForward("srfissaved");
			}else{
				srfjsonobj.put("result", issavedSrf);
				srfjsonobj.put("error", "Error in Saving The Form");
				out.println(srfjsonobj);
				return null;
			}
		 }	 
		 System.out.println(" LOgin Credential Fails");
		 return map.findForward("login");
		 
		 
	}
	
	public ActionForward logout(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		usersession = request.getSession(false);
		usersession.invalidate();			
		
		return map.findForward("login");
	}
	
	public ActionForward Clear(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("IN CLEAR ");
		 SrfForm srfsaveform =(SrfForm) form;
		 srfsaveform.reset(map, request);
		return map.findForward("clearsrfform");
	}
}
