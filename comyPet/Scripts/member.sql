CREATE SEQUENCE CMPP_MEMBER_SEQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 1000000;

/*유저 정보*/
CREATE TABLE CMPP_MEMBER_INFO(
	MEMBER_UID NUMBER,
	MEMBER_NAME VARCHAR2(20) NOT NULL,
	MEMBER_ID VARCHAR2(50) NOT NULL,
	MEMBER_PW VARCHAR2(100) NOT NULL,
	MEMBER_NICK VARCHAR2(20) NOT NULL,
	MEMBER_GENDER VARCHAR2(20) NOT NULL,
	MEMBER_BIRTH DATE NOT NULL,
	MEMBER_TEL VARCHAR2(30) NOT NULL,
	MEMBER_EMAIL VARCHAR2(50) NOT NULL,
	MEMBER_ZIPCODE VARCHAR2(100) NOT NULL,
	MEMBER_ADDRESS VARCHAR2(100) NOT NULL,
	MEMBER_ADDRESS_DETAIL VARCHAR2(100) NOT NULL,
	MEMBER_ADDRESS_ETC VARCHAR2(100) NOT NULL,
	MEMBER_MUTE_COMMENT NUMBER(10) DEFAULT 0 NOT NULL,
	MEMBER_MUTE_CONTENTS NUMBER(10) DEFAULT 0 NOT NULL,
	CONSTRAINTS PK_UID PRIMARY KEY(MEMBER_UID)
);

SELECT * FROM CMPP_MEMBER_INFO;
SELECT * FROM CMPP_PROFILE;
SELECT FILE_NAME FROM CMPP_PROFILE WHERE MEMBER_UID = 4;

DROP TABLE CMPP_MEMBER_INFO;

UPDATE CMPP_MEMBER_INFO 
SET MEMBER_PW ='1111'; 

DELETE  cmpp_free_board WHERE member_uid = 23;
DELETE  cmpp_board_comment WHERE member_uid = 23;
DELETE CMPP_PROFILE WHERE PROFILE_IDX = 22;

SELECT COUNT(*) FROM CMPP_MEMBER_INFO WHERE MEMBER_NICK = '테스터'
		
SELECT * FROM CMPP_FREE_BOARD WHERE MEMBER_UID = 4;

SELECT * FROM (SELECT /*+ INDEX_DESC(CMPP_FREE_BOARD PK_FREE_BOARD) */ROWNUM RN, B.* FROM CMPP_FREE_BOARD 
B WHERE ROWNUM <= 1 * 10 AND MEMBER_UID = 4) WHERE RN > (1 - 1) * 10 

SELECT * FROM CMPP_MEMBER_INFO WHERE MEMBER_UID =4;

INSERT INTO CMPP_FREE_BOARD VALUES(CMPP_BOARD_SEQ.NEXTVAL,4,'흠','그래여ㅛ',0,0,0,sysdate,0,0);

SELECT count(MEMBER_ID) FROM CMPP_MEMBER_INFO WHERE MEMBER_ID ='asd' AND MEMBER_PW = '1111';