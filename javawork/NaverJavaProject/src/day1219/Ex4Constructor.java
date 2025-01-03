package day1219;

class Orange {
	private String name;
	private String color;
	private int age;
	
	Orange() {
//		this.name = "홍길동";
//		this.color = "빨강";
//		this.age = 30;
		// 생성자에서 다른 생성자 호출 시 this() 사용
		this("홍길동","빨강"); // 인자가 맞는 생성자 호출
	}
	Orange(String name, String color) {
		this.name = name;
		this.color = color;
		this.age = 30;
	}
	// 메서드 오버로딩
	public void writeMemeber() {
		System.out.println("name= "+name+" color= "+color+" age= "+age);
		
	}
	
	public void writeMember(int n) {
		if(n==1) {
			System.out.println("이름 : "+name);
			System.out.println("좋아하는 색상: "+color);
			System.out.println("나이 : "+age);
			System.out.println("*".repeat(20));
		} else if(n==2) {
			System.out.println(name+"님은 "+color+" 색상을 좋아합니다");
		} else {
			System.out.println("1 or 2만 가능합니다");
		}
	}
}

public class Ex4Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Orange o1 = new Orange();
		o1.writeMemeber();
		
		Orange o2 = new Orange("김옥지","노랑");
		o2.writeMemeber();
		o2.writeMember(1);
		o2.writeMember(2);
		o2.writeMember(4);
	}

}
