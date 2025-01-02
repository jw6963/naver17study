-- emp table로 연습
desc emp;
-- job 컬럼의 데이터 중 중복되는 데이터는 한번만 출력해보자
select distinct job from emp;
select distinct job,ename from emp; -- 다른 컬럼과 같이 쓸 경우 적용이 안되거나 오류가 날 수도 있다

select ename,job from emp order by ename; -- ename의 오름차순 조회 (asc는 생략 가능)
select ename,job from emp order by ename desc; -- ename의 내림차순 조회 (desc는 생략 불가)

-- job의 오름차순, 같은 job 일 경우는 ename의 내림차순 조회
select job,ename from emp order by job, ename desc;
-- job의 내림차순, 같은 job 일 경우는 ename의 오름차순 조회
select job,ename from emp order by ename ;
-- 순서를 정할 때 컬럼명 대신 나열된 컬럼 번호로 해도 된다(첫번째 컬럼은 1)
select job,ename from emp order by 1,2; -- order by job. ename 과 동일

-- sal의 오름차순 정렬
select * from emp order by 6;

-- empno 의 오름차순 조회
select ename, sal, comm, job, empno from emp order by 5;
select ename, sal, comm, job, empno from emp order by empno;

-- ename의 내림차순
select ename, sal, comm, job, empno from emp order by 1 desc;
select ename, sal, comm, job, empno from emp order by ename desc;

-- where 조건문
select ename, job, sal, comm from emp where sal>=1500;
select ename, job, sal, comm from emp where ename='aleen'; -- 데이터는 대소문자 정확히 써야 한다
select ename, job, sal, comm from emp where ename='ALLEN';

-- ename이 A로 시작하는 데이터 조회
select * from emp where ename like 'A%';
-- ename에 A가 포함되는 데이터 조회
select * from emp where ename like '%A%';
-- ename에 A로 시작하거나 S로 시작하는 데이터 조회
select * from emp where ename like 'A%' or ename like 'S%';
-- ename에 A와 S를 모두 포함하는 데이터만 출력
select * from emp where ename like '%A%' and ename like '%S%';

-- ename의 두번째 글자가 A인 사람만 조회
select * from emp where ename like '_A%';
-- ename의 두번째 글자가 A이거나 세번째가 A인 사람 조회
select * from emp where ename like '_A%' or ename like '__A%';

-- ename이 N이나 K로 끝나는 사람만 조회
select * from emp where ename like '%N' or ename like '%K';

-- job이 analyst이면서 sal이 1500 이상인 사람 조회
select * from emp where job='ANALYST' and sal>=1500;

-- sal 1200~2000 사이 값 조회
select * from emp where sal>=1200 and sal <=2000; -- 방법1
select * from emp where sal between 1200 and 2000; -- 방법2

-- job이 MANAGER, SALESMAN, ANALYST 이 3가지 직업의 사람을 조회
select * from emp where job='MANAGER' or job = 'SLAESMAN' or job='ANALYST'; -- 방법1
select * from emp where job in ('MANAGER','SALESMAN','ANALYST'); -- 방법2

-- empno가 7654,7788,7902인 사람만 조회(in을 이용해서)
select * from emp where empno in (7654,7788,7902);

-- comm이 null인 데이터만 조회
select * from emp where comm is null; 

-- comm이 null이 아닌 데이터만 조회
select * from emp where comm is not null;

-- MGR이 null이 아닌 경우만 조회
select * from emp where mgr is not null;

-- comm이 null 인 경우는 0으로 출력, mgr은 null인 경우 100으로 출력
select ename, job, sal, nvl(mgr,100) as mgr, nvl(comm,0) as comm from emp; -- as 생략 가능

select sal, comm, sal+comm from emp; -- comm이 null일 경우 sal+comm도 null
-- 위의 경우 sal+comm 이 경우 comm이 null이면 0으로 계산
select sal,comm,sal+nvl(comm,0) from emp;

-- 총 레코드 갯수
select (count(*)) from emp;
select count(*) count from emp; -- 이경우는 컬럼명이 count
select count(*) 총갯수 from emp; -- 이경우는 컬럼명이 총갯수

-- 문자열을 컬럼에 추가시 || 연산자 사용
select '내 이름은 '||ename||'입니다' 자기소개 from emp;
select '내 직업은 '||job||'이고, 내 월 급여는 '||sal||'입니다.' 자기소개 from emp;

-- sal이 1500~2000 사이가 아닌 경우만조회
select * from emp where sal not between 1500 and 2000;

-- not in 을 사용하여 job이 salesman, clerk가 아닌 경우만 조회
select * from emp where job not in ('SALESMAN', 'CLERK');

-- GROUP 함수(COUNT,SUM,AVG,MAX,MIN
select count(*) FROM EMP;
select sum(sal) from emp;
select avg(sal) from emp;
select round(avg(sal),2) from emp;
select max(sal) from emp;
select min(sal) from emp;

-- 평균급여보다 sal이 더 높은 사람을 조회하시오.
select ename,sal from emp where sal > (select avg(sal) from emp);

-- scott의 직업과 같은 직업을 가진 사람을 조회하시오.
select ename, job from emp where job = (select job from emp where ename='SCOTT');

-- scott의 mgr과 같은 mgr을 가진 사람
select ename, mgr from emp where mgr = (select mgr from emp where ename='SCOTT');

-- group by
select job 직업,count(*) 인원수 from emp group by job;

-- job의 group 별로 인원수를 구해보자(인원이 3명 이상인 경우에만 조회)
select job 직업, count(*) 인원수 from emp group by job having count(job)>=3;

-- job의 group 별로 인원수를 구해보자(인원이 3명 이상인 경우에만 조회) : 인원순으로 오름차순
select job 직업, count(*) 인원수 from emp group by job having count(job)>=3 order by 인원수;

-- 직업별 인원수, 최저연봉, 최고연봉, 평균연봉(소숫점이하 없이)을 구하시오.
select job 직업, count(*) 인원수, min(sal) 최저연봉, max(sal) 최고연봉, round(avg(sal),0) 평균연봉 from emp group by job;

-- 숫자 함수
select abs(-5),abs(5) from dual;

-- round : 반올림, ceil : 올림, floor: 내림
select round(3.6,0), ceil(3.6), floor(3.6) from dual; // 4,4,3
select round(3.4,0), ceil(3.4), floor(3.4) from dual; // 3,4,3
select round(328947,-2) from dual; // 328900 
select round(328467,-2) from dual; // 328500

-- power(M,N) : M의 N승 값을 구함. 
-- mod(M,N) : M을 N으로 나눈 나머지
select power(3,3), mod(10,3) from dual; // 27, 1

-- 문자함수 concat(두 문자 더하기), lower(소문자), upper(대문자), initcap(첫글자만 대문자)
select ename, concat(ename, '님'), lower(ename), upper(ename), initcap(ename) from emp;

select LPAD(sal,10,'*') from emp; -- 총 10자리 중 남는 부분을 왼쪽부터 *로 채움
select RPAD(sal,10,'*') from emp; -- 총 10자리 중 남는 부분을 오른쪽부터 *로 채움

select substr('HAPPY DAY', 7, 3) from dual; -- 7번째 글자부터 3글자 추출
select substr('HAPPY DAY', -6, 3) from dual; -- 뒤에서 6번째 글자부터 3글자 추출

-- emp 테이블의 ename에서 왼쪽 3글자를 추출 후 총 7자리 중 우측 빈공간은 *로 채워서 출력
select rpad(substr(ename, 1,3),7,'*') from emp;

-- length 길이 구하기
select ename 이름, length(ename) from emp;

-- replace - happy를 good 으로 변경
select replace('HAPPY DAY', 'HAPPY','GOOD') from dual;

-- trim : 앞 뒤 공백 제거
select '*'||'    Lee su ji   '||'*' from dual;
select '*'||trim('    Lee su ji   ')||'*' from dual;

-- 일단 현재 날짜를 나타내는 sysdate
select sysdate from dual; -- 현재 날짜
select sysdate+7 from dual; -- 오늘로부터 7일 뒤 날짜
select sysdate+1 from dual; -- 내일 날짜

-- to_char 함수를 이용해서 원하는 날짜 모양으로 출력해보자
select to_char(sysdate, 'yyyy-mm-dd') from dual; 
select to_char(sysdate, 'yyyy-mm-dd am hh:mi') from dual; -- 2024-12-30 오후 04:44
select to_char(sysdate, 'yyyy-mm-dd hh24:mi') from dual; -- 2024-12-30 16:44
select to_char(sysdate, 'month') from dual; -- (지역화에 따라 다르게 나오므로 잘 사용 안 함)

-- 현재 년도 4자리만 추출
select to_char(sysdate, 'yyyy') from dual;
-- 현재 월 추출
select to_char(sysdate, 'mm') from dual;
select to_char(to_date('2024-5-10'),'mm') from dual; -- 05