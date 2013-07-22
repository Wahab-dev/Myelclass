/**
 * 
 */
package sb.elpro.model;

/**
 * @author Wahab	
 *
 */
public class EndUsageDetails {
	
	private String srf_endusageid;
	private String srf_endusage;
	private String label;
	private String srf_endusagetype;
	/**
	 * @return the srf_endusage
	 */
	public String getSrf_endusage() {
		return srf_endusage;
	}
	/**
	 * @param srf_endusage the srf_endusage to set
	 */
	public void setSrf_endusage(String srf_endusage) {
		this.srf_endusage = srf_endusage;
	}
	
	/**
	 * @return the srf_endusageid
	 */
	public String getSrf_endusageid() {
		return srf_endusageid;
	}
	/**
	 * @param srf_endusageid the srf_endusageid to set
	 */
	public void setSrf_endusageid(String srf_endusageid) {
		this.srf_endusageid = srf_endusageid;
	}
	
	public String getSrf_endusagetype() {
		return srf_endusagetype;
	}
	/**
	 * @param srf_endusagetype the srf_endusagetype to set
	 */
	public void setSrf_endusagetype(String srf_endusagetype) {
		this.srf_endusagetype = srf_endusagetype;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
}
