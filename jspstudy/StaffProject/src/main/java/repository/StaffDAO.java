package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.StaffDTO;



public class StaffDAO {

	private SqlSessionFactory factory;
	private static StaffDAO instance = new StaffDAO();
	
	private StaffDAO() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static StaffDAO getInstance() {
		return instance;
	}
	public int insertStaff(StaffDTO member) {
		SqlSession ss = factory.openSession(false);
		int res = ss.insert("mybatis.mapper.member.insertStaff", member);
		if(res > 0) {
			ss.commit();
		}
		ss.close();
		return res;
	}
	
	public List<StaffDTO> selectstaffList() {
		SqlSession ss = factory.openSession();
		List<StaffDTO> members = ss.selectList("mybatis.mapper.staff.selectstaffList");
		ss.close();
		return members;
	}
	
	
	
	
}