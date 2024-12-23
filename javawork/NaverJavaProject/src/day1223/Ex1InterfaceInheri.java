package day1223;

interface InterA {
	public void study();
}
// 인터페이스끼리(클래스끼리)의 상속은 extends
interface InterB extends InterA {
	public void play();
}
// 클래스가 인터페이스 구현 시는 implements
class MyInter implements InterB {
	@Override
	public void study() {
		System.out.println("그룹 스터디를 합니다");
	}
	@Override
	public void play() {
		System.out.println("그룹 모임을 합니다");
	}
	
	public void job() {
		System.out.println("밀린 일처리를 합니다");
	}
}
public class Ex1InterfaceInheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterA interA = new MyInter();
		interA.study();
		// 다운캐스팅으로 job 호출
		((MyInter)interA).job();
		System.out.println("=".repeat(20));
		
		InterB interB = new MyInter();
		interB.study();
		interB.play();
		// 다운 캐스팅으로 job 호출
		((MyInter)interB).job();
		System.out.println("=".repeat(20));	
		
		MyInter my = new MyInter();
		my.study();
		my.play();
		my.job();

		
	}

}
