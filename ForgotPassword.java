package com.model.shopping;

public class ForgotPassword {
	private String email;
	private String question;
	private String answer;
	private String password;
	
	public ForgotPassword() {
		super();
	}
	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @param email
	 * Return void
	 * Set values into class private variable email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * 
	 * @param question
	 *  Return void
	 * Set values into class private variable question
	 */
	public void setQuestion(String question) {
		this.question = question;
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
	 *  Return void
	 * Set values into class private variable answer
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password
	 *   Return void
	 * Set values into class private variable password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
