package ven.spring.mall.dao;

import java.util.List;

import ven.spring.mall.model.CategoryVO;
import ven.spring.mall.model.MallItemVO;
import ven.spring.mall.model.ItemViewVO;

public interface AdminDAO {

	// 카테고리
	public List<CategoryVO> category() throws Exception;

	// 상품추가
	public void addItem(MallItemVO mallItemVO) throws Exception;

	//상품목록
	public List<ItemViewVO> itemList() throws Exception;
	
	//상품조회 + 카테고리 조인
	public ItemViewVO itemView(int item_num) throws Exception;
	
	//상품수정
	public void itemModify(MallItemVO mallItemVO) throws Exception;

	//상품삭제
	public void itemDelete(int item_num) throws Exception;
}
