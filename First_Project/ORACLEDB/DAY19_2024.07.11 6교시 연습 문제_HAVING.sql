SELECT * FROM SUBJECT;
-- 1. ������ �л��� ���� ������ ������ ���� �̸� ���

SELECT SUB_NAME, SUB_PROF
FROM STUDENT S
INNER JOIN ENROL E ON S.STU_NO= E.STU_NO
INNER JOIN SUBJECT SUB ON E.SUB_NO = SUB.SUB_NO
WHERE STU_NAME = '������';

-- 2. �����۹�, �������ڽ��� ������ ��� �л��� �й�, �̸�, ������ ���

SELECT S.STU_NO, STU_NAME, SUB_NAME
FROM STUDENT S
INNER JOIN ENROL E ON S.STU_NO = E.STU_NO
INNER JOIN SUBJECT SUB ON SUB.SUB_NO = E.SUB_NO
WHERE SUB_NAME ='�����۹�' OR SUB_NAME= '�������ڽ���';
-- WHERE SUB_NAME IN ('�����۹�','�������ڽ���') -> OR�� ��� IN���� ����� �� �ִ�.

-- 3. �����̸鼭 ������ ������ ������ ��� �л��� �й�, �̸�, �а�, ������, ���� ���� ���

SELECT S.STU_NO, STU_NAME, STU_DEPT, SUB_NAME, ENR_GRADE
FROM STUDENT S
INNER JOIN ENROL E ON E.STU_NO = S.STU_NO
INNER JOIN SUBJECT SUB ON SUB.SUB_NO = E.SUB_NO
WHERE SUB_PROF = '������' AND STU_GENDER = 'F';

-- 4. �������� ��� �������� ���� ������ ���� �л����� �̸�, �����, ���� ���

SELECT S.STU_NAME, SUB_NAME, ENR_GRADE
FROM STUDENT S
INNER JOIN ENROL E ON E.STU_NO = S.STU_NO
INNER JOIN SUBJECT SUB ON SUB.SUB_NO = E.SUB_NO
WHERE ENR_GRADE < (
                   SELECT AVG(ENR_GRADE) 
                   FROM ENROL E
                   INNER JOIN STUDENT S ON S.STU_NO = E.STU_NO
                  );
                    

-- 5. 2�� �̻��� ������ ��� �л����� ��� ���(�����, ����)
 -- ��ǻ� ����! �л��� ����� �ʿ���
SELECT SUB_NAME, ENR_GRADE, STU_NAME
FROM (
      SELECT COUNT(STU_NO) AS CNT, STU_NO
      FROM ENROL
      GROUP BY STU_NO
     ) S
INNER JOIN ENROL E ON E.STU_NO = S.STU_NO
INNER JOIN SUBJECT SUB ON SUB.SUB_NO = E.SUB_NO
-- INNER JOIN STUDENT J ON J.STU_NO = S.STU_NO -> �̰Ÿ� ������ �Ʒ��� ���� ����̾��µ� ������ �� �Ű澲��.. ���� 
-- ������ �ڵ带 ���̷��� ������� �ʾƵ� �ɵ�?
WHERE CNT >= 2;

 -- JOIN�� �̿��� ���
 
SELECT *
FROM STUDENT S
INNER JOIN ENROL E ON E.STU_NO = S.STU_NO
INNER JOIN SUBJECT SUB ON SUB.SUB_NO = E.SUB_NO
INNER JOIN(
           SELECT COUNT(STU_NO) AS CNT, STU_NO
           FROM ENROL
           GROUP BY STU_NO
          ) J ON J.STU_NO = S.STU_NO
WHERE CNT >= 2;

 
 

-- 6. �������ڰ��� ��� �������� ���� ��� ������ ���� �л����� ��� ���

SELECT ENR_AVG, STU_NAME
FROM STUDENT S
INNER JOIN (
            SELECT AVG(ENR_GRADE) AS ENR_AVG, STU_NO
            FROM ENROL
            GROUP BY STU_NO
           ) E ON S.STU_NO = E.STU_NO
WHERE ENR_AVG > (
                 SELECT  AVG(ENR_GRADE)
                 FROM STUDENT S
                 INNER JOIN ENROL E ON E.STU_NO = S.STU_NO
                 WHERE STU_DEPT = '��������'
                );


    -- 6�� ���� ��� HAVING(�׷� �Լ��� ���� ������ �� �� �ִ� ����) -> WHERE�� GROUP�Լ� ����
    -- �׷��� �̹� ����ΰ� �� ������ HAVING�� ���ͼ� �� �׷쿡 ���� ������ �� �� �ִ�.
SELECT AVG(ENR_GRADE), STU_NAME
FROM STUDENT S
INNER JOIN ENROL E ON S.STU_NO = E.STU_NO
GROUP BY S.STU_NO, STU_NAME
HAVING AVG(ENR_GRADE) >  (
                 SELECT  AVG(ENR_GRADE)
                 FROM STUDENT S
                 INNER JOIN ENROL E ON E.STU_NO = S.STU_NO
                 WHERE STU_DEPT = '��������'
                );

SELECT COUNT(*), STU_NO
FROM ENROL
GROUP BY STU_NO
HAVING COUNT(*) >= 2;

-- �а� �� ���Ű�� 165 �̻��� �а� ���
SELECT STU_DEPT, ROUND(AVG(STU_HEIGHT),1)
FROM STUDENT
GROUP BY STU_DEPT
HAVING AVG(STU_HEIGHT) >= 165;

