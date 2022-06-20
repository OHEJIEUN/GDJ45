package com.goodee.ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("name", "민경태");
		return "index";    //    /WEB-INF/index.jsp
	}
	
}
