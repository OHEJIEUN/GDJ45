package repository;

import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.config.MybatisConfig;

public class EmpDAO {

	// MybatisConfig로부터 SqlSessionFactory를 받아서 사용한다.
	// SqlSessionFactory를 필드로 저장해 두고,
	// 모든 메소드(삽입, 수정, 삭제, 조회)들이 SqlSessionFactory를 사용한다.
	private SqlSessionFactory factory;
	
	// MybatisConfig 인스턴스
	// MybatisConfig.getInstance()
	
	// MybatisConfig 인스턴스가 가지고 있는 SqlSessionFactory
	// MybatisConfig.getInstance().getSqlSessionFactory()
	
	// singleton
	private static EmpDAO empDAO = new EmpDAO();
	private EmpDAO() {
		factory = MybatisConfig.getInstance().getSqlSessionFactory();
	}
	public static EmpDAO getInstance() {
		return empDAO;
	}
	
	
	// 1. 전체사원조회하기
	
	
	
	// 2. 개별사원조회하기
	
	
	
	// 3. 사원삽입하기
	
	
	
	// 4. 사원수정하기
	
	
	
	// 5. 사원삭제하기
	
	
	
	

}
