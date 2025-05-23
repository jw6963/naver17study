package day1211;

public class Ex8Arguments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("외부에서 값 읽어오기");
		String name = args[0];
		String city = args[1];
		int birth = Integer.parseInt(args[2]); // String 형태의 년도를 정수 타입으로 변환
		int age = 2024 - birth;
		// 두 과목의 점수 읽기
		int kor = Integer.parseInt(args[3]);
		int eng = Integer.parseInt(args[4]);
		int total = kor + eng;
		// 평균 int + double= double, int + int = int(2.0이 아닌 2로 계산할 경우 소수점이 버려진다)
		double avg = total / 2.0; // 또는 double avg = (double)total / 2;
		
		System.out.println("이름 : " + name);
		System.out.println("지역 : " + city);
		System.out.println("출생년도 : " + birth + "년 나이 : " + age + "세");
		System.out.println("국어 점수 : " + kor + "점");
		System.out.println("영어 점수 : " + eng + "점");
		System.out.println("총점 : " + total + "점");
		System.out.println("평균 점수 : " + avg + "점");
	}

}