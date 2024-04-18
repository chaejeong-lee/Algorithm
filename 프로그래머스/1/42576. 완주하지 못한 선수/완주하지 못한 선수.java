import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0;i<participant.length;i++){
            if(hm.containsKey(participant[i])){
                hm.put(participant[i], hm.get(participant[i])+1);
            }else{
                hm.put(participant[i], 1);
            }
        }
        
        for(int i=0;i<completion.length;i++){
            hm.put(completion[i], hm.get(completion[i])-1);
        }
        
        String answer = "";
        
        for(int i=0;i<hm.size();i++){
            if(hm.get(participant[i]) != 0){
                answer = participant[i];
                break;
            }
        }
        
        return answer;
    }
}