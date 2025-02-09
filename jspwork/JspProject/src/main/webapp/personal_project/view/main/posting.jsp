<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<%
    String role = (String) session.getAttribute("role"); // 역할
 // 세션에서 userId를 가져와 로그인 상태 확인
    String userId = (String) session.getAttribute("userId");
    
    if (userId == null) {
        // 로그인되지 않았으면 로그인 페이지로 리디렉션
        response.sendRedirect("../login/login.html");
        return;  // 페이지 렌더링을 중단
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 작성</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="../../css/post/post.css">
    <style type="text/css">
    #content {
    height:300px;
    }
    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<header>
    <h2>게시글 작성</h2>
</header>
<div class="container" style="background-color:snow; margin-top:20px;padding:20px; border-radius: 30px;">
<section class="write-container">
    <form id="writeForm">
        <!-- 제목 입력 -->
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" required placeholder="제목 입력">
        </div>

        <!-- 카테고리 선택 -->
        <div class="form-group">
            <label for="category">카테고리</label>
            <select id="category" name="category">
                <option value="일반">일반</option>
                <% if ("admin".equals(role)) { %>
                    <option value="공지">공지</option>
                <% } %>
            </select>
        </div>

        <!-- 내용 입력 -->
        <div class="form-group">
            <label for="content">내용</label>
            <textarea id="content" name="content"></textarea>
        </div>

        <!-- 작성 버튼 -->
        <div class="form-group">
            <button type="button" id="submitBtn">등록</button>
        </div>
    </form>
</section>
</div>

<script>

    // 게시글 등록 AJAX 처리
    $("#submitBtn").click(function(e) {
        e.preventDefault(); 
        var title = $("#title").val().trim();
        var category = $("#category").val();
		var content = $("#content").val();
        
        if (title === "" || content === "") {
            alert("제목과 내용을 입력해주세요.");
            return;
        }
        if (content.includes(";") || title.includes(";")) {
            alert("세미콜론(;)은 사용할 수 없습니다."); // sql injection 방지
            return;
        }

        $.ajax({
            type: "POST",
            url: "../../data/main/writePost.jsp",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            data: {
                title: title,
                category: category,
                content: content
            },
            success: function(response) {
                alert("게시글이 등록되었습니다!");
                window.location.href = "mainPage.jsp"; // 메인 페이지로 이동
            },
            error: function() {
                alert("게시글 등록에 실패했습니다.");
            }
        });
    });
</script>

</body>
</html>