package day1213;

import java.util.Scanner;

public class Ex3Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 년도와 월을 입력 후 윤년인지 평년인지 출력하고
		 * 그 월이 며칠까지 있는지 구하시오
		 * 윤년이란 년도%4==0 && 년도%100!=0 || 년도%400==0
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int year,month,days;
		
		System.out.println("년도와 월을 입력하세요");
		year = sc.nextInt();
		month = sc.nextInt();
		
		boolean b = year % 4==0 && year%100!=0 || year%400 ==0; // true면 윤년, false면 평년, 젊으면 청년 
		
		if (b) {
			System.out.println(year+"년도는 윤년입니다");
		} else {
			System.out.println(year+"년도는 평년입니다");
		}
		switch (month) {
		case 2: {
			days = b?29:28;
			break;
		}
		case 4,6,9,11: {
			days = 30;
			break;
		}
		case 1,3,5,7,8,10,12: {
			days = 31;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + month);
		}
		System.out.println(year+"년도 "+month+"월은 "+days+"일까지 있습니다");

	}

}
