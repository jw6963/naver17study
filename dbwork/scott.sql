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
select ename, job, sal, nvl(mgr,100) as mgr, nvl(comm,0) as comm from emp;

select sal, comm, sal+comm from emp; -- comm이 null일 경우 sal+comm도 null
-- 위의 경우 sal+comm 이 경우 comm이 null이면 0으로 계산
select sal,comm,sal+nvl(comm,0) from emp;