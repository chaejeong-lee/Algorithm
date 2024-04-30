import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, P;
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // N: 저장된 노래의 개수
		M = Integer.parseInt(st.nextToken()); // M: 같은 노래를 추가하려면 두 노래 사이에 존재해야 하는 노래 개수
		P = Integer.parseInt(st.nextToken()); // P: 오늘 들으려고 하는 노래 개수

		long answer = 0;
		long[][] dp = new long[P + 1][N + 1];

		dp[0][0] = 1;

		for (int i = 1; i <= P; i++) {
			for (int j = 1; j <= N; j++) {
				// 플레이 리스트에 넣지 않은 음악
				dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * (N - j + 1)) % MOD;

				// 플레이리스트에 넣은 음악(m개의 간격 두기)
				if (j > M) {
					dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - M)) % MOD;
				}
			}
		}

		answer = dp[P][N];
		System.out.println(answer);
	}

}