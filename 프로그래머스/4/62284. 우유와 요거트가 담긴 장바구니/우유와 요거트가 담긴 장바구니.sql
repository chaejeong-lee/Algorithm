-- 우유(Milk)와 요거트(Yogurt)를 동시에 구입한 장바구니 구하기
-- 구입한 장바구니의 아이디 조회
-- 아이디 순으로 
WITH M AS (
    SELECT CART_ID, NAME
    FROM CART_PRODUCTS
    WHERE NAME = 'Milk'
),
    Y AS (
    SELECT CART_ID, NAME
    FROM CART_PRODUCTS
    WHERE NAME = 'Yogurt'
)

SELECT M.CART_ID
FROM M
JOIN Y
ON M.CART_ID = Y.CART_ID
ORDER BY M.CART_ID;