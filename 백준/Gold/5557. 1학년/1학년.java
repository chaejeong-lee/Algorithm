import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		long[][] dp = new long[N-1][21];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][nums[0]] = 1;
		for(int i=1; i<N-1;i++) {
			for(int j=0;j<=20;j++) {
				if(dp[i-1][j] > 0) {
					int plus = j + nums[i];
					if(0<=plus && plus <=20) {
						dp[i][plus] += dp[i-1][j];
					}
					
					int minus = j - nums[i];
					if(0<=minus && minus <=20) {
						dp[i][minus] += dp[i-1][j];
					}
				}
			}
		}
		
		System.out.println(dp[N-2][nums[N-1]]);
	}

}
