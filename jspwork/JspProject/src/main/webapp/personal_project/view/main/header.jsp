<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%String userId = (String) session.getAttribute("userId"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="../../css/main/main.css">
</head>
<body>
	<header>
		<div class="header-left">
			<i class="bi bi-menu-button-wide-fill burger-menu" id="menuBtn"></i>
		</div>
		<div class="header-center">
			<h1 class="logo">Bitcamp Board</h1>
		</div>
		<div class="header-right">
			<div class="profile" id="profileToggle">
				<i class="bi bi-person-circle prof-icon"></i> <span id="userId"
					class="nickname"><%=userId %></span>
				<div class="profile-menu" id="profileMenu">
					<span>마이페이지</span> <span id="logoutBtn">로그아웃</span>
				</div>
			</div>
		</div>
	</header>

	<nav id="gnb" class="gnb">
		<ul>
			<li><a href="#">전체글</a></li>
			<li><a href="#">내가 작성한 글</a></li>
			<li><a href="#">즐겨찾기</a></li>
			<li id="writePost"><a href="#">게시글 작성</a>
		</ul>
	</nav>
</body>
</html>
<script type="text/javascript">
$(document).ready(function() {
	$("#writePost").click(function(){
		window.location.href="posting.jsp"
	})
    // GNB 메뉴 토글
    $('.burger-menu').click(function() {
        $('#gnb').toggleClass('active');
    });

    // 프로필 메뉴 토글
    $('.profile').click(function(e) {
    	e.stopPropagation();
        $('.profile-menu').addClass('show');
    });

    $("#logoutBtn").click(function(){
    	$.ajax({
    		type:"get",
    		url:"../../data/login/logout.jsp",
    		success:function(res){
    			alert("로그아웃 되었습니다.");
    			window.location.href = "../../view/login/login.html";
    		}
    	})
    });
    $(document).click(function(e) {
        if (!$(e.target).closest('.burger-menu').length && !$(e.target).closest('.profile').length) {
            $('#gnb').removeClass('active');
            if (!$(e.target).closest('.profile').length) {
                $('.profile-menu').removeClass('show');
            }
        }
    });
});
$(".logo").click(function(){
	window.location.href="mainPage.jsp";
})
</script>