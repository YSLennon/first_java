-- 해당 프로시저 호출 시 해당 사번을 가진 사람의 이름, 직급 출력
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
        DBMS_OUTPUT.PUT_LINE('이름: '||P_EMP.ENAME|| ' 직급: '||P_EMP.JOB);
END;
/



