package com.goodee.ex16.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.ex16.domain.MemberDTO;

@Controller
public class MemberController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member/management")
	public String management() {
		return "member/manage";
	}
	
	@ResponseBody
	@PostMapping(value="/members", produces="application/json")
	public Map<String, Object> addMember(@RequestBody MemberDTO member, HttpServletResponse response){
		System.out.println(member);
		return null;
	}
	
	
	
	
	
	
	
}
