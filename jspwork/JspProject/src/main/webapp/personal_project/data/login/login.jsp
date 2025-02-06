<%@page import="personalproject.dto.UsersDto"%>
<%@page import="personalproject.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    String userId = request.getParameter("userId");
    String passwd = request.getParameter("passwd");
    UsersDao dao = new UsersDao();
    UsersDto dto = dao.getUser(userId);
    boolean loginSuccess = dao.Login(userId,passwd);
    if (loginSuccess) {
        out.print("true");  // 로그인 성공
        session.setAttribute("userId", dto.getUserId());
        session.setAttribute("role", dto.getRole());
    } else {
        out.print("false"); // 로그인 실패
    }
%>