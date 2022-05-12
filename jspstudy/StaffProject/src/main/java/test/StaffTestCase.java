package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.StaffDTO;
import respository.StaffDAO;

public class StaffTestCase {
	
	@Test
	void 등록테스트() {
		StaffDTO staff = StaffDTO.builder()
				.sno("99999")
				.name("김기획")
				.dept("기획부")
				.salary(5000L)
				.build();
		
		int res = 0;
		try {
			res = StaffDAO.getInstance().insertStaff(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1, res, "제품등록실패");
		
	}
	
	@Test
	void 조회테스트() {
		StaffDTO staff = StaffDAO.getInstance().selectStaffSno("99999");
		assertNotNull(staff);
	}
	
	
	
	
	
}
