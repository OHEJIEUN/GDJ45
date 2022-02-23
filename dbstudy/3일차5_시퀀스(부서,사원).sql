-- 테이블 삭제
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

-- DEPARTMENT 테이블 생성
CREATE TABLE DEPARTMENT(
    DEPT_NO   NUMBER NOT NULL,
    DEPT_NAME VARCHAR2(15 BYTE) NOT NULL,
    LOCATION  VARCHAR2(15 BYTE) NOT NULL
);

-- 기본키
ALTER TABLE DEPARTMENT ADD CONSTRAINT DEPARTMENT_PK PRIMARY KEY(DEPT_NO);

-- EMPLOYEE 테이블 생성
CREATE TABLE EMPLOYEE(
    EMP_NO    NUMBER NOT NULL,
    NAME      VARCHAR2(20 BYTE) NOT NULL,
    DEPART    NUMBER,
    POSITION  VARCHAR2(20 BYTE),
    GENDER    CHAR(2),
    HIRE_DATE DATE,
    SALARY    NUMBER
);

-- 기본키
ALTER TABLE EMPLOYEE ADD CONSTRAINT EMPLOYEE_PK PRIMARY KEY(EMP_NO);

-- 외래키
ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT EMPLOYEE_DEPARTMENT_FK FOREIGN KEY(DEPART) 
        REFERENCES DEPARTMENT(DEPT_NO);

/****************************************************************/

/*
    시퀀스
    
    1. 일련번호를 생성하는 데이터베이스 객체이다.
    2. 기본키에서 주로 사용된다.
    3. 자동으로 증가하는 번호를 생성한다.
    4. NEXTVAL를 이용하면 다음에 생성될 번호를 알 수 있다. (주로 사용)
    5. CURRVAL를 이용하면 현재 생성된 번호를 알 수 있다.
*/

-- 시퀀스 생성하기
CREATE SEQUENCE DEPARTMENT_SEQ
    START WITH 1    -- 시작값 1
    INCREMENT BY 1  -- 증가값 1
    MINVALUE 1      -- 최소값 1
    MAXVALUE 100;   -- 최대값 100

-- 시퀀스 이용해서 번호 삽입하기
INSERT INTO DEPARTMENT VALUES(DEPARTMENT_SEQ.NEXTVAL, '영업부', '대구');
INSERT INTO DEPARTMENT VALUES(DEPARTMENT_SEQ.NEXTVAL, '인사부', '서울');
INSERT INTO DEPARTMENT VALUES(DEPARTMENT_SEQ.NEXTVAL, '총무부', '대구');
INSERT INTO DEPARTMENT VALUES(DEPARTMENT_SEQ.NEXTVAL, '기획부', '서울');


-- 시퀀스 생성하기
CREATE SEQUENCE EMPLOYEE_SEQ
    START WITH 1001  -- 시작값 1001
    INCREMENT BY 1   -- 증가값 1
    NOMINVALUE       -- 최소값 없음
    NOMAXVALUE       -- 최대값 없음
    NOCACHE          -- 메모리 캐시 사용 안 함(추천)
    NOCYCLE;         -- 번호 순환 없음

INSERT INTO EMPLOYEE(EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY)
VALUES (EMPLOYEE_SEQ.NEXTVAL, '구창민', 1, '과장', 'M', '95-05-01', 5000000);
INSERT INTO EMPLOYEE(EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY)
VALUES (EMPLOYEE_SEQ.NEXTVAL, '김민서', 1, '사원', 'M', '17-09-01', 2500000);
INSERT INTO EMPLOYEE(EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY)
VALUES (EMPLOYEE_SEQ.NEXTVAL, '이은영', 2, '부장', 'F', '90-09-01', 5500000);
INSERT INTO EMPLOYEE(EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY)
VALUES (EMPLOYEE_SEQ.NEXTVAL, '한성일', 2, '과장', 'M', '93-04-01', 5000000);

COMMIT;