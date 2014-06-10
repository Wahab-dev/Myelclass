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

import sb.elpro.bo.InspectionBo;
import sb.elpro.bo.InspectionBoImpl;
import sb.elpro.model.InspectionBean;
import sb.elpro.model.InspectionGrade;
import sb.elpro.model.ManualTest;
import sb.elpro.model.ProductDetails;

/**
 * @author Wahab
 *
 */
public class InspectionGridAction extends Action{
	HttpSession usersession;
	InspectionBo inspbo  =  new InspectionBoImpl();
	public ActionForward execute (ActionMapping map, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		usersession = request.getSession(false);
		PrintWriter out = response.getWriter();
		JSONObject jsonobj = new JSONObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		 if(usersession != null){
			 String oper =   request.getParameter("oper");
			 String rows = request.getParameter("rows");
             String pag = request.getParameter("page");
             String sidx = request.getParameter("sidx");
             String sord = request.getParameter("sord");
             String event = request.getParameter("event");
             String artid = request.getParameter("artid");
             
             System.out.println("rows "+rows); 
             System.out.println("page "+pag); 
             System.out.println("sidx "+sidx);
             System.out.println("sord "+sord);
             System.out.println("event "+event);
             System.out.println("artid "+artid);
             
             if(event.equalsIgnoreCase("manualtest")){
            	
            	 System.out.println("In INsp test ");
		             if(oper == null){
						System.out.println(" In Insp Test Load");
						List<ManualTest> testload = inspbo.getInspectionTestDetails(sidx,sord,artid);
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
		            	ManualTest insptest = new ManualTest();
		            		insptest.setId(request.getParameter("id"));
		            		insptest.setTestid(request.getParameter("testid"));
		            		insptest.setArticleid(request.getParameter("articleid"));
		            		insptest.setTestcolor(request.getParameter("testcolor"));
		            		insptest.setContractno(request.getParameter("")); 
		            		
		            		insptest.setColortest(request.getParameter("colortest"));
		            		insptest.setColortested(request.getParameter("colortested"));
		            		insptest.setColorresult(request.getParameter("colorresult"));
		            		insptest.setColorcomments(request.getParameter("colorcomments"));
		            		insptest.setSubtest(request.getParameter("subtest"));
		            		insptest.setSubtested(request.getParameter("subtested"));
		            		insptest.setSubresult(request.getParameter("subresult"));
		            		insptest.setSubcomments(request.getParameter("subcomments"));
		            		insptest.setTeartest(request.getParameter("teartest"));
		            		insptest.setTeartested(request.getParameter("teartested"));
		            		insptest.setTearresult(request.getParameter("tearresult"));
		            		insptest.setTearcomments(request.getParameter("tearcomments"));
		            		insptest.setGrainbreaktest(request.getParameter("grainbreaktest"));
		            		insptest.setGrainbreaktested(request.getParameter("grainbreaktested"));
		            		insptest.setGrainbreakresult(request.getParameter("grainbreakresult"));
		            		insptest.setGrainbreakcomments(request.getParameter("grainbreakcomments"));
		            		insptest.setCrockingwettest(request.getParameter("crockingwettest"));
		            		insptest.setCrockingwettested(request.getParameter("crockingwettested"));
		            		insptest.setCrockingwetresult(request.getParameter("crockingwetresult"));
		            		insptest.setCrockingwetcomments(request.getParameter("crockingwetcomments"));
		            		insptest.setCrockingdrytest(request.getParameter("crockingdrytest"));
		            		insptest.setCrockingdrytested(request.getParameter("crockingdrytested"));
		            		insptest.setCrockingdryresult(request.getParameter("crockingdryresult"));
		            		insptest.setCrockingdrycomments(request.getParameter("crockingdrycomments"));
		            		insptest.setFinishadhensiontest(request.getParameter("finishadhensiontest"));
		            		insptest.setFinishadhensiontested(request.getParameter("finishadhensiontested"));
		            		insptest.setFinishadhensionresult(request.getParameter("finishadhensionresult"));
		            		insptest.setFinishadhensioncomments(request.getParameter("finishadhensioncomments"));
		            		insptest.setFourfoldstest(request.getParameter("fourfoldstest"));
		            		insptest.setFourfoldstested(request.getParameter("fourfoldstested"));
		            		insptest.setFourfoldsresult(request.getParameter("fourfoldsresult"));
		            		insptest.setFourfoldscomments(request.getParameter("fourfoldscomments"));
		            		insptest.setDyethrutest(request.getParameter("dyethrutest"));
		            		insptest.setDyethrutested(request.getParameter("dyethrutested"));
		            		insptest.setDyethruresult(request.getParameter("dyethruresult"));
		            		insptest.setDyethrucomments(request.getParameter("dyethrucomments"));
		            		insptest.setOrganoleptictest(request.getParameter("organoleptictest"));
		            		insptest.setOrganoleptictested(request.getParameter("organoleptictested"));
		            		insptest.setOrganolepticresult(request.getParameter("organolepticresult"));
		            		insptest.setOrganolepticcomments(request.getParameter("organolepticcomments"));
		            		
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
						List<InspectionGrade> gradeload = inspbo.getInspectionGradeDetails(sidx, sord, artid);
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
		            	 InspectionGrade inspgrad = new InspectionGrade();
		            	 	inspgrad.setId(request.getParameter("id"));
		            	 	inspgrad.setGradeid(request.getParameter("gradeid"));
		            	 	inspgrad.setArtid(request.getParameter("articleid"));
		            	 	inspgrad.setGradecolor(request.getParameter("gradecolor"));
		            		inspgrad.setGrtotinspected(request.getParameter("grtotinspected"));
		            	 	inspgrad.setGrade1(request.getParameter("grade1"));
		            	 	inspgrad.setSkincount1(request.getParameter("skincount1"));
		            	 	inspgrad.setPercent1(request.getParameter("percent1"));
		            	 	inspgrad.setComment1(request.getParameter("comment1"));
		            		inspgrad.setGrade2(request.getParameter("grade2"));
		            	 	inspgrad.setSkincount2(request.getParameter("skincount2"));
		            	 	inspgrad.setPercent2(request.getParameter("percent2"));
		            	 	inspgrad.setComment2(request.getParameter("comment2"));
		            		inspgrad.setGrade3(request.getParameter("grade3"));
		            	 	inspgrad.setSkincount3(request.getParameter("skincount3"));
		            	 	inspgrad.setPercent3(request.getParameter("percent3"));
		            	 	inspgrad.setComment3(request.getParameter("comment3"));
		            		inspgrad.setGrade4(request.getParameter("grade4"));
		            	 	inspgrad.setSkincount4(request.getParameter("skincount4"));
		            	 	inspgrad.setPercent4(request.getParameter("percent4"));
		            	 	inspgrad.setComment4(request.getParameter("comment4"));
		            		inspgrad.setGrade5(request.getParameter("grade5"));
		            	 	inspgrad.setSkincount5(request.getParameter("skincount5"));
		            	 	inspgrad.setPercent5(request.getParameter("percent5"));
		            	 	inspgrad.setComment5(request.getParameter("comment5"));
		            	 	inspgrad.setImprovement(request.getParameter("improvement"));
		            	 	inspgrad.setSkincount6(request.getParameter("skincount6"));
		            	 	inspgrad.setPercent6(request.getParameter("percent6"));
		            	 	inspgrad.setComment6(request.getParameter("comment6"));
		            	
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
						List<InspectionBean> rejectload = inspbo.getInspectionRejDetails(sidx,sord,artid);
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
		            	 	System.out.println("rejectid"+insprej.getRejectid());
		            	 	insprej.setSelecrejects(request.getParameter("selecrejects"));
		            	 	insprej.setSizerejects(request.getParameter("sizerejects"));
		            	 	insprej.setSubsrejects(request.getParameter("subsrejects"));
		            	 	insprej.setRjtotinspected(request.getParameter("rjtotinspected"));
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
             		System.out.println(" Ct No in inspection Form GRID  "+ctno);
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
