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
			// 0~100세를 벗어나는경우 다시 입력(인원 수 제외)
			// continue : for문은 i++로 이동
			if (n<0 || n>100) {
				System.out.println("!!0~100세 사이로 다시 입력!!");
				i--;
				continue;
			}
			if (n>=40) {
				o++;
			}
			sum += n;
			u = i-o;
		}
		avg = sum/5.0;
		
		System.out.println("40세 이상: "+o);
		System.out.println("40세 미만: "+u);
		System.out.printf("평균 나이: %.1f",avg);
		
	}

}
