<%@page import="personalproject.dto.UsersDto"%>
<%@page import="personalproject.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
String userId = request.getParameter("userId");
String passwd = request.getParameter("passwd");
UsersDao dao = new UsersDao();
dao.insertUser(userId,passwd);
%>