/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class CustomerInvoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8224099407665140680L;

	private String ctno;
	private String agent;
	private String orderdt;
	private String pono;
	private String exporter;
	private String customer;
	private String tannery;
	private String consignee;
	private String destination;
	private String othercommission;
	private String commission;
	private String cdd_date; 
	private String add_date; 
	
	/*
	 * Actually not Necessary . Combined Ct and Sample as One
	 */
	//Sample
	private String Sampleno;
	private String sorderdt;
	private String refno;
	private String priority;
	private String handledby;
	private String scustomerid;
	private String stanneryid;
	private String deliverid;
	private String sadd_date;
	private String scdd_date;
	private String isinvraised; 

	
	
	/**
	 * @return the sampleno
	 */
	public String getSampleno() {
		return Sampleno;
	}
	/**
	 * @param sampleno the sampleno to set
	 */
	public void setSampleno(String sampleno) {
		Sampleno = sampleno;
	}
	/**
	 * @return the sorderdt
	 */
	public String getSorderdt() {
		return sorderdt;
	}
	/**
	 * @param sorderdt the sorderdt to set
	 */
	public void setSorderdt(String sorderdt) {
		this.sorderdt = sorderdt;
	}
	/**
	 * @return the refno
	 */
	public String getRefno() {
		return refno;
	}
	/**
	 * @param refno the refno to set
	 */
	public void setRefno(String refno) {
		this.refno = refno;
	}
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
	/**
	 * @return the handledby
	 */
	public String getHandledby() {
		return handledby;
	}
	/**
	 * @param handledby the handledby to set
	 */
	public void setHandledby(String handledby) {
		this.handledby = handledby;
	}
	/**
	 * @return the scustomerid
	 */
	public String getScustomerid() {
		return scustomerid;
	}
	/**
	 * @param scustomerid the scustomerid to set
	 */
	public void setScustomerid(String scustomerid) {
		this.scustomerid = scustomerid;
	}
	/**
	 * @return the stanneryid
	 */
	public String getStanneryid() {
		return stanneryid;
	}
	/**
	 * @param stanneryid the stanneryid to set
	 */
	public void setStanneryid(String stanneryid) {
		this.stanneryid = stanneryid;
	}
	/**
	 * @return the deliverid
	 */
	public String getDeliverid() {
		return deliverid;
	}
	/**
	 * @param deliverid the deliverid to set
	 */
	public void setDeliverid(String deliverid) {
		this.deliverid = deliverid;
	}
	/**
	 * @return the sadd_date
	 */
	public String getSadd_date() {
		return sadd_date;
	}
	/**
	 * @param sadd_date the sadd_date to set
	 */
	public void setSadd_date(String sadd_date) {
		this.sadd_date = sadd_date;
	}
	/**
	 * @return the scdd_date
	 */
	public String getScdd_date() {
		return scdd_date;
	}
	/**
	 * @param scdd_date the scdd_date to set
	 */
	public void setScdd_date(String scdd_date) {
		this.scdd_date = scdd_date;
	}
	/**
	 * @return the isinvraised
	 */
	public String getIsinvraised() {
		return isinvraised;
	}
	/**
	 * @param isinvraised the isinvraised to set
	 */
	public void setIsinvraised(String isinvraised) {
		this.isinvraised = isinvraised;
	}
	/**
	 * @return the pono
	 */
	public String getPono() {
		return pono;
	}
	/**
	 * @param pono the pono to set
	 */
	public void setPono(String pono) {
		this.pono = pono;
	}

	/**
	 * @return the cdd_date
	 */
	public String getCdd_date() {
		return cdd_date;
	}
	/**
	 * @param cdd_date the cdd_date to set
	 */
	public void setCdd_date(String cdd_date) {
		this.cdd_date = cdd_date;
	}
	/**
	 * @return the add_date
	 */
	public String getAdd_date() {
		return add_date;
	}
	/**
	 * @param add_date the add_date to set
	 */
	public void setAdd_date(String add_date) {
		this.add_date = add_date;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the commission
	 */
	public String getCommission() {
		return commission;
	}
	/**
	 * @param commission the commission to set
	 */
	public void setCommission(String commission) {
		this.commission = commission;
	}
	/**
	 * @return the orderdt
	 */
	public String getOrderdt() {
		return orderdt;
	}
	/**
	 * @param orderdt the orderdt to set
	 */
	public void setOrderdt(String orderdt) {
		this.orderdt = orderdt;
	}
	/**
	 * @return the ctno
	 */
	public String getCtno() {
		return ctno;
	}
	/**
	 * @param ctno the ctno to set
	 */
	public void setCtno(String ctno) {
		this.ctno = ctno;
	}
	/**
	 * @return the agent
	 */
	public String getAgent() {
		return agent;
	}
	/**
	 * @param agent the agent to set
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}
	/**
	 * @return the exporter
	 */
	public String getExporter() {
		return exporter;
	}
	/**
	 * @param exporter the exporter to set
	 */
	public void setExporter(String exporter) {
		this.exporter = exporter;
	}
	/**
	 * @return the othercommission
	 */
	public String getOthercommission() {
		return othercommission;
	}
	/**
	 * @param othercommission the othercommission to set
	 */
	public void setOthercommission(String othercommission) {
		this.othercommission = othercommission;
	}
	/**
	 * @return the tannery
	 */
	public String getTannery() {
		return tannery;
	}
	/**
	 * @param tannery the tannery to set
	 */
	public void setTannery(String tannery) {
		this.tannery = tannery;
	}
	/**
	 * @return the consignee
	 */
	public String getConsignee() {
		return consignee;
	}
	/**
	 * @param consignee the consignee to set
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	} 
	

}
