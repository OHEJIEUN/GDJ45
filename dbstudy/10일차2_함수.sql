/*
    함수(FUNCTION)
    
    1. 특정 결과 값을 반환한다.
    2. 값을 반환할 때 RETURN을 사용한다.
    3. 입력 파라미터를 사용할 수 있다.
    4. 함수 호출 결과를 처리할 수 있도록 호출해야 한다.
    5. 형식
        CREATE [OR REPLACE] FUNCTION 함수명(매개변수)
        RETURN 반환타입
        IS  -- AS도 가능
            변수선언
        BEGIN
            작업수행
        [EXCEPTION]
            예외처리
        END 함수명;
*/




-- 함수 FUNC1 정의
CREATE OR REPLACE FUNCTION FUNC1
RETURN VARCHAR2  -- 반환타입
IS
BEGIN
    RETURN 'Hello Function';  -- 반환값
END FUNC1;

-- 함수 FUNC1 호출
SELECT FUNC1()
  FROM DUAL;














