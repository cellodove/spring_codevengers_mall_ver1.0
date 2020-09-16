package ven.spring.mall.service;

import java.util.List;

import ven.spring.mall.model.ItemViewVO;
import ven.spring.mall.model.MallOrderDetailVO;
import ven.spring.mall.model.MallOrderListVO;
import ven.spring.mall.model.MallOrderVO;
import ven.spring.mall.model.ReviewBoardListVO;
import ven.spring.mall.model.ReviewBoardVO;
import ven.spring.mall.model.WishListListVO;
import ven.spring.mall.model.WishListVO;

public interface ShopService {
	
	//카테고리별 상품리스트
	public List<ItemViewVO> list(int item_cateCode, int level) throws Exception;
	
	//상품조회
	public ItemViewVO itemView(int item_num) throws Exception;
	
	//상품소감(댓글)작성
	public void addReview(ReviewBoardVO reviewBoardVO) throws Exception;
	
	//상품소감 리스트
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
	
	//주문정보
	public void orderInfo(MallOrderVO mallOrderVO) throws Exception;
		
	//주문 상세 정보
	public void orderInfo_Details(MallOrderDetailVO mallOrderDetailVO) throws Exception;

	//장바구니 비우기
	public void wishListAllDelete(String mem_id) throws Exception;
	
	//주문목록
	public List<MallOrderVO> orderList(MallOrderVO mallOrderVO) throws Exception;

	//특정 주문 목록
	public List<MallOrderListVO> orderView(MallOrderVO mallOrderVO) throws Exception;
}
