package day1213;

import java.util.Scanner;

public class Ex7While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int score,total=0,count=0;
		double avg;
		
		while(true) {
			System.out.println("점수 입력(종료: 0)");
			score=sc.nextInt();
			if (0>score || score>100) {
				System.out.println("잘못 입력된 점수입니다");
				continue;
			}
			if(score==0) {
				break;
			}
			count++;
			total+=score;
				
		}
		avg=(double)total/count;

		System.out.println("총 입력한 점수 갯수: "+count);
		System.out.println("점수의 총합계: "+total);
		System.out.printf("점수들의 평균: %5.2f\n",avg);
	}

}