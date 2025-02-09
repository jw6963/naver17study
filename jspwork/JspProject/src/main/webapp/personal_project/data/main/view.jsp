<%@page import="personalproject.dao.PostsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int postId = Integer.parseInt(request.getParameter("postId"));
	PostsDao dao = new PostsDao();
	
	dao.viewPost(postId);
%>
