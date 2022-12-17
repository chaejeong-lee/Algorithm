class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n);
        int[] answer = new int[s.length()];
        
        for(int i=0;i<answer.length;i++){
            answer[answer.length-i-1] = Integer.parseInt(s.substring(i, i+1));
        }
        
        return answer;
    }
}