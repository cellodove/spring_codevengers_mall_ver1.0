package ven.spring.mall.service;

import java.util.List;

import ven.spring.mall.model.CategoryVO;
import ven.spring.mall.model.MallItemVO;

public interface AdminService {

	//카태고리
	public List<CategoryVO> category() throws Exception;

	//상품추가
	public void addItem(MallItemVO mallItemVO) throws Exception;

	//상품목록
	public List<MallItemVO> itemList() throws Exception;
	
	//상품조회
	public MallItemVO itemView(int item_num) throws Exception;
	
	//상품수정
	public void itemModify(MallItemVO mallItemVO) throws Exception;

	//상품삭제
	public void itemDelete(int item_num) throws Exception;
}
