-- WHERE -> LIKE

-- ID 중 a로 시작하는 글자
SELECT * FROM STU
WHERE ID LIKE 'a%';

-- ID 중 e로 끝나는 글자
SELECT * FROM STU
WHERE ID LIKE '%e';

-- ID 중 a가 포함된 글자
SELECT * FROM STU
WHERE ID LIKE '%a%';

-- ID 중 '_' 개수의 글자
SELECT * FROM STU
WHERE ID LIKE '_____';

-- ID 중 '_' 개수의 글자 + o로 끝남
SELECT * FROM STU
WHERE ID LIKE '____o';

-- LOWER CASE를 통해서 대소문자 문제 해결
SELECT * FROM STU
WHERE LOWER(ID) LIKE LOWER('%B%');

-- ESCAPE 문자는 명시를 해야 사용할 수 있다.
SELECT * FROM STU
WHERE ID LIKE '%\_%' ESCAPE '\';



