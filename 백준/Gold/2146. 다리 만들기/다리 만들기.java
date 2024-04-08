import java.io.*;
import java.util.*;

public class Main {
	
	static class Point {
		int r, c;
		int len;
		
		public Point(int r, int c, int len) {
			this.r = r;
			this.c = c;
			this.len = len;
		}
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static int answer = Integer.MAX_VALUE;
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				//0: 바다, 1: 육지
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int type = 1;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 0) continue;
				if(visited[i][j]) continue;
				cntIsland(i, j, type);
				type++;
			}
		}
		
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 0) continue;
				if(visited[i][j]) continue;
				
				visited[i][j] = true;
				setBridge(i, j, map[i][j]);
			}
		}
		
		System.out.println(answer);
	}

	private static void cntIsland(int r, int c, int type) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		
		visited[r][c] = true;
		map[r][c] = type;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int d = 0; d<4 ; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr<0 || nc<0 || nr >=N || nc>=N) continue;
				if(map[nr][nc] == 0 || visited[nr][nc]) continue;
				
				q.add(new Point(nr, nc));
				visited[nr][nc] = true;
				map[nr][nc] = type;
			}
		}
	}
	
	// 다리 세우기
	private static void setBridge(int r, int c, int type) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, 0));
		
		boolean[][] curVisited = new boolean[N][N];
		curVisited[r][c] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int d = 0 ; d<4;d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				if(map[nr][nc] == type) {
					curVisited[nr][nc] = true;
					continue;
				}
				if(curVisited[nr][nc]) continue;
				
				if(map[nr][nc] == 0) {
					q.add(new Point(nr, nc, cur.len+1));
					curVisited[nr][nc] = true;
				}
				else if(map[nr][nc] != type) {
					answer = Math.min(answer, cur.len);
					return;
				}
			}
		}
	}
}