package day1223;

import java.util.Date;

public class Ex7Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,5,6,7};
		for(int i=0; i<=arr.length;i++) {
			try {
				System.out.println(arr[i]);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("오류 메세지: "+e.getMessage());
				e.printStackTrace(); // 행 번호 표시
			}
		}
		System.out.println();
		Date date = null;
		try {
			int age=(date.getYear()+1900)-1989;
			System.out.println("age="+age);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류 메세지: "+e.getMessage());
		}
		
		
		
		System.out.println("정상 종료");

	}

}