CREATE TABLE student (
  stu_no char(8)PRIMARY KEY,
  stu_name varchar(12),
  stu_dept varchar(20),
  stu_grade NUMBER ,
  stu_class char(1) ,
  stu_gender char(1) ,
  stu_height NUMBER ,
  stu_weight NUMBER
 
);

CREATE TABLE subject (
  sub_no char(3) PRIMARY KEY,
  sub_name varchar(30) ,
  sub_prof varchar(12) ,
  sub_grade NUMBER ,
  sub_dept varchar(20) 
) ;

CREATE TABLE enrol (
  sub_no char(3) REFERENCES subject(sub_no),
  stu_no char(8) REFERENCES student(stu_no),
  enr_grade NUMBER 
);
INSERT INTO STUDENT VALUES(20153075,'���Ѻ�','���',1,'C','M',177,80);
INSERT INTO STUDENT VALUES(20153088,'���¿�','���',1,'C','F',162,50);
INSERT INTO STUDENT VALUES(20143054,'������','���',2,'C','F',154,47);
INSERT INTO STUDENT VALUES(20152088,'���ο�','��������',1,'C','M',188,90);
INSERT INTO STUDENT VALUES(20142021,'�ɼ���','��������',2,'A','F',168,45);
INSERT INTO STUDENT VALUES(20132003,'����ö','��������',3,'B','M',NULL,63);
INSERT INTO STUDENT VALUES(20151062,'������','��ǻ������',1,'B','M',166,67);
INSERT INTO STUDENT VALUES(20141007,'������','��ǻ������',2,'A','M',174,64);
INSERT INTO STUDENT VALUES(20131001,'������','��ǻ������',3,'C','M',NULL,72);
INSERT INTO STUDENT VALUES(20131025,'������','��ǻ������',3,'A','F',172,63);

INSERT INTO SUBJECT VALUES('111', '�����ͺ��̽�', '���翵',2,'��ǻ������');
INSERT INTO SUBJECT VALUES('110', '�ڵ�����','������',2,'��������');
INSERT INTO SUBJECT VALUES('109', '�ڵ�ȭ����','�ڹο�',3,'���');
INSERT INTO SUBJECT VALUES('101', '��ǻ�Ͱ���','������',3,'��ǻ������');
INSERT INTO SUBJECT VALUES('102', '�����۹�','���¿�',1,'���');
INSERT INTO SUBJECT VALUES('103', '�������ڽ���','������',1,'��������');
INSERT INTO SUBJECT VALUES('104', '�ý��ۺм�����','������',3,'��ǻ������');
INSERT INTO SUBJECT VALUES('105', '����Ҽ���','���',1,'���');
INSERT INTO SUBJECT VALUES('106', '����ȸ�ν���','�ֿ���',3,'��������');
INSERT INTO SUBJECT VALUES('107', 'CAD����ǽ�','������',2,'���');
INSERT INTO SUBJECT VALUES('108', '����Ʈ�������','�ǹμ�',1,'��ǻ������');

INSERT INTO ENROL VALUES('101', '20131001', 80);
INSERT INTO ENROL VALUES('104', '20131001', 56);
INSERT INTO ENROL VALUES('106', '20132003', 72);
INSERT INTO ENROL VALUES('103', '20152088', 45);
INSERT INTO ENROL VALUES('101', '20131025', 65);
INSERT INTO ENROL VALUES('104', '20131025', 65);
INSERT INTO ENROL VALUES('108', '20151062', 81);
INSERT INTO ENROL VALUES('107', '20143054', 41);
INSERT INTO ENROL VALUES('102', '20153075', 66);
INSERT INTO ENROL VALUES('105', '20153075', 56);
INSERT INTO ENROL VALUES('102', '20153088', 61);
INSERT INTO ENROL VALUES('105', '20153088', 78);
COMMIT;