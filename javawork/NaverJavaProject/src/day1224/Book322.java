package day1224;

//class Vehicle {
//	public void run() {
//		System.out.println("차량이 달립니다");
//	}
//}
//// abstract 클래스에는 일반메서드도 올 수 있고 추상메서드도 올 수 있다
//abstract class Vehicle {
//	public abstract void run();
//}
// abstract method 만 있을 경우 인터페이스로 대체 가능
interface Vehicle {
	public void run();
}
///////////
//class Bus extends Vehicle {
class Bus implements Vehicle {
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}
}
///////////
//class Taxi extends Vehicle {
class Taxi implements Vehicle {
	@Override
	public void run() {
		System.out.println("택시가 달립니다");
	}
}
///////////
class Driver {
	// 매개변수 다형성
	public void drive(Vehicle vehicle) {
		vehicle.run();
	}
}
public class Book322 {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		driver.drive(bus);
		
		Taxi taxi=new Taxi();
		driver.drive(taxi);
		
	}
}
