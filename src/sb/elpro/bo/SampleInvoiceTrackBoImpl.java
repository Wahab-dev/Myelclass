/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.SampleInvTrackDaoImpl;
import sb.elpro.dao.SampleInvoiceTrackDao;
import sb.elpro.model.InvBillDetails;

/**
 * @author Wahab
 *
 */
public class SampleInvoiceTrackBoImpl implements SampleInvoiceTrackBo {

	private SampleInvoiceTrackDao saminvtrackdao;
	/*
	 * 
	 * 
	 */
	public SampleInvoiceTrackBoImpl(){
		this.saminvtrackdao = new SampleInvTrackDaoImpl();
	}
	/* (non-Javadoc)
	 * @see sb.elpro.bo.SampleInvoiceTrackBo#getSamInvTrackDetails()
	 */
	@Override
	public List<InvBillDetails> getSamInvTrackDetails() throws Exception {
		ArrayList<InvBillDetails> saminvtrackarr = saminvtrackdao.getSamInvTrackList();
		return saminvtrackarr;
	}
	
	
}
