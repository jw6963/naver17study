-- equi join 또는 inner join : 두 테이블의 결합

-- 방법1, 컬럼명 앞에 테이블명이나 테이블 별칭을 붙인다
select
    e.ename, e.job, e.sal, d.dname, d.loc
from emp e, dept d
where e.deptno=d.deptno;

-- 방법2, 조인할 테이블에 컬럼명이 겹치지 않은 경우는 테이블명이나 별칭을 붙이지 않아도 된다
select
    ename, job, sal, dname, loc
from emp e, dept d
where e.deptno=d.deptno;
-- decode 함수 - 다중 if문 같은 함수이다
select ename, deptno, decode(deptno, 10, '홍보부', 20, '교육부', 30, '인사부') 부서명 from emp;