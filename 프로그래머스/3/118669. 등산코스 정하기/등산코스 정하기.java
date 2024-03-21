import java.util.*;
import java.io.*;

class Solution {
    
    class Point{
        int to, cost;
        public Point(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    
    public ArrayList<Point>[] list;
    public final int INF = Integer.MAX_VALUE;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // n: 지점수
        // paths: 각 등산로 정보
        // gates: 출입구들 번호
        // summits: 산봉오리들 번호
        // 결론적으로 [산봉우리의 번호, intensity의 최솟값]
        list = new ArrayList[n+1];
        
        // 배열 초기화
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        
        // 배열에 path 넣기
        for(int i=0;i<paths.length;i++){
            int start = paths[i][0];
            int end = paths[i][1];
            int cost = paths[i][2];
            //1. 출입구이거나 봉우리이면 단방향
            if(isGatesOrSummits(start, gates) || isGatesOrSummits(end, summits)){
                list[start].add(new Point(end, cost));
            }else if(isGatesOrSummits(end, gates) || isGatesOrSummits(start, summits)){
                list[end].add(new Point(start, cost));
            }else{
                // 2. 아닐 경우는 다 양방향
                list[start].add(new Point(end, cost));
                list[end].add(new Point(start, cost));
            }
        }
        
        int[] answer = dijkstra(n, gates, summits);
        return answer;
    }
    
    
    public int[] dijkstra(int n, int[] gates, int[] summits){
        Queue<Point> q = new LinkedList<>();
        int[] intensity = new int[n+1];
        
        //다익스트라니까 배열에 INF값 넣어주기
        Arrays.fill(intensity, INF);
        
        // 모든 시작점을 넣어주기
        for(int num:gates){
            q.add(new Point(num, 0));
            intensity[num] = 0;
        }
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            
            // 현재 가중치가 저장된 가중치보다 커서 최소 갱신이 되지 않을 때 스킵
            
            
            for(int i=0;i<list[cur.to].size();i++){
                Point nPoint = list[cur.to].get(i);
                
                int dis = Math.max(intensity[cur.to], nPoint.cost);
                if(intensity[nPoint.to] > dis){
                    intensity[nPoint.to] = dis;
                    q.add(new Point(nPoint.to, dis));
                }
            }
        }
        
        int mSummitsNum = Integer.MAX_VALUE;// 산봉우리 번호
        int mSummitsCost = Integer.MAX_VALUE;// 최소값
        
        Arrays.sort(summits);
        
        for(int summit: summits){
            if(intensity[summit] < mSummitsCost){
                mSummitsNum = summit;
                mSummitsCost = intensity[summit];
            }
        }
        return new int[]{mSummitsNum, mSummitsCost};
    }
    
    // 시작점인지 봉우리인지 확인하는 함수
    public boolean isGatesOrSummits(int a, int[] arr){
        for(int num: arr){
            if(num == a) return true;
        }
        return false;
    }
}