import java.util.*;

public class Solution {
	static int N, K;
	static int[] V;//부피
	static int[] C;//가치
	static int[][] dp;
	static int max;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();//N개의 물건
			K = sc.nextInt();//최대 K부피 만큼 넣을 수 있음
			
			//N개의 물건만큼 받기 때문에 둘다 N+1개수만큼 받기
			V = new int[N+1];//부피
			C = new int[N+1];//가치
			
			max=Integer.MIN_VALUE;
			dp = new int[N+1][K+1];
			
			for(int i=1;i<N+1;i++) {
				V[i]=sc.nextInt();//부피
				C[i]=sc.nextInt();//가치
			}
			
			for(int i=1;i<N+1;i++) {//몇 번째 가방인지
				for(int j=0;j<K+1;j++) {//현개 구하는 무게
					if(V[i]>j) {//무게가 커서 경우의 수에 포함 안됨
						dp[i][j]=dp[i-1][j]; 
					}
					else {//무게 안 넘침, 어떤 게 더 클지?
						dp[i][j]=Math.max(dp[i-1][j-V[i]]+C[i], dp[i-1][j]); 
					}
				}
			}
			for(int i=1;i<=K;i++) {
				if(max<dp[N][i]) max=dp[N][i];
			}
			sb.append("#"+test_case+" "+max+"\n");
		}
		System.out.print(sb);
	}
}