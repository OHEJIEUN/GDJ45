package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class StaffDTO {

	private String sno;
	private String name;
	private String dept;
	private Long salary;
}
