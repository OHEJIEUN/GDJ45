package com.goodee.ex15.util;

public class SecurityUtils {

	// XSS
	public static String xss(String str) {
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("\'", "&#x27;");
		str = str.replaceAll("&", "&amp;");
		return str;
	}
	
	// 인증코드
	public static String authCode(int length) {
		// 문자   아스키코드값
		// '0'    48
		// '1'    49
		// ...
		// 'A'    65
		// 'B'    66
		// ...
		// 'a'    97
		// 'b'    98
		// ...
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			if(Math.random() < 0.5) {
				sb.append( (char)((int)(Math.random() * 10) + '0') );
			} else {
				sb.append( (char)((int)(Math.random() * 26) + 'A') );
			}
		}
		return sb.toString();
	}
	
	
	
	
	
}
