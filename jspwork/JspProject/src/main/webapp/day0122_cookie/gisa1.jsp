<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
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
오세훈 서울시장이 최근 각종 여론조사에서 더불어민주당의 지지율이 떨어지고 있는 것과 관련해 
"국민들이 거대 야당의 문제점을 정확히 알고 있다"고 주장했다. 22일 오 시장은 이날 서울시청에서
 열린 '2025년 출입기자단 신년 간담회'에서 이 같이 밝히며 "각종 여론조사의 지지율로 이미 반영돼 나타나고 있다"고 설명했다.

이어 "사실 대통령이 탄핵소추된 상태에서 한 권한대행이 안정적으로 국정을 운영할 수 있도록 최대한 돕는 것이
 야당이 해야 될 일이었다"라며 "결정적인 순간에 한덕수 총리까지 권한대행에서 탄핵소추를 통해서 업무를 하지 못하도록 
 만드는 장면을 보면서 많은 국민께서 '민주당은 민생을 국민을 먼저 생각하는 게 아니라 집권을 먼저 생각하는구나'라고 실망한 많은 
 국민들이 등을 돌린 걸로 저는 본다"라고 설명했다.

그러면서 "또 외교까지도 정쟁의 도구로 삼아서 국가의 미래를 위태롭게 할 수 있는 정당이구나 라는 판단이 
(민주당 지지율 하락에) 결정적이었던 걸로 저는 본다"고 덧붙였다.

아울러 오 시장은 국민들이 이재명 대표가 집권하게 되면 한미관계가 매우 위태롭게 되겠다는 위기감도 느꼈을 것이라고 주장했다.

그는 "탄핵 사유 중에 미국, 일본과의 관계를 회복한 것이 잘못된 국정 운영이었고 탄핵 사유까지 된다고 명시한 부분을 보면서 많은,
 국민들이 지금 트럼프 신정부가 출범하는 즈음에 그런 문구가 탄핵사유에 들어가는 것을 보면서 이재명 대표가 집권하게 되면 한미관계가 
 매우 위태롭게 되겠다는 위기감을 느꼈을 것"이라고 했다.

또 "최근 '카톡 계엄'을 비롯해서 여러 가지 원인이 있는데 그런 믿음직하지 못한 민주당의 행태를 
보면서 국민들이 등을 돌리기 시작한 것 같다"고 분석했다.

오 시장은 국민의힘의 지지율이 오르는 것에 대해서도 "저희 당으로서는 독약이라고 생각한다. 
걱정이 크다"며 우려를 내비치기도 했다.

그는 "민주당의 실수가 아닌 우리 실력으로 올라가야한다. 우리 당이 지금 지지율이 갑자기 
짧은 시간에 많이 올라왔다"면서 "이거는 저는 앞으로 부정적으로 영향을 미칠 가능성이 매우 높다고 본다. 
우리 당의 자중자애를 주문한다"고 강조했다.

이어 자신이 차기 대선 주자 지지율에서 정체되는 것에 대해서는 "저는 지지율에 그렇게 연연하지 않는다"라며 
"일과 지지율이 꼭 비례하지 않는다. 묵묵히 일을 하다 보면 언젠가는 평가를 받을 날이 오는데 큰 선거를 앞두고 있기 때문에
 아마 지지율 순위나 이런 거를 눈여겨보시는 거는 인지상정이라고 생각한다"고 밝혔다.
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