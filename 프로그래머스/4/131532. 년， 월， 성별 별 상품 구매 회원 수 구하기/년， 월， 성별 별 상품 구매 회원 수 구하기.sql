-- 년, 월, 성별 별로 상품을 구매한 회원수를 집계
-- 년, 월, 성별을 기준 오름차순
-- 성별 정보 x -> 결과 제외
SELECT YEAR(OS.SALES_DATE) AS YEAR, MONTH(OS.SALES_DATE) AS MONTH, UI.GENDER, COUNT(DISTINCT OS.USER_ID) AS USERS
FROM ONLINE_SALE OS
JOIN USER_INFO UI
ON OS.USER_ID = UI.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER;