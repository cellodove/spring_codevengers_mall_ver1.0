package ven.spring.mall.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ven.spring.mall.dao.ShopDAO;
import ven.spring.mall.model.ItemViewVO;
import ven.spring.mall.model.ReviewBoardListVO;
import ven.spring.mall.model.ReviewBoardVO;
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

}
