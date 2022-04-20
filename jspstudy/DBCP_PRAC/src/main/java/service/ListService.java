package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDAO;

public class ListService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", BoardDAO.getInstance().selectBoardList());
		request.setAttribute("totalCount", BoardDAO.getInstance().selectBoardCount());
		return new ActionForward("board/list.jsp", false);
	}

}
