package day1213;

import java.util.Scanner;

public class Ex8While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 숫자 n을 입력하면 1부터 n까지의 합계 sum을 구해서 출력하시오
		 * 
		 * 예) 100 입력 시
		 * 1부터 100까지의 합계는 5050입니다(printf)
		 */
		Scanner sc = new Scanner(System.in);
		int n;
		long sum=0;

		System.out.println("숫자 입력");
		n=sc.nextInt();
		if (n<=0) {
			System.out.println("0보다 큰 수만 입력가능합니다.");
			return;
		}
		int i=0;
		 while (i<=n) {
			sum+=i;
			i++;
		}
		System.out.printf("1부터 %d까지의 합계는 %d입니다.",n,sum);
	}

}
