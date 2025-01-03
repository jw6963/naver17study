package day1213;

import java.util.Scanner;

public class EX9While {
	
	public static void main(String[] args) {
		
		/*
		 * 1글자씩 입력하다가 x(대소문자 상관 없이)를 입력하면 빠져나와서
		 * 입력한 데이터들을 분석한 결과를 출력하시오
		 * 
		 * 대문자:3
		 * 소문자:4
		 * 숫자:3
		 */
		
		Scanner sc = new Scanner(System.in);
		char c;
		int b=0,s=0,n=0;
		
		System.out.println("문자를 입력하세요.(종료:x||X)");
		while (true) {
			c=sc.nextLine().charAt(0);
			if (c=='x' || c=='X') {
				break;
			}
			if ('0'<=c && c <='9') { // 48~57
				n++;
				continue;
			} else if ('A'<= c && c <='Z' && c!='X') { // 65~90
				b++;
				continue;
			} else if ('a' <= c && c<='z' && c !='x') { // 97~122
				s++;
				continue;
			} 
		}
		System.out.println("대문자: "+b);
		System.out.println("소문자: "+s);
		System.out.println("숫자: "+n);
	}

}
