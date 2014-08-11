/**
 * 
 */
package sb.elpro.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Wahab
 *
 */
public class InspectionForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1326268577180737805L;
	private String id; 
	private String insptype;
	private String inspid; //inspection id
	private String inspContractNo;
	private String inspdate;
	private String inspqualityctrlr;
	private String insp_cdn;
	private String inspcomments;
	
	private String articleid;	
	private String artidhidden;	
	private String articlehidden;
	private String colorhidden;
	private String sizehidden;
	private String substancehidden;
	private String selhidden;
	private String quantityhidden;
	private String custhidden;
	private String tanhidden;
	private String ctdthidden;
	
	//Manual test 
	private String testid;
	private String testtype;
	
	private String testedpcs; 
	private String result;
	private String comments;
	
	private String article;
	private String colortest;
	private String subs;
	private String tearstrength;
	private String grainbreak;
	private String crockingdry;
	private String crockingwet;
	private String finishadhension;
	private String fourfold;
	private String crosssection;
	private String organoleptic;
	
	//Grade
	private String gradeid;
	private String gradecolor;
	private String grade;
	private String skincount;
	private String percent;
	private String comment;
	
	/*private String contractno;
	private String inspectionid;
	private String qualityctrl;
	private String grade1skincount;
	private String grade2skincount;
	private String grade3skincount;
	private String grade4skincount;
	private String grade5skincount;
	private String grade1percent;
	private String grade2percent;
	private String grade3percent;
	private String grade4percent;
	private String grade5percent;
	private String grade1comments;
	private String grade2comments;
	private String grade3comments;
	private String grade4comments;
	private String grade5comments;*/


	// Rejects 
	private String rejectid;
	private String arttype;
	private String rejcolor;
	private String totinspected;
	private String totpassed;
	private String totrejects;
	private String subsrejects;
	private String sizerejects;
	private String selecrejects;
	private String colorrejects;
	private String orgrejects;
	private String otherrejects;
	private String grtotinspected;
	private String rjtotinspected;
	private String status;
	
	private String inspaction;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the inspid
	 */
	
	/**
	 * @return the inspContractNo
	 */
	public String getInspContractNo() {
		return inspContractNo;
	}
	/**
	 * @param inspContractNo the inspContractNo to set
	 */
	public void setInspContractNo(String inspContractNo) {
		this.inspContractNo = inspContractNo;
	}
	/**
	 * @return the inspdate
	 */
	public String getInspdate() {
		return inspdate;
	}
	/**
	 * @param inspdate the inspdate to set
	 */
	public void setInspdate(String inspdate) {
		this.inspdate = inspdate;
	}
	/**
	 * @return the inspqualityctrlr
	 */
	public String getInspqualityctrlr() {
		return inspqualityctrlr;
	}
	/**
	 * @param inspqualityctrlr the inspqualityctrlr to set
	 */
	public void setInspqualityctrlr(String inspqualityctrlr) {
		this.inspqualityctrlr = inspqualityctrlr;
	}
	/**
	 * @return the insp_cdn
	 */
	public String getInsp_cdn() {
		return insp_cdn;
	}
	/**
	 * @param insp_cdn the insp_cdn to set
	 */
	public void setInsp_cdn(String insp_cdn) {
		this.insp_cdn = insp_cdn;
	}
	/**
	 * @return the articleid
	 */
	public String getArticleid() {
		return articleid;
	}
	/**
	 * @param articleid the articleid to set
	 */
	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}
	
	
	/**
	 * @return the testid
	 */
	public String getTestid() {
		return testid;
	}
	/**
	 * @param testid the testid to set
	 */
	public void setTestid(String testid) {
		this.testid = testid;
	}
	/**
	 * @return the testtype
	 */
	public String getTesttype() {
		return testtype;
	}
	/**
	 * @param testtype the testtype to set
	 */
	public void setTesttype(String testtype) {
		this.testtype = testtype;
	}
	/**
	 * @return the testedpcs
	 */
	public String getTestedpcs() {
		return testedpcs;
	}
	/**
	 * @param testedpcs the testedpcs to set
	 */
	public void setTestedpcs(String testedpcs) {
		this.testedpcs = testedpcs;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the article
	 */
	public String getArticle() {
		return article;
	}
	/**
	 * @param article the article to set
	 */
	public void setArticle(String article) {
		this.article = article;
	}
	/**
	 * @return the colortest
	 */
	public String getColortest() {
		return colortest;
	}
	/**
	 * @param colortest the colortest to set
	 */
	public void setColortest(String colortest) {
		this.colortest = colortest;
	}
	/**
	 * @return the subs
	 */
	public String getSubs() {
		return subs;
	}
	/**
	 * @param subs the subs to set
	 */
	public void setSubs(String subs) {
		this.subs = subs;
	}
	/**
	 * @return the tearstrength
	 */
	public String getTearstrength() {
		return tearstrength;
	}
	/**
	 * @param tearstrength the tearstrength to set
	 */
	public void setTearstrength(String tearstrength) {
		this.tearstrength = tearstrength;
	}
	/**
	 * @return the grainbreak
	 */
	public String getGrainbreak() {
		return grainbreak;
	}
	/**
	 * @param grainbreak the grainbreak to set
	 */
	public void setGrainbreak(String grainbreak) {
		this.grainbreak = grainbreak;
	}
	/**
	 * @return the crockingdry
	 */
	public String getCrockingdry() {
		return crockingdry;
	}
	/**
	 * @param crockingdry the crockingdry to set
	 */
	public void setCrockingdry(String crockingdry) {
		this.crockingdry = crockingdry;
	}
	/**
	 * @return the crockingwet
	 */
	public String getCrockingwet() {
		return crockingwet;
	}
	/**
	 * @param crockingwet the crockingwet to set
	 */
	public void setCrockingwet(String crockingwet) {
		this.crockingwet = crockingwet;
	}
	/**
	 * @return the finishadhension
	 */
	public String getFinishadhension() {
		return finishadhension;
	}
	/**
	 * @param finishadhension the finishadhension to set
	 */
	public void setFinishadhension(String finishadhension) {
		this.finishadhension = finishadhension;
	}
	/**
	 * @return the fourfold
	 */
	public String getFourfold() {
		return fourfold;
	}
	/**
	 * @param fourfold the fourfold to set
	 */
	public void setFourfold(String fourfold) {
		this.fourfold = fourfold;
	}
	/**
	 * @return the crosssection
	 */
	public String getCrosssection() {
		return crosssection;
	}
	/**
	 * @param crosssection the crosssection to set
	 */
	public void setCrosssection(String crosssection) {
		this.crosssection = crosssection;
	}
	/**
	 * @return the organoleptic
	 */
	public String getOrganoleptic() {
		return organoleptic;
	}
	/**
	 * @param organoleptic the organoleptic to set
	 */
	public void setOrganoleptic(String organoleptic) {
		this.organoleptic = organoleptic;
	}
	/**
	 * @return the gradeid
	 */
	public String getGradeid() {
		return gradeid;
	}
	/**
	 * @param gradeid the gradeid to set
	 */
	public void setGradeid(String gradeid) {
		this.gradeid = gradeid;
	}
	/**
	 * @return the gradecolor
	 */
	public String getGradecolor() {
		return gradecolor;
	}
	/**
	 * @param gradecolor the gradecolor to set
	 */
	public void setGradecolor(String gradecolor) {
		this.gradecolor = gradecolor;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * @return the skincount
	 */
	public String getSkincount() {
		return skincount;
	}
	/**
	 * @param skincount the skincount to set
	 */
	public void setSkincount(String skincount) {
		this.skincount = skincount;
	}
	/**
	 * @return the percent
	 */
	public String getPercent() {
		return percent;
	}
	/**
	 * @param percent the percent to set
	 */
	public void setPercent(String percent) {
		this.percent = percent;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the rejectid
	 */
	public String getRejectid() {
		return rejectid;
	}
	/**
	 * @param rejectid the rejectid to set
	 */
	public void setRejectid(String rejectid) {
		this.rejectid = rejectid;
	}
	/**
	 * @return the arttype
	 */
	public String getArttype() {
		return arttype;
	}
	/**
	 * @param arttype the arttype to set
	 */
	public void setArttype(String arttype) {
		this.arttype = arttype;
	}
	/**
	 * @return the rejcolor
	 */
	public String getRejcolor() {
		return rejcolor;
	}
	/**
	 * @param rejcolor the rejcolor to set
	 */
	public void setRejcolor(String rejcolor) {
		this.rejcolor = rejcolor;
	}
	/**
	 * @return the totinspected
	 */
	public String getTotinspected() {
		return totinspected;
	}
	/**
	 * @param totinspected the totinspected to set
	 */
	public void setTotinspected(String totinspected) {
		this.totinspected = totinspected;
	}
	/**
	 * @return the totpassed
	 */
	public String getTotpassed() {
		return totpassed;
	}
	/**
	 * @param totpassed the totpassed to set
	 */
	public void setTotpassed(String totpassed) {
		this.totpassed = totpassed;
	}
	/**
	 * @return the totrejects
	 */
	public String getTotrejects() {
		return totrejects;
	}
	/**
	 * @param totrejects the totrejects to set
	 */
	public void setTotrejects(String totrejects) {
		this.totrejects = totrejects;
	}
	/**
	 * @return the subsrejects
	 */
	public String getSubsrejects() {
		return subsrejects;
	}
	/**
	 * @param subsrejects the subsrejects to set
	 */
	public void setSubsrejects(String subsrejects) {
		this.subsrejects = subsrejects;
	}
	/**
	 * @return the sizerejects
	 */
	public String getSizerejects() {
		return sizerejects;
	}
	/**
	 * @param sizerejects the sizerejects to set
	 */
	public void setSizerejects(String sizerejects) {
		this.sizerejects = sizerejects;
	}
	/**
	 * @return the selecrejects
	 */
	public String getSelecrejects() {
		return selecrejects;
	}
	/**
	 * @param selecrejects the selecrejects to set
	 */
	public void setSelecrejects(String selecrejects) {
		this.selecrejects = selecrejects;
	}
	/**
	 * @return the colorrejects
	 */
	public String getColorrejects() {
		return colorrejects;
	}
	/**
	 * @param colorrejects the colorrejects to set
	 */
	public void setColorrejects(String colorrejects) {
		this.colorrejects = colorrejects;
	}
	/**
	 * @return the orgrejects
	 */
	public String getOrgrejects() {
		return orgrejects;
	}
	/**
	 * @param orgrejects the orgrejects to set
	 */
	public void setOrgrejects(String orgrejects) {
		this.orgrejects = orgrejects;
	}
	/**
	 * @return the otherrejects
	 */
	public String getOtherrejects() {
		return otherrejects;
	}
	/**
	 * @param otherrejects the otherrejects to set
	 */
	public void setOtherrejects(String otherrejects) {
		this.otherrejects = otherrejects;
	}
	/**
	 * @return the rjtotinspected
	 */
	public String getRjtotinspected() {
		return rjtotinspected;
	}
	/**
	 * @param rjtotinspected the rjtotinspected to set
	 */
	public void setRjtotinspected(String rjtotinspected) {
		this.rjtotinspected = rjtotinspected;
	}
	/**
	 * @return the grtotinspected
	 */
	public String getGrtotinspected() {
		return grtotinspected;
	}
	/**
	 * @param grtotinspected the grtotinspected to set
	 */
	public void setGrtotinspected(String grtotinspected) {
		this.grtotinspected = grtotinspected;
	}
	/**
	 * @return the inspcomments
	 */
	public String getInspcomments() {
		return inspcomments;
	}
	/**
	 * @param inspcomments the inspcomments to set
	 */
	public void setInspcomments(String inspcomments) {
		this.inspcomments = inspcomments;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		System.out.println(" IN RESET INSPECTION FORM");
		id=""; 
		inspid =""; //inspection id
		inspContractNo="";
		inspdate="";
		inspqualityctrlr="";
		insp_cdn="";
		inspcomments="";
		
		articleid="";		
		
		//Manual test 
		testid="";
		testtype="";
		
		testedpcs=""; 
		result="";
		comments="";
		
		article="";
		colortest="";
		subs="";
		tearstrength="";
		grainbreak="";
		crockingdry="";
		crockingwet="";
		finishadhension="";
		fourfold="";
		crosssection="";
		organoleptic="";
		
		//Grade
		gradeid="";
		gradecolor="";
		grade="";
		skincount="";
		percent="";
		comment="";
		
		/*contractno="";
		inspectionid="";
		qualityctrl="";
		grade1skincount="";
		grade2skincount="";
		grade3skincount="";
		grade4skincount="";
		grade5skincount="";
		grade1percent="";
		grade2percent="";
		grade3percent="";
		grade4percent="";
		grade5percent="";
		grade1comments="";
		grade2comments="";
		grade3comments="";
		grade4comments="";
		grade5comments="";*/
		
		
		// Rejects 
		rejectid="";
		arttype="";
		rejcolor="";
		totinspected="";
		totpassed="";
		totrejects="";
		subsrejects="";
		sizerejects="";
		selecrejects="";
		colorrejects="";
		orgrejects="";
		otherrejects="";
		
		
		grtotinspected="";
		rjtotinspected="";
		status="";
		
		inspaction="";
	}

	/**
	 * @return the artidhidden
	 */
	public String getArtidhidden() {
		return artidhidden;
	}
	/**
	 * @param artidhidden the artidhidden to set
	 */
	public void setArtidhidden(String artidhidden) {
		this.artidhidden = artidhidden;
	}
	/**
	 * @return the articlehidden
	 */
	public String getArticlehidden() {
		return articlehidden;
	}
	/**
	 * @param articlehidden the articlehidden to set
	 */
	public void setArticlehidden(String articlehidden) {
		this.articlehidden = articlehidden;
	}
	/**
	 * @return the colorhidden
	 */
	public String getColorhidden() {
		return colorhidden;
	}
	/**
	 * @param colorhidden the colorhidden to set
	 */
	public void setColorhidden(String colorhidden) {
		this.colorhidden = colorhidden;
	}
	/**
	 * @return the sizehidden
	 */
	public String getSizehidden() {
		return sizehidden;
	}
	/**
	 * @param sizehidden the sizehidden to set
	 */
	public void setSizehidden(String sizehidden) {
		this.sizehidden = sizehidden;
	}
	/**
	 * @return the substancehidden
	 */
	public String getSubstancehidden() {
		return substancehidden;
	}
	/**
	 * @param substancehidden the substancehidden to set
	 */
	public void setSubstancehidden(String substancehidden) {
		this.substancehidden = substancehidden;
	}
	/**
	 * @return the selhidden
	 */
	public String getSelhidden() {
		return selhidden;
	}
	/**
	 * @param selhidden the selhidden to set
	 */
	public void setSelhidden(String selhidden) {
		this.selhidden = selhidden;
	}
	/**
	 * @return the quantityhidden
	 */
	public String getQuantityhidden() {
		return quantityhidden;
	}
	/**
	 * @param quantityhidden the quantityhidden to set
	 */
	public void setQuantityhidden(String quantityhidden) {
		this.quantityhidden = quantityhidden;
	}
	/**
	 * @return the custhidden
	 */
	public String getCusthidden() {
		return custhidden;
	}
	/**
	 * @param custhidden the custhidden to set
	 */
	public void setCusthidden(String custhidden) {
		this.custhidden = custhidden;
	}
	/**
	 * @return the tanhidden
	 */
	public String getTanhidden() {
		return tanhidden;
	}
	/**
	 * @param tanhidden the tanhidden to set
	 */
	public void setTanhidden(String tanhidden) {
		this.tanhidden = tanhidden;
	}
	/**
	 * @return the ctdthidden
	 */
	public String getCtdthidden() {
		return ctdthidden;
	}
	/**
	 * @param ctdthidden the ctdthidden to set
	 */
	public void setCtdthidden(String ctdthidden) {
		this.ctdthidden = ctdthidden;
	}
	/**
	 * @return the insptype
	 */
	public String getInsptype() {
		return insptype;
	}
	/**
	 * @param insptype the insptype to set
	 */
	public void setInsptype(String insptype) {
		this.insptype = insptype;
	}
	/**
	 * @return the inspid
	 */
	public String getInspid() {
		return inspid;
	}
	/**
	 * @param inspid the inspid to set
	 */
	public void setInspid(String inspid) {
		this.inspid = inspid;
	}
	/**
	 * @return the inspaction
	 */
	public String getInspaction() {
		return inspaction;
	}
	/**
	 * @param inspaction the inspaction to set
	 */
	public void setInspaction(String inspaction) {
		this.inspaction = inspaction;
	}
}

