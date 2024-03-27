import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int V, E;
	static ArrayList<Integer>[] arr;
	static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int K = Integer.parseInt(br.readLine());
		for(int t = 1;t<=K;t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점의 개수 (1<=V<=20_000)
			E = Integer.parseInt(st.nextToken()); // 간선의 개수 (1<=E<=200_000)
			arr = new ArrayList[V+1];
			visit = new int[V+1];
			
			// 그래프 초기화
			for(int i=0;i<=V;i++) {
				arr[i] = new ArrayList<Integer>();
			}
			
			// 그래프 연결
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				arr[start].add(end);
				arr[end].add(start);
			}
			
			bfs();
		}
		System.out.print(sb);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1;i<=V;i++) {
			if(visit[i] == 0) {
				q.add(i);
				visit[i] = 1;
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(int j=0;j<arr[cur].size();j++) {
					if(visit[arr[cur].get(j)] == 0) {
						q.add(arr[cur].get(j));
					}
					
					if(visit[arr[cur].get(j)] == visit[cur]) {
						sb.append("NO\n");
						return;
					}
					
					if(visit[cur] == 1 && visit[arr[cur].get(j)] == 0) {
						visit[arr[cur].get(j)] = 2;
					}
					else if(visit[cur] == 2 && visit[arr[cur].get(j)] == 0) {
						visit[arr[cur].get(j)] = 1;
					}
				}
			}
		}
		sb.append("YES\n");
	}
}