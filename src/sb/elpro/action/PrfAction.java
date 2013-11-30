/**
 * 
 */
package sb.elpro.action;


import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.sun.org.apache.bcel.internal.generic.NEW;

import sb.elpro.actionform.PrfForm;
import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.model.ProductDetails;

/**
 * @author Wahab
 *
 */
public class PrfAction extends Action {

	PrfBo prfbo  =  new PrfBoImpl();
	HttpSession usersession;
	ProductDetails prfbean = new ProductDetails();
	
	public ActionForward execute(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		 System.out.println("In Save Prf Form");
		 PrintWriter out = response.getWriter();
		 /*
		  * Getting all values 
		  * 
		  */
		/* Enumeration<String> paramNames = request.getParameterNames();
		 while(paramNames.hasMoreElements())
	        {
			 	String paramName = (String)paramNames.nextElement();
	            String[] paramValues = request.getParameterValues(paramName);
	            for(int i=0; i<paramValues.length; i++)
                {
	            	System.out.println(paramName + paramValues[i]);
                }
	        }*/
		 prfbean.setPrf_agentname(request.getParameter("prf_agentname"));
		 prfbean.setPrf_contractno(request.getParameter("prf_contractno"));
		 prfbean.setPrf_orderdate(request.getParameter("prf_orderdate"));
		 prfbean.setPrf_poreftype(request.getParameter("prf_poreftype"));
		 prfbean.setPrf_poref(request.getParameter("prf_poref"));
		 prfbean.setPrf_tanname(request.getParameter("prf_tanname"));
		 prfbean.setPrf_custname(request.getParameter("prf_custname"));
		 prfbean.setPrf_cdd(request.getParameter("prf_cdd"));
		 prfbean.setPrf_add(request.getParameter("prf_add"));
		 prfbean.setPrf_destination(request.getParameter("prf_destination"));
		 prfbean.setPrf_terms(request.getParameter("prf_terms"));
		 prfbean.setPrf_insurance(request.getParameter("prf_insurance"));
		 prfbean.setPrf_payment(request.getParameter("prf_payment"));
		 prfbean.setPrf_elclasscommission(request.getParameter("prf_elclasscommission"));
		 prfbean.setPrf_commission(request.getParameter("prf_commission"));
		 prfbean.setPrf_special(request.getParameter("prf_special"));
		 prfbean.setPrf_inspcdn(request.getParameter("prf_inspcdn"));
		 prfbean.setPrf_consigneename(request.getParameter("prf_consigneename"));
		 prfbean.setPrf_notifyname(request.getParameter("prf_notifyname"));
		 prfbean.setPrf_bankname(request.getParameter("prf_bankname"));
		 prfbean.setPrf_exporterid(request.getParameter("prf_tanname")); //Exported ID
		 prfbean.setPrf_pojw("N/A");
		 usersession = request.getSession(false);
		 if(!(usersession == null)){
			 JSONObject prfjsonobj = new JSONObject();
			 System.out.println("usersession "+usersession.toString());
			boolean issavedPrf = prfbo.savePrfform(prfbean);
			if(issavedPrf){
				prfjsonobj.put("result", issavedPrf);
				prfjsonobj.put("success", "Successfully Saved The Form");
			}else{
				prfjsonobj.put("result", issavedPrf);
				prfjsonobj.put("error", "Error in Saving The Form");
			}
			 System.out.println("Hola  "+prfjsonobj);
			 out.println(prfjsonobj);
			 return null;
		 }	
		
		 return map.findForward("login");
	}
	
	
	/*
	public ActionForward Logout(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("Logout IN PORF ");
		usersession = request.getSession(false);
		usersession.invalidate();			
		return mapping.findForward("login");  
	}

	public ActionForward insertArticle(ActionMapping map , ActionForm form, 
			HttpServletRequest request, HttpServletResponse response ) throws Exception{
		System.out.println("In Load Article");
		String ctno = request.getParameter("contractno");
		System.out.println("Ct No  "+ctno);
		request.setAttribute("ctno", ctno);
		//String prfartid = request.getParameter("prf_articleid");
		usersession = request.getSession(false);
		if(!(usersession==null)){
			String prfartid = request.getParameter("articleid");
			
		 if(prfartid == null || prfartid.isEmpty()){
			 System.out.println("It is an Insert Command ");
		 }else{
			 System.out.println("It is an Update Command ");
			// PrfArticle editprfartbean = new PrfArticle();
			// List<ArticleDetails> editarticle =  prfbo.editprfArticle(prfartid);
			
			 //usersession.setAttribute("articlearray",editarticle);
			 
		 }
			
			
			
			
			
			String ctno = request.getParameter("contractno"); 
			String prfartid = request.getParameter("prf_articleid");
			System.out.println("Session is Valid for Article Page /+ "+ctno+ "/ /" +prfartid);
			request.setAttribute("ctno", ctno);
			request.setAttribute("prfartid", prfartid);
			return map.findForward("showArticlePage");
		}else{
			System.out.println("Session is INVALIDValid for Article Page");
			return map.findForward("login");
		}
	}
		public ActionForward saveArticle(ActionMapping map, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response ) throws Exception{
			System.out.println("SAVE ARTICLE Art");
			String ctno = request.getParameter("prfhidd_contractno"); 
			System.out.println("CT NO = +"+ctno);
			String prfartid = request.getQueryString();
			System.out.println("Qury String "+prfartid);
			
			//String id = request.getParameter("checkboxValue");
			//System.out.println("Insert ID "+id);
			usersession = request.getSession(false);
			if(usersession != null){			
				PrfForm prfArticleform =(PrfForm) form;
				System.out.println("Article ID B4 in FORM "+prfArticleform.getPrf_articleid());
				 ArticleDetails prfartbean = new ArticleDetails();
				 System.out.println("Article ID B4 in Bean "+prfartbean.getPrfarticleid());
				 BeanUtils.copyProperties(prfartbean, prfArticleform);
				 String id = prfartbean.getPrfarticleid();
				 prfartbean.setContractno(ctno);
				 if((id == null) || id.isEmpty() || id.equalsIgnoreCase("null")){
					 System.out.println("IT IS AN INSERT COMMAND");
						usersession.setAttribute("saveArticle", prfbo.saveprfArticle(prfartbean));
					}else{
						System.out.println("IT IS AN UPDATE COMMAND ");
						 PrfForm prfArticleupform =(PrfForm) form;
						 ArticleDetails prfartupbean = new ArticleDetails();
						 BeanUtils.copyProperties(prfartupbean, prfArticleupform);
						 usersession.setAttribute("saveArticle", prfbo.updateprfArticle(prfartbean));
						 String myctno = prfartbean.getContractno();
						 System.out.println("MyCTNO !!!"+ myctno);
						 getAllArticle(request,myctno);
						return map.findForward("updateprfarticle");
					}
				 String myctno = prfartbean.getContractno();
				 getAllArticle(request,myctno);
			return map.findForward("prfArticlesaved");
			}else{
			return map.findForward("login");
			//}
	}
		
		public ActionForward edit(ActionMapping mapping, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response) throws Exception{
			System.out.println("In Edit Article "); 
			PrfForm prfArticleform =(PrfForm) form;
			PrfArticle prfartbean = new PrfArticle();
			BeanUtils.copyProperties(prfartbean, prfArticleform);
			String prfarticleid = request.getParameter("prf_articleid");
			String contractno = request.getParameter("prf_contractno");
			System.out.println("Prf Article Id "+prfarticleid);
			usersession = request.getSession(false);
			if(usersession != null){
				List<PrfArticle> EditArticle =  prfbo.editprfArticle(prfarticleid);
				request.setAttribute("editarticle", EditArticle);
				return mapping.findForward("editprfarticle");
			}else
				return mapping.findForward("login");
		}
			
			
		
		private void getAllArticle(HttpServletRequest request, String myctno) throws Exception{
			List<ArticleDetails> article = prfbo.getPrfArticleDetails(myctno);
			request.setAttribute("article", article);
		}
		*/
	
}
