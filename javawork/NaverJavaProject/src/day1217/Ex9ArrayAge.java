package day1217;

public class Ex9ArrayAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] datas= {12,34,54,20,33,59,41,44,27,21};
		System.out.println("인원 수 : "+datas.length);
		/*
		 * 위의 데이터를 분석하여 10대부터 40대까지 각각의 인원수를 구하시오
		 * 배열변수 []age를 이용해서 구하시오
		 * 0번지에는 10대 인원수...
		 * 
		 * 출력 양식
		 * 10대 : 1명
		 * 20대 : 3명
		 * .
		 * .
		 */

		int[] age;
		int max=datas[0];
		for (int i=0; i<datas.length; i++) {
			if (max<datas[i]) {
				max = datas[i];
			}
		}
		age = new int[max/10];
		for (int i=0; i<datas.length; i++) {
			age[((datas[i]/10) - 1)]++;
		}
		for (int i=0; i<age.length; i++) {
			System.out.print((i+1)*10+"대 인원수 :"+age[i]+"\n");
		}
		
	}

}
