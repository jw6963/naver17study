package day1217;

public class Ex2Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] ch;
		
		ch=new char[4];
		
		System.out.println("배열 크기: "+ch.length);
		// 배열에 데이터 넣기
		ch[0]='H';
		ch[1]=65;
		ch[2]='x';
		ch[3]='t';
		
		// 출력 #1
		for (int i=0;i<ch.length;i++) {
			System.out.printf("ch[%d]=%c\n",i,ch[i]);
		}
		System.out.println();
		// 출력 #2
		for(char a:ch) {
			System.out.println(a);
		}
		
		System.out.println("=".repeat(30));
		char[] ch2=new char[5];
		ch2= new char[] {'a','n','x','y','u'};
		for (int i=0; i<ch2.length; i++) {
			System.out.printf("ch2[%d]=%c\n",i,ch2[i]);
		}
		
		System.out.println("=".repeat(30));
		char[] ch3 = {'s','r','t','a','x'};
		for (char a:ch3) {
			System.out.println(a);
		}

	}

}
