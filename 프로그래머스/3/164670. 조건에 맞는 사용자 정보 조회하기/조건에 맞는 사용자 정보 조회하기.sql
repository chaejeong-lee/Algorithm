-- 중고 거래 게시물을 3건 이상 등록한 사용자의 ID, 닉네임, 전체주소(시, 도로명 주소, 상세주소), 전화번호(XXX-XXXX-XXXX)
-- 회원 ID를 기준으로 내림차순 정렬
SELECT U.USER_ID, NICKNAME, CONCAT(CITY, " ", STREET_ADDRESS1, " ", STREET_ADDRESS2) AS "전체주소",
        CONCAT(LEFT(U.TLNO, 3), "-", MID(U.TLNO,4, 4), "-", RIGHT(U.TLNO, 4)) AS "전화번호"
FROM USED_GOODS_BOARD B
JOIN USED_GOODS_USER U
ON B.WRITER_ID = U.USER_ID
GROUP BY B.WRITER_ID
HAVING COUNT(*) >= 3
ORDER BY U.USER_ID DESC;