package dbcp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductAddService implements ProductService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
			
		/* 1. 파일 업로드 */
		
		// 1) 업로드 할 디렉터리 경로 알아내기(서버 내부 realPath)
		String realPath = request.getServletContext().getRealPath("storage");
		
		// 2) 업로드 할 디렉터리 없으면 만들기
		File dir = new File(realPath);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		// 3) MultipartRequest 인스턴스 만들기
		//    여기서 업로드가 진행된다.
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(
				request, 
				realPath, 
				1024 * 1024 * 10, 
				"UTF-8", 
				new DefaultFileRenamePolicy());
		} catch (IOException e) {
			message(response, "파일 첨부가 실패했습니다.");
		}
		
		// 2. DB 저장
		String name = mr.getParameter("name");
		Integer price = Integer.parseInt(mr.getParameter("price"));
		String image = mr.getFilesystemName("filename");
		ProductDTO product = ProductDTO.builder()
				.name(name)
				.price(price)
				.image(image)
				.build();
		try {
			int res = ProductDAO.getInstance().insertProduct(product);
		} catch(SQLIntegrityConstraintViolationException e) {  // UNIQUE, NOT NULL
			message(response, "동일한 제품명이 이미 등록되어 있거나\n 필수 정보가 누락되었습니다.");
		} catch(SQLException e) {  // COLUMN TYPE, SIZE
			message(response, "저장할 수 없는 데이터가 포함되어 있습니다.");
		} catch(Exception e) {
			message(response, "알 수 없는 예외가 발생했습니다.");
		}
		
		return null;
		
	}
	
	// 3. 예외 처리(예외에 따른 응답 만들기)
	public void message(HttpServletResponse response, String msg) {
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" + msg + "')");
			out.println("history.back()");
			out.println("</script>");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
