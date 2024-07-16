SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;

-- 1. BOOK 테이블에서 PRICE 가 20000 이상 출력
SELECT *
FROM BOOK
WHERE PRICE >= 20000;

-- 2. BOOK 테이블에서 BOOKNAME 컬럼에 '야구' 가 들어간 레코드 출력
SELECT *
FROM BOOK
WHERE BOOKNAME LIKE'%야구%';

-- 3. BOOK 테이블에서 PUBLISHER 컬럼이 '굿스포츠'인 데이터를 BOOKNAME 컬럼 내림차순으로 출력
SELECT *
FROM BOOK
WHERE PUBLISHER ='굿스포츠'
ORDER BY BOOKNAME DESC;

-- 4. BOOK 테이블에서 PRICE 가 5000이상 20000이하 데이터 출력
SELECT *
FROM BOOK
WHERE PRICE BETWEEN 5000 AND 20000;

-- 5. CUSTOMER 테이블에서 PHONE가 NULL이 아니고 CUSTID가 3이상인 레코드 출력
SELECT *
FROM CUSTOMER
WHERE PHONE IS NOT NULL AND CUSTID >= 3;

-- 6. 고객별 평균 주문 금액을 백원 단위로 반올림한 값을 구하시오.
SELECT NAME, ROUND(AVG(SALEPRICE),-2)
FROM ORDERS O
INNER JOIN CUSTOMER C ON C.CUSTID = O.CUSTID
GROUP BY NAME;

-- 7. 이상미디어의 고객 중에서 같은 성(姓)을 가진 사람이 몇 명이나 되는지 성별 인원수를 구하시오.
SELECT 성, COUNT(성)
FROM (
    SELECT SUBSTR(NAME,1,1) 성, NAME 이름
    FROM ORDERS O
    INNER JOIN CUSTOMER C ON C.CUSTID = O.CUSTID
    INNER JOIN BOOK B ON B.BOOKID= O.BOOKID
    WHERE PUBLISHER = '이상미디어'
    GROUP BY SUBSTR(NAME,1,1), NAME
)
GROUP BY 성;

-- 8. 이상미디어에서 2020년 7월 7일에 주문받은 도서의 주문번호, 주문일, 고객번호, 도서번호를 모두 보이시오. 단 주문일은 ‘yyyy-mm-dd 요일’ 형태로 표시한다.
SELECT ORDERID, TO_CHAR(ORDERDATE, 'YYYY-MM-DD DAY'), CUSTID, B.BOOKID, PUBLISHER
FROM ORDERS O
INNER JOIN BOOK B ON O.BOOKID = B.BOOKID
WHERE ORDERDATE= '20/07/07' AND PUBLISHER = '이상미디어';

-- 9. 이름, 전화번호가 포함된 고객목록을 보이시오. 단, 전화번호가 없는 고객은 ‘연락처없음’으로 표시하시오.
SELECT NAME, NVL(PHONE, '연락처없음')
FROM CUSTOMER;

-- 10. 고객목록에서 고객번호, 이름, 전화번호를 앞의 두 명만 보이시오.
SELECT CUSTID, NAME, PHONE
FROM CUSTOMER
WHERE ROWNUM IN(1,2);


-- 11. 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오.
SELECT ORDERID, SALEPRICE
FROM ORDERS
WHERE 
    SALEPRICE <= (
                  SELECT AVG(SALEPRICE)
                  FROM ORDERS);
                        
-- 12. ‘대한민국’에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
SELECT SUM(SALEPRICE)
FROM ORDERS O
INNER JOIN CUSTOMER C ON C.CUSTID = O.CUSTID
WHERE ADDRESS LIKE '%대한민국%';

-- 13. 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오.
SELECT ORDERID, SALEPRICE
FROM ORDERS
WHERE SALEPRICE > (
                    SELECT MAX(SALEPRICE)
                    FROM ORDERS
                    WHERE CUSTID =3);

-- 14. 이상미디어의 고객별 판매액을 보이시오(고객이름과 고객별 판매액 출력).
SELECT NAME, SUM(SALEPRICE)
FROM ORDERS O
INNER JOIN CUSTOMER C ON C.CUSTID = O.CUSTID
INNER JOIN (SELECT *
            FROM BOOK 
            WHERE PUBLISHER = '이상미디어')
            B ON B.BOOKID = O.BOOKID
GROUP BY NAME;

-- 15. 고객번호가 2 이하인 고객의 판매액을 보이시오(고객이름과 고객별 판매액 출력).
SELECT NAME, SUM(SALEPRICE)
FROM ORDERS O
INNER JOIN CUSTOMER C ON C.CUSTID = O.CUSTID
INNER JOIN BOOK B ON B.BOOKID = O.BOOKID
WHERE O.CUSTID <=2
GROUP BY NAME;

-- 16. 주소에 ‘대한민국’을 포함하는 고객들로 구성된 뷰를 만들고 조회하시오. 뷰의 이름은 vw_Customer로 설정하시오.
CREATE OR REPLACE VIEW VW_CUSTOMER
    AS SELECT *
       FROM CUSTOMER
       WHERE ADDRESS LIKE '%대한민국%';

-- 17. Orders 테이블에서 고객이름과 도서이름을 바로 확인할 수 있는 뷰를 생성한 후, ‘김연아’ 고객이 구입한 도서의 주문번호, 도서이름, 주문액을 보이시오.
CREATE OR REPLACE VIEW V_ORDERS
    AS SELECT NAME, BOOKNAME, SALEPRICE
       FROM ORDERS O
       INNER JOIN CUSTOMER C ON C.CUSTID = O.CUSTID
       INNER JOIN BOOK B ON B.BOOKID = O.BOOKID
       WITH READ ONLY;
       
SELECT * 
FROM V_ORDERS
WHERE NAME = '김연아';