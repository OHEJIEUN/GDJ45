-- 테이블 삭제
DROP TABLE CUSTOMER;
DROP TABLE BANK;

-- 테이블 생성
CREATE TABLE BANK(
    BANK_CODE VARCHAR2(20 BYTE),
    BANK_NAME VARCHAR2(30 BYTE)
);

-- 기본키 지정
ALTER TABLE BANK ADD CONSTRAINT BANK_PK PRIMARY KEY(BANK_CODE);

-- 테이블 생성
CREATE TABLE CUSTOMER(
    NO        NUMBER,
    NAME      VARCHAR2(30 BYTE) NOT NULL,
    PHONE     VARCHAR2(30 BYTE) UNIQUE,
    AGE       NUMBER CHECK(AGE >= 0 AND AGE <= 100),  -- CHECK(조건식), CHECK(AGE BETWEEN 0 AND 100)
    BANK_CODE VARCHAR2(20 BYTE)
);

-- 기본키 지정
ALTER TABLE CUSTOMER ADD CONSTRAINT CUSTOMER_PK PRIMARY KEY(NO);

-- 외래키 지정
ALTER TABLE CUSTOMER 
    ADD CONSTRAINT CUSTOMER_BANK_FK FOREIGN KEY(BANK_CODE) 
        REFERENCES BANK(BANK_CODE);


-- 테이블 정의 변경하기

-- 1. 칼럼 추가
--    BANK 테이블에 BANK_PHONE 칼럼을 추가하시오.
ALTER TABLE BANK ADD BANK_PHONE VARCHAR2(15 BYTE);

--    CUSTOMER 테이블에 GRADE 칼럼을 추가하시오. ('VIP', 'GOLD', 'SILVER' 값을 가진다.)
ALTER TABLE CUSTOMER ADD GRADE VARCHAR2(6 BYTE) CHECK(GRADE = 'VIP' OR GRADE = 'GOLD' OR GRADE = 'SILVER');
ALTER TABLE CUSTOMER ADD GRADE VARCHAR2(6 BYTE) CHECK(GRADE IN('VIP', 'GOLD', 'SILVER'));

-- 2. 칼럼 수정
--    BANK 테이블의 BANK_NAME 칼럼을 VARCHAR2(15 BYTE)로 수정하시오.
ALTER TABLE BANK MODIFY BANK_NAME VARCHAR2(15 BYTE);

--    BANK 테이블의 BANK_NAME 칼럼을 NOT NULL로 수정하시오.
ALTER TABLE BANK MODIFY BANK_NAME VARCHAR2(15 BYTE) NOT NULL;

-- 3. 칼럼 삭제
--   CUSTOMER 테이블의 AGE 칼럼을 삭제하시오.
ALTER TABLE CUSTOMER DROP COLUMN AGE;

-- 4. 칼럼 이름 변경
--    CUSTOMER 테이블의 NO 칼럼을 CUSTOMER_NO로 이름을 변경하시오.
ALTER TABLE CUSTOMER RENAME COLUMN NO TO CUSTOMER_NO;


-- 테이블 구조 확인
DESCRIBE BANK;
DESCRIBE CUSTOMER;
