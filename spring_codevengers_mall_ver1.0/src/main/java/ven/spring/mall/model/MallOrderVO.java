package ven.spring.mall.model;

import java.sql.Date;

public class MallOrderVO {

	private String cor_id;
	private String mem_id;
	private int mem_zipcode;
	private String mem_adress1;
	private String mem_adress2;
	private int mem_tel1;
	private int mem_tel2;
	private int mem_tel3;
	private Date cor_date;
	private int cor_amount;
	private String cor_rec;
	private String delivery;
	

	
	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getMem_adress2() {
		return mem_adress2;
	}

	public void setMem_adress2(String mem_adress2) {
		this.mem_adress2 = mem_adress2;
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

	public int getMem_zipcode() {
		return mem_zipcode;
	}

	public void setMem_zipcode(int mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}

	public String getMem_adress1() {
		return mem_adress1;
	}

	public void setMem_adress1(String mem_adress1) {
		this.mem_adress1 = mem_adress1;
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

	public Date getCor_date() {
		return cor_date;
	}

	public void setCor_date(Date cor_date) {
		this.cor_date = cor_date;
	}

	public int getCor_amount() {
		return cor_amount;
	}

	public void setCor_amount(int cor_amount) {
		this.cor_amount = cor_amount;
	}

	public String getCor_rec() {
		return cor_rec;
	}

	public void setCor_rec(String cor_rec) {
		this.cor_rec = cor_rec;
	}

}
