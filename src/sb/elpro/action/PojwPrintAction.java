/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Wahab
 *
 */
public class PojwPrintAction extends Action {

		/* (non-Javadoc)
		 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
		 */
		@Override
		public ActionForward execute(ActionMapping map, ActionForm form,
				HttpServletRequest request, HttpServletResponse myresponse)
				throws Exception {
			
			Connection conn = null;
			try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/elpro","root","tiger");
	            System.out.println("conn "+conn.getCatalog());
	            } catch (SQLException ex) {
	            } catch (ClassNotFoundException ex) {
	            }
			myresponse.setContentType("application/ms-excel"); 
			//myresponse.setHeader("Content-Length", String.valueOf(new File("C:/Users/meetw_000/Desktop/report/PrfPoForm.jrxml").length()));
			myresponse.setHeader("Content-Disposition", "attachment; filename=PRFPO.xls");
			ServletOutputStream  myout = myresponse.getOutputStream();
			System.out.println("IN Print  ");
			JasperReport report = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/PrfPoForm.jrxml");
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("prf_pojw",request.getParameter("prf_pojw"));
			hm.put("pojw_orderdate", request.getParameter("pojw_orderdate"));
			hm.put("pojw_cddate", request.getParameter("pojw_cddate"));
			hm.put("pojw_contractno", request.getParameter("pojw_contractno"));
			hm.put("pojw_comm", request.getParameter("pojw_comm"));
			hm.put("prf_exporter", request.getParameter("prf_exporter"));
			hm.put("prf_exporterattn", request.getParameter("prf_exporterattn"));
			hm.put("prf_exporteraddr", request.getParameter("prf_exporteraddr"));
			hm.put("prf_exportertele", request.getParameter("prf_exportertele"));
			hm.put("prf_exporterfax", request.getParameter("prf_exporterfax"));
			hm.put("pojw_splcdn", request.getParameter("pojw_splcdn"));
			hm.put("pojw_payterms", request.getParameter("pojw_payterms"));
			
			JasperPrint print = JasperFillManager.fillReport(report, hm, conn);
			
			JRXlsxExporter excelexporter = new JRXlsxExporter(); // supports jaspersoft 5.5.1 
	      
	 		// Here we assign the parameters jp and baos to the exporter
	         excelexporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
	         excelexporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, myout);
	 	
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
	       /* myout.flush();
	        myout.close();*/
			return map.getInputForward();
		}
}
