package service;

import java.util.Scanner;

import dao.ProductDAO;

public class ProductService {

	// 필드
	private Scanner sc;
	private ProductDAO dao;
	
	// 생성자
	public ProductService() {
		sc = new Scanner(System.in);
		dao = ProductDAO.getInstance();
	}
	
	// 제품등록
	public void addProduct() {
		System.out.println("===제품등록===");
		System.out.print("제품명 >>> ");
		String name = sc.next();
		System.out.print("제품가격 >>> ");
		int price = sc.nextInt();
		int res = dao.insertProduct(name, price);
		if(res > 0)
			System.out.println("===" + name + " 등록 성공===");
		else
			System.out.println("===" + name + " 등록 실패===");
	}
	// 제품삭제
	public void removeProduct() {
		
	}
	// 제품수정
	public void modifyProduct() {
		
	}
	// 제품조회
	public void findProduct() {
		
	}
	// 전체조회
	public void findAllProducts() {
		
	}
	// 실행
	public void execute() {
		while(true) {
			System.out.print("1.추가 2.삭제 3.수정 4.조회 5.전체 0.종료 >>> ");
			int choice = sc.nextInt();
			sc.nextLine();  // 1~0 숫자 입력 후 누른 Enter키 제거
			switch(choice) {
			case 1 : addProduct(); break;
			case 2 : removeProduct(); break;
			case 3 : modifyProduct(); break;
			case 4 : findProduct(); break;
			case 5 : findAllProducts(); break;
			case 0 : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("선택을 다시 하세요.");
			}
		}
	}
	
}
