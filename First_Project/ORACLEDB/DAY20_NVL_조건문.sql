-- NVL : NULL값을 대체해서 출력해주는 함수 NVL(COLUMN, REPLACE_STR)
-- 별칭을 주면 좋다! NVL(COMM,0)이런식으로 쓰기는 어려우니까

SELECT EMPNO, ENAME, SAL, NVL(COMM,0) AS COMM 
FROM EMP;

-- NVL2 : VAL2(COLUMN, NOT_NULL_STR, NULL_STR)

SELECT EMPNO, ENAME, SAL, NVL2(COMM,0,1), COMM
FROM EMP;

-- DECODE : (IF문) ORACLE문법임. SQL에는 없음.

SELECT EMPNO, ENAME, DECODE(JOB,'PRESIDENT', '사장')
FROM EMP;

-- IF-ELSE
SELECT EMPNO, ENAME, DECODE(JOB,'PRESIDENT', '사장', '직원')
FROM EMP;

-- IF-ELSE IF

SELECT EMPNO, ENAME, DECODE(JOB,'PRESIDENT', '사장','MANAGER', '관리자', '사원')
FROM EMP;

-- CASE - WHEN - THEN - ELSE - END(IF문과 비슷)

SELECT EMPNO, ENAME,
        CASE JOB WHEN 'PRESIDENT' THEN '사장'
                 WHEN 'MANAGER' THEN '관리자'
                 ELSE '사원' 
        END AS 직급
FROM EMP;

-- IF와 동일하게 위에서부터 체크해서 먼저 적용되는걸 적용해서 새로운 COLUMN을 만든다.

SELECT EMPNO, ENAME,
        CASE WHEN SAL > 3000 THEN '3000'
                 WHEN JOB = 'PRESIDENT' THEN '관리자'
                 ELSE '사원' 
        END AS 직급
FROM EMP;

SELECT EMPNO, ENAME,
        CASE WHEN JOB = 'PRESIDENT' THEN '관리자'
             WHEN SAL > 3000 THEN '3000'
             ELSE '사원' 
        END AS 직급
FROM EMP;

