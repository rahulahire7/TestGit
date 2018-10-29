package com.model.shopping;

public class Wishlist
{
private int wish_id;
private int pid;
private String wishimage;
private String wishname;
private double wishprice;
private int wishquantity;

public Wishlist() {
	super();
}
public int getWish_id() {
	return wish_id;
}
public void setWish_id(int wish_id) {
	this.wish_id = wish_id;
}

public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getWishimage() {
	return wishimage;
}
public void setWishimage(String wishimage) {
	this.wishimage = wishimage;
}
public String getWishname() {
	return wishname;
}
public void setWishname(String wishname) {
	this.wishname = wishname;
}
public double getWishprice() {
	return wishprice;
}
public void setWishprice(double wishprice) {
	this.wishprice = wishprice;
}
public int getWishquantity() {
	return wishquantity;
}
public void setWishquantity(int wishquantity) {
	this.wishquantity = wishquantity;
}
@Override
public String toString() {
	return "Wishlist [wish_id=" + wish_id + ", wishimage=" + wishimage + ", wishname=" + wishname + ", wishprice="
			+ wishprice + ", wishquantity=" + wishquantity + "]";
}

}
