package day1212;

public class Ex1Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 증감 연산자, ++ 변수 (전치:1순위), 변수++(후치:끝순위)
		int a,b,m,n;
		a=b=5;
		m=++a; // 먼저 a가 증가된 후 m으로 대입된다 => 6
		n=b++; // 먼저 대입 후 b가 증가된다. => 5
		
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
		a=b=m=n=5;
		m=a++*++b; // 5*6
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
		n=a++ + ++b; // 6+7
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
		a=5;
		System.out.println(a++); // 5로 출력되고 6으로 증가
		System.out.println(++a); // 6에서 7로 증가되고 출력
		
	}

}
