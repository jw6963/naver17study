package day1227;

public class Ex4Thread extends Thread{
	String msg;
	int count;
	
	public Ex4Thread(String msg, int count) {
		this.msg=msg;
		this.count=count;
	}
	
	@Override
	public void run() {
		for(int i =1; i<=count;i++) {
			System.out.println(msg+":"+i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4Thread th1 = new Ex4Thread("1번 쓰레드", 300);
		Ex4Thread th2 = new Ex4Thread("2번 쓰레드", 300);
		Ex4Thread th3 = new Ex4Thread("3번 쓰레드", 300);

		// run 메서드 호출 - start
		th1.start();
		th2.start();
		th3.start();
		
	}

}
