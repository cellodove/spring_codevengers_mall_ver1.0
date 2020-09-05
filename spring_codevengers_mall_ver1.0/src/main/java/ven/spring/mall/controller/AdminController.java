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

import net.sf.json.JSONArray;
import ven.spring.mall.model.CategoryVO;
import ven.spring.mall.model.MallItemVO;
import ven.spring.mall.service.AdminService;

@Controller
@RequestMapping("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	//관리자 화면
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get index");
	}
	
	//상품등록
	@RequestMapping(value = "/item/add_item", method = RequestMethod.GET)
	public void getItemAdd(Model model) throws Exception {
		logger.info("get item add");
		
		List<CategoryVO> category = null;
		category = adminService.category();
		//작동방법확인해볼것
		model.addAttribute("category", JSONArray.fromObject(category));	
	}
	
	//상품추가
	@RequestMapping(value = "/item/add_item", method = RequestMethod.POST)
	public String postItemAdd(MallItemVO mallItemVO) throws Exception {
		adminService.addItem(mallItemVO);
		return "redirect:/admin/index";
	}
	
	//상품목록
	@RequestMapping(value = "/item/list", method = RequestMethod.GET)
	public void getItemList(Model model) throws Exception {
		logger.info("get item list");
		List<MallItemVO> list = adminService.itemList();
		model.addAttribute("list", list);
	}
	
	//상품조회
	@RequestMapping(value = "/item/view", method = RequestMethod.GET)
	public void getItemView(@RequestParam("n") int item_num, Model model) throws Exception {
		logger.info("get item view");
		
		MallItemVO mallItem = adminService.itemView(item_num);
		model.addAttribute("mallItem", mallItem);
	}
	
}
