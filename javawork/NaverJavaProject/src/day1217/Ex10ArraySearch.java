package day1217;

import java.util.Scanner;

public class Ex10ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] datas= {12,5,8,10,9,16,19,3,1,7};
		System.out.println("갯수: "+datas.length);
		int searchNum;
		boolean find;
		/*
		 * 숫자를 입력하면 그 숫자가 몇 번째 있는지 출력
		 * 없을 경우 해당 숫자가 없습니다 라고 출력
		 * 0을 입력 시 검색 종료
		 */
		Scanner sc = new Scanner(System.in);
		while(true) {
			find=false;
			System.out.print("검색할 숫자는? (종료: 0) ");
			searchNum = sc.nextInt();
			if (searchNum ==0) {
				System.out.println("프로그램 종료!");
				break;
			}
			for(int i=0; i<datas.length; i++) {
				if(datas[i]==searchNum) {
					find = true;
					System.out.println(i+1+"번째에 있습니다");
					break;
				}
			}
			if(!find) {
				System.err.println("해당 숫자가 없습니다");
			}
		}

	}

}
