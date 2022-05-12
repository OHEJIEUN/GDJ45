package test;


import domain.StaffDTO;
import repository.StaffDAO;

class StaffTestCase {

	// @BeforeEach  // JUnit 테스트 이전에 실행되는 메소드이다.
	void 제품등록테스트() {
		
		// 등록할 제품 생성
		StaffDTO staff = StaffDTO.builder()
				.sno("1111")
				.name("설경구")
				.dept("기획부")
				.salary(5000)
				.build();
		int res =0;
		try {
			res = StaffDAO.getInstance().insertStaff(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1, res, "저장할 수 없는 값이 전달되었습니다.");
	}

}