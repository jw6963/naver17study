package db.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnect {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username="root";
	String pw="0000";
	
	// camp134
	String url2="jdbc:mysql://db-324ocg-kr.vpc-pub-cdb.ntruss.com:3306/studydb?serverTimezone=Asia/Seoul";
	String username2="study";
	String pw2="bitcamp!@#123";
	
	public MysqlConnect() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Mysql driver 실패: "+e.getMessage());
		}
	}
	
	public Connection getConnection() {
		Connection conn =null;
		try {
			conn = DriverManager.getConnection(url,username,pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql 연결 실패: "+e.getMessage());
		}
		
		return conn;
	}
	
	public Connection getNaverConnection() {
		Connection conn =null;
		try {
			conn = DriverManager.getConnection(url2,username2,pw2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ncp Mysql 연결 실패: "+e.getMessage());
		}
		
		return conn;
	}
	
	public void dbClose(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException|NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException|NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}