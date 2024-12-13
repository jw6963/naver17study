package day1212;

import java.util.Scanner;

public class Ex12Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 이름(name)과 java,html,spring의 3과목 점수를 입력 받은 후
		 * 총점(sum)과 평균(avg), 등급(grade),합격 여부를 출력하시오
		 * 
		 * 등급은 평균이 90 이상이면 "우등장학생", 80이상이면"50프로 장학금", 나머지는 "노력"이라고 출력
		 * 
		 * 합격 여부는 3과목이 50이상이고 평균이 모두 70 이상이면 "합격입니다" 
		 * 아니면 "불합격입니다"라고 출력(출력문에서 직접 조건 연산자로 출력하기)
		 */
		String name,grade;
		int java,html,spring,sum;
		double avg;
		System.out.println("이름 입력");
		name = sc.nextLine();
		System.out.println("java 점수 입력");
		java = sc.nextInt();
		System.out.println("html 점수 입력");
		html = sc.nextInt();
		System.out.println("spring 점수 입력");
		spring = sc.nextInt();
		sum = java+html+spring;
		avg = sum/3.0;
		grade = avg>=90?"우등 장학생":avg>=80?"50프로 장학금":"노력";
		System.out.println("평균 : "+avg);
		System.out.println(grade);
		System.out.println(java>=50&&html>=50&&spring>=50&&avg>=70?"합격입니다.":"불합격입니다");

	}

}
