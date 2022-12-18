class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum=0;
        int check = x;//x의 값이 0이 될때까지 자릿수의 합을 구하기 위해
        while(check != 0){
            sum += check%10;
            check /= 10;
        }
        
        if(x%sum!=0) answer = false;
        return answer;
    }
}