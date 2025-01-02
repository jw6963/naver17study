show tables;
use study502;

-- 현재 날짜와 시간 구하기(모두 같은 결과)
select now() from dual;
select sysdate() from dual;
select current_timestamp() from dual;

-- 날짜 함수들
select year(now()) from dual; -- year(날짜) : 2025 숫자로 반환
select month(now()) from dual; -- month(날짜) : 월을 숫자로 반환
select day(now()) from dual; -- day(날짜) : 일을 숫자로 반환
select dayofmonth(now()) from dual; -- 위와 같음
select monthname(now()) from dual; -- 월을 영어로 반환
select dayname(now()) from dual; -- 요일을 영어로

-- date_format(날짜,'형식') -> 오라클의 to_char와 같다
-- %Y(년도4자리)%y(년도2자리) %M(월 영어로)%m(월 숫자로) %D(일 순번) %d(일 숫자)
select date_format(now(), '%Y-%M-%d') from dual; -- 2025-January-02
-- %H : 24시간, %h : 12시간 표시, %i 분 ,%p : am/pm
select date_format(now(), '%Y-%m-%d %H:%i') from dual; -- 2025-01-02 15:03
select date_format(now(), '%Y년%m월-%d일 %H시:%i분 %p') from dual; -- 2025년01월-02일 15시:04분 PM

-- 문자 함수들
-- concat(a,b) : 문자 연결합, 여러 개도 가능하다(오라클은 2개만 가능)
select concat('Happy','Day') from dual; 
select concat('Happy','Day','!!') from dual;
-- replace('문자열','기존문자열','새로운 문자열') : 문자열 변경
select replace('bitcamp','bit','비트') from dual;
-- instr('문자열','찾는 문자열') : 위치 반환
select instr('김영희','영희') from dual; -- 2
select instr('김영희','철수') from dual; -- 0
-- left('문자열',갯수) : 왼쪽에서 갯수만큼 문자 추출
-- right('문자열',갯수) : 오른쪽에서 갯수만큼 문자 추출
-- mid('문자열',시작위치,갯수) : 시작위치에서 갯수만큼 문자 추출
-- substring('문자열', '시작위치', 갯수) : 시작위치부터 갯수만큼 추출
select left('Have a Nice day',4) from dual; -- Have
select right('Have a Nice day',3) from dual; -- day
select mid('Have a Nice day',8,4) from dual; -- Nice
select substring('Have a Nice day',8,4) from dual; -- Nice 

-- ltrim, rtrim, trim : 공백 제거
select concat('*',ltrim('      Happy      '),'*' ) from dual;
select concat('*',rtrim('      Happy      '),'*' ) from dual;
select concat('*',trim('      Happy      '),'*' ) from dual; 

-- lower, lcase : 소문자 변환, upper,ucase : 대문자 변환, reverse : 문자 순서 거꾸로 출력
select lower('HappY dAy HahA') from dual;
select lcase('HappY dAy HahA') from dual;
select upper('HappY dAy HahA') from dual;
select ucase('HappY dAy HahA') from dual;
select reverse('HappY dAy HahA') from dual;

-- 조건 함수
-- if(조건식,참일때 값, 거짓일 때 값)
select if(100>200, '맞음','틀림') from dual; 
select if(100>200, '맞음','틀림') result from dual; -- 컬럼명 변경

-- ifnull(컬럼값, 널일 때의 대치값) : 오라클의 nvl과 같다
select ifnull(null,1) from dual; -- 1
select ifnull('mija',1) from dual; -- mija

-- 숫자함수
-- abs : 절대값
select abs(6),abs(-6) from dual;
-- ceiling : 올림, floor : 내림
select ceiling(5.2), floor(5.7) from dual; -- 6, 5
-- round : 반올림
select round(3.16, 1) from dual; -- 소수점 1째자리까지 반올림. 3.2
select round(65845,-2) from dual; -56800 

-- pow : 지수승, mod : 나머지
select pow(2,3), mod(10,3) from dual; -- 8, 1
 
-- greatest(숫자1,숫자2,...) : 가장 큰 숫자 구하기
-- least(숫자1,숫자2...) : 가장 작은 숫자 구하기
select greatest(100,35,352,56,132) from dual; -- 352
select least(234,45,356,21,2,43) from dual; -- 2
