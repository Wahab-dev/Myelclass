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
public class SampleInvoiceForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8760629375298276712L;
	
	private String saminv_invoicetype;
	private String saminv_invoiceno;
	private String saminv_invdate;
	private String saminv_expref;
	private String saminv_otherref;
	
	private String saminv_exporter;
	private String saminv_exporterid;
	private String saminv_exporterattn;
	private String saminv_exporteraddress; 
	private String saminv_exportertele;
	private String saminv_exporterfax;
	
	private String saminv_notify;
	private String saminv_notifyid;
	private String saminv_notifyattn;
	private String saminv_notifyaddress;
	private String saminv_notifytele;
	private String saminv_notifyfax;
	
	private String saminv_buyer;
	private String saminv_buyerattn;
	private String saminv_buyeraddr;
	private String saminv_buyertele;
	private String saminv_buyerfax;
	private String saminv_buyerid;
	
	private String saminv_bank;
	private String saminv_bankid;
	private String saminv_bankbranch;
	private String saminv_bankaddress;
	private String saminv_bankswiftcode;
	private String saminv_bankacno;
	private String saminv_banktele;
	private String saminv_bankfax;
	
	private String saminv_ctryoforigngoods;
	private String saminv_loadingport;
	private String saminv_ctryoffinaldesti;
	private String saminv_finaldesti;
	private String saminv_dischargeport;
	private String saminv_vesselno;
	private String saminv_awbilldate;
	private String saminv_awbillno;
	private String saminv_payment;
	private String saminv_terms;
	
	private String saminv_precarriageby;
	private String saminv_marksno;
	private String saminv_noofpackages;
	private String saminv_packno;
	private String saminv_netwt;
	private String saminv_grosswt;
	private String saminv_dimension;
	private String saminv_courierchrgs;
	private String saminv_vatcst;
	private String saminv_total;
	
	private String saminv_includeSample;
	private String saminv_customer;
	private String saminv_custattn;
	private String saminv_custaddr;
	private String saminv_custtele;
	private String saminv_custfax;
	private String saminv_custid;
	private String saminv_deduction;
	
	private String sampleinvactionform;
	
	/**
	 * @return the saminv_invoicetype
	 */
	public String getSaminv_invoicetype() {
		return saminv_invoicetype;
	}
	/**
	 * @param saminv_invoicetype the saminv_invoicetype to set
	 */
	public void setSaminv_invoicetype(String saminv_invoicetype) {
		this.saminv_invoicetype = saminv_invoicetype;
	}
	/**
	 * @return the saminv_invoiceno
	 */
	public String getSaminv_invoiceno() {
		return saminv_invoiceno;
	}
	/**
	 * @param saminv_invoiceno the saminv_invoiceno to set
	 */
	public void setSaminv_invoiceno(String saminv_invoiceno) {
		this.saminv_invoiceno = saminv_invoiceno;
	}
	/**
	 * @return the saminv_invdate
	 */
	public String getSaminv_invdate() {
		return saminv_invdate;
	}
	/**
	 * @param saminv_invdate the saminv_invdate to set
	 */
	public void setSaminv_invdate(String saminv_invdate) {
		this.saminv_invdate = saminv_invdate;
	}
	/**
	 * @return the saminv_expref
	 */
	public String getSaminv_expref() {
		return saminv_expref;
	}
	/**
	 * @param saminv_expref the saminv_expref to set
	 */
	public void setSaminv_expref(String saminv_expref) {
		this.saminv_expref = saminv_expref;
	}
	/**
	 * @return the saminv_otherref
	 */
	public String getSaminv_otherref() {
		return saminv_otherref;
	}
	/**
	 * @param saminv_otherref the saminv_otherref to set
	 */
	public void setSaminv_otherref(String saminv_otherref) {
		this.saminv_otherref = saminv_otherref;
	}
	/**
	 * @return the saminv_exporter
	 */
	public String getSaminv_exporter() {
		return saminv_exporter;
	}
	/**
	 * @param saminv_exporter the saminv_exporter to set
	 */
	public void setSaminv_exporter(String saminv_exporter) {
		this.saminv_exporter = saminv_exporter;
	}
	/**
	 * @return the saminv_exporterattn
	 */
	public String getSaminv_exporterattn() {
		return saminv_exporterattn;
	}
	/**
	 * @param saminv_exporterattn the saminv_exporterattn to set
	 */
	public void setSaminv_exporterattn(String saminv_exporterattn) {
		this.saminv_exporterattn = saminv_exporterattn;
	}
	/**
	 * @return the saminv_exportertele
	 */
	public String getSaminv_exportertele() {
		return saminv_exportertele;
	}
	/**
	 * @param saminv_exportertele the saminv_exportertele to set
	 */
	public void setSaminv_exportertele(String saminv_exportertele) {
		this.saminv_exportertele = saminv_exportertele;
	}
	/**
	 * @return the saminv_exporterfax
	 */
	public String getSaminv_exporterfax() {
		return saminv_exporterfax;
	}
	/**
	 * @param saminv_exporterfax the saminv_exporterfax to set
	 */
	public void setSaminv_exporterfax(String saminv_exporterfax) {
		this.saminv_exporterfax = saminv_exporterfax;
	}
	/**
	 * @return the saminv_notify
	 */
	public String getSaminv_notify() {
		return saminv_notify;
	}
	/**
	 * @param saminv_notify the saminv_notify to set
	 */
	public void setSaminv_notify(String saminv_notify) {
		this.saminv_notify = saminv_notify;
	}
	/**
	 * @return the saminv_notifyattn
	 */
	public String getSaminv_notifyattn() {
		return saminv_notifyattn;
	}
	/**
	 * @param saminv_notifyattn the saminv_notifyattn to set
	 */
	public void setSaminv_notifyattn(String saminv_notifyattn) {
		this.saminv_notifyattn = saminv_notifyattn;
	}
	/**
	 * @return the saminv_notifyaddress
	 */
	public String getSaminv_notifyaddress() {
		return saminv_notifyaddress;
	}
	/**
	 * @param saminv_notifyaddress the saminv_notifyaddress to set
	 */
	public void setSaminv_notifyaddress(String saminv_notifyaddress) {
		this.saminv_notifyaddress = saminv_notifyaddress;
	}
	/**
	 * @return the saminv_notifytele
	 */
	public String getSaminv_notifytele() {
		return saminv_notifytele;
	}
	/**
	 * @param saminv_notifytele the saminv_notifytele to set
	 */
	public void setSaminv_notifytele(String saminv_notifytele) {
		this.saminv_notifytele = saminv_notifytele;
	}
	/**
	 * @return the saminv_notifyfax
	 */
	public String getSaminv_notifyfax() {
		return saminv_notifyfax;
	}
	/**
	 * @param saminv_notifyfax the saminv_notifyfax to set
	 */
	public void setSaminv_notifyfax(String saminv_notifyfax) {
		this.saminv_notifyfax = saminv_notifyfax;
	}
	/**
	 * @return the saminv_buyer
	 */
	public String getSaminv_buyer() {
		return saminv_buyer;
	}
	/**
	 * @param saminv_buyer the saminv_buyer to set
	 */
	public void setSaminv_buyer(String saminv_buyer) {
		this.saminv_buyer = saminv_buyer;
	}
	/**
	 * @return the saminv_buyerattn
	 */
	public String getSaminv_buyerattn() {
		return saminv_buyerattn;
	}
	/**
	 * @param saminv_buyerattn the saminv_buyerattn to set
	 */
	public void setSaminv_buyerattn(String saminv_buyerattn) {
		this.saminv_buyerattn = saminv_buyerattn;
	}
	/**
	 * @return the saminv_buyeraddr
	 */
	public String getSaminv_buyeraddr() {
		return saminv_buyeraddr;
	}
	/**
	 * @param saminv_buyeraddr the saminv_buyeraddr to set
	 */
	public void setSaminv_buyeraddr(String saminv_buyeraddr) {
		this.saminv_buyeraddr = saminv_buyeraddr;
	}
	/**
	 * @return the saminv_buyertele
	 */
	public String getSaminv_buyertele() {
		return saminv_buyertele;
	}
	/**
	 * @param saminv_buyertele the saminv_buyertele to set
	 */
	public void setSaminv_buyertele(String saminv_buyertele) {
		this.saminv_buyertele = saminv_buyertele;
	}
	/**
	 * @return the saminv_buyerfax
	 */
	public String getSaminv_buyerfax() {
		return saminv_buyerfax;
	}
	/**
	 * @param saminv_buyerfax the saminv_buyerfax to set
	 */
	public void setSaminv_buyerfax(String saminv_buyerfax) {
		this.saminv_buyerfax = saminv_buyerfax;
	}
	/**
	 * @return the saminv_buyerid
	 */
	public String getSaminv_buyerid() {
		return saminv_buyerid;
	}
	/**
	 * @param saminv_buyerid the saminv_buyerid to set
	 */
	public void setSaminv_buyerid(String saminv_buyerid) {
		this.saminv_buyerid = saminv_buyerid;
	}
	/**
	 * @return the saminv_bank
	 */
	public String getSaminv_bank() {
		return saminv_bank;
	}
	/**
	 * @param saminv_bank the saminv_bank to set
	 */
	public void setSaminv_bank(String saminv_bank) {
		this.saminv_bank = saminv_bank;
	}
	/**
	 * @return the saminv_bankbranch
	 */
	public String getSaminv_bankbranch() {
		return saminv_bankbranch;
	}
	/**
	 * @param saminv_bankbranch the saminv_bankbranch to set
	 */
	public void setSaminv_bankbranch(String saminv_bankbranch) {
		this.saminv_bankbranch = saminv_bankbranch;
	}
	/**
	 * @return the saminv_bankaddress
	 */
	public String getSaminv_bankaddress() {
		return saminv_bankaddress;
	}
	/**
	 * @param saminv_bankaddress the saminv_bankaddress to set
	 */
	public void setSaminv_bankaddress(String saminv_bankaddress) {
		this.saminv_bankaddress = saminv_bankaddress;
	}
	/**
	 * @return the saminv_bankswiftcode
	 */
	public String getSaminv_bankswiftcode() {
		return saminv_bankswiftcode;
	}
	/**
	 * @param saminv_bankswiftcode the saminv_bankswiftcode to set
	 */
	public void setSaminv_bankswiftcode(String saminv_bankswiftcode) {
		this.saminv_bankswiftcode = saminv_bankswiftcode;
	}
	/**
	 * @return the saminv_bankacno
	 */
	public String getSaminv_bankacno() {
		return saminv_bankacno;
	}
	/**
	 * @param saminv_bankacno the saminv_bankacno to set
	 */
	public void setSaminv_bankacno(String saminv_bankacno) {
		this.saminv_bankacno = saminv_bankacno;
	}
	/**
	 * @return the saminv_banktele
	 */
	public String getSaminv_banktele() {
		return saminv_banktele;
	}
	/**
	 * @param saminv_banktele the saminv_banktele to set
	 */
	public void setSaminv_banktele(String saminv_banktele) {
		this.saminv_banktele = saminv_banktele;
	}
	/**
	 * @return the saminv_bankfax
	 */
	public String getSaminv_bankfax() {
		return saminv_bankfax;
	}
	/**
	 * @param saminv_bankfax the saminv_bankfax to set
	 */
	public void setSaminv_bankfax(String saminv_bankfax) {
		this.saminv_bankfax = saminv_bankfax;
	}
	/**
	 * @return the saminv_ctryoforigngoods
	 */
	public String getSaminv_ctryoforigngoods() {
		return saminv_ctryoforigngoods;
	}
	/**
	 * @param saminv_ctryoforigngoods the saminv_ctryoforigngoods to set
	 */
	public void setSaminv_ctryoforigngoods(String saminv_ctryoforigngoods) {
		this.saminv_ctryoforigngoods = saminv_ctryoforigngoods;
	}
	/**
	 * @return the saminv_loadingport
	 */
	public String getSaminv_loadingport() {
		return saminv_loadingport;
	}
	/**
	 * @param saminv_loadingport the saminv_loadingport to set
	 */
	public void setSaminv_loadingport(String saminv_loadingport) {
		this.saminv_loadingport = saminv_loadingport;
	}
	/**
	 * @return the saminv_ctryoffinaldesti
	 */
	public String getSaminv_ctryoffinaldesti() {
		return saminv_ctryoffinaldesti;
	}
	/**
	 * @param saminv_ctryoffinaldesti the saminv_ctryoffinaldesti to set
	 */
	public void setSaminv_ctryoffinaldesti(String saminv_ctryoffinaldesti) {
		this.saminv_ctryoffinaldesti = saminv_ctryoffinaldesti;
	}
	/**
	 * @return the saminv_dischargeport
	 */
	public String getSaminv_dischargeport() {
		return saminv_dischargeport;
	}
	/**
	 * @param saminv_dischargeport the saminv_dischargeport to set
	 */
	public void setSaminv_dischargeport(String saminv_dischargeport) {
		this.saminv_dischargeport = saminv_dischargeport;
	}
	/**
	 * @return the saminv_vesselno
	 */
	public String getSaminv_vesselno() {
		return saminv_vesselno;
	}
	/**
	 * @param saminv_vesselno the saminv_vesselno to set
	 */
	public void setSaminv_vesselno(String saminv_vesselno) {
		this.saminv_vesselno = saminv_vesselno;
	}
	/**
	 * @return the saminv_awbilldate
	 */
	public String getSaminv_awbilldate() {
		return saminv_awbilldate;
	}
	/**
	 * @param saminv_awbilldate the saminv_awbilldate to set
	 */
	public void setSaminv_awbilldate(String saminv_awbilldate) {
		this.saminv_awbilldate = saminv_awbilldate;
	}
	/**
	 * @return the saminv_awbillno
	 */
	public String getSaminv_awbillno() {
		return saminv_awbillno;
	}
	/**
	 * @param saminv_awbillno the saminv_awbillno to set
	 */
	public void setSaminv_awbillno(String saminv_awbillno) {
		this.saminv_awbillno = saminv_awbillno;
	}
	/**
	 * @return the saminv_grosswt
	 */
	public String getSaminv_grosswt() {
		return saminv_grosswt;
	}
	/**
	 * @param saminv_grosswt the saminv_grosswt to set
	 */
	public void setSaminv_grosswt(String saminv_grosswt) {
		this.saminv_grosswt = saminv_grosswt;
	}
	/**
	 * @return the saminv_dimension
	 */
	public String getSaminv_dimension() {
		return saminv_dimension;
	}
	/**
	 * @param saminv_dimension the saminv_dimension to set
	 */
	public void setSaminv_dimension(String saminv_dimension) {
		this.saminv_dimension = saminv_dimension;
	}
	/**
	 * @return the saminv_courierchrgs
	 */
	public String getSaminv_courierchrgs() {
		return saminv_courierchrgs;
	}
	/**
	 * @param saminv_courierchrgs the saminv_courierchrgs to set
	 */
	public void setSaminv_courierchrgs(String saminv_courierchrgs) {
		this.saminv_courierchrgs = saminv_courierchrgs;
	}
	/**
	 * @return the saminv_vatcst
	 */
	public String getSaminv_vatcst() {
		return saminv_vatcst;
	}
	/**
	 * @param saminv_vatcst the saminv_vatcst to set
	 */
	public void setSaminv_vatcst(String saminv_vatcst) {
		this.saminv_vatcst = saminv_vatcst;
	}
	/**
	 * @return the saminv_total
	 */
	public String getSaminv_total() {
		return saminv_total;
	}
	/**
	 * @param saminv_total the saminv_total to set
	 */
	public void setSaminv_total(String saminv_total) {
		this.saminv_total = saminv_total;
	}
	/**
	 * @return the saminv_includeSample
	 */
	public String getSaminv_includeSample() {
		return saminv_includeSample;
	}
	/**
	 * @param saminv_includeSample the saminv_includeSample to set
	 */
	public void setSaminv_includeSample(String saminv_includeSample) {
		this.saminv_includeSample = saminv_includeSample;
	}
	/**
	 * @return the saminv_customer
	 */
	public String getSaminv_customer() {
		return saminv_customer;
	}
	/**
	 * @param saminv_customer the saminv_customer to set
	 */
	public void setSaminv_customer(String saminv_customer) {
		this.saminv_customer = saminv_customer;
	}
	/**
	 * @return the saminv_custattn
	 */
	public String getSaminv_custattn() {
		return saminv_custattn;
	}
	/**
	 * @param saminv_custattn the saminv_custattn to set
	 */
	public void setSaminv_custattn(String saminv_custattn) {
		this.saminv_custattn = saminv_custattn;
	}
	/**
	 * @return the saminv_custaddr
	 */
	public String getSaminv_custaddr() {
		return saminv_custaddr;
	}
	/**
	 * @param saminv_custaddr the saminv_custaddr to set
	 */
	public void setSaminv_custaddr(String saminv_custaddr) {
		this.saminv_custaddr = saminv_custaddr;
	}
	/**
	 * @return the saminv_custtele
	 */
	public String getSaminv_custtele() {
		return saminv_custtele;
	}
	/**
	 * @param saminv_custtele the saminv_custtele to set
	 */
	public void setSaminv_custtele(String saminv_custtele) {
		this.saminv_custtele = saminv_custtele;
	}
	/**
	 * @return the saminv_custfax
	 */
	public String getSaminv_custfax() {
		return saminv_custfax;
	}
	/**
	 * @param saminv_custfax the saminv_custfax to set
	 */
	public void setSaminv_custfax(String saminv_custfax) {
		this.saminv_custfax = saminv_custfax;
	}
	/**
	 * @return the saminv_custid
	 */
	public String getSaminv_custid() {
		return saminv_custid;
	}
	/**
	 * @param saminv_custid the saminv_custid to set
	 */
	public void setSaminv_custid(String saminv_custid) {
		this.saminv_custid = saminv_custid;
	}
	/**
	 * @return the saminv_precarriageby
	 */
	public String getSaminv_precarriageby() {
		return saminv_precarriageby;
	}
	/**
	 * @param saminv_precarriageby the saminv_precarriageby to set
	 */
	public void setSaminv_precarriageby(String saminv_precarriageby) {
		this.saminv_precarriageby = saminv_precarriageby;
	}
	/**
	 * @return the saminv_marksno
	 */
	public String getSaminv_marksno() {
		return saminv_marksno;
	}
	/**
	 * @param saminv_marksno the saminv_marksno to set
	 */
	public void setSaminv_marksno(String saminv_marksno) {
		this.saminv_marksno = saminv_marksno;
	}
	/**
	 * @return the saminv_noofpackages
	 */
	public String getSaminv_noofpackages() {
		return saminv_noofpackages;
	}
	/**
	 * @param saminv_noofpackages the saminv_noofpackages to set
	 */
	public void setSaminv_noofpackages(String saminv_noofpackages) {
		this.saminv_noofpackages = saminv_noofpackages;
	}
	/**
	 * @return the saminv_packno
	 */
	public String getSaminv_packno() {
		return saminv_packno;
	}
	/**
	 * @param saminv_packno the saminv_packno to set
	 */
	public void setSaminv_packno(String saminv_packno) {
		this.saminv_packno = saminv_packno;
	}
	/**
	 * @return the saminv_netwt
	 */
	public String getSaminv_netwt() {
		return saminv_netwt;
	}
	/**
	 * @param saminv_netwt the saminv_netwt to set
	 */
	public void setSaminv_netwt(String saminv_netwt) {
		this.saminv_netwt = saminv_netwt;
	}
	/**
	 * @return the exporteraddress
	 */
	/**
	 * @return the saminv_exporteraddress
	 */
	public String getSaminv_exporteraddress() {
		return saminv_exporteraddress;
	}
	/**
	 * @param saminv_exporteraddress the saminv_exporteraddress to set
	 */
	public void setSaminv_exporteraddress(String saminv_exporteraddress) {
		this.saminv_exporteraddress = saminv_exporteraddress;
	}
	/**
	 * @return the saminv_finaldesti
	 */
	public String getSaminv_finaldesti() {
		return saminv_finaldesti;
	}
	/**
	 * @param saminv_finaldesti the saminv_finaldesti to set
	 */
	public void setSaminv_finaldesti(String saminv_finaldesti) {
		this.saminv_finaldesti = saminv_finaldesti;
	}
	/**
	 * @return the saminv_deduction
	 */
	public String getSaminv_deduction() {
		return saminv_deduction;
	}
	/**
	 * @param saminv_deduction the saminv_deduction to set
	 */
	public void setSaminv_deduction(String saminv_deduction) {
		this.saminv_deduction = saminv_deduction;
	}
	
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		 saminv_invoicetype= "";
		 saminv_invoiceno= "";
		 saminv_invdate= "";
		 saminv_expref= "";
		 saminv_otherref= "";
		 saminv_exporter= "";
		 saminv_exporterattn= "";
		 saminv_exporteraddress= ""; 
		 saminv_exportertele= "";
		 saminv_exporterfax= "";
		 saminv_notify= "";
		 saminv_notifyattn= "";
		 saminv_notifyaddress= "";
		 saminv_notifytele= "";
		 saminv_notifyfax= "";
		
		 saminv_buyer= "";
		 saminv_buyerattn= "";
		 saminv_buyeraddr= "";
		 saminv_buyertele= "";
		 saminv_buyerfax= "";
		 saminv_buyerid= "";
		 saminv_bank= "";
		 saminv_bankbranch= "";
		 saminv_bankaddress= "";
		 saminv_bankswiftcode= "";
		 saminv_bankacno= "";
		 saminv_banktele= "";
		 saminv_bankfax= "";
		 saminv_ctryoforigngoods= "";
		 saminv_loadingport= "";
		 saminv_ctryoffinaldesti= "";
		 saminv_finaldesti= "";
		 saminv_dischargeport= "";
		 saminv_vesselno= "";
		 saminv_awbilldate= "";
		 saminv_awbillno= "";
		 saminv_precarriageby= "";
		 saminv_marksno= "";
		 saminv_noofpackages= "";
		 saminv_packno= "";
		 saminv_netwt= "";
		 saminv_grosswt= "";
		 saminv_dimension= "";
		 saminv_courierchrgs= "";
		 saminv_vatcst= "";
		 saminv_total= "";
		
		 saminv_includeSample= "";
		 saminv_customer= "";
		 saminv_custattn= "";
		 saminv_custaddr= "";
		 saminv_custtele= "";
		 saminv_custfax= "";
		 saminv_custid= "";
		 saminv_deduction= "";
	}
	/**
	 * @return the sampleinvactionform
	 */
	public String getSampleinvactionform() {
		return sampleinvactionform;
	}
	/**
	 * @param sampleinvactionform the sampleinvactionform to set
	 */
	public void setSampleinvactionform(String sampleinvactionform) {
		this.sampleinvactionform = sampleinvactionform;
	}
	/**
	 * @return the saminv_terms
	 */
	public String getSaminv_terms() {
		return saminv_terms;
	}
	/**
	 * @param saminv_terms the saminv_terms to set
	 */
	public void setSaminv_terms(String saminv_terms) {
		this.saminv_terms = saminv_terms;
	}
	/**
	 * @return the saminv_payment
	 */
	public String getSaminv_payment() {
		return saminv_payment;
	}
	/**
	 * @param saminv_payment the saminv_payment to set
	 */
	public void setSaminv_payment(String saminv_payment) {
		this.saminv_payment = saminv_payment;
	}
	/**
	 * @return the saminv_exporterid
	 */
	public String getSaminv_exporterid() {
		return saminv_exporterid;
	}
	/**
	 * @param saminv_exporterid the saminv_exporterid to set
	 */
	public void setSaminv_exporterid(String saminv_exporterid) {
		this.saminv_exporterid = saminv_exporterid;
	}
	/**
	 * @return the saminv_notifyid
	 */
	public String getSaminv_notifyid() {
		return saminv_notifyid;
	}
	/**
	 * @param saminv_notifyid the saminv_notifyid to set
	 */
	public void setSaminv_notifyid(String saminv_notifyid) {
		this.saminv_notifyid = saminv_notifyid;
	}
	/**
	 * @return the saminv_bankid
	 */
	public String getSaminv_bankid() {
		return saminv_bankid;
	}
	/**
	 * @param saminv_bankid the saminv_bankid to set
	 */
	public void setSaminv_bankid(String saminv_bankid) {
		this.saminv_bankid = saminv_bankid;
	}
}
