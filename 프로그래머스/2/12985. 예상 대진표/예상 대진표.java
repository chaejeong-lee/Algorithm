class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        // a와 b가 다르면 반복
        while (a != b) {
            // a와 b를 각각 2로 나눈 몫과 나머지와 더함
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;

            // answer 증가(라운드 증가)
            answer++;
        }

        return answer;
    }
}