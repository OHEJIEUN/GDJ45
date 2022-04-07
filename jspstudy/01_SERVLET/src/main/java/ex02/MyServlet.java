package ex02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청(request)
		
		// 1) 요청에 포함된 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 2) 파라미터(Parameter) 확인
		//    (1) URL?파라미터=값
		//    (2) URL?파라미터=값&파라미터=값
		//    (3) 모든 파라미터는 String이다.
		//    (4) 파라미터 확인 메소드는 getParameter()이다.
		String name = request.getParameter("name");
		
		String strAge = request.getParameter("age");
		int age = 0;
		if(strAge != null) {
			age = Integer.parseInt(strAge);
		}
		
		// 3) 파라미터 콘솔에 출력하기
		System.out.println("이름 " + name);
		System.out.println("나이 " + age);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
