package day1212;

import java.util.Scanner;

public class Ex10Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 상품(sang)과 수량(su), 단가(dan)을 입력 받은 후
		 * 총 금액(total)을 출력하시오
		 * 단, 수량이 5개 이상이면 총 금액의 10프로를 할인된 금액(dctotal)
		 * 으로 출력해주세요
		 * 예시)
		 * 상품명 : 바나나킥
		 * 수량 5개
		 * 단가 : 1000원
		 * 총 금액 : 4500원
		 */
		Scanner sc = new Scanner(System.in);
		String sang;
		int su;
		int dan;
		int total;
		int dctotal;
		System.out.println("상품명을 입력하세요");
		sang=sc.nextLine();
		System.out.println("수량을 입력하세요");
		su=sc.nextInt();
		System.out.println("단가를 입력하세요");
		dan=sc.nextInt();
		total=su*dan;
		dctotal=(int)(su*dan*0.9);
		System.out.println("-----------");
		System.out.println("상품명 : "+sang);
		System.out.println("수량 : "+su+"개");
		System.out.println("단가 : "+dan+"원");
		System.out.println("총 금액 : "+(su<5?total:dctotal)+"원"+(su<5?"":"(할인됨)"));
		

	}

}
