import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int i;
		for(i = 0;isCheese();i++) {
			
			for(boolean[] arr : visited) {
				Arrays.fill(arr, false);
			}
			
			visited[0][0] = true;
			answer = 0;
			dfs(0, 0);
		}
		
		System.out.println(i+"\n"+answer);
	}
	
	private static void dfs(int r, int c) {
		for(int i=0;i<4;i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(nr<0 || nc<0 || nr>=R || nc >= C) {
				continue;
			}
			
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				if(map[nr][nc]==1) {
					map[nr][nc] = 2;
					answer++;
				}else {
					dfs(nr, nc);
				}
			}
		}
	}

	private static boolean isCheese() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] == 2) {
					map[i][j] = 0;
				}
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}
}
