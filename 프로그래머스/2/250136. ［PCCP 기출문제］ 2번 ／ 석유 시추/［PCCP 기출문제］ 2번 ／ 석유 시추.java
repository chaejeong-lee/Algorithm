import java.util.*;

class Solution {
    class Point {
        int r, c;
        
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    int n, m;       // n: 세로, m: 가로
    int[] oilRig;   // oilRig: 시추관 위치별 석유량
    
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        oilRig = new int[m];
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    bfs(land, visited, i, j);
                }
            }
        }
        
        int answer = 0;
        for(int i=0;i<m;i++){
            answer = answer<oilRig[i]?oilRig[i]:answer;
        }
        return answer;
    }
    
    public void bfs(int[][] land, boolean[][] visited, int r, int c){
        visited[r][c] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        
        boolean[] oilRigColumn = new boolean[m];
        
        int cnt = 1;
        while(!q.isEmpty()){
            Point cur = q.poll();
            oilRigColumn[cur.c] = true;
            
            for(int d = 0; d<4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                if(!isRange(nr, nc)) continue;
                
                if(land[nr][nc] == 1 && !visited[nr][nc]){
                    q.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                    cnt+=1;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            if(oilRigColumn[i]){
                oilRig[i] += cnt;
            }
        }
    }
    
    public boolean isRange(int r, int c){
        return (0<=r && 0<=c && r<n && c<m);
    }
}