SELECT * FROM STU;
SELECT * FROM PROFESSOR;
SELECT * FROM DEPARTMENT;

 -- 1. 교수번호가 1003번인 사람의 학과에 속한 학생들의 학번, 이름, 학년 출력
 SELECT STUNO, S.NAME, GRADE
 FROM STU S
 INNER JOIN PROFESSOR P ON S.DEPTNO1 = P.DEPTNO
 WHERE P.PROFNO=1003;
 
-- 2. PROFESSOR 테이블에서 400이상의 급여를 받으면 A, 
    --300~400 사이면 B, 나머지는 C로 출력
SELECT NAME, PAY, CASE WHEN PAY >= 400 THEN 'A'
                    WHEN PAY BETWEEN 300 AND 400 THEN 'B'
                    ELSE 'C'
                  END
FROM PROFESSOR
ORDER BY PAY DESC;
        
-- 3. PROFESSOR 테이블에서 id의 앞에 3글자를 *로 표기(이미지 카페 참고)
SELECT NAME, LPAD(SUBSTR(ID,4),LENGTH(ID),'*')
FROM PROFESSOR;

-- 4. PROFESSOR 테이블에서 직급(POSITION)별 
--    가장 큰 급여를 받는 사람의 이름, 급여, 직급 출력
SELECT NAME, P.PAY, P.POSITION
FROM PROFESSOR P
INNER JOIN (SELECT MAX(PAY) AS PAY, POSITION
            FROM PROFESSOR
            GROUP BY POSITION) J ON P.POSITION = J.POSITION
WHERE P.PAY = J.PAY AND P.POSITION = J.POSITION;

-- 이런식으로도 할 수 있음! JOIN할때 이미 조건분기로 완성해보자
SELECT NAME, P.PAY, P.POSITION
FROM PROFESSOR P
INNER JOIN (SELECT MAX(PAY) AS PAY, POSITION
            FROM PROFESSOR
            GROUP BY POSITION) J ON P.PAY = J.PAY AND P.POSITION = J.POSITION;

        
-- 5. 학생들이 가장 많이 태어난 달 찾기(2개 이상이 같은 경우 레코드 2개 출력)
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
                            