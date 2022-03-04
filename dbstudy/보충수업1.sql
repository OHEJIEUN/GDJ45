-- 1. DEPARTMENT_ID가 20인 사원중에서 전체 평균 연봉(SALARY) 이상을 받는 사원의 EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, SALARY를 조회하시오.


-- 2. JOB_ID가 'IT_PROG'인 사원의 최대 연봉(SALARY)보다 더 많은 연봉을 받는 사원의 EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY를 조회하시오.


-- 3. EMPLOYEE_ID가 115인 사원과 같은 JOB_ID, DEPARTMENT_ID를 가진 사원의 EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID를 조회하시오.


-- 4. LOCATION_ID가 1000~1500인 국가들의 COUNTRY_ID, COUNTRY_NAME을 조회하시오.


-- 5. MANAGER가 아닌 사원들의 EMPLOYEE_ID, FIRST_NAME을 조회하시오.
--    (참고. 서브쿼리 결과는 NULL을 포함하면 안 된다.)


-- 6. 근무하는 CITY가 'Southlake'인 사원들의 EMPLOYEE_ID, FIRST_NAME를 조회하시오.


-- 7. 가장 많은 사원이 근무 중인 부서의 DEPARTMENT_ID, 근무 인원 수를 조회하시오.


-- 8. DEPARTMENT_NAME의 오름차순 정렬 기준으로 사원의 EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID를 조회하시오.


-- 9. 최대 연봉 사원의 EMPLOYEE_ID, FIRST_NAME, SALARY를 조회하시오.
--    1) ROWNUM 활용
--       (1) 높은 연봉이 가장 위로 오도록 정렬한다. (연봉 내림차순 정렬)
--       (2) 정렬 결과에서 ROWNUM이 1인 데이터를 조회한다.

--    2) RANK() OVER() 활용
--       (1) 높은 연봉이 1등이 되도록 RANK() 함수를 구한다.
--       (2) RANK() 함수 결과가 1인 데이터를 조회한다.


-- 10. 연봉 TOP 11 ~ 20 사원의 EMPLOYEE_ID, FIRST_NAME, SALARY를 조회하시오.
--     1) ROWNUM 활용
--        (1) 높은 연봉이 가장 위로 오도록 정렬한다. (연봉 내림차순 정렬)
--        (2) 정렬 결과에 ROWNUM 칼럼을 추가한다. 반드시 ROWNUM 칼럼에 별명을 부여한다.
--        (3) 부여된 ROWNUM의 별명으로 11 ~ 20 사이를 조회한다.

--    2) RANK() OVER() 활용
--       (1) 높은 연봉이 1등이 되도록 RANK() 함수를 구한다.
--       (2) RANK() 함수 결과가 11~20인 데이터를 조회한다.