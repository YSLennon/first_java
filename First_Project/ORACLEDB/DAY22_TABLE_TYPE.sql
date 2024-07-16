--프로시져 호출 시 SELECT 데이터가 여러개 일 경우

SELECT * FROM EMP;

EXECUTE DEPT_LIST(10);
-- 10번 부서 사람들의 사번, 이름, 급여 출력

CREATE OR REPLACE PROCEDURE DEPT_LIST
    (P_DEPTNO IN EMP.DEPTNO%TYPE)
IS
    TYPE EMPNO_TABLE IS TABLE OF EMP.EMPNO%TYPE
    INDEX BY BINARY_INTEGER;
    TYPE ENAME_TABLE IS TABLE OF EMP.ENAME%TYPE
    INDEX BY BINARY_INTEGER;
    TYPE SAL_TABLE IS TABLE OF EMP.SAL%TYPE
    INDEX BY BINARY_INTEGER;
    
    EMPNO_TAB EMPNO_TABLE;
    ENAME_TAB EMPNO_TABLE;
    SAL_TAB EMPNO_TABLE;
    I NUMBER;
BEGIN
    SELECT EMPNO, ENAME, SAL
    INTO EMPNO_TAB, ENAME_TAB, SAL_TAB
    FROM EMP
    WHERE DEPTNO = P_DEPTNO;
        
    
END;
/