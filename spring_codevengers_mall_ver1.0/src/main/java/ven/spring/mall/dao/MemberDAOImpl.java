package ven.spring.mall.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ven.spring.mall.model.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sql;
	
	//매퍼설정
	private static String namespace = "ven.codevengers.mappers.memberMapper";
	
	//회원가입
	@Override
	public void signup(MemberVO memberVO) throws Exception {
		sql.insert(namespace + ".signup",memberVO);
	}
	
	//로그인
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		return sql.selectOne(namespace + ".login", memberVO);
	}

}
