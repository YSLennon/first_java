-- ���̺� ���� : UPDATE

update student
set stu_grade = 1,
    stu_class = 'C'
where stu_name = '���Ѻ�';

commit;

select *
from student;

select stu_name, stu_grade from student where stu_name = ' '

