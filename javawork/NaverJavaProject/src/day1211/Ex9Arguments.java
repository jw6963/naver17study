package day1211;

public class Ex9Arguments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메인 Argument 값 읽기 문제");
		
		/*
		 * 이상욱
		 * 삼성전자
		 * 홍보부
		 * 89
		 * 100
		 * 74
		 * 
		 * 이름(name), 회사명(emp), 부서(dep),
		 * 3과목의 입사 시험 점수(score1,score2,score3)
		 * 를 읽어서 위의 데이터와 입사시험의 총 합계(total)과
		 * 평균(average)-소숫점 첫째자리까지만 출력(printf로)하시오.
		 */
		String name = args[0];
		String emp = args[1];
		String dep = args[2];
		int score1 = Integer.parseInt(args[3]);
		int score2 = Integer.parseInt(args[4]);
		int score3 = Integer.parseInt(args[5]);
		int total = score1 + score2 + score3;
		double avg = total / 3.0;
		
		System.out.printf("이름 : %s\n"
				+ "회사명 : %s\n"
				+ "부서 : %s\n"
				+ "점수 합계 : %d\n"
				+ "평균 : %.1f\n"
				, name, emp, dep, total, avg);
		
	}

}
