package dml;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connect.MyConnection;

public class DMLMain {

	// DML : INSERT, UPDATE, DELETE
	// COMMIT과 ROLLBACK을 사용할 필요가 있으나,
	// JDBC는 Auto Commit을 사용하므로 코드를 작성할 필요가 없다.
	
	// INSERT, UPDATE, DELETE문을 처리하는 자바 코드는 동일하다.
	
	// INSERT
	public static void insert1() {
		
		/* DB접속     */  Connection con = null;
		/* 쿼리문실행 */  PreparedStatement ps = null;
		/* 실행결과   */  int res = 0;
		/* 쿼리문자체 */  String sql = null;
		
		try {

			// 1. DB접속
			// MyConnection 클래스의 getConnection 메소드를 호출하면 된다.
			con = MyConnection.getConnection();
			
			// 2. 쿼리문작성
			//    쿼리문자체에는 세미콜론이 마지막에 포함되지 않는다.
			sql = "INSERT INTO BOARDS(NO, TITLE, HIT, CREATED) VALUES(BOARDS_SEQ.NEXTVAL, '긴급공지', 0, TO_DATE('22/03/07', 'YY/MM/DD')";
			
			// 3. 쿼리문실행 인스턴스 ps 생성
			//    쿼리문을 미리 준비해서 전달해야 한다.
			ps = con.prepareStatement(sql);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		insert1();
	}

}
