package day1213;

import java.util.Scanner;

public class Ex2Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		char ch;
//		ch = sc.nextLine().charAt(0); // 입력한 문자열의 첫번째 문자를 char 타입으로 반환
//		switch(ch) {
//		case 'a': // 현재 케이스에는 break가 없기 때문에 다음 명령이 실행됨
//		case 'A':
//			System.out.println("Apple");
//			break;
//		case 'b':
//		case 'B':
//			System.out.println("Banana");
//			break;
//		case 'c':
//		case 'C':
//			System.out.println("computer");
//			break;
//		default:
//			System.out.println("others");	
//		}
		
		System.out.println("영어 단어를 입력해주세요");
		String msg=sc.nextLine();
		
		// jdk8 이후로 case 에서 문자열도 가능해졌다
		switch (msg) {
		case "red":
		case "RED": {
			System.out.println("빨강색");
			break;
		}
		case "green":
		case "GREEN": {
			System.out.println("초록색");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + msg);
		}
		
	}

}
