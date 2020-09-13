package ven.spring.mall.model;

import java.sql.Date;

public class ReviewBoardVO {
	
	private int rbrd_num;
	private String mem_id;
	private String rbrd_title;
	private String rbrd_passwd;
	private String rbrd_content;
	private String rbrd_file;
	private Date rbrd_rbrd_date;
	private int item_num;
	private String mem_name;
	
	
	
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public int getRbrd_num() {
		return rbrd_num;
	}
	public void setRbrd_num(int rbrd_num) {
		this.rbrd_num = rbrd_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getRbrd_title() {
		return rbrd_title;
	}
	public void setRbrd_title(String rbrd_title) {
		this.rbrd_title = rbrd_title;
	}
	public String getRbrd_passwd() {
		return rbrd_passwd;
	}
	public void setRbrd_passwd(String rbrd_passwd) {
		this.rbrd_passwd = rbrd_passwd;
	}
	public String getRbrd_content() {
		return rbrd_content;
	}
	public void setRbrd_content(String rbrd_content) {
		this.rbrd_content = rbrd_content;
	}
	public String getRbrd_file() {
		return rbrd_file;
	}
	public void setRbrd_file(String rbrd_file) {
		this.rbrd_file = rbrd_file;
	}
	public Date getRbrd_rbrd_date() {
		return rbrd_rbrd_date;
	}
	public void setRbrd_rbrd_date(Date rbrd_rbrd_date) {
		this.rbrd_rbrd_date = rbrd_rbrd_date;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	
	
	

}
