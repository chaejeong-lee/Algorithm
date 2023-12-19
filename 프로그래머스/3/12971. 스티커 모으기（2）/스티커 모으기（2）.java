class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        if(sticker.length == 1) return sticker[0];
        
        int[] dp = new int[sticker.length];
        //1. 처음 스티커 땐 경우
        dp[0] = dp[1] = sticker[0];
        
        for(int i=2;i<sticker.length-1;i++){
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }
        answer = dp[sticker.length-2];
        
        // 2. 두번째 스티커부터 땐 경우
        dp[0] = 0;
        dp[1] = sticker[1];
        
        for(int i=2;i<sticker.length;i++){
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);
        }
        
        answer = Math.max(answer, dp[sticker.length - 1]);
        
        return answer;
    }
}