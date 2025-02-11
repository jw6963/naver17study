package day1224;

import java.io.File;import java.io.FileReader;

public class Ex2File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file1 =new File("C:\\Users\\jw\\Desktop\\naver1210\\study\\score.txt");
		File file2 = new File("C:\\Users\\jw\\Desktop\\naver1210\\study");
		System.out.println(file1.length()); // 파일 길이를 byte 단위로 구한다.
		// 파일 권한 확인
		System.out.println(file1.canExecute()); // 실행 가능한가 - true
		System.out.println(file1.canRead()); // 읽기 가능한가 - true
		System.out.println(file1.canWrite()); // 쓰기 가능한가 - true 

		// 파일 확인
		System.out.println(file1.exists()); // true
		
		// 디렉토리인지 확인
		System.out.println(file1.isDirectory()); // false
		System.out.println(file2.isDirectory()); // true
		
		// 파일인지 확인
		System.out.println(file1.isFile()); // true
		System.out.println(file2.isFile()); // false
		
		// file1이 디렉토리라면 목록을 출력하라
		if (file1.isDirectory()) {
			String[] list=file1.list();
			int n=0;
			for(String s:list) {
				System.out.println(++n+":"+s);
			}
		} else {
			System.out.println("file1은 파일입니다");
		}
		// file2가 디렉토리라면 목록을 출력하라
		if (file2.isDirectory()) {
			String[] list=file2.list();
			int n=0;
			for(String s:list) {
				System.out.println(++n+":"+s);
			}
		} else {
			System.out.println("file2은 파일입니다");
		}
		System.out.println("=".repeat(30));
		System.out.println(file1.getAbsolutePath()); // C:\Users\jw\Desktop\naver1210\study\score.txt
		System.out.println(file1.getName()); // score.txt
		System.out.println(file1.getPath()); // C:\Users\jw\Desktop\naver1210\study\score.txt
	}

}
