package day1224;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex12FileList {
	static final String FILENAME="C:\\Users\\jw\\Desktop\\naver1210\\study\\sawon.txt";
	
	List<String> sawonList=new Vector<String>();

	public Ex12FileList() {
		// 파일에서 이름을 읽어서 sawonList에 추가해주세요
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			while(true) {
				String line=br.readLine();
				if(line==null) {
					break;
				}
				try {
					sawonList.add(line);
				} catch (NumberFormatException e) {
					// TODO: handle exception
				}
			}
		} catch (IOException|NullPointerException e) {
			// TODO: handle exception
			System.out.println("파일을 찾을 수 없습니다.");
		} finally {
			if (br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		}
		
		
	}
	
	public void showTitle() {
		int n=0;
		n=sawonList.size();
		System.out.println("총 "+n+"명의 사원이 있습니다.");
		System.out.println("번호\t사원명");
		System.out.println("=".repeat(30));
	}
	public void sawonMemberList() {
		// 사원 이름을 번호와 함께 출력해주세요
		showTitle();
		int n=0;
		for (String s:sawonList) {
			System.out.println(++n+"\t"+s);
		}
		System.out.println();
	}
	// 해당 이름이 몇 번 인덱스에 있는지 리턴 (없으면 -1 리턴)
	public int getSearchName(String name) {
		int idx=-1;
		for(int i=0;i<sawonList.size();i++) {
			String listName = sawonList.get(i);
			if(listName.equals(name)) {
				idx=i;
				break;
			}
		}
		return idx;
	}
	
	// 이름 입력 시 삭제하는 메서드
	public void deleteSawon(String name) {
		int idx=this.getSearchName(name);
		if(idx==-1) {
			System.out.println(name+"님은 명단에 없습니다.");
		} else {
			sawonList.remove(idx);
			System.out.println(name+"님을 명단에서 삭제했습니다.");
		}
	}
	
	// 이름 조회
	public void searchName(String name) {
		int idx=this.getSearchName(name);
		if (idx==-1) {
			System.out.println(name+"님은 명단에 없습니다.");
		} else {
			System.out.println(name+"님은 "+(idx+1)+"번째에 있습니다.");
		}
	}
	
	// List의 이름들을 다시 파일에 저장하기
	public void sawonFileSave() {
		FileWriter fw=null;
		try {
			fw=new FileWriter(FILENAME);
			for (String name:sawonList) {
				fw.write(name+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	// 사원 추가
	public void addSawon(String name) {
		// 이미 존재할 경우 추가 못함
		int idx=this.getSearchName(name);
		if(idx!=-1) {
			System.out.println(name+"님은 이미 존재합니다.");
		} else {
			sawonList.add(name);
			System.out.println("추가되었습니다.");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Ex12FileList ex12 = new Ex12FileList();
		
		int menu=0;
		
		while(true) {
			System.out.println("1.사원추가 2.사원삭제 3.사원검색 4.명단조회 5.저장 후 종료");
			System.out.println("=".repeat(50));
			try {
				menu=Integer.parseInt(sc.nextLine());				
			} catch (NumberFormatException e) {
				// TODO: handle exception
				menu=4; // 문자 잘못 입력 시 전체 목록이 나오도록
				System.out.println("잘못된 요청입니다.");
				
			}
			switch(menu) {
			case 1-> {
				System.out.println("추가할 사원명을 입력하세요");
				String name=sc.nextLine();
				ex12.addSawon(name);
			}
			case 2 -> {
				System.out.println("삭제할 사원명을 입력하세요");
				String name=sc.nextLine();
				ex12.deleteSawon(name);
			}
			case 3 -> {
				System.out.println("검색할 사원명을 입력하세요");
				String name=sc.nextLine();
				ex12.searchName(name);
			}
			case 4 -> {
				ex12.sawonMemberList();
			}
			default -> {
				System.out.println("**저장 후 종료합니다.**");
				ex12.sawonFileSave();
				System.exit(0);;
			}
			}
			
		}
		

	}

}
