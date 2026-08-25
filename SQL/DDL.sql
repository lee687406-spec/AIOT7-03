/*
    상품번호
    상품명
    가격
    설명
    등록일자
    수정일자
*/
DROP TABLE product;
CREATE TABLE product (
    no          NUMBER PRIMARY KEY,
    name        VARCHAR2(100) NOT NULL,
    price       NUMBER DEFAULT 0 NOT NULL,
    description CLOB,
    created_at  DATE DEFAULT SYSDATE NOT NULL,
    updated_at  DATE DEFAULT SYSDATE NOT NULL 
);

-- 시퀀스
CREATE SEQUENCE PRODUCT_SEQ 
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;