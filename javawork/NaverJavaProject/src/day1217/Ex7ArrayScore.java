package day1217;

import java.util.Scanner;

public class Ex7ArrayScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 인원 수를 입력 후 그 인원 수만큼 이름과 점수를 입력하고
		 * 등수와 총점과 평균을 구하여 출력하시오
		 */
		Scanner sc = new Scanner(System.in);
		int n;
		int[] score,rank;
		String[] name;
		int total=0;
		double avg;
		
		System.out.println("인원 수 입력");
		n=Integer.parseInt(sc.nextLine());
		score=new int[n];
		name=new String[n];
		for (int i=0; i<n; i++) {
			System.out.println(i+1+"번째 인원의 이름을 입력");
			name[i]=sc.nextLine();
			System.out.println(i+1+"번째 인원의 점수를 입력");
			score[i]=Integer.parseInt(sc.nextLine());
			total+=score[i];
		}
		avg=total/(double)n;
		
		rank=new int[n];
		for (int i=0; i<n; i++) {
			rank[i]=1;
			for (int j=0;j<n; j++) {
				if(score[i]<score[j]) {
					rank[i]++;
				}
			}
		}
		
		System.out.println("=".repeat(30));
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("=".repeat(30));
		for (int i=0; i<n;i++) {
			System.out.println(i+1+"\t"+name[i]+"\t"+score[i]+"\t"+rank[i]);
		}
		System.out.println("=".repeat(30));
		System.out.printf("총점: %d\t평균: %.2f\n",total,avg);
		System.out.println("=".repeat(30));
	}

}
