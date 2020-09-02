package ven.spring.mall.service;

import javax.inject.Inject;

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
	
	
	

}
