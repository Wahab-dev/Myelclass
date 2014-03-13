/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.SampleInvoiceDao;
import sb.elpro.dao.SampleInvoiceDaoImpl;
import sb.elpro.model.ArticleDetails;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.InvBillDetails;


/**
 * @author Wahab
 *
 */
public class SampleInvoiceBoImpl implements SampleInvoiceBo {
	private SampleInvoiceDao sampleinvdao;
	public SampleInvoiceBoImpl() {
		this.sampleinvdao = new SampleInvoiceDaoImpl();
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.SampleInvoiceBo#getSamInvCustCtDetails(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<CustomerInvoice> getSamInvCustsampleDetails(String custname,
			String type, String sidx, String sord) throws Exception {
		ArrayList<CustomerInvoice> saminvCustomerarr = sampleinvdao.getSamInvCustsampleDet(custname, type, sidx, sord);
		return saminvCustomerarr;
	}
	
	/* (non-Javadoc)
	 * @see sb.elpro.bo.SampleInvoiceBo#getInvSelSampleDetails(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ArticleDetails> getInvSelSampleDetails(String samno, String type)
			throws Exception {
		ArrayList<ArticleDetails> invSelSamarr = sampleinvdao.getInvSelSampleDetails(samno,type);
		return invSelSamarr;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.SampleInvoiceBo#getSampleInvAddBillDetails(sb.elpro.model.InvBillDetails)
	 */
	@Override
	public boolean getSampleInvAddBillDetails(InvBillDetails saminvbill)
			throws Exception {
		boolean saminvaddbillarr = sampleinvdao.getSamInvAddbillDetails(saminvbill);
		return saminvaddbillarr;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.SampleInvoiceBo#getSamInvBillDetails(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<InvBillDetails> getSamInvBillDetails(String invno,
			String samno, String type) throws Exception {
		ArrayList<InvBillDetails> saminvBillarr = sampleinvdao.getSamInvBillDetails(invno,samno,type);
		return saminvBillarr;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.SampleInvoiceBo#getSamInvBillTotAmt(java.lang.String)
	 */
	@Override
	public List<InvBillDetails> getSamInvBillTotAmt(String invno)
			throws Exception {
		ArrayList<InvBillDetails> saminvamtdetails = sampleinvdao.getSamInvBillTotAmtDetails(invno);
		return saminvamtdetails;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.SampleInvoiceBo#getSamInvBillAddDetails(sb.elpro.model.InvBillDetails)
	 */
	@Override
	public boolean getSamInvBillAddDetails(InvBillDetails saminvaddagainbill)
			throws Exception {
		boolean saminvaddagainbillarr = sampleinvdao.getSamInvAddbillSecondDetails(saminvaddagainbill);
		return saminvaddagainbillarr;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.SampleInvoiceBo#getSamInvBillEditDetails(sb.elpro.model.InvBillDetails)
	 */
	@Override
	public boolean getSamInvBillEditDetails(InvBillDetails saminveditbill)
			throws Exception {
		boolean saminveditbillarr = sampleinvdao.getSamInvEditbillDetails(saminveditbill);
		return saminveditbillarr;
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.SampleInvoiceBo#getSamInvBillDelDetails(sb.elpro.model.InvBillDetails)
	 */
	@Override
	public boolean getSamInvBillDelDetails(InvBillDetails saminvdelabill)
			throws Exception {
		boolean saminvdelbill = sampleinvdao.getSamInvDelbillDetails(saminvdelabill);
		return saminvdelbill;
	}
	
}
