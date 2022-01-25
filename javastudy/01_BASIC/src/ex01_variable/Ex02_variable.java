package ex01_variable;

public class Ex02_variable {

	public static void main(String[] args) {
		
		// 변수(variable)
		// 1. 컴퓨터의 메모리(램)에 확보되는 데이터 저장 공간
		// 2. 메모리(램)는 1바이트마다 고유번호(0부터 시작하는 16진수)를 부여
		// 3. 주소(address) : 1바이트마다 부여된 메모리의 고유번호
		
		// 1. byte 타입
		//    1) 1바이트
		//    2) 정수
		//    3) 모든 데이터의 최소 단위를 의미함
		
		// 2. short 타입
		//    1) 2바이트
		//    2) 정수
		//    3) 과거용

		// 3. int 타입
		//    1) 4바이트
		//    2) 정수 (기본 단위)
		//    3) 가용범위 : -2,147,483,648 ~ 2,147,483,647
		
		int myAge = 45;
		System.out.println(myAge);
		
		// 4. long 타입
		//    1) 8바이트
		//    2) 정수
		//    3) suffix (접미사)가 L(l)
		
		long myMoney = 50000L;
		System.out.println(myMoney);
		
		// 1바이트 = 8비트
		
		//          갯수       범위
		// 1비트    2         
        // 2비트    4         
		// 3비트    8         
		// ...
		// n비트    2의 n제곱  -(2의 n-1제곱) ~ (2의 n-1제곱) - 1
		
		
		
		
		
		
		
		
	}

}
