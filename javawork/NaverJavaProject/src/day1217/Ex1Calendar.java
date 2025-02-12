package day1217;

import java.util.Date;
import java.util.Scanner;

public class Ex1Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 
		 * 년도와 월을 입력하면 해당 월의 달력을 출력하시오 
		 * 1. 첫째날이 무슨 요일인가? 요일만큼 \t 넣기
		 * 2. 그 월이 며칠까지 있는가
		 * 3. 윤년 체크
		 */
		Scanner sc = new Scanner(System.in);
		int inputYear, inputMonth;
		int endDays; // 며칠까지 있는지
		int weekDay; // 요일 숫자
		boolean leapYear;

		System.out.println("[ 달력 만들기 ]");
		System.out.print("년도 입력 : ");
		inputYear = sc.nextInt();
		System.out.print("월 입력 : ");
		inputMonth = sc.nextInt();
		// 1~12월이 아닌 경우 프로그램 종료
		if(inputMonth<1 || inputMonth>12 || inputYear<1) {
			System.out.println("잘못된 입력입니다");
			return;
		}
		
		// 윤년 체크
		leapYear=inputYear%4==0 && inputYear%100!=0 || inputYear%400==0;
		if (leapYear) System.out.println(inputYear+"년도는 윤년입니다");
		else System.out.println(inputYear+"년도는 평년입니다");
		
		// 요일 체크
		Date date = new Date(inputYear-1900, inputMonth-1,1); // 입력한 년,월의 1일의 date 얻기
		weekDay = date.getDay(); // 요일 얻기
		
		// 해당 월이 며칠까지 있는지 구하기
		switch(inputMonth) {
		case 2:
			endDays=leapYear?29:28;
			break;
		case 4,6,9,11:
			endDays=30;
			break;
		default:
			endDays=31;
			break;
		}
		
		// 제목부터
		System.out.println("=".repeat(50));
		System.out.println("\t\t[ "+inputYear+"년 "+inputMonth+"월 ]");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("=".repeat(50));
		
		// weekDay 숫자만큼 \t
		System.out.print("\t".repeat(weekDay));
//		for (int i=1; i<=weekDay; i++) {
//			System.out.print("\t"); 
//		} // 반복문 말고 weekDay만큼 repeat 찍으면 되지 않나??
		
		// 1일부터 endDays까지 출력 (토요일은 출력 후 엔터)
		for (int i=1; i<=endDays; i++) {
			++weekDay; // 이렇게 증가하면 첫 토요일이 7.. 그 다음부터 토요일이 7의 배수가 된다
			System.out.printf("%2d\t",i);
			if(weekDay%7==0) {
				System.out.println();
			}
		}
	}

}
