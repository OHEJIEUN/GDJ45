package ex06_input_stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

	// FileInputStream : 모든 파일을 읽음
	
	// FileInputStream 입력 단위
	// 1. 1개    : int
	// 2. 여러개 : byte[]
	public static void m1() {
		
		try {
			
			// 입력 스트림 생성
			FileInputStream fis = new FileInputStream("C:\\storage\\b1.txt");
			
			// 사용 변수 및 인스턴스
			StringBuilder sb = new StringBuilder();
			byte[] b = new byte[5];  // 바이트 수는 임의로 조정
			int readCount;
			
			// read 메소드
			// int readCount = fis.read(b);  읽은 내용은 배열 b에 저장, 읽은 바이트 수는 readCount에 저장
			while((readCount = fis.read(b)) != -1) {
				
				// byte[] b를 String으로 변환
				// new String(b, 0, readCount) : 배열 b의 인덱스 0부터 readCount만큼만 문자열로 변환
				
				// b1.txt 파일은 오직 영문(1글자는 1바이트)으로만 구성되므로
				// byte[]에 읽는 것이 문제 없음
				
				sb.append( new String(b, 0, readCount) );
				
			}
			
			// 확인
			System.out.println(sb.toString());
			
			// 입력 스트림 닫기
			fis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// InputStreamReader : 바이트 기반 입력 스트림(InputStream)을 
	//                     문자 기반 입력 스트림(Reader)으로 변환
	public static void m2() {
		
		try {
			
			// 입력 스트림 생성(InputStream)
			InputStream is = new FileInputStream("C:\\storage\\b2.bin");
			
			// 문자 기반 스트림
			InputStreamReader isr = new InputStreamReader(is);
			
			// 버퍼
			BufferedReader br = new BufferedReader(isr);
			
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			
			System.out.println(sb.toString());
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		m2();
	}

}
