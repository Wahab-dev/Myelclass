/**
 * 
 */
package sb.elpro.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.InspectionDao;
import sb.elpro.dao.InspectionDaoImpl;
import sb.elpro.model.InspectionBean;
import sb.elpro.model.InspectionGrade;
import sb.elpro.model.ManualTest;
import sb.elpro.model.ProductDetails;
import sb.elpro.model.QualityCtrlrDetails;

/**
 * @author Wahab
 *
 */
public class InspectionBoImpl implements InspectionBo {
	private InspectionDao inspdao;
	InspectionBean insploadbean = new InspectionBean();
	
	
	public InspectionBoImpl(){
		this.inspdao = new InspectionDaoImpl(); 			
	}
	
	
	@Override
	public List<ProductDetails> getInspCtDetails(String inspctterm, String type) throws Exception {
		ArrayList<ProductDetails> InspCtList = inspdao.getInspCtList(inspctterm, type);
		return InspCtList;
	}


	@Override
	public List<QualityCtrlrDetails> getInspQltyCtlr(String qcterm) throws Exception {
		ArrayList<QualityCtrlrDetails> InspqcList = inspdao.getInspQctrlrList(qcterm);
		return InspqcList;
	}


	@Override
	public List<ProductDetails> getInspArtDetails(String ctno, String type) throws Exception {
		ArrayList<ProductDetails> InspArtList = inspdao.getInspArtList(ctno,type);
		return InspArtList;
	}


	@Override
	public List<ManualTest> getInspectionTestDetails(String sidx, String sord, String artid)
			throws Exception {
		ArrayList<ManualTest> InspTestList = inspdao.getInspTestList(sidx,sord,artid);
		return InspTestList;
	}


	@Override
	public boolean getInspectionTestAddDetails(ManualTest insptest,
			String sidx, String sord) throws Exception {
		boolean InspTestAddList = inspdao.getInspTestAddList(insptest, sidx,sord);
		return InspTestAddList;
	}


	@Override
	public boolean getInspectionTesEditDetails(ManualTest insptest,
			String sidx, String sord) throws Exception {
		boolean InspTestEditList = inspdao.getInspTestEditList(insptest, sidx,sord);
		return InspTestEditList;
	}


	@Override
	public boolean getInspectionTesDelDetails(ManualTest insptest,
			String sidx, String sord) throws Exception {
		boolean InspTestDelList = inspdao.getInspTestDelList(insptest, sidx,sord);
		return InspTestDelList;
	}


	@Override
	public List<InspectionGrade> getInspectionGradeDetails(String sidx,
			String sord, String artid ) throws Exception {
		ArrayList<InspectionGrade> InspGradeList = inspdao.getInspGradeList(sidx, sord, artid);
		return InspGradeList;
	}


	@Override
	public boolean getInspectionGradeAddDetails(InspectionGrade inspgrad,
			String sidx, String sord) throws Exception {
		boolean InspGradeAddList = inspdao.getInspGradeAddList(inspgrad, sidx,sord);
		return InspGradeAddList;
	}


	@Override
	public boolean getInspectionGradEditDetails(InspectionGrade inspgrad,
			String sidx, String sord) throws Exception {
		boolean InspGradeEditList = inspdao.getInspGradeEditList(inspgrad, sidx,sord);
		return InspGradeEditList;
	}


	@Override
	public boolean getInspectionGradeDelDetails(InspectionGrade inspgrad,
			String sidx, String sord) throws Exception {
		boolean InspGradeDelList = inspdao.getInspGradeDelList(inspgrad, sidx,sord);
		return InspGradeDelList;
	}


	@Override
	public List<InspectionBean> getInspectionRejDetails(String sidx,
			String sord, String artid) throws Exception {
		ArrayList<InspectionBean> InspRejList = inspdao.getInspRejList(sidx,sord, artid);
		return InspRejList;
	}


	@Override
	public boolean getInspectionRejAddDetails(InspectionBean insprej,
			String sidx, String sord) throws SQLException {
		boolean InspRejAddList = inspdao.getInspRejAddList(insprej, sidx,sord);
		return InspRejAddList;
	}


	@Override
	public boolean getInspectionRejEditDetails(InspectionBean insprej,
			String sidx, String sord) throws Exception {
		boolean InspRejEditList = inspdao.getInspRejEditList(insprej, sidx,sord);
		return InspRejEditList;
	}


	@Override
	public boolean getInspectionGradeRejDetails(InspectionBean insprej,
			String sidx, String sord) throws SQLException {
		boolean InspRejDelList = inspdao.getInspRejDelList(insprej, sidx,sord);
		return InspRejDelList;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.InspectionBo#saveInspectionform(sb.elpro.model.InspectionBean)
	 */
	@Override
	public boolean saveInspectionform(InspectionBean inspbean) throws Exception {
		boolean isSaveInspection =  inspdao.saveInspectionForm(inspbean);
		return isSaveInspection;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.InspectionBo#getInspid()
	 */
	@Override
	public int getInspid() throws Exception {
		int inspid =  inspdao.getInspid();
		return inspid;
	}


	
	
	
}
