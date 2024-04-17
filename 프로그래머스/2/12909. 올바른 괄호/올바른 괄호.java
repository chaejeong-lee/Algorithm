class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        
        int cnt = 0;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(cnt <= 0 && c == ')'){
                return false;
            }
            
            if(c =='('){
                cnt++;
            }else if(c==')'){
                cnt--;
            }
        }
        if(cnt != 0) answer = false;

        return answer;
    }
}