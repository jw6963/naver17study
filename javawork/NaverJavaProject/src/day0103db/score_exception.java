package day0103db;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class score_exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int score;
		List<Integer> arr = new ArrayList<Integer>();
		
		System.out.println("점수 입력(종료: -1)");
		int i = 0;
		while (true) {
			try {
				score=sc.nextInt();
				if (score == -1) {
					break;
				}
				if (score>100 || score <0) {
					System.out.println("유효한 점수가 아닙니다. 다시 입력하세요.");
				} else {
					arr.add(score);
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			}
		}
		int max = Collections.max(arr);
		int min = Collections.min(arr);
		int sum = arr.stream().mapToInt(Integer::intValue).sum();
		double avg = (double)sum/arr.size();
		
		System.out.println("최고 점수 : "+max);
		System.out.println("최저 점수 : "+min);
		System.out.println("합계 : "+sum);
		System.out.printf("평균 : %.2f",avg);

	}

}
