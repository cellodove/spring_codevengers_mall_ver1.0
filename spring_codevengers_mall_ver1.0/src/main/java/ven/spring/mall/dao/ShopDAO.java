package ven.spring.mall.dao;

import java.util.List;

import ven.spring.mall.model.ItemViewVO;

public interface ShopDAO {
	
	//카테고리별 상품 리스트 1차분류
	public List<ItemViewVO> list(int item_cateCode, int cateCodeRef) throws Exception;
	
	//카테고리별 상품 리스트 2차분류
	public List<ItemViewVO> list(int item_cateCode) throws Exception;

}
