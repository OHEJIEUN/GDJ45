package ex04_string;

public class Ex01_String {

	public static void main(String[] args) {
		
		// 1. 길이
		String str = "java";
		int length = str.length();
		System.out.println(length);
		
		// 2. 특정 문자 추출
		char ch = str.charAt(0);
		System.out.println(ch);
		
		// 문제. "abc124def" 문자열에서 아라비아 숫자 "123" 제외하고 출력하기
		String str2 = "abc123def";
		for(int i = 0; i < str2.length(); i++) {
			if(str2.charAt(i) >= '0' && str2.charAt(i) <= '9') {  // if(str2.charAt(i) >= 48 && str2.charAt(i) <= 57) {
				continue;
			}
			System.out.print(str2.charAt(i));
		}
		
		System.out.println();  // 줄 바꿈
		
		// 위 코드를 리팩토링 해보기
		// 기준 : 동일한 메소드를 여러 번 호출하면 성능이 안 좋다.
		//        가능하면 메소드는 한 번만 호출하기
		String str3 = "abc123def";
		for(int i = 0, len = str3.length(); i < len; i++) {
			char c = str3.charAt(i);
			if(c >= '0' && c <= '9') {
				continue;
			}
			System.out.print(c);
		}
		
		System.out.println();
		
		// 3. 동등 비교
		String str4 = "JAVA";
		boolean res1 = str4.equals("java");
		boolean res2 = str4.equalsIgnoreCase("java");  // 대소문자 무시하고 비교
		System.out.println(res1);
		System.out.println(res2);
		
		// 4. 일부 문자열 추출
		//    1) substring(begin) : 인덱스 begin(포함)부터 끝까지 추출
		//    2) substring(begin, end) : 인덱스 begin(포함)부터 인덱스 end(불포함) 이전까지 추출
		String str5 = "hello";
		String res3 = str5.substring(2);
		String res4 = str5.substring(0, 4);
		System.out.println(res3);
		System.out.println(res4);
		
		// 5. 특정 문자열의 인덱스 반환
		//    1) indexOf     : 발견된 첫 번째 인덱스 반환
		//    2) lastIndexOf : 발견된 마지막  인덱스 반환
		String str6 = "java";
		
		int idx1 = str6.indexOf("j");  //  0
		int idx2 = str6.indexOf("a");  //  1 (발견된 첫 번째 인덱스 반환)
		int idx3 = str6.indexOf("z");  // -1 (없는 경우)
		System.out.println(idx1);
		System.out.println(idx2);
		System.out.println(idx3);
		
		int idx4 = str6.lastIndexOf("j");  //  0
		int idx5 = str6.lastIndexOf("a");  //  3 (발견된 마지막 인덱스 반환)
		int idx6 = str6.lastIndexOf("z");  // -1 (없는 경우)
		System.out.println(idx4);
		System.out.println(idx5);
		System.out.println(idx6);
		

	}

}
