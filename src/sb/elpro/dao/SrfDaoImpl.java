package sb.elpro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import sb.elpro.model.SampleRequest;
import sb.elpro.model.SrfArticle;
import sb.elpro.model.AutoComplete;
import sb.elpro.model.CustomerDetails;
import sb.elpro.model.HandledByDetails;
import sb.elpro.model.PaymentDetails;
import sb.elpro.model.TanneryDetails;
import sb.elpro.utility.DBConnection;

public class SrfDaoImpl implements SrfDao {
	@Override
	public String getSampleno() throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		String sampleno = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT max(sampleno) as sampleno FROM elpro.tbl_srfform";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				String sno = rs.getString("sampleno").trim();
				int isample = Integer.parseInt(sno.substring(1));
				System.out.println(" Int val "+ ++isample);
				sampleno = "S"+isample;
				System.out.println("SAmpleNo "+sampleno);	
			}
		}catch(Exception e){
			System.out.println("Result ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return sampleno;
	}

	@Override
	public ArrayList<HandledByDetails> getsrfhandledby(String term) throws SQLException {
		ArrayList<HandledByDetails> handledbyarray = new ArrayList<HandledByDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT name, type FROM elpro.tbl_handledby where name like '%"+term+"%'  order by name";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				HandledByDetails handledbybean = new HandledByDetails();
				handledbybean.setLabel(rs.getString("name"));
				handledbybean.setSrf_handledbytype(rs.getString("type"));
				System.out.println("handledby  name "+handledbybean.getLabel());
				handledbyarray.add(handledbybean);
			}
		}catch(Exception e){
			System.out.println("Result ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return handledbyarray;
	}

	@Override
	public List<AutoComplete> getsrfendusage(String term) throws SQLException {
		ArrayList<AutoComplete> endusagearray = new ArrayList<AutoComplete>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;			
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT endusagename, endusagetype FROM elpro.tbl_srfendusage where endusagename like '%"+term+"%'   order by endusagename";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				AutoComplete endusagebean = new AutoComplete();
				endusagebean.setLabel(rs.getString("endusagename"));
				endusagebean.setValue(rs.getString("endusagetype"));
				System.out.println("endusage name "+endusagebean.getLabel());
				endusagearray.add(endusagebean);
			}
		}catch(Exception e){
			System.out.println("Result ERROR RESULT");
			e.printStackTrace();
		}finally{
			 con.close();
			 st.close();
			 rs.close();
	   }			
		return endusagearray;
	}

	@Override
	public ArrayList<TanneryDetails> getTannery(String term) throws SQLException {
		ArrayList<TanneryDetails> tanarraylist = new ArrayList<TanneryDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT tanid, tanname, tanaddr, tanattn, tanphone, tanfax  FROM elpro.tbl_tannery where tanname like '%"+term+"%' order by tanname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				TanneryDetails tanbean = new TanneryDetails();
				tanbean.setTanneryAddress(rs.getString("tanaddr"));
				tanbean.setTanneryAttention(rs.getString("tanattn"));
				tanbean.setTanneryFax(rs.getString("tanfax"));
				tanbean.setTanneryId(rs.getString("tanid"));
				tanbean.setTanneryName(rs.getString("tanname"));
				tanbean.setTanneryContactNo(rs.getString("tanphone"));
				System.out.println("Tan name "+tanbean.getTanneryName());
				tanarraylist.add(tanbean);
			}
			System.out.println("Tannery Name Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Tannery Result ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }			
		return tanarraylist;
	}

	@Override
	public ArrayList<CustomerDetails> getCustomer() throws SQLException {
		ArrayList<CustomerDetails> custrraylist = new ArrayList<CustomerDetails>();			
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	
		try{	con = DBConnection.getConnection();
		st = (Statement) con.createStatement();
		String sql = "SELECT custid, custname, custaddr, custattn, custphone, custfax, agentid, shortform FROM elpro.tbl_customer order by custname";
		rs = st.executeQuery(sql);
		while(rs.next()) {	
			CustomerDetails custbean = new CustomerDetails();
			custbean.setCustomerAddress(rs.getString("custaddr"));
			custbean.setCustomerAttention(rs.getString("custattn"));
			custbean.setCustomerFax(rs.getString("custfax"));
			custbean.setCustomerId(rs.getString("custid"));
			custbean.setCustomerName(rs.getString("custname"));
			custbean.setCustomerTelephone(rs.getString("custphone"));			
			System.out.println("Customer  name "+custbean.getCustomerName());
			custrraylist.add(custbean);
			}
		System.out.println("Customer Name Result Added Successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Customer Name ERROR RESULT");
		}finally{
			 con.close() ;
			 st.close();
			 rs.close();
	   }	
		return custrraylist;
	}

	@Override
	public List<AutoComplete> getDestination(String term) throws SQLException {
		List<AutoComplete> destarraylist = new ArrayList<AutoComplete>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT shortform, destname, destcountry FROM elpro.tbl_destination where destname like '%"+term+"%' order by destname";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {	
				//destarraylist.add(rs.getString("destname"));
				AutoComplete destbean = new AutoComplete();
				destbean.setLabel(rs.getString("destname"));	
				destbean.setValue(rs.getString("destcountry"));
				destbean.setShform(rs.getString("shortform"));
				//System.out.println("dest name "+destbean.getLabel());
				destarraylist.add(destbean);
				}
			System.out.println(" dest Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("dest ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return destarraylist;
	}

	@Override
	public ArrayList<PaymentDetails> getPayment(String term) throws SQLException {
		ArrayList<PaymentDetails> payarraylist = new ArrayList<PaymentDetails>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT payid, payname FROM tbl_payment where payname like '%"+term+"%' order by payname";
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				PaymentDetails paybean = new PaymentDetails();
				paybean.setLabel(rs.getString("payname"));
				paybean.setPaymentId(rs.getString("payid"));
				System.out.println("Payment name "+paybean.getPayment());
				payarraylist.add(paybean);
				}
			System.out.println("payname Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("payname ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return payarraylist;
	}

	@Override
	public ArrayList<SrfArticle> getSrfArticleDetails(String sampleno, String sidx, String sord)
			throws SQLException {
		ArrayList<SrfArticle> articlearray = new ArrayList<SrfArticle>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT articleid, articletype,articleshform, articlename, color, size, substance, selection, selectionp, quantity, pcs, unit, rate, colormatching, tapetest, crockingwet, crockingdry, fourfolds, keytest, sampleno, srfarticleid, user from tbl_srf_article where sampleno = '"+sampleno+"' order by "+sidx+"  "+sord+" ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {	
				SrfArticle artbean = new SrfArticle();
				artbean.setArticleid(rs.getString("articleid"));
				artbean.setSrf_articletype(rs.getString("articletype"));
				artbean.setSrf_articleshform(rs.getString("articleshform"));
				artbean.setSrf_articlename(rs.getString("articlename"));
				artbean.setSrf_color(rs.getString("color"));
				artbean.setSrf_size(rs.getString("size"));
				artbean.setSrf_substance(rs.getString("substance"));
				artbean.setSrf_selection(rs.getString("selection"));
				artbean.setSrf_selectionp(rs.getString("selectionp"));
				artbean.setSrf_qty(rs.getString("quantity"));
				artbean.setSrf_unit(rs.getString("unit"));
				artbean.setSrf_pieces(rs.getString("pcs"));
				artbean.setSrf_price(rs.getString("rate"));
				artbean.setSrf_colormatch(rs.getString("colormatching"));
				artbean.setSrf_tapetest(rs.getString("tapetest"));
				artbean.setSrf_crockwet(rs.getString("crockingwet"));
				artbean.setSrf_crockdry(rs.getString("crockingdry"));
				artbean.setSrf_fourfold(rs.getString("fourfolds"));
				artbean.setSrf_keytest(rs.getString("keytest"));
				artbean.setSrf_samplenum(rs.getString("sampleno"));
				artbean.setSrf_articleid(rs.getString("srfarticleid"));
				artbean.setUser(rs.getString("user"));
				articlearray.add(artbean);
			}
		}catch(Exception e){
				e.printStackTrace();
				System.out.println("ERROR RESULT");
		}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		}	
		return articlearray;	

	}

	@Override
	public boolean addsrfArticle(SrfArticle artindertdetail, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isadded = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_savesrfArticle = new StringBuffer("insert into tbl_srf_article (articleid, articletype, articleshform, articlename, color, size, substance, selection, selectionp, quantity,  unit, pcs, rate, colormatching, tapetest, crockingwet, crockingdry, fourfolds, keytest, sampleno, user)");
			sql_savesrfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_savesrfArticle = sql_savesrfArticle.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_savesrfArticle);
			pst.setString(1, artindertdetail.getArticleid());
			System.out.println("getArticleid " +artindertdetail.getArticleid());
			pst.setString(2, artindertdetail.getSrf_articletype());
			System.out.println("getSrf_articletype " +artindertdetail.getSrf_articletype());
			pst.setString(3, artindertdetail.getSrf_articleshform());
			pst.setString(4, artindertdetail.getSrf_articlename());
			pst.setString(5, artindertdetail.getSrf_color());
			pst.setString(6, artindertdetail.getSrf_size());
			pst.setString(7, artindertdetail.getSrf_substance());
			pst.setString(8, artindertdetail.getSrf_selection());
			pst.setString(9, artindertdetail.getSrf_selectionp());
			pst.setString(10, artindertdetail.getSrf_qty());	
			pst.setString(11, artindertdetail.getSrf_unit());
			pst.setString(12, artindertdetail.getSrf_pieces());			
			pst.setString(13, artindertdetail.getSrf_price());
			pst.setString(14, artindertdetail.getSrf_colormatch());
			pst.setString(15, artindertdetail.getSrf_tapetest());
			pst.setString(16, artindertdetail.getSrf_crockwet());
			pst.setString(17, artindertdetail.getSrf_crockdry());
			pst.setString(18, artindertdetail.getSrf_fourfold());
			pst.setString(19, artindertdetail.getSrf_keytest());
			pst.setString(20, artindertdetail.getSrf_samplenum());
			pst.setString(21, artindertdetail.getUser());
			
			System.out.println("getSrf_samplenum " +artindertdetail.getSrf_samplenum());
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully inserted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isadded = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }
	  return isadded;
	}

	@Override
	public boolean editsrfArticle(SrfArticle artindertdetail, String sidx,
			String sord) throws SQLException {
			Connection con = null;
			PreparedStatement pst = null;
			int noofrows  = 0;
			boolean isupdate = true;
			try{			
				con = DBConnection.getConnection();
				StringBuffer sql_updtsrfArticle = new StringBuffer("UPDATE elpro.tbl_srf_article SET articleid = ? , articletype = ? , articleshform = ? , articlename = ? , color = ? , size = ? , substance = ? , selection = ? , selectionp = ? , quantity = ? , unit = ? , pcs  = ? , rate = ? ,colormatching=?, tapetest=?, crockingwet=?, crockingdry=?, fourfolds=?, keytest=?, sampleno=?, user=? where srfarticleid = '"+artindertdetail.getSrf_articleid()+"' ");
				String sqlquery_updtsrfArticle = sql_updtsrfArticle.toString();
				pst = (PreparedStatement) con.prepareStatement(sqlquery_updtsrfArticle);
				pst.setString(1, artindertdetail.getArticleid());
				pst.setString(2, artindertdetail.getSrf_articletype());
				pst.setString(3, artindertdetail.getSrf_articleshform());
				pst.setString(4, artindertdetail.getSrf_articlename());
				pst.setString(5, artindertdetail.getSrf_color());
				pst.setString(6, artindertdetail.getSrf_size());
				pst.setString(7, artindertdetail.getSrf_substance());
				pst.setString(8, artindertdetail.getSrf_selection());
				pst.setString(9, artindertdetail.getSrf_selectionp());
				pst.setString(10, artindertdetail.getSrf_qty());
				pst.setString(11, artindertdetail.getSrf_unit());
				pst.setString(12, artindertdetail.getSrf_pieces());
				pst.setString(13, artindertdetail.getSrf_price());
				pst.setString(14, artindertdetail.getSrf_colormatch());							
				pst.setString(15, artindertdetail.getSrf_tapetest());				
				pst.setString(16, artindertdetail.getSrf_crockwet());
				pst.setString(17, artindertdetail.getSrf_crockdry());
				pst.setString(18, artindertdetail.getSrf_fourfold());
				pst.setString(19, artindertdetail.getSrf_keytest());
				pst.setString(20, artindertdetail.getSrf_samplenum());
				pst.setString(21, artindertdetail.getUser());
				
				
				noofrows = pst.executeUpdate();
				System.out.println("Sucessfully inserted the record.." + noofrows);
			}catch(Exception e){
				e.printStackTrace();
				isupdate = false;
				System.out.println("ERROR RESULT");
			}finally{
				 con.close() ;
				 pst.close();
		   }	
		//return noofrows;
			return isupdate;
	}

	@Override
	public boolean delsrfArticle(SrfArticle artindertdetail, String sidx,
			String sord) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isdel = true;
		try{			
			con = DBConnection.getConnection();
			StringBuffer sql_delsrfArticle = new StringBuffer("delete from elpro.tbl_srf_article WHERE srfarticleid = '"+artindertdetail.getSrf_articleid()+"' ");
			String sqlquery_delsrfArticle = sql_delsrfArticle.toString();
			System.out.println(sqlquery_delsrfArticle);
			pst = (PreparedStatement) con.prepareStatement(sqlquery_delsrfArticle);
			noofrows = pst.executeUpdate();
			System.out.println("Sucessfully deleted the record.." + noofrows);
		}catch(Exception e){
			e.printStackTrace();
			isdel = false;
			System.out.println("ERROR RESULT");
		}finally{
			 con.close() ;
			 pst.close();
	   }	
	//return noofrows;
		return isdel;
	}

	@Override
	public List<SampleRequest> getEditSrfFormDetails(String sampleno)
			throws SQLException {
		List<SampleRequest> editsrfformlist = new ArrayList<SampleRequest>() ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{			
			con = DBConnection.getConnection();
			st = (Statement) con.createStatement();
			String sql = "SELECT sampleno, agentid, orderdt, refno, priority, handledby, customerid, tanneryid, deliverid, destination, terms, add_date, cdd_date, splcdn, inspcdn, forwaderid, isinvraised FROM elpro.tbl_srfform where sampleno ='"+sampleno+"' ";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			if(rs.next()) {	
				SampleRequest editsrfformbean = new SampleRequest();
				editsrfformbean.setSrf_sampleno(rs.getString("sampleno"));
				editsrfformbean.setSrf_agentname(rs.getString("agentid"));
				editsrfformbean.setSrf_orderdate(rs.getString("orderdt"));
				System.out.println("DT "+editsrfformbean.getSrf_orderdate());
				editsrfformbean.setSrf_referenceno(rs.getString("refno"));
				editsrfformbean.setSrf_priority(rs.getString("priority"));
				editsrfformbean.setSrf_handledby(rs.getString("handledby"));
				editsrfformbean.setSrf_custname(rs.getString("customerid"));
				editsrfformbean.setSrf_tanname(rs.getString("tanneryid"));
				editsrfformbean.setSrf_deliver(rs.getString("deliverid"));
				editsrfformbean.setSrf_destination(rs.getString("destination"));
				editsrfformbean.setSrf_paymentterms(rs.getString("terms"));
				editsrfformbean.setSrf_add(rs.getString("add_date"));
				editsrfformbean.setSrf_cdd(rs.getString("cdd_date"));
				editsrfformbean.setSrf_splcdn(rs.getString("splcdn"));
				editsrfformbean.setSrf_inspcdn(rs.getString("inspcdn"));
				//editsrfformbean.setSrf_(rs.getString("forwaderid"));
				editsrfformbean.setSrf_isSample(rs.getString("isinvraised"));
				editsrfformlist.add(editsrfformbean);
				}
			System.out.println(" dest Result Added Successfully");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("dest ERROR RESULT");
			}finally{
				 con.close() ;
				 st.close();
				 rs.close();
		   }	
		return editsrfformlist;
	}

	/* (non-Javadoc)
	 * @see sb.elpro.dao.SrfDao#savePrfForm(sb.elpro.model.SampleRequest)
	 */
	@Override
	public boolean saveSrfForm(SampleRequest srfbean) throws SQLException {
		System.out.println("In PRF SAVE");
		Connection con = null;
		PreparedStatement pst = null;
		int noofrows  = 0;
		boolean isSaved =true;
		
		try{
			con = DBConnection.getConnection();
			StringBuffer sql_savesrfArticle = new StringBuffer("insert into tbl_srfform (sampleno, agentid, orderdt, refno, priority, handledby, customerid, tanneryid, deliverid, destination, endusage, terms, add_date, cdd_date, splcdn, inspcdn, forwaderid, isinvraised)");
			sql_savesrfArticle.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sqlquery_savesrfArticle = sql_savesrfArticle.toString();
			pst = (PreparedStatement) con.prepareStatement(sqlquery_savesrfArticle);
			pst.setString(1, srfbean.getSrf_sampleno());
			System.out.println("getSrf_sampleno " +srfbean.getSrf_sampleno());
			pst.setString(2, srfbean.getSrf_agentname());
			System.out.println("getPrf_agentname " +srfbean.getSrf_agentname());
			pst.setString(3, srfbean.getSrf_orderdate());
			pst.setString(4, srfbean.getSrf_poreftype() +", "+ srfbean.getSrf_referenceno());
			pst.setString(5, srfbean.getSrf_priority());
			pst.setString(6, srfbean.getSrf_handledby());
			pst.setString(7, srfbean.getSrf_customer());
			pst.setString(8, srfbean.getSrf_tanname());
			pst.setString(9, srfbean.getSrf_deliver());
			pst.setString(10, srfbean.getSrf_destination());
			pst.setString(11, srfbean.getSrf_endusage());
			pst.setString(12, srfbean.getSrf_paymentterms());
			pst.setString(13, srfbean.getSrf_add());
			pst.setString(14, srfbean.getSrf_cdd());
			pst.setString(15, srfbean.getSrf_splcdn());
			pst.setString(16, srfbean.getSrf_inspcdn());
			pst.setString(17, srfbean.getSrf_forwarder());
			pst.setString(18, srfbean.getSrf_isSample());
			noofrows = pst.executeUpdate();
			
			System.out.println("Sucessfully inserted the record.." + noofrows);
	}catch(Exception e){
		e.printStackTrace();
		isSaved = false;
		System.out.println("ERROR RESULT");
	}finally{
		 con.close() ;
		 pst.close();
   }	
		return isSaved;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
