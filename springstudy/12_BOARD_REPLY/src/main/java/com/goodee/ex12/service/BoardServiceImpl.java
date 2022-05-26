package com.goodee.ex12.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		model.addAttribute("paging", pageUtils.getPaging(request.getContextPath() + "/board/list"));
		
	}
	
	@Override
	public void findBoardByNo(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int save(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
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
