package ven.spring.mall.model;

import java.sql.Date;

public class MallItemVO {

	private int item_num;
	private String item_name;
	private String item_type;
	private int item_size;
	private String item_gender;
	private Date item_maketime;
	private int item_price;
	private int item_remain;
	private int item_allnumber;
	private int item_count;
	private String item_summary;
	private Date item_date;
	private String item_picture;
	private int item_catecode;
	private String item_thumbImg;
	
	private String cateCodeRef;
	private String cateName;
	
	
	
	
	public String getCateCodeRef() {
		return cateCodeRef;
	}
	public void setCateCodeRef(String cateCodeRef) {
		this.cateCodeRef = cateCodeRef;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getItem_catecode() {
		return item_catecode;
	}
	public void setItem_catecode(int item_catecode) {
		this.item_catecode = item_catecode;
	}
	public String getItem_thumbImg() {
		return item_thumbImg;
	}
	public void setItem_thumbImg(String item_thumbImg) {
		this.item_thumbImg = item_thumbImg;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public int getItem_size() {
		return item_size;
	}
	public void setItem_size(int item_size) {
		this.item_size = item_size;
	}
	public String getItem_gender() {
		return item_gender;
	}
	public void setItem_gender(String item_gender) {
		this.item_gender = item_gender;
	}
	public Date getItem_maketime() {
		return item_maketime;
	}
	public void setItem_maketime(Date item_maketime) {
		this.item_maketime = item_maketime;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public int getItem_remain() {
		return item_remain;
	}
	public void setItem_remain(int item_remain) {
		this.item_remain = item_remain;
	}
	public int getItem_allnumber() {
		return item_allnumber;
	}
	public void setItem_allnumber(int item_allnumber) {
		this.item_allnumber = item_allnumber;
	}
	public int getItem_count() {
		return item_count;
	}
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}
	public String getItem_summary() {
		return item_summary;
	}
	public void setItem_summary(String item_summary) {
		this.item_summary = item_summary;
	}
	public Date getItem_date() {
		return item_date;
	}
	public void setItem_date(Date item_date) {
		this.item_date = item_date;
	}
	public String getItem_picture() {
		return item_picture;
	}
	public void setItem_picture(String item_picture) {
		this.item_picture = item_picture;
	}
	
	
	
	
	
	
}
