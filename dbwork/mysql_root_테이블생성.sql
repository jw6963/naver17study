-- cmd창에서 접속 시 mysql-8
-- mysql -u root -p  -- p 엔터 누르면 비밀번호 입력 후 엔터로 접속
show databases; -- database 전체 종류
-- 연습용 tatabase study502 생성

create database study502;

-- cmd 창에서 접속한 경우 use database명으로 이동한다

-- database 제거
drop database study502;

-- 연습용 생성 후 제거
create database test11;
drop database test11;