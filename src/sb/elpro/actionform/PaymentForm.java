/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Wahab
 *
 */
public class PaymentForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3411218029792688422L;
	
	private String deb_debitno;
	private String deb_debitdate;
	private String deb_exporter;
	private String deb_tanaddr;
	private String deb_tanattn;
	private String deb_tantelephone;
	private String deb_tanfax;
	private String deb_taninvno;
	private String deb_elclassrefno;
	private String deb_contractno;
	private String deb_orderdate;
	private String deb_article;
	private String deb_color;
	private String deb_invno;
	private String deb_invdate;
	private String deb_totalquantity;
	private String deb_qshipped;
	private String deb_qremain;
	private String deb_rate;
	private String deb_invoiceamt;
	private String deb_commission;
	private String deb_othercommission;
	private String deb_tc;
	private String deb_exchangerate;
	private String deb_elclassamt;
	private String deb_elclassamtinrs;
	private String deb_tax;
	private String deb_total;
	private String deb_tds;
	private String deb_due;
	private String deb_deduction;
	private String deb_iswaived;
	
	private String paymentid;
	private String paymentno;
	private String paymentdate;
	private String recieptdate;
	private String chequedetails;
	private String creditamt;
	private String balanceamt;
	private String otherdetails;
	
	private String tcdeb_tcdebitno;
	private String tcdeb_exporter;
	private String tcdeb_tanaddr;
	private String tcdeb_tantelephone;
	private String tcdeb_tcdebitdate;
	private String tcdeb_taninvno;
	private String tcdeb_elclassrefno;
	private String tcdeb_exchangerate;
	private String tcdeb_commission1;
	private String tcdeb_tcamt;
	private String tcdeb_rate;
	private String tcdeb_totalquantity;
	private String tcdeb_invoiceamt;
	private String tcdeb_elclassamt;
	private String tcdeb_elclassamtinrs;
	//TcDebit 

	/**
	 * @return the deb_debitno
	 */
	public String getDeb_debitno() {
		return deb_debitno;
	}
	/**
	 * @param deb_debitno the deb_debitno to set
	 */
	public void setDeb_debitno(String deb_debitno) {
		this.deb_debitno = deb_debitno;
	}
	/**
	 * @return the deb_debitdate
	 */
	public String getDeb_debitdate() {
		return deb_debitdate;
	}
	/**
	 * @param deb_debitdate the deb_debitdate to set
	 */
	public void setDeb_debitdate(String deb_debitdate) {
		this.deb_debitdate = deb_debitdate;
	}
	/**
	 * @return the deb_exporter
	 */
	public String getDeb_exporter() {
		return deb_exporter;
	}
	/**
	 * @param deb_exporter the deb_exporter to set
	 */
	public void setDeb_exporter(String deb_exporter) {
		this.deb_exporter = deb_exporter;
	}
	/**
	 * @return the deb_tanaddr
	 */
	public String getDeb_tanaddr() {
		return deb_tanaddr;
	}
	/**
	 * @param deb_tanaddr the deb_tanaddr to set
	 */
	public void setDeb_tanaddr(String deb_tanaddr) {
		this.deb_tanaddr = deb_tanaddr;
	}
	/**
	 * @return the deb_tanattn
	 */
	public String getDeb_tanattn() {
		return deb_tanattn;
	}
	/**
	 * @param deb_tanattn the deb_tanattn to set
	 */
	public void setDeb_tanattn(String deb_tanattn) {
		this.deb_tanattn = deb_tanattn;
	}
	/**
	 * @return the deb_tantelephone
	 */
	public String getDeb_tantelephone() {
		return deb_tantelephone;
	}
	/**
	 * @param deb_tantelephone the deb_tantelephone to set
	 */
	public void setDeb_tantelephone(String deb_tantelephone) {
		this.deb_tantelephone = deb_tantelephone;
	}
	/**
	 * @return the deb_tanfax
	 */
	public String getDeb_tanfax() {
		return deb_tanfax;
	}
	/**
	 * @param deb_tanfax the deb_tanfax to set
	 */
	public void setDeb_tanfax(String deb_tanfax) {
		this.deb_tanfax = deb_tanfax;
	}
	/**
	 * @return the deb_taninvno
	 */
	public String getDeb_taninvno() {
		return deb_taninvno;
	}
	/**
	 * @param deb_taninvno the deb_taninvno to set
	 */
	public void setDeb_taninvno(String deb_taninvno) {
		this.deb_taninvno = deb_taninvno;
	}
	/**
	 * @return the deb_elclassrefno
	 */
	public String getDeb_elclassrefno() {
		return deb_elclassrefno;
	}
	/**
	 * @param deb_elclassrefno the deb_elclassrefno to set
	 */
	public void setDeb_elclassrefno(String deb_elclassrefno) {
		this.deb_elclassrefno = deb_elclassrefno;
	}
	/**
	 * @return the deb_contractno
	 */
	public String getDeb_contractno() {
		return deb_contractno;
	}
	/**
	 * @param deb_contractno the deb_contractno to set
	 */
	public void setDeb_contractno(String deb_contractno) {
		this.deb_contractno = deb_contractno;
	}
	/**
	 * @return the deb_orderdate
	 */
	public String getDeb_orderdate() {
		return deb_orderdate;
	}
	/**
	 * @param deb_orderdate the deb_orderdate to set
	 */
	public void setDeb_orderdate(String deb_orderdate) {
		this.deb_orderdate = deb_orderdate;
	}
	/**
	 * @return the deb_article
	 */
	public String getDeb_article() {
		return deb_article;
	}
	/**
	 * @param deb_article the deb_article to set
	 */
	public void setDeb_article(String deb_article) {
		this.deb_article = deb_article;
	}
	/**
	 * @return the deb_color
	 */
	public String getDeb_color() {
		return deb_color;
	}
	/**
	 * @param deb_color the deb_color to set
	 */
	public void setDeb_color(String deb_color) {
		this.deb_color = deb_color;
	}
	/**
	 * @return the deb_invno
	 */
	public String getDeb_invno() {
		return deb_invno;
	}
	/**
	 * @param deb_invno the deb_invno to set
	 */
	public void setDeb_invno(String deb_invno) {
		this.deb_invno = deb_invno;
	}
	/**
	 * @return the deb_invdate
	 */
	public String getDeb_invdate() {
		return deb_invdate;
	}
	/**
	 * @param deb_invdate the deb_invdate to set
	 */
	public void setDeb_invdate(String deb_invdate) {
		this.deb_invdate = deb_invdate;
	}
	/**
	 * @return the deb_totalquantity
	 */
	public String getDeb_totalquantity() {
		return deb_totalquantity;
	}
	/**
	 * @param deb_totalquantity the deb_totalquantity to set
	 */
	public void setDeb_totalquantity(String deb_totalquantity) {
		this.deb_totalquantity = deb_totalquantity;
	}
	/**
	 * @return the deb_qshipped
	 */
	public String getDeb_qshipped() {
		return deb_qshipped;
	}
	/**
	 * @param deb_qshipped the deb_qshipped to set
	 */
	public void setDeb_qshipped(String deb_qshipped) {
		this.deb_qshipped = deb_qshipped;
	}
	/**
	 * @return the deb_qremain
	 */
	public String getDeb_qremain() {
		return deb_qremain;
	}
	/**
	 * @param deb_qremain the deb_qremain to set
	 */
	public void setDeb_qremain(String deb_qremain) {
		this.deb_qremain = deb_qremain;
	}
	/**
	 * @return the deb_rate
	 */
	public String getDeb_rate() {
		return deb_rate;
	}
	/**
	 * @param deb_rate the deb_rate to set
	 */
	public void setDeb_rate(String deb_rate) {
		this.deb_rate = deb_rate;
	}
	/**
	 * @return the deb_invoiceamt
	 */
	public String getDeb_invoiceamt() {
		return deb_invoiceamt;
	}
	/**
	 * @param deb_invoiceamt the deb_invoiceamt to set
	 */
	public void setDeb_invoiceamt(String deb_invoiceamt) {
		this.deb_invoiceamt = deb_invoiceamt;
	}
	/**
	 * @return the deb_commission
	 */
	public String getDeb_commission() {
		return deb_commission;
	}
	/**
	 * @param deb_commission the deb_commission to set
	 */
	public void setDeb_commission(String deb_commission) {
		this.deb_commission = deb_commission;
	}
	/**
	 * @return the deb_othercommission
	 */
	public String getDeb_othercommission() {
		return deb_othercommission;
	}
	/**
	 * @param deb_othercommission the deb_othercommission to set
	 */
	public void setDeb_othercommission(String deb_othercommission) {
		this.deb_othercommission = deb_othercommission;
	}
	/**
	 * @return the deb_tc
	 */
	public String getDeb_tc() {
		return deb_tc;
	}
	/**
	 * @param deb_tc the deb_tc to set
	 */
	public void setDeb_tc(String deb_tc) {
		this.deb_tc = deb_tc;
	}
	/**
	 * @return the deb_exchangerate
	 */
	public String getDeb_exchangerate() {
		return deb_exchangerate;
	}
	/**
	 * @param deb_exchangerate the deb_exchangerate to set
	 */
	public void setDeb_exchangerate(String deb_exchangerate) {
		this.deb_exchangerate = deb_exchangerate;
	}
	/**
	 * @return the deb_elclassamt
	 */
	public String getDeb_elclassamt() {
		return deb_elclassamt;
	}
	/**
	 * @param deb_elclassamt the deb_elclassamt to set
	 */
	public void setDeb_elclassamt(String deb_elclassamt) {
		this.deb_elclassamt = deb_elclassamt;
	}
	/**
	 * @return the deb_elclassamtinrs
	 */
	public String getDeb_elclassamtinrs() {
		return deb_elclassamtinrs;
	}
	/**
	 * @param deb_elclassamtinrs the deb_elclassamtinrs to set
	 */
	public void setDeb_elclassamtinrs(String deb_elclassamtinrs) {
		this.deb_elclassamtinrs = deb_elclassamtinrs;
	}
	/**
	 * @return the deb_tax
	 */
	public String getDeb_tax() {
		return deb_tax;
	}
	/**
	 * @param deb_tax the deb_tax to set
	 */
	public void setDeb_tax(String deb_tax) {
		this.deb_tax = deb_tax;
	}
	/**
	 * @return the deb_total
	 */
	public String getDeb_total() {
		return deb_total;
	}
	/**
	 * @param deb_total the deb_total to set
	 */
	public void setDeb_total(String deb_total) {
		this.deb_total = deb_total;
	}
	/**
	 * @return the deb_tds
	 */
	public String getDeb_tds() {
		return deb_tds;
	}
	/**
	 * @param deb_tds the deb_tds to set
	 */
	public void setDeb_tds(String deb_tds) {
		this.deb_tds = deb_tds;
	}
	/**
	 * @return the deb_due
	 */
	public String getDeb_due() {
		return deb_due;
	}
	/**
	 * @param deb_due the deb_due to set
	 */
	public void setDeb_due(String deb_due) {
		this.deb_due = deb_due;
	}
	/**
	 * @return the deb_deduction
	 */
	public String getDeb_deduction() {
		return deb_deduction;
	}
	/**
	 * @param deb_deduction the deb_deduction to set
	 */
	public void setDeb_deduction(String deb_deduction) {
		this.deb_deduction = deb_deduction;
	}
	/**
	 * @return the deb_iswaived
	 */
	public String getDeb_iswaived() {
		return deb_iswaived;
	}
	/**
	 * @param deb_iswaived the deb_iswaived to set
	 */
	public void setDeb_iswaived(String deb_iswaived) {
		this.deb_iswaived = deb_iswaived;
	}
	/**
	 * @return the recieptdate
	 */
	public String getRecieptdate() {
		return recieptdate;
	}
	/**
	 * @param recieptdate the recieptdate to set
	 */
	public void setRecieptdate(String recieptdate) {
		this.recieptdate = recieptdate;
	}
	/**
	 * @return the chequedetails
	 */
	public String getChequedetails() {
		return chequedetails;
	}
	/**
	 * @param chequedetails the chequedetails to set
	 */
	public void setChequedetails(String chequedetails) {
		this.chequedetails = chequedetails;
	}
	/**
	 * @return the creditamt
	 */
	public String getCreditamt() {
		return creditamt;
	}
	/**
	 * @param creditamt the creditamt to set
	 */
	public void setCreditamt(String creditamt) {
		this.creditamt = creditamt;
	}
	/**
	 * @return the balanceamt
	 */
	public String getBalanceamt() {
		return balanceamt;
	}
	/**
	 * @param balanceamt the balanceamt to set
	 */
	public void setBalanceamt(String balanceamt) {
		this.balanceamt = balanceamt;
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
	/**
	 * @return the tcdeb_tcdebitno
	 */
	public String getTcdeb_tcdebitno() {
		return tcdeb_tcdebitno;
	}
	/**
	 * @param tcdeb_tcdebitno the tcdeb_tcdebitno to set
	 */
	public void setTcdeb_tcdebitno(String tcdeb_tcdebitno) {
		this.tcdeb_tcdebitno = tcdeb_tcdebitno;
	}
	/**
	 * @return the tcdeb_exporter
	 */
	public String getTcdeb_exporter() {
		return tcdeb_exporter;
	}
	/**
	 * @param tcdeb_exporter the tcdeb_exporter to set
	 */
	public void setTcdeb_exporter(String tcdeb_exporter) {
		this.tcdeb_exporter = tcdeb_exporter;
	}
	/**
	 * @return the tcdeb_tanaddr
	 */
	public String getTcdeb_tanaddr() {
		return tcdeb_tanaddr;
	}
	/**
	 * @param tcdeb_tanaddr the tcdeb_tanaddr to set
	 */
	public void setTcdeb_tanaddr(String tcdeb_tanaddr) {
		this.tcdeb_tanaddr = tcdeb_tanaddr;
	}
	/**
	 * @return the tcdeb_tantelephone
	 */
	public String getTcdeb_tantelephone() {
		return tcdeb_tantelephone;
	}
	/**
	 * @param tcdeb_tantelephone the tcdeb_tantelephone to set
	 */
	public void setTcdeb_tantelephone(String tcdeb_tantelephone) {
		this.tcdeb_tantelephone = tcdeb_tantelephone;
	}
	/**
	 * @return the tcdeb_tcdebitdate
	 */
	public String getTcdeb_tcdebitdate() {
		return tcdeb_tcdebitdate;
	}
	/**
	 * @param tcdeb_tcdebitdate the tcdeb_tcdebitdate to set
	 */
	public void setTcdeb_tcdebitdate(String tcdeb_tcdebitdate) {
		this.tcdeb_tcdebitdate = tcdeb_tcdebitdate;
	}
	/**
	 * @return the tcdeb_taninvno
	 */
	public String getTcdeb_taninvno() {
		return tcdeb_taninvno;
	}
	/**
	 * @param tcdeb_taninvno the tcdeb_taninvno to set
	 */
	public void setTcdeb_taninvno(String tcdeb_taninvno) {
		this.tcdeb_taninvno = tcdeb_taninvno;
	}
	/**
	 * @return the tcdeb_elclassrefno
	 */
	public String getTcdeb_elclassrefno() {
		return tcdeb_elclassrefno;
	}
	/**
	 * @param tcdeb_elclassrefno the tcdeb_elclassrefno to set
	 */
	public void setTcdeb_elclassrefno(String tcdeb_elclassrefno) {
		this.tcdeb_elclassrefno = tcdeb_elclassrefno;
	}
	/**
	 * @return the tcdeb_exchangerate
	 */
	public String getTcdeb_exchangerate() {
		return tcdeb_exchangerate;
	}
	/**
	 * @param tcdeb_exchangerate the tcdeb_exchangerate to set
	 */
	public void setTcdeb_exchangerate(String tcdeb_exchangerate) {
		this.tcdeb_exchangerate = tcdeb_exchangerate;
	}
	/**
	 * @return the tcdeb_commission1
	 */
	public String getTcdeb_commission1() {
		return tcdeb_commission1;
	}
	/**
	 * @param tcdeb_commission1 the tcdeb_commission1 to set
	 */
	public void setTcdeb_commission1(String tcdeb_commission1) {
		this.tcdeb_commission1 = tcdeb_commission1;
	}
	/**
	 * @return the tcdeb_tcamt
	 */
	public String getTcdeb_tcamt() {
		return tcdeb_tcamt;
	}
	/**
	 * @param tcdeb_tcamt the tcdeb_tcamt to set
	 */
	public void setTcdeb_tcamt(String tcdeb_tcamt) {
		this.tcdeb_tcamt = tcdeb_tcamt;
	}
	/**
	 * @return the tcdeb_rate
	 */
	public String getTcdeb_rate() {
		return tcdeb_rate;
	}
	/**
	 * @param tcdeb_rate the tcdeb_rate to set
	 */
	public void setTcdeb_rate(String tcdeb_rate) {
		this.tcdeb_rate = tcdeb_rate;
	}
	/**
	 * @return the tcdeb_totalquantity
	 */
	public String getTcdeb_totalquantity() {
		return tcdeb_totalquantity;
	}
	/**
	 * @param tcdeb_totalquantity the tcdeb_totalquantity to set
	 */
	public void setTcdeb_totalquantity(String tcdeb_totalquantity) {
		this.tcdeb_totalquantity = tcdeb_totalquantity;
	}
	/**
	 * @return the tcdeb_invoiceamt
	 */
	public String getTcdeb_invoiceamt() {
		return tcdeb_invoiceamt;
	}
	/**
	 * @param tcdeb_invoiceamt the tcdeb_invoiceamt to set
	 */
	public void setTcdeb_invoiceamt(String tcdeb_invoiceamt) {
		this.tcdeb_invoiceamt = tcdeb_invoiceamt;
	}
	/**
	 * @return the tcdeb_elclassamt
	 */
	public String getTcdeb_elclassamt() {
		return tcdeb_elclassamt;
	}
	/**
	 * @param tcdeb_elclassamt the tcdeb_elclassamt to set
	 */
	public void setTcdeb_elclassamt(String tcdeb_elclassamt) {
		this.tcdeb_elclassamt = tcdeb_elclassamt;
	}
	/**
	 * @return the tcdeb_elclassamtinrs
	 */
	public String getTcdeb_elclassamtinrs() {
		return tcdeb_elclassamtinrs;
	}
	/**
	 * @param tcdeb_elclassamtinrs the tcdeb_elclassamtinrs to set
	 */
	public void setTcdeb_elclassamtinrs(String tcdeb_elclassamtinrs) {
		this.tcdeb_elclassamtinrs = tcdeb_elclassamtinrs;
	}
	

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		deb_debitno= "";
		deb_debitdate ="";
		deb_exporter="";
		deb_tanaddr="";
		deb_tanattn="";
		deb_tantelephone="";
		deb_tanfax="";
		deb_taninvno="";
		deb_elclassrefno="";
		deb_contractno="";
		deb_orderdate="";
		deb_article="";
		deb_color="";
		deb_invno="";
		deb_invdate="";
		deb_totalquantity="";
		deb_qshipped="";
		deb_qremain="";
		deb_rate="";
		deb_invoiceamt="";
		deb_commission="";
		deb_othercommission="";
		deb_tc="";
		deb_exchangerate="";
		deb_elclassamt="";
		deb_elclassamtinrs="";
		deb_tax="";
		deb_total="";
		deb_tds="";
		deb_due="";
		deb_deduction="";
		deb_iswaived="";
		
		//TcDebit 

		tcdeb_tcdebitno="";
		tcdeb_exporter="";
		tcdeb_tanaddr="";
		tcdeb_tantelephone="";
		tcdeb_tcdebitdate="";
		tcdeb_taninvno="";
		tcdeb_elclassrefno="";
		tcdeb_exchangerate="";
		tcdeb_commission1="";
		tcdeb_tcamt="";
		tcdeb_rate="";
		tcdeb_totalquantity="";
		tcdeb_invoiceamt="";
		tcdeb_elclassamt="";
		tcdeb_elclassamtinrs="";
		
		paymentid="";
		paymentno ="";
		paymentdate="";
		recieptdate="";
		chequedetails="";
		creditamt="";
		balanceamt="";
		otherdetails="";
	}
	/**
	 * @return the paymentdate
	 */
	public String getPaymentdate() {
		return paymentdate;
	}
	/**
	 * @param paymentdate the paymentdate to set
	 */
	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}
	/**
	 * @return the paymentid
	 */
	public String getPaymentid() {
		return paymentid;
	}
	/**
	 * @param paymentid the paymentid to set
	 */
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	/**
	 * @return the paymentno
	 */
	public String getPaymentno() {
		return paymentno;
	}
	/**
	 * @param paymentno the paymentno to set
	 */
	public void setPaymentno(String paymentno) {
		this.paymentno = paymentno;
	}
}
