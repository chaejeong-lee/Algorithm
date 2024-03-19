import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Problem{
		int time, point;
		
		public Problem(int time, int point) {
			this.time = time;
			this.point = point;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());	// N : 단원 개수
		int T = Integer.parseInt(st.nextToken());	// T : 문공부 가능 총 시간
		
		Problem[] problems = new Problem[N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int K = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			problems[i]= new Problem(K, S);
		}
		
		int[][] dp = new int[N+1][T+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=T;j++) {
				if(j<problems[i].time)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-problems[i].time]+problems[i].point);
			}
		}
		
		System.out.println(dp[N][T]);
	}

}