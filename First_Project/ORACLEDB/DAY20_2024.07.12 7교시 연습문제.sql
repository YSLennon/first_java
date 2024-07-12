SELECT * FROM STU;
SELECT * FROM PROFESSOR;
SELECT * FROM DEPARTMENT;

 -- 1. ������ȣ�� 1003���� ����� �а��� ���� �л����� �й�, �̸�, �г� ���
 SELECT STUNO, S.NAME, GRADE
 FROM STU S
 INNER JOIN PROFESSOR P ON S.DEPTNO1 = P.DEPTNO
 WHERE P.PROFNO=1003;
 
-- 2. PROFESSOR ���̺��� 400�̻��� �޿��� ������ A, 
    --300~400 ���̸� B, �������� C�� ���
SELECT NAME, PAY, CASE WHEN PAY >= 400 THEN 'A'
                    WHEN PAY BETWEEN 300 AND 400 THEN 'B'
                    ELSE 'C'
                  END
FROM PROFESSOR
ORDER BY PAY DESC;
        
-- 3. PROFESSOR ���̺��� id�� �տ� 3���ڸ� *�� ǥ��(�̹��� ī�� ����)
SELECT NAME, LPAD(SUBSTR(ID,4),LENGTH(ID),'*')
FROM PROFESSOR;

-- 4. PROFESSOR ���̺��� ����(POSITION)�� 
--    ���� ū �޿��� �޴� ����� �̸�, �޿�, ���� ���
SELECT NAME, P.PAY, P.POSITION
FROM PROFESSOR P
INNER JOIN (SELECT MAX(PAY) AS PAY, POSITION
            FROM PROFESSOR
            GROUP BY POSITION) J ON P.POSITION = J.POSITION
WHERE P.PAY = J.PAY AND P.POSITION = J.POSITION;

-- �̷������ε� �� �� ����! JOIN�Ҷ� �̹� ���Ǻб�� �ϼ��غ���
SELECT NAME, P.PAY, P.POSITION
FROM PROFESSOR P
INNER JOIN (SELECT MAX(PAY) AS PAY, POSITION
            FROM PROFESSOR
            GROUP BY POSITION) J ON P.PAY = J.PAY AND P.POSITION = J.POSITION;

        
-- 5. �л����� ���� ���� �¾ �� ã��(2�� �̻��� ���� ��� ���ڵ� 2�� ���)
SELECT * FROM STU
ORDER BY SUBSTR(JUMIN,3,2);


SELECT SUBSTR(JUMIN,3,2), COUNT(SUBSTR(JUMIN,3,2))
FROM STU
GROUP BY SUBSTR(JUMIN,3,2)
HAVING 
    COUNT(SUBSTR(JUMIN,3,2)) = (
                            SELECT MAX(COUNT(SUBSTR(JUMIN,3,2)))
                            FROM STU
                            GROUP BY SUBSTR(JUMIN,3,2));
                            