package day0106db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class PersonModel {

	MysqlConnect connect = new MysqlConnect();
	
	// select *
	public List<Vector<String>> getDatas() {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from study502.person order by num";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector<String> data = new Vector<String>();
				data.add(String.valueOf(rs.getInt("num")));
				data.add(rs.getString("name"));
				data.add(String.valueOf(rs.getInt("age")));
				data.add(rs.getString("hp"));
				data.add(rs.getString("blood"));
				
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connect.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	// insert
	public void insertPerson(String name, int age, String blood, String hp) {
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into study502.person (name,age,blood,hp,today) values (?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, blood);
			pstmt.setString(4, hp);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connect.dbClose(pstmt, conn);
		}
	}
	
	// delete
	public void deletePerson(int num) {
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from study502.person where num = ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connect.dbClose(pstmt, conn);
		}
	}
}