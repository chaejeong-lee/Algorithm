class Solution {
    public int solution(int n, int k) {//n: 양꼬치, k: 음료수
        int answer = 0;
        
        answer = n*12000 + k*2000 - (n/10)*2000;
        
        return answer;
    }
}