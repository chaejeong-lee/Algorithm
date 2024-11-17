-- 분화된 연도, 분화된 연도별 대장균 크기의 변차, 대장균 개체의 ID(YEAR, YEAR_DEV, ID)
-- 분화된 연도별 대장균 크기의 편차 = 분화된 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기
-- 연도에 따른 오름차순, 대장균 크기의 오름차순
SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR
        , ((
            SELECT MAX(SIZE_OF_COLONY)
            FROM ECOLI_DATA
            WHERE YEAR(DIFFERENTIATION_DATE) = YEAR
        ) - SIZE_OF_COLONY) AS YEAR_DEV
        , ID
FROM ECOLI_DATA
ORDER BY YEAR, YEAR_DEV;