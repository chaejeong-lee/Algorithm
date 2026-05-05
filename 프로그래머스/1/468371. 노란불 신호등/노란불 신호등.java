class Solution {    
    public int solution(int[][] signals) {
        int answer = 0;
        int n = signals.length;
        int maxTime = 1;
        for(int i = 0; i<n; i++){
            int c = signals[i][0]+signals[i][1]+signals[i][2];
            maxTime = lcm(maxTime, c);
        }
        
        for(int t = 1; t<=maxTime; t++){
            boolean isAllYellow = true;
            for(int i = 0; i< n; i++){
                int g = signals[i][0];
                int y = signals[i][1];
                int r = signals[i][2];
                int C = g+y+r;
                
                int remain = (t-1) %C;
                
                if(!(g <= remain && remain < g+y)){
                    isAllYellow = false;
                    break;
                }
            }
            if(isAllYellow){
                return t;
            }
        }

        
        return -1;
    }
    
    public int lcm(int a, int b){
        return a / gcd(a,b) * b;
    }
    public int gcd(int a, int b){
        while(b>0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}