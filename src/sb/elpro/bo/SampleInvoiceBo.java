/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.ArticleDetails;
import sb.elpro.model.CustomerInvoice;
import sb.elpro.model.InvBillDetails;
import sb.elpro.model.SampleInvoiceBean;
import sb.elpro.model.SampleRequest;

/**
 * @author Wahab
 *
 */
public interface SampleInvoiceBo {

	
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<CustomerInvoice> getSamInvCustsampleDetails(String custname, String type, String sidx, String sord) throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<ArticleDetails> getInvSelSampleDetails(String samno, String type)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean getSampleInvAddBillDetails(InvBillDetails saminvbill)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<InvBillDetails> getSamInvBillDetails(String invno, String samno,
			String type)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<InvBillDetails> getSamInvBillTotAmt(String invno)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean getSamInvBillAddDetails(InvBillDetails saminvaddagainbill)throws Exception;
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean getSamInvBillEditDetails(InvBillDetails saminvaddagainbill)throws Exception;
	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean getSamInvBillDelDetails(InvBillDetails saminvaddagainbill)throws Exception;

	/**  
	 * Save the Sample Invoice Form 
	 * @param
	 * @return
	 * etc
	 */
	boolean saveSampleInvoiceform(SampleInvoiceBean sampinvbean)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<SampleInvoiceBean> getEditSamInvFormValues(String saminvno)throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean updtSampleInvoiceform(SampleInvoiceBean sampinvbean)throws Exception;

	

}
