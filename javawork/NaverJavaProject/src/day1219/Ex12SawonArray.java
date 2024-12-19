package day1219;

import java.util.Scanner;

public class Ex12SawonArray {

	/*
	 * showTitle: 제목 출력
	 * 사원명 직급 기본급 수당 가족수당 세금 실수령액
	 */
	static void showTitle() {
		System.out.println("사원명\t직급\t기본급\t수당\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(70));
	}
	
	/*
	 * writeSawon(Sawon sawon) : 한 개의 사원 데이터 출력
	 */
	static void writeSawon(Sawon sawon) {
		
		System.out.println(sawon.getSawonName()+"\t"+sawon.getPosition()+"\t"+
	sawon.getGibonPay(sawon.getPosition())+"\t"+sawon.getSudang(sawon.getPosition())+"\t"+sawon.getFamSudang(sawon.getFamSu())
	+"\t\t"+sawon.getTax(sawon.getGibonPay(sawon.getPosition()))+"\t"+sawon.getNetPay(sawon.getGibonPay(sawon.getPosition()), sawon.getSudang(sawon.getPosition()), sawon.getTax(sawon.getSudang(sawon.getPosition())), sawon.getFamSudang(sawon.getFamSu())));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int inwon;
		Sawon[] mySawon;
		/*
		 * 인원수를 입력 후 인원수만큼 배열 메모리 할당
		 */
		System.out.println("인원수 입력");
		int memNum = Integer.parseInt(sc.nextLine());
		mySawon = new Sawon[memNum];
		/*
		 * 배열에 데이터 입력 후 생성자 통해서 데이터 저장하기
		 */
		for (int i=0; i<mySawon.length;i++) {
			System.out.println("사원명 입력");
			String saName = sc.nextLine();
			System.out.println("직급 입력");
			String position =sc.nextLine();
			System.out.println("가족수 입력");
			int famSu = Integer.parseInt(sc.nextLine());
			
			mySawon[i] = new Sawon(saName,position,famSu);
		}
		
		/*
		 * 제목 출력
		 */
		showTitle();
		
		/*
		 * 반복문 통해서 데이터 출력하는 메서드 호출
		 */
		for(Sawon s:mySawon) {
			writeSawon(s);
		}

	}

}
