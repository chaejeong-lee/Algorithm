import java.io.*;
import java.util.*;

public class Main {
	private static int N, M, H;
	private static List<Integer>[] list;
	private static int[][] dp;
	private static final int MOD = 10007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		dp = new int[N+1][1001];
		
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreElements()) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=0;i<=N;i++) {
			dp[i][0] = 1;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=H;j++) {
				dp[i][j] += dp[i-1][j];
				for(Integer num: list[i]) {
					if(j>=num) {
						dp[i][j] += dp[i-1][j-num];
						dp[i][j] %= MOD;
					}
				}
			}
		}
		
		System.out.println(dp[N][H]);
	}

}
