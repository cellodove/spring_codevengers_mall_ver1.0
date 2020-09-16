package ven.spring.mall.model;

public class MallOrderDetailVO {

	private int cor_details_num;
	private String cor_id;
	private int item_num;
	private int wishlist_stock;

	public int getCor_details_num() {
		return cor_details_num;
	}

	public void setCor_details_num(int cor_details_num) {
		this.cor_details_num = cor_details_num;
	}

	public String getCor_id() {
		return cor_id;
	}

	public void setCor_id(String cor_id) {
		this.cor_id = cor_id;
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

}
