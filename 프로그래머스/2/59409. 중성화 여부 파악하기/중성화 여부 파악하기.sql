-- 보호소의 동물이 중성화되었는지 아닌지 판단
-- 중성화된 동물은 SEX_UPON_INTAKE 컬럼에 'Neutered' 또는 'Spayed'가 들어있음
-- 아이디, 이름, 중성화 여부
-- 아이디 순으로 조회
-- 중성화 되어있다면 'O' 아니라면 'X'
SELECT ANIMAL_ID, 
        NAME, 
        CASE 
            WHEN SEX_UPON_INTAKE LIKE 'Neutered%' OR SEX_UPON_INTAKE LIKE 'Spayed%' THEN 'O' 
            ELSE 'X'
        END AS '중성화'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;