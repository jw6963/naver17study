package day1216;

import java.util.Scanner;

public class Ex6LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문자열 str을 입력 후 엔터를 누르면
		 * 문자열을 분석해서 대문자, 소문자, 숫자 각각의 갯수를 구해서 출력하시오
		 * 사용할 문자메서드 : length(), charAt(index)
		 */
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.println("문자열을 입력하세요.");
		str = sc.nextLine();
		int n,lowCnt=0,upCnt=0,numCnt=0;
		n= str.length();
		for (int i=0; i<n; i++) {
			char ch = str.charAt(i);
			if ('a'<= ch && ch <='z') {
				lowCnt++;
			} else if('A'<=ch && ch <='Z') {
				upCnt++;
			} else if ('0'<=ch && ch<='9') {
				numCnt++;
			} else {
				continue;
			}
		}
		System.out.println("대문자 : "+upCnt);
		System.out.println("소문자 : "+lowCnt);
		System.out.println("숫자 : "+numCnt);

	}

}
