package day1219;

public class Ex7VarArgs {

	public static int calcNum(int ...n) {
		int sum=0;
		System.out.println("총 "+n.length+"개의 점수");
		for (int score:n) {
			System.out.println(score+" ");
			sum+=score;
		}
		System.out.println();
		
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s1=calcNum(90,80);
		System.out.println("합계= "+s1);
		
		int s2=calcNum(100,80,67,77);
		System.out.println("합계= "+s2);
		
		int s3=calcNum(56,87,23,46,123,45);
		System.out.println("합계= "+s3);

	}

}
