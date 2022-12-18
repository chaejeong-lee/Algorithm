class Solution {
    public String solution(String s) {
        String answer = "";
        
        if(s.length()%2==1){
            //문자열 길이가 홀수인 경우
            int num = s.length()/2;
            answer = s.substring(num, num+1);
        }else{
            int num = s.length()/2-1;
            answer = s.substring(num, num+2);
        }
        
        return answer;
    }
}