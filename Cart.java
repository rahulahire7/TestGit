package com.model.shopping;

public class Cart {
	private int cartid;
	private String cartimage ;
	private int custid;
	private String cartname;
	private double cartprice;
	private int cartquantity; 
	private double carttotal;
	
	public Cart() {
		super();
	}
	/**
	 * 
	 * @return custid
	 */
	public int getCustid() {
		return custid;
	}
	/**
	 * 
	 * @param custid
	 * Return void
	 * Set values into class private variable custid
	 */
	public void setCustid(int custid) {
		this.custid = custid;
	}
	/**
	 * 
	 * @return cartid
	 */
	public int getCartid() {
		return cartid;
	}
	/**
	 * 
	 * @param cartid
	 * Return void
	 * Set values into class private variable cartid
	 */
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	/**
	 * 
	 * @return cartimage
	 */
	public String getCartimage() {
		return cartimage;
	}
	/**
	 * 
	 * @param cartimage
	 *  Return void
	 * Set values into class private variable cartimage
	 */
	public void setCartimage(String cartimage) {
		this.cartimage = cartimage;
	}
	/**
	 * 
	 * @return cartname
	 */
	public String getCartname() {
		return cartname;
	}
	/**
	 * 
	 * @param cartname
	 *  Return void
	 * Set values into class private variable cartimage
	 */
	public void setCartname(String cartname) {
		this.cartname = cartname;
	}
	/**
	 * 
	 * @return cartprice
	 */
	public double getCartprice() {
		return cartprice;
	}
	/**
	 * 
	 * @param cartprice
	 *  Return void
	 * Set values into class private variable cartprice
	 */
	public void setCartprice(double cartprice) {
		this.cartprice = cartprice;
	}
	/**
	 * 
	 * @return cartquantity
	 */
	public int getCartquantity() {
		return cartquantity;
		}
	/**
	 * 
	 * @param cartquantity
	 *  Return void
	 * Set values into class private variable cartquantity
	 */
	public void setCartquantity(int cartquantity) {
		this.cartquantity = cartquantity;
	}
	/**
	 * 
	 * @return carttotal
	 */
	public double getCarttotal() {
		return carttotal;
	}
	/**
	 * 
	 * @param carttotal
	 *  Return void
	 * Set values into class private variable carttotal
	 */
	public void setCarttotal(double carttotal) {
		this.carttotal = carttotal;
	}
	/**
	 * To Display Object in form of String
	 */
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", cartimage=" + cartimage + ", cartname=" + cartname + ", cartprice="
				+ cartprice + ", cartquantity=" + cartquantity + ", carttotal=" + carttotal + "]";
	}
	

}
