package day1216;

import java.util.Scanner;

public class Ex3Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 임의의 난수를 수한 후 숫자 알아맞추기
		 * 맞췄을 경우
		 *     계속 하시겠습니까? y
		 *         => 새로운 난수 발생, 카운트 변수 0으로 초기화
		 *     y가 아닐 경우 프로그램 종료
		 */
		Scanner sc = new Scanner(System.in);
		int su,rnd,cnt;
		
		Exit: // 레이블은 대소문자 상관없이 임의로 지정하면 됨
			while(true) {
				rnd = (int)(Math.random()*100) +1;
				cnt=0;
				while(true) {
					System.out.print(++cnt+"회 : ");
					// nextInt로 받으면 버퍼에 엔터가 들어가서 뒤에 문자를 받을 때 에러가 발생할 수 있다
//					su = sc.nextInt();
					su=Integer.parseInt(sc.nextLine());
					if (su>rnd) {
						System.out.println(su+"보다 작습니다");
					} else if(su<rnd) {
						System.out.println(su+"보다 큽니다");
					}else {
						System.out.println("정답입니다");
						System.out.println("게임을 계혹하려면 y, 그만하려면 n");
						char ch=sc.nextLine().charAt(0);
						if (ch=='y'||ch=='Y') {
							System.out.println("새로운 난수를 생성합니다");
							break; // 현재 속한 반복문 종료
//							continue Exit; // 레이블 조건식으로 이동
						} else {
							break Exit; // 레이블 종료
						}
					}
				}
			}
		System.out.println("프로그램을 종료합니다.");

	}

}
