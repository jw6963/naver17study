package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3OracleJoin {

	static final String ORACLE_DRIVER ="oracle.jdbc.OracleDriver";
	// db에 접근하려면 url과 id,password가 필요하다
	String url="jdbc:oracle:thin:@localhost:1521/xe";
	String username = "angel";
	String pw = "pw1234";
	
	public Ex3OracleJoin() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 드라이버 실패: "+e.getMessage());
		}
	}
	
	// db 연결 성공 후 Connection을 반환하는 메서드
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(url,username,pw);
			System.out.println("오라클 접속 성공");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("오라클 접속 실패:"+e.getMessage());
		}
		
		return conn;
	}
	
	public void shopWriteDate() {
		Connection conn = null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="""
				select
					s.sangcode,sangname,sangprice,cntnum,to_char(cartday,'yyyy-mm-dd') cartday
				from shop s, cart c
				where s.sangcode=c.sangcode
				""";
		
		conn=this.getConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql); // select sql문은 ResultSet이 반환되는 executeQuery만 가능
			// 여러 개인 경우 while문으로 rs.next()가 true인 동안만 반복
			System.out.println("상품코드\t상품명\t\t상품단가\t상품갯수\t날짜");
			System.out.println("=".repeat(50));
			while(rs.next()) {
				// 컬럼 명으로 가져와도 되고, 인덱스로 가져와도 된다. - 인덱스는 1번부터 시작
				String code=rs.getString("sangcode");
				String sname=rs.getString("sangname");
				String sprice=rs.getString("sangprice");
				String cntnum=rs.getString("cntnum");
				String day=rs.getString("cartday");
				System.out.println(code+"\t\t"+sname+"\t"+sprice+"\t\t"+cntnum+"\t"+day);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("sql문 오류: "+e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3OracleJoin ex3 = new Ex3OracleJoin();
		ex3.shopWriteDate();

	}

}