package day1218;

class Car {
	static String carcompany="현대";
	
	private String carName;
	private int carPrice;
	String company = "현대자동차";
	String model = "그랜저";
	boolean start;
	int speed;
	int maxSpeed = 350;
	String color="검정";
	
	public static void setCarCompany(String carCompany) {
		// static 메서드에서는 static 변수만이 접근가능하다
		Car.carcompany = carCompany;
	}
	
	public void setCarName(String carName) {
		this.carName=carName;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice=carPrice;
	}
	public String getCarName() {
		return this.carName; // this는 생략 가능
	}
	public int getCarPrice() {
		return this.carPrice;
	}
	// 한번에 설정
	public void setData(String carName, int carPrice) {
		this.carName=carName;
		this.carPrice=carPrice;
	}
}

public class Ex9Object {
	
	public static void writeCarInfo(Car myCar) {
		System.out.println("=".repeat(30));
		System.out.println("자동차명 : "+ myCar.getCarName());
		System.out.println("가격 : "+myCar.getCarPrice());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("기존 자동차 회사명: "+Car.carcompany);
		
		Car.setCarCompany("삼성");
		System.out.println("변경된 자동차 회사명: "+Car.carcompany);
		Car car1 = new Car();
		car1.setCarName("Sm5");
		car1.setCarPrice(3000);
		
		Car car2= new Car();
		car2.setData("소나타",3200);
		
		Car car3 = new Car();
		car3.setCarName("Mini");
		car3.setCarPrice(5000);
//		
//		System.out.println("car1 자동차명: "+car1.getCarName());
//		System.out.println("car1 자동차 가격: "+car1.getCarPrice());
//		System.out.println("=".repeat(30));
//		System.out.println("car2 자동차명: "+car1.getCarName());
//		System.out.println("car2 자동차 가격: "+car1.getCarPrice());
//		
		writeCarInfo(car1);
		writeCarInfo(car2);
		writeCarInfo(car3);
	}

}
