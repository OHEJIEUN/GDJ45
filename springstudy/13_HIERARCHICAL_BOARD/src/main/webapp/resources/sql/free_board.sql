-- 계층형 게시판
-- 자유 게시판

DROP TABLE FREE_BOARD;
CREATE TABLE FREE_BOARD
(
    /* 글번호 */       FREE_BOARD_NO NUMBER NOT NULL,
    /* 작성자 */       WRITER VARCHAR2(50 BYTE),
    /* 내용 */         CONTENT VARCHAR2(1000 BYTE),
    /* IP */           IP VARCHAR2(30 BYTE),
    /* 작성일 */       CREATED DATE,
    /* 수정일 */       MODIFIED DATE,
    /* 삭제여부 */     STATE NUMBER,     /* 정상: 1, 삭제: -1 */
    /* 게시글/댓글 */  DEPTH NUMBER,     /* 게시글: 0, 댓글: 1 또는 1 이상 */
    /* 동일그룹 */     GROUP_NO NUMBER,  /* 게시글: FREE_BOARD_NO, 댓글: 게시글의 FREE_BOARD_NO */
    /* 그룹내순서 */   GROUP_ORD NUMBER  /* 동일그룹내 표시 순서 */
);

-- 시퀀스
DROP SEQUENCE FREE_BOARD_SEQ;
CREATE SEQUENCE FREE_BOARD_SEQ NOCACHE;

-- 원글
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자1', '게시글1', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자2', '게시글2', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자3', '게시글3', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자4', '게시글4', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자5', '게시글5', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자6', '게시글6', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자7', '게시글7', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자8', '게시글8', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자9', '게시글9', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자10', '게시글10', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);

INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자11', '게시글11', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자12', '게시글12', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자13', '게시글13', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자14', '게시글14', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자15', '게시글15', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자16', '게시글16', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자17', '게시글17', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자18', '게시글18', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자19', '게시글19', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자20', '게시글20', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);

INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자21', '게시글21', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자22', '게시글22', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자23', '게시글23', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자24', '게시글24', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자25', '게시글25', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자26', '게시글26', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자27', '게시글27', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자28', '게시글28', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자29', '게시글29', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자30', '게시글30', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);

INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자41', '게시글41', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자42', '게시글42', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자43', '게시글43', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자44', '게시글44', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자45', '게시글45', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자46', '게시글46', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자47', '게시글47', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자48', '게시글48', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자49', '게시글49', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자50', '게시글50', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);

INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자51', '게시글51', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자52', '게시글52', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자53', '게시글53', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자54', '게시글54', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자55', '게시글55', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자56', '게시글56', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자57', '게시글57', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자58', '게시글58', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자59', '게시글59', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자60', '게시글60', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);

INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자61', '게시글61', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자62', '게시글62', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자63', '게시글63', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자64', '게시글64', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자65', '게시글65', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자66', '게시글66', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자67', '게시글67', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자68', '게시글68', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자69', '게시글69', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자70', '게시글70', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);

INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자71', '게시글71', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자72', '게시글72', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자73', '게시글73', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자74', '게시글74', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);
INSERT INTO FREE_BOARD VALUES (FREE_BOARD_SEQ.NEXTVAL, '작성자75', '게시글75', '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE, 1, 0, FREE_BOARD_SEQ.CURRVAL, 0);

COMMIT;
