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
최상목 대통령 권한대행 부총리 겸 기획재정부 장관은 1월 21일 방송법·초·중등교육법 
개정안과 반인권적 국가 범죄의 시효 등에 관한 특례법 등 3개 법안에 대해 재의요구권(거부권)을 행사했다.

최 권한대행은 이날 정부서울청사에서 주재한 정례 국무회의에서 “국무위원들과 함께
 법률안들을 심도 있게 검토했으며, 3개 법률안에 대해 불가피하게 재의요구권을 행사하기로 했다”고 밝혔다. 
 이어 “권한대행으로서 재의요구권을 행사하는 것은 국회에서 통과된 법률안을 거부하는 것이 아니다”라며
  “반인권적 국가 범죄의 시효 등에 관한 특례법 제정안은 위헌성이 있는 요소들을 국회에서 보완해 달라는 요청”이라고 말했다.

최 권한대행은 “초·중등교육법 개정안과 방송법 개정안은 국회가 정부와 함께 
더 바람직한 대안과 해결책을 다시 한번 논의해보자는 취지”라며 “지난주에 이어 오늘 국무회의에서도 
재의요구권을 행사하게 돼 국회와 국민께 매우 송구스럽게 생각한다”고 밝혔다.

방송법 개정안은 한국방송공사(KBS)·한국교육방송공사(EBS)의 재원이 되는 TV 수신료를 전기요금과 통합 징수하는 것이 골자다.
 최 권한대행은 “수신료 분리 징수 제도는 작년 7월부터 시행돼 이미 1500만 가구에서 분리 납부를 하고 있으며 국민들의 수신료
  과·오납이 점차 줄어들고 있다”면서 “이런 상황에서 다시 수신료 결합 징수를 강제하게 된다면 국민들의 선택권을 저해하고, 
  소중한 재산권을 침해할 수 있다”고 말했다.

초·중등교육법 개정안은 인공지능(AI) 디지털 교과서를 교과서가 아닌 교육 자료로 규정하는 것이다.

최 권한대행은 “무엇보다 학생들은 인공지능 기술은 물론 앞으로 빅데이터, 사물인터넷, 클라
우드, 유비쿼터스 등 디지털 기술에 기반한 맞춤형 학습을 할 수 있는 교과서 사용 기회 자체를 박탈당하게 된다”며 
“시도 교육청과 학교의 재정 여건에 따라 일부 학생만 다양한 디지털 교육자료를 활용할 수 있게 돼 균등한 교육 
기회 제공이라는 헌법 가치를 훼손할 수 있다”고 말했다.

국가범죄 시효 특례법은 수사기관의 증거 왜곡과 직권남용 등을 반인권적 국가 범죄로 규정하고, 
공소 시효를 배제하는 내용이 핵심이다. 최 권한대행은 “법이 그대로 시행되면 헌법상 기본 원칙인 과잉금지 
원칙에 반하고, 민생 범죄 대응에 공백이 생길 우려가 크다”고 말했다.
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