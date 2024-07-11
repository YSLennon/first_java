-- 검색(TABLE DATA SEARCH)
select * 
from t_emp;

select *
from t_emp
where hobby = '등산' and emp_type = '정규직';

select * 
from t_emp
where PAY >= 35000000;

select *
from t_emp
where deptno = '1001' or emp_type ='계약직';

select *
from t_emp
where position is null;

select *
from t_emp
where pay between 25000000 and 35000000;


