/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class TermsDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7386377503075669653L;
	
	private String termid;
	private String termname;
	private String otherdetails;
	/**
	 * @return the termid
	 */
	public String getTermid() {
		return termid;
	}
	/**
	 * @param termid the termid to set
	 */
	public void setTermid(String termid) {
		this.termid = termid;
	}
	/**
	 * @return the termname
	 */
	public String getTermname() {
		return termname;
	}
	/**
	 * @param termname the termname to set
	 */
	public void setTermname(String termname) {
		this.termname = termname;
	}
	/**
	 * @return the otherdetails
	 */
	public String getOtherdetails() {
		return otherdetails;
	}
	/**
	 * @param otherdetails the otherdetails to set
	 */
	public void setOtherdetails(String otherdetails) {
		this.otherdetails = otherdetails;
	}
	
	
	
}
