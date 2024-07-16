CREATE SEQUENCE SAMPLE_SEQ
    INCREMENT BY 1 -- 증가 값
    START WITH 1 -- 초기 값
    MINVALUE 1 -- 최소 값
    MAXVALUE 9999 -- 최대 값
    CYCLE -- MAXVALUE까지 도달 시 처음부터 <-> NOCYCLE
;
