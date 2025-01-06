package day0106db;

import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex2ShopTable extends JFrame{
	JTextField tfSang,tfSu,tfDan;
	JButton btnAdd,btnDel,btnUpdate;
	DefaultTableModel tableModel;
	JTable table;
	
	ShopModel shopModel = new ShopModel();
	
	public Ex2ShopTable() {
		super("shop 관리");
		this.setBounds(300,100,600,400);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void initDesign() {
		JPanel p1=new JPanel();
		tfSang=new JTextField(6);
		tfSu=new JTextField(3);
		tfDan=new JTextField(6);
		
		p1.add(new JLabel("상품명"));
		p1.add(tfSang);
		p1.add(new JLabel("수량"));
		p1.add(tfSu);
		p1.add(new JLabel("단가"));
		p1.add(tfDan);
		
		// p1 panel frame 상단에 추가하기
		this.add("North", p1);
		
		// frame 중간에 table 넣기
		String[] title= {"index","상품명","수량","단가","총금액","입고일"};
		tableModel=new DefaultTableModel(title,0); // 제목과 데이터는 0개로 생성
		table= new JTable(tableModel);
		this.add("Center",new JScrollPane(table)); // 제목과 스크롤이 보이도록 추가
		
		// 데이터 출력
		this.rowSelect();
		
		// 하단에 버튼 3개
		btnAdd=new JButton("상품추가");
		btnDel=new JButton("상품삭제");
		btnUpdate=new JButton("상품수정");
		
		JPanel p2= new JPanel();
		p2.add(btnAdd);
		p2.add(btnDel);
		p2.add(btnUpdate);
		this.add("South",p2);
	}
	
	// table에 데이터 출력하는 메서드
	public void rowSelect() {
		// 기존 테이블의 데이터 모두 삭제
		tableModel.setRowCount(0);
		
		// db의 모든 데이터 가져오기
		List<Vector<String>> list = shopModel.getAllDatas();
		for(Vector<String> data:list) {
			tableModel.addRow(data);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2ShopTable ex2 = new Ex2ShopTable();
		

	}

}
