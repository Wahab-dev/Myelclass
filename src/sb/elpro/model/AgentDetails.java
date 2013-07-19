/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class AgentDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8835539042950820374L;

	private String agentId;
	private String agentname;
	private String contractNo;
	private String localAgent;
	private String overseasAgent;
	private String customerId;
	private String agentDetails;
	
	
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
	 * @return the agentName
	 */
	public String getAgentname() {
		return agentname;
	}
	/**
	 * @param agentName the agentName to set
	 */
	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}
	/**
	 * @return the contractNo
	 */
	public String getContractNo() {
		return contractNo;
	}
	/**
	 * @param contractNo the contractNo to set
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	/**
	 * @return the localAgent
	 */
	public String getLocalAgent() {
		return localAgent;
	}
	/**
	 * @param localAgent the localAgent to set
	 */
	public void setLocalAgent(String localAgent) {
		this.localAgent = localAgent;
	}
	/**
	 * @return the overseasAgent
	 */
	public String getOverseasAgent() {
		return overseasAgent;
	}
	/**
	 * @param overseasAgent the overseasAgent to set
	 */
	public void setOverseasAgent(String overseasAgent) {
		this.overseasAgent = overseasAgent;
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
	 * @return the agentDetails
	 */
	public String getAgentDetails() {
		return agentDetails;
	}
	/**
	 * @param agentDetails the agentDetails to set
	 */
	public void setAgentDetails(String agentDetails) {
		this.agentDetails = agentDetails;
	}
	
	
		
	
	
	
	
}
