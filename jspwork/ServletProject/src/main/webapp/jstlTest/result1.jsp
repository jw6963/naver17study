<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 위가 있어야 c태그 및 fmt 태그 사용 가능 -->
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
<h2>TestServletEx1로부터 포워드</h2>
<!-- request영역의 변수는 requestScope로 가져온다. (생략 가능함) -->
<h3>오늘 날짜 : ${requestScope.today}</h3>
<h3>오늘 날짜 : ${today}</h3>
<h3>오늘 날짜 : ${today2}</h3>
<h3>이름 : ${myname }</h3>
<h3>나이 : ${myage }</h3>
<hr>
<!-- jstl로 변수 선언과 연산자 공부하기-->
<c:set var="su1" value="7"/>
<c:set var="su2" value="10"/>
<h5>숫자 1 :${su1 }</h5>
<h5>숫자 2 :${su2 }</h5>
<h5>더하기 :${su1+su2 }</h5>
<h5>빼기 :${su1-su2 }</h5>
<h5>곱하기 :${su1*su2 }</h5>
<h5>나누기1 :${su1/su2 }</h5>
<h5>나누기2 :${su1 div su2 }</h5>
<h5>나머기1 :${su1%su2 }</h5>
<h5>나머기2 :${su1 mod su2 }</h5>

<!-- jstl 에는 증감 연산자가 없다. 그러면 su1에 1을 더해서 출력하려면 -->
<c:set var="su1" value="${su1+1 }"/>
<h6>su1에 1증가: ${su1}</h6>
</body>
</html>