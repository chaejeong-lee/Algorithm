import java.io.*;
import java.util.*;

public class Main {
	
	private static int N;
	private static int[] parent;
	private static boolean[] visited;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			N = Integer.parseInt(br.readLine());
			
			parent = new int[N+1];
			visited = new boolean[N+1];
			
			for(int i=1;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				// A가 B의 부모
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				parent[B] = A;
			}
			
			// 가장 가까운 조상을 찾아야하는 노드
			st = new StringTokenizer(br.readLine()," ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			solution(node1, node2);
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void solution(int node1, int node2) {
		// node1을 루트 노드까지 이동시킴
		while(node1>0) {
			visited[node1] = true;
			node1 = parent[node1];
		}
		
		// node2를 루트 노드로 이동시키는 과정에서 처음 만난 노드가 최소 공통 조상
		while(node2>0) {
			if(visited[node2]) {
				answer = node2;
				break;
			}
			node2 = parent[node2];
		}
	}
}