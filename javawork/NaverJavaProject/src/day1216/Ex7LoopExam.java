package day1216;

import java.util.Scanner;

public class Ex7LoopExam {
	
	public static void main(String[] args) {
		/*
		 * 1. 지수 승 구하기
		 * 2. 팩토리얼 구하기
		 * 3. 원의 넓이 구하기
		 * 4. 종료
		 * while 반복문에서 위의 메뉴가 나오면 번호를 입력하고 
		 * 해당 데이터를 입력 후 결과값을 출력하시오
		 * switch문
		 * 1번 : 두 수 x,y를 입력 후 x의 y승(for문)을 구하여 출력하시오
		 * 2번 : 숫자 n을 입력 후 n!의 값을 구하시오
		 * 3번 : 반지름 r을 입력하면 원의 넓이를 구해서 출력(반지름*반지름*Math.PI)
		 * 그 이외의 값이 들어오면 "종료합니다" 출력 후 프로그램을 종료하시오
		 */
		Scanner sc = new Scanner(System.in);
		int x,y,result; // 1번에 필요한 변수
		int n,fact; // 2번에 필요한 변수
		int r; // 3번에 필요한 변수
		double area; // 3번에 필요한 변수
		int menu; // 번호 입력받을 변수
		Loop:
		while(true) {
			System.out.printf("1. 지수 승 구하기\n2. 팩토리얼 구하기\n3. 원의 넓이 구하기\n4. 종료\n");
			menu=sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("[ 지수 승 구하기 ]");
				System.out.println("x와 y를 차례대로 입력하시오.");
				x=sc.nextInt();
				y=sc.nextInt();
				result = 1;
				for (int i=1; i<=y; i++) {
					result *=x;
				}
//				System.out.println(Math.pow(x, y));
				System.out.printf("%d의 %d승은 %d입니다.\n",x,y,result);
				break;
			case 2:
				System.out.println("[ 팩토리얼 구하기 ]");
				System.out.println("자연수 n을 입력하시오.");
				n=sc.nextInt();
				fact=1;
				for (int i=1; i<=n;i++) {
					fact += fact*i;
//					fact*=i;
				}
				System.out.println(n+"!의 값은 "+fact+"입니다");
				break;
			case 3:
				System.out.println("[ 원의 넓이 구하기 ]");
				System.out.println("반지름 r을 입력하시오.");
				r=sc.nextInt();
				area = r*r*Math.PI;
				System.out.printf("반지름이 %d인 원의 넓이는 %.2f 입니다.\n", r, area);
				break;
				default:
					System.out.println("종료합니다");
					break Loop;
			}
		}
		
	}

}
