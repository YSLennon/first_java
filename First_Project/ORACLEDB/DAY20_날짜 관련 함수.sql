-- ��¥ ���� �Լ�

-- SYSDATE : �������� ��¥ ��� -> MYSQL�� NOW�� �����.
    -- �ð� ������ ��������� ����Ҷ��� ��¥�� ���´�.
SELECT SYSDATE
FROM DUAL;

SELECT 
    SYSDATE,
    TO_CHAR(SYSDATE, 'YYMMDD') AS CASE1,
    TO_CHAR(SYSDATE, 'YYYYMMDD') AS CASE2,
    TO_CHAR(SYSDATE, 'YYYY-MM-DD') AS CASE3,
    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS') AS CASE4,
    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS PM') AS CASE5 -- 24�ð�ǥ���, AM PM ǥ��
    FROM DUAL;
