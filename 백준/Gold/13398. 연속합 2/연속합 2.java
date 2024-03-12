import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int array[] = new int[n];
		int dp[][] = new int[n][2];

		for(int i = 0; i < n; i++)
			array[i] = Integer.parseInt(stz.nextToken());

		int max = array[0];
		dp[0][0] = array[0];
		dp[0][1] = array[0];

		for(int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i-1][0] + array[i], array[i]);
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+array[i]);
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}

		System.out.println(max);
	}

}
 