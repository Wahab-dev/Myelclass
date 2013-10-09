/**
 * 
 */
package sb.elpro.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.InspectionDao;
import sb.elpro.dao.InspectionDaoImpl;
import sb.elpro.model.InspectionGrading;
import sb.elpro.model.InspectionLoadBean;
import sb.elpro.model.InspectionManualTest;
import sb.elpro.model.InspectionRejects;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.QualityCtrlrDetails;
import sb.elpro.model.SampleTrack;

/**
 * @author Wahab
 *
 */
public class InspectionboImpl implements Inspectionbo {
	private InspectionDao inspdao;
	InspectionLoadBean insploadbean = new InspectionLoadBean();
	
	
	public InspectionboImpl(){
		this.inspdao = new InspectionDaoImpl(); 			
	}
	
	
	@Override
	public List<ProductDetails> getInspCtDetails(String inspctterm) throws Exception {
		ArrayList<ProductDetails> InspCtList = inspdao.getInspCtList(inspctterm);
		return InspCtList;
	}


	@Override
	public List<QualityCtrlrDetails> getInspQltyCtlr(String qcterm) throws Exception {
		ArrayList<QualityCtrlrDetails> InspqcList = inspdao.getInspQctrlrList(qcterm);
		return InspqcList;
	}


	@Override
	public List<ProductDetails> getInspArtDetails(String ctno) throws Exception {
		ArrayList<ProductDetails> InspArtList = inspdao.getInspArtList(ctno);
		return InspArtList;
	}


	@Override
	public List<InspectionManualTest> getInspectionTestDetails(String sidx, String sord)
			throws Exception {
		ArrayList<InspectionManualTest> InspTestList = inspdao.getInspTestList(sidx,sord);
		return InspTestList;
	}


	@Override
	public boolean getInspectionTestAddDetails(InspectionManualTest insptest,
			String sidx, String sord) throws Exception {
		boolean InspTestAddList = inspdao.getInspTestAddList(insptest, sidx,sord);
		return InspTestAddList;
	}


	@Override
	public boolean getInspectionTesEditDetails(InspectionManualTest insptest,
			String sidx, String sord) throws Exception {
		boolean InspTestEditList = inspdao.getInspTestEditList(insptest, sidx,sord);
		return InspTestEditList;
	}


	@Override
	public boolean getInspectionTesDelDetails(InspectionManualTest insptest,
			String sidx, String sord) throws Exception {
		boolean InspTestDelList = inspdao.getInspTestDelList(insptest, sidx,sord);
		return InspTestDelList;
	}


	@Override
	public List<InspectionGrading> getInspectionGradeDetails(String sidx,
			String sord) throws Exception {
		ArrayList<InspectionGrading> InspGradeList = inspdao.getInspGradeList(sidx,sord);
		return InspGradeList;
	}


	@Override
	public boolean getInspectionGradeAddDetails(InspectionGrading inspgrad,
			String sidx, String sord) throws Exception {
		boolean InspGradeAddList = inspdao.getInspGradeAddList(inspgrad, sidx,sord);
		return InspGradeAddList;
	}


	@Override
	public boolean getInspectionGradEditDetails(InspectionGrading inspgrad,
			String sidx, String sord) throws Exception {
		boolean InspGradeEditList = inspdao.getInspGradeEditList(inspgrad, sidx,sord);
		return InspGradeEditList;
	}


	@Override
	public boolean getInspectionGradeDelDetails(InspectionGrading inspgrad,
			String sidx, String sord) throws Exception {
		boolean InspGradeDelList = inspdao.getInspGradeDelList(inspgrad, sidx,sord);
		return InspGradeDelList;
	}


	@Override
	public List<InspectionRejects> getInspectionRejDetails(String sidx,
			String sord) throws Exception {
		ArrayList<InspectionRejects> InspRejList = inspdao.getInspRejList(sidx,sord);
		return InspRejList;
	}


	@Override
	public boolean getInspectionRejAddDetails(InspectionRejects insprej,
			String sidx, String sord) throws SQLException {
		boolean InspRejAddList = inspdao.getInspRejAddList(insprej, sidx,sord);
		return InspRejAddList;
	}


	@Override
	public boolean getInspectionRejEditDetails(InspectionRejects insprej,
			String sidx, String sord) throws Exception {
		boolean InspRejEditList = inspdao.getInspRejEditList(insprej, sidx,sord);
		return InspRejEditList;
	}


	@Override
	public boolean getInspectionGradeRejDetails(InspectionRejects insprej,
			String sidx, String sord) throws SQLException {
		boolean InspRejDelList = inspdao.getInspRejDelList(insprej, sidx,sord);
		return InspRejDelList;
	}


	
	
}
