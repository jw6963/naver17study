package day1217;

import java.util.Scanner;

public class Ex11ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] member= {"강영현","김원필","윤도운","김준호","전종원","전세호","이지혜","송중기","손석구","박성진","강호동","유재석"};
		String searchName;
		boolean find;
		Scanner sc = new Scanner(System.in);
		/*
		 * 이름을 입력하면 몇 번째에 있는지 출력
		 * 없을 경우 "해당 이름은 없습니다"
		 * 반복적으로 검색하다가 종료하고 싶으면 "종료" 입력 시 "프로그램을 종료합니다" 출력 후 종료
		 */

		while(true) {
			find = false;
			System.out.println("검색할 이름 입력 :(종료:종료)");
			searchName=sc.nextLine();
			if (searchName.equals("종료")) {
				System.err.println("프로그램을 종료합니다");
				break;
			}

			for (int i=0;i<member.length;i++) {
				if (searchName.equals(member[i])) {
					find=true;
					System.out.println(i+1+"번째에 있습니다");
					break;
				}
			}
			if(!find) {
				System.err.println("해당 이름은 없습니다");
			}
		}

	}

}
