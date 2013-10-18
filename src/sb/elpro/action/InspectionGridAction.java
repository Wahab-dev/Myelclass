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

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.Inspectionbo;
import sb.elpro.bo.InspectionboImpl;
import sb.elpro.model.InspectionBean;
import sb.elpro.model.ProductDetails;

/**
 * @author Wahab
 *
 */
public class InspectionGridAction extends Action{
	HttpSession usersession;
	Inspectionbo inspbo  =  new InspectionboImpl();
	public ActionForward execute (ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		usersession = request.getSession(false);
		PrintWriter out = response.getWriter();
		JSONObject jsonobj = new JSONObject();
		response.setContentType("application/json");
		System.out.println("In Sample Track  Action ");
		 if(usersession != null){
			 String oper =   request.getParameter("oper");
			 String rows = request.getParameter("rows");
             String pag = request.getParameter("page");
             String sidx = request.getParameter("sidx");
             String sord = request.getParameter("sord");
             String event = request.getParameter("event");
             
             System.out.println("rows "+rows); 
             System.out.println("page "+pag); 
             System.out.println("sidx "+sidx);
             System.out.println("sord "+sord);
             System.out.println("event "+event);
             if(event.equalsIgnoreCase("manualtest")){
            	 System.out.println("In INsp test ");
		             if(oper == null){
						System.out.println(" In Insp Test Load");
						List<InspectionBean> testload = inspbo.getInspectionTestDetails(sidx,sord);
						int records = testload.size();
						System.out.println("Reords  "+records);
							int page = Integer.parseInt(pag);
			                int totalPages = 0;
			                int totalCount = records;
			                if (totalCount > 0) {
			                	 if (totalCount % Integer.parseInt(rows) == 0) {
			                		 System.out.println("STEP 1 "+totalCount % Integer.parseInt(rows) );
			                         totalPages = totalCount / Integer.parseInt(rows);
			                         System.out.println("STEP 2 "+totalPages);
			                     } else {
			                         totalPages = (totalCount / Integer.parseInt(rows)) + 1;
			                         System.out.println("STEP 3 "+totalPages);
			                     }
			                }else {
			                    totalPages = 0;
			                }
						jsonobj.put("total", totalPages);
						jsonobj.put("page", page);
						jsonobj.put("records", records);
						jsonobj.put("rows", testload);
						System.out.println(jsonobj);		
						out.println(jsonobj);
		             }else {
		            	 InspectionBean insptest = new InspectionBean();
		            	 	insptest.setTestid(request.getParameter("testid"));
		            	 	insptest.setArticleid(request.getParameter("articleid"));
		            	 	insptest.setColortest(request.getParameter("colortest"));
		            	 	insptest.setId(request.getParameter("id"));
		            	 	insptest.setTesttype(request.getParameter("testtype"));
		            	 	insptest.setTestedpcs(request.getParameter("testedpcs"));
		            	 	insptest.setResult(request.getParameter("result"));
		            	 	insptest.setComments(request.getParameter("comments"));
		            	 	
		            		if(oper.equalsIgnoreCase("add")){
		            			System.out.println(" In Article Add");
								boolean isInspTestAdded = inspbo.getInspectionTestAddDetails(insptest,sidx,sord);
								if(isInspTestAdded){
									jsonobj.put("success", "Successfully Inserted The Record");
								}else{
									jsonobj.put("Error", "Error in Inserrting");
								}
								System.out.println(jsonobj);		
								out.println(jsonobj);
		            		}else if(oper.equalsIgnoreCase("edit")){
		            			System.out.println(" In Test Edit");
								boolean isInspTestUpdated = inspbo.getInspectionTesEditDetails(insptest,sidx,sord);
								if(isInspTestUpdated){
									jsonobj.put("success", "Successfully Inserted The Record");
								}else{
									jsonobj.put("Error", "Error in Inserrting");
								}
								System.out.println(jsonobj);		
								out.println(jsonobj);
		            		}else{
		            			System.out.println(" In Test Delet");
								boolean isInspTestDel = inspbo.getInspectionTesDelDetails(insptest,sidx,sord);
								if(isInspTestDel){
									jsonobj.put("success", "Successfully Inserted The Record");
								}else{
									jsonobj.put("Error", "Error in Inserrting");
								}
								System.out.println(jsonobj);		
								out.println(jsonobj);
		            		}
		             }
             	}else if(event.equalsIgnoreCase("grade")){
             		 System.out.println("In INsp GRADING---- ");
		             if(oper == null){
						System.out.println(" In Insp Grade Load");
						List<InspectionBean> gradeload = inspbo.getInspectionGradeDetails(sidx,sord);
						int records = gradeload.size();
						System.out.println("Reords  "+records);
							int page = Integer.parseInt(pag);
			                int totalPages = 0;
			                int totalCount = records;
			                if (totalCount > 0) {
			                	 if (totalCount % Integer.parseInt(rows) == 0) {
			                		 System.out.println("STEP 1 "+totalCount % Integer.parseInt(rows) );
			                         totalPages = totalCount / Integer.parseInt(rows);
			                         System.out.println("STEP 2 "+totalPages);
			                     } else {
			                         totalPages = (totalCount / Integer.parseInt(rows)) + 1;
			                         System.out.println("STEP 3 "+totalPages);
			                     }
			                }else {
			                    totalPages = 0;
			                }
						jsonobj.put("total", totalPages);
						jsonobj.put("page", page);
						jsonobj.put("records", records);
						jsonobj.put("rows", gradeload);
						System.out.println(jsonobj);		
						out.println(jsonobj);
		             }else {
		            	 InspectionBean inspgrad = new InspectionBean();
		            	 	inspgrad.setId(request.getParameter("id"));
		            	 	inspgrad.setGradeid(request.getParameter("gradeid"));
		            	 	inspgrad.setArticleid(request.getParameter("articleid"));
		            	 	inspgrad.setGradecolor(request.getParameter("gradecolor"));
		            	 	inspgrad.setGrade(request.getParameter("grade"));
		            	 	inspgrad.setSkincount(request.getParameter("skincount"));
		            	 	inspgrad.setPercent(request.getParameter("percent"));
		            	 	inspgrad.setComment(request.getParameter("comment"));
		            	 	
		            		if(oper.equalsIgnoreCase("add")){
		            			System.out.println(" In Grading Add");
								boolean isInspGradAdded = inspbo.getInspectionGradeAddDetails(inspgrad,sidx,sord);
								if(isInspGradAdded){
									jsonobj.put("success", "Successfully Inserted The Record");
								}else{
									jsonobj.put("Error", "Error in Inserrting");
								}
								System.out.println(jsonobj);		
								out.println(jsonobj);
		            		}else if(oper.equalsIgnoreCase("edit")){
		            			System.out.println(" In Grade Edit");
								boolean isInspGradUpdated = inspbo.getInspectionGradEditDetails(inspgrad,sidx,sord);
								if(isInspGradUpdated){
									jsonobj.put("success", "Successfully Inserted The Record");
								}else{
									jsonobj.put("Error", "Error in Inserrting");
								}
								System.out.println(jsonobj);		
								out.println(jsonobj);
		            		}else{
		            			System.out.println(" In Grade Delet");
								boolean isInspGradeDel = inspbo.getInspectionGradeDelDetails(inspgrad,sidx,sord);
								if(isInspGradeDel){
									jsonobj.put("success", "Successfully Inserted The Record");
								}else{
									jsonobj.put("Error", "Error in Inserrting");
								}
								System.out.println(jsonobj);		
								out.println(jsonobj);
		            		}
		             }	
             	}else if(event.equalsIgnoreCase("reject")){
             		 System.out.println("In INsp Reject---- ");
		             if(oper == null){
						System.out.println(" In Insp Reject Load");
						List<InspectionBean> rejectload = inspbo.getInspectionRejDetails(sidx,sord);
						int records = rejectload.size();
						System.out.println("Reords  "+records);
							int page = Integer.parseInt(pag);
			                int totalPages = 0;
			                int totalCount = records;
			                if (totalCount > 0) {
			                	 if (totalCount % Integer.parseInt(rows) == 0) {
			                		 System.out.println("STEP 1 "+totalCount % Integer.parseInt(rows) );
			                         totalPages = totalCount / Integer.parseInt(rows);
			                         System.out.println("STEP 2 "+totalPages);
			                     } else {
			                         totalPages = (totalCount / Integer.parseInt(rows)) + 1;
			                         System.out.println("STEP 3 "+totalPages);
			                     }
			                }else {
			                    totalPages = 0;
			                }
						jsonobj.put("total", totalPages);
						jsonobj.put("page", page);
						jsonobj.put("records", records);
						jsonobj.put("rows", rejectload);
						System.out.println(jsonobj);		
						out.println(jsonobj);
		             }else {
		             
		            	 InspectionBean insprej = new InspectionBean();
		            	 	insprej.setId(request.getParameter("id"));
		            	 	insprej.setArticleid(request.getParameter("articleid"));
		            	 	insprej.setArttype(request.getParameter("arttype"));
		            	 	insprej.setRejcolor(request.getParameter("rejcolor"));
		            	 	insprej.setColorrejects(request.getParameter("colorrejects"));
		            	 	insprej.setOrgrejects(request.getParameter("orgrejects"));
		            	 	insprej.setOtherrejects(request.getParameter("otherrejects"));
		            	 	insprej.setRejectid(request.getParameter("rejectid"));
		            	 	insprej.setSelecrejects(request.getParameter("selecrejects"));
		            	 	insprej.setSizerejects(request.getParameter("sizerejects"));
		            	 	insprej.setSubsrejects(request.getParameter("subsrejects"));
		            	 	insprej.setTotinspected(request.getParameter("totinspected"));
		            	 	insprej.setTotpassed(request.getParameter("totpassed"));
		            	 	insprej.setTotrejects(request.getParameter("totrejects"));
		            	 	

		            		if(oper.equalsIgnoreCase("add")){
		            			System.out.println(" In Rejects Add");
								boolean isInspRejAdded = inspbo.getInspectionRejAddDetails(insprej,sidx,sord);
								if(isInspRejAdded){
									jsonobj.put("success", "Successfully Inserted The Record");
								}else{
									jsonobj.put("Error", "Error in Inserrting");
								}
								System.out.println(jsonobj);		
								out.println(jsonobj);
		            		}else if(oper.equalsIgnoreCase("edit")){
		            			System.out.println(" In Reject Edit");
								boolean isInspRejUpdated = inspbo.getInspectionRejEditDetails(insprej,sidx,sord);
								if(isInspRejUpdated){
									jsonobj.put("success", "Successfully Inserted The Record");
								}else{
									jsonobj.put("Error", "Error in Inserrting");
								}
								System.out.println(jsonobj);		
								out.println(jsonobj);
		            		}else{
		            			System.out.println(" In Rej Delet");
								boolean isInspGradeRej = inspbo.getInspectionGradeRejDetails(insprej,sidx,sord);
								if(isInspGradeRej){
									jsonobj.put("success", "Successfully Inserted The Record");
								}else{
									jsonobj.put("Error", "Error in Inserrting");
								}
								System.out.println(jsonobj);		
								out.println(jsonobj);
		            		}
		             }
             	}else if(event.equalsIgnoreCase("loadarticle")){
             		String ctno = request.getParameter("ctno");
             		List<ProductDetails> inspartllist =  inspbo.getInspArtDetails(ctno);
    				int records = inspartllist.size();
    				System.out.println("Reords  "+records);
    				int page = Integer.parseInt(pag);
	                int totalPages = 0;
	                int totalCount = records;
	                if (totalCount > 0) {
	                	 if (totalCount % Integer.parseInt(rows) == 0) {
	                		 System.out.println("STEP 1 "+totalCount % Integer.parseInt(rows) );
	                         totalPages = totalCount / Integer.parseInt(rows);
	                         System.out.println("STEP 2 "+totalPages);
	                     } else {
	                         totalPages = (totalCount / Integer.parseInt(rows)) + 1;
	                         System.out.println("STEP 3 "+totalPages);
	                     }
	                }else {
	                    totalPages = 0;
	                }
				jsonobj.put("total", totalPages);
				jsonobj.put("page", page);
				jsonobj.put("records", records);
				jsonobj.put("rows", inspartllist);
				System.out.println(jsonobj);		
				out.println(jsonobj);
             	}
             
			 }else{
			 System.out.println("Error Invalid Session");
			 return map.findForward("login");
		 }
		 return null;
	}
}
