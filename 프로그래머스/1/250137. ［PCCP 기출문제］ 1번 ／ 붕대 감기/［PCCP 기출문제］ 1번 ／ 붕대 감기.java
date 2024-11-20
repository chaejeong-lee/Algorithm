class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int time = 0;
        int idx = 0;
        int continueCnt = 0;
        
        while(true) {
            time++;
            // 1. 먼저 attacks한 시간이랑 일치하는 지 체크
            if(time == attacks[idx][0]) {
                // 피 깎고, 연속성 제거
                answer -= attacks[idx][1];
                idx++;
                continueCnt = 0;
                if(answer <= 0) return -1;
            } 
            else {
                // 2. 피가 가득 찼는지 확인
                // 3. 아닐 경우 +1 증가, 연속성 증가
                if(answer < health) {
                    answer += bandage[1];
                    if(answer > health) answer = health;
                }
                continueCnt++;
                // 4. 연속성이 bandage[0]이랑 같으면 추가 회복량하기, 시전 시간 증가
                if(continueCnt == bandage[0]) {
                    answer += bandage[2];
                    if(answer >= health) answer = health;
                    continueCnt = 0;
                }
                
            }
            
            if(time == attacks[attacks.length-1][0]) break;
        }
        
        return answer;
    }
}