class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        int[] cnt = new int[1001];
        
        for(int i=0;i<array.length;i++){
            cnt[array[i]]++;
        }
        
        int max = 0;
        int max_idx = 0;
        
        for(int j=0;j<cnt.length;j++){
            if(cnt[j]>max){
                max = cnt[j];
                max_idx = j;
            }    
        }
        
        int count = 0;
        for(int i=0;i<cnt.length;i++){
            if(cnt[i] == max) count++;
        }
        
        if(count > 1) return -1;
        answer = max_idx;
        return answer;
    }
}