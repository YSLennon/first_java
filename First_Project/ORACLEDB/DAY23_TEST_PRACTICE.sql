--1. ������ �̿��� SELECT ��ȸ 
-- ex) STUDENT ���̺��� Ű�� 170�̻��� �л� ��ȸ

SELECT * FROM STUDENT
WHERE STU_HEIGHT >= 170;


--2. DML ��ɾ�
-- ex) 2-1) STUDENT ���̺� INSERT ������ �̿��Ͽ� ���ڵ� �߰�
--		(�ʼ� �÷� : �й�, �̸�, �а�, Ű)
--	 2-2) 2-1���� ���� �������� Ű�� 170���� ����
--	 2-3) 2-1���� ���� �����͸� �й��� �������� ����
SELECT * FROM STUDENT;

INSERT INTO STUDENT(STU_NO, STU_NAME, STU_DEPT, STU_HEIGHT)
	VALUES(12341234, '��ö��', '����', 180);
UPDATE STUDENT
	SET STU_HEIGHT = 170
	WHERE STU_NO = 12341234;
DELETE FROM STUDENT 
WHERE STU_NO = 12341234;


--3. ���� �Լ� (STU)
-- ex) ���̵��� ù 3���ڸ� *�� ǥ���ϼ���. <-- �̰ź��� ���� ������ ���·�

SELECT LPAD(SUBSTR(ID, 4), LENGTH(ID), '*' )
FROM STU;

--4. �׷� �Լ� (STUDENT)
-- ex) ��ǻ���а� �л����� ��� Ű�� ���ϰ� �Ҽ��� 1��° �ڸ����� �ݿø� �Ͻÿ�.
SELECT*FROM STUDENT;
SELECT ROUND(AVG(STU_HEIGHT),1)
FROM STUDENT
WHERE STU_DEPT = '��ǻ������';

--5. ���� - 2����
-- ex) 5-1) ������ ������ ������ ��� �л����� ����� ����Ͻÿ�. (STUDENT, ENROL, SUBJECT)
-- ex) 5-2) ����(JOB)�� SALESMAN�� ������� �޿� ��� ����� ���Ͻÿ�. (EMP, SALGRADE)

SELECT * 
FROM STUDENT S
INNER JOIN ENROL E ON E.STU_NO = S.STU_NO
INNER JOIN SUBJECT SUB ON SUB.SUB_NO = E.SUB_NO
WHERE SUB_PROF = '������';

SELECT AVG(GRADE)
FROM EMP E
INNER JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE E.JOB = 'SALESMAN';


--6. �������� (STU, DEPARTMENT)
-- ex) ����(DEPTNO1)�� �������п� ���ϴ� �л��� ���� ���Ͻÿ�.
SELECT COUNT(*)
FROM STU S
INNER JOIN DEPARTMENT D ON S.DEPTNO1 = D.DEPTNO
INNER JOIN DEPARTMENT D1 ON D.PART = D1.DEPTNO
INNER JOIN DEPARTMENT D2 ON D1.PART = D2.DEPTNO
WHERE D2.DNAME = '��������';


--7~8. �Ʒ� ���� ������ ����. ������ ������ �� ����.
-- ex) �������п��� ���� ������ �� ���� ū �޿��� ������ ����� 
--	���� ���� �޿��� ������ ����� ���� �̸�, �Ҽ� �а�, ����, �޿��� ����Ͻÿ�


	SELECT P.NAME, D.DEPTNO, POSITION, PAY
	FROM PROFESSOR P
	INNER JOIN DEPARTMENT D ON P.DEPTNO = D.DEPTNO
	INNER JOIN DEPARTMENT D1 ON D.PART = D1.DEPTNO
	INNER JOIN DEPARTMENT D2 ON D1.PART = D2.DEPTNO 
	INNER JOIN (
        SELECT MAX(PAY) MAX_PAY, MIN(PAY) MIN_PAY
        FROM PROFESSOR P
        INNER JOIN DEPARTMENT D ON P.DEPTNO = D.DEPTNO
        INNER JOIN DEPARTMENT D1 ON D.PART = D1.DEPTNO
        INNER JOIN DEPARTMENT D2 ON D1.PART = D2.DEPTNO
        WHERE D2.DNAME = '��������') ON P.PAY IN (MAX_PAY, MIN_PAY)
        ;








