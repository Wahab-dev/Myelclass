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
		/*System.out.println("IN Print  ");
		 PrfForm prfprintform =(PrfForm) form;
		 BeanUtils.copyProperties(prfprintbean, prfprintform);
		 System.out.println("Ct No  "+prfprintform.getPrf_contractno());
		
		Connection conn = null;
		
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/elpro","root","tiger");
            System.out.println("conn "+conn.getCatalog());
            } catch (SQLException ex) {
            } catch (ClassNotFoundException ex) {
            }
		response.setContentType("application/pdf");
        ServletOutputStream out = response.getOutputStream();
        
        
        JasperReport report = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/SubreportTest/Blank_A4.jrxml");
        //JasperReport subreportcust = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/SubreportTest/address.jrxml");
        JRBeanCollectionDataSource beanColDataSource = new
        		JRBeanCollectionDataSource(prfprintbean);
        
        
        List<ProductDetails> reportRows = new ArrayList<ProductDetails>;
        HashMap<String, Object> params = new HashMap<String, Object>(); 
        params.put("prf_contractno", prfprintform.getPrf_contractno());
        JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(params);
        //params.put("$F{customerid}", subreportcust);
       
        	System.out.println("zzzzz"+params.toString());
        	//System.out.println("zzzzz"+subreportcust.getName());
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, conn);
            
            //Pdf Converter           
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
            try {
    			exporter.exportReport();
    			
    		} catch (JRException e) {
    			throw new RuntimeException(e);
    		}catch (Exception e) {
       			e.printStackTrace();
    		}
		*/
		
		/*System.out.println("1 .0 "); 
		//Connection connection = null;
		ServletOutputStream servletOutputStream = response.getOutputStream();
		InputStream reportStream = getServlet().getServletConfig().getServletContext().getResourceAsStream("/jasper/prf.jasper");
		System.out.println("1 .1"); 
		response.setContentType("application/pdf");
		//Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1 .2 "); 
		//connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/elpro?user=root&password=tiger");
		JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, new HashMap());
		//connection.close();
		System.out.println("1 .3 "); 
		servletOutputStream.flush();
		servletOutputStream.close();
		return map.getInputForward();*/
		
		
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
