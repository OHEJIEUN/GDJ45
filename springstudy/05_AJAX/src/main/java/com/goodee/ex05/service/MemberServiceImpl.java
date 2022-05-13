package com.goodee.ex05.service;

import javax.servlet.http.HttpServletRequest;

public class MemberServiceImpl implements MemberService {

	@Override
	public String detail1(HttpServletRequest request) {
		System.out.println("detail1");
		return null;
	}

}
