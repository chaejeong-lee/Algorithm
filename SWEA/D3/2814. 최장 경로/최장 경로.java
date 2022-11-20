import java.util.*;

public class Solution {
	static int N, M;
	static int[][] map;
	static boolean[] visited;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N=sc.nextInt();//N개의 정점
			M=sc.nextInt();//M개의 간선
			
			answer=Integer.MIN_VALUE;
			
			map = new int[N+1][N+1];
			visited = new boolean[N+1];
			
			for(int i=0;i<M;i++) {
				int x = sc.nextInt();//그래프 간선 정보
				int y=sc.nextInt();
				map[x][y] = map[y][x]=1;
			}
			
			for(int i=1;i<N+1;i++) {
				dfs(1,  i);
				visited[i]=false;
			}
			
			sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.print(sb);
	}
	
	private static void dfs(int idx, int v) {
		visited[v]=true;
		
		for(int i=0;i<N+1;i++) {
			if(map[v][i]==1 && visited[i]==false) {
				dfs(idx+1, i);
				visited[i]=false;
			}
		}
		answer = Math.max(idx, answer)	;	
	}
}