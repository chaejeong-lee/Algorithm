import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        
        for(int i=0;i<queue1.length;i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }        
        for(int i=0;i<queue2.length;i++) {
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        int answer = 0;
        while(true) {
            if(sum1 == sum2) {
                break;
            }
            else if(answer >= (queue1.length * 4)) {
                return -1;
            }
            else if(sum1 < sum2) {
                int cur = q2.poll();
                q1.add(cur);
                sum2 -= cur;
                sum1 += cur;
            }
            else if(sum1 > sum2) {
                int cur = q1.poll();
                q2.add(cur);
                sum1 -= cur;
                sum2 += cur;
            }
            answer++;
        }
        return answer;
    }
}