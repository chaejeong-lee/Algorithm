import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final int MOD = 10_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N+1][10];
		
		for(int i=0;i<10;i++) {
			dp[0][i] = 1;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<10;j++) {
				for(int k=j;k<10;k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= MOD;
				}
			}
		}
		
		System.out.println(dp[N][0]);
		
	}

}