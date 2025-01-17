package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1FileScore {

	public static void scoreRead() {
		FileReader fr=null;
		BufferedReader br=null;
		
		int cnt=0, sum=0;
		double avg;
		
		// 생성
		try {
			fr= new FileReader("C:\\Users\\jw\\Desktop\\naver1210\\study\\score.txt");
			System.out.println("파일 존재함!");
			br=new BufferedReader(fr);
			while(true) {
				// 파일에서 한 줄씩 읽기
				String s=br.readLine();
				if(s==null) {
					break;
				}
				try {
					int score = Integer.parseInt(s);
					cnt++;
					sum+=score;
					System.out.println(cnt+"=>"+score+"점");
				} catch (NumberFormatException e) {
					// TODO: handle exception
					System.out.println("\t문자가 포함됨!");
				}
			}
			avg=(double)sum/cnt;
			System.out.println("점수갯수: "+cnt);
			System.out.println("총점: "+sum);
			System.out.println("평균: "+avg);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("파일을 찾을 수 없다: "+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException|NullPointerException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scoreRead();
		System.out.println("정상 종료");

	}

}
