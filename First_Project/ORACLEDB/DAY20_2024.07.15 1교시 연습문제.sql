SELECT * FROM STU;
SELECT * FROM PROFESSOR;
SELECT * FROM DEPARTMENT;

--1. 아이디가 7글자 이상인 학생들의 목록을 출력하시오.
SELECT *
FROM STU
WHERE LENGTH(ID) >= 7;

--2. 아이디에 a가 들어있는 학생들의 목록을 출력하시오. (like)
SELECT * 
FROM STU
WHERE ID LIKE '%a%';

--3. 전공(DEPTNO1)이 컴퓨터공학과인 학생들의 목록을 출력하시오.
SELECT *
FROM STU S
INNER JOIN DEPARTMENT D ON D.DEPTNO = S.DEPTNO1
WHERE D.DNAME = '컴퓨터공학과';

--4. 81년도에 입사한 교수들의 목록을 출력하시오.
SELECT * 
FROM PROFESSOR
WHERE TO_CHAR(HIREDATE, 'YY') = 81;

--5. 각 학년별 학생들의 평균 키를 구하시오.
SELECT ROUND(AVG(HEIGHT), 1)
FROM STU;

--6. 96학번과 97학번 중 가장 키가 큰 학생의 학번, 이름, 아이디, 키를 출력하시오.
-- (학번 : STUNO 의 첫 두글자)
SELECT STUNO, NAME, ID, HEIGHT
FROM STU
WHERE   
    SUBSTR(STUNO,1,2) IN(96,97) AND
    HEIGHT = (SELECT MAX(HEIGHT)
    FROM STU
    WHERE SUBSTR(STUNO,1,2) IN(96,97));
    
    --> 96, 97 따로 구하라는듯..? 다시 해보지 뭐
    SELECT S.STUNO, NAME, ID, HEIGHT
    FROM
        (SELECT S.*, SUBSTR(STUNO,1,2) STUNO1
        FROM STU S) S
    INNER JOIN
        (SELECT MAX(HEIGHT) MAXH, SUBSTR(STUNO,1,2) STUNO
        FROM STU
        GROUP BY SUBSTR(STUNO,1,2)) J ON J.STUNO = S.STUNO1
    WHERE S.HEIGHT = MAXH AND S.STUNO1 IN(96,97);

--7. 교수의 평균임금이 가장 높은 학과의 학과명, 평균 임금을 출력하시오.
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
    
    -- 중복되지 않는 경우의 간단한 해결 법 = ROWNUM 예시
    
    
    SELECT *
    FROM (SELECT* 
          FROM STU
          ORDER BY HEIGHT DESC)
    WHERE ROWNUM =1;

--8. '인문대학'에 소속된 교수들의 목록을 구하시오.
SELECT * 
FROM PROFESSOR P
INNER JOIN DEPARTMENT D ON D.DEPTNO = P.DEPTNO
INNER JOIN DEPARTMENT D1 ON D1.DEPTNO = D.PART
INNER JOIN DEPARTMENT D2 ON D2.DEPTNO = D1.PART
WHERE D2.DNAME = '인문대학';


--9. 각 학년별 키가 가장 큰 학생의 학번, 이름, 학년, 키를 구하시오.
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

--10. 76년생 학생들의 성별(남,여) 인원수를 구하시오.
SELECT GENDER, COUNT(GENDER)
FROM (
    SELECT CASE 
        WHEN SUBSTR(JUMIN, 7,1) IN(1,3) THEN '남자'
        WHEN SUBSTR(JUMIN, 7,1) IN(2,4) THEN '여자'
        END AS GENDER
    FROM STU
    WHERE TO_CHAR(BIRTHDAY, 'YY') = 76 )
GROUP BY GENDER;