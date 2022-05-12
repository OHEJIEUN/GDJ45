package com.goodee.ex04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodee.ex04.domain.Member;

@Controller
public class Controller1 {

	@GetMapping("/")     // http://localhost:9090/ex04 이 주소로 연결되면,
	public String index() {
		return "index";  // index.jsp로 갑니다.
	}
	
	
	@GetMapping("/detail1")  // <a href="${contextPath}/detail1?name=민경태&age=45">
	public String detail1(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(name, age);
		request.setAttribute("member", member);
		
		return "detail";     // detail.jsp로 forward 합니다.
		
	}
	
	
	@GetMapping("/detail2")  // <a href="${contextPath}/detail2?name=민경태&age=45">
	public String detail2(HttpServletRequest request, Model model) {
		
		// 요청은 request가 처리한다.
		// forward 할 데이터를 model이 처리한다.
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(name, age);
		
		// 스프링에서 사용하는 데이터 전달용 Model
		// 내부적으로는 request를 사용해서 전달한다.
		// model을 사용함으로써 보안이 향상된다.
		// 대부분 Model을 쓴다.
		model.addAttribute("member", member);  // 사실 request.setAttribute("member", member)와 같다.
		
		return "detail";     // detail.jsp로 forward 합니다.
		
	}
	
	
	@GetMapping("/detail3")  // <a href="${contextPath}/detail3?name=민경태&age=45">
	public String detail3(@RequestParam(value="name") String name, // 파라미터 name을 String name에 저장해 주세요.
						@RequestParam(value="age") int age) {      // 파라미터 age를 int age에 저장해 주세요.
		
		System.out.println(name);
		System.out.println(age);
		
		return "";
		
	}
	
	
	
	
	
	
	
	
	
	
}
