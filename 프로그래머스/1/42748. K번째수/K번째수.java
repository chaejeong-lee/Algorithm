import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int tc=0;tc<commands.length;tc++){
            int[] arr = Arrays.copyOfRange(array, commands[tc][0]-1, commands[tc][1]);
            Arrays.sort(arr);
            answer[tc] = arr[commands[tc][2]-1];
        }
        
        return answer;
    }
}