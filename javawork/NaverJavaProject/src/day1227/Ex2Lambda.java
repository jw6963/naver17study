package day1227;

/*
 *  자바에서의 함수형 프로그램인 람다(Lambda) 표현식은 인터페이스를
 *  사용하는 익명 내부 클래스의 또 다른 표현식이다
 *  단, 인터페이스는 단 하나의 추상 메서드만 가지고 있어야 한다
 *  
 *  람다는 ^ 그리스어 알파벳의 11번째 글자이다
 */

@FunctionalInterface // 메서드가 하나인지 아닌지 검증하는 역할, 두 개일 경우 오류 발생
interface Orange {
	public void write();
}

interface DataAdd {
	public void add(int x, int y);
}

public class Ex2Lambda {

	Orange or =new Orange() {
		
		@Override
		public void write() {
			// TODO Auto-generated method stub
			System.out.println("오렌지 익명 내부 클래스 형태");
			
		}
	};
	
	public void lambdaMethod() {
		Orange orange1 = () -> { // ()는 파라미터
			System.out.println("람다식 오렌지 메서드 호출");
		};
		orange1.write();
		
		Orange orange2 = () -> {
			System.out.println("Hi Lambda");
		};
		orange2.write();
		
		DataAdd add1 = (int x, int y) -> {
			System.out.println(x+"+"+y+"="+(x+y));
		};
		add1.add(10, 3);
		add1.add(5, 2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2Lambda ex2 = new Ex2Lambda();
		ex2.or.write();
		ex2.lambdaMethod();

	}

}
