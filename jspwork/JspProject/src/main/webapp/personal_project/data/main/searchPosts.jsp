<%@page import="personalproject.dto.PostsDto"%>
<%@page import="personalproject.dao.PostsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, data.db.DBConnect, data.posts.PostsDto, data.posts.PostsDao, java.util.List" %>
<%
    request.setCharacterEncoding("UTF-8");

    // 검색 조건 가져오기
    String type = request.getParameter("type"); // "title" 또는 "writer"
    String keyword = request.getParameter("keyword");

    // 검색어가 없으면 빈 결과 반환
    if (keyword == null || keyword.trim().isEmpty()) {
        out.print("<p>검색 결과가 없습니다.</p>");
        return;
    }

    // 게시글 DAO 가져오기
    PostsDao dao = new PostsDao();
    List<PostsDto> searchResults = dao.searchPosts(keyword, type, limit, offset);

    if (searchResults.isEmpty()) {
%>
        <p>검색 결과가 없습니다.</p>
<%
    } else {
%>
        <table class="table">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>추천</th>
                </tr>
            </thead>
            <tbody>
<%
            for (PostsDto post : searchResults) {
%>
                <tr>
                    <td><%= post.getPostId() %></td>
                    <td><a href="details.jsp?postId=<%= post.getPostId() %>"><%= post.getTitle() %></a></td>
                    <td><%= post.getUserId() %></td>
                    <td><%= post.getCreatedAt() %></td>
                    <td><%= post.getLikeCnt() %></td>
                </tr>
<%
            }
%>
            </tbody>
        </table>
<%
    }
%>
