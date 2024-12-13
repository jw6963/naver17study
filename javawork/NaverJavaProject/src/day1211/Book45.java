package day1211;

import java.util.ArrayList;

public class Book45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Long 타입에 아주 큰 숫자를 대입하려면 뒤에 L을 붙여야 한다
		char var1 = 'b';
		char var2 = 'a';
		// long var3 = 100000000000000;
		long var4 = 100000000000000L;
		
		System.out.println(var1);
		System.out.println(var2);
		
		System.out.println(var4);
		System.out.println(((Object)(var1+var2)).getClass().getName());
		System.out.println(((Object)var2).getClass().getName());
	}

}
