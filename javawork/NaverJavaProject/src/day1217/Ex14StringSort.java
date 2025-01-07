package day1217;

public class Ex14StringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names= {"박성진","강영현","김원필","윤도운","공효진","손석구","이진","김미나","Adams","강호동","황진이"};
		// 이름의 오름차순으로 출력

		for (int i=0; i<names.length-1; i++) {
			for(int j=i+1;j<names.length; j++) {
				// names[i]가 names[j]보다 클 경우 양수값, 작을 경우 음수값
				if (names[i].compareTo(names[j])>0) { // 오름차순 정렬
					String temp=names[i];
					names[i]=names[j];
					names[j]=temp;
				}
			}
		}
		for (String a:names) {
			System.out.println(a);
		}
		
	}

}
