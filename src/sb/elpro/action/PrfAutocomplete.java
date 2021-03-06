/**
 * 
 */
package sb.elpro.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sb.elpro.bo.PrfBo;
import sb.elpro.bo.PrfBoImpl;
import sb.elpro.bo.SrfBo;
import sb.elpro.bo.SrfBoImpl;
import sb.elpro.model.AgentDetails;
import sb.elpro.model.ArticleDetails;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.BankDetails;
import sb.elpro.model.CommissionDetails;
import sb.elpro.model.ConsigneeDetails;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.NotifyConsigneeDetails;
import sb.elpro.model.TanneryDetails;

/**
 * @author Wahab
 * Created on 16.05.13
 *  All Autocomplete in prf Screen ll be handled by this servlet
 */
public class PrfAutocomplete extends Action {
	SrfBo srfbo = new SrfBoImpl();
	PrfBo prfbo = new PrfBoImpl();
	HttpSession usersession;
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request,  HttpServletResponse response) throws Exception{
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			usersession = request.getSession(false);
			if(!(usersession == null)){
				String action = request.getParameter("action");
				if(action.equalsIgnoreCase("tan")){ 
					String tanterm = request.getParameter("term");
					List<TanneryDetails> tannerylist =  prfbo.getTanneryDetails(tanterm);
					System.out.println("List Value " +tannerylist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(tannerylist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}else if (action.equalsIgnoreCase("artname")){
					String term = request.getParameter("term");
					System.out.println("Art type "+term);
					List<ArticleDetails> articlelist =  prfbo.getPrfArticleName(term);
					System.out.println("List Value " +articlelist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(articlelist);
					 System.out.println(jsonOrdertanArray);
			 		out.println(jsonOrdertanArray);
				}else if (action.equalsIgnoreCase("arttype")){
					//String term = request.getParameter("term");
					List<ArticleDetails> articlelist =  prfbo.getPrfArticleType();
					System.out.println("List Value " +articlelist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(articlelist);
					/*
					 * Get teh Value of the JSon data 
					 * {"rows":[{"divid":["01"],"longDesc":["Office of Technology and Information Services"]},{"divid":["04"],"longDesc":["Office of Emergency Response"]},{"divid":["05"]}]}
					 */
				
					 System.out.println(jsonOrdertanArray);
			 		out.println(jsonOrdertanArray);
				}else if (action.equalsIgnoreCase("selec")){
					List<AutoComplete> seleclist =  prfbo.getPrfSelection();
					System.out.println("List Value " +seleclist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(seleclist);
					 System.out.println(jsonOrdertanArray);
			 		out.println(jsonOrdertanArray);
				}else if (action.equalsIgnoreCase("sizerem")){
					List<AutoComplete> seleclist =  prfbo.getPrfSizeRem();
					System.out.println("List Value " +seleclist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(seleclist);
					 System.out.println(jsonOrdertanArray);
			 		out.println(jsonOrdertanArray);
				}else if (action.equalsIgnoreCase("colormatch")){
					List<AutoComplete> colormatchlist =  prfbo.getPrfColormatch();
					System.out.println("List Value " +colormatchlist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(colormatchlist);
					 System.out.println(jsonOrdertanArray);
			 		out.println(jsonOrdertanArray);
				}else if (action.equalsIgnoreCase("color")){
					String term = request.getParameter("term");
					List<AutoComplete> articlelist =  prfbo.getPrfColor(term);
					System.out.println("List Value " +articlelist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(articlelist);
					 System.out.println(jsonOrdertanArray);
			 		out.println(jsonOrdertanArray);
				}else if(action.equalsIgnoreCase("custname")){
					String custterm = request.getParameter("term");
					List<CustomerDetails> customerlist =  prfbo.getCustomerDetails(custterm);
					System.out.println("List Value " +customerlist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(customerlist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}else if(action.equalsIgnoreCase("deliver")){
					String delivterm = request.getParameter("term");
					List<CustomerDetails> customerlist =  prfbo.getCustomerDetails(delivterm);
					System.out.println("List Value " +customerlist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(customerlist);
					System.out.println(jsonOrdertanArray);
					out.println(jsonOrdertanArray);
				}else if(action.equalsIgnoreCase("commision")){
					String commissnterm = request.getParameter("term");
					List<CommissionDetails> commssionlist =  prfbo.getCommissionDetails(commissnterm);
					System.out.println("List Value " +commssionlist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(commssionlist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}else if(action.equalsIgnoreCase("othercommision")){
					System.out.println("In Other Commission");
					String othercommissnterm = request.getParameter("term");
					List<CommissionDetails> commssionlist =  prfbo.getOtherCommissionDetails(othercommissnterm);
					System.out.println("List Value " +commssionlist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(commssionlist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}
				else if(action.equalsIgnoreCase("bank")){
					System.out.println("In prf_bankname");
					String bankterm = request.getParameter("term");
					List<BankDetails> banklist =  prfbo.getbankDetails(bankterm);
					System.out.println("List Value " +banklist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(banklist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}
				else if(action.equalsIgnoreCase("notify")){
					System.out.println("In prf_notifyname");
					String notifyterm = request.getParameter("term");
					List<NotifyConsigneeDetails> notifyconsigneelist =  prfbo.getnotifyDetails(notifyterm);
					System.out.println("List Value " +notifyconsigneelist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(notifyconsigneelist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}
				else if(action.equalsIgnoreCase("consignee")){
					System.out.println("In prf_consigneename");
					String consigneeterm = request.getParameter("term");
					List<ConsigneeDetails> consigneelist =  prfbo.getconsignee(consigneeterm);
					System.out.println("List Value " +consigneelist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(consigneelist);
					 System.out.println(jsonOrdertanArray);
					 out.println(jsonOrdertanArray);
				}else if(action.equalsIgnoreCase("desti")){
					String term = request.getParameter("term");
					System.out.println(" Term "+term);
					List<AutoComplete> destinationlist =  srfbo.getDestinationDetails(term);
					System.out.println("List Value " +destinationlist.size());
					JSONArray jsonOrderArray = JSONArray.fromObject(destinationlist);
					 System.out.println(jsonOrderArray);
			 		out.println(jsonOrderArray);
				}else if (action.equalsIgnoreCase("agent")){
					String term = request.getParameter("term");
					List<AgentDetails> articlelist =  prfbo.getAgentDetails(term);
					System.out.println("List Value " +articlelist.size());
					JSONArray jsonOrdertanArray = JSONArray.fromObject(articlelist);
					 System.out.println(jsonOrdertanArray);
			 		out.println(jsonOrdertanArray);
				}else if (action.equalsIgnoreCase("shipment")){
					String term = request.getParameter("term");
					List<AutoComplete> shipmentlist =  prfbo.getShipmentDetails(term);
					System.out.println("List Value " +shipmentlist.size());
					JSONArray jsonOrdershipArray = JSONArray.fromObject(shipmentlist);
					 System.out.println(jsonOrdershipArray);
			 		out.println(jsonOrdershipArray);
				}else if(action.equalsIgnoreCase("pojwno")){
					System.out.println("In pojwno Autocomplete");
					String pojwno  =  prfbo.getPoJWno();
					System.out.println(pojwno);
					out.println(pojwno);
				}else if(action.equalsIgnoreCase("qtyunit")){
					String term = request.getParameter("term");
					List<AutoComplete> qtyunitlist =  prfbo.getQtyUnitDetails(term);
					System.out.println("List Value " +qtyunitlist.size());
					JSONArray jsonOrdershipArray = JSONArray.fromObject(qtyunitlist);
					System.out.println(jsonOrdershipArray);
			 		out.println(jsonOrdershipArray);
				}else if(action.equalsIgnoreCase("currency")){
					String term = request.getParameter("term");
					List<AutoComplete> currencylist =  prfbo.getCurrencyDetails(term);
					System.out.println("List Value " +currencylist.size());
					JSONArray jsonOrdershipArray = JSONArray.fromObject(currencylist);
					System.out.println(jsonOrdershipArray);
			 		out.println(jsonOrdershipArray);
				}else if(action.equalsIgnoreCase("subcurrency")){
					String term = request.getParameter("term");
					List<AutoComplete> subcurrencylist =  prfbo.getSubCurrencyDetails(term);
					System.out.println("List Value " +subcurrencylist.size());
					JSONArray jsonOrdershipArray = JSONArray.fromObject(subcurrencylist);
					System.out.println(jsonOrdershipArray);
			 		out.println(jsonOrdershipArray);
				}else if(action.equalsIgnoreCase("tccust")){
					String term = request.getParameter("term");
					List<AutoComplete> tccustlist =  prfbo.getTcCustDetails(term);
					System.out.println("List Value " +tccustlist.size());
					JSONArray jsonOrdershipArray = JSONArray.fromObject(tccustlist);
					System.out.println(jsonOrdershipArray);
			 		out.println(jsonOrdershipArray);
				}else if(action.equalsIgnoreCase("terms")){
					String term = request.getParameter("term");
					List<AutoComplete> prftermstlist =  prfbo.getTermsDetails(term);
					System.out.println("List Value " +prftermstlist.size());
					JSONArray prftermstArray = JSONArray.fromObject(prftermstlist);
					System.out.println(prftermstArray);
			 		out.println(prftermstArray);
				}else if(action.equalsIgnoreCase("payment")){
					String term = request.getParameter("term");
					List<AutoComplete> prfpaymentlist =  prfbo.getPaymentDetails(term);
					System.out.println("List Value " +prfpaymentlist.size());
					JSONArray jsonprfpaymentArray = JSONArray.fromObject(prfpaymentlist);
					System.out.println(jsonprfpaymentArray);
			 		out.println(jsonprfpaymentArray);
				}else{
				
					/*
					 * Here i am using first letter enter from the Entry using request .getparamanter 
					 * and passing the value
					 * 
					 */
					  
					}
				 out.close();
			}else{
				System.out.println("Invalid User pls Login Again");
				return mapping.findForward("logout");
			}
		return null;
	}

}
