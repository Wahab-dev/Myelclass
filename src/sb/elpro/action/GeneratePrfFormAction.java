/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Wahab
 *
 */

public class GeneratePrfFormAction extends Action {
		public ActionForward execute (ActionMapping map, ActionForm form,  HttpServletRequest request , HttpServletResponse 
				response ) throws Exception{
			System.out.println(" In Prf Print Form Jaja");
				//Connection connection = null;
			ServletOutputStream servletOutputStream = response.getOutputStream();
			System.out.println("  1" +getServlet().getServletConfig().getServletContext());
			InputStream reportStream = getServlet().getServletConfig().getServletContext().getResourceAsStream("/jasper/prf.jasper");
			
			System.out.println("Report Stream + "+reportStream);
			response.setContentType("application/pdf");
			//Class.forName("com.mysql.jdbc.Driver");
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/mydo?user=user&password=pass");
			JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, new HashMap());
			//connection.close(); // I need to pass the Correct value 
			servletOutputStream.flush();
			servletOutputStream.close();
			return map.getInputForward();
			//return map.findForward("");
			
			/* JasperReport jasperReport = null;
	            JasperDesign jasperDesign = null;
	            Map parameters = new HashMap();
	           // String path = getServletContext().getRealPath("/WEB-INF/");
	           // InputStream reportStream = getServlet().getServletConfig().getServletContext().getResourceAsStream("/jasper/prf.jasper");
	            jasperDesign = JRXmlLoader.load("/Myelclass/jasper/prf.jrxml");
	            jasperReport = JasperCompileManager.compileReport(jasperDesign);
	            byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, null);                            
	            OutputStream outStream = response.getOutputStream();
	            response.setHeader("Content-Disposition","inline, filename=prf.pdf");
	            response.setContentType("application/pdf");
	            response.setContentLength(byteStream.length);
	            outStream.write(byteStream,0,byteStream.length);    
	            return map.getInputForward();*/
			
			
			
			/*JasperReport report = JasperCompileManager.compileReport(load.getResourceAsStream("yourpackage/report.jrxml"));
			JasperPrint print = JasperFillManager.fillReport(report, new Map<String, Object>(), java.sql.Connection);      
			JasperExportManager.exportReportToPdfStream(print, outStream); */
		}		
}
