import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] distance;
	private static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		distance = new int[N+1];	// i분에 달릴 수 있는 거리
		for(int i=1;i<=N;i++) {
			distance[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[N+1][M+1];		// 갈 수 있는 최대 거리
		for(int i=1;i<=N;i++) {
			solution(i, distance[i]);
		}
		System.out.println(dp[N][0]);
		
	}
	
	private static void solution(int idx, int move) {
		// idx번째에 쉬었을 경우
		dp[idx][0] = dp[idx-1][0];
		
		// idx번째에 달렸을 경우
		for(int i=1;i<=M;i++) {
			dp[idx][i] = dp[idx-1][i-1]+ move;
		}
		
		// 지침지수가 0으로 끝나는 경우의 최대값으로 저장
		for(int i=1;i<=M && idx > i;i++) {
			dp[idx][0] = Math.max(dp[idx][0], dp[idx-i][i]);
		}
	}
}