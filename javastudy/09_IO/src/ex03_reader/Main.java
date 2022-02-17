package ex03_reader;

import java.io.FileReader;
import java.io.IOException;

public class Main {

	
	// FileReader : 텍스트 파일을 읽을 때 사용
	
	// FileReader 입력 단위
	// 1. 1글자 : int
	// 2. 여러글자 : char[]
	public static void m1() {
		
		try {
			
			// 입력 스트림 생성
			FileReader fr = new FileReader("C:\\storage\\m2.txt");
			
			// 문자 저장 변수
			int c;
			
			// read 메소드
			// 1. 문자 반환
			// 2. -1 반환 (모두 읽은 경우)
			/*
			while(true) {
				c = fr.read();
				if(c == -1)
					break;
				System.out.print((char)c);
			}
			*/
			while((c = fr.read()) != -1) {
				System.out.print((char)c);
			}
			
			// 입력 스트림 닫기
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void quiz1() {
		
		try {
			
			// 입력 스트림 생성
			FileReader fr = new FileReader("C:\\storage\\m2.txt");
			
			// 문자 저장 변수
			int c;
			
			// read 메소드
			// 1. 문자 반환
			// 2. -1 반환 (모두 읽은 경우)
		
			StringBuilder sb = new StringBuilder();
			while((c = fr.read()) != -1) {
				sb.append((char)c);
			}
			
			// 확인
			System.out.println(sb.toString());
			
			// 입력 스트림 닫기
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void m2() {
		
		try {
			
			// 입력 스트림 생성
			FileReader fr = new FileReader("C:\\storage\\m2.txt");
			
			// 5글자를 저장할 배열
			char[] cbuf = new char[5];
			
			// 읽기
			while(true) {
				
				int readCount = fr.read(cbuf);
				
				// m2.txt 파일 순회 과정
				//          readCount    cbuf
				// 순회1     5           A   p   p   l   e
				// 순회2     5           \n  M   a   n   g
				// 순회3     1           o   M   a   n   g
				//                       --  -------------  
				//             새로 읽은 o   기존에 있던 Mang
				// 순회4    -1
				
				if(readCount == -1)
					break;
				
				// 배열 cbuf 순회는 readCount만큼 처리
				for(int i = 0; i < readCount; i++)
					System.out.print(cbuf[i]);
				
			}
			
			// 입력 스트림 닫기
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		m2();
	}

}
