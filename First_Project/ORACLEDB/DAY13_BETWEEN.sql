-- �˻�(TABLE DATA SEARCH)
select * 
from t_emp;

select *
from t_emp
where hobby = '���' and emp_type = '������';

select * 
from t_emp
where PAY >= 35000000;

select *
from t_emp
where deptno = '1001' or emp_type ='�����';

select *
from t_emp
where position is null;

select *
from t_emp
where pay between 25000000 and 35000000;


