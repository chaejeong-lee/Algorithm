-- 2022년 한해 평가 점수가 가장 높은 사원 정보 조회
-- 2022년도 평가 점수가 가장 높은 사원들의 점수, 사번, 성명, 직책, 이메일
-- 2022년도의 평가 점수 = 상 + 하반기 점수의 합 => score
select SUM(HG.SCORE) AS SCORE, HG.EMP_NO, HE.EMP_NAME, HE.POSITION, HE.EMAIL
from HR_EMPLOYEES HE
JOIN HR_GRADE HG
ON HE.EMP_NO = HG.EMP_NO
GROUP BY HG.YEAR, HE.EMP_NO
HAVING HG.YEAR = 2022
ORDER BY SCORE DESC
LIMIT 1;