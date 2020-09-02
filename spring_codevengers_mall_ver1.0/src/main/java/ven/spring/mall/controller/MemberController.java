package ven.spring.mall.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ven.spring.mall.model.MemberVO;
import ven.spring.mall.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController extends HttpServlet {
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
		
		return "redirect:/";
	}


	
	
	
	


	

}
