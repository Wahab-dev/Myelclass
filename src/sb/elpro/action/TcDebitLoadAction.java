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

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.actionform.DebitForm;
import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;
import sb.elpro.bo.TcDebitBo;
import sb.elpro.bo.TcDebitBoImpl;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.InvoiceBean;
import sb.elpro.utility.DateConversion;


/**
 * @author Wahab
 *
 */
public class TcDebitLoadAction extends Action {
	
	HttpSession usersession;
	TcDebitBo tcdebitbo = new TcDebitBoImpl();
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		usersession = request.getSession(false);	
		if(usersession !=null){	
			
			String tcdeb_tcdebitno = request.getParameter("tcdeb_tcdebitno");
			System.out.println("tcdeb_tcdebitno????"+tcdeb_tcdebitno);
			 
			PrintWriter out = response.getWriter();
			 DebitForm tcsaveform =(DebitForm) form;
			 DebitFormDetails tcformbean = new DebitFormDetails();
			 BeanUtils.copyProperties(tcformbean, tcsaveform);
			 tcformbean.setTcdeb_tcdebitdate(DateConversion.ConverttoMysqlDate(request.getParameter("tcdeb_tcdebitdate")));
			 JSONObject tcjsonobj = new JSONObject();
			 System.out.println("usersession "+usersession.getId());
			 System.out.println("request  "+usersession.getAttribute("debactionform"));
			 
			 // Save the TC Debit Form In ADD
			 boolean issavedtcdeb = tcdebitbo.saveTCDebitform(tcformbean);
			 if(issavedtcdeb){
					tcjsonobj.put("result", issavedtcdeb);
					tcjsonobj.put("success", "Successfully Saved The Form");
					tcsaveform.reset(mapping, request);
					out.println(tcjsonobj);
					return mapping.findForward("tcdebissaved");
				}else{
					tcjsonobj.put("result", issavedtcdeb);
					tcjsonobj.put("error", "Error in Saving The Form");
					out.println(tcjsonobj);
					return null;
				}
		}else{
			 System.out.println(" Invalid Session");
			 return mapping.findForward("logout");
		 } 
	}
	
}
