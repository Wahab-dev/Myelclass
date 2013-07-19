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
	
	private String termId;
	private String termName;
	
	/**
	 * @return the termId
	 */
	public String getTermId() {
		return termId;
	}
	/**
	 * @param termId the termId to set
	 */
	public void setTermId(String termId) {
		this.termId = termId;
	}
	/**
	 * @return the termName
	 */
	public String getTermName() {
		return termName;
	}
	/**
	 * @param termName the termName to set
	 */
	public void setTermName(String termName) {
		this.termName = termName;
	}
	
}
