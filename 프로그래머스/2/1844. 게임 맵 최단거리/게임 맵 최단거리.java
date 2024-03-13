import java.util.*;
import java.io.*;

class Solution {
    int N, M;
    int[][] visited;
    
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;
        
        visited = new int[N][M];
        
        bfs(maps);
        answer = visited[N-1][M-1];
        if(answer == 0) answer = -1;
        return answer;
    }
    
    public void bfs(int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            
            for(int d=0;d<4;d++){
                int nr = curR + dr[d];
                int nc = curC + dc[d];
                
                if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                if(visited[nr][nc] != 0 || maps[nr][nc] == 0) continue;
                
                visited[nr][nc] = visited[curR][curC]+1;
                q.add(new int[]{nr, nc});
            }
        }
        
    }
}