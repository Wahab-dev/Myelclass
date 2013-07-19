/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class TcDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2146413936243139293L;
	
	private String tcid;
	private String tcdetails;
	private String tcamount;
	private String tcagent;
	private String tcvalue;
	private String tccommnets;
	/**
	 * @return the tcid
	 */
	public String getTcid() {
		return tcid;
	}
	/**
	 * @param tcid the tcid to set
	 */
	public void setTcid(String tcid) {
		this.tcid = tcid;
	}
	/**
	 * @return the tcdetails
	 */
	public String getTcdetails() {
		return tcdetails;
	}
	/**
	 * @param tcdetails the tcdetails to set
	 */
	public void setTcdetails(String tcdetails) {
		this.tcdetails = tcdetails;
	}
	/**
	 * @return the tcamount
	 */
	public String getTcamount() {
		return tcamount;
	}
	/**
	 * @param tcamount the tcamount to set
	 */
	public void setTcamount(String tcamount) {
		this.tcamount = tcamount;
	}
	/**
	 * @return the tcagent
	 */
	public String getTcagent() {
		return tcagent;
	}
	/**
	 * @param tcagent the tcagent to set
	 */
	public void setTcagent(String tcagent) {
		this.tcagent = tcagent;
	}
	/**
	 * @return the tcvalue
	 */
	public String getTcvalue() {
		return tcvalue;
	}
	/**
	 * @param tcvalue the tcvalue to set
	 */
	public void setTcvalue(String tcvalue) {
		this.tcvalue = tcvalue;
	}
	/**
	 * @return the tccommnets
	 */
	public String getTccommnets() {
		return tccommnets;
	}
	/**
	 * @param tccommnets the tccommnets to set
	 */
	public void setTccommnets(String tccommnets) {
		this.tccommnets = tccommnets;
	}
	

}
