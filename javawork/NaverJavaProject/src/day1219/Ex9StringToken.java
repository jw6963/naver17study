package day1219;

import java.util.StringTokenizer;

public class Ex9StringToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="red|green|yellow|white|black";
//		String msg="red,green,yellow,white,black";
		
		// | 로 분리해서 출력
//		String[] arr = msg.split("|"); // 잘 안됨
//		for (String a:arr) {
//			System.out.println(a);
//		}
		
		StringTokenizer st=new StringTokenizer(msg,"|");
		System.out.println("분리할 총 토큰 수 : "+st.countTokens());
		
//		for (int i=0;i<st.countTokens();i++) { // countTokens의 값은 토큰을 처리할 때마다 값이 줄어든다. (앞으로 처리해야 할 토큰 수)
		// 방법 1
		int ran = st.countTokens();
		for (int i=0; i<ran; i++) {
			System.out.println(st.nextToken());
		}
		System.out.println();
		// 방법 2
		StringTokenizer st2=new StringTokenizer(msg,"|"); // st에서 읽으면서 토큰이 다 처리 되었기 때문에 새로운 st2를 만들어준다.
		while (st2.hasMoreTokens()) { // == (st2.countTokens()>0)
			System.out.println(st2.nextToken());
		}
		
		System.out.println();
		String[] arr2=msg.split("|"); 
		System.out.println("총 "+arr2.length+"개");
		
		String[] arr3=msg.split("\\|"); // split은 정규표현식을 사용하는 게 좋다.
		System.out.println("총 "+arr3.length+"개");
		
		System.out.println();
		// 아래 데이터를 "."으로 분리하여 출력하시오;
		String msg2="이미자.손태영.강호동.이영자.박진아";
		String[] arr4=msg2.split("\\.");
		for (String a:arr4) {
			System.out.println(a);
		}
	}

}
