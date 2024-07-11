SELECT * FROM SUBJECT;
-- 1. 김인중 학생이 들은 수업의 과목명과 교수 이름 출력

SELECT SUB_NAME, SUB_PROF
FROM STUDENT S
INNER JOIN ENROL E ON S.STU_NO= E.STU_NO
INNER JOIN SUBJECT SUB ON E.SUB_NO = SUB.SUB_NO
WHERE STU_NAME = '김인중';

-- 2. 기계공작법, 기초전자실험 수업을 듣는 학생의 학번, 이름, 수업명 출력

SELECT S.STU_NO, STU_NAME, SUB_NAME
FROM STUDENT S
INNER JOIN ENROL E ON S.STU_NO = E.STU_NO
INNER JOIN SUBJECT SUB ON SUB.SUB_NO = E.SUB_NO
WHERE SUB_NAME ='기계공작법' OR SUB_NAME= '기초전자실험';
-- WHERE SUB_NAME IN ('기계공작법','기초전자실험') -> OR의 경우 IN으로 사용할 수 있다.

-- 3. 여자이면서 구봉규 교수의 수업을 드는 학생의 학번, 이름, 학과, 수업명, 과목 점수 출력

SELECT S.STU_NO, STU_NAME, STU_DEPT, SUB_NAME, ENR_GRADE
FROM STUDENT S
INNER JOIN ENROL E ON E.STU_NO = S.STU_NO
INNER JOIN SUBJECT SUB ON SUB.SUB_NO = E.SUB_NO
WHERE SUB_PROF = '구봉규' AND STU_GENDER = 'F';

-- 4. 김인중의 평균 점수보다 낮은 점수를 받은 학생들의 이름, 과목명, 점수 출력

SELECT S.STU_NAME, SUB_NAME, ENR_GRADE
FROM STUDENT S
INNER JOIN ENROL E ON E.STU_NO = S.STU_NO
INNER JOIN SUBJECT SUB ON SUB.SUB_NO = E.SUB_NO
WHERE ENR_GRADE < (
                   SELECT AVG(ENR_GRADE) 
                   FROM ENROL E
                   INNER JOIN STUDENT S ON S.STU_NO = E.STU_NO
                  );
                    

-- 5. 2개 이상의 과목을 듣는 학생들의 목록 출력(과목명, 점수)
 -- 사실상 오답! 학생의 목록이 필요함
SELECT SUB_NAME, ENR_GRADE, STU_NAME
FROM (
      SELECT COUNT(STU_NO) AS CNT, STU_NO
      FROM ENROL
      GROUP BY STU_NO
     ) S
INNER JOIN ENROL E ON E.STU_NO = S.STU_NO
INNER JOIN SUBJECT SUB ON SUB.SUB_NO = E.SUB_NO
-- INNER JOIN STUDENT J ON J.STU_NO = S.STU_NO -> 이거만 넣으면 아래랑 같은 방식이었는데 조건을 잘 신경쓰자.. ㅋㅋ 
-- 억지로 코드를 줄이려고 노력하지 않아도 될듯?
WHERE CNT >= 2;

 -- JOIN을 이용한 방식
 
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

 
 

-- 6. 전기전자과의 평균 점수보다 높은 평균 점수를 받은 학생들의 목록 출력

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
                 WHERE STU_DEPT = '전기전자'
                );


    -- 6번 편한 방법 HAVING(그룹 함수에 대한 조건을 줄 수 있는 문법) -> WHERE의 GROUP함수 버전
    -- 그룹을 이미 지어두고 그 다음에 HAVING이 나와서 그 그룹에 대한 조건을 줄 수 있다.
SELECT AVG(ENR_GRADE), STU_NAME
FROM STUDENT S
INNER JOIN ENROL E ON S.STU_NO = E.STU_NO
GROUP BY S.STU_NO, STU_NAME
HAVING AVG(ENR_GRADE) >  (
                 SELECT  AVG(ENR_GRADE)
                 FROM STUDENT S
                 INNER JOIN ENROL E ON E.STU_NO = S.STU_NO
                 WHERE STU_DEPT = '전기전자'
                );

SELECT COUNT(*), STU_NO
FROM ENROL
GROUP BY STU_NO
HAVING COUNT(*) >= 2;

-- 학과 별 평균키가 165 이상인 학과 출력
SELECT STU_DEPT, ROUND(AVG(STU_HEIGHT),1)
FROM STUDENT
GROUP BY STU_DEPT
HAVING AVG(STU_HEIGHT) >= 165;

