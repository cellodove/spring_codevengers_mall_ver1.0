package ven.spring.mall.dao;

import java.util.List;

import ven.spring.mall.model.ItemViewVO;
import ven.spring.mall.model.ReviewBoardListVO;
import ven.spring.mall.model.ReviewBoardVO;
import ven.spring.mall.model.WishListListVO;
import ven.spring.mall.model.WishListVO;

public interface ShopDAO {
	
	//카테고리별 상품 리스트 1차분류
	public List<ItemViewVO> list(int item_cateCode, int cateCodeRef) throws Exception;
	
	//카테고리별 상품 리스트 2차분류
	public List<ItemViewVO> list(int item_cateCode) throws Exception;
	
	//상품조회
	public ItemViewVO itemView(int item_num) throws Exception;
	
	//상품소감(댓글) 작성
	public void addReview(ReviewBoardVO reviewBoardVO) throws Exception;
	
	//상품 댓글 리스트
	public List<ReviewBoardListVO> reviewList(int item_num) throws Exception;

	//상품 댓글 삭제
	public void deleteReview(ReviewBoardVO reviewBoardVO) throws Exception;

	//아이디 체크
	public String idCheck(int rbrd_num) throws Exception;
	
	//상품 댓글 수정
	public void modifyReview(ReviewBoardVO reviewBoardVO) throws Exception;
	
	//장바구니 담기
	public void addWishList(WishListVO wishListVO) throws Exception;
	
	//장바구니 리스트
	public List<WishListListVO> wishListList(String mem_id) throws Exception;
	
	//장바구니 삭제
	public void deleteWishList(WishListVO wishListVO) throws Exception;
	

}
