import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int cheeseCnt;
	
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		while(isCheese()) {
			for(boolean[] arr: visited) Arrays.fill(arr, false);
			
			visited[0][0] = true;
			cheeseCnt = 0;
			
			DFS(0, 0);
			time++;
		}
		System.out.println(time);
		System.out.println(cheeseCnt);
	}

	// 치즈 존재
	private static boolean isCheese() {
		for(int i=0;i<N;i++) {	// 공기로 바꿔주기
			for(int j=0;j<M;j++) {
				if(map[i][j] == 2) {
					map[i][j] = 0;
				}
			}
		}
		
		//치즈 있는지
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 1) {
					 return true;
				}
			}
		}
		return false;
	}
	
	private static void DFS(int r, int c) {
		for(int d=0;d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isRange(nr, nc)) continue;
			
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				if(map[nr][nc] == 1) {
					map[nr][nc] = 2;
					cheeseCnt++;
				}
				else {
					DFS(nr, nc);
				}
			}
		}
	}
	
	private static boolean isRange(int r, int c) {
		return (r<0 ||c<0 || r>=N || c>=M);
	}
}