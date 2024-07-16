-- 해당 학번을 가진 학생의 이름, 학과, 학년 출력
EXECUTE STUINFO(20131001); 

CREATE OR REPLACE PROCEDURE STUINFO
    (P_STUNO IN STUDENT.STU_NO%TYPE)
IS
    P_NAME STUDENT.STU_NAME%TYPE;
    P_DEPT STUDENT.STU_DEPT%TYPE;
    P_GRADE STUDENT.STU_GRADE%TYPE;
BEGIN
    DBMS_OUTPUT.ENABLE;
    SELECT STU_NAME, STU_DEPT, STU_GRADE
    INTO P_NAME, P_DEPT, P_GRADE
    FROM STUDENT
    WHERE STU_NO = P_STUNO
    ;
    DBMS_OUTPUT.PUT_LINE('이름: ' || P_NAME ||' 학과: ' || P_DEPT||' 학년: ' || P_GRADE);
END;
/
SET SERVEROUTPUT ON;

SELECT*FROM STUDENT;