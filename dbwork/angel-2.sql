-- pl-sql 이란 sql 언어에 절차적 언어요소를 추가해서 프로그래밍한 것을 pl/sql이라고 한다
-- 형식
-- declare
--     변수, 커서 선언
-- begin
--   sql구문이나 pl/sql문으로 코딩
-- end
-- / (실행)

-- 스크립트 출력창에 결과가 출력되도록 한 번만 설정
set serveroutput on -- 켜기
set serveroutput off -- 끄기 (dbm 창으로 확인하려면 꺼도 됨)

-- 예제 1
declare
    v_no number(4,1); -- 변수 선언, 4자리 수에 소숫점이하 1자리 라는 뜻
begin
    v_no:=12.7; -- 값 대입(오라클에서 = 은 비교연산자, :=는 대입연산자)
    dbms_output.put_line(v_no); -- v_no를 콘솔창에 출력
end;
/

-- 예제 2
declare
    vscode varchar2(20);
    vsprice number(10);
    vsangpum varchar2(20);
begin
    vscode:='A600';
    -- vscode값에 해당하는 상품 데이터 가져오기
    select sangprice, sangname
    into vsprice,vsangpum
    from shop
    where sangcode = vscode;
    dbms_output.put_line('상품명 : '||vsangpum);
    dbms_output.put_line('가 격 : '||vsprice||'원');
    dbms_output.put_line('코드번호 : '||vscode);
end;
/

-- 예제 3 if문 -- 년도에 따라서 띠를 구해보자
-- 쥐(子), 소(丑), 호랑이(寅), 토끼(卯), 용(辰), 뱀(巳), 말(午), 양(未), 원숭이(申), 닭(酉), 개(戌), 돼지(亥)
declare
    v_year number(4) := 2025;
    v_mod number(2) := mod(v_year,12); -- 서기 1년은 닭띠이다.. 12년이 원숭이띠
    v_ddi varchar2(20); -- 띠 저장할 변수
begin
    if v_mod=0 then v_ddi:='원숭이띠';
    elsif v_mod=1 then v_ddi:='닭띠';
    elsif v_mod=2 then v_ddi:='개띠';
    elsif v_mod=3 then v_ddi:='돼지띠';
    elsif v_mod=4 then v_ddi:='쥐띠';
    elsif v_mod=5 then v_ddi:='소띠';
    elsif v_mod=6 then v_ddi:='호랑이띠';
    elsif v_mod=7 then v_ddi:='토끼띠';
    elsif v_mod=8 then v_ddi:='용띠';
    elsif v_mod=9 then v_ddi:='뱀띠';
    elsif v_mod=10 then v_ddi:='말띠';
    elsif v_mod=11 then v_ddi:='양띠';
    end if;
    dbms_output.put_line(v_year||'년도는 '||v_ddi||'해이다');
end;
/

-- accept를 이용해서 년도를 직접 입력해서 띠를 알아보자
accpet year prompt '년도를 입력해보세요';
declare
    v_year number(4) := '&year'; -- 입력받은 year 값 가져오기
    v_mod number(2) := mod(v_year,12); -- 서기 1년은 닭띠이다.. 12년이 원숭이띠
    v_ddi varchar2(20); -- 띠 저장할 변수
begin
    if v_mod=0 then v_ddi:='원숭이띠';
    elsif v_mod=1 then v_ddi:='닭띠';
    elsif v_mod=2 then v_ddi:='개띠';
    elsif v_mod=3 then v_ddi:='돼지띠';
    elsif v_mod=4 then v_ddi:='쥐띠';
    elsif v_mod=5 then v_ddi:='소띠';
    elsif v_mod=6 then v_ddi:='호랑이띠';
    elsif v_mod=7 then v_ddi:='토끼띠';
    elsif v_mod=8 then v_ddi:='용띠';
    elsif v_mod=9 then v_ddi:='뱀띠';
    elsif v_mod=10 then v_ddi:='말띠';
    elsif v_mod=11 then v_ddi:='양띠';
    end if;
    dbms_output.put_line(v_year||'년도는 '||v_ddi||'해이다');
end;
/

-- 예제 4 상품코드,상품명, 가격을 입력받아 shop 테이블에 추가해보자
accept scode prompt 'A로 시작하는 상품코드를 입력하세요';
accept ssang prompt '상품명을 입력하세요';
accept sprice prompt '가격을 입력하세요';
declare
    v_code varchar2(20) := '&scode';
    v_sang varchar2(30) := '&ssang';
    v_price number(10) := '&sprice';
begin
    insert into shop (sangcode,sangname,sangprice)values (v_code,v_sang,v_price);
    dbms_output.put_line(v_sang||' 상품 정보를 테이블에 추가했습니다');
end;
/

-- 예제 5 Cursor와 for문을 이용하여 shop의 데이터들을 읽어오자
declare
    -- 커서 객체에 select sql문을 이용해서 넣기
    cursor s1
    is
    select * from shop;
begin
    for s in s1 loop -- recode 단위로 s를 가져온다
        dbms_output.put_line(s.sangcode||'   '||s.sangname||'   ' ||s.sangprice);
        exit when s1%notfound; -- 더이상 데이터가 없으면 for문 탈출
    end loop;
end;
/

-- 응용: join sql 문을 이용해서 cartnum, sangcode, sangname, sangprice, cntnum, cartday를 출력하시오
declare
    -- 커서 객체에 select sql문을 이용해서 넣기
    cursor s1
    is
    select 
        c.cartnum, s.sangcode, s.sangname, s.sangprice, c.cntnum, to_char(c.cartday,'yyyy-mm-dd') cartday
        from shop s, cart c
        where s.sangcode = c.sangcode;
begin
    for s in s1 loop -- recode 단위로 s를 가져온다
        dbms_output.put_line(s.cartnum||'   '||s.sangcode||'   '||s.sangname||'   ' ||s.sangprice||'   '||s.cntnum||'   '||s.cartday);
        exit when s1%notfound; -- 더이상 데이터가 없으면 for문 탈출
    end loop;
end;
/

-- 상품 코드와 상품명과 가격을 accept를 이용해서 입력 후 shop에 해당 상품코드가 존재할 경우 update로 수정을 하고
-- 존재하지 않을 경우 insert로 추가를 하시오
accept scode prompt '상품코드 입력';
accept sname prompt '상품명 입력';
accept sprice prompt '가격 입력';
declare
    v_code varchar2(20) :='&scode';
    v_name varchar2(30) :='&sname';
    v_price number(10) :='&sprice';
    v_cnt number(2); -- count 값을 가져올 변수
begin
--    INSERT INTO shop (sangcode, sangname, sangprice)
--    VALUES (v_code, v_name, v_price) ON DUPLICATE KEY
--    UPDATE sangname = v_name, sangprice = v_price;
    select count(*) into v_cnt
    from shop where sangcode=v_code; -- 존재하면 1 없으면 0
    if v_cnt=1 then
        update shop set sangname=v_name, sangprice=v_price
        where sangcode=v_code;
        commit;
        dbms_output.put_line(v_code||'상품이 수정되었습니다.');
    else
        insert into shop (sangcode,sangname,sangprice) values (v_code,v_name,v_price);
        commit;
        dbms_output.put_line(v_code||'상품이 추가되었습니다.');
    end if;
end;
/

-- 상품명을 입력하면 shop 테이블에서 그 이름을 포함하고 있는 데이터를 모두 출력
accept name prompt '상품명 입력';
declare
    v_name varchar2(20) := '&name';
    v_cnt number(2);
    cursor s1
    is
    select * from shop where sangname like '%'||v_name||'%';
begin
    select count(*) into v_cnt
    from shop
    where sangname like '%'||v_name||'%';
    dbms_output.put_line(v_cnt);
    if v_cnt>0 then
        dbms_output.put_line('상품코드    상품명    상품가격');
        dbms_output.put_line('---------------------------');
        for s in s1 loop
            dbms_output.put_line(s.sangcode||'    '||s.sangname||'    '||s.sangprice);
            exit when s1%notfound;
        end loop;
    else dbms_output.put_line(v_name||'상품은 존재하지 않습니다');
    end if;
end;
/