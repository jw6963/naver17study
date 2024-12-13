package day1213;

import java.util.Scanner;

public class Ex13For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 2
		 * 5명의 나이를 입력 후
		 * 40세 이상과 40세 미만이 각각 몇명인지 출력하고
		 * 평균 나이도 같이 출력하시오
		 * (for문 사용)
		 */

		Scanner sc = new Scanner(System.in);
		int n,sum=0,o=0,u=0;
		double avg;
		
		for (int i=1; i<=5; i++) {
			System.out.println(i+"번째 사람의 나이를 입력");
			n=sc.nextInt();
			if (n>=40) {
				o++;
			}
			sum += n;
		}
		u = 5-o;
		avg = sum/5.0;
		System.out.println("40세 이상: "+o);
		System.out.println("40세 미만: "+u);
		System.out.printf("평균 나이: %.1f",avg);
		
	}

}
