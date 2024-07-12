SELECT * FROM EMP; -- MGR == ���(MANAGER) SALGRADE: �޿�, COMMISSION: ���ʽ�, DEPTNO: �μ���ȣ
SELECT * FROM DEPT;
SELECT * FROM SALGRADE; -- �޿� ��� SALARY GRADE

-- JOB�� MANAGER�� ������� ��� �޿�

SELECT ROUND(AVG(SAL),1)
FROM EMP
WHERE JOB = 'MANAGER';

-- ���, �̸�, ����� �̸� (SELF JOIN)
SELECT E.EMPNO, E.ENAME, E2.ENAME
FROM EMP E
INNER JOIN EMP E2 ON E.MGR = E2.EMPNO
;

-- ���������� �� ���

SELECT E.EMPNO, E.ENAME, COUNT(E2.ENAME)
FROM EMP E
LEFT JOIN EMP E2 ON E.EMPNO = E2.MGR
GROUP BY E.EMPNO, E.ENAME
;

SELECT E.ENAME, E.EMPNO, NVL(E2.CNT, 0) AS CNT
FROM EMP E
LEFT JOIN(
    SELECT COUNT(*) AS CNT, MGR
    FROM EMP
    GROUP BY MGR
    ) E2 ON E.EMPNO = E2.MGR;
