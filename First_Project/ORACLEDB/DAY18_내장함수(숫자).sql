-- 내장 함수 (숫자)

SELECT ROUND(190.456, 2) -- 2번째 자리 이후 반올림
FROM DUAL;

SELECT TRUNC(190.456, 2)  -- 2번째 자리 이후 내림
FROM DUAL;

SELECT CEIL(190.456) -- 정수를 기준으로 올림
FROM DUAL;

SELECT FLOOR(123.999) -- 정수를 기준으로 내림
FROM DUAL;

SELECT SQRT(16) -- 제곱근
FROM DUAL;

SELECT POWER(2,3) -- 2의 3제곱
FROM DUAL;

SELECT ABS(-123) -- 절대 값 (ABSOLUTE)
FROM DUAL;

SELECT SIGN(-123) -- 음수일 때 -1, 양수일 때 1, 0 이면 0
FROM DUAL;

SELECT MOD(10,3) -- 나머지 연산 %
FROM DUAL;