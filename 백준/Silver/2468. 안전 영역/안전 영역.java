import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] checked;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int maxHeight = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(maxHeight < map[i][j])
					maxHeight = map[i][j];
			}
		}
		
		int answer = 0;
		
		for(int i=0;i<=maxHeight;i++) {
			checked = new boolean[N][N];
			int cnt = 0;
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(!checked[j][k] && map[j][k] > i) {
						if(dfs(j, k, i)) cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}

	private static boolean dfs(int r, int c, int height) {
		checked[r][c] = true;
		
		for(int d=0;d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr >=N || nc<0 || nc>=N || checked[nr][nc]) continue;
			if(map[nr][nc]>height) dfs(nr, nc, height);
		}
		return true;
	}
}