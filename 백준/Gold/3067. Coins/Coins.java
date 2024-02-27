import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
			
			M = Integer.parseInt(br.readLine());
			
			dp = new int[M+1];
			dp[0] = 1;
			
			solution();
			sb.append(dp[M]).append("\n");
		}
		System.out.print(sb);
	}

	private static void solution() {
		for(int i=0;i<N;i++){
			for(int j=arr[i];j<=M;j++) {
				if(j-arr[i]>=0) dp[j] += dp[j-arr[i]];
			}
		}
	}
}