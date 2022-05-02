package repository;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.MemberDTO;

public class MemberDAO {

	private SqlSessionFactory factory;
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public int insertMember(MemberDTO member) {
		SqlSession ss = factory.openSession(false);
		int res = ss.insert("mybatis.mapper.member.insertMember", member);
		if(res > 0) {
			ss.commit();
		}
		ss.close();
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
}
