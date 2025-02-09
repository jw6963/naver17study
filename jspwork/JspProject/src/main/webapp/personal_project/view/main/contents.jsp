<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="personalproject.dto.PostsDto"%>
<%@page import="personalproject.dao.PostsDao"%>

<%
int pageSize = 10; // 한 페이지에 보여줄 게시글 수
int pg = 1; // 기본 페이지 번호
if (request.getParameter("page") != null) {
	pg = Integer.parseInt(request.getParameter("page"));
}

int offset = (pg - 1) * pageSize; // OFFSET 계산

PostsDao dao = new PostsDao();
List<PostsDto> postList = dao.getAllDatas(null, pageSize, offset);
int totalPosts = dao.getTotalPostsCount(null);
int totalPages = (int) Math.ceil((double) totalPosts / pageSize);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main-contents</title>
</head>
<style>
.post-table {
	width: 65%;
	table-layout: fixed;
	border-collapse: collapse;
	margin: auto;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	border-collapse: collapse;
}

.post-table th, .post-table td {
	padding: 12px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

.post-table th {
	background-color: #333;
	color: white;
}

.post-table tbody tr:hover {
	background-color: #f5f5f5;
	cursor: pointer;
}

.post-table td.title-cell {
	text-align: left;
	padding-left: 15px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 250px;
}

.post-table td.no-cell {
	width: 50px;
}

.post-table a {
	text-decoration: none;
	color: #333;
	font-weight: bold;
}

.post-table a:hover {
	text-decoration: underline;
}

.pagination {
    display: flex;
    margin-top:20px;
    gap: 5px;
}

.pagination a {
    text-decoration: none;
    color: #333;
    padding: 8px 12px;
    margin: 0 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    transition: 0.3s;
}

.pagination a.active {
    background-color: #007bff;
    color: white;
    border-color: #007bff;
}

.pagination a:hover {
    background-color: #ddd;
}


.cnt {
	font-size: 14px;
	color: gray;
}
</style>
<body>
	<table class="post-table">
		<thead>
			<tr>
				<th style="width: 55px;">번호</th>

				<th>제목</th>
				<th style="width: 150px;">작성자</th>
				<th>작성일</th>
				<th style="width: 70px;">조회수</th>
				<th style="width: 70px;">추천수</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (PostsDto post : postList) {
			%>
			<tr class="clickable-row"
				data-url="details.jsp?postId=<%=post.getPostId()%>" data-post-id="<%=post.getPostId()%>">
				<td class="no-cell"><%=post.getPostId()%></td>

				<td class="title-cell"><%=post.getTitle()%></td>
				<td><%=post.getUserId()%></td>
				<%
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String formattedDate = sdf.format(post.getCreatedAt());
				%>
				<td><%=formattedDate%></td>
				<td class="cnt"><%=post.getViewCnt()%></td>
				<td class="cnt"><%=post.getLikeCnt()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<!-- 페이지네이션 -->
	<div class="pagination">
		<%
		if (pg > 1) {
		%>
		<a href="?page=<%=pg - 1%>">이전</a>
		<%
		}
		%>

		<%
		for (int i = 1; i <= totalPages; i++) {
		%>
		<a href="?page=<%=i%>" class="<%=(i == pg) ? "active" : ""%>"><%=i%></a>
		<%
		}
		%>

		<%
		if (pg < totalPages) {
		%>
		<a href="?page=<%=pg + 1%>">다음</a>
		<%
		}
		%>
	</div>
</body>
</html>
<script>
	$(document).ready(function() {
		$(".clickable-row").click(function() {
			var url = $(this).data("url");
			var postId = $(this).data("post-id");
			$.ajax({
	            url: "../../data/main/view.jsp",  // 해당 URL로 요청
	            type: "GET",
	            data: { "postId": postId },  // postId를 전달
	            success: function(response) {
	                // 성공적으로 처리되면 페이지 이동
	                window.location.href = url;
	            },
	            error: function(xhr, status, error) {
	                console.log("에러 발생: " + error);
	            }
	        });
		});
	});
</script>