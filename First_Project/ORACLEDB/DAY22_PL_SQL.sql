-- PL/SQL

CREATE OR REPLACE PROCEDURE UPDATE_SAL
    (P_EMPNO IN NUMBER,
    P_ADDED_SAL IN NUMBER)
IS -- BEGIN에서 사용할 변수
    P_COUNT NUMBER;
BEGIN
    DBMS_OUTPUT.ENABLE;
    UPDATE EMP
    SET
        SAL = SAL +P_ADDED_SAL
        WHERE EMPNO = P_EMPNO;
        -- 변수에 값을 넣고 싶을 때는 := 를 사용해야함
        -- SQL%ROWCOUNT; : 실행한 QUERY에 영향을 받은 행의 개수 리턴함
        P_COUNT := SQL%ROWCOUNT; 
        IF P_COUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('사번을 다시 확인해주세요.');
        ELSIF P_COUNT = 1 THEN
            DBMS_OUTPUT.PUT_LINE(P_COUNT || '개 행이 업데이트 되었습니다.'); -- DB PRINT문
--                                +를 사용하면 수학적 연산만 진행된다.
        ELSE
            DBMS_OUTPUT.PUT_LINE('2개 이상 행이 업데이트 되었습니다.'); 
        END IF;
        -- 커밋은 가장 마지막에 사용해야함. 
        COMMIT;
-- 끝! /로 끝맺음을 해줘야함
-- PROCEDURE 명은 생략이 가능하다.
END UPDATE_SAL; 
/

SELECT * FROM EMP;
SET SERVEROUTPUT ON;
EXECUTE UPDATE_SAL(7369, 50);








CREATE OR REPLACE PROCEDURE INCREASE_HEIGHT_STUDENT
    (P_STUNO IN NUMBER)
IS
BEGIN
    UPDATE STUDENT
    SET STU_HEIGHT = STU_HEIGHT +1
    WHERE STU_NO = P_STUNO;
END;
/

SELECT * FROM STUDENT;
EXECUTE INCREASE_HEIGHT_STUDENT(20153075);

