package day0106db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.connect.MysqlConnect;

public class Ex1ShopMysql {
	MysqlConnect mysqlConnect= new MysqlConnect();

	// shop에 상품 추가
	public void insertShop(String sangpum, int su, int danga) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// statement는 불가능하지만 PreparedStatement는 ?로 값을 미리 선언할 수 있다.
		String sql = "insert into shop (sangpum,su,danga,ipgoday) values (?,?,?,now())";
		
		// db 연결
		conn=mysqlConnect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql); // 이때 sql문을 검사한다
			// ? 갯수만큼 데이터를 넣어준다.(바인딩)
			// 첫번째 물음표부터 1번,2번,...
			pstmt.setString(1, sangpum); // 타입별로
			pstmt.setInt(2, su);
			pstmt.setInt(3, danga);
			
			// 바인딩을 모두 마친 후 실행을 하는데 이때 sql문을 보내면 안되고 그냥 실행만 해야 한다.
			pstmt.execute();
			System.out.println("상품을 추가했습니다.");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}
	
	// 전체 shop 데이터 출력
	public void writeShop() {
		System.out.println("전체 상품을 출력합니다.");
		System.out.println("index\t상품명\t수량\t단가\t총금액\t입고일");
		System.out.println("=".repeat(65));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from shop";
		conn=mysqlConnect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int idx=rs.getInt("idx");
				String sangpum=rs.getString("sangpum");
				int su = rs.getInt("su");
				int dan = rs.getInt("danga");
				int total = su*dan;
				String ipgo = rs.getString("ipgoday").substring(0,16);
				
				System.out.println(idx+"\t"+sangpum+"\t"+su+"\t"+dan+"\t"+total+"\t"+ipgo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}
	}
	
	// 상품 삭제
	public void deleteShop(String sangpum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from shop where sangpum=?";
		conn=mysqlConnect.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,sangpum);
			int cnt = pstmt.executeUpdate();
			if (cnt>0) {
				System.out.println("총 "+cnt+"개의 상품을 삭제했습니다.");
			} else {
				System.out.println("["+sangpum+"] 상품이 없습니다.");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}
	
	// 상품 조회
	public void searchShop(String sangpum) {
		System.out.println("["+sangpum+"] 상품을 조회합니다.");
		System.out.println("index\t상품명\t수량\t단가\t총금액\t입고일");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from shop where sangpum like ? order by idx";
		conn = mysqlConnect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%"+sangpum+"%");
			rs=pstmt.executeQuery();
			
			int cnt=0;
			while(rs.next()) {
				cnt++;
				int idx=rs.getInt("idx");
				String sang=rs.getString("sangpum");
				int su = rs.getInt("su");
				int dan = rs.getInt("danga");
				int total = su*dan;
				String ipgo = rs.getString("ipgoday").substring(0,16);
				
				System.out.println(idx+"\t"+sang+"\t"+su+"\t"+dan+"\t"+total+"\t"+ipgo);
			}
			if (cnt==0) {
				System.out.println("["+sangpum+"] 관련 제품이 없습니다.");
			} else {
				System.out.println("["+sangpum+"] 관련 제품이 총"+cnt+"개 조회되었습니다.");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}
		
	}
	
	// 상품 수정
	public void updateShop(int idx,int su, int danga) {
		/*
		 * idx에 해당하는 su,danga 수정
		 * excuteUpdate로 int 타입 반환값을 받아서
		 * 0이면 해당 상품이 없습니다
		 * 0이 아니면 해당 상품정보를 수정했습니다
		 */
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update shop set su=?,danga=? where idx=?";
		
		conn=mysqlConnect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, su);
			pstmt.setInt(2, danga);
			pstmt.setInt(3, idx);
			int cnt = pstmt.executeUpdate();
			if (cnt==0) {
				System.out.println("해당 상품이 없습니다");
			} else {
				System.out.println(idx+"번 상품 정보가 수정되었습니다.");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1ShopMysql ex1 = new Ex1ShopMysql();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("=".repeat(65));
			System.out.println("\t** 상품관리 메뉴 **\n");
			System.out.println("1.상품추가 2.전체출력 3.상품조회 4.상품삭제 5.상품수정 6.종료");
			System.out.print("번호 선택(1-6) : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 -> {
				System.out.println("상품명을 입력하세요");
				String sangpum = sc.nextLine();
				System.out.println("수량을 입력하세요");
				int su = Integer.parseInt(sc.nextLine());
				System.out.println("단가를 입력하세요");
				int danga = Integer.parseInt(sc.nextLine());
				
				ex1.insertShop(sangpum, su, danga);
			} case 2-> {
				ex1.writeShop();
			} case 3-> {
				System.out.println("상품명을 입력하세요");
				String sangpum= sc.nextLine();
				
				ex1.searchShop(sangpum);
			} case 4-> {
				System.out.println("상품명을 입력하세요");
				String sangpum=sc.nextLine();
				
				ex1.deleteShop(sangpum);
			} case 5-> {
				System.out.println("상품번호를 입력하세요");
				int idx = Integer.parseInt(sc.nextLine());
				System.out.println("수량을 입력하세요");
				int su = Integer.parseInt(sc.nextLine());
				System.out.println("단가를 입력하세요");
				int danga = Integer.parseInt(sc.nextLine());
				
				ex1.updateShop(idx, su, danga);
				
			}
			default -> {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			}
		}

	}

}