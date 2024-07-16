

DECLARE 
    I NUMBER;
BEGIN
    FOR I IN 1..10 LOOP
--    FOR I IN REVERSE 1..10 LOOP -- 역으로 출력하기
    IF MOD(I,2) =1 THEN
--    IF I MOD 2 = 1 THEN
        DBMS_OUTPUT.PUT_LINE(I);
    END IF;
    END LOOP;
END;
/

DECLARE
    I NUMBER := 1;
BEGIN
    WHILE I <= 5 LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I+1;
    END LOOP;
END;
/