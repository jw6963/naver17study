<%@page import="personalproject.dto.CommentsDto"%>
<%@page import="personalproject.dao.CommentsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    try {
        // 세션에서 사용자 정보 가져오기
        String userId = (String) session.getAttribute("userId");

        // 로그인 상태 확인
        if (userId == null) {
            response.getWriter().write("로그인이 필요합니다.");
            return;
        }

        // 파라미터 받아오기
        int postId = Integer.parseInt(request.getParameter("postId"));
        String content = request.getParameter("content");
        
        if (content.contains(";")) {
            out.println("Error: 세미콜론(;)은 사용할 수 없습니다.");
            return;
        }
        
        if (content == null) {
            response.getWriter().write("content 값이 null입니다.");
            return;
        }

        // DB에 저장
        CommentsDao dao = new CommentsDao();
        CommentsDto dto = new CommentsDto();
        dto.setPostId(postId);
        dto.setWriter(userId);
        dto.setContent(content);
        

        boolean success = dao.insertComment(dto);

        if (success) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("fail");
        }
    } catch (Exception e) {
        e.printStackTrace(); // 콘솔에서 에러 로그 확인
        response.getWriter().write("서버 오류 발생: " + e.getMessage());
    }
%>