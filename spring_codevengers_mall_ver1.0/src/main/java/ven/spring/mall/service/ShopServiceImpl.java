package ven.spring.mall.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ven.spring.mall.dao.ShopDAO;
import ven.spring.mall.model.ItemViewVO;
import ven.spring.mall.model.MallOrderDetailVO;
import ven.spring.mall.model.MallOrderListVO;
import ven.spring.mall.model.MallOrderVO;
import ven.spring.mall.model.ReviewBoardListVO;
import ven.spring.mall.model.ReviewBoardVO;
import ven.spring.mall.model.WishListListVO;
import ven.spring.mall.model.WishListVO;
@Service
public class ShopServiceImpl implements ShopService {
	
	@Inject
	private ShopDAO shopDAO;
	
	//카테고리별 상품리스트
	@Override
	public List<ItemViewVO> list(int item_cateCode, int level) throws Exception {
		int cateCodeRef = 0;
		
		if (level == 1) {//1차분류
			cateCodeRef = item_cateCode;
			return shopDAO.list(item_cateCode, cateCodeRef);
		} else {//2차분류
			return shopDAO.list(item_cateCode);
		}

	}
	
	//상품조회
	@Override
	public ItemViewVO itemView(int item_num) throws Exception {
		return shopDAO.itemView(item_num);
	}
	
	//상품소감(댓글) 작성
	@Override
	public void addReview(ReviewBoardVO reviewBoardVO) throws Exception {
		shopDAO.addReview(reviewBoardVO);
		
	}
	
	//상품댓글 리스트
	@Override
	public List<ReviewBoardListVO> reviewList(int item_num) throws Exception {
		return shopDAO.reviewList(item_num);
	}

	//상품 댓글삭제
	@Override
	public void deleteReview(ReviewBoardVO reviewBoardVO) throws Exception {
		shopDAO.deleteReview(reviewBoardVO);
		
	}
	
	//아이디 체크
	@Override
	public String idCheck(int rbrd_num) throws Exception {
		return shopDAO.idCheck(rbrd_num);
	}
	
	//상품 댓글 수정
	@Override
	public void modifyReview(ReviewBoardVO reviewBoardVO) throws Exception {
		shopDAO.modifyReview(reviewBoardVO);
		
	}
	
	//장바구니 담기
	@Override
	public void addWishList(WishListVO wishListVO) throws Exception {
		shopDAO.addWishList(wishListVO);
		
	}
	
	//장바구니 리스트
	@Override
	public List<WishListListVO> wishListList(String mem_id) throws Exception {
		return shopDAO.wishListList(mem_id);
	}
	
	//장바구니 삭제
	@Override
	public void deleteWishList(WishListVO wishListVO) throws Exception {
		shopDAO.deleteWishList(wishListVO);
	}

	//주문 정보
	@Override
	public void orderInfo(MallOrderVO mallOrderVO) throws Exception {
		shopDAO.orderInfo(mallOrderVO);
	}
	
	//주문 상세 정보
	@Override
	public void orderInfo_Details(MallOrderDetailVO mallOrderDetailVO) throws Exception {
		shopDAO.orderInfo_Details(mallOrderDetailVO);
	}
	
	//장바구니 비우기
	@Override
	public void wishListAllDelete(String mem_id) throws Exception {
		shopDAO.wishListAllDelete(mem_id);
	}
	
	//주문 목록
	@Override
	public List<MallOrderVO> orderList(MallOrderVO mallOrderVO) throws Exception {
		return shopDAO.orderList(mallOrderVO);
	}
	
	//특정 주문목록
	@Override
	public List<MallOrderListVO> orderView(MallOrderVO mallOrderVO) throws Exception {
		return shopDAO.orderView(mallOrderVO);
	}

}
