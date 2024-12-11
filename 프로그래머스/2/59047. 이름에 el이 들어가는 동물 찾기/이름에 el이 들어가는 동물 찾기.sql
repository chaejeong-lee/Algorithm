-- 개 이름에 el이 들어감
-- 이름 순으로 조회, 대소문자 구분 x
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE 1 = 1
    AND UPPER(NAME) LIKE '%EL%'
    AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME;