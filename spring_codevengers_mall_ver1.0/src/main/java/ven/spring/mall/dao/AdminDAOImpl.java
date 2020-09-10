package ven.spring.mall.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ven.spring.mall.model.CategoryVO;
import ven.spring.mall.model.MallItemVO;
import ven.spring.mall.model.ItemViewVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "ven.codevengers.mappers.adminMapper";
	
	
	
	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}


	//상품추가
	@Override
	public void addItem(MallItemVO mallItemVO) throws Exception {
		sql.insert(namespace + ".addItem", mallItemVO);
	}

	//상품목록
	@Override
	public List<ItemViewVO> itemList() throws Exception {
		return sql.selectList(namespace + ".itemList");
	}

	//상품조회 + 카테고리 조인
	@Override
	public ItemViewVO itemView(int item_num) throws Exception {
		return sql.selectOne(namespace + ".itemView", item_num);
	}

	//상품수정
	@Override
	public void itemModify(MallItemVO mallItemVO) throws Exception {
		sql.update(namespace + ".itemModify", mallItemVO);		
	}

	//상품삭제
	@Override
	public void itemDelete(int item_num) throws Exception {
		sql.delete(namespace + ".itemDelete", item_num);
		
	}




	
	
}
