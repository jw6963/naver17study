<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
      	background-color: orange;
      }
      
      .tab .photo{
      	width: 50px;
      	height: 60px;
      	border: 1px solid gray;
      	margin-rigth: 10px;
      }
      .btn{
      	width: 100px;
      }
   </style>
</head>
<body>
<form action="./insertaction.jsp" method="post">
	<div style="margin: 30px;">
		<table class="tab table table-bordered" style="width: 400px;">
			<tr>
				<th width="100">사원명</th>
				<td>
					<input type="text" class="form-control" style="width:150px;" required="required" autofocus="autofocus" name="sname">
				</td>
			</tr>
			<tr>
				<th width="100">사진</th>
				<td class="input-group">
					<img src="" class="photo">
					<select class="form-select selphoto" name="sphoto" style="width: 120px;">
					<%
					for(int i=1;i<=20;i++){
						String s="../image/photo/"+i+".jpg";
						%>
						<option value="<%=s %>"<%=i==17?"selected":"" %>>사진 #<%=i %></option>
					<%}
					%>
					</select>
					<script type="text/javascript">
					// 1. 선택된 옵션의 사진을 초기값으로 지정
					$("img.photo").attr("src",$(".selphoto").val());
					// 2. 사진 변경 시 .photo도 변경
					$(".selphoto").change(function(){
						$("img.photo").attr("src",$(this).val());
					})
					</script>
				</td>
			</tr>
			<tr>
				<th width="100">입사일</th>
				<td>
					<%
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					String initVal=sdf.format(new Date());
					%>
					<input type="date" name="ipsaday" value="<%=initVal %>">
				</td>
			</tr>
			<tr>
				<th width="100">출생년도</th>
				<td>
				<% 
				int curYear = new Date().getYear()+1900;%>
					<input type="number" name="sbirth" max="<%=curYear %>" class="form-control">
				</td>
			</tr>
			<tr>
				<th width="100">혈액형</th>
				<td>
					<%
					String[] blood={"A","B","O","AB"};
					for(String b:blood){%>
						<label>
							<input type="radio" value="<%=b%>" name="sblood" <%=b.equals("B")?"checked":"" %>><%=b %>형
						</label>
						&nbsp;
						
					<%}
					%>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-success btn-sm">사원 등록</button>
					<button type="button" class="btn btn-success btn-sm" onclick="history.back()">이전으로</button>
		</table>
	</div>
</form>
</body>
</html>