-- 2022년 3월의 오프라인/온라인 상품 판매 데이터의 판매 날짜, 상품 id, 유저id, 판매량
-- offline_sale 테이블의 판매 데이터의 user_id 값은 null로 표시
-- 판매일 기준으로 오름차순, 상품 id 오름차순, 상품 id 오름차순, 유저 id

(
    -- 2022년 3월 ONLINE_SALE 테이블 판매 데이터 조회
    SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
    FROM ONLINE_SALE
    WHERE SALES_DATE LIKE "2022-03%"
    
    UNION
    
    -- 2022년 3월 OFFLINE_SALE 테이블 판매 데이터 조회
    SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
    FROM OFFLINE_SALE
    WHERE SALES_DATE LIKE "2022-03%"
)
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;