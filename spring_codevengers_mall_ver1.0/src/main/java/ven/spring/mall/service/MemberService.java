package ven.spring.mall.service;

import ven.spring.mall.model.MemberVO;

public interface MemberService {
	
	//회원가입
	public void signup(MemberVO memberVO) throws Exception;

}
