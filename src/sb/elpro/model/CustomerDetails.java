/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class CustomerDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5662437199287662259L;
	
	
	private String customerId;
	private String customerName;
	private String customerAddress;
	private String customerTelephone;
	private String customerFax;
	private String customerAttention;
	private String customerShortForm;
	private String agentId;
	private String customertype;
	private String label;
	private String value;
	
	
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
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}
	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	/**
	 * @return the customerTelephone
	 */
	public String getCustomerTelephone() {
		return customerTelephone;
	}
	/**
	 * @param customerTelephone the customerTelephone to set
	 */
	public void setCustomerTelephone(String customerTelephone) {
		this.customerTelephone = customerTelephone;
	}
	/**
	 * @return the customerFax
	 */
	public String getCustomerFax() {
		return customerFax;
	}
	/**
	 * @param customerFax the customerFax to set
	 */
	public void setCustomerFax(String customerFax) {
		this.customerFax = customerFax;
	}
	/**
	 * @return the customerAttention
	 */
	public String getCustomerAttention() {
		return customerAttention;
	}
	/**
	 * @param customerAttention the customerAttention to set
	 */
	public void setCustomerAttention(String customerAttention) {
		this.customerAttention = customerAttention;
	}
	/**
	 * @return the customerShortForm
	 */
	public String getCustomerShortForm() {
		return customerShortForm;
	}
	/**
	 * @param customerShortForm the customerShortForm to set
	 */
	public void setCustomerShortForm(String customerShortForm) {
		this.customerShortForm = customerShortForm;
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
	 * @return the customertype
	 */
	public String getCustomertype() {
		return customertype;
	}
	/**
	 * @param customertype the customertype to set
	 */
	public void setCustomertype(String customertype) {
		this.customertype = customertype;
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
