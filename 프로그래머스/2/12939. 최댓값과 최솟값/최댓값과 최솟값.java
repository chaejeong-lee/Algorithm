import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int cnt = st.countTokens();
        for(int i=0;i<cnt;i++){
            int cur = Integer.parseInt(st.nextToken());
            if(max < cur) max = cur;
            if(min > cur) min = cur;
        }
        
        return (min+ " "+max);
    }
}