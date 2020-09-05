package ven.spring.mall.dao;

import java.util.List;

import ven.spring.mall.model.CategoryVO;
import ven.spring.mall.model.MallItemVO;

public interface AdminDAO {

	// 카테고리
	public List<CategoryVO> category() throws Exception;

	// 상품추가
	public void addItem(MallItemVO mallItemVO) throws Exception;

	//상품목록
	public List<MallItemVO> itemList() throws Exception;
	
	//상품조회
	public MallItemVO itemView(int item_num) throws Exception;
	

}
