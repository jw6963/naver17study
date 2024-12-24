package day1224;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex4FileReadWrite {
	static final String FILENAME="C:\\Users\\jw\\Desktop\\naver1210\\study\\member.txt";

	public static void fileRead() throws IOException {
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			// 제목
			System.out.println("\t전체 멤버 명단");
			System.out.println();
			System.out.println("번호\t이름\t나이\t주거지");
			System.out.println("=".repeat(30));
			int n=0;
			while(true) {
				String line=br.readLine();
				if(line==null) {
					break;
				}
				String[] m=line.split(","); // 데이터가 "이름,나이,주거지"이런 형태이다.
				System.out.println(++n+"\t"+m[0]+"\t"+m[1]+"세\t"+m[2]);
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("**해당 파일을 찾을 수 없습니다.**");
		} finally {
			if(br!=null) {
				br.close();
			}
			if(fr!=null) {
				fr.close();
			}
			
		}
		
	}
	
	public static void fileSave() throws IOException {
		FileWriter fw=null;
		Scanner sc =new Scanner(System.in);
		String name,age,addr;
		
		fw = new FileWriter(FILENAME, true); // true - 추가모드로 생성(false - 덮어쓰기)
		// 추가할 데이터 입력
		System.out.println("추가할 이름 입력");
		name=sc.nextLine();
		System.out.println("나이 입력");
		age=sc.nextLine();
		System.out.println("주거지 입력");
		addr=sc.nextLine();
		
		// 파일 추가
		fw.write(name+","+age+","+addr+"\n");
		// 파일 닫기
		if(fw!=null) {
			fw.close();
		}
	}
	
	public static void fileDelete() {
		// 파일 삭제
		File file=new File(FILENAME);
		if(file.exists()) {
			System.out.println("파일을 삭제합니다(모든 멤버 삭제됨)");
			file.delete();
		} else {
			System.out.println("삭제할 파일이 없습니다.");
		}
		System.out.println();
	}
	
	public static int getMenu() {
		int menu=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("1.멤버추가 2.전체출력 3.전체멤버삭제 4.종료");
		try {
			menu=Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			menu=2; // 메뉴에 문자가 들어올 경우 그냥 전체출력 실행
		}
		return menu;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Label:
		while(true) {
			switch(getMenu()) {
			case 1 -> fileSave();
			case 2 -> fileRead();
			case 3 -> fileDelete();
			default -> {
				System.out.println("프로그램을 종료합니다");
//				break Label;
				System.exit(0); // 시스템 종료
			}
			}
		}

	}

}
