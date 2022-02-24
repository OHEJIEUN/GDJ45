/*
    DUAL 테이블
    
    1. DUMMY 칼럼에 'X'값을 하나 가지고 있는 테이블이다.
    2. 테이블 자체는 아무 의미가 없다.
    3. 오라클의 SELECT문은 FROM절이 필수이기 때문에, 테이블이 필요없는 단순 조회도 FROM절을 작성해야 한다.
       이 때 DUAL테이블을 FROM절에 작성한다.
*/


-- 1. 형 변환 함수

-- 1) 숫자로 변환하기
--    TO_NUMBER('문자열')

SELECT '100', TO_NUMBER('100')
  FROM DUAL;

SELECT '1.5', TO_NUMBER('1.5')
  FROM DUAL;

-- '문자열' 연산 특징
-- 숫자형 문자열은 자동으로 숫자로 변환된다.
SELECT 1 + 1
  FROM DUAL;

SELECT 1 + '1'  -- SELECT 1 + TO_NUMBER('1')
  FROM DUAL;

SELECT '1' + '1'  -- SELECT TO_NUMBER('1') + TO_NUMBER('1')
  FROM DUAL;



-- 2) 날짜로 변환하기


-- 3) 문자로 변환하기
