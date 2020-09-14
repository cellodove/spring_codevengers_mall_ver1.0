package ven.spring.mall.controller;

import java.io.Console;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ven.spring.mall.model.ItemViewVO;
import ven.spring.mall.model.MemberVO;
import ven.spring.mall.model.ReviewBoardListVO;
import ven.spring.mall.model.ReviewBoardVO;
import ven.spring.mall.model.WishListListVO;
import ven.spring.mall.model.WishListVO;
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
	 
	 MemberVO memberVO = (MemberVO)session.getAttribute("member");
	 reviewBoardVO.setMem_id(memberVO.getMem_id());
	 
	 shopService.addReview(reviewBoardVO);
	} 
	
	
	 // 상품 소감(댓글) 목록
	 
	  @ResponseBody
	  
	  @RequestMapping(value = "/view/reviewList", method = RequestMethod.GET)
	  public List<ReviewBoardListVO> getReviewList(@RequestParam("n") int item_num)
	  throws Exception { logger.info("get reply list");
	  
	  List<ReviewBoardListVO> reply = shopService.reviewList(item_num);
	  
	  return reply; }
	 
	  
	  // 상품 소감(댓글) 삭제
	  @ResponseBody
	  @RequestMapping(value = "/view/deleteReview", method = RequestMethod.POST)
	  public int getReplyList(ReviewBoardVO reviewBoardVO,  HttpSession session) throws Exception {
	   logger.info("post delete review");

	   int result = 0;
	   
	   MemberVO memberVO = (MemberVO)session.getAttribute("member");
	   String mem_id = shopService.idCheck(reviewBoardVO.getRbrd_num());
	  
	   		
	     
	   if(memberVO.getMem_id().equals(mem_id)) {
	    
		   reviewBoardVO.setMem_id(memberVO.getMem_id());
		   shopService.deleteReview(reviewBoardVO);
		   
	    
	    result = 1;
	   }
	   System.out.println(reviewBoardVO.getRbrd_num());
	   System.out.println(memberVO.getMem_id());
  		System.out.println(mem_id);
  		System.out.println(result);
	   
	   return result; 
	  }
	  
	  //상품 댓글 수정
	  @ResponseBody
	  @RequestMapping(value = "/view/modifyReview", method = RequestMethod.POST)
	  public int modifyReview(ReviewBoardVO reviewBoardVO, HttpSession session) throws Exception {
		logger.info("modify review");
		  int result = 0;
		  
		  MemberVO memberVO = (MemberVO)session.getAttribute("member");
		  String mem_id = shopService.idCheck(reviewBoardVO.getRbrd_num());
		  
		  if (memberVO.getMem_id().equals(mem_id)) {
			reviewBoardVO.setMem_id(memberVO.getMem_id());
			shopService.modifyReview(reviewBoardVO);
			result = 1;
		}
		  
		  
		  return result;
	}
	  
	 
	  //장바구니 담기
	  @ResponseBody
	  @RequestMapping(value = "/view/addWishList", method = RequestMethod.POST)
	  public int addWishList(WishListVO wishListVO, HttpSession session) throws Exception {
		
		int result = 0;  
		  
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		
		if (memberVO != null) {
			wishListVO.setMem_id(memberVO.getMem_id());
			shopService.addWishList(wishListVO);
			result = 1;
		}
		return result;
	}
	  
	  
	// 카트 목록
	  @RequestMapping(value = "/wishListList", method = RequestMethod.GET)
	  public void getCartList(HttpSession session, Model model) throws Exception {
	   logger.info("get wishList list");
	   
	   MemberVO memberVO = (MemberVO)session.getAttribute("member");
	   String mem_id = memberVO.getMem_id();
	   
	   List<WishListListVO> wishListList = shopService.wishListList(mem_id);
	   
	   model.addAttribute("wishListList", wishListList);
	   
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	
}
