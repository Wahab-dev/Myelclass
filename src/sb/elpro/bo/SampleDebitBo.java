/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.bo;

import java.util.List;

import sb.elpro.model.InvBillDetails;

/**
 * @author Wahab
 *
 */
public interface SampleDebitBo {

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	List<InvBillDetails> getSamDebitDetails()throws Exception;

	/**  
	 * (Method description)
	 * @param
	 * @return
	 * etc
	 */
	boolean addSamDebStatus(InvBillDetails sampledeb)throws Exception;


}
