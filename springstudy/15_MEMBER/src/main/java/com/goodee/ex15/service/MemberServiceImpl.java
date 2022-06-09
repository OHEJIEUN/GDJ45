package com.goodee.ex15.service;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.ex15.domain.MemberDTO;
import com.goodee.ex15.mapper.MemberMapper;
import com.goodee.ex15.util.SecurityUtils;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Map<String, Object> idCheck(String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("res", memberMapper.selectMemberById(id));
		return map;
	}
	
	@Override
	public Map<String, Object> emailCheck(String email) {
		Map<String, Object> map = new HashMap<>();
		map.put("res", memberMapper.selectMemberByEmail(email));
		return map;
	}
	
	@Override
	public Map<String, Object> sendAuthCode(String email) {
		
		// 인증코드
		String authCode = SecurityUtils.authCode(6);    // 6자리 인증코드
		System.out.println(authCode);
		
		// 필수 속성
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");  // 구글 메일로 보냅니다.
		props.put("mail.smtp.port", "587");             // 구글 메일 보내는 포트.
		props.put("mail.smtp.auth", "true");            // 인증되었다.
		props.put("mail.smtp.starttls.enable", "true"); // TLS 허용한다.
		
		// 메일을 보내는 사용자 정보
		final String USERNAME = "forspringlec@gmail.com";
		final String PASSWORD = "ukpiajijxfirdgcz";     // 발급 받은 앱 비밀번호
		
		// 사용자 정보를 javax.mail.Session에 저장
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});
		
		/*
			이메일 보내기
			1. 사용자 정보는 구글 메일만 가능합니다.
			2. 가급적 구글 부계정을 만들어서 사용하세요.
			3. 구글 로그인 - Google 계정 - 보안
			    1) 2단계 인증 - 사용
			    2) 앱 비밀번호
			        (1) 앱 선택 - 기타 (앱 이름은 마음대로)
			        (2) 기기 선택 - Windows 컴퓨터
			        (3) 생성 버튼 - 16자리 비밀번호를 생성해 줌
		*/
		
		// 이메일 전송하기
		try {
			
			Message message = new MimeMessage(session);
			
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			message.setFrom(new InternetAddress(USERNAME, "인증코드관리자"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("인증 요청 메일입니다.");
			message.setText("인증번호는 " + authCode + "입니다.");
			
			Transport.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("authCode", authCode);
		return map;
		
	}
	
	@Override
	public void signIn(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터
		String id = SecurityUtils.xss(request.getParameter("id"));        // 크로스 사이트 스크립팅
		String pw = SecurityUtils.sha256(request.getParameter("pw"));     // SHA-256 암호화
		String name = SecurityUtils.xss(request.getParameter("name"));    // 크로스 사이트 스크립팅
		String email = SecurityUtils.xss(request.getParameter("email"));  // 크로스 사이트 스크립팅
		String location = request.getParameter("location");
		String promotion = request.getParameter("promotion");
		int agreeState = 1;  // 필수 동의
		if(location.equals("location") && promotion.equals("promotion")) {
			agreeState = 4;  // 필수 + 위치 + 프로모션 동의
		} else if(location.equals("location") && promotion.isEmpty()) {
			agreeState = 2;  // 필수 + 위치 동의
		} else if(location.isEmpty() && promotion.equals("promotion")) {
			agreeState = 3;  // 필수 + 프로모션 동의
		}
		
		// MemberDTO
		MemberDTO member = MemberDTO.builder()
				.id(id)
				.pw(pw)
				.name(name)
				.email(email)
				.agreeState(agreeState)
				.build();
		
		// MEMBER 테이블에 member 저장
		int res = memberMapper.insertMember(member);
		
		// 응답
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if(res == 1) {
				out.println("<script>");
				out.println("alert('회원 가입되었습니다.')");
				out.println("location.href='" + request.getContextPath() + "'");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('회원 가입에 실패했습니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
}
