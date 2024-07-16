-- PL/SQL

CREATE OR REPLACE PROCEDURE UPDATE_SAL
    (P_EMPNO IN NUMBER,
    P_ADDED_SAL IN NUMBER)
IS -- BEGIN���� ����� ����
    P_COUNT NUMBER;
BEGIN
    DBMS_OUTPUT.ENABLE;
    UPDATE EMP
    SET
        SAL = SAL +P_ADDED_SAL
        WHERE EMPNO = P_EMPNO;
        -- ������ ���� �ְ� ���� ���� := �� ����ؾ���
        -- SQL%ROWCOUNT; : ������ QUERY�� ������ ���� ���� ���� ������
        P_COUNT := SQL%ROWCOUNT; 
        IF P_COUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('����� �ٽ� Ȯ�����ּ���.');
        ELSIF P_COUNT = 1 THEN
            DBMS_OUTPUT.PUT_LINE(P_COUNT || '�� ���� ������Ʈ �Ǿ����ϴ�.'); -- DB PRINT��
--                                +�� ����ϸ� ������ ���길 ����ȴ�.
        ELSE
            DBMS_OUTPUT.PUT_LINE('2�� �̻� ���� ������Ʈ �Ǿ����ϴ�.'); 
        END IF;
        -- Ŀ���� ���� �������� ����ؾ���. 
        COMMIT;
-- ��! /�� �������� �������
-- PROCEDURE ���� ������ �����ϴ�.
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

