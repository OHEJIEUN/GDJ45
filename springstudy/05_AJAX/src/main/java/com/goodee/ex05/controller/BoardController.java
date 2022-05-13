package com.goodee.ex05.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.ex05.domain.BoardDTO;
import com.goodee.ex05.service.BoardService;

@Controller
public class BoardController {

	private BoardService boardService;
	
	// 생성자는 @Autowired를 안 적어도 됩니다.
	public BoardController(BoardService boardService) {  // root-context.xml에 정의한 bean이 매개변수 BoardService boardService로 주입됩니다.
		super();
		this.boardService = boardService;
	}

	@GetMapping(value="/board")  // ${contextPath}/board 요청이 오면,
	public String board() {
		return "board";          // board.jsp로 이동하자.
	}
	
	@ResponseBody
	@GetMapping(value="/board/detail1",
			produces="application/json; charset=UTF-8")
	public BoardDTO detail1(HttpServletRequest request) {
		return boardService.detail1(request);
	}
	
	@ResponseBody
	@GetMapping(value="/board/detail2",
			produces="application/json; charset=UTF-8")
	public BoardDTO detail2(String title, Long hit) {
		return boardService.detail2(title, hit);
	}
	
	@ResponseBody
	@PostMapping(value="/board/detail3",
			produces="application/json; charset=UTF-8")
	public Map<String, Object> detail3(@RequestBody BoardDTO board) {
		return boardService.detail3(board);
	}
	
	@ResponseBody
	@PostMapping(value="/board/detail4",
			produces="application/json; charset=UTF-8")
	public BoardDTO detail4(@RequestBody Map<String, Object> map) {
		return boardService.detail4(map);
	}
	
}
