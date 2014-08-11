/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 * This class defines the payment recieved by the Tannery after sending Invoice
 * Please note that this doesnt have any conection eith debit note.
 * just to get the information that the tannery recieved payment for shipped invoice  
 */
public class Invpaymentdetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5077856112782080683L;

	private String invno;
	private String invtotamt;
	private String deduction; 
	private String bankcharge; 
	private String amtrecieved; 
	private String balanceamt; 
	private String exchngrate; 
	private String amtininr; 
	private String recieptdate; 
	private String remarks;
	
	
	/**
	 * @return the invno
	 */
	public String getInvno() {
		return invno;
	}
	/**
	 * @param invno the invno to set
	 */
	public void setInvno(String invno) {
		this.invno = invno;
	}
	/**
	 * @return the invtotamt
	 */
	public String getInvtotamt() {
		return invtotamt;
	}
	/**
	 * @param invtotamt the invtotamt to set
	 */
	public void setInvtotamt(String invtotamt) {
		this.invtotamt = invtotamt;
	}
	/**
	 * @return the deduction
	 */
	public String getDeduction() {
		return deduction;
	}
	/**
	 * @param deduction the deduction to set
	 */
	public void setDeduction(String deduction) {
		this.deduction = deduction;
	}
	/**
	 * @return the bankcharge
	 */
	public String getBankcharge() {
		return bankcharge;
	}
	/**
	 * @param bankcharge the bankcharge to set
	 */
	public void setBankcharge(String bankcharge) {
		this.bankcharge = bankcharge;
	}
	/**
	 * @return the amtrecieved
	 */
	public String getAmtrecieved() {
		return amtrecieved;
	}
	/**
	 * @param amtrecieved the amtrecieved to set
	 */
	public void setAmtrecieved(String amtrecieved) {
		this.amtrecieved = amtrecieved;
	}
	/**
	 * @return the balanceamt
	 */
	public String getBalanceamt() {
		return balanceamt;
	}
	/**
	 * @param balanceamt the balanceamt to set
	 */
	public void setBalanceamt(String balanceamt) {
		this.balanceamt = balanceamt;
	}
	/**
	 * @return the exchngrate
	 */
	public String getExchngrate() {
		return exchngrate;
	}
	/**
	 * @param exchngrate the exchngrate to set
	 */
	public void setExchngrate(String exchngrate) {
		this.exchngrate = exchngrate;
	}
	/**
	 * @return the amtininr
	 */
	public String getAmtininr() {
		return amtininr;
	}
	/**
	 * @param amtininr the amtininr to set
	 */
	public void setAmtininr(String amtininr) {
		this.amtininr = amtininr;
	}
	/**
	 * @return the recieptdate
	 */
	public String getRecieptdate() {
		return recieptdate;
	}
	/**
	 * @param recieptdate the recieptdate to set
	 */
	public void setRecieptdate(String recieptdate) {
		this.recieptdate = recieptdate;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	} 
	
}
