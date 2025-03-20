class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String[] num = phone_number.split("");
        
        int len = num.length;
        
        for(int i = 0; i < len; i++) {
            if(i < len - 4) 
                answer += "*";
            else
                answer += num[i];
        }
        
        return answer;
    }
}