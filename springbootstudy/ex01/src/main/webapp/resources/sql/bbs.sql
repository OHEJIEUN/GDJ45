DROP TABLE BBS;
CREATE TABLE BBS
(
    BBS_NO NUMBER PRIMARY KEY,          -- 게시글번호, BBS_SEQ 이용
    WRITER VARCHAR2(100 BYTE) NOT NULL, -- 작성자
    TITLE VARCHAR2(100 BYTE) NOT NULL,  -- 제목
    CONTENT VARCHAR2(4000 BYTE),        -- 내용(에디터사용 : 태그가 DB에 포함), 더 큰 크기는 CLOB 타입으로 설정
    CREATED VARCHAR2(20 BYTE),          -- 최초작성일 2022-05-17
    MODIFIED VARCHAR2(20 BYTE)          -- 최종수정일 2022-05-17
);

DROP SEQUENCE BBS_SEQ;
CREATE SEQUENCE BBS_SEQ NOCACHE;