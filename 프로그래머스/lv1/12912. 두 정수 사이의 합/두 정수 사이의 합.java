class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int s, l;
        if(a<b){
            s=a;
            l=b;
        }else{
            s=b;
            l=a;
        }
        
        for(int i=s;i<=l;i++){
            answer += i;
        }
        return answer;
    }
}