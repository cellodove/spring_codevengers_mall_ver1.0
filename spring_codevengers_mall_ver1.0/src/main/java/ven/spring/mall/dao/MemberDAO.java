package ven.spring.mall.dao;

import ven.spring.mall.model.MemberVO;

public interface MemberDAO {
	
	//회원가입
	public void signup(MemberVO memberVO) throws Exception;

}
