package day1217;

import java.util.Scanner;

public class Ex8ArrayAlpha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 영어 문장을 입력하면 알파벳을 분석해서 각 알파벳의 갯수를 구하시오 (대소문자 구분 없이)
		 */
		Scanner sc = new Scanner(System.in);
		String message;
		int[] alpha = new int[26];
		
		System.out.println("영어 문장 입력");
		message = sc.nextLine().toUpperCase();
		
		// 글자 수 만큼 반복
		for (int i=0; i<message.length(); i++) {
			char ch=message.charAt(i);
			alpha[ch-'A']++;
		}
		for (int i=0; i<alpha.length; i++) {
//			System.out.printf("%c:%d개\t",'A'+i,alpha[i]);
			System.out.print((char)('A'+i)+":"+alpha[i]+"개\t");
			// 한 줄에 4개씩 출력
			if ((i+1)%4==0) {
				System.out.println();
			}
		}
		

	}

}
