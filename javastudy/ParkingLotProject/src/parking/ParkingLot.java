package parking;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {

	private String name;
	private List<Car> cars;
	private Scanner sc;
	
	public ParkingLot(String name) {
		this.name = name;
		cars = new ArrayList<Car>();
		sc = new Scanner(System.in);
	}
	
	public void addCar() {
		System.out.println("===차량 추가하기===");
		System.out.print("차량번호 >>> ");
		String carNo = sc.next();
		System.out.print("모델 >>> ");
		String model = sc.next();
		boolean res = cars.add( new Car(carNo, model) );
		if(res) {  // if(res == true) {
			System.out.println(carNo + " 차량이 추가되었습니다.");
		} else {
			System.out.println(carNo + " 차량이 추가되지 않았습니다.");
		}
	}
	
	public void deleteCar() throws RuntimeException {
		System.out.println("===차량 삭제하기===");
		System.out.print("제거할 차량번호 >>> ");
		String carNo = sc.next();
		/*
		for(int i = 0, size = cars.size(); i < size; i++) {
			Car car = cars.get(i);
			if(carNo.equals(car.getCarNo())) {
				System.out.println(carNo + " 차량이 삭제되었습니다.");
				cars.remove(i);
				return;
			}
		}
		*/
		for(Car car : cars) {
			if(carNo.equals(car.getCarNo())) {
				System.out.println(carNo + " 차량이 삭제되었습니다.");
				cars.remove(car);
				return;
			}
		}
		throw new RuntimeException("대상 차량이 없습니다.");
	}
	
	public void printAllCars() throws RuntimeException {
		System.out.println("===전체 조회하기===");
		if(cars.isEmpty()) {  // if(cars.size() == 0)
			throw new RuntimeException("주차장에 등록된 차량이 없습니다.");
		}
		System.out.println(name + " 차량 목록");
		for(Car car : cars)
			System.out.println(car);  // Car클래스의 toString 동작
	}
	
	public void manage() {
		while(true) {
			try {
				System.out.print("1.추가 2.삭제 3.전체 0.종료 >>> ");
				int choice = sc.nextInt();  // InputMismatchException 발생 가능성 있음
				sc.nextLine();  // 엔터제거가 목적입니다. 엔터입력은 nextLine()만 됩니다.
				switch(choice) {
				case 1: addCar();
						break;
				case 2: deleteCar();
						break;
				case 3: printAllCars();
						break;
				case 0: System.out.println("프로그램 종료");
						return;
				default:
						System.out.println("존재하지 않는 메뉴입니다.");
						throw new RuntimeException("존재하지 않는 메뉴입니다.");
				}
			} catch (InputMismatchException e) {
				System.out.println("메뉴 입력은 정수입니다.");
				sc.next();
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
