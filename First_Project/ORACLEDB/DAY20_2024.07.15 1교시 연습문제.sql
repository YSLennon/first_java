SELECT * FROM STU;
SELECT * FROM PROFESSOR;
SELECT * FROM DEPARTMENT;

--1. ���̵� 7���� �̻��� �л����� ����� ����Ͻÿ�.
SELECT *
FROM STU
WHERE LENGTH(ID) >= 7;

--2. ���̵� a�� ����ִ� �л����� ����� ����Ͻÿ�. (like)
SELECT * 
FROM STU
WHERE ID LIKE '%a%';

--3. ����(DEPTNO1)�� ��ǻ�Ͱ��а��� �л����� ����� ����Ͻÿ�.
SELECT *
FROM STU S
INNER JOIN DEPARTMENT D ON D.DEPTNO = S.DEPTNO1
WHERE D.DNAME = '��ǻ�Ͱ��а�';

--4. 81�⵵�� �Ի��� �������� ����� ����Ͻÿ�.
SELECT * 
FROM PROFESSOR
WHERE TO_CHAR(HIREDATE, 'YY') = 81;

--5. �� �г⺰ �л����� ��� Ű�� ���Ͻÿ�.
SELECT ROUND(AVG(HEIGHT), 1)
FROM STU;

--6. 96�й��� 97�й� �� ���� Ű�� ū �л��� �й�, �̸�, ���̵�, Ű�� ����Ͻÿ�.
-- (�й� : STUNO �� ù �α���)
SELECT STUNO, NAME, ID, HEIGHT
FROM STU
WHERE   
    SUBSTR(STUNO,1,2) IN(96,97) AND
    HEIGHT = (SELECT MAX(HEIGHT)
    FROM STU
    WHERE SUBSTR(STUNO,1,2) IN(96,97));
    
    --> 96, 97 ���� ���϶�µ�..? �ٽ� �غ��� ��
    SELECT S.STUNO, NAME, ID, HEIGHT
    FROM
        (SELECT S.*, SUBSTR(STUNO,1,2) STUNO1
        FROM STU S) S
    INNER JOIN
        (SELECT MAX(HEIGHT) MAXH, SUBSTR(STUNO,1,2) STUNO
        FROM STU
        GROUP BY SUBSTR(STUNO,1,2)) J ON J.STUNO = S.STUNO1
    WHERE S.HEIGHT = MAXH AND S.STUNO1 IN(96,97);

--7. ������ ����ӱ��� ���� ���� �а��� �а���, ��� �ӱ��� ����Ͻÿ�.
SELECT DNAME, AVG_PAY
FROM(
SELECT D.DNAME, ROUND(AVG(PAY),1) AVG_PAY 
FROM PROFESSOR P
INNER JOIN DEPARTMENT D ON D.DEPTNO = P.DEPTNO
GROUP BY D.DNAME)
WHERE AVG_PAY = (
    SELECT MAX(ROUND(AVG(PAY),1))
    FROM PROFESSOR 
    GROUP BY DEPTNO);
    
    -- �ߺ����� �ʴ� ����� ������ �ذ� �� = ROWNUM ����
    
    
    SELECT *
    FROM (SELECT* 
          FROM STU
          ORDER BY HEIGHT DESC)
    WHERE ROWNUM =1;

--8. '�ι�����'�� �Ҽӵ� �������� ����� ���Ͻÿ�.
SELECT * 
FROM PROFESSOR P
INNER JOIN DEPARTMENT D ON D.DEPTNO = P.DEPTNO
INNER JOIN DEPARTMENT D1 ON D1.DEPTNO = D.PART
INNER JOIN DEPARTMENT D2 ON D2.DEPTNO = D1.PART
WHERE D2.DNAME = '�ι�����';


--9. �� �г⺰ Ű�� ���� ū �л��� �й�, �̸�, �г�, Ű�� ���Ͻÿ�.
SELECT *
FROM STU S
INNER JOIN 
    (SELECT GRADE, MAX(HEIGHT) AS MAX_HEGHT
    FROM STU
    GROUP BY GRADE) J ON S.GRADE = J.GRADE
    WHERE S.HEIGHT = MAX_HEGHT;

SELECT *
FROM STU
WHERE (HEIGHT, GRADE) IN (
    SELECT MAX(HEIGHT) AS MAX_HEIGHT, GRADE
    FROM STU
    GROUP BY GRADE);

--10. 76��� �л����� ����(��,��) �ο����� ���Ͻÿ�.
SELECT GENDER, COUNT(GENDER)
FROM (
    SELECT CASE 
        WHEN SUBSTR(JUMIN, 7,1) IN(1,3) THEN '����'
        WHEN SUBSTR(JUMIN, 7,1) IN(2,4) THEN '����'
        END AS GENDER
    FROM STU
    WHERE TO_CHAR(BIRTHDAY, 'YY') = 76 )
GROUP BY GENDER;