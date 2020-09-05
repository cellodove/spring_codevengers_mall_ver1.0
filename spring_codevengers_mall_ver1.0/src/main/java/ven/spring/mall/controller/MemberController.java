package ven.spring.mall.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ven.spring.mall.model.MemberVO;
import ven.spring.mall.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	//회원가입get
	@RequestMapping(value = "/signup" , method = RequestMethod.GET)
	public void getSignup() throws Exception {
		logger.info("get signup");
	}
	
	//회원가입post
	@RequestMapping(value = "/signup" , method = RequestMethod.POST)
	public String postSignup(MemberVO memberVO) throws Exception {
		
		//입력받은 암호를 암호화시켜 다시 memberVO로 넘겨준다.
		String inputMem_passwd = memberVO.getMem_passwd();
		String mem_passwd = passwordEncoder.encode(inputMem_passwd);
		memberVO.setMem_passwd(mem_passwd);
		
		memberService.signup(memberVO);
		System.out.println(memberVO.getMem_id());
		
		return "redirect:/";
	}
	
	//로그인 get
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void getLogin() throws Exception {
		logger.info("get Login");
	}
	
	//로그인 post
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(MemberVO memberVO, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) throws Exception {
		logger.info("post login");
		
		MemberVO login = memberService.login(memberVO);
		HttpSession httpSession = httpServletRequest.getSession();
		
		boolean passwdMatch = passwordEncoder.matches(memberVO.getMem_passwd(), login.getMem_passwd());
		
		if (login != null && passwdMatch) {
			httpSession.setAttribute("member", login);
		} else {
			httpSession.setAttribute("member", null);
			redirectAttributes.addFlashAttribute("msg",false);
			return "redirect:/member/login";
		}
		return "redirect:/";
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String signout(HttpSession httpSession) throws Exception {
	 logger.info("get logout");
	 
	 memberService.logout(httpSession);
	 return "redirect:/";
	}
	
	
	
	


	

}
