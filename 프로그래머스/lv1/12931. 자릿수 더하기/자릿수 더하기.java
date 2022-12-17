import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = n;
        
        while(num!=0){
            answer += num%10;
            num /= 10;
        }

        return answer;
    }
}