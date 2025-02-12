package day1223;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex13FileException {

	public static void scoreRead() throws FileNotFoundException, IOException {
		FileReader fr;
		BufferedReader br;

		fr = new FileReader("C:/Users/jw/Desktop/naver1210/study/score.txt");
		System.out.println("파일 찾음");

		br = new BufferedReader(fr); // 한 줄 단위로 읽어오기 위해서

		int sum=0,n=0,score;
		while(true) {
			String line= br.readLine();
			if(line==null) 
				break;
			try {
				score=Integer.parseInt(line);
				sum+=score;
				System.out.println(++n+"번 점수: "+score);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("문자가 있네요: "+e.getMessage());
			}

		}
		System.out.println("총 합계: "+sum);

		// 열려진 자원들을 닫기 - 생성된 역순으로 닫아야 한다.
		if (br!=null) {
			br.close();
		}
		if(fr!=null) {
			fr.close();
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			scoreRead();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 찾을 수 없습니다: "+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("정상 종료");

	}

}
