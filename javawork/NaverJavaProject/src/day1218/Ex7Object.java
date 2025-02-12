package day1218;

class Apple {
	// 접근 지정자 생략 시 default가 되는데 같은 패키지에서는
	// private을 제외하고 모두 직접 접근 가능하다
	static String message="Hello"; // 클래스 멤버 변수
	static final String EMP="비트캠프"; // 상수
	String name="간디"; // 인스턴스 멤버 변수 : 생성자를 통해 인스턴스를 생성해야만 값을 가져올 수 있다
}
//////////

public class Ex7Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 다른 클래스의 static 변수는 클래스명.변수명 이렇게 접근한다.
		System.out.println("메세지: "+Apple.message);
		System.out.println("EMP: "+Apple.EMP);

		Apple.message="Happy";
		System.out.println("메세지: "+Apple.message);
		
//		Apple.EMP="const"; // final 상수는 값 변경 불가
		
		// 다른 클래스의 인스턴스 멤버 변수를 접근하려면 new로 생성된 인스턴스 변수가 있어야 한다.
		Apple apple = new Apple();
		System.out.println(apple.name);
//		System.out.println(Apple.name); // 에러
		apple.name="미라";
		Apple a = new Apple();
		System.out.println("apple: "+apple.name+"\na: "+a.name); // 각 인스턴스마다 다른 값으로 인식
	}

}
