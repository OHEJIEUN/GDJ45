package com.goodee.ex09.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goodee.ex09.domain.NoticeDTO;
import com.goodee.ex09.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/notice/list")
	public String list(Model model) {
		model.addAttribute("notices", noticeService.findNotices());
		return "notice/list";
	}
	
	
	@PostMapping("/notice/save")
	// public String save(@RequestParam String title, @RequestParam String content)
	// public String save(NoticeDTO notice)
	public String save(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		NoticeDTO notice = new NoticeDTO();
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		int res = noticeService.save(notice);
	}
	
	
	
	
	
	
	
	
	
	
}
