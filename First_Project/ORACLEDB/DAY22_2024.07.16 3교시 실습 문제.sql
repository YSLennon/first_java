SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;

-- 1. BOOK ���̺��� PRICE �� 20000 �̻� ���
SELECT *
FROM BOOK
WHERE PRICE >= 20000;

-- 2. BOOK ���̺��� BOOKNAME �÷��� '�߱�' �� �� ���ڵ� ���
SELECT *
FROM BOOK
WHERE BOOKNAME LIKE'%�߱�%';

-- 3. BOOK ���̺��� PUBLISHER �÷��� '�½�����'�� �����͸� BOOKNAME �÷� ������������ ���
SELECT *
FROM BOOK
WHERE PUBLISHER ='�½�����'
ORDER BY BOOKNAME DESC;

-- 4. BOOK ���̺��� PRICE �� 5000�̻� 20000���� ������ ���
SELECT *
FROM BOOK
WHERE PRICE BETWEEN 5000 AND 20000;

-- 5. CUSTOMER ���̺��� PHONE�� NULL�� �ƴϰ� CUSTID�� 3�̻��� ���ڵ� ���
SELECT *
FROM CUSTOMER
WHERE PHONE IS NOT NULL AND CUSTID >= 3;

-- 6. ���� ��� �ֹ� �ݾ��� ��� ������ �ݿø��� ���� ���Ͻÿ�.
SELECT NAME, ROUND(AVG(SALEPRICE),-2)
FROM ORDERS O
INNER JOIN CUSTOMER C ON C.CUSTID = O.CUSTID
GROUP BY NAME;

-- 7. �̻�̵���� �� �߿��� ���� ��(��)�� ���� ����� �� ���̳� �Ǵ��� ���� �ο����� ���Ͻÿ�.
SELECT ��, COUNT(��)
FROM (
    SELECT SUBSTR(NAME,1,1) ��, NAME �̸�
    FROM ORDERS O
    INNER JOIN CUSTOMER C ON C.CUSTID = O.CUSTID
    INNER JOIN BOOK B ON B.BOOKID= O.BOOKID
    WHERE PUBLISHER = '�̻�̵��'
    GROUP BY SUBSTR(NAME,1,1), NAME
)
GROUP BY ��;

-- 8. �̻�̵��� 2020�� 7�� 7�Ͽ� �ֹ����� ������ �ֹ���ȣ, �ֹ���, ����ȣ, ������ȣ�� ��� ���̽ÿ�. �� �ֹ����� ��yyyy-mm-dd ���ϡ� ���·� ǥ���Ѵ�.
SELECT ORDERID, TO_CHAR(ORDERDATE, 'YYYY-MM-DD DAY'), CUSTID, B.BOOKID, PUBLISHER
FROM ORDERS O
INNER JOIN BOOK B ON O.BOOKID = B.BOOKID
WHERE ORDERDATE= '20/07/07' AND PUBLISHER = '�̻�̵��';

-- 9. �̸�, ��ȭ��ȣ�� ���Ե� ������� ���̽ÿ�. ��, ��ȭ��ȣ�� ���� ���� ������ó���������� ǥ���Ͻÿ�.
SELECT NAME, NVL(PHONE, '����ó����')
FROM CUSTOMER;

-- 10. ����Ͽ��� ����ȣ, �̸�, ��ȭ��ȣ�� ���� �� �� ���̽ÿ�.
SELECT CUSTID, NAME, PHONE
FROM CUSTOMER
WHERE ROWNUM IN(1,2);


-- 11. ��� �ֹ��ݾ� ������ �ֹ��� ���ؼ� �ֹ���ȣ�� �ݾ��� ���̽ÿ�.
SELECT ORDERID, SALEPRICE
FROM ORDERS
WHERE 
    SALEPRICE <= (
                  SELECT AVG(SALEPRICE)
                  FROM ORDERS);
                        
-- 12. �����ѹα����� �����ϴ� ������ �Ǹ��� ������ �� �Ǹž��� ���Ͻÿ�.
SELECT SUM(SALEPRICE)
FROM ORDERS O
INNER JOIN CUSTOMER C ON C.CUSTID = O.CUSTID
WHERE ADDRESS LIKE '%���ѹα�%';

-- 13. 3�� ���� �ֹ��� ������ �ְ� �ݾ׺��� �� ��� ������ ������ �ֹ��� �ֹ���ȣ�� �ݾ��� ���̽ÿ�.
SELECT ORDERID, SALEPRICE
FROM ORDERS
WHERE SALEPRICE > (
                    SELECT MAX(SALEPRICE)
                    FROM ORDERS
                    WHERE CUSTID =3);

-- 14. �̻�̵���� ���� �Ǹž��� ���̽ÿ�(���̸��� ���� �Ǹž� ���).
SELECT NAME, SUM(SALEPRICE)
FROM ORDERS O
INNER JOIN CUSTOMER C ON C.CUSTID = O.CUSTID
INNER JOIN (SELECT *
            FROM BOOK 
            WHERE PUBLISHER = '�̻�̵��')
            B ON B.BOOKID = O.BOOKID
GROUP BY NAME;

-- 15. ����ȣ�� 2 ������ ���� �Ǹž��� ���̽ÿ�(���̸��� ���� �Ǹž� ���).
SELECT NAME, SUM(SALEPRICE)
FROM ORDERS O
INNER JOIN CUSTOMER C ON C.CUSTID = O.CUSTID
INNER JOIN BOOK B ON B.BOOKID = O.BOOKID
WHERE O.CUSTID <=2
GROUP BY NAME;

-- 16. �ּҿ� �����ѹα����� �����ϴ� ����� ������ �並 ����� ��ȸ�Ͻÿ�. ���� �̸��� vw_Customer�� �����Ͻÿ�.
CREATE OR REPLACE VIEW VW_CUSTOMER
    AS SELECT *
       FROM CUSTOMER
       WHERE ADDRESS LIKE '%���ѹα�%';

-- 17. Orders ���̺��� ���̸��� �����̸��� �ٷ� Ȯ���� �� �ִ� �並 ������ ��, ���迬�ơ� ���� ������ ������ �ֹ���ȣ, �����̸�, �ֹ����� ���̽ÿ�.
CREATE OR REPLACE VIEW V_ORDERS
    AS SELECT NAME, BOOKNAME, SALEPRICE
       FROM ORDERS O
       INNER JOIN CUSTOMER C ON C.CUSTID = O.CUSTID
       INNER JOIN BOOK B ON B.BOOKID = O.BOOKID
       WITH READ ONLY;
       
SELECT * 
FROM V_ORDERS
WHERE NAME = '�迬��';