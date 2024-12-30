-- system에 등록된 table들 확인하기
select * from tab;

// 등록된 user(계정)들 확인
select username from dba_users;

// dba_users 라는 테이블에는 어떤 컬럼이 있을까

// 기본 구조만 확인 (데이터는 확인 x)
desc dba_users; 

// 계정과 lock 상태알아보기
select username, account_status from dba_users;

-- scott 계정에 비번은 tiger로 생성해보자
create user scott identified by tiger; -- 오류 발생, 12버전부터 발생하는 오류

-- 12버전부터는 user명에 공통문자열 c##이 들어간다
-- 일단 c##scott/비번은 tiger로 만들어보자
create user c##scott identified by tiger;

-- c##scott 계정을 삭제 후 공통 문자열을 안 넣고도 생성하는 방법으로 다시 생성해보자
drop user c##scott;

alter session set "_ORACLE_SCRIPT"=true; -- session 변경

create user scott identified by tiger;
create user angel identified by a1234;

// 계정과 lock 상태알아보기
select username, account_status from dba_users ;

-- angel 계정에 lock 설정
alter user angel account lock;
-- angel 계정에 lock 설정 해제
alter user angel account unlock;

-- scott와 angel 계정에 기본 권한을 주자
grant connect,resource to scott,angel;

-- 생성된 계정에서 테이블을 생성하고 데이터를 추가하려고 하면 table space에 대한 오류가 발생
-- table space 를 unlimit 으로 설정(root만 가능)
alter user angel default tablespace users quota unlimited on users;
alter user scott default tablespace users quota unlimited on users;

-- angel의 비번을 a1234에서 pw1234로 변경
alter user angel IDENTIFIED by pw1234;