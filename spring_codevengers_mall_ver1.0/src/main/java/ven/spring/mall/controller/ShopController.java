package ven.spring.mall.controller;

import java.io.Console;
import java.text.DecimalFormat;
import java.util.Calendar;
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
import ven.spring.mall.model.MallOrderDetailVO;
import ven.spring.mall.model.MallOrderListVO;
import ven.spring.mall.model.MallOrderVO;
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

	// 카테고리별 상품리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(@RequestParam("c") int item_cateCode, @RequestParam("l") int level, Model model)
			throws Exception {
		logger.info("get llist");

		List<ItemViewVO> list = null;
		list = shopService.list(item_cateCode, level);

		model.addAttribute("list", list);
	}

	// 상품조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("n") int item_num, Model model) throws Exception {
		logger.info("get view");

		ItemViewVO itemViewVO = shopService.itemView(item_num);
		model.addAttribute("view", itemViewVO);

	}

	// 상품 소감(댓글) 작성
	@ResponseBody
	@RequestMapping(value = "/view/addReview", method = RequestMethod.POST)
	public void addReview(ReviewBoardVO reviewBoardVO, HttpSession session) throws Exception {
		logger.info("add Review");

		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		reviewBoardVO.setMem_id(memberVO.getMem_id());

		shopService.addReview(reviewBoardVO);
	}

	// 상품 소감(댓글) 목록

	@ResponseBody

	@RequestMapping(value = "/view/reviewList", method = RequestMethod.GET)
	public List<ReviewBoardListVO> getReviewList(@RequestParam("n") int item_num) throws Exception {
		logger.info("get reply list");

		List<ReviewBoardListVO> reply = shopService.reviewList(item_num);

		return reply;
	}

	// 상품 소감(댓글) 삭제
	@ResponseBody
	@RequestMapping(value = "/view/deleteReview", method = RequestMethod.POST)
	public int getReplyList(ReviewBoardVO reviewBoardVO, HttpSession session) throws Exception {
		logger.info("post delete review");

		int result = 0;

		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		String mem_id = shopService.idCheck(reviewBoardVO.getRbrd_num());

		if (memberVO.getMem_id().equals(mem_id)) {

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

	// 상품 댓글 수정
	@ResponseBody
	@RequestMapping(value = "/view/modifyReview", method = RequestMethod.POST)
	public int modifyReview(ReviewBoardVO reviewBoardVO, HttpSession session) throws Exception {
		logger.info("modify review");
		int result = 0;

		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		String mem_id = shopService.idCheck(reviewBoardVO.getRbrd_num());

		if (memberVO.getMem_id().equals(mem_id)) {
			reviewBoardVO.setMem_id(memberVO.getMem_id());
			shopService.modifyReview(reviewBoardVO);
			result = 1;
		}

		return result;
	}

	// 장바구니 담기
	@ResponseBody
	@RequestMapping(value = "/view/addWishList", method = RequestMethod.POST)
	public int addWishList(WishListVO wishListVO, HttpSession session) throws Exception {

		int result = 0;

		MemberVO memberVO = (MemberVO) session.getAttribute("member");

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

		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		String mem_id = memberVO.getMem_id();

		List<WishListListVO> wishListList = shopService.wishListList(mem_id);

		model.addAttribute("wishListList", wishListList);

	}

	// 장바구니 삭제
	@ResponseBody
	@RequestMapping(value = "/deleteWishList", method = RequestMethod.POST)
	public int deleteCart(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr,
			WishListVO wishListVO) throws Exception {
		logger.info("delete wishlist");

		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		String mem_id = memberVO.getMem_id();

		int result = 0;
		int wishList_num = 0;

		if (memberVO != null) {
			wishListVO.setMem_id(mem_id);
			;

			for (String i : chArr) {
				wishList_num = Integer.parseInt(i);
				wishListVO.setWishlist_num(wishList_num);
				;
				shopService.deleteWishList(wishListVO);
				;
			}
			result = 1;
		}
		return result;
	}

	// 주문
	@RequestMapping(value = "/wishListList", method = RequestMethod.POST)
	public String order(HttpSession session, MallOrderVO mallOrderVO, MallOrderDetailVO mallOrderDetailVO)
			throws Exception {
		logger.info("order");

		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		String mem_id = memberVO.getMem_id();

		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(calendar.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(calendar.get(Calendar.DATE));
		String subNum = "";
		
		for (int i = 1; i <= 6; i++) {
			subNum += (int) (Math.random() * 10);
		}
		
		String cor_id = ymd + "_" + subNum;
		mallOrderVO.setCor_id(cor_id);
		mallOrderVO.setMem_id(mem_id);
		
		shopService.orderInfo(mallOrderVO);

		mallOrderDetailVO.setCor_id(cor_id);
		shopService.orderInfo_Details(mallOrderDetailVO);
		
		shopService.wishListAllDelete(mem_id);
		
		return "redirect:/shop/orderList";
	}
	
	// 주문 목록
	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public void getOrderList(HttpSession session, MallOrderVO mallOrderVO, Model model) throws Exception {
	 logger.info("get order list");
	 
	 MemberVO memberVO = (MemberVO)session.getAttribute("member");
	 String mem_id = memberVO.getMem_id();
	 
	 mallOrderVO.setMem_id(mem_id);
	 
	 List<MallOrderVO> mallOrderList = shopService.orderList(mallOrderVO);
	 
	 model.addAttribute("mallOrderList", mallOrderList);
	}
	
	
	// 주문 상세 목록
	@RequestMapping(value = "/orderView", method = RequestMethod.GET)
	public void getOrderList(HttpSession session, @RequestParam("n") String cor_id,MallOrderVO mallOrderVO, Model model) throws Exception {
	 logger.info("get order view");
	 
	 MemberVO memberVO = (MemberVO)session.getAttribute("member");
	 String mem_id = memberVO.getMem_id();
	 
	 mallOrderVO.setMem_id(mem_id);
	 mallOrderVO.setCor_id(cor_id);
	 
	 List<MallOrderListVO> mallOrderListVO = shopService.orderView(mallOrderVO);
	 
	 model.addAttribute("mallOrderListVO", mallOrderListVO);
	}

}
