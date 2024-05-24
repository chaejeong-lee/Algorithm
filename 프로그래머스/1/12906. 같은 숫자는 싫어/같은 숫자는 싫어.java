import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i] != arr[i-1]){
                q.add(arr[i]);
            }
        }
        
        int size = q.size();
        int[] answer = new int[size];
        for(int i=0;i<size;i++){
            answer[i] = q.poll();
        }

        return answer;
    }
}