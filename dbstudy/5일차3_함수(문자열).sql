-- 문자 처리 함수


-- 1. 대소문자 처리
--    1) UPPER   : 대문자로 변환 (CAP)
--    2) LOWER   : 소문자로 변환 (cap)
--    3) INITCAP : 첫글자만 대문자 (Cap)
SELECT
       UPPER(EMAIL)
     , LOWER(EMAIL)
     , INITCAP(EMAIL)
  FROM
       EMPLOYEES;

-- 2. 길이
--    1) LENGTH  : 글자수
--    2) LENGTHB : 바이트수
SELECT
       EMAIL
     , LENGTH(EMAIL)
     , LENGTHB(EMAIL)
  FROM
       EMPLOYEES;

-- 3. 연결
--    1) || 연산자
--    2) CONCAT 함수
--       인수가 2개로 고정됨 : CONCAT(A, B) => AB    CONCAT(A, B, C) => 오류
--                                                   CONCAT(A, CONCAT(B, C)) => ABC
SELECT
       '대한' || '독립' || '만세'
     , CONCAT('대한', CONCAT('독립', '만세'))
  FROM
       DUAL;

-- 4. 일부 반환
--    SUBSTR(문자열, BEGIN, LENGTH) : BEGIN부터 LENGTH개 반환, BEGIN의 시작은 1
SELECT
       EMAIL
     , SUBSTR(EMAIL, 1, 3) -- 1번 글자부터 3개 반환
  FROM
       EMPLOYEES;

