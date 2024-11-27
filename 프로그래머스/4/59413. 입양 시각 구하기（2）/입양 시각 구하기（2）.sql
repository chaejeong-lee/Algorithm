-- 보호소에서는 몇시에 입양이 가장 활발하게 일어나는지
-- 0시 ~ 23시까지
-- 입양 몇건 발생했는지 조회
SET @HOUR = -1;

SELECT @HOUR := @HOUR+1 AS HOUR,
        (SELECT COUNT(*)
        FROM ANIMAL_OUTS
        WHERE HOUR(DATETIME) = @HOUR) AS COUNT
FROM ANIMAL_OUTS
WHERE @HOUR+1 < 24;