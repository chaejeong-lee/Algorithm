import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] townPeople;
	static ArrayList<ArrayList<Integer>> graph;
	static int[][] dp;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		townPeople = new int[N+1];
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		dp = new int[N+1][2];
		
		st = new StringTokenizer(br.readLine());
		graph.add(new ArrayList<>());
		for(int i=1;i<=N;i++) {
			townPeople[i] = Integer.parseInt(st.nextToken());
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}
		
		dfs(1);
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	
	public static void dfs(int idx) {
		visited[idx] = true;
		dp[idx][1] = townPeople[idx];
		
		for(Integer people: graph.get(idx)) {
			if(!visited[people]) {
				dfs(people);
				dp[idx][0] += Math.max(dp[people][0], dp[people][1]);
				dp[idx][1] += dp[people][0];
			}
		}
	}
}
