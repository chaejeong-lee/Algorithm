class Solution {
    public long solution(long n) {
        long answer = 0;
        
        Double num = Math.sqrt(n);
        if(num == num.intValue()){
            answer =  (long)Math.pow(num+1, 2);
        }else{
            answer = -1;
        }
        
        return answer;
    }
}