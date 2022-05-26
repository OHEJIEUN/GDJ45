package com.goodee.ex12.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.goodee.ex12.domain.BoardDTO;
import com.goodee.ex12.mapper.BoardMapper;
import com.goodee.ex12.util.PageUtils;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void findBoards(HttpServletRequest request, Model model) {
		
//		int page = 1;
//		String strPage = request.getParameter("page");
//		if(strPage != null) {
//			page = Integer.parseInt(strPage);
//		}

		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		int totalRecord = boardMapper.selectBoardCount();
		
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(totalRecord, page);
		
		Map<String, Object> map = new HashMap<>();
		map.put("beginRecord", pageUtils.getBeginRecord());
		map.put("endRecord", pageUtils.getEndRecord());
		
		List<BoardDTO> boards = boardMapper.selectBoardList(map);
		
		model.addAttribute("boards", boards);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("paging", pageUtils.getPaging1(request.getContextPath() + "/board/list"));
		
	}
	
	@Override
	public void findBoardByNo(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional  // save() 메소드에 있는 모든 쿼리문은 모두 성공해야 합니다. 하나라도 실패하면 전부 실패처리 합니다.
	@Override
	public int save(HttpServletRequest request) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 어딘가를 경유해서 작성된 게시글의 IP는 요청헤더 X-Forwarded-For에 저장된다.
		// 직접 전달된 게시글은 요청헤더 X-Forwarded-For값이 없다.
		String ip = request.getHeader("X-Forwarded-For");
		if(ip == null) {
			ip = request.getRemoteAddr();
		}
		
		BoardDTO board = BoardDTO.builder()
				.writer(writer)
				.title(title)
				.content(content)
				.ip(ip)
				.build();
		
		return boardMapper.insertBoard(board);
		
	}
	
	@Override
	public int change(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int remove(Long boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
