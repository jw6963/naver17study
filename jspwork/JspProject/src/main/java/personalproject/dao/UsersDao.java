package personalproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.connect.MysqlConnect;
import personalproject.dto.UsersDto;

public class UsersDao {
	MysqlConnect db=new MysqlConnect();
	
	public boolean Login(String userId, String passwd) throws SQLException {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    String sql = "SELECT * FROM users WHERE userId = ? AND passwd = ?";
	    conn=db.getPpConnection();
	    pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userId);
        pstmt.setString(2, passwd);
        rs = pstmt.executeQuery();
        
        if (rs.next()) {
            // 로그인 성공
        	db.dbClose(rs, pstmt, conn);
            return true;
        } else {
            // 로그인 실패
        	db.dbClose(rs, pstmt, conn);
            return false;
        }

	}
	public UsersDto getUser(String userId) {
		UsersDto dto = null;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "SELECT userId,role,suspension from users WHERE userId = ?";
		
	    conn=db.getPpConnection();
	    try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto = new UsersDto();
				dto.setUserId(rs.getString("userId"));
				dto.setRole(rs.getString("role"));
				dto.setSuspension(rs.getTimestamp("suspension"));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	public void insertUser(String userId, String passwd) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql ="insert into users (userId,passwd,role, createdAt) values(?,?,'user',now())";
		
		conn=db.getPpConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, passwd);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
}
