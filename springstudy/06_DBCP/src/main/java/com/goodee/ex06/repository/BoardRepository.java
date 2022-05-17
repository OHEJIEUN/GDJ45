package com.goodee.ex06.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.goodee.ex06.domain.BoardDTO;

public class BoardRepository {

	// BoardRepository == BoardDAO
	// 개발자가 singleton 처리를 할 필요가 없다.
	// BoardConfig.java에 bean으로 등록해 두면 스프링이 singleton으로 만들기 때문이다.
	
	// DBCP 관리는 DataSource가 한다.
	private DataSource dataSource;
	
	// BoardConfig.java를 통해서 bean이 생성되는 순간
	// new BoardRepository()가 호출된다.
	// 외부에서 호출할 수 있도록 접근권한은 public으로 처리하고,
	// context.xml을 읽어서 dataSource를 생성한다.
	public BoardRepository() {
		// JNDI 방식으로 context.xml에 등록한 Resource의 이름(Name)을 찾아서 읽어들인다.
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch(NamingException e) {
			e.printStackTrace();  // Resource를 찾을 수 없다.
		}
	}
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(con != null) con.close();
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// BoardRepository의 메소드 이름
	// DB와 직결되는 부분으로 select/insert/update/delete를 활용하는 것이 좋다.
	
	
	public List<BoardDTO> selectBoards(){
		List<BoardDTO> boards = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATED, LASTMODIFIED FROM BOARD ORDER BY BOARD_NO DESC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDTO board = new BoardDTO(
						rs.getLong(1),    // rs.getLong("BOARD_NO")
						rs.getString(2),  // rs.getString("TITLE")
						rs.getString(3),  // rs.getString("CONTENT")
						rs.getString(4),  // rs.getString("WRITER")
						rs.getString(5),  // rs.getString("CREATED")
						rs.getString(6)); // rs.getString("LASTMODIFIED")
				boards.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return boards;
	}
	
	public BoardDTO selectBoardByNo(Long board_no) {
		
		return null;
	}
	
	public int insertBoard(BoardDTO board) {
		
		return 0;
	}
	
	public int updateBoard(BoardDTO board) {
		
		return 0;
	}
	
	public int deleteBoard(Long board_no) {
		
		return 0;
	}
	
}
