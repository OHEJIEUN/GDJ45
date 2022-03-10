package dao;

// Singleton Pattern
// 1. 인스턴스를 하나만 만들 수 있는 패턴이다.
// 2. 방법
//     1) 인스턴스를 하나만 선언한다.
//     2) 인스턴스를 외부에서 못 만들게 한다.
//     3) getInstance() 메소드를 호출하면 선언한 인스턴스를 생성한 다음 반환한다.
//        이미 생성했다면 그냥 반환한다.

public class ProductDAO {
	
	// dao는 필드이므로 기본 null 상태이다.
	// 클래스 메소드인 getInstance() 메소드에서는
	// 클래스 변수만 사용할 수 있다.
	private static ProductDAO dao;

	// private 생성자
	// 클래스 외부에서는 생성자를 호출할 수 없다.(인스턴스 생성을 할 수 없다.)
	private ProductDAO() {
		
	}
	
	// 인스턴스가 없는 상태로 getInstance() 메소드를 호출해야 하므로
	// 클래스 메소드로 처리해야 한다.(static)
	public static ProductDAO getInstance() {
		if(dao == null)
			dao = new ProductDAO();
		return dao;
	}
	
	
	
}
