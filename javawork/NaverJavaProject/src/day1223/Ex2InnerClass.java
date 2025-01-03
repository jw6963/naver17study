package day1223;

class OuterObj {
	int a =10;
	static int b=20;
	private int c=30;
	
	class InnerObj {
		int x =40;
		static int y=50; // jdk 17에서는 가능(낮은 버전에서는 불가능했다. 내부에서 static 변수 쓰려면 내부 클래스도 static이어야 했다)
		
		public void disp() {
			System.out.println("a="+a);
			System.out.println("b="+b);
			System.out.println("c="+c);
			System.out.println("x="+x);
			System.out.println("y="+y);
		}
	}
	public void outerDisp() {
		// 외부 클래스에서 직접 내부클래스 호출 시
		InnerObj in = new InnerObj();
		in.disp();
	}
}

public class Ex2InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterObj obj1 = new OuterObj();
		obj1.outerDisp();
		System.out.println();
		// 직접 내부클래스의 메서드를 호출하려면
//		OuterObj.InnerObj obj2 = new OuterObj().new InnerObj();
		OuterObj.InnerObj obj2 = obj1.new InnerObj();
		obj2.disp(); // 실제로는 위의 방법을 더 많이 쓴다.

	}

}
