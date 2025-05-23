package day1227;

import java.awt.print.Book;

// p704
// Workable
@FunctionalInterface
interface Workable {
	void work(String name, String job);
}
//Speakable
@FunctionalInterface
interface Speakable {
	void speak(String word);
}
// p705
// Person

class Person {
	public void action1(Workable workable) {
		workable.work("홍길동", "프로그래밍");
	}
	public void action2(Speakable speakable) {
		speakable.speak("안녕하세요?");
	}
}
public class Book705 {
	Workable a = (name, job) -> {
		System.out.print(name+"이 ");
		System.out.println(job+"을 합니다.");
	};
	Speakable b = (word) -> {
		System.out.print("\""+word+"\"");
		System.out.println("라고 합니다.");
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		
		person.action1((name, job) -> {
			System.out.print(name+"이 ");
			System.out.println(job+"을 합니다.");
		});

		person.action2((word)-> {
			System.out.print("\""+word+"\"");
			System.out.println("라고 합니다.");
		});
		
		Book705 book = new Book705();
		book.a.work("홍길동","운동");
		book.b.speak("Hi");
	}

}
