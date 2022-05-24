package com.goodee.ex11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/employee/searchPage")
	public String searchPage() {
		return "employee/search";
	}
	
}
