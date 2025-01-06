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

public class Ex2ShopTable extends JFrame{
	JTextField tfSang,tfSu,tfDan;
	JButton btnAdd,btnDel,btnUpdate,btnSearch;
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
		btnSearch=new JButton("검색");
		
		JPanel p2= new JPanel();
		p2.add(btnAdd);
		p2.add(btnDel);
		p2.add(btnUpdate);
		p2.add(btnSearch);
		this.add("South",p2);
		
		// 상품추가 버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 입력한 데이터들을 읽어서 dto로 묶어준다
				String sangpum = tfSang.getText();
				if (sangpum.length()==0) {
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "상품명을 입력해주세요");
					return; // 메세지 띄운 후 메서드 종료
				} 
				String text_su = tfSu.getText();
				int su = 0;
				if (text_su.length()==0) {
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "수량을 입력해주세요");
					return; // 메세지 띄운 후 메서드 종료
				} else {
					su=Integer.parseInt(text_su);
				}
				String text_dan = tfDan.getText();
				int dan=0;
				if (text_dan.length()==0) {
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "단가를 입력해주세요");
					return; // 메세지 띄운 후 메서드 종료
				} else {
					dan=Integer.parseInt(text_dan);
				}
				
				// insert 메서드 호출
				shopModel.insertShop(new ShopDto(sangpum,su,dan));
				// 전체 데이터 다시 출력
				rowSelect();
				// 입력했던 데이터초기화
				tfSang.setText("");
				tfSu.setText("");
				tfDan.setText("");
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
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "선택된 행이 없습니다.");
					return; // 메세지 띄운 후 메서드 종료
				} else {
					// 선택한 행의 0번열(idx) 값 가져오기
//					int idx = Integer.parseInt(table.getValueAt(row, 0).toString()); // 방법1
					int idx = Integer.parseInt((String)table.getValueAt(row, 0)); // 방법2
					// delete 메서드 호출
					shopModel.deleteShop(idx);
					// 전체 데이터 다시 출력
					rowSelect();
				}
			}
		});
		
		// 수정 버튼 이벤트
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 테이블에서 선택한 행 번호 가져오기
				int row=table.getSelectedRow();
				if (row==-1) { // 선택을 안했을 경우
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "선택된 행이 없습니다.");
					return; // 메세지 띄운 후 메서드 종료
				}
				int idx = Integer.parseInt((String)table.getValueAt(row, 0));
				
				String sangpum;
				int danga;
				
				sangpum = JOptionPane.showInputDialog("수정할 상품명을 입력해주세요");
				danga= Integer.parseInt(JOptionPane.showInputDialog("수정할 단가를 입력해주세요"));
				
				// update 메서드 호출
				shopModel.updateShop(idx,sangpum,danga);
				// 전체 데이터 다시 출력
				rowSelect();
				// 입력했던 데이터초기화
				tfSang.setText("");
				tfSu.setText("");
				tfDan.setText("");
			}
		});
	
		// 검색 버튼 이벤트
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 텍스트 필드에서 상품명을 입력하면 해당 상품 출력
				// 입력 안 하면 전체 출력
				String sangpum = tfSang.getText();
				if (sangpum.length()==0) {
					rowSelect();
				} else {
					// 기존 데이터 모두 삭제
					tableModel.setRowCount(0);
					// 검색 결과 가져오기
					List<Vector<String>> searchList= shopModel.searchDatas(sangpum);
					// 테이블에 출력
					for (Vector<String> data:searchList) {
						tableModel.addRow(data);
					}
				}
				// 입력했던 데이터초기화
				tfSang.setText("");
				tfSu.setText("");
				tfDan.setText("");
			}
		});
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
