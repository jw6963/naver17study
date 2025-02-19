package day1219;

import java.util.Scanner;

public class Ex2ObjectArray {

	public static void dataInput(Student s) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 이름?");
		String name = sc.nextLine();
		System.out.println("학생 주소?");
		String addr = sc.nextLine();
		System.out.println("학생 혈액형?");
		String blood = sc.nextLine();
		
		s.changeStudent(name, addr, blood);
		System.out.println();
	}
	
	public static void showTitle() {
		System.out.println("이름\t혈액형\t주소");
		System.out.println("=".repeat(35));
	}
	
	public static void writeStudent(Student s) {
		System.out.println(s.getStuName()+"\t"+s.getStuBlood().toUpperCase()+"형\t"+s.getStuAddress());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int inwon;
		Student[] stuArray= {};
		
		System.out.println("입력할 인원 수는?");
		inwon = Integer.parseInt(sc.nextLine());
		// 메모리 할당
		stuArray = new Student[inwon];
		
		for (int i=0; i<stuArray.length;i++) {
			stuArray[i] = new Student();
			dataInput(stuArray[i]); // 객체 타입은 주소가 전달이 된다(주소를 통해서 데이터가 들어온다)
		}
		showTitle();
		for (int i=0; i<stuArray.length;i++) {
			writeStudent(stuArray[i]);
		}

		
	}
	

}
