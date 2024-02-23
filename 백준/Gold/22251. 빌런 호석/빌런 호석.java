import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int N, K, P, X;
	private static int result = 0;
	private static int[][] nums = { {0, 4, 3, 3, 4, 3, 2, 3, 1, 2}, 	// 0
									{4, 0, 5, 3, 2, 5, 6, 1, 5, 4},		// 1
									{3, 5, 0, 2, 5, 4, 3, 4, 2, 3},		// 2
									{3, 3, 2, 0, 3, 2, 3, 2, 2, 1},		// 3
									{4, 2, 5, 3, 0, 3, 4, 3, 3, 2},		// 4
									{3, 5, 4, 2, 3, 0, 1, 4, 2, 1},		// 5
									{2, 6, 3, 3, 4, 1, 0, 5, 1, 2},		// 6
									{3, 1, 4, 2, 3, 4, 5, 0, 4, 3},		// 7
									{1, 5, 2, 2, 3, 2, 1, 4, 0, 1},		// 8
									{2, 4, 3, 1, 2, 1, 2, 3, 1, 0}		// 9
									};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 층수
		K = Integer.parseInt(st.nextToken()); // 디스플레이에 보이는 자릿 
		P = Integer.parseInt(st.nextToken()); // 최대 반전시킬 개수
		X = Integer.parseInt(st.nextToken()); // 실제로 멈춰있는 층 
		solve(0, 1, 0, 0);
		System.out.println(result-1);
	}

	private static void solve(int idx, int tmp, int su, int flipCnt) {
		if(flipCnt > P || su > N) return;
		if(idx == K) {
			if(su != 0) result++;
			return;
		}
		
		for(int i=0;i<=9;i++) {
			solve(idx+1, tmp*10, i*tmp + su, flipCnt + nums[X/tmp%10][i]);
		}
	}
}