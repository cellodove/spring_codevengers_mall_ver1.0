package ven.spring.mall.service;

import javax.servlet.http.HttpSession;

import ven.spring.mall.model.MemberVO;

public interface MemberService {

	// 회원가입
	public void signup(MemberVO memberVO) throws Exception;

	// 로그인
	public MemberVO login(MemberVO memberVO) throws Exception;

	// 로그아웃
	public void logout(HttpSession httpSession) throws Exception;

}
