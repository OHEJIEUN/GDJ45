package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Board;

public class BoardDAO {

	// singleton
	private static BoardDAO dao = new BoardDAO();
	private BoardDAO() { }
	public static BoardDAO getInstance() {
		return dao;
	}
	
	// DataSource
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
	
	// 2. 게시글목록가져오기
	public List<Board> selectBoardList() {
		List<Board> list = new ArrayList<Board>();
		try {
			con = dataSource.getConnection();
			sql = "SELECT * FROM BOARD ORDER BY NO DESC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setNo(rs.getLong("NO"));
				board.setWriter(rs.getString("WRITER"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setIp(rs.getString("IP"));
				board.setHit(rs.getLong("HIT"));
				board.setCreated(rs.getDate("CREATED"));
				board.setLastModified(rs.getDate("LASTMODIFIED"));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
