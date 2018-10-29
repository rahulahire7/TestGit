package com.model.shopping;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable 
{
	private int pid;
	private String pname;
	private double pprice;
	private String pcategory;
	private String pcolor;
	private String pbrand;
	private String pimage1;
	private String pimage2;
	private String pimage3;
	private String product_size;
	private int stock_qty;
	
	public Product() {
		super();
	}
	/**
	 * 
	 * @return pid
	 */
	public int getPid() {
		return pid;
	}
	/**
	 * 
	 * @param pid
	 *  Return void
	 * Set values into class private variable pid
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}
	/**
	 * 
	 * @return pname
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * 
	 * @param pname
	 *   Return void
	 * Set values into class private variable pname
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
/**
 * 
 * @return pprice
 */
	public double getPprice() {
		return pprice;
	}
	/**
	 * 
	 * @param pprice
	 *  Return void
	 * Set values into class private variable pprice
	 */
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	/**
	 * 
	 * @return pcategory
	 */
	public String getPcategory() {
		return pcategory;
	}
	/**
	 * 
	 * @param pcategory
	 *  Return void
	 * Set values into class private variable pcolor
	 */
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	/**
	 * 
	 * @return pcolor
	 */
	public String getPcolor() {
		return pcolor;
	}
	/**
	 * 
	 * @param pcolor
	 *    Return void
	 * Set values into class private variable pcolor
	 */
	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}
	/**
	 * 
	 * @return pbrand
	 */
	public String getPbrand() {
		return pbrand;
	}
	/**
	 * 
	 * @param pbrand
	 *    Return void
	 * Set values into class private variable pbrand
	 */
	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}

	/**
	 * 
	 * @return pimage1
	 */
	public String getPimage1() {
		return pimage1;
	}
	/**
	 * 
	 * @param pimage1
	 *   Return void
	 * Set values into class private variable pimage1
	 */
	public void setPimage1(String pimage1) {
		this.pimage1 = pimage1;
	}
	/**
	 * 
	 * @return pimage2
	 */
	public String getPimage2() {
		return pimage2;
	}
	/**
	 * 
	 * @param pimage2
	 *   Return void
	 * Set values into class private variable pimage2
	 * 
	 */
	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}
	/**
	 * 
	 * @return pimage3
	 */
	public String getPimage3() {
		return pimage3;
	}
	/**
	 * 
	 * @param pimage3
	 *   Return void
	 * Set values into class private variable pimage3
	 */
	public void setPimage3(String pimage3) {
		this.pimage3 = pimage3;
	}
	/**
	 * 
	 * @return product_size
	 */
	public String getProduct_size() {
		return product_size;
	}
	/**
	 * 
	 * @param product_size
	 *  Return void
	 * Set values into class private variable product_size
	 * 
	 */
	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}
	/**
	 * 
	 * @return stock_qty
	 */
	public int getStock_qty() {
		return stock_qty;
	}
	/**
	 * 
	 * @param stock_qty
	 * Return void
	 * Set values into class private variable stock_qty
	 */
	public void setStock_qty(int stock_qty) {
		this.stock_qty = stock_qty;
	}
	/**
	 * To Display Object in form of String
	 */
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pcategory=" + pcategory
				+ ", pcolor=" + pcolor + ", pbrand=" + pbrand + ", pimage1=" + pimage1 + ", pimage2=" + pimage2
				+ ", pimage3=" + pimage3 + ", product_size=" + product_size + ", stock_qty=" + stock_qty + "]";
	}
	
	

	
}
