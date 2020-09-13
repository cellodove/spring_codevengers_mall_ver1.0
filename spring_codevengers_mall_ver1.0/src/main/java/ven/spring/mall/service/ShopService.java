package ven.spring.mall.service;

import java.util.List;

import ven.spring.mall.model.ItemViewVO;
import ven.spring.mall.model.ReviewBoardListVO;
import ven.spring.mall.model.ReviewBoardVO;

public interface ShopService {
	
	//카테고리별 상품리스트
	public List<ItemViewVO> list(int item_cateCode, int level) throws Exception;
	
	//상품조회
	public ItemViewVO itemView(int item_num) throws Exception;
	
	//상품소감(댓글)작성
	public void addReview(ReviewBoardVO reviewBoardVO) throws Exception;
	
	//상품소감 리스트
	public List<ReviewBoardListVO> reviewList(int item_num) throws Exception;

}
