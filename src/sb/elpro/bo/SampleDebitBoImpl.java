/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.BulkDao;
import sb.elpro.dao.BulkDaoImpl;
import sb.elpro.dao.SampleDebitDao;
import sb.elpro.dao.SampleDebitDaoImpl;
import sb.elpro.model.BulkArticle;
import sb.elpro.model.InvBillDetails;

/**
 * @author Wahab
 *
 */
public class SampleDebitBoImpl implements SampleDebitBo {
	 private SampleDebitDao samdebdao;

	 /**
	  *
	  */
		public SampleDebitBoImpl() {
			this.samdebdao = new SampleDebitDaoImpl();
		}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.SampleDebitBo#getSamDebitDetails()
	 */
	@Override
	public List<InvBillDetails> getSamDebitDetails() throws Exception {
		ArrayList<InvBillDetails> sampledebList = samdebdao.getSampleDebList();
		return sampledebList;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.bo.SampleDebitBo#addSamDebStatus(sb.elpro.model.InvBillDetails)
	 */
	@Override
	public boolean addSamDebStatus(InvBillDetails sampledeb) throws Exception {
		boolean isdebstatusupdate = samdebdao.updatSamDebStatus(sampledeb);
		return isdebstatusupdate;
	}
}
