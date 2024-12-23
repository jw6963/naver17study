package day1223;

import java.sql.Date;
import java.util.Scanner;

public class Ex9Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ex8번의 예제에서 catch 2개를 하나로 합치기
		Scanner sc = new Scanner(System.in);
		
		int birthYear,age;
		
		try {
			System.out.println("태어난 년도는?");
			birthYear = Integer.parseInt(sc.nextLine());
			Date date=null;
			age = (date.getYear()+1900)-birthYear;
			System.out.println("내 나이는 "+age+"세 입니다.");
		} catch (NumberFormatException|NullPointerException e) {
			// TODO: handle exception
			System.out.println("예외발생: "+e.getMessage());
		}
		

		System.out.println("정상 종료");

	}

}
