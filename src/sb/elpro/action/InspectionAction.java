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


import sb.elpro.actionform.InspectionForm;
import sb.elpro.actionform.SampleInvoiceForm;
import sb.elpro.bo.InspectionBo;
import sb.elpro.bo.InspectionBoImpl;
import sb.elpro.model.InspectionBean;
import sb.elpro.utility.DateConversion;

/**
 * @author ADMIN_WIN7
 *
 */
public class InspectionAction extends DispatchAction {
	HttpSession usersession;
	InspectionBo inspbo = new InspectionBoImpl();
	 InspectionBean inspbean = new InspectionBean();
		public ActionForward Save(ActionMapping mapping, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response) throws Exception{
			System.out.println("In Sample Invoice Save Form");
			 PrintWriter out = response.getWriter();
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			 usersession = request.getSession(false);
			 JSONObject inspjsonobj = new JSONObject();
			 if(!(usersession == null)){
				
				 InspectionForm inspform =  (InspectionForm) form;
				 BeanUtils.copyProperties(inspbean, inspform);
				 inspbean.setInspdate(DateConversion.ConverttoMysqlDate(request.getParameter("inspdate")));
				 System.out.println("Sample Inv Type"+inspbean.getInspdate());
				 
				 System.out.println("usersession "+usersession.getId());
				 System.out.println("request  "+usersession.getAttribute("inspactionform"));
				 if(usersession.getAttribute("inspactionform").equals("edit")){
					/* boolean isupdtsampleinv = sampinvbo.updtSampleInvoiceform(sampinvbean);
					 if(isupdtsampleinv){
						 sampinvjsonobj.put("result", isupdtsampleinv);
						 sampinvjsonobj.put("success", "Successfully UPdt The Form");
						 sampinvform.reset(map, request);
							out.println(sampinvjsonobj);
							return map.findForward("sampleinvoicetrackisloaded");
						}else{
							sampinvjsonobj.put("result", isupdtsampleinv);
							sampinvjsonobj.put("error", "Error in UPdt  Form");
							out.println(sampinvjsonobj);
							return null;*/
				 }else{
						boolean issavedinsp = inspbo.saveInspectionform(inspbean);
						if(issavedinsp){
							inspjsonobj.put("result", issavedinsp);
							inspjsonobj.put("success", "Successfully Saved The Form");
							inspform.reset(mapping, request);
							out.println(inspjsonobj);
							return mapping.findForward("inspectionisloaded");
						}else{
							inspjsonobj.put("result", issavedinsp);
							inspjsonobj.put("error", "Error in Saving The Form");
							out.println(inspjsonobj);
							return null;
						}
				}
			}else{
					System.out.println("Invalid Login credentials");
					mapping.findForward("login");
				 }
			return null;
		}
		
		public ActionForward Logout(ActionMapping mapping, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response) throws Exception{
			System.out.println("IN INSPECTION LOGOUT");
			usersession = request.getSession(false);
			usersession.invalidate();			
			return mapping.findForward("login");
		}
}
