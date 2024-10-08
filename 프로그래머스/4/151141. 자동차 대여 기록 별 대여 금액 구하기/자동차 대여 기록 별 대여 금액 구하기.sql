-- 코드를 입력하세요
WITH A AS (SELECT H.HISTORY_ID, C.DAILY_FEE, C.CAR_TYPE, DATEDIFF(H.END_DATE, H.START_DATE)+1 AS RENTAL_DATE,
                    CASE
                        WHEN DATEDIFF(H.END_DATE, H.START_DATE)+1 >= 90 THEN '90일 이상'
                        WHEN DATEDIFF(H.END_DATE, H.START_DATE)+1 >= 30 THEN '30일 이상'
                        WHEN DATEDIFF(H.END_DATE, H.START_DATE)+1 >= 7 THEN '7일 이상'
                        ELSE '7일 이하'
                    END RENTAL_TYPE
          FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
          JOIN CAR_RENTAL_COMPANY_CAR C
          ON H.CAR_ID = C.CAR_ID
          WHERE C.CAR_TYPE = '트럭')

SELECT A.HISTORY_ID, 
        ROUND(A.DAILY_FEE * A.RENTAL_DATE * (100 - IFNULL(P.DISCOUNT_RATE, 0))* 0.01) AS FEE
FROM A
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
ON A.RENTAL_TYPE = P.DURATION_TYPE
    AND A.CAR_TYPE = P.CAR_TYPE
ORDER BY FEE DESC, A.HISTORY_ID DESC;