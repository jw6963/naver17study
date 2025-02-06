<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
    session.invalidate();  // 세션 무효화
    response.sendRedirect("../../view/login/login.html");  // 로그인 페이지로 리디렉션 // 잘 안됨. main에서 이동하도록 설정
%>