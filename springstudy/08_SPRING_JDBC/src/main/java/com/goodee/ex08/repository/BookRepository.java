package com.goodee.ex08.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.goodee.ex08.domain.BookDTO;

@Repository
public class BookRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;  // Connection, PreparedStatement, ResultSet을 내부에서 사용하는 객체
	
	private String sql;
	
	public List<BookDTO> selectBookList() {
		sql = "SELECT BOOK_NO, TITLE, AUTHOR, PRICE, PUBDATE, REGDATE FROM BOOK ORDER BY BOOK_NO DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookDTO.class));
	}
	
	public BookDTO selectBookByNo(Long book_no) {
		sql = "SELECT BOOK_NO, TITLE, AUTHOR, PRICE, PUBDATE, REGDATE FROM BOOK WHERE BOOK_NO = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BookDTO.class), book_no);
	}
	
	public int insertBook(BookDTO book) {
		return 0;
	}
	
	public int updateBook(BookDTO book) {
		return 0;
	}
	
	public int deleteBook(Long book_no) {
		return 0;
	}
	
}
