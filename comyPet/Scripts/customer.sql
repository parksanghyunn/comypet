CREATE SEQUENCE CMPP_CS_SEQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 10000000;

CREATE TABLE CMPP_CUSTOMER(
	customer_idx NUMBER,
	customer_name VARCHAR2(20),
	customer_email VARCHAR2(100),
	customer_tel VARCHAR2(30),
	customer_contents VARCHAR2(3000),
	customer_regDate DATE,
	customer_state NUMBER(10),
	CONSTRAINTS PK_CUSTOMER_IDX PRIMARY KEY(customer_idx)
);

SELECT * FROM cmpp_customer;