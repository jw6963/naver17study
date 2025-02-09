<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    // 세션에서 userId를 가져와 로그인 상태 확인
    String userId = (String) session.getAttribute("userId");
    
    if (userId == null) {
        // 로그인되지 않았으면 로그인 페이지로 리디렉션
        response.sendRedirect("../login/login.html");
        return;  // 페이지 렌더링을 중단
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
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
<style>
body * {
	font-family: 'Jua';
}

.pagination-wrapper {
	margin-top: 20px;
	width: 100%;
}

.pagination-container {
	margin-top: 30px;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	align-items: center;
}

#btnWrite {
	padding: 8px 12px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />

	<main>


		<div class="container-lg">
			<aside class="sidebar">
				<!-- 광고 배너 or 기타 요소 -->
				<div style="margin-bottom: 30px;"></div>
				<div class="banner">
					광고 문의 <i class="bi bi-caret-right-fill"></i> 010-1234-5678<i
						class="bi bi-caret-left-fill"></i>
				</div>
			</aside>
			<div class="container-md">
				<div style="margin-bottom: 50px;"></div>

				<div>
					<div class="pagination-wrapper">
						<div class="pagination-container">
							<jsp:include page="contents.jsp" />
						</div>
					</div>
					<div class="search-bar">
						<select id="searchType" style="height: 42px; border: 1px solid #ccc;">
							<option value="title">제목</option>
							<option value="writer">작성자</option>
						</select> <input type="text" id="searchBox" placeholder="검색어 입력">
						<button id="searchBtn">검색</button>
					</div>

				</div>

			</div>
		</div>
		<div></div>
	</main>

	<script>
        $(document).ready(function() {
            $("#menuBtn").click(function() {
                $("#gnb").toggleClass("open");
            });

            $("#profileToggle").click(function() {
                $("#profileMenu").toggle();
            });
        });
    </script>
</body>
</html>
<script type="text/javascript">
$(document).ready(function() {
    $("#searchBtn").click(function() {
        var searchType = $("#searchType").val();  // 제목 or 작성자 선택값
        var keyword = $("#searchBox").val().trim();

        if (keyword === "") {
            alert("검색어를 입력해주세요.");
            return;
        }

        $.ajax({
            type: "GET",
            url: "../../data/main/searchPost.jsp",
            data: {
                type: searchType,
                keyword: keyword
            },
            success: function(res) {
                $(".pagination-container").html(res);  // 검색 결과 갱신
            },
            error: function() {
                alert("검색에 실패했습니다.");
            }
        });
    });
});

</script>