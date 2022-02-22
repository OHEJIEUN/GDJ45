-- DDL
-- Data Definition Language
-- 데이터정의어
-- 데이터베이스 객체를 추가/수정/삭제하는 쿼리문
-- 작업 수행 후 취소가 불가능
-- 종류
-- 생성 : CREATE
-- 변경 : ALTER
-- 삭제 : DROP


-- 테이블 삭제
DROP TABLE enroll;
DROP TABLE student;
DROP TABLE subject;

-- 외래키 제약조건을 무시하고 테이블 삭제
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE subject CASCADE CONSTRAINTS;
DROP TABLE enroll CASCADE CONSTRAINTS;


-- 테이블 생성
CREATE TABLE enroll (
    enroll_no     NUMBER NOT NULL,
    std_no        NUMBER NOT NULL,
    subject_code  VARCHAR2(1 BYTE) NOT NULL
);

CREATE TABLE student (
    std_no    NUMBER NOT NULL,
    std_name  VARCHAR2(15 BYTE),
    std_age   NUMBER
);

CREATE TABLE subject (
    subject_code  VARCHAR2(1 BYTE) NOT NULL,
    subject_name  VARCHAR2(10 BYTE),
    professor     VARCHAR2(15 BYTE)
);


-- 테이블 수정
-- PK 등록
ALTER TABLE enroll ADD CONSTRAINT enroll_pk PRIMARY KEY ( enroll_no );
ALTER TABLE student ADD CONSTRAINT student_pk PRIMARY KEY ( std_no );
ALTER TABLE subject ADD CONSTRAINT subject_pk PRIMARY KEY ( subject_code );
-- FK 등록
ALTER TABLE enroll
    ADD CONSTRAINT enroll_student_fk FOREIGN KEY ( std_no )
        REFERENCES student ( std_no );
ALTER TABLE enroll
    ADD CONSTRAINT enroll_subject_fk FOREIGN KEY ( subject_code )
        REFERENCES subject ( subject_code );