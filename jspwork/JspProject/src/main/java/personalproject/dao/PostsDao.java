package personalproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Vector;

import db.connect.MysqlConnect;
import personalproject.dto.CommentsDto;
import personalproject.dto.PostsDto;

public class PostsDao {
	MysqlConnect db=new MysqlConnect();

	public List<PostsDto> getAllDatas(String search, int limit, int offset) {
		List<PostsDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		if (search == null || search.isEmpty()) {
			sql = "SELECT * FROM posts ORDER BY postId LIMIT ? OFFSET ?";
		} else {
			sql = "SELECT * FROM posts WHERE userId LIKE ? ORDER BY postId LIMIT ? OFFSET ?";
		}

		conn = db.getNaverConnection();
		try {
			pstmt = conn.prepareStatement(sql);

			if (search == null || search.isEmpty()) {
				pstmt.setInt(1, limit);
				pstmt.setInt(2, offset);
			} else {
				pstmt.setString(1, "%" + search + "%");
				pstmt.setInt(2, limit);
				pstmt.setInt(3, offset);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				PostsDto dto = new PostsDto();
				dto.setPostId(rs.getInt("postId"));
				dto.setUserId(rs.getString("userId"));
				dto.setCategory(rs.getString("category"));
				dto.setCreatedAt(rs.getTimestamp("createdAt"));
				dto.setUpdatedAt(rs.getTimestamp("updatedAt"));
				dto.setContents(rs.getString("contents"));
				dto.setTitle(rs.getString("title"));
				dto.setViewCnt(rs.getInt("viewCnt"));
				dto.setLikeCnt(rs.getInt("likeCnt"));
				dto.setSanctioned(rs.getBoolean("sanctioned"));
				dto.setDeleted(rs.getBoolean("isDeleted"));
				dto.setNotice(rs.getBoolean("isNotice"));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}
	
	public List<PostsDto> searchPosts(String keyword, String searchType, int limit, int offset) {
	    List<PostsDto> list = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = "";

	    if (keyword == null || keyword.isEmpty()) {
	        sql = "SELECT * FROM posts ORDER BY postId DESC LIMIT ? OFFSET ?";
	    } else {
	        if ("title".equals(searchType)) {
	            sql = "SELECT * FROM posts WHERE title LIKE ? ORDER BY postId DESC LIMIT ? OFFSET ?";
	        } else if ("userId".equals(searchType)) {
	            sql = "SELECT * FROM posts WHERE userId LIKE ? ORDER BY postId DESC LIMIT ? OFFSET ?";
	        } else {
	            return list; // 잘못된 searchType이면 빈 리스트 반환
	        }
	    }

	    conn = db.getNaverConnection();
	    try {
	        pstmt = conn.prepareStatement(sql);

	        if (keyword == null || keyword.isEmpty()) {
	            pstmt.setInt(1, limit);
	            pstmt.setInt(2, offset);
	        } else {
	            pstmt.setString(1, "%" + keyword + "%");
	            pstmt.setInt(2, limit);
	            pstmt.setInt(3, offset);
	        }

	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            PostsDto dto = new PostsDto();
	            dto.setPostId(rs.getInt("postId"));
	            dto.setUserId(rs.getString("userId"));
	            dto.setCategory(rs.getString("category"));
	            dto.setCreatedAt(rs.getTimestamp("createdAt"));
	            dto.setUpdatedAt(rs.getTimestamp("updatedAt"));
	            dto.setContents(rs.getString("contents"));
	            dto.setTitle(rs.getString("title"));
	            dto.setViewCnt(rs.getInt("viewCnt"));
	            dto.setLikeCnt(rs.getInt("likeCnt"));
	            dto.setSanctioned(rs.getBoolean("sanctioned"));
	            dto.setDeleted(rs.getBoolean("isDeleted"));
	            dto.setNotice(rs.getBoolean("isNotice"));
	            list.add(dto);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(rs, pstmt, conn);
	    }
	    return list;
	}


	public PostsDto getPost(int postId) {
		PostsDto dto = new PostsDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		sql = "SELECT * FROM posts where postId=?";

		conn = db.getNaverConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				dto.setPostId(rs.getInt("postId"));
				dto.setUserId(rs.getString("userId"));
				dto.setCategory(rs.getString("category"));
				dto.setCreatedAt(rs.getTimestamp("createdAt"));
				dto.setUpdatedAt(rs.getTimestamp("updatedAt"));
				dto.setContents(rs.getString("contents"));
				dto.setTitle(rs.getString("title"));
				dto.setViewCnt(rs.getInt("viewCnt"));
				dto.setLikeCnt(rs.getInt("likeCnt"));
				dto.setSanctioned(rs.getBoolean("sanctioned"));
				dto.setDeleted(rs.getBoolean("isDeleted"));
				dto.setNotice(rs.getBoolean("isNotice"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

		return dto;
	}

	public int getTotalPostsCount(String search) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "";

		if (search == null || search.isEmpty()) {
			sql = "SELECT COUNT(*) FROM posts";
		} else {
			sql = "SELECT COUNT(*) FROM posts WHERE userId LIKE ?";
		}

		conn = db.getNaverConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if (search != null && !search.isEmpty()) {
				pstmt.setString(1, "%" + search + "%");
			}
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return count;
	}
	public int getSearchPostCount(String keyword, String searchType) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int count = 0;
	    String sql = "";

	    if (keyword == null || keyword.isEmpty()) {
	        sql = "SELECT COUNT(*) FROM posts";
	    } else {
	        if ("title".equals(searchType)) {
	            sql = "SELECT COUNT(*) FROM posts WHERE title LIKE ?";
	        } else if ("userId".equals(searchType)) {
	            sql = "SELECT COUNT(*) FROM posts WHERE userId LIKE ?";
	        } else {
	            return count; // 잘못된 searchType이면 0 반환
	        }
	    }

	    conn = db.getNaverConnection();
	    try {
	        pstmt = conn.prepareStatement(sql);
	        if (keyword != null && !keyword.isEmpty()) {
	            pstmt.setString(1, "%" + keyword + "%");
	        }
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(rs, pstmt, conn);
	    }
	    return count;
	}

	public boolean insertPost(PostsDto dto) {
		if (dto.getTitle().contains(";") || dto.getContents().contains(";")) {
	        return false; // 세미콜론 포함된 경우 등록 차단
	    }
		Connection conn =null;
		PreparedStatement pstmt = null;
		String sql = """
				insert into posts(userId, title, category, contents)
				values (?,?,?,?)
				""";
		conn=db.getNaverConnection();

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getCategory());
			pstmt.setString(4, dto.getContents());
			

			int rows = pstmt.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	public void viewPost(int postId) {
		PostsDto dto = new PostsDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		sql = "UPDATE posts SET viewCnt = viewCnt + 1 WHERE postId = ?";
		
		try {
	        // DB 연결
	        conn = db.getNaverConnection();
	        
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, postId);
	        pstmt.executeUpdate();  // 조회수 증가

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(rs, pstmt, conn);  // DB 연결 종료
	    }
	}
	
	public void likeUp(int postId) {
		PostsDto dto = new PostsDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		sql = "UPDATE posts SET likeCnt = likeCnt + 1 WHERE postId = ?";
		
		try {
	        conn = db.getNaverConnection();
	        
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, postId);
	        pstmt.executeUpdate(); 

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(pstmt, conn); 
	    }
	}
}
