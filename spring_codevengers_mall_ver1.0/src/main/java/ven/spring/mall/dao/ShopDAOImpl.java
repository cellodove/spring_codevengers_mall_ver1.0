package ven.spring.mall.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ven.spring.mall.model.ItemViewVO;
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
}
