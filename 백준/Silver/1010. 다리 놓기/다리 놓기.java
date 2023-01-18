import java.util.Scanner;

public class Main {

	static int[][] dp = new int[30][30];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for(int test_case = 0;test_case<T;test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			sb.append(combi(M, N)).append("\n");
		}
		System.out.println(sb);
	}

	public static int combi(int N, int R) {
		//이미 풀린 경우 바로 반환
		if(dp[N][R]>0) return dp[N][R];
		
		//2번 성질
		if(N==R || R == 0) return dp[N][R]= 1;
		
		//3번 성질
		return dp[N][R]= combi(N-1, R-1)+combi(N-1, R); 
	}
}