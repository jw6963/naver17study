use study502;
create table person(
	num smallint auto_increment primary key,
	name varchar(20),
	blood varchar(20) default 'B',
	age smallint,
	today date,
	writeday datetime
);

select * from person;

-- table 구조 확인
desc person;
show create table person; -- 좀 더 디테일한 구조 확인

-- 데이터 추가하기
insert into person (name,age,today,writeday) values ('이영자',23,now(),now());
-- 모든 컬럼명 생략하고 순서대로 넣기 - num은 시퀀스 컬럼이므로 null로 줘도 숫자로 들어간다
insert into person values (null, '강호동','AB',45,now(),now());
insert into person values (null, '고릴라','O',19,now(),now());
insert into person values (null, '박성진','A',33,now(),now());
insert into person values (null, '강영현','B',33,now(),now());
insert into person values (null, '김원필','A',32,now(),now());
insert into person values (null, '윤도운','AB',31,now(),now());

-- 각종 조회 연습
select num,name,age from person order by age asc;
select num,name,age from person order by age desc;
select * from person where age>=20 and age =<33;
select * from person where age between 20 and 33;
select * from person where blood ='O' or blood ='AB' or blood='A';
select * from person where blood in ('A','AB','O');
select * from person where name like '강%';
select * from person where name like '%영%';
select * from person where name like '_성%';

-- 그룹 함수 : count, avg,sum,max,min
select count(*) from person;
select avg(age) from person;
select round(avg(age),0) from person;
select max(age) 최고나이, min(age) 최소나이 from person;

-- 혈액형별 인원수와 평균 나이를 구해보자
select blood, count(*) 인원수, round(avg(age),0) 평균나이
from person group by blood order by blood asc;

-- limit 시작위치, 가져올 글의 갯수
select * from person limit 0,3; -- 첫글(0번)부터 3개 가져오기
select * from person limit 2,3; -- 2번부터 3개 가져오기

-- where 조건과 limit 사용 시
select * from person where age>=20 limit 2,2;

-- update
update person set blood='O', age=18 where name='고릴라';

-- delete
delete from person where name ='강호동';
commit;
select * from person;

-- 연습용 테이블 생성
create table study502.shop(
	idx smallint auto_increment primary key,
	sangpum varchar(30),
	su smallint default 1,
	danga int,
	ipgoday datetime
);
select * from shop;
select * from study502.person;
use study502;
select * from person;
desc person;
insert into study502.person (name,age,blood,hp,today) values ("강호동",32,"B","010-4234-4334",now());

