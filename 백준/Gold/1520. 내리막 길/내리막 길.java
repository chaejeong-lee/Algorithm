import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map, dp;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; 
			}
		}
		System.out.println(dfs(0, 0));
	}

	private static int dfs(int x, int y) { 
		if(x==(N-1) && y == (M-1)) return 1;
		
		if(dp[x][y] != -1) return dp[x][y];
		else {
			dp[x][y] = 0;
			for(int i=0;i<dir.length;i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				
				if(0<=nx && 0<=ny && nx<N && ny<M) {
					if(map[x][y]>map[nx][ny])
						dp[x][y] += dfs(nx, ny);
				}
			}
		}
		return dp[x][y];
	}
}
