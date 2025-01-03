package day1227;

/*
 * java는 다중 상속이 안되므로 부득이하게 이미 다른 클래스를
 * 상속받고 있다면 더 이상 Thread를 상속 받을 수 없다
 * 이런 경우는 인터페이스 Runnable을 구현함으로써 쓰레드를 구현할 수 있다
 */

public class Ex5Runnable implements Runnable{

	int cnt;
	String msg;
	
	public Ex5Runnable(String msg, int cnt) {
		this.msg=msg;
		this.cnt=cnt;
	}
	@Override
	public void run() {
		for(int i=1; i<=cnt; i++) {
			System.out.println(msg+":"+i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5Runnable ex1 = new Ex5Runnable("1번쓰레드", 300);
		Ex5Runnable ex2 = new Ex5Runnable("2번쓰레드", 300);
		Ex5Runnable ex3 = new Ex5Runnable("3번쓰레드", 300);
		
		Thread th1= new Thread(ex1);
		Thread th2= new Thread(ex2);
		Thread th3= new Thread(ex3);
		
		th1.start();
		th2.start();
		th3.start();

	}

}
