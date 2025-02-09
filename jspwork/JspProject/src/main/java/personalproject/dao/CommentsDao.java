package personalproject.dao;

import java.sql.*;
import java.util.*;
import personalproject.dto.CommentsDto;
import db.connect.MysqlConnect;

public class CommentsDao {
    MysqlConnect db = new MysqlConnect();

    // 특정 게시글의 댓글 목록을 가져오는 메소드
    public List<CommentsDto> getCommentsByPostId(int postId) {
        List<CommentsDto> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM comment WHERE postId = ? ORDER BY createdAt";

        conn = db.getNaverConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, postId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CommentsDto dto = new CommentsDto();
                dto.setCmtId(rs.getLong("cmtId"));
                dto.setPostId(rs.getInt("postId"));
                dto.setWriter(rs.getString("writer"));
                dto.setContent(rs.getString("content"));
                dto.setCreatedAt(rs.getTimestamp("createdAt"));
                dto.setLikeCnt(rs.getInt("likeCnt"));
                dto.setDislikeCnt(rs.getInt("dislikeCnt"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return list;
    }


    // 댓글 추가하는 메소드
    public boolean insertComment(CommentsDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = """
                INSERT INTO comment (postId, writer, content)
                VALUES (?, ?, ?)
                """;

        conn = db.getNaverConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getPostId());
            pstmt.setString(2, dto.getWriter());
            pstmt.setString(3, dto.getContent());

            int rows = pstmt.executeUpdate();
            return rows > 0; // 성공적으로 삽입되었으면 true 반환
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // 실패한 경우 false 반환
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    // 댓글 삭제하는 메소드 (물리적 삭제 대신 논리적 삭제)
    public boolean deleteComment(int commentId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "UPDATE comment SET isDeleted = ? WHERE commentId = ?";

        conn = db.getNaverConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1, true);  // 논리적 삭제 (isDeleted를 true로 설정)
            pstmt.setInt(2, commentId);

            int rows = pstmt.executeUpdate();
            return rows > 0; // 삭제 성공 시 true 반환
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // 삭제 실패 시 false 반환
        } finally {
            db.dbClose(pstmt, conn);
        }
    }
    
    public void likeUp(int cmtId) {
		CommentsDto dto = new CommentsDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		sql = "UPDATE comment SET likeCnt = likeCnt + 1 WHERE cmtId = ?";
		
		try {
	        conn = db.getNaverConnection();
	        
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, cmtId);
	        pstmt.executeUpdate(); 

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(pstmt, conn); 
	    }
	}
    
    public void dislikeUp(int cmtId) {
		CommentsDto dto = new CommentsDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		sql = "UPDATE comment SET dislikeCnt = dislikeCnt + 1 WHERE cmtId = ?";
		
		try {
	        conn = db.getNaverConnection();
	        
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, cmtId);
	        pstmt.executeUpdate(); 

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(pstmt, conn); 
	    }
	}
}
