class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0]=-1;//맨 앞글자이기 때문에
        for(int i=1;i<s.length();i++){
            answer[i] = -1;
            for(int j=0;j<i;j++){
                if(s.charAt(i)==s.charAt(j)){
                    answer[i]=i-j;
                }
            }
        }
        return answer;
    }
}