package com.model.shopping;

public class Orders 
{
	private int oid;
	private int cid;
	private int cart_id;
	private int aid;
	private int ordered_qty;
	private double total_price;
	private int date_added;
	public Orders() {
		super();
	}
	/**
	 * 
	 * @return oid
	 */
	public int getOid() {
		return oid;
	}
	/**
	 * 
	 * @param oid
	 *  Return void
	 * Set values into class private variable oid
	 */
	public void setOid(int oid) {
		this.oid = oid;
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
	 * Return void
	 * Set values into class private variable cid
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}
	/**
	 * 
	 * @return cart_id
	 */
	public int getCart_id() {
		return cart_id;
	}
	/**
	 * 
	 * @param cart_id
	 *   Return void
	 * Set values into class private variable cart_id
	 */
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
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
	 *  Return void
	 * Set values into class private variable aid
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}
	/**
	 * 
	 * @return ordered_qty
	 */
	public int getOrdered_qty() {
		return ordered_qty;
	}
	/**
	 * 
	 * @param ordered_qty
	 *  Return void
	 * Set values into class private variable ordered_qty
	 * 
	 */
	public void setOrdered_qty(int ordered_qty) {
		this.ordered_qty = ordered_qty;
	}
	/**
	 * 
	 * @return total_price
	 */
	public double getTotal_price() {
		return total_price;
	}
	/**
	 * 
	 * @param total_price
	 * Return void
	 * Set values into class private variable total_price
	 */
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	/**
	 * 
	 * @return date_added
	 */
	public int getDate_added() {
		return date_added;
	}
	/**
	 * 
	 * @param date_added
	 * Return void
	 * Set values into class private variable date_added
	 */
	public void setDate_added(int date_added) {
		this.date_added = date_added;
	}
	
	
}
