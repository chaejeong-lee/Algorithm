import java.util.*;

class Solution {
    public double solution(int[] arr) {
        double answer = Arrays.stream(arr).sum()/ (double)arr.length;
        return answer;
    }
}