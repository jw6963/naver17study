package day1217;

import java.util.Scanner;

public class Ex12ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] member= {"강영현","김원필","윤도운","김준호","전종원","전세호","이지혜","송중기","손석구","박성진","강호동","유재석"};
		String searchName;
		int cnt;
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 검색할 성씨는 ? 이
		 * 		이지혜
		 * 		총 1 명 검색
		 *  검색할 성씨는 ? 강
		 * 		강호동
		 * 		강영현
		 * 		총 2 명 검색
		 *  검색할 성씨는 ? 홍
		 * 		"홍"씨성을 가진 멤버는 없습니다
		 * 
		 * => 대소문자 상관없이 exit 입력 시 종료
		 */
		while(true) {
			System.out.print("검색할 성씨는 ? (종료:exit) ");
			searchName=sc.nextLine();
			if(searchName.equalsIgnoreCase("EXIT")) {
				System.err.println("프로그램을 종료합니다.");
				break;
			}
			cnt=0;
			for (int i=0;i<member.length; i++) {
//				if(searchName.equals(String.valueOf(member[i].charAt(0)))) {
				if(member[i].startsWith(searchName)) {
					System.out.println("\t"+member[i]);
					cnt++;
				}
			}
			if(cnt==0) {
				System.err.println("\t\""+searchName+"\"씨성을 가진 멤버는 없습니다.");
			} else	System.out.println("\t총 "+cnt+"명 검색");
			
		}

	}

}