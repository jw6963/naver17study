package day1219;

public class Ex8StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Happy";
		// String -> StringBuffer
		StringBuffer sb = new StringBuffer(str);
		// 인스턴스 변수인 경우 변수명만 출력 시 자동으로 to String() 이 호출
		// toString을 갖고 있지 않는 경우 값이 아닌 주소가 출력된다
		System.out.println(sb);
		System.out.println(sb.toString());
		
		// String 은 값 자체를(일부) 변경할 수 없지만 StringBuffer는 문자열 편집이 가능함
		sb.append('A');
		sb.append(100);
		sb.append("BitCamp");
		System.out.println(sb);
		
		// 삭제
		sb.delete(5, 9); // 5~8번 인덱스 부분이 제거
		System.out.println(sb);
		
		// 삽입
		sb.insert(3, "java"); // 3번 인덱스 위치에 java 삽입
		System.out.println(sb);
		
		// 문자열 변경
		sb.replace(3, 7, "Hello");
		System.out.println(sb);
		
		// 데이터를 json 데이터로 변환
		String name = "캔디";
		int age=23;
		
		StringBuffer sb2=new StringBuffer();
		sb2.append("{\"name\":");
		sb2.append("\""+name+"\",");
		sb2.append("\"age\":");
		sb2.append(age+"}");
		System.out.println(sb2);
		
	}

}