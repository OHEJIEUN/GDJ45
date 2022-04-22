package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Student;

public class StudentDAO {

	// SqlSessionFactory factory 인스턴스를 필드로 생성해 두고,
	// 모든 메소드는 factory로부터
	// SqlSession ss 인스턴스를 받아서 사용한 뒤 닫는다.
	
	// 필드
	private SqlSessionFactory factory;
	
	// singleton
	private static StudentDAO instance = new StudentDAO();
	private StudentDAO() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static StudentDAO getInstance() {
		return instance;
	}
	
	
	// 1. 전체학생조회
	public List<Student> selectStudentList() {
		SqlSession ss = factory.openSession();
		List<Student> list = ss.selectList("mybatis.mapper.student.selectStudentList");
		ss.close();
		return list;
	}
	
	// 2. 학생상세조회
	
	
	// 3. 학생삽입
	
	
	// 4. 학생수정
	
	
	// 5. 학생삭제
	
	
	
	
	
	
	
	
	
	
	
}
