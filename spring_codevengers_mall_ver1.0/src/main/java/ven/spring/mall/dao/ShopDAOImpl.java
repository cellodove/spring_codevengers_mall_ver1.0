package ven.spring.mall.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ven.spring.mall.model.ItemViewVO;
import ven.spring.mall.model.ReviewBoardListVO;
import ven.spring.mall.model.ReviewBoardVO;
@Repository
public class ShopDAOImpl implements ShopDAO {
	
	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "ven.codevengers.mappers.shopMapper";
	

	//카테고리별 상품리스트 1차분류
	@Override
	public List<ItemViewVO> list(int item_cateCode, int cateCodeRef) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("item_cateCode", item_cateCode);
		map.put("cateCodeRef", cateCodeRef);
		
		return sql.selectList(namespace + ".list_1", map);
	}

	
	//카테고리별 상품리스트 2차분류
	@Override
	public List<ItemViewVO> list(int item_cateCode) throws Exception {
		return sql.selectList(namespace + ".list_2", item_cateCode);
	}

	//상품조회
	@Override
	public ItemViewVO itemView(int item_num) throws Exception {
		return sql.selectOne("ven.codevengers.mappers.shopMapper" + ".itemView", item_num);
	}

	//상품소감(댓글) 작성
	@Override
	public void addReview(ReviewBoardVO reviewBoardVO) throws Exception {
		sql.insert(namespace + ".addReview", reviewBoardVO);
		
	}

	//상품댓글 리스트
	@Override
	public List<ReviewBoardListVO> reviewList(int item_num) throws Exception {
		return sql.selectList(namespace + ".reviewList", item_num);
	}
}









