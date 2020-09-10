package ven.spring.mall.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ven.spring.mall.model.ItemViewVO;
import ven.spring.mall.service.ShopService;

@Controller
@RequestMapping("/shop/*")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

	@Inject
	ShopService shopService;
	
	//카테고리별 상품리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(@RequestParam("c") int item_cateCode, @RequestParam("l") int level, Model model) throws Exception {
		logger.info("get llist");
		
		List<ItemViewVO> list = null;
		list = shopService.list(item_cateCode, level);
		
		model.addAttribute("list", list);
	}
	
	
	
	
}
