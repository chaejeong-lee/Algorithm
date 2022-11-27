class Solution {
    String[] can_speak = {"aya", "ye", "woo", "ma"};
    String[] ban_speak = {"ayaaya", "yeye", "woowoo", "mama"};//최대 한번씩 사용해 조합한 발음밖에 하지 못하기 때문에
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String str:babbling){
            String tempStr = str;
            
            for(String ban:ban_speak){
                tempStr = tempStr.replace(ban,"z");
            }
            
            for(String speak : can_speak){
                tempStr = tempStr.replace(speak,"?");
            }
                
            int sign=0;
            for(int i=0; i<tempStr.length();i++){
                if(!tempStr.subSequence(i, i+1).equals("?")){
                    sign = 1;
                    break;
                }
            }
            
            if(sign==0) answer++;
        }
        
        return answer;
    }
}