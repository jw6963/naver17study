package day0106db;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * Mysql의 person table 관리 프로그램 만들기
 * 파일명: Ex3PersonTable, PersonModel, PersonDto
 * 아까와 같은 구조로 처음 시작 시 table에 person 데이터 출력
 * (출력 컬럼 : num,name,age,hp,blood)
 * 상단에 이름, 나이, 혈액형, 핸드폰 입력하고 [직원추가] 버튼 클릭 시 db에 추가 후 다시 전체 출력하기
 * 테이블의 데이터 클릭 후 [직원 삭제] 버튼 클릭 시 db에서 행 당 직원 삭제 후 다시 전체 출력하기
 */
public class Ex3PersonTable extends JFrame{

	JTextField tfName,tfAge,tfBlood,tfHp;
	JButton btnAdd,btnDel;
	DefaultTableModel tableModel;
	JTable table;
	
	PersonModel personModel = new PersonModel();
	
	
	public Ex3PersonTable() {
		super("person 관리");
		this.setBounds(300,100,600,400);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void initDesign() {
		JPanel p1=new JPanel();
		tfName=new JTextField(6);
		tfAge=new JTextField(3);
		tfBlood=new JTextField(2);
		tfHp=new JTextField(20);
		
		p1.add(new JLabel("이름"));
		p1.add(tfName);
		p1.add(new JLabel("나이"));
		p1.add(tfAge);
		p1.add(new JLabel("혈액형"));
		p1.add(tfBlood);
		p1.add(new JLabel("핸드폰"));
		p1.add(tfHp);
		
		// p1 panel frame 상단에 추가하기
		this.add("North", p1);
		
		// frame 중간에 table 넣기
		String[] title= {"번호","이름","나이","혈액형","핸드폰"};
		tableModel=new DefaultTableModel(title,0); // 제목과 데이터는 0개로 생성
		table= new JTable(tableModel);
		this.add("Center",new JScrollPane(table)); // 제목과 스크롤이 보이도록 추가
		
		// 데이터 출력
		this.selectRow();
		
		// 하단에 버튼 3개
		btnAdd=new JButton("직원추가");
		btnDel=new JButton("직원삭제");

		JPanel p2= new JPanel();
		p2.add(btnAdd);
		p2.add(btnDel);
		this.add("South",p2);
		
		// 상품추가 버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = tfName.getText();
				if (name.length()==0) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "이름을 입력해주세요");
					return; // 메세지 띄운 후 메서드 종료
				} 
				String text_age = tfAge.getText();
				int age = 0;
				if (text_age.length()==0) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "나이를 입력해주세요");
					return; // 메세지 띄운 후 메서드 종료
				} else {
					age=Integer.parseInt(text_age);
				}
				String blood = tfBlood.getText();
				if (blood.length()==0) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "혈액형을 입력해주세요");
					return; // 메세지 띄운 후 메서드 종료
				} 
				String hp = tfHp.getText();
				if (hp.length()==0) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "핸드폰을 입력해주세요");
					return; // 메세지 띄운 후 메서드 종료
				} 
				
				// insert 메서드 호출
				personModel.insertPerson(name,age,blood,hp);
				System.out.println("추가완료");
				// 전체 데이터 다시 출력
				selectRow();
				// 입력했던 데이터초기화
				tfName.setText("");
				tfAge.setText("");
				tfBlood.setText("");
				tfHp.setText("");
			}
		});
		
		// 삭제 버튼 이벤트
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 테이블에서 선택한 행 번호 가져오기
				int row=table.getSelectedRow();
				if (row==-1) { // 선택을 안했을 경우
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "선택된 행이 없습니다.");
					return; // 메세지 띄운 후 메서드 종료
				} else {
					// 선택한 행의 0번열(idx) 값 가져오기
//					int idx = Integer.parseInt(table.getValueAt(row, 0).toString()); // 방법1
					int num = Integer.parseInt((String)table.getValueAt(row, 0)); // 방법2
					// delete 메서드 호출
					personModel.deletePerson(num);
					// 전체 데이터 다시 출력
					selectRow();
				}
			}
		});
		
		
	}
	
	public void selectRow() {
		tableModel.setRowCount(0);
		
		List<Vector<String>> list = personModel.getDatas();
		for (Vector<String> data:list) {
			tableModel.addRow(data);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3PersonTable ex3 = new Ex3PersonTable();

		
		
	}

}