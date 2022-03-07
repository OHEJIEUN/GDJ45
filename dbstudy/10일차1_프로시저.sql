/*
    프로시저(PROCEDURE)
    
    1. 여러 개의 쿼리문을 한 번에 처리할 수 있다.
    2. 동시에 진행해야하는 쿼리문들을 한 번에 수행할 수 있다.
       (예 : 이체의 경우 2개의 UPDATE문이 필요)
    3. EXECUTE(줄여서 EXEC)문으로 실행한다.
    4. 형식
        CREATE [OR REPLACE] PROCEDURE 프로시저명(매개변수)
        IS  -- AS도 가능
            변수선언
        BEGIN
            작업수행
        [EXCEPTION]
            예외처리
        END 프로시저명;
*/

SET SERVEROUTPUT ON;

-- 프로시저 PROC1 정의
CREATE OR REPLACE PROCEDURE PROC1
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello Procedure');
END PROC1;

-- 프로시저 PROC1 호출
EXECUTE PROC1();




-- 프로시저 PROC2 정의
CREATE OR REPLACE PROCEDURE PROC2
IS
    var_last_name EMPLOYEES.LAST_NAME%TYPE;
    var_employee_id EMPLOYEES.EMPLOYEE_ID%TYPE;
BEGIN
    var_employee_id := 100;
    SELECT LAST_NAME
      INTO var_last_name
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = var_employee_id;
    DBMS_OUTPUT.PUT_LINE(var_last_name);
END PROC2;

-- 프로시저 PROC2 실행
EXECUTE PROC2();




-- 프로시저 PROC3 정의
-- 입력 파라미터 : 프로시저로 전달되는 값을 저장할 변수
-- 형식 : 변수명 IN 타입
CREATE OR REPLACE PROCEDURE PROC3(var_employee_id IN EMPLOYEES.EMPLOYEE_ID%TYPE)
IS
    var_last_name EMPLOYEES.LAST_NAME%TYPE;
BEGIN
    SELECT LAST_NAME
      INTO var_last_name
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = var_employee_id;
    DBMS_OUTPUT.PUT_LINE(var_last_name);
END PROC3;

-- 프로시저 PROC3 실행
EXECUTE PROC3(100);  -- 인수 100을 입력 파라미터 var_employee_id에 전달한다.




-- 프로시저 PROC4 정의
-- 출력 파라미터 : 프로시저의 결과 값을 저장할 변수
-- 형식 : 변수명 OUT 타입
CREATE OR REPLACE PROCEDURE PROC4(var_last_name OUT EMPLOYEES.LAST_NAME%TYPE)
IS
    var_employee_id EMPLOYEES.EMPLOYEE_ID%TYPE;
BEGIN
    var_employee_id := 100;
    SELECT LAST_NAME
      INTO var_last_name
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = var_employee_id;
END PROC4;

-- 프로시저 PROC4 실행
DECLARE
    var_last_name EMPLOYEES.LAST_NAME%TYPE;
BEGIN
    PROC4(var_last_name);  -- 프로그래밍 내부에서는 EXECUTE가 없어야 프로시저를 호출할 수 있다.
    DBMS_OUTPUT.PUT_LINE(var_last_name);
END;




-- 프로시저 PROC5 정의
CREATE OR REPLACE PROCEDURE PROC5
(
    var_employee_id IN  EMPLOYEES.EMPLOYEE_ID%TYPE,
    var_last_name   OUT EMPLOYEES.LAST_NAME%TYPE
)
IS
BEGIN
    SELECT LAST_NAME
      INTO var_last_name
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = var_employee_id;
END PROC5;

-- 프로시저 PROC5 실행
DECLARE
    var_employee_id EMPLOYEES.EMPLOYEE_ID%TYPE;
    var_last_name   EMPLOYEES.LAST_NAME%TYPE;
BEGIN
    var_employee_id := 100;
    PROC5(var_employee_id, var_last_name);
    DBMS_OUTPUT.PUT_LINE(var_last_name);
END;




-- 연습
-- 사원번호를 전달하면 해당 사원의 연봉을 반환하는 프로시저 PROC6을 작성하시오.
-- 사원번호는 입력 파라미터로 처리하고, 연봉은 출력 파라미터로 처리하시오.
-- 전달된 사원번호가 존재하지 않는다면 연봉은 0으로 조회되도록 처리하시오. (EXCEPTION)
CREATE OR REPLACE PROCEDURE PROC6
(
    var_employee_id IN  EMPLOYEES.EMPLOYEE_ID%TYPE,
    var_salary      OUT EMPLOYEES.SALARY%TYPE
)
IS
BEGIN
    SELECT SALARY
      INTO var_salary
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = var_employee_id;
EXCEPTION
    WHEN NO_DATA_FOUND THEN  -- WHEN OTHERS THEN으로 처리할 수도 있음.
        var_salary := 0;
END PROC6;

DECLARE
    var_employee_id EMPLOYEES.EMPLOYEE_ID%TYPE;
    var_salary      EMPLOYEES.SALARY%TYPE;
BEGIN
    var_employee_id := 99;
    PROC6(var_employee_id, var_salary);
    DBMS_OUTPUT.PUT_LINE('사원번호 ' || var_employee_id || '의 연봉 ' || var_salary);
END;
