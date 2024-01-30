import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] drinks = new int[n];
		for(int i=0;i<n;i++) {
			drinks[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n];
		dp[0] = drinks[0];
		if(n>1)dp[1] = drinks[0] + drinks[1];
		if(n>2) dp[2] = Math.max(dp[1], Math.max(drinks[1]+drinks[2], drinks[0]+drinks[2]));
		
		for(int i=3;i<n;i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + drinks[i], dp[i-3]+drinks[i-1]+ drinks[i]));
		}
		System.out.println(dp[n-1]);
	}

}
