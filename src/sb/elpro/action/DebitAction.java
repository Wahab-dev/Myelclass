/**
 * 
 */
package sb.elpro.action;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sb.elpro.actionform.DebitForm;
import sb.elpro.bo.DebitBo;
import sb.elpro.bo.DebitBoImpl;
import sb.elpro.bo.TcDebitBo;
import sb.elpro.bo.TcDebitBoImpl;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.utility.DateConversion;
import sb.elpro.utility.GetNumberFromString;

/**
 * @author Wahab
 *
 */
public class DebitAction extends DispatchAction {
	HttpSession usersession;
	DebitBo debbo = new DebitBoImpl();
	TcDebitBo tcdebitbo = new TcDebitBoImpl();
	DebitFormDetails debformbean = new DebitFormDetails();
	
	public ActionForward Logout(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		usersession = request.getSession(false);
		usersession.invalidate();
		return mapping.findForward("logout");
	}
	public ActionForward Save(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in Save");
		 PrintWriter out = response.getWriter();
		 DebitForm debsaveform =(DebitForm) form;
		 BeanUtils.copyProperties(debformbean, debsaveform);
		 usersession = request.getSession(false);
		 System.out.println("Sessio n "+usersession);
		 debformbean.setDeb_debitdate(DateConversion.ConverttoMysqlDate(request.getParameter("deb_debitdate")));
		 if(!(usersession == null)){
			 JSONObject debjsonobj = new JSONObject();
			 System.out.println("usersession "+usersession.getId());
			 System.out.println("request  "+usersession.getAttribute("debactionform"));

			 if(debsaveform.getDebactionform().equals("edit")){
				 boolean isupdtdeb = debbo.updtDebitform(debformbean);
				 if(isupdtdeb){
						debjsonobj.put("result", isupdtdeb);
						debjsonobj.put("success", "Successfully Saved The Form");
						debsaveform.reset(mapping, request);
						out.println(debjsonobj);
						return mapping.findForward("gotodebittracking");
					}else{
						debjsonobj.put("result", isupdtdeb);
						debjsonobj.put("error", "Error in Saving The Form");
						out.println(debjsonobj);
						return null;
					} 
			 }else{
				 boolean issaveddeb = debbo.saveDebitform(debformbean);
				 if(issaveddeb){
						debjsonobj.put("result", issaveddeb);
						debjsonobj.put("success", "Successfully Saved The Form");
						debsaveform.reset(mapping, request);
						out.println(debjsonobj);
						return mapping.findForward("debissaved");
					}else{
						debjsonobj.put("result", issaveddeb);
						debjsonobj.put("error", "Error in Saving The Form");
						out.println(debjsonobj);
						return null;
					}
			 }
		 }
		 else{
			 System.out.println(" Invalid Session");
			 return mapping.findForward("logout");
		 } 
	}
	public ActionForward TCSave(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in TC SAVE");
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
			 System.out.println("deb_elclassrefdt "+tcformbean.getTcdeb_elclassrefdt());
			 // Save the TC Debit Form In ADD
			 boolean issavedtcdeb = tcdebitbo.saveTCDebitform(tcformbean);
			 if(issavedtcdeb){
					tcjsonobj.put("result", issavedtcdeb);
					tcjsonobj.put("success", "Successfully Saved The Form");
					//tcsaveform.reset(mapping, request);
					//out.println(tcjsonobj);
					return null;
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
	public ActionForward TCClear(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in TC Clear");
		
		return null;
	}
	public ActionForward TCPrint(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in TC PRINT");
			Connection conn = null;
			try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/elpro","root","tiger");
	            } catch (SQLException ex) {
	            } catch (ClassNotFoundException ex) {
	            }
			response.setContentType("application/ms-excel"); 
			response.setHeader("Content-Disposition", "attachment; filename=TCDebit.xls");
	        ServletOutputStream out = response.getOutputStream();
			System.out.println("IN Print  ");
			DebitForm tcprintform =(DebitForm) form;
			JasperReport report = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/TCDebitForm.jrxml");
			HashMap<String, Object> hm = new HashMap<String, Object>();
			int tcamt = GetNumberFromString.GetIntFromString(tcprintform.getTcdeb_tcamt());
			String tcamts = String.valueOf(tcamt);
			System.out.println("tcamts "+tcamts);
			String currency = (tcprintform.getTcdeb_rate().substring(0,1));
			System.out.println("Currency "+currency);
			String tccurr = currency.equalsIgnoreCase("$")? "USD" : currency.equalsIgnoreCase("E")? "Euro" : "Rs";
			hm.put("ptctanname",tcprintform.getTcdeb_exporter());
			hm.put("ptctanaddr", tcprintform.getTcdeb_tanaddr());
			
			hm.put("ptctanphone", tcprintform.getTcdeb_tantelephone());
			//hm.put("tcamt", tcamts);
			hm.put("tcamt", tcprintform.getTcdeb_tcamt());
			hm.put("ptccurrency", tccurr);
			hm.put("ptcdebno", tcprintform.getTcdeb_tcdebitno());
			hm.put("ptcdebdt", tcprintform.getTcdeb_tcdebitdate());
			hm.put("ptcelclassrefno", tcprintform.getTcdeb_elclassrefno());
			hm.put("ptcelclassrefdt", tcprintform.getTcdeb_elclassrefdt()); // 
			hm.put("ptcctno", tcprintform.getTcdeb_ctno()); 
			hm.put("ptcxcngrate",tcprintform.getTcdeb_exchangerate());
			hm.put("ptcinvnodt", tcprintform.getTcdeb_taninvno());
			hm.put("ptcqshp", tcprintform.getTcdeb_totalquantity());
			hm.put("ptcinvval", tcprintform.getTcdeb_invoiceamt());
			hm.put("ptccommpercent",tcprintform.getTcdeb_commission());
			hm.put("ptcamtinrs",tcprintform.getTcdeb_elclassamtinrs());
			hm.put("ptcamtinusd",tcprintform.getTcdeb_elclassamt());
			hm.put("ptcrupeesinword",tcprintform.getTcdebamtinwords());
			

			JasperPrint print = JasperFillManager.fillReport(report, hm, conn);
			JRXlsxExporter excelexporter = new JRXlsxExporter(); // supports jaspersoft 5.5.1 
		      
	 		// Here we assign the parameters jp and baos to the exporter
	         excelexporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
	         excelexporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);

	         // Excel specific parameters
	         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
	         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
	         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
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
	public ActionForward Print(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in Print");
		Connection conn = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/elpro","root","tiger");
            System.out.println("conn "+conn.getCatalog());
            } catch (SQLException ex) {
            } catch (ClassNotFoundException ex) {
            }		
		response.setContentType("application/ms-excel"); 
		response.setHeader("Content-Disposition", "attachment; filename=DebitNote.xls");
		
        ServletOutputStream out = response.getOutputStream();
        DebitForm debprintform =(DebitForm) form;
        BeanUtils.copyProperties(debformbean, debprintform);
        JasperReport report = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/DebitForm.jrxml");
        HashMap<String, Object> hm = new HashMap<String, Object>();  
        
        String othercomm = debformbean.getDeb_othercommission();
        int icount = othercomm.indexOf("%");
        System.out.println("Icount "+icount);
		
		System.out.println("TOTAL AMT "+debformbean.getDebamtinwords());
		hm.put("ptanname",debformbean.getDeb_exporter());
		hm.put("ptanaddr", debformbean.getDeb_tanaddr());
		hm.put("ptanphone", debformbean.getDeb_tantelephone());
		hm.put("pdebno", debformbean.getDeb_debitno());
		hm.put("pdebdt", debformbean.getDeb_debitdate());
		hm.put("pelclassrefno", debformbean.getDeb_elclassrefno());
		hm.put("", debformbean.getDeb_elclassrefdt());
		hm.put("pinvdt", debformbean.getDeb_invdate());
		hm.put("pctno", debformbean.getDeb_contractno());
		hm.put("pxcngrate",debformbean.getDeb_exchangerate());
		hm.put("pinvnodt", debformbean.getDeb_taninvno());
		hm.put("pqshp", debformbean.getDeb_totalquantity());
		hm.put("invval", debformbean.getDeb_invoiceamt());
		hm.put("invdt", debformbean.getDeb_invdate());
		hm.put("pcommpercent",debformbean.getDeb_commission());
		hm.put("psalestax","12.36"); //Wrong Value here Sales tx percent
		hm.put("pamtinrs",debformbean.getDeb_elclassamtinrs());
		hm.put("pamtinusd",debformbean.getDeb_elclassamt());
		hm.put("ptaxamt",debformbean.getDeb_tax());
		hm.put("ptotal",debformbean.getDeb_total()); // debamtinwords
		hm.put("prupeesinword",debformbean.getDebamtinwords()); 
		hm.put("pothercomm",debformbean.getDeb_othercommission());
		
		JasperPrint print = JasperFillManager.fillReport(report, hm, conn);
		JRXlsxExporter excelexporter = new JRXlsxExporter(); // supports jaspersoft 5.5.1 
	      
 		// Here we assign the parameters jp and baos to the exporter
         excelexporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
         excelexporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
 	
         // Excel specific parameters
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
         excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
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
	
}
