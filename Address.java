package com.model.shopping;

public class Address 
{
	private int aid;
	private int custId;
	private String addressline1;
	private String addressline2;
	private String city;
	private long pincode;
	private String state;
	private String country;
	
	public Address() 
	{
		super();
	}
/**
 * 
 * @return aid
 */
	public int getAid() {
		return aid;
	}
/**
 * 
 * @param aid 
 * Return void
 * Set values into class private variable aid
 */
	public void setAid(int aid) {
		this.aid = aid;
	}
	/**
	 * 
	 * @return custId
	 */
	public int getCustId() {
		return custId;
	}
/**
 * 
 * @param custId
 * Return void
 * Set values into class  private variable custId
 */
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
/**
 * 
 * @return addressline1
 */
public String getAddressline1() {
		return addressline1;
	}
/**
 * 
 * @param addressline1
 * Return void
 * Set values into class  private variable addressline2
 * 
 */
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
/**
 * 
 * @return addressline2
 */
	public String getAddressline2() {
		return addressline2;
	}
/**
 * 
 * @param addressline2
 * Return void
 * Set values into class  private variable addressline2
 */
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
/**
 * 
 * @return city
 */
	public String getCity() {
		return city;
	}
/**
 * 
 * @param city
 * Return void
 * Set values into class  private variable city
 */
	public void setCity(String city) {
		this.city = city;
	}
/**
 * 
 * @return pincode
 */
	public long getPincode() {
		return pincode;
	}
/**
 * 
 * @param pincode
 * Return void
 * Set values into class  private variable pincode
 */
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
/**
 * 
 * @return state
 */
	public String getState() {
		return state;
	}
/**
 * 
 * @param state
 * Return void
 * Set values into class  private variable state
 */
	public void setState(String state) {
		this.state = state;
	}
/**
 * 
 * @return country
 */
	public String getCountry() {
		return country;
	}
/**
 * 
 * @param country
  * Return void
 * Set values into class  private variable country
 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
