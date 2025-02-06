<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="personalproject.dto.UsersDto"%>
<%@page import="personalproject.dao.UsersDao"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%
    String userId = request.getParameter("userId");
	String result = "error"; // 기본적으로 에러 처리
	
	if (userId != null && !userId.trim().isEmpty()) {
        try {
            UsersDao dao = new UsersDao();
            UsersDto dto = dao.getUser(userId);

            if (dto == null) {
                result = "available"; // 아이디 사용 가능
            } else {
                result = "unavailable"; // 아이디 중복됨
            }
        } catch (Exception e) {
            result = "error"; // 예외 발생 시 에러 반환
        }
    } else {
        result = "invalid"; // 입력값이 없는 경우
    }

    out.print(result);
%>