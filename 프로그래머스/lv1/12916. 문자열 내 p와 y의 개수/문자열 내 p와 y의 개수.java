class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt=0;
        int yCnt=0;
        
        s = s.toLowerCase();//모두 소문자로 내리기
        
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(c=='p') pCnt++;
            else if(c=='y') yCnt++;
        }
        
        answer = pCnt==yCnt? true:false;
        
        return answer;
    }
}