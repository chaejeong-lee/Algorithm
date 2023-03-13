import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		dp = new int[N+1][2];
		
		for(int i=0;i<list.length;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	private static void dfs(int index) {
		visited[index] = true;
		dp[index][0] = 0;
		dp[index][1] = 1;
		
		for(int node:list[index]) {
			if(!visited[node]) {
				dfs(node);
				dp[index][0] += dp[node][1];
				dp[index][1] += Math.min(dp[node][0], dp[node][1]);
			}
		}
	}
}
