-- 각 세대별 자식이 없는 개체의 수(count)와 세대(generation)
-- 세대에 대해 오름차순 정렬
-- 모든 세대에는 자식이 없는 개체가 적어도 1개체는 존재
WITH RECURSIVE CTE AS (
    SELECT ID, PARENT_ID, 1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT ED.ID, ED.PARENT_ID, CTE.GENERATION + 1 AS GENERATION
    FROM ECOLI_DATA ED
    JOIN CTE
    ON ED.PARENT_ID = CTE.ID
) 
SELECT COUNT(*) AS COUNT, GENERATION
FROM CTE
LEFT OUTER JOIN ECOLI_DATA ED
ON CTE.ID = ED.PARENT_ID
WHERE ED.ID IS NULL
GROUP BY GENERATION
ORDER BY GENERATION;