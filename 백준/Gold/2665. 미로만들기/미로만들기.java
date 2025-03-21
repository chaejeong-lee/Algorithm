import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] map;
	static int[][] check;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		check = new int[n][n];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = str.charAt(j) - '0';//0 - 검은색 , 1 - 흰색
				check[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		
		System.out.println(check[n-1][n-1]);
	}
	
	public static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0, 0});
		check[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(!isRange(nr, nc)) continue;
				
				int dist = check[cur[0]][cur[1]];
				
				if(map[nr][nc] == 0) dist++;
				
				if(check[nr][nc] > dist) {
					check[nr][nc] = dist;
					
					if(map[nr][nc] == 1) q.addFirst(new int[] {nr, nc});
					else q.addLast(new int[] {nr, nc});
				}
			}
		}
	}
	
	public static boolean isRange(int r, int c) {
		return 0<=r && r<n && 0<=c && c<n;
	}
}
