package com.goodee.ex05.service;

import javax.servlet.http.HttpServletRequest;

import com.goodee.ex05.domain.MemberDTO;

// 기능별로 메소드를 사용한다.

public interface MemberService {
	public String detail1(HttpServletRequest request);
	public MemberDTO detail2(String id, String pw);
}
