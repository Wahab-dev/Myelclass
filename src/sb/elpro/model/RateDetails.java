/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class RateDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1730779676717210467L;
	
	private String rateid;
	private String rate;
	private String currencytype;
	private String denomination;
	/**
	 * @return the rateid
	 */
	public String getRateid() {
		return rateid;
	}
	/**
	 * @param rateid the rateid to set
	 */
	public void setRateid(String rateid) {
		this.rateid = rateid;
	}
	/**
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	/**
	 * @return the currencytype
	 */
	public String getCurrencytype() {
		return currencytype;
	}
	/**
	 * @param currencytype the currencytype to set
	 */
	public void setCurrencytype(String currencytype) {
		this.currencytype = currencytype;
	}
	/**
	 * @return the denomination
	 */
	public String getDenomination() {
		return denomination;
	}
	/**
	 * @param denomination the denomination to set
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	

}
