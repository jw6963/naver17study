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
   </style>
</head>
<%
boolean blogin=false;
Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for (int i=0; i<cookies.length;i++){
		// loginok 라는 쿠키가 있는지 검사
		if(cookies[i].getName().equals("loginok")){
			blogin=true;
			break;
		}
	}
}
%>
<body>
	<%
if(blogin){%>
	<pre>
고위공직자범죄수사처가 22일 윤석열 대통령에 대한 3차 강제구인 시도에 나섰다.

공수처는 이날 오전 10시 20분께 경기도 의왕시 서울구치소 정문을 통과해 내부로 진입했다.

공수처는 구인이 여의치 않을 경우 무리한 추진보다는 방문조사를 시도하는 방안도 고려 중이다.

이번 강제구인 시도는 지난 20일, 21일에 이은 세 번째 시도다.

앞서 오동운 공수처장은 이날 출근길에 "(윤 대통령이) 소환에 불응하고 있어 불가피하게 
강제구인에 나서고 있다"며 "오늘 강제구인을 시도하겠다"고 말했다.

윤 대통령은 지난 15일 공수처에 체포된 후 진술 거부권을 행사 중이다. 
또 16·17일 출석 요구에도 모두 불응했다. 19일 새벽 구속된 뒤에도 당일 오후 2시와 20일 
오전 10시 출석하라는 두 차례 요구에도 불응했다.
</pre>
	<%} else {
%>
	<script type="text/javascript">
alert("먼저 로그인을 해주세요");
history.back();// 이전 페이지로 이동
</script>
<%} %>

</body>
</html>