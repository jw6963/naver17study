package day1216;

import java.util.Scanner;

public class Ex8LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 이름을 입력하면 그 중 "김"씨 성을 가진 사람의 인원 수
		 * "이"씨 성을 가진 사람의 인원 수
		 * 그 이외의 인원 수를 각각 구하여 출력하시오
		 * (while문 - 빠져 나가는 코드는 "끝")
		 * 
		 * 사용할 문자열 메서드 : startWith,equals
		 */
		Scanner sc = new Scanner(System.in);

		String names;
		char firstName;
		int kimCnt=0, leeCnt=0, others=0;
		System.out.println("이름을 입력하세요. 종료 : '끝'");
		Loop:
		while(true) {
			names=sc.nextLine();
//			firstName=names.charAt(0);
//			switch(firstName) {
//			case '김':
//				kimCnt++;
//				break;
//			case '이':
//				leeCnt++;
//				break;
//			case '끝':
//				break Loop;
//				default:
//					others++;
//					break;
//			}
			if(names.startsWith("김")) {
				kimCnt++;
			} else if (names.startsWith("이")) {
				leeCnt++;
			} else if (names.equals("끝")) {
				break Loop;
			} else others++;
		}
		System.out.println("김 : "+kimCnt);
		System.out.println("이 : "+leeCnt);
		System.out.println("나머지 : "+others);
	}

}
