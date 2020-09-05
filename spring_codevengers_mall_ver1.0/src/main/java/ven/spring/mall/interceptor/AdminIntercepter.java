package ven.spring.mall.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ven.spring.mall.model.MemberVO;

public class AdminIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
		
		HttpSession httpSession = httpServletRequest.getSession();
		MemberVO memberVO = (MemberVO) httpSession.getAttribute("member");
	
		if (memberVO == null) {
			httpServletResponse.sendRedirect("/member/login");
			return false;
		}
		
		if (!memberVO.getMem_manager().equals("yes")) {
			httpServletResponse.sendRedirect("/");
			return false;
		}
		return true;
		
	}
}
