import java.io.*;
import java.util.*;

public class Main {
	
	static class Counsultation {
		int day, t, p;
		
		public Counsultation(int day, int t, int p) {
			this.day = day;
			this.t = t;
			this.p = p;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Counsultation> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			if(i + T > N) continue;
			
			list.add(new Counsultation(i+1, T, P));
		}
		
		int[] dp = new int[N+2];
		
		for(int i=0;i<list.size();i++) {
			Counsultation cur = list.get(i);
			
			for(int j=1;j<=cur.day;j++) {
				dp[cur.day] = Math.max(dp[cur.day], dp[j]);
			}
			
			int nextDay = cur.day + cur.t;
			dp[nextDay] = Math.max(dp[nextDay], dp[cur.day]+cur.p);
		}
		
		int answer = 0;
		for(int i=0;i<dp.length;i++) {
			answer = Math.max(dp[i], answer);
		}
		System.out.println(answer);
	}

}
