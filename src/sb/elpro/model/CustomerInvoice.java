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

	private String Ctno;
	private String Orderdt;
	private String pono; 
	private String customerid; 
	private String cdd_date; 
	private String add_date; 
	private String destination; 
	private String commission;
	/**
	 * @return the ctno
	 */
	public String getCtno() {
		return Ctno;
	}
	/**
	 * @param ctno the ctno to set
	 */
	public void setCtno(String ctno) {
		Ctno = ctno;
	}
	/**
	 * @return the orderdt
	 */
	public String getOrderdt() {
		return Orderdt;
	}
	/**
	 * @param orderdt the orderdt to set
	 */
	public void setOrderdt(String orderdt) {
		Orderdt = orderdt;
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
	 * @return the customerid
	 */
	public String getCustomerid() {
		return customerid;
	}
	/**
	 * @param customerid the customerid to set
	 */
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
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
	

}
