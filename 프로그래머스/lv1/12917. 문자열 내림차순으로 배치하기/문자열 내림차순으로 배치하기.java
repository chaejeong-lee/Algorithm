import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] arr = new char[s.length()];
        for(int i=0;i<arr.length;i++){
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length;i++){
            answer += arr[arr.length-i-1];
        }
        
        return answer;
    }
}