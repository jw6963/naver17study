package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.NullCipher;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex5TableStudent extends JFrame{
	static final String FILENAME="c:/Users/jw/Desktop/Naver1210/study/student.txt";
	List<Student> list = new ArrayList<Student>();
	JTable table;

	public Ex5TableStudent() {
		super("학생 성적 관리");
		this.setBounds(300,100,400,300);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void studentFileRead() {
		// 파일을 읽어서 list 변수에 담기
		FileReader fr = null;
		BufferedReader br =null;
		try {
			fr= new FileReader(FILENAME);
			br= new BufferedReader(fr);
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				String[] s = line.split("\\|");
				Student student = new Student();
				student.setName(s[0]);
				student.setEng(Integer.parseInt(s[1]));
				student.setKor(Integer.parseInt(s[2]));

				list.add(student);
			}
			System.out.println(list.size()+"명 읽음");
		} catch (FileNotFoundException|NullPointerException e) {
			// TODO: handle exception
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public void initDesign() {

		this.studentFileRead(); // 파일을 읽어서 list 변수에 담는다
		// list의 데이터를 읽어서 테이블에 출력
		// 프레임에 출력하시오
		// 제목은 이름,국어,영어,총점,평균
		String[] title = {"이름","국어","영어","총점","평균"};
		String[][] data = new String[list.size()][title.length];

		for (int i=0; i<list.size();i++) {
			Student a =list.get(i);
			data[i][0] = list.get(i).getName();
			data[i][1] = String.valueOf(a.getKor());
			data[i][2] = String.valueOf(a.getEng());
			data[i][3] = String.valueOf(a.getEng()+a.getKor());
			data[i][4] = String.valueOf((a.getEng()+a.getKor())/2.0);
		}

		table = new JTable(data,title);

		this.add("North",new JLabel("데이터 출력 테이블",JLabel.CENTER));

		this.add("Center",new JScrollPane(table));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex5TableStudent();

	}

}
