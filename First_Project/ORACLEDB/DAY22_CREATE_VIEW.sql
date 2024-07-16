SELECT * FROM EMP;
 -- VIEW. 필요한 정보만 따로 묶어서 검색할 수 있게 만들어둔다. 
 -- 간혹 3중첩 셀프조인 등을 통한 복잡한 테이블을 뷰로 만들어두기도 함
 
CREATE OR REPLACE VIEW V_EMP 
AS
    SELECT EMPNO, ENAME, JOB, HIREDATE
    FROM EMP
    WHERE DEPTNO = 20
    WITH READ ONLY -- 기본적으로는 수정이 가능하지만 READ ONLY 옵션으로 방지가 가능하다.
;

SELECT *
FROM V_EMP;

DELETE V_EMP WHERE EMPNO = 7902;
COMMIT;