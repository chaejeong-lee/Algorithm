import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] graph = new int[1001][1001];
	static boolean[] visited = new boolean[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			// 간선 연결
			graph[u][v] = graph[v][u] = 1;
		}
		
		int result = 0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				dfs(i);
				result++;
			}
		}
		
		System.out.println(result);
	}

	private static void dfs(int idx) {
		if(visited[idx]) return;
		
		visited[idx] = true;
		for(int i=1;i<=N;i++) {
			if(graph[idx][i] == 1) {
				dfs(i);
			}
		}
	}
}