package com.goodee.ex05.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.ex05.domain.MemberDTO;
import com.goodee.ex05.service.MemberService;

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
		return "index";  // index.jsp
	}
	
	@GetMapping(value="/member")
	public String member() {
		return "member";  // member.jsp
	}
	
	
	// 컨트롤러의 메소드는 기본적으로 JSP이름을 반환한다.
	
	// Ajax는 JSP이름을 반환하는 것이 아니라
	// 자신을 호출한 JSP로 값을 반환하는 구조이다.
	
	// 값을 반환하기 위해서는
	// @ResponseBody 애너테이션이 필요하다.
	
	
	@GetMapping(value="/member/detail1", 
			produces="text/plain; charset=UTF-8")  // 내가 반환하는 건 텍스트입니다.(응답 타입 response.setContentType)

	@ResponseBody  // 내가 반환하는 건 JSP이름이 아니라 어떤 값(텍스트, XML, JSON 등)이에요.

	public String detail1(HttpServletRequest request) {  // 파라미터 id와 pw를 request로 받는다.
		String res = memberService.detail1(request);
		return res;  // memberService의 detail1() 메소드에서 만든 텍스트를 member.jsp로 반환한다.
	}
	
	
	
	
	@GetMapping(value="/member/detail2",
			produces="application/json; charset=UTF-8")  // 내가 반환하는 값은 JSON입니다.

	@ResponseBody  // 내가 반환하는 건 JSP이름이 아니에요. 난 값을 반환해요.
	
	// 반환타입 MemberDTO는 jackson에 의해서 JSON 데이터로 자동 변환됩니다.
	
	public MemberDTO detail2(@RequestParam(value="id") String id,   // 파라미터 id는 String id에 저장해 주세요.
							@RequestParam(value="pw") String pw) {  // 파라미터 pw는 String pw에 저장해 주세요.
		
		MemberDTO member = memberService.detail2(id, pw);
		
		// jackson이 하는 일
		// 자바 객체 member를 자동으로 {"id": 아이디, "pw": 비밀번호} 로 만들어 줍니다.
		
		return member;  // 자바 객체를 member.jsp로 반환하는데, 이 때 jackson이 개입해서 member를 {"id": 아이디, "pw": 비밀번호} 로 바꿔줍니다.
		                // 물론, JSON으로 바꿔서 보내라고 말은 해 줘야 되는데 그건 produces에서 처리합니다.

		// 실제 return은
		// return {"id": 아이디, "pw": 비밀번호}; 인 것이다. 
		
	}
	
	
	
	@GetMapping(value="/member/detail3",
			produces="application/json; charset=UTF-8")  // 내가 반환하는 값은 JSON입니다.
	
	@ResponseBody  // 내가 반환하는 건 JSP이름이 아니에요. 난 값을 반환해요.
	
	// 반환타입 Map은 jackson에 의해서 JSON 데이터로 자동 변환됩니다.
	
	public Map<String, Object> detail3(MemberDTO member) {  // MemberDTO member의 setId와 setPw가 파라미터 id와 pw를 받아줍니다.
		
		Map<String, Object> res = memberService.detail3(member);
		
		return res;  // Map을 반환하고 있지만 produces에서 반환타입이 JSON이라고 했기 때문에,
		             // jackson이 개입해서 Map을 JSON 데이터로 바꿔 줍니다.
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
