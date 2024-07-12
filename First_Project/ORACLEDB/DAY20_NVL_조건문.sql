-- NVL : NULL���� ��ü�ؼ� ������ִ� �Լ� NVL(COLUMN, REPLACE_STR)
-- ��Ī�� �ָ� ����! NVL(COMM,0)�̷������� ����� �����ϱ�

SELECT EMPNO, ENAME, SAL, NVL(COMM,0) AS COMM 
FROM EMP;

-- NVL2 : VAL2(COLUMN, NOT_NULL_STR, NULL_STR)

SELECT EMPNO, ENAME, SAL, NVL2(COMM,0,1), COMM
FROM EMP;

-- DECODE : (IF��) ORACLE������. SQL���� ����.

SELECT EMPNO, ENAME, DECODE(JOB,'PRESIDENT', '����')
FROM EMP;

-- IF-ELSE
SELECT EMPNO, ENAME, DECODE(JOB,'PRESIDENT', '����', '����')
FROM EMP;

-- IF-ELSE IF

SELECT EMPNO, ENAME, DECODE(JOB,'PRESIDENT', '����','MANAGER', '������', '���')
FROM EMP;

-- CASE - WHEN - THEN - ELSE - END(IF���� ���)

SELECT EMPNO, ENAME,
        CASE JOB WHEN 'PRESIDENT' THEN '����'
                 WHEN 'MANAGER' THEN '������'
                 ELSE '���' 
        END AS ����
FROM EMP;

-- IF�� �����ϰ� ���������� üũ�ؼ� ���� ����Ǵ°� �����ؼ� ���ο� COLUMN�� �����.

SELECT EMPNO, ENAME,
        CASE WHEN SAL > 3000 THEN '3000'
                 WHEN JOB = 'PRESIDENT' THEN '������'
                 ELSE '���' 
        END AS ����
FROM EMP;

SELECT EMPNO, ENAME,
        CASE WHEN JOB = 'PRESIDENT' THEN '������'
             WHEN SAL > 3000 THEN '3000'
             ELSE '���' 
        END AS ����
FROM EMP;

