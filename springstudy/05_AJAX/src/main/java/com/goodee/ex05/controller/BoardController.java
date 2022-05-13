package com.goodee.ex05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping(value="/board")  // ${contextPath}/board 요청이 오면,
	public String board() {
		return "board";          // board.jsp로 이동하자.
	}
	
	
	
}
