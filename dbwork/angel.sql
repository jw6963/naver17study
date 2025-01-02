-- 시퀀스를 생성해보자
create sequence seq1; -- 1부터 1씩 자동 증가하는 시퀀스 객체가 생성
create sequence seq2 start with 1 increment by 1; -- 위와 같다. (1부터 1씩 증가는 생략 가능)
create sequence seq3 start with 1 increment by 1 nocache; -- 위와 같으니 cache 사이즈를 20에서 0으로 변경
create sequence seq4 start with 1 increment by 1 maxvalue 100 nocache; -- max 값을 100까지만
create sequence seq5 start with 5 increment by 5 nocache;

-- 시퀀스 전체 정보를 출력
select * from seq;

-- 시퀀스 값을 발생시켜보자 - 한번 발생한 값들은 두 번 다시 안 나온다
select seq1.nextval, seq2.nextval, seq3.nextval,seq4.nextval,seq5.nextval from dual;

-- 시퀀스 제거
drop SEQUENCE seq1;
drop SEQUENCE seq2;
drop SEQUENCE seq3;
drop SEQUENCE seq4;
drop SEQUENCE seq5;

-- table 생성
create table test1 (
    num number(3) primary key,
    name varchar2(20) not null,
    today date);

-- 구조 확인
desc test1;

-- 데이터 추가
insert into test1 values (1, 'CANDY', sysdate); -- 컬럼명 생략 시 컬럼 순서대로 값을 넣는다
-- primary key에 같은 값을 넣었을 경우 어떤 오류가 나오는 지 확인하기
insert into test1 values (1, 'ORANGE', sysdate); -- 무결성 제약 조건으로 코드번호 출력
-- 이번에는 이름을 빼고 넣은 후 오류 확인
insert into test1 (num,today) values (2,sysdate); -- ORA-01400: NULL을 ("ANGEL"."TEST1"."NAME") 안에 삽입할 수 없습니다

-- 이번에는 전체 데이터를 순서를 바꿔 넣어보자
insert into test1 (num,today,name) values (2,'2024-11-20','MIRA');

-- insert 2개 추가한 상태에서 rollback을 해보자
rollback;
-- 다시 위의 insert 문 실행해서 넣고 commit 해보자 - rollback해도 남아있다.
commit;

-- 데이터 확인
select * from test1;

-- test2는 test1과 같은데 제약 조건 이름을 추가해서 생성해보자
create table test2 (
    num number(3) constraint pk_test2_num primary key,
    name varchar2(20) constraint nn_test2_name not null,
    today date);

-- 오류를 발생 시켜보자
insert into test2 values(1,'CANDY',sysdate);
insert into test2 values(1,'MIRA',sysdate); -- ORA-00001: 무결성 제약 조건(ANGEL.PK_TEST2_NUM)에 위배됩니다

-- 테이블의 구조 변경, alter table
-- 컬럼 추가 : add, 컬럼 삭제 : drop column, 컬럼 수정 : modify, 컬럼명 변경 : rename column

-- test1에 age number(3) 컬럼 추가하기
alter table test1 add age number(3);

-- test1에 addr varchar2(30) 추가하는데 기본 값을 SEOUL로 주고 싶다.
alter table test1 add addr varchar2(30) default 'SEOUL';

-- test1에 gaipday date으로 추가하는데 기본 값을 현재 날짜로
alter table test1 add gaipday date default sysdate;

-- test1의 today column 삭제하기
alter table test1 drop column today;

-- test1의 name의 길이를 20에서 30으로 수정해보자
alter table test1 modify name varchar2(30);

-- test1의 addr을 address로 컬럼명을 변경해보자
alter table test1 rename column addr to address;

-- test1의 gaipday를 writeday로 변경
alter table test1 rename column gaipday to writeday;

-- test1의 제약조건 중 sys_c008317(임시이름)을 제거해보자
alter table test1 drop constraint sys_c008317;

-- test1에 제약조건을 추가 :  age를 나이 범위가 10~30으로, 제약조건명 : ck_test1_age
alter table test1 add constraint ck_test1_age check (age>=10 and age<=30);

-- age에 범위를 벗어나게 추가해서 오류확인하기
insert into test1 (num,name,age) values (2,'sda',40); -- ORA-02290: 체크 제약조건(ANGEL.CK_TEST1_AGE)이 위배되었습니다

-- 5분 문제
-- 1. test2에 blood varchar2(10) 초기값은 A로 추가하기
alter table test2 add blood varchar2(10) default 'A';
-- 2. test2에서 today 컬럼 제거하기
alter table test2 drop column today;
-- 3. test2의 name을 sawon_name으로 컬럼이름 변경하기
alter table test2 rename column name to sawon_name;
-- 4. BLOOD에 제약조건 추가(A,B,O,AB 만 가능하도록 check) ck_test2_blood
alter table test2 add constraint ck_test2_blood check (blood in('A', 'B', 'O', 'AB'));
-- 5. nn_test2_name 이라는 제약조건을 제거하기
alter table test2 drop constraint nn_test2_name;

-- 연습용 테이블 제거하기
drop table test1;
drop table test2;

--------------------------------------------------------------------------------------------
-- 시퀀스 생성
create sequence seq1 nocache; -- 1부터 1씩 증가하는 cache없는 시퀀스 생성
-- 테이블 생성
create table sawon (
    num number(3) constraint pk_sawon_num primary key,
    name varchar2(20),
    buseo varchar2(20),
    gender varchar2(10) default '남자',
    age number(3),
    height number(5,1),
    writeday date);

-- 제약조건 추가 : 부서명은 '홍보부','교육부,'관리부'만 가능하다 ck_sawon_buseo
alter table sawon add constraint ck_sawon_buseo check (buseo in ('홍보부','교육부','관리부'));
-- 제약조건 추가 : 성별은 '남자','여자'만 가능하다 ck_sawon_gender
alter table sawon add constraint ck_sawon_gender check (gender in ('남자','여자'));

-- 데이터 추가
insert into sawon values (seq1.nextval, '이진', '홍보부', '여자', 29, 167.9, sysdate);
insert into sawon (num,name,buseo,age) values (seq1.nextval,'강호동','관리부',35);
insert into sawon (num,name,buseo,height) values (seq1.nextval,'유재석','홍보부',175.3);
insert into sawon (num,name,buseo,gender,age,writeday) values (seq1.nextval,'송해나','교육부','여자',31,sysdate);
insert into sawon values (seq1.nextval,'이영자','관리부','여자',31,156.7,sysdate);
commit;

-- update - 수정
update sawon set height=186.5; -- 만약 where 조건을 안 쓰면 모든 행이 수정된다
-- 취소
rollback;

-- num=3인 경우만 수정
update sawon set height=186.5 where num=3;

-- 여러 컬럼을 수정하는 경우
update sawon set buseo='홍보부',age=39,height=162.1 where name='이영자';

-- writeday가 null일 경우 '2024-12-12'로 변경해보자
update sawon set writeday='2024-12-12' where writeday is null;
commit;

-- delete - 삭제
delete from sawon; -- where 조건을 안 쓴 경우 전체 데이터가 삭제된다

-- 삭제 취소
rollback;

-- age가 null인 데이터 모두 삭제
delete from sawon where age is null;

-- group by 연습
-- 부서별 인원수와 평균 나이를 구하시오
select buseo,count(*),avg(age) from sawon group by buseo;
-- 성별 인원수와 평균 나이를 구하시오
select gender,count(*),avg(age) from sawon group by gender;

---------------------------------------------------
-- join 연습용 테이블 생성하기
create table food (
foodnum number(3) primary key,
foodname varchar2(20),
foodprice number(7),
foodsize varchar2(20));

create table booking (
    bnum number(3) constraint pk_booking_bnum primary key,
    bname varchar(20) constraint nn_booking_bname not null,
    bhp varchar(20) constraint uq_booking_bgp unique,
    foodnum number(3),
    bookingday date,
    constraint fk_foodnum foreign key(foodnum) references food(foodnum));


-- 메뉴 등록
insert into food values (100, '짜장면', 9000,'보통');
insert into food values (101, '짜장면', 11000,'곱배기');
insert into food values (200, '탕수육', 15000,'보통');
insert into food values (201, '탕수육', 20000,'곱배기');
insert into food values (300, '칠리새우', 15000,'소');
insert into food values (301, '칠리새우', 30000,'대');
insert into food values (400, '해물짬뽕', 11000,'보통');
commit;
select * from food;

-- 시퀀스 생성
create sequence seq_food start with 10 increment by 10 nocache;

-- 예약
insert into booking values (seq_food.nextval, '이영자','010-1234-5678',200,'2024-12-24');
-- 오류 발생시켜보기
insert into booking values (seq_food.nextval, '김말자','010-7777-5678',401,'2025-01-14'); -- 401은 메뉴에 없음
-- ORA-02291: 무결성 제약조건(ANGEL.FK_FOODNUM)이 위배되었습니다- 부모 키가 없습니다
insert into booking values (seq_food.nextval, '김말자','010-7777-5678',301,'2025-01-14');
insert into booking values (seq_food.nextval, '이효리','010-2434-5643',400,'2025-02-23');
insert into booking values (seq_food.nextval, '손예진','010-5432-3425',201,'2024-12-31');
commit;

-- inner join 으로 예약손님의 정보 확인
select 
    bname,bhp,foodname,foodprice,foodsize,to_char(bookingday,'yyyy-mm-dd') bookingday
from food f, booking b
where f.foodnum=b.foodnum;

-- outer join을 이용해서 한 번도 주문하지 않은 메뉴들을 알아보자
select
    f.foodnum, bname, foodname,foodprice,foodsize
from food f, booking b
where f.foodnum=b.foodnum(+); -- 이 때 아무도 주문하지 않은 메뉴는 주문자가 null이 온다

-- 위의 sql문을 이용해서 주문자 이름을 빼고 null 인 경우만 출력하면 아무도 주문하지 않은 메뉴만 골라낼 수 있다
select
    f.foodnum,foodname, foodprice,foodsize
from food f, booking b
where f.foodnum=b.foodnum(+) and bname is null;

-- booking(자식 테이블)에 추가된 메뉴를 food(부모테이블) 에서 삭제할 수 있을까?
-- 자식 테이블 생성 시 on delete cascade 설정을 안 했을 경우는 못 지운다
delete from food where foodnum=200; -- 200번 메뉴는 이영자가 예약주문함, 그래서 삭제 못함
-- 오류메세지 : ORA-02292: 무결성 제약조건(ANGEL.FK_FOODNUM)이 위배되었습니다- 자식 레코드가 발견되었습니다

delete from food where foodnum=300; -- 아무도 주문을 예약하지 않았으므로 삭제 가능함

-- 부모테이블을 삭제해보자
drop table food; -- 삭제 안됨, 자식테이블을 먼저 삭제해야 부모테이블도 삭제 가능

-- booking을 먼저 제거 후 food 제거 - 외부키로 서로 연결되어 있으므로
drop table booking;
drop table food;

-- sawon 테이블도 일단 삭제
drop table sawon;

-- 시퀀스도 일단 모두 삭제
drop sequence seq_food;
drop sequence seq1;



