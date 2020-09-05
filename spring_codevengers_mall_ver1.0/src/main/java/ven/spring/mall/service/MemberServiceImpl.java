package ven.spring.mall.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import ven.spring.mall.dao.MemberDAO;
import ven.spring.mall.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO memberDAO;
	
	//회원가입
	@Override
	public void signup(MemberVO memberVO) throws Exception {
		memberDAO.signup(memberVO);
	}
	
	//로그인
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		return memberDAO.login(memberVO);
	}
	
	//로그아웃
	@Override
	public void logout(HttpSession httpSession) throws Exception {
		httpSession.invalidate();
		
	}
	
	
	

}
