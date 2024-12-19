package day1219;

import java.util.Scanner;

public class Ex1ObjectArray {
	Student[] stuArray=new Student[3]; // 초기값은 null
	
	public void inputData() {
//		System.out.println("input Data");
		Scanner sc = new Scanner(System.in);
//		for (Student s:stuArray) { // forEach방식은 로컬 변수 s를 초기화하지만 stuArray에 직접 반영하지 않음. 따라서 출력 시 stuArray의 값에 null로 인식되어 에러 발생
		for (int i=0; i<stuArray.length; i++) {
//			s = new Student();
			stuArray[i] = new Student();
			
			System.out.println("학생 이름 입력");
			String name = sc.nextLine();
			System.out.println("혈액형 입력");
			String blood = sc.nextLine();
			System.out.println("태어난 년도 입력");
			int birthYear = Integer.parseInt(sc.nextLine());
			System.out.println("점수 입력");
			int score = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			// 데이터 삽입
//			s.setStuName(name);
//			s.setStuBlood(blood);
//			s.setStuBirthYear(birthYear);
//			s.setStuScore(score);
			stuArray[i].setStuName(name);
			stuArray[i].setStuBlood(blood);
			stuArray[i].setStuBirthYear(birthYear);
			stuArray[i].setStuScore(score);
		}
	}
	
	public static void showTitle() {
//		System.out.println("show Title");
		System.out.println("이름\t혈액형\t나이\t점수\t학점");
		System.out.println("=".repeat(50));
	}
	
	public void writeDataArray() {
//		System.out.println("write Data");
		for (Student s:stuArray) {
			System.out.println(s.getStuName()+"\t"+s.getStuBlood().toUpperCase()+"형\t"+s.getAge()+"\t"+s.getStuScore()+"\t"+s.getScoreGrade());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1ObjectArray ex1 = new Ex1ObjectArray();
		// 데이터 입력
		ex1.inputData();
		// 제목 출력
		showTitle(); // static
		// 데이터 출력
		ex1.writeDataArray();
		
	}

}
