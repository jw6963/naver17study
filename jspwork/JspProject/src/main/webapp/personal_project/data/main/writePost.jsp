<%@page import="personalproject.dto.PostsDto"%>
<%@page import="personalproject.dao.PostsDao"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>

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
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String content = request.getParameter("content");
        
        if (title.contains(";") || content.contains(";")) {
            out.println("Error: 세미콜론(;)은 사용할 수 없습니다.");
            return;
        }
        
        if (content == null) {
            response.getWriter().write("content 값이 null입니다.");
            return;
        }

        // DB에 저장
        PostsDao dao = new PostsDao();
        PostsDto dto = new PostsDto();
        dto.setUserId(userId);
        dto.setCategory(category);
        dto.setTitle(title);
        dto.setContents(content);

        boolean success = dao.insertPost(dto);

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
