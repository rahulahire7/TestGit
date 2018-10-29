package com.model.shopping;

public class Customer {
	private int cid;
	private String cname;
	private String cemail;
	private long cmobile;
	private String cpass;
	private String questions;
	private String answer;
	private Address add;
	
	public Customer() {
		super();
	}
	/**
	 * 
	 * @return cmobile
	 */
	public long getCmobile() {
		return cmobile;
	}
/**
 * 
 * @param cmobile
 *  Return void
	 * Set values into class private variable cmobile
 */
	public void setCmobile(long cmobile) {
		this.cmobile = cmobile;
	}
/**
 * 
 * @return cid
 */
	public int getCid() {
		return cid;
	}
	/**
	 * 
	 * @param cid
	 *  Return void
	 * Set values into class private variable cid
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}
	/**
	 * 
	 * @return cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * 
	 * @param cname
	 *  Return void
	 * Set values into class private variable cname
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * 
	 * @return cemail
	 */
	public String getCemail() {
		return cemail;
	}
	/**
	 * 
	 * @param cemail
	 *  Return void
	 * Set values into class private variable cemail
	 */
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	/**
	 * 
	 * @return cpass
	 */

	public String getCpass() {
		return cpass;
	}
	/**
	 * 
	 * @param cpass
	 *  Return void
	 * Set values into class private variable cpass
	 */
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	/**
	 * 
	 * @return questions
	 * 
	 */

	public String getQuestions() {
		return questions;
	}
	/**
	 * 
	 * @param questions
	 *  Return void
	 * Set values into class private variable questions
	 */

	public void setQuestions(String questions) {
		this.questions = questions;
	}
	/**
	 * 
	 * @return answer
	 */

	public String getAnswer() {
		return answer;
	}
	/**
	 * 
	 * @param answer
	 * Return void
	 * Set values into class private variable answer
	 */

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 
	 * @return add
	 */

	public Address getAdd() {
		return add;
	}
	/**
	 * 
	 * @param add
	 *  Return void
	 * Set values into class private variable add
	 */

	public void setAdd(Address add) {
		this.add = add;
	}
	/**
	 * To Display Object in form of String
	 */
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cmobile=" + cmobile + ", cpass="
				+ cpass + ", questions=" + questions + ", answer=" + answer + "]";
	}

	
	}
	
	

