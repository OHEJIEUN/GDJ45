-- 그룹화
-- 1. SELECT절에서 조회할 칼럼은 반드시 GROUP BY절에 존재해야 한다.
-- 2. 그룹화는 대부분 그룹함수와 함께 사용된다.


-- 1. 동일한 지역(LOCATION_ID)으로 그룹화하여 조회하시오.
SELECT LOCATION_ID
  FROM DEPARTMENTS
 GROUP BY LOCATION_ID;


-- 2. 지역(LOCATION_ID)의 중복을 제거하여 조회하시오.
SELECT DISTINCT LOCATION_ID
  FROM DEPARTMENTS;


-- 3. 동일한 지역(LOCATION_ID)으로 그룹화하여 각 지역별 부서의 수를 조회하시오.
SELECT LOCATION_ID, COUNT(*)
  FROM DEPARTMENTS
 GROUP BY LOCATION_ID;