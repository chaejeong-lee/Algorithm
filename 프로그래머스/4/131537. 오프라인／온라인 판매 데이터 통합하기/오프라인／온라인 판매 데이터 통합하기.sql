-- 2022년 3월의 상품
-- offline_sale 테이블의 판매 데이터의 user_id 값은 null로 표시
-- 판매일 기준 오름차순 정렬, 상품id 기준 오름차순, 유저id 기준 오름차순
(
    SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") 'SALES_DATE',
            PRODUCT_ID,
            USER_ID,
            SALES_AMOUNT
    FROM ONLINE_SALE
    WHERE MONTH(SALES_DATE) = 3
    
    UNION
    
    SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") 'SALES_DATE',
            PRODUCT_ID,
            NULL AS USER_ID,
            SALES_AMOUNT
    FROM OFFLINE_SALE 
    WHERE MONTH(SALES_DATE) = 3
)
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;