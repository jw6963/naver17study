package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex4MysqlJoin {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username="root";
	String pw="0000";

	public Ex4MysqlJoin() {
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql 드라이버 실패: "+e.getMessage());
		}
	}

	// db 연결 성공 후 Connection을 반환하는 메서드
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(url,username,pw);
			System.out.println("Mysql 접속 성공");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Mysql 접속 실패:"+e.getMessage());
		}

		return conn;
	}

	public void personWriteDate() {
		Connection conn = null;
		Statement stmt=null;
		ResultSet rs=null;
		//			String sql="select name,age,blood,hp,date_format(today,\"%Y-%m-%d %H:%i\") today from person"; // 방법1
		String sql="""
				select
					p.name,p.blood,hp,p.age,s.kor,s.eng,s.sum 
				from person p, stu s
				where p.num=s.num
				"""; // 방법 2 멀티 라인 문자열

		conn=this.getConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql); // select sql문은 ResultSet이 반환되는 executeQuery만 가능
			// 여러 개인 경우 while문으로 rs.next()가 true인 동안만 반복
			System.out.println("이름\t나이\t혈액형\t전화번호\t국어\t영어\t합계");
			System.out.println("=".repeat(60));
			while(rs.next()) {
				// 컬럼 명으로 가져와도 되고, 인덱스로 가져와도 된다. - 인덱스는 1번부터 시작
				String name=rs.getString("name");
				String age=rs.getString("age");
				String blood=rs.getString("blood");
				String hp=rs.getString("hp");
				String kor=rs.getString("kor");
				String eng=rs.getString("eng");
				String sum=rs.getString("sum");
				System.out.println(name+"\t"+age+"\t"+blood+"\t"+hp+"\t"+kor+"\t"+eng+"\t"+sum);
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

	public void personBlood() {
		
		// 혈액형별 인원수와 나이 평균 구하기
		String sql="""
				select 
					blood, count(*) cnt, round(avg(age),1) avgage
				from person
				group by blood order by cnt
				""";
		Connection conn = null;
		Statement stmt=null;
		ResultSet rs=null;
		conn=this.getConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql); // select sql문은 ResultSet이 반환되는 executeQuery만 가능
			// 여러 개인 경우 while문으로 rs.next()가 true인 동안만 반복
			System.out.println("혈액형\t인원수\t평균 나이");
			System.out.println("=".repeat(60));
			while(rs.next()) {
				// 컬럼 명으로 가져와도 되고, 인덱스로 가져와도 된다. - 인덱스는 1번부터 시작
				String blood=rs.getString("blood");
				int cnt=rs.getInt("cnt");
				int avgage=rs.getInt("avgage");
				System.out.println(blood+"\t"+cnt+"\t"+avgage);
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
		Ex4MysqlJoin ex4 = new Ex4MysqlJoin();
		ex4.personWriteDate();
		ex4.personBlood();


	}

}