package day1213;

public class Ex6While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=65;
		while(a<=90) {
//			System.out.printf("%c",a++);
			System.out.print((char)a++);
		}
		System.out.println();
		char b='a';
		// do while을 이용해서 a부터 z까지 출력하시옿
		do {
			System.out.print(b);
			b++;
		} while (b<=122);
		
		System.out.println();
		int n=0;
		while(n<=10) {
			n++;
			if(n%2==0) {
				continue; // 조건식으로 이동
			}
			System.out.printf("%3d",n++);
		}
	}

}

