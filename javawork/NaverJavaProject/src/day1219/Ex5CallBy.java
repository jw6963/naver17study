package day1219;

/*
 * 인자 전달방식
 * CallByValue : 값만 전달(기본형, String)
 * CallByReference : 주소가 전달(모든 객체, 배열타입)
 */
class Test {
	String message;
	int code;
}

public class Ex5CallBy {
	
	public static void changeInt(int n) {
		n=200;
	}
	
	public static void changeString(String s) {
		s="apple";
	}
	
	public static void changeTest(Test t) {
		t.message="Happy";
		t.code=100;
	}
	
	public static void changeArray(int[] arr) {
		arr[1] = 20;
	}
	
	public static int changeScore(int score) {
		if (score>=80) {
			return score;
		} else return 90;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		changeInt(n);
		System.out.println("n= "+n); // 값만 전달
		
		String s="Berry";
		changeString(s);
		System.out.println(s); // 값만 전달
		
		Test t = new Test();
		System.out.println("message= "+t.message+", code= "+t.code);
		changeTest(t); // reference, 주소가 전달됨
		System.out.println("message= "+t.message+", code= "+t.code);
		
		int[] a = {5,7,11};
		changeArray(a);
		for(int aa:a) {
			System.out.print(aa+" ");
		}
		System.out.println();
		
		int score=8;
		// 값만 전달되는 경우는 메서드에서 변경된 값을 받으려면 리턴으로 받아와야 한다
		score = changeScore(score);
		System.out.println("score= "+score);
	}

}
