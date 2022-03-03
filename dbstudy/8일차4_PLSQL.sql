-- HR 계정의 EMPLOYEES 테이블을 SCOTT 계정으로 복사하기
CREATE TABLE EMPLOYEES
    AS (SELECT *
          FROM HR.EMPLOYEES);

-- 기본키는 추가로 생성
ALTER TABLE EMPLOYEES
    ADD CONSTRAINT EMPLOYEES_PK PRIMARY KEY(EMPLOYEE_ID);



-- 서버메시지 출력을 할 수 있도록 SERVEROUTPUT 값을 ON으로 세팅한다.
-- 디폴트 상태는 SET SERVEROUTPUT OFF이다.
SET SERVEROUTPUT ON;



-- PL/SQL의 프로그래밍 기본 형식
/*
[DECLARE]
    변수 선언
BEGIN
    작업 수행
END;
*/



-- 'Hello World' 서버메시지 출력하기
-- DBMS_OUTPUT.PUT_LINE('메시지') : '메시지' 출력 후 줄 바꿈을 진행한다.
-- DBMS_OUTPUT.PUT('메시지')      : '메시지' 만 출력한다.
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello World');
END;




-- 변수 선언하기1
-- 스칼라 변수 (타입을 직접 명시하는 방법)
-- 대입연산자는 '등호(=)'가 아니라 '콜론등호(:=)'이다.
DECLARE
    my_name VARCHAR2(20 BYTE);
    my_age  NUMBER(3);
BEGIN
    my_name := '민경태';
    my_age := 45;
    DBMS_OUTPUT.PUT_LINE('My name is ' || my_name);
    DBMS_OUTPUT.PUT_LINE('I am ' || my_age || ' years old.');
END;




-- 변수 선언하기2
-- 참조 변수 (기존 테이블의 특정 칼럼과 같은 타입으로 선언)
-- 참조 변수 선언 방식 : 테이블명.칼럼%TYPE

DECLARE
    my_name   EMPLOYEES.LAST_NAME%TYPE;
    my_salary EMPLOYEES.SALARY%TYPE;
BEGIN
    my_name := '민경태';
    my_salary := 1000;
    DBMS_OUTPUT.PUT_LINE(my_name);
    DBMS_OUTPUT.PUT_LINE(my_salary);
END;




-- 변수 선언하기3
-- 참조 타입은 주로 테이블에 저장된 데이터를 변수에 저장할 때 사용
-- 테이블의 데이터를 변수에 저장하는 방법
-- SELECT 칼럼 INTO 변수 : 칼럼의 값을 변수에 저장

DECLARE
    var_last_name  EMPLOYEES.LAST_NAME%TYPE;
    var_salary     EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT LAST_NAME, SALARY
      INTO var_last_name, var_salary
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;
    DBMS_OUTPUT.PUT_LINE('LAST_NAME : ' || var_last_name);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || var_salary);
END;






