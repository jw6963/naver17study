create user c##angel identified by a1234;

create user c##bitcamp identified by a1234;

select username from dba_users;

drop user c##angel;
drop user c##bitcamp;

// 세션 변경. c## 없이 유저 생성 가능
alter session set "_ORACLE_SCRIPT"=true; 

create user bitcamp identified by a1234;
create user angel identified by a1234;

// 접속. 권한 없어서 실패
conn angel/a1234;

// 접속, 파일 생성 등 권한 부여
grant connect,resource to angel;

conn angel/a1234; // 원래 접속 돼야 하는데 오류남. 나중에 확인
// cmd 창에서는 접속 되는 것 확인함.
// 이 tool에서 접속 정보에 유저 정보를 넣기 때문에 유저 변경을 막아놓은 건가??

show user

revoke CONNECT,resource from angel;

select * from tab;

// test 테이블 생성
create table test(name varchar2(20), age number);

desc test;

// 권한 없는 유저로 행 삽입 시 에러.
insert into test values('kim',23);

// 권한 부여
alter user bitcamp default tablespace users quota unlimited on users;
alter user angel default tablespace users quota unlimited on users;

select * from test;

drop table test;
drop user angel;
drop user bitcamp;