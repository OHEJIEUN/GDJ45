package com.goodee.ex05.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.goodee.ex05.service.MemberService;
import com.goodee.ex05.service.MemberServiceImpl;

@Controller
public class MemberController {

	
	// 컨트롤러는 언제나 Service를 호출합니다.
	// 그래서 Service를 field로 등록합니다.
	
	// DI를 사용 안 하는 경우
	// 개발자가 직접 필요한 Bean을 생성하는 방법
	// private MemberService memberService = new MemberServiceImpl();
	
	// DI를 사용하는 경우
	// root-context.xml에 등록한 Bean을 스프링이 가져오는 방법
	
	// 필드, 생성자, setter 방식 중 필드 주입 방식 사용해 봅니다.
	@Autowired
	private MemberService memberService;
		
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/member")
	public String member() {
		return "member";
	}
	
	@GetMapping(value="/member/detail1")
	public String detail1(HttpServletRequest request) {  // 파라미터 id와 pw를 request로 받는다.
		memberService.detail1(request);
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
}
