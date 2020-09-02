package ven.spring.mall.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.xml.internal.utils.NameSpace;

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

}
