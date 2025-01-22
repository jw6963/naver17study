<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String chksave=request.getParameter("chksave");
	String myid=request.getParameter("myid");
	String mypass=request.getParameter("mypass");
	
	if(myid.equals("angel") && mypass.equals("1234")){
		if(chksave!=null){
			session.setAttribute("myid", myid);
			session.setAttribute("chksave", "yes");
		} else {
			// 이전에 저장된 세션 삭제
			session.removeAttribute("chksave");
			session.removeAttribute("myid");
		}
		session.setAttribute("loginok", "yes");
		
		// 유지 시간 지정(생략 시 기본 30분간 유지)
		session.setMaxInactiveInterval(60*60); // 한시간 유지(초 단위)
		
		response.sendRedirect("./sessionmain.jsp"); // 메인 페이지로 이동
	} else {%>
	<script>
		alert("아이디또는 비밀번호가 틀렸습니다.")
		history.back();
	</script>
<%
	}
%>