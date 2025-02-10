<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
   <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
   <style>
      body * {
         font-family: 'Jua';
      }
   </style>
</head>
<body>
<div style="margin:20px;">
	<!-- 자바코드로 날짜를 얻어서 JSTL의 today 변수에 직접 저장하려면 -->
	<c:set var="today" value="<%=new Date() %>"/>
	<h5>${today }</h5>
	<h5>
		<fmt:formatDate value="${today }" pattern="yyyy-MM-dd"/>
	</h5>
	<h5>
		<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm:ss"/>
	</h5>
	<h5>
		<fmt:formatDate value="${today }" pattern="yyyy-MM-dd a hh:mm"/>
	</h5>
	<h5>
		<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm EEE"/>
	</h5>
	<!-- 날짜 포멧 양식을 지정 후 변수 day1에 저장하기 -->
	<fmt:formatDate value="${today }" pattern="yyyy년 MM월 dd일 HH시" var="day1"/>
	
	<h1>${day1 }</h1>
	<hr>
	<c:set var="money" value="456780"></c:set>
	<c:set var="avergage" value="89.244"></c:set>
	<h4>급여:${money }</h4>
	<h4>평균 :${average}</h4>
</div>
</body>
</html>