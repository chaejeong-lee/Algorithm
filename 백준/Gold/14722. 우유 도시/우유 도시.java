import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int[][][] dp;
	static int answer = 0;
	
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		dp = new int[N+1][N+1][3];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		milkSolution();
		answer = Math.max(dp[N][N][0], Math.max(dp[N][N][1], dp[N][N][2]));
		System.out.println(answer);
	}

	private static void milkSolution() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				int currentMilk = map[i][j];
				
				if(currentMilk == 0)
					dp[i][j][0] = Math.max(dp[i][j-1][2]+1, dp[i-1][j][2]+1);
				else
					dp[i][j][0] = Math.max(dp[i][j-1][0], dp[i-1][j][0]);
				
				if(currentMilk == 1 && dp[i][j][0] > dp[i][j][1]) 
					dp[i][j][1] = Math.max(dp[i][j-1][0]+1, dp[i-1][j][0]+1);
				else
					dp[i][j][1] = Math.max(dp[i][j-1][1], dp[i-1][j][1]);
				
				if(currentMilk == 2 && dp[i][j][1] > dp[i][j][2])
					dp[i][j][2] = Math.max(dp[i][j-1][1]+1, dp[i-1][j][1]+1);
				else
					dp[i][j][2] = Math.max(dp[i][j-1][2], dp[i-1][j][2]);
			}
		}
	}
}