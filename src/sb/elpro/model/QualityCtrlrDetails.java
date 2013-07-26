	/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class QualityCtrlrDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8855353738117696075L;

	private String label;;
	private String qc_Id;
	private String qc_Name;
	private String qc_Type; //Agent , Cust , IC, CI
	//private String qc_;
	
	
	/**
	 * @return the qc_Id
	 */
	public String getQc_Id() {
		return qc_Id;
	}
	/**
	 * @param qc_Id the qc_Id to set
	 */
	public void setQc_Id(String qc_Id) {
		this.qc_Id = qc_Id;
	}
	/**
	 * @return the qc_Name
	 */
	public String getQc_Name() {
		return qc_Name;
	}
	/**
	 * @param qc_Name the qc_Name to set
	 */
	public void setQc_Name(String qc_Name) {
		this.qc_Name = qc_Name;
	}
	/**
	 * @return the qc_Type
	 */
	public String getQc_Type() {
		return qc_Type;
	}
	/**
	 * @param qc_Type the qc_Type to set
	 */
	public void setQc_Type(String qc_Type) {
		this.qc_Type = qc_Type;
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
