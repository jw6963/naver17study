package day1218;

public class Book219 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar = new Car();
		
		System.out.println("제작 회사: "+ myCar.company);
		System.out.println("모델명: "+ myCar.model);
		System.out.println("색깔: "+myCar.color);
		System.out.println("최고속도: "+myCar.maxSpeed);
		System.out.println("현재 속도: "+myCar.speed);

		myCar.speed = 60;
		System.out.println("수정된 속도: "+myCar.speed);
	}

}
