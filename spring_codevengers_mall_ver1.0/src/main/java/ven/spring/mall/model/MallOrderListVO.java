package ven.spring.mall.model;

import java.sql.Date;

public class MallOrderListVO {
	
	private String cor_id;
	private String mem_id;
	private String cor_rec;
	private String mem_zipcode;
	private String mem_adress1;
	private String mem_adress2;
	private int mem_tel1;
	private int mem_tel2;
	private int mem_tel3;
	private int cor_amount;
	private Date cor_date;
	
	private int cor_details_num;
	private int item_num;
	private int wishlist_stock;
	
	private String item_name;
	private String item_thumbImg;
	private int item_price;
	
	private String delivery;
	
	
	
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getCor_id() {
		return cor_id;
	}
	public void setCor_id(String cor_id) {
		this.cor_id = cor_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getCor_rec() {
		return cor_rec;
	}
	public void setCor_rec(String cor_rec) {
		this.cor_rec = cor_rec;
	}
	public String getMem_zipcode() {
		return mem_zipcode;
	}
	public void setMem_zipcode(String mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}
	public String getMem_adress1() {
		return mem_adress1;
	}
	public void setMem_adress1(String mem_adress1) {
		this.mem_adress1 = mem_adress1;
	}
	public String getMem_adress2() {
		return mem_adress2;
	}
	public void setMem_adress2(String mem_adress2) {
		this.mem_adress2 = mem_adress2;
	}
	public int getMem_tel1() {
		return mem_tel1;
	}
	public void setMem_tel1(int mem_tel1) {
		this.mem_tel1 = mem_tel1;
	}
	public int getMem_tel2() {
		return mem_tel2;
	}
	public void setMem_tel2(int mem_tel2) {
		this.mem_tel2 = mem_tel2;
	}
	public int getMem_tel3() {
		return mem_tel3;
	}
	public void setMem_tel3(int mem_tel3) {
		this.mem_tel3 = mem_tel3;
	}
	public int getCor_amount() {
		return cor_amount;
	}
	public void setCor_amount(int cor_amount) {
		this.cor_amount = cor_amount;
	}
	public Date getCor_date() {
		return cor_date;
	}
	public void setCor_date(Date cor_date) {
		this.cor_date = cor_date;
	}
	public int getCor_details_num() {
		return cor_details_num;
	}
	public void setCor_details_num(int cor_details_num) {
		this.cor_details_num = cor_details_num;
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
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_thumbImg() {
		return item_thumbImg;
	}
	public void setItem_thumbImg(String item_thumbImg) {
		this.item_thumbImg = item_thumbImg;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	
	

}
