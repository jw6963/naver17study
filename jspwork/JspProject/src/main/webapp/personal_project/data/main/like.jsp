<%@page import="personalproject.dao.PostsDao"%>
<%@page import="personalproject.dao.CommentsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String type = request.getParameter("type");
	if (type.equals("post")) {
		int postId = Integer.parseInt(request.getParameter("postId"));
		PostsDao dao = new PostsDao();
		dao.likeUp(postId);
	} else if (type.equals("cmt")) {
		int cmtId = Integer.parseInt(request.getParameter("cmtId"));
		CommentsDao dao = new CommentsDao();
		dao.likeUp(cmtId);
	}
	
	
%>
