-- �ش� ���ν��� ȣ�� �� �ش� ����� ���� ����� �̸�, ���� ���
EXECUTE EMPINFO(0);
EXECUTE EMPINFO(7369);
SELECT * FROM EMP;
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE EMPINFO
    (P_EMPNO IN EMP.EMPNO%TYPE)
IS
    P_ENAME EMP.ENAME%TYPE;
    P_JOB EMP.JOB%TYPE;
BEGIN
    DBMS_OUTPUT.ENABLE;
    IF P_EMPNO = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Its me! Mario!! You find a Easter Egg');
    ELSE
        SELECT ENAME, JOB
        INTO P_ENAME, P_JOB
        FROM EMP
        WHERE EMPNO = P_EMPNO;
        DBMS_OUTPUT.PUT_LINE('�̸�: '||P_ENAME || ' ����: '||P_JOB);
    END IF;
END;
/