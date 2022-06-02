package com.goodee.ex14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {

	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/gallery/list")
	public String list() {
		return "gallery/list";
	}
	
	@GetMapping("/gallery/savePage")
	public String savePage() {
		return "gallery/save";
	}
	
	
	
}
