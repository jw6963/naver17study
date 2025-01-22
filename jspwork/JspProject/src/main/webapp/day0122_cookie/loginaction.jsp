<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	String amho=request.getParameter("amho");
// 암호가 bitcamp가 맞으면 쿠키 생성(이름은 loginok)
if(amho.equals("bitcamp")){
	Cookie cookie=new Cookie("loginok",amho); // name은 loginok, value는 아무거나 저장(다른 값이 와도 되긴 함)
	cookie.setPath("/");
	cookie.setMaxAge(10); // 쿠키 유지 시간, 초단위
	response.addCookie(cookie); // 브라우저에 쿠키 추가
	response.sendRedirect("./cookiemain.jsp"); // 메인 페이지로 이동
} else { %>
<script>
		alert("암호가 맞지 않습니다.");
		history.back();
	</script>
<%}
%>