/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.ArrayList;
import java.util.List;

import sb.elpro.dao.PaymentDao;
import sb.elpro.dao.PaymentDaoImpl;
import sb.elpro.model.DebitFormDetails;
import sb.elpro.model.InvBillDetails;
import sb.elpro.model.PaymentBean;

/**
 * @author Wahab
 *
 */
public class PaymentBoImpl implements PaymentBo {
	private PaymentDao paymentdao;
	 
	 
	public PaymentBoImpl() {
		this.paymentdao = new PaymentDaoImpl();
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.PaymentBo#getPaymentDebDetails(java.lang.String)
	 */
	@Override
	public List<DebitFormDetails> getPaymentDebDetails(String expo)
			throws Exception {
		ArrayList<DebitFormDetails> getpaydetails = paymentdao.getPaymentPendingList(expo);
		return getpaydetails;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.PaymentBo#savePaymentform(sb.elpro.model.PaymentBean)
	 */
	@Override
	public boolean savePaymentform(PaymentBean paymntformbean) throws Exception {
		boolean issavePayForm = paymentdao.savePaymentFormDetails(paymntformbean);
		return issavePayForm;
	}


	/* (non-Javadoc)
	 * @see sb.elpro.bo.PaymentBo#getPayTrackDetails()
	 */
	@Override
	public List<PaymentBean> getPayTrackDetails() throws Exception {
		ArrayList<PaymentBean> getpaytrackdetails = paymentdao.getPaymentTrackList();
		return getpaytrackdetails;
	}
}
