package day1216;

public class Ex10Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 2~9단까지 한 번에 나오도록 출력
		 * ---------------------
		 * 2*1=2 3*1=3 ...
		 * 2*2=4 3*2=6 ...
		 * .
		 * .
		 * .
		 * 2*9=18 3*9=27 ...
		 */
		System.out.println("[ 구구단 ]");
		
		for (int i=2; i<=9; i++) {
			System.out.printf("[%d단]\t",i);
		}
		System.out.println();
		System.out.println("=".repeat(65));
		for (int i=1; i<=9; i++) {
			for (int j=2; j<=9; j++) {
				int result = i*j;
				System.out.printf("%d*%d=%d\t",j,i,result);
			}
			System.out.println();
			
		}

	}
	
}