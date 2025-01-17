package day1218;

class Orange {
	public static final String MESSAGE="Happy";

	private String name;
	private int age;
	
	public void showData() {
		// 일반 멤버 메서드는 this라는 인스턴스 변수를 가지고 있다.
		// 그래서 this.name 이런 식으로 접근 가능 (this는 경우에 따라 생략 가능)
		System.out.println("이름:"+this.name+", 나이: "+age);	
	}
	
	// 값을 변경하기 위한 setter method를 만들어보자
	public void setName(String name) {
		// 같은 구역에 멈버와 같은 이름의 변수가 있을 경우
		// 멤버 변수 앞에 반드시 this를 붙인다
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// 값을 읽기 위한 getter method를 만들어보자
	public String getName() {
		return this.name;
	}
	public Integer getAge() {
		return this.age;
	}

}
public class Ex8Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Orange.MESSAGE);
		
		Orange orange = new Orange();
//		System.out.println(orange.name); // 오류:private 변수는 직접 접근 불가
		orange.showData();
		orange.setAge(30);
		orange.setName("김두한");
		
		orange.showData();
		System.out.println(orange.getAge());
	}

}
