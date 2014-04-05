/**
 * 
 */
package sb.elpro.action;


import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;




import sb.elpro.actionform.PrfForm;
import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.model.ProductDetails;
import sb.elpro.utility.DateConversion;

/**
 * @author Wahab
 *
 */
public class PrfAction extends DispatchAction {

	PrfBo prfbo  =  new PrfBoImpl();
	HttpSession usersession;
	ProductDetails prfbean = new ProductDetails();
	ProductDetails prfprintbean = new ProductDetails();
	
	public ActionForward Save(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		 System.out.println("In Save Prf Form");
		 PrintWriter out = response.getWriter();
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 PrfForm prfsaveform =(PrfForm) form;
		 BeanUtils.copyProperties(prfbean, prfsaveform);
		 
		 prfbean.setPrf_orderdate(DateConversion.ConverttoMysqlDate(request.getParameter("prf_orderdate")));
		 prfbean.setPrf_cdd(DateConversion.ConverttoMysqlDate(request.getParameter("prf_cdd")));
		 prfbean.setPrf_add(DateConversion.ConverttoMysqlDate(request.getParameter("prf_add")));
		 prfbean.setPrf_exporterid(prfbean.getPrf_tanname());
		
		/* prfbean.setPrf_agentname(request.getParameter("prf_agentname"));
		 prfbean.setPrf_contractno(request.getParameter("prf_contractno"));
		 prfbean.setPrf_poreftype(request.getParameter("prf_poreftype"));
		 prfbean.setPrf_poref(request.getParameter("prf_poref"));
		 prfbean.setPrf_tanname(request.getParameter("prf_tanname"));
		 prfbean.setPrf_custname(request.getParameter("prf_custname"));		 
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
		 prfbean.setPrf_exporterid(request.getParameter("prf_tanname")); *///Exported ID
		 prfbean.setPrf_pojw("N/A");
		// prfbean.setFormaction("edit");
		 usersession = request.getSession(false);
		 if(!(usersession == null)){
			 JSONObject prfjsonobj = new JSONObject();
			 System.out.println("usersession "+usersession.getId());
			 System.out.println("request  "+usersession.getAttribute("actionform"));
			 if(usersession.getAttribute("actionform").equals("add")){
				 boolean issavedPrf = prfbo.savePrfform(prfbean);
				 if(issavedPrf){
						prfjsonobj.put("result", issavedPrf);
						prfjsonobj.put("success", "Successfully Saved The Form");
						prfsaveform.reset(map, request);
						out.println(prfjsonobj);
						return map.findForward("prfissaved");
					}else{
						prfjsonobj.put("result", issavedPrf);
						prfjsonobj.put("error", "Error in Saving The Form");
						out.println(prfjsonobj);
						return null;
					}
			 }else{
				 boolean isupdatePrf = prfbo.updatePrfform(prfbean);
				 if(isupdatePrf){
						prfjsonobj.put("result", isupdatePrf);
						prfjsonobj.put("success", "Successfully Updated The Form");
						prfsaveform.reset(map, request);
						out.println(prfjsonobj);
						return map.findForward("bulkisloaded");
					}else{
						prfjsonobj.put("result", isupdatePrf);
						prfjsonobj.put("error", "Error in Updated The Form");
						out.println(prfjsonobj);
						return null;
					}
				
			 }
			 
		 }	
		System.out.println(" LOgin Credential Fails");
		 return map.findForward("login");
	}
	
	public ActionForward Clear(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("IN CLEAR ");
		 PrfForm prfsaveform =(PrfForm) form;
		 prfsaveform.reset(map, request);
		return map.findForward("clearprfform");
	}
	
	public ActionForward Print(ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); 
        ServletOutputStream out = response.getOutputStream();
		System.out.println("IN Print  ");
		PrfForm prfprintform =(PrfForm) form;
		prfprintform.setPrf_poref("This is the Title of the Report");
		JasperReport report = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/prf.jrxml");
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("pctno",prfprintform.getPrf_contractno());
		hm.put("porderdt", prfprintform.getPrf_orderdate());
		hm.put("ptanneryname", prfprintform.getPrf_tanname());
		hm.put("ptanneryattn", prfprintform.getPrf_tanattn());
		hm.put("ptanneryaddr", prfprintform.getPrf_tanaddr());
		hm.put("ptanneryphone", prfprintform.getPrf_tanphone());
		hm.put("ptanneryfax", prfprintform.getPrf_tanfax());
		hm.put("pcustname", prfprintform.getPrf_custname());
		hm.put("pcustattn", prfprintform.getPrf_custattn());
		hm.put("pcustaddr", prfprintform.getPrf_custaddr());
		hm.put("pcusttel", prfprintform.getPrf_custphone());
		hm.put("pcustfax", prfprintform.getPrf_custfax());
		hm.put("pdesti", prfprintform.getPrf_destination());
		hm.put("pcomm", prfprintform.getPrf_elclasscommission()+" "+prfprintform.getPrf_commission());
		hm.put("ppayment", prfprintform.getPrf_payment());
		hm.put("pinsurance", prfprintform.getPrf_insurance());
		hm.put("pterms", prfprintform.getPrf_terms());
		hm.put("pbankname", prfprintform.getPrf_bankname());
		hm.put("pbankaddr", prfprintform.getPrf_bankaddr());
		hm.put("pbankbranch", prfprintform.getPrf_bankbranch());
		hm.put("pbankphone", prfprintform.getPrf_bankphone());
		hm.put("pbankfax", prfprintform.getPrf_bankfax());
		hm.put("pconsigname", prfprintform.getPrf_consigneename());
		hm.put("pconsigattn", prfprintform.getPrf_consigneeattn());
		hm.put("pconsigaddr", prfprintform.getPrf_consigneeaddr());
		hm.put("pconsigphone", prfprintform.getPrf_consigneephone());
		hm.put("pconsigfax", prfprintform.getPrf_consigneefax());
		hm.put("pnotifyname", prfprintform.getPrf_notifyname());
		hm.put("pnotifyattn", prfprintform.getPrf_notifyattn());
		hm.put("pnotifyaddr", prfprintform.getPrf_notifyaddr());
		hm.put("pnotifytele", prfprintform.getPrf_notifyphone());
		hm.put("pnotifyfax", prfprintform.getPrf_notifyfax());
		hm.put("psplcdn", prfprintform.getPrf_special());
		JasperPrint print = JasperFillManager.fillReport(report, hm, new JREmptyDataSource());
		
		JRXlsxExporter excelexporter = new JRXlsxExporter(); // supports jaspersoft 5.5.1 
      
 		// Here we assign the parameters jp and baos to the exporter
         excelexporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
         excelexporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
 	
         // Excel specific parameters
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_GRAPHICS,Boolean.FALSE);
         
        try {
        	excelexporter.exportReport();
			
		} catch (JRException e) {
			throw new RuntimeException(e);
		}catch (Exception e) {
   			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public ActionForward Logout(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("Logout IN PORF ");
		usersession = request.getSession(false);
		usersession.invalidate();			
		return mapping.findForward("login");  
	}
	/*
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
