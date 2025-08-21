import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        
        String[] arr = my_string.replaceAll("[a-z]","").split("");
        // 문자열 제거한 배열 생성
        
        answer = new int[arr.length];   // 문자열 제거한 배열길이 생성  
        
        for(int i=0; i<arr.length; i++) {
        	answer[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(answer);
        
        return answer;
    }
}