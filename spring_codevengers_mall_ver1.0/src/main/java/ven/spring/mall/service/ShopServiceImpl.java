package ven.spring.mall.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ven.spring.mall.dao.ShopDAO;
import ven.spring.mall.model.ItemViewVO;
@Service
public class ShopServiceImpl implements ShopService {
	
	@Inject
	private ShopDAO shopDAO;

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

}
