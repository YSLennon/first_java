SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

-- �����, ����, �μ���, �μ���ġ�� ���
SELECT ENAME, JOB,DNAME, LOC
FROM EMP E
INNER JOIN DEPT D ON D.DEPTNO = E.DEPTNO;

-- �����ȣ, �����, �޿�, �޿������ ��� INNER JOIN 'COLUMN' ON 'BOOLEAN' �̶�� ���� �ɵ�?
SELECT EMPNO, ENAME, SAL, GRADE
FROM EMP E
INNER JOIN SALGRADE S ON SAL BETWEEN LOSAL AND HISAL;

-- �� ����(JOB) �� �޿���յ�� 
SELECT JOB, ROUND(AVG(GRADE), 1)
FROM EMP E
INNER JOIN SALGRADE S ON SAL BETWEEN LOSAL AND HISAL
GROUP BY JOB;

-- �μ��� �޿���յ��(�μ���, �μ���� ���)
SELECT DNAME, ROUND(AVG(GRADE), 1)
FROM EMP E
INNER JOIN SALGRADE S ON SAL BETWEEN LOSAL AND HISAL
INNER JOIN DEPT D ON E.DEPTNO = D.DEPTNO
GROUP BY DNAME;

SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

-- 1. 2000�̻� �޿��� �޴� ����� ���� ���Ͻÿ�.
SELECT COUNT(*)
FROM EMP
WHERE SAL >= 2000;

-- 2. �����ȣ, �̸�, �޿��� ����Ͻÿ�. ��, �޿��� ����� ��, 
--    Ŀ�̼��� �޴� ����� Ŀ�̼ǰ� ���ؼ� ����� ��.
SELECT EMPNO, ENAME, SAL + NVL(COMM, 0) AS �޿�
FROM EMP;

-- 3. WARD���� ���� �޿�(SAL)�� �޴� ������� ����Ͻÿ�.
SELECT *
FROM EMP
WHERE SAL > (SELECT SAL
FROM EMP
WHERE ENAME ='WARD');

-- 4. �޿������ 3��� �̻��� ������� ���� ����Ͻÿ�.
SELECT COUNT(*)
FROM EMP E
INNER JOIN SALGRADE S ON SAL BETWEEN LOSAL AND HISAL
WHERE GRADE >= 3;

-- 5. 81�⵵�� �Ի��� ������� ��� ����Ͻÿ�.
SELECT *
FROM EMP
WHERE TO_CHAR(HIREDATE, 'YY') = 81;

-- 6. �� ���޺� ���� ���� �޿��� �޴� ����� ����Ͻÿ�.
SELECT E.*
FROM EMP E
INNER JOIN(
            SELECT MAX(SAL) AS MAX_SAL, JOB
            FROM EMP
            GROUP BY JOB) E2 ON E.SAL = E2.MAX_SAL AND E.JOB = E2.JOB;
            
-- WHERE���� ���� ������ε� ���� �� �ִ���(�߾Ⱦ�)
SELECT *
FROM EMP E
WHERE (SAL, JOB) IN (SELECT MAX(SAL) AS MAX_SAL, JOB
            FROM EMP
            GROUP BY JOB);

-- 7. SALESMAN ���޺��� ��ձ޿��� ���� �μ����� �μ���, ��� �޿� ����� ����Ͻÿ�.
SELECT DNAME, ROUND(AVG(GRADE), 1)
FROM EMP E
INNER JOIN SALGRADE S ON SAL BETWEEN LOSAL AND HISAL
INNER JOIN DEPT D ON D.DEPTNO = E.DEPTNO
GROUP BY DNAME
HAVING ROUND(AVG(SAL)) > (SELECT AVG(SAL)
FROM EMP
WHERE JOB = 'SALESMAN');

-- ROUND ���� �� ã��
SELECT ROUND(AVG(SAL),-3),AVG(SAL)
FROM EMP
GROUP BY DEPTNO;