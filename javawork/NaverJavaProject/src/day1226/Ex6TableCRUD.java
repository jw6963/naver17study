package day1226;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex6TableCRUD extends JFrame{
	static final String FILENAME="c:/Users/jw/Desktop/Naver1210/study/student.txt";
	List<Student> list = new ArrayList<Student>();
	JTable table;
	DefaultTableModel tableModel; // 추가, 삭제 등의 메서드를 갖고 있는 클래스 모델
	JTextField tfName, tfKor,tfEng,tfName2;
	JButton btnAdd,btnDel;

	public Ex6TableCRUD() {
		super("학생 성적 관리");
		this.setBounds(300,100,400,300);

		this.initDesign();
		this.setVisible(true);
		
		// 윈도우 x 버튼 클릭 시 이벤트 발생시켜서 파일을 저장한다.
		// 익명 내부클래스 형태로 이벤트를 구현한다.
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e); // 없어도 됨. 역할 x
				// list의 내용을 파일에 저장한다
				saveFile();
				JOptionPane.showMessageDialog(null, "저장되었습니다.");
				System.exit(0);
			}
		});
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
		// 파일 읽어오기
		this.studentFileRead();

		// 테이블을 생성해서 center에 추가
		String[] title= {"이름","국어","영어","총점","평균"};
		String[][] data = new String[list.size()][title.length];

		for (int i=0; i<list.size();i++) {
			Student a =list.get(i);
			data[i][0] = list.get(i).getName();
			data[i][1] = String.valueOf(a.getKor());
			data[i][2] = String.valueOf(a.getEng());
			data[i][3] = String.valueOf(a.getEng()+a.getKor());
			data[i][4] = String.valueOf((a.getEng()+a.getKor())/2.0);
		}
		tableModel=new DefaultTableModel(data,title); // 일단 행갯수는 0으로 생성
//		tableModel.setValueAt(data, list.size(), title.length);
		table=new JTable(tableModel);
		// frame에 추가
		this.add("Center",new JScrollPane(table));

		// 입력 부분 디자인
		JPanel panelAdd=new JPanel();
		tfName=new JTextField(5);
		tfKor=new JTextField(4);
		tfEng=new JTextField(4);

		btnAdd=new JButton("추가");

		// panel에 각 컴포넌트들 추가
		panelAdd.add(new JLabel("이름"));
		panelAdd.add(tfName);
		panelAdd.add(new JLabel("국어"));
		panelAdd.add(tfKor);
		panelAdd.add(new JLabel("영어"));
		panelAdd.add(tfEng);
		panelAdd.add(btnAdd);
				
		// 추가 버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			private Component MyFrame;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = tfName.getText();
		        int kor=0, eng=0;
		        if(name.isEmpty()) {
		        	JOptionPane.showMessageDialog(this.MyFrame, "이름을 입력해주세요.");
		        	return;
		        }
				try {
					kor = Integer.parseInt(tfKor.getText());
		            eng = Integer.parseInt(tfEng.getText());
				} catch (NumberFormatException ex) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "국어와 영어 점수는 숫자로 입력해야 합니다.");
		            return;
				} 
				
				Student newStudent = new Student(name,kor,eng);
				addStudent(newStudent);
				tableModel.addRow(new Object[] {
			            newStudent.getName(),
			            newStudent.getKor(),
			            newStudent.getEng(),
			            newStudent.getKor() + newStudent.getEng(),
			            (newStudent.getKor() + newStudent.getEng()) / 2.0
			        });
				
				JOptionPane.showMessageDialog(this.MyFrame, "추가되었습니다.");
				tfName.setText("");
		        tfKor.setText("");
		        tfEng.setText("");
			}
		});

		// frame에 panel을 상단에 추가하자
		this.add("North",panelAdd);
		
		// 삭제 부분
		JPanel panelDel = new JPanel();
		tfName2=new JTextField(5);
		btnDel=new JButton("삭제");
		
		panelDel.add(new JLabel("이름"));
		panelDel.add(tfName2);
		panelDel.add(btnDel);
		
		// frame 하단에 추가
		this.add("South",panelDel);
		
		// 삭제 버튼 이벤트
		btnDel.addActionListener(new ActionListener() {
			private Component MyFrame;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = tfName2.getText();
		        if(name.isEmpty()) {
		        	JOptionPane.showMessageDialog(this.MyFrame, "이름을 입력해주세요.");
		        	return;
		        }
				
		        int idx = getSearchName(name); // 이름으로 인덱스 검색
		        if (idx == -1) {
		            JOptionPane.showMessageDialog(this.MyFrame, "명단에 없는 학생입니다.");
		            return;
		        }

		        // 데이터 삭제
		        list.remove(idx);
		        tableModel.removeRow(idx); // 테이블에서 해당 행 삭제

		        JOptionPane.showMessageDialog(this.MyFrame, "삭제되었습니다.");
		        tfName2.setText(""); // 입력 필드 초기화
			}
		});
	}

	public void saveFile() {
		// List의 내용을 파일에 저장한다.
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			for (Student stu:list) {
				String s=stu.getName()+"|"+stu.getKor()+"|"+stu.getEng()+"\n";
				// 파일에 추가
				fw.write(s);
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
	
	public void addStudent(Student student) {
		list.add(student);
	}
	
	public int getSearchName(String name) {
		int idx=-1;
		for (int i=0; i<list.size(); i++) {
			Student stu=list.get(i);
			if(stu.getName().equals(name)) {
				idx=i;
				break;
			}
		}

		return idx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex6TableCRUD ex6 = new Ex6TableCRUD();
	}

}
