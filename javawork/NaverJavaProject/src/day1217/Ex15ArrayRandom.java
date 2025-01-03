package day1217;

public class Ex15ArrayRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers=new int[20];
		/*
		 * 배열에 1~50 사이의 난수 20개를 넣고
		 * 오름차순으로 정렬해서 출력하시오
		 * 
		 * 중복되는 수가 있을 경우 수를 다시 구하시오
		 */
		
		int cnt= 0;
		for(int i=0;i<numbers.length;i++) {
			numbers[i] = (int)(Math.random()*50)+1;
			// 이전에 발생한 값이랑 같을 경우 다시 구하기 - 중복처리 로직 추가
			for (int j=0; j<i; j++) {
				if (numbers[i] == numbers[j]) {
					cnt++;
					System.err.println("중복 발생 "+cnt);
					i--;
					break;
				} 
			}
			
		}
		for (int i=0; i<numbers.length-1; i++) {
			for (int j=i+1; j<numbers.length; j++) {
				if (numbers[i]>numbers[j]) {
					int temp=numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=temp;
				}
			}
		}
		for (int i=0; i<numbers.length; i++) {
			System.out.print(i+1+": "+numbers[i]+"\t");
			if((i+1)%5==0) {
				System.out.println();
			}
		}
		

	}

}
