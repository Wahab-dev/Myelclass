/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.InvoiceDao;
import sb.elpro.dao.InvoiceDaoImpl;
import sb.elpro.dao.InvoiceTrackDao;
import sb.elpro.dao.InvoiceTrackDaoImpl;
import sb.elpro.model.ExporterDetails;
import sb.elpro.model.InvBillDetails;
import sb.elpro.model.Invpaymentdetails;

/**
 * @author Wahab
 *
 */
public class InvoiceTrackBoImpl implements InvoiceTrackBo {
	 private InvoiceTrackDao invtrackdao;
	 
	 
	 public InvoiceTrackBoImpl() {
			this.invtrackdao = new InvoiceTrackDaoImpl();
		}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.InvoiceTrackBo#getInvTrackDetails()
	 */
	@Override
	public List<InvBillDetails> getInvTrackDetails() throws Exception {
		ArrayList<InvBillDetails> invtrackarr = invtrackdao.getInvTrackList();
		return invtrackarr;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.InvoiceTrackBo#addPayment(sb.elpro.model.Invpaymentdetails)
	 */
	@Override
	public boolean addPayment(Invpaymentdetails invpay) throws Exception {
		boolean isdPayadded = invtrackdao.addPayment(invpay);
		return isdPayadded;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.InvoiceTrackBo#editPayment(sb.elpro.model.Invpaymentdetails)
	 */
	@Override
	public boolean editPayment(Invpaymentdetails invpay) throws Exception {
		boolean isPayupdate = invtrackdao.editPayment(invpay);
		return isPayupdate;
	}
	 
	 
	 
}
