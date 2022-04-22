package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import repository.BoardDAO;

public class DetailService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// <a href="detail.do?no=1">제목</a>
		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		Long no = Long.parseLong(optNo.orElse("0"));
		
		// 조회수 늘리기
		// UPDATE 이후에는 redirect를 해야 한다. (물론 아몰랑~하고 forward 할 수도 있음)
		int res = BoardDAO.getInstance().updateHit(no);
		if(res == 0) {
			return new ActionForward("/DBCP_PRAC/list.do", true);
		}
		
		// 조회 결과 board를 request에 저장하면 redirect 할 때 전달되지 않으니까
		// session에 저장한다.
		HttpSession session = request.getSession();
		session.setAttribute("board", BoardDAO.getInstance().selectBoardByNo(no));
		return new ActionForward("board/detail.jsp", true);
		
	}

}
