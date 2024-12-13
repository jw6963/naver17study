package day1212;

import java.util.Date;

public class Ex6Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 현재 날짜와 시간을 얻어보자
		// Date 클래스는 jdk1.1 이후에 deprecate 됨 - Calendar를 권장(실제로는 Date를 많이 씀)
		
		Date date = new Date();
		int curYear = date.getYear()+1900; // 1900을 뺀 값을 반환함
		int curMonth = date.getMonth()+1; // 0~11을 반환하므로 +1
		int curDate = date.getDate();
		
		
		System.out.println("현재 년도: "+curYear);
		System.out.println("현재 월: "+curMonth);
		System.out.println("현재 일: "+curDate);
		
		// 요일 숫자 구하기(0~6: 일~토)
		int curDay = date.getDay(); // 0:일,1:월,2:화,3:수...6:토
		System.out.println("현재 요일: "+curDay);
		
		// 오늘은 목요일입니다.
		String week = (curDay==0?"일":curDay==1?"월":curDay==2?"화":curDay==3?"수":curDay==4?"목":curDay==5?"금":"토");
		System.out.println("오늘은 "+week+"요일입니다.");

	}

}
