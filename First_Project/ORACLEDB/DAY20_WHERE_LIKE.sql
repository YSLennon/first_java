-- WHERE -> LIKE

-- ID �� a�� �����ϴ� ����
SELECT * FROM STU
WHERE ID LIKE 'a%';

-- ID �� e�� ������ ����
SELECT * FROM STU
WHERE ID LIKE '%e';

-- ID �� a�� ���Ե� ����
SELECT * FROM STU
WHERE ID LIKE '%a%';

-- ID �� '_' ������ ����
SELECT * FROM STU
WHERE ID LIKE '_____';

-- ID �� '_' ������ ���� + o�� ����
SELECT * FROM STU
WHERE ID LIKE '____o';

-- LOWER CASE�� ���ؼ� ��ҹ��� ���� �ذ�
SELECT * FROM STU
WHERE LOWER(ID) LIKE LOWER('%B%');

-- ESCAPE ���ڴ� ��ø� �ؾ� ����� �� �ִ�.
SELECT * FROM STU
WHERE ID LIKE '%\_%' ESCAPE '\';



