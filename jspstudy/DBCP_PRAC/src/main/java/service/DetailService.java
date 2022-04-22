package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDAO;

public class DetailService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// <a href="detail.do?no=1">제목</a>
		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		Long no = Long.parseLong(optNo.orElse("0"));
		
		// 조회 결과 board를 request에 저장하고 detail.jsp로 forward
		request.setAttribute("board", BoardDAO.getInstance().selectBoardByNo(no));
		return new ActionForward("board/detail.jsp", false);
		
	}

}
