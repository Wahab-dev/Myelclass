/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class ConsigneeDetails implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5491819157840688553L;
	
	private String consigneeId;
	private String consigneeName;
	private String consigneeAttention;
	private String consigneeAddress;
	private String consigneeContactNo;
	private String consigneefax;
	private String consigneeType; //Holds type as Customer, Forward agent, Actual Agent, 
	private String consigneeShortForm;
	private String consigneeDetails;
	private String agentId;
	private String customerId;
	private String value;
	private String label;
	
	
	/**
	 * @return the consigneeId
	 */
	public String getConsigneeId() {
		return consigneeId;
	}
	/**
	 * @param consigneeId the consigneeId to set
	 */
	public void setConsigneeId(String consigneeId) {
		this.consigneeId = consigneeId;
	}
	/**
	 * @return the consigneeName
	 */
	public String getConsigneeName() {
		return consigneeName;
	}
	/**
	 * @param consigneeName the consigneeName to set
	 */
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	/**
	 * @return the consigneeAttention
	 */
	public String getConsigneeAttention() {
		return consigneeAttention;
	}
	/**
	 * @param consigneeAttention the consigneeAttention to set
	 */
	public void setConsigneeAttention(String consigneeAttention) {
		this.consigneeAttention = consigneeAttention;
	}
	/**
	 * @return the consigneeAddress
	 */
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	/**
	 * @param consigneeAddress the consigneeAddress to set
	 */
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	/**
	 * @return the consigneeContactNo
	 */
	public String getConsigneeContactNo() {
		return consigneeContactNo;
	}
	/**
	 * @param consigneeContactNo the consigneeContactNo to set
	 */
	public void setConsigneeContactNo(String consigneeContactNo) {
		this.consigneeContactNo = consigneeContactNo;
	}
	/**
	 * @return the consigneefax
	 */
	public String getConsigneefax() {
		return consigneefax;
	}
	/**
	 * @param consigneefax the consigneefax to set
	 */
	public void setConsigneefax(String consigneefax) {
		this.consigneefax = consigneefax;
	}
	/**
	 * @return the consigneeType
	 */
	public String getConsigneeType() {
		return consigneeType;
	}
	/**
	 * @param consigneeType the consigneeType to set
	 */
	public void setConsigneeType(String consigneeType) {
		this.consigneeType = consigneeType;
	}
	/**
	 * @return the consigneeShortForm
	 */
	public String getConsigneeShortForm() {
		return consigneeShortForm;
	}
	/**
	 * @param consigneeShortForm the consigneeShortForm to set
	 */
	public void setConsigneeShortForm(String consigneeShortForm) {
		this.consigneeShortForm = consigneeShortForm;
	}
	/**
	 * @return the consigneeDetails
	 */
	public String getConsigneeDetails() {
		return consigneeDetails;
	}
	/**
	 * @param consigneeDetails the consigneeDetails to set
	 */
	public void setConsigneeDetails(String consigneeDetails) {
		this.consigneeDetails = consigneeDetails;
	}
	/**
	 * @return the agentId
	 */
	public String getAgentId() {
		return agentId;
	}
	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	
	

}
