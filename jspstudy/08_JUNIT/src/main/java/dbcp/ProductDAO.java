package dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAO {

	private static DataSource dataSource;
	private static ProductDAO dao = new ProductDAO();
	
	private ProductDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/xe");
		} catch (NamingException e) {
			System.out.println("해당 Resource를 읽을 수 없습니다.");
		}
	}
	
	public static ProductDAO getInstance() {
		return dao;
	}
	
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(con != null) { con.close(); }
			if(ps != null) { ps.close(); }
			if(rs != null) { rs.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
