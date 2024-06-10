import java.util.*;

class Solution {
    class Minerals implements Comparable<Minerals> {
        int dia, iron, stone;
        
        public Minerals (int dia, int iron, int stone){
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
        
        @Override
        public int compareTo(Minerals o){
            if(o.dia == this.dia){
                if(o.iron == this.iron){
                    return o.stone - this.stone;
                }
                return o.iron - this.iron;
            }
            return o.dia - this.dia;
        }
        
        @Override
        public String toString() {
            return "Diamonds: " + dia + ", Iron: " + iron + ", Stone: " + stone;
        }
    }
    
    public int[][] fatigue = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};    // fatigue: 피로도
    public List<Minerals> list = new ArrayList();
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int pickCnt = picks[0]+picks[1]+picks[2];   // 곡괭이 개수
        
        for(int i=0;i<minerals.length;i+=5){
            if(pickCnt == 0) break;    // 곡괭이 개수가 0개일 경우 돌아갈 수 없음
            
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            
            for(int j=i;j<i+5;j++){
                if(j==minerals.length) break;
                
                if(minerals[j].equals("diamond")){
                    diamond++;
                }
                else if(minerals[j].equals("iron")){
                    iron++;
                }else{
                    stone++;
                }
            }
            list.add(new Minerals(diamond, iron, stone));
            pickCnt--; // 한 번 작업을 완료할 때마다 곡괭이 개수 감소
        }
        
        Collections.sort(list);
        
        // fatigue 계산
        for(int i=0;i<list.size();i++){
            Minerals cur = list.get(i);
            if(picks[0]>0){
                // 다이아몬드 곡괭이가 있는 경우
                answer += (cur.dia*fatigue[0][0] + cur.iron*fatigue[0][1]+cur.stone*fatigue[0][2]);
                picks[0]--;
            }else if(picks[1]>0) {
                // 철 곡괭이 있는 경우
                answer += (cur.dia*fatigue[1][0] + cur.iron*fatigue[1][1]+cur.stone*fatigue[1][2]);
                picks[1]--;
            }else if(picks[2]>0) {
                // 돌 곡괭이 있는 경우
                answer += (cur.dia*fatigue[2][0] + cur.iron*fatigue[2][1]+cur.stone*fatigue[2][2]);
                picks[2]--;
            }
        }
        
        return answer;
    }
}