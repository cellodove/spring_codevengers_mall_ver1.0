package ven.spring.mall.service;

import java.util.List;

import ven.spring.mall.model.ItemViewVO;

public interface ShopService {
	
	//카테고리별 상품리스트
	public List<ItemViewVO> list(int item_cateCode, int level) throws Exception;

}
