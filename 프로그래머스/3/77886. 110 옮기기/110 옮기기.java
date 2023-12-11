import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i=0;i<s.length;i++){
            // 1. stack 만들기
            Stack<Character> stk = new Stack<>();
            int cnt = 0;
            
            // 2. 110을 제외하고 다 스택에 넣기
            for(int j=0;j<s[i].length();j++){
                char c1 = s[i].charAt(j);
                if(stk.size() > 1){
                    char c2 = stk.pop();
                    char c3 = stk.pop();
                    // 110인지?
                    if(c3 == '1' && c2 == '1' && c1 == '0'){
                        cnt++;
                    }
                    else{
                        stk.push(c3);
                        stk.push(c2);
                        stk.push(c1);
                    }
                }
                else{
                    stk.push(c1);
                }
            }
            
            // 2. 마지막 0의 위치 찾기
            int idx = stk.size();
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            
            while(!stk.isEmpty()){
                if(!flag){
                    if(stk.peek() == '1'){
                        idx--;
                    }else{
                        flag = true;
                    }
                }
                sb.insert(0, stk.pop());
            }
            
            // 3. 문자에 110이 있는 경우 -> 뒤에 cnt 개수 만큼 110 붙이기
            //                없는 경우 -> 원본 그대로
            if(cnt <= 0){
                answer[i] = s[i];
            }
            else{
                while(cnt-- > 0){
                    sb.insert(idx, "110");
                    idx += 3;
                }
                answer[i] = sb.toString();
            }
            
        }
        
        return answer;
    }
}