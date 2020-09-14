package ven.spring.mall.model;

import java.sql.Date;

public class WishListVO {
	
	private int wishlist_num;
	private String mem_id;
	private int item_num;
	private int wishlist_stock;
	private Date wishlist_date;
	
	
	public int getWishlist_num() {
		return wishlist_num;
	}
	public void setWishlist_num(int wishlist_num) {
		this.wishlist_num = wishlist_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public int getWishlist_stock() {
		return wishlist_stock;
	}
	public void setWishlist_stock(int wishlist_stock) {
		this.wishlist_stock = wishlist_stock;
	}
	public Date getWishlist_date() {
		return wishlist_date;
	}
	public void setWishlist_date(Date wishlist_date) {
		this.wishlist_date = wishlist_date;
	}
	
	

}
