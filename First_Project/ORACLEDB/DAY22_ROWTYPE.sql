-- �ش� ���ν��� ȣ�� �� �ش� ����� ���� ����� �̸�, ���� ���
EXECUTE EMPINFO(7369);
SELECT * FROM EMP;

CREATE OR REPLACE PROCEDURE EMPINFO
    (P_EMPNO IN EMP.EMPNO%TYPE)
IS
    P_EMP EMP%ROWTYPE;
BEGIN
        SELECT ENAME, JOB
        INTO P_EMP.ENAME, P_EMP.JOB
        FROM EMP
        WHERE EMPNO = P_EMPNO;
        DBMS_OUTPUT.PUT_LINE('�̸�: '||P_EMP.ENAME|| ' ����: '||P_EMP.JOB);
END;
/



