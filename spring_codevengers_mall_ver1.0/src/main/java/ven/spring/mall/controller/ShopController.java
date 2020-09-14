package ven.spring.mall.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ven.spring.mall.model.ItemViewVO;
import ven.spring.mall.model.MemberVO;
import ven.spring.mall.model.ReviewBoardListVO;
import ven.spring.mall.model.ReviewBoardVO;
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
	
	//상품조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("n") int item_num, Model model) throws Exception {
		logger.info("get view");
		
		ItemViewVO itemViewVO = shopService.itemView(item_num);
		model.addAttribute("view", itemViewVO);
		
		
		/*
		  List<ReviewBoardListVO> reply = shopService.reviewList(item_num);
		  model.addAttribute("reply", reply);
		 */
		 
	}
	
	/*
	 * //상품조회 - 댓글 작성
	 * 
	 * @RequestMapping(value = "/view" , method = RequestMethod.POST) public String
	 * addReview(ReviewBoardVO reviewBoardVO, HttpSession session) throws Exception
	 * { logger.info("addReview");
	 * 
	 * MemberVO memberVO = (MemberVO)session.getAttribute("member");
	 * reviewBoardVO.setMem_id(memberVO.getMem_id());
	 * shopService.addReview(reviewBoardVO);
	 * 
	 * return "redirect:/shop/view?n=" + reviewBoardVO.getItem_num(); }
	 */
	
	
	// 상품 소감(댓글) 작성
	@ResponseBody
	@RequestMapping(value = "/view/addReview", method = RequestMethod.POST)
	public void addReview(ReviewBoardVO reviewBoardVO,  HttpSession session) throws Exception {
	 logger.info("add Review");
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");
	 reviewBoardVO.setMem_id(member.getMem_id());
	 
	 shopService.addReview(reviewBoardVO);
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	 // 상품 소감(댓글) 목록
	 
	  @ResponseBody
	  
	  @RequestMapping(value = "/view/reviewList", method = RequestMethod.GET)
	  public List<ReviewBoardListVO> getReviewList(@RequestParam("n") int item_num)
	  throws Exception { logger.info("get reply list");
	  
	  List<ReviewBoardListVO> reply = shopService.reviewList(item_num);
	  
	  return reply; }
	 
	
	
}
