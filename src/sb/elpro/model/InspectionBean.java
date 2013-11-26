/**
 * 
 */
package sb.elpro.model;

import java.io.Serializable;

/**
 * @author Wahab
 *
 */
public class InspectionBean implements Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -5064888768604040704L;
	
	private String id; 
	private String inspid; //inspection id
	private String inspContractNo;
	private String inspdate;
	private String inspqualityctrlr;
	private String inspcdn;
	private String inspcomments;
	
	private String articleid;		
	private String color;
	
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
	private String rejectsid;
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
	public String getInspcdn() {
		return inspcdn;
	}
	/**
	 * @param insp_cdn the insp_cdn to set
	 */
	public void setInspcdn(String inspcdn) {
		this.inspcdn = inspcdn;
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
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
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
	/**
	 * @return the rejectsid
	 */
	public String getRejectsid() {
		return rejectsid;
	}
	/**
	 * @param rejectsid the rejectsid to set
	 */
	public void setRejectsid(String rejectsid) {
		this.rejectsid = rejectsid;
	}
	
	


}
