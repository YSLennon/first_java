SELECT * FROM EMP;
-- UNION, UNION ALL
-- COLUMN�� ������ �����ؾ��ϸ�, ����(Ÿ��) ���� �����ؾ��Ѵ�.

SELECT 
    ENAME, JOB, SAL+NVL(COMM,0) AS SAL_COMM
FROM EMP
WHERE SAL >= 1500
UNION ALL
SELECT 
    ENAME, JOB, SAL+NVL(COMM,0)
FROM EMP
WHERE COMM IS NOT NULL;


SELECT * FROM STUDENT;
SELECT * FROM ENROL;


SELECT �̸�, �������
FROM (
    SELECT 
        STU_NAME �̸�,
        NVL(AVG(ENR_GRADE),0) �������
        ,1 AS ORDERKEY
    FROM STUDENT S
    INNER JOIN ENROL E ON E.STU_NO = S.STU_NO
    GROUP BY STU_NAME, 1
    UNION 
    SELECT 
        '��ü���',
        ROUND(AVG(ENR_GRADE),1)
        , 2 AS ORDERKEY
    FROM ENROL
    
    ORDER BY ORDERKEY, ������� DESC
);