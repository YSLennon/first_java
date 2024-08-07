CREATE TABLE EMP_LOG(
    L_EMPNO NUMBER ,
    L_MGR NUMBER,
    L_SAL NUMBER,
    L_COMM NUMBER,
    L_ID VARCHAR(20),
    EVENT VARCHAR(10));
    
CREATE OR REPLACE TRIGGER TRG_EMP
    AFTER
    UPDATE OR INSERT OR DELETE ON EMP
    FOR EACH ROW
BEGIN
    IF UPDATING THEN
        INSERT INTO EMP_LOG
            VALUES (:NEW.EMPNO, :NEW.MGR, :NEW.SAL, :NEW.COMM, SYS_CONTEXT('USERENV', 'SESSION_USER'), 'U');
    ELSIF INSERTING THEN
        INSERT INTO EMP_LOG
            VALUES (:NEW.EMPNO, :NEW.MGR, :NEW.SAL, :NEW.COMM, SYS_CONTEXT('USERENV', 'SESSION_USER'), 'I');
    ELSIF DELETING THEN
        INSERT INTO EMP_LOG
            VALUES (:OLD.EMPNO, :OLD.MGR, :OLD.SAL, :OLD.COMM, SYS_CONTEXT('USERENV', 'SESSION_USER'), 'D');
    END IF;
END;
/

SELECT * FROM EMP;
SELECT * FROM EMP_LOG;
INSERT INTO EMP
    VALUES(1111,'NAME','JOB', 7369, '11/11/11', 400, 400, 10);
UPDATE EMP
    SET SAL = SAL+100
    WHERE ENAME = 'NAME';
DELETE FROM EMP
    WHERE ENAME = 'NAME';
TRUNCATE TABLE EMP_LOG;