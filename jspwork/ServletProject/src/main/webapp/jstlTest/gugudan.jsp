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
         text-align: center;
      }
   </style>
</head>
<%
	int []nums={1,2,3,4,5,6,7,8,9};
%>
<c:set var="nums" value="<%=nums %>"></c:set>
<body>
<h3 class="alert alert-info">구구단을 외자 구구단을 외자</h3>
<div class="container">
	<table class="table table-bordered">
	<thead>
	<c:forEach var="dan" items="${nums }" varStatus="i" begin="1" end="8">
		<th style="background-color:skyblue; color:white">${dan}단</th>
	</c:forEach>
	</thead>
	<tbody>
	<c:forEach var="num" items="${nums }" varStatus="i" begin="0" end="8">
		<tr>
		<c:forEach var="dan" items="${nums }" varStatus="i" begin="1" end="8">
			<td>${dan } x ${num } = ${dan*num }</td>
		</c:forEach>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>

</body>
</html>