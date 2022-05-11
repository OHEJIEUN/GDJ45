package com.goodee.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.goodee.ex03.domain.Board;

@Controller
public class BoardController {

	
	// Spring4부터 새로운 애너테이션이 지원됩니다.

	// @GetMapping("/")  == @RequestMapping(value="/", method=RequestMethod.GET)
	// @PostMapping("/") == @RequestMapping(value="/", method=RequestMethod.POST)
	
	
	@GetMapping("/")
	public String index() {
		return "index";  // 뷰 리졸버에 의해서 "/WEB-INF/views/index.jsp"로 변환됩니다.
	}
	
	
	// field
	private Board board1;
	
	// @GetMapping("board/detail")   이걸 사용할 거지만,
	// @GetMapping("/board/detail")  매핑이 슬래시(/)로 시작해도 됩니다.
	
	@GetMapping("board/detail")
	public String board1() {
		
		return "board/detail";  // 뷰 리졸버에 의해서 return "/WEB-INF/views/board/detail.jsp" 변환됩니다.
	}
	
	
	
	
	
	
}
