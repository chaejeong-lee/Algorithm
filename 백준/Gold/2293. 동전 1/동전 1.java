import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());//동전 종류
		int k = Integer.parseInt(st.nextToken());//가치의 합이 해당 원이 되도록
		
		int[] nums = new int[n+1];
		int[] dp = new int[k+1];
		
		dp[0] = 1;
		for(int i=1;i<=n;i++) {
			nums[i] = Integer.parseInt(br.readLine());
			for(int j=nums[i];j<=k;j++) {
				dp[j] += dp[j-nums[i]];
			}
		}
		System.out.println(dp[k]);
	}
}
