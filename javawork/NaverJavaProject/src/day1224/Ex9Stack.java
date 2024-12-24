package day1224;

import java.util.Stack;

public class Ex9Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// LIFO : 마지막으로 들어간 데이터가 먼저 나오는 구조
		// push,pop 을 이용해서 데이터 조작
		Stack<String> stack1= new Stack<String>();
		
		stack1.push("사과");
		stack1.push("오렌지");
		stack1.push("사과");
		stack1.push("키위");
		stack1.push("딸기");
		
		System.out.println("stack의 갯수: "+stack1.size());
		
		while(!stack1.isEmpty()) {
			System.out.println(stack1.pop());
		}

	}

}
