-- 1. ENROL 테이블 대상 프로시저 생성
 --  학번, 과목번호, 점수를 입력받아서
 --  해당 동일한 학번과 과목번호가 존재할 경우(AND) 기존 점수에 파라미터로 보낸
 --  점수를 더해주기
 --  업데이트 행이 있으면 '저장되었습니다'
 --  없을 경우 '해당 학번이나 과목이 존재하지 않습니다' 출력

CREATE OR REPLACE PROCEDURE SET_GRADE
    (P_STU_NO IN NUMBER, 
    P_SUB_NO IN NUMBER,  
    P_ENR_GRADE IN NUMBER) 
IS
    P_COUNT NUMBER;
BEGIN
    DBMS_OUTPUT.ENABLE;
    
    UPDATE ENROL
    SET ENR_GRADE = ENR_GRADE + P_ENR_GRADE
    WHERE SUB_NO = P_SUB_NO AND STU_NO = P_STU_NO;
    
    P_COUNT := SQL%ROWCOUNT;
    
    IF P_COUNT =0 THEN
        DBMS_OUTPUT.PUT_LINE('해당 학번이나 과목이 존재하지 않습니다.');
    ELSE 
        DBMS_OUTPUT.PUT_LINE(P_COUNT ||'개 행이 저장되었습니다.');
    END IF;
    COMMIT;
END;
/

SET SERVEROUTPUT ON;
SELECT * FROM ENROL;

EXECUTE SET_GRADE(20131001, 101, 5);