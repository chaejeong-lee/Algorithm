import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        
        long total = 1;
        for(int i=1;i<=n;i++) {
            list.add(i);
            total *= i;
        }
        
        k--;
        
        int idx= 0;
        while(idx < n) {
            total /= n - idx; // 전체 경우의 수 / 숫자의 개수
            answer[idx++] = list.remove((int) (k/total));
            k %= total; // 다음 찾아야 할 번호
        }
        
        return answer;
    }
}