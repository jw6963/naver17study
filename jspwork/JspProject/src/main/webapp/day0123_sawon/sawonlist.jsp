<%@page import="sawon.data.SawonDto"%>
<%@page import="java.util.List"%>
<%@page import="sawon.data.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
      .tab th{
      background-color: gray;
      text-align: center;
      }
      .tab .photo{
      	width:40px;
      	height: 40px;
      	border: 1px solid black;
      	margin-right: 10px;
      }
      .tab {
      	text-align: center;
      }
   </style>
   <script type="text/javascript">
   	// 검색 버튼 이벤트
   	$(function(){
   		$("#btnsearch").click(function() {
   	   		// 검색 단어 가져오기
   			let search=$("#search").val();
   	   		// 목록 파일로 이동-검색단어는 get 방식으로 전달
   			location.href="./sawonlist.jsp?search="+search;
   		})
   	})
   	
   </script>
</head>
<%
	// 검색단어 search 읽기
	// sawonlist.jsp를 직접 실행 시에는 라는 값이 안 넘어온다.
	// 이 경우에는 null 값이 search 변수 값은 null이 된다.
	String search=request.getParameter("search");
	
	// dao 생성
	SawonDao dao= new SawonDao();

	// 전체 데이터 가져오기
	List<SawonDto> list = dao.getAllDatas(search);
%>
<body>
<div style="margin: 30px">
	<table class="tab table table-bordered" style="width: 450px;">
		<caption align="top">
			<b>[사원 목록(<%=list.size() %>명)]</b>
			<button type="button" class="btn btn-sm btn-success" style="float:right;" onclick="location.href='./sawonform.jsp'">사원 등록</button>
		</caption>
		<tr>
			<td colspan="4" >
				<div class="input-group">
					&nbsp;&nbsp;
					<div style="border:1px groove gray;align-content: center; padding:5px;">
						<b>이름 검색</b>&nbsp;&nbsp;
						<i class="bi bi-search"></i>
					</div>&nbsp;&nbsp;
					<input type="text" id="search" placeholder="검색할 이름 입력" class="form-control">
					<button type="button" class="btn btn-success" id="btnsearch">검색</button>
				</div>
			</td>
		</tr>
		<tr>
			<th width="50">번호</th>
			<th width="150">사원명</th>
			<th width="150">입사일</th>
			<th>상세보기</th>
		</tr>
		<%
		if(list.size()==0){ %>
			<tr height="50">
				<td colspan="4" align="center">
					<b>등록된 사원이 없습니다</b> 
				</td>
			</tr>
		<%} else {
			int no=0;
			for(SawonDto dto:list){%>
				<tr>
					<td><%=dto.getNum() %></td>
					<td align="left">
					<img src="<%=dto.getSphoto()%>" class="photo">
					<%=dto.getSname() %>
					</td>
					<td><%=dto.getIpsaday() %></td>
					<td>
					<button type="button" class="btn btn-sm btn-info" onclick="location.href='./sawondetail.jsp?num=<%=dto.getNum()%>'">Details</button>
					</td>
				</tr>
			<%}	
		}%>
	</table>
</div>
</body>
</html>