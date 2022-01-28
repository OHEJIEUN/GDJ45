package ex04_instance_array;

public class Company {

	private Employee[] employees;
	private int idx;  // 인덱스(자동으로 최초 0값을 가짐)
	
	public Company(int n) {
		employees = new Employee[n];
	}
	
	public void addEmployee(Employee employee) {
		if(idx == employees.length) {
			System.out.println("더 이상 직원을 뽑을 수 없습니다.");
			return;  // addEmployee 메소드 종료(반환타입이 void인 메소드는 return; 코드로 종료 가능)
		}
		employees[idx++] = employee;
	}
	
	public void printAllEmployee() {
		System.out.println("총 직원 수는 " + idx + "명입니다.");
		for(Employee employee : employees) {
			if (employee != null)
				System.out.println(employee.getName() + "(" + employee.getDept() + ")");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
