package day0107db;

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

//create table foodrest (
//	num smallint auto_increment primary key,
//	foodname varchar(30),
//	foodprice int,
//	foodsize varchar(20) default '보통');
//
//create table foodorder (
//	idx smallint auto_increment primary key,
//	num smallint,
//	ordername varchar(20),
//	ordercnt smallint,
//	bookingday datetime,
//	constraint fk_foodorder_num foreign key(num) references foodrest(num));
public class Ex1FoodMysqlDb extends JFrame {

	FoodModel foodModel = new FoodModel();
	DefaultTableModel foodRestTableModel;
	DefaultTableModel foodOrderTableModel;
	JTable foodRestTable;
	JTable foodOrderTable;

	JButton btnFoodRestAdd, btnFoodRestDel;
	JButton btnFoodOrderAdd, btnFoodOrderDel;
	JTextField tfFoodNum, tfOrderName, tfOrderCnt, tfBookingDay;
	JTextField tfFoodName, tfFoodPrice, tfFoodSize;

	public Ex1FoodMysqlDb() {
		super("메뉴등록 및 예약");
		this.setBounds(200,100,1100,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true);
	}

	public void initDesign() {
		// 상단에 버튼 배치
		JPanel p1 = new JPanel();
		btnFoodRestAdd=new JButton("메뉴등록");
		btnFoodRestDel=new JButton("메뉴삭제");
		btnFoodOrderAdd=new JButton("예약하기");
		btnFoodOrderDel=new JButton("예약취소");

		tfFoodName=new JTextField(7);
		tfFoodPrice=new JTextField(7);
		tfFoodSize=new JTextField(5);

		p1.add(new JLabel("메뉴명"));
		p1.add(tfFoodName);
		p1.add(new JLabel("가격등록"));
		p1.add(tfFoodPrice);
		p1.add(new JLabel("사이즈"));
		p1.add(tfFoodSize);

		p1.add(btnFoodRestAdd);
		p1.add(btnFoodRestDel);
		p1.add(btnFoodOrderAdd);
		p1.add(btnFoodOrderDel);
		this.add("North",p1);

		// 왼쪽에 등록된 메뉴 보이게 하기
		String[] menuTitle= {"번호","메뉴명","가격","사이즈"};
		foodRestTableModel=new DefaultTableModel(menuTitle,0); // 제목과 행갯수 일단 0으로
		foodRestTable=new JTable(foodRestTableModel);
		this.add("West",new JScrollPane(foodRestTable));

		// 가운데 예약테이블 보이게 하기
		String[] orderTitle= {"번호","예약자명","메뉴명","가격","사이즈","인원수","예약일"};
		foodOrderTableModel=new DefaultTableModel(orderTitle,0);
		foodOrderTable=new JTable(foodOrderTableModel);
		this.add("Center",new JScrollPane(foodOrderTable));

		// 하단에 예약내용 입력부분 추가
		tfOrderName=new JTextField(5);
		tfOrderCnt=new JTextField(3);
		tfBookingDay=new JTextField(10);
		tfFoodNum=new JTextField(3);

		JPanel p2=new JPanel();
		p2.add(new JLabel("메뉴번호"));
		p2.add(tfFoodNum);

		p2.add(new JLabel("예약자명"));
		p2.add(tfOrderName);

		p2.add(new JLabel("인원수"));
		p2.add(tfOrderCnt);

		p2.add(new JLabel("예약시간"));
		p2.add(tfBookingDay);

		this.add("South",p2);
		
		this.writeFoodMenu();
		this.writeFoodOrderJoin();

		// 버튼 이벤트들

		// 메뉴 등록 버튼
		btnFoodRestAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String foodName=tfFoodName.getText();
				int foodPrice=Integer.parseInt(tfFoodPrice.getText());
				String foodSize=tfFoodSize.getText();
				
				// insert 메서드 호출
				foodModel.foodMenuInsert(foodName, foodPrice, foodSize);
				
				// 테이블 다시 출력
				writeFoodMenu();
				// 입력데이터 초기화
				tfFoodName.setText("");
				tfFoodPrice.setText("");
				tfFoodSize.setText("");

			}
		});

		// 메뉴 삭제 버튼
		btnFoodRestDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=foodRestTable.getSelectedRow();
				if (row==-1 ) {
					JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "삭제하려는 메뉴를 선택해 주세요");
					return;
				}
				int num=Integer.parseInt(foodRestTable.getValueAt(row, 0).toString());
				System.out.println(num); // 콘솔로 먼저 확인하기
				
				// 해당 메뉴를 예약한 예약 갯수 구하기
				int cnt=foodModel.getOrderMenuCount(num);
				if(cnt==0) {
					foodModel.deleteFoodMenu(num);
					JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "삭제되었습니다.");
					writeFoodMenu();
				} else {
					JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "해당 메뉴는 예약자가 있어 삭제가 안됩니다."
							+ "\n먼저 예약을 취소해주세요.");
				}
				

			}
		});

		// 예약버튼
		btnFoodOrderAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 입력 값들 읽어오기
				int num = Integer.parseInt(tfFoodNum.getText());
				String orderName = tfOrderName.getText();
				int orderCnt=Integer.parseInt(tfOrderCnt.getText());
				String bookingDay = tfBookingDay.getText();
				
				// dto에 넣어주기
				FoodOrderDto dto = new FoodOrderDto(num, orderName, orderCnt, bookingDay);
				
				// 예약 insert 메서드 호출하기
				foodModel.foodOrderInsert(dto);
				
				// 다시 출력하기
				writeFoodOrderJoin();
				
				// 입력 값 초기화
				tfFoodNum.setText("");
				tfOrderName.setText("");
				tfOrderCnt.setText("");
				tfBookingDay.setText("");

			}
		});

		// 예약취소 버튼
		btnFoodOrderDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 0번열의 idx값을 얻어서 삭제 후
				// "예약이 취소되었습니다" 알림
				// 선택 안했을 경우 "취소할 데이터를 선택해주세요"
				int row = foodOrderTable.getSelectedRow();
				if (row==-1) {
					JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "취소할 데이터를 선택해 주세요");
					return;
				}
				int idx = Integer.parseInt(foodOrderTable.getValueAt(row, 0).toString());
				foodModel.deleteFoodOrder(idx);
				JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "예약이 취소되었습니다.");
				writeFoodOrderJoin();

			}
		});

		
	}

	public void writeFoodMenu() {
		// db에서 전체 등록된 메뉴를 얻는다
		List<Vector<String>> list = foodModel.getAllMenus();
		// 기존 메뉴들 삭제
		foodRestTableModel.setRowCount(0);
		// table에 출력
		for(Vector<String> data:list) {
			foodRestTableModel.addRow(data);
		}

	}

	public void writeFoodOrderJoin() {
		List<Vector<String>> list = foodModel.getAllOrders();
		// 기존 메뉴들 삭제
		foodOrderTableModel.setRowCount(0);
		// table에 출력
		for(Vector<String> data:list) {
			foodOrderTableModel.addRow(data);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1FoodMysqlDb ex1 = new Ex1FoodMysqlDb();

	}

}