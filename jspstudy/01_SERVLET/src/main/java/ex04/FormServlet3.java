package ex04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet3")
public class FormServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormServlet3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 요청(request)
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// radio는 하나만 선택할 수 있으므로 하나의 값만 온다.
		String gender = request.getParameter("gender");
		
		// checkbox는 여러 개를 선택할 수 있으므로 여러 개의 값이 온다.
		String[] hobbies = request.getParameterValues("hobbies");
		
		// 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
