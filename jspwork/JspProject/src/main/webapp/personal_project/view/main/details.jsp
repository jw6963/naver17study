<%@page import="java.text.SimpleDateFormat"%>
<%@page import="personalproject.dto.PostsDto"%>
<%@page import="personalproject.dao.PostsDao"%>
<%@page import="personalproject.dao.CommentsDao"%>
<%@page import="personalproject.dto.CommentsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>

<%
	//세션에서 userId를 가져와 로그인 상태 확인
	String userId = (String) session.getAttribute("userId");
	
	if (userId == null) {
	    // 로그인되지 않았으면 로그인 페이지로 리디렉션
	    response.sendRedirect("../login/login.html");
	    return;  // 페이지 렌더링을 중단
	}
    // 게시글 번호 받아오기
    int postId = Integer.parseInt(request.getParameter("postId"));
    
    // 게시글 정보 가져오기
    PostsDao postsDao = new PostsDao();
    PostsDto post = postsDao.getPost(postId);

    // 댓글 목록 가져오기
    CommentsDao commentDao = new CommentsDao();
    List<CommentsDto> comments = commentDao.getCommentsByPostId(postId);
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 조회</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../css/post/post.css">
    <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
</head>
<style>
/* 댓글 리스트 스타일 */
.comments-section {
    width: 80%;
    margin: 20px auto;
    border-top: 1px solid #ddd;
    padding-top: 20px;
}

.comment {
    padding: 15px;
    border-bottom: 1px solid #f0f0f0;
    display: flex;
    flex-direction: column;
}

.comment:last-child {
    border-bottom: none;
}

.comment-header {
    display: flex;
    justify-content: space-between;
    font-size: 14px;
    color: #555;
    margin-bottom: 5px;
}

.comment-header .user {
    font-weight: bold;
}

.comment-header .date {
    font-style: italic;
}

.comment-content {
    margin-top: 5px;
    font-size: 16px;
    line-height: 1.5;
}

.comment-actions {
    margin-top: 10px;
    display: flex;
    gap: 10px;
}

.comment-actions button {
    padding: 5px 10px;
    font-size: 14px;
    cursor: pointer;
    border: none;
    border-radius: 5px;
    transition: background-color 0.3s;
}

.comment-actions button:hover {
    background-color: #f0f0f0;
}

/* 댓글 작성 폼 */
.comment-form {
    margin: 20px auto;
    width: 80%;
    display: flex;
    flex-direction: column;
}

.comment-form textarea {
    resize: none;
    height: 100px;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;
}

.comment-form button {
    padding: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.comment-form button:hover {
    background-color: #0056b3;
}
.comment-actions {
    display: flex;
    gap: 10px;
    margin-top: 10px;
    font-size: 14px;
}

.comment-actions button {
    background: none;
    border: none;
    cursor: pointer;
    color: #333;
    font-size: 18px;
    transition: color 0.3s;
}

.comment-actions button:hover {
    color: #007bff;
}

/* 원문에서의 아이콘 버튼 */
.post-actions {
    display: flex;
    gap: 10px;
    font-size: 18px;
    margin-top: 10px;
}

.post-actions button {
    background: none;
    border: none;
    cursor: pointer;
    color: #333;
    font-size: 18px;
    transition: color 0.3s;
}

.post-actions button:hover {
    color: #007bff;
}
.dt-cont{
	min-height: 300px;
	background-color: #fff;
	border-radius: 20px;
	padding: 10px;
	border: 1px solid #ccc;
}
.dt-titleddddd {
	background-color: #fff;
	border-radius: 5px;
	padding: 10px;
	border: 1px solid #ccc;
}
</style>
<body>
    <jsp:include page="header.jsp"/>
	<div class="container" style="background-color:snow; margin-top:10px;padding:20px; border-radius: 30px;">
		<section class="post-details">
		<div class="dt-title" style="display:flex; border: 1px solid lgihtgray; padding:5px; margin-bottom:5px;"><span style="font-size:20px; font-weight: bold; overflow: hidden;text-overflow: ellipsis;
	white-space: nowrap;"><%= post.getTitle() %></span>
        </div>
        <hr>
        <div style="margin-bottom:15px; display: none;">
        	<span style="">카테고리: <%= post.getCategory() %></span>
        </div>
        <div style="margin-bottom:15px;text-align: right;">
        	<span>작성자 : <%= post.getUserId()%></span>
        </div>
        <p class="dt-cont"><%= post.getContents() %></p>
        
        <div class="comment-actions">
    <button id="likeBtnPost">추천</button>
    
    <button>신고</button>
</div>
        
        <hr>

        <!-- 댓글 목록 -->
        <h3>댓글</h3>
        
        <!-- 댓글 작성 -->
        <div class="comment-form">
            <textarea id="commentContent" placeholder="댓글을 작성하세요"></textarea>
            <button id="submitCommentBtn">댓글 작성</button>
        </div>
    </section>
    <div class="comments-section">
    <% for (CommentsDto comment : comments) { %>
    <div class="comment">
        <div class="comment-header">
            <span class="user"><p><%= comment.getWriter() %></p></span>
            <%
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String formattedDate = sdf.format(comment.getCreatedAt());
				%>
            <span class="date"><%=formattedDate %><br>&nbsp;&nbsp;추천 :&nbsp;<%= comment.getLikeCnt() %>
            &nbsp;비추천 :&nbsp;<%= comment.getDislikeCnt() %></span>
            
        </div>
        <div class="comment-content">
            <%= comment.getContent() %>
        </div>
        <div class="comment-actions">
    		<button class="likeCommentBtn" data-comment-id="<%= comment.getCmtId() %>">추천</button>
    		<button class="dislikeCommentBtn" data-comment-id="<%= comment.getCmtId() %>">비추천</button>
    		<button class="reportCommentBtn" data-comment-id="<%= comment.getCmtId() %>">신고</button>
		</div>

    </div>
    <% } %>
    <!-- 추가적인 댓글들 -->
</div>
	</div>
    

    <script>
        // 게시글 추천 버튼 클릭
        $("#likeBtnPost").click(function() {
            $.ajax({
                type: "POST",
                url: "../../data/main/like.jsp",
                data: { "type":"post",postId: <%= postId %> },
                success: function(response) {
                    alert("게시글이 추천되었습니다.");
                }
            });
        });

        // 게시글 비추천 버튼 클릭
        /*
        $("#dislikeBtn").click(function() {
            $.ajax({
                type: "POST",
                url: "../../data/main/dislikePost.jsp",
                data: { "postId": <%= postId %> },
                success: function(response) {
                    alert("게시글이 비추천되었습니다.");
                }
            });
        });
        */

        // 신고 버튼 클릭
        $("#reportBtn").click(function() {
            $.ajax({
                type: "POST",
                url: "../../data/main/reportPost.jsp",
                data: { postId: <%= postId %> },
                success: function(response) {
                    alert("게시글이 신고되었습니다.");
                }
            });
        });

        // 댓글 작성 버튼 클릭
        $("#submitCommentBtn").click(function() {
            var commentContent = $("#commentContent").val();
            if (commentContent.trim() === "") {
                alert("댓글을 입력해주세요.");
                return;
            }

            $.ajax({
                type: "POST",
                url: "../../data/main/writeComment.jsp",
                data: { postId: <%= postId %>, content: commentContent },
                success: function(response) {
                    alert("댓글이 작성되었습니다.");
                    location.reload(); // 새로고침하여 댓글 추가된 부분 표시
                }
            });
        });

        // 댓글 추천 버튼 클릭
        $(".likeCommentBtn").click(function() {
            var commentId = $(this).data("comment-id");

            $.ajax({
                type: "POST",
                url: "../../data/main/like.jsp",
                data: { "type": "cmt","cmtId": commentId },
                success: function(response) {
                    alert("댓글이 추천되었습니다.");
                    window.location.reload();
                }
            });
        });

        // 댓글 비추천 버튼 클릭
        $(".dislikeCommentBtn").click(function() {
            var commentId = $(this).data("comment-id");

            $.ajax({
                type: "POST",
                url: "../../data/main/dislike.jsp",
                data: { "cmtId": commentId },
                success: function(response) {
                    alert("댓글이 비추천되었습니다.");
                    window.location.reload();
                }
            });
        });
    </script>
</body>
</html>
