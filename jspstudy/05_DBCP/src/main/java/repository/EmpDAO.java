package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDAO {

	// singleton
	private static EmpDAO empDAO = new EmpDAO();
	private EmpDAO() { }
	public static EmpDAO getInstance() {
		return empDAO;
	}
	
	// context.xml 내용을 읽어서 DataSource 인스턴스 생성
	// JNDI : Java Naming and Directory Interface API
	// 특정 리소스에 이름(name)을 부여하고 해당 이름(name)을 찾는(lookup) 방식
	private static DataSource dataSource;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");
			// WAS가 톰캣인 경우   java:comp/env/
			// <Resource name>     jdbc/oracle11g
		} catch(NamingException e) {
			System.out.println("Resource name을 찾을 수 없습니다.");
		}
	}
	
	
	// field
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	
	// method
	
	// 1. 접속 해제하기
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(con != null) con.close();  // Connection의 반납
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 2. 사원 추가하기
	public int insertEmp() {
		con = dataSource.getConnection();  // Connection 대여
		
		close(con, ps, null);
	}
	
	
	
	
}
