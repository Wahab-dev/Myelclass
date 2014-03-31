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
	 
	 
	 
}
