/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
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
public class InspectionTrackPrintAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {		
	String type = request.getParameter("type");
	Connection conn = null;
	try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/elpro","root","tiger");
        System.out.println("conn "+conn.getCatalog());
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
	if(type.equalsIgnoreCase("pdf")){
		response.setContentType("application/pdf");
        ServletOutputStream out = response.getOutputStream();
        JasperReport report = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/SampleTrack/InspectionTrack.jrxml");
     
        HashMap<String, Object> params = new HashMap<String, Object>(); 
        params.put("Title", "Sample Track");
       
        	System.out.println("zzzzz"+params.toString());
        	System.out.println("zzzzz"+report.getName());
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
	}else{
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); 
        ServletOutputStream output = response.getOutputStream();

        	JasperReport report = JasperCompileManager.compileReport("C:/Users/meetw_000/Desktop/report/SampleTrack/InspectionTrack.jrxml");
            HashMap<String, Object> params = new HashMap<String, Object>(); 
            params.put("Title", "Sample Track");
        
        	JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, conn);
        	  //Excel Converter
        	
        	JRXlsxExporter excelexporter = new JRXlsxExporter(); // supports jaspersoft 5.5.1 
           // JExcelApiExporter excelexporter = new JExcelApiExporter(); // supports jasper Report version
   		 
    		// Here we assign the parameters jp and baos to the exporter
            excelexporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            excelexporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, output);
    	
            // Excel specific parameters
            excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.FALSE);
            excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            excelexporter.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_GRAPHICS,Boolean.FALSE);
            
    		try {
    			excelexporter.exportReport();
    			
    		} catch (JRException e) {
    			throw new RuntimeException(e);
    		} catch (Exception e) {
            e.printStackTrace();
        }	
	}
		return null;
	}
}
