package day1223;

import java.io.FileWriter;
import java.io.IOException;

public class Ex11Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 일반 Exception은 선택이 아니라 필수로 처리해야만 한다
		// 메서드 자체가 throws로 던지는 Exception 처리하면 된다.
		
		System.out.println("3초만 기다리세요");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("오래 기다리셨어요~");
		
		// 파일에 이름과 주소를 저장해보자
		FileWriter fw = null;
		try {
			fw= new FileWriter("c:/Users/jw/Desktop/naver1210/study/memo.txt", true); // true: 기존 파일에 내용 추가(없으면 덮어쓰기)
			fw.write("이름: 이영자\n");
			fw.write("주소:강남구\n");
			fw.write("==========\n");
			System.out.println("탐색기로 파일을 확인하세요");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException | NullPointerException e) {
				// close할 때는 보통 이렇게 많이 쓴다.
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("정상 종료");
		
	}

}
