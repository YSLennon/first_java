SELECT * FROM EMP;
 -- VIEW. �ʿ��� ������ ���� ��� �˻��� �� �ְ� �����д�. 
 -- ��Ȥ 3��ø �������� ���� ���� ������ ���̺��� ��� �����α⵵ ��
 
CREATE OR REPLACE VIEW V_EMP 
AS
    SELECT EMPNO, ENAME, JOB, HIREDATE
    FROM EMP
    WHERE DEPTNO = 20
    WITH READ ONLY -- �⺻�����δ� ������ ���������� READ ONLY �ɼ����� ������ �����ϴ�.
;

SELECT *
FROM V_EMP;

DELETE V_EMP WHERE EMPNO = 7902;
COMMIT;