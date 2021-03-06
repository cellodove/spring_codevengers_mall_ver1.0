package ven.spring.mall.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ven.spring.mall.dao.AdminDAO;
import ven.spring.mall.model.CategoryVO;
import ven.spring.mall.model.MallItemVO;
import ven.spring.mall.model.MallOrderListVO;
import ven.spring.mall.model.MallOrderVO;
import ven.spring.mall.model.ItemViewVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDAO adminDAO;
	
	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		return adminDAO.category();
	}

	//상품 추가
	@Override
	public void addItem(MallItemVO mallItemVO) throws Exception {
		adminDAO.addItem(mallItemVO);
		
	}
	
	//상품목록
	@Override
	public List<ItemViewVO> itemList() throws Exception {
		System.out.println("서비스");
		return adminDAO.itemList();
	}
	
	
	//상품조회
	@Override
	public ItemViewVO itemView(int item_num) throws Exception {
		return adminDAO.itemView(item_num);
	}
	
	//상품수정
	@Override
	public void itemModify(MallItemVO mallItemVO) throws Exception {
		adminDAO.itemModify(mallItemVO);	
	}
	
	//상품삭제
	@Override
	public void itemDelete(int item_num) throws Exception {
		adminDAO.itemDelete(item_num);
		
	}

	//주문목록
	@Override
	public List<MallOrderVO> orderList() throws Exception {
		return adminDAO.orderList(); 
	}
	
	//특정주문목록
	@Override
	public List<MallOrderListVO> orderView(MallOrderVO mallOrderVO) throws Exception {
		return adminDAO.orderView(mallOrderVO);
	}

}
