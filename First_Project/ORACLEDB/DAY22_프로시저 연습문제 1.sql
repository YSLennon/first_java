-- 1. ENROL ���̺� ��� ���ν��� ����
 --  �й�, �����ȣ, ������ �Է¹޾Ƽ�
 --  �ش� ������ �й��� �����ȣ�� ������ ���(AND) ���� ������ �Ķ���ͷ� ����
 --  ������ �����ֱ�
 --  ������Ʈ ���� ������ '����Ǿ����ϴ�'
 --  ���� ��� '�ش� �й��̳� ������ �������� �ʽ��ϴ�' ���

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
        DBMS_OUTPUT.PUT_LINE('�ش� �й��̳� ������ �������� �ʽ��ϴ�.');
    ELSE 
        DBMS_OUTPUT.PUT_LINE(P_COUNT ||'�� ���� ����Ǿ����ϴ�.');
    END IF;
    COMMIT;
END;
/

SET SERVEROUTPUT ON;
SELECT * FROM ENROL;

EXECUTE SET_GRADE(20131001, 101, 5);