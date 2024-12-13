package day1213;

public class Ex5While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =10;
		// while은 조건이 맞지 않으면 한 번도 실행하지 않고 빠져나온다
		while(a<10) {
			System.out.println("loop");
		}
		
		// do~while은 일단 한 번 실행 후 조건을 비교하므로 조건이 맞지 않아도 최소 한 번은 문장이 실행된다
		do {
			System.out.println("do~while loop");
		} while(a<10);
		
		a=1;
		while(a<=10) {
			System.out.printf("%3d",a++);
		}
		System.out.println();
		// 조건을 while에 직접 사용하는 것이 좋지만 while 문 내부에 조건을 줘도 좋다
		a=1;
		while(true) {
			System.out.printf("%3d",a++);
			if (a>10) {
				break;
			}
		}
		System.out.println();
		a=1;
		do {
			System.out.printf("%3d",a++);
		} while(a<=10);

	}

}
