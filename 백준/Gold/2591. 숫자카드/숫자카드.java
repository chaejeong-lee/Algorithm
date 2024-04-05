import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		int N = arr.length;
		
		int[][] dp = new int[41][3];
		// dp[n][l] = n번째 수에서 마지막 수가 l일 때의 경우의 수 l = 1(일의 자리), 2(십의 자리)
		int prev = (arr[0]-'0')*10;
		
		dp[1][1] = 1;
		
		for(int i=2;i<=N;i++) {
			int cur = arr[i-1]-'0';
			if(cur == 0) {
				if(prev + cur <= 34)
					dp[i][2] = dp[i-1][1];
				continue;
			}
			
			if(prev + cur <= 34) {
				dp[i][1] = dp[i-1][2] + dp[i-1][1];
				dp[i][2] = dp[i-1][1];
			}
			else {
				//34보다 크면 십의 자리 X
				dp[i][1] = dp[i-1][1] + dp[i-1][2];
			}
			prev = cur * 10;
		}
		System.out.println(dp[N][1] + dp[N][2]);
	}

}