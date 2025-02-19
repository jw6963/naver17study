package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex3JTableSawon extends JFrame{
	JTable table;
	List<Sawon> sawonList=new Vector<Sawon>();
	static final String SAWONFILE = "c:/Users/jw/Desktop/Naver1210/study/mysawon.txt";
	
	public Ex3JTableSawon() {
		super("사원 파일 읽기");
		this.setBounds(300,100,400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true);
	}
	
	public void initDesign() {
		// 파일 정보 읽어오기
		this.sawonFileRead();
		Vector<String> title=new Vector<String>();
		title.add("사원명");
		title.add("나이");
		title.add("핸드폰");
		title.add("주소");
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		for (Sawon s:sawonList) {
			Vector<String> sawon = new Vector<String>();
			sawon.add(s.getSawonName());
			sawon.add(String.valueOf(s.getAge()));
			sawon.add(s.getHp());
			sawon.add(s.getAddr());
			data.add(sawon);
		}
		
		// jtable 생성
		table=new JTable(data,title);
				
		// North에 JLabel을 추가해보자
		this.add("North",new JLabel("데이터출력테이블",JLabel.CENTER));
				
		// frame의 center에 추가
//		this.add("Center",table) // 제목이 안 나옴, 데이터가 많을 경우 스크롤도 안됨
		this.add("Center",new JScrollPane(table)); // JScrollPane으로 생성해서 넣어야 이런 것들이 나타남
	}
	
	public void sawonFileRead() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr=new FileReader(SAWONFILE);
			br=new BufferedReader(fr);
			while (true) {
				String sawonInfo=br.readLine();
				if(sawonInfo==null) {
					break;
				}
				String[] s = sawonInfo.split("\\|");
				Sawon sawon = new Sawon();
				sawon.setSawonName(s[0]);
				sawon.setAge(Integer.parseInt(s[1]));
				sawon.setHp(s[2]);
				sawon.setAddr(s[3]);
				
				// List에 추가
				sawonList.add(sawon);
			}
			System.out.println("총 "+sawonList.size()+"명 읽음");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("저장된 사원 정보가 없습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException | NullPointerException  e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex3JTableSawon(); // 생성자 호출

		
	}

}
