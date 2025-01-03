use study502;
select * from person;
-- 테이블 구조 변경
-- 1. 컬럼 추가 hp
alter table person add hp varchar(20);
-- 컬럼 제거
-- 2. today 컬럼 제거
alter table person drop column today;
desc person;
-- 3. type 변경 name을 byte 20에서 30으로 변경
alter table person modify column name varchar(30);
-- 4. writeday를 today로 수정
alter table person rename column writeday to today;

-- 5. hp에 데이터 넣기
update person set hp='010-2222-3333' where num=1;
update person set hp='010-1111-3333' where num=3;
update person set hp='010-3553-3553' where num=4;
update person set hp='010-5235-3535' where num=5;
update person set hp='010-6534-5753' where num=6;
update person set hp='010-6346-3525' where num=7;

-- join 연습용 테이블 생성하기
-- 부모테이블은 person으로 하고 person의 num을 외부키로 갖는 stu 생성
create table stu (
	idx tinyint auto_increment primary key,
	num smallint,
	kor smallint default 0,
	eng smallint default 0,
	sum smallint default 0,
	constraint fk_stu_num foreign key(num) references person(num) on delete cascade
); -- person 데이터 삭제 시 stu에 추가된 데이터 자동으로 지워짐

-- stu에 데이터 추가하기
insert into stu (num,kor,eng) values (1,78,89);
insert into stu (num,kor,eng) values (3,54,59);
insert into stu (num,kor,eng) values (4,89,77);
insert into stu (num,kor,eng) values (5,87,100);
insert into stu (num,kor,eng) values (6,76,92);
insert into stu (num,kor,eng) values (7,75,80);
-- 전체 학생들의 sum 구하기
update stu set sum=kor+eng;
-- person과 stu를 join해서 전체를 출력하는 방법
-- 방법1
select * from person p, stu s where p.num=s.num;
-- 방법2
select p.name,p.blood,p.age,s.kor,s.eng,s.sum 
from person p, stu s where p.num=s.num;
-- 방법3 - 위와 동일 결과
select name,blood,age,hp,kor,eng,sum
from person p inner join stu s on p.num=s.num;

-- stu 생성 시 on delete cascade 설정
-- person에서 1번을 삭제하면 stu에서도 같이 삭제됨
delete from person where num=1;

-- stu만 조회
select * from stu;

select name,age,blood,hp,date_format(today,"%Y-%m-%d %H:%i") today from person; 

select 
	blood, count(*) cnt, round(avg(age),1) avgage
from person
group by blood order by cnt;
